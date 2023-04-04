package edu.global.board.dao; //기능은 패키지 별로 만들어서 저장

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.global.vo.BoardVO;

public class BDao {

	private DataSource dataSource;

	public BDao() {
		try {
			Context context = new InitialContext(); // Context = Context.xml의 세팅된 것 들을 가져오는 객체
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); // oracle부분은 context.xml의 name(이름)이랑
																					// 동일하게
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BoardVO> list() { /* DB에 저장된 모든 것을 가져온다 */
		List<BoardVO> board = new ArrayList<BoardVO>();

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement의 위 버전, 실무에서는 이것을 사용 */
		ResultSet rs = null; // DB테이블을 받아오는 문법

		try {
			con = dataSource.getConnection();
			String query = "select * from mvc_board order by bgroup desc, bstep asc"; // 먼저 원본글 댓글을 group으로 정렬, 그룹내 댓글을
																						// step으로 정렬

			preparedStatement = con.prepareStatement(query);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				System.out.println(bname);
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				BoardVO vo = new BoardVO(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				board.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return board;
	}

	public BoardVO contentView(String strID) { /* DB에 저장된 모든 것을 가져온다 */
		BoardVO board = null;

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement의 위 버전, 실무에서는 이것을 사용 */
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			String query = "select * from mvc_board where bid = ?";

			//쿼리문을 가져오는 방법은 Statement와 PrepareStatement랑 다른다. 기본적인 사용방법, 가지고있는 기능, 함수가 다르기 떄문에 외워라!
			preparedStatement = con.prepareStatement(query);//prepareStatement를 사용하면 ?기능을 사용할 수 있다.
			preparedStatement.setInt(1, Integer.valueOf(strID)); // 쿼리문 ?을 선언하면 preparedStatement의함수를 이용해서 내용을 담을 수 있다.
			
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				board = new BoardVO(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return board;
	}

	public int modify(String bid, String bname, String btitle, String bcontent) { /* DB에 저장된 모든 것을 가져온다 */

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement의 위 버전, 실무에서는 이것을 사용 */
		int rn = 0; // update delete할 때는 ResultSet을 불러올 필요 없음

		try {
			con = dataSource.getConnection();
			String query = "update mvc_board set bname = ?, btitle = ?, bcontent = ? where bid = ?";

			preparedStatement = con.prepareStatement(query);

			System.out.println(bid);
			System.out.println(bname);
			System.out.println(bcontent);
			System.out.println(btitle);

			preparedStatement.setString(1, bname); // 쿼리문 ?을 선언하면 preparedStatement의함수를 이용해서 내용을 담을 수 있다.
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);
			preparedStatement.setInt(4, Integer.valueOf(bid));

			rn = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return rn;
	}

	public int delete(String bid) { /* DB에 저장된 모든 것을 가져온다 */

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement의 위 버전, 실무에서는 이것을 사용 */

		int rn = 0;

		try {
			con = dataSource.getConnection();
			String query = "delete from mvc_board where bid = ?";

			preparedStatement = con.prepareStatement(query);

			System.out.println(bid);

			preparedStatement.setInt(1, Integer.valueOf(bid));

			rn = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return rn;
	}

	public int write(String bname, String btitle, String bcontent) { /* DB에 저장된 모든 것을 가져온다 */

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement의 위 버전, 실무에서는 이것을 사용 */

		int rn = 0;

		try {
			con = dataSource.getConnection();
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";

			preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, bname);
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);

			rn = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return rn;
	}

	public BoardVO reply_view(String strID) { /* DB에 저장된 모든 것을 가져온다 */
		BoardVO board = null;

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement의 위 버전, 실무에서는 이것을 사용 */
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			String query = "select * from mvc_board where bid = ?";

			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, Integer.valueOf(strID)); // 쿼리문 ?을 선언하면 preparedStatement의함수를 이용해서 내용을 담을 수 있다.
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				board = new BoardVO(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return board;
	}
	
	//새로운 댓글을 넣기위한 자리를 확보하는 함수(먼저 달린 댓글 밑으로 밀기!)
	public int replyShape(String strGroup, String strStep) { /* DB에 저장된 모든 것을 가져온다 */

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement의 위 버전, 실무에서는 이것을 사용 */

		int rn = 0;

		try {
			con = dataSource.getConnection();
			String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
			// 새로운 댓글을 달기위해서 원래 있던 댓글의 step을 +1증가 시켜서 밀어낸다. -> 새로운 댓글이 들어갈 자리를 만든다.
			preparedStatement = con.prepareStatement(query);

			preparedStatement.setInt(1, Integer.valueOf(strGroup));
			preparedStatement.setInt(2, Integer.valueOf(strStep));

			rn = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return rn;
	}

	//자기자신 댓글을 집어넣기위한 함수
	public int reply(String bid, String bname, String btitle, String bcontent, String bgroup, String bstep,
			String bindent) { /* DB에 저장된 모든 것을 가져온다 */

		replyShape(bgroup, bstep); // 댓글이 달릴 떄마다 bstep +1증가

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement의 위 버전, 실무에서는 이것을 사용 */
		int rn = 0; // update delete할 때는 ResultSet을 불러올 필요 없음

		try {
			con = dataSource.getConnection();
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";

			preparedStatement = con.prepareStatement(query);

			System.out.println(bid);
			System.out.println(bname);
			System.out.println(bcontent);
			System.out.println(btitle);

			preparedStatement.setString(1, bname);
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);
			preparedStatement.setInt(4, Integer.parseInt(bgroup));
			preparedStatement.setInt(5, Integer.parseInt(bstep) + 1);
			preparedStatement.setInt(6, Integer.parseInt(bindent) + 1);
			
			rn = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return rn;
	}

}