
package li.kang.wang.badan.common;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * 系统公共SqlMap配置
 */
public class SqlConfig {
    /** sqlMap instance */
    private static SqlMapClient sqlMap;

    /** Log */
    private static Logger log = Logger.getLogger(SqlConfig.class.getName());

    /** 静态代码块优先执行 */
    static {

        Reader reader = null;

        try {
            String resource = "ibatis/resources/SqlMapConfig.xml";
            Resources.setCharset(Charset.forName("UTF-8"));
            reader = Resources.getResourceAsReader(resource);
            sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
        } catch (Exception e) {
            log.error("SqlMapConfig.xml连接异常");
            log.error(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error("SqlMapConfig.xml连接异常");
                    log.error(e);
                }
            }
        }
    }

    /**
     * SqlMap实例取得
     * @return SqlMapClient
     */
    public static SqlMapClient getSqlMapInstance() {
        return sqlMap;
    }
}