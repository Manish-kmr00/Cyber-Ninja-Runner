package com.pgl.ssdk;

import android.content.Context;
import com.google.common.net.HttpHeaders;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.util.Locale;

/* JADX INFO: loaded from: classes9.dex */
public abstract class m0 {
    private Context b;
    private String c;
    private int d;
    private int e;
    private byte[] f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7522a = "";
    private int g = -1;
    private byte[] h = null;
    private int i = 10000;
    private int j = 2;
    private int k = 0;
    private boolean l = false;
    private boolean m = true;
    private HttpURLConnection n = null;
    private Runnable o = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m0.this.a() || m0.this.k >= m0.this.j) {
                return;
            }
            m0.c(m0.this);
            o0.a(this);
        }
    }

    public m0(Context context, String str) {
        str = (str == null || str.length() <= 0) ? "" : str;
        this.b = context;
        this.c = str;
    }

    static /* synthetic */ int c(m0 m0Var) {
        int i = m0Var.k;
        m0Var.k = i + 1;
        return i;
    }

    public abstract boolean a(int i, byte[] bArr);

    private void a(int i) throws ProtocolException {
        String str;
        if (i == 1) {
            str = "POST";
        } else if (i == 3) {
            str = com.safedk.android.a.g.f;
        } else if (i == 4) {
            str = "DELETE";
        } else if (i != 5) {
            str = i != 6 ? "GET" : "TRACE";
        } else {
            str = "HEAD";
        }
        this.n.setRequestMethod(str);
    }

    private void b(int i) {
        String str;
        if (i != 1) {
            str = i != 2 ? "" : "application/octet-stream";
        } else {
            str = "application/json; charset=utf-8";
        }
        if (str.length() > 0) {
            this.n.addRequestProperty("Content-Type", str);
        }
        this.n.addRequestProperty(HttpHeaders.COOKIE, "sessionid=" + this.c);
        try {
            String language = Locale.getDefault().getLanguage();
            if (language.equalsIgnoreCase("zh")) {
                this.n.addRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, Locale.getDefault().toString() + StringUtils.COMMA + language + ";q=0.9");
            } else {
                this.n.addRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, Locale.getDefault().toString() + StringUtils.COMMA + language + ";q=0.9,en-US;q=0.6,en;q=0.4");
            }
        } catch (Throwable unused) {
        }
    }

    private byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr, 0, 1024);
            if (i > 0) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0075 A[Catch: all -> 0x007d, PHI: r1
  0x0075: PHI (r1v14 java.io.InputStream) = (r1v13 java.io.InputStream), (r1v19 java.io.InputStream) binds: [B:18:0x0072, B:15:0x006e] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x007d, blocks: (B:3:0x0001, B:5:0x000c, B:7:0x001f, B:9:0x003c, B:11:0x003f, B:12:0x0055, B:20:0x0075, B:6:0x0017), top: B:36:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0083 A[PHI: r1 r2
  0x0083: PHI (r1v1 java.net.HttpURLConnection) = (r1v0 java.net.HttpURLConnection), (r1v15 java.net.HttpURLConnection) binds: [B:25:0x0080, B:22:0x007a] A[DONT_GENERATE, DONT_INLINE]
  0x0083: PHI (r2v1 boolean) = (r2v0 boolean), (r2v7 boolean) binds: [B:25:0x0080, B:22:0x007a] A[DONT_GENERATE, DONT_INLINE]] */
    public boolean a() {
        HttpURLConnection httpURLConnection;
        boolean z;
        InputStream inputStream;
        try {
            URL url = new URL(this.f7522a);
            if (this.m) {
                this.n = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
            } else {
                this.n = (HttpURLConnection) url.openConnection();
            }
            this.n.setConnectTimeout(this.i);
            this.n.setReadTimeout(this.i);
            a(this.d);
            b(this.e);
            byte[] bArr = this.f;
            z = true;
            if (bArr != null && bArr.length > 0) {
                this.n.setDoOutput(true);
                OutputStream outputStream = this.n.getOutputStream();
                outputStream.write(this.f);
                outputStream.flush();
                outputStream.close();
            }
            this.n.connect();
            try {
                this.g = this.n.getResponseCode();
                inputStream = this.n.getInputStream();
                try {
                    this.h = a(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable unused) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (Throwable unused2) {
                inputStream = null;
            }
            httpURLConnection = this.n;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                this.n = null;
            }
        } catch (Throwable unused3) {
            httpURLConnection = this.n;
            z = false;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                this.n = null;
            }
        }
        if (z) {
            a(this.g, this.h);
        }
        return z;
    }

    private void b(int i, int i2, byte[] bArr) {
        this.d = i;
        this.e = i2;
        this.f = bArr;
    }

    public void a(int i, int i2, byte[] bArr) {
        b(i, i2, bArr);
        o0.a(this.o);
    }
}
