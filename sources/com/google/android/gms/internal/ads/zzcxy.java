package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcxy extends zzdat implements zzcya {
    public zzcxy(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdl(final zzbuy zzbuyVar) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzcxx
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzcya) obj).zzdl(zzbuyVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdm(final zzfbg zzfbgVar) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzcxw
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzcya) obj).zzdm(zzfbgVar);
            }
        });
    }
}
