package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfnc {
    private final Context zza;
    private final Looper zzb;

    public zzfnc(Context context, Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(String str) {
        zzfnn zzfnnVarZza = zzfnq.zza();
        Context context = this.zza;
        zzfnnVarZza.zza(context.getPackageName());
        zzfnnVarZza.zzc(2);
        zzfnk zzfnkVarZza = zzfnm.zza();
        zzfnkVarZza.zza(str);
        zzfnkVarZza.zzb(2);
        zzfnnVarZza.zzb(zzfnkVarZza);
        new zzfnd(context, this.zzb, (zzfnq) zzfnnVarZza.zzbr()).zza();
    }
}
