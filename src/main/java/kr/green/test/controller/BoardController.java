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

import kr.green.test.pagination.Criteria;
import kr.green.test.pagination.PageMaker;
import kr.green.test.service.BoardService;
import kr.green.test.service.MemberService;
import kr.green.test.service.PageMakerService;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.MemberVO;


@Controller
public class BoardController {
	
	
	@Autowired
	BoardService boardService;
	@Autowired
	PageMakerService pageMakerService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	//게시판리스트
	@RequestMapping(value= "/board/list",method=RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv, Criteria cri){
		String valid="I";
		int displayPageNum=2;
		ArrayList<BoardVO> list = boardService.getBoardList(cri,valid);
		int totalCount = boardService.getTotalCount(cri,valid);
		System.out.println(totalCount);
		PageMaker pm = pageMakerService.getPageMaker(displayPageNum,cri,totalCount); 
		System.out.println(pm);
	    mv.setViewName("/board/list");
	    mv.addObject("list",list);
	    mv.addObject("pageMaker",pm);
	    return mv;
	}
	//게시글 등록
	@RequestMapping(value= "/board/register",method=RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv){
		
	    mv.setViewName("/board/register");
	    return mv;
	}
	@RequestMapping(value= "/board/register",method=RequestMethod.POST)
	public String boardRegisterPost(BoardVO bVo){
		//System.out.println(bVo);
		boardService.registerBoard(bVo);
	    return "redirect:/board/list";
	}
	//게시글 상세
	@RequestMapping(value= "/board/display",method=RequestMethod.GET)
	public ModelAndView boardDisplayGet(ModelAndView mv,Integer num, Criteria cri){
		BoardVO board=boardService.getBoard(num);
	    mv.setViewName("/board/display");
	    mv.addObject("board",board);
	    mv.addObject("cri",cri);
	    return mv;
	}
	//게시글 수정
	@RequestMapping(value= "/board/modify",method=RequestMethod.GET)
	public ModelAndView boardModifyPost(ModelAndView mv,Integer num, Criteria cri,HttpServletRequest r){
		boolean isWriter = boardService.isWriter(num,r);
		BoardVO board=null;
		if(isWriter) {
			board=boardService.getBoard(num);
			mv.setViewName("/board/modify");
		}else {
			mv.setViewName("redirect:/board/list");
		}
		
	    mv.addObject("board",board);
	    mv.addObject("cri",cri);
	    return mv;
	}
	@RequestMapping(value= "/board/modify",method=RequestMethod.POST)
	public String boardModifyPost(BoardVO bVo,HttpServletRequest r){
		//System.out.println(bVo);
		if(boardService.isWriter(bVo.getNum(),r)){
			boardService.modifyBoard(bVo);
		}
	    return "redirect:/board/list";
	}
	//
	@RequestMapping(value= "/board/delete",method=RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv,Integer num,HttpServletRequest r){
		if(boardService.isWriter(num, r)) {
			boardService.deleteBoard(num);
		}
	    mv.setViewName("redirect:/board/list");
	    return mv;
	}
}
