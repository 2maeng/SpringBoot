package com.kim.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InterfaceMemberDAO {

	MemberDTO selectOne(Map<String, String> map);
	List<MemberDTO> selectAll(MemberDTO mDTO);
	
	boolean insert(Map<String, String> map);
	boolean update(Map<String, String> map);
	boolean delete(String id);
	
}
