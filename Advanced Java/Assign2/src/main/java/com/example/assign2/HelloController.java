package com.example.assign2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField numberField;

    @FXML
    private Label resultLabel;

    @FXML
    private TextField loanAmountField;

    @FXML
    private TextField interestRateField;

    @FXML
    private TextField loanDurationField;

    @FXML
    private Label carLoanResultLabel;

    @FXML
    public void calculateFactorial() {
        try {
            int number = Integer.parseInt(numberField.getText());
            long factorial = calculateFactorialRecursive(number);
            resultLabel.setText("Factorial: " + factorial);
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid number.");
        }
    }

    @FXML
    public void calculateCarLoan() {
        try {
            double loanAmount = Double.parseDouble(loanAmountField.getText());
            double interestRate = Double.parseDouble(interestRateField.getText());
            int loanDuration = Integer.parseInt(loanDurationField.getText());

            double monthlyInterestRate = interestRate / 12 / 100;
            int numberOfPayments = loanDuration * 12;

            double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
            double totalPayment = monthlyPayment * numberOfPayments;
            carLoanResultLabel.setText("Monthly Payment: $" + String.format("%.2f", monthlyPayment) +
                    "\nTotal Payment: $" + String.format("%.2f", totalPayment));
        } catch (NumberFormatException e) {
            carLoanResultLabel.setText("Please enter valid numbers.");
        }
    }

    private long calculateFactorialRecursive(int n) {
        if (n == 0)
            return 1;
        else
            return n * calculateFactorialRecursive(n - 1);
    }
}