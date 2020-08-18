package main;

import javafx.application.Application;
import javafx.stage.Stage;
import programing.WumpusPlay;
import view.View;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{


        View view = new View();
        view.createGameWindow();


    }
}
