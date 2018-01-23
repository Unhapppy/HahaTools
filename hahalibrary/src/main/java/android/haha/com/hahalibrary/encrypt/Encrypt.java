package android.haha.com.hahalibrary.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/12/19 0019.
 */

public class Encrypt
{


    /**
     * 传入文本内容，返回 SHA串
     *
     * @param  strText
     * @return 密文
     */

    public static String SHA1(final String strText)
    {
        return SHA(strText, "SHA-1");
    }

    public static String SHA224(final String strText)
    {
        return SHA(strText, "SHA-224");
    }

    public static String SHA256(final String strText)
    {
        return SHA(strText, "SHA-256");
    }

    public static String SHA384(final String strText)
    {
        return SHA(strText, "SHA-384");
    }

    public static String SHA512(final String strText)
    {
        return SHA(strText, "SHA-512");
    }


    /**
     * 字符串 SHA 加密
     *
     * @param
     * @return
     */
    private static String SHA(final String strText, final String strType)
    {
        // 返回值
        String strResult = null;

        // 字符串是否有效
        if (strText != null && strText.length() > 0)
        {
            try
            {
                // SHA 加密开始
                // 创建加密对象 传入加密类型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes());
                // 得到 byte 类型结果
                byte byteBuffer[] = messageDigest.digest();

                // 将 byte 转换为 string
                StringBuffer strHexString = new StringBuffer();
                // 遍历 byte buffer
                for (int i = 0; i < byteBuffer.length; i++)
                {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1)
                    {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回结果
                strResult = strHexString.toString();
            }
            catch (NoSuchAlgorithmException e)
            {
                e.printStackTrace();
            }
        }

        return strResult;
    }
}