package jp.lapinitigo.util;

/**
 * Validation Module
 * @author lapin
 */
public class Validate {

    /** 
     * throw IllegalArgumentException when null or empty 
     * @param str validation target
     * @param message exception message
     **/
    public static final void isNullOrEmpty(String str, String message) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException(message);
        }
    }
    
    
}
