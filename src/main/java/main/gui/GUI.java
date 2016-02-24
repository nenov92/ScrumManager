package main.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Miroslav Nenov
 * code adapted from: http://stackoverflow.com/posts/28482233/revisions
 */

@SuppressWarnings("serial")
public class GUI extends JPanel {
	private static final Color COLOR = Color.BLUE;

	private BufferedImage backgroundImg;
	private BufferedImage bImg;
	private int prefW;
	private int prefH;
	Graphics g;

	public GUI(int x, int y) throws IOException {
		File file = new File("F:/Dev/Java Workspace/scrum-workflow/src/main/resources/flow.jpg");
		bImg = ImageIO.read(file);
		prefW = bImg.getWidth();
		prefH = bImg.getHeight();
		backgroundImg = new BufferedImage(prefW, prefH, BufferedImage.TYPE_INT_ARGB);

		g = backgroundImg.getGraphics();
		g.drawImage(bImg, 0, 0, this);
		g.dispose();

		drawToBackground(x, y);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImg != null) {
			g.drawImage(backgroundImg, 0, 0, this);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(prefW, prefH);
	}

	public void drawToBackground(int x, int y) {
		Graphics g = backgroundImg.getGraphics();
		g.setColor(COLOR);
		g.fillOval(x, y, 15, 15);
		g.dispose();

		this.repaint();
	}

	public void refreshBackground() {
		g = backgroundImg.getGraphics();
		g.drawImage(bImg, 0, 0, this);
		g.dispose();
	}

	public GUI createAndShowGui(int x, int y) throws IOException {
		GUI mainPanel = new GUI(x, y);

		JFrame frame = new JFrame("Scrum Workflow");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

		return mainPanel;
	}

}