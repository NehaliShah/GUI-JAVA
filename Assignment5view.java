/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5view;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Nehali Shah # 000770110
 *
 */
public class Assignment5view extends Application {

    // TODO: Instance Variables for View Components and Model
    // Display the Title
    Label title1;
    Label title2;
    // Display the right value
    Label rightSideValue;
    // Display the sign symbol
    Label sign;
    // Display the left value 
    Label leftSideValue;
    // Display the equal symbol 
    Label equalSing;
    // Display the right label 
    Label rightSideLabel;
    // Display the feedback
    Label comment;
    // Display the number of correct answer
    Label correct;
    // Display the number of wrong answer
    Label wrong;
    // Display Answer Button
    Button answerButton;
    // Display Reset Button
    Button resetButton;

    // Textfield for user to type in the answer
    TextField inputField;

    assignment5Model m;

    // TODO: Private Event Handlers and Helper Methods
    // Action Handler of Answer button    
    private void answerButtonHandler(ActionEvent e) {
        int userAnswer = Integer.parseInt(inputField.getText());

        m.setUserAns(userAnswer);

        comment.setText(m.getComment());

        if (m.getRightAns() == m.getUserAns()) {
            comment.setStyle("-fx-text-fill:darkblue");
        } else {
            comment.setStyle("-fx-text-fill:darkred");
        }
        wrong.setText("Wrong: " + m.getWrong());
        correct.setText("Right: " + m.getCorrect());

        m.nextQuestion();// set next question
        sign.setText(m.getSign());

        rightSideValue.setText(Integer.toString(m.getRightSideValue()));
        leftSideValue.setText(Integer.toString(m.getLeftSideValue()));
        inputField.setText("");
    }

    // Action Handler of Reset button
    private void resetButtonHandler(ActionEvent e) {
        m.reset();
        wrong.setText("Wrong: " + m.getWrong());
        correct.setText("Right: " + m.getCorrect());
        rightSideValue.setText(Integer.toString(m.getRightSideValue()));
        leftSideValue.setText(Integer.toString(m.getLeftSideValue()));
        comment.setText("");
        inputField.setText("");
    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 450, 400); // set the size here
        stage.setTitle("Quiz"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        // 1. Create the model
        m = new assignment5Model();

        // 2. Create the GUI components
        Canvas canvas = new Canvas(450, 400);
        title1 = new Label("Mathematics Practise Quiz");
        title2 = new Label("Click on Answer button to check your answer");
        leftSideValue = new Label(Integer.toString(m.getLeftSideValue()));

        sign = new Label(m.getSign());

        rightSideValue = new Label(Integer.toString(m.getRightSideValue()));
        wrong = new Label("Wrong  :  " + m.getWrong());
        correct = new Label("Right  : " + m.getCorrect());
        equalSing = new Label(" = ");
        inputField = new TextField();
        rightSideLabel = new Label();
        comment = new Label("");
        answerButton = new Button(" Answer ");
        resetButton = new Button(" Reset ");

        // 3. Add components to the root
        root.getChildren().addAll(canvas, title1, title2, leftSideValue, sign, rightSideValue, wrong, correct, equalSing, inputField, rightSideLabel, comment, answerButton, resetButton);

        // 4. Configure the components (colors, fonts, size, location)
        title1.setLayoutX(30);
        title1.setLayoutY(10);
        title1.setFont(new Font(30));

        title2.setLayoutX(25);
        title2.setLayoutY(50);
        title2.setFont(new Font(20));

        leftSideValue.setLayoutX(50);
        leftSideValue.setLayoutY(100);
        leftSideValue.setFont(new Font(20));

        sign.setLayoutX(100);
        sign.setLayoutY(100);
        sign.setFont(new Font(20));

        rightSideValue.setLayoutX(150);
        rightSideValue.setLayoutY(100);
        rightSideValue.setFont(new Font(20));

        equalSing.setLayoutX(200);
        equalSing.setLayoutY(100);
        equalSing.setFont(new Font(20));

        rightSideLabel.setLayoutX(550);
        rightSideLabel.setPrefWidth(250);
        rightSideLabel.setPrefHeight(400);

        inputField.setLayoutX(250);
        inputField.setLayoutY(100);
        inputField.setPrefWidth(100);

        answerButton.setLayoutX(100);
        answerButton.setLayoutY(300);

        resetButton.setLayoutX(250);
        resetButton.setLayoutY(300);

        comment.setLayoutX(230);
        comment.setLayoutY(130);
        comment.setFont(new Font(20));

        correct.setLayoutX(60);
        correct.setLayoutY(190);
        correct.setFont(new Font(20));

        wrong.setLayoutX(230);
        wrong.setLayoutY(190);
        wrong.setFont(new Font(20));

        // 5. Add Event Handlers and do final setup
        answerButton.setOnAction(this::answerButtonHandler);
        resetButton.setOnAction(this::resetButtonHandler);

        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }

}
