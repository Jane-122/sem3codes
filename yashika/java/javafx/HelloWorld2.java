import javafx.scene.control.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class HelloWorld2 extends Application
{
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Demo JavaFX Application");
		Label lbl=new Label();
		lbl.setText("Hello World from JavaFX");
		lbl.setTextFill(Color.RED);

		FlowPane root=new FlowPane();
		root.getChildren().add(lbl);
		Scene myScene=new Scene(root,300,50);
		primaryStage.setScene(myScene);
		primaryStage.show();
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}