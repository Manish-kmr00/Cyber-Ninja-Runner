package com.mbridge.msdk.click;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.MBridgeHostnameVerifier;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: compiled from: JavaHttpSpider.java */
/* JADX INFO: loaded from: classes9.dex */
public class i {
    private static final String f = "i";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.setting.g f4738a;
    private String b;
    private boolean c = true;
    private final int d = 3145728;
    private com.mbridge.msdk.click.entity.a e;

    public i() {
        com.mbridge.msdk.setting.g gVarD = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        this.f4738a = gVarD;
        if (gVarD == null) {
            this.f4738a = com.mbridge.msdk.setting.h.b().a();
        }
    }

    public com.mbridge.msdk.click.entity.a a(String str, boolean z, boolean z2, CampaignEx campaignEx) {
        int i;
        HttpsURLConnection httpsURLConnection = null;
        if (!URLUtil.isNetworkUrl(str)) {
            return null;
        }
        String strReplace = str.replace(" ", "%20");
        this.e = new com.mbridge.msdk.click.entity.a();
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(strReplace).openConnection();
            try {
                httpsURLConnection2.setHostnameVerifier(new MBridgeHostnameVerifier(strReplace));
                httpsURLConnection2.setRequestMethod("GET");
                if ((!z && !z2) || campaignEx == null) {
                    httpsURLConnection2.setRequestProperty("User-Agent", k0.i());
                }
                if (z && campaignEx != null && campaignEx.getcUA() == 1) {
                    httpsURLConnection2.setRequestProperty("User-Agent", k0.i());
                }
                if (z2 && campaignEx != null && campaignEx.getImpUA() == 1) {
                    httpsURLConnection2.setRequestProperty("User-Agent", k0.i());
                }
                httpsURLConnection2.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip");
                if (this.f4738a.I0() && !TextUtils.isEmpty(this.b)) {
                    httpsURLConnection2.setRequestProperty("referer", this.b);
                }
                httpsURLConnection2.setConnectTimeout(60000);
                httpsURLConnection2.setReadTimeout(60000);
                httpsURLConnection2.setInstanceFollowRedirects(false);
                httpsURLConnection2.connect();
                this.e.f4734a = httpsURLConnection2.getHeaderField("Location");
                this.e.d = httpsURLConnection2.getHeaderField(HttpHeaders.REFERER);
                this.e.f = MintegralNetworkBridge.httpUrlConnectionGetResponseCode(httpsURLConnection2);
                this.e.b = httpsURLConnection2.getContentType();
                this.e.e = httpsURLConnection2.getContentLength();
                this.e.c = httpsURLConnection2.getContentEncoding();
                boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(this.e.c);
                com.mbridge.msdk.click.entity.a aVar = this.e;
                if (aVar.f == 200 && this.c && (i = aVar.e) > 0 && i < 3145728 && !TextUtils.isEmpty(strReplace)) {
                    try {
                        String strA = a(MintegralNetworkBridge.urlConnectionGetInputStream(httpsURLConnection2), zEqualsIgnoreCase);
                        if (!TextUtils.isEmpty(strA)) {
                            byte[] bytes = strA.getBytes();
                            if (bytes.length > 0 && bytes.length < 3145728) {
                                this.e.g = strA.trim();
                            }
                        }
                    } catch (Throwable th) {
                        o0.b(f, th.getMessage());
                    }
                }
                this.b = strReplace;
                MintegralNetworkBridge.httpUrlConnectionDisconnect(httpsURLConnection2);
                return this.e;
            } catch (Throwable th2) {
                th = th2;
                httpsURLConnection = httpsURLConnection2;
                try {
                    this.e.h = th.getMessage();
                    return this.e;
                } finally {
                    if (httpsURLConnection != null) {
                        MintegralNetworkBridge.httpUrlConnectionDisconnect(httpsURLConnection);
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0034 A[Catch: all -> 0x002d, TryCatch #5 {all -> 0x002d, blocks: (B:4:0x0008, B:5:0x000e, B:21:0x0030, B:23:0x0034, B:24:0x0041), top: B:38:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x004c A[Catch: Exception -> 0x0026, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0026, blocks: (B:10:0x0022, B:26:0x004c), top: B:41:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private String a(InputStream inputStream, boolean z) throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        Exception e;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            if (z) {
                try {
                    try {
                        inputStream = new GZIPInputStream(inputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e2) {
                                o0.b(f, e2.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    if (this.e == null) {
                        com.mbridge.msdk.click.entity.a aVar = new com.mbridge.msdk.click.entity.a();
                        this.e = aVar;
                        aVar.h = e.getMessage();
                    }
                    o0.b(f, e.getMessage());
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return sb.toString();
                }
            }
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                } catch (Exception e4) {
                    e = e4;
                    bufferedReader2 = bufferedReader;
                    if (this.e == null) {
                        com.mbridge.msdk.click.entity.a aVar2 = new com.mbridge.msdk.click.entity.a();
                        this.e = aVar2;
                        aVar2.h = e.getMessage();
                    }
                    o0.b(f, e.getMessage());
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return sb.toString();
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
            bufferedReader.close();
        } catch (Exception e5) {
            o0.b(f, e5.getMessage());
        }
        return sb.toString();
    }
}
