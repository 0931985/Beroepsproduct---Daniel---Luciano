package sample;

import sample.Controller_Settings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.Scene;
import javafx.scene.Parent;
import java.util.Random;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Controller{

    @FXML
    private ChoiceBox<?> playerDecisionChoiceBox;

    @FXML
    private TextField cpuDecisionTextField;

    @FXML
    private MenuItem settingsMenu;


    private int playerScore = 0;
    private int cpuScore = 0;


    @FXML
    void play(ActionEvent event) {
        int cpudecisionCalculator = 0;
        int cpuDecisionResult = 0;
        int playerDecisionResult = 0;
        int roundNumber = 0;


        Random rand = new Random();

        int cpuDecisionCalculator = rand.nextInt(5);
        String strCalculator = Integer.toString(cpuDecisionCalculator);

        String playerDecision = String.valueOf(this.playerDecisionChoiceBox.getValue());


        switch (playerDecision) {
            case "Rock":
                playerDecision = "0";
                break;
            case "Paper":
                playerDecision = "1";
                break;
            case "Scissors":
                playerDecision = "2";
                break;
            case "Lizard":
                playerDecision = "3";
                break;
            case "Spock":
                playerDecision = "4";
                break;
        }

        switch (strCalculator) {
            case "0":
                this.cpuDecisionTextField.setText("Rock");;
                break;
            case "1":
                this.cpuDecisionTextField.setText("Paper");;
                break;
            case "2":
                this.cpuDecisionTextField.setText("Scissors");;
                break;
            case "3":
                this.cpuDecisionTextField.setText("Lizard");;
                break;
            case "4":
                this.cpuDecisionTextField.setText("Spock");;
                break;
        }

        cpuDecisionResult = Integer.parseInt(strCalculator);
        playerDecisionResult = Integer.parseInt(playerDecision);

        System.out.println("Player "  + playerDecisionResult);
        System.out.println("Cpu " + cpuDecisionResult);


        class Player {
            int update_playerScore() {
                return playerScore++;
            }
            }

        class Computer{
            int update_cpuScore(){ return cpuScore++;
            }

        }
    }

    @FXML
    void display_Settings(ActionEvent event) throws Exception {
        Stage stage = new Stage();
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("Settings.fxml"));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.setTitle("Settings");
        stage.show();
    }
}

