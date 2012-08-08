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

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Connection オブジェクト生成クラス。
 * このクラスは、一度生成すると、上書き再生成しない。
 * ConnectionUtil クラスを切り替えたい場合、connection-util.propertiesの
 * connection.classを変更する。
 * このクラスはSingletonのため、インスタンスを取得する場合は
 * getInstance()メソッドを利用する。
 */
public class ConnectionUtilFactory {

    private static class ConnectionUtilFactoryException extends RuntimeException {
        public ConnectionUtilFactoryException(String errorCode, String errorMessage, Throwable e) {
            super(errorCode + ": " + errorMessage, e);
        }
    }

    /** プロパティファイル名 */
    protected final static String PROPERTY_FILE_NAME = "connection-util.properties";

    /** コネクションクラスを取得するキー */
    protected final static String CONNECTION_CLASS_KEY = "connection.class";

    private String connectionClassName = null;

    private static ConnectionUtilFactory instance = null;

    private ConnectionUtilFactory () {

        BufferedInputStream bis = null;
        try {
            // プロパティファイルからコネクションクラスを取得する
            bis = new BufferedInputStream(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTY_FILE_NAME));
            Properties prop = new Properties();
            prop.load(bis);
            connectionClassName = prop.getProperty(CONNECTION_CLASS_KEY);
            if (connectionClassName == null) {
                connectionClassName = "";
            }

        } catch (IOException e) {
            throw new ConnectionUtilFactoryException("SDE-EJD00001", "ファイルの読み込みに失敗しました。", e);

        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new ConnectionUtilFactoryException("SDE-EJD00003", "ファイルのクローズに失敗しました。", e);
                }
            }
        }
    }

    /**
     * コンストラクタの代わりに利用するインスタンス取得メソッド。
     */
    public static ConnectionUtilFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionUtilFactory();
        }
        return instance;
    }

    /**
     * <p>ConnectionUtil オブジェクトの生成。</p>
     * connection-util.propertiesで指定されたコネクションクラスのインスタンスを生成
     * @param cls 呼び出し元の Class オブジェクト
     * @return ConnectionUtil オブジェクト
     */
    public ConnectionUtil create(Class cls) {
        
        ConnectionUtil util = null;
        Class connectionClass = null;
        try {
            if (connectionClassName.indexOf(".") < 0) {
                // connection.classの指定がクラス名だけの場合は呼び出し元と同じパッケージを補完
                connectionClass = Class.forName(this.getClass().getPackage().getName() + '.' + connectionClassName);
            } else {
                // connection.classの指定が完全修飾名の場合はそのまま利用
                connectionClass = Class.forName(connectionClassName);
            }
            util = (ConnectionUtil)connectionClass.getConstructor(new Class[]{Class.class}).newInstance(cls);
        } catch (ClassNotFoundException e) {
            throw new ConnectionUtilFactoryException("SDE-EJD00002", PROPERTY_FILE_NAME + "の" + CONNECTION_CLASS_KEY + "の値が不正です。", e);

        } catch (Exception e) {
            throw new ConnectionUtilFactoryException("SDE-EJD00004", connectionClass.getName() + "クラスのインスタンスを生成できません。", e);
        }
        return util;
    }
}
