package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
	private JFXButton btnAlterar;

	@FXML
	private JFXTextField textAntigoValor;

	@FXML
	void compilar(ActionEvent event) {
		//System.out.println("clicou em compilar");
		//Executando script em C para compilar projeto
		
				try {
					Process exec;
					exec = Runtime.getRuntime().exec("cmd /c start C:\\Andrade\\Projetos\\Cobrança\\quartusCompilar");
					BufferedReader in = new BufferedReader(new InputStreamReader(exec.getInputStream()));
					String line = null;
					while ((line = in.readLine()) != null) {
						System.out.println(line);
					}
					if (exec.waitFor() == 0)
						System.out.println("Executado.");
					else
						System.out.println("ERRO");
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	}

	@FXML
	void executar(ActionEvent event) {
		System.out.println("Clicou em executar");
		
		try {
			Process exec;
			exec = Runtime.getRuntime().exec("cmd /c start C:\\Andrade\\Projetos\\Cobrança\\quartusExecutar");
			BufferedReader in = new BufferedReader(new InputStreamReader(exec.getInputStream()));
			String line = null;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
			if (exec.waitFor() == 0)
				System.out.println("Executado.");
			else
				System.out.println("ERRO");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void alterarArquivo(ActionEvent event) {

		//Alterando o valor do no arquivo
		
		try {
			alterarValorArquivo("C:\\Andrade\\TADS\\5o período\\Embarcados\\ladder\\tond\\lpm_constant0.vhd",
					"lpm_cvalue => " + textAntigoValor.getText(), "lpm_cvalue => " + textValor.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	private void alterarValorArquivo(String caminho, String stringVelha, String stringNova) throws IOException {
		String conteudoVelho = "";
		File arquivo = new File(caminho);
		BufferedReader reader = new BufferedReader(new FileReader(arquivo));

		String linha = reader.readLine();
		// String stringVelha = "";

		while (linha != null) {
			/*
			 * if(linha.contains("lpm_cvalue => ")) { stringVelha = linha +
			 * System.lineSeparator(); }
			 */
			conteudoVelho = conteudoVelho + linha + System.lineSeparator();
			linha = reader.readLine();
		}

		String novoConteudo = conteudoVelho.replaceAll(stringVelha, stringNova);
		//System.out.println(novoConteudo);

		FileWriter writer = new FileWriter(arquivo);
		writer.write(novoConteudo);

		reader.close();

		writer.close();
	}

}
