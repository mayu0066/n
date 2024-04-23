package com.example.demo.controller.userList;

import com.example.demo.domain.mapper.MstUserMapper;
import com.example.demo.domain.model.MstUser;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/User")
public class UserListController {

	@Autowired
	MstUserMapper mstUserMapper;
	
	@GetMapping("/UserList")
	public String getUser(Model model) {
		List<MstUser> userList = mstUserMapper.selectAll();
		UserListForm form = new UserListForm();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		record Gender (Integer man, Integer woman, Integer other) {}
		Gender gender = new Gender(0, 1, 2);
		
		for (MstUser user : userList) {
			UserListInfo info = new UserListInfo();
			info.employeeNo = user.getEmployee_no();
			info.name = user.getName();
			info.nameKana = user.getName_kana();
			info.department = user.getDepartment();
			info.telNo = user.getTel_no();
			info.mailAdress = user.getMail_adress();
			info.age = user.getAge();
			switch (user.getGender()) {
				case 0:
					info.gender = "男性";
					break;
				case 1:
					info.gender = "女性";
					break;
				case 2:
					info.gender = "その他";
					break;
			}
			info.position = user.getPosition();
			info.accountLevel = user.getAccount_level();
			if (user.getRetire_date() != null) {
				info.retireDate = dateFormat.format(user.getRetire_date());
			}
			info.registerDate = dateFormat.format(user.getRegister_date());
			if (user.getUpdate_date() != null) {
				info.updateDate = dateFormat.format(user.getUpdate_date());
			}
			info.deleteFlag = user.getDelete_flag() ? "〇" : "";
			
			form.userList.add(info);
		}
		model.addAttribute("form", form);
		
		return "userList";
	}
}
