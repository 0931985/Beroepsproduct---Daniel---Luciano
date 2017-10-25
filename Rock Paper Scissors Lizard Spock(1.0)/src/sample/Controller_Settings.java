package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.Controller;

public class Controller_Settings extends Controller{
    @FXML
    private TextField playerName;

    @FXML
    void save_Name(){
        String saveName = this.playerName.getText();
        System.out.println(saveName);
    }



}
