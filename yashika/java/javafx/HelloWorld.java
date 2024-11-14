
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
public class HelloWorld extends Application {
public void start(Stage primaryStage) { // entry point for the application
primaryStage.setTitle("Demo JavaFX Aplication"); // set the title of top level
//container.
Label lbl = new Label(); // create a label control
lbl.setText("Hello World from JavaFX");
lbl.setTextFill(Color.RED);
FlowPane root = new FlowPane(); // create a root node.
root.getChildren().add(lbl); // add the label to the node
Scene myScene = new Scene(root, 300, 50); // create a scene using the node
primaryStage.setScene(myScene); // set the scene on the stage
primaryStage.show(); // show the stage
}

public static void main(String[] args) {
launch(args); // Start the JavaFX application by calling launch( ).
}
}
