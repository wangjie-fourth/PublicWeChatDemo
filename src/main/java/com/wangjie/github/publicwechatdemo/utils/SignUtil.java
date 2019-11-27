package com.wangjie.github.publicwechatdemo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @ClassName SignUtil
 * @Description
 * @Author 25127
 * @Date 2019/9/7 12:15
 * @Email jie.wang13@hand-china.com
 **/
public class SignUtil {
    // 与接口配置信息中的Token要一致
    private static String token = "publicwechatdemo18856435267wj";
    private static String EncodingAESKey = "VnGGNPCUPn2dsZ95pBdQsZtrCE60sAGjbDU59aIcwL3";

    /**
     * 方法名：checkSignature</br>
     * 详述：验证签名</br>
     * 开发人员：souvc</br>
     * 创建时间：2015-9-29  </br>
     *
     * @param signature 微信加密签名
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @return          验证成功，返回true
     */
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(
            value="DM_DEFAULT_ENCODING",
            justification="I know what I'm doing")
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        // 1.将token、timestamp、nonce三个参数进行字典序排序
        String[] arr = new String[]{token, timestamp, nonce};
        Arrays.sort(arr);

        // 2. 将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密

            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        content = null;
        // 3.将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 方法名：byteToStr</br>
     * 详述：将字节数组转换为十六进制字符串</br>
     * 开发人员：souvc </br>
     * 创建时间：2015-9-29  </br>
     *
     * @param byteArray 字节数组
     * @return         将字节数组转换为十六进制字符串
     */
    private static String byteToStr(byte[] byteArray) {
        StringBuffer strDigest = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            strDigest.append(byteToHexStr(byteArray[i]));
        }
        return strDigest.toString();
    }

    /**
     * 方法名：byteToHexStr</br>
     * 详述：将字节转换为十六进制字符串</br>
     * 开发人员：souvc</br>
     * 创建时间：2015-9-29  </br>
     *
     * @param mByte 字节
     * @return      十六进制字符串
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
}
