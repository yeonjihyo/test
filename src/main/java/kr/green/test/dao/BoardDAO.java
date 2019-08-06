package kr.green.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVO;

public interface BoardDAO {
	public ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri,@Param("valid")String valid);//매개변수가 2개 이상일때 매퍼가 @Param("cri")없이보내면 인식을 못함 

	public int selectCountBoardList(@Param("cri")Criteria cri,@Param("valid")String valid);

	public void insertBoard(@Param("board")BoardVO board);

	public BoardVO selectBoard(@Param("num")Integer num);

	public void updateBoard(@Param("board")BoardVO board);
}
