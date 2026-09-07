package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzyo {
    public final zzbm zza;
    public final int[] zzb;

    public zzyo(zzbm zzbmVar, int[] iArr, int i) {
        if (iArr.length == 0) {
            zzdx.zzd("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.zza = zzbmVar;
        this.zzb = iArr;
    }
}
