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

public interface ISZAB011CInsertDAO {

    /**
     * <p>insert 処理</p>
     * @param dto 条件が格納された ZAB011CInsertDTO 型オブジェクト
     * @return executeUpdate() を実行した結果の戻り値、Connection の取得に失敗した場合は -1
     * @throws java.sql.SQLException
     */
    public int insert(SZAB011CInsertDTO dto) throws java.sql.SQLException;
}
