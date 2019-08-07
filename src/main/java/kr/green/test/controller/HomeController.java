package kr.green.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//로그인
	@RequestMapping(value= "/",method=RequestMethod.GET)
	public ModelAndView mainGet(ModelAndView mv) throws Exception{
//		MemberVO mVo = memberService.getMember("aaa123123");
//		System.out.println(mVo); //db와 연동이 잘 되었는지 체크 
		
	    mv.setViewName("/main/home");//타일즈와 연결이 되어있는애임 
	    return mv;
	}
	@RequestMapping(value= "/",method=RequestMethod.POST)
	public String mainPost(MemberVO loginInfo,Model model) throws Exception{
		MemberVO user = memberService.signin(loginInfo);
		System.out.println(user);//비밀번호 암호화후에 로그인 테스트
		model.addAttribute("user",user);
	    return "redirect:/";
	}
	//로그아웃
	@RequestMapping(value= "/signout",method=RequestMethod.GET)
	public String signoutGet(HttpServletRequest r) throws Exception{
		r.getSession().removeAttribute("user");
	    return "redirect:/";
	}
	//회원가입
	@RequestMapping(value= "/signup",method=RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) throws Exception{
		
	    mv.setViewName("/member/signup");//타일즈와 연결이 되어있는애임 (tiles-def.xml에 경로가 2개니까 폴더명/jsp로 써야함)
	    return mv;
	}
	@RequestMapping(value ="/dup")
	@ResponseBody
	public boolean idcheck(@RequestBody String id){
		//map 여러개의데이터를한번에보낼때사용
		//그외에는 내가원하는 자료형 넣어주면 됨
		boolean isMember = memberService.getMember(id) != null; //id를 통해 일치하는 회원정보를 가져와서 회원정보가 null이 아니면 true 아니면 false 
	     return isMember;
	     //return memberService.getMember(id) != null; 와 같음
	}
}
