package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzbxp {
    private Context zza;
    private Clock zzb;
    private com.google.android.gms.ads.internal.util.zzg zzc;
    private zzbxw zzd;

    private zzbxp() {
        throw null;
    }

    /* synthetic */ zzbxp(zzbxr zzbxrVar) {
    }

    public final zzbxp zza(com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzc = zzgVar;
        return this;
    }

    public final zzbxp zzd(zzbxw zzbxwVar) {
        this.zzd = zzbxwVar;
        return this;
    }

    public final zzbxx zze() {
        zzhfg.zzc(this.zza, Context.class);
        zzhfg.zzc(this.zzb, Clock.class);
        zzhfg.zzc(this.zzc, com.google.android.gms.ads.internal.util.zzg.class);
        zzhfg.zzc(this.zzd, zzbxw.class);
        return new zzbxq(this.zza, this.zzb, this.zzc, this.zzd);
    }

    public final zzbxp zzb(Context context) {
        context.getClass();
        this.zza = context;
        return this;
    }

    public final zzbxp zzc(Clock clock) {
        clock.getClass();
        this.zzb = clock;
        return this;
    }
}
