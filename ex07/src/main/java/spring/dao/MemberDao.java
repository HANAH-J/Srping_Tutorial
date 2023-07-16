package spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import spring.vo.Member;

public class MemberDao {
//	private static long nextId = 0;
//	private Map<String, Member> map = new HashMap<>();
	
	// 쿼리를 실행시킬 때 필요한 정보
	// => 연결 객체, 쿼리, 결과를 받아줄 리스트
	
	// 스프링에서는 jdbcTemplate 이라는 객체를 이용해서 DB 연결을 제어
	// select => jdbcTemplate.query('쿼리', 매핑규칙, 데이터1, 데이터2, ...);
	//		  => jdbcTemplate.query('쿼리', 매핑규칙, 데이터1, 데이터2, ...);
	// 그 외	  => jdbcTemplate.update('미완성 쿼리를 완성시켜주는 객체 : PreparedStatementCreator로 만든 객체');
	// 		  => jdbcTemplate.update('쿼리', 데이터1, 데이터2, ... );
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(Member member) {
		// 시퀀스의 값을 알아오는 방법 : KeyHolder
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		String sql = "INSERT INTO members "
				+ " VALUES(members_seq.nextval,?,?,?,?)";
		
		// jdbcTemplate.update(PreparedStatementCreator를 구현한 객체);
		int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
									  // 미완성 쿼리를 수동으로 완성시켜주는 객체
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement psmt = con.prepareStatement(sql, new String[] {"id"});
				psmt.setString(1, member.getEmail());
				psmt.setString(2, member.getPassword());
				psmt.setString(3, member.getName());
				psmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				
				return psmt;
			}
		}, keyHolder);
		
		Number keyNum = keyHolder.getKey();
		System.out.println("넣게 될 시퀀스값 : " + keyNum.longValue());
		
		System.out.println("INSERT로 삽입된 데이터의 개수 : " + cnt);
	}
	
	public void update(Member member) {
		int cnt = jdbcTemplate.update(
				"UPDATE members SET name=?, password=? WHERE email=?", 
				member.getName(),
				member.getPassword(),
				member.getEmail());
		
		System.out.println("UPDATE로 변경된 데이터의 개수 : " + cnt);
	}
	
	public Collection<Member> selectAll() {
		String sql = "SELECT * FROM members ORDER BY id ASC";
		 											// 매개값으로 쿼리와 매핑 규칙(인터페이스(RowMapper)로부터 구현받은 객체)
													// jdbcTemplate.query(sql,);
		// 방법 1. 인터페이스를 구현한 객체를 직접 만드는 방법
		// List<Member> list = jdbcTemplate.query(sql, new MapperSqlToMember());
		
		// 방법 2. 익명구현객체
//		List<Member> list = jdbcTemplate.query(sql, new RowMapper<Member>() {
//			
//			@Override
//			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Member member = new Member(
//						rs.getString("email"),
//						rs.getString("password"),
//						rs.getString("name"),
//						rs.getTimestamp("registDate"));
//				member.setId(rs.getLong("id"));
//				
//				return member;
//			}
//		});
		
		// 방법 3. 람다식
		List<Member> list = jdbcTemplate.query(sql, (rs, rowNum)->{
									Member member = new Member(
											rs.getString("email"),
											rs.getString("password"),
											rs.getString("name"),
											rs.getTimestamp("registDate"));
									member.setId(rs.getLong("id"));
									
									return member;
								});
				
		return list;
	}
	
	class MapperSqlToMember implements RowMapper<Member>{

		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member member = new Member(
					rs.getString("email"),
					rs.getString("password"),
					rs.getString("name"),
					rs.getTimestamp("registDate"));
			member.setId(rs.getLong("id"));
			
			return member;
		}
	}
	
	public Member selectByEmail(String email) {
		List<Member> list = jdbcTemplate.query(
				"SELECT * FROM members WHERE email=?",
				new RowMapper<Member>(){
					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(
								rs.getString("email"),
								rs.getString("password"),
								rs.getString("name"),
								rs.getTimestamp("registerDate"));
						member.setId(rs.getLong("id"));
						return member;
					}	
				},
				email);
		return list.isEmpty()?null:list.get(0); 
	}
	
	// 어차피 결과가 반드시 하나인 경우
	public int count() {
		Integer cnt = jdbcTemplate.queryForObject("SELECT count(*) FROM members", Integer.class);
		
		return cnt;
	}
}