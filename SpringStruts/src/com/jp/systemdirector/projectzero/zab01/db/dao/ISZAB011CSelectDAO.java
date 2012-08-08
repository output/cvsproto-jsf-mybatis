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

import java.util.List;


public interface ISZAB011CSelectDAO {

    /**
     * <p>selectStoringId 処理</p>
     * @param dto 条件が格納された SZAB011CSelectDTO 型オブジェクト
     * @return executeQuery() の実行結果を格納した SZAB011CSelectDTO 型オブジェクトの List
     * @throws java.sql.SQLException
     */
    public List<SZAB011CSelectDTO> selectStoringId(SZAB011CSelectDTO dto) throws java.sql.SQLException;

    /**
     * <p>findById 処理</p>
     * @param dto 条件が格納された SZAB011CSelectDTO 型オブジェクト
     * @return executeQuery() の実行結果を格納した SZAB011CSelectDTO 型オブジェクトの List
     * @throws java.sql.SQLException
     */
    public List<SZAB011CSelectDTO> findById(SZAB011CSelectDTO dto) throws java.sql.SQLException;
}
