import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class JavaFXEventDemo extends Application
{
	Label response;
	public static void main(String[] args)
	{
		launch(args);
	}

	public void start(Stage myStage)
	{
		myStage.setTitle("Use JavaFX Buttons and Events");
		FlowPane rootnode=new FlowPane(10,10);
		rootnode.setAlignment(Pos.CENTER);
		Scene myScene=new Scene(rootnode,300,100);
		myStage.setScene(myScene);
		response=new Label("push a button");
		Button btnUp=new Button("Up");
		Button btnDown=new Button("Down");
		btnUp.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent ae)
			{
				response.setText("You pressed Down");
			}
		});
		btnDown.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent ae)
			{
				response.setText("You pressed Down");
			}
		});
		rootnode.getChildren().addAll(btnUp,btnDown,response);
		myStage.show();
	}
}













