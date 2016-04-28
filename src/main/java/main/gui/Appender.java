package main.gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextArea;

/**
 * 
 * @author Miroslav Nenov
 * code adapted from: http://stackoverflow.com/questions/342990/create-java-console-inside-a-gui-panel
 */

public class Appender implements Runnable {
	private final JTextArea textArea;
	private final LinkedList<Integer> lengths; // length of lines within text area
	private final List<String> values; // values waiting to be appended

	private int curLength; // length of current line
	private boolean clear;
	private boolean queue;

	public Appender(JTextArea txtara) {
		textArea = txtara;
		lengths = new LinkedList<Integer>();
		values = new ArrayList<String>();

		curLength = 0;
		clear = false;
		queue = true;
	}

	// append string to the queue
	synchronized void append(String val) {
		values.add(val);
		if (queue) {
			queue = false;
			EventQueue.invokeLater(this);
		}
	}

	// remove queue elements
	synchronized void clear() {
		clear = true;
		curLength = 0;
		lengths.clear();
		values.clear();
		if (queue) {
			queue = false;
			EventQueue.invokeLater(this);
		}
	}

	// add system outs to the admin console
	public synchronized void run() {
		if (clear) {
			textArea.setText("");
		}
		for (String val : values) {
			curLength += val.length();
			if (val.endsWith(EOL1) || val.endsWith(EOL2)) {
				lengths.addLast(curLength);
				curLength = 0;
			}
			textArea.append(val);
		}
		values.clear();
		clear = false;
		queue = true;
	}

	static private final String EOL1 = "\n";
	static private final String EOL2 = System.getProperty("line.separator", EOL1);
}
