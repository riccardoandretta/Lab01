package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {

	Parole elenco;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtParola"
	private TextField txtParola; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML
	private Button btnReset;

	@FXML // fx:id="btnInserisci"
	private Button btnInserisci; // Value injected by FXMLLoader

	@FXML
	private Button btnCancella;
	
	@FXML
	private TextField txtExe;

	@FXML
	void doInsert(ActionEvent event) {
		String parola = txtParola.getText();
		elenco.addParola(parola);

		String sb = new String();
		for (String s : elenco.getElenco()) {
			sb += (s + "\n");
		}
		this.txtResult.setText(sb);
		txtParola.clear();
		
		
		long startTime = System.nanoTime();    
		// ... the code being measured ...    
		//long estimatedTime = System.nanoTime() - startTime;
		txtExe.setText(String.format("%d", System.nanoTime() - startTime));

	}

	@FXML
	void doReset(ActionEvent event) {
		elenco.reset();
		txtResult.clear();
		txtParola.clear();
		
		long startTime = System.nanoTime();    
		txtExe.setText(String.format("%d", System.nanoTime() - startTime));
	}

	@FXML
	void doCanc(ActionEvent event) {
		String selected = "";
		if (this.elenco.getElenco().contains(txtParola.getText())) {
			selected = txtParola.getText();
			elenco.cancella(selected);
			txtParola.clear();
			txtResult.setText(txtResult.getText().replace(selected, "").trim());
				
		}
		
		long startTime = System.nanoTime();    
		txtExe.setText(String.format("%d", System.nanoTime() - startTime));

	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
		assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";

		elenco = new Parole();

	}
}
