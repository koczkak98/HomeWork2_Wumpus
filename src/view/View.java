package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import programing.WumpusPlay;

public class View {

    public void showTable(Stage stage, WumpusPlay gt)
    {
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


        /** VIEW ELEMENTS */

        for (int row = 0; row < 8; row++) {

            for (int column = 0; column < 8; column++) {

                String gameCellContent = gt.getCellContent(row, column);

                Button button = new Button(gameCellContent);

                gridPane.add(button, column, row);
            }

        }

        /** VIEW ELEMENTS */


        //Creating a scene object
        Scene scene = new Scene(gridPane);

        //Setting title to the Stage
        stage.setTitle("Wumpus Game");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }


}
