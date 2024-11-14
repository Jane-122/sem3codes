import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.event.*;

public class Multi extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage myStage)
    {
        myStage.setTitle("Multiplication Table Generator");
        FlowPane rootNode=new FlowPane(15,15);
        rootNode.setAlignment(Pos.CENTER);

        Label promptLabel=new Label("Enter an integer ");
        TextField inputField=new TextField();
        Button generateButton=new Button("Generate Table");
        Label resultLabel=new Label();
        resultLabel.setTextFill(Color.BLUE);

        generateButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try{
                    int number=Integer.parseInt(inputField.getText());
                    StringBuilder table=new StringBuilder();

                    for (int i=1;i<=10;i++)
                    {
                        table.append(number).append("x").append(i).append("=").append(number*i).append("\n");
                    }
                    resultLabel.setText(table.toString());
                }
                catch (NumberFormatException e)
                {
                    resultLabel.setText("Please enter a valid integer");
                }
            }
        });

        rootNode.getChildren().addAll(promptLabel,inputField,generateButton,resultLabel);
        Scene myScene=new Scene(rootNode,600,350);
        myStage.setScene(myScene);
        myStage.show();        
    }
}

















