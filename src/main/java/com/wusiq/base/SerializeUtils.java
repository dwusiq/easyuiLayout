package com.wusiq.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化工具
 */
public class SerializeUtils {
    private static Logger LOGGER =  LoggerFactory.getLogger(SerializeUtils.class);

    /*序列化*/
    public static byte[] serialize(Object obj){
        LOGGER.info("序列化开始，参数:[{}]",obj);
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;

        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            byte[] bytes = baos.toByteArray();
            LOGGER.info("序列化完成，结果:[{}]",bytes);
            return bytes;
        } catch (Exception ex){
            LOGGER.warn("序列化失败",ex);
        }
        return  null;
    }

    /*反序列化*/
    public static Object unserialize(byte[] bytes){
        ByteArrayInputStream bais = null;
        bais = new ByteArrayInputStream(bytes);
        try{
            ObjectInputStream ois = new ObjectInputStream(bais);
            Object obj = ois.readObject();
            return  obj;
        }catch (Exception ex){
            LOGGER.warn("反序列化失败",ex);
        }
        return null;
    }

}
