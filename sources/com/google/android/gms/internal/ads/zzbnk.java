package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbnk implements zzbzt {
    final /* synthetic */ zzbnl zza;

    zzbnk(zzbnl zzbnlVar) {
        this.zza = zzbnlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzt
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        final zzbmh zzbmhVar = (zzbmh) obj;
        zzbzk.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbnj
            @Override // java.lang.Runnable
            public final void run() {
                zzbmh zzbmhVar2 = zzbmhVar;
                zzbmhVar2.zzr("/result", zzbji.zzo);
                zzbmhVar2.zzc();
            }
        });
    }
}
