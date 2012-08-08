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

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

/**
 * 画面 com.jp.systemdirector.projectzero.pr.SZAB0111Form に対するフォームクラス。
 * 
 */
public class SZAB0111Form extends ValidatorForm {

	public static final String FORM_ID = "SZAB0111";

	/**
	 * フィールド upload の値を格納するフィールド。
	 */
	private FormFile upload = null;
	
	/**
	 * 账号
	 */
	private String username = null;
	
	/**
	 * 密码
	 */
	private String password = null;

	/**
	 * フィールド upload の値を設定する。
	 */
	public void setUpload(FormFile upload) {
		this.upload = upload;
	}

	/**
	 * フィールド upload の値を取得する。
	 */
	public FormFile getUpload() {
		return this.upload;
	}

	/**
	 * フィールド message の値を格納するフィールド。
	 */
	private java.lang.String message = null;

	/**
	 * フィールド message の値を設定する。
	 */
	public void setMessage(java.lang.String message) {
		this.message = message;
	}

	/**
	 * フィールド message の値を取得する。
	 */
	public java.lang.String getMessage() {
		return this.message;
	}

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
