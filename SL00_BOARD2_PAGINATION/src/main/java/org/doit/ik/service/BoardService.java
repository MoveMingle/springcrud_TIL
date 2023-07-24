package org.doit.ik.service;

import java.util.List;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;

public interface BoardService {
	
	List<BoardVO> getList();
	void register(BoardVO boardVO);
	BoardVO get(Long bno);
	boolean remove(Long bno);
	boolean modify(BoardVO board);

	
	
		//페이징처리
	List<BoardVO> getListWithPage(Criteria criteria); //표준 규범
	int getTotal(Criteria criteria);//페이징처리 하기 위해선, 클래스로 받는다.
}
