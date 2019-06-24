package com.swing.design;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TempAppMainConsole extends Application implements EventHandler<ActionEvent>{
Button but;
Button but1;

	public static void main(String[] args) {
	launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	primaryStage.setTitle("New Window");
	but=new Button();
	but1=new Button();
	but.setText("click me");
	but1.setText("click me 1");
	but.setOnAction(this);
	but1.setOnAction(this);
	StackPane layout=new StackPane();
	layout.getChildren().add(but);
	layout.getChildren().add(but1);
	
	
	Scene scene=new Scene(layout,300,200);
	primaryStage.setScene(scene);
	primaryStage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==but) {
			System.out.println("ooooooooooh");
		}
		if(event.getSource()==but1) {
			System.out.println("ooooooooooh no");
		}
	}
}
