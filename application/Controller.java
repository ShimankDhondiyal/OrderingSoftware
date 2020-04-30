/**
 * Controller class for the first stage (Stage1.fxml)
 * 
 * @author Michael Cardoso
 * @author Shimank Dhondiyal
 */

package application;

import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controller {
	protected int MAX_TOPPINGS = 6;
	protected int MIN_TOPPINGS = 1;
	static ArrayList<Pizza> order = new ArrayList<>();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="pizzaOptions"
    private ComboBox<String> pizzaOptions; // Value injected by FXMLLoader

    @FXML // fx:id="sizeOptions"
    private ComboBox<String> sizeOptions; // Value injected by FXMLLoader

    @FXML // fx:id="toppings"
    private ListView<String> toppings; // Value injected by FXMLLoader

    @FXML // fx:id="selectedToppings"
    private ListView<String> selectedToppings; // Value injected by FXMLLoader
    
    @FXML // fx:id="image"
    private ImageView image;
    
    @FXML
    void addToOrder() {
    	if(pizzaOptions.getValue() == "Hawaiian") {
    		Hawaiian newPizza = new Hawaiian(pizzaOptions.getValue(), sizeOptions.getValue());
    		order.add(newPizza);
    	}
    	else if(pizzaOptions.getValue() == "Deluxe") {
    		Deluxe newPizza = new Deluxe(pizzaOptions.getValue(), sizeOptions.getValue());
    		order.add(newPizza);
    	}
    	else {
    		ArrayList<String> toppingsList = new ArrayList<>();
    		if(selectedToppings.getItems().size() >= MIN_TOPPINGS && selectedToppings.getItems().size() <= MAX_TOPPINGS) {
        		toppingsList.addAll(selectedToppings.getItems());
        		BuildYourOwn newPizza = new BuildYourOwn(pizzaOptions.getValue(), sizeOptions.getValue(), toppingsList); 
        		order.add(newPizza);
    		}
    	}
    	clearClicked();
    }
    
    /**
     * Create a new window and display the pizza order
     */
    @FXML
    void showOrder() {
		try {
	    	Stage secondStage = new Stage();
	    	Parent root2;
			root2 = FXMLLoader.load(getClass().getClassLoader().getResource("Stage2.fxml"));
			Scene secondaryStage = new Scene(root2);
	    	secondStage.setScene(secondaryStage);
	    	secondStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * When the "Add Toppings" button is clicked, add the toppings if 1. Build Your Own and 2. topping not already selected
     */
    @FXML
    void addClicked() {
    	if (pizzaOptions.getValue() == "Build Your Own") {
    		if(!selectedToppings.getItems().contains(toppings.getSelectionModel().getSelectedItem())
    				&& (toppings.getSelectionModel().getSelectedItem() != null)) {
    			selectedToppings.getItems().add(toppings.getSelectionModel().getSelectedItem());
    			toppings.getItems().remove(toppings.getSelectionModel().getSelectedItem());
    		}
    	}
    }
    
    /**
     * Remove topping from selected toppings list
     */
    @FXML
    void removeClicked() {
    	if(selectedToppings.getSelectionModel().getSelectedItem() != null) {
    		toppings.getItems().add(selectedToppings.getSelectionModel().getSelectedItem());
    		selectedToppings.getItems().remove(selectedToppings.getSelectionModel().getSelectedItem());
    	}
    }
    
    /**
     * Remove all toppings from selected toppings list
     */
    @FXML
    void clearClicked() {
    	toppings.getItems().clear();
        toppings.getItems().addAll("Beef", "Cheese", "Chicken", "Green Pepper", "Ham", "Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage");
    	selectedToppings.getItems().clear();
    }
    
    /**
     * If the pizza type changes from BYO to preset, delete all toppings
     */
    @FXML
    void changePizzaType() {
    	if(pizzaOptions.getValue() == "Deluxe") {
    		clearClicked();
            File file = new File("src/application/Deluxe.jpg");
            Image img = new Image(file.toURI().toString());
            image.setImage(img);
    	}
    	else if(pizzaOptions.getValue() == "Hawaiian") {
    		clearClicked();
            File file = new File("src/application/Hawaiian.jpg");
            Image img = new Image(file.toURI().toString());
            image.setImage(img);
    	}
    	else {
            File file = new File("src/application/Plain.jpg");
            Image img = new Image(file.toURI().toString());
            image.setImage(img);
    	}

    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert pizzaOptions != null : "fx:id=\"pizzaOptions\" was not injected: check your FXML file 'FXMLDoc.fxml'.";
        assert sizeOptions != null : "fx:id=\"sizeOptions\" was not injected: check your FXML file 'FXMLDoc.fxml'.";
        assert toppings != null : "fx:id=\"toppings\" was not injected: check your FXML file 'FXMLDoc.fxml'.";
        assert selectedToppings != null : "fx:id=\"selectedToppings\" was not injected: check your FXML file 'FXMLDoc.fxml'.";
        
        //Set defaults
        pizzaOptions.getItems().addAll("Deluxe", "Hawaiian", "Build Your Own");
        pizzaOptions.getSelectionModel().select(2);
        sizeOptions.getItems().addAll("Small", "Medium", "Large");
        sizeOptions.getSelectionModel().select(1);
        File file = new File("src/application/Plain.jpg");
        Image img = new Image(file.toURI().toString());
        image.setImage(img);
        
        toppings.getItems().addAll("Beef", "Cheese", "Chicken", "Green Pepper", "Ham", "Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage");
    }
}
