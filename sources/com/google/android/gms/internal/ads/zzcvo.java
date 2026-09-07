package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcvo extends zzdat implements zzcvg {
    public zzcvo(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zza(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzcvn
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzcvs) obj).zzr(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzb() {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzcvm
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzcvs) obj).zzr(zzfcq.zzd(11, null, null));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzc(final zzdfl zzdflVar) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzcvl
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                zzcvs zzcvsVar = (zzcvs) obj;
                String message = zzdflVar.getMessage();
                if (message == null) {
                    message = "Internal show error.";
                }
                zzcvsVar.zzr(zzfcq.zzd(12, message, null));
            }
        });
    }
}
