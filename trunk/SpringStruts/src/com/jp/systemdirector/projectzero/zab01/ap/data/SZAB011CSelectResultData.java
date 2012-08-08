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

public class SZAB011CSelectResultData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3420119637207977313L;
	
	private List<ContextData> resultList;

	public List<ContextData> getResultList() {
		return resultList;
	}

	public void setResultList(List<ContextData> resultList) {
		this.resultList = resultList;
	}
}

