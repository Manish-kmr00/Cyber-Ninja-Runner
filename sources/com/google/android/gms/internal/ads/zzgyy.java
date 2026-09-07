package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgyy implements zzhaa {
    private static final zzgze zza = new zzgyw();
    private final zzgze zzb;

    public zzgyy() {
        zzgze zzgzeVar = zza;
        int i = zzgzq.zza;
        zzgyx zzgyxVar = new zzgyx(zzgxo.zza(), zzgzeVar);
        byte[] bArr = zzgyi.zzb;
        this.zzb = zzgyxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhaa
    public final zzgzz zza(Class cls) {
        int i = zzhab.zza;
        if (!zzgxv.class.isAssignableFrom(cls)) {
            int i2 = zzgzq.zza;
        }
        zzgzd zzgzdVarZzb = this.zzb.zzb(cls);
        if (zzgzdVarZzb.zzb()) {
            int i3 = zzgzq.zza;
            return zzgzk.zzc(zzhab.zzm(), zzgxi.zza(), zzgzdVarZzb.zza());
        }
        int i4 = zzgzq.zza;
        return zzgzj.zzm(cls, zzgzdVarZzb, zzgzn.zza(), zzgyu.zza(), zzhab.zzm(), zzgzdVarZzb.zzc() + (-1) != 1 ? zzgxi.zza() : null, zzgzc.zza());
    }
}
