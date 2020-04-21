/**
 * Controller class for the first stage (Stage2.fxml)
 * 
 * @author Michael Cardoso
 * @author Shimank Dhondiyal
 */

package application;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import application.Controller;

public class Controller2 {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="output"
    private TextArea output; // Value injected by FXMLLoader

    @FXML // fx:id="back"
    private Button back; // Value injected by FXMLLoader

    /**
     * When the back button is clicked, close the current window
     */
    @FXML
    void backClicked(ActionEvent event) {
    	Stage stage = (Stage) back.getScene().getWindow();
    	stage.close();
    }

    /**
     * When the clear button is clicked, clear the output and empty the list
     */
    @FXML
    void clearClicked() {
    	Controller.order.clear();
    	output.clear();
    }
    
    /**
     * This method is used to print information to the textArea
     * OutputStream changed to prevent printing to console
     * 
     * @return String representation of Order
     */
    String print()
    {
    	String output = "";
    	// Create a stream to hold the output
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(baos);
    	// IMPORTANT: Save the old System.out!
    	PrintStream old = System.out;
    	// Tell Java to use your special stream
    	System.setOut(ps);
    	// Print some output: goes to your special stream
    	int totalPrice = 0;
    	for(Pizza pizza : Controller.order) {
    		totalPrice += pizza.pizzaPrice();
    		output += pizza.toString() + "\n";
    	}
    	output += "Total Price: $" + totalPrice + "\n";
    	// Put things back
    	System.out.flush();
    	System.setOut(old);
    	return output;
	}

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert output != null : "fx:id=\"output\" was not injected: check your FXML file 'Stage2.fxml'.";

        output.appendText(print());
    }
}