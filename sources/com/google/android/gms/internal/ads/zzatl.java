package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzatl extends zzgxv implements zzgzh {
    private static final zzatl zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private zzgyh zzd = zzbK();
    private zzgwn zze = zzgwn.zzb;
    private int zzf = 1;
    private int zzg = 1;

    static {
        zzatl zzatlVar = new zzatl();
        zza = zzatlVar;
        zzgxv.zzbZ(zzatl.class, zzatlVar);
    }

    private zzatl() {
    }

    public static zzatk zza() {
        return (zzatk) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzatl zzatlVar, zzgwn zzgwnVar) {
        zzgyh zzgyhVar = zzatlVar.zzd;
        if (!zzgyhVar.zzc()) {
            zzatlVar.zzd = zzgxv.zzbL(zzgyhVar);
        }
        zzatlVar.zzd.add(zzgwnVar);
    }

    static /* synthetic */ void zzd(zzatl zzatlVar, zzgwn zzgwnVar) {
        zzatlVar.zzc |= 1;
        zzatlVar.zze = zzgwnVar;
    }

    static /* synthetic */ void zzf(zzatl zzatlVar, int i) {
        zzatlVar.zzg = i - 1;
        zzatlVar.zzc |= 4;
    }

    static /* synthetic */ void zzg(zzatl zzatlVar, int i) {
        zzatlVar.zzf = 4;
        zzatlVar.zzc |= 2;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zzatf.zza, "zzg", zzatb.zza});
        }
        if (iOrdinal == 3) {
            return new zzatl();
        }
        zzatm zzatmVar = null;
        if (iOrdinal == 4) {
            return new zzatk(zzatmVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzatl.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }
}
