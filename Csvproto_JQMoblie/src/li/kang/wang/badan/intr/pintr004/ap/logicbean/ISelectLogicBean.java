package li.kang.wang.badan.intr.pintr004.ap.logicbean;

import li.kang.wang.badan.intr.pintr001.ap.data.ContextData;
import li.kang.wang.badan.intr.pintr001.ap.data.SelectResultData;

/** ISelectLogicBean接口 */
public interface ISelectLogicBean {

    /**
     * 查询用户信息
     */
    public SelectResultData getUserList();

    /**
     * 验证用户信息
     */
    public boolean checkUserInfo(ContextData contextData);
}
