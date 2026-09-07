package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcve extends zzdat implements zzcvf {
    public zzcve(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzcvf
    public final void zzdz(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzcvd
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzcvf) obj).zzdz(zzeVar);
            }
        });
    }
}
