package com.mbridge.msdk.tracker.network;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.json.cc;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class t<T> implements Comparable<t<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f5639a;
    private String b;
    private volatile p c;
    private long d;
    private Map<String, String> e;
    private int f;
    private final String g;
    private final int h;
    private final String i;
    private final int j;
    private final Object k;
    private v.a l;
    private Integer m;
    private u n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private x t;
    private b.a u;
    private long v;

    /* JADX INFO: compiled from: Request.java */
    public enum a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public t(int i, String str) {
        this(i, str, 0);
    }

    private static int b(String str) {
        Uri uri;
        String host;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || (host = uri.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public final boolean A() {
        return this.s;
    }

    public final boolean B() {
        return this.r;
    }

    protected abstract v<T> a(q qVar);

    public void a(v.a aVar) {
        this.l = aVar;
    }

    protected abstract void a(T t);

    public void a(String str) {
    }

    public boolean a() {
        return false;
    }

    protected b0 c(b0 b0Var) {
        return b0Var;
    }

    void c(String str) {
        u uVar = this.n;
        if (uVar != null) {
            uVar.c(this);
        }
    }

    public b.a d() {
        return this.u;
    }

    public String e() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        if (this.f5639a == null) {
            this.f5639a = new com.mbridge.msdk.tracker.network.toolbox.e();
        }
        String strA = this.f5639a.a(this);
        this.b = strA;
        return strA;
    }

    public Map<String, String> f() {
        return Collections.emptyMap();
    }

    public int g() {
        return this.f;
    }

    public p h() {
        return this.c;
    }

    protected Map<String, String> i() {
        return null;
    }

    protected String j() {
        return "UTF-8";
    }

    public int k() {
        return this.h;
    }

    public a l() {
        return a.NORMAL;
    }

    public long m() {
        return this.v;
    }

    public long n() {
        return SystemClock.elapsedRealtime() - this.d;
    }

    public x o() {
        return this.t;
    }

    public String p() {
        return this.i;
    }

    public final int q() {
        x xVarO = o();
        if (xVarO == null) {
            return 30000;
        }
        return xVarO.b();
    }

    public final long r() {
        x xVarO = o();
        if (xVarO == null) {
            return 30000L;
        }
        long jA = xVarO.a();
        if (jA < 0) {
            return 30000L;
        }
        return jA;
    }

    public int s() {
        return this.j;
    }

    public String t() {
        return this.g;
    }

    public String toString() {
        return (v() ? "[X] " : "[ ] ") + t() + " " + ("0x" + Integer.toHexString(s())) + " " + l() + " " + this.m;
    }

    public boolean u() {
        boolean z;
        synchronized (this.k) {
            z = this.q;
        }
        return z;
    }

    public boolean v() {
        boolean z;
        synchronized (this.k) {
            z = this.p;
        }
        return z;
    }

    public void w() {
        synchronized (this.k) {
            this.q = true;
        }
    }

    void x() {
        synchronized (this.k) {
        }
    }

    public boolean y() {
        return true;
    }

    public final boolean z() {
        return this.o;
    }

    public t(int i, String str, int i2) {
        this(i, str, i2, "un_known");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t<?> a(x xVar) {
        this.t = xVar;
        return this;
    }

    public String d(String str) {
        if (this.e != null && !TextUtils.isEmpty(str)) {
            try {
                return this.e.get(str);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public t(int i, String str, int i2, String str2) {
        this.k = new Object();
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.u = null;
        this.v = 0L;
        this.f = i;
        this.g = str;
        this.h = i2;
        this.i = str2;
        a((x) new e());
        this.j = b(str);
        this.d = SystemClock.elapsedRealtime();
    }

    void a(int i) {
        u uVar = this.n;
        if (uVar != null) {
            uVar.a(this, i);
        }
    }

    public String c() {
        return "application/x-www-form-urlencoded; charset=" + j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t<?> c(boolean z) {
        this.r = z;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t<?> a(u uVar) {
        this.n = uVar;
        return this;
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            int i = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                i++;
                if (entry.getKey() != null) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append(cc.T);
                    sb.append(URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue(), str));
                    if (i <= map.size() - 1) {
                        sb.append(Typography.amp);
                    }
                }
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t<?> b(int i) {
        this.m = Integer.valueOf(i);
        return this;
    }

    public byte[] b() {
        Map<String, String> mapI = i();
        if (mapI != null && mapI.size() > 0) {
            byte[] bArrA = a(mapI, j());
            this.v = bArrA.length;
            return bArrA;
        }
        this.v = 0L;
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t<?> b(boolean z) {
        this.s = z;
        return this;
    }

    public void b(b0 b0Var) {
        v.a aVar;
        synchronized (this.k) {
            aVar = this.l;
        }
        if (aVar != null) {
            aVar.a(b0Var);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t<?> a(boolean z) {
        this.o = z;
        return this;
    }

    void a(v<?> vVar) {
        synchronized (this.k) {
        }
    }

    public void a(p pVar) {
        this.c = pVar;
    }

    public void a(String str, String str2) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            this.e.put(str, str2);
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(t<T> tVar) {
        a aVarL = l();
        a aVarL2 = tVar.l();
        return aVarL == aVarL2 ? this.m.intValue() - tVar.m.intValue() : aVarL2.ordinal() - aVarL.ordinal();
    }
}
