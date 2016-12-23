package hrs.client.util;

import java.text.DecimalFormat;

public class DoubleFormat {
	public static String format(String x){
		DecimalFormat dFormat=new DecimalFormat("#.00");
		double number=Double.parseDouble(x);
		String string=dFormat.format(number);
		return string;
	}
	public static void main (String[]args){
		System.out.println(format("0.988888888"));
		System.out.println(format("0.9"));
	}

}
