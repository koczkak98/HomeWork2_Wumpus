package view;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import programing.WumpusPlay;

import javax.xml.soap.Text;
import java.util.Random;


public class View {

    public void createGameWindow()
    {
        Stage stage = new Stage();

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Set layout
        //Setting size for the pane
        gridPane.setMinSize(300, 300);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 20, 10, 20));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);




        /** Button */
        /*
        DRAWING THE PLAY
         */

        int winnerButtonID = (new Random().nextInt(8));
        int buttonCounter = 0;

        for(int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {

                Button button = new Button();


                button.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {


                    }




                });
                gridPane.add(button, column, row);

            }

        }

        /** Button with caracter */




        /** VIEW ELEMENTS */


        //Creating a scene object
        Scene scene = new Scene(gridPane);

        //Setting title to the Stage
        stage.setTitle("WUMPUS");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }


}
