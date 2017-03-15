package jp.lapinitigo.util;

/**
 * Validation Module
 * @author lapin
 */
public class Validate {

    /** 
     * throw IllegalArgumentException if not null or not empty 
     * @param str validation target
     * @param message exception message
     **/
    public static final void isEmpty(String str, String message) {
        if (str != null && str.length() > 0) {
            throw new IllegalArgumentException(message);
        }
    }

    /** 
     * throw IllegalArgumentException if null or empty 
     * @param str validation target
     * @param message exception message
     **/
    public static final void isNotEmpty(String str, String message) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException(message);
        }
    }
    
    
}
