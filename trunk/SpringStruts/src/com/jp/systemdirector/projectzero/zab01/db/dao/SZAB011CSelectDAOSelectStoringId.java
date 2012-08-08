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
import java.util.ArrayList;
import java.util.List;

/**
 * DB アクセス用個別 DAO クラス（selectStoringId 処理）。
 */
public class SZAB011CSelectDAOSelectStoringId {

    /**
     * <p>Statement の設定。</p>
     * @param stmt Statement
     * @param dto 条件が格納された SZAB011CSelectDTO 型オブジェクト
     * @throws SQLException
     */
    protected void setStatement(PreparedStatement stmt, SZAB011CSelectDTO dto) throws SQLException {
        // BEGIN SetStatement
        // END SetStatement
    }

    /**
     * <p>ResultSet からの結果取得。</p>
     * @param rs ResultSet
     * @param dto 結果が格納された SZAB011CSelectDTO 型オブジェクト
     * @throws SQLException
     */
    protected void setResult(ResultSet rs, SZAB011CSelectDTO dto) throws SQLException {
        // BEGIN SetResult
        dto.setSTORING_ID(rs.getString(1));
        // END SetResult
    }

    /**
     * <p>SQL 文の取得。</p>
     * @return SQL 文
     */
    protected String getSQL() {
        // BEGIN SQL
        String sql = "SELECT "
					+"  LPAD(SZAB001T.NEXTVAL, 8, '0') AS STORING_ID "
					+"FROM "
					+"  dual";
        return sql;
        // END SQL
    }

    /**
     * <p>データベースアクセス処理。</p>
     * @param dto SZAB011CSelectDTO 型オブジェクト
     * @return executeQuery() の実行結果を格納した SZAB011CSelectDTO 型オブジェクトの List
     * @throws SQLException 
     */
    public List<SZAB011CSelectDTO> execute(SZAB011CSelectDTO dto) throws SQLException {
        // BEGIN Execute
        PreparedStatement stmt = null;
        ConnectionUtil util = null;
        ResultSet rs = null;
        try {
            Connection conn = null;
            ConnectionUtilFactory factory = ConnectionUtilFactory.getInstance();
            util = factory.create(this.getClass());
            if (util == null) {
                return null;
            } else {
                conn = util.getConnection();
                if (conn == null) {
                    return null;
                }
            }
            stmt = conn.prepareStatement(getSQL());
            setStatement(stmt, dto);
            // SELECT 文の発行
            rs = stmt.executeQuery();
            List<SZAB011CSelectDTO> ret = new ArrayList<SZAB011CSelectDTO>();
            while (rs.next()) {
                SZAB011CSelectDTO res = new SZAB011CSelectDTO();
                setResult(rs, res);
                ret.add(res);
            }
            return ret;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
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
