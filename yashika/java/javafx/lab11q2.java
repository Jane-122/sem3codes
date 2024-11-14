import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class lab12q2 extends Application {
    public void start(Stage primaryStage) {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        TextField nameField = new TextField("Name");
        TextField emailField = new TextField("Email");
        TextField phoneField = new TextField("Phone");

        CheckBox[] languages = {
            new CheckBox("English"),
            new CheckBox("Spanish"),
            new CheckBox("French"),
            new CheckBox("German")
        };

        Button submitButton = new Button("Submit");
        Canvas canvas = new Canvas(400, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        submitButton.setOnAction(e -> {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.fillText("Resume", 150, 20);
            gc.fillText("Name: " + nameField.getText(), 10, 50);
            gc.fillText("Email: " + emailField.getText(), 10, 70);
            gc.fillText("Phone: " + phoneField.getText(), 10, 90);
            gc.fillText("Languages:", 10, 110);
            for (int i = 0; i < languages.length; i++) {
                if (languages[i].isSelected()) gc.fillText("- " + languages[i].getText(), 10, 130 + i * 20);
            }
        });

        vbox.getChildren().addAll(nameField, emailField, phoneField, languages[0], languages[1], languages[2], languages[3], submitButton, canvas);
        primaryStage.setScene(new Scene(vbox, 400, 350));
        primaryStage.setTitle("Resume Creator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
