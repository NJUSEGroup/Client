package hrs.client.UI.HotelUI.HotelUI.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import hrs.client.UI.HotelUI.HotelUI.HotelUIPanel;

public class CityListener implements ItemListener{

	private HotelUIPanel jpHotelInfo;
	
	public CityListener(HotelUIPanel jpHotelInfo){
		this.jpHotelInfo = jpHotelInfo;
	}

	/**
	 * 酒店所选城市发生改变后，商圈下拉列表框中的选项也要发生改变
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getStateChange() == ItemEvent.SELECTED){
			jpHotelInfo.changeCircle();
		}
                
	}
	
}