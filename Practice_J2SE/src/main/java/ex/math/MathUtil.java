package ex.math;

import java.math.BigDecimal;

public class MathUtil
{

	public static Double round(Double doubleValue, int scale)
	{
		return new BigDecimal(doubleValue.toString()).setScale(scale,
				BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
