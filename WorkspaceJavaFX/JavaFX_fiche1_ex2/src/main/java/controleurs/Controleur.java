package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controleur {
	@FXML
	private TextField tfEuros;
	@FXML
	private TextField tfDollars;
	@FXML
	private Label tfErrorMessage;
	private final static double TAUX_DE_CHANGE = 1.03;

	public void convertirMontantVersDollars(ActionEvent e) {
		
		try {
			String montantEuros = tfEuros.getText();
			Double montantEurosParsed = Double.parseDouble(montantEuros);
			
			double montantDollars = montantEurosParsed * TAUX_DE_CHANGE;
			
			String montantDollarsParsed = Double.toString(montantDollars);
			
			tfDollars.setText(montantDollarsParsed);
			tfErrorMessage.setVisible(false);
		} catch(Exception ex) {
			tfErrorMessage.setVisible(true);
			tfErrorMessage.setText("Montant Incorrect");
		}
		
		
	}
	
	public void convertirMontantVersEuros(ActionEvent e) {
		
		try {
			String montantDollars = tfDollars.getText();
			Double montantDollarsParsed = Double.parseDouble(montantDollars);
			
			double montantEuros = montantDollarsParsed / TAUX_DE_CHANGE;
			
			String montantEurosParsed = Double.toString(montantEuros);
			
			tfEuros.setText(montantEurosParsed);
			tfErrorMessage.setVisible(false);
		} catch(Exception ex){
			tfErrorMessage.setVisible(true);
			tfErrorMessage.setText("Montant Incorrect");
			tfDollars.setText("");
			tfEuros.setText("");
		}

	}
}
	