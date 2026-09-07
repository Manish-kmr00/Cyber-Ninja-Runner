package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhck extends zzgxv implements zzgzh {
    private static final zzhck zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private zzhcj zzd;
    private int zzh;
    private byte zzi = 2;
    private zzgyh zze = zzbK();
    private zzgwn zzf = zzgwn.zzb;
    private zzgwn zzg = zzgwn.zzb;

    static {
        zzhck zzhckVar = new zzhck();
        zza = zzhckVar;
        zzgxv.zzbZ(zzhck.class, zzhckVar);
    }

    private zzhck() {
    }

    public static zzhch zzc() {
        return (zzhch) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhck zzhckVar, zzhcg zzhcgVar) {
        zzhcgVar.getClass();
        zzgyh zzgyhVar = zzhckVar.zze;
        if (!zzgyhVar.zzc()) {
            zzhckVar.zze = zzgxv.zzbL(zzgyhVar);
        }
        zzhckVar.zze.add(zzhcgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        zzhee zzheeVar = null;
        switch (zzgxuVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzi);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzi = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzbQ(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", "zze", zzhcg.class, "zzf", "zzg", "zzh"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhck();
            case NEW_BUILDER:
                return new zzhch(zzheeVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzo zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    synchronized (zzhck.class) {
                        zzgxqVar = zzb;
                        if (zzgxqVar == null) {
                            zzgxqVar = new zzgxq(zza);
                            zzb = zzgxqVar;
                        }
                        break;
                    }
                }
                return zzgxqVar;
            default:
                throw null;
        }
    }
}
