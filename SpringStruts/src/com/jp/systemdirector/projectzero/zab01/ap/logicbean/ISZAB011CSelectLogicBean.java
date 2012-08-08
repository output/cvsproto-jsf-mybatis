/*
 * THIS PROGRAM IS GENERATED UNDER LICENSE FROM NEC CORPORATION.
 * 
 * 
 * $Date: 2011/12/19$
 * $Revision: 1.1$
 * $Author: hnnc$
 *
 */

package com.jp.systemdirector.projectzero.zab01.ap.logicbean;


public interface ISZAB011CSelectLogicBean {

	public static final String BEAN_ID = "SZAB011CSelect";

	public com.jp.systemdirector.projectzero.zab01.ap.data.SZAB011CSelectResultData execute(
		com.jp.systemdirector.projectzero.zab01.ap.data.ContextData context,
		com.jp.systemdirector.projectzero.zab01.ap.data.SZAB011CSelectInputData inputData);
	
	public com.jp.systemdirector.projectzero.zab01.ap.data.SZAB011CSelectResultData getStoringId(
			com.jp.systemdirector.projectzero.zab01.ap.data.ContextData context,
			com.jp.systemdirector.projectzero.zab01.ap.data.SZAB011CSelectInputData inputData);
}
