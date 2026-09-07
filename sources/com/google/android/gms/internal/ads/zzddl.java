package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzddl extends zzdat implements zzbka {
    public zzddl(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbka
    public final void zza(final zzbvw zzbvwVar) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzddk
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzbka) obj).zza(zzbvwVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbka
    public final void zzb() {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzddj
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzbka) obj).zzb();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbka
    public final synchronized void zzc() {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzddi
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzbka) obj).zzc();
            }
        });
    }
}
