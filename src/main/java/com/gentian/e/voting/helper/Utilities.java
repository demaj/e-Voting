package com.gentian.e.voting.helper;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 *
 * @author Gentian
 */
public class Utilities {
    
    private static final Logger _logger = Logger.getLogger("Utilities");
    
    public static Set<String> getSupportedLanguages(HandleDefault defaultHandler) {
        Application app = FacesContext.getCurrentInstance().getApplication();
        Set<String> languageCodes = new HashSet<>();
        for (Iterator<Locale> itr = app.getSupportedLocales(); itr.hasNext();) {
            Locale locale = itr.next();
            languageCodes.add(locale.getLanguage());
        }
        
        String defaultLang = app.getDefaultLocale().getLanguage();
        if (defaultHandler == HandleDefault.Exclude) {
            languageCodes.remove(defaultLang);
        }
        else {
            // We need to include the default language
            // cause it may or may not be defined as a supported language.
            languageCodes.add(defaultLang);
        }
        return languageCodes;
    }
    
    public enum HandleDefault {
        Include, Exclude
    }
    
    public static String getDefaultLanguage() {
        Application app = FacesContext.getCurrentInstance().getApplication();
        return app.getDefaultLocale().getLanguage();
    }
    
    /**
     * retrieves a localized message from the message bundle
     * 
     * @param key
     * @return 
     */
    public static String getMessage(String key) {
        ResourceBundle messageBundle = ResourceBundle.getBundle("com.gentian.e.voting.messages");
        try {
            return messageBundle.getString(key);
        }
        catch (MissingResourceException mre) {
            return "<unknown resource: " + key + ">";
        }
    }
    
    public static String getMessage(String lang, String key) {
        ResourceBundle messageBundle = ResourceBundle.getBundle("com.gentian.e.voting.messages", new Locale(lang));
        try {
            return messageBundle.getString(key);
        }
        catch (MissingResourceException mre) {
            return "<unknown resource: " + key + ">";
        }
    }
    
    public static String printTree() {
        UIViewRoot root = FacesContext.getCurrentInstance().getViewRoot();
        printTree(root, 0);
        return "";
    }
    
    private static void printTree(UIComponent element, int level) {
        logElement(level, element);
        for (UIComponent child : element.getChildren()) {
            printTree(child, level + 1);
        }
    }
    
    private static void logElement(int level, UIComponent element) {
        String out = "";
        for (int i = 0; i < level; i++) {
            out += "----";
        }
        out += element.getClass().getSimpleName()
                + " - " + element.getFamily()
                + " - " + element.getRendererType();
        _logger.log(Level.INFO, out);
    }
    
}