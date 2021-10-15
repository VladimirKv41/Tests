package PO2;

public class ViewPresLayer implements CalculatorView,CalculatorPresenter {
	
    private CalculatorClass calculator;
    public ViewPresLayer() {
        calculator = new CalculatorClass();
    }
    public String str_a,str_b;
    public double result_of_calculation;
    public String error_message;
    public void printResult(double result) {
    	result_of_calculation = result;
        System.out.println(result);
    }
    public void displayError(String message) {
    	error_message = message;
    	System.out.println(message);
    }
    public String getFirstArgumentAsString() {
        return str_a;
    }
    public String getSecondArgumentAsString() {
        return str_b;
    }
    public void onPlusClicked() {
        try {
            Double.parseDouble(getFirstArgumentAsString());
            Double.parseDouble(getSecondArgumentAsString());
        } catch(NumberFormatException e) {
            displayError("Argument in not a number.");
            return;
        } catch(NullPointerException e) {
            displayError("Argument is null.");
            return;
        }
        printResult(calculator.sum( Double.parseDouble(getFirstArgumentAsString()),Double.parseDouble(getSecondArgumentAsString())));
    }
    public void onMinusClicked() {
        try {
            Double.parseDouble(getFirstArgumentAsString());
            Double.parseDouble(getSecondArgumentAsString());
        } catch(NumberFormatException e) {
            displayError("Argument in not a number.");
            return;
        } catch(NullPointerException e) {
            displayError("Argument is null.");
            return;
        }
        printResult(calculator.subtract(Double.parseDouble(getFirstArgumentAsString()),Double.parseDouble(getSecondArgumentAsString())));
    }
    public void onDivideClicked() {
        try {
            Double.parseDouble(getFirstArgumentAsString());
            Double.parseDouble(getSecondArgumentAsString());
        } catch(NumberFormatException e) {
            displayError("Argument in not a number.");
            return;
        } catch(NullPointerException e) {
            displayError("Argument is null.");
            return;
        }
        try {
            printResult(calculator.divide(Double.parseDouble(getFirstArgumentAsString()),Double.parseDouble(getSecondArgumentAsString())));
        } catch(ArithmeticException e) {
            displayError("Second argument is zero. Divide by zero is not allowed.");
        } 
    }
    public void onMultiplyClicked() {
        try {
            Double.parseDouble(getFirstArgumentAsString());
            Double.parseDouble(getSecondArgumentAsString());
        } catch(NumberFormatException e) {
            displayError("Argument in not a number.");
            return;
        } catch(NullPointerException e) {
            displayError("Argument is null.");
            return;
        }
        printResult(calculator.multiply(Double.parseDouble(getFirstArgumentAsString()),Double.parseDouble(getSecondArgumentAsString())));
    }
}
