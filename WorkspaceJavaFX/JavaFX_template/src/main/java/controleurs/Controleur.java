package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.Chaines;

public class Controleur {
	@FXML
	TextField tfChaine1, tfChaine2;

	public void transformerChaine(ActionEvent e) {
		String chaine1 = tfChaine1.getText();
		try {
			String chaine2 = Chaines.transformerMinMaj(chaine1);
			tfChaine2.setText(chaine2);
		} catch (Exception e1) {
		}
	}
}
