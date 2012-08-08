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

import com.jp.systemdirector.projectzero.zab01.ap.data.ContextData;

public class SZAB0111SelectResultData implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2436767078140381296L;
	// オウンコーディング--start
	private List<ContextData> resultList;

	public List<ContextData> getResultList() {
		return resultList;
	}

	public void setResultList(List<ContextData> resultList) {
		this.resultList = resultList;
	}
	// オウンコーディング--end
	
}

