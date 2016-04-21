package lv.lgs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lv.lgs.entity.Color;
import lv.lgs.serviceImplementation.MailSender;

@Controller
public class ContactController {

	@Autowired
	MailSender mailSender;

	@RequestMapping(value = "/contacts") // �� GET !!!!!!! // ������ /contacts
											// ����� �� �� �� �������� (�
											// index.jsp ) � ������� �������
											// "contact.jsp"
	public String contact(Model model) {
		// String �� ����� ��� jsp, � ����� Object ���� ���������� �� �����
		model.addAttribute("String", "Object");
		List<Color> list = new ArrayList<Color>();
		list.add(new Color("Red"));
		list.add(new Color("Pink"));
		list.add(new Color("Green"));
		list.add(new Color("Orange"));
		list.add(new Color("Silver"));
		model.addAttribute("Colors", list);

		return "contact";// ������� ������ String jsp ����� //����� �����
							// ��������� � tails ����� ����� ��������� � tails

	}

	@RequestMapping(value = "/contacts/send", method = RequestMethod.POST)
	public String sendMail(@RequestParam(name = "content") String content, @RequestParam(name = "email") String email,
			@RequestParam(name = "path") String path) {

		mailSender.sendMail(content, email, path);

		return "redirect:/contacts";

	}
	// @RequestMapping(value = "/contacts") // ������ /contacts ����� �� �� ��
	// �������� (� index.jsp ) � ������� ������� "contact.jsp"
	// public String allCars(Model model) {
	// // Cars �� ����� ��� jsp, � ����� Object ���� ���������� �� �����
	//
	// model.addAttribute("Cars", carServicseImpl.readAll());
	//
	// return "contact";// ������� ������ String jsp ����� //contact �����
	// ����� ��������� � tails
	// // ����� ����� ��������� � tails
	//
	// }
	/*
	 * @RequestMapping(value = "/contacts/send") public String sendMail(){
	 * System.out.println("GET"); return "contact";}
	 */

}
