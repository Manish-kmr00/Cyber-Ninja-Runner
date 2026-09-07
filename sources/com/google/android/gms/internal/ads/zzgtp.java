package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgtp extends zzgxv implements zzgzh {
    private static final zzgtp zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private zzgts zze;

    static {
        zzgtp zzgtpVar = new zzgtp();
        zza = zzgtpVar;
        zzgxv.zzbZ(zzgtp.class, zzgtpVar);
    }

    private zzgtp() {
    }

    public static zzgtn zzb() {
        return (zzgtn) zza.zzaZ();
    }

    public static zzgtp zzd(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzgtp) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    public static zzgzo zzg() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzh(zzgtp zzgtpVar, zzgts zzgtsVar) {
        zzgtsVar.getClass();
        zzgtpVar.zze = zzgtsVar;
        zzgtpVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgtp();
        }
        zzgto zzgtoVar = null;
        if (iOrdinal == 4) {
            return new zzgtn(zzgtoVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgtp.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzgts zzf() {
        zzgts zzgtsVar = this.zze;
        return zzgtsVar == null ? zzgts.zzd() : zzgtsVar;
    }
}
