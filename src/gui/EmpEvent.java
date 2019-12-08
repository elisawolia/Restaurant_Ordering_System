package gui;

import java.util.EventObject;

public class EmpEvent extends EventObject {
	private String fName;
	private String lName;
	private String birth;
	private String login;
	private String password;

	public EmpEvent(Object source) {
		super(source);
	}

	public EmpEvent(Object source, String fName, String lName, String birth, String login, String password)
	{
		super(source);

		this.fName = fName;
		this.lName = lName;
		this.birth = birth;
		this.login = login;
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getBirth() {
		return birth;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
}
