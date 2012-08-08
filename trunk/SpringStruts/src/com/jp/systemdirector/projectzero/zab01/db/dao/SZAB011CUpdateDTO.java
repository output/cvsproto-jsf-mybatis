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

import java.math.BigDecimal;

/**
 * DB アクセス用 DTO クラス。
 */
public class SZAB011CUpdateDTO
        {


    /** QUANTITY 用変数 */
    private BigDecimal QUANTITY;

    /** IN1 用変数 */
    private String IN1;
    

    /**
     * QUANTITY を java.math.BigDecimal 型で取得。</p>
     * @return java.math.BigDecimal 型オブジェクト
     */
    public BigDecimal getQUANTITY() {
        return QUANTITY;
    }

    /**
     * IN1 を String 型で取得。</p>
     * @return String 型オブジェクト
     */
    public String getIN1() {
        return IN1;
    }


    /**
     * QUANTITY を java.math.BigDecimal 型で設定。</p>
     * @param QUANTITY java.math.BigDecimal 型オブジェクト
     */
    public void setQUANTITY(BigDecimal QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    /**
     * IN1 を String 型で設定。</p>
     * @param IN1 String 型オブジェクト
     */
    public void setIN1(String IN1) {
        this.IN1 = IN1;
    }
    
}