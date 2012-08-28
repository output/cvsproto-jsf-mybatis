package li.kang.wang.badan.common;

import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Property文件解析
 */
public class PropertyFileUtils {

    /** Log */
    private static Logger log = Logger.getLogger(PropertyFileUtils.class
            .getName());

    /** 公共配置文件 */
    private static final String SYSTEM_RESOURCES = "/resources/CommonSetting.properties";

    /**
     * 取得公共配置文件项目的值
     * 
     * @param String
     *            key
     * @return String
     */
    public String getUserId(String key) {
        String userId = "";

        try {

            // Properties对象生成
            Properties prop = new Properties();
            // 循环遍历文件
            prop.load(this.getClass().getResourceAsStream(SYSTEM_RESOURCES));

            // 取得属性对应的值
            userId = prop.getProperty(key);

        } catch (Exception e) {
            log.error(e);
        }

        return userId;
    }
}