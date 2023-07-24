package org.doit.ik.mapper;

import java.util.List;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;

public interface BoardMapper {

	List<BoardVO> getList();
	void insert(BoardVO board);
	BoardVO read(Long bno);
	void insertSelectKey(BoardVO board);
	int delete(Long bno);
	int update(BoardVO board);
	
	
	
	//체이징 처리 추상 메서드 추가
	//현재페이지번호, 한페이지 출력할 수 
	List<BoardVO> getListWithPaging(Criteria criteria);
	int getTotalCount(Criteria criteria);
}


//페이징 처리 추상메서드 추가 현재페이지번호, 한페이지 출력할 수  -->Criteria클래스 선언
