package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzasu extends zzgxv implements zzgzh {
    private static final zzasu zza;
    private static volatile zzgzo zzb;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private long zzE;
    private long zzI;
    private long zzJ;
    private long zzK;
    private long zzM;
    private zzasw zzP;
    private zzasp zzaG;
    private long zzaM;
    private long zzaN;
    private zzash zzaQ;
    private zzasj zzaR;
    private int zzaU;
    private long zzaV;
    private boolean zzaY;
    private zzasr zzah;
    private zzast zzaj;
    private int zzau;
    private int zzav;
    private int zzaw;
    private int zzax;
    private zzatj zzay;
    private long zzba;
    private zzath zzbb;
    private int zzc;
    private int zzd;
    private int zze;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzu;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;
    private String zzf = "";
    private String zzg = "";
    private String zzv = "";
    private String zzF = "";
    private String zzG = "D";
    private String zzH = "";
    private String zzL = "";
    private long zzN = -1;
    private long zzO = -1;
    private long zzQ = -1;
    private long zzR = -1;
    private long zzS = -1;
    private long zzT = -1;
    private long zzU = -1;
    private long zzV = -1;
    private String zzW = "D";
    private String zzX = "D";
    private long zzY = -1;
    private int zzZ = 1000;
    private int zzaa = 1000;
    private long zzab = -1;
    private long zzac = -1;
    private long zzad = -1;
    private long zzae = -1;
    private long zzaf = -1;
    private int zzag = 1000;
    private zzgyh zzai = zzbK();
    private long zzak = -1;
    private long zzal = -1;
    private long zzam = -1;
    private long zzan = -1;
    private long zzao = -1;
    private long zzap = -1;
    private long zzaq = -1;
    private long zzar = -1;
    private String zzas = "D";
    private long zzat = -1;
    private long zzaz = -1;
    private int zzaA = 1000;
    private int zzaB = 1000;
    private String zzaC = "D";
    private zzgyh zzaD = zzbK();
    private int zzaE = 1000;
    private zzgyh zzaF = zzbK();
    private String zzaH = "";
    private long zzaI = -1;
    private long zzaJ = -1;
    private long zzaK = -1;
    private long zzaL = -1;
    private long zzaO = -1;
    private String zzaP = "";
    private long zzaS = -1;
    private long zzaT = -1;
    private String zzaW = "";
    private int zzaX = 2;
    private String zzaZ = "";
    private long zzbc = -1;
    private String zzbd = "";

    static {
        zzasu zzasuVar = new zzasu();
        zza = zzasuVar;
        zzgxv.zzbZ(zzasu.class, zzasuVar);
    }

    private zzasu() {
    }

    static /* synthetic */ void zzA(zzasu zzasuVar, long j) {
        zzasuVar.zze |= 4096;
        zzasuVar.zzaK = j;
    }

    static /* synthetic */ void zzB(zzasu zzasuVar, String str) {
        str.getClass();
        zzasuVar.zzd |= 256;
        zzasuVar.zzX = str;
    }

    static /* synthetic */ void zzC(zzasu zzasuVar, String str) {
        str.getClass();
        zzasuVar.zzc |= 4194304;
        zzasuVar.zzF = str;
    }

    static /* synthetic */ void zzD(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 1048576;
        zzasuVar.zzD = j;
    }

    static /* synthetic */ void zzE(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 1024;
        zzasuVar.zzp = j;
    }

    static /* synthetic */ void zzF(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 2048;
        zzasuVar.zzu = j;
    }

    static /* synthetic */ void zzG(zzasu zzasuVar, String str) {
        str.getClass();
        zzasuVar.zzc |= 1;
        zzasuVar.zzf = str;
    }

    static /* synthetic */ void zzH(zzasu zzasuVar, long j) {
        zzasuVar.zzd |= 4194304;
        zzasuVar.zzam = j;
    }

    static /* synthetic */ void zzI(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 524288;
        zzasuVar.zzC = j;
    }

    static /* synthetic */ void zzJ(zzasu zzasuVar, long j) {
        zzasuVar.zzd |= 8388608;
        zzasuVar.zzan = j;
    }

    static /* synthetic */ void zzK(zzasu zzasuVar, long j) {
        zzasuVar.zzd |= 64;
        zzasuVar.zzV = j;
    }

    static /* synthetic */ void zzL(zzasu zzasuVar, long j) {
        zzasuVar.zzd |= 16;
        zzasuVar.zzT = j;
    }

    static /* synthetic */ void zzM(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= Integer.MIN_VALUE;
        zzasuVar.zzO = j;
    }

    static /* synthetic */ void zzN(zzasu zzasuVar, long j) {
        zzasuVar.zzd |= 8;
        zzasuVar.zzS = j;
    }

    static /* synthetic */ void zzO(zzasu zzasuVar, long j) {
        zzasuVar.zzd |= 4;
        zzasuVar.zzR = j;
    }

    static /* synthetic */ void zzP(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 1073741824;
        zzasuVar.zzN = j;
    }

    static /* synthetic */ void zzQ(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 32768;
        zzasuVar.zzy = j;
    }

    static /* synthetic */ void zzR(zzasu zzasuVar, long j) {
        zzasuVar.zzd |= 2;
        zzasuVar.zzQ = j;
    }

    static /* synthetic */ void zzS(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 8192;
        zzasuVar.zzw = j;
    }

    static /* synthetic */ void zzT(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 16384;
        zzasuVar.zzx = j;
    }

    static /* synthetic */ void zzU(zzasu zzasuVar, long j) {
        zzasuVar.zzd |= 16384;
        zzasuVar.zzad = j;
    }

    static /* synthetic */ void zzV(zzasu zzasuVar, long j) {
        zzasuVar.zze |= 1024;
        zzasuVar.zzaI = j;
    }

    static /* synthetic */ void zzW(zzasu zzasuVar, zzasr zzasrVar) {
        zzasrVar.getClass();
        zzasuVar.zzah = zzasrVar;
        zzasuVar.zzd |= 262144;
    }

    static /* synthetic */ void zzX(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 67108864;
        zzasuVar.zzJ = j;
    }

    static /* synthetic */ void zzY(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 65536;
        zzasuVar.zzz = j;
    }

    static /* synthetic */ void zzZ(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 2097152;
        zzasuVar.zzE = j;
    }

    public static zzarz zza() {
        return (zzarz) zza.zzaZ();
    }

    static /* synthetic */ void zzaa(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 134217728;
        zzasuVar.zzK = j;
    }

    static /* synthetic */ void zzab(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 33554432;
        zzasuVar.zzI = j;
    }

    static /* synthetic */ void zzac(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 536870912;
        zzasuVar.zzM = j;
    }

    static /* synthetic */ void zzad(zzasu zzasuVar, zzast zzastVar) {
        zzastVar.getClass();
        zzasuVar.zzaj = zzastVar;
        zzasuVar.zzd |= 524288;
    }

    static /* synthetic */ void zzae(zzasu zzasuVar, String str) {
        str.getClass();
        zzasuVar.zzc |= 268435456;
        zzasuVar.zzL = str;
    }

    static /* synthetic */ void zzah(zzasu zzasuVar, int i) {
        zzasuVar.zzaa = i - 1;
        zzasuVar.zzd |= 2048;
    }

    static /* synthetic */ void zzai(zzasu zzasuVar, int i) {
        zzasuVar.zzag = i - 1;
        zzasuVar.zzd |= 131072;
    }

    static /* synthetic */ void zzaj(zzasu zzasuVar, int i) {
        zzasuVar.zzaB = i - 1;
        zzasuVar.zze |= 32;
    }

    static /* synthetic */ void zzak(zzasu zzasuVar, int i) {
        zzasuVar.zzaU = i - 1;
        zzasuVar.zze |= 4194304;
    }

    static /* synthetic */ void zzal(zzasu zzasuVar, int i) {
        zzasuVar.zzaA = i - 1;
        zzasuVar.zze |= 16;
    }

    static /* synthetic */ void zzam(zzasu zzasuVar, int i) {
        zzasuVar.zzZ = i - 1;
        zzasuVar.zzd |= 1024;
    }

    public static zzasu zzc() {
        return zza;
    }

    public static zzasu zzd(byte[] bArr, zzgxf zzgxfVar) throws zzgyk {
        return (zzasu) zzgxv.zzbx(zza, bArr, zzgxfVar);
    }

    static /* synthetic */ void zzh(zzasu zzasuVar, zzasr zzasrVar) {
        zzasrVar.getClass();
        zzgyh zzgyhVar = zzasuVar.zzai;
        if (!zzgyhVar.zzc()) {
            zzasuVar.zzai = zzgxv.zzbL(zzgyhVar);
        }
        zzasuVar.zzai.add(zzasrVar);
    }

    static /* synthetic */ void zzj(zzasu zzasuVar, long j) {
        zzasuVar.zzd |= 67108864;
        zzasuVar.zzaq = j;
    }

    static /* synthetic */ void zzk(zzasu zzasuVar, String str) {
        str.getClass();
        zzasuVar.zzd |= 268435456;
        zzasuVar.zzas = str;
    }

    static /* synthetic */ void zzl(zzasu zzasuVar, long j) {
        zzasuVar.zzd |= 134217728;
        zzasuVar.zzar = j;
    }

    static /* synthetic */ void zzm(zzasu zzasuVar, long j) {
        zzasuVar.zze |= 2048;
        zzasuVar.zzaJ = j;
    }

    static /* synthetic */ void zzn(zzasu zzasuVar, String str) {
        str.getClass();
        zzasuVar.zze |= 131072;
        zzasuVar.zzaP = str;
    }

    static /* synthetic */ void zzo(zzasu zzasuVar, String str) {
        str.getClass();
        zzasuVar.zzc |= 2;
        zzasuVar.zzg = str;
    }

    static /* synthetic */ void zzp(zzasu zzasuVar, String str) {
        str.getClass();
        zzasuVar.zzd |= 128;
        zzasuVar.zzW = str;
    }

    static /* synthetic */ void zzq(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 4;
        zzasuVar.zzh = j;
    }

    static /* synthetic */ void zzr(zzasu zzasuVar, long j) {
        zzasuVar.zzd |= 2097152;
        zzasuVar.zzal = j;
    }

    static /* synthetic */ void zzs(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 32;
        zzasuVar.zzk = j;
    }

    static /* synthetic */ void zzt(zzasu zzasuVar, long j) {
        zzasuVar.zzc |= 16;
        zzasuVar.zzj = j;
    }

    static /* synthetic */ void zzu(zzasu zzasuVar, String str) {
        str.getClass();
        zzasuVar.zzc |= 16777216;
        zzasuVar.zzH = str;
    }

    static /* synthetic */ void zzv(zzasu zzasuVar, long j) {
        zzasuVar.zzd |= 32;
        zzasuVar.zzU = j;
    }

    static /* synthetic */ void zzw(zzasu zzasuVar, long j) {
        zzasuVar.zzd |= 4096;
        zzasuVar.zzab = j;
    }

    static /* synthetic */ void zzx(zzasu zzasuVar, long j) {
        zzasuVar.zzd |= 8192;
        zzasuVar.zzac = j;
    }

    static /* synthetic */ void zzy(zzasu zzasuVar, long j) {
        zzasuVar.zze |= 268435456;
        zzasuVar.zzba = j;
    }

    static /* synthetic */ void zzz(zzasu zzasuVar, long j) {
        zzasuVar.zze |= 8192;
        zzasuVar.zzaL = j;
    }

    public final boolean zzaf() {
        return (this.zzc & 4194304) != 0;
    }

    public final boolean zzag() {
        return (this.zze & 536870912) != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            zzgyb zzgybVar = zzasd.zza;
            zzgyb zzgybVar2 = zzatc.zza;
            return zzbQ(zza, "\u0001c\u0000\u0003\u0001Įc\u0000\u0003\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂW\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈX\u0019ဂ\\\u001a᠌Y\u001bဈ\u0016\u001cဇZ\u001dဈ\u0018\u001eဈ[\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0᠌*1᠌+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08᠌19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=A᠌>B᠌?Cဈ<D᠌AEဉBFဂCGဂ8Hဂ9I᠌DJဂ)Kဈ\u0017L᠌EMဈFN\u001bO᠌GP\u001bQဉHRဈISဂJTဂKUဂLVဂMWဂNXဂPYဈQZဉR[ဉS\\ဂT]ဂU^᠌V_᠌@aဂOÉဉ]ĭဂ^Įဈ_", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzaV", "zzD", "zzE", "zzaW", "zzba", "zzaX", zzgybVar, "zzF", "zzaY", "zzH", "zzaZ", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzai", zzasr.class, "zzU", "zzV", "zzW", "zzX", "zzZ", zzgybVar2, "zzaa", zzgybVar2, "zzah", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", zzgybVar2, "zzaj", "zzak", "zzal", "zzam", "zzan", "zzaq", "zzar", "zzat", "zzau", zzatb.zza, "zzav", zzatf.zza, "zzas", "zzax", zzasa.zza, "zzay", "zzaz", "zzao", "zzap", "zzaA", zzgybVar2, "zzY", "zzG", "zzaB", zzgybVar2, "zzaC", "zzaD", zzasn.class, "zzaE", zzgybVar2, "zzaF", zzasc.class, "zzaG", "zzaH", "zzaI", "zzaJ", "zzaK", "zzaL", "zzaM", "zzaO", "zzaP", "zzaQ", "zzaR", "zzaS", "zzaT", "zzaU", zzask.zza, "zzaw", zzase.zza, "zzaN", "zzbb", "zzbc", "zzbd"});
        }
        if (iOrdinal == 3) {
            return new zzasu();
        }
        zzatm zzatmVar = null;
        if (iOrdinal == 4) {
            return new zzarz(zzatmVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzasu.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzath zzf() {
        zzath zzathVar = this.zzbb;
        return zzathVar == null ? zzath.zzc() : zzathVar;
    }

    public final String zzg() {
        return this.zzF;
    }
}
