package org.chitan.module.sys.controller;

import org.chitan.module.sys.entity.User;
import org.chitan.module.sys.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * LoginController����򿪵�¼ҳ��(GET����)�͵�¼����ҳ��(POST����)��
 * 
 * ������¼��POST������Filter���,
 * 
 * @author CHENLEI
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserManager userManager;

	@RequestMapping(value = "getUserCount", method = RequestMethod.GET)
	public String getUserCount(Model model) {
		int count = userManager.count();
		model.addAttribute("count", count);
		return "user/index";
	}

	@RequestMapping(value = "getUserBy/{id}", method = RequestMethod.GET)
	public String getUserBy(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userManager.selectOne(id));
		return "user/user";
	}

	@RequestMapping(value = "selectUserById/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User selectUserById(@PathVariable("id") Long id, Model model) {
		return userManager.selectOne(id);
	}

	/**
	 * ����RequestMapping��������ǰ��Model׼������, ʵ��Struts2
	 * Preparable���β��ְ󶨵�Ч��,�ȸ���form��id�����ݿ���User����,�ٰ�Form�ύ�����ݰ󶨵��ö����ϡ�
	 * ��Ϊ��update()������form����id���ԣ���˽���updateʱʵ��ִ��.
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
		if (id != -1) {
			model.addAttribute("user", userManager.selectOne(id));
		}
	}

}