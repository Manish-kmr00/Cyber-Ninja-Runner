package com.google.android.gms.ads.internal.util.client;

import android.net.TrafficStats;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzfpj;
import com.safedk.android.internal.partials.AdMobNetworkBridge;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzu implements zze {
    private final String zza;
    private String zzb;

    public zzu() {
        throw null;
    }

    public zzu(String str) {
        this.zza = str;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0102 A[PHI: r5
  0x0102: PHI (r5v2 com.google.android.gms.ads.internal.util.client.zzt) = 
  (r5v0 com.google.android.gms.ads.internal.util.client.zzt)
  (r5v1 com.google.android.gms.ads.internal.util.client.zzt)
  (r5v4 com.google.android.gms.ads.internal.util.client.zzt)
 binds: [B:46:0x0100, B:42:0x00e0, B:26:0x00b0] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.ads.internal.util.client.zze
    public final zzt zza(String str) {
        zzt zztVar;
        zzt zztVar2 = zzt.PERMANENT_FAILURE;
        try {
            try {
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.setThreadStatsTag(263);
                }
                zzo.zze("Pinging URL: " + str);
                URL url = new URI(str).toURL();
                int i = zzfpj.zzb;
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    zzbb.zzb();
                    String str2 = this.zza;
                    httpURLConnection.setConnectTimeout(60000);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setReadTimeout(60000);
                    if (str2 != null) {
                        httpURLConnection.setRequestProperty("User-Agent", str2);
                    }
                    httpURLConnection.setUseCaches(false);
                    zzl zzlVar = new zzl(null);
                    zzlVar.zzc(httpURLConnection, null);
                    int iHttpUrlConnectionGetResponseCode = AdMobNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
                    zzlVar.zze(httpURLConnection, iHttpUrlConnectionGetResponseCode);
                    if (iHttpUrlConnectionGetResponseCode < 200 || iHttpUrlConnectionGetResponseCode >= 300) {
                        zzo.zzj("Received non-success response code " + iHttpUrlConnectionGetResponseCode + " from pinging URL: " + str);
                        if (iHttpUrlConnectionGetResponseCode == 502) {
                            zztVar = zzt.RETRIABLE_FAILURE;
                        } else {
                            AdMobNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                            if (ClientLibraryUtils.isPackageSide()) {
                                TrafficStats.clearThreadStatsTag();
                            }
                        }
                        return zztVar2;
                    }
                    if (((Boolean) zzbd.zzc().zzb(zzbci.zzhT)).booleanValue()) {
                        this.zzb = httpURLConnection.getHeaderField("X-Afma-Ad-Event-Value");
                    }
                    zztVar = zzt.SUCCESS;
                    zztVar2 = zztVar;
                    AdMobNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                    if (ClientLibraryUtils.isPackageSide()) {
                        TrafficStats.clearThreadStatsTag();
                    }
                    return zztVar2;
                } catch (Throwable th) {
                    AdMobNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                    throw th;
                }
            } catch (IOException e) {
                e = e;
                zzo.zzj("Error while pinging URL: " + str + ". " + e.getMessage());
                zztVar2 = zzt.RETRIABLE_FAILURE;
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
                zzo.zzj("Error while parsing ping URL: " + str + ". " + e.getMessage());
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (RuntimeException e3) {
                e = e3;
                zzo.zzj("Error while pinging URL: " + str + ". " + e.getMessage());
                zztVar2 = zzt.RETRIABLE_FAILURE;
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (URISyntaxException e4) {
                e = e4;
                zzo.zzj("Error while parsing ping URL: " + str + ". " + e.getMessage());
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            }
        } catch (Throwable th2) {
            if (ClientLibraryUtils.isPackageSide()) {
                TrafficStats.clearThreadStatsTag();
            }
            throw th2;
        }
    }

    public final String zzb() {
        return this.zzb;
    }
}
