package app.dto;

import app.models.Person;

public class PersonDto {
	private long id;
	private String fullName;
	private int age;
	private String roll;
	private String userName;
	private String password;
	
	public PersonDto(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	

	public PersonDto(long id) {
		super();
		this.id = id;
	}

	public PersonDto(long id, String fullName, int age, String rol, String userName, String password) {
		this.id = id;
		this.fullName = fullName;
		this.roll = rol;
		this.age = age;
		this.userName = userName;
		this.password = password;
	}

	public PersonDto(Person person) {
		this.id = person.getId();
		this.fullName = person.getFullName();
		this.roll = person.getRoll();
		this.userName = person.getUserName();
		this.password = person.getPassword();
	}

	public PersonDto() {
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
