package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhdl extends zzgxv implements zzgzh {
    private static final zzhdl zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private long zze;
    private boolean zzf;
    private int zzg;
    private boolean zzj;
    private boolean zzk;
    private String zzd = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzhdl zzhdlVar = new zzhdl();
        zza = zzhdlVar;
        zzgxv.zzbZ(zzhdl.class, zzhdlVar);
    }

    private zzhdl() {
    }

    public static zzhdk zzc() {
        return (zzhdk) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhdl zzhdlVar, String str) {
        zzhdlVar.zzc |= 1;
        zzhdlVar.zzd = str;
    }

    static /* synthetic */ void zzg(zzhdl zzhdlVar, long j) {
        zzhdlVar.zzc |= 2;
        zzhdlVar.zze = j;
    }

    static /* synthetic */ void zzh(zzhdl zzhdlVar, boolean z) {
        zzhdlVar.zzc |= 4;
        zzhdlVar.zzf = z;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဇ\u0006\bဇ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzhdm.zza, "zzh", "zzi", "zzj", "zzk"});
        }
        if (iOrdinal == 3) {
            return new zzhdl();
        }
        zzhee zzheeVar = null;
        if (iOrdinal == 4) {
            return new zzhdk(zzheeVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzhdl.class) {
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
