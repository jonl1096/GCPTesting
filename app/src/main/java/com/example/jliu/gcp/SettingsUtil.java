package com.example.jliu.gcp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Convenience class for working with the SharedPreferences in Android OS
 */
public class SettingsUtil {

    //Shared Prefs
    private static final String SETTINGS_USER = "SETTINGS_USER";
    private static final String SETTINGS_APP = "SETTINGS_APP";

    //Settings
    private static final String SETTING_USER_AUTH_TOKEN = "SETTING_USER_AUTH_TOKEN";
    private static final String SETTING_USER_AUTH_ID = "SETTING_USER_AUTH_ID";
    private static final String SETTING_USER_EMAIL = "SETTING_USER_EMAIL";



    /**
     * Gets the user shared prefs
     * @param pContext
     * @return
     */
    private static SharedPreferences getUserPrefs(Context pContext)
    {

        return pContext.getSharedPreferences(SETTINGS_USER,0);

    }

    /**
     * Gets the App shared prefs
     * @param pContext
     * @return
     */
    private static SharedPreferences getAppPrefs(Context pContext)
    {

        return pContext.getSharedPreferences(SETTINGS_APP,0);

    }

    /**
     * Gets auth token
     * @param pContext
     * @return
     */
    public static String getUserAuthToken(Context pContext)
    {
        String token = getUserPrefs(pContext).getString(SETTING_USER_AUTH_TOKEN, null);
        return token;

    }

    /**
     * Sets auth token
     * @param pContext
     * @param pToken
     */
    public static void setUserAuthToken(Context pContext, String pToken)
    {

        SharedPreferences prefs = getUserPrefs(pContext);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(SETTING_USER_AUTH_TOKEN,pToken);
        editor.commit();

    }

    /**
     * Gets the saved auth id for oauth
     * @param pContext
     * @return
     */
    public static String getUserAuthId(Context pContext)
    {

        return getUserPrefs(pContext).getString(SETTING_USER_AUTH_ID,null);

    }

    /**
     * Sets an auth Id from oauth
     * @param pContext
     * @param pAuthId
     */
    public static void setUserAuthId(Context pContext, String pAuthId)
    {

        SharedPreferences prefs = getUserPrefs(pContext);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(SETTING_USER_AUTH_ID,pAuthId);
        editor.commit();

    }

    /**
     * Gets user's email address
     * @param pContext
     * @return
     */
    public static String getUserEmail(Context pContext)
    {

        return getUserPrefs(pContext).getString(SETTING_USER_EMAIL, null);

    }

    /**
     * Sets users email address
     * @param pContext
     * @param pToken
     */
    public static void setUserEmail(Context pContext, String pToken)
    {

        SharedPreferences prefs = getUserPrefs(pContext);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(SETTING_USER_EMAIL, pToken);
        editor.commit();

    }

    public static boolean hasUserSetEmailInPrefs(Context pContext)
    {

        return (getUserEmail(pContext) != null);

    }

    public static boolean hasUserSetAuthToken(Context pContext)
    {

        return (getUserAuthToken(pContext) != null);

    }

    public static boolean hasUserSetAuthId(Context pContext)
    {

        return (getUserAuthId(pContext) != null);

    }



}
