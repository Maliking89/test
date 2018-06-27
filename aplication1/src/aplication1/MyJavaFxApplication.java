package aplication1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyJavaFxApplication extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("application de gestion de stock");
		BorderPane borderPaneRoot  = new BorderPane();
		Scene scene = new Scene(borderPaneRoot,600,600);
		primaryStage.setScene(scene);
		
		HBox hBox1 = new HBox();
		hBox1.setPadding(new Insets(10));
		hBox1.setSpacing(10);
		
		Label labelNom= new Label("Produits:");
		TextField textFeildNom=new TextField();
		Button buttonAdd=new Button("Ajouter");
		hBox1.getChildren().addAll(labelNom, textFeildNom, buttonAdd);
		
		VBox vBox1= new VBox();
		vBox1.setPadding(new Insets(10));

		ObservableList<String> observableList= FXCollections.observableArrayList();
		
		ListView<String> listView1= new ListView<>(observableList);
		//listView1.getItems().addAll("orange","pomme");
		observableList.addAll("A", "B");
		vBox1.getChildren().add(listView1);
		borderPaneRoot.setCenter(vBox1);
		
		borderPaneRoot.setTop(hBox1);
		primaryStage.show();
		buttonAdd.setOnAction((event)->{ 
			String nom=textFeildNom.getText();
			observableList.add(nom);
		});
	}

}
