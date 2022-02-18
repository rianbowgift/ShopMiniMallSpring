package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/memberUI")
	public String loginUI() {
		
		return "memberForm";  
		//뷰이기 때문에 memberForm.jsp==> 클라이언트에서   html로 받기 때문에 화면 깜밖임이 있다.
	}
	
	//String 을 뷰가 아닌 데이터(문자열, ArrayList, DTO등)로 처리하라는 의미.
	/*
	 * 
	<mvc:annotation-driven />
	<mvc:default-servlet-handler/>
	
	 * <!-- JSON/Ajax start -->
	<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.8.8</version>
</dependency>
		<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>2.8.8</version>
</dependency>
	 */
	@RequestMapping(value="/idCheck", produces = "text/plain;charset=UTF-8")
	@ResponseBody 
	public String idCheck(@RequestParam("id") String userid,
			@RequestParam("pw") String pw) {

		int result = memberService.idCheck(userid); // userid값을 이용해서 DB에 중복체크
		String mesg = "아이디 사용가능";
		if(result==1) {
			mesg = "아이디 중복";
		}
		
		return mesg;
		// "main"을 뷰가 아닌 문자열로 처리하여 응답 ==> 전체화면이 아닌 일부분의 데이터만 처리하고자 할 때
	}
	
	//회원저장
	@RequestMapping(value="/memberAdd", method = RequestMethod.GET)
	public String memberAdd(MemberDTO dto, Model m) {
		System.out.println(dto);
		int n = memberService.memberAdd(dto);
		if(n==1) {
			m.addAttribute("mesg", "회원가입성공");
		}else {
			m.addAttribute("mesg", "회원가입실패");
		}
		return "forward:/";
	}
	
	@RequestMapping("/mypage")
	public String mypage(HttpSession session) {
		//HttpSession에 login키로 dto가 저장되어있다. userid정보를 세션에서 찾는다.
		MemberDTO mDTO = (MemberDTO)session.getAttribute("login");
		//userid에 해당하는 회원정보를 DB에서 가져와서 저장후 화면에 보여준다.
		MemberDTO dto = memberService.mypage(mDTO.getUserid());
		session.setAttribute("login", dto);
		
		return "mypage";  //mypage.jsp
	}
	
	
	
	
	
	
}





