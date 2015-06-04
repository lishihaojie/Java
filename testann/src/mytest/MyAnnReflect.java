package mytest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
/**
 * 这个是对注解MyAnn的反射处理
 * @author Lioncraft
 *
 */
public class MyAnnReflect implements IMyReflect{

	@Override
	public Class<? extends Annotation> annotationClass() {
		// TODO Auto-generated method stub
		return MyAnn.class;
	}

	@Override
	public void wirting(Object object, Field field, int iType) {
		// TODO Auto-generated method stub
		
		MyAnn annotation = (MyAnn) field.getAnnotation(this.annotationClass());//获得注解的值
		Object tmpobj = null;
		if (1 == iType) {
			tmpobj = new MyOne(annotation.intValue(),
					annotation.floatValue(),
					annotation.booleanValue(),
					annotation.byteValue(),
					annotation.doubleValue(),
					annotation.charValue(),
					annotation.longValue(),
					annotation.shortValue(),
					annotation.strValue());
			setFieldValue(object, field.getName(), MyOne.class, tmpobj);
		}
		
		if (2 == iType) {
			tmpobj = new MyTwo(annotation.intArrayValue(),
					annotation.floatArrayValue(),
					annotation.booleanArrayValue(),
					annotation.byteArrayValue(),
					annotation.doubleArrayValue(),
					annotation.charArrayValue(),
					annotation.longArrayValue(),
					annotation.shrotArrayValue(),
					annotation.strArrayValue()
					);
			setFieldValue(object, field.getName(), MyTwo.class, tmpobj);
		}
			
		
	}
	
	/**
	 * 将注解中的值赋给块
	 * 
	 * @param obj
	 * @param fname
	 * @param fieldClass
	 * @param fieldObject
	 */
	private void setFieldValue(Object obj, String fname, Class<?> fieldClass, Object fieldObject) {
		if (!fieldClass.isAssignableFrom(fieldObject.getClass())) { //主要用于判断，fieldClass 和 fieldObjbect 是同一个类
			return;
		}
		
		Class<?> clazz = obj.getClass();
		
		try {//这是出力方法
			Method method = clazz.getDeclaredMethod("set" + Character.toUpperCase(fname.charAt(0))
					+ fname.substring(1), fieldClass);
			method.setAccessible(true);
		    method.invoke(obj, fieldObject);
		} catch (Exception e) {
			try {//这是块
				Field field = clazz.getDeclaredField(fname);
				field.setAccessible(true);
				field.set(obj, fieldObject);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public Object parseMethod(Object object, Method method) {
		// TODO Auto-generated method stub
		Object objResult = null;
		MyAnn annotation = (MyAnn) method.getAnnotation(this.annotationClass());//获得注解的值
		
		 Parameter[] tmp = method.getParameters();
		 int length = tmp.length;
		 Object[] objpar = new Object[length];
		 for (int  i= 0; i < length; i++) {
			 String strtmp = tmp[i].getType().getName();
			 objpar[i] = getAnnValue(strtmp, annotation);
			
		 }
		
		try {
			objResult = method.invoke(object, objpar);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objResult;
	}
	
	private Object getAnnValue(String strType, MyAnn annotation) {
		Object objResult = null;
		 if (strType.equals("java.lang.String")) {
			 objResult = annotation.strValue();
		 }
		 
		 if (strType.equals("int")) {
			 objResult = annotation.intValue();
		 }
		 
		 if (strType.equals("double")) {
			 objResult = annotation.doubleValue();
		 }
		 
		 if (strType.equals("boolean")) {
			 objResult = annotation.doubleValue();
		 }
		 
		 if (strType.equals("byte")) {
			 objResult = annotation.doubleValue();
		 }
		 
		 if (strType.equals("char")) {
			 objResult = annotation.doubleValue();
		 }
		 
		 if (strType.equals("long")) {
			 objResult = annotation.doubleValue();
		 }
		 
		 if (strType.equals("short")) {
			 objResult = annotation.doubleValue();
		 }
		 
		 if (strType.equals("float")) {
			 objResult = annotation.doubleValue();
		 }
		 /**
		  * Array
		  */
		 if (strType.equals("[I")) {//int array
			 objResult = annotation.intArrayValue();
		 }
		 
		 if (strType.equals("[D")) {//double array
			 objResult = annotation.doubleArrayValue();
		 }
		 
		 if (strType.equals("[Ljava.lang.String;")) {//string array
			 objResult = annotation.strArrayValue();
		 }
		 
		 if (strType.equals("[Z")) {//boolean array
			 objResult = annotation.booleanArrayValue();
		 }
		 
		 if (strType.equals("[B")) {//byte array
			 objResult = annotation.byteArrayValue();
		 }
		 
		 if (strType.equals("[C")) {//char array
			 objResult = annotation.charArrayValue();
		 }
		 
		 if (strType.equals("[J")) {//long array
			 objResult = annotation.longArrayValue();
		 }
		 
		 if (strType.equals("[S")) {//short array
			 objResult = annotation.shrotArrayValue();
		 }
		 
		 if (strType.equals("[F")) {//float array
			 objResult = annotation.floatArrayValue();
		 }
		
		 
		return objResult;
	}

}
