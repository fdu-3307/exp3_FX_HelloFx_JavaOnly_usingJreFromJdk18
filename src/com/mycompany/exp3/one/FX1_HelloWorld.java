/**
 * 
 */
package com.mycompany.exp3.one;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Hello word JavaFX example. 
 * @author ilker
 *
 */
public class FX1_HelloWorld extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Set STAGE
		primaryStage.setTitle("Hello World JavaFX");
		
		// Add SCENE to STAGE
		Label label = new Label("Hello World ilker SCENE of JavaFX");
		Scene scene = new Scene(label, 400, 200);
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
}
