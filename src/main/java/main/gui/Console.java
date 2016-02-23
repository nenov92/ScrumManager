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

public class Console {
	public Console() {
		JFrame frame = new JFrame("Scrum Workflow Simulation");
		// frame.add(new JLabel("Output"), BorderLayout.NORTH);
		frame.setSize(500, 600);

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

		JTextArea textArea = new JTextArea();
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setEditable(false);

		TextOutputStream textOutputStream = new TextOutputStream(textArea);
		PrintStream printStream = new PrintStream(textOutputStream);
		System.setOut(printStream);
		System.setErr(printStream);

		frame.add(new JScrollPane(textArea));
		frame.setVisible(true);
	}
}
