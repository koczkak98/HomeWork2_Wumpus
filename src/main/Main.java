package main;

import javafx.application.Application;
import javafx.stage.Stage;
import programing.ButtonListener;
import programing.WumpusPlay;
import view.View;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{


        WumpusPlay play = new WumpusPlay();

        View view = new View();

        ButtonListener bl = new ButtonListener(play, view);

        view.showTable(primaryStage, play, bl);






    }
}
