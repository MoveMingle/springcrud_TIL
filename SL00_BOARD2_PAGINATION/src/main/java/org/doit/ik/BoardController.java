package org.doit.ik;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;
import org.doit.ik.domain.PageDTO;
import org.doit.ik.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@RequestMapping("/board/*")
@Controller
@AllArgsConstructor
public class BoardController {
	private BoardService boardService;

	
	
	/*페이징 xxx
	 * //컨트롤러 메서드
	 * 
	 * @GetMapping("/list") public void list(Model model) {
	 * log.info(">/borard/list get..");
	 * model.addAttribute("list",this.boardService.getList()); }
	 * 
	 */
	
	//페이징 ㅇㅇ 컨트롤러 메서드 
	@GetMapping("/list")
	public void list(Criteria criteria, Model model) {
		log.info(">/borard/list get..");
		model.addAttribute("list",this.boardService.getListWithPage(criteria));
		int total = this.boardService.getTotal(criteria);
	//<1[2]345> -> pageDTO 클래스 선언 
		model.addAttribute("pageMaker",new PageDTO(criteria,total));
	}
	
	
	
	@GetMapping("/register")
	public void register() {
		log.info(">/borard/register get..");
	
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr/*HttpSession*/) {//일회성 속성값
		log.info(">/borard/rester get..");
	this.boardService.register(board);
	// board.getBno()
	rttr.addFlashAttribute("result",board.getBno());
	return "redirect:/board/list";
	}
	
	//board/get?bno=5
	//board/modify?bno
	//board/get?pageNum=2&amount=5&bno=2

	 	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno")Long bno
			,@ModelAttribute("criteria")Criteria criteria	
			,Model model) {
			log.info(">/board/get or /modify get..");
			model.addAttribute("board",this.boardService.get(bno));
			//model.addAttribute("criteria",criteria);
	 	}
	

	 	 @GetMapping("/remove")
	     
	     public String remove(@RequestParam("bno") Long bno,RedirectAttributes rttr) {
	 		log.info(">/borard/rester delete.."+bno);
	 		if(this.boardService.remove(bno)) {
	 			rttr.addFlashAttribute("result","success");
	 			
	 			
	 		}
	 		return "redirect:/board/list";
		
	     }

	 	@PostMapping("/modify")
		public String modify(BoardVO board, RedirectAttributes rttr/*HttpSession*/) {//일회성 속성값
			log.info(">/borard/rester post..");
		
			if(this.boardService.modify(board)){
				
	 			rttr.addFlashAttribute("result","success");

			};
		// board.getBno()
		return "redirect:/board/list";
		}
	 	 
}
