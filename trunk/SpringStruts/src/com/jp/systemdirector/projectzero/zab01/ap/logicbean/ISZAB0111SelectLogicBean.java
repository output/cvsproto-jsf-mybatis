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

import com.jp.systemdirector.projectzero.zab01.ap.data.ContextData;
import com.jp.systemdirector.projectzero.zab01.ap.data.SZAB0111SelectInputData;
import com.jp.systemdirector.projectzero.zab01.ap.data.SZAB0111SelectResultData;

public interface ISZAB0111SelectLogicBean {

    public static final String BEAN_ID = "SZAB0111Select";

    /**
     * 
     * @param context
     *            共通查询条件 保存各个页面之间传递的参数和SQL查询的参数
     * @param inputData
     *            查询条件
     * @return
     */
    public SZAB0111SelectResultData getUserById(ContextData context,
            SZAB0111SelectInputData inputData);

    public boolean checkUserInfo(ContextData context,
            SZAB0111SelectInputData inputData);
}
