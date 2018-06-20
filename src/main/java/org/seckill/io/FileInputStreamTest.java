package org.seckill.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * FileInputStream 读取文件内容
 *
 * @author 12084
 * @create 2018-06-20 8:46
 */
public class FileInputStreamTest {

    public static final Logger logger = LoggerFactory.getLogger(FileInputStreamTest.class);


    public static void main(String[] args) {
        try {
            String filePath = "d:/FileInputStreamTest.txt";
            String readFile = readFile(filePath);
            String utf8Str = getUtf8Str(readFile);
            //todo 会乱码，未解决
            logger.warn("readFile={}", utf8Str);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getUtf8Str(String str) throws Exception {
        try {
            return new String(str.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public static String readFile(String path) {
        FileInputStream fis = null;
        String result = "";
        try {
            //1、根据path 路径实例化一个输入流的对象

            fis = new FileInputStream(path);
            //2、返回这个输入流中可以被读到剩下的bytes字节的估计值
            int size = fis.available();
            //3、根据输入流中的字节数创建byte数组
            byte[] array = new byte[size];
            //4、把数据读取到数组中
            fis.read(array);
            //5、根据获得的byte数组新创建一个字符串，然后输出
            result = new String(array);


        } catch (Exception e) {
            logger.error("FileInputStreamTest.readFile error:", e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
