package li.kang.wang.badan.intr.pintr001.pr.event;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import li.kang.wang.badan.intr.pintr001.ap.data.ContextData;
import li.kang.wang.badan.intr.pintr001.ap.data.SelectResultData;
import li.kang.wang.badan.intr.pintr001.ap.logicbean.ISelectLogicBean;
import li.kang.wang.badan.intr.pintr001.pr.form.PINTR001Form;

import org.apache.log4j.Logger;

/** PINTR001页面Event */
public class PINTR001Event {

    private static Logger log = Logger.getLogger(PINTR001Event.class.getName());

    private PINTR001Form pintr001Form;
    
    // 通过接口, 可以从faces-config.xml指定pintr001SelectLogicBean对应某个实际的值
    private ISelectLogicBean pintr001SelectLogicBean;

    /**
     * @return the pintr001Form
     */
    public PINTR001Form getPintr001Form() {
        return pintr001Form;
    }

    /**
     * @param pintr001Form
     *            the pintr001Form to set
     */
    public void setPintr001Form(PINTR001Form pintr001Form) {
        this.pintr001Form = pintr001Form;
    }

    /**
     * @return the pintr001SelectLogicBean
     */
    public ISelectLogicBean getPintr001SelectLogicBean() {
        return pintr001SelectLogicBean;
    }

    /**
     * @param pintr001SelectLogicBean the pintr001SelectLogicBean to set
     */
    public void setPintr001SelectLogicBean(ISelectLogicBean pintr001SelectLogicBean) {
        this.pintr001SelectLogicBean = pintr001SelectLogicBean;
    }
    
    /**
     * 登录验证
     * 
     * @return
     */
    public String checkUser() {
        
        ContextData contextData = new ContextData();        

        log.debug("checkUser:\n" 
                + "username: " + pintr001Form.getUsername()
                + "\n" + "password: " + pintr001Form.getPassword());
        
//        if (pintr001Form.getUsername().equals("wkl")
//                && pintr001Form.getPassword().equals("wkl")) {
//            return "loginSuccess";
//        }
        
        // 通过LogicBean查询数据库
        contextData.setUsername(pintr001Form.getUsername());
        contextData.setPassword(pintr001Form.getPassword());
        
        if(pintr001SelectLogicBean.checkUserInfo(contextData)){
            pintr001Form.setLoginFlag(true);
            return "loginSuccess";
        }

        return "loginError";
    }
    
    public String getUserList(){
        
        SelectResultData resultData = null;
        
        try {
            resultData = pintr001SelectLogicBean.getUserList();
            
            if (resultData != null) {
                pintr001Form.setList(resultData.getList());
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

}
