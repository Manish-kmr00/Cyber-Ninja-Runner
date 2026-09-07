package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzblg implements zzapc {
    private volatile zzbkt zza;
    private final Context zzb;

    public zzblg(Context context) {
        this.zzb = context;
    }

    static /* bridge */ /* synthetic */ void zzc(zzblg zzblgVar) {
        if (zzblgVar.zza == null) {
            return;
        }
        zzblgVar.zza.disconnect();
        Binder.flushPendingCommands();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzapc
    public final zzapf zza(zzapj zzapjVar) throws zzaps {
        Parcelable.Creator<zzbku> creator = zzbku.CREATOR;
        Map mapZzl = zzapjVar.zzl();
        int size = mapZzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry entry : mapZzl.entrySet()) {
            strArr[i] = (String) entry.getKey();
            strArr2[i] = (String) entry.getValue();
            i++;
        }
        zzbku zzbkuVar = new zzbku(zzapjVar.zzk(), strArr, strArr2);
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime();
        try {
            zzbzp zzbzpVar = new zzbzp();
            this.zza = new zzbkt(this.zzb, com.google.android.gms.ads.internal.zzv.zzu().zzb(), new zzble(this, zzbzpVar), new zzblf(this, zzbzpVar));
            this.zza.checkAvailabilityAndConnect();
            ListenableFuture listenableFutureZzo = zzgbs.zzo(zzgbs.zzn(zzbzpVar, new zzblc(this, zzbkuVar), zzbzk.zza), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeF)).intValue(), TimeUnit.MILLISECONDS, zzbzk.zzd);
            listenableFutureZzo.addListener(new zzbld(this), zzbzk.zza);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) listenableFutureZzo.get();
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime) + "ms");
            zzbkw zzbkwVar = (zzbkw) new zzbuw(parcelFileDescriptor).zza(zzbkw.CREATOR);
            if (zzbkwVar == null) {
                return null;
            }
            if (zzbkwVar.zza) {
                throw new zzaps(zzbkwVar.zzb);
            }
            String[] strArr3 = zzbkwVar.zze;
            String[] strArr4 = zzbkwVar.zzf;
            if (strArr3.length != strArr4.length) {
                return null;
            }
            HashMap map = new HashMap();
            for (int i2 = 0; i2 < strArr3.length; i2++) {
                map.put(strArr3[i2], strArr4[i2]);
            }
            return new zzapf(zzbkwVar.zzc, zzbkwVar.zzd, map, zzbkwVar.zzg, zzbkwVar.zzh);
        } catch (InterruptedException | ExecutionException unused) {
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime) + "ms");
            return null;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime) + "ms");
            throw th;
        }
    }
}
