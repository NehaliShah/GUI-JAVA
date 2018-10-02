/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5view;

/**
 *
 * @author Nehali Shah # 000770110
 */
public class assignment5Model {

    /**
     * userAns hold the value that user enters
     */
    private int userAns;
    /**
     * left side value
     */
    private int leftSideValue;
    /**
     * right side value
     */
    private int rightSideValue;
    /**
     * correct-if answer is right variable for increment
     */
    private int correct;
    /**
     * wrong-if answer is wrong variable for increment
     */
    private int wrong;
    /**
     * calculate and store right answer in rightAns
     */
    private int rightAns;
    /**
     * i and j variable for getting random number
     */
    private int i;
    private int j;
    /**
     * sign variable holds the value of sign
     */
    private String sign;

    /**
     *
     * @return userAns
     */
    public int getUserAns() {
        return userAns;
    }

    /**
     *
     * @return leftSideValue
     */
    public int getLeftSideValue() {
        return leftSideValue;
    }

    /**
     *
     * @return rightSideValue
     */
    public int getRightSideValue() {
        return rightSideValue;
    }

    /**
     *
     * @return correct
     */
    public int getCorrect() {
        return correct;
    }

    /**
     *
     * @return wrong
     */
    public int getWrong() {
        return wrong;
    }

    /**
     *
     * @return rightAns
     */
    public int getRightAns() {
        return rightAns;
    }

    /**
     *
     * @return sign
     */
    public String getSign() {
        return sign;
    }

    //constructor
    public assignment5Model() {

        leftSideValue = (int) (Math.random() * 20 + 1);//Get random leftSideValue
        rightSideValue = (int) (Math.random() * 20 + 1);//Get random rightSideValue
        i = (int) (Math.random() * 30); //Get random i
        if (i <= 10) {

            rightAns = leftSideValue + rightSideValue;
            sign = "+";

        } else if (i > 10 && i <= 20) {

            rightAns = leftSideValue - rightSideValue;
            sign = "-";

        } else if (i > 20 && i <= 30) {
            rightAns = leftSideValue * rightSideValue;
            sign = "*";
        }

    }

    public void nextQuestion() {

        leftSideValue = (int) (Math.random() * 20 + 1);//Get random leftSideValue
        rightSideValue = (int) (Math.random() * 20 + 1);//Get random rightSideValue
        j = (int) (Math.random() * 30);       //Get random j
        if (j <= 10) {

            rightAns = leftSideValue + rightSideValue;
            sign = "+";

        } else if (j > 10 && j <= 20) {

            rightAns = leftSideValue - rightSideValue;
            sign = "-";

        } else if (j > 20 && j <= 30) {
            rightAns = leftSideValue * rightSideValue;
            sign = "*";
        }

    }

    /**
     * reset function
     */
    public void reset() {
        wrong = 0;
        correct = 0;
        nextQuestion();
    }

    /**
     *
     * @return comment
     */
    public String getComment() {
        if (userAns != rightAns) {
            wrong++;
            return "Incorrect Answer";
        } else {
            correct++;
            return "Correct Answer";
        }
    }

    /**
     *
     * @param userAns
     */
    public void setUserAns(int userAns) {
        this.userAns = userAns;
    }

}
