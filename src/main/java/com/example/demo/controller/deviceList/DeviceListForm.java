package com.example.demo.controller.deviceList;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class DeviceListForm {
	
	public List<DeviceListInfo> deviceList;

	public DeviceListForm() {
		this.deviceList = new ArrayList<>();
	}
}
