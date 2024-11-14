import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class ToggleButtonDemo extends Application
{
	ToggleButton tbOnOff;
	Label response;

	public static void main(String[] args)
	{
		launch(args);
	}

	public void start(Stage myStage)
	{
		myStage.setTitle("Demonstrate a Toggle Button");
		FlowPane rootNode=new FlowPane(10,10);
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene=new Scene(rootNode,220,120);
		myStage.setScene(myScene);
		response=new Label("Push a button");
		tbOnOff=new ToggleButton("On/Off");

		tbOnOff.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent ae)
			{
				if (tbOnOff.isSelected())
					response.setText("Button is on");
				else
					response.setText("Button is off");
			}
		});

		rootNode.getChildren().addAll(tbOnOff,response);
		myStage.show();
	}
}
















