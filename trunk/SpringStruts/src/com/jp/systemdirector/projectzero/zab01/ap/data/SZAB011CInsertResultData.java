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

public class SZAB011CInsertResultData  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 376424547021762891L;
	
	// オウンコーディング--start
	private List<ContextData> resultList;

	public List<ContextData> getResultList() {
		return resultList;
	}

	public void setResultList(List<ContextData> resultList) {
		this.resultList = resultList;
	}
	// オウンコーディング--end
	
	private int affectLines;

	public int getAffectLines() {
		return affectLines;
	}

	public void setAffectLines(int affectLines) {
		this.affectLines = affectLines;
	}
		
}

