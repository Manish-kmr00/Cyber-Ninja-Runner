package com.inmobi.media;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Q8 {
    public static final boolean a(Pa pa) {
        String str;
        Intrinsics.checkNotNullParameter(pa, "<this>");
        HashMap map = pa.c;
        return (map == null || (str = (String) map.get("Content-Encoding")) == null || !StringsKt.contains$default((CharSequence) str, (CharSequence) "gzip", false, 2, (Object) null)) ? false : true;
    }

    public static final String a(String url, HashMap map) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (map == null) {
            return url;
        }
        boolean z = W8.f3228a;
        W8.a(map);
        String strA = W8.a(com.ironsource.b9.i.c, (Map) map);
        StringBuilder sb = new StringBuilder(url);
        int length = strA.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = Intrinsics.compare((int) strA.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                }
                length--;
            } else if (z3) {
                i++;
            } else {
                z2 = true;
            }
        }
        if (strA.subSequence(i, length + 1).toString().length() > 0) {
            if (!StringsKt.contains$default((CharSequence) url, (CharSequence) "?", false, 2, (Object) null)) {
                sb.append("?");
            }
            if (!StringsKt.endsWith$default(url, com.ironsource.b9.i.c, false, 2, (Object) null) && !StringsKt.endsWith$default(url, "?", false, 2, (Object) null)) {
                sb.append(com.ironsource.b9.i.c);
            }
            sb.append(strA);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, Charsets.UTF_8);
        } catch (UnsupportedEncodingException | Exception unused) {
            return "";
        }
    }
}
