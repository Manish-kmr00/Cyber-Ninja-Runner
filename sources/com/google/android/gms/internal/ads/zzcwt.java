package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcwt implements zzhey {
    private final zzhfh zza;

    public zzcwt(zzhfh zzhfhVar) {
        this.zza = zzhfhVar;
    }

    public static zzcws zzc(Set set) {
        return new zzcws(set);
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcws zzb() {
        return new zzcws(((zzhfk) this.zza).zzb());
    }
}
