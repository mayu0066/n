package com.example.demo.controller.userList;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public class UserListForm {

	public List<UserListInfo> userList;
	
	public UserListForm() {
		this.userList = new ArrayList<>();
	}
}
