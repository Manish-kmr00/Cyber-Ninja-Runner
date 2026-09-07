package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhfj {
    private final List zza;
    private final List zzb;

    /* synthetic */ zzhfj(int i, int i2, zzhfi zzhfiVar) {
        this.zza = zzhev.zzc(i);
        this.zzb = zzhev.zzc(i2);
    }

    public final zzhfj zza(zzhfh zzhfhVar) {
        this.zzb.add(zzhfhVar);
        return this;
    }

    public final zzhfj zzb(zzhfh zzhfhVar) {
        this.zza.add(zzhfhVar);
        return this;
    }

    public final zzhfk zzc() {
        return new zzhfk(this.zza, this.zzb, null);
    }
}
