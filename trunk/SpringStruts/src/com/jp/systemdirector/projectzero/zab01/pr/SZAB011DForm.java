/*
 * THIS PROGRAM IS GENERATED UNDER LICENSE FROM NEC CORPORATION.
 * 
 * 
 * $Date: 2011/12/19$
 * $Revision: 1.1$
 * $Author: hnnc$
 *
 */
package com.jp.systemdirector.projectzero.zab01.pr;

import org.apache.struts.action.ActionForm;

/**
  *  画面 com.jp.systemdirector.projectzero.pr.SZAB011DForm に対するフォームクラス。
  *  
  */
public class SZAB011DForm extends ActionForm {

	public static final String FORM_ID = "SZAB011D";


    /**
     *  フィールド stockInfoRegResult の値を格納するフィールド。
     */
    private java.util.List<com.jp.systemdirector.projectzero.zab01.pr.SZAB011DStockInfoRegResultBean> stockInfoRegResult = null;
    
    /**
     *  フィールド stockInfoRegResult の値を設定する。
     */
    public void setStockInfoRegResult( java.util.List<com.jp.systemdirector.projectzero.zab01.pr.SZAB011DStockInfoRegResultBean> stockInfoRegResult ) {
        this.stockInfoRegResult = stockInfoRegResult;
    }

    /**
     *  フィールド stockInfoRegResult の値を取得する。
     */
    public java.util.List<com.jp.systemdirector.projectzero.zab01.pr.SZAB011DStockInfoRegResultBean> getStockInfoRegResult() {
        return this.stockInfoRegResult;
    }


    /**
     *  フィールド message の値を格納するフィールド。
     */
    private java.lang.String message = null;
    
    /**
     *  フィールド message の値を設定する。
     */
    public void setMessage( java.lang.String message ) {
        this.message = message;
    }

    /**
     *  フィールド message の値を取得する。
     */
    public java.lang.String getMessage() {
        return this.message;
    }

}

