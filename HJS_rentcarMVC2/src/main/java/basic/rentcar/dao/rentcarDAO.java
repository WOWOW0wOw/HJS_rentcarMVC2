package basic.rentcar.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import basic.rentcar.util.MybatisConfig;
import basic.rentcar.vo.rentcar;

public class rentcarDAO {
	private rentcarDAO() {
	}

	private static rentcarDAO dao = new rentcarDAO();

	public static rentcarDAO getInstance() {
		return dao;
	}

	public ArrayList<rentcar> getCarlist(String category, String company) {

		ArrayList<rentcar> list = new ArrayList<rentcar>();

		Map<String, String> menu = new HashMap<>();
		menu.put("category", category);
		menu.put("company", company);

		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			list = (ArrayList) session.selectList("rentcarList", menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public rentcar oneRentcarInfo(int num) {
		rentcar car = null;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			car = session.selectOne("oneRentcarInfo", num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return car;
	}

	public int getRentcarQTY(int num) {
		int qty = -1;
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			qty = session.selectOne("getRentcarQTY", num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("dldid" + qty + "개");
		return qty;
	}

	public void updateQTY(HashMap<String, Integer> rc) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			session.update("updateQTY", rc);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void deleteRentCar(int num) {

		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			session.delete("deleteRes", num);
			session.delete("deleteRentCar", num);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addCar(rentcar vo) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			session.insert("addCar", vo);
			session.commit();
		} catch (Exception e) {
			System.out.println("addCar 에러");
			e.printStackTrace();
		}

	}
	
	public void insertRentcar(String name, int category, int price, int usepeople, int total_qty, String company, String img,
			String info) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			session.insert("insertRentcar", new rentcar(0, name, category, price, usepeople, total_qty, company, img, info));
			session.commit();
		}catch (Exception e) {
			System.out.println("insertRentcar Fail");
		}
	}

	public void updateRentcar(int num,String name,  int category, int price, int usepeople, int total_qty, String company, String img,
			String info) {
		try (SqlSession session = MybatisConfig.getInstance().openSession()) {
			if(img == null)
				session.update("updateRentcarNoImg", new rentcar(num, name, category, price, usepeople, total_qty, company, img, info));
			else {
				session.update("updateRentcarHasImg", new rentcar(num, name, category, price, usepeople, total_qty, company, img, info));
			}
			session.commit();
		}catch (Exception e) {
			System.out.println("updateRentcar Fail");
			e.printStackTrace();
		}
	}

}
