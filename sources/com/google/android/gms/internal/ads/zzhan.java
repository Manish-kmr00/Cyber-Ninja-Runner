package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzhan extends zzhal {
    zzhan() {
    }

    @Override // com.google.android.gms.internal.ads.zzhal
    final /* bridge */ /* synthetic */ Object zza(Object obj) {
        zzgxv zzgxvVar = (zzgxv) obj;
        zzham zzhamVar = zzgxvVar.zzt;
        if (zzhamVar != zzham.zzc()) {
            return zzhamVar;
        }
        zzham zzhamVarZzf = zzham.zzf();
        zzgxvVar.zzt = zzhamVarZzf;
        return zzhamVarZzf;
    }

    @Override // com.google.android.gms.internal.ads.zzhal
    final /* synthetic */ Object zzb() {
        return zzham.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzhal
    final /* synthetic */ Object zzc(Object obj) {
        zzham zzhamVar = (zzham) obj;
        zzhamVar.zzh();
        return zzhamVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhal
    final /* bridge */ /* synthetic */ void zzd(Object obj, int i, int i2) {
        ((zzham) obj).zzj((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzhal
    final /* bridge */ /* synthetic */ void zze(Object obj, int i, long j) {
        ((zzham) obj).zzj((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzhal
    final /* bridge */ /* synthetic */ void zzf(Object obj, int i, Object obj2) {
        ((zzham) obj).zzj((i << 3) | 3, (zzham) obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzhal
    final /* bridge */ /* synthetic */ void zzg(Object obj, int i, zzgwn zzgwnVar) {
        ((zzham) obj).zzj((i << 3) | 2, zzgwnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhal
    final /* bridge */ /* synthetic */ void zzh(Object obj, int i, long j) {
        ((zzham) obj).zzj(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzhal
    final void zzi(Object obj) {
        ((zzgxv) obj).zzt.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzhal
    final /* synthetic */ void zzj(Object obj, Object obj2) {
        ((zzgxv) obj).zzt = (zzham) obj2;
    }
}
