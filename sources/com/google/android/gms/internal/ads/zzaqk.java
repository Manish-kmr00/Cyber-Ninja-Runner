package com.google.android.gms.internal.ads;

import com.safedk.android.internal.partials.AdMobNetworkBridge;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaqk extends zzapx {
    public zzaqk() {
        throw null;
    }

    public zzaqk(zzaqj zzaqjVar, SSLSocketFactory sSLSocketFactory) {
    }

    static List zzb(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new zzapb((String) entry.getKey(), (String) it.next()));
                }
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzapx
    public final zzaqh zza(zzapj zzapjVar, Map map) throws Throwable {
        String strZzk = zzapjVar.zzk();
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(zzapjVar.zzl());
        URL url = new URL(strZzk);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int iZzb = zzapjVar.zzb();
        httpURLConnection.setConnectTimeout(iZzb);
        httpURLConnection.setReadTimeout(iZzb);
        boolean z = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        "https".equals(url.getProtocol());
        try {
            for (String str : map2.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) map2.get(str));
            }
            if (zzapjVar.zza() != 0) {
                httpURLConnection.setRequestMethod("POST");
                byte[] bArrZzx = zzapjVar.zzx();
                if (bArrZzx != null) {
                    httpURLConnection.setDoOutput(true);
                    if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                    }
                    DataOutputStream dataOutputStream = new DataOutputStream(AdMobNetworkBridge.urlConnectionGetOutputStream(httpURLConnection));
                    dataOutputStream.write(bArrZzx);
                    dataOutputStream.close();
                }
            } else {
                httpURLConnection.setRequestMethod("GET");
            }
            int iHttpUrlConnectionGetResponseCode = AdMobNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
            if (iHttpUrlConnectionGetResponseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            zzapjVar.zza();
            if ((iHttpUrlConnectionGetResponseCode >= 100 && iHttpUrlConnectionGetResponseCode < 200) || iHttpUrlConnectionGetResponseCode == 204 || iHttpUrlConnectionGetResponseCode == 304) {
                zzaqh zzaqhVar = new zzaqh(iHttpUrlConnectionGetResponseCode, zzb(httpURLConnection.getHeaderFields()), -1, null);
                AdMobNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                return zzaqhVar;
            }
            try {
                return new zzaqh(iHttpUrlConnectionGetResponseCode, zzb(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new zzaqi(httpURLConnection));
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    AdMobNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
