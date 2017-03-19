package com.mycompany.exp3.three;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * 
 * @author ilker
 *
 */
public class FX3_Calculator extends Application {
	private static final String APP_TITLE = "FX Basic Calculator";
	private static final int    WIDTH_PREF_SINGLE_CELL = 80;
	private static final int    WIDTH_PREF_DOUBLE_CELL = 170;
	
	private static final String  NUM1_DEFAULT_MESSAGE = "enter num1";
	private static final String  NUM2_DEFAULT_MESSAGE = "enter num2";
	private static final String  RESULT_DEFAULT_MESSAGE = "result will be here";
	
	private TextField textField_num1, textField_num2;
	private Button button2add, button2subtract, button2multiply, button2divide, button2clear;
	private Label label4result;
	
    public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// widgets (scene controls)
		textField_num1 = new TextField(NUM1_DEFAULT_MESSAGE);
		textField_num2 = new TextField(NUM2_DEFAULT_MESSAGE);
		button2add = new Button("+");
		button2subtract = new Button("-");
		button2multiply = new Button("*");
		button2divide = new Button("/");
		label4result = new Label(RESULT_DEFAULT_MESSAGE);
		label4result.setAlignment(Pos.CENTER);
		label4result.setStyle("-fx-border-color:#0000; -fx-padding:5px;");
		button2clear = new Button("Clear");
		
		// set widths of all controls
		textField_num1.setPrefWidth(WIDTH_PREF_SINGLE_CELL);
		textField_num2.setPrefWidth(WIDTH_PREF_SINGLE_CELL);
		button2add.setPrefWidth(WIDTH_PREF_SINGLE_CELL);
		button2subtract.setPrefWidth(WIDTH_PREF_SINGLE_CELL);
		button2multiply.setPrefWidth(WIDTH_PREF_SINGLE_CELL);
		button2divide.setPrefWidth(WIDTH_PREF_SINGLE_CELL);
		label4result.setPrefWidth(WIDTH_PREF_DOUBLE_CELL);
		button2clear.setPrefWidth(WIDTH_PREF_DOUBLE_CELL);
		
		// register (using Java8 lambda) EventHandler to handle ActionEvent of button controls
		button2add.setOnAction(actionEvent -> handleActionEvent(actionEvent));
		button2subtract.setOnAction(actionEvent -> handleActionEvent(actionEvent));
		button2multiply.setOnAction(actionEvent -> handleActionEvent(actionEvent));
		button2divide.setOnAction(actionEvent -> handleActionEvent(actionEvent));
		button2clear.setOnAction(actionEvent -> handleActionEvent(actionEvent));
				
		// create layout container
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);	// let it be in middle of scene
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		// add controls to grid, cell by cell
		gridPane.add(textField_num1, 0, 0);
		gridPane.add(textField_num2, 1, 0);
		gridPane.add(button2add, 0, 1);
		gridPane.add(button2subtract, 1, 1);
		gridPane.add(button2multiply, 0, 2);
		gridPane.add(button2divide, 1, 2);
		// let result and clear take 2 grid cells
		gridPane.add(label4result, 0, 3, 2, 1);
		gridPane.add(button2clear, 0, 4, 2, 1);
		
		// finally create/set Scene and show Stage
		Scene scene = new Scene(gridPane, 300, 250);
		primaryStage.setTitle(APP_TITLE);
		primaryStage.setScene(scene);
		// register (using Java8 lambda) EventHandler to handle KeyEvent of button controls
		button2add.setOnKeyReleased(keyEvent -> handleKeyEvent(keyEvent, scene));
		button2subtract.setOnKeyReleased(keyEvent -> handleKeyEvent(keyEvent, scene));
		button2multiply.setOnKeyReleased(keyEvent -> handleKeyEvent(keyEvent, scene));
		button2divide.setOnKeyReleased(keyEvent -> handleKeyEvent(keyEvent, scene));
		button2clear.setOnKeyReleased(keyEvent -> handleKeyEvent(keyEvent, scene));
		// show
		primaryStage.show();	
	}

	public void handleActionEvent(ActionEvent ae) {
		float num1, num2, result=0f;
		char symbol='E';
		boolean unHandledSource = false;
		
		if (ae.getSource() == button2clear) {
			textField_num1.setText(NUM1_DEFAULT_MESSAGE);
			textField_num2.setText(NUM2_DEFAULT_MESSAGE);
			label4result.setText(RESULT_DEFAULT_MESSAGE);
			textField_num1.requestFocus();
		} else {
			try {
				// parse number inputs from textFields
				num1 = Float.parseFloat(textField_num1.getText());
				num2 = Float.parseFloat(textField_num2.getText());
				
				if (ae.getSource() == button2add) {
					symbol = '+';
					result = num1 + num2;
				} else if (ae.getSource() == button2subtract) {
					symbol = '-';
					result = num1 - num2;
				} else if (ae.getSource() == button2multiply) {
					symbol = '*';
					result = num1 * num2;
				} else if (ae.getSource() == button2divide) {
					symbol = '/';
					result = num1 / num2;
				} else {
					unHandledSource = true;
				}
				
				if (unHandledSource) {
					label4result.setText("ERROR - UnHandled button source");
				} else {
					label4result.setText("" + num1 + symbol + num2 + '=' + result);
				}
			} catch (NullPointerException npe) {
				label4result.setText("ERROR - Input number(s) null");
				npe.printStackTrace();
			} catch (NumberFormatException nfe) {
				label4result.setText("ERROR - Invalid input number can not be parsed");
				nfe.printStackTrace();
			}
		}	
	}
	
	public void handleKeyEvent(KeyEvent ke, Scene scene) {
		if (ke.getCode() == KeyCode.ENTER) {
			Node focusedNode = scene.getFocusOwner();
			if (focusedNode == button2add || focusedNode == button2subtract || focusedNode == button2multiply || focusedNode == button2divide || focusedNode == button2clear) {
				// ENTER was pressed while focus was on one of the buttons, then create an equivalent ActionEvent on that button emulating user clicking on it and let handleActionEvent handle it
				ActionEvent actionEvent = new ActionEvent(focusedNode, focusedNode);
				handleActionEvent(actionEvent);
			}
		}
	}
}
