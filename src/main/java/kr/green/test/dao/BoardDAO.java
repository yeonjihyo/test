package kr.green.test.dao;

import java.util.ArrayList;

import kr.green.test.vo.BoardVO;

public interface BoardDAO {
	public ArrayList<BoardVO> selectBoardList();
}