package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzasy extends zzgxv implements zzgzh {
    private static final zzasy zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private zzgwn zzd = zzgwn.zzb;
    private zzgwn zze;
    private zzgwn zzf;
    private zzgwn zzg;

    static {
        zzasy zzasyVar = new zzasy();
        zza = zzasyVar;
        zzgxv.zzbZ(zzasy.class, zzasyVar);
    }

    private zzasy() {
        zzgwn zzgwnVar = zzgwn.zzb;
        this.zze = zzgwnVar;
        this.zzf = zzgwnVar;
        this.zzg = zzgwnVar;
    }

    public static zzasx zza() {
        return (zzasx) zza.zzaZ();
    }

    public static zzasy zzc(byte[] bArr, zzgxf zzgxfVar) throws zzgyk {
        return (zzasy) zzgxv.zzbx(zza, bArr, zzgxfVar);
    }

    static /* synthetic */ void zzi(zzasy zzasyVar, zzgwn zzgwnVar) {
        zzasyVar.zzc |= 1;
        zzasyVar.zzd = zzgwnVar;
    }

    static /* synthetic */ void zzj(zzasy zzasyVar, zzgwn zzgwnVar) {
        zzasyVar.zzc |= 2;
        zzasyVar.zze = zzgwnVar;
    }

    static /* synthetic */ void zzk(zzasy zzasyVar, zzgwn zzgwnVar) {
        zzasyVar.zzc |= 8;
        zzasyVar.zzg = zzgwnVar;
    }

    static /* synthetic */ void zzl(zzasy zzasyVar, zzgwn zzgwnVar) {
        zzasyVar.zzc |= 4;
        zzasyVar.zzf = zzgwnVar;
    }

    public final zzgwn zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzasy();
        }
        zzatm zzatmVar = null;
        if (iOrdinal == 4) {
            return new zzasx(zzatmVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzasy.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzgwn zzf() {
        return this.zze;
    }

    public final zzgwn zzg() {
        return this.zzg;
    }

    public final zzgwn zzh() {
        return this.zzf;
    }
}
