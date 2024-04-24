package com.example.demo.controller.deviceDetail;

import com.example.demo.controller.JsonResponse;
import com.example.demo.domain.mapper.MstDeviceMapper;
import com.example.demo.domain.model.MstDevice;
import com.example.demo.domain.service.device.DeviceDetailService;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/Device/DeviceDetail")
public class DeviceDetailController {
	
	@Autowired
	private MstDeviceMapper mstDeviceMapper;
	
	@GetMapping("/register")
	public String getRegisterDevice(Model model) {
		DeviceDetailForm form = new DeviceDetailForm();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		form.setLeaseFlag(false);
		form.setBroken(false);
		form.setRegisterDate(dateFormat.format(new Date()).toString());
		
		model.addAttribute("form", form);
		
		return "deviceDetail";
	}

	@PostMapping("/register")
	@ResponseBody
	public JsonResponse newDevice(@RequestBody @Validated DeviceDetailForm form, BindingResult result) throws ParseException {
		MstDevice device = new MstDevice();
		
		if (result.hasErrors()) {
			return new JsonResponse(result.getAllErrors());
		}
		
		if ((form.getLeaseStartDate() != null) & (judgeDate(form.getLeaseStartDate())) == false) {
			result.rejectValue("leaseStartDate", null, "日付の形式で入力してください");
		}
		
		if ((form.getLeaseDeadlineDate() != null) & (judgeDate(form.getLeaseDeadlineDate()) == false)) {
			result.rejectValue("leaseDeadlineDate", null, "日付の形式で入力してください");
		}
		
		if ((form.getInventoryDate() != null) & (judgeDate(form.getInventoryDate()) == false)) {
			result.rejectValue("inventoryDate", null, "日付の形式で入力してください");
		}
		
		if (result.hasErrors()) {
			return new JsonResponse(result.getAllErrors());
		}
		
		device.setDevice_no(form.getDeviceNo());
		device.setMaker(form.getMaker());
		device.setOs(form.getOs());
		device.setMemory(form.getMemory());
		device.setCapacity(form.getCapacity());
		device.setStorage_locate(form.getStorageLocate());
		device.setGraphic_board(form.getGraphicBoard());
		device.setBroken(form.getBroken() ? true : false);
		device.setLease_flag(form.getLeaseFlag() ? true : false);
		device.setLease_start_date(DateFormat.getDateInstance().parse(form.getLeaseStartDate()));
		device.setLease_deadline_date(DateFormat.getDateInstance().parse(form.getLeaseStartDate()));
		device.setLease_employee_no(form.getLeaseEmployeeNo());
		device.setInventory_date(DateFormat.getDateInstance().parse(form.getInventoryDate()));
		device.setRemarks(form.getRemarks());
		device.setRegister_date(new Date());
		device.setDelete_flag(false);
		
		mstDeviceMapper.insertDevice(device);
		
		return new JsonResponse(form);
	}
	
	@GetMapping("/edit")
	public String getDevice(@RequestParam(name="deviceNo",required=true) String deviceNo, Model model) {
		MstDevice deviceDetail = mstDeviceMapper.selectByDeviceNo(deviceNo);
		DeviceDetailForm form = new DeviceDetailForm();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		form.setDeviceNo(deviceDetail.getDevice_no());
		form.setMaker(deviceDetail.getMaker());
		form.setOs(deviceDetail.getOs());
		form.setMemory(deviceDetail.getMemory());
		form.setCapacity(deviceDetail.getCapacity());
		form.setStorageLocate(deviceDetail.getStorage_locate());
		form.setGraphicBoard(deviceDetail.getGraphic_board());
		form.setBroken(deviceDetail.getBroken());
		form.setLeaseFlag(deviceDetail.getLease_flag());
		form.setLeaseStartDate(dateFormat.format(deviceDetail.getLease_start_date()));
		form.setLeaseDeadlineDate(dateFormat.format(deviceDetail.getLease_deadline_date()));
		form.setLeaseEmployeeNo(deviceDetail.getLease_employee_no());
		form.setInventoryDate(dateFormat.format(deviceDetail.getInventory_date()));
		form.setRemarks(deviceDetail.getRemarks());
		form.setRegisterDate(dateFormat.format(deviceDetail.getRegister_date()));
		if (deviceDetail.getUpdate_date() != null) {
		form.setUpdateDate(dateFormat.format(deviceDetail.getUpdate_date()));
		}
		
		model.addAttribute("form", form);
		
		return "deviceDetail";
	}
	
	@PostMapping("/edit")
	@ResponseBody
	public JsonResponse postDevice(@RequestBody @Validated DeviceDetailForm form, BindingResult result) throws ParseException {
		MstDevice device = new MstDevice();
		
		if (result.hasErrors()) {
			return new JsonResponse(result.getAllErrors());
		}
		
		if (judgeDate(form.getLeaseStartDate()) == false) {
			result.rejectValue("leaseStartDate", null, "日付の形式で入力してください");
		}
		
		if (judgeDate(form.getLeaseDeadlineDate()) == false) {
			result.rejectValue("leaseDeadlineDate", null, "日付の形式で入力してください");
		}
		
		if (judgeDate(form.getInventoryDate()) == false) {
			result.rejectValue("inventoryDate", null, "日付の形式で入力してください");
		}
		
		if (result.hasErrors()) {
			return new JsonResponse(result.getAllErrors());
		}
		
		device.setDevice_no(form.getDeviceNo());
		device.setMaker(form.getMaker());
		device.setOs(form.getOs());
		device.setMemory(form.getMemory());
		device.setCapacity(form.getCapacity());
		device.setStorage_locate(form.getStorageLocate());
		device.setGraphic_board(form.getGraphicBoard());
		device.setBroken(form.getBroken() ? true : false);
		device.setLease_flag(form.getLeaseFlag() ? true : false);
		device.setLease_start_date(DateFormat.getDateInstance().parse(form.getLeaseStartDate()));
		device.setLease_deadline_date(DateFormat.getDateInstance().parse(form.getLeaseStartDate()));
		device.setLease_employee_no(form.getLeaseEmployeeNo());
		device.setInventory_date(DateFormat.getDateInstance().parse(form.getInventoryDate()));
		device.setRemarks(form.getRemarks());
		device.setUpdate_date(new Date());
		
		mstDeviceMapper.update(device);
		
		return new JsonResponse(form);
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public JsonResponse deviceDelete(@RequestBody DeviceDetailForm form, BindingResult result) throws ParseException {
		mstDeviceMapper.logicalDeleteByDeviceNo(form.getDeviceNo());
		
		return new JsonResponse(form);
	}
	
	private boolean judgeDate(String date) {
		date = date.replace('-', '/');
	    DateFormat format = DateFormat.getDateInstance();
	    format.setLenient(false);
	    try {
	        format.parse(date);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	
	private boolean judgeAlphaNum(String employeeNo) {
	    return Pattern.matches("^[-A-Za-z0-9]+$", employeeNo);
	  }
}
