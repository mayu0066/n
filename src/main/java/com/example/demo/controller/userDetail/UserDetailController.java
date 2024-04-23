package com.example.demo.controller.userDetail;

import com.example.demo.domain.mapper.MstUserMapper;
import com.example.demo.domain.model.MstUser;
import com.example.demo.controller.JsonResponse;
import com.example.demo.controller.userDetail.UserDetailForm;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/User/UserList")
public class UserDetailController {

	@Autowired
	MstUserMapper mstUserMapper;
	
	@PostMapping("/register")
	@ResponseBody
	public JsonResponse newUser(@RequestBody @Validated UserDetailForm form, BindingResult result) throws ParseException {
		
		if (result.hasErrors()) {
			return new JsonResponse(result.getAllErrors());
		}
		
		if (judgeNotSymbol(form.getName()) == false) {
			result.rejectValue("name", null, "記号が入力されています");
		}
		
		if (judgeNum(form.getEmployeeNo()) == false) {
			result.rejectValue("employeeNo", null, "半角数字で入力してください");
		}
		
		if (judgeNum(form.getTelNo()) == false) {
			result.rejectValue("telNo", null, "半角数字で入力してください");
		}
		
		if (judgeNum(form.getAge()) == false) {
			result.rejectValue("age", null, "半角数字で入力してください");
		}
		
		if (judgeNotSymbol(form.getDepartment()) == false) {
			result.rejectValue("department", null, "記号が入力されています");
		}
		
		if (judgeNotSymbol(form.getPosition()) == false) {
			result.rejectValue("position", null, "記号が入力されています");
		}
		
		if (judgeAlphaNum(form.getMailAdress()) == false) {
			result.rejectValue("deviceNo", null, "半角英数字で入力してください");
		}
		
		if (judgeDate(form.getRetireDate()) == false) {
			result.rejectValue("retireDate", null, "日付の形式で入力してください");
		}

		if (result.hasErrors()) {
			return new JsonResponse(result.getAllErrors());
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		MstUser user = new MstUser();
		user.setEmployee_no(form.getEmployeeNo());
		user.setName(form.getName());
		user.setName_kana(form.getNameKana());
		user.setDepartment(form.getDepartment());
		user.setTel_no(form.getTelNo());
		user.setMail_adress(form.getMailAdress());
		user.setAge(Integer.valueOf(form.getAge()));
		user.setGender(Integer.valueOf(form.getGender()));
		user.setPosition(form.getPosition());
		user.setAccount_level(form.getAccountLevel());
		if (form.getRetireDate() != null) {
			user.setRetire_date(DateFormat.getDateInstance().parse(form.getRetireDate()));
		}
		user.setRegister_date(new Date());
		user.setUpdate_date(new Date());
		user.setDelete_flag(false);
		
		
		mstUserMapper.insertUser(user);
		
		return new JsonResponse(form);
	}
	
	@GetMapping("/edit")
	public String getUser(@RequestParam(name="employeeNo", required=true) String employeeNo, Model model) {
		MstUser userDetail = mstUserMapper.selectByEmployeeNo(employeeNo);
		UserDetailForm form = new UserDetailForm();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		form.setEmployeeNo(userDetail.getEmployee_no());
		form.setName(userDetail.getName());
		form.setNameKana(userDetail.getName_kana());
		form.setDepartment(userDetail.getDepartment());
		form.setTelNo(userDetail.getTel_no());
		form.setMailAdress(userDetail.getMail_adress());
		form.setAge(userDetail.getAge().toString());
		form.setGender(userDetail.getGender().toString());
		form.setPosition(userDetail.getPosition());
		form.setAccountLevel(userDetail.getAccount_level());
		form.setRegisterDate(dateFormat.format(userDetail.getRegister_date()));
		if (userDetail.getRetire_date() != null) {
			form.setRetireDate(dateFormat.format(userDetail.getRetire_date()));
		}else {
			form.setRetireDate("");
		}
		if(userDetail.getUpdate_date() != null) {
			form.setUpdateDate(dateFormat.format(userDetail.getUpdate_date()));
		}else {
			form.setUpdateDate("");
		}
		
		model.addAttribute("form", form);
		
		return "userDetail";
	}
	
	@PostMapping("/edit")
	@ResponseBody
	public JsonResponse postUser(@RequestBody @Validated UserDetailForm form, BindingResult result) throws ParseException {
		MstUser user = new MstUser();
		
		if (result.hasErrors()) {
			return new JsonResponse(result.getAllErrors());
		}
		
		if (judgeDate(form.getRetireDate()) == false) {
			result.rejectValue("retireDate", null, "日付の形式で入力してください");
		}

		if (result.hasErrors()) {
			return new JsonResponse(result.getAllErrors());
		}
		
		user.setEmployee_no(form.getEmployeeNo());
		user.setName(form.getName());
		user.setName_kana(form.getNameKana());
		user.setDepartment(form.getDepartment());
		user.setTel_no(form.getTelNo());
		user.setMail_adress(form.getMailAdress());
		user.setAge(Integer.valueOf(form.getAge()));
		user.setGender(Integer.valueOf(form.getGender()));
		user.setPosition(form.getPosition());
		user.setAccount_level(form.getAccountLevel());
		user.setRetire_date(DateFormat.getDateInstance().parse(form.getRetireDate()));
		user.setUpdate_date(new Date());
		//form.setDeleteFlag(userDetail.getDelete_flag());
		
		mstUserMapper.update(user);
		
		return new JsonResponse(form);
	}

	@DeleteMapping("/edit")
	public JsonResponse userDelete(@PathVariable(value = "employeeNo") String employeeNo) {
		
		mstUserMapper.deleteByEmployeeNo(employeeNo);
		
		return new JsonResponse();
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
	
	private boolean judgeAlphaNum(String str) {
		return Pattern.matches("^[-A-Za-z0-9]+$",str);
	}
	
	private boolean judgeNum(String num) {
		return Pattern.matches("^[0-9]*$" ,num);
	}
	
	private boolean judgeNotSymbol(String str) {
		return Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])", str);
	}
}

