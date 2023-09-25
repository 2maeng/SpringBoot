package com.kim.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InterfaceBoardDAO {

	BoardDTO selectOne(int num); // #{param1}
	List<BoardDTO> selectAll(BoardDTO bDTO);
	
	boolean insert(Map<String, String> map);
	boolean update(Map<String, String> map);
	boolean delete(@Param("NUM")int num); // #{NUM}
}
