package com.jp.systemdirector.projectzero.util;

public class RemoveSpace {
    
    /**
     *  文字列前後のスペースを削除
     */
    public static String delSpace(String str) throws Exception {  
        
        if (str == null) { 
            return null;  
        }  
          
        String regStartSpace = "^[　 ]*";
        String regEndSpace = "[　 ]*$";          
        
        String strDelSpace = str.replaceAll(regStartSpace, "").replaceAll(regEndSpace, "");  
          
        return strDelSpace;  
    }  
}
