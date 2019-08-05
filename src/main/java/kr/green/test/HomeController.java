package kr.green.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value= "/",method=RequestMethod.GET)
	public ModelAndView mainGet(ModelAndView mv) throws Exception{
//		MemberVO mVo = memberService.getMember("aaa123123");
//		System.out.println(mVo); //db와 연동이 잘 되었는지 체크 
		
	    mv.setViewName("/main/home");
	    mv.addObject("setHeader", "타일즈");
	    return mv;
	}
	@RequestMapping(value= "/",method=RequestMethod.POST)
	public String mainPost(MemberVO loginInfo) throws Exception{
		MemberVO user = memberService.signin(loginInfo);
		System.out.println(user);
	    return "redirect:/";
	}
	
	
}
