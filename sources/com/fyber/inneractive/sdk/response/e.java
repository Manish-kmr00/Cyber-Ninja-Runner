package com.fyber.inneractive.sdk.response;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.ignite.m;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public String A;
    public String B;
    public String C;
    public String E;
    public String F;
    public String G;
    public String I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2321a;
    public long b;
    public long c;
    public String d;
    public int e;
    public int f;
    public int g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public UnitDisplayType p;
    public String q;
    public Map r;
    public String s;
    public ImpressionData t;
    public com.fyber.inneractive.sdk.dv.j u;
    public String x;
    public Exception z;
    public int v = 0;
    public float w = -1.0f;
    public int y = -1;
    public boolean D = false;
    public m H = m.NONE;
    public boolean J = false;
    public long K = 0;
    public boolean L = false;

    public abstract InneractiveErrorCode a(InneractiveAdRequest inneractiveAdRequest, r rVar);

    public final void a(String str) {
        long j;
        try {
            j = Long.parseLong(str);
        } catch (NumberFormatException unused) {
            j = 20;
        }
        this.b = j;
        this.f2321a = TimeUnit.MINUTES.toMillis(j) + this.c;
    }

    public abstract InneractiveErrorCode b();

    public final boolean a() {
        return (this.H == m.NONE || TextUtils.isEmpty(this.A) || TextUtils.isEmpty(this.G) || TextUtils.isEmpty(this.I)) ? false : true;
    }
}
