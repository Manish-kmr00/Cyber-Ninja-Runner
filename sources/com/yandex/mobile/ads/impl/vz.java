package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes6.dex */
public class vz extends ik {
    private final boolean e;
    private final int f;
    private final int g;
    private final String h;
    private final rh0 i;
    private final rh0 j;
    private final boolean k;
    private sj1<String> l;
    private HttpURLConnection m;
    private InputStream n;
    private boolean o;
    private int p;
    private long q;
    private long r;

    public static final class a implements qv.a {
        private String b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final rh0 f10519a = new rh0();
        private int c = 8000;
        private int d = 8000;

        @Override // com.yandex.mobile.ads.impl.qv.a
        public final qv a() {
            return new vz(this.b, this.c, this.d, this.f10519a);
        }

        public final a b() {
            this.b = null;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b extends jc0<String, List<String>> {
        private final Map<String, List<String>> b;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean a(String str) {
            return str != null;
        }

        @Override // com.yandex.mobile.ads.impl.kc0
        protected final Map a() {
            return this.b;
        }

        @Override // java.util.Map
        public final boolean containsValue(Object obj) {
            Iterator it = (Iterator) rj1.a(entrySet().iterator());
            if (obj == null) {
                while (it.hasNext()) {
                    if (((Map.Entry) it.next()).getValue() == null) {
                        return true;
                    }
                }
                return false;
            }
            while (it.hasNext()) {
                if (obj.equals(((Map.Entry) it.next()).getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.yandex.mobile.ads.impl.jc0, java.util.Map
        public final Object get(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }

        public b(Map<String, List<String>> map) {
            this.b = map;
        }

        @Override // com.yandex.mobile.ads.impl.jc0
        protected final Map<String, List<String>> b() {
            return this.b;
        }

        @Override // com.yandex.mobile.ads.impl.jc0, java.util.Map
        public final boolean containsKey(Object obj) {
            return obj != null && super.containsKey(obj);
        }

        @Override // com.yandex.mobile.ads.impl.jc0, java.util.Map
        public final Set<String> keySet() {
            return px1.a(super.keySet(), new sj1() { // from class: com.yandex.mobile.ads.impl.vz$b$$ExternalSyntheticLambda1
                @Override // com.yandex.mobile.ads.impl.sj1
                public final boolean apply(Object obj) {
                    return vz.b.a((String) obj);
                }
            });
        }

        @Override // com.yandex.mobile.ads.impl.jc0, java.util.Map
        public final Set<Map.Entry<String, List<String>>> entrySet() {
            return px1.a(super.entrySet(), new sj1() { // from class: com.yandex.mobile.ads.impl.vz$b$$ExternalSyntheticLambda0
                @Override // com.yandex.mobile.ads.impl.sj1
                public final boolean apply(Object obj) {
                    return vz.b.a((Map.Entry) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean a(Map.Entry entry) {
            return entry.getKey() != null;
        }

        @Override // com.yandex.mobile.ads.impl.jc0, java.util.Map
        public final int size() {
            return super.size() - (super.containsKey(null) ? 1 : 0);
        }

        @Override // com.yandex.mobile.ads.impl.jc0, java.util.Map
        public final boolean isEmpty() {
            if (super.isEmpty()) {
                return true;
            }
            return super.size() == 1 && super.containsKey(null);
        }

        @Override // java.util.Map
        public final boolean equals(Object obj) {
            return obj != null && a(obj);
        }

        @Override // java.util.Map
        public final int hashCode() {
            return c();
        }
    }

    public vz(String str, int i, int i2, rh0 rh0Var) {
        super(true);
        this.h = str;
        this.f = i;
        this.g = i2;
        this.e = false;
        this.i = rh0Var;
        this.l = null;
        this.j = new rh0();
        this.k = false;
    }

    private URL a(URL url, String str) throws oh0 {
        if (str == null) {
            throw new oh0("Null location redirect", 2001);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new oh0("Unsupported protocol redirect: " + protocol, 2001);
            }
            if (this.e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new oh0("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", 2001);
        } catch (MalformedURLException e) {
            throw new oh0(e, 2001, 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029 A[Catch: IOException -> 0x0033, TRY_LEAVE, TryCatch #0 {IOException -> 0x0033, blocks: (B:4:0x0004, B:6:0x000d, B:9:0x0017, B:10:0x001d, B:13:0x0029), top: B:18:0x0004 }] */
    @Override // com.yandex.mobile.ads.impl.nv
    public final int read(byte[] bArr, int i, int i2) throws oh0 {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.q;
            if (j != -1) {
                long j2 = j - this.r;
                if (j2 != 0) {
                    i2 = (int) Math.min(i2, j2);
                    InputStream inputStream = this.n;
                    int i4 = x82.f10629a;
                    i3 = inputStream.read(bArr, i, i2);
                    if (i3 != -1) {
                        this.r += (long) i3;
                        c(i3);
                        return i3;
                    }
                }
            } else {
                InputStream inputStream2 = this.n;
                int i5 = x82.f10629a;
                i3 = inputStream2.read(bArr, i, i2);
                if (i3 != -1) {
                    this.r += (long) i3;
                    c(i3);
                    return i3;
                }
            }
            return -1;
        } catch (IOException e) {
            int i6 = x82.f10629a;
            throw oh0.a(e, 2);
        }
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection == null) {
            return ik0.g();
        }
        return new b(httpURLConnection.getHeaderFields());
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final void close() throws oh0 {
        try {
            InputStream inputStream = this.n;
            if (inputStream != null) {
                long j = this.q;
                long j2 = -1;
                if (j != -1) {
                    j2 = j - this.r;
                }
                a(this.m, j2);
                try {
                    inputStream.close();
                } catch (IOException e) {
                    int i = x82.f10629a;
                    throw new oh0(e, 2000, 3);
                }
            }
            this.n = null;
            f();
            if (this.o) {
                this.o = false;
                e();
            }
        } catch (Throwable th) {
            this.n = null;
            f();
            if (this.o) {
                this.o = false;
                e();
            }
            throw th;
        }
    }

    private HttpURLConnection d(uv uvVar) throws IOException {
        uvVar = uvVar;
        URL url = new URL(uvVar.f10424a.toString());
        int i = uvVar.c;
        byte[] bArr = uvVar.d;
        long j = uvVar.f;
        long j2 = uvVar.g;
        int i2 = 0;
        boolean z = (uvVar.i & 1) == 1;
        if (!this.e && !this.k) {
            return a(url, i, bArr, j, j2, z, true, uvVar.e);
        }
        URL urlA = url;
        int i3 = i;
        byte[] bArr2 = bArr;
        while (true) {
            int i4 = i2 + 1;
            if (i2 <= 20) {
                Map<String, String> map = uvVar.e;
                int i5 = i3;
                i2 = i4;
                URL url2 = urlA;
                j2 = j2;
                HttpURLConnection httpURLConnectionA = a(urlA, i3, bArr2, j, j2, z, false, map);
                int responseCode = httpURLConnectionA.getResponseCode();
                String headerField = httpURLConnectionA.getHeaderField("Location");
                if ((i5 == 1 || i5 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                    httpURLConnectionA.disconnect();
                    urlA = a(url2, headerField);
                    i3 = i5;
                } else {
                    if (i5 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                        return httpURLConnectionA;
                    }
                    httpURLConnectionA.disconnect();
                    if (this.k && responseCode == 302) {
                        i3 = i5;
                    } else {
                        bArr2 = null;
                        i3 = 1;
                    }
                    urlA = a(url2, headerField);
                }
            } else {
                throw new oh0(new NoRouteToHostException(oe.a("Too many redirects: ", i4)), 2001, 1);
            }
        }
    }

    private HttpURLConnection a(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map<String, String> map) throws IOException {
        String string;
        HttpURLConnection httpURLConnectionA = a(url);
        httpURLConnectionA.setConnectTimeout(this.f);
        httpURLConnectionA.setReadTimeout(this.g);
        HashMap map2 = new HashMap();
        rh0 rh0Var = this.i;
        if (rh0Var != null) {
            map2.putAll(rh0Var.a());
        }
        map2.putAll(this.j.a());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionA.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        int i2 = ei0.c;
        if (j == 0 && j2 == -1) {
            string = null;
        } else {
            StringBuilder sb = new StringBuilder("bytes=");
            sb.append(j);
            sb.append("-");
            if (j2 != -1) {
                sb.append((j + j2) - 1);
            }
            string = sb.toString();
        }
        if (string != null) {
            httpURLConnectionA.setRequestProperty("Range", string);
        }
        String str = this.h;
        if (str != null) {
            httpURLConnectionA.setRequestProperty("User-Agent", str);
        }
        httpURLConnectionA.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, z ? "gzip" : "identity");
        httpURLConnectionA.setInstanceFollowRedirects(z2);
        httpURLConnectionA.setDoOutput(bArr != null);
        httpURLConnectionA.setRequestMethod(uv.a(i));
        if (bArr != null) {
            httpURLConnectionA.setFixedLengthStreamingMode(bArr.length);
            httpURLConnectionA.connect();
            OutputStream outputStream = httpURLConnectionA.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnectionA.connect();
        }
        return httpURLConnectionA;
    }

    private void f() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                at0.a("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.m = null;
        }
    }

    private static void a(HttpURLConnection httpURLConnection, long j) {
        int i;
        if (httpURLConnection == null || (i = x82.f10629a) < 19 || i > 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                return;
            }
            String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Class<? super Object> superclass = inputStream.getClass().getSuperclass();
                superclass.getClass();
                Method declaredMethod = superclass.getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final long a(uv uvVar) throws oh0 {
        long j = 0;
        this.r = 0L;
        this.q = 0L;
        b(uvVar);
        try {
            HttpURLConnection httpURLConnectionD = d(uvVar);
            this.m = httpURLConnectionD;
            this.p = httpURLConnectionD.getResponseCode();
            httpURLConnectionD.getResponseMessage();
            int i = this.p;
            if (i >= 200 && i <= 299) {
                String contentType = httpURLConnectionD.getContentType();
                sj1<String> sj1Var = this.l;
                if (sj1Var != null && !sj1Var.apply(contentType)) {
                    f();
                    throw new ph0(contentType);
                }
                if (this.p == 200) {
                    long j2 = uvVar.f;
                    if (j2 != 0) {
                        j = j2;
                    }
                }
                boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(httpURLConnectionD.getHeaderField("Content-Encoding"));
                if (!zEqualsIgnoreCase) {
                    long j3 = uvVar.g;
                    if (j3 != -1) {
                        this.q = j3;
                    } else {
                        long jA = ei0.a(httpURLConnectionD.getHeaderField("Content-Length"), httpURLConnectionD.getHeaderField(HttpHeaders.CONTENT_RANGE));
                        this.q = jA != -1 ? jA - j : -1L;
                    }
                } else {
                    this.q = uvVar.g;
                }
                try {
                    this.n = httpURLConnectionD.getInputStream();
                    if (zEqualsIgnoreCase) {
                        this.n = new GZIPInputStream(this.n);
                    }
                    this.o = true;
                    c(uvVar);
                    try {
                        a(j);
                        return this.q;
                    } catch (IOException e) {
                        f();
                        if (e instanceof oh0) {
                            throw ((oh0) e);
                        }
                        throw new oh0(e, 2000, 1);
                    }
                } catch (IOException e2) {
                    f();
                    throw new oh0(e2, 2000, 1);
                }
            }
            Map<String, List<String>> headerFields = httpURLConnectionD.getHeaderFields();
            if (this.p == 416) {
                if (uvVar.f == ei0.a(httpURLConnectionD.getHeaderField(HttpHeaders.CONTENT_RANGE))) {
                    this.o = true;
                    c(uvVar);
                    long j4 = uvVar.g;
                    if (j4 != -1) {
                        return j4;
                    }
                    return 0L;
                }
            }
            InputStream errorStream = httpURLConnectionD.getErrorStream();
            try {
                if (errorStream != null) {
                    int i2 = x82.f10629a;
                    byte[] bArr = new byte[4096];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int i3 = errorStream.read(bArr);
                        if (i3 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i3);
                    }
                    byteArrayOutputStream.toByteArray();
                } else {
                    int i4 = x82.f10629a;
                }
            } catch (IOException unused) {
                int i5 = x82.f10629a;
            }
            f();
            throw new qh0(this.p, this.p == 416 ? new rv(2008) : null, headerFields);
        } catch (IOException e3) {
            f();
            throw oh0.a(e3, 1);
        }
    }

    public HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private void a(long j) throws IOException {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            int iMin = (int) Math.min(j, 4096);
            InputStream inputStream = this.n;
            int i = x82.f10629a;
            int i2 = inputStream.read(bArr, 0, iMin);
            if (Thread.currentThread().isInterrupted()) {
                throw new oh0(new InterruptedIOException(), 2000, 1);
            }
            if (i2 != -1) {
                j -= (long) i2;
                c(i2);
            } else {
                throw new oh0(2008);
            }
        }
    }
}
