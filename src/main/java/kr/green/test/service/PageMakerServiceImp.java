package kr.green.test.service;

import org.springframework.stereotype.Service;

import kr.green.test.pagination.Criteria;
import kr.green.test.pagination.PageMaker;

@Service
public class PageMakerServiceImp implements PageMakerService {

	/*
	 * 페이지네이션에서는 
	 * 현재페이지 (criteria)
	 * 페이지네이션의 페이지 갯수 (displayPageNum)
	 * 총 게시글 수(totalCount)가 중요한데 totalCount를 맨 마지막에 써야함 앞에 두개가 있어야 총 게시글 수를 알수 있으니까 
	 * */
	@Override
	public PageMaker getPageMaker(int displayPageNum, Criteria cri, int totalCount) {
		PageMaker pm = new PageMaker();
		pm.setDisplayPageNum(displayPageNum);
		pm.setCriteria(cri);
		pm.setTotalCount(totalCount);
		
		return pm;
	}

}
