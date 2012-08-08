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

public class SZAB011CSelectInputData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1032640283981995074L;

	private String productCd = null;			//商品コード
	
	private String quantity = null;			//入庫後数量
	
	private String storingId = null;			//入出庫履歴番号
	
	private String storingQuantity = null;		//入庫数
	
	private String storingDate = null;	 		//入庫日
	
	private String storingUserCd = null;		//入庫担当者ID
	
	private String remarks = null;				//備考	
	

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

	public String getStoringId() {
		return storingId;
	}

	public void setStoringId(String storingId) {
		this.storingId = storingId;
	}

	public String getStoringQuantity() {
		return storingQuantity;
	}

	public void setStoringQuantity(String storingQuantity) {
		this.storingQuantity = storingQuantity;
	}

	public String getStoringDate() {
		return storingDate;
	}

	public void setStoringDate(String storingDate) {
		this.storingDate = storingDate;
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
	
	
	
	
}

