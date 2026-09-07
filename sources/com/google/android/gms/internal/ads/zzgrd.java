package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgrd extends zzgxv implements zzgzh {
    private static final zzgrd zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private zzgrj zze;
    private zzgwn zzf = zzgwn.zzb;

    static {
        zzgrd zzgrdVar = new zzgrd();
        zza = zzgrdVar;
        zzgxv.zzbZ(zzgrd.class, zzgrdVar);
    }

    private zzgrd() {
    }

    public static zzgrb zzb() {
        return (zzgrb) zza.zzaZ();
    }

    public static zzgrd zzd(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzgrd) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    public static zzgzo zzh() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzj(zzgrd zzgrdVar, zzgrj zzgrjVar) {
        zzgrjVar.getClass();
        zzgrdVar.zze = zzgrjVar;
        zzgrdVar.zzc |= 1;
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
            return new zzgrd();
        }
        zzgrc zzgrcVar = null;
        if (iOrdinal == 4) {
            return new zzgrb(zzgrcVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgrd.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzgrj zzf() {
        zzgrj zzgrjVar = this.zze;
        return zzgrjVar == null ? zzgrj.zzd() : zzgrjVar;
    }

    public final zzgwn zzg() {
        return this.zzf;
    }
}
