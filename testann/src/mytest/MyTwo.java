package mytest;

import java.util.Arrays;

public class MyTwo {
	private int[] intArrayValue;
	private float[] floatArrayValue;
	private boolean[] booleanArrayValue;
	private byte[] byteArrayValue;
	private double[] doubleArrayValue;
	private char[] charArrayValue;
	private long[] longArrayValue;
	private short[] shrotArrayValue;
	private String[] strArrayValue;
	
	public MyTwo(int[] iArray, float[] fArray, boolean[] bArray,
			byte[] btArray, double[] dArray, char[] cArray, long[] lArray, short[] sArray,
			String[] strArray) {
		
		intArrayValue = iArray;
		floatArrayValue = fArray;
		booleanArrayValue = bArray;
		byteArrayValue = btArray;
		doubleArrayValue = dArray;
		charArrayValue = cArray;
		longArrayValue = lArray;
		shrotArrayValue = sArray;
		strArrayValue = strArray;
		
	}
	
	public void PrintArray() {
		System.out.println(Arrays.toString(intArrayValue));
		System.out.println(Arrays.toString(floatArrayValue));
		System.out.println(Arrays.toString(booleanArrayValue));
		System.out.println(Arrays.toString(byteArrayValue));
		System.out.println(Arrays.toString(doubleArrayValue));
		System.out.println(Arrays.toString(charArrayValue));
		System.out.println(Arrays.toString(longArrayValue));
		System.out.println(Arrays.toString(shrotArrayValue));
		System.out.println(Arrays.toString(strArrayValue));
	}

}
