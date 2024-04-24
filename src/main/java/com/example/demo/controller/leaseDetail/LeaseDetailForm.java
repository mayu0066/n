package com.example.demo.controller.leaseDetail;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LeaseDetailForm {

	@NotEmpty(message = "必須です")
	@Size(max = 20, message = "20文字以内で入力してください")
	private String deviceNo;
	
	private Boolean leaseFlag;
	
	private String leaseStartDate;
	
	private String leaseDeadlineDate;
	
	@Size(max = 20, message = "20文字以内で入力してください")
	private String leaseEmployeeNo;
	
	@Size(max = 20, message = "20文字以内で入力してください")
	private String name;
	
	@NotEmpty(message = "必須です")
	private String inventoryDate;
	
	@Size(max = 225, message = "225文字以内で入力してください")
	private String remarks;
}
