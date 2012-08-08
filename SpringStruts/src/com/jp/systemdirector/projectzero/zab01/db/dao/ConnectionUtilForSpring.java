/*
 * THIS PROGRAM IS GENERATED UNDER LICENSE FROM NEC CORPORATION.
 * 
 * 
 * $Date: $
 * $Revision: $
 * $Author: $
 *
 */

package com.jp.systemdirector.projectzero.zab01.db.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.web.context.ContextLoader;

/**
 * Spring 用 Connection 取得用クラス。
 * このクラスは、一度生成すると、上書き再生成しない。
 */
public class ConnectionUtilForSpring extends ConnectionUtil {

    private DataSource dataSource = null;

    private Connection conn = null;

    private Class daoCls;

    /**
     * <p>コンストラクタ。</p>
     * @param daoCls 呼び出し元の DAO クラスオブジェクト
     */
    public ConnectionUtilForSpring(Class daoCls) {
        this.daoCls = daoCls;
    }

    /**
     * <p>Connection オブジェクトの取得。</p>
     * @return Connection オブジェクト
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException {
        // ApplicationContextからdataSourceを取得
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        dataSource = (DataSource)context.getBean("dataSource");
        conn = DataSourceUtils.getConnection(dataSource);
        return conn;
    }

    /**
     * <p>Connection の close 処理。</p>
     * @throws SQLException 
     */
    public void close() throws SQLException {
        // Spring がトランザクションを管理しているため connection の close 処理はしない
    }
}
