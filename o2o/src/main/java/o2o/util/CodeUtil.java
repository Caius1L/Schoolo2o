package o2o.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
       public static boolean checkVerifyCode(HttpServletRequest request) {
    	   String checkVerifyExcepted=(String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
    	   String VerifyCodeActual =HttpServletRequestUtil.getString(request, "verifyCodeActual");
    	   if(VerifyCodeActual==null||!VerifyCodeActual.equals(checkVerifyExcepted)) {
    		   return false;
    	   }else {
    		   return true;
    	   }
       }
}
