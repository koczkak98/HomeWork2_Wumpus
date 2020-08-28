package programing;

import javafx.scene.control.Button;
import view.View;

public class ButtonListener {

    private WumpusPlay gt;
    private View view;
    private int clickCounter;

    public ButtonListener(WumpusPlay gt, View view) {
        this.gt = gt;
        this.view = view;
        clickCounter = 0;
    }

    public void buttonListener (Button button, int row, int column)
    {
        clickCounter++;

        if( gt.discovery(row, column) )
        {
            gt.setDiscovered(row, column);
            updateButtonText(button, row, column);

            if( gt.finishedGame(row, column) )
            {
                String message = gt.finishedMessage(row, column);

                view.showEndMessage(message, clickCounter);
            }
        }
    }

    public void updateButtonText(Button button, int row, int column) {

        String gameCellContent = gt.getCellContent(row, column);
        button.setText(gameCellContent);

        if(gameCellContent.equals("H"))
        {
            button.setStyle("-fx-background-color: magenta");
        }
        else if(gameCellContent.equals("E"))
        {
            button.setStyle("-fx-background-color: magenta");
        }
        else if(gameCellContent.equals("W"))
        {
            button.setStyle("-fx-background-color: red");
        }
        else if(gameCellContent.equals("T"))
        {
            button.setStyle("-fx-background-color: yellow");
        }
        else if(gameCellContent.equals("N"))
        {
            button.setStyle("-fx-background-color: orange");
        }

    }


}
