package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcsr implements zzcya, zzddo {
    private zzbus zza;
    private final Context zzc;
    private final zzfgq zzd;
    private final VersionInfoParcel zze;
    private final Executor zzf;
    private boolean zzg = false;
    private boolean zzh = false;
    private final AtomicBoolean zzb = new AtomicBoolean();

    zzcsr(Context context, zzfgq zzfgqVar, VersionInfoParcel versionInfoParcel, Executor executor) {
        this.zzc = context;
        this.zzd = zzfgqVar;
        this.zze = versionInfoParcel;
        this.zzf = executor;
    }

    public static /* synthetic */ void zzc(zzcsr zzcsrVar) {
        zzbbs.zze(zzcsrVar.zzc);
        zzcsrVar.zzh = true;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003a  */
    public final void zzd() {
        zzbus zzbusVar;
        int i;
        zzboa zzboaVarZza;
        if (!this.zzb.getAndSet(true)) {
            if (((Boolean) zzbei.zzj.zze()).booleanValue()) {
                i = 2;
            } else {
                i = 3;
                if (!((Boolean) zzbei.zzk.zze()).booleanValue()) {
                    if (((Boolean) zzbei.zzi.zze()).booleanValue()) {
                        try {
                            String strOptString = new JSONObject(com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zzc()).optString("local_flag_write");
                            if (TextUtils.equals(strOptString, "client")) {
                                i = 2;
                            } else if (!TextUtils.equals(strOptString, NotificationCompat.CATEGORY_SERVICE)) {
                                i = 1;
                            }
                        } catch (JSONException unused) {
                        }
                    } else {
                        i = 1;
                    }
                }
            }
            int i2 = i - 1;
            if (i2 == 1) {
                zzboaVarZza = com.google.android.gms.ads.internal.zzv.zzg().zza(this.zzc, VersionInfoParcel.forPackage(), this.zzd);
            } else if (i2 == 2) {
                zzboaVarZza = com.google.android.gms.ads.internal.zzv.zzg().zzb(this.zzc, VersionInfoParcel.forPackage(), this.zzd);
            }
            this.zza = new zzbuu(this.zzc, zzboaVarZza.zza("google.afma.sdkConstants.getSdkConstants", zzbnx.zza, zzbnx.zza), this.zze);
            this.zzg = true;
        }
        if (this.zzg && (zzbusVar = this.zza) != null) {
            ListenableFuture listenableFutureZza = zzbusVar.zza();
            if (!this.zzh && ((Boolean) zzbea.zzi.zze()).booleanValue()) {
                listenableFutureZza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsq
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcsr.zzc(this.zza);
                    }
                }, this.zzf);
            }
            zzbzn.zza(listenableFutureZza, "persistFlagsClient");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdl(zzbuy zzbuyVar) {
        zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdm(zzfbg zzfbgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzddo
    public final void zze(com.google.android.gms.ads.nonagon.signalgeneration.zzbk zzbkVar) {
        zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzddo
    public final void zzf(String str) {
        zzd();
    }
}
