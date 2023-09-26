import javax.swing.JFrame;

/**  
* Jack Aden - jeaden@dmacc.edu  
* CIS171 22149
* May 1, 2023
* Operating System version - Microsoft
*/
public class WaterIntakeGUIFrame {
	public static void main(String[] args) {
        WaterIntakeGUI gui = new WaterIntakeGUI(); // frame
        
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);
    }

}
