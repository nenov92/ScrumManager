package main.gui;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/*
 * TextFieldDemo.java requires one additional file:
 * content.txt
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.scrum.roles.Role;
import main.scrum.roles.ScrumParticipant;

public class InputConsoleOld extends JFrame implements DocumentListener {

	private static final long serialVersionUID = -2646420103095502620L;

	private JTextField entry;
	private JLabel jLabel;
	private JLabel status;
	private JTextArea ta;
	private ScrumParticipant user;
	private List<String> content;

	private List<JLabel> activeCompontents;

	final static Color ERROR_COLOR = Color.PINK;
	final static String ENTER_ACTION = "enter";

	final Color entryBg;

	public InputConsoleOld(String windowName, ScrumParticipant user) {
		initComponents(windowName);

		this.user = user;

		content = new ArrayList<String>();
		if (user.getRole() == Role.PRODUCT_OWNER) {
			content.add("startSprint");
		} else if (user.getRole() == Role.SCRUM_MASTER) {
			content.add("assignTask");
		}

		entryBg = entry.getBackground();
		entry.getDocument().addDocumentListener(this);

		InputMap im = entry.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = entry.getActionMap();
		im.put(KeyStroke.getKeyStroke("ENTER"), ENTER_ACTION);
		am.put(ENTER_ACTION, new EnterAction());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	private void initComponents(String windowName) {
		entry = new JTextField();
		status = new JLabel();
		jLabel = new JLabel();
		ta = new JTextArea();
		ta.setBackground(Color.LIGHT_GRAY);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle(windowName);

		jLabel.setText("Enter action to be performed:");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);

		// Turn on automatically adding gaps between components
		layout.setAutoCreateGaps(true);

		// Turn on automatically creating gaps between components that touch the
		// edge of the container and the container.
		layout.setAutoCreateContainerGaps(true);

		// Create the horizontal group
		layout.setHorizontalGroup(initHorizontalGroup(layout));

		// Create the vertical group
		layout.setVerticalGroup(initVerticalGroup(layout));

		setSize(400, 200);
	}

	private ParallelGroup initHorizontalGroup(GroupLayout layout) {
		ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);

		ParallelGroup h1 = layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(status, GroupLayout.DEFAULT_SIZE, 300, 300);

		SequentialGroup h2 = layout.createSequentialGroup()
				.addComponent(jLabel).addComponent(entry, GroupLayout.DEFAULT_SIZE, 180, 185);

		ParallelGroup h3 = layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(ta, GroupLayout.DEFAULT_SIZE, 350, 360);
		
		hGroup.addGroup(GroupLayout.Alignment.LEADING, h1);
		hGroup.addGroup(GroupLayout.Alignment.LEADING, h2);
		hGroup.addGroup(GroupLayout.Alignment.LEADING, h3);

		return hGroup;
	}

	private ParallelGroup initVerticalGroup(GroupLayout layout) {
		ParallelGroup vGroup = layout.createParallelGroup();

		SequentialGroup v = layout.createSequentialGroup();
		v.addComponent(ta, 50, 50, 50);

		ParallelGroup v1 = layout.createParallelGroup();
		v1.addComponent(jLabel);
		v1.addComponent(entry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);

		SequentialGroup v2 = layout.createSequentialGroup();
		v2.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
		v2.addComponent(status);

		v1.addGroup(v2);
		v.addGroup(v1);
		vGroup.addGroup(v);

		return vGroup;
	}

	public List<JLabel> getActiveCompontents() {
		return activeCompontents;
	}

	public void setActiveCompontents(List<JLabel> activeCompontents) {
		this.activeCompontents = activeCompontents;
	}

	public void checkIfMethodDefiened() {
		String s = entry.getText();
		if (s.length() <= 0) {
			message("No method entered.");
			return;
		}

		if (content.contains(s)) { // match found
			entry.setBackground(entryBg);
			message("'" + s + "' method is defined. Press Enter to run this method.");
		} else {
			entry.setBackground(ERROR_COLOR);
			message("'" + s + "' method is not defined.");
		}
	}

	void message(String msg) {
		status.setText(msg);
	}

	// DocumentListener methods
	public void insertUpdate(DocumentEvent ev) {
		checkIfMethodDefiened();
	}

	public void removeUpdate(DocumentEvent ev) {
		checkIfMethodDefiened();
	}

	public void changedUpdate(DocumentEvent ev) {
	}

	class EnterAction extends AbstractAction {
		private static final long serialVersionUID = 1040470137965458333L;

		public void actionPerformed(ActionEvent ev) {
			try {
				Method method = user.getClass().getMethod(entry.getText(), (Class<?>[]) null);
				try {
					System.out.println("Action function triggered: " + entry.getText());
					method.invoke(user);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
				entry.setText("");
				entry.setBackground(entryBg);
			} catch (NoSuchMethodException | SecurityException e1) {
				status.setText("No such method defined");
			}

		}
	}
}