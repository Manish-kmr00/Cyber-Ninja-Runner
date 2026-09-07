package com.yandex.mobile.ads.impl;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class fe1 extends ik {
    private final mn.a e;
    private final rh0 f;
    private final String g;
    private final tm h;
    private final rh0 i;
    private sj1<String> j;
    private oq1 k;
    private InputStream l;
    private boolean m;
    private long n;
    private long o;

    static {
        r60.a("goog.exo.okhttp");
    }

    public fe1(be1 be1Var, String str, rh0 rh0Var) {
        super(true);
        this.e = (mn.a) hg.a(be1Var);
        this.g = str;
        this.h = null;
        this.i = rh0Var;
        this.j = null;
        this.f = new rh0();
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Uri getUri() {
        oq1 oq1Var = this.k;
        if (oq1Var == null) {
            return null;
        }
        return Uri.parse(oq1Var.o().g().toString());
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Map<String, List<String>> getResponseHeaders() {
        oq1 oq1Var = this.k;
        return oq1Var == null ? Collections.emptyMap() : oq1Var.g().c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.mobile.ads.impl.qv
    public final long a(uv uvVar) throws oh0 {
        di0 di0VarA;
        String string;
        qp1 qp1VarA;
        long j = 0;
        this.o = 0L;
        this.n = 0L;
        b(uvVar);
        long j2 = uvVar.f;
        long j3 = uvVar.g;
        String string2 = uvVar.f10424a.toString();
        Intrinsics.checkNotNullParameter(string2, "<this>");
        try {
            Intrinsics.checkNotNullParameter(string2, "<this>");
            di0VarA = new di0.a().a(null, string2).a();
        } catch (IllegalArgumentException unused) {
            di0VarA = null;
        }
        if (di0VarA != null) {
            op1.a aVarA = new op1.a().a(di0VarA);
            tm tmVar = this.h;
            if (tmVar != null) {
                aVarA.a(tmVar);
            }
            HashMap map = new HashMap();
            rh0 rh0Var = this.i;
            if (rh0Var != null) {
                map.putAll(rh0Var.a());
            }
            map.putAll(this.f.a());
            map.putAll(uvVar.e);
            for (Map.Entry entry : map.entrySet()) {
                aVarA.b((String) entry.getKey(), (String) entry.getValue());
            }
            int i = ei0.c;
            if (j2 == 0 && j3 == -1) {
                string = null;
            } else {
                StringBuilder sb = new StringBuilder("bytes=");
                sb.append(j2);
                sb.append("-");
                if (j3 != -1) {
                    sb.append((j2 + j3) - 1);
                }
                string = sb.toString();
            }
            if (string != null) {
                aVarA.a("Range", string);
            }
            String str = this.g;
            if (str != null) {
                aVarA.a("User-Agent", str);
            }
            if ((uvVar.i & 1) != 1) {
                aVarA.a(HttpHeaders.ACCEPT_ENCODING, "identity");
            }
            byte[] bArr = uvVar.d;
            if (bArr != null) {
                qp1VarA = rp1.a(bArr);
            } else {
                qp1VarA = uvVar.c == 2 ? rp1.a(x82.f) : null;
            }
            aVarA.a(uv.a(uvVar.c), qp1VarA);
            sn1 sn1VarA = this.e.a(aVarA.a());
            try {
                qx1 qx1VarB = qx1.b();
                sn1VarA.a(new ee1(qx1VarB));
                try {
                    try {
                        oq1 oq1Var = (oq1) qx1VarB.get();
                        this.k = oq1Var;
                        sq1 sq1VarA = oq1Var.a();
                        sq1VarA.getClass();
                        this.l = sq1VarA.c().inputStream();
                        int iD = oq1Var.d();
                        if (!oq1Var.h()) {
                            if (iD == 416) {
                                if (uvVar.f == ei0.a(oq1Var.g().a(HttpHeaders.CONTENT_RANGE))) {
                                    this.m = true;
                                    c(uvVar);
                                    long j4 = uvVar.g;
                                    if (j4 != -1) {
                                        return j4;
                                    }
                                    return 0L;
                                }
                            }
                            try {
                                InputStream inputStream = this.l;
                                inputStream.getClass();
                                int i2 = x82.f10629a;
                                byte[] bArr2 = new byte[4096];
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                while (true) {
                                    int i3 = inputStream.read(bArr2);
                                    if (i3 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, i3);
                                }
                                byteArrayOutputStream.toByteArray();
                            } catch (IOException unused2) {
                                int i4 = x82.f10629a;
                            }
                            TreeMap treeMapC = oq1Var.g().c();
                            f();
                            throw new qh0(iD, iD == 416 ? new rv(2008) : null, treeMapC);
                        }
                        yw0 yw0VarB = sq1VarA.b();
                        String string3 = yw0VarB != null ? yw0VarB.toString() : "";
                        sj1<String> sj1Var = this.j;
                        if (sj1Var != null && !sj1Var.apply(string3)) {
                            f();
                            throw new ph0(string3);
                        }
                        if (iD == 200) {
                            long j5 = uvVar.f;
                            if (j5 != 0) {
                                j = j5;
                            }
                        }
                        long j6 = uvVar.g;
                        if (j6 != -1) {
                            this.n = j6;
                        } else {
                            long jA = sq1VarA.a();
                            this.n = jA != -1 ? jA - j : -1L;
                        }
                        this.m = true;
                        c(uvVar);
                        try {
                            a(j);
                            return this.n;
                        } catch (oh0 e) {
                            f();
                            throw e;
                        }
                    } catch (ExecutionException e2) {
                        throw new IOException(e2);
                    }
                } catch (InterruptedException unused3) {
                    sn1VarA.a();
                    throw new InterruptedIOException();
                }
            } catch (IOException e3) {
                throw oh0.a(e3, 1);
            }
        }
        throw new oh0("Malformed URL", 1004);
    }

    @Override // com.yandex.mobile.ads.impl.nv
    public final int read(byte[] bArr, int i, int i2) throws oh0 {
        try {
            return c(bArr, i, i2);
        } catch (IOException e) {
            int i3 = x82.f10629a;
            throw oh0.a(e, 2);
        }
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final void close() {
        if (this.m) {
            this.m = false;
            e();
            f();
        }
    }

    private int c(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.n;
        if (j != -1) {
            long j2 = j - this.o;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        InputStream inputStream = this.l;
        int i3 = x82.f10629a;
        int i4 = inputStream.read(bArr, i, i2);
        if (i4 == -1) {
            return -1;
        }
        this.o += (long) i4;
        c(i4);
        return i4;
    }

    private void f() {
        oq1 oq1Var = this.k;
        if (oq1Var != null) {
            sq1 sq1VarA = oq1Var.a();
            sq1VarA.getClass();
            y82.a((Closeable) sq1VarA.c());
            this.k = null;
        }
        this.l = null;
    }

    private void a(long j) throws oh0 {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            try {
                int iMin = (int) Math.min(j, 4096);
                InputStream inputStream = this.l;
                int i = x82.f10629a;
                int i2 = inputStream.read(bArr, 0, iMin);
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (i2 != -1) {
                    j -= (long) i2;
                    c(i2);
                } else {
                    throw new oh0(2008);
                }
            } catch (IOException e) {
                if (e instanceof oh0) {
                    throw ((oh0) e);
                }
                throw new oh0(2000);
            }
        }
    }
}
