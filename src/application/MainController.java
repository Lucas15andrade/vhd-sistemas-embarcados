package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {

	@FXML
	private AnchorPane borderPrincipal;

	@FXML
	private JFXTextField textValor;

	@FXML
	private JFXButton btnCompilar;

	@FXML
	private JFXButton btnExecutar;

	@FXML
	private JFXButton btnEscolherArquivo;

	@FXML
	void compilar(ActionEvent event) {
		System.out.println("clicou em compilar");
	}

	@FXML
	void executar(ActionEvent event) {
		System.out.println("Clicou em executar");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
