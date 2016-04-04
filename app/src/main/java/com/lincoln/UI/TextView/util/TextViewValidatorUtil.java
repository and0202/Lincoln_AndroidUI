package com.lincoln.UI.TextView.util;


import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Created by lincoln on 16/4/3.
 */
public class TextViewValidatorUtil {
    //验证Email
    public static boolean emailValidator(String content){
        boolean result = false;
        if(content != null && !content.equals("")){
            result = Patterns.EMAIL_ADDRESS.matcher(content).matches();
        }
        return  result;
    }
    //验证Phone
    public static boolean phoneValidator(String content){
        boolean result = false;
        String patternContent = "^[1][\\d]{10}";
        if(content != null && !content.equals("")){
            result = Pattern.compile(patternContent).matcher(content).matches();
        }
        return  result;
    }

    //验证Web Url
    public static boolean WebUrlValidator(String content){
        boolean result = false;
        if (isNotEmpty(content)){
            result = Patterns.WEB_URL.matcher(content).matches();
        }
        return  result;
    }

    //验证 domain
    public static boolean domainValidator(String content){
        boolean result = false;
        if (isNotEmpty(content)){
            result = Patterns.DOMAIN_NAME.matcher(content).matches();
        }
        return  result;
    }

    //验证 IP
    public static boolean IPValidator(String content){
        boolean result = false;
        if (isNotEmpty(content)){
            result = Patterns.IP_ADDRESS.matcher(content).matches();
        }
        return  result;
    }


    //验证 内容是否不为空
    public static boolean isNotEmpty(String content){
        boolean result = false;
        if(content != null && !content.equals("")){
            result = true;
        }
        return  result;
    }

}
