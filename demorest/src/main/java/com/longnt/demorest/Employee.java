package com.longnt.demorest;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
    private String ID;
    private String name;
    private int age;

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;;
    }

    public void setAge(int age) {
        this.age = age;
    }

	public String toString() {
		return "Employee [ID=" + ID + ", name=" + name + ", age=" + age + "]";
	}
    
}
