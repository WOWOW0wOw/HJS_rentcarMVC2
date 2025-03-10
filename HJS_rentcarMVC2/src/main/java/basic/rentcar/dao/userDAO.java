package basic.rentcar.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import basic.rentcar.util.MybatisConfig;
import basic.rentcar.vo.user;

public class userDAO {

	private userDAO() {
	}

	private static userDAO dao = new userDAO();

	public static userDAO getInstance() {
		return dao;
	}

	public String userLogin(user user) {
		String userId = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			userId = session.selectOne("userLogin", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}

	public int getUserNo(String id) {
		int cnt = 0;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			cnt = session.selectOne("getUserNo", id);
		} catch (Exception e) {
			System.out.println("getMemberNo Error");
			e.printStackTrace();
		}
		return cnt;
	}

	public int userInsert(HashMap<String, String> vo) {
		int cnt = 0;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			cnt = session.insert("userInsert", vo);
			session.commit();
		} catch (Exception e) {
			System.out.println("memberInsert Error");
			e.printStackTrace();
		}
		return cnt;

	}

	public boolean isValidId(String id) {
		System.out.println(id);
		int cnt = -1;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			cnt = session.selectOne("isValidId", id);
		} catch (Exception e) {
			System.out.println("isValidId Error");
			e.printStackTrace();
		}
		return cnt != -1;
	}

	public ArrayList<user> userList() {

		ArrayList<user> list = null;

		try (SqlSession session = MybatisConfig.getInstance().openSession()) {

			list = (ArrayList) session.selectList("userList");

		} catch (Exception e) {
			System.out.println(" memberList() 에러");
			e.printStackTrace();
		}
		return list;
	}

	public int userDelete(String id) {
		int cnt;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			cnt = session.delete("userDelete", id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return cnt;
	}

	public user userContent(int num) {
		List<user> list = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			list = session.selectList("userContent", num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list.get(0);
	}

	public int userUpdate(user vo) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			int cnt = session.update("userUpdate", vo);
			session.commit();
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public String getOneUserId(int log) {
		String userId = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			userId = session.selectOne("getOneUserId", log);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}

}
