package com.pcc.board.qna.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.ClosedByInterruptException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.pcc.member.db.MemberDAO;


// 게시판 관련 모든 메서드를 생성하는 클래스

public class QnADAO {

	private Connection con = null;
	private String sql ="";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	
	public QnADAO () {
		System.out.println("DAO : DB 연결을 위한 모든 정보 준비 완료");
	}
	
	// 0. alert창 -----------------------------------------
	public void alert(HttpServletResponse response, String msg, String path) {
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('"+msg+"');");
			out.println(path);
			out.println("</script>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// 1. CP를 이용한 DB 연결 -----------------------------------------
	private Connection getConnect() {
		try {
			// 1-1. 프로젝트 정보 초기화
			Context initCTX = new InitialContext();
			System.out.println("프로젝트 정보 초기화 완료");
			// 1-2. 초기화된 프로젝트 중 데이터 관련 정보 불러오기
			DataSource ds = (DataSource) initCTX.lookup("java:comp/env/jdbc/cafe_pcc");
			System.out.println("초기화된 프로젝트 중 데이터 관련 정보 불러오기 완료");
			con = ds.getConnection();
			System.out.println("con 완료");
			
			System.out.println("DAO : DB 연결 완료");
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
	
	// 2. getConnect() 메서드의 역순으로 DB 연결 해제 ------------------
	
	private void closeDB() {
		try {
			if(rs != null)	rs.close();
			if(pstmt != null)  pstmt.close();
			if(con != null)  con.close();
			System.out.println("DAO : DB 자원(rs, pstmt, con) 해제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("DAO : DB 연결 해제");
	}
	
	
	// 3. 문의사항 글쓰기 메서드  -----------------------------------------
	
	public int QnAWrite (QnADTO dto) {
		int qna_num = 0;
		try {
			con = getConnect();
			sql = "select max(qna_num) from qna_boards";
			System.out.println(" select문 성공! ");
			
			pstmt = con.prepareStatement(sql);
			System.out.println(" pstmt 성공! ");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				qna_num = rs.getInt(1)+1;
			}
			System.out.println(" QnA_num : " + qna_num);
			
			sql = "insert into qna_boards (qna_num, qna_writer_type, mem_num, name, qna_password, "
					+ "qna_subject, qna_content, qna_readcount, qna_re_ref, qna_re_lev, qna_re_seq, "
					+ "qna_date, qna_ip, qna_file) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,now(),?,?) ";
			System.out.println("SQL 완료");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			pstmt.setInt(2, 2); // 회원은 타입 2
			pstmt.setInt(3, dto.getMem_num());
			pstmt.setString(4, dto.getName());
			if(dto.getMem_num() != 0) {
				pstmt.setInt(5, dto.getQna_password());
			} else if(dto.getMgr_num() != 0) {
				pstmt.setInt(5, 9090);
			}
			pstmt.setString(6, dto.getQna_subject());
			pstmt.setString(7, dto.getQna_content());
//			System.out.println(" content 완료 ");
			pstmt.setInt(8, dto.getQna_readcount());
//			System.out.println(" readcount 완료 ");
			
			pstmt.setInt(9, dto.getQna_re_ref());
			pstmt.setInt(10, dto.getQna_re_lev());
			pstmt.setInt(11, dto.getQna_re_seq());
			
			pstmt.setString(12, dto.getQna_ip());
			pstmt.setString(13, dto.getQna_file());
			
			pstmt.executeUpdate();
			
			System.out.println(" sql 구문 실행 완료 ");
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return qna_num;
	}
	
	// 회원번호로 개인정보를 불러오는 메서드

	public void getMemberInfo(HttpSession sessionID) {
		
		
//		try {
//			con = getConnect();
//			
//			sql = "select * from members where mem_num =?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, sessionID);
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
		

	}
	

	// 4. 문의사항 목록 조회  -----------------------------------------
	
	// 글 전체 목록 조회 메서드 - getQnAList()
	
		public List<QnADTO> getQnAList() {
			
			List<QnADTO> qnaboardlist = new ArrayList<QnADTO>();
			
			try {
				con = getConnect();
				
				sql = "select * from qna_boards";
				
				pstmt = con.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					QnADTO dto = new QnADTO();
					
					dto.setQna_num(rs.getInt("qna_num"));
					dto.setQna_writer_type(rs.getInt("qna_writer_type"));
					dto.setMem_num(rs.getInt("mem_num"));
					dto.setQna_password(rs.getInt("qna_password"));
					dto.setQna_subject(rs.getString("qna_subject"));
					dto.setQna_content(rs.getString("qna_content"));
					dto.setQna_readcount(rs.getInt("qna_readcount"));
					dto.setQna_re_ref(rs.getInt("qna_re_ref"));
					dto.setQna_re_lev(rs.getInt("qna_re_lev"));
					dto.setQna_re_seq(rs.getInt("qna_re_seq"));
					dto.setQna_date(rs.getTimestamp("qna_date"));
					dto.setQna_ip(rs.getString("qna_ip"));
					dto.setQna_file(rs.getString("qna_file"));
					
					qnaboardlist.add(dto);
					
				} // while 
				
				System.out.println(" C : 게시판 목록 모두 저장 완료! ");
				System.out.println(" C : " + qnaboardlist);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeDB();
			}
			
			
			
			return qnaboardlist;
		}

		public List<QnADTO> getQnAList(int startRow, int pageSize) {
			
			List<QnADTO> qnaboardlist = new ArrayList<QnADTO>();
			
			try {
				con = getConnect();
				
				sql = "select * from qna_boards order by QnA_num desc limit ?,?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, startRow-1);
				pstmt.setInt(2, pageSize);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					QnADTO dto = new QnADTO();
					
					dto.setQna_num(rs.getInt("qna_num"));
					dto.setQna_writer_type(rs.getInt("qna_writer_type"));
					dto.setMem_num(rs.getInt("mem_num"));
					dto.setMgr_num(rs.getInt("mgr_num"));
					dto.setName(rs.getString("name"));
					dto.setQna_password(rs.getInt("qna_password"));
					dto.setQna_subject(rs.getString("qna_subject"));
					dto.setQna_content(rs.getString("qna_content"));
					dto.setQna_readcount(rs.getInt("qna_readcount"));
					dto.setQna_re_ref(rs.getInt("qna_re_ref"));
					dto.setQna_re_lev(rs.getInt("qna_re_lev"));
					dto.setQna_re_seq(rs.getInt("qna_re_seq"));
					dto.setQna_date(rs.getTimestamp("qna_date"));
					dto.setQna_ip(rs.getString("qna_ip"));
					dto.setQna_file(rs.getString("qna_file"));
					
					qnaboardlist.add(dto);
					
				} // while 				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeDB();
			}

			return qnaboardlist;
		}
	
	// 5. 조회수 증가 메서드  -----------------------------------------
	
	
		
		public int getQnACount() {
			System.out.println( " \n DAO : getQnACount() 메서드 실행 ");
			int cnt = 0;
			
			try {
				con = getConnect();
				
				sql = "select count(*) from qna_boards";
				
				pstmt = con.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					cnt = rs.getInt(1);
				}
				
				System.out.println(" DAO : 글 개수 - 총 : " + cnt + "개 입니다.");
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeDB();
			}
			return cnt;
		}
	
	
	
	// 6. 조회수 올리는 메서드  -----------------------------------------
	
	public QnADTO getQnAContent (int qna_num) {
		System.out.println( "DAO : getQnAContent() 메서드 실행" );
		
		QnADTO dto = null;
		
		try {
			con = getConnect();
			
			sql = "select * from qna_boards where qna_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			
			//pstmt.executeQuery();
			rs = pstmt.executeQuery();

			if(rs.next()) {
				
				dto = new QnADTO();
				
				dto.setQna_num(rs.getInt("qna_num"));
				dto.setQna_writer_type(rs.getInt("qna_writer_type"));
				dto.setMem_num(rs.getInt("mem_num"));
				dto.setName(rs.getString("name"));
				dto.setQna_password(rs.getInt("qna_password"));
				dto.setQna_subject(rs.getString("qna_subject"));
				dto.setQna_content(rs.getString("qna_content"));
				dto.setQna_readcount(rs.getInt("qna_readcount"));
				dto.setQna_re_ref(rs.getInt("qna_re_ref"));
				dto.setQna_re_lev(rs.getInt("qna_re_lev"));
				dto.setQna_re_seq(rs.getInt("qna_re_seq"));
				dto.setQna_date(rs.getTimestamp("qna_date"));
				dto.setQna_ip(rs.getString("qna_ip"));
				dto.setQna_file(rs.getString("qna_file"));

				System.out.println(qna_num+"의 dto: "+dto);
				System.out.println("QnA DB 저장 완료!");
			}
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return dto;
		
	}		
		

	public int getQnAReadCount(int qna_num) {
		
	
		int cnt = 0;
		try {
			
			con = getConnect();
			sql = "select QnA_readcount from qna_boards where QnA_num=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return cnt = rs.getInt(1)+1;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return cnt;
	}

	public void updateReadCount(int qna_num) {
		
		try {
			con = getConnect();
			sql = "update qna_boards set QnA_readcount=QnA_readcount+1 "
					+ "where QnA_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		
		
	}

	
		
	// 7. 문의사항 글 수정을 위한 DB 정보 호출 메서드  -----------------------------------------
	
	public QnADTO getQnAUpdateContent(int qna_num) {
		QnADTO dto = null;
		
		try {
			
			con = getConnect();
			
			sql = "select qna_subject, qna_content, qna_file from qna_boards "
					+ "where qna_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new QnADTO();
				dto.setQna_subject(rs.getString("qna_subject"));
				System.out.println(qna_num+"번 제목 가져오기 완료 ");
				dto.setQna_content(rs.getString("qna_content"));
				System.out.println(qna_num+"번 내용 가져오기 완료 ");
				dto.setQna_file(rs.getString("qna_file"));
				System.out.println(qna_num+"번 파일 가져오기 완료 ");
			}
			System.out.println(qna_num+"번 문의사항 저장 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		
		return dto;
	}
	
	// 8. 문의사항 글 수정 메서드  -----------------------------------------
			public QnADTO QnAUpdate(QnADTO dto, int qna_num) {
				System.out.println(" QnAUpdate() 호출 ");
				
				System.out.println("dto : " + dto + "=======================");
				
				try {
					con = getConnect();
					sql = "update qna_boards "
							+ "set qna_subject=?, qna_content=?, "
							+ "qna_file=? where qna_num=?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, dto.getQna_subject());
					pstmt.setString(2, dto.getQna_content());
					pstmt.setString(3, dto.getQna_file());
					pstmt.setInt(4, dto.getQna_num());
					System.out.println("qna_num : " + dto.getQna_num());
					System.out.println("dto : " + dto);
					
					pstmt.executeUpdate();
					
					System.out.println("DB에 공지사항 업데이트 완료");
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					closeDB();
				}
				return dto;
			}
	
	
	
	// 8. 문의사항 글 수정 메서드 (매니저)  -----------------------------------------

//	public QnADTO QnAUpdate(QnADTO dto) {
//		
//		System.out.println("QnAUpdate() 호출");
//		
//		try {
//			con = getConnect();
//			sql = "update qna_boards set qna_subject=?, qna_content=?, "
//					+ "qna_file=? where qna_num=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, dto.getQna_subject());
//			pstmt.setString(2, dto.getQna_content());
//			pstmt.setString(3, dto.getQna_file());
//			pstmt.setInt(4, dto.getQna_num());
//			
//			pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			closeDB();
//		}
//		
//		return dto;
//	}
		

	// 9. 문의사항 글 수정 메서드 (회원)  -----------------------------------------
		
//		public QnADTO QnAUpdate (QnADTO dto, int mem_num) {
//			
//			System.out.println("QnAUpdate() 호출");
//			
//			try {
//				con = getConnect();
//				sql = "update qna_boards set qna_subject=?, qna_content=?, "
//						+ "qna_file=?, where qna_num=?";
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, dto.getQna_subject());
//				pstmt.setString(2, dto.getQna_content());
//				pstmt.setString(3, dto.getQna_file());
//				pstmt.setInt(4, dto.getQna_num());
//				
//				pstmt.executeUpdate();
//						
//			} catch (Exception e) {
//				e.printStackTrace();
//			}finally {
//				closeDB();
//			}
//			return dto;
//		}
		
	// 10. 문의사항 글 삭제 메서드 (회원)   -----------------------------------------
		
		public void QnADelete(int qna_num, int mem_num) {
			System.out.println("QnADelete() 호출");
			try {
				con = getConnect();
				
				sql = "delete from qna_boards where qna_num=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, qna_num);
				
				pstmt.executeUpdate();
				System.out.println("회원용 글 삭제 완료");
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeDB();
			}
		}
	
	// 11. 특정 글 1개의 정보 조회   -----------------------------------------
	
	public QnADTO getQna(int qna_num) {
		System.out.println(" C: getQnA(qna_num) 호출");
		
		QnADTO dto = null;
		
		try {
			con = getConnect();
			
			sql = "select * from qna_boards where qna_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new QnADTO();
				
				dto.setQna_num(rs.getInt("qna_num"));
				dto.setQna_writer_type(rs.getInt("qna_writer_type"));
				dto.setMem_num(rs.getInt("mem_num"));
				dto.setQna_password(rs.getInt("qna_password"));
				dto.setQna_subject(rs.getString("qna_subject"));
				dto.setQna_content(rs.getString("qna_content"));
				dto.setQna_readcount(rs.getInt("qna_readcount"));
				dto.setQna_re_ref(rs.getInt("qna_re_ref"));
				dto.setQna_re_lev(rs.getInt("qna_re_lev"));
				dto.setQna_re_seq(rs.getInt("qna_re_seq"));
				dto.setQna_date(rs.getTimestamp("qna_date"));
				dto.setQna_ip(rs.getString("qna_ip"));
				dto.setQna_file(rs.getString("qna_file"));
				
			} //if
			
			System.out.println(" C : 게시글 " + qna_num + "번 정보 dto에 저장 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		
		return dto;
		
	}

	public void QnADelete(int qna_num) {
		try {
			con = getConnect();
			
			sql = "delete from qna_boards where qna_num=? and qna_password=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			
			pstmt.executeUpdate();
			System.out.println("회원용 글 삭제 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
	}

	public int qnaReply(int qna_num, QnADTO dto) {
		int qna_re_ref= qna_num;
		try {
			con = getConnect();
			
			sql = "select max(qna_num) from qna_boards";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				qna_num = rs.getInt(1)+1;
			}
			
			sql = "insert into qna_boards(qna_num, qna_writer_type, mgr_num, name, "
					+ "qna_password, qna_subject, qna_content, qna_readcount, qna_re_ref, qna_re_lev,"
					+ "qna_re_seq, qna_date, qna_ip, qna_file) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,now(),?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			pstmt.setInt(2, 1); // 1은 관리자, 2는 회원
			pstmt.setInt(3, dto.getMgr_num());
			pstmt.setString(4,  "관리자");
			pstmt.setInt(5, 9090);
//			System.out.println("글 제목:"+dto.getQna_subject());
			pstmt.setString(6, dto.getQna_subject());
			pstmt.setString(7, dto.getQna_content());
			pstmt.setInt(8, dto.getQna_readcount());
			pstmt.setInt(9, qna_re_ref);
			pstmt.setInt(10, dto.getQna_re_ref());
			pstmt.setInt(11, 1);
			pstmt.setString(12, dto.getQna_ip());
			pstmt.setString(13, dto.getQna_file());
			
			pstmt.executeUpdate();
			
			System.out.println(qna_re_ref+"번 글의 답글 작성 완료!");
			
			return qna_num;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return 0;
	}
	
	
	
	
	
	

}