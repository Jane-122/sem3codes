import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication2 extends Application {

    // Doctor and Staff Management Fields
    private TextField idField, nameField, positionField;
    private ComboBox<String> shiftBox;
    private CheckBox availabilityCheckBox;
    private Button addStaffButton, displayStaffButton;
    private TextArea staffDisplay;
    private List<Staff> staffList;

    // Patient Registration Fields
    private ObservableList<Patient> patients = FXCollections.observableArrayList();
    private TextField nameFieldPatient, aadharField, fatherNameField, motherNameField, phoneField, emailField, ageField;
    private TextArea addressArea;
    private ComboBox<String> genderComboBox;
    private Button registerPatientButton, displayPatientsButton;
    private TextArea patientDisplayArea;

    // Appointment Scheduler Fields
    private ObservableList<Doctor> doctors = FXCollections.observableArrayList();
    private TextField doctorNameField, specializationField;
    private DatePicker appointmentDatePicker;
    private ComboBox<String> appointmentTimeComboBox;
    private ComboBox<Doctor> doctorComboBox;
    private ComboBox<Patient> patientComboBox;
    private ListView<String> appointmentListView;
    private ObservableList<String> appointmentList = FXCollections.observableArrayList();
    private Button scheduleAppointmentButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Health Care Management");

        // Initialize staff management UI
        staffList = new ArrayList<>();
        AnchorPane staffRoot = createStaffManagementUI();

        // Initialize patient registration UI
        VBox patientRegistrationRoot = createPatientRegistrationUI();

        // Initialize appointment scheduler UI
        VBox appointmentSchedulerRoot = createAppointmentSchedulerUI();

        // Combine both UI layouts into tabs
        TabPane tabPane = new TabPane();
        Tab staffTab = new Tab("Staff Management", staffRoot);
        staffTab.setClosable(false);
        Tab patientTab = new Tab("Patient Registration", patientRegistrationRoot);
        patientTab.setClosable(false);
        Tab appointmentTab = new Tab("Appointment Scheduler", appointmentSchedulerRoot);
        appointmentTab.setClosable(false);
        tabPane.getTabs().addAll(staffTab, patientTab, appointmentTab);

        // Main Layout
        Scene scene = new Scene(tabPane, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private AnchorPane createStaffManagementUI() {
        AnchorPane root = new AnchorPane();

        idField = new TextField();
        idField.setPromptText("Staff ID");
        idField.setLayoutX(50);
        idField.setLayoutY(50);

        nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.setLayoutX(50);
        nameField.setLayoutY(90);

        positionField = new TextField();
        positionField.setPromptText("Position (e.g., Doctor, Nurse)");
        positionField.setLayoutX(50);
        positionField.setLayoutY(130);

        shiftBox = new ComboBox<>();
        shiftBox.getItems().addAll("Morning", "Afternoon", "Night");
        shiftBox.setPromptText("Select Shift");
        shiftBox.setLayoutX(50);
        shiftBox.setLayoutY(170);

        availabilityCheckBox = new CheckBox("Available");
        availabilityCheckBox.setLayoutX(50);
        availabilityCheckBox.setLayoutY(210);

        addStaffButton = new Button("Add Staff");
        addStaffButton.setLayoutX(50);
        addStaffButton.setLayoutY(250);
        addStaffButton.setOnAction(event -> addStaff());

        displayStaffButton = new Button("Display Staff");
        displayStaffButton.setLayoutX(150);
        displayStaffButton.setLayoutY(250);
        displayStaffButton.setOnAction(event -> displayStaff());

        staffDisplay = new TextArea();
        staffDisplay.setEditable(false);
        staffDisplay.setLayoutX(250);
        staffDisplay.setLayoutY(50);
        staffDisplay.setPrefSize(300, 300);

        root.getChildren().addAll(idField, nameField, positionField, shiftBox, availabilityCheckBox, addStaffButton, displayStaffButton, staffDisplay);
        return root;
    }

    private VBox createPatientRegistrationUI() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        layout.getChildren().add(new Label("Patient Registration"));

        GridPane patientGridPane = new GridPane();
        patientGridPane.setPadding(new Insets(10));
        patientGridPane.setVgap(10);
        patientGridPane.setHgap(10);

        // Adding Patient Registration Fields
        nameFieldPatient = new TextField();
        aadharField = new TextField();
        fatherNameField = new TextField();
        motherNameField = new TextField();
        phoneField = new TextField();
        emailField = new TextField();
        addressArea = new TextArea();
        ageField = new TextField();
        genderComboBox = new ComboBox<>();
        genderComboBox.getItems().addAll("Male", "Female", "Other");

        patientGridPane.add(new Label("Full Name:"), 0, 0);
        patientGridPane.add(nameFieldPatient, 1, 0);
        patientGridPane.add(new Label("Aadhar No:"), 0, 1);
        patientGridPane.add(aadharField, 1, 1);
        patientGridPane.add(new Label("Father's Name:"), 0, 2);
        patientGridPane.add(fatherNameField, 1, 2);
        patientGridPane.add(new Label("Mother's Name:"), 0, 3);
        patientGridPane.add(motherNameField, 1, 3);
        patientGridPane.add(new Label("Phone No:"), 0, 4);
        patientGridPane.add(phoneField, 1, 4);
        patientGridPane.add(new Label("Email:"), 0, 5);
        patientGridPane.add(emailField, 1, 5);
        patientGridPane.add(new Label("Address:"), 0, 6);
        patientGridPane.add(addressArea, 1, 6);
        patientGridPane.add(new Label("Age:"), 0, 7);
        patientGridPane.add(ageField, 1, 7);
        patientGridPane.add(new Label("Gender:"), 0, 8);
        patientGridPane.add(genderComboBox, 1, 8);

        registerPatientButton = new Button("Register Patient");
        registerPatientButton.setOnAction(e -> registerPatient());
        patientGridPane.add(registerPatientButton, 1, 9);

        displayPatientsButton = new Button("Display Patients");
        displayPatientsButton.setOnAction(e -> displayPatients());
        patientGridPane.add(displayPatientsButton, 1, 10);

        // Initialize the patient display area
        patientDisplayArea = new TextArea();
        patientDisplayArea.setEditable(false);
        patientDisplayArea.setPrefSize(400, 200);
        patientDisplayArea.setWrapText(true);

        layout.getChildren().add(patientGridPane);
        layout.getChildren().add(new Label("Registered Patients:"));
        layout.getChildren().add(patientDisplayArea);

        return layout;
    }

    private VBox createAppointmentSchedulerUI() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        // Initialize components for adding a doctor
        doctorNameField = new TextField();
        doctorNameField.setPromptText("Doctor's Name");

        specializationField = new TextField();
        specializationField.setPromptText("Specialization");

        Button addDoctorButton = new Button("Add Doctor");
        addDoctorButton.setOnAction(e -> addDoctor());

        // Initialize components for scheduling an appointment
        appointmentDatePicker = new DatePicker();
        appointmentTimeComboBox = new ComboBox<>();
        for (int i = 8; i <= 17; i++) {
            appointmentTimeComboBox.getItems().add(String.format("%02d:00", i));
        }
        doctorComboBox = new ComboBox<>(doctors);
        patientComboBox = new ComboBox<>(patients);
        appointmentListView = new ListView<>(appointmentList);
        scheduleAppointmentButton = new Button("Schedule Appointment");
        scheduleAppointmentButton.setOnAction(e -> scheduleAppointment());

        // Add UI components to layout
        layout.getChildren().add(new Label("Add Doctor:"));
        layout.getChildren().addAll(doctorNameField, specializationField, addDoctorButton);

        layout.getChildren().add(new Label("Select Patient:"));
        layout.getChildren().add(patientComboBox);

        layout.getChildren().add(new Label("Select Doctor:"));
        layout.getChildren().add(doctorComboBox);

        // Add remaining UI components
        layout.getChildren().addAll(
                new Label("Select Appointment Date:"), appointmentDatePicker,
                new Label("Select Appointment Time:"), appointmentTimeComboBox,
                scheduleAppointmentButton, new Label("Scheduled Appointments:"), appointmentListView
        );

        return layout;
    }

    private void addStaff() {
        String id = idField.getText();
        String name = nameField.getText();
        String position = positionField.getText();
        String shift = shiftBox.getValue();
        boolean available = availabilityCheckBox.isSelected();

        if (id.isEmpty() || name.isEmpty() || position.isEmpty() || shift == null) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please fill all required fields.");
            return;
        }

        staffList.add(new Staff(id, name, position, shift, available));
        clearStaffFields();
        showAlert(Alert.AlertType.INFORMATION, "Success", "Staff added successfully.");
    }

    private void displayStaff() {
        StringBuilder displayText = new StringBuilder();
        for (Staff staff : staffList) {
            displayText.append(staff).append("\n");
        }
        staffDisplay.setText(displayText.toString());
    }

    private void registerPatient() {
        String name = nameFieldPatient.getText().trim();
        String aadhar = aadharField.getText().trim();
        String fatherName = fatherNameField.getText().trim();
        String motherName = motherNameField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();
        String address = addressArea.getText().trim();
        String ageStr = ageField.getText().trim();
        String gender = genderComboBox.getValue();

        // Check for duplicates based on Aadhar number
        for (Patient p : patients) {
            if (p.aadhar.equals(aadhar)) {
                showAlert(Alert.AlertType.WARNING, "Input Error", "A patient with this Aadhar number already exists.");
                return;
            }
        }

        if (name.isEmpty() || aadhar.isEmpty() || fatherName.isEmpty() || motherName.isEmpty() ||
                phone.isEmpty() || email.isEmpty() || address.isEmpty() || ageStr.isEmpty() || gender == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please fill all required fields.");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter a valid age (integer).");
            return;
        }

        Patient patient = new Patient(name, aadhar, fatherName, motherName, phone, email, address, age, gender);
        patients.add(patient);
        patientComboBox.getItems().add(patient); // Add to combo box for selection
        clearPatientFields();
        showAlert(Alert.AlertType.INFORMATION, "Success", "Patient Registered: " + name);
    }

    private void displayPatients() {
        StringBuilder displayText = new StringBuilder();
        for (Patient patient : patients) {
            displayText.append(patient).append("\n");
        }
        patientDisplayArea.setText(displayText.toString());
    }

    private void addDoctor() {
        String doctorName = doctorNameField.getText().trim();
        String specialization = specializationField.getText().trim();

        if (!doctorName.isEmpty() && !specialization.isEmpty()) {
            // Check for duplicates
            for (Doctor doctor : doctors) {
                if (doctor.getName().equalsIgnoreCase(doctorName) &&
                    doctor.specialization.equalsIgnoreCase(specialization)) {
                    showAlert(Alert.AlertType.WARNING, "Input Error", "This doctor is already added.");
                    return;
                }
            }

            Doctor doctor = new Doctor(doctorName, specialization);
            doctors.add(doctor);
            doctorComboBox.getItems().add(doctor); // Add to combo box for selection
            clearDoctorFields();
            showAlert(Alert.AlertType.INFORMATION, "Doctor Added", "Added Doctor: " + doctorName + " (" + specialization + ")");
        } else {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please enter both the doctor's name and specialization.");
        }
    }

    private void scheduleAppointment() {
        String date = appointmentDatePicker.getValue() != null ? appointmentDatePicker.getValue().toString() : "";
        String time = appointmentTimeComboBox.getValue();
        Doctor doctor = doctorComboBox.getValue();
        Patient patient = patientComboBox.getValue();

        if (date.isEmpty() || time == null || doctor == null || patient == null) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please select all fields.");
            return;
        }

        String appointmentDetails = String.format("Appointment: %s with Dr. %s at %s on %s",
                patient.name, doctor.getName(), time, date);
        appointmentList.add(appointmentDetails);
        appointmentListView.setItems(appointmentList);
        showAlert(Alert.AlertType.INFORMATION, "Appointment Scheduled", appointmentDetails);
    }

    private void clearPatientFields() {
        nameFieldPatient.clear();
        aadharField.clear();
        fatherNameField.clear();
        motherNameField.clear();
        phoneField.clear();
        emailField.clear();
        addressArea.clear();
        ageField.clear();
        genderComboBox.setValue(null);
    }

    private void clearDoctorFields() {
        doctorNameField.clear();
        specializationField.clear();
    }

    private void clearStaffFields() {
        idField.clear();
        nameField.clear();
        positionField.clear();
        shiftBox.setValue(null);
        availabilityCheckBox.setSelected(false);
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Define Patient and Doctor classes
    class Patient {
        String name, aadhar, fatherName, motherName, phone, email, address, gender;
        int age;

        Patient(String name, String aadhar, String fatherName, String motherName,
                 String phone, String email, String address, int age, String gender) {
            this.name = name;
            this.aadhar = aadhar;
            this.fatherName = fatherName;
            this.motherName = motherName;
            this.phone = phone;
            this.email = email;
            this.address = address;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return String.format("Name: %s, Aadhar: %s, Age: %d, Gender: %s", name, aadhar, age, gender);
        }
    }

    class Doctor {
        String name, specialization;

        Doctor(String name, String specialization) {
            this.name = name;
            this.specialization = specialization;
        }

        String getName() {
            return name;
        }

        @Override
        public String toString() {
            return String.format("%s (%s)", name, specialization);
        }
    }

    class Staff {
        String id, name, position, shift;
        boolean available;

        Staff(String id, String name, String position, String shift, boolean available) {
            this.id = id;
            this.name = name;
            this.position = position;
            this.shift = shift;
            this.available = available;
        }

        @Override
        public String toString() {
            return String.format("%s (%s): %s, Shift: %s, Available: %s", name, id, position, shift, available);
        }
    }
}
