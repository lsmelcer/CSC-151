/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numberguess;

import javax.swing.JOptionPane;

/**
 *
 * @author smelcerl6737
 */
public class NumberGuess {

    public static void main(String[] args) {
        // Bake the class into an object so we can use it
        NumberGuess g = new NumberGuess();
        // Variables
        int playerNumber;
        int low = 1;
        int high = 100;
        int guess = (low + high) / 2;
        final int TOO_LOW = 1;
        final int TOO_HIGH = 2;
        final int CORRECT = 3;
        boolean keepPlaying = true;
        
        g.say("Pick a number between 1 and 100 and I will guess it.");
        playerNumber = g.getInteger();
        while (keepPlaying) {
    // Test Case 1: Ask for a number
        g.say("I guess: " + guess);
        g.say("Enter 1 for too low, 2 for too high, 3 for correct");
        Integer feedback = g.getInteger();
        if (feedback == TOO_LOW){
            low = guess;
            guess = (low + high) / 2;
        }
        else if (feedback == TOO_HIGH){
            high = guess;
            guess = (low + high) / 2;
        }
        else if (feedback == CORRECT) {
            g.say("Computer wins!");
            keepPlaying = false;
            if (guess != playerNumber) {
                g.say("Wait, you let me win didn't you?");
            }
        }
        else {
            g.say("I don't even know what's happening anymore -- bye");
            keepPlaying = false;
        }
    }
}    
    
    // Convert String into Integer (or -1 if error)
    public Integer process(String input) {
        // -1 means error in this program
        Integer value = -1;
        // try / catch
        try {
            // Convert String to Integer
            value = Integer.parseInt(input); 
            }
        
        catch (NumberFormatException e) {
            System.err.println(input + " is not an Integer!");
        }
        return value;
    }

    public Integer getInteger() {
        String userInput = JOptionPane.showInputDialog("Enter an integer:");
        Integer result = this.process(userInput); // only allow ints
        // Show the answer, or a decent error message
        if (result == -1) {
            JOptionPane.showMessageDialog(null, result);
            result = this.getInteger();
        }
        return result;
    }
    
    public void say(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
}

