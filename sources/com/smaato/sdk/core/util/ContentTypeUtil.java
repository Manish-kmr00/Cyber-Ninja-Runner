package com.smaato.sdk.core.util;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes8.dex */
public final class ContentTypeUtil {
    private static final Pattern PATTERN_CHARSET = Pattern.compile("\\A.*charset=([^\\s;]+)", 2);
    private static final Pattern PATTERN_MYME_SUB_TYPE = Pattern.compile("\\A([^\\s]+/[^\\s;]+)", 2);

    public static String parseCharset(String str) {
        Objects.requireNonNull(str);
        Matcher matcher = PATTERN_CHARSET.matcher(str.trim());
        if (matcher.find()) {
            return matcher.group(1).replaceAll("[\"\\\\]", "").toUpperCase(Locale.US);
        }
        return null;
    }

    public static String parseMimeType(String str) {
        Objects.requireNonNull(str);
        Matcher matcher = PATTERN_MYME_SUB_TYPE.matcher(str.trim());
        if (matcher.find()) {
            return matcher.group(1).toLowerCase(Locale.US);
        }
        return null;
    }
}
