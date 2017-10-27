package RPSLS;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Player {

    @FXML
    private TextField inputPlayerName;

    public String playerName;

    @FXML
    public String getName(){
        playerName = inputPlayerName.getText();
        System.out.println(playerName);
        return playerName;
    }



}
