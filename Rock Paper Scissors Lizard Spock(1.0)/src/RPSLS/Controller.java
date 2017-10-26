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
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Controller extends Player{

    @FXML
    private ChoiceBox<?> playerDecisionChoiceBox;

    @FXML
    private TextField cpuDecisionTextField;

    @FXML
    private MenuItem settingsMenu;

    @FXML
    private Label displayRound;


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


        //Determine the winner
        if (strCalculator.equals(playerDecision)) {
            System.out.print("It is a draw \n"); }

        else if (playerDecision.equals("0") && (strCalculator.equals("1")))
            System.out.println("Paper covers Rock. You lose\n");
        else if (playerDecision.equals("0") && (strCalculator.equals("2")))
            System.out.println("Rock crushes Scissors. You win\n");
        else if (playerDecision.equals("0") && (strCalculator.equals("3")))
            System.out.println("Rock crushes Lizard. You win\n");
        else if (playerDecision.equals("0") && (strCalculator.equals("4")))
            System.out.println("Spock vaporizes Rock. You lose\n");

        else if (playerDecision.equals("1") && (strCalculator.equals("0")))
            System.out.println("Paper covers Rock. You win\n");
        else if (playerDecision.equals("1") && (strCalculator.equals("2")))
            System.out.println("Scissors cut Paper. You lose\n");
        else if (playerDecision.equals("1") && (strCalculator.equals("3")))
            System.out.println("Lizard eats Paper. You lose\n");
        else if (playerDecision.equals("1") && (strCalculator.equals("4")))
            System.out.println("Paper disproves Spock. You win\n");

        else if (playerDecision.equals("2") && (strCalculator.equals("0")))
            System.out.println("Rock crushes Scissors. You lose\n");
        else if (playerDecision.equals("2") && (strCalculator.equals("1")))
            System.out.println("Scissors cut Paper. You win\n");
        else if (playerDecision.equals("2") && (strCalculator.equals("3")))
            System.out.println("Scissors decapitates Lizard. You win\n");
        else if (playerDecision.equals("2") && (strCalculator.equals("4")))
            System.out.println("Spock smashes Scissors. You lose\n");

        else if (playerDecision.equals("3") && (strCalculator.equals("0")))
            System.out.println("Rock crushes Lizard. You lose\n");
        else if (playerDecision.equals("3") && (strCalculator.equals("1")))
            System.out.println("Lizard eats Paper. You win\n");
        else if (playerDecision.equals("3") && (strCalculator.equals("2")))
            System.out.println("Scissors decapitates Lizard. You lose\n");
        else if (playerDecision.equals("3") && (strCalculator.equals("4")))
            System.out.println("Lizard poisons Spock. You win\n");

        else if (playerDecision.equals("4") && (strCalculator.equals("0")))
            System.out.println("Spock vaporizes Rock. You win\n");
        else if (playerDecision.equals("4") && (strCalculator.equals("1")))
            System.out.println("Paper disproves Spock. You lose\n");
        else if (playerDecision.equals("4") && (strCalculator.equals("2")))
            System.out.println("Spock smashes Scissors. You win\n");
        else if (playerDecision.equals("4") && (strCalculator.equals("3")))
            System.out.println("Lizard poisons Spock. You lose\n");

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



