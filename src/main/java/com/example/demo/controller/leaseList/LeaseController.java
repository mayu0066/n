package com.example.demo.controller.leaseList;

import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.mapper.MstDeviceMapper;
import com.example.demo.domain.mapper.MstUserMapper;
import com.example.demo.domain.model.MstDevice;
import com.example.demo.domain.model.MstUser;
import com.example.demo.controller.leaseList.LeaseListForm;
import com.example.demo.controller.leaseList.LeaseListInfo;
import com.example.demo.controller.userDetail.UserDetailForm;

@Controller
@RequestMapping("/Device")
public class LeaseController {

	@Autowired
	MstDeviceMapper mstDeviceMapper;
	MstUserMapper mstUserMapper;
	
	@GetMapping("/LeaseList")
	public String getLease(Model model) {
		List<MstDevice> leaseList = mstDeviceMapper.selectForLeaseList();
		LeaseListForm form = new LeaseListForm();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		for (MstDevice device : leaseList) {
			LeaseListInfo info = new LeaseListInfo();
			
			info.setDeviceNo(device.getDevice_no());
			info.setLeaseEmployeeNo(device.getLease_employee_no());
			info.setName(device.getName());
			info.setLeaseFlag(device.getLease_flag() ? "〇" : "");
			if (device.getLease_start_date() != null) {
				info.setLeaseStartDate(dateFormat.format(device.getLease_start_date()));
			}
			else {
				info.setLeaseStartDate("");
			}
			if (device.getLease_deadline_date() != null) {
				info.setLeaseDeadlineDate(dateFormat.format(device.getLease_deadline_date()));
			}
			else {
				info.setLeaseDeadlineDate("");
			}
			if (device.getInventory_date() != null) {
				info.setInventoryDate(dateFormat.format(device.getInventory_date()));
			}
			else {
				info.setInventoryDate("");
			}
			info.setRemarks(device.getRemarks());
			
			form.leaseList.add(info);
		}
		model.addAttribute("form", form);
		
		return "leaseList";
	}
}