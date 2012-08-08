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
import java.util.List;

public class SZAB011CUpdateResultData implements Serializable{
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8896583474325914013L;
	
	private List<ContextData> resultList;

	public List<ContextData> getResultList() {
		return resultList;
	}

	public void setResultList(List<ContextData> resultList) {
		this.resultList = resultList;
	}
	
	private int affectLines;

	public int getAffectLines() {
		return affectLines;
	}

	public void setAffectLines(int affectLines) {
		this.affectLines = affectLines;
	}
}

