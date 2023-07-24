package org.doit.ik.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/customer/*")
public class CustomerController {

	@Autowired //자동주입하겠다
	private NoticeDao noticeDao;

	@PostMapping("/noticeEdit.htm")
	public String noticeDetail(
			NoticeVO notice) throws Exception {
		int updateCount = this.noticeDao.update(notice);
		if (updateCount==1) {
			return "redirect:noticeDetail.htm?seq="+ notice.getSeq();
		} else {
			return "redirect:notice.htm";
		}
	}
	
	//?seq=1
	@GetMapping("/noticeEdit.htm")
	public String noticeEdit(
			@RequestParam("seq") String seq
			, Model model) throws Exception{
		NoticeVO notice = this.noticeDao.getNotice(seq);
		model.addAttribute("notice", notice);
		return "noticeEdit.jsp";
	}
	
	
	//p358 컨트롤러 메서드 파라미터 중의( 커멘드객체를 사용하는 예시)
	//@RequestMapping(value = "/noticeReg.htm", method = RequestMethod.POST)
	@PostMapping("/noticeReg.htm")
	public String noticeReg( NoticeVO notice ) throws Exception{
		//로그인 인증 - 세션
		notice.setWriter("jieun");//이런식으로 로그인한 세션값을 받아와서 이렇게 처리하면 됨
		
		
		int insertCount = this.noticeDao.insert(notice);
		if (insertCount ==1) {
			return "redirect:notice.htm";
		} else {
			return "noticeReg.jsp?error";
		}
		
	}
	
	//notice.jsp 에서 링크 태그[글쓰기] 버튼을 클릭
	//@RequestMapping(value = "/noticeReg.htm", method = RequestMethod.GET)
	@GetMapping("/noticeReg.htm")
	public String noticeReg() throws Exception {
		return "noticeReg.jsp";
	}

	
	@GetMapping("/noticeDetail.htm")
	public String noticeDetail(
			@RequestParam("seq") String seq
			, Model model
			) throws Exception {

		NoticeVO notice = this.noticeDao.getNotice(seq);
		model.addAttribute("notice", notice);
		

		return "noticeDetail.jsp";
	}
	

	@GetMapping("/notice.htm")
	public String notices(
			@RequestParam(value = "page", defaultValue="1") int page,
			@RequestParam(value = "field", defaultValue="title") String field,
			@RequestParam(value = "query", defaultValue="") String query
			, Model model) throws Exception {
		model.addAttribute("message", "hello world"); 
		List<NoticeVO> list = this.noticeDao.getNotices(page, field, query);
		model.addAttribute("list", list);
		return "notice.jsp";
	}
	/*
	//"컨트롤러 메서드"
	//@RequestMapping(value = {"/customer/notice.htm"}) //어떤요청이 들어오면 얘가 실행이 됩니까? 라는 요청이다.
	//@RequestMapping("/customer/notice.htm")
	@GetMapping("/customer/notice.htm") //위에 2개도 모두 이거와 같은 방식이다. 
	public ModelAndView notices(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {

		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "hello world"); //message안에 hello world를 넣겠다.
		//?page=2&field=title&query=홍길동
		String ppage = request.getParameter("page");
		String pfield = request.getParameter("field");
		String pquery = request.getParameter("query");

		int page=1;
		String field="title";
		String query = "";

		if( ppage !=null && !ppage.equals("")) { page = Integer.parseInt(ppage);}
		if( pfield !=null && !pfield.equals("")) { field = pfield; }
		if( pquery !=null && !pquery.equals("")) { query=pquery;}

		List<NoticeVO> list = this.noticeDao.getNotices(page, field, query);

		mav.addObject("list", list);

		mav.setViewName("notice.jsp");

		return mav;
	}
	 */


}


