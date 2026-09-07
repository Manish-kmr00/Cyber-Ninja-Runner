package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzate extends zzgxv implements zzgzh {
    private static final zzate zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private long zzf;
    private long zzh;
    private long zzi;
    private String zzd = "";
    private String zze = "";
    private String zzg = "D";

    static {
        zzate zzateVar = new zzate();
        zza = zzateVar;
        zzgxv.zzbZ(zzate.class, zzateVar);
    }

    private zzate() {
    }

    public static zzatd zza() {
        return (zzatd) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzate zzateVar, String str) {
        zzateVar.zzc |= 1;
        zzateVar.zzd = "0.460000000";
    }

    static /* synthetic */ void zzd(zzate zzateVar, String str) {
        str.getClass();
        zzateVar.zzc |= 2;
        zzateVar.zze = str;
    }

    static /* synthetic */ void zzf(zzate zzateVar, String str) {
        str.getClass();
        zzateVar.zzc |= 8;
        zzateVar.zzg = str;
    }

    static /* synthetic */ void zzg(zzate zzateVar, long j) {
        zzateVar.zzc |= 4;
        zzateVar.zzf = j;
    }

    static /* synthetic */ void zzh(zzate zzateVar, long j) {
        zzateVar.zzc |= 32;
        zzateVar.zzi = j;
    }

    static /* synthetic */ void zzi(zzate zzateVar, long j) {
        zzateVar.zzc |= 16;
        zzateVar.zzh = j;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဈ\u0003\u0005ဂ\u0004\u0006ဂ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzate();
        }
        zzatm zzatmVar = null;
        if (iOrdinal == 4) {
            return new zzatd(zzatmVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzate.class) {
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
