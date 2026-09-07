package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgtg extends zzgxv implements zzgzh {
    private static final zzgtg zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private zzgyh zzd = zzbK();

    static {
        zzgtg zzgtgVar = new zzgtg();
        zza = zzgtgVar;
        zzgxv.zzbZ(zzgtg.class, zzgtgVar);
    }

    private zzgtg() {
    }

    public static zzgtc zza() {
        return (zzgtc) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzgtg zzgtgVar, zzgte zzgteVar) {
        zzgteVar.getClass();
        zzgyh zzgyhVar = zzgtgVar.zzd;
        if (!zzgyhVar.zzc()) {
            zzgtgVar.zzd = zzgxv.zzbL(zzgyhVar);
        }
        zzgtgVar.zzd.add(zzgteVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzc", "zzd", zzgte.class});
        }
        if (iOrdinal == 3) {
            return new zzgtg();
        }
        zzgtf zzgtfVar = null;
        if (iOrdinal == 4) {
            return new zzgtc(zzgtfVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgtg.class) {
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
