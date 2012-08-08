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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB アクセス用個別 DAO クラス（insert 処理）。
 */
public class SZAB011CInsertDAOInsert {

    /**
     * <p>Statement の設定。</p>
     * @param stmt Statement
     * @param dto 条件が格納された ZAB011CInsertDTO 型オブジェクト
     * @throws SQLException
     */
    protected void setStatement(PreparedStatement stmt, SZAB011CInsertDTO dto) throws SQLException {
        // BEGIN SetStatement
        stmt.setString(1, dto.getSTORING_ID());
        stmt.setString(2, dto.getPRODUCT_CD());
        stmt.setInt(3, dto.getSTORINGQUANTITY());
        stmt.setString(4, dto.getSTORING_DATE());
        stmt.setString(5, dto.getSTORINGUSER_ID());
        stmt.setString(6, dto.getREMARKS());        
        // END SetStatement
    }

    /**
     * <p>ResultSet からの結果取得。</p>
     * @param rs ResultSet
     * @param dto 結果が格納された ZAB011CInsertDTO 型オブジェクト
     * @throws SQLException
     */
    protected void setResult(ResultSet rs, SZAB011CInsertDTO dto) throws SQLException {
        // BEGIN SetResult
        // END SetResult
    }

    /**
     * <p>SQL 文の取得。</p>
     * @return SQL 文
     */
    protected String getSQL() {
        // BEGIN SQL
        String sql = "INSERT INTO "
					+"  TZAA004T(STORING_ID, PRODUCT_CD, STORINGQUANTITY, STORING_DATE, STORINGUSER_ID, REMARKS, CREATED_DATE, CREATED_BY, CREATED_PRG_NM, UPDATED_DATE, UPDATED_BY, UPDATED_PRG_NM, MODIFY_COUNT ) "
					+"VALUES "
					+"  (?, ?, ?, ?, ?, ?, sysdate, 'hnnc', 'SZAB011C', sysdate, 'hnnc', 'SZAB011C', 0)";
        return sql;
        // END SQL
    }

    /**
     * <p>データベースアクセス処理。</p>
     * @param dto ZAB011CInsertDTO 型オブジェクト
     * @return executeUpdate() を実行した結果の戻り値、Connection の取得に失敗した場合は -1
     * @throws SQLException 
     */
    public int execute(SZAB011CInsertDTO dto) throws SQLException {
        // BEGIN Execute
        PreparedStatement stmt = null;
        ConnectionUtil util = null;
        try {
            Connection conn = null;
            ConnectionUtilFactory factory = ConnectionUtilFactory.getInstance();
            util = factory.create(this.getClass());
            if (util == null) {
                return -1;
            } else {
                conn = util.getConnection();
                if (conn == null) {
                    return -1;
                }
            }
            stmt = conn.prepareStatement(getSQL());
            setStatement(stmt, dto);
            // UPDATE/INSERT/DELETE 文の発行
            int ret = stmt.executeUpdate();
            return ret;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (util != null) {
                try {
                    util.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // END Execute
    }
}
