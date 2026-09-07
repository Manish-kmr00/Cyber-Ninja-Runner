package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzboj {
    private final zzbnm zza;
    private ListenableFuture zzb;

    zzboj(zzbnm zzbnmVar) {
        this.zza = zzbnmVar;
    }

    private final void zzd() {
        if (this.zzb == null) {
            final zzbzp zzbzpVar = new zzbzp();
            this.zzb = zzbzpVar;
            this.zza.zzb(null).zzj(new zzbzt() { // from class: com.google.android.gms.internal.ads.zzbog
                @Override // com.google.android.gms.internal.ads.zzbzt
                public final void zza(Object obj) {
                    zzbzpVar.zzc((zzbnn) obj);
                }
            }, new zzbzr() { // from class: com.google.android.gms.internal.ads.zzboh
                @Override // com.google.android.gms.internal.ads.zzbzr
                public final void zza() {
                    zzbzpVar.zzd(new zzbnp("Cannot get Javascript Engine"));
                }
            });
        }
    }

    public final zzbom zza(String str, zzbnt zzbntVar, zzbns zzbnsVar) {
        zzd();
        return new zzbom(this.zzb, "google.afma.activeView.handleUpdate", zzbntVar, zzbnsVar);
    }

    public final void zzb(final String str, final zzbjj zzbjjVar) {
        zzd();
        this.zzb = zzgbs.zzn(this.zzb, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzboi
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                zzbnn zzbnnVar = (zzbnn) obj;
                zzbnnVar.zzq(str, zzbjjVar);
                return zzgbs.zzh(zzbnnVar);
            }
        }, zzbzk.zzg);
    }

    public final void zzc(final String str, final zzbjj zzbjjVar) {
        this.zzb = zzgbs.zzm(this.zzb, new zzftl() { // from class: com.google.android.gms.internal.ads.zzbof
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                zzbnn zzbnnVar = (zzbnn) obj;
                zzbnnVar.zzr(str, zzbjjVar);
                return zzbnnVar;
            }
        }, zzbzk.zzg);
    }
}
