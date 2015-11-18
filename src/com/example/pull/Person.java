package com.example.pull;

public class Person {
private String id,names,email,city;

public Person(String id, String names, String email, String city) {
	super();
	this.id = id;
	this.names = names;
	this.email = email;
	this.city = city;
}

public String getId() {
	return id;
}

public String getNames() {
	return names;
}

public String getEmail() {
	return email;
}

public String getCity() {
	return city;
}

}
