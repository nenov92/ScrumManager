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
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.scrum.roles.Role;
import main.scrum.roles.ScrumParticipant;

public class InputConsole extends JFrame implements DocumentListener {

	private static final long serialVersionUID = -2646420103095502620L;

	private JTextField entry;
	private JLabel jLabel;
	private JLabel status;
	private ScrumParticipant user;
	private List<String> content;

	final static Color ERROR_COLOR = Color.PINK;
	final static String ENTER_ACTION = "enter";

	final Color entryBg;

	public InputConsole(String windowName, ScrumParticipant user) {
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

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle(windowName);

		jLabel.setText("Enter action to be performed:");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);

		// Create a parallel group for the horizontal axis
		ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);

		// Create a sequential and a parallel groups
		SequentialGroup h1 = layout.createSequentialGroup();
		ParallelGroup h2 = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);

		// Add a container gap to the sequential group h1
		h1.addContainerGap();

		// Add a scroll pane and a label to the parallel group h2
		h2.addComponent(status, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE);

		// Create a sequential group h3
		SequentialGroup h3 = layout.createSequentialGroup();
		h3.addComponent(jLabel);
		h3.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
		h3.addComponent(entry, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE);

		// Add the group h3 to the group h2
		h2.addGroup(h3);
		// Add the group h2 to the group h1
		h1.addGroup(h2);

		h1.addContainerGap();

		// Add the group h1 to the hGroup
		hGroup.addGroup(GroupLayout.Alignment.TRAILING, h1);
		// Create the horizontal group
		layout.setHorizontalGroup(hGroup);

		// Create a parallel group for the vertical axis
		ParallelGroup vGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		// Create a sequential group v1
		SequentialGroup v1 = layout.createSequentialGroup();
		// Add a container gap to the sequential group v1
		v1.addContainerGap();
		// Create a parallel group v2
		ParallelGroup v2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
		v2.addComponent(jLabel);
		v2.addComponent(entry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
		// Add the group v2 tp the group v1
		v1.addGroup(v2);
		v1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
		v1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
		v1.addComponent(status);
		v1.addContainerGap();

		// Add the group v1 to the group vGroup
		vGroup.addGroup(v1);
		// Create the vertical group
		layout.setVerticalGroup(vGroup);
		setSize(400, 100);
	}

	public void checkIfMethodDefiened() {
		String s = entry.getText();
		if (s.length() <= 0) {
			message("Nothing to search");
			return;
		}

		if (content.contains(s)) { // match found
			entry.setBackground(entryBg);
			message("'" + s + "' method is defined. Press Enter to run this method");
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