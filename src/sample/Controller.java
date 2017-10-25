package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;


import java.util.Random;

public class Controller {

    @FXML
    private ChoiceBox<?> playerDecisionChoiceBox;

    @FXML
    private ChoiceBox<?> cpuDecisionChoiceBox;

    @FXML
    void play(ActionEvent event) {

        int cpudecisionCalculator = 0;
        int cpudecisionResult = 0;
        int playerDecisionResult = 0;
        int playerScore = 0;
        int cpuScore = 0;
        int roundNumber = 0;

        String cpuDecision = String.valueOf(cpuDecisionChoiceBox.getValue());
        String playerDecision = String.valueOf(this.playerDecisionChoiceBox.getValue());

        Random rand = new Random();

        int cpuDecisionCalculator = rand.nextInt(5);

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

        switch (cpuDecision) {
            case "Rock":
                cpuDecision = "0";
                break;
            case "Paper":
                cpuDecision = "1";
                break;
            case "Scissors":
                cpuDecision = "2";
                break;
            case "Lizard":
                cpuDecision = "3";
                break;
            case "Spock":
                cpuDecision = "4";
                break;
        }

        cpudecisionResult = Integer.parseInt(cpuDecision);

        playerDecisionResult = Integer.parseInt(playerDecision);

        System.out.println(cpudecisionResult);
        System.out.println(playerDecisionResult);
    }

}
