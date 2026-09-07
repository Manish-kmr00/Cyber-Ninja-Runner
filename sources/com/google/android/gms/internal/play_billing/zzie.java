package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes13.dex */
final class zzie implements zziy {
    private static final zzik zza = new zzic();
    private final zzik zzb;

    public zzie() {
        zzik zzikVar = zza;
        int i = zziu.zza;
        zzid zzidVar = new zzid(zzhf.zza(), zzikVar);
        byte[] bArr = zzhp.zzb;
        this.zzb = zzidVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zziy
    public final zzix zza(Class cls) {
        int i = zziz.zza;
        if (!zzhk.class.isAssignableFrom(cls)) {
            int i2 = zziu.zza;
        }
        zzij zzijVarZzb = this.zzb.zzb(cls);
        if (zzijVarZzb.zzb()) {
            int i3 = zziu.zza;
            return zziq.zzc(zziz.zzm(), zzgz.zza(), zzijVarZzb.zza());
        }
        int i4 = zziu.zza;
        return zzip.zzl(cls, zzijVarZzb, zzis.zza(), zzia.zza(), zziz.zzm(), zzijVarZzb.zzc() + (-1) != 1 ? zzgz.zza() : null, zzii.zza());
    }
}
