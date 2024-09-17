package com.mvc.homework.util;

public interface PasswordEncoder {

    /** 加密 */
	String encode(String rawPassword);

    /** 驗證 */
    boolean matches(String rawPassword, String encodedPassword);
    
}
