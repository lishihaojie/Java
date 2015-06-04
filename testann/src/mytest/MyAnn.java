package mytest;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 　1.所有基本数据类型（int,float,boolean,byte,double,char,long,short)
　　　　2.String类型
　　　　3.Class类型
　　　　4.enum类型
　　　　5.Annotation类型
　　　　6.以上所有类型的数组

　　Annotation类型里面的参数该怎么设定: 
　　第一,只能用public或默认(default)这两个访问权修饰.例如,String value();这里把方法设为defaul默认类型；　 　
　　第二,参数成员只能用基本类型byte,short,char,int,long,float,double,boolean八种基本数据类型和 String,Enum,Class,annotations等数据类型,以及这一些类型的数组.例如,String value();这里的参数成员就为String;　　
　　第三,如果只有一个参数成员,最好把参数名称设为"value",后加小括号.。
 * @author Lioncraft
 *
 */
/**
 * 这就是一个注解
 * @author Lioncraft
 *
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnn {

	int intValue() default 0;
	float floatValue() default 1.1f;
	boolean booleanValue() default false;
	byte byteValue() default (byte)23;
	double doubleValue() default 0.12;
	char charValue() default 'a';
	long longValue() default 100L;
	short shortValue() default 2;
	String strValue() default "默认值";
	
	
	int intValue2() default 0;
	float floatValue2() default 1.1f;
	boolean booleanValue2() default false;
	byte byteValue2() default (byte)23;
	double doubleValue2() default 0.12;
	char charValue2() default 'a';
	long longValue2() default 100L;
	short shortValue2() default 2;
	String strValue2() default "默认值";
	
	/**
	 * Array
	 */
	int[] intArrayValue() default {10,11};
	float[] floatArrayValue() default {10.1f,10.2f};
	boolean[] booleanArrayValue() default {true,false};
	byte[] byteArrayValue() default {(byte)123,(byte)124};
	double[] doubleArrayValue() default {10.11, 10.22};
	char[] charArrayValue() default {'A','Z'};
	long[] longArrayValue() default {200L,222L};
	short[] shrotArrayValue() default {102, 103};
	String[] strArrayValue() default {"数组1","数组2"};
	
	
	
}
