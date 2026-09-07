package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzffs extends zzdat implements zzffm {
    zzffs(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzffm
    public final void zza(final zzfez zzfezVar) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzffq
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                zzfez zzfezVar2 = zzfezVar;
                ((zzffu) obj).zzdA((zzffn) zzfezVar2.zza(), zzfezVar2.zzb());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzffm
    public final void zzb(final zzfez zzfezVar, final Throwable th) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzffo
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                zzfez zzfezVar2 = zzfezVar;
                ((zzffu) obj).zzdB((zzffn) zzfezVar2.zza(), zzfezVar2.zzb(), th);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzffm
    public final void zzc(final zzfez zzfezVar) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzffr
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                zzfez zzfezVar2 = zzfezVar;
                ((zzffu) obj).zzdC((zzffn) zzfezVar2.zza(), zzfezVar2.zzb());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzffm
    public final void zzd(final zzfez zzfezVar) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzffp
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                zzfez zzfezVar2 = zzfezVar;
                ((zzffu) obj).zzd((zzffn) zzfezVar2.zza(), zzfezVar2.zzb());
            }
        });
    }
}
