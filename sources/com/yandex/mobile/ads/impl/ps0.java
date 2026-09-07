package com.yandex.mobile.ads.impl;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ps0 {
    public static String a(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String language = locale.getLanguage();
        String country = locale.getCountry();
        StringBuilder sb = new StringBuilder(language);
        String script = locale.getScript();
        if (script != null && script.length() != 0) {
            sb.append('-').append(script);
        }
        if (country != null && country.length() != 0) {
            sb.append('_').append(country);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
