package com.example.demo.controller.userDetail;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDetailForm {

	@NotEmpty(message="必須です")
	@Size(max = 20, message="20文字以内で入力してください")
	private String employeeNo;
	
	@Size(max = 20, message="20文字以内で入力してください")
	private String name;
	
	@Size(max = 20, message="20文字以内で入力してください")
	private String nameKana;
	
	@Size(max = 20, message="20文字以内で入力してください")
	private String department;
	
	@Size(max = 20, message="20文字以内で入力してください")
	private String telNo;
	
	@Size(max = 50, message="50文字以内で入力してください")
	private String mailAdress;
	
	private String age;
	
	private String gender;
	
	@Size(max = 20, message="20文字以内で入力してください")
	private String position;
	
	@Size(max = 20, message="20文字以内で入力してください")
	private String accountLevel;
	
	private String retireDate;
	
	@NotEmpty(message="必須です")
	private String registerDate;
	
	private String updateDate;
	
	private String deleteFlag;
}
