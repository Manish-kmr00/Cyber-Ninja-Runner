package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class lz implements qv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9578a;
    private final ArrayList b = new ArrayList();
    private final qv c;
    private eb0 d;
    private rg e;
    private as f;
    private qv g;
    private s72 h;
    private ov i;
    private ln1 j;
    private qv k;

    public static final class a implements qv.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f9579a;
        private final qv.a b;

        @Override // com.yandex.mobile.ads.impl.qv.a
        public final qv a() {
            return new lz(this.f9579a, this.b.a());
        }

        public a(Context context, qv.a aVar) {
            this.f9579a = context.getApplicationContext();
            this.b = aVar;
        }
    }

    public lz(Context context, qv qvVar) {
        this.f9578a = context.getApplicationContext();
        this.c = (qv) hg.a(qvVar);
    }

    @Override // com.yandex.mobile.ads.impl.nv
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        qv qvVar = this.k;
        qvVar.getClass();
        return qvVar.read(bArr, i, i2);
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Uri getUri() {
        qv qvVar = this.k;
        if (qvVar == null) {
            return null;
        }
        return qvVar.getUri();
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Map<String, List<String>> getResponseHeaders() {
        qv qvVar = this.k;
        return qvVar == null ? Collections.emptyMap() : qvVar.getResponseHeaders();
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final void close() throws IOException {
        qv qvVar = this.k;
        if (qvVar != null) {
            try {
                qvVar.close();
            } finally {
                this.k = null;
            }
        }
    }

    private void a(qv qvVar) {
        for (int i = 0; i < this.b.size(); i++) {
            qvVar.a((w62) this.b.get(i));
        }
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final void a(w62 w62Var) {
        w62Var.getClass();
        this.c.a(w62Var);
        this.b.add(w62Var);
        eb0 eb0Var = this.d;
        if (eb0Var != null) {
            eb0Var.a(w62Var);
        }
        rg rgVar = this.e;
        if (rgVar != null) {
            rgVar.a(w62Var);
        }
        as asVar = this.f;
        if (asVar != null) {
            asVar.a(w62Var);
        }
        qv qvVar = this.g;
        if (qvVar != null) {
            qvVar.a(w62Var);
        }
        s72 s72Var = this.h;
        if (s72Var != null) {
            s72Var.a(w62Var);
        }
        ov ovVar = this.i;
        if (ovVar != null) {
            ovVar.a(w62Var);
        }
        ln1 ln1Var = this.j;
        if (ln1Var != null) {
            ln1Var.a(w62Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final long a(uv uvVar) throws IOException {
        if (this.k == null) {
            String scheme = uvVar.f10424a.getScheme();
            Uri uri = uvVar.f10424a;
            int i = x82.f10629a;
            String scheme2 = uri.getScheme();
            if (!TextUtils.isEmpty(scheme2) && !"file".equals(scheme2)) {
                if ("asset".equals(scheme)) {
                    if (this.e == null) {
                        rg rgVar = new rg(this.f9578a);
                        this.e = rgVar;
                        a(rgVar);
                    }
                    this.k = this.e;
                } else if ("content".equals(scheme)) {
                    if (this.f == null) {
                        as asVar = new as(this.f9578a);
                        this.f = asVar;
                        a(asVar);
                    }
                    this.k = this.f;
                } else if ("rtmp".equals(scheme)) {
                    if (this.g == null) {
                        try {
                            qv qvVar = (qv) Class.forName("com.monetization.ads.exo.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                            this.g = qvVar;
                            a(qvVar);
                        } catch (ClassNotFoundException unused) {
                            at0.d("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                        } catch (Exception e) {
                            throw new RuntimeException("Error instantiating RTMP extension", e);
                        }
                        if (this.g == null) {
                            this.g = this.c;
                        }
                    }
                    this.k = this.g;
                } else if ("udp".equals(scheme)) {
                    if (this.h == null) {
                        s72 s72Var = new s72(0);
                        this.h = s72Var;
                        a(s72Var);
                    }
                    this.k = this.h;
                } else if ("data".equals(scheme)) {
                    if (this.i == null) {
                        ov ovVar = new ov();
                        this.i = ovVar;
                        a(ovVar);
                    }
                    this.k = this.i;
                } else if (!"rawresource".equals(scheme) && !"android.resource".equals(scheme)) {
                    this.k = this.c;
                } else {
                    if (this.j == null) {
                        ln1 ln1Var = new ln1(this.f9578a);
                        this.j = ln1Var;
                        a(ln1Var);
                    }
                    this.k = this.j;
                }
            } else {
                String path = uvVar.f10424a.getPath();
                if (path != null && path.startsWith("/android_asset/")) {
                    if (this.e == null) {
                        rg rgVar2 = new rg(this.f9578a);
                        this.e = rgVar2;
                        a(rgVar2);
                    }
                    this.k = this.e;
                } else {
                    if (this.d == null) {
                        eb0 eb0Var = new eb0();
                        this.d = eb0Var;
                        a(eb0Var);
                    }
                    this.k = this.d;
                }
            }
            return this.k.a(uvVar);
        }
        throw new IllegalStateException();
    }
}
