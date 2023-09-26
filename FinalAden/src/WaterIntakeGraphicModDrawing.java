import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
/**  
* Jack Aden - jeaden@dmacc.edu  
* CIS171 22149
* May 1, 2023
* Operating System version - Microsoft
*/
public class WaterIntakeGraphicModDrawing extends JComponent{
	//initialize color of the lines, constant variable for if/else statement at end of code to switch colors
	Color lines = Color.black;
	Color water = Color.green;
	
	// initialize string for if else statement
	String activeColor = "yellow";
	
	//method to paint water glass
	public void paintComponent (Graphics g) {
		
		// body of glass
		g.setColor(lines);
		g.drawRect(0, 10, 15, 15);
		
		// water
		g.setColor(water);
		g.fillRect(1, 15, 13, 5);
	}
	
	public void changeColor() {
		// initialize color
		water = Color.green;
		
		// if else for the water in the cup to change color
		if(activeColor.equals("yellow")) {
			activeColor = "blue";
			water = Color.blue;				
		} else {
			activeColor = "white";
			water = Color.white;
		}
		
		repaint();
	}
}
