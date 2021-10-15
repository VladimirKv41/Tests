package PO2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TestCases {

	ViewPresLayer VPL = new ViewPresLayer();
	CalculatorClass calculator = new CalculatorClass();
	
	
	// Проверки аргументов
    @Test
    public void is_first_argument_null_check_for_sum() {
        VPL.str_a = null;
        VPL.str_b = String.valueOf(Math.random());
        VPL.onPlusClicked();
        assertEquals("Argument is null.",VPL.error_message);
    }
    @Test
    public void is_second_argument_null_check_for_sum() {
        VPL.str_a = String.valueOf(Math.random());
        VPL.str_b = null;
        VPL.onPlusClicked();
        assertEquals("Argument is null.",VPL.error_message);
    }
    @Test
    public void is_first_argument_null_check_for_subtract() {
        VPL.str_a = null;
        VPL.str_b = String.valueOf(Math.random());
        VPL.onMinusClicked();
        assertEquals("Argument is null.",VPL.error_message);
    }
    @Test
    public void is_second_argument_null_check_for_subtract() {
        VPL.str_a = String.valueOf(Math.random());
        VPL.str_b = null;
        VPL.onMinusClicked();
        assertEquals("Argument is null.",VPL.error_message);
    }
    @Test
    public void is_first_argument_null_check_for_multiply() {
        VPL.str_a = null;
        VPL.str_b = String.valueOf(Math.random());
        VPL.onMultiplyClicked();
        assertEquals("Argument is null.",VPL.error_message);
    }
    @Test
    public void is_second_argument_null_check_for_multiply() {
        VPL.str_a = String.valueOf(Math.random());
        VPL.str_b = null;
        VPL.onMultiplyClicked();
        assertEquals("Argument is null.",VPL.error_message);
    }
    @Test
    public void is_first_argument_null_check_for_divide() {
        VPL.str_a = null;
        VPL.str_b = String.valueOf(Math.random());
        VPL.onDivideClicked();
        assertEquals("Argument is null.",VPL.error_message);
    }
    @Test
    public void is_second_argument_null_check_for_divide() {
        VPL.str_a = String.valueOf(Math.random());
        VPL.str_b = null;
        VPL.onDivideClicked();
        assertEquals("Argument is null.",VPL.error_message);
    }
    @Test
    public void is_first_argument_parseable_check_for_sum() {
        VPL.str_a = "Just string";
        VPL.str_b = String.valueOf(Math.random());
        VPL.onPlusClicked();
        assertEquals("Argument in not a number.",VPL.error_message);
    }
    @Test
    public void is_second_argument_parseable_check_for_sum() {
        VPL.str_a = String.valueOf(Math.random());
        VPL.str_b = "Just string";
        VPL.onPlusClicked();
        assertEquals("Argument in not a number.",VPL.error_message);
    }
    @Test
    public void is_first_argument_parseable_check_for_subtract() {
        VPL.str_a = "Just string";
        VPL.str_b = String.valueOf(Math.random());
        VPL.onMinusClicked();
        assertEquals("Argument in not a number.",VPL.error_message);
    }
    @Test
    public void is_second_argument_parseable_check_for_subtract() {
        VPL.str_a = String.valueOf(Math.random());
        VPL.str_b = "Just string";
        VPL.onMinusClicked();
        assertEquals("Argument in not a number.",VPL.error_message);
    }
    @Test
    public void is_first_argument_parseable_check_for_multiply() {
        VPL.str_a = "Just string";
        VPL.str_b = String.valueOf(Math.random());
        VPL.onMultiplyClicked();
        assertEquals("Argument in not a number.",VPL.error_message);
    }
    @Test
    public void is_second_argument_parseable_check_for_multiply() {
        VPL.str_a = String.valueOf(Math.random());
        VPL.str_b = "Just string";
        VPL.onMultiplyClicked();
        assertEquals("Argument in not a number.",VPL.error_message);
    }
    @Test
    public void is_first_argument_parseable_check_for_divide() {
        VPL.str_a = "Just string";
        VPL.str_b = String.valueOf(Math.random());
        VPL.onDivideClicked();
        assertEquals("Argument in not a number.",VPL.error_message);
    }
    @Test
    public void is_second_argument_parseable_check_for_divide() {
        VPL.str_a = String.valueOf(Math.random());
        VPL.str_b = "Just string";
        VPL.onDivideClicked();
        assertEquals("Argument in not a number.",VPL.error_message);
    }
    @Test
    public void divide_by_zero_check() {
        VPL.str_a = String.valueOf(Math.random());
        VPL.str_b = "0";
        VPL.onDivideClicked();
        assertEquals("Second argument is zero. Divide by zero is not allowed.",VPL.error_message);
    }
    
    
    
    
    
    
    // Проверки методов CalculatorClass
    @RepeatedTest(100)
    public void sum_test() {
        double a = Math.random();
        double b = Math.random();
        assertEquals(a+b,calculator.sum(a,b));
    }
    @RepeatedTest(100)
    public void subtract_test() {
        double a = Math.random();
        double b = Math.random();
        assertEquals(a-b,calculator.subtract(a,b));
    }
    @RepeatedTest(100)
    public void divide_test() {
        double a = Math.random();
        double b = Math.random();
        if (b == 0) b+=b;
        assertEquals(a/b,calculator.divide(a,b));
    }
    @RepeatedTest(100)
    public void multiply_test() {
        double a = Math.random();
        double b = Math.random();
        assertEquals(a*b,calculator.multiply(a,b));
    }
    
    
    
    
    
    
    
    // Проверки методов ViewPresLayer
    @Test
    public void VPL_sum_test() {
    	double a = Math.random();
        double b = Math.random();
        VPL.str_a = String.valueOf(a);
        VPL.str_b = String.valueOf(b);
        VPL.onPlusClicked();
        assertEquals(calculator.sum(a,b),VPL.result_of_calculation);
    }
    @Test
    public void VPL_subtract_test() {
    	double a = Math.random();
        double b = Math.random();
        VPL.str_a = String.valueOf(a);
        VPL.str_b = String.valueOf(b);
        VPL.onMinusClicked();
        assertEquals(calculator.subtract(a,b),VPL.result_of_calculation);
    }
    @Test
    public void VPL_multiply_test() {
    	double a = Math.random();
        double b = Math.random();
        VPL.str_a = String.valueOf(a);
        VPL.str_b = String.valueOf(b);
        VPL.onMultiplyClicked();
        assertEquals(calculator.multiply(a,b),VPL.result_of_calculation);
    }
    @Test
    public void VPL_divide_test() {
    	double a = Math.random();
        double b = Math.random();
        VPL.str_a = String.valueOf(a);
        VPL.str_b = String.valueOf(b);
        VPL.onDivideClicked();
        assertEquals(calculator.divide(a,b),VPL.result_of_calculation);
    }
    @Test
    public void getFirstArgumentAsString_test() {
        VPL.str_a = String.valueOf(Math.random());
        assertEquals(VPL.str_a,VPL.getFirstArgumentAsString());
    }
    @Test
    public void getSecondArgumentAsString_test() {
        VPL.str_b = String.valueOf(Math.random());
        assertEquals(VPL.str_b,VPL.getSecondArgumentAsString());
    }
    @Test
    public void printResult_test_for_sum() {
    	double a = Math.random();
        double b = Math.random();
        VPL.str_a = String.valueOf(a);
        VPL.str_b = String.valueOf(b);
        VPL.onPlusClicked();
        assertEquals(calculator.sum(a,b),VPL.result_of_calculation);
    }
    @Test
    public void printResult_test_for_subtract() {
    	double a = Math.random();
        double b = Math.random();
        VPL.str_a = String.valueOf(a);
        VPL.str_b = String.valueOf(b);
        VPL.onMinusClicked();
        assertEquals(calculator.subtract(a,b),VPL.result_of_calculation);
    }
    @Test
    public void printResult_test_for_multiply() {
    	double a = Math.random();
        double b = Math.random();
        VPL.str_a = String.valueOf(a);
        VPL.str_b = String.valueOf(b);
        VPL.onMultiplyClicked();
        assertEquals(calculator.multiply(a,b),VPL.result_of_calculation);
    }
    @Test
    public void printResult_test_for_divide() {
    	double a = Math.random();
        double b = Math.random();
        VPL.str_a = String.valueOf(a);
        VPL.str_b = String.valueOf(b);
        VPL.onDivideClicked();
        assertEquals(calculator.divide(a,b),VPL.result_of_calculation);
    }
    
    
} 