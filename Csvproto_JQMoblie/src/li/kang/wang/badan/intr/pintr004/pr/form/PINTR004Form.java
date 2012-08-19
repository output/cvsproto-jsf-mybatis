package li.kang.wang.badan.intr.pintr004.pr.form;

/** PINTR004Form用于存储用户注册信息 */
public class PINTR004Form {

    /** 注册账号 */
    private String username;

    /** 注册密码 */
    private String password;

    /** 真实姓名 */
    private String truename;

    /** 年龄 */
    private int age;

    /** 注册邮箱 */
    private String email;

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

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}