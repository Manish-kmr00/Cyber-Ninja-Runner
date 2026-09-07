package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhdt extends zzgxv implements zzgzh {
    private static final zzhdt zza;
    private static volatile zzgzo zzb;
    private zzhdp zzC;
    private zzhca zzE;
    private zzhbs zzG;
    private zzhct zzI;
    private int zzJ;
    private long zzM;
    private zzhds zzN;
    private zzhcy zzO;
    private int zzc;
    private int zzd;
    private int zze;
    private zzhbw zzi;
    private zzhde zzm;
    private boolean zzn;
    private boolean zzu;
    private boolean zzv;
    private zzhdl zzx;
    private boolean zzy;
    private byte zzQ = 2;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private zzgyh zzj = zzbK();
    private zzgyh zzk = zzbK();
    private String zzl = "";
    private zzgyh zzo = zzgxv.zzbK();
    private String zzp = "";
    private zzgwn zzw = zzgwn.zzb;
    private String zzz = "";
    private zzgyh zzA = zzgxv.zzbK();
    private zzgyh zzB = zzgxv.zzbK();
    private zzgyh zzD = zzbK();
    private String zzF = "";
    private zzgyh zzH = zzbK();
    private zzgyh zzK = zzbK();
    private zzgyh zzL = zzbK();
    private String zzP = "";

    static {
        zzhdt zzhdtVar = new zzhdt();
        zza = zzhdtVar;
        zzgxv.zzbZ(zzhdt.class, zzhdtVar);
    }

    private zzhdt() {
    }

    public static zzhbu zzc() {
        return (zzhbu) zza.zzaZ();
    }

    static /* synthetic */ void zzi(zzhdt zzhdtVar, Iterable iterable) {
        zzgyh zzgyhVar = zzhdtVar.zzA;
        if (!zzgyhVar.zzc()) {
            zzhdtVar.zzA = zzgxv.zzbL(zzgyhVar);
        }
        zzgvw.zzaQ(iterable, zzhdtVar.zzA);
    }

    static /* synthetic */ void zzj(zzhdt zzhdtVar, Iterable iterable) {
        zzgyh zzgyhVar = zzhdtVar.zzB;
        if (!zzgyhVar.zzc()) {
            zzhdtVar.zzB = zzgxv.zzbL(zzgyhVar);
        }
        zzgvw.zzaQ(iterable, zzhdtVar.zzB);
    }

    static /* synthetic */ void zzk(zzhdt zzhdtVar, zzhdj zzhdjVar) {
        zzhdjVar.getClass();
        zzgyh zzgyhVar = zzhdtVar.zzj;
        if (!zzgyhVar.zzc()) {
            zzhdtVar.zzj = zzgxv.zzbL(zzgyhVar);
        }
        zzhdtVar.zzj.add(zzhdjVar);
    }

    static /* synthetic */ void zzl(zzhdt zzhdtVar) {
        zzhdtVar.zzc &= -65;
        zzhdtVar.zzl = zza.zzl;
    }

    static /* synthetic */ void zzm(zzhdt zzhdtVar, String str) {
        zzhdtVar.zzc |= 64;
        zzhdtVar.zzl = str;
    }

    static /* synthetic */ void zzn(zzhdt zzhdtVar, zzhdl zzhdlVar) {
        zzhdlVar.getClass();
        zzhdtVar.zzx = zzhdlVar;
        zzhdtVar.zzc |= 8192;
    }

    static /* synthetic */ void zzo(zzhdt zzhdtVar, zzhbw zzhbwVar) {
        zzhbwVar.getClass();
        zzhdtVar.zzi = zzhbwVar;
        zzhdtVar.zzc |= 32;
    }

    static /* synthetic */ void zzp(zzhdt zzhdtVar, String str) {
        str.getClass();
        zzhdtVar.zzc |= 8;
        zzhdtVar.zzg = str;
    }

    static /* synthetic */ void zzq(zzhdt zzhdtVar, zzhde zzhdeVar) {
        zzhdeVar.getClass();
        zzhdtVar.zzm = zzhdeVar;
        zzhdtVar.zzc |= 128;
    }

    static /* synthetic */ void zzr(zzhdt zzhdtVar, String str) {
        str.getClass();
        zzhdtVar.zzc |= 4;
        zzhdtVar.zzf = str;
    }

    static /* synthetic */ void zzs(zzhdt zzhdtVar, int i) {
        zzhdtVar.zzd = i - 1;
        zzhdtVar.zzc |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        zzhee zzheeVar = null;
        switch (zzgxuVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzQ);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzQ = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzbQ(zza, "\u0001#\u0000\u0001\u0001##\u0000\t\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\n᠌\u0000\u000b᠌\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0010\u001b\u0011ဉ\r\u0012ဇ\u000e\u0013ဈ\u000f\u0014\u001a\u0015\u001a\u0016ဉ\u0010\u0017\u001b\u0018ဉ\u0011\u0019ဈ\u0012\u001aဉ\u0013\u001b\u001b\u001cဉ\u0014\u001d᠌\u0015\u001e\u001b\u001f\u001b ဂ\u0016!ဉ\u0017\"ဉ\u0018#ဈ\u0019", new Object[]{"zzc", "zzf", "zzg", "zzh", "zzj", zzhdj.class, "zzn", "zzo", "zzp", "zzu", "zzv", "zzd", zzhdf.zza, "zze", zzhbt.zza, "zzi", "zzl", "zzm", "zzw", "zzk", zzhdx.class, "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", zzhed.class, "zzE", "zzF", "zzG", "zzH", zzhce.class, "zzI", "zzJ", zzhdn.zza, "zzK", zzhcw.class, "zzL", zzhdb.class, "zzM", "zzN", "zzO", "zzP"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhdt();
            case NEW_BUILDER:
                return new zzhbu(zzheeVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzo zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    synchronized (zzhdt.class) {
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

    public final String zzf() {
        return this.zzl;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final List zzh() {
        return this.zzj;
    }
}
