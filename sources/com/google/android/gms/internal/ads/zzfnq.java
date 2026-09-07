package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfnq extends zzgxv implements zzgzh {
    private static final zzfnq zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private zzfnm zzg;

    static {
        zzfnq zzfnqVar = new zzfnq();
        zza = zzfnqVar;
        zzgxv.zzbZ(zzfnq.class, zzfnqVar);
    }

    private zzfnq() {
    }

    public static zzfnn zza() {
        return (zzfnn) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzfnq zzfnqVar, String str) {
        str.getClass();
        zzfnqVar.zzc |= 2;
        zzfnqVar.zze = str;
    }

    static /* synthetic */ void zzd(zzfnq zzfnqVar, zzfnm zzfnmVar) {
        zzfnmVar.getClass();
        zzfnqVar.zzg = zzfnmVar;
        zzfnqVar.zzc |= 8;
    }

    static /* synthetic */ void zzf(zzfnq zzfnqVar, int i) {
        zzfnqVar.zzd = 1;
        zzfnqVar.zzc = 1 | zzfnqVar.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", zzfno.zza, "zze", "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzfnq();
        }
        zzfnp zzfnpVar = null;
        if (iOrdinal == 4) {
            return new zzfnn(zzfnpVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzfnq.class) {
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
