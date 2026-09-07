package com.google.android.gms.internal.ads;

import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzdf {
    private final zzdq zza;
    private final zzdq zzb;
    private Object zzc;
    private final zzjf zzd;

    public zzdf(Object obj, Looper looper, Looper looper2, zzdg zzdgVar, zzjf zzjfVar) {
        this.zza = zzdgVar.zzd(looper, null);
        this.zzb = zzdgVar.zzd(looper2, null);
        this.zzc = obj;
        this.zzd = zzjfVar;
    }

    public static /* synthetic */ void zza(zzdf zzdfVar, Object obj) {
        Object obj2 = zzdfVar.zzc;
        zzdfVar.zzc = obj;
        if (obj2.equals(obj)) {
            return;
        }
        zzdfVar.zzd.zza(obj2, obj);
    }

    public final void zzb(Runnable runnable) {
        this.zza.zzi(runnable);
    }

    public final void zzc(final Object obj) {
        this.zzb.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzde
            @Override // java.lang.Runnable
            public final void run() {
                zzdf.zza(this.zza, obj);
            }
        });
    }
}
