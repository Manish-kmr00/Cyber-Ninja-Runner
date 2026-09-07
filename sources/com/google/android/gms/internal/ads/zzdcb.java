package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdcb extends zzdat implements zzdcd {
    public zzdcb(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzdcd
    public final void zza(String str) {
        final String str2 = "MalformedJson";
        zzq(new zzdas(str2) { // from class: com.google.android.gms.internal.ads.zzdbv
            public final /* synthetic */ String zza = "MalformedJson";

            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzdcd) obj).zza(this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcd
    public final void zzb(final String str, final String str2) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzdby
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzdcd) obj).zzb(str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcd
    public final void zzc(final String str) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzdbx
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzdcd) obj).zzc(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcd
    public final void zzd(final String str) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzdbz
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzdcd) obj).zzd(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcd
    public final void zze() {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzdca
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzdcd) obj).zze();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcd
    public final void zzf() {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzdbw
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzdcd) obj).zzf();
            }
        });
    }
}
