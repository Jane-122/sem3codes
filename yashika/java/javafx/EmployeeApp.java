import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// Employee class
class Employee {
    private String name;
    private String empID;
    private String designation;
    private double basicPay;
    private double DA;
    private double HRA;
    private double PF;
    private double LIC;
    private double netSalary;

    public Employee(String name, String empID, String designation, double basicPay) {
        this.name = name;
        this.empID = empID;
        this.designation = designation;
        this.basicPay = basicPay;
        calculateSalaryComponents();
    }

    private void calculateSalaryComponents() {
        DA = 0.4 * basicPay;
        HRA = 0.15 * basicPay;
        PF = 0.12 * basicPay;
        LIC = 0; // Assuming LIC is 0 for simplicity
        netSalary = basicPay + DA + HRA - PF - LIC;
    }

    // Getters
    public String getName() { return name; }
    public String getEmpID() { return empID; }
    public String getDesignation() { return designation; }
    public double getBasicPay() { return basicPay; }
    public double getDA() { return DA; }
    public double getHRA() { return HRA; }
    public double getPF() { return PF; }
    public double getLIC() { return LIC; }
    public double getNetSalary() { return netSalary; }
}

// JavaFX application class
public class EmployeeApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create UI controls
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label empIDLabel = new Label("Employee ID:");
        TextField empIDField = new TextField();

        Label designationLabel = new Label("Designation:");
        TextField designationField = new TextField();

        Label basicPayLabel = new Label("Basic Pay:");
        TextField basicPayField = new TextField();

        Button submitButton = new Button("Submit");
        Label outputLabel = new Label();

        // Set up the layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.addRow(0, nameLabel, nameField);
        grid.addRow(1, empIDLabel, empIDField);
        grid.addRow(2, designationLabel, designationField);
        grid.addRow(3, basicPayLabel, basicPayField);
        grid.addRow(4, submitButton);
        grid.addRow(5, outputLabel);

        // Handle button click
        submitButton.setOnAction(event -> {
            String name = nameField.getText();
            String empID = empIDField.getText();
            String designation = designationField.getText();
            double basicPay;

            try {
                basicPay = Double.parseDouble(basicPayField.getText());
                Employee employee = new Employee(name, empID, designation, basicPay);
                
                outputLabel.setText("Employee Info:\n" +
                    "Name: " + employee.getName() + "\n" +
                    "ID: " + employee.getEmpID() + "\n" +
                    "Designation: " + employee.getDesignation() + "\n" +
                    "Basic Pay: " + employee.getBasicPay() + "\n" +
                    "DA: " + employee.getDA() + "\n" +
                    "HRA: " + employee.getHRA() + "\n" +
                    "PF: " + employee.getPF() + "\n" +
                    "LIC: " + employee.getLIC() + "\n" +
                    "Net Salary: " + employee.getNetSalary());
            } catch (NumberFormatException e) {
                outputLabel.setText("Please enter a valid number for Basic Pay.");
            }
        });

        // Create a scene and set it on the stage
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Employee Information");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
