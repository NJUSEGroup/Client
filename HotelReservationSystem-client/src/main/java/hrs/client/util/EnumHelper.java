package hrs.client.util;

import java.util.HashMap;

import hrs.common.util.type.OrderStatus;
import hrs.common.util.type.RoomType;
/**
 * 将一些枚举类型与String互相转换
 * 
 * @author 涵
 *
 */
public class EnumHelper {
	
	/**
	 * 将RoomType转为String
	 * @param type
	 * @return
	 */
	public static String RoomFormat(RoomType type){
		HashMap<RoomType, String> map = new HashMap<>();
		map.put(RoomType.Business,"商务标间");
		map.put(RoomType.Deluxe,"豪华房");
		map.put(RoomType.Double,"双人房");
		map.put(RoomType.Single,"单人房");
		map.put(RoomType.Standard,"标准房");
		map.put(RoomType.KingSize,"大床间");
		map.put(RoomType.Executive,"行政标间");
		
		return map.get(type);
		
		
	}
	
	/**
	 * 将OrderStatus转为String
	 * @param status
	 * @return
	 */
	public static String StatusFormat(OrderStatus status){
		
		HashMap<OrderStatus, String> map = new HashMap<>();
		map.put(OrderStatus.Abnormal,"异常");
		map.put(OrderStatus.Executed,"已执行");
		map.put(OrderStatus.UserRevoked,"已撤销");
		map.put(OrderStatus.Unexecuted,"未执行");
		
		return map.get(status);
	}

	/**
	 * 将String转为OrderStatus
	 * @param status
	 * @return
	 */
	public static OrderStatus toStatus(String status) {
		HashMap<String, OrderStatus> map = new HashMap<>();
		map.put("异常",OrderStatus.Abnormal);
		map.put("已执行",OrderStatus.Executed);
		map.put("已撤销",OrderStatus.UserRevoked);
		map.put("未执行",OrderStatus.Unexecuted);
		return map.get(status);
	}
	
	public static RoomType toRoomType(String type){
		HashMap<String,RoomType > map = new HashMap<>();
		map.put("商务标间",RoomType.Business);
		map.put("豪华房",RoomType.Deluxe);
		map.put("双人房",RoomType.Double);
		map.put("单人房",RoomType.Single);
		map.put("标准房",RoomType.Standard);
		map.put("大床间",RoomType.KingSize);
		map.put("行政标间",RoomType.Executive);
		
		return map.get(type);
		
		
	}
}
