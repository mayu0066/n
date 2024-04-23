package com.example.demo.controller.deviceDetail;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DeviceDetailForm {

	@NotEmpty(message = "必須です")
	@Size(max = 20, message = "20文字以内で入力してください")
	private String deviceNo;
	
	@Size(max = 20, message = "20文字以内で入力してください")
	private String maker;
	
	@Size(max = 20, message = "20文字以内で入力してください")
	private String os;
	
	@Size(max = 20, message = "20文字以内で入力してください")
	private String memory;
	
	@Size(max = 20, message = "20文字以内で入力してください")
	private String capacity;
	
	@NotEmpty(message = "必須です")
	@Size(max = 20, message = "20文字以内で入力してください")
	private String storageLocate;
	
	@Size(max = 20, message = "20文字以内で入力してください")
	private String graphicBoard;
	
	private Boolean broken;
	
	private Boolean leaseFlag;
	
	private String leaseStartDate;
	
	private String leaseDeadlineDate;
	
	@Size(max = 20, message = "20文字以内で入力してください")
	private String leaseEmployeeNo;
	
	@NotEmpty(message = "必須です")
	private String inventoryDate;
	
	@Size(max = 225, message = "225文字以内で入力してください")
	private String remarks;
	
	private String registerDate;
	
	private String updateDate;
	
}
