package mytest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * 测试注解和反射
 * @author Lioncraft
 *
 */
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyUseAnn test = new MyUseAnn();
		
		try {
			initReflect(test,new MyAnnReflect());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.TestUse1();
		test.TestUse2();
		test.TestUse3();
		test.TestUse4();
		
	}
	
	/**
	 * 把注解中的值反射出来
	 * 
	 * @param obj
	 * @param myreflect
	 * @throws Exception
	 */
	private static void initReflect(Object obj, IMyReflect... myreflect) throws Exception{
		Class<?> cls = obj.getClass();
		
		for (Field field : cls.getDeclaredFields()) { //getDeclaredFields 方法将获得类中所有Field包括public,private,protcted
			for (IMyReflect reflect : myreflect) {
				if (field.isAnnotationPresent(reflect.annotationClass())) {//判断块field在reflect中是否有
					if ("mytest.MyOne".equals(field.getType().getName())){//判断是是不是对象MyOne
						reflect.wirting(obj, field, 1);//此处的1表示对象MyOne
					}
					
					if ("mytest.MyTwo".equals(field.getType().getName())){//判断是是不是对象MyTwo
						reflect.wirting(obj, field, 2);//此处的2表示对象MyTwo
					}
					
					break;
				}
			}
		}
		
		
		for (Method method : cls.getDeclaredMethods()) {//getDeclaredMethods 方法获得说有的方法
			for (IMyReflect reflect : myreflect) {
				if (method.isAnnotationPresent(reflect.annotationClass())) {//判断块method在reflect中是否有
					Object tmp = reflect.parseMethod(obj, method);
					if (null != tmp) {
						System.out.println("这个是Method方法的返回值" + tmp.toString());
					}
					break;
				}
			}
		}
	}

}
