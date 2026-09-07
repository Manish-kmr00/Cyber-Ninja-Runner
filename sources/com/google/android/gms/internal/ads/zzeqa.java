package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeqa implements zzesu {
    private final Integer zza;

    public zzeqa(Integer num) {
        this.zza = num;
    }

    @Override // com.google.android.gms.internal.ads.zzesu
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzesu
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Integer num = this.zza;
        zzcue zzcueVar = (zzcue) obj;
        if (num != null) {
            zzcueVar.zza.putInt("dspct", Math.min(num.intValue(), 20));
        }
    }
}
