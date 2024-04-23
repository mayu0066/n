package com.example.demo.controller.leaseList;

import java.util.Date;
import lombok.Data;

@Data
public class LeaseListInfo {

	private String deviceNo;

	private String leaseEmployeeNo;
	
	private String leaseFlag;
	
	private String leaseStartDate;
	
	private String leaseDeadlineDate;
	
	private String inventoryDate;
	
	private String remarks;
	
	private String name;
}
