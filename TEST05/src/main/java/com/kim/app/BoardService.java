package com.kim.app;

import java.util.List;

public interface BoardService {
	public BoardDTO selectOne(BoardDTO bDTO);
	public List<BoardDTO> selectAll(BoardDTO bDTO);
	
	public boolean insert(BoardDTO bDTO);
	public boolean update(BoardDTO bDTO);
	public boolean delete(BoardDTO bDTO);
}
