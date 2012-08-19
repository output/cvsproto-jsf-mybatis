/**
 * 
 */
package li.kang.wang.converters;

import java.io.Serializable;

/**
 * @author kang
 * 
 */
public class PhoneNumber implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -4708156977796560773L;
    private String countryCode;
    private String areaCode;
    private String prefix;
    private String number;

    @Override
    public String toString() {
        if (countryCode.equals("1")) {
            return countryCode + " " + areaCode + " " + prefix + " " + number;
        } else {
            return number;
        }
    }

    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode
     *            the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return the areaCode
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * @param areaCode
     *            the areaCode to set
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @param prefix
     *            the prefix to set
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number
     *            the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

}
