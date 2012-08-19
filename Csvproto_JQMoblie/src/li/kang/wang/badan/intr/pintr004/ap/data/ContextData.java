package li.kang.wang.badan.intr.pintr004.ap.data;

import java.util.Date;

/** 保存各个页面之间传递的参数和SQL查询的参数 */
public class ContextData {

    /** 注册账号 */
    private String username;

    /** 注册密码 */
    private String password;

    /** 真实姓名 */
    private String truename;

    /** 年龄 */
    private int age;

    /** 出生年月(yyyy/MM) */
    private Date birthday;

    /** 注册邮箱 */
    private String email;

    /** 电话 */
    private String phone;

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
     * @return the truename
     */
    public String getTruename() {
        return truename;
    }

    /**
     * @param truename
     *            the truename to set
     */
    public void setTruename(String truename) {
        this.truename = truename;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age
     *            the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     *            the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     *            the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
