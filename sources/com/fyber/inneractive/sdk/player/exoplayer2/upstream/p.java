package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.net.HttpHeaders;
import com.json.b9;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public final class p implements h {
    public static final Pattern o = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final AtomicReference p = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2168a;
    public final int b;
    public final int c;
    public final String d;
    public final w e;
    public final w f;
    public final m g;
    public HttpURLConnection h;
    public InputStream i;
    public boolean j;
    public long k;
    public long l;
    public long m;
    public long n;

    public p(String str, m mVar, int i, int i2, boolean z, w wVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.d = str;
        this.g = mVar;
        this.f = new w();
        this.b = i;
        this.c = i2;
        this.f2168a = z;
        this.e = wVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final Uri a() {
        HttpURLConnection httpURLConnection = this.h;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final HttpURLConnection b(k kVar) throws IOException {
        URL url = new URL(kVar.f2163a.toString());
        long j = kVar.c;
        long j2 = kVar.d;
        int i = 0;
        boolean z = (kVar.f & 1) == 1;
        if (!this.f2168a) {
            return a(url, null, j, j2, z, true);
        }
        while (true) {
            int i2 = i + 1;
            if (i > 20) {
                throw new NoRouteToHostException(com.fyber.inneractive.sdk.player.exoplayer2.m.a("Too many redirects: ", i2));
            }
            HttpURLConnection httpURLConnectionA = a(url, null, j, j2, z, false);
            int iHttpUrlConnectionGetResponseCode = DTExchangeNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnectionA);
            if (iHttpUrlConnectionGetResponseCode != 300 && iHttpUrlConnectionGetResponseCode != 301 && iHttpUrlConnectionGetResponseCode != 302 && iHttpUrlConnectionGetResponseCode != 303 && iHttpUrlConnectionGetResponseCode != 307 && iHttpUrlConnectionGetResponseCode != 308) {
                return httpURLConnectionA;
            }
            String headerField = httpURLConnectionA.getHeaderField("Location");
            DTExchangeNetworkBridge.httpUrlConnectionDisconnect(httpURLConnectionA);
            if (headerField == null) {
                throw new ProtocolException("Null location redirect");
            }
            URL url2 = new URL(url, headerField);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new ProtocolException("Unsupported protocol redirect: " + protocol);
            }
            i = i2;
            url = url2;
        }
    }

    public final void c() throws IOException {
        if (this.m == this.k) {
            return;
        }
        byte[] bArr = (byte[]) p.getAndSet(null);
        if (bArr == null) {
            bArr = new byte[4096];
        }
        while (true) {
            long j = this.m;
            long j2 = this.k;
            if (j == j2) {
                p.set(bArr);
                return;
            }
            int i = this.i.read(bArr, 0, (int) Math.min(j2 - j, bArr.length));
            if (Thread.interrupted()) {
                throw new InterruptedIOException();
            }
            if (i == -1) {
                throw new EOFException();
            }
            long j3 = i;
            this.m += j3;
            m mVar = this.g;
            if (mVar != null) {
                synchronized (mVar) {
                    mVar.d += j3;
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final void close() {
        try {
            if (this.i != null) {
                HttpURLConnection httpURLConnection = this.h;
                long j = this.l;
                if (j != -1) {
                    j -= this.n;
                }
                a(httpURLConnection, j);
                try {
                    this.i.close();
                } catch (IOException e) {
                    throw new u(e);
                }
            }
            this.i = null;
            b();
            if (this.j) {
                this.j = false;
                m mVar = this.g;
                if (mVar != null) {
                    mVar.a();
                }
            }
        } catch (Throwable th) {
            this.i = null;
            b();
            if (this.j) {
                this.j = false;
                m mVar2 = this.g;
                if (mVar2 != null) {
                    mVar2.a();
                }
            }
            throw th;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final int read(byte[] bArr, int i, int i2) throws u {
        try {
            c();
            return a(bArr, i, i2);
        } catch (IOException e) {
            throw new u(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0028  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final long a(k kVar) throws u {
        long j;
        long jMax;
        this.n = 0L;
        this.m = 0L;
        try {
            HttpURLConnection httpURLConnectionB = b(kVar);
            this.h = httpURLConnectionB;
            try {
                int iHttpUrlConnectionGetResponseCode = DTExchangeNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnectionB);
                if (iHttpUrlConnectionGetResponseCode < 200 || iHttpUrlConnectionGetResponseCode > 299) {
                    this.h.getHeaderFields();
                    b();
                    v vVar = new v(iHttpUrlConnectionGetResponseCode);
                    if (iHttpUrlConnectionGetResponseCode != 416) {
                        throw vVar;
                    }
                    vVar.initCause(new i());
                    throw vVar;
                }
                this.h.getContentType();
                if (iHttpUrlConnectionGetResponseCode == 200) {
                    j = kVar.c;
                    if (j == 0) {
                        j = 0;
                    }
                } else {
                    j = 0;
                }
                this.k = j;
                if ((kVar.f & 1) == 1) {
                    this.l = kVar.d;
                } else {
                    long j2 = kVar.d;
                    if (j2 != -1) {
                        this.l = j2;
                    } else {
                        HttpURLConnection httpURLConnection = this.h;
                        String headerField = httpURLConnection.getHeaderField("Content-Length");
                        if (TextUtils.isEmpty(headerField)) {
                            jMax = -1;
                        } else {
                            try {
                                jMax = Long.parseLong(headerField);
                            } catch (NumberFormatException unused) {
                                Log.e("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField + b9.i.e);
                                jMax = -1;
                            }
                        }
                        String headerField2 = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_RANGE);
                        if (!TextUtils.isEmpty(headerField2)) {
                            Matcher matcher = o.matcher(headerField2);
                            if (matcher.find()) {
                                try {
                                    long j3 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                                    if (jMax < 0) {
                                        jMax = j3;
                                    } else if (jMax != j3) {
                                        Log.w("DefaultHttpDataSource", "Inconsistent headers [" + headerField + "] [" + headerField2 + b9.i.e);
                                        jMax = Math.max(jMax, j3);
                                    }
                                } catch (NumberFormatException unused2) {
                                    Log.e("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField2 + b9.i.e);
                                }
                            }
                        }
                        this.l = jMax != -1 ? jMax - this.k : -1L;
                    }
                }
                try {
                    this.i = DTExchangeNetworkBridge.urlConnectionGetInputStream(this.h);
                    this.j = true;
                    m mVar = this.g;
                    if (mVar != null) {
                        synchronized (mVar) {
                            if (mVar.b == 0) {
                                mVar.c = SystemClock.elapsedRealtime();
                            }
                            mVar.b++;
                        }
                    }
                    return this.l;
                } catch (IOException e) {
                    b();
                    throw new u(e);
                }
            } catch (IOException e2) {
                b();
                throw new u("Unable to connect to " + kVar.f2163a.toString(), e2);
            }
        } catch (IOException e3) {
            throw new u("Unable to connect to " + kVar.f2163a.toString(), e3);
        }
    }

    public final HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        Map map;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.b);
        httpURLConnection.setReadTimeout(this.c);
        w wVar = this.e;
        if (wVar != null) {
            synchronized (wVar) {
                if (wVar.b == null) {
                    wVar.b = Collections.unmodifiableMap(new HashMap(wVar.f2172a));
                }
                map = wVar.b;
            }
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        for (Map.Entry entry2 : this.f.a().entrySet()) {
            httpURLConnection.setRequestProperty((String) entry2.getKey(), (String) entry2.getValue());
        }
        if (j != 0 || j2 != -1) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.d);
        if (!z) {
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStreamUrlConnectionGetOutputStream = DTExchangeNetworkBridge.urlConnectionGetOutputStream(httpURLConnection);
                outputStreamUrlConnectionGetOutputStream.write(bArr);
                outputStreamUrlConnectionGetOutputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    public final int a(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.l;
        if (j != -1) {
            long j2 = j - this.n;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = this.i.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.l == -1) {
                return -1;
            }
            throw new EOFException();
        }
        long j3 = i3;
        this.n += j3;
        m mVar = this.g;
        if (mVar != null) {
            synchronized (mVar) {
                mVar.d += j3;
            }
        }
        return i3;
    }

    public static void a(HttpURLConnection httpURLConnection, long j) {
        int i = com.fyber.inneractive.sdk.player.exoplayer2.util.z.f2192a;
        if (i == 19 || i == 20) {
            try {
                InputStream inputStreamUrlConnectionGetInputStream = DTExchangeNetworkBridge.urlConnectionGetInputStream(httpURLConnection);
                if (j == -1) {
                    if (inputStreamUrlConnectionGetInputStream.read() == -1) {
                        return;
                    }
                } else if (j <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                    return;
                }
                String name = inputStreamUrlConnectionGetInputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStreamUrlConnectionGetInputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", null);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStreamUrlConnectionGetInputStream, null);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void b() {
        HttpURLConnection httpURLConnection = this.h;
        if (httpURLConnection != null) {
            try {
                DTExchangeNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.h = null;
        }
    }
}
