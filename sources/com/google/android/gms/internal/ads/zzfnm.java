package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfnm extends zzgxv implements zzgzh {
    private static final zzfnm zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private zzgyd zzd = zzbG();
    private String zze = "";
    private String zzf = "";
    private String zzg = "";

    static {
        zzfnm zzfnmVar = new zzfnm();
        zza = zzfnmVar;
        zzgxv.zzbZ(zzfnm.class, zzfnmVar);
    }

    private zzfnm() {
    }

    public static zzfnk zza() {
        return (zzfnk) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzfnm zzfnmVar, String str) {
        str.getClass();
        zzfnmVar.zzc |= 1;
        zzfnmVar.zze = str;
    }

    static /* synthetic */ void zzd(zzfnm zzfnmVar, int i) {
        zzgyd zzgydVar = zzfnmVar.zzd;
        if (!zzgydVar.zzc()) {
            zzfnmVar.zzd = zzgxv.zzbH(zzgydVar);
        }
        zzfnmVar.zzd.zzi(2);
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ࠞ\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzc", "zzd", zzfnj.zza, "zze", "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzfnm();
        }
        zzfnl zzfnlVar = null;
        if (iOrdinal == 4) {
            return new zzfnk(zzfnlVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzfnm.class) {
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
