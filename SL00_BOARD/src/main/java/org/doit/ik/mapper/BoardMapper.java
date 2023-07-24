package org.doit.ik.mapper;

import java.util.List;

import org.doit.ik.domain.BoardVO;

public interface BoardMapper {

	
	List<BoardVO> getList();
	void insert(BoardVO board);
	BoardVO read(Long bno);
	void insertSelectKey(BoardVO board);
	
	int delete(Long bno);
	

	int update(BoardVO board);

}
