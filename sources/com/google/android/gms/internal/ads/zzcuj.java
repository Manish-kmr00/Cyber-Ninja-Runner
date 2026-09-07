package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcuj {
    private Context zza;
    private zzfbp zzb;
    private Bundle zzc;
    private zzfbh zzd;
    private zzcuc zze;
    private zzeck zzf;
    private int zzg = 0;

    public final zzcuj zze(zzeck zzeckVar) {
        this.zzf = zzeckVar;
        return this;
    }

    public final zzcuj zzf(Context context) {
        this.zza = context;
        return this;
    }

    public final zzcuj zzg(Bundle bundle) {
        this.zzc = bundle;
        return this;
    }

    public final zzcuj zzh(zzcuc zzcucVar) {
        this.zze = zzcucVar;
        return this;
    }

    public final zzcuj zzi(int i) {
        this.zzg = i;
        return this;
    }

    public final zzcuj zzj(zzfbh zzfbhVar) {
        this.zzd = zzfbhVar;
        return this;
    }

    public final zzcuj zzk(zzfbp zzfbpVar) {
        this.zzb = zzfbpVar;
        return this;
    }

    public final zzcul zzl() {
        return new zzcul(this, null);
    }
}
