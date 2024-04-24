package com.example.demo.controller.deviceList;

import com.example.demo.domain.mapper.MstDeviceMapper;
import com.example.demo.domain.model.MstDevice;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Device")
public class DeviceListController {

	@Autowired
	MstDeviceMapper mstDeviceMapper; 
	
	@GetMapping("/DeviceList")
	public String getDevice(Model model) {
		List<MstDevice> deviceList = mstDeviceMapper.selectAll();
		DeviceListForm form = new DeviceListForm();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		for (MstDevice device : deviceList) {
			DeviceListInfo info = new DeviceListInfo();
			info.deviceNo = device.getDevice_no();
			info.maker = device.getMaker();
			info.os = device.getOs();
			info.memory = device.getMemory();
			info.storageLocate = device.getStorage_locate();
			info.broken = device.getBroken() ? "〇" : "";
			info.leaseFlag = device.getLease_flag() ? "〇" : "";
			info.leaseStartDate = dateFormat.format(device.getLease_start_date());
			info.leaseDeadlineDate = dateFormat.format(device.getLease_deadline_date());
			
			form.deviceList.add(info);
		}
		model.addAttribute("form", form);
		
		return "deviceList";
	}
}



