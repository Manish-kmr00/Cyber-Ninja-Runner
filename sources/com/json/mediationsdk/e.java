package com.json.mediationsdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.json.environment.thread.IronSourceThreadManager;
import com.json.m5;
import com.json.mb;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceLogger;
import com.json.mediationsdk.logger.IronSourceLoggerManager;
import com.json.mediationsdk.utils.IronSourceAES;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.json.o5;
import com.json.o9;
import com.json.s4;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3972a = "1";
    private final String b = "102";
    private final String c = "102";
    private final String d = "GenericNotifications";
    private f e;
    private IronSource.AD_UNIT f;
    private o5 g;
    private s4 h;
    private ISBannerSize i;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected s4 f3973a;
        protected d.a b;
        protected int c;
        protected String d;
        protected long e;
        protected int f;
        private int h;
        private final URL k;
        private final JSONObject l;
        private final boolean m;
        private final int n;
        private final long o;
        private final boolean p;
        private final boolean q;
        protected String g = "other";
        protected String i = "";
        protected int j = 0;

        public a(s4 s4Var, URL url, JSONObject jSONObject, boolean z, int i, long j, boolean z2, boolean z3, int i2) {
            this.f3973a = s4Var;
            this.k = url;
            this.l = jSONObject;
            this.m = z;
            this.n = i;
            this.o = j;
            this.p = z2;
            this.q = z3;
            this.h = i2;
        }

        private String a() {
            return this.h == 2 ? mb.b().d() : mb.b().c();
        }

        private String a(HttpURLConnection httpURLConnection) throws IOException {
            InputStreamReader inputStreamReader = new InputStreamReader(IronSourceNetworkBridge.urlConnectionGetInputStream(httpURLConnection));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
                sb.append(line);
            }
        }

        private HttpURLConnection a(URL url, long j) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            httpURLConnection.setReadTimeout((int) j);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            return httpURLConnection;
        }

        private JSONObject a(String str, String str2) throws JSONException {
            String strDecode = IronSourceAES.decode(str, str2);
            if (TextUtils.isEmpty(strDecode)) {
                throw new JSONException("decryption error");
            }
            return IronSourceNetworkBridge.jsonObjectInit(strDecode);
        }

        private void a(long j, long j2) {
            long time = j - (new Date().getTime() - j2);
            if (time > 0) {
                SystemClock.sleep(time);
            }
        }

        private void a(HttpURLConnection httpURLConnection, JSONObject jSONObject, boolean z) throws Exception {
            String strA;
            String strEncode;
            OutputStream outputStreamUrlConnectionGetOutputStream = IronSourceNetworkBridge.urlConnectionGetOutputStream(httpURLConnection);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStreamUrlConnectionGetOutputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            if (this.h == 2) {
                try {
                    strA = mb.b().a();
                } catch (JSONException e) {
                    o9.d().a(e);
                    this.i = e.getLocalizedMessage();
                    this.j = 1015;
                    this.h = 1;
                    IronLog.INTERNAL.error("get encrypted session key exception " + e.getMessage());
                    strA = "";
                }
            } else {
                strA = "";
            }
            String string = jSONObject.toString();
            String strA2 = a();
            if (z) {
                IronLog.INTERNAL.verbose("compressing and encrypting auction request");
                strEncode = IronSourceAES.compressAndEncrypt(strA2, string);
            } else {
                strEncode = IronSourceAES.encode(strA2, string);
            }
            bufferedWriter.write(this.h == 2 ? String.format("{\"sk\" : \"%1$s\", \"ct\" : \"%2$s\"}", strA, strEncode) : String.format("{\"request\" : \"%1$s\"}", strEncode));
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStreamUrlConnectionGetOutputStream.close();
        }

        private JSONObject b(String str, String str2) throws JSONException {
            IronLog.INTERNAL.verbose("decrypting and decompressing auction response");
            String strDecryptAndDecompress = IronSourceAES.decryptAndDecompress(str, str2);
            if (strDecryptAndDecompress != null) {
                return IronSourceNetworkBridge.jsonObjectInit(strDecryptAndDecompress);
            }
            throw new JSONException("decompression error");
        }

        protected JSONObject a(JSONObject jSONObject, boolean z) throws JSONException {
            String strA = a();
            String string = jSONObject.getString(this.h == 2 ? "ct" : "response");
            return z ? b(strA, string) : a(strA, string);
        }

        protected void a(String str, boolean z, boolean z2) throws JSONException {
            if (TextUtils.isEmpty(str)) {
                throw new JSONException("empty response");
            }
            JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(str);
            if (z) {
                jSONObjectJsonObjectInit = a(jSONObjectJsonObjectInit, z2);
            }
            d.a aVarA = d.b().a(jSONObjectJsonObjectInit);
            this.b = aVarA;
            this.c = aVarA.c();
            this.d = this.b.d();
        }

        protected void a(boolean z, s4 s4Var, long j) {
            if (z) {
                s4Var.a(this.b.h(), this.b.a(), this.b.e(), this.b.f(), this.b.b(), this.f + 1, j, this.j, this.i);
            } else {
                s4Var.a(this.c, this.d, this.f + 1, this.g, j);
            }
        }

        protected boolean b() {
            String str;
            this.e = new Date().getTime();
            try {
                this.h = this.j == 1015 ? 1 : this.h;
                this.f = 0;
                HttpURLConnection httpURLConnectionA = null;
                while (true) {
                    int i = this.f;
                    int i2 = this.n;
                    if (i >= i2) {
                        this.f = i2 - 1;
                        this.g = "trials_fail";
                        return false;
                    }
                    try {
                        long time = new Date().getTime();
                        String str2 = "Auction Handler: auction trial " + (this.f + 1) + " out of " + this.n + " max trials";
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, str2, 0);
                        IronSourceUtils.sendAutomationLog(str2);
                        httpURLConnectionA = a(this.k, this.o);
                        a(httpURLConnectionA, this.l, this.p);
                        int iHttpUrlConnectionGetResponseCode = IronSourceNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnectionA);
                        if (iHttpUrlConnectionGetResponseCode == 200 || iHttpUrlConnectionGetResponseCode == 204) {
                            try {
                                a(a(httpURLConnectionA), this.m, this.q);
                                IronSourceNetworkBridge.httpUrlConnectionDisconnect(httpURLConnectionA);
                                return true;
                            } catch (JSONException e) {
                                o9.d().a(e);
                                if (e.getMessage() != null && e.getMessage().equalsIgnoreCase("decryption error")) {
                                    this.c = 1003;
                                    str = "Auction decryption error";
                                } else if (e.getMessage() == null || !e.getMessage().equalsIgnoreCase("decompression error")) {
                                    this.c = 1002;
                                    str = "Auction parsing error";
                                } else {
                                    this.c = 1008;
                                    str = "Auction decompression error";
                                }
                                this.d = str;
                                this.g = "parsing";
                                IronLog.INTERNAL.error("Auction handle response exception " + e.getMessage());
                                IronSourceNetworkBridge.httpUrlConnectionDisconnect(httpURLConnectionA);
                                return false;
                            }
                        }
                        this.c = 1001;
                        String str3 = "Auction response code not valid, error code response from server - " + iHttpUrlConnectionGetResponseCode;
                        this.d = str3;
                        IronLog.INTERNAL.error(str3);
                        IronSourceNetworkBridge.httpUrlConnectionDisconnect(httpURLConnectionA);
                        if (this.f < this.n - 1) {
                            a(this.o, time);
                        }
                        this.f++;
                    } catch (SocketTimeoutException e2) {
                        o9.d().a(e2);
                        if (httpURLConnectionA != null) {
                            IronSourceNetworkBridge.httpUrlConnectionDisconnect(httpURLConnectionA);
                        }
                        this.c = 1006;
                        this.d = "Connection timed out";
                        IronLog.INTERNAL.error("Auction socket timeout exception " + e2.getMessage());
                    } catch (Throwable th) {
                        o9.d().a(th);
                        IronLog.INTERNAL.error("getting exception " + th);
                        if (httpURLConnectionA != null) {
                            IronSourceNetworkBridge.httpUrlConnectionDisconnect(httpURLConnectionA);
                        }
                        this.c = 1000;
                        this.d = th.getMessage();
                        this.g = "other";
                        return false;
                    }
                }
            } catch (Exception e3) {
                o9.d().a(e3);
                this.c = 1007;
                this.d = e3.getMessage();
                this.f = 0;
                this.g = "other";
                IronLog.INTERNAL.error("Auction request exception " + e3.getMessage());
                return false;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zB = b();
            s4 s4Var = this.f3973a;
            if (s4Var == null) {
                return;
            }
            a(zB, s4Var, new Date().getTime() - this.e);
        }
    }

    @Deprecated
    public e(IronSource.AD_UNIT ad_unit, o5 o5Var, s4 s4Var) {
        this.f = ad_unit;
        this.g = o5Var;
        this.h = s4Var;
    }

    public e(f fVar) {
        this.e = fVar;
    }

    private JSONObject a(Map<String, Object> map, List<String> list, h hVar, int i, boolean z, IronSourceSegment ironSourceSegment) throws JSONException {
        i iVar = new i(this.f);
        iVar.a(map);
        iVar.a(list);
        iVar.a(hVar);
        iVar.a(i);
        iVar.a(this.i);
        iVar.a(ironSourceSegment);
        iVar.b(z);
        return d.b().a(iVar);
    }

    public void a(Context context, i iVar, s4 s4Var) {
        try {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.e.a(context, iVar, s4Var));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error("execute auction exception " + e.getMessage());
            if (s4Var != null) {
                s4Var.a(1000, e.getMessage(), 0, "other", 0L);
            }
        }
    }

    @Deprecated
    public void a(Context context, Map<String, Object> map, List<String> list, h hVar, int i, IronSourceSegment ironSourceSegment) {
        try {
            boolean zIsEncryptedResponse = IronSourceUtils.isEncryptedResponse();
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a(this.h, new URL(this.g.a(false)), a(map, list, hVar, i, zIsEncryptedResponse, ironSourceSegment), zIsEncryptedResponse, this.g.g(), this.g.m(), this.g.n(), this.g.o(), this.g.d()));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error("execute auction exception " + e.getMessage());
            this.h.a(1000, e.getMessage(), 0, "other", 0L);
        }
    }

    @Deprecated
    public void a(Context context, Map<String, Object> map, List<String> list, h hVar, int i, IronSourceSegment ironSourceSegment, ISBannerSize iSBannerSize) {
        this.i = iSBannerSize;
        a(context, map, list, hVar, i, ironSourceSegment);
    }

    public void a(m5 m5Var, int i, m5 m5Var2) {
        Iterator<String> it = m5Var.h().iterator();
        while (it.hasNext()) {
            d.b().a("reportLoadSuccess", m5Var.c(), d.b().a(it.next(), i, m5Var, "", "", ""));
        }
        if (m5Var2 != null) {
            Iterator<String> it2 = m5Var2.h().iterator();
            while (it2.hasNext()) {
                d.b().a("reportLoadSuccess", "GenericNotifications", d.b().a(it2.next(), i, m5Var, "", "102", ""));
            }
        }
    }

    public void a(m5 m5Var, int i, m5 m5Var2, String str) {
        Iterator<String> it = m5Var.b().iterator();
        while (it.hasNext()) {
            d.b().a("reportImpression", m5Var.c(), d.b().a(it.next(), i, m5Var, "", "", str));
        }
        if (m5Var2 != null) {
            Iterator<String> it2 = m5Var2.b().iterator();
            while (it2.hasNext()) {
                d.b().a("reportImpression", "GenericNotifications", d.b().a(it2.next(), i, m5Var, "", "102", str));
            }
        }
    }

    public void a(ArrayList<String> arrayList, ConcurrentHashMap<String, m5> concurrentHashMap, int i, m5 m5Var, m5 m5Var2) {
        int iJ = m5Var2.j();
        for (String str : arrayList) {
            if (!str.equals(m5Var2.c())) {
                m5 m5Var3 = concurrentHashMap.get(str);
                int iJ2 = m5Var3.j();
                String strI = m5Var3.i();
                String str2 = iJ2 < iJ ? "1" : "102";
                IronLog.INTERNAL.verbose("instance=" + m5Var3.c() + ", instancePriceOrder= " + iJ2 + ", loseReasonCode=" + str2 + ", winnerInstance=" + m5Var2.c() + ", winnerInstancePriceOrder=" + iJ);
                Iterator<String> it = m5Var3.g().iterator();
                while (it.hasNext()) {
                    d.b().a("reportAuctionLose", m5Var3.c(), d.b().a(it.next(), i, m5Var2, strI, str2, ""));
                }
            }
        }
        if (m5Var != null) {
            Iterator<String> it2 = m5Var.g().iterator();
            while (it2.hasNext()) {
                d.b().a("reportAuctionLose", "GenericNotifications", d.b().a(it2.next(), i, m5Var2, "", "102", ""));
            }
        }
    }

    public void a(CopyOnWriteArrayList<y> copyOnWriteArrayList, ConcurrentHashMap<String, m5> concurrentHashMap, int i, m5 m5Var, m5 m5Var2) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<y> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().c());
        }
        a(arrayList, concurrentHashMap, i, m5Var, m5Var2);
    }

    public boolean a() {
        return this.e.a();
    }
}
