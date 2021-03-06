package it.polito.tdp.extflightdelays;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.extflightdelays.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnCreaGrafo;

    @FXML
    private ComboBox<String> cmbBoxStati;

    @FXML
    private Button btnVisualizzaVelivoli;

    @FXML
    private TextField txtT;

    @FXML
    private TextField txtG;

    @FXML
    private Button btnSimula;

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	
    	this.txtResult.clear();
    	
    	try {
    		
    		this.model.generaGrafo();
    		this.txtResult.appendText("Grafo creato!\n# vertici: "+this.model.getNvertici()+
    				"\n# archi: "+this.model.getNarchi());
    		
    		this.cmbBoxStati.getItems().setAll(this.model.getStati());
    		
    	}catch(Exception e) {
    		this.txtResult.appendText("ERRORE, impossibile creare il grafo!");
    		return;
    	}
    }

    @FXML
    void doSimula(ActionEvent event) {

		this.txtResult.clear();
		
		int turisti;
		int giorni;
		
		try {
			
			try {
				
				turisti = Integer.parseInt(this.txtT.getText());
				giorni = Integer.parseInt(this.txtG.getText());
				
			}catch(NumberFormatException e1) {
				this.txtResult.appendText("ERRORE, inserire un numero intero T di turisti e G di gionri di viaggio!");
				return;
			}
			
			this.txtResult.appendText(this.model.simulazioneTuristi(this.cmbBoxStati.getValue(), turisti, giorni));

		} catch (Exception e) {

			this.txtResult.appendText("ERRORE, creare il grafo e scegliere uno stato dal menù a tendina!\n"
					+ "Poi inserire un numero intero T di turisti e G di gionri di viaggio!");
			e.printStackTrace();
			return;
		}
	}
    
    @FXML
    void doVisualizzaVelivoli(ActionEvent event) {
    	
    	this.txtResult.clear();
    	try {
    		
    		this.txtResult.appendText(this.model.getStatiCollegati(this.cmbBoxStati.getValue()));
    		
    	}catch(Exception e) {
    		
    		this.txtResult.appendText("ERRORE, creare il grafo e scegliere uno stato dal menù a tendina!");
    		return;
    	}
    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert cmbBoxStati != null : "fx:id=\"cmbBoxStati\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert btnVisualizzaVelivoli != null : "fx:id=\"btnVisualizzaVelivoli\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert txtT != null : "fx:id=\"txtT\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert txtG != null : "fx:id=\"txtG\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
	}
}
