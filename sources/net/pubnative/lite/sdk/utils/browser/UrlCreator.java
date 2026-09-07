package net.pubnative.lite.sdk.utils.browser;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class UrlCreator {
    public String createUrl(String str, Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("Url can not be null");
        }
        if (map == null) {
            throw new NullPointerException("queryparams can not be null");
        }
        return applyParameters(Uri.parse(str), map).toString();
    }

    private Uri applyParameters(Uri uri, Map<String, String> map) {
        Uri.Builder builderBuildUpon = uri.buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return builderBuildUpon.build();
    }

    public String extractHostname(String str) {
        if (str != null) {
            return Uri.parse(str).getHost();
        }
        throw new NullPointerException("Url can not be null");
    }

    public String extractScheme(String str) {
        if (str != null) {
            return Uri.parse(str).getScheme();
        }
        throw new NullPointerException("Url can not be null");
    }

    public boolean isSecureScheme(String str) {
        return "https".equalsIgnoreCase(str);
    }

    public boolean isInsecureScheme(String str) {
        return "http".equalsIgnoreCase(str);
    }

    public boolean isSupportedForNetworking(String str) {
        String strExtractScheme = extractScheme(str);
        return isSecureScheme(strExtractScheme) || isInsecureScheme(strExtractScheme);
    }
}
