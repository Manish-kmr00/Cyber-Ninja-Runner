package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgxo implements zzgze {
    private static final zzgxo zza = new zzgxo();

    private zzgxo() {
    }

    public static zzgxo zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgze
    public final zzgzd zzb(Class cls) {
        if (!zzgxv.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            return (zzgzd) zzgxv.zzbh(cls.asSubclass(zzgxv.class)).zzbO();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgze
    public final boolean zzc(Class cls) {
        return zzgxv.class.isAssignableFrom(cls);
    }
}
