package li.kang.wang.badan.intr.pintr001.db.dto;

import java.io.Serializable;

/** 数据库表绑定Java Bean */
public class UserInfo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1646885493639314417L;

    /** 账号 */
    private String username;

    /** 密码 */
    private String password;

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
}
