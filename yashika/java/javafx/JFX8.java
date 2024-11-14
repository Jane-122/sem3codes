import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class JFX8 extends Application {

    private ObservableList<String> patientList = FXCollections.observableArrayList();
    private int patientCounter = 0; // Counter for the number of patients

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PATIENT REGISTRATION");

        // Create UI Components for Personal Details
        Label nameLabel = new Label("Full Name:");
        TextField nameField = new TextField();

        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();

        Label genderLabel = new Label("Gender:");
        ComboBox<String> genderComboBox = new ComboBox<>();
        genderComboBox.getItems().addAll("Male", "Female", "Other");

        // Create UI Components for Medical Details
        Label medicalHistoryLabel = new Label("Medical History:");
        TextArea medicalHistoryArea = new TextArea();

        CheckBox allergiesCheckBox = new CheckBox("Allergies");
        TextField allergiesField = new TextField();

        Label emergencyContactLabel = new Label("Emergency Contact:");
        TextField emergencyContactField = new TextField();
        emergencyContactField.setPrefWidth(200); // Set preferred width for visibility

        Button registerButton = new Button("Register Patient");
        ListView<String> patientListView = new ListView<>(patientList);

        // Layout setup
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Set column constraints for better layout
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(30); // First column (labels)
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(70); // Second column (input fields)
        gridPane.getColumnConstraints().addAll(column1, column2);

        // Add Personal Details to the layout
        gridPane.add(new Label("PERSONAL DETAILS"), 0, 0, 2, 1);
        gridPane.add(nameLabel, 0, 1);
        gridPane.add(nameField, 1, 1);
        gridPane.add(ageLabel, 0, 2);
        gridPane.add(ageField, 1, 2);
        gridPane.add(genderLabel, 0, 3);
        gridPane.add(genderComboBox, 1, 3);

        // Add Medical Details to the layout
        gridPane.add(new Label("MEDICAL DETAILS"), 0, 4, 2, 1);
        gridPane.add(medicalHistoryLabel, 0, 5);
        gridPane.add(medicalHistoryArea, 1, 5);
        gridPane.add(allergiesCheckBox, 0, 6);
        gridPane.add(allergiesField, 1, 6);
        gridPane.add(emergencyContactLabel, 0, 7);
        gridPane.add(emergencyContactField, 1, 7);
        gridPane.add(registerButton, 1, 8);
        gridPane.add(patientListView, 0, 9, 2, 1);

        // Button Event Handling
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String name = nameField.getText().trim();
                String ageStr = ageField.getText().trim();
                String gender = genderComboBox.getValue();
                String medicalHistory = medicalHistoryArea.getText().trim();
                String allergies = allergiesCheckBox.isSelected() ? allergiesField.getText().trim() : "None";
                String emergencyContact = emergencyContactField.getText().trim();

                // Check for valid input
                if (name.isEmpty() || ageStr.isEmpty() || gender == null) {
                    showAlert("Error", "Please fill all required fields.");
                    return;
                }

                int age;
                try {
                    age = Integer.parseInt(ageStr);
                } catch (NumberFormatException ex) {
                    showAlert("Error", "Please enter a valid age (integer).");
                    return;
                }

                // Use "None" if medical history is empty
                if (medicalHistory.isEmpty()) {
                    medicalHistory = "None";
                }

                patientCounter++; // Increment patient counter
                String patientInfo = String.format("""
                        Patient Number: %d
                        Name: %s
                        Age: %d
                        Gender: %s
                        Medical History: %s
                        Allergies: %s
                        Emergency Contact: %s
                        """,
                        patientCounter, name, age, gender, medicalHistory, allergies, emergencyContact);
                patientList.add(patientInfo);

                // Clear fields after registration
                nameField.clear();
                ageField.clear();
                genderComboBox.setValue(null);
                medicalHistoryArea.clear();
                allergiesCheckBox.setSelected(false);
                allergiesField.clear();
                emergencyContactField.clear();
            }
        });

        VBox vBox = new VBox(gridPane);
        Scene scene = new Scene(vBox, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
