package com.inmobi.media;

import android.webkit.WebResourceResponse;
import java.net.URLDecoder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public abstract class kd {
    public static WebResourceResponse a(String urlRaw, L4 l4) {
        String url;
        Intrinsics.checkNotNullParameter(urlRaw, "urlRaw");
        if (l4 != null) {
            ((M4) l4).c("IMResourceCacheManager", S.a("shouldInterceptRequest ", urlRaw));
        }
        try {
            url = URLDecoder.decode(StringsKt.trim((CharSequence) urlRaw).toString(), "UTF-8");
        } catch (Exception unused) {
            url = null;
        }
        if (url == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        if (StringsKt.contains$default((CharSequence) url, (CharSequence) "inmobicache=true", false, 2, (Object) null)) {
            return md.f3377a.a(url, l4);
        }
        if (l4 != null) {
            ((M4) l4).a("IMResourceCacheManager", "Cache is not enabled for URL: ".concat(url));
        }
        return null;
    }
}
