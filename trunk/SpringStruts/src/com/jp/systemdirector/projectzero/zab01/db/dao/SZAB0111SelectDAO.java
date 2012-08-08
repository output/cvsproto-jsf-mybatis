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

import java.sql.SQLException;
import java.util.List;

/**
 *  DB アクセス用 DAO クラス。
 */
public class SZAB0111SelectDAO
        extends java.lang.Object implements com.jp.systemdirector.projectzero.zab01.db.dao.ISZAB0111SelectDAO {


    /**
     * <p>findById 処理</p>
     * @param dto 条件が格納された ZAB0111SelectDTO 型オブジェクト
     * @return executeQuery() の実行結果を格納した ZAB0111SelectDTO 型オブジェクトの List
     * @throws java.sql.SQLException
     */
    public List<SZAB0111SelectDTO> findById(SZAB0111SelectDTO dto) throws java.sql.SQLException {
        SZAB0111SelectDAOFindById dao = new SZAB0111SelectDAOFindById();
        List<SZAB0111SelectDTO> ret = dao.execute(dto);
        return ret;
    }

    @Override
    public boolean checkUserinfo(SZAB0111SelectDTO dto)
            throws SQLException {
        SZAB0111SelectDAOCheckUserinfo dao = new SZAB0111SelectDAOCheckUserinfo();
       return dao.execute(dto);
    }
    
}
