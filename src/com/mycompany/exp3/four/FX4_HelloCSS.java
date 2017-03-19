/**
 * 
 */
package com.mycompany.exp3.four;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author ilker
 *
 */
public class FX4_HelloCSS extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(args);

	}

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Set STAGE
		primaryStage.setTitle("Hello JavaFX CSS");

		// create controls
		Label label = new Label("Hello JavaFX CSS");
		label.getStyleClass().add("my_customLabel");	// NOTE ilker setting custom class defined in CSS file
		Button button = new Button("Click Me Button");
		// NOTE using "java 8 lambda expressions" to handle user events on button
		button.setOnAction(actionEvent -> {
			System.out.println("IN handle(ActionEvent) of EventHandler<ActionEvent>");
			label.setText("Hello JavaFX CSS - button clicked");
		});
		
		// create layouts and put controls into layouts
		VBox vBox = new VBox();
		vBox.getChildren().addAll(label, button);
		
		// create SCENE, set layouts into scene, set CSS stylesheet of scene, add SCENE to STAGE
		Scene scene = new Scene(vBox, 500, 400);	// NOTE ilker, as far as CSS is concerned the vBox added here to scene is the "root node", hence .root style is applied to it
		// NOTE while setting stylesheet CSS in below, need to put full path, including the package CSS file is in
//		scene.getStylesheets().add("com/mycompany/exp3/four/css/myStyle.css");	// NOTE ilker this and below lines are equivalent, leading / is ignored
//		scene.getStylesheets().add("/com/mycompany/exp3/four/css/myStyle.css");
//		scene.getStylesheets().add("src/com/mycompany/exp3/four/css/myStyle.css");	// WRONG
//		scene.getStylesheets().add("myStyleAtSrc.css");	// CORRECT
//		scene.getStylesheets().add("myStyleAtSamePackage.css");	// WRONG
//		scene.getStylesheets().add("com.mycompany.exp3.four/myStyleAtSamePackage.css");	// WRONG
//		scene.getStylesheets().add("com\mycompany\exp3\four\myStyleAtSamePackage.css");	// WRONG
		scene.getStylesheets().add("com/mycompany/exp3/four/myStyleAtSamePackage.css");	// CORRECT
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

}
