package kr.green.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.BoardService;
import kr.green.test.service.MemberService;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.MemberVO;


@Controller
public class BoardController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	//게시판리스트
	@RequestMapping(value= "/board/list",method=RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv) throws Exception{
		ArrayList<BoardVO> list = boardService.getBoardList();
	    mv.setViewName("/board/list");
	    mv.addObject("list",list);
	    return mv;
	}
	
}
