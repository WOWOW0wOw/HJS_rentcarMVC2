package basic.rentcar.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import basic.rentcar.util.MybatisConfig;
import basic.rentcar.vo.reservation;
import basic.rentcar.vo.reservationViwe;
import basic.rentcar.vo.user;

public class reservationDAO {
	private reservationDAO() {
	}

	private static reservationDAO dao = new reservationDAO();

	public static reservationDAO getInstance() {
		return dao;
	}
	
	public int reservationInsert(reservation vo) {
		int cnt;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			cnt = session.insert("reservationInsert",vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return cnt;
	}
	
	public List<reservationViwe> reservationList(String userId) {
	    List<reservationViwe> list = new ArrayList<reservationViwe>();
	    try (SqlSession session = MybatisConfig.getInstance().openSession()) {
	        list = (ArrayList) session.selectList("reservationList", userId);
	        System.out.println("List size: " + list.size());
	    } catch (Exception e) {
	        System.out.println("reservationList() error");
	        e.printStackTrace();
	    }
	    return list;
	}
	
	public void reservationDelete(int regNo) {
		HashMap<String, Integer> vo = new HashMap<String, Integer>();
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			int qty = session.selectOne("getQTY", regNo);
			int num = session.selectOne("getCarNum", regNo);
			System.out.println("qty1 = " + qty + "\nnum1 = " + num);
			vo.put("qty", qty);
			vo.put("num", num);
			System.out.println("qty2 = " + vo.get("qty") + "\nnum2 = " + vo.get("num"));
			session.delete("reservationDelete", regNo);
			session.update("updateQTY", vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public reservationViwe getOneReservation(int regNo) {
		
		reservationViwe vo = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			vo = session.selectOne("oneReservationInfo", regNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
		
	}

	public void reservationUpdate(reservation vo) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			session.update("reservationUpdate", vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getRentcarNum(int regNo) {
		int cnt = -1;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			cnt = session.selectOne("getCarNum", regNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	
}
