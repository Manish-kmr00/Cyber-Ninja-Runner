package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgsz extends zzgxv implements zzgzh {
    private static final zzgsz zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private zzgsp zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzgsz zzgszVar = new zzgsz();
        zza = zzgszVar;
        zzgxv.zzbZ(zzgsz.class, zzgszVar);
    }

    private zzgsz() {
    }

    public static zzgsy zzc() {
        return (zzgsy) zza.zzaZ();
    }

    static /* synthetic */ void zzg(zzgsz zzgszVar, zzgsp zzgspVar) {
        zzgspVar.getClass();
        zzgszVar.zzd = zzgspVar;
        zzgszVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzgsp zzb() {
        zzgsp zzgspVar = this.zzd;
        return zzgspVar == null ? zzgsp.zzd() : zzgspVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzgsz();
        }
        zzgta zzgtaVar = null;
        if (iOrdinal == 4) {
            return new zzgsy(zzgtaVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgsz.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzgtt zzf() {
        zzgtt zzgttVarZzb = zzgtt.zzb(this.zzg);
        return zzgttVarZzb == null ? zzgtt.UNRECOGNIZED : zzgttVarZzb;
    }

    public final boolean zzj() {
        return (this.zzc & 1) != 0;
    }

    public final int zzk() {
        int i = this.zze;
        int i2 = 2;
        if (i != 0) {
            if (i == 1) {
                i2 = 3;
            } else if (i != 2) {
                i2 = i != 3 ? 0 : 5;
            } else {
                i2 = 4;
            }
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
