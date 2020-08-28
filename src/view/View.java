package view;

import programing.ButtonListener;
import programing.WumpusPlay;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View {

    private Stage mainWindow;
    private Stage finishWindow;


    public void showTable(Stage stage, WumpusPlay gt, ButtonListener bl)
    {
        mainWindow = stage;

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

                Button button = new Button();
                bl.updateButtonText(button, row, column);

                Integer rowInteger = row;
                Integer columnInteger = column;
                button.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {

                        bl.buttonListener(button, rowInteger, columnInteger);
                    }
                });

                gridPane.add(button, column, row);
            }

        }

        /** VIEW ELEMENTS */


        //Creating a scene object
        Scene scene = new Scene(gridPane);

        //Setting title to the Stage
        mainWindow.setTitle("Wumpus Game");

        //Adding scene to the stage
        mainWindow.setScene(scene);

        //Displaying the contents of the stage
        mainWindow.show();
    }


    public void showEndMessage(String message, int clickCounter)
    {
        finishWindow = new Stage();

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Set layout
        //Setting size for the pane
        gridPane.setMinSize(200, 150);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 20, 10, 20));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);


        /** VIEW ELEMENTS */

        Text text = new Text(message);
        gridPane.add(text, 0, 0);

        Text clickCounterText = new Text("You clicked " + clickCounter);
        gridPane.add(clickCounterText, 0, 1);

        Button button = new Button("Exit");
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                mainWindow.close();
                finishWindow.close();
            }
        });
        gridPane.add(button, 0, 2);
        /** VIEW ELEMENTS */


        //Creating a scene object
        Scene scene = new Scene(gridPane);

        //Setting title to the Stage
        finishWindow.setTitle("Game Finished");

        //Adding scene to the stage
        finishWindow.setScene(scene);

        //Displaying the contents of the stage
        finishWindow.show();
    }
}
