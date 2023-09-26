
/**  
* Jack Aden - jeaden@dmacc.edu  
* CIS171 22149
* Apr 30, 2023
* Operating System version - Microsoft
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class WaterIntakeGUI extends JFrame {
	// declare variables
    private JTextField nameField, daysField, glassesField, feedbackLabel;
    private JTextArea resultArea;
    //create waterGlass object
    WaterIntakeGraphicModDrawing waterGlass = new WaterIntakeGraphicModDrawing();

    
    public WaterIntakeGUI() {
        // set up the window
        setTitle("Water Intake Calculator");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // set up the components
        nameField = new JTextField(20);
        daysField = new JTextField(20);
        glassesField = new JTextField(20);
        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(resultArea);
        

        
        // create input fields
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(waterGlass);
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Days per week you drink water:"));
        inputPanel.add(daysField);
        inputPanel.add(new JLabel("Glasses per day:"));
        inputPanel.add(glassesField);
        
        // Create the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearButtonListener());
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        
        // create results window
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        resultPanel.add(new JLabel("Result:"), BorderLayout.NORTH);
        resultPanel.add(scrollPane, BorderLayout.CENTER);        
        
        // set layout of the panel
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);       

    }
    
    // button listener for calculate button
    private class CalculateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	// get input values
            String name = nameField.getText();
            int days = 0;
            int glasses = 0;
            // handle NumberFormatException for days
            try {
            	days = Integer.parseInt(daysField.getText());
            } catch (NumberFormatException ex) {
                resultArea.setText("Invalid input for days. Please press clear and enter a valid number.");
                return;
            }
            
            //handle NumberFormatException for glasses
            try {
            	glasses = Integer.parseInt(glassesField.getText());
            } catch (NumberFormatException ex) {
            	resultArea.setText("Invalid input for days. Please press clear and enter a valid number.");
                return;
            }
            
            // calculate the result
            double totalGlasses = days * glasses;
            double averageGlasses = totalGlasses / days;
            String message = glassesOfWaterMessage(averageGlasses);
            String result = String.format("Hi %s,\n\nYour average glasses of water for %d days is %.1f glasses.\n\n%s", 
                                          capitalize(name), days, averageGlasses, message);
            
            // display the result
            resultArea.setText(result);
            waterGlass.changeColor();

        }
    }
    
    // button listener for clear button
    private class ClearButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            nameField.setText("");
            daysField.setText("");
            glassesField.setText("");
            resultArea.setText("");
        }
    }
    // method for message
    public static String glassesOfWaterMessage(double glassesOfWater) {
        String glassesOfWaterCategorys = null;
        if (glassesOfWater > 8)
            glassesOfWaterCategorys = "That's a lot";
        else if (glassesOfWater >= 6)
            glassesOfWaterCategorys = "Great job";
        else if (glassesOfWater >= 4)
            glassesOfWaterCategorys = "Doing better than most";
        else if (glassesOfWater >= 1)
            glassesOfWaterCategorys = "More than 1-3 glasses can be beneficial";
        else if (glassesOfWater == 0)
            glassesOfWaterCategorys = "Really really need to drink water";
        return glassesOfWaterCategorys;
    }
    // capitalize first letter of string method
    public static final String capitalize(String str) {
		if (str == null || str.length() == 0)
			return str;
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
