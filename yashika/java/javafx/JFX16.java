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
import javafx.scene.paint.Color;

public class JFX16 extends Application {

    private ObservableList<String> patientList = FXCollections.observableArrayList();
    private int patientCounter = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PATIENT REGISTRATION");

        Label titleLabel = new Label("PATIENT REGISTRATION");
        titleLabel.setTextFill(Color.DODGERBLUE);

        Label nameLabel = new Label("Full Name:");
        nameLabel.setTextFill(Color.DARKGREEN);
        TextField nameField = new TextField();

        Label aadharLabel = new Label("Aadhar No:");
        aadharLabel.setTextFill(Color.DARKGREEN);
        TextField aadharField = new TextField();

        Label fatherNameLabel = new Label("Father's Name:");
        fatherNameLabel.setTextFill(Color.DARKGREEN);
        TextField fatherNameField = new TextField();

        Label motherNameLabel = new Label("Mother's Name:");
        motherNameLabel.setTextFill(Color.DARKGREEN);
        TextField motherNameField = new TextField();

        Label phoneLabel = new Label("Phone No:");
        phoneLabel.setTextFill(Color.DARKGREEN);
        TextField phoneField = new TextField();

        Label emailLabel = new Label("Email:");
        emailLabel.setTextFill(Color.DARKGREEN);
        TextField emailField = new TextField();

        Label addressLabel = new Label("Address:");
        addressLabel.setTextFill(Color.DARKGREEN);
        TextArea addressArea = new TextArea();
        addressArea.setPrefHeight(50);

        Label ageLabel = new Label("Age:");
        ageLabel.setTextFill(Color.DARKGREEN);
        TextField ageField = new TextField();

        Label genderLabel = new Label("Gender:");
        genderLabel.setTextFill(Color.DARKGREEN);
        ComboBox<String> genderComboBox = new ComboBox<>();
        genderComboBox.getItems().addAll("Male", "Female", "Other");

        Label medicalDetailsLabel = new Label("MEDICAL DETAILS");
        medicalDetailsLabel.setTextFill(Color.DODGERBLUE);

        Label medicalHistoryLabel = new Label("Medical History:");
        medicalHistoryLabel.setTextFill(Color.DARKGREEN);
        TextArea medicalHistoryArea = new TextArea();
        medicalHistoryArea.setPrefHeight(50);

        Label vaccinationsLabel = new Label("Vaccinations:");
        vaccinationsLabel.setTextFill(Color.DARKGREEN);
        TextArea vaccinationsArea = new TextArea();
        vaccinationsArea.setPrefHeight(50);

        Label ongoingTreatmentsLabel = new Label("Ongoing Treatments:");
        ongoingTreatmentsLabel.setTextFill(Color.DARKGREEN);
        TextArea ongoingTreatmentsArea = new TextArea();
        ongoingTreatmentsArea.setPrefHeight(50);

        CheckBox allergiesCheckBox = new CheckBox("Allergies");
        Label allergiesLabel = new Label("Allergies Details:");
        allergiesLabel.setTextFill(Color.DARKGREEN);
        TextField allergiesField = new TextField();


        Label emergencyContactLabel = new Label("Emergency Contact:");
        emergencyContactLabel.setTextFill(Color.DARKGREEN);
        TextField emergencyContactField = new TextField();
        emergencyContactField.setPrefWidth(200);

        Button registerButton = new Button("Register Patient");
        Button viewButton = new Button("View Patient Details");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(30);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(70);
        gridPane.getColumnConstraints().addAll(column1, column2);

        gridPane.add(titleLabel, 0, 0, 2, 1);
        gridPane.add(new Label("PERSONAL DETAILS"), 0, 1, 2, 1);
        gridPane.add(nameLabel, 0, 2);
        gridPane.add(nameField, 1, 2);
        gridPane.add(aadharLabel, 0, 3);
        gridPane.add(aadharField, 1, 3);
        gridPane.add(fatherNameLabel, 0, 4);
        gridPane.add(fatherNameField, 1, 4);
        gridPane.add(motherNameLabel, 0, 5);
        gridPane.add(motherNameField, 1, 5);
        gridPane.add(phoneLabel, 0, 6);
        gridPane.add(phoneField, 1, 6);
        gridPane.add(emailLabel, 0, 7);
        gridPane.add(emailField, 1, 7);
        gridPane.add(addressLabel, 0, 8);
        gridPane.add(addressArea, 1, 8);
        gridPane.add(ageLabel, 0, 9);
        gridPane.add(ageField, 1, 9);
        gridPane.add(genderLabel, 0, 10);
        gridPane.add(genderComboBox, 1, 10);

        gridPane.add(medicalDetailsLabel, 0, 11, 2, 1);
gridPane.add(medicalHistoryLabel, 0, 12);
gridPane.add(medicalHistoryArea, 1, 12);
gridPane.add(vaccinationsLabel, 0, 13);
gridPane.add(vaccinationsArea, 1, 13);
gridPane.add(ongoingTreatmentsLabel, 0, 14);
gridPane.add(ongoingTreatmentsArea, 1, 14);
gridPane.add(allergiesLabel, 0, 15); // Added label for allergies
gridPane.add(allergiesCheckBox, 0, 16);
gridPane.add(allergiesField, 1, 16);
gridPane.add(emergencyContactLabel, 0, 17);
gridPane.add(emergencyContactField, 1, 17);


        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(true);

        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String name = nameField.getText().trim();
                String aadhar = aadharField.getText().trim();
                String fatherName = fatherNameField.getText().trim();
                String motherName = motherNameField.getText().trim();
                String phone = phoneField.getText().trim();
                String email = emailField.getText().trim();
                String address = addressArea.getText().trim();
                String ageStr = ageField.getText().trim();
                String gender = genderComboBox.getValue();
                String medicalHistory = medicalHistoryArea.getText().trim();
                String vaccinations = vaccinationsArea.getText().trim();
                String ongoingTreatments = ongoingTreatmentsArea.getText().trim();
                String allergies = allergiesCheckBox.isSelected() ? allergiesField.getText().trim() : "None";
                String emergencyContact = emergencyContactField.getText().trim();

                if (name.isEmpty() || aadhar.isEmpty() || fatherName.isEmpty() || motherName.isEmpty() || 
                    phone.isEmpty() || email.isEmpty() || address.isEmpty() || ageStr.isEmpty() || gender == null) {
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

                if (medicalHistory.isEmpty()) {
                    medicalHistory = "None";
                }
                if (vaccinations.isEmpty()) {
                    vaccinations = "None";
                }
                if (ongoingTreatments.isEmpty()) {
                    ongoingTreatments = "None";
                }

                patientCounter++;
                String patientInfo = String.format("""
                        Patient Number: %d
                        Name: %s
                        Aadhar No: %s
                        Father's Name: %s
                        Mother's Name: %s
                        Phone No: %s
                        Email: %s
                        Address: %s
                        Age: %d
                        Gender: %s
                        Medical History: %s
                        Vaccinations: %s
                        Ongoing Treatments: %s
                        Allergies: %s
                        Emergency Contact: %s
                        """,
                        patientCounter, name, aadhar, fatherName, motherName, phone, email, address, age, gender, medicalHistory, vaccinations, ongoingTreatments, allergies, emergencyContact);

                patientList.add(patientInfo);
                clearTextFields(nameField, aadharField, fatherNameField, motherNameField, phoneField, emailField, ageField, allergiesField, emergencyContactField);
                clearTextArea(addressArea);
                clearTextArea(medicalHistoryArea);
                clearTextArea(vaccinationsArea);
                clearTextArea(ongoingTreatmentsArea);
                genderComboBox.setValue(null);
                allergiesCheckBox.setSelected(false);
            }
        });

        viewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                showPatientDetails();
            }
        });

        VBox vBox = new VBox(scrollPane);
        Scene scene = new Scene(vBox, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showPatientDetails() {
        Stage detailsStage = new Stage();
        detailsStage.setTitle("PATIENT DETAILS");

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.CENTER);

        TextField searchField = new TextField();
        searchField.setPromptText("Enter Patient Name");

        TextArea detailsArea = new TextArea();
        detailsArea.setEditable(false);
        detailsArea.setWrapText(true);
        detailsArea.setPrefSize(800, 500);

        updatePatientDetails(detailsArea, null);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            updatePatientDetails(detailsArea, newValue.trim());
        });

        vBox.getChildren().addAll(searchField, detailsArea);
        Scene scene = new Scene(vBox, 800, 600);
        detailsStage.setScene(scene);
        detailsStage.show();
    }

    private void updatePatientDetails(TextArea detailsArea, String searchTerm) {
        StringBuilder patientInfo = new StringBuilder();
        for (String patient : patientList) {
            if (searchTerm == null || patient.toLowerCase().contains(searchTerm.toLowerCase())) {
                patientInfo.append(patient).append("\n");
            }
        }
        detailsArea.setText(patientInfo.toString());
    }

    private void clearTextFields(TextField... fields) {
        for (TextField field : fields) {
            field.clear();
        }
    }

    private void clearTextArea(TextArea area) {
        area.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
