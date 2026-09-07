package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcwb extends zzdat {
    public zzcwb(Set set) {
        super(set);
    }

    public final void zza(final Context context) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzcwa
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzcvx) obj).zzdh(context);
            }
        });
    }

    public final void zzb(final Context context) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzcvy
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzcvx) obj).zzdj(context);
            }
        });
    }

    public final void zzc(final Context context) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzcvz
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzcvx) obj).zzdk(context);
            }
        });
    }
}
