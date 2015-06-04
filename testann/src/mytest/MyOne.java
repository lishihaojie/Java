package mytest;

/**
 * 这是一个简单的实体类，用于测试注解
 * @author Lioncraft
 *
 */
public class MyOne {

	private int intValue;
	private float floatValue;
	private boolean booleanValue;
	private byte byteValue;
	private double doubleValue;
	private char charValue;
	private long longValue;
	private short shortValue;
	private String strValue;
	
	public MyOne(int i, float f, boolean b, byte bt, double d, char c, long l, short s,String str) {
		intValue = i;
		floatValue = f;
		booleanValue = b;
		byteValue = bt;
		doubleValue = d;
		charValue = c;
		longValue = l;
		shortValue = s;
		strValue = str;
		
	}
	
	public void printT() {
		System.out.println("i:=" + intValue + ";f:=" + floatValue
				+ ";boolean:=" + booleanValue + ";byteValue:=" + byteValue + ";doubleValue:=" + doubleValue
				+ ";charValue:=" + charValue + ";longValue:=" + longValue + ";shortValue:=" + shortValue
				+ ";strValue:=" + strValue);
	}
}
