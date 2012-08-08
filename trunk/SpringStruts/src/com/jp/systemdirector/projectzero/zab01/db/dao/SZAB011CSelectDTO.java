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

/**
 * DB アクセス用 DTO クラス。
 */
public class SZAB011CSelectDTO
        extends java.lang.Object {


    /** IN1 用変数 */
    private java.lang.String IN1;

    /** QUANTITY 用変数 */
    private java.math.BigDecimal QUANTITY;

    /** STORING_ID 用変数 */
    private java.lang.String STORING_ID;


    /**
     * IN1 を java.lang.String 型で取得。</p>
     * @return java.lang.String 型オブジェクト
     */
    public java.lang.String getIN1() {
        return IN1;
    }

    /**
     * QUANTITY を java.math.BigDecimal 型で取得。</p>
     * @return java.math.BigDecimal 型オブジェクト
     */
    public java.math.BigDecimal getQUANTITY() {
        return QUANTITY;
    }

    /**
     * STORING_ID を java.lang.String 型で取得。</p>
     * @return java.lang.String 型オブジェクト
     */
    public java.lang.String getSTORING_ID() {
        return STORING_ID;
    }


    /**
     * IN1 を java.lang.String 型で設定。</p>
     * @param IN1 java.lang.String 型オブジェクト
     */
    public void setIN1(java.lang.String IN1) {
        this.IN1 = IN1;
    }

    /**
     * QUANTITY を java.math.BigDecimal 型で設定。</p>
     * @param QUANTITY java.math.BigDecimal 型オブジェクト
     */
    public void setQUANTITY(java.math.BigDecimal QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    /**
     * STORING_ID を java.lang.String 型で設定。</p>
     * @param STORING_ID java.lang.String 型オブジェクト
     */
    public void setSTORING_ID(java.lang.String STORING_ID) {
        this.STORING_ID = STORING_ID;
    }
    
    
    private java.math.BigDecimal MODIFY_COUNT;
    
    private String UPDATED_DATE;


	public java.math.BigDecimal getMODIFY_COUNT() {
		return MODIFY_COUNT;
	}

	public void setMODIFY_COUNT(java.math.BigDecimal mODIFYCOUNT) {
		MODIFY_COUNT = mODIFYCOUNT;
	}

	public String getUPDATED_DATE() {
		return UPDATED_DATE;
	}

	public void setUPDATED_DATE(String uPDATEDDATE) {
		UPDATED_DATE = uPDATEDDATE;
	}
    
    
}