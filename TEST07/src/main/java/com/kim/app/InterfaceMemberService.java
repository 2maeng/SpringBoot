package com.kim.app;

import java.util.List;

public interface InterfaceMemberService {
	MemberDTO selectOne(MemberDTO mDTO);
	List<MemberDTO> selectAll(MemberDTO mDTO);
	
	boolean insert(MemberDTO mDTO);
	boolean update(MemberDTO mDTO);
	boolean delete(MemberDTO mDTO);
}
