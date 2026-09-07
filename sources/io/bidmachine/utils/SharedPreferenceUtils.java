package io.bidmachine.utils;

import android.content.SharedPreferences;
import java.util.Iterator;

/* JADX INFO: loaded from: classes12.dex */
public class SharedPreferenceUtils {
    public static String optString(SharedPreferences sharedPreferences, String str, String str2) {
        String string;
        try {
            return (!sharedPreferences.contains(str) || (string = sharedPreferences.getString(str, str2)) == null) ? str2 : string;
        } catch (Exception unused) {
        }
    }

    public static int optInt(SharedPreferences sharedPreferences, String str, int i) {
        try {
            if (sharedPreferences.contains(str)) {
                return sharedPreferences.getInt(str, i);
            }
        } catch (Exception unused) {
        }
        return i;
    }

    public static long optLong(SharedPreferences sharedPreferences, String str, long j) {
        try {
            if (sharedPreferences.contains(str)) {
                return sharedPreferences.getLong(str, j);
            }
        } catch (Exception unused) {
        }
        return j;
    }

    public static void putString(SharedPreferences sharedPreferences, String str, String str2) {
        if (str2 == null) {
            remove(sharedPreferences, str);
        } else {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public static void putLong(SharedPreferences sharedPreferences, String str, Long l) {
        if (l == null) {
            remove(sharedPreferences, str);
        } else {
            sharedPreferences.edit().putLong(str, l.longValue()).apply();
        }
    }

    public static void remove(SharedPreferences sharedPreferences, String str) {
        sharedPreferences.edit().remove(str).apply();
    }

    public static void remove(SharedPreferences sharedPreferences, String... strArr) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        for (String str : strArr) {
            editorEdit.remove(str);
        }
        editorEdit.apply();
    }

    public static void clear(SharedPreferences sharedPreferences) {
        Iterator<String> it = sharedPreferences.getAll().keySet().iterator();
        while (it.hasNext()) {
            sharedPreferences.edit().remove(it.next()).apply();
        }
    }
}
