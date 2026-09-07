package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzast extends zzgxv implements zzgzh {
    private static final zzast zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;

    static {
        zzast zzastVar = new zzast();
        zza = zzastVar;
        zzgxv.zzbZ(zzast.class, zzastVar);
    }

    private zzast() {
    }

    public static zzass zza() {
        return (zzass) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzast zzastVar, long j) {
        zzastVar.zzc |= 32;
        zzastVar.zzi = j;
    }

    static /* synthetic */ void zzd(zzast zzastVar, long j) {
        zzastVar.zzc |= 4;
        zzastVar.zzf = j;
    }

    static /* synthetic */ void zzf(zzast zzastVar, long j) {
        zzastVar.zzc |= 1;
        zzastVar.zzd = j;
    }

    static /* synthetic */ void zzg(zzast zzastVar, long j) {
        zzastVar.zzc |= 8;
        zzastVar.zzg = j;
    }

    static /* synthetic */ void zzh(zzast zzastVar, long j) {
        zzastVar.zzc |= 16;
        zzastVar.zzh = j;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (iOrdinal == 3) {
            return new zzast();
        }
        zzatm zzatmVar = null;
        if (iOrdinal == 4) {
            return new zzass(zzatmVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzast.class) {
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
