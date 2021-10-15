package PO2;

import javax.swing.JOptionPane;

public class ViewPresLayer implements CalculatorView,CalculatorPresenter {
	
    private CalculatorClass calculator;
    private Calculator_GUI GUI;
    public ViewPresLayer(Calculator_GUI calculatorGUI) {
    	this.GUI = calculatorGUI;
        calculator = new CalculatorClass();
    }
    public String str_a,str_b;
    public double result_of_calculation;
    public String error_message;
    public void printResult(double result) {
    	GUI.result.setText(Double.toString(result));
    	result_of_calculation = result;
        System.out.println(result);
    }
    public void displayError(String message) {
    	JOptionPane.showMessageDialog(GUI, message);
    	error_message = message;
    	System.out.println(message);
    }
    public String getFirstArgumentAsString() {
        //return str_a;
    	 return GUI.number_field_1.getText();
    }
    public String getSecondArgumentAsString() {
    	return GUI.number_field_2.getText();
        //return str_b;
    }
    @Override
    public void onPlusClicked() {
        try {
        	if(getFirstArgumentAsString().isEmpty()) throw new NullPointerException();
        	Double.parseDouble(getFirstArgumentAsString());
            if(getSecondArgumentAsString().isEmpty()) throw new NullPointerException();
            Double.parseDouble(getSecondArgumentAsString()); 
            
        } catch(NumberFormatException e) {
        	displayError("Argument is not a number.");
            return;
        } catch(NullPointerException e) {
        	displayError("Argument is null.");
            return;
        }
        printResult(calculator.sum( Double.parseDouble(getFirstArgumentAsString()),
        		Double.parseDouble(getSecondArgumentAsString())));
    }
    @Override
    public void onMinusClicked() {
    	try {
        	if(getFirstArgumentAsString().isEmpty()) throw new NullPointerException();
        	Double.parseDouble(getFirstArgumentAsString());
            if(getSecondArgumentAsString().isEmpty()) throw new NullPointerException();
            Double.parseDouble(getSecondArgumentAsString()); 
            
        } catch(NumberFormatException e) {
        	displayError("Argument is not a number.");
            return;
        } catch(NullPointerException e) {
        	displayError("Argument is null.");
            return;
        }
        printResult(calculator.subtract(Double.parseDouble(getFirstArgumentAsString()),
        		Double.parseDouble(getSecondArgumentAsString())));
    }
    @Override
    public void onDivideClicked() {
    	try {
        	if(getFirstArgumentAsString().isEmpty()) throw new NullPointerException();
        	Double.parseDouble(getFirstArgumentAsString());
            if(getSecondArgumentAsString().isEmpty()) throw new NullPointerException();
            Double.parseDouble(getSecondArgumentAsString()); 
            
        } catch(NumberFormatException e) {
        	displayError("Argument is not a number.");
            return;
        } catch(NullPointerException e) {
        	displayError("Argument is null.");
            return;
        }
        try {
        	printResult(calculator.divide(Double.parseDouble(getFirstArgumentAsString()),
        			Double.parseDouble(getSecondArgumentAsString())));
        } catch(ArithmeticException e) {
        	displayError("Second argument is zero. Divide by zero is not allowed.");
        } 
    }
    @Override
    public void onMultiplyClicked() {
    	try {
        	if(getFirstArgumentAsString().isEmpty()) throw new NullPointerException();
        	Double.parseDouble(getFirstArgumentAsString());
            if(getSecondArgumentAsString().isEmpty()) throw new NullPointerException();
            Double.parseDouble(getSecondArgumentAsString()); 
            
        } catch(NumberFormatException e) {
        	displayError("Argument is not a number.");
            return;
        } catch(NullPointerException e) {
        	displayError("Argument is null.");
            return;
        }
        printResult(calculator.multiply(Double.parseDouble(getFirstArgumentAsString()),
        		Double.parseDouble(getSecondArgumentAsString())));
    }
}
