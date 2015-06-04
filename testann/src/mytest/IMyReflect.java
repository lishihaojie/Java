package mytest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * 这个是反射的接口
 * @author Lioncraft
 *
 */
public interface IMyReflect {

Class<? extends Annotation> annotationClass();//获得注解的类
	
void wirting(Object object, Field field, int iType);//设置块的值

Object parseMethod(Object object, Method method);// 设置方法中的值
}
