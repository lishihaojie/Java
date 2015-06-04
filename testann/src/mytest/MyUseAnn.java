package mytest;
/**
 * 使用注解 的demo类
 * @author Lioncraft
 *
 */
public class MyUseAnn {
	
	@MyAnn()
	private MyOne test1;
	
	@MyAnn(intValue = 2, floatValue = 2.2f, booleanValue = true,
			byteValue = (byte)45,doubleValue = 2.2222,charValue = 'w',
			longValue = 200L, shortValue = 2222, strValue = "test2")
	private MyOne test2;
	
	@MyAnn()
	private MyTwo test3;
	
	@MyAnn(intArrayValue = {100,101}, floatArrayValue = {100.1f,101.1f},
			booleanArrayValue = {false, true}, byteArrayValue = {'c','C'},
			strArrayValue = {"Arraytest", "这就好了"})
	private MyTwo test4;
	
	public void TestUse1() {
		test1.printT();
	}
	
	public void TestUse2() {
		test2.printT();
	}
	
	public void TestUse3() {
		test3.PrintArray();
	}
	
	public void TestUse4() {
		test4.PrintArray();
	}
	@MyAnn(strValue = "hello method1",intValue = 1, doubleValue = 2.0)
	public void TestMethod1(String str, int i, double d) {
		System.out.println("这个是第一个测试方法" + str +"    integer value:" + i
				+ "   double value:" + d);
	}
	
	@MyAnn(intArrayValue = {20, 30})
	public int TestMethod2(int... intargs) {
		int iSum = 0;
		for (int i : intargs) {
			iSum += i;
		}
		return iSum;
	}


}
