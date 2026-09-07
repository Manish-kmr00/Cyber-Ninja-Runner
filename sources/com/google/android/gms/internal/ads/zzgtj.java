package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgtj extends zzgxv implements zzgzh {
    private static final zzgtj zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private zzgtm zze;

    static {
        zzgtj zzgtjVar = new zzgtj();
        zza = zzgtjVar;
        zzgxv.zzbZ(zzgtj.class, zzgtjVar);
    }

    private zzgtj() {
    }

    public static zzgth zzb() {
        return (zzgth) zza.zzaZ();
    }

    public static zzgtj zzd(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzgtj) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    public static zzgzo zzg() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzh(zzgtj zzgtjVar, zzgtm zzgtmVar) {
        zzgtmVar.getClass();
        zzgtjVar.zze = zzgtmVar;
        zzgtjVar.zzc |= 1;
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
            return zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgtj();
        }
        zzgti zzgtiVar = null;
        if (iOrdinal == 4) {
            return new zzgth(zzgtiVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgtj.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzgtm zzf() {
        zzgtm zzgtmVar = this.zze;
        return zzgtmVar == null ? zzgtm.zzc() : zzgtmVar;
    }
}
