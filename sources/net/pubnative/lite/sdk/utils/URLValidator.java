package net.pubnative.lite.sdk.utils;

import android.util.Patterns;
import android.webkit.URLUtil;
import com.json.b9;

/* JADX INFO: loaded from: classes9.dex */
public class URLValidator {
    public static boolean isValidURL(String str) {
        if (str.trim().isEmpty()) {
            return false;
        }
        String strReplace = str.replace(b9.i.d, "%5B").replace(b9.i.e, "%5D");
        return URLUtil.isValidUrl(strReplace) && Patterns.WEB_URL.matcher(strReplace).matches();
    }
}
