package li.kang.wang.badan.intr.pintr001.pr.form;

import java.util.ArrayList;
import java.util.List;

import li.kang.wang.badan.intr.pintr001.ap.data.ListContextData;

/** PINTR001Form用于存储表单信息 */
public class PINTR001Form {

    /** 账号 */
    private String username;

    /** 密码 */
    private String password;

    /** 登录标志 */
    private boolean loginFlag;

    /** 用户列表 */
    private List<ListContextData> list = new ArrayList<ListContextData>();

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the loginFlag
     */
    public boolean getLoginFlag() {
        return loginFlag;
    }

    /**
     * @param loginFlag
     *            the loginFlag to set
     */
    public void setLoginFlag(boolean loginFlag) {
        this.loginFlag = loginFlag;
    }

    /**
     * @return the list
     */
    public List<ListContextData> getList() {
        return list;
    }

    /**
     * @param list
     *            the list to set
     */
    public void setList(List<ListContextData> list) {
        this.list = list;
    }
}
