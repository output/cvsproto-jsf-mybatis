package li.kang.wang.badan.intr.pintr001.ap.data;

/** 用于存储多条记录常用表格显示,如XX产品一览 */
public class ListContextData {
    /** ID */
    private int userId;
    
    /** 账号 */
    private String username;
    
    /** 密码 */
    private String password;

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

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
