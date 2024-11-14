import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SignInApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane layout
        GridPane grid = new GridPane();
        grid.setHgap(10); // Horizontal gap between columns
        grid.setVgap(10); // Vertical gap between rows

        // Create UI controls
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        
        Button signInButton = new Button("Sign in");
        Label messageLabel = new Label(); // For displaying the welcome message

        // Set up the layout
        grid.addRow(0, usernameLabel, usernameField);
        grid.addRow(1, passwordLabel, passwordField);
        grid.addRow(2, signInButton);
        grid.addRow(3, messageLabel); // Display the welcome message

        // Handle button click
        signInButton.setOnAction(event -> {
            String username = usernameField.getText();
            messageLabel.setText("Welcome " + username); // Update Label text
        });

        // Create a scene and set it on the stage
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setTitle("Sign In Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

