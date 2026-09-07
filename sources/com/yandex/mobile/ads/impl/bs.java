package com.yandex.mobile.ads.impl;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class bs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap f8535a = new HashMap();
    private final ArrayList b = new ArrayList();

    public final List<String> b() {
        return Collections.unmodifiableList(new ArrayList(this.b));
    }

    public static void a(bs bsVar, long j) {
        bsVar.f8535a.put("exo_len", Long.valueOf(j));
        bsVar.b.remove("exo_len");
    }

    public static void a(bs bsVar, Uri uri) {
        if (uri == null) {
            bsVar.b.add("exo_redir");
            bsVar.f8535a.remove("exo_redir");
            return;
        }
        String string = uri.toString();
        HashMap map = bsVar.f8535a;
        string.getClass();
        map.put("exo_redir", string);
        bsVar.b.remove("exo_redir");
    }

    public final Map<String, Object> a() {
        HashMap map = new HashMap(this.f8535a);
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(map);
    }
}
