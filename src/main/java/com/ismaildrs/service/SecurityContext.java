package com.ismaildrs.service;

import java.util.List;

public class SecurityContext {
    public static String username = "";
    private static String password = "";
    private static String[] roles = {};

    public static void authenticate(String u, String p, String[] r) {
        if(u.equals("root") && p.equals("root")){
            username = u;
            password = p;
            roles = r;
        } else {
            throw new SecurityException("Incorrect username or password");
        }
    }

    public static boolean hasRole(String r) {
        for(String s : roles){
            if(s.equals(r)){
                return true;
            }
        }
        return false;
    }

}
