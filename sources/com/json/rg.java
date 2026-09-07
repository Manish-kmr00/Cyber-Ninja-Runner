package com.json;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes9.dex */
public class rg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4223a = "POST";
    private static final String b = "GET";
    private static final String c = "ISHttpService";

    public static class a {
        private static final int h = 15000;
        private static final int i = 15000;
        private static final String j = "UTF-8";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f4224a;
        final String b;
        final String c;
        final int d;
        final int e;
        final String f;
        ArrayList<Pair<String, String>> g;

        /* JADX INFO: renamed from: com.ironsource.rg$a$a, reason: collision with other inner class name */
        static class C0401a {
            String b;
            String d;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            List<Pair<String, String>> f4225a = new ArrayList();
            String c = "POST";
            int e = 15000;
            int f = 15000;
            String g = "UTF-8";

            C0401a() {
            }

            C0401a a(int i) {
                this.e = i;
                return this;
            }

            C0401a a(Pair<String, String> pair) {
                this.f4225a.add(pair);
                return this;
            }

            C0401a a(String str) {
                this.d = str;
                return this;
            }

            C0401a a(List<Pair<String, String>> list) {
                this.f4225a.addAll(list);
                return this;
            }

            a a() {
                return new a(this);
            }

            C0401a b(int i) {
                this.f = i;
                return this;
            }

            C0401a b(String str) {
                this.g = str;
                return this;
            }

            C0401a c(String str) {
                this.b = str;
                return this;
            }

            C0401a d(String str) {
                this.c = str;
                return this;
            }
        }

        public a(C0401a c0401a) {
            this.f4224a = c0401a.b;
            this.b = c0401a.c;
            this.c = c0401a.d;
            this.g = new ArrayList<>(c0401a.f4225a);
            this.d = c0401a.e;
            this.e = c0401a.f;
            this.f = c0401a.g;
        }

        boolean a() {
            return "POST".equals(this.b);
        }
    }

    public static fq a(String str, String str2, List<Pair<String, String>> list) throws Exception {
        Uri uriBuild = Uri.parse(str).buildUpon().encodedQuery(str2).build();
        a.C0401a c0401a = new a.C0401a();
        c0401a.c(uriBuild.toString()).a(str2).d("GET").a(list);
        return b(c0401a.a());
    }

    private static HttpURLConnection a(a aVar) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(aVar.f4224a).openConnection();
        httpURLConnection.setConnectTimeout(aVar.d);
        httpURLConnection.setReadTimeout(aVar.e);
        httpURLConnection.setRequestMethod(aVar.b);
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection, a aVar) throws Exception {
        if (aVar.a()) {
            byte[] bytes = aVar.c.getBytes(aVar.f);
            httpURLConnection.setRequestProperty("Content-Length", Integer.toString(bytes.length));
            a(httpURLConnection, bytes);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, List<Pair<String, String>> list) throws ProtocolException {
        for (Pair<String, String> pair : list) {
            httpURLConnection.setRequestProperty((String) pair.first, (String) pair.second);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        httpURLConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(IronSourceNetworkBridge.urlConnectionGetOutputStream(httpURLConnection));
        try {
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
        } finally {
            dataOutputStream.close();
        }
    }

    private static boolean a(String str, String str2) {
        return (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) ? false : true;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00a0: MOVE (r8 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:42:0x00a0 */
    public static fq b(a aVar) throws Exception {
        HttpURLConnection httpURLConnectionA;
        InputStream inputStream;
        InputStream inputStream2;
        if (!a(aVar.f4224a, aVar.c)) {
            throw new InvalidParameterException("not valid params");
        }
        fq fqVar = new fq();
        InputStream inputStreamUrlConnectionGetInputStream = null;
        inputStreamUrlConnectionGetInputStream = null;
        inputStreamUrlConnectionGetInputStream = null;
        inputStreamUrlConnectionGetInputStream = null;
        inputStreamUrlConnectionGetInputStream = null;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnectionA = a(aVar);
                try {
                    a(httpURLConnectionA, aVar.g);
                    a(httpURLConnectionA, aVar);
                    inputStreamUrlConnectionGetInputStream = IronSourceNetworkBridge.urlConnectionGetInputStream(httpURLConnectionA);
                    fqVar.f3701a = IronSourceNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnectionA);
                    if (inputStreamUrlConnectionGetInputStream != null) {
                        fqVar.b = iv.a(inputStreamUrlConnectionGetInputStream);
                    }
                    if (inputStreamUrlConnectionGetInputStream != null) {
                        inputStreamUrlConnectionGetInputStream.close();
                    }
                } catch (InterruptedIOException e) {
                    e = e;
                    Log.d(c, "Failed post to " + aVar.f4224a + " exception: " + e.getMessage());
                    throw e;
                } catch (SSLException e2) {
                    e = e2;
                    Log.d(c, "Failed post to " + aVar.f4224a + " exception: " + e.getMessage());
                    throw e;
                } catch (IOException e3) {
                    e = e3;
                    inputStream = inputStreamUrlConnectionGetInputStream;
                    httpURLConnection = httpURLConnectionA;
                    o9.d().a(e);
                    if (httpURLConnection != null && httpURLConnection.getHeaderFields().isEmpty()) {
                        throw new go(e);
                    }
                    if (httpURLConnection != null) {
                        int iHttpUrlConnectionGetResponseCode = IronSourceNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
                        fqVar.f3701a = iHttpUrlConnectionGetResponseCode;
                        if (iHttpUrlConnectionGetResponseCode >= 400) {
                            Log.d(c, "Failed post to " + aVar.f4224a + " StatusCode: " + fqVar.f3701a);
                            if (inputStream != null) {
                                InputStream inputStream3 = inputStream;
                                httpURLConnectionA = httpURLConnection;
                                inputStreamUrlConnectionGetInputStream = inputStream3;
                                inputStreamUrlConnectionGetInputStream.close();
                            } else {
                                httpURLConnectionA = httpURLConnection;
                            }
                        }
                    }
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    if (inputStreamUrlConnectionGetInputStream != null) {
                        inputStreamUrlConnectionGetInputStream.close();
                    }
                    if (httpURLConnectionA != null) {
                        IronSourceNetworkBridge.httpUrlConnectionDisconnect(httpURLConnectionA);
                    }
                    throw th;
                }
            } catch (InterruptedIOException e4) {
                e = e4;
                Log.d(c, "Failed post to " + aVar.f4224a + " exception: " + e.getMessage());
                throw e;
            } catch (SSLException e5) {
                e = e5;
                Log.d(c, "Failed post to " + aVar.f4224a + " exception: " + e.getMessage());
                throw e;
            } catch (IOException e6) {
                e = e6;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnectionA = null;
            }
            IronSourceNetworkBridge.httpUrlConnectionDisconnect(httpURLConnectionA);
            return fqVar;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnectionA = null;
            inputStreamUrlConnectionGetInputStream = inputStream2;
        }
    }

    public static fq b(String str, String str2, List<Pair<String, String>> list) throws Exception {
        a.C0401a c0401a = new a.C0401a();
        c0401a.c(str).a(str2).d("POST").a(list);
        return b(c0401a.a());
    }
}
