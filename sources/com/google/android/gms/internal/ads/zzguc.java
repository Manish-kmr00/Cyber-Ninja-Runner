package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzguc extends zzgxv implements zzgzh {
    private static final zzguc zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private zzguf zze;

    static {
        zzguc zzgucVar = new zzguc();
        zza = zzgucVar;
        zzgxv.zzbZ(zzguc.class, zzgucVar);
    }

    private zzguc() {
    }

    public static zzgua zzb() {
        return (zzgua) zza.zzaZ();
    }

    public static zzguc zzd(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzguc) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    static /* synthetic */ void zzg(zzguc zzgucVar, zzguf zzgufVar) {
        zzgufVar.getClass();
        zzgucVar.zze = zzgufVar;
        zzgucVar.zzc |= 1;
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
            return zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzguc();
        }
        zzgub zzgubVar = null;
        if (iOrdinal == 4) {
            return new zzgua(zzgubVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzguc.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzguf zzf() {
        zzguf zzgufVar = this.zze;
        return zzgufVar == null ? zzguf.zzd() : zzgufVar;
    }
}
