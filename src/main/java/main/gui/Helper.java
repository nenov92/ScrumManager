package main.gui;

import java.io.IOException;

import javax.swing.JFrame;

/**
 * @author Miroslav Nenov
 * Utility class that starts the gui
 */
public class Helper {
	private static JFrame frame = null;
	private static GUI gui = null;

	public Helper(GUI gui) {
		Helper.gui = gui;
		if (frame == null) {
			frame = new JFrame("Scrum Workflow Status");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(Helper.gui);
			frame.pack();
			frame.setLocationByPlatform(true);
			frame.setVisible(true);
		}
	}

	public static GUI getGUI() throws IOException {
		return gui;
	}

}
