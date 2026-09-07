package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaxw extends zzgxv implements zzgzh {
    private static final zzaxw zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        zzaxw zzaxwVar = new zzaxw();
        zza = zzaxwVar;
        zzgxv.zzbZ(zzaxw.class, zzaxwVar);
    }

    private zzaxw() {
    }

    public static zzaxu zzd() {
        return (zzaxu) zza.zzaZ();
    }

    public static zzaxw zzg() {
        return zza;
    }

    public static zzaxw zzh(zzgwn zzgwnVar) throws zzgyk {
        return (zzaxw) zzgxv.zzbm(zza, zzgwnVar);
    }

    public static zzaxw zzi(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzaxw) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    static /* synthetic */ void zzl(zzaxw zzaxwVar, String str) {
        str.getClass();
        zzaxwVar.zzc |= 2;
        zzaxwVar.zze = str;
    }

    static /* synthetic */ void zzm(zzaxw zzaxwVar, long j) {
        zzaxwVar.zzc |= 8;
        zzaxwVar.zzg = j;
    }

    static /* synthetic */ void zzn(zzaxw zzaxwVar, long j) {
        zzaxwVar.zzc |= 4;
        zzaxwVar.zzf = j;
    }

    static /* synthetic */ void zzo(zzaxw zzaxwVar, long j) {
        zzaxwVar.zzc |= 16;
        zzaxwVar.zzh = j;
    }

    static /* synthetic */ void zzp(zzaxw zzaxwVar, String str) {
        str.getClass();
        zzaxwVar.zzc |= 1;
        zzaxwVar.zzd = str;
    }

    public final long zza() {
        return this.zzg;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final long zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (iOrdinal == 3) {
            return new zzaxw();
        }
        zzaxv zzaxvVar = null;
        if (iOrdinal == 4) {
            return new zzaxu(zzaxvVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzaxw.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final String zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}
