package com.mbridge.msdk.preload;

import io.ktor.http.LinkHeader;
import java.util.Map;

/* JADX INFO: compiled from: PreloadController.java */
/* JADX INFO: loaded from: classes10.dex */
public class a {
    public void a(Map<String, Object> map) {
    }

    public void a(Map<String, Object> map, int i) {
        try {
            com.mbridge.msdk.mbnative.service.a.class.getMethod(LinkHeader.Rel.PreLoad, Map.class, Integer.TYPE).invoke(com.mbridge.msdk.mbnative.service.a.class.newInstance(), map, Integer.valueOf(i));
        } catch (Exception unused) {
        }
    }

    public void b(Map<String, Object> map) {
    }
}
