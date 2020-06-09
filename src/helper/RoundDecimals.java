package helper;

import java.math.BigDecimal;

public class RoundDecimals {

	public static double round(double value, int decimal) {
		BigDecimal bigDecimal = new BigDecimal(String.valueOf(value)).setScale(decimal, BigDecimal.ROUND_HALF_UP);
		return bigDecimal.doubleValue();
	}
}
