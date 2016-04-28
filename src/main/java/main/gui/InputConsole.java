package main.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultListModel;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.scrum.roles.Role;
import main.scrum.roles.ScrumParticipant;


/**
 * @author Miroslav Nenov
 * Personal User Console 
 */
public class InputConsole extends JFrame implements DocumentListener {

	private static final long serialVersionUID = -7463270687956560650L;

	private JPanel contentPane;
	private JLabel status;
	private JTextField methodField;
	private DefaultListModel<String> obList;
	private DefaultListModel<String> prohList;

	private ScrumParticipant user;
	private List<String> content;

	final static Color ERROR_COLOUR = Color.PINK;
	final static String ENTER_ACTION = "enter";

	final Color bgColour;

	/**
	 * Create the frame.
	 */
	public InputConsole(String windowName, ScrumParticipant user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		setTitle(windowName);

		initialiseComponents();
		this.user = user;

		// actions that are possible to execute by each Scrum role
		content = new ArrayList<String>();
		if (user.getRole() == Role.PRODUCT_OWNER) {
			content.add("prepareBacklog");
			content.add("sortBacklog");
			content.add("giveClarifications");
			content.add("removeEstimationChange");
			content.add("changeTaskEstimation");
		} else if (user.getRole() == Role.SCRUM_MASTER) {
			content.add("startSprint");
			content.add("defineWhenTaskIsDone");
			content.add("setSprintLength");
			content.add("splitGroomingAndPlanning");
			content.add("setTaskMetric");
			content.add("keepInTime");
		}  else if (user.getRole() == Role.DEV_TEAM) {
			content.add("askForClarifications");
			content.add("giveTaskEstimation");
			content.add("updateStatus");
			content.add("demonstrateCompletedTasks");
			content.add("giveFeedback");
		}

		bgColour = methodField.getBackground();
		methodField.getDocument().addDocumentListener(this);

		InputMap im = methodField.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = methodField.getActionMap();
		
		// bind action to enter key
		im.put(KeyStroke.getKeyStroke("ENTER"), ENTER_ACTION);
		am.put(ENTER_ACTION, new EnterAction());
	}

	// Initialize all elements in the window
	private void initialiseComponents() {
		obList = new DefaultListModel<String>();
		prohList = new DefaultListModel<String>();

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel jLabel = new JLabel("Enter action to be performed:");
		jLabel.setForeground(Color.DARK_GRAY);
		jLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel.setBounds(10, 114, 166, 14);
		contentPane.add(jLabel);

		methodField = new JTextField();
		methodField.setBounds(186, 111, 238, 20);
		contentPane.add(methodField);
		methodField.setColumns(10);

		status = new JLabel("");
		status.setForeground(Color.DARK_GRAY);
		status.setBounds(10, 136, 414, 14);
		contentPane.add(status);

		JList<String> pList = new JList<String>(prohList);
		pList.setBackground(SystemColor.menu);
		pList.setBounds(222, 29, 202, 71);
		contentPane.add(pList);

		JLabel obLabel = new JLabel("Active Obligations:");
		obLabel.setForeground(Color.DARK_GRAY);
		obLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		obLabel.setBounds(10, 11, 118, 14);
		contentPane.add(obLabel);

		JLabel prohLabel = new JLabel("Active Prohibitions:");
		prohLabel.setForeground(Color.DARK_GRAY);
		prohLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		prohLabel.setBounds(220, 11, 118, 14);
		contentPane.add(prohLabel);

		JList<String> oList = new JList<String>(obList);
		oList.setBackground(SystemColor.menu);
		oList.setBounds(10, 29, 202, 71);
		contentPane.add(oList);
	}

	/*
	 * getters and setters for the lists
	 * holding the active obligations for this user
	 */
	
	public DefaultListModel<String> getObList() {
		return obList;
	}

	public void setObList(DefaultListModel<String> obList) {
		this.obList = obList;
	}

	public DefaultListModel<String> getProhList() {
		return prohList;
	}

	public void setProhList(DefaultListModel<String> prohList) {
		this.prohList = prohList;
	}

	// check the list of defined methods
	public void checkIfMethodDefiened() {
		String s = methodField.getText();
		if (s.length() <= 0) {
			message("No method entered.");
			return;
		}

		if (content.contains(s)) { // match found
			methodField.setBackground(bgColour);
			message("'" + s + "' method is defined. Press Enter to run this method.");
		} else {
			methodField.setBackground(ERROR_COLOUR);
			message("'" + s + "' method is not defined.");
		}
	}

	void message(String msg) {
		status.setText(msg);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		try {
			checkIfMethodDefiened();
		} catch (Exception e2) {
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		try {
			checkIfMethodDefiened();
		} catch (Exception e2) {
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {

	}

	// when input is entered trigger associated action
	class EnterAction extends AbstractAction {
		private static final long serialVersionUID = 1040470137965458333L;

		public void actionPerformed(ActionEvent ev) {
			try {
				Method method = user.getClass().getMethod(methodField.getText(), (Class<?>[]) null);
				try {
					System.out.println("Action function triggered: " + methodField.getText());
					method.invoke(user);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				}
				methodField.setText("");
				methodField.setBackground(bgColour);
			} catch (NoSuchMethodException | SecurityException e1) {
				status.setText("No such method defined");
			}

		}
	}
}
