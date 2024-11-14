import javafx.application.Application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ScrollingMessageApp extends Application {

    private Thread scrollingThread;
    private boolean running = false;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Create the message label
        Label messageLabel = new Label("Welcome to the Scrolling Message Application!");
        messageLabel.setStyle("-fx-font-size: 20;");

        // Create radio buttons for direction
        RadioButton leftToRightButton = new RadioButton("Scroll Left to Right");
        RadioButton rightToLeftButton = new RadioButton("Scroll Right to Left");

        ToggleGroup directionGroup = new ToggleGroup();
        leftToRightButton.setToggleGroup(directionGroup);
        rightToLeftButton.setToggleGroup(directionGroup);
        leftToRightButton.setSelected(true); // Default selection

        HBox radioBox = new HBox(10, leftToRightButton, rightToLeftButton);
        root.setTop(radioBox);
        root.setCenter(messageLabel);

        // Create a button to start/stop the scrolling
        Button toggleButton = new Button("Start Scrolling");
        toggleButton.setOnAction(e -> toggleScrolling(messageLabel, leftToRightButton.isSelected()));
        root.setBottom(toggleButton);

        // Set up the scene
        Scene scene = new Scene(root, 600, 100);
        primaryStage.setTitle("Scrolling Message Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void toggleScrolling(Label messageLabel, boolean leftToRight) {
        if (running) {
            running = false; // Stop the thread
            scrollingThread.interrupt();
            scrollingThread = null;
            return;
        }

        running = true;
        scrollingThread = new Thread(() -> {
            double startX = leftToRight ? -600 : 600; // Start position based on direction
            messageLabel.setLayoutX(startX); // Set initial position

            while (running) {
                // Scroll the label
                messageLabel.setLayoutX(messageLabel.getLayoutX() + (leftToRight ? 2 : -2));

                // Reset position if it goes out of bounds
                if (messageLabel.getLayoutX() > 600) {
                    messageLabel.setLayoutX(-messageLabel.getWidth());
                } else if (messageLabel.getLayoutX() < -messageLabel.getWidth()) {
                    messageLabel.setLayoutX(600);
                }

                try {
                    Thread.sleep(30); // Adjust the speed of scrolling
                } catch (InterruptedException e) {
                    running = false; // Stop the thread if interrupted
                }
            }
        });
        scrollingThread.setDaemon(true); // Allow the application to exit even if thread is running
        scrollingThread.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
