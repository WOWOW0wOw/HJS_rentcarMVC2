package basic.rentcar.frontController;

import java.util.HashMap;

import basic.rentcar.controller.car.deleteRentcarController;
import basic.rentcar.controller.car.deleteResrvationController;
import basic.rentcar.controller.car.rentcarAddAdminController;
import basic.rentcar.controller.car.rentcarInfoController;
import basic.rentcar.controller.car.rentcarInsertController;
import basic.rentcar.controller.car.rentcarListController;
import basic.rentcar.controller.car.rentcarUpdateController;
import basic.rentcar.controller.car.rentcarUpdateSetController;
import basic.rentcar.controller.car.reservationCompleteController;
import basic.rentcar.controller.car.reservationController;
import basic.rentcar.controller.car.reservationListController;
import basic.rentcar.controller.car.reservationRentcarController;
import basic.rentcar.controller.car.reservationUpdate;
import basic.rentcar.controller.car.reservationUpdateSet;
import basic.rentcar.controller.user.LogoutController;
import basic.rentcar.controller.user.VaildIdAjaxController;
import basic.rentcar.controller.user.deleteUserController;
import basic.rentcar.controller.user.insertUserController;
import basic.rentcar.controller.user.loginController;
import basic.rentcar.controller.user.mainController;
import basic.rentcar.controller.user.updateUserController;
import basic.rentcar.controller.user.userAddController;
import basic.rentcar.controller.user.userContentController;
import basic.rentcar.controller.user.userListController;


public class HandlerMapping {
	private HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		//유저
		mappings.put("/userLogin.do", new loginController());
		mappings.put("/main.do", new mainController());
		mappings.put("/userLogout.do", new LogoutController());
		mappings.put("/insertUser.do", new insertUserController());
		mappings.put("/userAdd.do", new userAddController());
		mappings.put("/vaildIdAjax.do", new VaildIdAjaxController());
		mappings.put("/userList.do", new userListController());
		mappings.put("/userDelete.do", new deleteUserController());
		mappings.put("/userContent.do", new userContentController());
		mappings.put("/userUpdate.do", new updateUserController());
		
		//차량
		mappings.put("/rentcarList.do", new rentcarListController());
		mappings.put("/rentcarInfo.do", new rentcarInfoController());
		mappings.put("/resercationRentcar.do", new reservationRentcarController());
		mappings.put("/rentcarReceipt.do", new reservationController());
		mappings.put("/reservationComplete.do", new reservationCompleteController());
		mappings.put("/reservationList.do", new reservationListController());
		mappings.put("/deleteRes.do", new deleteResrvationController());
		mappings.put("/updateRes.do", new reservationUpdate());
		mappings.put("/updateSetRes.do", new reservationUpdateSet());
		mappings.put("/rentcarUpdate.do", new rentcarUpdateController());
		mappings.put("/rentcarUpdateSet.do", new rentcarUpdateSetController());
		mappings.put("/rentcarDelete.do", new deleteRentcarController());
		mappings.put("/rentcarAdd.do", new rentcarAddAdminController());
		mappings.put("/rentcarinsert.do", new rentcarInsertController());
	}

	public Controller getController(String key) {
		return mappings.get(key);
	}
}