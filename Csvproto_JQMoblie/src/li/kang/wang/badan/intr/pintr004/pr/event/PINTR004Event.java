package li.kang.wang.badan.intr.pintr004.pr.event;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import li.kang.wang.badan.intr.pintr004.ap.data.ContextData;
import li.kang.wang.badan.intr.pintr004.ap.data.SelectResultData;
import li.kang.wang.badan.intr.pintr004.ap.logicbean.ISelectLogicBean;
import li.kang.wang.badan.intr.pintr004.pr.form.PINTR004Form;

import org.apache.log4j.Logger;

/** PINTR001页面Event */
public class PINTR004Event {

    private static Logger log = Logger.getLogger(PINTR004Event.class.getName());

    private PINTR004Form pintr004Form;

    // 通过接口, 可以从faces-config.xml指定pintr004SelectLogicBean对应某个实际的值
    private ISelectLogicBean pintr004SelectLogicBean;

    /**
     * @return the pintr004Form
     */
    public PINTR004Form getPintr004Form() {
        return pintr004Form;
    }

    /**
     * @param pintr004Form
     *            the pintr004Form to set
     */
    public void setPintr004Form(PINTR004Form pintr004Form) {
        this.pintr004Form = pintr004Form;
    }

    /**
     * @return the pintr004SelectLogicBean
     */
    public ISelectLogicBean getPintr004SelectLogicBean() {
        return pintr004SelectLogicBean;
    }

    /**
     * @param pintr004SelectLogicBean
     *            the pintr004SelectLogicBean to set
     */
    public void setPintr004SelectLogicBean(
            ISelectLogicBean pintr004SelectLogicBean) {
        this.pintr004SelectLogicBean = pintr004SelectLogicBean;
    }

    /**
     * 登录验证
     * 
     * @return
     */
    public String checkUser() {

        ContextData contextData = new ContextData();

        log.debug("checkUser:\n" + "username: " + pintr004Form.getUsername()
                + "\n" + "password: " + pintr004Form.getPassword());

        // if (pintr004Form.getUsername().equals("wkl")
        // && pintr004Form.getPassword().equals("wkl")) {
        // return "loginSuccess";
        // }

        // 通过LogicBean查询数据库
        contextData.setUsername(pintr004Form.getUsername());
        contextData.setPassword(pintr004Form.getPassword());
        //
        // if (pintr004SelectLogicBean.checkUserInfo(contextData)) {
        // pintr004Form.setLoginFlag(true);
        // return "loginSuccess";
        // }

        return "loginError";
    }

    /**
     * 取得用户列表
     */
    public String getUserList() {

        SelectResultData resultData = null;

        try {
            // resultData = pintr004SelectLogicBean.getUserList();

            if (resultData != null) {
                // pintr004Form.setList(resultData.getList());
            }

        } catch (Exception e) {

        }

        return "";
    }

    /**
     * 退出登录
     */
    public String logOut() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
        session.removeAttribute("PINTR001Form");

        return "";
    }

    public String changeTheme() {

        return "";
    }

    /**
     * 提交注册
     * 
     * @return
     */
    public String submitRegister() {

        ContextData contextData = new ContextData();

        log.debug("submitRegister:\n" + "username: "
                + pintr004Form.getUsername() + "\n" + "password: "
                + pintr004Form.getPassword());

        // if (pintr004Form.getUsername().equals("wkl")
        // && pintr004Form.getPassword().equals("wkl")) {
        // return "loginSuccess";
        // }

        // 通过LogicBean查询数据库
        contextData.setUsername(pintr004Form.getUsername());
        contextData.setPassword(pintr004Form.getPassword());
        //
        // if (pintr004SelectLogicBean.checkUserInfo(contextData)) {
        // pintr004Form.setLoginFlag(true);
        // return "loginSuccess";
        // }

        return "submitRegister";
    }
}
