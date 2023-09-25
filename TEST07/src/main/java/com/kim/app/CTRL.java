package com.kim.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CTRL {

	@Autowired
	private InterfaceBoardService boardService;
	
	@Autowired
	private InterfaceMemberService memberService;
	
	@RequestMapping("/")
	public String root(BoardDTO bDTO, Model model) {
		
		
		return "redirect:/main";
	}
	
	/////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/main")
	public String main(BoardDTO bDTO, Model model) {
		List<BoardDTO> bdatas = boardService.selectAll(bDTO);
		
		model.addAttribute("bdatas", bdatas);
		
		return "main";
	}
	/////////////////////////////////////////////////////////////////////////
	
	/////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/mypage/{id}")
	public String mypage(MemberDTO mDTO, Model model) {
		
		mDTO.setSearchCondition("mypage");
		
		mDTO = memberService.selectOne(mDTO);
		
		model.addAttribute("mdata", mDTO);
		
		return "mypage";
	}
	
	@RequestMapping(value = "/signupPage")
	public String signupPage() {
		return "signupPage";
	}
	
	@RequestMapping(value = "/signup")
	public String signup(MemberDTO mDTO, Model model) {
		
		mDTO.setSearchCondition("mypage");
		
		MemberDTO mdata = memberService.selectOne(mDTO);
		
		if(mdata == null) {
			memberService.insert(mDTO);
			
			return "redirect:/main";
		}
		else {
			return "redirect:/main";
		}
	}
	
	@RequestMapping(value = "/login")
	public String login(MemberDTO mDTO, HttpSession session, Model model) {
		
		mDTO.setSearchCondition("login");
		
		mDTO = memberService.selectOne(mDTO);
		
		if(mDTO != null) {
			session.setAttribute("id", mDTO.getId());
		}
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(MemberDTO mDTO, HttpSession session) {
		
		session.removeAttribute("id");
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/deleteMember/{id}")
	public String deleteMember(MemberDTO mDTO) {
		memberService.delete(mDTO);
		
		return "redirect:/logout";
	}
	
	@RequestMapping(value ="/updateMember")
	public String updateMember(MemberDTO mDTO) {
		memberService.update(mDTO);
		
		return "redirect:/logout";
	}
	/////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/insertBoard")
	public String insertBoard(BoardDTO bDTO, Model model) {
		
		boardService.insert(bDTO);
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/board/{num}")
	public String board(MemberDTO mDTO, BoardDTO bDTO, Model model) {
		
		bDTO = boardService.selectOne(bDTO);
		
		model.addAttribute("bdata", bDTO);
		
		return "board";
	}
	
	@RequestMapping(value = "/updateBoard/{num}")
	public String updateBoard(BoardDTO bDTO, Model model) {
		boardService.update(bDTO);
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/deleteBoard/{num}")
	public String deleteBoard(BoardDTO bDTO) {
		boardService.delete(bDTO);
		
		return "redirect:/main";
	}
	
}
