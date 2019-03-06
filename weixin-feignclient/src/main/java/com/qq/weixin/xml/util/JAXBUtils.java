package com.qq.weixin.xml.util;

import org.apache.commons.lang.StringUtils;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JAXBUtils {
    public static String convertToXml(Object obj) {
        return convertToXml(obj, false);
    }

    public static String convertToXml(Object obj, boolean format) {
        try {
            StringWriter sw = new StringWriter();
            Marshaller marshaller = MarshallerFactory.getMarshaller(obj.getClass());
            if (marshaller == null) {
                return StringUtils.EMPTY;
            }

            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, format);
            marshaller.marshal(obj, sw);
            return sw.toString();
        } catch (JAXBException e) {
            throw new RuntimeException("obj toXML failed", e);
        }
    }

    public static <T> T convertToJavaBean(String xml, Class<T> t) {
        try {
            Unmarshaller unmarshaller = MarshallerFactory.getUnmarshaller(t);
            if (unmarshaller == null) {
                return null;
            }

            StringReader sr = new StringReader(xml);
            T ret;
            ret = (T) unmarshaller.unmarshal(sr);
            return ret;
        } catch (JAXBException e) {
            throw new RuntimeException("xml toObj failed", e);
        }
    }
}
