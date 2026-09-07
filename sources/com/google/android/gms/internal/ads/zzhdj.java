package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhdj extends zzgxv implements zzgzh {
    private static final zzhdj zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private zzhck zzf;
    private zzhco zzg;
    private int zzh;
    private int zzk;
    private byte zzm = 2;
    private String zze = "";
    private zzgyd zzi = zzbG();
    private String zzj = "";
    private zzgyh zzl = zzgxv.zzbK();

    static {
        zzhdj zzhdjVar = new zzhdj();
        zza = zzhdjVar;
        zzgxv.zzbZ(zzhdj.class, zzhdjVar);
    }

    private zzhdj() {
    }

    public static zzhdi zzd() {
        return (zzhdi) zza.zzaZ();
    }

    static /* synthetic */ void zzh(zzhdj zzhdjVar, String str) {
        str.getClass();
        zzgyh zzgyhVar = zzhdjVar.zzl;
        if (!zzgyhVar.zzc()) {
            zzhdjVar.zzl = zzgxv.zzbL(zzgyhVar);
        }
        zzhdjVar.zzl.add(str);
    }

    static /* synthetic */ void zzi(zzhdj zzhdjVar, int i) {
        zzhdjVar.zzc |= 1;
        zzhdjVar.zzd = i;
    }

    static /* synthetic */ void zzj(zzhdj zzhdjVar, zzhck zzhckVar) {
        zzhckVar.getClass();
        zzhdjVar.zzf = zzhckVar;
        zzhdjVar.zzc |= 4;
    }

    static /* synthetic */ void zzk(zzhdj zzhdjVar, String str) {
        str.getClass();
        zzhdjVar.zzc |= 2;
        zzhdjVar.zze = str;
    }

    static /* synthetic */ void zzl(zzhdj zzhdjVar, int i) {
        zzhdjVar.zzk = i - 1;
        zzhdjVar.zzc |= 64;
    }

    public final int zzc() {
        return this.zzl.size();
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        zzhee zzheeVar = null;
        switch (zzgxuVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzm);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzm = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzbQ(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\b᠌\u0006\t\u001a", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzhdg.zza, "zzl"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhdj();
            case NEW_BUILDER:
                return new zzhdi(zzheeVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzo zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    synchronized (zzhdj.class) {
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

    public final String zzg() {
        return this.zze;
    }
}
