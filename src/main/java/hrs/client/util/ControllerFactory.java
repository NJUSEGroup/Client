package hrs.client.util;

import hrs.common.Controller.HotelController.IHotelController;
import hrs.common.Controller.HotelController.IHotelDiscountController;
import hrs.common.Controller.HotelController.IHotelOrderController;
import hrs.common.Controller.HotelController.IOfflineRecordController;
import hrs.common.Controller.HotelController.IRoomController;
import hrs.common.Controller.LoginController.ILoginController;
import hrs.common.Controller.UserController.IUserController;
import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.Controller.UserController.IUserOrderController;
import hrs.common.Controller.WebMarketController.IWebCreditController;
import hrs.common.Controller.WebMarketController.IWebDiscountController;
import hrs.common.Controller.WebMarketController.IWebOrderController;
import hrs.common.Controller.WebStaffController.IWebStaffController;
import hrs.common.Controller.WebStaffController.IWebUserController;
/**
 * 工厂模式，单例模式
 * @author NewSong
 *
 */
public class ControllerFactory {
private static ILoginController loginController;
	
	private static IUserController userController;
	private static IUserHotelController userHotelController;
	private static IUserOrderController userOrderController;
	
	private static IHotelController hotelController;
	private static IHotelDiscountController hotelDiscountController;
	private static IHotelOrderController hotelOrderController;
	private static IOfflineRecordController offlineRecordController;
	private static IRoomController roomController;
	
	private static IWebCreditController webCreditController;
	private static IWebDiscountController webDiscountController;
	private static IWebOrderController webOrderController;
	
	private static IWebStaffController webStaffController;
	private static IWebUserController webUserController;
	
	public static ILoginController getLoginController(){
		if(loginController == null){
			loginController = SpringUtils.getBean("loginController");
		}
		return loginController;
	}
	
	public static IUserController getUserController(){
		if(userController == null){
			userController = SpringUtils.getBean("userController");
		}
		return userController;
	}
	
	public static IUserHotelController getUserHotelController(){
		if(userHotelController == null){
			userHotelController = SpringUtils.getBean("userHotelController");
		}
		return userHotelController;
	}
	
	public static IUserOrderController getUserOrderController(){
		if(userOrderController == null){
			userOrderController = SpringUtils.getBean("userOrderController");
		}
		return userOrderController;
	}
	public static IHotelController getHotelController(){
		if(hotelController == null){
			hotelController = SpringUtils.getBean("hotelController");
		}
		return hotelController;
	}
	
	public static IHotelDiscountController getHotelDiscountController(){
		if(hotelDiscountController == null){
			hotelDiscountController = SpringUtils.getBean("hotelDiscountController");
		}
		return hotelDiscountController;
	}
	
	public static IHotelOrderController getHotelOrderController(){
		if(hotelOrderController == null){
			hotelOrderController = SpringUtils.getBean("hotelOrderController");
		}
		return hotelOrderController;
	}
	
	public static IOfflineRecordController getOfflineRecordController(){
		if(offlineRecordController == null){
			offlineRecordController = SpringUtils.getBean("offlineRecordController");
		}
		return offlineRecordController;
	}
	
	public static IRoomController getRoomController(){
		if(roomController == null){
			roomController = SpringUtils.getBean("roomController");
		}
		return roomController;
	}
	
	public static IWebCreditController getWebCreditController(){
		if(webCreditController == null){
			webCreditController = SpringUtils.getBean("webCreditController");
		}
		return webCreditController;
	}
	
	public static IWebDiscountController getWebDiscountController(){
		if(webDiscountController == null){
			webDiscountController = SpringUtils.getBean("webDiscountController");
		}
		return webDiscountController;
	}
	
	public static IWebOrderController getWebOrderController(){
		if(webOrderController == null){
			webOrderController = SpringUtils.getBean("webOrderController");
		}
		return webOrderController;
	}
	
	public static IWebStaffController getWebStaffController(){
		if(webStaffController == null){
			webStaffController = SpringUtils.getBean("webStaffController");
		}
		return webStaffController;
	}
	
	public static IWebUserController getWebUserController(){
		if(webUserController == null){
			webUserController = SpringUtils.getBean("webUserController");
		}
		return webUserController;
	}
	
}



