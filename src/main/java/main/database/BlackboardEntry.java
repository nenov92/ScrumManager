package main.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Miroslav Nenov
 * This class is annotated with reference to the corresponding
 * database table
 */
@Entity
@Table(name = "blackboard", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
public class BlackboardEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "current_value")
	private String currentValue;

	// default empty constructor
	public BlackboardEntry() {
	}

	public BlackboardEntry(String name, String type, String currentValue) {
		this.name = name;
		this.type = type;
		this.currentValue = currentValue;
	}

	/**
	 * getter and setter methods
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * custom toString function 
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: ");
		sb.append(getName());
		sb.append("; Type: ");
		sb.append(getType());
		sb.append("; Value: ");
		sb.append(getCurrentValue());
		return sb.toString();
	}
}
