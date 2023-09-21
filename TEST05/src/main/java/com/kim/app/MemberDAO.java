package com.kim.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 응집도를 높여줌
	// 자바문에서 대문자가 보이면 상수값 OR 쿼리문
	private final String SELECTALL = "SELECT * FROM MEMBER";
	private final String SELECTONE_LOGIN = "SELECT ID, PW FROM MEMBER WHERE ID = ? AND PW = ?";
	private final String SELECTONE_MYPAGE = "SELECT ID FROM MEMBER WHERE ID = ?";
	private final String INSERT = "INSERT INTO MEMBER (ID, PW) VALUES (?, ?)";
	private final String UPDATE = "UPDATE MEMBER SET PW = ? WHERE ID = ?";
	private final String DLEELTE = "DELETE FROM MEMBER WHERE ID = ?";
	
	public List<MemberDTO> selectAll(MemberDTO mDTO) {
		return jdbcTemplate.query(SELECTALL, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}
	
	public MemberDTO selectOne(MemberDTO mDTO) {
		
		try {
			if(mDTO.getSearchCondition() == null) {
				System.out.println("memberDAO2 selectOne 서치컨디션 null");
			}
			else if (mDTO.getSearchCondition().equals("login")) {
				Object[] args = { mDTO.getId(), mDTO.getPw() };
				return jdbcTemplate.queryForObject(SELECTONE_LOGIN, args, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
			}
			else if (mDTO.getSearchCondition().equals("mypage")) {
				Object[] args = { mDTO.getId() };
				return jdbcTemplate.queryForObject(SELECTONE_MYPAGE, args, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
			}
		}
		catch(EmptyResultDataAccessException e) {
			System.out.println("memberDAO2 selectOne 데이터가 비어있음");
			return null;
		}
		return null;
	}
	
	public boolean insert(MemberDTO mDTO) {
		int result = jdbcTemplate.update(INSERT, mDTO.getId(), mDTO.getPw());
		
		if(result <= 0) {
			return false;
		}
		return true;
	}
	
	public boolean update(MemberDTO mDTO) {
		int result = jdbcTemplate.update(UPDATE, mDTO.getPw(), mDTO.getId());
		
		if(result <= 0) {
			return false;
		}
		
		return true;
	}
	
	public boolean delete(MemberDTO mDTO) {
		int result = jdbcTemplate.update(DLEELTE, mDTO.getId());
		
		if(result <= 0) {
			return false;
		}
		
		return true;
	}
}
