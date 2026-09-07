package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzary extends zzgxv implements zzgzh {
    public static final /* synthetic */ int zza = 0;
    private static final zzary zzb;
    private static volatile zzgzo zzc;
    private int zzd;
    private boolean zzf;
    private boolean zzg;
    private long zze = 100;
    private long zzh = 300;
    private long zzi = 1000;

    static {
        zzary zzaryVar = new zzary();
        zzb = zzaryVar;
        zzgxv.zzbZ(zzary.class, zzaryVar);
    }

    private zzary() {
    }

    public static zzary zzb() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005ဂ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzary();
        }
        zzarx zzarxVar = null;
        if (iOrdinal == 4) {
            return new zzarw(zzarxVar);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzc;
        if (zzgxqVar == null) {
            synchronized (zzary.class) {
                zzgxqVar = zzc;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zzb);
                    zzc = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }
}
