/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strings;

import java.util.ResourceBundle;

/**
 *
 * @author Fahid Shehzad
 */
public class Language {
    private static final String LANGUAGE_RESOURCE_PFAD = "strings/language";
    private static ResourceBundle language = ResourceBundle.getBundle(LANGUAGE_RESOURCE_PFAD);
    
    public static String getString(String key) {
        String value = null;
        if(!language.containsKey(key)) {
            value = language.getString("StringNotFound");
        } else {
            value = language.getString(key);
        }
        return value;
    }
}
