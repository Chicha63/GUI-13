package com.gui13.gui13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("GUI-13");
        TextArea textArea1 = new TextArea();
        ScrollPane scrollPane1 = new ScrollPane(textArea1);
        scrollPane1.setFitToWidth(true);
        scrollPane1.setFitToHeight(true);

        TextField textField1 = new TextField();
        Button button1 = new Button("Send");
        HBox box1 = new HBox(textField1, button1);


        TextArea textArea2 = new TextArea();
        ScrollPane scrollPane2 = new ScrollPane(textArea2);
        scrollPane2.setFitToWidth(true);
        scrollPane2.setFitToHeight(true);

        TextField textField2 = new TextField();
        Button button2 = new Button("Send");
        HBox box2 = new HBox(textField2, button2);

        HBox.setHgrow(scrollPane1, Priority.ALWAYS);
        HBox.setHgrow(scrollPane2, Priority.ALWAYS);
        VBox.setVgrow(scrollPane1, Priority.ALWAYS);
        VBox.setVgrow(scrollPane2, Priority.ALWAYS);
        HBox.setHgrow(textField1, Priority.ALWAYS);
        HBox.setHgrow(textField2, Priority.ALWAYS);

        VBox vBox1 = new VBox(scrollPane1, box1);
        VBox vBox2 = new VBox(scrollPane2, box2);

        SplitPane splitPane = new SplitPane(vBox1, vBox2);

        button1.setOnAction(e->{
            String str = textField1.getText();
            textArea2.appendText("Julieta: " + str + "\n");
            textArea1.appendText("Julieta: " + str + "\n");
            textField1.clear();
        });

        button2.setOnAction(e->{
            String str = textField2.getText();
            textArea2.appendText("Romeo: " + str + "\n");
            textArea1.appendText("Romeo: " + str + "\n");
            textField2.clear();
        });

        textField1.setOnKeyPressed(e->{
            if (e.getCode() == KeyCode.ESCAPE){
                textArea1.clear();
            }if (e.getCode() == KeyCode.ENTER){
                String str = textField1.getText();
                textArea2.appendText("Julieta: " + str + "\n");
                textArea1.appendText("Julieta: " + str + "\n");
                textField1.clear();
            }
        });

        textField2.setOnKeyPressed(e->{
            if (e.getCode() == KeyCode.ESCAPE){
                textArea2.clear();
            }if (e.getCode() == KeyCode.ENTER){
                String str = textField2.getText();
                textArea2.appendText("Romeo: " + str + "\n");
                textArea1.appendText("Romeo: " + str + "\n");
                textField2.clear();
            }
        });

        Scene scene = new Scene(splitPane, 500, 240);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}