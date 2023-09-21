package com.kim.app;

import java.util.List;

public interface MemberService {
	public MemberDTO selectOne(MemberDTO mDTO);
	public List<MemberDTO> selectAll(MemberDTO mDTO);
	
	public boolean insert(MemberDTO mDTO);
	public boolean update(MemberDTO mDTO);
	public boolean delete(MemberDTO mDTO);
}
