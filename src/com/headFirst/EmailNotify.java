package com.headFirst;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class EmailNotify implements Observer {
	private String[] users=new String[]{"小名","小紅"};
	public EmailNotify() {
		// TODO Auto-generated constructor stub
	}

	public String[] getUsers() {
		return users;
	}

	public void setUsers(String[] users) {
		this.users = users;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		notifyUsers(arg);
	}
	public void notifyUsers(Object arg){
		for (String string : users) {
			System.out.println(string+":"+"差異是"+arg);
		}
	}
}
