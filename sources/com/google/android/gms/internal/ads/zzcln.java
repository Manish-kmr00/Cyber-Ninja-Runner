package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcln implements zzcvx {
    private final zzfcn zza;

    public zzcln(zzfcn zzfcnVar) {
        this.zza = zzfcnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcvx
    public final void zzdh(Context context) {
        try {
            this.zza.zzg();
        } catch (zzfbw e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvx
    public final void zzdj(Context context) {
        try {
            this.zza.zzt();
        } catch (zzfbw e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Cannot invoke onPause for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvx
    public final void zzdk(Context context) {
        try {
            zzfcn zzfcnVar = this.zza;
            zzfcnVar.zzu();
            if (context != null) {
                zzfcnVar.zzs(context);
            }
        } catch (zzfbw e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Cannot invoke onResume for the mediation adapter.", e);
        }
    }
}
