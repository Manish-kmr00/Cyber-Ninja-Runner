package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
@Deprecated
public final class zzhct extends zzgxv implements zzgzh {
    private static final zzhct zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private zzhcs zze;
    private zzhcs zzf;

    static {
        zzhct zzhctVar = new zzhct();
        zza = zzhctVar;
        zzgxv.zzbZ(zzhct.class, zzhctVar);
    }

    private zzhct() {
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", zzhcq.zza, "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzhct();
        }
        zzhee zzheeVar = null;
        if (iOrdinal == 4) {
            return new zzhcp(zzheeVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzhct.class) {
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
