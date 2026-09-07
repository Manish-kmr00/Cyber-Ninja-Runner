package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public final class wh0 implements xv0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qv.a f10564a;
    private final String b;
    private final boolean c;
    private final HashMap d;

    public wh0(String str, boolean z, vz.a aVar) {
        hg.a((z && TextUtils.isEmpty(str)) ? false : true);
        this.f10564a = aVar;
        this.b = str;
        this.c = z;
        this.d = new HashMap();
    }

    public final byte[] a(UUID uuid, i60.a aVar) throws yv0 {
        String str;
        String strB = aVar.b();
        if (this.c || TextUtils.isEmpty(strB)) {
            strB = this.b;
        }
        if (!TextUtils.isEmpty(strB)) {
            HashMap map = new HashMap();
            UUID uuid2 = qm.e;
            if (uuid2.equals(uuid)) {
                str = "text/xml";
            } else {
                str = qm.c.equals(uuid) ? "application/json" : "application/octet-stream";
            }
            map.put("Content-Type", str);
            if (uuid2.equals(uuid)) {
                map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
            }
            synchronized (this.d) {
                map.putAll(this.d);
            }
            return a(this.f10564a, strB, aVar.a(), map);
        }
        uv.a aVar2 = new uv.a();
        Uri uri = Uri.EMPTY;
        throw new yv0(aVar2.a(uri).a(), uri, ik0.g(), 0L, new IllegalStateException("No license URL"));
    }

    public final byte[] a(i60.d dVar) throws yv0 {
        return a(this.f10564a, dVar.b() + "&signedRequest=" + x82.a(dVar.a()), null, Collections.emptyMap());
    }

    public final void a(String str, String str2) {
        str.getClass();
        str2.getClass();
        synchronized (this.d) {
            this.d.put(str, str2);
        }
    }

    private static byte[] a(qv.a aVar, String str, byte[] bArr, Map<String, String> map) throws yv0 {
        Map<String, List<String>> map2;
        List<String> list;
        l22 l22Var = new l22(aVar.a());
        uv uvVarA = new uv.a().b(str).a(map).b().a(bArr).a(1).a();
        int i = 0;
        int i2 = 0;
        uv uvVarA2 = uvVarA;
        while (true) {
            try {
                sv svVar = new sv(l22Var, uvVarA2);
                try {
                    try {
                        int i3 = x82.f10629a;
                        byte[] bArr2 = new byte[4096];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            int i4 = svVar.read(bArr2);
                            if (i4 != -1) {
                                byteArrayOutputStream.write(bArr2, i, i4);
                            } else {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                x82.a((Closeable) svVar);
                                return byteArray;
                            }
                            x82.a((Closeable) svVar);
                            throw th;
                        }
                    } catch (qh0 e) {
                        int i5 = e.e;
                        String str2 = ((i5 != 307 && i5 != 308) || i2 >= 5 || (map2 = e.f) == null || (list = map2.get("Location")) == null || list.isEmpty()) ? null : list.get(i);
                        if (str2 != null) {
                            i2++;
                            uvVarA2 = uvVarA2.a().b(str2).a();
                            x82.a((Closeable) svVar);
                        } else {
                            throw e;
                        }
                    }
                } catch (Throwable th) {
                    x82.a((Closeable) svVar);
                    throw th;
                }
            } catch (Exception e2) {
                Uri uriF = l22Var.f();
                uriF.getClass();
                throw new yv0(uvVarA, uriF, l22Var.getResponseHeaders(), l22Var.e(), e2);
            }
        }
    }
}
