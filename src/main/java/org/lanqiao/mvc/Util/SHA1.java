package org.lanqiao.mvc.Util;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletInputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SHA1算法
 * @author Administrator
 *
 */
public class SHA1 {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    // 把密文转换成十六进制的字符串形式
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        try {
            //获取加密对象
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            //加密
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //解析xml包  生成键对值
    public static Map<String, String> parseRequest(ServletInputStream is) {
        Map<String,String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        try {
            // 读取输入流，获取文档对象
            Document document= reader.read(is);
            //获取根节点
            Element root =  document.getRootElement();
            //获取根节点的所有子节点
            List<Element> elements = root.elements();
            for (Element e:elements){
                map.put(e.getName(),e.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }
}
