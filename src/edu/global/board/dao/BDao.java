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
		ResultSet rs = null; //DB테이블을 받아오는 문법

		try {
			con = dataSource.getConnection();
			String query = "select * from mvc_board order by bgroup desc, bstep asc";

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

	public int modify(String bid, String bname, String btitle, String bcontent) { /* DB에 저장된 모든 것을 가져온다 */

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement의 위 버전, 실무에서는 이것을 사용 */
		int rn = 0; //update delete할 때는 ResultSet을 불러올 필요 없음

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
}