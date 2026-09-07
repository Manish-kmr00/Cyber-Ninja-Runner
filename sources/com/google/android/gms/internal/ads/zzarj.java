package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzarj extends zzgxv implements zzgzh {
    private static final zzarj zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private long zze;
    private long zzi;
    private long zzj;
    private long zzl;
    private int zzp;
    private String zzd = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzk = "";
    private String zzm = "";
    private String zzn = "";
    private zzgyh zzo = zzbK();

    static {
        zzarj zzarjVar = new zzarj();
        zza = zzarjVar;
        zzgxv.zzbZ(zzarj.class, zzarjVar);
    }

    private zzarj() {
    }

    public static zzarf zza() {
        return (zzarf) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzarj zzarjVar, String str) {
        str.getClass();
        zzarjVar.zzc |= 1;
        zzarjVar.zzd = str;
    }

    static /* synthetic */ void zzd(zzarj zzarjVar, String str) {
        zzarjVar.zzc |= 16;
        zzarjVar.zzh = str;
    }

    static /* synthetic */ void zzf(zzarj zzarjVar, String str) {
        zzarjVar.zzc |= 1024;
        zzarjVar.zzn = str;
    }

    static /* synthetic */ void zzg(zzarj zzarjVar, String str) {
        str.getClass();
        zzarjVar.zzc |= 8;
        zzarjVar.zzg = str;
    }

    static /* synthetic */ void zzh(zzarj zzarjVar, long j) {
        zzarjVar.zzc |= 2;
        zzarjVar.zze = j;
    }

    static /* synthetic */ void zzi(zzarj zzarjVar, String str) {
        str.getClass();
        zzarjVar.zzc |= 4;
        zzarjVar.zzf = str;
    }

    static /* synthetic */ void zzj(zzarj zzarjVar, int i) {
        zzarjVar.zzp = i - 1;
        zzarjVar.zzc |= 2048;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0004\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\r᠌\u000b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzarh.class, "zzp", zzari.zza});
        }
        if (iOrdinal == 3) {
            return new zzarj();
        }
        zzark zzarkVar = null;
        if (iOrdinal == 4) {
            return new zzarf(zzarkVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzarj.class) {
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
