package org.seckill.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

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
            String filePath = "d:/FileInputStreamTest1.txt";
            System.out.println(readFile1(filePath));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String readFile1(String path) {
        FileInputStream fis = null;
        StringBuffer sb = new StringBuffer();
        InputStreamReader reader = null;

        try {
            //1、根据path 路径实例化一个输入流的对象

            fis = new FileInputStream(path);

            reader = new InputStreamReader(fis, "UTF-8");


            while (reader.ready()) {
                sb.append((char) reader.read());
            }

        } catch (Exception e) {
            logger.error("FileInputStreamTest.readFile error:", e);
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public static String readFile2(String path) {
        FileInputStream fis = null;
        StringBuffer sb = new StringBuffer();
        try {
            fis = new FileInputStream(path);
            byte[] bbuf = new byte[1024];
            int hasRead = 0;
            while ((hasRead = fis.read(bbuf)) != -1) {
                sb.append(new String(bbuf, 0, hasRead, "utf-8"));
            }


        } catch (Exception e) {
            logger.error("FileInputStreamTest.readFile2 error:", e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {

                }
            }
        }
        return sb.toString();
    }

    /**
     * 从控制台读取字符串
     */
    public static void readSystemIn() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str;
            do {
                str = br.readLine();
                System.out.println(str);

            } while (!str.equals("end"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 可能会存在乱码
     */
    public static void fileStreamTest() {
        try {
            byte bWrite[] = {11, 21, 3, 40, 3};
            OutputStream os = new FileOutputStream("test.txt");
            for (byte b : bWrite) {
                // writes the bytes
                os.write(b);
            }
            os.close();
            InputStream is = new FileInputStream("test.txt");
            int size = is.available();
            for (int i = 0; i < size; i++) {
                String s = "  ";
                String c = (char) is.read() + s;
                System.out.print(new String(c.getBytes(), "utf-8"));
            }
            is.close();

        } catch (Exception e) {
            logger.error("FileInputStreamTest.fileStreamTest error:", e);
        }
    }


    /**
     * 以下代码实例来解决乱码问题
     */
    public static void fileStreamTest2() {
        try {
            String path = "d:/FileInputStreamTest.txt";
            File f = new File(path);
            // 构建FileOutputStream对象,文件不存在会自动新建
            FileOutputStream fop = new FileOutputStream(f);
            // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
            OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
            // 写入到缓冲区
            writer.append("中文输入");
            //换行
            writer.append("\r\n");

            writer.append("English");

            // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入
//            writer.flush();
            //关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉
            writer.close();
            //关闭输出流,释放系统资源
            fop.close();

            // 构建FileInputStream对象
            FileInputStream fip = new FileInputStream(f);
            // 构建InputStreamReader对象,编码与写入相同
            InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
            StringBuffer sb = new StringBuffer();

            while (reader.ready()) {
                sb.append((char) reader.read());

            }
            System.err.println(sb.toString());
            reader.close();
            fip.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
