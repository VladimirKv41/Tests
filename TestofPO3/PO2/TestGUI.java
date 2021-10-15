package PO2;


import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Mock extends Calculator_GUI{
    public Mock() {super();}
    public String get_message() {
    	return this.VPL.error_message;
    }
}


public class TestGUI {
    private static Mock app;
    private static double a,b;
    private static Robot robot;
    @BeforeAll
    public static void init() {
        app = new Mock();
        app.setVisible(true);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        
    }
    public void mouse() throws InterruptedException {   
    	Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JDialog) {
                JDialog dialog = (JDialog) window;
                if (dialog.getContentPane().getComponentCount() == 1
                    && dialog.getContentPane().getComponent(0) instanceof JOptionPane){
                    dialog.dispose();
                }
            }
        }
    }

    @Test
    public void check_sum() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_1.setText(Double.toString(a));
        app.number_field_2.setText(Double.toString(b));
        app.sum.doClick();
        mouse();
        assertEquals(Double.toString(a + b), app.result.getText());
    }
    @Test
    public void check_minus() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_1.setText(Double.toString(a));
        app.number_field_2.setText(Double.toString(b));
    	app.subtract.doClick();
    	mouse();
        assertEquals(Double.toString(a - b), app.result.getText());
    }
    @Test
    public void check_multiply() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_1.setText(Double.toString(a));
        app.number_field_2.setText(Double.toString(b));
        app.multiply.doClick();
    	mouse();
        assertEquals(Double.toString(a * b), app.result.getText());
    }
    @Test
    public void check_divide() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_1.setText(Double.toString(a));
        app.number_field_2.setText(Double.toString(b));
    	app.divide.doClick();
    	mouse();
        assertEquals(Double.toString(a /b), app.result.getText());
    }
    
    
    
    @Test
    public void is_first_arg_null_sum() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_2.setText(Double.toString(b));
        app.number_field_1.setText(null);
        app.sum.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is null.");
    }
    @Test
    public void is_first_arg_null_subtract() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_2.setText(Double.toString(b));
        app.number_field_1.setText(null);
        app.subtract.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is null.");
    }
    @Test
    public void is_first_arg_null_multiply() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_2.setText(Double.toString(b));
        app.number_field_1.setText(null);
        app.multiply.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is null.");
    }
    @Test
    public void is_first_arg_null_divide() throws InterruptedException {
    	Thread.sleep(1000);
        b = Math.random();
        app.number_field_2.setText(Double.toString(b));
        app.number_field_1.setText(null);
        app.divide.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is null.");
    }
    
    
    @Test
    public void is_second_arg_null_sum() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_1.setText(Double.toString(a));
        app.number_field_2.setText(null);
        app.sum.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is null.");
    }
    @Test
    public void is_second_arg_null_subtract() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_1.setText(Double.toString(a));
        app.number_field_2.setText(null);
        app.subtract.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is null.");
    }
    @Test
    public void is_second_arg_null_multiply() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_1.setText(Double.toString(a));
        app.number_field_2.setText(null);
        app.multiply.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is null.");
    }
    @Test
    public void is_second_arg_null_divide() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_1.setText(Double.toString(a));
        app.number_field_2.setText(null);
        app.divide.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is null.");
    }

    
    
    
    
    
    @Test
    public void is_first_arg_not_number_sum() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_2.setText(Double.toString(b));
        app.number_field_1.setText("Just string");
        app.sum.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is not a number.");
    }
    @Test
    public void is_first_arg_not_number_subtract() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random()+1;
        b = Math.random()+1;
        app.number_field_1.setText(Double.toString(a));
        app.number_field_2.setText(Double.toString(b));
        app.number_field_1.setText("Just string");
        app.subtract.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is not a number.");
    }
    @Test
    public void is_first_arg_not_number_multiply() throws InterruptedException {
        Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_2.setText(Double.toString(b));
        app.number_field_1.setText("Just string");
        app.multiply.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is not a number.");
    }
    @Test
    public void is_first_arg_not_number_divide() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_2.setText(Double.toString(b));
        app.number_field_1.setText("Just string");
        app.divide.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is not a number.");
    }
    
    
    
    
    
    @Test
    public void is_second_arg_not_number_sum() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_1.setText(Double.toString(a));
        app.number_field_2.setText("Just string");
        app.sum.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is not a number.");
    }
    @Test
    public void is_second_arg_not_number_subtract() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_1.setText(Double.toString(a));
        app.number_field_2.setText("Just string");
        app.subtract.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is not a number.");
    }
    @Test
    public void is_second_arg_not_number_multiply() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_1.setText(Double.toString(a));
        app.number_field_2.setText("Just string");
        app.multiply.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is not a number.");
    }
    @Test
    public void is_second_arg_not_number_divide() throws InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_1.setText(Double.toString(a));
        app.number_field_2.setText("Just string");
        app.divide.doClick();
        mouse();
        assertEquals(app.get_message(),"Argument is not a number.");
    }
    
    
    
    @Test
    public void testDivByZero() throws  InterruptedException {
    	Thread.sleep(1000);
    	a = Math.random();
        b = Math.random();
        app.number_field_1.setText(Double.toString(a));
        app.number_field_2.setText("0");
        app.divide.doClick();
        mouse();
        app.checkImage(null, app);
        assertEquals(app.get_message(),"Second argument is zero. Divide by zero is not allowed.");
    }
}