package com.snake.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BeanFactory {
    /**
     *
     */
    Map<String, Object> map = new HashMap<String, Object>();

    public BeanFactory(String xml) {
        parseXml(xml);
    }

    public void parseXml(String xml) throws SnakeSpringException {
        File file = new File(this.getClass().getResource("/").getPath() + "/" + xml);
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(file);
            Element rootElement = document.getRootElement();
            Attribute attribute = rootElement.attribute("default");
            boolean flag = false;
            if (attribute != null) {
                flag = true;
            }
            for (Iterator<Element> iterator = rootElement.elementIterator(); iterator.hasNext(); ) {
                /**
                 * setup1、实例化对象
                 */
                Element elementFirst = iterator.next();
                Attribute attributeId = elementFirst.attribute("id");
                String id = attributeId.getValue();
                Attribute attributeClass = elementFirst.attribute("class");
                String clazzName = attributeClass.getValue();
                Class<?> clazz = Class.forName(clazzName);

                /**
                 * 维护依赖关系
                 * 看这个对象有没有依赖（判断是否有property。或者判断类是否有属性）
                 * 如果有则注入
                 */
                Object object = null;
                for (Iterator<Element> iteratorSecond = elementFirst.elementIterator(); iteratorSecond.hasNext(); ) {
                    Element elementSecond = iterator.next();
                    if ("property".equals(elementSecond.getName())) {
                        String refValue = elementSecond.attribute("ref").getValue();
                        String nameValue = elementSecond.attribute("name").getValue();
                        Object injectObject = map.get(refValue);
                        // 基于反射, 参数注入
                        Field field = clazz.getDeclaredField(nameValue);
                        field.setAccessible(true);
                        field.set(object, injectObject);
                        object = clazz.newInstance();
                    } else {
                        // 说明有参构造
                        String refValue = elementSecond.attribute("ref").getValue();
                        Object injectObject = map.get(refValue);
                        // 基于反射, 构造注入
                        Class<?> injectObjectClass = injectObject.getClass();
                        Constructor<?> constructor = clazz.getConstructor(injectObjectClass.getInterfaces()[0]);
                        object = constructor.newInstance(injectObjectClass);
                    }
                }
                if (object == null && flag && attribute.getValue().equals("byType")) {//判断自动注入
                    // 判断clazz是否有依赖属性
                    Field[] fields = clazz.getDeclaredFields();
                    for (Field field : fields) {
                        // 得到属性 byte，比如String a 那么这个的field.getType()=String.class
                        Class injectObjectClazz = field.getType().getInterfaces()[0];

                        int count = 0;
                        Object injectObject = null;
                        for (String key : map.keySet()) {
                            Class temp = map.get(key).getClass();
                            if (temp.getName().equals(injectObjectClazz.getName())) {
                                injectObject = map.get(key);
                                //记录找到一个，因为可能找到多个count
                                count++;
                            }
                        }
                        if (count > 1) {
                            throw new SnakeSpringException("需要一个对象，但是找到了两个对象");
                        } else {
                            object = clazz.newInstance();
                            field.setAccessible(true);
                            field.set(object, injectObject);
                        }
                    }
                }

                if (object == null) {//沒有子标签
                    object = clazz.newInstance();
                }

                map.put(id, object);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(map);
    }

    public Object getBean(String beanName) {
        return map.get(beanName);
    }

}
