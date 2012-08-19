package li.kang.wang.badan.intr.pintr004.ap.data;

/** 保存各个页面之间传递的参数和SQL查询的参数 */
public class ContextData {
    
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
     * @param username the username to set
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
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
