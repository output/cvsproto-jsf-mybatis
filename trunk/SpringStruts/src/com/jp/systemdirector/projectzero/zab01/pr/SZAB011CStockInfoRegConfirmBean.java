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

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 画面のリスト項目 com.jp.systemdirector.projectzero.pr.SZAB011CStockInfoRegConfirmBean
 * に対する Bean クラス。
 * 
 */
public class SZAB011CStockInfoRegConfirmBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2672855591203554597L;

	/**
	 * 入庫日
	 */
	private String storingDate = null;

	/**
	 * 商品コード
	 */
	private String productCd = null;

	/**
	 * 入庫後数量
	 */
	private BigDecimal quantity = null;

	/**
	 * 入庫数
	 */
	private BigDecimal storingQuantity = null;

	/**
	 * 入庫担当者ID
	 */
	private String storingUserCd = null;

	/**
	 * 備考
	 */
	private String remarks = null;
	
	/**
	 * 更新回数
	 */	
	private java.math.BigDecimal modifyCount = null;
    
	/**
	 * 更新日
	 */
	private String updatedDate = null;
	

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

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getStoringQuantity() {
		return storingQuantity;
	}

	public void setStoringQuantity(BigDecimal storingQuantity) {
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

}
