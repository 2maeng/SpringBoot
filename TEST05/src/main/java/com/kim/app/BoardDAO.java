package com.kim.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 응집도를 높여줌
		// 자바문에서 대문자가 보이면 상수값 OR 쿼리문
		private final String SELECTALL = "SELECT * FROM BOARD";
		private final String SELECTONE = "SELECT NUM, MID, CONTENT FROM BOARD WHERE NUM = ?";
		private final String INSERT = "INSERT INTO BOARD (MID, CONTENT) VALUES (?, ?)";
		private final String UPDATE = "UPDATE BOARD SET CONTENT = ? WHERE NUM = ?";
		private final String DLEELTE = "DELETE FROM BOARD WHERE NUM = ?";
		
		public List<BoardDTO> selectAll(BoardDTO bDTO) {
			return jdbcTemplate.query(SELECTALL, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
		}
		
		public BoardDTO selectOne(BoardDTO bDTO) {
			Object[] args = { bDTO.getNum() };
			return jdbcTemplate.queryForObject(SELECTONE, args, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
		}
		
		public boolean insert(BoardDTO bDTO) {
			int result = jdbcTemplate.update(INSERT, bDTO.getMid(), bDTO.getContent());
			
			if(result <= 0) {
				return false;
			}
			return true;
		}
		
		public boolean update(BoardDTO bDTO) {
			int result = jdbcTemplate.update(UPDATE, bDTO.getContent(), bDTO.getNum());
			
			if(result <= 0) {
				return false;
			}
			
			return true;
		}
		
		public boolean delete(BoardDTO bDTO) {
			int result = jdbcTemplate.update(DLEELTE, bDTO.getNum());
			
			if(result <= 0) {
				return false;
			}
			
			return true;
		}
	
}
