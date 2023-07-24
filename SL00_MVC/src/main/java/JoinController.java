package org.doit.ik.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.doit.ik.domain.MemberVO;
import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.MemberDao;
import org.doit.ik.persistence.MemberDaoImpl;
import org.doit.ik.persistence.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.NoArgsConstructor;

@Controller
@RequestMapping("/joinus/*")
@NoArgsConstructor
public class JoinController {
	
	@Autowired
	private MemberDao memberDao; 
	
	@GetMapping("/login.htm")
	public String login() throws Exception{
		return "login.jsp";
	}
	
	@GetMapping("/join.htm")
	public String join() throws Exception{
		return "join.jsp";
	}
	
	// 문제) 회원가입 -> home 으로 이동
	@PostMapping("/join.htm")
	public String join( MemberVO member  ) throws Exception{
		 
		 this.memberDao.insert(member);
        return "redirect:../index.htm";

	}
	
	/*
	[1]
	@RequestMapping( value= {"join.htm"}, method = RequestMethod.POST )
	public String join( Member member , String year, String month, String day ) throws Exception{
		
		String birth =  String.format("%s-%s-%d", year, month, day);
		member.setBirth(birth);
		
		this.memberDao.insert(member);
         return "redirect:../index.htm";

	}
	*/
	
	

} // class
