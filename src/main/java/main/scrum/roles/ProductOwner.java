package main.scrum.roles;

import main.Helper;
import main.gui.InputConsole;

/**
 * The MIT License
 * 
 * Copyright 2016 Miroslav Nenov <m.nenov92 at gmail.com>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class ProductOwner extends ScrumParticipant implements Runnable {
	private static Role role = Role.PRODUCT_OWNER;
	private String name;
	private InputConsole console;
	
	// used to control the life scope of the thread
	private volatile boolean running = true;

	// empty constructor
	public ProductOwner() {
	}

	public ProductOwner(String name) {
		super(role);
		this.setName(name);
	}

	public Role getRole() {
		return role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InputConsole getConsole() {
		return console;
	}

	public void setConsole(InputConsole console) {
		this.console = console;
	}

	public static void prepareBacklog() {
		System.out.println("Product Owner: Preparing Backlog");

		Helper.updateBlackboardEntryRecord("backlog", "true");
	}
	
	public static void sortBacklog() {
		System.out.println("Product Owner: Sorting Backlog");

		Helper.updateBlackboardEntryRecord("backlogSorted", "true");
	}
	
	public static void giveClarifications() {
		System.out.println("Product Owner: Giving Clarifications");

		Helper.updateBlackboardEntryRecord("clarificationsGiven", "true");
	}
	
	public static void changeTaskEstimation() {
		System.out.println("Product Owner: Illegally Changing Task Estimations");

		Helper.updateBlackboardEntryRecord("estimationChanged", "true");
	}
	
	public static void removeEstimationChange() {
		System.out.println("Product Owner: Removing Illegally Changed Task Estimations");

		Helper.updateBlackboardEntryRecord("estimationChanged", "false");
	}
	
	public void closeConsole() {
		this.running = false;
	}

	@Override
	public void run() {
		console = new InputConsole("Product Owner Terminal", new ProductOwner("Sam"));
		console.setVisible(true);

		System.out.println("Product Owner joining workflow");
		while (running) {
			Helper.addActiveNormsToConsole(console, getRole());
		}
	}

	// function that stops the thread from running
	public void terminate() {
		running = false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: ");
		sb.append(getName());
		sb.append("; Role: ");
		sb.append(getRole());
		return sb.toString();
	}
}
