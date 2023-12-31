package com.kim.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements InterfaceMemberService {

	@Autowired
	private InterfaceMemberDAO mDAO;

	@Override
	public MemberDTO selectOne(MemberDTO mDTO) {
		Map<String, String> map = new HashMap<String, String>();

		map.put("data1", mDTO.getId());
		map.put("data2", mDTO.getPw());
		map.put("searchCondition", mDTO.getSearchCondition());

		return mDAO.selectOne(map);
	}

	@Override
	public List<MemberDTO> selectAll(MemberDTO mDTO) {
		return mDAO.selectAll(mDTO);
	}

	@Override
	public boolean insert(MemberDTO mDTO) {
		Map<String, String> map = new HashMap<String, String>();

		map.put("data1", mDTO.getId());
		map.put("data2", mDTO.getPw());

		return mDAO.insert(map);
	}

	@Override
	public boolean update(MemberDTO mDTO) {
		Map<String, String> map = new HashMap<String, String>();

		map.put("data1", mDTO.getPw());
		map.put("data2", mDTO.getId());

		return mDAO.update(map);
	}

	@Override
	public boolean delete(MemberDTO mDTO) {
		return mDAO.delete(mDTO.getId());
	}

}
