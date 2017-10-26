package RPSLS;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Player {

    @FXML
    private TextField inputPlayerName;

    @FXML
    public void getName(){
        String playerName = inputPlayerName.getText();
        System.out.println(playerName);
    }



}
