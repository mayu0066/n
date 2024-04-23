package com.example.demo.controller.leaseDetail;

import com.example.demo.controller.JsonResponse;
import com.example.demo.controller.deviceDetail.DeviceDetailForm;
import com.example.demo.domain.mapper.MstDeviceMapper;
import com.example.demo.domain.model.MstDevice;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/Device/LeaseList")
public class LeaseDetailController {
	
	@Autowired
	MstDeviceMapper mstDeviceMapper;
	
	@GetMapping("/edit")
	public String editLease(@RequestParam(name="deviceNo", required=true) String deviceNo, Model model) {
		MstDevice device = mstDeviceMapper.selectForLeaseDetail(deviceNo);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		LeaseDetailForm form = new LeaseDetailForm();
		form.setDeviceNo(device.getDevice_no());
		form.setLeaseEmployeeNo(device.getLease_employee_no());
		form.setName(device.getName());
		form.setLeaseFlag(device.getLease_flag());
		form.setLeaseStartDate(dateFormat.format(device.getLease_start_date()));
		form.setLeaseDeadlineDate(dateFormat.format(device.getLease_deadline_date()));
		form.setInventoryDate(dateFormat.format(device.getInventory_date()));
		form.setRemarks(device.getRemarks());
		
		model.addAttribute("form", form);
		
		return "leaseDetail";
	}
}