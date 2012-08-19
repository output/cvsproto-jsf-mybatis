/**
 * 
 */
package li.kang.wang.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * @author kang
 * 
 */
public class PhoneConverter implements Converter {

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext
     * , javax.faces.component.UIComponent, java.lang.String)
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value.isEmpty()) {
            return null;
        }
        PhoneNumber phone = new PhoneNumber();
        String[] phoneComps = value.split(" ,()-");
        String countryCode = phoneComps[0];
        phone.setCountryCode(countryCode);
        if ("1".equals(countryCode)) {
            String areaCode = phoneComps[1];
            String prefix = phoneComps[2];
            String number = phoneComps[3];
            phone.setAreaCode(areaCode);
            phone.setPrefix(prefix);
            phone.setNumber(number);
        } else {
            phone.setNumber(value);
        }
        return phone;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext
     * , javax.faces.component.UIComponent, java.lang.Object)
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        return value.toString();
    }
}
