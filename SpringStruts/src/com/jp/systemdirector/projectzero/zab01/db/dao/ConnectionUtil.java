/*
 * THIS PROGRAM IS GENERATED UNDER LICENSE FROM NEC CORPORATION.
 * 
 * 
 * $Date: 2011/12/19$
 * $Revision: 1.1$
 * $Author: hnnc$
 *
 */

package com.jp.systemdirector.projectzero.zab01.db.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Connection 取得用クラスの抽象クラス。
 * このクラスは、一度生成すると、上書き再生成しない。
 */
public abstract class ConnectionUtil {

    /**
     * <p>データソース名取得用抽象メソッド。</p>
     * DAO クラスごとにデータソース名の取得方法を変更する場合は override して利用する。
     * @param daoCls 呼び出し元の DAO クラスオブジェクト
     */
    protected String getDataSourceName(Class daoCls) { return null; }

    /**
     * <p>Connection 取得用抽象メソッド。</p>
     * DAO クラスごとに Connection の取得方法を変更する場合は override して利用する。
     * @param daoCls 呼び出し元の DAO クラスオブジェクト
     */
    protected Connection getConnection(Class daoCls) { return null; }

    /**
     * <p>Bean ID 取得用抽象メソッド。</p>
     * DAO クラスごとに Bean ID を変更する場合は override して利用する。
     * @param daoCls 呼び出し元の DAO クラスオブジェクト
     */
    protected String getBeanId(Class daoCls) { return null; }

    public abstract Connection getConnection() throws SQLException;

    public abstract void close() throws SQLException;
}
