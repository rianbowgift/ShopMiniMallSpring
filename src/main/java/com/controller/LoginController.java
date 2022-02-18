package com.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.MemberDAO;
import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class LoginController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/loginUI")
	public String loginUI() {
		return "loginForm"; //loginForm.jsp
	}
	@RequestMapping("/login")
	public String login(@RequestParam Map<String, String> map, 
			            Model m,
			            HttpSession session) {
		System.out.println(map);
		
		MemberDTO dto = memberService.login(map);
		System.out.println(dto);
		// id와 pw 모두 일치한 경우: dto에 id에 해당정보 저장
		// id와 pw  일치하지 않는 경우: dto에 null
		String page = "";
		if(dto==null) {
			//로그인 실패
			m.addAttribute("mesg", "아이디 또는 비번 실패");
			page = "loginForm";
		}else {
			//로그인 성공==> HttpSession에 데이터저장
			session.setAttribute("login", dto);
			page = "redirect:/";  // main.jsp
		}
		
		return page; 
	}//
	
	@RequestMapping("/logout")
	public String logout(HttpSession session ) {
		session.invalidate();  // 세션영역 전체 삭제 
		//session.removeAttribute("key"); // key에 해당하는 값만 삭제
		return "redirect:/";
	}
}





