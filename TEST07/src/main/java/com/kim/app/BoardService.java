package com.kim.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService implements InterfaceBoardService{

	@Autowired
	private InterfaceBoardDAO bDAO;

	@Override
	public BoardDTO selectOne(BoardDTO bDTO) {
		return bDAO.selectOne(bDTO.getNum());
	}

	@Override
	public List<BoardDTO> selectAll(BoardDTO bDTO) {
		return bDAO.selectAll(bDTO);
	}

	@Override
	public boolean insert(BoardDTO bDTO) {
		Map<String, String> map = new HashMap<String, String>();

		map.put("data1", bDTO.getMid());
		map.put("data2", bDTO.getContent());

		return bDAO.insert(map);
	}

	@Override
	public boolean update(BoardDTO bDTO) {
		Map<String, String> map = new HashMap<String, String>();

		map.put("data1", bDTO.getContent());
		map.put("data2", Integer.toString(bDTO.getNum()));
		
		return bDAO.update(map);
	}

	@Override
	public boolean delete(BoardDTO bDTO) {
		return bDAO.delete(bDTO.getNum());
	}
}
