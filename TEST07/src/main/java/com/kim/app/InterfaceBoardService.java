package com.kim.app;

import java.util.List;

public interface InterfaceBoardService {
	BoardDTO selectOne(BoardDTO bDTO);
	List<BoardDTO> selectAll(BoardDTO bDTO);
	
	boolean insert(BoardDTO bDTO);
	boolean update(BoardDTO bDTO);
	boolean delete(BoardDTO bDTO);
}
