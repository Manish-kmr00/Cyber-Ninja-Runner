package com.applovin.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class q0 {
    private static final List e = Arrays.asList("5.0/i", "4.0/ad", "1.0/mediate");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f591a;
    private final com.applovin.impl.sdk.o b;
    private final y3 c;
    private d d;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f592a;
        private long b;

        public long a() {
            return this.f592a;
        }

        public long b() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j) {
            this.f592a = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(long j) {
            this.b = j;
        }
    }

    private class c implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f593a;
        private final com.applovin.impl.sdk.network.a b;
        private final String c;
        private final Object d;
        private final boolean e;
        private final b f;
        private final e g;

        @Override // androidx.core.util.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(y3.d dVar) {
            int i;
            long jE = dVar.e();
            Object objA = null;
            try {
                try {
                    int iC = dVar.c();
                    try {
                        if (iC <= 0) {
                            q0.this.a(this.c, this.f593a, iC, jE, (Throwable) null);
                            this.g.a(this.f593a, iC, null, null);
                            return;
                        }
                        if (iC < 200 || iC >= 400) {
                            this.g.a(this.f593a, iC, null, null);
                            return;
                        }
                        b bVar = this.f;
                        if (bVar != null) {
                            bVar.a(jE);
                        }
                        q0.this.a(this.c, this.f593a, iC, jE);
                        byte[] bArrD = dVar.d();
                        if (k7.h(com.applovin.impl.sdk.k.o()) && (!this.e || s4.b(bArrD) != s4.a.V2)) {
                            q0.this.f591a.u().a(bArrD != null ? new String(dVar.d(), Charset.forName("UTF-8")) : "", this.f593a, this.b.b() != null ? this.b.b().toString() : "");
                        }
                        if (bArrD == null) {
                            this.g.a(this.f593a, this.d, iC);
                            return;
                        }
                        String str = new String(dVar.d(), Charset.forName("UTF-8"));
                        b bVar2 = this.f;
                        if (bVar2 != null) {
                            bVar2.b(bArrD.length);
                            if (this.b.r()) {
                                q0.this.d = new d(this.b.f(), bArrD.length, jE);
                            }
                        }
                        if (this.e) {
                            String strB = s4.b(bArrD, q0.this.f591a.j0(), q0.this.f591a);
                            if (strB == null) {
                                HashMap map = new HashMap(2);
                                map.put("request", StringUtils.getHostAndPath(this.f593a));
                                map.put("response", str);
                                q0.this.f591a.G().trackEvent("rdf", map);
                            }
                            str = strB;
                        }
                        try {
                            this.g.a(this.f593a, q0.this.a(str, this.d), iC);
                        } catch (Throwable th) {
                            String str2 = "Unable to parse response from " + StringUtils.getHostAndPath(this.f593a) + " because of " + th.getClass().getName() + " : " + th.getMessage();
                            com.applovin.impl.sdk.o unused = q0.this.b;
                            if (com.applovin.impl.sdk.o.a()) {
                                q0.this.b.a("ConnectionManager", str2, th);
                            }
                            q0.this.f591a.E().a("ConnectionManager", "failedToParseResponse", th, CollectionUtils.hashMap("url", StringUtils.getHostAndPath(this.f593a)));
                            this.g.a(this.f593a, AppLovinErrorCodes.INVALID_RESPONSE, str2, null);
                        }
                    } catch (MalformedURLException e) {
                        e = e;
                        i = iC;
                        if (this.d != null) {
                            q0.this.a(this.c, this.f593a, i, jE, e);
                            this.g.a(this.f593a, -901, e.getMessage(), null);
                        } else {
                            q0.this.a(this.c, this.f593a, i, jE);
                            this.g.a(this.f593a, this.d, -901);
                        }
                    }
                } catch (Throwable th2) {
                    int iB = dVar.b();
                    try {
                        byte[] bArrF = dVar.f();
                        String str3 = new String(bArrF);
                        if (bArrF != null) {
                            if (this.e) {
                                str3 = s4.b(bArrF, q0.this.f591a.j0(), q0.this.f591a);
                            }
                            objA = q0.this.a(str3, this.d);
                        }
                    } catch (Throwable unused2) {
                    }
                    q0.this.a(this.c, this.f593a, iB, jE, th2);
                    this.g.a(this.f593a, iB, th2.getMessage(), objA);
                }
            } catch (MalformedURLException e2) {
                e = e2;
                i = 0;
            }
        }

        private c(String str, com.applovin.impl.sdk.network.a aVar, String str2, Object obj, boolean z, b bVar, e eVar) {
            this.f593a = str;
            this.b = aVar;
            this.c = str2;
            this.d = obj;
            this.e = z;
            this.f = bVar;
            this.g = eVar;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f594a = System.currentTimeMillis();
        private final String b;
        private final long c;
        private final long d;

        public d(String str, long j, long j2) {
            this.b = str;
            this.c = j;
            this.d = j2;
        }

        protected boolean a(Object obj) {
            return obj instanceof d;
        }

        public long b() {
            return this.c;
        }

        public long c() {
            return this.f594a;
        }

        public String d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (!dVar.a(this) || c() != dVar.c() || b() != dVar.b() || a() != dVar.a()) {
                return false;
            }
            String strD = d();
            String strD2 = dVar.d();
            return strD != null ? strD.equals(strD2) : strD2 == null;
        }

        public int hashCode() {
            long jC = c();
            long jB = b();
            int i = ((((int) (jC ^ (jC >>> 32))) + 59) * 59) + ((int) (jB ^ (jB >>> 32)));
            long jA = a();
            String strD = d();
            return (((i * 59) + ((int) ((jA >>> 32) ^ jA))) * 59) + (strD == null ? 43 : strD.hashCode());
        }

        public String toString() {
            return "ConnectionManager.RequestMeasurement(timestampMillis=" + c() + ", urlHostAndPathString=" + d() + ", responseSizeBytes=" + b() + ", connectionTimeMillis=" + a() + ")";
        }

        public long a() {
            return this.d;
        }
    }

    public interface e {
        void a(String str, int i, String str2, Object obj);

        void a(String str, Object obj, int i);
    }

    public q0(com.applovin.impl.sdk.k kVar) {
        this.f591a = kVar;
        this.b = kVar.O();
        y3 y3Var = new y3(kVar);
        this.c = y3Var;
        y3Var.a();
    }

    /* JADX WARN: Code duplicated, block: B:72:0x0217 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x0219 A[Catch: all -> 0x026d, TryCatch #1 {all -> 0x026d, blocks: (B:36:0x00fc, B:38:0x010c, B:42:0x0137, B:41:0x0133, B:43:0x0148, B:46:0x016d, B:48:0x0189, B:52:0x01aa, B:68:0x01ff, B:71:0x020e, B:73:0x0219, B:54:0x01ae, B:57:0x01b6, B:63:0x01ce, B:65:0x01d4, B:66:0x01ea, B:49:0x0197, B:74:0x021c, B:76:0x0222, B:77:0x0238, B:59:0x01c7), top: B:92:0x00fc, inners: #0 }] */
    public void a(com.applovin.impl.sdk.network.a aVar, b bVar, e eVar) {
        byte[] bytes;
        byte[] bArrA;
        if (aVar != null) {
            String strF = aVar.f();
            String strH = aVar.h();
            if (strF == null) {
                throw new IllegalArgumentException("No endpoint specified");
            }
            if (strH == null) {
                throw new IllegalArgumentException("No method specified");
            }
            if (eVar != null) {
                if (!strF.toLowerCase().startsWith("http")) {
                    String str = "Requested postback submission to non HTTP endpoint " + strF + "; skipping...";
                    com.applovin.impl.sdk.o.h("ConnectionManager", str);
                    eVar.a(strF, AppLovinErrorCodes.INVALID_URL, str, null);
                    return;
                }
                String httpsString = StringUtils.toHttpsString(strF);
                HashMap map = new HashMap(2);
                boolean zM = aVar.m();
                s4.a aVarA = ((Boolean) this.f591a.a(v4.e5)).booleanValue() ? s4.a.a(((Integer) this.f591a.a(v4.b5)).intValue()) : aVar.e();
                long jA = k7.a(this.f591a);
                if ((aVar.i() != null && !aVar.i().isEmpty()) || aVar.c() > 0) {
                    Map mapI = aVar.i();
                    Boolean bool = (Boolean) this.f591a.a(v4.g3);
                    if (mapI != null && aVar.c() > 0) {
                        mapI.put("current_retry_attempt", String.valueOf(aVar.c()));
                    }
                    if (zM) {
                        String strA = k7.a(mapI, bool.booleanValue());
                        String strB = s4.b(strA, jA, aVarA, this.f591a.j0(), this.f591a);
                        if (StringUtils.isValidString(strA) && TextUtils.isEmpty(strB)) {
                            map.put("query", strA);
                        }
                        httpsString = StringUtils.appendQueryParameter(httpsString, "p", strB);
                    } else {
                        httpsString = StringUtils.appendQueryParameters(httpsString, mapI, bool.booleanValue());
                    }
                }
                String str2 = httpsString;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    Boolean boolEndsWith = StringUtils.endsWith(StringUtils.getHostAndPath(str2), e);
                    if (com.applovin.impl.sdk.o.a()) {
                        this.b.d("ConnectionManager", "Sending " + strH + " request to id=#" + str2.hashCode() + " \"" + (boolEndsWith.booleanValue() ? str2 : StringUtils.getHostAndPath(str2)) + "\"...");
                    }
                    y3.c.a aVarA2 = new y3.c.a().a(str2).b(strH).a(aVar.g()).a(aVar.l());
                    if (aVar.b() != null) {
                        if (zM) {
                            bytes = s4.a(aVar.b().toString(), jA, aVarA, this.f591a.j0(), this.f591a);
                            if (bytes == null) {
                                map.put("body", aVar.b().toString());
                            }
                        } else {
                            bytes = aVar.b().toString().getBytes("UTF-8");
                        }
                        byte[] bArr = bytes;
                        if ((!zM || aVarA != s4.a.V2) && aVar.o() && bArr != null && bArr.length > ((Integer) this.f591a.a(v4.y5)).intValue()) {
                            try {
                                bArrA = k7.a(bArr);
                            } catch (Throwable th) {
                                if (com.applovin.impl.sdk.o.a()) {
                                    this.b.a("ConnectionManager", "Failed to gzip POST body for request " + a(str2), th);
                                }
                                this.f591a.E().a("ConnectionManager", "gzip", th, CollectionUtils.hashMap("url", StringUtils.getHostAndPath(str2)));
                                bArrA = null;
                            }
                            aVarA2.a("Content-Type", "application/json; charset=utf-8");
                            if (!aVar.o() && bArrA != null) {
                                aVarA2.a("Content-Encoding", "gzip");
                                aVarA2.a(bArrA);
                            } else if (bArr != null) {
                                aVarA2.a(bArr);
                            }
                        } else {
                            bArrA = null;
                            aVarA2.a("Content-Type", "application/json; charset=utf-8");
                            if (!aVar.o()) {
                                if (bArr != null) {
                                    aVarA2.a(bArr);
                                }
                            } else if (bArr != null) {
                                aVarA2.a(bArr);
                            }
                        }
                    }
                    if (!map.isEmpty()) {
                        map.put("request", StringUtils.getHostAndPath(str2));
                        this.f591a.G().trackEvent("ref", map);
                    }
                    this.c.a(aVarA2.a(new c(str2, aVar, strH, aVar.d(), zM, bVar, eVar)).a(this.f591a.r0().d()).a());
                    return;
                } catch (Throwable th2) {
                    a(strH, str2, 0, SystemClock.elapsedRealtime() - jElapsedRealtime, th2);
                    eVar.a(str2, 0, th2.getMessage(), null);
                    return;
                }
            }
            throw new IllegalArgumentException("No callback specified");
        }
        throw new IllegalArgumentException("No request specified");
    }

    public d a() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(String str, Object obj) {
        if (obj == null) {
            return str;
        }
        if (str != null && str.length() >= 3) {
            if (obj instanceof JSONObject) {
                return new JSONObject(str);
            }
            if (obj instanceof m8) {
                return n8.a(str, this.f591a);
            }
            if (obj instanceof String) {
                return str;
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.b.b("ConnectionManager", "Failed to process response of type '" + obj.getClass().getName() + "'");
            }
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i, long j) {
        if (com.applovin.impl.sdk.o.a()) {
            this.b.d("ConnectionManager", "Successful " + str + " returned " + i + " in " + (j / 1000.0f) + " s over " + r0.g(this.f591a) + " to " + a(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i, long j, Throwable th) {
        if (com.applovin.impl.sdk.o.a()) {
            this.b.a("ConnectionManager", "Failed " + str + " returned " + i + " in " + (j / 1000.0f) + " s over " + r0.g(this.f591a) + " to " + a(str2), th);
        }
    }

    private String a(String str) {
        return "#" + str.hashCode() + " \"" + StringUtils.getHostAndPath(str) + "\"";
    }
}
