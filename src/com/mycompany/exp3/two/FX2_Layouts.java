/**
 * 
 */
package com.mycompany.exp3.two;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Example showing;
 * <p><ul>
 * <li>how to use layouts (StackPane, HBox, VBox)
 * <li>how to have nested layouts (above 3 layouts in FlowPane)
 * <li>basic characteristics of layouts StackPane, HBox, VBox, FlowPane
 * <li>handle events using "anonymous inner class that implements EventHandler interface"
 * <li>handle events using "java 8 lambda expressions"
 * </ul><p>
 * 
 * @author ilker
 *
 */
public class FX2_Layouts extends Application {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// widgets to put into Layout
		// button1 - using "anonymous inner class that implements EventHandler interface" to handle user events on button
		Button button1 = new Button();
		button1.setText("button1 button1 button1");	//("Button using anonymous inner class implementing EventHandler");
		// handle user events - using anonymous inner class that implements EventHandler interface to handle events on this button
		button1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("button1 event handled via anonymous inner class");
			}
		});

		// button2 - using "java 8 lambda expressions" to handle user events on button
		Button button2 = new Button();
		button2.setText("button2");	//("Button java 8 lambda expressions");
		button2.setOnAction(actionEvent -> { 
			System.out.println("button2 event handled via java 8 lambda expressions");
			System.out.println( "button1's text is" + button1.getText());
		});

		// button3
		Button button3 = new Button();
		button3.setText("button3");	//("Button java 8 lambda expressions");
		button3.setOnAction((ActionEvent actionEvent) -> System.out.println("button3 event handled via java 8 lambda expressions"));
		
		// button4
		Button button4 = new Button();
		button4.setText("button4");	//("Button java 8 lambda expressions");
		button4.setOnAction(actionEvent -> System.out.println("button4 event handled via java 8 lambda expressions"));
		
		// button5
		Button button5 = new Button();
		button5.setText("button5");	//("Button java 8 lambda expressions");
		button5.setOnAction(actionEvent -> { System.out.println("button5 event handled via java 8 lambda expressions");});
		
		// button6
		Button button6 = new Button();
		button6.setText("button6");	//("Button java 8 lambda expressions");
		button6.setOnAction(actionEvent -> System.out.println("button6 event handled via java 8 lambda expressions"));

		// Layout (containing widgets) to put into Scene
 		// using StackPane - not good for 2 things unless one is smaller than other. NOTE every add lays over the previous one, last one on top.
		StackPane stackPane = new StackPane();
		ObservableList<Node> stackPaneChildren = stackPane.getChildren();
		stackPaneChildren.add(button1);
		stackPaneChildren.add(button2);		
//		Scene scene = new Scene(stackPane, 500, 250);

		// using VBox
		VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10));
	    vbox.setSpacing(8);
		ObservableList<Node> vboxChildren = vbox.getChildren();
		vboxChildren.add(button3);
		vboxChildren.add(button4);
//		Scene scene = new Scene(vbox, 500, 250);

//		// using HBox
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(8);
		ObservableList<Node> hboxChildren = hbox.getChildren();
		hboxChildren.add(button5);
		hboxChildren.add(button6);
//		Scene scene = new Scene(vbox, 500, 250);
		
		// using FlowPane as outer layout container to hold StackPane and VBox
		FlowPane flowPane = new FlowPane();
		ObservableList<Node> flowPaneChildren = flowPane.getChildren();
		flowPaneChildren.add(stackPane);
		flowPaneChildren.add(vbox);
		flowPaneChildren.add(hbox);
		Scene scene = new Scene(flowPane, 500, 250);
		
		primaryStage.setTitle("Hello World 2");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
