package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgts extends zzgxv implements zzgzh {
    private static final zzgts zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private String zzd = "";
    private zzgst zze;

    static {
        zzgts zzgtsVar = new zzgts();
        zza = zzgtsVar;
        zzgxv.zzbZ(zzgts.class, zzgtsVar);
    }

    private zzgts() {
    }

    public static zzgtq zzb() {
        return (zzgtq) zza.zzaZ();
    }

    public static zzgts zzd() {
        return zza;
    }

    public static zzgts zzf(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzgts) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    static /* synthetic */ void zzh(zzgts zzgtsVar, zzgst zzgstVar) {
        zzgstVar.getClass();
        zzgtsVar.zze = zzgstVar;
        zzgtsVar.zzc |= 1;
    }

    static /* synthetic */ void zzi(zzgts zzgtsVar, String str) {
        str.getClass();
        zzgtsVar.zzd = str;
    }

    public final zzgst zza() {
        zzgst zzgstVar = this.zze;
        return zzgstVar == null ? zzgst.zzd() : zzgstVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgts();
        }
        zzgtr zzgtrVar = null;
        if (iOrdinal == 4) {
            return new zzgtq(zzgtrVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgts.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final String zzg() {
        return this.zzd;
    }
}
