package com.google.android.gms.internal.ads;

import android.net.Network;
import com.safedk.android.internal.partials.AdMobNetworkBridge;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzfqa extends zzfpo {
    private zzfuo<Integer> zza;
    private zzfuo<Integer> zzb;
    private zzfpz zzc;
    private HttpURLConnection zzd;

    zzfqa() {
        this(new zzfuo() { // from class: com.google.android.gms.internal.ads.zzfpq
            @Override // com.google.android.gms.internal.ads.zzfuo
            public final Object zza() {
                return zzfqa.zzf();
            }
        }, new zzfuo() { // from class: com.google.android.gms.internal.ads.zzfpr
            @Override // com.google.android.gms.internal.ads.zzfuo
            public final Object zza() {
                return zzfqa.zzg();
            }
        }, null);
    }

    zzfqa(zzfuo<Integer> zzfuoVar, zzfuo<Integer> zzfuoVar2, zzfpz zzfpzVar) {
        this.zza = zzfuoVar;
        this.zzb = zzfuoVar2;
        this.zzc = zzfpzVar;
    }

    static /* synthetic */ Integer zzf() {
        return -1;
    }

    static /* synthetic */ Integer zzg() {
        return -1;
    }

    static /* synthetic */ URLConnection zzp(URL url) throws IOException {
        int i = zzfpj.zzb;
        return url.openConnection();
    }

    public static void zzs(HttpURLConnection httpURLConnection) {
        zzfpp.zza();
        if (httpURLConnection != null) {
            AdMobNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        zzs(this.zzd);
    }

    public HttpURLConnection zzm() throws IOException {
        zzfpp.zzb(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzfpz zzfpzVar = this.zzc;
        zzfpzVar.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzfpzVar.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    public HttpURLConnection zzn(zzfpz zzfpzVar, final int i, final int i2) throws IOException {
        this.zza = new zzfuo() { // from class: com.google.android.gms.internal.ads.zzfps
            @Override // com.google.android.gms.internal.ads.zzfuo
            public final Object zza() {
                return Integer.valueOf(i);
            }
        };
        this.zzb = new zzfuo() { // from class: com.google.android.gms.internal.ads.zzfpt
            @Override // com.google.android.gms.internal.ads.zzfuo
            public final Object zza() {
                return Integer.valueOf(i2);
            }
        };
        this.zzc = zzfpzVar;
        return zzm();
    }

    public HttpURLConnection zzo(final Network network, final URL url, final int i, final int i2) throws IOException {
        this.zza = new zzfuo() { // from class: com.google.android.gms.internal.ads.zzfpu
            @Override // com.google.android.gms.internal.ads.zzfuo
            public final Object zza() {
                return Integer.valueOf(i);
            }
        };
        this.zzb = new zzfuo() { // from class: com.google.android.gms.internal.ads.zzfpv
            @Override // com.google.android.gms.internal.ads.zzfuo
            public final Object zza() {
                return Integer.valueOf(i2);
            }
        };
        this.zzc = new zzfpz() { // from class: com.google.android.gms.internal.ads.zzfpw
            @Override // com.google.android.gms.internal.ads.zzfpz
            public final URLConnection zza() {
                return network.openConnection(url);
            }
        };
        return zzm();
    }

    public URLConnection zzr(final URL url, final int i) throws IOException {
        this.zza = new zzfuo() { // from class: com.google.android.gms.internal.ads.zzfpx
            @Override // com.google.android.gms.internal.ads.zzfuo
            public final Object zza() {
                return Integer.valueOf(i);
            }
        };
        this.zzc = new zzfpz() { // from class: com.google.android.gms.internal.ads.zzfpy
            @Override // com.google.android.gms.internal.ads.zzfpz
            public final URLConnection zza() {
                return zzfqa.zzp(url);
            }
        };
        return zzm();
    }
}
