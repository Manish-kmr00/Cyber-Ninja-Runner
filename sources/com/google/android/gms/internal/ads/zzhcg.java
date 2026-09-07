package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhcg extends zzgxv implements zzgzh {
    private static final zzhcg zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private byte zzf = 2;
    private zzgwn zzd = zzgwn.zzb;
    private zzgwn zze = zzgwn.zzb;

    static {
        zzhcg zzhcgVar = new zzhcg();
        zza = zzhcgVar;
        zzgxv.zzbZ(zzhcg.class, zzhcgVar);
    }

    private zzhcg() {
    }

    public static zzhcf zzc() {
        return (zzhcf) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhcg zzhcgVar, zzgwn zzgwnVar) {
        zzhcgVar.zzc |= 1;
        zzhcgVar.zzd = zzgwnVar;
    }

    static /* synthetic */ void zzg(zzhcg zzhcgVar, zzgwn zzgwnVar) {
        zzhcgVar.zzc |= 2;
        zzhcgVar.zze = zzgwnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        zzhee zzheeVar = null;
        switch (zzgxuVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzf);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzf = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzbQ(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzc", "zzd", "zze"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhcg();
            case NEW_BUILDER:
                return new zzhcf(zzheeVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzo zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    synchronized (zzhcg.class) {
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
