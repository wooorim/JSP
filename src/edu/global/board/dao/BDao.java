package edu.global.board.dao; //����� ��Ű�� ���� ���� ����

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
			Context context = new InitialContext(); // Context = Context.xml�� ���õ� �� ���� �������� ��ü
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); // oracle�κ��� context.xml�� name(�̸�)�̶�
																					// �����ϰ�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BoardVO> list() { /* DB�� ����� ��� ���� �����´� */
		List<BoardVO> board = new ArrayList<BoardVO>();

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement�� �� ����, �ǹ������� �̰��� ��� */
		ResultSet rs = null; // DB���̺��� �޾ƿ��� ����

		try {
			con = dataSource.getConnection();
			String query = "select * from mvc_board order by bgroup desc, bstep asc"; // ���� ������ ����� group���� ����, �׷쳻 �����
																						// step���� ����

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

	public BoardVO contentView(String strID) { /* DB�� ����� ��� ���� �����´� */
		BoardVO board = null;

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement�� �� ����, �ǹ������� �̰��� ��� */
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			String query = "select * from mvc_board where bid = ?";

			//�������� �������� ����� Statement�� PrepareStatement�� �ٸ���. �⺻���� �����, �������ִ� ���, �Լ��� �ٸ��� ������ �ܿ���!
			preparedStatement = con.prepareStatement(query);//prepareStatement�� ����ϸ� ?����� ����� �� �ִ�.
			preparedStatement.setInt(1, Integer.valueOf(strID)); // ������ ?�� �����ϸ� preparedStatement���Լ��� �̿��ؼ� ������ ���� �� �ִ�.
			
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

	public int modify(String bid, String bname, String btitle, String bcontent) { /* DB�� ����� ��� ���� �����´� */

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement�� �� ����, �ǹ������� �̰��� ��� */
		int rn = 0; // update delete�� ���� ResultSet�� �ҷ��� �ʿ� ����

		try {
			con = dataSource.getConnection();
			String query = "update mvc_board set bname = ?, btitle = ?, bcontent = ? where bid = ?";

			preparedStatement = con.prepareStatement(query);

			System.out.println(bid);
			System.out.println(bname);
			System.out.println(bcontent);
			System.out.println(btitle);

			preparedStatement.setString(1, bname); // ������ ?�� �����ϸ� preparedStatement���Լ��� �̿��ؼ� ������ ���� �� �ִ�.
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

	public int delete(String bid) { /* DB�� ����� ��� ���� �����´� */

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement�� �� ����, �ǹ������� �̰��� ��� */

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

	public int write(String bname, String btitle, String bcontent) { /* DB�� ����� ��� ���� �����´� */

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement�� �� ����, �ǹ������� �̰��� ��� */

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

	public BoardVO reply_view(String strID) { /* DB�� ����� ��� ���� �����´� */
		BoardVO board = null;

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement�� �� ����, �ǹ������� �̰��� ��� */
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			String query = "select * from mvc_board where bid = ?";

			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, Integer.valueOf(strID)); // ������ ?�� �����ϸ� preparedStatement���Լ��� �̿��ؼ� ������ ���� �� �ִ�.
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
	
	//���ο� ����� �ֱ����� �ڸ��� Ȯ���ϴ� �Լ�(���� �޸� ��� ������ �б�!)
	public int replyShape(String strGroup, String strStep) { /* DB�� ����� ��� ���� �����´� */

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement�� �� ����, �ǹ������� �̰��� ��� */

		int rn = 0;

		try {
			con = dataSource.getConnection();
			String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
			// ���ο� ����� �ޱ����ؼ� ���� �ִ� ����� step�� +1���� ���Ѽ� �о��. -> ���ο� ����� �� �ڸ��� �����.
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

	//�ڱ��ڽ� ����� ����ֱ����� �Լ�
	public int reply(String bid, String bname, String btitle, String bcontent, String bgroup, String bstep,
			String bindent) { /* DB�� ����� ��� ���� �����´� */

		replyShape(bgroup, bstep); // ����� �޸� ������ bstep +1����

		Connection con = null;
		PreparedStatement preparedStatement = null; /* Statement�� �� ����, �ǹ������� �̰��� ��� */
		int rn = 0; // update delete�� ���� ResultSet�� �ҷ��� �ʿ� ����

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