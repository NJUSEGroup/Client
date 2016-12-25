package hrs.common.util.HotelComparator;

import org.springframework.stereotype.Component;

import hrs.common.VO.HotelVO;
/**
 * 
* @ClassName: StarComparator
* @Description: 星级比较器
* @author NewSong
* @date 2016年11月19日 下午10:07:19
*
 */
@Component("StarComparator")
public class StarComparator extends HotelComparator {

	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = -4933039628707891648L;

	@Override
	public int compare(HotelVO o1, HotelVO o2) {
		if (super.isDecrease) {
			return o2.star - o1.star;
		} else {
			return o1.star - o2.star;
		}
	}

}