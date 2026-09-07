package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzwe implements zzuw, zzadf, zzzk, zzzo, zzwp {
    private static final Map zzb;
    private static final zzz zzc;
    private zzaeb zzA;
    private long zzB;
    private boolean zzC;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private int zzH;
    private boolean zzI;
    private long zzJ;
    private boolean zzL;
    private int zzM;
    private boolean zzN;
    private boolean zzO;
    private final zzze zzP;
    private final Uri zzd;
    private final zzge zze;
    private final zzry zzf;
    private final zzvi zzg;
    private final zzrt zzh;
    private final zzwa zzi;
    private final long zzj;
    private final long zzk;
    private final zzvt zzm;
    private zzuv zzr;
    private zzagc zzs;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private zzwd zzz;
    private final zzzs zzl = new zzzs("ProgressiveMediaPeriod");
    private final zzdj zzn = new zzdj(zzdg.zza);
    private final Runnable zzo = new Runnable() { // from class: com.google.android.gms.internal.ads.zzvv
        @Override // java.lang.Runnable
        public final void run() {
            this.zza.zzV();
        }
    };
    private final Runnable zzp = new Runnable() { // from class: com.google.android.gms.internal.ads.zzvw
        @Override // java.lang.Runnable
        public final void run() {
            zzwe.zzA(this.zza);
        }
    };
    private final Handler zzq = zzeu.zzy(null);
    private zzwc[] zzu = new zzwc[0];
    private zzwr[] zzt = new zzwr[0];
    private long zzK = -9223372036854775807L;
    private int zzD = 1;

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        zzb = Collections.unmodifiableMap(map);
        zzx zzxVar = new zzx();
        zzxVar.zzO("icy");
        zzxVar.zzad("application/x-icy");
        zzc = zzxVar.zzaj();
    }

    public zzwe(Uri uri, zzge zzgeVar, zzvt zzvtVar, zzry zzryVar, zzrt zzrtVar, zzzi zzziVar, zzvi zzviVar, zzwa zzwaVar, zzze zzzeVar, String str, int i, int i2, zzz zzzVar, long j, zzaaa zzaaaVar) {
        this.zzd = uri;
        this.zze = zzgeVar;
        this.zzf = zzryVar;
        this.zzh = zzrtVar;
        this.zzg = zzviVar;
        this.zzi = zzwaVar;
        this.zzP = zzzeVar;
        this.zzj = i;
        this.zzm = zzvtVar;
        this.zzk = j;
    }

    static /* bridge */ /* synthetic */ void zzF(final zzwe zzweVar) {
        zzweVar.zzq.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzvu
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzI = true;
            }
        });
    }

    private final int zzR() {
        int iZzd = 0;
        for (zzwr zzwrVar : this.zzt) {
            iZzd += zzwrVar.zzd();
        }
        return iZzd;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    private final long zzS(boolean z) {
        int i = 0;
        long jMax = Long.MIN_VALUE;
        while (true) {
            zzwr[] zzwrVarArr = this.zzt;
            if (i >= zzwrVarArr.length) {
                return jMax;
            }
            if (z) {
                jMax = Math.max(jMax, zzwrVarArr[i].zzh());
            } else {
                zzwd zzwdVar = this.zzz;
                zzwdVar.getClass();
                if (zzwdVar.zzc[i]) {
                    jMax = Math.max(jMax, zzwrVarArr[i].zzh());
                }
            }
            i++;
        }
    }

    private final zzaei zzT(zzwc zzwcVar) {
        int length = this.zzt.length;
        for (int i = 0; i < length; i++) {
            if (zzwcVar.equals(this.zzu[i])) {
                return this.zzt[i];
            }
        }
        if (this.zzv) {
            zzdx.zzf("ProgressiveMediaPeriod", "Extractor added new track (id=" + zzwcVar.zza + ") after finishing tracks.");
            return new zzacx();
        }
        zzwr zzwrVar = new zzwr(this.zzP, this.zzf, this.zzh);
        zzwrVar.zzv(this);
        int i2 = length + 1;
        zzwc[] zzwcVarArr = (zzwc[]) Arrays.copyOf(this.zzu, i2);
        zzwcVarArr[length] = zzwcVar;
        int i3 = zzeu.zza;
        this.zzu = zzwcVarArr;
        zzwr[] zzwrVarArr = (zzwr[]) Arrays.copyOf(this.zzt, i2);
        zzwrVarArr[length] = zzwrVar;
        this.zzt = zzwrVarArr;
        return zzwrVar;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private final void zzU() {
        zzdc.zzf(this.zzw);
        this.zzz.getClass();
        this.zzA.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzV() {
        int i;
        if (this.zzO || this.zzw || !this.zzv || this.zzA == null) {
            return;
        }
        for (zzwr zzwrVar : this.zzt) {
            if (zzwrVar.zzi() == null) {
                return;
            }
        }
        this.zzn.zzc();
        int length = this.zzt.length;
        zzbm[] zzbmVarArr = new zzbm[length];
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zzz zzzVarZzi = this.zzt[i2].zzi();
            zzzVarZzi.getClass();
            String str = zzzVarZzi.zzo;
            boolean zZzh = zzay.zzh(str);
            boolean z = zZzh || zzay.zzj(str);
            zArr[i2] = z;
            this.zzx = z | this.zzx;
            this.zzy = this.zzk != -9223372036854775807L && length == 1 && zzay.zzi(str);
            zzagc zzagcVar = this.zzs;
            if (zzagcVar != null) {
                if (zZzh || this.zzu[i2].zzb) {
                    zzav zzavVar = zzzVarZzi.zzl;
                    zzav zzavVar2 = zzavVar == null ? new zzav(-9223372036854775807L, zzagcVar) : zzavVar.zzc(zzagcVar);
                    zzx zzxVarZzb = zzzVarZzi.zzb();
                    zzxVarZzb.zzW(zzavVar2);
                    zzzVarZzi = zzxVarZzb.zzaj();
                }
                if (zZzh && zzzVarZzi.zzh == -1 && zzzVarZzi.zzi == -1 && (i = zzagcVar.zza) != -1) {
                    zzx zzxVarZzb2 = zzzVarZzi.zzb();
                    zzxVarZzb2.zzA(i);
                    zzzVarZzi = zzxVarZzb2.zzaj();
                }
            }
            zzz zzzVarZzc = zzzVarZzi.zzc(this.zzf.zza(zzzVarZzi));
            zzbmVarArr[i2] = new zzbm(Integer.toString(i2), zzzVarZzc);
            this.zzG = zzzVarZzc.zzu | this.zzG;
        }
        this.zzz = new zzwd(new zzxd(zzbmVarArr), zArr);
        if (this.zzy && this.zzB == -9223372036854775807L) {
            this.zzB = this.zzk;
            this.zzA = new zzvy(this, this.zzA);
        }
        this.zzi.zza(this.zzB, this.zzA, this.zzC);
        this.zzw = true;
        zzuv zzuvVar = this.zzr;
        zzuvVar.getClass();
        zzuvVar.zzl(this);
    }

    private final void zzW(int i) {
        zzU();
        zzwd zzwdVar = this.zzz;
        boolean[] zArr = zzwdVar.zzd;
        if (zArr[i]) {
            return;
        }
        zzz zzzVarZzb = zzwdVar.zza.zzb(i).zzb(0);
        this.zzg.zzd(new zzuu(1, zzay.zzb(zzzVarZzb.zzo), zzzVarZzb, 0, null, zzeu.zzv(this.zzJ), -9223372036854775807L));
        zArr[i] = true;
    }

    private final void zzX(int i) {
        zzU();
        if (this.zzL) {
            if ((!this.zzx || this.zzz.zzb[i]) && !this.zzt[i].zzy(false)) {
                this.zzK = 0L;
                this.zzL = false;
                this.zzF = true;
                this.zzJ = 0L;
                this.zzM = 0;
                for (zzwr zzwrVar : this.zzt) {
                    zzwrVar.zzq(false);
                }
                zzuv zzuvVar = this.zzr;
                zzuvVar.getClass();
                zzuvVar.zzj(this);
            }
        }
    }

    private final void zzY() {
        zzvz zzvzVar = new zzvz(this, this.zzd, this.zze, this.zzm, this, this.zzn);
        if (this.zzw) {
            zzdc.zzf(zzZ());
            long j = this.zzB;
            if (j != -9223372036854775807L && this.zzK > j) {
                this.zzN = true;
                this.zzK = -9223372036854775807L;
                return;
            }
            zzaeb zzaebVar = this.zzA;
            zzaebVar.getClass();
            zzvz.zzf(zzvzVar, zzaebVar.zzg(this.zzK).zza.zzc, this.zzK);
            for (zzwr zzwrVar : this.zzt) {
                zzwrVar.zzu(this.zzK);
            }
            this.zzK = -9223372036854775807L;
        }
        this.zzM = zzR();
        this.zzl.zza(zzvzVar, this, zzzi.zza(this.zzD));
    }

    private final boolean zzZ() {
        return this.zzK != -9223372036854775807L;
    }

    private final boolean zzaa() {
        return this.zzF || zzZ();
    }

    static /* bridge */ /* synthetic */ long zzr(zzwe zzweVar, boolean z) {
        return zzweVar.zzS(true);
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzG() {
        this.zzv = true;
        this.zzq.post(this.zzo);
    }

    final void zzH() throws IOException {
        this.zzl.zzi(zzzi.zza(this.zzD));
    }

    final void zzI(int i) throws IOException {
        this.zzt[i].zzn();
        zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final /* bridge */ /* synthetic */ void zzJ(zzzn zzznVar, long j, long j2, boolean z) {
        zzvz zzvzVar = (zzvz) zzznVar;
        zzhd zzhdVar = zzvzVar.zzd;
        zzup zzupVar = new zzup(zzvzVar.zzb, zzvzVar.zzl, zzhdVar.zzh(), zzhdVar.zzi(), j, j2, zzhdVar.zzg());
        long unused = zzvzVar.zzb;
        this.zzg.zze(zzupVar, new zzuu(1, -1, null, 0, null, zzeu.zzv(zzvzVar.zzk), zzeu.zzv(this.zzB)));
        if (z) {
            return;
        }
        for (zzwr zzwrVar : this.zzt) {
            zzwrVar.zzq(false);
        }
        if (this.zzH > 0) {
            zzuv zzuvVar = this.zzr;
            zzuvVar.getClass();
            zzuvVar.zzj(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final /* bridge */ /* synthetic */ void zzK(zzzn zzznVar, long j, long j2) {
        zzvz zzvzVar = (zzvz) zzznVar;
        if (this.zzB == -9223372036854775807L && this.zzA != null) {
            long jZzS = zzS(true);
            long j3 = jZzS == Long.MIN_VALUE ? 0L : jZzS + 10000;
            this.zzB = j3;
            this.zzi.zza(j3, this.zzA, this.zzC);
        }
        zzhd zzhdVar = zzvzVar.zzd;
        zzup zzupVar = new zzup(zzvzVar.zzb, zzvzVar.zzl, zzhdVar.zzh(), zzhdVar.zzi(), j, j2, zzhdVar.zzg());
        long unused = zzvzVar.zzb;
        this.zzg.zzf(zzupVar, new zzuu(1, -1, null, 0, null, zzeu.zzv(zzvzVar.zzk), zzeu.zzv(this.zzB)));
        this.zzN = true;
        zzuv zzuvVar = this.zzr;
        zzuvVar.getClass();
        zzuvVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final /* bridge */ /* synthetic */ void zzL(zzzn zzznVar, long j, long j2, int i) {
        zzvz zzvzVar = (zzvz) zzznVar;
        zzhd zzhdVar = zzvzVar.zzd;
        this.zzg.zzh(i == 0 ? new zzup(zzvzVar.zzb, zzvzVar.zzl, j) : new zzup(zzvzVar.zzb, zzvzVar.zzl, zzhdVar.zzh(), zzhdVar.zzi(), j, j2, zzhdVar.zzg()), new zzuu(1, -1, null, 0, null, zzeu.zzv(zzvzVar.zzk), zzeu.zzv(this.zzB)), i);
    }

    @Override // com.google.android.gms.internal.ads.zzzo
    public final void zzM() {
        for (zzwr zzwrVar : this.zzt) {
            zzwrVar.zzp();
        }
        this.zzm.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzwp
    public final void zzN(zzz zzzVar) {
        this.zzq.post(this.zzo);
    }

    public final void zzO() {
        if (this.zzw) {
            for (zzwr zzwrVar : this.zzt) {
                zzwrVar.zzo();
            }
        }
        this.zzl.zzj(this);
        this.zzq.removeCallbacksAndMessages(null);
        this.zzr = null;
        this.zzO = true;
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzP(final zzaeb zzaebVar) {
        this.zzq.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzvx
            @Override // java.lang.Runnable
            public final void run() {
                zzwe.zzC(this.zza, zzaebVar);
            }
        });
    }

    final boolean zzQ(int i) {
        return !zzaa() && this.zzt[i].zzy(this.zzN);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zza(long j, zzma zzmaVar) {
        zzU();
        if (!this.zzA.zzh()) {
            return 0L;
        }
        zzadz zzadzVarZzg = this.zzA.zzg(j);
        zzaec zzaecVar = zzadzVarZzg.zza;
        zzaec zzaecVar2 = zzadzVarZzg.zzb;
        long j2 = zzmaVar.zzc;
        if (j2 == 0) {
            if (zzmaVar.zzd == 0) {
                return j;
            }
            j2 = 0;
        }
        long j3 = zzaecVar.zzb;
        int i = zzeu.zza;
        long j4 = j - j2;
        long j5 = zzmaVar.zzd;
        long j6 = j + j5;
        long j7 = j ^ j6;
        long j8 = j5 ^ j6;
        if (((j ^ j2) & (j ^ j4)) < 0) {
            j4 = Long.MIN_VALUE;
        }
        if ((j7 & j8) < 0) {
            j6 = Long.MAX_VALUE;
        }
        boolean z = j4 <= j3 && j3 <= j6;
        long j9 = zzaecVar2.zzb;
        boolean z2 = j4 <= j9 && j9 <= j6;
        if (z && z2) {
            if (Math.abs(j3 - j) > Math.abs(j9 - j)) {
                return j9;
            }
        } else if (!z) {
            return z2 ? j9 : j4;
        }
        return j3;
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final long zzb() {
        long jZzS;
        zzU();
        if (this.zzN || this.zzH == 0) {
            return Long.MIN_VALUE;
        }
        if (zzZ()) {
            return this.zzK;
        }
        if (this.zzx) {
            int length = this.zzt.length;
            jZzS = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                zzwd zzwdVar = this.zzz;
                if (zzwdVar.zzb[i] && zzwdVar.zzc[i] && !this.zzt[i].zzx()) {
                    jZzS = Math.min(jZzS, this.zzt[i].zzh());
                }
            }
        } else {
            jZzS = Long.MAX_VALUE;
        }
        if (jZzS == Long.MAX_VALUE) {
            jZzS = zzS(false);
        }
        return jZzS == Long.MIN_VALUE ? this.zzJ : jZzS;
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final long zzc() {
        return zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zzd() {
        if (this.zzG) {
            this.zzG = false;
        } else {
            if (!this.zzF) {
                return -9223372036854775807L;
            }
            if (!this.zzN && zzR() <= this.zzM) {
                return -9223372036854775807L;
            }
            this.zzF = false;
        }
        return this.zzJ;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    /* JADX WARN: Code duplicated, block: B:37:0x007c A[LOOP:1: B:36:0x007a->B:37:0x007c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:39:0x0088  */
    /* JADX WARN: Code duplicated, block: B:41:0x0091 A[LOOP:2: B:40:0x008f->B:41:0x0091, LOOP_END] */
    /* JADX WARN: Instruction removed from duplicated block: B:35:0x0077, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:39:0x0088, please report this as an issue */
    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zze(long j) {
        zzzs zzzsVar;
        int i;
        zzU();
        boolean[] zArr = this.zzz.zzb;
        if (true != this.zzA.zzh()) {
            j = 0;
        }
        this.zzF = false;
        long j2 = this.zzJ;
        this.zzJ = j;
        if (zzZ()) {
            this.zzK = j;
            return j;
        }
        if (this.zzD == 7 || !(this.zzN || this.zzl.zzl())) {
            this.zzL = false;
            this.zzK = j;
            this.zzN = false;
            this.zzG = false;
            zzzsVar = this.zzl;
            if (zzzsVar.zzl()) {
                zzzsVar.zzh();
                for (zzwr zzwrVar : this.zzt) {
                    zzwrVar.zzq(false);
                }
                break;
            }
            for (zzwr zzwrVar2 : this.zzt) {
                zzwrVar2.zzk();
            }
            zzzsVar.zzg();
            break;
        }
        int length = this.zzt.length;
        for (int i2 = 0; i2 < length; i2++) {
            zzwr zzwrVar3 = this.zzt[i2];
            if (zzwrVar3.zzb() != 0 || j2 != j) {
                if (!(this.zzy ? zzwrVar3.zzz(zzwrVar3.zza()) : zzwrVar3.zzA(j, false)) && (zArr[i2] || !this.zzx)) {
                    this.zzL = false;
                    this.zzK = j;
                    this.zzN = false;
                    this.zzG = false;
                    zzzsVar = this.zzl;
                    if (zzzsVar.zzl()) {
                        zzzsVar.zzh();
                        while (i < r2) {
                            zzwrVar.zzq(false);
                        }
                        break;
                        break;
                    }
                    while (i < r3) {
                        zzwrVar2.zzk();
                    }
                    zzzsVar.zzg();
                    break;
                }
            }
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zzf(zzyp[] zzypVarArr, boolean[] zArr, zzws[] zzwsVarArr, boolean[] zArr2, long j) {
        zzyp zzypVar;
        zzU();
        zzwd zzwdVar = this.zzz;
        zzxd zzxdVar = zzwdVar.zza;
        boolean[] zArr3 = zzwdVar.zzc;
        int i = this.zzH;
        int i2 = 0;
        for (int i3 = 0; i3 < zzypVarArr.length; i3++) {
            zzws zzwsVar = zzwsVarArr[i3];
            if (zzwsVar != null && (zzypVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((zzwb) zzwsVar).zzb;
                zzdc.zzf(zArr3[i4]);
                this.zzH--;
                zArr3[i4] = false;
                zzwsVarArr[i3] = null;
            }
        }
        boolean z = !this.zzE ? j == 0 || this.zzy : i != 0;
        for (int i5 = 0; i5 < zzypVarArr.length; i5++) {
            if (zzwsVarArr[i5] == null && (zzypVar = zzypVarArr[i5]) != null) {
                zzdc.zzf(zzypVar.zzd() == 1);
                zzdc.zzf(zzypVar.zza(0) == 0);
                int iZza = zzxdVar.zza(zzypVar.zzg());
                zzdc.zzf(!zArr3[iZza]);
                this.zzH++;
                zArr3[iZza] = true;
                this.zzG = zzypVar.zzf().zzu | this.zzG;
                zzwsVarArr[i5] = new zzwb(this, iZza);
                zArr2[i5] = true;
                if (!z) {
                    zzwr zzwrVar = this.zzt[iZza];
                    z = (zzwrVar.zzb() == 0 || zzwrVar.zzA(j, true)) ? false : true;
                }
            }
        }
        if (this.zzH == 0) {
            this.zzL = false;
            this.zzF = false;
            this.zzG = false;
            zzzs zzzsVar = this.zzl;
            if (zzzsVar.zzl()) {
                zzwr[] zzwrVarArr = this.zzt;
                int length = zzwrVarArr.length;
                while (i2 < length) {
                    zzwrVarArr[i2].zzk();
                    i2++;
                }
                zzzsVar.zzg();
            } else {
                this.zzN = false;
                for (zzwr zzwrVar2 : this.zzt) {
                    zzwrVar2.zzq(false);
                }
            }
        } else if (z) {
            j = zze(j);
            while (i2 < zzwsVarArr.length) {
                if (zzwsVarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.zzE = true;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final zzxd zzg() {
        zzU();
        return this.zzz.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzh(long j, boolean z) {
        if (this.zzy) {
            return;
        }
        zzU();
        if (zzZ()) {
            return;
        }
        boolean[] zArr = this.zzz.zzc;
        int length = this.zzt.length;
        for (int i = 0; i < length; i++) {
            this.zzt[i].zzj(j, false, zArr[i]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzi() throws IOException {
        zzH();
        if (this.zzN && !this.zzw) {
            throw zzaz.zza("Loading finished before preparation is complete.", null);
        }
    }

    final int zzj(int i, zzkp zzkpVar, zzhn zzhnVar, int i2) {
        if (zzaa()) {
            return -3;
        }
        zzW(i);
        int iZze = this.zzt[i].zze(zzkpVar, zzhnVar, i2, this.zzN);
        if (iZze == -3) {
            zzX(i);
        }
        return iZze;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzk(zzuv zzuvVar, long j) {
        this.zzr = zzuvVar;
        this.zzn.zze();
        zzY();
    }

    final int zzl(int i, long j) {
        if (zzaa()) {
            return 0;
        }
        zzW(i);
        zzwr zzwrVar = this.zzt[i];
        int iZzc = zzwrVar.zzc(j, this.zzN);
        zzwrVar.zzw(iZzc);
        if (iZzc != 0) {
            return iZzc;
        }
        zzX(i);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final void zzm(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final boolean zzo(zzku zzkuVar) {
        if (this.zzN) {
            return false;
        }
        zzzs zzzsVar = this.zzl;
        if (zzzsVar.zzk() || this.zzL) {
            return false;
        }
        if (this.zzw && this.zzH == 0) {
            return false;
        }
        boolean zZze = this.zzn.zze();
        if (zzzsVar.zzl()) {
            return zZze;
        }
        zzY();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final boolean zzp() {
        return this.zzl.zzl() && this.zzn.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final /* bridge */ /* synthetic */ zzzl zzu(zzzn zzznVar, long j, long j2, IOException iOException, int i) {
        long jMin;
        zzzl zzzlVarZzb;
        zzaeb zzaebVar;
        zzvz zzvzVar = (zzvz) zzznVar;
        zzhd zzhdVar = zzvzVar.zzd;
        zzup zzupVar = new zzup(zzvzVar.zzb, zzvzVar.zzl, zzhdVar.zzh(), zzhdVar.zzi(), j, j2, zzhdVar.zzg());
        long unused = zzvzVar.zzk;
        int i2 = zzeu.zza;
        if ((iOException instanceof zzaz) || (iOException instanceof FileNotFoundException) || (iOException instanceof zzgu) || (iOException instanceof zzzq)) {
            jMin = -9223372036854775807L;
            break;
        }
        Throwable cause = iOException;
        while (true) {
            if (cause == null) {
                jMin = Math.min((i - 1) * 1000, 5000);
                break;
            }
            if ((cause instanceof zzgf) && ((zzgf) cause).zza == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
            cause = cause.getCause();
        }
        if (jMin == -9223372036854775807L) {
            zzzlVarZzb = zzzs.zzb;
        } else {
            int iZzR = zzR();
            boolean z = iZzR > this.zzM;
            if (this.zzI || !((zzaebVar = this.zzA) == null || zzaebVar.zza() == -9223372036854775807L)) {
                this.zzM = iZzR;
            } else {
                boolean z2 = this.zzw;
                if (!z2 || zzaa()) {
                    this.zzF = z2;
                    this.zzJ = 0L;
                    this.zzM = 0;
                    for (zzwr zzwrVar : this.zzt) {
                        zzwrVar.zzq(false);
                    }
                    zzvz.zzf(zzvzVar, 0L, 0L);
                } else {
                    this.zzL = true;
                    zzzlVarZzb = zzzs.zza;
                }
            }
            zzzlVarZzb = zzzs.zzb(z, jMin);
        }
        boolean zZzc = zzzlVarZzb.zzc();
        this.zzg.zzg(zzupVar, new zzuu(1, -1, null, 0, null, zzeu.zzv(zzvzVar.zzk), zzeu.zzv(this.zzB)), iOException, !zZzc);
        if (!zZzc) {
            long unused2 = zzvzVar.zzb;
        }
        return zzzlVarZzb;
    }

    final zzaei zzv() {
        return zzT(new zzwc(0, true));
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final zzaei zzw(int i, int i2) {
        return zzT(new zzwc(i, false));
    }

    public static /* synthetic */ void zzA(zzwe zzweVar) {
        if (zzweVar.zzO) {
            return;
        }
        zzuv zzuvVar = zzweVar.zzr;
        zzuvVar.getClass();
        zzuvVar.zzj(zzweVar);
    }

    public static /* synthetic */ void zzC(zzwe zzweVar, zzaeb zzaebVar) {
        zzweVar.zzA = zzweVar.zzs == null ? zzaebVar : new zzaea(-9223372036854775807L, 0L);
        zzweVar.zzB = zzaebVar.zza();
        boolean z = false;
        if (!zzweVar.zzI && zzaebVar.zza() == -9223372036854775807L) {
            z = true;
        }
        zzweVar.zzC = z;
        zzweVar.zzD = true == z ? 7 : 1;
        if (zzweVar.zzw) {
            zzweVar.zzi.zza(zzweVar.zzB, zzaebVar, z);
        } else {
            zzweVar.zzV();
        }
    }
}
