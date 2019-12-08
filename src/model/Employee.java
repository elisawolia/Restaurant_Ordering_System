package model;

import java.sql.Statement;

public class Employee {
	private String fName;
	private String lName;
	private String birth;
	private String login;
	private String password;

	public Employee() {

	}

	public Employee(String fName, String lName, String birth, String login, String password) {
		this.fName = fName;
		this.lName = lName;
		this.birth = birth;
		this.login = login;
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
