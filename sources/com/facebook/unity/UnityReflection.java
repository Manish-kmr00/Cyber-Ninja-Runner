package com.facebook.unity;

import android.app.Activity;
import android.util.Log;
import com.unity3d.services.core.properties.MadeWithUnityDetector;

/* JADX INFO: loaded from: classes9.dex */
public class UnityReflection {
    private static Class<?> unityPlayer;

    public static void SendMessage(String str, String str2, String str3) {
        try {
            if (unityPlayer == null) {
                unityPlayer = Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
            }
            unityPlayer.getMethod("UnitySendMessage", String.class, String.class, String.class).invoke(unityPlayer, str, str2, str3);
        } catch (Exception e) {
            Log.d("TODO", e.toString());
        }
    }

    public static Activity GetUnityActivity() {
        try {
            if (unityPlayer == null) {
                unityPlayer = Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
            }
            Activity activity = (Activity) unityPlayer.getField("currentActivity").get(null);
            if (activity == null) {
                Log.d(FB.TAG, "Current unity activity is null");
            }
            return activity;
        } catch (Exception e) {
            Log.d(FB.TAG, e.toString());
            return null;
        }
    }
}
