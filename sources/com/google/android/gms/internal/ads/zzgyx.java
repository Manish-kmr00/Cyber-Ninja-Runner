package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgyx implements zzgze {
    private final zzgze[] zza;

    zzgyx(zzgze... zzgzeVarArr) {
        this.zza = zzgzeVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgze
    public final zzgzd zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzgze zzgzeVar = this.zza[i];
            if (zzgzeVar.zzc(cls)) {
                return zzgzeVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.gms.internal.ads.zzgze
    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
