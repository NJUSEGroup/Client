package hrs.client.UI.HotelUI.HotelDiscountUI.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import hrs.client.UI.HotelUI.HotelDiscountUI.AddDiscountDialog;

public class TypeSelectedListener implements ItemListener{

	private AddDiscountDialog addDialog;
	
	public TypeSelectedListener(AddDiscountDialog addDialog){
		this.addDialog = addDialog;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange() == ItemEvent.SELECTED){
			addDialog.setByType();
		}
	}

}
