package main.gui;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Miroslav Nenov
 * Admin console
 */
public class Console {
	public Console() {
		JFrame frame = new JFrame("Scrum Manager Admin Console");
		frame.setSize(500, 600);

		// menu with exit button 
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menubar.add(exit);

		// text area to print messages
		JTextArea textArea = new JTextArea();
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setEditable(false);

		// take system out streams
		TextOutputStream textOutputStream = new TextOutputStream(textArea);
		PrintStream printStream = new PrintStream(textOutputStream);
		System.setOut(printStream);
		System.setErr(printStream);

		// Visualize
		frame.add(new JScrollPane(textArea));
		frame.setVisible(true);
	}
}
