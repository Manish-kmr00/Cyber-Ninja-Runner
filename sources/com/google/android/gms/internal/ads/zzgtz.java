package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgtz extends zzgxv implements zzgzh {
    private static final zzgtz zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private zzguf zze;
    private zzgwn zzf = zzgwn.zzb;

    static {
        zzgtz zzgtzVar = new zzgtz();
        zza = zzgtzVar;
        zzgxv.zzbZ(zzgtz.class, zzgtzVar);
    }

    private zzgtz() {
    }

    public static zzgtx zzb() {
        return (zzgtx) zza.zzaZ();
    }

    public static zzgtz zzd(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzgtz) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    static /* synthetic */ void zzi(zzgtz zzgtzVar, zzguf zzgufVar) {
        zzgufVar.getClass();
        zzgtzVar.zze = zzgufVar;
        zzgtzVar.zzc |= 1;
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
            return zzbQ(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzgtz();
        }
        zzgty zzgtyVar = null;
        if (iOrdinal == 4) {
            return new zzgtx(zzgtyVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgtz.class) {
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

    public final zzgwn zzg() {
        return this.zzf;
    }
}
