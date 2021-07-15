/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ravin
 */
public class FXMLDocumentController implements Initializable {
    private static final String MESSAGE_ENTER_LETTER_AND_NUMBER_ON_THE_BOARD = "Oops, please enter a letter and a number on the board.";
    private static final String MESSAGE_NOT_ON_THE_BOARD = "Oops, that isn't on the board.";
    private static final String MESSAGE_OFF_THE_BOARD = "Oops, that's off the board!";
    private Ship ships[] = new Ship[3];
    
    @FXML
    private Button fireButton;
    
    @FXML
    private GridPane gridPane;
    
    @FXML
    private TextField guessTextField;
    @FXML
    private Label messageLabel;
    private int boardSize;
    private int shipLength;
    private int numShips;
    private int shipsSunk;
    
    private double firstNum;
    private double secondNum;
    private int guesses;
    
    @FXML
    public void fireEvent() {
        String guess = guessTextField.getText().trim();
        String message = checkValidInput(guess);
        if(!"".equals(message)) {
            Alert a = new Alert(Alert.AlertType.NONE, message, ButtonType.OK); 
            a.show();
            return;
        }
        String location = firstNum+""+secondNum;
        
        this.guesses++;
        boolean hit = fire(location);
        if (hit && this.shipsSunk == numShips) {
            updateMessageLabel("You sank all my battleships, in " + this.guesses + " guesses");
        }
        guessTextField.setText("");
    }
    private boolean fire(String guess) {
        for (int i = 0; i < this.numShips; i++) {
            Ship ship = this.ships[i];
            
            int index = ship.getLocations().indexOf(guess);
            
            if (ship.getHits() != null && index != -1 && "hit".equals(ship.getHits().get(index))) {
                updateMessageLabel("Oops, you already hit that location!");
                return true;
            } else if (index >= 0) {
                List<String> hits = ship.getHits();
                if(hits == null) {
                    hits = new ArrayList<>();
                    hits.add("");
                    hits.add("");
                    hits.add("");
                }
                hits.set(index, "hit");
                ship.setHits(hits);
                displayHit();
                updateMessageLabel("HIT!");
                if (this.isSunk(ship)) {
                    updateMessageLabel("You sank my battleship!");
                    this.shipsSunk++;
                }
                return true;
            }
        }
        displayMiss();
        updateMessageLabel("You missed.");
        return false;
    }
    private void displayHit() {
        final HBox pictureRegionForShip = new HBox();
        final ImageView imv2 = new ImageView();
        final Image shipImage = new Image(FXMLDocumentController.class.getResourceAsStream("images/ship.png"), 100, 100, true, true);
        imv2.setImage(shipImage);
        pictureRegionForShip.getChildren().add(imv2);
        gridPane.add(pictureRegionForShip, (int)secondNum, (int)firstNum);
    }
    private void displayMiss() {
        final HBox pictureRegionForMiss = new HBox();
        final ImageView imv = new ImageView();
        final Image missImage = new Image(FXMLDocumentController.class.getResourceAsStream("images/miss.png"), 100, 100, true, true);
        imv.setImage(missImage);
        pictureRegionForMiss.getChildren().add(imv);
        gridPane.add(pictureRegionForMiss, (int)secondNum, (int)firstNum);
    }
    private String checkValidInput(String guess) {
        guess = guess.toUpperCase();
        String message = "";
        if(guess.isEmpty() || "".equals(guess) || guess.length() != 2) {
            return MESSAGE_ENTER_LETTER_AND_NUMBER_ON_THE_BOARD;
        }
        List<Character> chars = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G');
        char ch = guess.charAt(0);
        char ch2 = guess.charAt(1);
        
        int num;
        try {
            num = Integer.parseInt(String.valueOf(ch2));
        } catch (Exception e) {
            return MESSAGE_NOT_ON_THE_BOARD;
        }
        if(num > 6) {
            return MESSAGE_OFF_THE_BOARD;
        }
        if(!chars.contains(ch)) {
            return MESSAGE_OFF_THE_BOARD;
        }
        firstNum = chars.indexOf(ch);
        secondNum = num;
        return message;
    }
    private void updateMessageLabel(String message) {
        messageLabel.setText(message);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.boardSize = 7;
        this.shipLength = 3;
        this.numShips = 3;
        this.generateShipLocations();
//        for (int i = 0; i < ships.length; i++) {
//            Ship ship = ships[i];
//            for(String loc:ship.getLocations()) {
//                System.out.println(loc);
//            }
////            for(String hit:ship.getHits()) {
////                System.out.println(hit);
////            }
//        }
    } 
    private void generateShipLocations() {
        List<String> locations;
       
        for (int i = 0; i < this.numShips; i++) {
            
            do {
                locations = this.generateShip();
            } while (this.collision(locations));
            this.ships[i].setLocations(locations);
        }
        System.out.println("Ships array: ");
        System.out.println(this.ships);
    }
    private List<String> generateShip() {
        double direction = Math.floor(Math.random() * 2);
        double row, col;

        if (direction == 1) { // horizontal
                row = Math.floor(Math.random() * this.boardSize);
                col = Math.floor(Math.random() * (this.boardSize - this.shipLength + 1));
        } else { // vertical
                row = Math.floor(Math.random() * (this.boardSize - this.shipLength + 1));
                col = Math.floor(Math.random() * this.boardSize);
        }

        
        List<String> newShipLocations = new ArrayList<>();
        for (int i = 0; i < this.shipLength; i++) {
            if (direction == 1) {
                newShipLocations.add(row + "" + (col + i));

            } else {
                newShipLocations.add((row + i) + "" + col);
            }
        }
        return newShipLocations;
    }
    
    private boolean collision(List<String> locations) {
        for (int i = 0; i < this.numShips; i++) {
            Ship ship = this.ships[i];
            if(ship == null) {
                ship = new Ship();
                ship.setLocations(new ArrayList<>());
                this.ships[i] = ship;
            }
            for (int j = 0; j < locations.size(); j++) {
                    if (ship.getLocations().indexOf(locations.get(j)) >= 0) {
                            return true;
                    }
            }
        }
        return false;
    }
    private boolean isSunk(Ship ship) {
        for (int i = 0; i < this.shipLength; i++)  {
            if (!"hit".equals(ship.getHits().get(i))) {
                    return false;
            }
        }
        return true;
    } 
    

}
class Ship {
    private List<String> locations;
    private List<String> hits;

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public List<String> getHits() {
        return hits;
    }

    public void setHits(List<String> hits) {
        this.hits = hits;
    }  
}
