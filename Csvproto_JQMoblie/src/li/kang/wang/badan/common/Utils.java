package li.kang.wang.badan.common;

import java.math.BigDecimal;
import java.math.BigInteger;

/** 系统公共工具类 */
public final class Utils {

    private Utils() {

    }

    /**
     * object转换成数字
     * 
     * @param value
     *            数字字符串
     * @return BigDecimal型数字
     */
    public static BigDecimal convertToBigDecimal(Object value) {
        BigDecimal ret = null;

        if (value != null) {
            if (value instanceof BigDecimal) {
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                ret = new BigDecimal(((Number) value).doubleValue());
            } else {
                ret = new BigDecimal("0");
            }
        }
        return ret;
    }

    /**
     * object转换成字符串
     * 
     * @param value
     * @return 字符串
     */
    public static String convertToString(Object value) {
        String ret = "";

        if (value != null) {
            ret = String.valueOf(value);
        }

        return ret;
    }

    /**
     * 从左侧填充半角字符
     * 
     * @param inData
     * @param totalSize
     * @param padChar
     * @return
     */
    public static String PadLeftInHalf(String inData, int totalSize,
            char padChar) {
        return padInHalf(inData, totalSize, padChar, true);
    }

    /**
     * 从右侧填充半角字符
     * 
     * @param inData
     * @param totalSize
     * @param padChar
     * @return
     */
    public static String PadRightInHalf(String inData, int totalSize,
            char padChar) {
        return padInHalf(inData, totalSize, padChar, false);
    }

    /**
     * 填充半角字符
     * 
     * @param inData
     * @param totalSize
     * @param padChar
     * @param isPadLeft
     * @return
     */
    private static String padInHalf(String inData, int totalSize, char padChar,
            boolean isPadLeft) {

        String retData = inData;

        int deltSize = getDeltSize(inData, totalSize);

        if (deltSize > 0) {
            for (int i = 0; i < deltSize; i++) {
                if (isPadLeft) {
                    retData = padChar + retData;
                } else {
                    retData += padChar;
                }
            }
        }

        return retData;
    }

    /**
     * 取得字符串长度差
     * 
     * @param inData
     * @param totalSize
     * @return
     */
    private static int getDeltSize(String inData, int totalSize) {
        int dataLen = inData.getBytes().length;

        return (totalSize - dataLen);
    }

    /**
     * 删除字符串前后的空格(包括全角和半角)
     */
    public static String delSpace(String str) {

        if (str == null) {
            return null;
        }

        String regStartSpace = "^[�@ ]*";
        String regEndSpace = "[�@ ]*$";

        String strDelSpace = str.replaceAll(regStartSpace, "").replaceAll(
                regEndSpace, "");

        return strDelSpace;
    }

    /**
     * 删除字符串前后的半角空格
     */
    public static String delHalfSpace(String str) {

        if (str == null) {
            return "";
        }

        return str.trim();
    }
}
