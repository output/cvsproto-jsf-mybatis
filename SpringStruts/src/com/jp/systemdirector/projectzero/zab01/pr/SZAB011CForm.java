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

import org.apache.struts.validator.ValidatorForm;

import com.jp.systemdirector.projectzero.zab01.pr.SZAB011CStockInfoRegConfirmBean;

/**
  *  画面 com.jp.systemdirector.projectzero.pr.SZAB011CForm に対するフォームクラス。
  *  
  */
public class SZAB011CForm extends ValidatorForm {

	public static final String FORM_ID = "SZAB011C";

    /**
     *  フィールド stockInfoRegConfirm の値を格納するフィールド。
     */
    private java.util.List<SZAB011CStockInfoRegConfirmBean> stockInfoRegConfirm;
    
    /**
     *  フィールド stockInfoRegConfirm の値を設定する。
     */
    public void setStockInfoRegConfirm( java.util.List<SZAB011CStockInfoRegConfirmBean> stockInfoRegConfirm ) {
        this.stockInfoRegConfirm = stockInfoRegConfirm;
    }

    /**
     *  フィールド stockInfoRegConfirm の値を取得する。
     */
    public java.util.List<SZAB011CStockInfoRegConfirmBean> getStockInfoRegConfirm() {
        return this.stockInfoRegConfirm;
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

