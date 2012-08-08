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
 * DB アクセス用個別 DAO クラス（findById 処理）。
 */
public class SZAB0111SelectDAOFindById {

    /**
     * <p>Statement の設定。</p>
     * @param stmt Statement
     * @param dto 条件が格納された ZAB0111SelectDTO 型オブジェクト
     * @throws SQLException
     */
    protected void setStatement(PreparedStatement stmt, SZAB0111SelectDTO dto) throws SQLException {
        // BEGIN SetStatement
        stmt.setString(1, dto.getUserid());
        // END SetStatement
    }

    /**
     * <p>ResultSet からの結果取得。</p>
     * @param rs ResultSet
     * @param dto 結果が格納された ZAB0111SelectDTO 型オブジェクト
     * @throws SQLException
     */
    protected void setResult(ResultSet rs, SZAB0111SelectDTO dto) throws SQLException {
        // BEGIN SetResult
        
        dto.setUserid(rs.getString("USER_ID"));        
        dto.setUsername(rs.getString("USER_NAME"));
        dto.setPassword(rs.getString("PASSWORD"));
        
        // END SetResult
    }

    /**
     * <p>SQL 文の取得。</p>
     * @return SQL 文
     */
    protected String getSQL() {
        // BEGIN SQL
        String sql = "SELECT "
					+"  id AS \"USER_ID\" ,"
					+"  username AS \"USER_NAME\" ,"
					+"  password AS \"PASSWORD\" "
					+"FROM "
					+"  user "
					+"WHERE "
					+"  id = ? ";
                    
        return sql;
        // END SQL
    }

    /**
     * <p>データベースアクセス処理。</p>
     * @param dto ZAB0111SelectDTO 型オブジェクト
     * @return executeQuery() の実行結果を格納した ZAB0111SelectDTO 型オブジェクトの List
     * @throws SQLException 
     */
    public List<SZAB0111SelectDTO> execute(SZAB0111SelectDTO dto) throws SQLException {
      
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
            List<SZAB0111SelectDTO> ret = new ArrayList<SZAB0111SelectDTO>();
            while (rs.next()) {
                SZAB0111SelectDTO res = new SZAB0111SelectDTO();
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
