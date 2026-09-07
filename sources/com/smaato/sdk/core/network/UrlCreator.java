package com.smaato.sdk.core.network;

import android.net.Uri;
import com.smaato.sdk.core.util.Objects;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class UrlCreator {
    public String createUrl(String str, Map<String, String> map) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(map);
        return applyParameters(Uri.parse(str), map).toString();
    }

    private Uri applyParameters(Uri uri, Map map) {
        Uri.Builder builderBuildUpon = uri.buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return builderBuildUpon.build();
    }

    public String extractHostname(String str) {
        Objects.requireNonNull(str, "Parameter url cannot be null for UrlCreator::extractHostname");
        return Uri.parse(str).getHost();
    }

    public String extractScheme(String str) {
        Objects.requireNonNull(str, "Parameter url cannot be null for UrlCreator::extractScheme");
        return Uri.parse(str).getScheme();
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
