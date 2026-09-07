package com.json.mediationsdk.server;

import android.text.TextUtils;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.p;
import com.json.o9;
import com.json.xe;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes9.dex */
public class HttpFunctions {
    public static final String ERROR_PREFIX = "ERROR:";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f4017a = 15000;
    private static final String b = "GET";
    private static final String c = "POST";
    private static final String d = "UTF-8";
    private static final String e = "Bad Request - 400";
    private static final ExecutorService f = Executors.newSingleThreadExecutor();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4018a;
        final /* synthetic */ String b;
        final /* synthetic */ xe c;

        a(String str, String str2, xe xeVar) {
            this.f4018a = str;
            this.b = str2;
            this.c = xeVar;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            HttpURLConnection httpURLConnectionB;
            OutputStream outputStreamUrlConnectionGetOutputStream;
            try {
                httpURLConnectionB = HttpFunctions.b(this.f4018a);
                try {
                    outputStreamUrlConnectionGetOutputStream = IronSourceNetworkBridge.urlConnectionGetOutputStream(httpURLConnectionB);
                    try {
                        try {
                            HttpFunctions.b(this.b, outputStreamUrlConnectionGetOutputStream);
                            int iHttpUrlConnectionGetResponseCode = IronSourceNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnectionB);
                            boolean z = iHttpUrlConnectionGetResponseCode == 200;
                            if (!z) {
                                IronLog.INTERNAL.error("invalid response code " + iHttpUrlConnectionGetResponseCode + " sending request");
                            }
                            this.c.a(z);
                        } catch (Throwable th) {
                            th = th;
                            HttpFunctions.b(outputStreamUrlConnectionGetOutputStream, httpURLConnectionB, null);
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        o9.d().a(e);
                        IronLog.INTERNAL.error("exception while sending request " + e.getMessage());
                        this.c.a(false);
                    }
                } catch (Exception e2) {
                    e = e2;
                    outputStreamUrlConnectionGetOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    outputStreamUrlConnectionGetOutputStream = null;
                    HttpFunctions.b(outputStreamUrlConnectionGetOutputStream, httpURLConnectionB, null);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                httpURLConnectionB = null;
                outputStreamUrlConnectionGetOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnectionB = null;
                outputStreamUrlConnectionGetOutputStream = null;
            }
            HttpFunctions.b(outputStreamUrlConnectionGetOutputStream, httpURLConnectionB, null);
        }
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HttpURLConnection b(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        return httpURLConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(OutputStream outputStream, HttpURLConnection httpURLConnection, BufferedReader bufferedReader) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                o9.d().a(e2);
                IronLog.INTERNAL.error("exception while closing output stream " + e2.getMessage());
            }
        }
        if (httpURLConnection != null) {
            IronSourceNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                o9.d().a(e3);
                IronLog.INTERNAL.error("exception while closing reader " + e3.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        bufferedWriter.write(str);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static String getStringFromURL(String str) throws Exception {
        return getStringFromURL(str, null);
    }

    public static String getStringFromURL(String str, p.c cVar) throws Throwable {
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        Exception e2;
        BufferedReader bufferedReader2;
        Throwable th;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                if (IronSourceNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection) == 400) {
                    if (cVar != null) {
                        cVar.a(e);
                    }
                    b(null, httpURLConnection, null);
                    return null;
                }
                bufferedReader2 = new BufferedReader(new InputStreamReader(IronSourceNetworkBridge.urlConnectionGetInputStream(httpURLConnection)));
                try {
                    String strA = a(bufferedReader2);
                    b(null, httpURLConnection, bufferedReader2);
                    return strA;
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        o9.d().a(e2);
                        b(null, httpURLConnection, bufferedReader2);
                        return null;
                    } catch (Throwable th2) {
                        bufferedReader = bufferedReader2;
                        th = th2;
                        BufferedReader bufferedReader3 = bufferedReader;
                        th = th;
                        bufferedReader2 = bufferedReader3;
                        b(null, httpURLConnection, bufferedReader2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    b(null, httpURLConnection, bufferedReader2);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                e2 = e;
                bufferedReader2 = null;
                o9.d().a(e2);
                b(null, httpURLConnection, bufferedReader2);
                return null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                BufferedReader bufferedReader4 = bufferedReader;
                th = th;
                bufferedReader2 = bufferedReader4;
                b(null, httpURLConnection, bufferedReader2);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            httpURLConnection = null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            bufferedReader = null;
        }
    }

    public static String sendPostRequest(String str, String str2, p.c cVar) {
        Throwable th;
        BufferedReader bufferedReader;
        OutputStream outputStreamUrlConnectionGetOutputStream;
        Exception e2;
        HttpURLConnection httpURLConnectionB;
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnectionB = b(str);
            try {
                httpURLConnectionB.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                outputStreamUrlConnectionGetOutputStream = IronSourceNetworkBridge.urlConnectionGetOutputStream(httpURLConnectionB);
                try {
                    b(str2, outputStreamUrlConnectionGetOutputStream);
                    int iHttpUrlConnectionGetResponseCode = IronSourceNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnectionB);
                    if (iHttpUrlConnectionGetResponseCode != 200) {
                        if (iHttpUrlConnectionGetResponseCode == 400 && cVar != null) {
                            cVar.a(e);
                        }
                        b(outputStreamUrlConnectionGetOutputStream, httpURLConnectionB, null);
                        return null;
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(IronSourceNetworkBridge.urlConnectionGetInputStream(httpURLConnectionB)));
                    try {
                        String strA = a(bufferedReader);
                        b(outputStreamUrlConnectionGetOutputStream, httpURLConnectionB, bufferedReader);
                        return strA;
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            o9.d().a(e2);
                            IronLog.INTERNAL.error("exception while sending request " + e2.getMessage());
                            b(outputStreamUrlConnectionGetOutputStream, httpURLConnectionB, bufferedReader);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection = httpURLConnectionB;
                            httpURLConnectionB = httpURLConnection;
                            b(outputStreamUrlConnectionGetOutputStream, httpURLConnectionB, bufferedReader);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        b(outputStreamUrlConnectionGetOutputStream, httpURLConnectionB, bufferedReader);
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    bufferedReader = null;
                    o9.d().a(e2);
                    IronLog.INTERNAL.error("exception while sending request " + e2.getMessage());
                    b(outputStreamUrlConnectionGetOutputStream, httpURLConnectionB, bufferedReader);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    httpURLConnection = httpURLConnectionB;
                    httpURLConnectionB = httpURLConnection;
                    b(outputStreamUrlConnectionGetOutputStream, httpURLConnectionB, bufferedReader);
                    throw th;
                }
            } catch (Exception e5) {
                e2 = e5;
                outputStreamUrlConnectionGetOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                outputStreamUrlConnectionGetOutputStream = null;
            }
        } catch (Exception e6) {
            e2 = e6;
            httpURLConnectionB = null;
            outputStreamUrlConnectionGetOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
            outputStreamUrlConnectionGetOutputStream = null;
            httpURLConnectionB = httpURLConnection;
            b(outputStreamUrlConnectionGetOutputStream, httpURLConnectionB, bufferedReader);
            throw th;
        }
    }

    public static void sendPostRequest(String str, String str2, xe xeVar) {
        f.submit(new a(str, str2, xeVar));
    }
}
