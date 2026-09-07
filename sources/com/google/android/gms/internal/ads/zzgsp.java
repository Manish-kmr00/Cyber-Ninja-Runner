package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgsp extends zzgxv implements zzgzh {
    private static final zzgsp zza;
    private static volatile zzgzo zzb;
    private String zzc = "";
    private zzgwn zzd = zzgwn.zzb;
    private int zze;

    static {
        zzgsp zzgspVar = new zzgsp();
        zza = zzgspVar;
        zzgxv.zzbZ(zzgsp.class, zzgspVar);
    }

    private zzgsp() {
    }

    public static zzgsm zza() {
        return (zzgsm) zza.zzaZ();
    }

    public static zzgsp zzd() {
        return zza;
    }

    static /* synthetic */ void zzi(zzgsp zzgspVar, String str) {
        str.getClass();
        zzgspVar.zzc = str;
    }

    static /* synthetic */ void zzj(zzgsp zzgspVar, zzgwn zzgwnVar) {
        zzgwnVar.getClass();
        zzgspVar.zzd = zzgwnVar;
    }

    public final zzgsn zzb() {
        zzgsn zzgsnVar;
        int i = this.zze;
        if (i == 0) {
            zzgsnVar = zzgsn.UNKNOWN_KEYMATERIAL;
        } else if (i == 1) {
            zzgsnVar = zzgsn.SYMMETRIC;
        } else if (i == 2) {
            zzgsnVar = zzgsn.ASYMMETRIC_PRIVATE;
        } else if (i != 3) {
            zzgsnVar = i != 4 ? null : zzgsn.REMOTE;
        } else {
            zzgsnVar = zzgsn.ASYMMETRIC_PUBLIC;
        }
        return zzgsnVar == null ? zzgsn.UNRECOGNIZED : zzgsnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgsp();
        }
        zzgso zzgsoVar = null;
        if (iOrdinal == 4) {
            return new zzgsm(zzgsoVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgsp.class) {
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
        return this.zzd;
    }

    public final String zzg() {
        return this.zzc;
    }
}
