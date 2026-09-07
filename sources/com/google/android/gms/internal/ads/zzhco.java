package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhco extends zzgxv implements zzgzh {
    private static final zzhco zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private zzhcn zzd;
    private zzgwn zzg;
    private int zzh;
    private zzgwn zzi;
    private byte zzj = 2;
    private zzgyh zze = zzbK();
    private zzgwn zzf = zzgwn.zzb;

    static {
        zzhco zzhcoVar = new zzhco();
        zza = zzhcoVar;
        zzgxv.zzbZ(zzhco.class, zzhcoVar);
    }

    private zzhco() {
        zzgwn zzgwnVar = zzgwn.zzb;
        this.zzg = zzgwnVar;
        this.zzi = zzgwnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        zzhee zzheeVar = null;
        switch (zzgxuVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzj);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzj = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzbQ(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzc", "zzd", "zze", zzhcg.class, "zzf", "zzg", "zzh", "zzi"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhco();
            case NEW_BUILDER:
                return new zzhcl(zzheeVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzo zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    synchronized (zzhco.class) {
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
