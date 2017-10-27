package RPSLS;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.Scene;
import javafx.scene.Parent;
import java.util.Random;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;


public class Controller extends Player{

    @FXML
    private ChoiceBox<?> playerDecisionChoiceBox;
    @FXML
    private TextField cpuDecisionTextField;

    @FXML
    private MenuItem settingsMenu;

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

    @FXML
    private void display_round_results() throws Exception {
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

    private void updatePlayerScore(){
        playerScore++;
        displayPlayerScore.setText("Player score: " + playerScore);
    }

    private void updateCpuScore(){
        cpuScore++;
        displayCpuScore.setText("Cpu score: " + cpuScore);
    }

    private void updateRound(){
        roundNumber++;
        displayRound.setText("Round: " + roundNumber);
    }

    private void checkScore(){
        if (playerScore == 3){
            JOptionPane.showMessageDialog(null, "Player wins the game"); }
        else if(cpuScore == 3){
            JOptionPane.showMessageDialog(null, "Cpu wins the game");}
    }

    @FXML
    void play(ActionEvent event) {
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

            System.out.println("Player " + playerDecisionResult);
            System.out.println("Cpu " + cpuDecisionResult);
            System.out.println(playerName);

            //Determine the winner
            if (strCalculator.equals(playerDecision)) {
                JOptionPane.showMessageDialog(null, "It's a tie");

            } else if (playerDecision.equals("0") && (strCalculator.equals("1"))) {
                updateRound();
                updateCpuScore();
                JOptionPane.showMessageDialog(null, "Paper covers Rock. You lose");
                checkScore();
            } else if (playerDecision.equals("0") && (strCalculator.equals("2"))) {
                updateRound();
                updatePlayerScore();
                JOptionPane.showMessageDialog(null, "Rock crushes Scissors. You win");
                checkScore();
            } else if (playerDecision.equals("0") && (strCalculator.equals("3"))) {
                updateRound();
                updatePlayerScore();
                JOptionPane.showMessageDialog(null, "Rock crushes Lizard. You win");
                checkScore();
            } else if (playerDecision.equals("0") && (strCalculator.equals("4"))) {
                updateRound();
                updateCpuScore();
                JOptionPane.showMessageDialog(null, "Spock vaporizes Rock. You lose");
                checkScore();

            } else if (playerDecision.equals("1") && (strCalculator.equals("0"))) {
                updateRound();
                updatePlayerScore();
                JOptionPane.showMessageDialog(null, "Paper covers Rock. You win");
                checkScore();
            } else if (playerDecision.equals("1") && (strCalculator.equals("2"))) {
                updateRound();
                updateCpuScore();
                JOptionPane.showMessageDialog(null, "Scissors cut Paper. You lose");
                checkScore();
            } else if (playerDecision.equals("1") && (strCalculator.equals("3"))) {
                updateRound();
                updateCpuScore();
                JOptionPane.showMessageDialog(null, "Lizard eats Paper. You lose");
                checkScore();
            } else if (playerDecision.equals("1") && (strCalculator.equals("4"))) {
                updateRound();
                updatePlayerScore();
                JOptionPane.showMessageDialog(null, "Paper disproves Spock. You win");
                checkScore();

            } else if (playerDecision.equals("2") && (strCalculator.equals("0"))) {
                updateRound();
                updateCpuScore();
                JOptionPane.showMessageDialog(null, "Rock crushes Scissors. You lose");
                checkScore();
            } else if (playerDecision.equals("2") && (strCalculator.equals("1"))) {
                updateRound();
                updatePlayerScore();
                JOptionPane.showMessageDialog(null, "Scissors cut Paper. You win");
                checkScore();
            } else if (playerDecision.equals("2") && (strCalculator.equals("3"))) {
                updateRound();
                updatePlayerScore();
                JOptionPane.showMessageDialog(null, "Scissors decapitates Lizard. You win");
                checkScore();
            } else if (playerDecision.equals("2") && (strCalculator.equals("4"))) {
                updateRound();
                updateCpuScore();
                JOptionPane.showMessageDialog(null, "Spock smashes Scissors. You lose");
                checkScore();

            } else if (playerDecision.equals("3") && (strCalculator.equals("0"))) {
                updateRound();
                updateCpuScore();
                JOptionPane.showMessageDialog(null, "Rock crushes Lizard. You lose");
                checkScore();
            } else if (playerDecision.equals("3") && (strCalculator.equals("1"))) {
                updateRound();
                updatePlayerScore();
                JOptionPane.showMessageDialog(null, "Lizard eats Paper. You win");
                checkScore();
            } else if (playerDecision.equals("3") && (strCalculator.equals("2"))) {
                updateRound();
                updateCpuScore();
                JOptionPane.showMessageDialog(null, "Scissors decapitates Lizard. You lose");
                checkScore();
            } else if (playerDecision.equals("3") && (strCalculator.equals("4"))) {
                updateRound();
                updatePlayerScore();
                JOptionPane.showMessageDialog(null, "Lizard poisons Spock. You win");
                checkScore();

            } else if (playerDecision.equals("4") && (strCalculator.equals("0"))) {
                updateRound();
                updatePlayerScore();
                JOptionPane.showMessageDialog(null, "Spock vaporizes Rock. You win");
                checkScore();
            } else if (playerDecision.equals("4") && (strCalculator.equals("1"))) {
                updateRound();
                updateCpuScore();
                JOptionPane.showMessageDialog(null, "Paper disproves Spock. You lose");
                checkScore();
            } else if (playerDecision.equals("4") && (strCalculator.equals("2"))) {
                updateRound();
                updatePlayerScore();
                JOptionPane.showMessageDialog(null, "Spock smashes Scissors. You win");
                checkScore();
            } else if (playerDecision.equals("4") && (strCalculator.equals("3"))) {
                updateRound();
                updateCpuScore();
                JOptionPane.showMessageDialog(null, "Lizard poisons Spock. You lose");
                checkScore();

            }

    }
}



