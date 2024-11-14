import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.*;

public class LabelImageDemo extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	public void start(Stage myStage)
	{
		myStage.setTitle("Use an image in a label");
		FlowPane rootNode=new FlowPane();
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene=new Scene(rootNode,300,200);
		myStage.setScene(myScene);
		Image hourglassImage = new Image(getClass().getResourceAsStream("hourglass.png"));
        ImageView hourglassIV = new ImageView(hourglassImage);
		Label hourglassLabel=new Label("Hourglass",hourglassIV);
		rootNode.getChildren().add(hourglassLabel);
		myStage.show();
	}
}