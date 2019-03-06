package com.qq.weixin.xml.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.util.Map;

public class MarshallerFactory {

    private final static Map<Class, Unmarshaller> unmarshallerCache = Maps.newHashMap();
    private final static Map<Class, Marshaller> marshallerCache = Maps.newHashMap();

    private MarshallerFactory() {
    }

    static {
        try {
            // 想要进行的bean转换的类，可以写在这里，初始化到Map中
        } catch (Exception e) {
            // 打印日志
        }
    }

    public static Marshaller getMarshaller(Class clazz) throws JAXBException {
        Preconditions.checkNotNull(clazz);
        Marshaller marshaller = marshallerCache.get(clazz);
        if (marshaller != null) {
            return marshaller;
        }
        JAXBContext jc = JAXBContext.newInstance(clazz);
        marshaller = jc.createMarshaller();
        marshallerCache.put(clazz, marshaller);

        return marshaller;
    }

    public static Unmarshaller getUnmarshaller(Class clazz) throws JAXBException {
        Unmarshaller unmarshaller = unmarshallerCache.get(clazz);
        if (unmarshaller != null) {
            return unmarshaller;
        }
        JAXBContext jc = JAXBContext.newInstance(clazz);
        unmarshaller = jc.createUnmarshaller();
        unmarshallerCache.put(clazz, unmarshaller);

        return unmarshaller;
    }
}
