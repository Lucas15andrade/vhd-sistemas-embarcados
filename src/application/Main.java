package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			/*
			 * Código padrão
			 * 
			 * BorderPane root = new BorderPane(); Scene scene = new Scene(root,400,400);
			 * scene.getStylesheets().add(getClass().getResource("application.css").
			 * toExternalForm()); primaryStage.setScene(scene); primaryStage.show();
			 */
			System.out.println("Executando");

			Parent cena = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(cena);
			Stage st = new Stage();
			st.setScene(scene);
			st.setResizable(false);
			st.setTitle("Alterar valor");
			st.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
