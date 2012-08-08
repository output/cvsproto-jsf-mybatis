/*
 * THIS PROGRAM IS GENERATED UNDER LICENSE FROM NEC CORPORATION.
 * 
 * 
 * $Date: 2011/12/19$
 * $Revision: 1.1$
 * $Author: hnnc$
 *
 */

package com.jp.systemdirector.projectzero.zab01.ap.data;

import java.io.Serializable;

import org.apache.struts.upload.FormFile;

/** 保存各个页面之间传递的参数和SQL查询的参数 */
public class ContextData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2799316586308491895L;

	private FormFile upload;			//参照
	
	private String storingDate; 		//入庫日
	
	private String productCd;			//商品コード
	
	private String quantity;			//庫数量

	private String storingQuantity;	//入庫数
	
	private String storingUserCd;		//入庫担当者ID
	
	private String remarks;			//備考
	
	private String newQuantity;		//入庫後数量
	
	private String result;				//処理結果
	
	private String storingId;			//入出庫履歴番号

	private java.math.BigDecimal modifyCount;		//更新回数
	    
	private String updatedDate;		//更新日

	/**
	 * 用户Id
	 */
	private String userid = null;
	
    /**
     * 账号
     */
    private String username = null;
    
    /**
     * 密码
     */
    private String password = null;
	
	public FormFile getUpload() {
		return upload;
	}

	public void setUpload(FormFile upload) {
		this.upload = upload;
	}

	public String getStoringDate() {
		return storingDate;
	}

	public void setStoringDate(String storingDate) {
		this.storingDate = storingDate;
	}

	public String getProductCd() {
		return productCd;
	}

	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getStoringQuantity() {
		return storingQuantity;
	}

	public void setStoringQuantity(String storingQuantity) {
		this.storingQuantity = storingQuantity;
	}

	public String getStoringUserCd() {
		return storingUserCd;
	}

	public void setStoringUserCd(String storingUserCd) {
		this.storingUserCd = storingUserCd;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getNewQuantity() {
		return newQuantity;
	}

	public void setNewQuantity(String newQuantity) {
		this.newQuantity = newQuantity;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStoringId() {
		return storingId;
	}

	public void setStoringId(String storingId) {
		this.storingId = storingId;
	}

	public java.math.BigDecimal getModifyCount() {
		return modifyCount;
	}

	public void setModifyCount(java.math.BigDecimal modifyCount) {
		this.modifyCount = modifyCount;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
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
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }	
	
}

