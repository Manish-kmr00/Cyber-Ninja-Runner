package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzqt {
    private final Context zza;
    private final zzpb zzb;
    private boolean zzc;
    private final zzqr zzd;
    private final zzqs zze;
    private zzqv zzf;
    private zzql zzg;

    @Deprecated
    public zzqt() {
        this.zza = null;
        this.zzb = zzpb.zza;
        this.zzd = zzqr.zza;
        this.zze = zzqs.zza;
    }

    public final zzrf zzc() {
        zzdc.zzf(!this.zzc);
        this.zzc = true;
        if (this.zzf == null) {
            this.zzf = new zzqv(new zzcn[0]);
        }
        if (this.zzg == null) {
            this.zzg = new zzql(this.zza);
        }
        return new zzrf(this, null);
    }

    public zzqt(Context context) {
        this.zza = context;
        this.zzb = zzpb.zza;
        this.zzd = zzqr.zza;
        this.zze = zzqs.zza;
    }
}
