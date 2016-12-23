package hrs.client.UI.LoginUI;



public class RegisterJL extends LoginJL {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3094759085895309636L;

	public RegisterJL(LoginFrame frame, String s) {
		super(frame, s);
		init();
		
	}

	@Override
	protected void addListener() {
		addMouseListener(new RegisterLabelListener(frame));
	}
	
	

}
