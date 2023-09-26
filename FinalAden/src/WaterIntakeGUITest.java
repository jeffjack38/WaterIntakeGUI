import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**  
* Jack Aden - jeaden@dmacc.edu  
* CIS171 22149
* May 2, 2023
* Operating System version - Microsoft
*/
class WaterIntakeGUITest {

	/**
	 * Test method for {@link WaterIntakeGUI#glassesOfWaterMessage(double)}.
	 */
	@Test
	// greater than 8 cups
	void testGlassesOfWaterMessageEight() {
		assertEquals("That's a lot", WaterIntakeGUI.glassesOfWaterMessage(9));
	}
	
	@Test
	// test between 6-8
	void testGlassesOfWaterMessageSixToEight() {
		assertEquals("Great job", WaterIntakeGUI.glassesOfWaterMessage(6));
	}
	@Test
	void testCapitalize1() {
		assertEquals("Jack", WaterIntakeGUI.capitalize("jack"));
	}
	@Test
	void testCapitalize() {
		assertEquals("Bill", WaterIntakeGUI.capitalize("bill"));
	}

}
