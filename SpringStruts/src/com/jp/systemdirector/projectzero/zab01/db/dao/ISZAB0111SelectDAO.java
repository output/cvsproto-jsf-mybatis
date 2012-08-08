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


public interface ISZAB0111SelectDAO {

    /**
     * <p>findById 処理</p>
     * @param dto 条件が格納された ZAB0111SelectDTO 型オブジェクト
     * @return executeQuery() の実行結果を格納した ZAB0111SelectDTO 型オブジェクトの List
     * @throws java.sql.SQLException
     */
    public List<SZAB0111SelectDTO> findById(SZAB0111SelectDTO dto) throws java.sql.SQLException;
    
    public boolean checkUserinfo(SZAB0111SelectDTO dto) throws java.sql.SQLException;
}
