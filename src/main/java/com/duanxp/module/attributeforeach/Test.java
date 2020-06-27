package com.duanxp.module.attributeforeach;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Test
 * @Description:
 * @Author duanxp
 * @Date 2020/01/07 16:22
 */
public class Test {

    public static void main(String[] args) {


        Animal animal = new Animal();
        animal.setAge(11);
        animal.setName("动物");
        animal.setPrice(11.03);

        Field[] fields = animal.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            System.out.println("fields -------> " + field.getName());
            String value = getFieldValueByFieldName(field.getName(), animal);
            System.out.println("value -------->"+value);

        }



    }

    /**
     * 根据属性名 获取属性值
     * @param fieldName
     * @param object
     * @return
     */
    private static String getFieldValueByFieldName(String fieldName, Object object) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = object.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(object, new Object[] {});
            return value.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static void methodEq(Object o,Object obj,String... not) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {

            String name = field.getName();

//            if (field.isAnnotationPresent(TableField.class)) {
//
//            }
            List<String> strings = Arrays.asList(not);
            if (StringUtils.isNotBlank(getFieldValueByFieldName(name, obj))) {
                if (StringUtils.equals(name,"pageSize") || StringUtils.equals(name,"offset")) {
                    break;
                }
                if (strings.contains(name)) {
                    break;
                }
//                wrapper.eq(field.getName(), getFieldValueByFieldName(field.getName(), obj));
            }

        }
    }


}
