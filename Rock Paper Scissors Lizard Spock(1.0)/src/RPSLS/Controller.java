package RPSLS;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.Scene;
import java.util.Random;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;


public class Controller{

    @FXML
    private ChoiceBox<?> playerDecisionChoiceBox;

    @FXML
    private TextField cpuDecisionTextField;

    @FXML
    private Label displayRound;

    @FXML
    private Label displayPlayerScore;

    @FXML
    private Label displayCpuScore;


    private int roundNumber = 0;
    private int playerScore = 0;
    private int cpuScore = 0;
    private String roundResults;
    private String playerName;


    //Displays the second screen where the round result is shown
    @FXML
    private void displayRoundResults() throws Exception {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Text roundResultsText2 = new Text();
        roundResultsText2.setText(this.roundResults);
        StackPane layout = new StackPane();
        layout.getChildren().add(roundResultsText2);
        Scene scene2 = new Scene(layout);
        stage.setScene(scene2);
        stage.show();
    }

    //Function to get and return the player name input
    @FXML
    public String getName(){
        playerName = JOptionPane.showInputDialog("Enter your player name: ");
        displayPlayerScore.setText(playerName + " score: " + playerScore);
        return playerName;
    }

    //function to update the player score label
    private void updatePlayerScore(){
        playerScore++;
        displayPlayerScore.setText(playerName + " score: " + playerScore);
    }

    //Function to update the cpu score label
    private void updateCpuScore(){
        cpuScore++;
        displayCpuScore.setText("Cpu score: " + cpuScore);
    }

    //Function to update the round number
    private void updateRound(){
            roundNumber++;
            displayRound.setText("Round: " + roundNumber);
    }

    //Check the scores of the cpu and player to see if somebody won
    private void checkScore() {
        if (playerScore == 3) {
            JOptionPane.showMessageDialog(null, playerName + " wins the game");

        } else if (cpuScore == 3) {
            JOptionPane.showMessageDialog(null, "Cpu wins the game");
        }
    }


    // This function contains the game logic
    @FXML
    void play(ActionEvent event) throws Exception{

            int cpuDecisionResult = 0;
            int playerDecisionResult = 0;

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
                    cpuDecisionTextField.setText("Rock");
                    break;
                case "1":
                    cpuDecisionTextField.setText("Paper");
                    break;
                case "2":
                    cpuDecisionTextField.setText("Scissors");
                    break;
                case "3":
                    cpuDecisionTextField.setText("Lizard");
                    break;
                case "4":
                    cpuDecisionTextField.setText("Spock");
                    break;
            }

            cpuDecisionResult = Integer.parseInt(strCalculator);
            playerDecisionResult = Integer.parseInt(playerDecision);


            //Determines the winner
            if (strCalculator.equals(playerDecision)) {
                this.roundResults = ("It's a tie");
                displayRoundResults();
            } else if (playerDecision.equals("0") && (strCalculator.equals("1"))) {
                updateRound();
                updateCpuScore();
                this.roundResults = ("Paper covers Rock. You lose");
                displayRoundResults();
                checkScore();
            } else if (playerDecision.equals("0") && (strCalculator.equals("2"))) {
                updateRound();
                updatePlayerScore();
                this.roundResults = ("Rock crushes Scissors. You win");
                displayRoundResults();
                checkScore();
            } else if (playerDecision.equals("0") && (strCalculator.equals("3"))) {
                updateRound();
                updatePlayerScore();
                this.roundResults = ("Rock crushes Lizard. You win");
                displayRoundResults();
                checkScore();
            } else if (playerDecision.equals("0") && (strCalculator.equals("4"))) {
                updateRound();
                updateCpuScore();
                this.roundResults = ("Spock vaporizes Rock. You lose");
                displayRoundResults();
                checkScore();

            } else if (playerDecision.equals("1") && (strCalculator.equals("0"))) {
                updateRound();
                updatePlayerScore();
                this.roundResults = ("Paper covers Rock. You win");
                displayRoundResults();
                checkScore();
            } else if (playerDecision.equals("1") && (strCalculator.equals("2"))) {
                updateRound();
                updateCpuScore();
                this.roundResults = ("Scissors cut Paper. You lose");
                displayRoundResults();
                checkScore();
            } else if (playerDecision.equals("1") && (strCalculator.equals("3"))) {
                updateRound();
                updateCpuScore();
                this.roundResults = ("Lizard eats Paper. You lose");
                displayRoundResults();
                checkScore();
            } else if (playerDecision.equals("1") && (strCalculator.equals("4"))) {
                updateRound();
                updatePlayerScore();
                this.roundResults = ("Paper disproves Spock. You win");
                displayRoundResults();
                checkScore();

            } else if (playerDecision.equals("2") && (strCalculator.equals("0"))) {
                updateRound();
                updateCpuScore();
                this.roundResults = ("Rock crushes Scissors. You lose");
                displayRoundResults();
                checkScore();
            } else if (playerDecision.equals("2") && (strCalculator.equals("1"))) {
                updateRound();
                updatePlayerScore();
                this.roundResults = ("Scissors cut Paper. You win");
                displayRoundResults();
                checkScore();
            } else if (playerDecision.equals("2") && (strCalculator.equals("3"))) {
                updateRound();
                updatePlayerScore();
                this.roundResults = ("Scissors decapitates Lizard. You win");
                displayRoundResults();
                checkScore();
            } else if (playerDecision.equals("2") && (strCalculator.equals("4"))) {
                updateRound();
                updateCpuScore();
                this.roundResults = ("Spock smashes Scissors. You lose");
                displayRoundResults();
                checkScore();

            } else if (playerDecision.equals("3") && (strCalculator.equals("0"))) {
                updateRound();
                updateCpuScore();
                this.roundResults = ("Rock crushes Lizard. You lose");
                displayRoundResults();
                checkScore();
            } else if (playerDecision.equals("3") && (strCalculator.equals("1"))) {
                updateRound();
                updatePlayerScore();
                this.roundResults = ("Lizard eats Paper. You win");
                displayRoundResults();
                checkScore();
            } else if (playerDecision.equals("3") && (strCalculator.equals("2"))) {
                updateRound();
                updateCpuScore();
                this.roundResults = ("Scissors decapitates Lizard. You lose");
                displayRoundResults();
                checkScore();
            } else if (playerDecision.equals("3") && (strCalculator.equals("4"))) {
                updateRound();
                updatePlayerScore();
                this.roundResults = ("Lizard poisons Spock. You win");
                displayRoundResults();
                checkScore();

            } else if (playerDecision.equals("4") && (strCalculator.equals("0"))) {
                updateRound();
                updatePlayerScore();
                this.roundResults = ("Spock vaporizes Rock. You win");
                displayRoundResults();
                checkScore();
            } else if (playerDecision.equals("4") && (strCalculator.equals("1"))) {
                updateRound();
                updateCpuScore();
                this.roundResults = ("Paper disproves Spock. You lose");
                displayRoundResults();
                checkScore();
            } else if (playerDecision.equals("4") && (strCalculator.equals("2"))) {
                updateRound();
                updatePlayerScore();
                this.roundResults = ("Spock smashes Scissors. You win");
                displayRoundResults();
                checkScore();
            } else if (playerDecision.equals("4") && (strCalculator.equals("3"))) {
                updateRound();
                updateCpuScore();
                this.roundResults = ("Lizard poisons Spock. You lose");
                displayRoundResults();
                checkScore();
            }

    }
}



