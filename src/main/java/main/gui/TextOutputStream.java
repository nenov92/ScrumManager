package main.gui;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.swing.JTextArea;

/**
 * 
 * @author Miroslav Nenov
 * code adapted from: http://stackoverflow.com/questions/342990/create-java-console-inside-a-gui-panel
 */
public class TextOutputStream extends OutputStream {

	private byte[] oneByte;
	private Appender appender;

	// creates instance of the appender in the provided text area
	public TextOutputStream(JTextArea txtara) {
		oneByte = new byte[1];
		appender = new Appender(txtara);
	}

	public synchronized void write(int val) {
		oneByte[0] = (byte) val;
		write(oneByte, 0, 1);
	}

	public synchronized void write(byte[] ba) {
		write(ba, 0, ba.length);
	}

	public synchronized void write(byte[] ba, int str, int len) {
		if (appender != null) {
			appender.append(bytesToString(ba, str, len));
		}
	}

	// stream of bytes to string
	static private String bytesToString(byte[] ba, int str, int len) {
		try {
			return new String(ba, str, len, "UTF-8");
		} catch (UnsupportedEncodingException exeption) {
			return new String(ba, str, len);
		}
	}

}
