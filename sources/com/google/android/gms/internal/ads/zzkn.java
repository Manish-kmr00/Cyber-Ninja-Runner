package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzkn implements Handler.Callback, zzuv, zzyu, zzlk, zzif, zzlo, zzhv {
    private static final long zza = zzeu.zzv(10000);
    private zzlm zzA;
    private zzkk zzB;
    private boolean zzC;
    private boolean zzE;
    private boolean zzF;
    private boolean zzH;
    private boolean zzK;
    private int zzL;
    private zzkl zzM;
    private long zzN;
    private long zzO;
    private int zzP;
    private boolean zzQ;
    private zzii zzR;
    private zzis zzT;
    private boolean zzV;
    private final zzje zzX;
    private final zzib zzY;
    private final zzlz[] zzb;
    private final zzlx[] zzc;
    private final boolean[] zzd;
    private final zzyv zze;
    private final zzyw zzf;
    private final zzkr zzg;
    private final zzzd zzh;
    private final zzdq zzi;
    private final zzln zzj;
    private final Looper zzk;
    private final zzbk zzl;
    private final zzbj zzm;
    private final long zzn;
    private final zzig zzo;
    private final ArrayList zzp;
    private final zzdg zzq;
    private final zzkz zzr;
    private final zzll zzs;
    private final long zzt;
    private final zzoz zzu;
    private final zzmg zzv;
    private final zzdq zzw;
    private final boolean zzx;
    private final zzhw zzy;
    private zzma zzz;
    private long zzU = -9223372036854775807L;
    private int zzI = 0;
    private boolean zzJ = false;
    private boolean zzD = false;
    private float zzW = 1.0f;
    private long zzS = -9223372036854775807L;
    private long zzG = -9223372036854775807L;

    public zzkn(Context context, zzlu[] zzluVarArr, zzlu[] zzluVarArr2, zzyv zzyvVar, zzyw zzywVar, zzkr zzkrVar, zzzd zzzdVar, int i, boolean z, zzmg zzmgVar, zzma zzmaVar, zzib zzibVar, long j, boolean z2, boolean z3, Looper looper, zzdg zzdgVar, zzje zzjeVar, zzoz zzozVar, zzln zzlnVar, zzis zzisVar) {
        this.zzX = zzjeVar;
        this.zze = zzyvVar;
        this.zzf = zzywVar;
        this.zzg = zzkrVar;
        this.zzh = zzzdVar;
        int i2 = 0;
        this.zzz = zzmaVar;
        this.zzY = zzibVar;
        this.zzt = j;
        this.zzq = zzdgVar;
        this.zzu = zzozVar;
        this.zzT = zzisVar;
        this.zzv = zzmgVar;
        this.zzn = zzkrVar.zzb(zzozVar);
        zzkrVar.zzg(zzozVar);
        zzbl zzblVar = zzbl.zza;
        this.zzA = zzlm.zzh(zzywVar);
        this.zzB = new zzkk(this.zzA);
        int length = zzluVarArr.length;
        this.zzc = new zzlx[2];
        this.zzd = new boolean[2];
        zzlw zzlwVarZze = zzyvVar.zze();
        this.zzb = new zzlz[2];
        boolean z4 = false;
        while (true) {
            int length2 = zzluVarArr.length;
            if (i2 >= 2) {
                this.zzx = z4;
                this.zzo = new zzig(this, zzdgVar);
                this.zzp = new ArrayList();
                this.zzl = new zzbk();
                this.zzm = new zzbj();
                zzyvVar.zzr(this, zzzdVar);
                this.zzQ = true;
                zzdq zzdqVarZzd = zzdgVar.zzd(looper, null);
                this.zzw = zzdqVarZzd;
                this.zzr = new zzkz(zzmgVar, zzdqVarZzd, new zzkd(this), zzisVar);
                this.zzs = new zzll(this, zzmgVar, zzdqVarZzd, zzozVar);
                zzln zzlnVar2 = new zzln(null);
                this.zzj = zzlnVar2;
                Looper looperZza = zzlnVar2.zza();
                this.zzk = looperZza;
                this.zzi = zzdgVar.zzd(looperZza, this);
                this.zzy = new zzhw(context, looperZza, this);
                return;
            }
            zzluVarArr[i2].zzv(i2, zzozVar, zzdgVar);
            this.zzc[i2] = zzluVarArr[i2].zzm();
            this.zzc[i2].zzL(zzlwVarZze);
            zzlu zzluVar = zzluVarArr2[i2];
            if (zzluVar != null) {
                zzluVar.zzv(i2, zzozVar, zzdgVar);
                z4 = true;
            }
            this.zzb[i2] = new zzlz(zzluVarArr[i2], zzluVarArr2[i2], i2);
            i2++;
        }
    }

    private final long zzA(long j) {
        zzkw zzkwVarZzi = this.zzr.zzi();
        if (zzkwVarZzi == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.zzN - zzkwVarZzi.zze()));
    }

    private final long zzB(zzuy zzuyVar, long j, boolean z) throws zzii {
        zzkz zzkzVar = this.zzr;
        return zzC(zzuyVar, j, zzkzVar.zzj() != zzkzVar.zzn(), z);
    }

    private final long zzC(zzuy zzuyVar, long j, boolean z, boolean z2) throws zzii {
        zzak();
        zzas(false, true);
        if (z2 || this.zzA.zze == 3) {
            zzag(2);
        }
        zzkz zzkzVar = this.zzr;
        zzkw zzkwVarZzj = zzkzVar.zzj();
        zzkw zzkwVarZzg = zzkwVarZzj;
        while (zzkwVarZzg != null && !zzuyVar.equals(zzkwVarZzg.zzg.zza)) {
            zzkwVarZzg = zzkwVarZzg.zzg();
        }
        if (z || zzkwVarZzj != zzkwVarZzg || (zzkwVarZzg != null && zzkwVarZzg.zze() + j < 0)) {
            zzH();
            if (zzkwVarZzg != null) {
                while (zzkzVar.zzj() != zzkwVarZzg) {
                    zzkzVar.zze();
                }
                zzkzVar.zza(zzkwVarZzg);
                zzkwVarZzg.zzq(1000000000000L);
                zzK();
                zzkwVarZzg.zzh = true;
            }
        }
        zzG();
        if (zzkwVarZzg != null) {
            zzkzVar.zza(zzkwVarZzg);
            if (!zzkwVarZzg.zze) {
                zzkwVarZzg.zzg = zzkwVarZzg.zzg.zzb(j);
            } else if (zzkwVarZzg.zzf) {
                zzuw zzuwVar = zzkwVarZzg.zza;
                j = zzuwVar.zze(j);
                zzuwVar.zzh(j - this.zzn, false);
            }
            zzaa(j);
            zzR();
        } else {
            zzkzVar.zzs();
            zzaa(j);
        }
        zzN(false);
        this.zzi.zzj(2);
        return j;
    }

    private final Pair zzD(zzbl zzblVar) {
        long j = 0;
        if (zzblVar.zzo()) {
            return Pair.create(zzlm.zzi(), 0L);
        }
        int iZzg = zzblVar.zzg(this.zzJ);
        zzbk zzbkVar = this.zzl;
        zzbj zzbjVar = this.zzm;
        Pair pairZzl = zzblVar.zzl(zzbkVar, zzbjVar, iZzg, -9223372036854775807L);
        zzuy zzuyVarZzq = this.zzr.zzq(zzblVar, pairZzl.first, 0L);
        long jLongValue = ((Long) pairZzl.second).longValue();
        if (zzuyVarZzq.zzb()) {
            zzblVar.zzn(zzuyVarZzq.zza, zzbjVar);
            if (zzuyVarZzq.zzc == zzbjVar.zze(zzuyVarZzq.zzb)) {
                zzbjVar.zzh();
            }
        } else {
            j = jLongValue;
        }
        return Pair.create(zzuyVarZzq, Long.valueOf(j));
    }

    private static Pair zzE(zzbl zzblVar, zzkl zzklVar, boolean z, int i, boolean z2, zzbk zzbkVar, zzbj zzbjVar) {
        zzbl zzblVar2 = zzklVar.zza;
        if (zzblVar.zzo()) {
            return null;
        }
        zzbl zzblVar3 = true == zzblVar2.zzo() ? zzblVar : zzblVar2;
        try {
            Pair pairZzl = zzblVar3.zzl(zzbkVar, zzbjVar, zzklVar.zzb, zzklVar.zzc);
            if (zzblVar.equals(zzblVar3)) {
                return pairZzl;
            }
            if (zzblVar.zza(pairZzl.first) != -1) {
                return (zzblVar3.zzn(pairZzl.first, zzbjVar).zzf && zzblVar3.zze(zzbjVar.zzc, zzbkVar, 0L).zzn == zzblVar3.zza(pairZzl.first)) ? zzblVar.zzl(zzbkVar, zzbjVar, zzblVar.zzn(pairZzl.first, zzbjVar).zzc, zzklVar.zzc) : pairZzl;
            }
            int iZzd = zzd(zzbkVar, zzbjVar, i, z2, pairZzl.first, zzblVar3, zzblVar);
            if (iZzd != -1) {
                return zzblVar.zzl(zzbkVar, zzbjVar, iZzd, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    private final zzlm zzF(zzuy zzuyVar, long j, long j2, long j3, boolean z, int i) {
        List listZzn;
        zzxd zzxdVar;
        zzyw zzywVar;
        int i2 = 0;
        this.zzQ = (!this.zzQ && j == this.zzA.zzs && zzuyVar.equals(this.zzA.zzb)) ? false : true;
        zzZ();
        zzlm zzlmVar = this.zzA;
        zzxd zzxdVar2 = zzlmVar.zzh;
        zzyw zzywVar2 = zzlmVar.zzi;
        List list = zzlmVar.zzj;
        if (this.zzs.zzj()) {
            zzkz zzkzVar = this.zzr;
            zzkw zzkwVarZzj = zzkzVar.zzj();
            zzxd zzxdVarZzh = zzkwVarZzj == null ? zzxd.zza : zzkwVarZzj.zzh();
            zzyw zzywVarZzi = zzkwVarZzj == null ? this.zzf : zzkwVarZzj.zzi();
            zzyp[] zzypVarArr = zzywVarZzi.zzc;
            zzfwt zzfwtVar = new zzfwt();
            boolean z2 = false;
            for (zzyp zzypVar : zzypVarArr) {
                if (zzypVar != null) {
                    zzav zzavVar = zzypVar.zze(0).zzl;
                    if (zzavVar == null) {
                        zzfwtVar.zzf(new zzav(-9223372036854775807L, new zzau[0]));
                    } else {
                        zzfwtVar.zzf(zzavVar);
                        z2 = true;
                    }
                }
            }
            zzfww zzfwwVarZzi = z2 ? zzfwtVar.zzi() : zzfww.zzn();
            if (zzkwVarZzj != null) {
                zzkx zzkxVar = zzkwVarZzj.zzg;
                if (zzkxVar.zzc != j2) {
                    zzkwVarZzj.zzg = zzkxVar.zza(j2);
                }
            }
            zzkw zzkwVarZzj2 = zzkzVar.zzj();
            if (zzkwVarZzj2 != null) {
                zzyw zzywVarZzi2 = zzkwVarZzj2.zzi();
                while (true) {
                    zzlz[] zzlzVarArr = this.zzb;
                    if (i2 >= 2) {
                        break;
                    }
                    if (zzywVarZzi2.zzb(i2)) {
                        if (zzlzVarArr[i2].zzb() != 1) {
                            break;
                        }
                        int i3 = zzywVarZzi2.zzb[i2].zzb;
                    }
                    i2++;
                }
            }
            listZzn = zzfwwVarZzi;
            zzxdVar = zzxdVarZzh;
            zzywVar = zzywVarZzi;
        } else if (zzuyVar.equals(this.zzA.zzb)) {
            listZzn = list;
            zzxdVar = zzxdVar2;
            zzywVar = zzywVar2;
        } else {
            zzywVar = this.zzf;
            zzxdVar = zzxd.zza;
            listZzn = zzfww.zzn();
        }
        if (z) {
            this.zzB.zzc(i);
        }
        return this.zzA.zzc(zzuyVar, j, j2, j3, zzz(), zzxdVar, zzywVar, listZzn);
    }

    private final void zzG() {
        if (this.zzx && zzau()) {
            zzlz[] zzlzVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                zzlz zzlzVar = zzlzVarArr[i];
                int iZza = zzlzVar.zza();
                zzlzVar.zzf(this.zzo);
                this.zzL -= iZza - zzlzVar.zza();
            }
            this.zzU = -9223372036854775807L;
        }
    }

    private final void zzH() throws zzii {
        int i = 0;
        while (true) {
            zzlz[] zzlzVarArr = this.zzb;
            if (i >= 2) {
                this.zzU = -9223372036854775807L;
                return;
            }
            int iZza = zzlzVarArr[i].zza();
            zzlzVarArr[i].zze(this.zzo);
            zzV(i, false);
            this.zzL -= iZza;
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:188:0x0345  */
    /* JADX WARN: Code duplicated, block: B:257:0x047c  */
    /* JADX WARN: Code duplicated, block: B:259:0x0483  */
    /* JADX WARN: Code duplicated, block: B:261:0x0487  */
    /* JADX WARN: Code duplicated, block: B:262:0x048d  */
    /* JADX WARN: Code duplicated, block: B:264:0x0491  */
    /* JADX WARN: Code duplicated, block: B:266:0x0495  */
    /* JADX WARN: Code duplicated, block: B:268:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:269:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:275:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:281:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:286:0x0526  */
    /* JADX WARN: Code duplicated, block: B:288:0x0533  */
    /* JADX WARN: Code duplicated, block: B:289:0x0540  */
    /* JADX WARN: Code duplicated, block: B:291:0x0547  */
    /* JADX WARN: Code duplicated, block: B:307:0x0587  */
    /* JADX WARN: Code duplicated, block: B:333:0x05ea  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v105 */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r0v55, types: [int] */
    /* JADX WARN: Type inference failed for: r0v59, types: [com.google.android.gms.internal.ads.zzlz] */
    /* JADX WARN: Type inference failed for: r14v9, types: [com.google.android.gms.internal.ads.zzyw] */
    /* JADX WARN: Type inference failed for: r15v4, types: [com.google.android.gms.internal.ads.zzlz[]] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29, types: [com.google.android.gms.internal.ads.zzlz] */
    /* JADX WARN: Type inference failed for: r38v0, types: [com.google.android.gms.internal.ads.zzkn, com.google.android.gms.internal.ads.zzuv] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.google.android.gms.internal.ads.zzlz] */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31, types: [int] */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r5v11, types: [com.google.android.gms.internal.ads.zzlz] */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [int] */
    private final void zzI() throws zzii, IOException {
        boolean z;
        boolean z2;
        boolean z3;
        zzlm zzlmVar;
        boolean z4;
        zzkw zzkwVarZzj;
        long jZzb;
        zzkw zzkwVarZzi;
        boolean z5;
        boolean z6;
        boolean zZzj;
        zzkw zzkwVarZzj2;
        zzkw zzkwVarZzg;
        boolean z7;
        ?? r15;
        int i;
        int i2;
        boolean z8;
        zzkw zzkwVarZzm;
        zzkx zzkxVarZzo;
        zzdq zzdqVar = this.zzi;
        long jUptimeMillis = SystemClock.uptimeMillis();
        zzdqVar.zzg(2);
        long j = -9223372036854775807L;
        boolean z9 = false;
        if (!this.zzA.zza.zzo() && this.zzs.zzj()) {
            zzkz zzkzVar = this.zzr;
            zzkzVar.zzu(this.zzN);
            if (zzkzVar.zzA() && (zzkxVarZzo = zzkzVar.zzo(this.zzN, this.zzA)) != null) {
                zzkw zzkwVarZzh = zzkzVar.zzh(zzkxVarZzo);
                if (!zzkwVarZzh.zzd) {
                    zzkwVarZzh.zzm(this, zzkxVarZzo.zzb);
                } else if (zzkwVarZzh.zze) {
                    zzdqVar.zzc(8, zzkwVarZzh.zza).zza();
                }
                if (zzkzVar.zzj() == zzkwVarZzh) {
                    zzaa(zzkxVarZzo.zzb);
                }
                zzN(false);
            }
            if (this.zzH) {
                this.zzH = zzaz(zzkzVar.zzi());
                zzal();
            } else {
                zzR();
            }
            if (!this.zzE && this.zzx && !this.zzV && !zzau() && (zzkwVarZzm = zzkzVar.zzm()) != null && zzkwVarZzm == zzkzVar.zzn() && zzkwVarZzm.zzg() != null && zzkwVarZzm.zzg().zze) {
                zzkzVar.zzf();
                zzkw zzkwVarZzm2 = zzkzVar.zzm();
                if (zzkwVarZzm2 != null) {
                    zzyw zzywVarZzi = zzkwVarZzm2.zzi();
                    int i3 = 0;
                    while (true) {
                        zzlz[] zzlzVarArr = this.zzb;
                        if (i3 >= 2) {
                            break;
                        }
                        if (zzywVarZzi.zzb(i3) && zzlzVarArr[i3].zzD() && !zzlzVarArr[i3].zzF()) {
                            zzlzVarArr[i3].zzy();
                            zzJ(zzkwVarZzm2, i3, false, zzkwVarZzm2.zzf());
                        }
                        i3++;
                        zzkwVarZzm2 = zzkwVarZzm2;
                        zzywVarZzi = zzywVarZzi;
                    }
                    zzkw zzkwVar = zzkwVarZzm2;
                    if (zzau()) {
                        this.zzU = zzkwVar.zza.zzd();
                        if (!zzkwVar.zzs()) {
                            zzkzVar.zza(zzkwVar);
                            zzN(false);
                            zzR();
                        }
                    }
                }
            }
            zzkw zzkwVarZzn = zzkzVar.zzn();
            if (zzkwVarZzn != null) {
                if (zzkwVarZzn.zzg() != null && !this.zzE) {
                    zzkw zzkwVarZzn2 = zzkzVar.zzn();
                    if (zzkwVarZzn2.zze) {
                        int i4 = 0;
                        while (true) {
                            zzlz[] zzlzVarArr2 = this.zzb;
                            if (i4 >= 2) {
                                if ((zzau() && zzkzVar.zzm() == zzkzVar.zzn()) || (!zzkwVarZzn.zzg().zze && this.zzN < zzkwVarZzn.zzg().zzf())) {
                                    break;
                                    break;
                                }
                                zzyw zzywVarZzi2 = zzkwVarZzn.zzi();
                                zzkw zzkwVarZzg2 = zzkzVar.zzg();
                                zzyw zzywVarZzi3 = zzkwVarZzg2.zzi();
                                zzbl zzblVar = this.zzA.zza;
                                zzkzVar = zzkzVar;
                                zzar(zzblVar, zzkwVarZzg2.zzg.zza, zzblVar, zzkwVarZzn.zzg.zza, -9223372036854775807L, false);
                                if (zzkwVarZzg2.zze && (((z8 = this.zzx) && this.zzU != -9223372036854775807L) || zzkwVarZzg2.zza.zzd() != -9223372036854775807L)) {
                                    this.zzU = -9223372036854775807L;
                                    if (z8 && !this.zzV) {
                                        int i5 = 2;
                                        int i6 = 0;
                                        while (true) {
                                            if (i6 < i5) {
                                                if (zzywVarZzi3.zzb(i6)) {
                                                    zzyp[] zzypVarArr = zzywVarZzi3.zzc;
                                                    if (zzay.zzf(zzypVarArr[i6].zzf().zzo, zzypVarArr[i6].zzf().zzk) || zzlzVarArr2[i6].zzF()) {
                                                    }
                                                }
                                                i6++;
                                                i5 = 2;
                                            } else {
                                                i2 = i5;
                                                i = 0;
                                                z9 = false;
                                            }
                                        }
                                    }
                                    long jZzf = zzkwVarZzg2.zzf();
                                    int i7 = 0;
                                    for (int i8 = 2; i7 < i8; i8 = 2) {
                                        zzlzVarArr2[i7].zzr(jZzf);
                                        i7++;
                                    }
                                    zzkzVar = zzkzVar;
                                    if (!zzkwVarZzg2.zzs()) {
                                        zzkzVar.zza(zzkwVarZzg2);
                                        z9 = false;
                                        zzN(false);
                                        zzR();
                                        break;
                                    }
                                    z9 = false;
                                    break;
                                }
                                z9 = false;
                                i = 0;
                                i2 = 2;
                                while (i < i2) {
                                    zzlzVarArr2[i].zzl(zzywVarZzi2, zzywVarZzi3, zzkwVarZzg2.zzf());
                                    i++;
                                    i2 = 2;
                                }
                                break;
                            }
                            if (!zzlzVarArr2[i4].zzB(zzkwVarZzn2)) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                    }
                } else if (zzkwVarZzn.zzg.zzj || this.zzE) {
                    zzlz[] zzlzVarArr3 = this.zzb;
                    for (int i9 = 0; i9 < 2; i9++) {
                        zzlz zzlzVar = zzlzVarArr3[i9];
                        if (zzlzVar.zzH(zzkwVarZzn) && zzlzVar.zzC(zzkwVarZzn)) {
                            long j2 = zzkwVarZzn.zzg.zze;
                            zzlzVar.zzs(zzkwVarZzn, (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? -9223372036854775807L : zzkwVarZzn.zze() + j2);
                        }
                    }
                }
            }
            zzkw zzkwVarZzn3 = zzkzVar.zzn();
            if (zzkwVarZzn3 != null && zzkzVar.zzj() != zzkwVarZzn3 && !zzkwVarZzn3.zzh) {
                zzkw zzkwVarZzn4 = zzkzVar.zzn();
                ?? Zzi = zzkwVarZzn4.zzi();
                ?? r0 = z9;
                int i10 = 1;
                while (true) {
                    r15 = this.zzb;
                    if (r0 >= 2) {
                        break;
                    }
                    int iZza = r15[r0].zza();
                    int iZzc = r15[r0].zzc(zzkwVarZzn4, Zzi, this.zzo);
                    this.zzL -= iZza - r15[r0].zza();
                    i10 &= iZzc & 1;
                    r0++;
                }
                if (i10 != 0) {
                    ?? r4 = z9;
                    while (r4 < 2) {
                        if (Zzi.zzb(r4) && !r15[r4].zzH(zzkwVarZzn4)) {
                            zzJ(zzkwVarZzn4, r4 == true ? 1 : 0, false, zzkwVarZzn4.zzf());
                        }
                        r4++;
                    }
                    zzkzVar.zzn().zzh = true;
                }
            }
            boolean z10 = z9;
            while (zzax() && !this.zzE && (zzkwVarZzj2 = zzkzVar.zzj()) != null && (zzkwVarZzg = zzkwVarZzj2.zzg()) != null && this.zzN >= zzkwVarZzg.zzf() && zzkwVarZzg.zzh) {
                if (z10) {
                    zzT();
                }
                this.zzV = z9;
                zzkw zzkwVarZze = zzkzVar.zze();
                zzkwVarZze.getClass();
                if (this.zzA.zzb.zza.equals(zzkwVarZze.zzg.zza.zza)) {
                    zzuy zzuyVar = this.zzA.zzb;
                    if (zzuyVar.zzb == -1) {
                        zzuy zzuyVar2 = zzkwVarZze.zzg.zza;
                        if (zzuyVar2.zzb != -1 || zzuyVar.zze == zzuyVar2.zze) {
                            z7 = z9;
                        } else {
                            z7 = true;
                        }
                    } else {
                        z7 = z9;
                    }
                } else {
                    z7 = z9;
                }
                zzkx zzkxVar = zzkwVarZze.zzg;
                zzuy zzuyVar3 = zzkxVar.zza;
                long j3 = zzkxVar.zzb;
                zzkz zzkzVar2 = zzkzVar;
                long j4 = j;
                this.zzA = zzF(zzuyVar3, j3, zzkxVar.zzc, j3, !z7, 0);
                zzZ();
                zzaq();
                if (zzau() && zzkwVarZze == zzkzVar2.zzm()) {
                    zzlz[] zzlzVarArr4 = this.zzb;
                    int i11 = 0;
                    for (int i12 = 2; i11 < i12; i12 = 2) {
                        zzlzVarArr4[i11].zzk();
                        i11++;
                    }
                }
                if (this.zzA.zze == 3) {
                    zzai();
                }
                zzyw zzywVarZzi4 = zzkzVar2.zzj().zzi();
                int i13 = 0;
                while (true) {
                    zzlz[] zzlzVarArr5 = this.zzb;
                    if (i13 < 2) {
                        if (zzywVarZzi4.zzb(i13)) {
                            zzlzVarArr5[i13].zzh();
                        }
                        i13++;
                    }
                }
                j = j4;
                zzkzVar = zzkzVar2;
                z10 = true;
                z9 = false;
            }
            long j5 = this.zzT.zzb;
        }
        int i14 = this.zzA.zze;
        if (i14 == 1 || i14 == 4) {
            return;
        }
        zzkz zzkzVar3 = this.zzr;
        zzkw zzkwVarZzj3 = zzkzVar3.zzj();
        if (zzkwVarZzj3 == null) {
            zzac(jUptimeMillis);
            return;
        }
        Trace.beginSection("doSomeWork");
        zzaq();
        if (zzkwVarZzj3.zze) {
            this.zzO = zzeu.zzs(SystemClock.elapsedRealtime());
            z = false;
            zzkwVarZzj3.zza.zzh(this.zzA.zzs - this.zzn, false);
            boolean z11 = true;
            z3 = true;
            int i15 = 0;
            while (true) {
                zzlz[] zzlzVarArr6 = this.zzb;
                if (i15 >= 2) {
                    break;
                }
                zzlz zzlzVar2 = zzlzVarArr6[i15];
                if (zzlzVar2.zza() == 0) {
                    zzV(i15, false);
                } else {
                    zzlzVar2.zzo(this.zzN, this.zzO);
                    boolean z12 = z11 && zzlzVar2.zzE();
                    boolean zZzA = zzlzVar2.zzA(zzkwVarZzj3);
                    zzV(i15, zZzA);
                    boolean z13 = z3 && zZzA;
                    if (!zZzA) {
                        zzU(i15);
                    }
                    z3 = z13;
                    z11 = z12;
                }
                i15++;
            }
            z2 = z11;
        } else {
            z = false;
            zzkwVarZzj3.zza.zzi();
            z2 = true;
            z3 = true;
        }
        long j6 = zzkwVarZzj3.zzg.zze;
        if (z2 && zzkwVarZzj3.zze && (j6 == -9223372036854775807L || j6 <= this.zzA.zzs)) {
            if (this.zzE) {
                this.zzE = z;
                zzaf(z, this.zzA.zzn, z, 5);
            }
            if (zzkwVarZzj3.zzg.zzj) {
                zzag(4);
                zzak();
                z4 = z;
            } else {
                zzlmVar = this.zzA;
                if (zzlmVar.zze != 2) {
                    if (this.zzL == 0) {
                        zZzj = zzav();
                    } else if (z3) {
                        if (zzlmVar.zzg) {
                            zzkwVarZzj = zzkzVar3.zzj();
                            if (zzay(this.zzA.zza, zzkwVarZzj.zzg.zza)) {
                                jZzb = this.zzY.zzb();
                            } else {
                                jZzb = -9223372036854775807L;
                            }
                            zzkwVarZzi = zzkzVar3.zzi();
                            if (zzkwVarZzi.zzs()) {
                                z5 = z;
                            } else {
                                z5 = z;
                            }
                            if (zzkwVarZzi.zzg.zza.zzb()) {
                                z6 = z;
                            } else {
                                z6 = z;
                            }
                            if (z5) {
                            }
                        }
                        zzag(3);
                        this.zzR = null;
                        if (zzax()) {
                            zzas(false, false);
                            this.zzo.zzh();
                            zzai();
                        }
                        z4 = false;
                    } else if (this.zzA.zze == 3) {
                        z4 = false;
                    } else {
                        z4 = false;
                    }
                    if (zZzj) {
                        zzag(3);
                        this.zzR = null;
                        if (zzax()) {
                            zzas(false, false);
                            this.zzo.zzh();
                            zzai();
                        }
                    } else if (this.zzA.zze == 3) {
                    }
                    z4 = false;
                } else if (this.zzA.zze == 3) {
                    z4 = false;
                } else {
                    z4 = false;
                }
            }
        } else {
            zzlmVar = this.zzA;
            if (zzlmVar.zze != 2) {
                if (this.zzL == 0) {
                    zZzj = zzav();
                } else if (z3) {
                    if (zzlmVar.zzg) {
                        zzkwVarZzj = zzkzVar3.zzj();
                        if (zzay(this.zzA.zza, zzkwVarZzj.zzg.zza)) {
                            jZzb = this.zzY.zzb();
                        } else {
                            jZzb = -9223372036854775807L;
                        }
                        zzkwVarZzi = zzkzVar3.zzi();
                        if (zzkwVarZzi.zzs() || !zzkwVarZzi.zzg.zzj) {
                            z5 = z;
                        } else {
                            z5 = true;
                        }
                        if (zzkwVarZzi.zzg.zza.zzb() || zzkwVarZzi.zze) {
                            z6 = z;
                        } else {
                            z6 = true;
                        }
                        if (z5 && !z6) {
                            zZzj = this.zzg.zzj(new zzkq(this.zzu, this.zzA.zza, zzkwVarZzj.zzg.zza, this.zzN - zzkwVarZzj.zze(), zzA(zzkwVarZzi.zzc()), this.zzo.zzc().zzb, this.zzA.zzl, this.zzF, jZzb, this.zzG));
                        }
                        z4 = false;
                    }
                    zzag(3);
                    this.zzR = null;
                    if (zzax()) {
                        zzas(false, false);
                        this.zzo.zzh();
                        zzai();
                    }
                    z4 = false;
                } else if (this.zzA.zze == 3) {
                    z4 = false;
                } else {
                    z4 = false;
                }
                if (zZzj) {
                    zzag(3);
                    this.zzR = null;
                    if (zzax()) {
                        zzas(false, false);
                        this.zzo.zzh();
                        zzai();
                    }
                } else if (this.zzA.zze == 3) {
                }
                z4 = false;
            } else if (this.zzA.zze == 3 || (this.zzL != 0 ? z3 : zzav())) {
                z4 = false;
            } else {
                z4 = false;
                zzas(zzax(), false);
                zzag(2);
                if (this.zzF) {
                    for (zzkw zzkwVarZzj4 = zzkzVar3.zzj(); zzkwVarZzj4 != null; zzkwVarZzj4 = zzkwVarZzj4.zzg()) {
                        for (zzyp zzypVar : zzkwVarZzj4.zzi().zzc) {
                        }
                    }
                    this.zzY.zzc();
                }
                zzak();
            }
        }
        char c = 2;
        if (this.zzA.zze == 2) {
            ?? r7 = z4;
            while (true) {
                zzlz[] zzlzVarArr7 = this.zzb;
                if (r7 >= c) {
                    break;
                }
                if (zzlzVarArr7[r7].zzH(zzkwVarZzj3)) {
                    zzU(r7);
                }
                c = 2;
                r7++;
            }
            zzlm zzlmVar2 = this.zzA;
            if (zzlmVar2.zzg || zzlmVar2.zzr >= 500000 || !zzaz(zzkzVar3.zzi()) || !zzax()) {
                this.zzS = -9223372036854775807L;
            } else if (this.zzS == -9223372036854775807L) {
                this.zzS = SystemClock.elapsedRealtime();
            } else if (SystemClock.elapsedRealtime() - this.zzS >= 4000) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        } else {
            this.zzS = -9223372036854775807L;
        }
        boolean z14 = (zzax() && this.zzA.zze == 3) ? true : z4;
        boolean z15 = this.zzA.zzp;
        int i16 = this.zzA.zze;
        if (i16 != 4 && (z14 || i16 == 2 || (i16 == 3 && this.zzL != 0))) {
            zzac(jUptimeMillis);
        }
        Trace.endSection();
    }

    private final void zzJ(zzkw zzkwVar, int i, boolean z, long j) throws zzii {
        zzlz zzlzVar = this.zzb[i];
        if (zzlzVar.zzI()) {
            return;
        }
        boolean z2 = zzkwVar == this.zzr.zzj();
        zzyw zzywVarZzi = zzkwVar.zzi();
        zzly zzlyVar = zzywVarZzi.zzb[i];
        zzyp zzypVar = zzywVarZzi.zzc[i];
        boolean z3 = zzax() && this.zzA.zze == 3;
        boolean z4 = !z && z3;
        this.zzL++;
        zzlzVar.zzg(zzlyVar, zzypVar, zzkwVar.zzc[i], this.zzN, z4, z2, j, zzkwVar.zze(), zzkwVar.zzg.zza, this.zzo);
        zzlzVar.zzi(11, new zzkg(this), zzkwVar);
        if (z3 && z2) {
            zzlzVar.zzx();
        }
    }

    private final void zzK() throws zzii {
        zzL(new boolean[2], this.zzr.zzn().zzf());
    }

    private final void zzL(boolean[] zArr, long j) throws zzii {
        zzlz[] zzlzVarArr;
        zzkw zzkwVarZzn = this.zzr.zzn();
        zzyw zzywVarZzi = zzkwVarZzn.zzi();
        int i = 0;
        while (true) {
            zzlzVarArr = this.zzb;
            if (i >= 2) {
                break;
            }
            if (!zzywVarZzi.zzb(i)) {
                zzlzVarArr[i].zzp();
            }
            i++;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            if (zzywVarZzi.zzb(i2) && !zzlzVarArr[i2].zzH(zzkwVarZzn)) {
                zzJ(zzkwVarZzn, i2, zArr[i2], j);
            }
        }
    }

    private final void zzM(IOException iOException, int i) {
        zzkz zzkzVar = this.zzr;
        zzii zziiVarZzc = zzii.zzc(iOException, i);
        zzkw zzkwVarZzj = zzkzVar.zzj();
        if (zzkwVarZzj != null) {
            zziiVarZzc = zziiVarZzc.zza(zzkwVarZzj.zzg.zza);
        }
        zzdx.zzd("ExoPlayerImplInternal", "Playback error", zziiVarZzc);
        zzaj(false, false);
        this.zzA = this.zzA.zze(zziiVarZzc);
    }

    private final void zzN(boolean z) {
        zzkw zzkwVarZzi = this.zzr.zzi();
        zzuy zzuyVar = zzkwVarZzi == null ? this.zzA.zzb : zzkwVarZzi.zzg.zza;
        boolean zEquals = this.zzA.zzk.equals(zzuyVar);
        if (!zEquals) {
            this.zzA = this.zzA.zzb(zzuyVar);
        }
        zzlm zzlmVar = this.zzA;
        zzlmVar.zzq = zzkwVarZzi == null ? zzlmVar.zzs : zzkwVarZzi.zzc();
        this.zzA.zzr = zzz();
        if ((!zEquals || z) && zzkwVarZzi != null && zzkwVarZzi.zze) {
            zzam(zzkwVarZzi.zzg.zza, zzkwVarZzi.zzh(), zzkwVarZzi.zzi());
        }
    }

    /* JADX WARN: Code duplicated, block: B:198:0x0367  */
    /* JADX WARN: Code duplicated, block: B:199:0x036d  */
    /* JADX WARN: Code duplicated, block: B:202:0x037f  */
    /* JADX WARN: Code duplicated, block: B:206:0x038a  */
    /* JADX WARN: Code duplicated, block: B:208:0x0394 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:214:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:218:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:222:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:50:0x0145  */
    /* JADX WARN: Code duplicated, block: B:51:0x0162  */
    /* JADX WARN: Code duplicated, block: B:54:0x016e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0174 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:59:0x0179  */
    /* JADX WARN: Code duplicated, block: B:63:0x0182  */
    /* JADX WARN: Code duplicated, block: B:69:0x0192  */
    /* JADX WARN: Code duplicated, block: B:72:0x0199  */
    /* JADX WARN: Code duplicated, block: B:79:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:82:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:86:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:89:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:91:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:92:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:94:0x01df  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v66 */
    /* JADX WARN: Type inference failed for: r1v67, types: [int] */
    /* JADX WARN: Type inference failed for: r1v80 */
    private final void zzO(zzbl zzblVar, boolean z) throws Throwable {
        zzuy zzuyVar;
        zzbj zzbjVar;
        zzbk zzbkVar;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        int iZzg;
        boolean z5;
        long jLongValue;
        zzuy zzuyVarZzq;
        int i3;
        zzuy zzuyVar2;
        boolean z6;
        zzbj zzbjVarZzn;
        boolean z7;
        zzuy zzuyVarZzi;
        long jZzB;
        boolean z8;
        boolean z9;
        long j;
        int iZzg2;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i4;
        boolean z14;
        int i5;
        Object obj;
        long j2;
        Object obj2;
        zzlm zzlmVar = this.zzA;
        zzkl zzklVar = this.zzM;
        int i6 = this.zzI;
        boolean z15 = this.zzJ;
        boolean z16 = false;
        if (zzblVar.zzo()) {
            zzuyVarZzi = zzlm.zzi();
            z9 = false;
            j = -9223372036854775807L;
            z8 = true;
            z7 = true;
            jZzB = 0;
        } else {
            zzbj zzbjVar2 = this.zzm;
            zzuy zzuyVar3 = zzlmVar.zzb;
            Object obj3 = zzuyVar3.zza;
            boolean zZzaw = zzaw(zzlmVar, zzbjVar2);
            long jLongValue2 = (zzuyVar3.zzb() || zZzaw) ? zzlmVar.zzc : zzlmVar.zzs;
            zzbk zzbkVar2 = this.zzl;
            if (zzklVar != null) {
                zzuyVar = zzuyVar3;
                Pair pairZzE = zzE(zzblVar, zzklVar, true, i6, z15, zzbkVar2, zzbjVar2);
                if (pairZzE == null) {
                    iZzg2 = zzblVar.zzg(z15);
                    obj3 = obj3;
                    jLongValue2 = jLongValue2;
                    zzbjVar = zzbjVar2;
                    z13 = true;
                    z11 = false;
                    z12 = false;
                } else {
                    if (zzklVar.zzc == -9223372036854775807L) {
                        zzbjVar = zzbjVar2;
                        iZzg2 = zzblVar.zzn(pairZzE.first, zzbjVar).zzc;
                        obj3 = obj3;
                        jLongValue2 = jLongValue2;
                        z10 = false;
                    } else {
                        zzbjVar = zzbjVar2;
                        obj3 = pairZzE.first;
                        jLongValue2 = ((Long) pairZzE.second).longValue();
                        iZzg2 = -1;
                        z10 = true;
                    }
                    z11 = zzlmVar.zze == 4;
                    z12 = z10;
                    z13 = false;
                }
                z3 = z13;
                z4 = z12;
                zzbkVar = zzbkVar2;
                i2 = iZzg2;
                z2 = z11;
            } else {
                zzuyVar = zzuyVar3;
                zzbjVar = zzbjVar2;
                zzbkVar = zzbkVar2;
                zzbl zzblVar2 = zzlmVar.zza;
                if (zzblVar2.zzo()) {
                    iZzg = zzblVar.zzg(z15);
                } else {
                    if (zzblVar.zza(obj3) == -1) {
                        int iZzd = zzd(zzbkVar, zzbjVar, i6, z15, obj3, zzblVar2, zzblVar);
                        if (iZzd == -1) {
                            iZzd = zzblVar.zzg(z15);
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        z3 = z5;
                        obj3 = obj3;
                        zzbkVar = zzbkVar;
                        jLongValue2 = jLongValue2;
                        z2 = false;
                        z4 = false;
                        i2 = iZzd;
                    } else if (jLongValue2 == -9223372036854775807L) {
                        iZzg = zzblVar.zzn(obj3, zzbjVar).zzc;
                    } else if (zZzaw) {
                        zzblVar2.zzn(obj3, zzbjVar);
                        zzbkVar = zzbkVar;
                        if (zzblVar2.zze(zzbjVar.zzc, zzbkVar, 0L).zzn == zzblVar2.zza(obj3)) {
                            Pair pairZzl = zzblVar.zzl(zzbkVar, zzbjVar, zzblVar.zzn(obj3, zzbjVar).zzc, jLongValue2);
                            obj3 = pairZzl.first;
                            jLongValue2 = ((Long) pairZzl.second).longValue();
                        } else {
                            obj3 = obj3;
                            jLongValue2 = jLongValue2;
                        }
                        i = -1;
                        i2 = -1;
                        z2 = false;
                        z3 = false;
                        z4 = true;
                    } else {
                        i = -1;
                        i2 = -1;
                        z2 = false;
                        z3 = false;
                        z4 = false;
                    }
                    if (i2 != i) {
                        Pair pairZzl2 = zzblVar.zzl(zzbkVar, zzbjVar, i2, -9223372036854775807L);
                        obj3 = pairZzl2.first;
                        jLongValue = ((Long) pairZzl2.second).longValue();
                        jLongValue2 = -9223372036854775807L;
                    } else {
                        jLongValue = jLongValue2;
                    }
                    zzuyVarZzq = this.zzr.zzq(zzblVar, obj3, jLongValue);
                    i3 = zzuyVarZzq.zze;
                    if (i3 != -1) {
                        zzuyVar2 = zzuyVar;
                        int i7 = zzuyVar2.zze;
                        boolean z17 = i7 == -1 && i3 >= i7;
                        if (obj3.equals(obj3) || zzuyVar2.zzb() || zzuyVarZzq.zzb() || !z17) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        zzbjVarZzn = zzblVar.zzn(obj3, zzbjVar);
                        if (!zZzaw && jLongValue2 == jLongValue2 && obj3.equals(zzuyVarZzq.zza)) {
                            if (zzuyVar2.zzb()) {
                                zzbjVarZzn.zzk(zzuyVar2.zzb);
                            }
                            if (zzuyVarZzq.zzb()) {
                                zzbjVarZzn.zzk(zzuyVarZzq.zzb);
                            }
                        }
                        z7 = true;
                        if (true == z6) {
                            zzuyVarZzq = zzuyVar2;
                        }
                        if (zzuyVarZzq.zzb()) {
                            if (zzuyVarZzq.equals(zzuyVar2)) {
                                jLongValue = zzlmVar.zzs;
                            } else {
                                zzblVar.zzn(zzuyVarZzq.zza, zzbjVar);
                                if (zzuyVarZzq.zzc == zzbjVar.zze(zzuyVarZzq.zzb)) {
                                    zzbjVar.zzh();
                                }
                                jLongValue = 0;
                            }
                        }
                        zzuyVarZzi = zzuyVarZzq;
                        jZzB = jLongValue;
                        z8 = z3;
                        z9 = z4;
                        long j3 = jLongValue2;
                        z16 = z2;
                        j = j3;
                    } else {
                        zzuyVar2 = zzuyVar;
                    }
                    if (obj3.equals(obj3)) {
                        z6 = false;
                    } else {
                        z6 = false;
                    }
                    zzbjVarZzn = zzblVar.zzn(obj3, zzbjVar);
                    if (!zZzaw) {
                        if (zzuyVar2.zzb()) {
                            zzbjVarZzn.zzk(zzuyVar2.zzb);
                        }
                        if (zzuyVarZzq.zzb()) {
                            zzbjVarZzn.zzk(zzuyVarZzq.zzb);
                        }
                    }
                    z7 = true;
                    if (true == z6) {
                        zzuyVarZzq = zzuyVar2;
                    }
                    if (zzuyVarZzq.zzb()) {
                        if (zzuyVarZzq.equals(zzuyVar2)) {
                            jLongValue = zzlmVar.zzs;
                        } else {
                            zzblVar.zzn(zzuyVarZzq.zza, zzbjVar);
                            if (zzuyVarZzq.zzc == zzbjVar.zze(zzuyVarZzq.zzb)) {
                                zzbjVar.zzh();
                            }
                            jLongValue = 0;
                        }
                    }
                    zzuyVarZzi = zzuyVarZzq;
                    jZzB = jLongValue;
                    z8 = z3;
                    z9 = z4;
                    long j4 = jLongValue2;
                    z16 = z2;
                    j = j4;
                }
                i2 = iZzg;
                i = -1;
                z2 = false;
                z3 = false;
                z4 = false;
                if (i2 != i) {
                    Pair pairZzl3 = zzblVar.zzl(zzbkVar, zzbjVar, i2, -9223372036854775807L);
                    obj3 = pairZzl3.first;
                    jLongValue = ((Long) pairZzl3.second).longValue();
                    jLongValue2 = -9223372036854775807L;
                } else {
                    jLongValue = jLongValue2;
                }
                zzuyVarZzq = this.zzr.zzq(zzblVar, obj3, jLongValue);
                i3 = zzuyVarZzq.zze;
                if (i3 != -1) {
                    zzuyVar2 = zzuyVar;
                    int i8 = zzuyVar2.zze;
                    if (i8 == -1) {
                    }
                    if (obj3.equals(obj3)) {
                        z6 = false;
                    } else {
                        z6 = false;
                    }
                    zzbjVarZzn = zzblVar.zzn(obj3, zzbjVar);
                    if (!zZzaw) {
                        if (zzuyVar2.zzb()) {
                            zzbjVarZzn.zzk(zzuyVar2.zzb);
                        }
                        if (zzuyVarZzq.zzb()) {
                            zzbjVarZzn.zzk(zzuyVarZzq.zzb);
                        }
                    }
                    z7 = true;
                    if (true == z6) {
                        zzuyVarZzq = zzuyVar2;
                    }
                    if (zzuyVarZzq.zzb()) {
                        if (zzuyVarZzq.equals(zzuyVar2)) {
                            jLongValue = zzlmVar.zzs;
                        } else {
                            zzblVar.zzn(zzuyVarZzq.zza, zzbjVar);
                            if (zzuyVarZzq.zzc == zzbjVar.zze(zzuyVarZzq.zzb)) {
                                zzbjVar.zzh();
                            }
                            jLongValue = 0;
                        }
                    }
                    zzuyVarZzi = zzuyVarZzq;
                    jZzB = jLongValue;
                    z8 = z3;
                    z9 = z4;
                    long j5 = jLongValue2;
                    z16 = z2;
                    j = j5;
                } else {
                    zzuyVar2 = zzuyVar;
                }
                if (obj3.equals(obj3)) {
                    z6 = false;
                } else {
                    z6 = false;
                }
                zzbjVarZzn = zzblVar.zzn(obj3, zzbjVar);
                if (!zZzaw) {
                    if (zzuyVar2.zzb()) {
                        zzbjVarZzn.zzk(zzuyVar2.zzb);
                    }
                    if (zzuyVarZzq.zzb()) {
                        zzbjVarZzn.zzk(zzuyVarZzq.zzb);
                    }
                }
                z7 = true;
                if (true == z6) {
                    zzuyVarZzq = zzuyVar2;
                }
                if (zzuyVarZzq.zzb()) {
                    if (zzuyVarZzq.equals(zzuyVar2)) {
                        jLongValue = zzlmVar.zzs;
                    } else {
                        zzblVar.zzn(zzuyVarZzq.zza, zzbjVar);
                        if (zzuyVarZzq.zzc == zzbjVar.zze(zzuyVarZzq.zzb)) {
                            zzbjVar.zzh();
                        }
                        jLongValue = 0;
                    }
                }
                zzuyVarZzi = zzuyVarZzq;
                jZzB = jLongValue;
                z8 = z3;
                z9 = z4;
                long j6 = jLongValue2;
                z16 = z2;
                j = j6;
            }
            i = -1;
            if (i2 != i) {
                Pair pairZzl4 = zzblVar.zzl(zzbkVar, zzbjVar, i2, -9223372036854775807L);
                obj3 = pairZzl4.first;
                jLongValue = ((Long) pairZzl4.second).longValue();
                jLongValue2 = -9223372036854775807L;
            } else {
                jLongValue = jLongValue2;
            }
            zzuyVarZzq = this.zzr.zzq(zzblVar, obj3, jLongValue);
            i3 = zzuyVarZzq.zze;
            if (i3 != -1) {
                zzuyVar2 = zzuyVar;
                int i9 = zzuyVar2.zze;
                if (i9 == -1) {
                }
                if (obj3.equals(obj3)) {
                    z6 = false;
                } else {
                    z6 = false;
                }
                zzbjVarZzn = zzblVar.zzn(obj3, zzbjVar);
                if (!zZzaw) {
                    if (zzuyVar2.zzb()) {
                        zzbjVarZzn.zzk(zzuyVar2.zzb);
                    }
                    if (zzuyVarZzq.zzb()) {
                        zzbjVarZzn.zzk(zzuyVarZzq.zzb);
                    }
                }
                z7 = true;
                if (true == z6) {
                    zzuyVarZzq = zzuyVar2;
                }
                if (zzuyVarZzq.zzb()) {
                    if (zzuyVarZzq.equals(zzuyVar2)) {
                        jLongValue = zzlmVar.zzs;
                    } else {
                        zzblVar.zzn(zzuyVarZzq.zza, zzbjVar);
                        if (zzuyVarZzq.zzc == zzbjVar.zze(zzuyVarZzq.zzb)) {
                            zzbjVar.zzh();
                        }
                        jLongValue = 0;
                    }
                }
                zzuyVarZzi = zzuyVarZzq;
                jZzB = jLongValue;
                z8 = z3;
                z9 = z4;
                long j7 = jLongValue2;
                z16 = z2;
                j = j7;
            } else {
                zzuyVar2 = zzuyVar;
            }
            if (obj3.equals(obj3)) {
                z6 = false;
            } else {
                z6 = false;
            }
            zzbjVarZzn = zzblVar.zzn(obj3, zzbjVar);
            if (!zZzaw) {
                if (zzuyVar2.zzb()) {
                    zzbjVarZzn.zzk(zzuyVar2.zzb);
                }
                if (zzuyVarZzq.zzb()) {
                    zzbjVarZzn.zzk(zzuyVarZzq.zzb);
                }
            }
            z7 = true;
            if (true == z6) {
                zzuyVarZzq = zzuyVar2;
            }
            if (zzuyVarZzq.zzb()) {
                if (zzuyVarZzq.equals(zzuyVar2)) {
                    jLongValue = zzlmVar.zzs;
                } else {
                    zzblVar.zzn(zzuyVarZzq.zza, zzbjVar);
                    if (zzuyVarZzq.zzc == zzbjVar.zze(zzuyVarZzq.zzb)) {
                        zzbjVar.zzh();
                    }
                    jLongValue = 0;
                }
            }
            zzuyVarZzi = zzuyVarZzq;
            jZzB = jLongValue;
            z8 = z3;
            z9 = z4;
            long j8 = jLongValue2;
            z16 = z2;
            j = j8;
        }
        boolean z18 = (this.zzA.zzb.equals(zzuyVarZzi) && jZzB == this.zzA.zzs) ? false : z7;
        int i10 = 2;
        if (z8) {
            try {
                if (this.zzA.zze != z7) {
                    i4 = 4;
                    try {
                        zzag(4);
                    } catch (Throwable th) {
                        th = th;
                        i5 = 4;
                        obj = null;
                        zzlm zzlmVar2 = this.zzA;
                        zzbl zzblVar3 = zzlmVar2.zza;
                        zzuy zzuyVar4 = zzlmVar2.zzb;
                        if (true != z9) {
                            j2 = -9223372036854775807L;
                        } else {
                            j2 = jZzB;
                        }
                        zzar(zzblVar, zzuyVarZzi, zzblVar3, zzuyVar4, j2, false);
                        if (z18) {
                            zzlm zzlmVar3 = this.zzA;
                            obj2 = zzlmVar3.zzb.zza;
                            zzbl zzblVar4 = zzlmVar3.zza;
                            if (z18) {
                            }
                            long j9 = this.zzA.zzd;
                            if (zzblVar.zza(obj2) != -1) {
                                i5 = 3;
                            }
                            this.zzA = zzF(zzuyVarZzi, jZzB, j, j9, z, i5);
                        } else {
                            zzlm zzlmVar4 = this.zzA;
                            obj2 = zzlmVar4.zzb.zza;
                            zzbl zzblVar5 = zzlmVar4.zza;
                            if (z18) {
                            }
                            long j10 = this.zzA.zzd;
                            if (zzblVar.zza(obj2) != -1) {
                                i5 = 3;
                            }
                            this.zzA = zzF(zzuyVarZzi, jZzB, j, j10, z, i5);
                        }
                        zzZ();
                        zzab(zzblVar, this.zzA.zza);
                        this.zzA = this.zzA.zzg(zzblVar);
                        if (!zzblVar.zzo()) {
                            this.zzM = obj;
                        }
                        zzN(false);
                        this.zzi.zzj(2);
                        throw th;
                    }
                } else {
                    i4 = 4;
                }
                z14 = false;
                try {
                    zzY(false, false, false, z7);
                } catch (Throwable th2) {
                    th = th2;
                    i5 = i4;
                    obj = null;
                    zzlm zzlmVar5 = this.zzA;
                    zzbl zzblVar6 = zzlmVar5.zza;
                    zzuy zzuyVar5 = zzlmVar5.zzb;
                    if (true != z9) {
                        j2 = -9223372036854775807L;
                    } else {
                        j2 = jZzB;
                    }
                    zzar(zzblVar, zzuyVarZzi, zzblVar6, zzuyVar5, j2, false);
                    if (z18) {
                        zzlm zzlmVar6 = this.zzA;
                        obj2 = zzlmVar6.zzb.zza;
                        zzbl zzblVar7 = zzlmVar6.zza;
                        if (z18) {
                        }
                        long j11 = this.zzA.zzd;
                        if (zzblVar.zza(obj2) != -1) {
                            i5 = 3;
                        }
                        this.zzA = zzF(zzuyVarZzi, jZzB, j, j11, z, i5);
                    } else {
                        zzlm zzlmVar7 = this.zzA;
                        obj2 = zzlmVar7.zzb.zza;
                        zzbl zzblVar8 = zzlmVar7.zza;
                        if (z18) {
                        }
                        long j12 = this.zzA.zzd;
                        if (zzblVar.zza(obj2) != -1) {
                            i5 = 3;
                        }
                        this.zzA = zzF(zzuyVarZzi, jZzB, j, j12, z, i5);
                    }
                    zzZ();
                    zzab(zzblVar, this.zzA.zza);
                    this.zzA = this.zzA.zzg(zzblVar);
                    if (!zzblVar.zzo()) {
                        this.zzM = obj;
                    }
                    zzN(false);
                    this.zzi.zzj(2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                i4 = 4;
                i5 = i4;
                obj = null;
                zzlm zzlmVar8 = this.zzA;
                zzbl zzblVar9 = zzlmVar8.zza;
                zzuy zzuyVar6 = zzlmVar8.zzb;
                if (true != z9) {
                    j2 = -9223372036854775807L;
                } else {
                    j2 = jZzB;
                }
                zzar(zzblVar, zzuyVarZzi, zzblVar9, zzuyVar6, j2, false);
                if (z18) {
                    zzlm zzlmVar9 = this.zzA;
                    obj2 = zzlmVar9.zzb.zza;
                    zzbl zzblVar10 = zzlmVar9.zza;
                    if (z18) {
                    }
                    long j13 = this.zzA.zzd;
                    if (zzblVar.zza(obj2) != -1) {
                        i5 = 3;
                    }
                    this.zzA = zzF(zzuyVarZzi, jZzB, j, j13, z, i5);
                } else {
                    zzlm zzlmVar10 = this.zzA;
                    obj2 = zzlmVar10.zzb.zza;
                    zzbl zzblVar11 = zzlmVar10.zza;
                    if (z18) {
                    }
                    long j14 = this.zzA.zzd;
                    if (zzblVar.zza(obj2) != -1) {
                        i5 = 3;
                    }
                    this.zzA = zzF(zzuyVarZzi, jZzB, j, j14, z, i5);
                }
                zzZ();
                zzab(zzblVar, this.zzA.zza);
                this.zzA = this.zzA.zzg(zzblVar);
                if (!zzblVar.zzo()) {
                    this.zzM = obj;
                }
                zzN(false);
                this.zzi.zzj(2);
                throw th;
            }
        } else {
            i4 = 4;
            z14 = false;
        }
        zzlz[] zzlzVarArr = this.zzb;
        for (?? r1 = z14; r1 < 2; r1++) {
            zzlzVarArr[r1].zzu(zzblVar);
        }
        try {
            if (z18) {
                i5 = i4;
                z7 = z14;
                if (!zzblVar.zzo()) {
                    zzkz zzkzVar = this.zzr;
                    for (zzkw zzkwVarZzj = zzkzVar.zzj(); zzkwVarZzj != null; zzkwVarZzj = zzkwVarZzj.zzg()) {
                        if (zzkwVarZzj.zzg.zza.equals(zzuyVarZzi)) {
                            zzkwVarZzj.zzg = zzkzVar.zzp(zzblVar, zzkwVarZzj.zzg);
                            zzkwVarZzj.zzr();
                        }
                    }
                    jZzB = zzB(zzuyVarZzi, jZzB, z16);
                }
            } else {
                try {
                    zzkz zzkzVar2 = this.zzr;
                    i5 = i4;
                    z7 = z14;
                    try {
                        int iZzb = zzkzVar2.zzb(zzblVar, this.zzN, zzkzVar2.zzn() == null ? 0L : zzy(zzkzVar2.zzn()), (!zzau() || zzkzVar2.zzm() == null) ? 0L : zzy(zzkzVar2.zzm()));
                        if ((iZzb & 1) != 0) {
                            try {
                                zzad(z7);
                                i10 = 2;
                            } catch (Throwable th4) {
                                th = th4;
                                obj = null;
                                zzlm zzlmVar11 = this.zzA;
                                zzbl zzblVar12 = zzlmVar11.zza;
                                zzuy zzuyVar7 = zzlmVar11.zzb;
                                if (true != z9) {
                                    j2 = -9223372036854775807L;
                                } else {
                                    j2 = jZzB;
                                }
                                zzar(zzblVar, zzuyVarZzi, zzblVar12, zzuyVar7, j2, false);
                                if (z18) {
                                    zzlm zzlmVar12 = this.zzA;
                                    obj2 = zzlmVar12.zzb.zza;
                                    zzbl zzblVar13 = zzlmVar12.zza;
                                    if (z18) {
                                    }
                                    long j15 = this.zzA.zzd;
                                    if (zzblVar.zza(obj2) != -1) {
                                        i5 = 3;
                                    }
                                    this.zzA = zzF(zzuyVarZzi, jZzB, j, j15, z, i5);
                                } else {
                                    zzlm zzlmVar13 = this.zzA;
                                    obj2 = zzlmVar13.zzb.zza;
                                    zzbl zzblVar14 = zzlmVar13.zza;
                                    if (z18) {
                                    }
                                    long j16 = this.zzA.zzd;
                                    if (zzblVar.zza(obj2) != -1) {
                                        i5 = 3;
                                    }
                                    this.zzA = zzF(zzuyVarZzi, jZzB, j, j16, z, i5);
                                }
                                zzZ();
                                zzab(zzblVar, this.zzA.zza);
                                this.zzA = this.zzA.zzg(zzblVar);
                                if (!zzblVar.zzo()) {
                                    this.zzM = obj;
                                }
                                zzN(false);
                                this.zzi.zzj(2);
                                throw th;
                            }
                        } else {
                            i10 = 2;
                            if ((iZzb & 2) != 0) {
                                zzG();
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        obj = null;
                        zzlm zzlmVar14 = this.zzA;
                        zzbl zzblVar15 = zzlmVar14.zza;
                        zzuy zzuyVar8 = zzlmVar14.zzb;
                        if (true != z9) {
                            j2 = -9223372036854775807L;
                        } else {
                            j2 = jZzB;
                        }
                        zzar(zzblVar, zzuyVarZzi, zzblVar15, zzuyVar8, j2, false);
                        if (z18 || j != this.zzA.zzc) {
                            zzlm zzlmVar15 = this.zzA;
                            obj2 = zzlmVar15.zzb.zza;
                            zzbl zzblVar16 = zzlmVar15.zza;
                            boolean z19 = (z18 || !z || zzblVar16.zzo() || zzblVar16.zzn(obj2, this.zzm).zzf) ? false : true;
                            long j17 = this.zzA.zzd;
                            if (zzblVar.zza(obj2) != -1) {
                                i5 = 3;
                            }
                            this.zzA = zzF(zzuyVarZzi, jZzB, j, j17, z19, i5);
                        }
                        zzZ();
                        zzab(zzblVar, this.zzA.zza);
                        this.zzA = this.zzA.zzg(zzblVar);
                        if (!zzblVar.zzo()) {
                            this.zzM = obj;
                        }
                        zzN(false);
                        this.zzi.zzj(2);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    i5 = i4;
                }
            }
            zzlm zzlmVar16 = this.zzA;
            zzbl zzblVar17 = zzlmVar16.zza;
            zzuy zzuyVar9 = zzlmVar16.zzb;
            long j18 = true != z9 ? -9223372036854775807L : jZzB;
            int i11 = i10;
            zzar(zzblVar, zzuyVarZzi, zzblVar17, zzuyVar9, j18, false);
            if (z18 || j != this.zzA.zzc) {
                zzlm zzlmVar17 = this.zzA;
                Object obj4 = zzlmVar17.zzb.zza;
                zzbl zzblVar18 = zzlmVar17.zza;
                boolean z20 = (!z18 || !z || zzblVar18.zzo() || zzblVar18.zzn(obj4, this.zzm).zzf) ? z7 : true;
                long j19 = this.zzA.zzd;
                if (zzblVar.zza(obj4) != -1) {
                    i5 = 3;
                }
                this.zzA = zzF(zzuyVarZzi, jZzB, j, j19, z20, i5);
            }
            zzZ();
            zzab(zzblVar, this.zzA.zza);
            this.zzA = this.zzA.zzg(zzblVar);
            if (!zzblVar.zzo()) {
                this.zzM = null;
            }
            zzN(z7);
            this.zzi.zzj(i11);
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private final void zzP(zzbb zzbbVar, boolean z) throws zzii {
        zzQ(zzbbVar, zzbbVar.zzb, true, z);
    }

    private final void zzQ(zzbb zzbbVar, float f, boolean z, boolean z2) throws zzii {
        int i;
        if (z) {
            if (z2) {
                this.zzB.zza(1);
            }
            zzlm zzlmVar = this.zzA;
            zzbl zzblVar = zzlmVar.zza;
            zzuy zzuyVar = zzlmVar.zzb;
            long j = zzlmVar.zzc;
            long j2 = zzlmVar.zzd;
            int i2 = zzlmVar.zze;
            zzii zziiVar = zzlmVar.zzf;
            boolean z3 = zzlmVar.zzg;
            zzxd zzxdVar = zzlmVar.zzh;
            zzyw zzywVar = zzlmVar.zzi;
            List list = zzlmVar.zzj;
            zzuy zzuyVar2 = zzlmVar.zzk;
            boolean z4 = zzlmVar.zzl;
            int i3 = zzlmVar.zzm;
            int i4 = zzlmVar.zzn;
            long j3 = zzlmVar.zzq;
            long j4 = zzlmVar.zzr;
            long j5 = zzlmVar.zzs;
            long j6 = zzlmVar.zzt;
            boolean z5 = zzlmVar.zzp;
            this.zzA = new zzlm(zzblVar, zzuyVar, j, j2, i2, zziiVar, z3, zzxdVar, zzywVar, list, zzuyVar2, z4, i3, i4, zzbbVar, j3, j4, j5, j6, false);
        }
        float f2 = zzbbVar.zzb;
        zzkw zzkwVarZzj = this.zzr.zzj();
        while (true) {
            i = 0;
            if (zzkwVarZzj == null) {
                break;
            }
            zzyp[] zzypVarArr = zzkwVarZzj.zzi().zzc;
            int length = zzypVarArr.length;
            while (i < length) {
                zzyp zzypVar = zzypVarArr[i];
                i++;
            }
            zzkwVarZzj = zzkwVarZzj.zzg();
        }
        zzlz[] zzlzVarArr = this.zzb;
        while (i < 2) {
            zzlzVarArr[i].zzt(f, f2);
            i++;
        }
    }

    private final void zzR() {
        long jZze;
        long jZze2;
        zzkz zzkzVar;
        boolean zZzh;
        zzkz zzkzVar2 = this.zzr;
        if (zzaz(zzkzVar2.zzi())) {
            zzkw zzkwVarZzi = zzkzVar2.zzi();
            long jZzA = zzA(zzkwVarZzi.zzd());
            if (zzkwVarZzi == zzkzVar2.zzj()) {
                jZze = this.zzN;
                jZze2 = zzkwVarZzi.zze();
            } else {
                jZze = this.zzN - zzkwVarZzi.zze();
                jZze2 = zzkwVarZzi.zzg.zzb;
            }
            zzkzVar = zzkzVar2;
            zzkq zzkqVar = new zzkq(this.zzu, this.zzA.zza, zzkwVarZzi.zzg.zza, jZze - jZze2, jZzA, this.zzo.zzc().zzb, this.zzA.zzl, this.zzF, zzay(this.zzA.zza, zzkwVarZzi.zzg.zza) ? this.zzY.zzb() : -9223372036854775807L, this.zzG);
            zzkr zzkrVar = this.zzg;
            zZzh = zzkrVar.zzh(zzkqVar);
            zzkw zzkwVarZzj = zzkzVar.zzj();
            if (!zZzh && zzkwVarZzj.zze && jZzA < 500000 && this.zzn > 0) {
                zzkwVarZzj.zza.zzh(this.zzA.zzs, false);
                zZzh = zzkrVar.zzh(zzkqVar);
            }
        } else {
            zzkzVar = zzkzVar2;
            zZzh = false;
        }
        this.zzH = zZzh;
        if (zZzh) {
            zzkw zzkwVarZzi2 = zzkzVar.zzi();
            zzkwVarZzi2.getClass();
            zzks zzksVar = new zzks();
            zzksVar.zze(this.zzN - zzkwVarZzi2.zze());
            zzksVar.zzf(this.zzo.zzc().zzb);
            zzksVar.zzd(this.zzG);
            zzkwVarZzi2.zzk(new zzku(zzksVar, null));
        }
        zzal();
    }

    private final void zzS() {
        zzkz zzkzVar = this.zzr;
        zzkzVar.zzt();
        zzkw zzkwVarZzl = zzkzVar.zzl();
        if (zzkwVarZzl != null) {
            if (!zzkwVarZzl.zzd || zzkwVarZzl.zze) {
                zzuw zzuwVar = zzkwVarZzl.zza;
                if (zzuwVar.zzp()) {
                    return;
                }
                if (this.zzg.zzi(this.zzA.zza, zzkwVarZzl.zzg.zza, zzkwVarZzl.zze ? zzuwVar.zzb() : 0L)) {
                    if (!zzkwVarZzl.zzd) {
                        zzkwVarZzl.zzm(this, zzkwVarZzl.zzg.zzb);
                        return;
                    }
                    zzks zzksVar = new zzks();
                    zzksVar.zze(this.zzN - zzkwVarZzl.zze());
                    zzksVar.zzf(this.zzo.zzc().zzb);
                    zzksVar.zzd(this.zzG);
                    zzkwVarZzl.zzk(new zzku(zzksVar, null));
                }
            }
        }
    }

    private final void zzT() {
        this.zzB.zzb(this.zzA);
        if (this.zzB.zze) {
            zzje zzjeVar = this.zzX;
            zzjeVar.zza.zzaa(this.zzB);
            this.zzB = new zzkk(this.zzA);
        }
    }

    private final void zzU(int i) throws zzii, IOException {
        zzlz zzlzVar = this.zzb[i];
        try {
            zzkw zzkwVarZzj = this.zzr.zzj();
            if (zzkwVarZzj == null) {
                throw null;
            }
            zzkw zzkwVar = zzkwVarZzj;
            zzlzVar.zzm(zzkwVarZzj);
        } catch (IOException | RuntimeException e) {
            zzlzVar.zzb();
            throw e;
        }
    }

    private final void zzV(final int i, final boolean z) {
        boolean[] zArr = this.zzd;
        if (zArr[i] != z) {
            zArr[i] = z;
            this.zzw.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkc
                @Override // java.lang.Runnable
                public final void run() {
                    zzkn zzknVar = this.zza;
                    int i2 = i;
                    zzknVar.zzv.zzJ(i2, zzknVar.zzb[i2].zzb(), z);
                }
            });
        }
    }

    private final void zzW() throws zzii {
        boolean z;
        zzig zzigVar = this.zzo;
        float f = zzigVar.zzc().zzb;
        zzkz zzkzVar = this.zzr;
        zzkw zzkwVarZzj = zzkzVar.zzj();
        zzkw zzkwVarZzn = zzkzVar.zzn();
        zzyw zzywVar = null;
        boolean z2 = true;
        while (zzkwVarZzj != null && zzkwVarZzj.zze) {
            zzlm zzlmVar = this.zzA;
            zzyw zzywVarZzj = zzkwVarZzj.zzj(f, zzlmVar.zza, zzlmVar.zzl);
            zzyw zzywVar2 = zzkwVarZzj == zzkzVar.zzj() ? zzywVarZzj : zzywVar;
            zzyw zzywVarZzi = zzkwVarZzj.zzi();
            boolean z3 = false;
            if (zzywVarZzi != null) {
                zzyp[] zzypVarArr = zzywVarZzj.zzc;
                if (zzywVarZzi.zzc.length == zzypVarArr.length) {
                    int i = 0;
                    while (true) {
                        if (i >= zzypVarArr.length) {
                            if (zzkwVarZzj != zzkwVarZzn) {
                                z3 = true;
                            }
                            z2 &= z3;
                            zzkwVarZzj = zzkwVarZzj.zzg();
                            zzywVar = zzywVar2;
                        } else if (zzywVarZzj.zza(zzywVarZzi, i)) {
                            i++;
                        }
                    }
                }
            }
            int i2 = 2;
            if (z2) {
                zzkw zzkwVarZzj2 = zzkzVar.zzj();
                int iZza = zzkzVar.zza(zzkwVarZzj2) & 1;
                zzlz[] zzlzVarArr = this.zzb;
                boolean[] zArr = new boolean[2];
                zzywVar2.getClass();
                long jZzb = zzkwVarZzj2.zzb(zzywVar2, this.zzA.zzs, 1 == iZza, zArr);
                zzlm zzlmVar2 = this.zzA;
                boolean z4 = (zzlmVar2.zze == 4 || jZzb == zzlmVar2.zzs) ? false : true;
                zzlm zzlmVar3 = this.zzA;
                this.zzA = zzF(zzlmVar3.zzb, jZzb, zzlmVar3.zzc, zzlmVar3.zzd, z4, 5);
                if (z4) {
                    zzaa(jZzb);
                }
                zzG();
                i2 = 2;
                boolean[] zArr2 = new boolean[2];
                for (int i3 = 0; i3 < 2; i3++) {
                    int iZza2 = zzlzVarArr[i3].zza();
                    zArr2[i3] = zzlzVarArr[i3].zzI();
                    zzlzVarArr[i3].zzj(zzkwVarZzj2.zzc[i3], zzigVar, this.zzN, zArr[i3]);
                    if (iZza2 - zzlzVarArr[i3].zza() > 0) {
                        zzV(i3, false);
                    }
                    this.zzL -= iZza2 - zzlzVarArr[i3].zza();
                }
                zzL(zArr2, this.zzN);
                z = true;
                zzkwVarZzj2.zzh = true;
            } else {
                zzkzVar.zza(zzkwVarZzj);
                if (zzkwVarZzj.zze) {
                    long jMax = Math.max(zzkwVarZzj.zzg.zzb, this.zzN - zzkwVarZzj.zze());
                    if (this.zzx && zzau() && zzkzVar.zzm() == zzkwVarZzj) {
                        zzG();
                    }
                    zzkwVarZzj.zza(zzywVarZzj, jMax, false);
                }
                z = true;
            }
            zzN(z);
            if (this.zzA.zze != 4) {
                zzR();
                zzaq();
                this.zzi.zzj(i2);
                return;
            }
            return;
        }
    }

    private final void zzX() throws zzii {
        zzW();
        zzad(true);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008f A[PHI: r2 r7 r9
  0x008f: PHI (r2v2 com.google.android.gms.internal.ads.zzuy) = (r2v1 com.google.android.gms.internal.ads.zzuy), (r2v6 com.google.android.gms.internal.ads.zzuy) binds: [B:25:0x0067, B:27:0x008c] A[DONT_GENERATE, DONT_INLINE]
  0x008f: PHI (r7v3 long) = (r7v2 long), (r7v11 long) binds: [B:25:0x0067, B:27:0x008c] A[DONT_GENERATE, DONT_INLINE]
  0x008f: PHI (r9v2 long) = (r9v1 long), (r9v5 long) binds: [B:25:0x0067, B:27:0x008c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d6 A[PHI: r3
  0x00d6: PHI (r3v3 com.google.android.gms.internal.ads.zzbl) = 
  (r3v2 com.google.android.gms.internal.ads.zzbl)
  (r3v2 com.google.android.gms.internal.ads.zzbl)
  (r3v19 com.google.android.gms.internal.ads.zzbl)
  (r3v19 com.google.android.gms.internal.ads.zzbl)
 binds: [B:31:0x009e, B:33:0x00a2, B:35:0x00b3, B:37:0x00c9] A[DONT_GENERATE, DONT_INLINE]] */
    private final void zzY(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        zzuy zzuyVar;
        zzbl zzblVar;
        this.zzi.zzg(2);
        this.zzR = null;
        zzas(false, true);
        this.zzo.zzi();
        this.zzN = 1000000000000L;
        try {
            zzH();
        } catch (zzii | RuntimeException e) {
            zzdx.zzd("ExoPlayerImplInternal", "Disable failed.", e);
        }
        if (z) {
            zzlz[] zzlzVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                try {
                    zzlzVarArr[i].zzp();
                } catch (RuntimeException e2) {
                    zzdx.zzd("ExoPlayerImplInternal", "Reset failed.", e2);
                }
            }
        }
        this.zzL = 0;
        zzlm zzlmVar = this.zzA;
        zzuy zzuyVar2 = zzlmVar.zzb;
        long jLongValue = zzlmVar.zzs;
        long j = (this.zzA.zzb.zzb() || zzaw(this.zzA, this.zzm)) ? this.zzA.zzc : this.zzA.zzs;
        if (z2) {
            this.zzM = null;
            Pair pairZzD = zzD(this.zzA.zza);
            zzuyVar2 = (zzuy) pairZzD.first;
            jLongValue = ((Long) pairZzD.second).longValue();
            j = -9223372036854775807L;
            z5 = zzuyVar2.equals(this.zzA.zzb) ? false : true;
        }
        long j2 = jLongValue;
        long j3 = j;
        zzkz zzkzVar = this.zzr;
        zzkzVar.zzs();
        this.zzH = false;
        zzbl zzblVarZzx = this.zzA.zza;
        if (z3 && (zzblVarZzx instanceof zzls)) {
            zzblVarZzx = ((zzls) zzblVarZzx).zzx(this.zzs.zzq());
            if (zzuyVar2.zzb != -1) {
                Object obj = zzuyVar2.zza;
                zzbj zzbjVar = this.zzm;
                zzblVarZzx.zzn(obj, zzbjVar);
                zzbk zzbkVar = this.zzl;
                zzblVarZzx.zze(zzbjVar.zzc, zzbkVar, 0L);
                if (zzbkVar.zzb()) {
                    zzblVar = zzblVarZzx;
                    zzuyVar = new zzuy(obj, zzuyVar2.zzd);
                } else {
                    zzuyVar = zzuyVar2;
                    zzblVar = zzblVarZzx;
                }
            } else {
                zzuyVar = zzuyVar2;
                zzblVar = zzblVarZzx;
            }
        } else {
            zzuyVar = zzuyVar2;
            zzblVar = zzblVarZzx;
        }
        zzlm zzlmVar2 = this.zzA;
        int i2 = zzlmVar2.zze;
        zzii zziiVar = z4 ? null : zzlmVar2.zzf;
        zzxd zzxdVar = z5 ? zzxd.zza : zzlmVar2.zzh;
        zzyw zzywVar = z5 ? this.zzf : this.zzA.zzi;
        List listZzn = z5 ? zzfww.zzn() : this.zzA.zzj;
        zzlm zzlmVar3 = this.zzA;
        this.zzA = new zzlm(zzblVar, zzuyVar, j3, j2, i2, zziiVar, false, zzxdVar, zzywVar, listZzn, zzuyVar, zzlmVar3.zzl, zzlmVar3.zzm, zzlmVar3.zzn, zzlmVar3.zzo, j2, 0L, j2, 0L, false);
        if (z3) {
            zzkzVar.zzv();
            this.zzs.zzh();
        }
    }

    private final void zzZ() {
        zzkw zzkwVarZzj = this.zzr.zzj();
        boolean z = false;
        if (zzkwVarZzj != null && zzkwVarZzj.zzg.zzi && this.zzD) {
            z = true;
        }
        this.zzE = z;
    }

    private static final void zzaA(zzlq zzlqVar) throws zzii {
        zzlqVar.zzi();
        try {
            zzlqVar.zzc().zzu(zzlqVar.zza(), zzlqVar.zzg());
        } finally {
            zzlqVar.zzh(true);
        }
    }

    private final void zzaa(long j) throws zzii {
        zzkw zzkwVarZzj = this.zzr.zzj();
        long jZze = j + (zzkwVarZzj == null ? 1000000000000L : zzkwVarZzj.zze());
        this.zzN = jZze;
        this.zzo.zzf(jZze);
        zzlz[] zzlzVarArr = this.zzb;
        for (int i = 0; i < 2; i++) {
            zzlzVarArr[i].zzq(zzkwVarZzj, this.zzN);
        }
        for (zzkw zzkwVarZzj2 = r0.zzj(); zzkwVarZzj2 != null; zzkwVarZzj2 = zzkwVarZzj2.zzg()) {
            for (zzyp zzypVar : zzkwVarZzj2.zzi().zzc) {
            }
        }
    }

    private final void zzab(zzbl zzblVar, zzbl zzblVar2) {
        if (zzblVar.zzo() && zzblVar2.zzo()) {
            return;
        }
        ArrayList arrayList = this.zzp;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
            return;
        }
        zzkj zzkjVar = (zzkj) arrayList.get(size);
        Object obj = zzkjVar.zzb;
        zzlq zzlqVar = zzkjVar.zza;
        int i = zzeu.zza;
        throw null;
    }

    private final void zzac(long j) {
        this.zzi.zzk(2, j + ((this.zzA.zze != 3 || zzax()) ? zza : 1000L));
    }

    private final void zzad(boolean z) throws zzii {
        zzuy zzuyVar = this.zzr.zzj().zzg.zza;
        long jZzC = zzC(zzuyVar, this.zzA.zzs, true, false);
        if (jZzC != this.zzA.zzs) {
            zzlm zzlmVar = this.zzA;
            this.zzA = zzF(zzuyVar, jZzC, zzlmVar.zzc, zzlmVar.zzd, z, 5);
        }
    }

    private final void zzae(zzbb zzbbVar) {
        this.zzi.zzg(16);
        this.zzo.zzg(zzbbVar);
    }

    private final void zzaf(boolean z, int i, boolean z2, int i2) throws zzii {
        this.zzB.zza(z2 ? 1 : 0);
        zzao(z, i, i2);
    }

    private final void zzag(int i) {
        zzlm zzlmVar = this.zzA;
        if (zzlmVar.zze != i) {
            if (i != 2) {
                this.zzS = -9223372036854775807L;
            }
            this.zzA = zzlmVar.zzf(i);
        }
    }

    private final void zzah(float f) throws zzii {
        this.zzW = f;
        float fZza = f * this.zzy.zza();
        int i = 0;
        while (true) {
            zzlz[] zzlzVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzlzVarArr[i].zzw(fZza);
            i++;
        }
    }

    private final void zzai() throws zzii {
        zzkw zzkwVarZzj = this.zzr.zzj();
        if (zzkwVarZzj == null) {
            return;
        }
        zzyw zzywVarZzi = zzkwVarZzj.zzi();
        int i = 0;
        while (true) {
            zzlz[] zzlzVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            if (zzywVarZzi.zzb(i)) {
                zzlzVarArr[i].zzx();
            }
            i++;
        }
    }

    private final void zzaj(boolean z, boolean z2) {
        zzY(z || !this.zzK, false, true, false);
        this.zzB.zza(z2 ? 1 : 0);
        this.zzg.zze(this.zzu);
        this.zzy.zzb(this.zzA.zzl, 1);
        zzag(1);
    }

    private final void zzak() throws zzii {
        this.zzo.zzi();
        int i = 0;
        while (true) {
            zzlz[] zzlzVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzlzVarArr[i].zzz();
            i++;
        }
    }

    private final void zzal() {
        zzkw zzkwVarZzi = this.zzr.zzi();
        boolean z = true;
        if (!this.zzH && (zzkwVarZzi == null || !zzkwVarZzi.zza.zzp())) {
            z = false;
        }
        zzlm zzlmVar = this.zzA;
        if (z != zzlmVar.zzg) {
            this.zzA = zzlmVar.zza(z);
        }
    }

    private final void zzam(zzuy zzuyVar, zzxd zzxdVar, zzyw zzywVar) {
        long jZze;
        long jZze2;
        zzkz zzkzVar = this.zzr;
        zzkw zzkwVarZzi = zzkzVar.zzi();
        zzkwVarZzi.getClass();
        if (zzkwVarZzi == zzkzVar.zzj()) {
            jZze = this.zzN;
            jZze2 = zzkwVarZzi.zze();
        } else {
            jZze = this.zzN - zzkwVarZzi.zze();
            jZze2 = zzkwVarZzi.zzg.zzb;
        }
        this.zzg.zzf(new zzkq(this.zzu, this.zzA.zza, zzuyVar, jZze - jZze2, zzA(zzkwVarZzi.zzc()), this.zzo.zzc().zzb, this.zzA.zzl, this.zzF, zzay(this.zzA.zza, zzkwVarZzi.zzg.zza) ? this.zzY.zzb() : -9223372036854775807L, this.zzG), zzxdVar, zzywVar.zzc);
    }

    private final void zzan() throws zzii {
        zzlm zzlmVar = this.zzA;
        zzao(zzlmVar.zzl, zzlmVar.zzn, zzlmVar.zzm);
    }

    private final void zzao(boolean z, int i, int i2) throws zzii {
        zzap(z, this.zzy.zzb(z, this.zzA.zze), i, i2);
    }

    private final void zzap(boolean z, int i, int i2, int i3) throws zzii {
        boolean z2;
        if (!z) {
            z2 = false;
        } else if (i != -1) {
            z2 = true;
        } else {
            i = -1;
            z2 = false;
        }
        if (i == -1) {
            i3 = 2;
        } else if (i3 == 2) {
            i3 = 1;
        }
        if (i == 0) {
            i2 = 1;
        } else if (i2 == 1) {
            i2 = 0;
        }
        zzlm zzlmVar = this.zzA;
        if (zzlmVar.zzl == z2 && zzlmVar.zzn == i2 && zzlmVar.zzm == i3) {
            return;
        }
        this.zzA = zzlmVar.zzd(z2, i3, i2);
        zzas(false, false);
        zzkz zzkzVar = this.zzr;
        for (zzkw zzkwVarZzj = zzkzVar.zzj(); zzkwVarZzj != null; zzkwVarZzj = zzkwVarZzj.zzg()) {
            for (zzyp zzypVar : zzkwVarZzj.zzi().zzc) {
            }
        }
        if (!zzax()) {
            zzak();
            zzaq();
            zzkzVar.zzu(this.zzN);
            return;
        }
        int i4 = this.zzA.zze;
        if (i4 == 3) {
            this.zzo.zzh();
            zzai();
            this.zzi.zzj(2);
        } else if (i4 == 2) {
            this.zzi.zzj(2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a9, code lost:
    
        r13 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzaq() throws com.google.android.gms.internal.ads.zzii {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkn.zzaq():void");
    }

    private final void zzar(zzbl zzblVar, zzuy zzuyVar, zzbl zzblVar2, zzuy zzuyVar2, long j, boolean z) throws zzii {
        if (!zzay(zzblVar, zzuyVar)) {
            zzbb zzbbVar = zzuyVar.zzb() ? zzbb.zza : this.zzA.zzo;
            if (this.zzo.zzc().equals(zzbbVar)) {
                return;
            }
            zzae(zzbbVar);
            zzQ(this.zzA.zzo, zzbbVar.zzb, false, false);
            return;
        }
        Object obj = zzuyVar.zza;
        zzbj zzbjVar = this.zzm;
        int i = zzblVar.zzn(obj, zzbjVar).zzc;
        zzbk zzbkVar = this.zzl;
        zzblVar.zze(i, zzbkVar, 0L);
        zzib zzibVar = this.zzY;
        zzaj zzajVar = zzbkVar.zzj;
        int i2 = zzeu.zza;
        zzibVar.zzd(zzajVar);
        if (j != -9223372036854775807L) {
            zzibVar.zze(zzx(zzblVar, obj, j));
            return;
        }
        if (!Objects.equals(!zzblVar2.zzo() ? zzblVar2.zze(zzblVar2.zzn(zzuyVar2.zza, zzbjVar).zzc, zzbkVar, 0L).zzb : null, zzbkVar.zzb) || z) {
            zzibVar.zze(-9223372036854775807L);
        }
    }

    private final void zzas(boolean z, boolean z2) {
        this.zzF = z;
        long jElapsedRealtime = -9223372036854775807L;
        if (z && !z2) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        this.zzG = jElapsedRealtime;
    }

    private final synchronized void zzat(zzfuo zzfuoVar, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j;
        boolean z = false;
        while (!((Boolean) zzfuoVar.zza()).booleanValue() && j > 0) {
            try {
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = jElapsedRealtime - SystemClock.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private final boolean zzau() {
        if (!this.zzx) {
            return false;
        }
        zzlz[] zzlzVarArr = this.zzb;
        for (int i = 0; i < 2; i++) {
            if (zzlzVarArr[i].zzF()) {
                return true;
            }
        }
        return false;
    }

    private final boolean zzav() {
        zzkw zzkwVarZzj = this.zzr.zzj();
        long j = zzkwVarZzj.zzg.zze;
        if (!zzkwVarZzj.zze) {
            return false;
        }
        if (j == -9223372036854775807L || this.zzA.zzs < j) {
            return true;
        }
        return !zzax();
    }

    private static boolean zzaw(zzlm zzlmVar, zzbj zzbjVar) {
        zzuy zzuyVar = zzlmVar.zzb;
        zzbl zzblVar = zzlmVar.zza;
        return zzblVar.zzo() || zzblVar.zzn(zzuyVar.zza, zzbjVar).zzf;
    }

    private final boolean zzax() {
        zzlm zzlmVar = this.zzA;
        return zzlmVar.zzl && zzlmVar.zzn == 0;
    }

    private final boolean zzay(zzbl zzblVar, zzuy zzuyVar) {
        if (!zzuyVar.zzb() && !zzblVar.zzo()) {
            int i = zzblVar.zzn(zzuyVar.zza, this.zzm).zzc;
            zzbk zzbkVar = this.zzl;
            zzblVar.zze(i, zzbkVar, 0L);
            if (zzbkVar.zzb() && zzbkVar.zzi && zzbkVar.zzf != -9223372036854775807L) {
                return true;
            }
        }
        return false;
    }

    private static final boolean zzaz(zzkw zzkwVar) {
        if (zzkwVar != null) {
            try {
                if (zzkwVar.zze) {
                    zzws[] zzwsVarArr = zzkwVar.zzc;
                    for (int i = 0; i < 2; i++) {
                        zzws zzwsVar = zzwsVarArr[i];
                        if (zzwsVar != null) {
                            zzwsVar.zzd();
                        }
                    }
                } else {
                    zzkwVar.zza.zzi();
                }
                if (zzkwVar.zzd() != Long.MIN_VALUE) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    static int zzd(zzbk zzbkVar, zzbj zzbjVar, int i, boolean z, Object obj, zzbl zzblVar, zzbl zzblVar2) {
        Object obj2 = zzblVar.zze(zzblVar.zzn(obj, zzbjVar).zzc, zzbkVar, 0L).zzb;
        for (int i2 = 0; i2 < zzblVar2.zzc(); i2++) {
            if (zzblVar2.zze(i2, zzbkVar, 0L).zzb.equals(obj2)) {
                return i2;
            }
        }
        int iZza = zzblVar.zza(obj);
        int iZzb = zzblVar.zzb();
        int iZzi = iZza;
        int iZza2 = -1;
        for (int i3 = 0; i3 < iZzb && iZza2 == -1; i3++) {
            iZzi = zzblVar.zzi(iZzi, zzbjVar, zzbkVar, i, z);
            if (iZzi == -1) {
                iZza2 = -1;
                break;
            }
            iZza2 = zzblVar2.zza(zzblVar.zzf(iZzi));
        }
        if (iZza2 == -1) {
            return -1;
        }
        return zzblVar2.zzd(iZza2, zzbjVar, false).zzc;
    }

    public static /* synthetic */ zzkw zzf(zzkn zzknVar, zzkx zzkxVar, long j) {
        zzze zzzeVarZzk = zzknVar.zzg.zzk();
        long j2 = zzknVar.zzT.zzb;
        zzyw zzywVar = zzknVar.zzf;
        zzll zzllVar = zzknVar.zzs;
        return new zzkw(zzknVar.zzc, j, zzknVar.zze, zzzeVarZzk, zzllVar, zzkxVar, zzywVar, -9223372036854775807L);
    }

    public static /* synthetic */ void zzh(zzkn zzknVar, zzlq zzlqVar) {
        try {
            zzaA(zzlqVar);
        } catch (zzii e) {
            zzdx.zzd("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    private final long zzx(zzbl zzblVar, Object obj, long j) {
        int i = zzblVar.zzn(obj, this.zzm).zzc;
        zzbk zzbkVar = this.zzl;
        zzblVar.zze(i, zzbkVar, 0L);
        if (zzbkVar.zzf == -9223372036854775807L || !zzbkVar.zzb() || !zzbkVar.zzi) {
            return -9223372036854775807L;
        }
        long j2 = zzbkVar.zzg;
        int i2 = zzeu.zza;
        return zzeu.zzs((j2 == -9223372036854775807L ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime()) - zzbkVar.zzf) - j;
    }

    private final long zzy(zzkw zzkwVar) {
        if (zzkwVar == null) {
            return 0L;
        }
        long jZze = zzkwVar.zze();
        if (zzkwVar.zze) {
            int i = 0;
            while (true) {
                zzlz[] zzlzVarArr = this.zzb;
                if (i >= 2) {
                    break;
                }
                if (zzlzVarArr[i].zzH(zzkwVar)) {
                    long jZzd = zzlzVarArr[i].zzd(zzkwVar);
                    if (jZzd == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    jZze = Math.max(jZzd, jZze);
                }
                i++;
            }
        }
        return jZze;
    }

    private final long zzz() {
        return zzA(this.zzA.zzq);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        boolean z;
        boolean z2;
        zzuy zzuyVar;
        int i;
        zzkw zzkwVarZzn;
        long jLongValue;
        boolean z3;
        zzuy zzuyVar2;
        Throwable th;
        long j;
        long jZza;
        long j2;
        zzlm zzlmVar;
        int i2;
        zzlm zzlmVarZzF;
        boolean z4 = true;
        try {
            zze zzeVar = null;
            switch (message.what) {
                case 1:
                    zzaf(message.arg1 != 0, message.arg2 >> 4, true, message.arg2 & 15);
                    z = true;
                    zzT();
                    return z;
                case 2:
                    zzI();
                    z = true;
                    zzT();
                    return z;
                case 3:
                    zzkl zzklVar = (zzkl) message.obj;
                    this.zzB.zza(1);
                    zzbl zzblVar = this.zzA.zza;
                    int i3 = this.zzI;
                    boolean z5 = this.zzJ;
                    zzbk zzbkVar = this.zzl;
                    zzbj zzbjVar = this.zzm;
                    Pair pairZzE = zzE(zzblVar, zzklVar, true, i3, z5, zzbkVar, zzbjVar);
                    long j3 = -9223372036854775807L;
                    if (pairZzE == null) {
                        Pair pairZzD = zzD(this.zzA.zza);
                        zzuy zzuyVar3 = (zzuy) pairZzD.first;
                        long jLongValue2 = ((Long) pairZzD.second).longValue();
                        z3 = !this.zzA.zza.zzo();
                        j3 = -9223372036854775807L;
                        jLongValue = jLongValue2;
                        zzuyVar2 = zzuyVar3;
                    } else {
                        Object obj = pairZzE.first;
                        jLongValue = ((Long) pairZzE.second).longValue();
                        long j4 = zzklVar.zzc;
                        if (j4 != -9223372036854775807L) {
                            j3 = jLongValue;
                        }
                        zzuy zzuyVarZzq = this.zzr.zzq(this.zzA.zza, obj, jLongValue);
                        if (zzuyVarZzq.zzb()) {
                            this.zzA.zza.zzn(zzuyVarZzq.zza, zzbjVar);
                            if (zzbjVar.zze(zzuyVarZzq.zzb) == zzuyVarZzq.zzc) {
                                zzbjVar.zzh();
                            }
                            z3 = true;
                            jLongValue = 0;
                        } else {
                            z3 = j4 == -9223372036854775807L;
                        }
                        zzuyVar2 = zzuyVarZzq;
                    }
                    try {
                        if (!this.zzA.zza.zzo()) {
                            if (pairZzE == null) {
                                if (this.zzA.zze != 1) {
                                    zzag(4);
                                }
                                zzY(false, true, false, true);
                            } else {
                                if (zzuyVar2.equals(this.zzA.zzb)) {
                                    zzkw zzkwVarZzj = this.zzr.zzj();
                                    jZza = (zzkwVarZzj == null || !zzkwVarZzj.zze || jLongValue == 0) ? jLongValue : zzkwVarZzj.zza.zza(jLongValue, this.zzz);
                                    if (zzeu.zzv(jZza) == zzeu.zzv(this.zzA.zzs) && ((i2 = (zzlmVar = this.zzA).zze) == 2 || i2 == 3)) {
                                        long j5 = zzlmVar.zzs;
                                        zzlmVarZzF = zzF(zzuyVar2, j5, j3, j5, z3, 2);
                                    }
                                } else {
                                    jZza = jLongValue;
                                }
                                long jZzB = zzB(zzuyVar2, jZza, this.zzA.zze == 4);
                                z3 |= jLongValue != jZzB;
                                try {
                                    zzlm zzlmVar2 = this.zzA;
                                    zzbl zzblVar2 = zzlmVar2.zza;
                                    zzar(zzblVar2, zzuyVar2, zzblVar2, zzlmVar2.zzb, j3, true);
                                    j2 = jZzB;
                                    zzlmVarZzF = zzF(zzuyVar2, j2, j3, j2, z3, 2);
                                } catch (Throwable th2) {
                                    j = jZzB;
                                    th = th2;
                                    this.zzA = zzF(zzuyVar2, j, j3, j, z3, 2);
                                    throw th;
                                }
                            }
                            this.zzA = zzlmVarZzF;
                            z = true;
                            zzT();
                            return z;
                        }
                        this.zzM = zzklVar;
                        j2 = jLongValue;
                        zzlmVarZzF = zzF(zzuyVar2, j2, j3, j2, z3, 2);
                        this.zzA = zzlmVarZzF;
                        z = true;
                        zzT();
                        return z;
                    } catch (Throwable th3) {
                        th = th3;
                        j = jLongValue;
                    }
                    break;
                case 4:
                    z4 = true;
                    zzae((zzbb) message.obj);
                    zzP(this.zzo.zzc(), true);
                    z = z4;
                    zzT();
                    return z;
                case 5:
                    z4 = true;
                    this.zzz = (zzma) message.obj;
                    z = z4;
                    zzT();
                    return z;
                case 6:
                    z4 = true;
                    zzaj(false, true);
                    z = z4;
                    zzT();
                    return z;
                case 7:
                    try {
                        zzY(true, false, true, false);
                        int i4 = 0;
                        while (true) {
                            zzlz[] zzlzVarArr = this.zzb;
                            if (i4 >= 2) {
                                this.zzg.zzd(this.zzu);
                                this.zzy.zzd();
                                this.zze.zzj();
                                zzag(1);
                                this.zzj.zzb();
                                synchronized (this) {
                                    this.zzC = true;
                                    notifyAll();
                                    break;
                                }
                                return true;
                            }
                            this.zzc[i4].zzq();
                            zzlzVarArr[i4].zzn();
                            i4++;
                        }
                    } catch (Throwable th4) {
                        this.zzj.zzb();
                        synchronized (this) {
                            this.zzC = true;
                            notifyAll();
                            throw th4;
                        }
                    }
                    break;
                case 8:
                    try {
                        zzuw zzuwVar = (zzuw) message.obj;
                        zzkz zzkzVar = this.zzr;
                        if (zzkzVar.zzy(zzuwVar)) {
                            zzkw zzkwVarZzi = zzkzVar.zzi();
                            if (zzkwVarZzi == null) {
                                throw null;
                            }
                            zzkw zzkwVar = zzkwVarZzi;
                            if (!zzkwVarZzi.zze) {
                                float f = this.zzo.zzc().zzb;
                                zzlm zzlmVar3 = this.zzA;
                                zzkwVarZzi.zzl(f, zzlmVar3.zza, zzlmVar3.zzl);
                            }
                            zzam(zzkwVarZzi.zzg.zza, zzkwVarZzi.zzh(), zzkwVarZzi.zzi());
                            if (zzkwVarZzi == zzkzVar.zzj()) {
                                zzaa(zzkwVarZzi.zzg.zzb);
                                zzK();
                                zzkwVarZzi.zzh = true;
                                zzlm zzlmVar4 = this.zzA;
                                zzuy zzuyVar4 = zzlmVar4.zzb;
                                long j6 = zzkwVarZzi.zzg.zzb;
                                this.zzA = zzF(zzuyVar4, j6, zzlmVar4.zzc, j6, false, 5);
                            }
                            zzR();
                        } else {
                            z4 = true;
                            zzkw zzkwVarZzk = zzkzVar.zzk(zzuwVar);
                            if (zzkwVarZzk != null) {
                                zzdc.zzf(!zzkwVarZzk.zze);
                                float f2 = this.zzo.zzc().zzb;
                                zzlm zzlmVar5 = this.zzA;
                                zzkwVarZzk.zzl(f2, zzlmVar5.zza, zzlmVar5.zzl);
                                if (zzkzVar.zzz(zzuwVar)) {
                                    zzS();
                                }
                            }
                        }
                        z = z4;
                    } catch (zzaz e) {
                        e = e;
                        zzaz zzazVar = e;
                        zzM(zzazVar, zzazVar.zzb == 1 ? true != zzazVar.zza ? 3003 : 3001 : 1000);
                        z = true;
                    } catch (zzgf e2) {
                        e = e2;
                        zzgf zzgfVar = e;
                        zzM(zzgfVar, zzgfVar.zza);
                        z = true;
                    } catch (zzii e3) {
                        e = e3;
                        zzii zziiVarZza = e;
                        if (zziiVarZza.zzc == 1 && (zzkwVarZzn = this.zzr.zzn()) != null && zziiVarZza.zzh == null) {
                            zziiVarZza = zziiVarZza.zza(zzkwVarZzn.zzg.zza);
                        }
                        if (zziiVarZza.zzi && (this.zzR == null || (i = zziiVarZza.zza) == 5004 || i == 5003)) {
                            zzdx.zzg("ExoPlayerImplInternal", "Recoverable renderer error", zziiVarZza);
                            zzii zziiVar = this.zzR;
                            if (zziiVar != null) {
                                zziiVar.addSuppressed(zziiVarZza);
                                zziiVarZza = this.zzR;
                            } else {
                                this.zzR = zziiVarZza;
                            }
                            zzdq zzdqVar = this.zzi;
                            zzdqVar.zzl(zzdqVar.zzc(25, zziiVarZza));
                        } else {
                            if (zziiVarZza.zzc == 1 && (zzuyVar = zziiVarZza.zzh) != null) {
                                int i5 = zziiVarZza.zze;
                                zzkz zzkzVar2 = this.zzr;
                                if (zzkzVar2.zzm() != null && zzkzVar2.zzm().zzg.zza.equals(zzuyVar) && this.zzb[i5].zzG(zzkzVar2.zzm())) {
                                    this.zzV = true;
                                    zzG();
                                    zzkw zzkwVarZzm = zzkzVar2.zzm();
                                    zzkw zzkwVarZzj2 = zzkzVar2.zzj();
                                    if (zzkzVar2.zzj() != zzkwVarZzm) {
                                        while (zzkwVarZzj2 != null && zzkwVarZzj2.zzg() != zzkwVarZzm) {
                                            zzkwVarZzj2 = zzkwVarZzj2.zzg();
                                        }
                                    }
                                    zzkzVar2.zza(zzkwVarZzj2);
                                    if (this.zzA.zze != 4) {
                                        zzR();
                                        this.zzi.zzj(2);
                                    }
                                }
                            }
                            zzii zziiVar2 = this.zzR;
                            if (zziiVar2 != null) {
                                zziiVar2.addSuppressed(zziiVarZza);
                                zziiVarZza = this.zzR;
                            }
                            zzii zziiVar3 = zziiVarZza;
                            zzdx.zzd("ExoPlayerImplInternal", "Playback error", zziiVar3);
                            z = true;
                            if (zziiVar3.zzc == 1) {
                                zzkz zzkzVar3 = this.zzr;
                                if (zzkzVar3.zzj() != zzkzVar3.zzn()) {
                                    while (zzkzVar3.zzj() != zzkzVar3.zzn()) {
                                        zzkzVar3.zze();
                                    }
                                    zzkw zzkwVarZzj3 = zzkzVar3.zzj();
                                    zzkwVarZzj3.getClass();
                                    zzT();
                                    zzkx zzkxVar = zzkwVarZzj3.zzg;
                                    zzuy zzuyVar5 = zzkxVar.zza;
                                    long j7 = zzkxVar.zzb;
                                    this.zzA = zzF(zzuyVar5, j7, zzkxVar.zzc, j7, true, 0);
                                }
                                z2 = false;
                                z = true;
                            } else {
                                z2 = false;
                            }
                            zzaj(z, z2);
                            this.zzA = this.zzA.zze(zziiVar3);
                        }
                        z = true;
                    } catch (zzrr e4) {
                        e = e4;
                        zzrr zzrrVar = e;
                        zzM(zzrrVar, zzrrVar.zza);
                        z = true;
                    } catch (zzty e5) {
                        e = e5;
                        zzM(e, 1002);
                        z = true;
                    } catch (IOException e6) {
                        e = e6;
                        zzM(e, 2000);
                        z = true;
                    } catch (RuntimeException e7) {
                        e = e7;
                        RuntimeException runtimeException = e;
                        zzii zziiVarZzd = zzii.zzd(runtimeException, ((runtimeException instanceof IllegalStateException) || (runtimeException instanceof IllegalArgumentException)) ? 1004 : 1000);
                        zzdx.zzd("ExoPlayerImplInternal", "Playback error", zziiVarZzd);
                        zzaj(true, false);
                        this.zzA = this.zzA.zze(zziiVarZzd);
                        z = true;
                    }
                    zzT();
                    return z;
                case 9:
                    zzuw zzuwVar2 = (zzuw) message.obj;
                    zzkz zzkzVar4 = this.zzr;
                    if (zzkzVar4.zzy(zzuwVar2)) {
                        zzkzVar4.zzu(this.zzN);
                        zzR();
                    } else if (zzkzVar4.zzz(zzuwVar2)) {
                        zzS();
                    }
                    z = true;
                    zzT();
                    return z;
                case 10:
                    zzW();
                    z = true;
                    zzT();
                    return z;
                case 11:
                    int i6 = message.arg1;
                    this.zzI = i6;
                    int iZzc = this.zzr.zzc(this.zzA.zza, i6);
                    if ((iZzc & 1) != 0) {
                        zzad(true);
                    } else if ((iZzc & 2) != 0) {
                        zzG();
                    }
                    zzN(false);
                    z = true;
                    zzT();
                    return z;
                case 12:
                    boolean z6 = message.arg1 != 0;
                    this.zzJ = z6;
                    int iZzd = this.zzr.zzd(this.zzA.zza, z6);
                    if ((iZzd & 1) != 0) {
                        zzad(true);
                    } else if ((iZzd & 2) != 0) {
                        zzG();
                    }
                    zzN(false);
                    z = true;
                    zzT();
                    return z;
                case 13:
                    boolean z7 = message.arg1 != 0;
                    AtomicBoolean atomicBoolean = (AtomicBoolean) message.obj;
                    if (this.zzK != z7) {
                        this.zzK = z7;
                        if (!z7) {
                            zzlz[] zzlzVarArr2 = this.zzb;
                            for (int i7 = 0; i7 < 2; i7++) {
                                zzlzVarArr2[i7].zzp();
                            }
                        }
                    }
                    if (atomicBoolean != null) {
                        synchronized (this) {
                            atomicBoolean.set(true);
                            notifyAll();
                            break;
                        }
                    }
                    z = true;
                    zzT();
                    return z;
                case 14:
                    zzlq zzlqVar = (zzlq) message.obj;
                    if (zzlqVar.zzb() == this.zzk) {
                        zzaA(zzlqVar);
                        int i8 = this.zzA.zze;
                        if (i8 == 3 || i8 == 2) {
                            this.zzi.zzj(2);
                        }
                    } else {
                        this.zzi.zzc(15, zzlqVar).zza();
                    }
                    z = true;
                    zzT();
                    return z;
                case 15:
                    final zzlq zzlqVar2 = (zzlq) message.obj;
                    Looper looperZzb = zzlqVar2.zzb();
                    if (looperZzb.getThread().isAlive()) {
                        this.zzq.zzd(looperZzb, null).zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkf
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzkn.zzh(this.zza, zzlqVar2);
                            }
                        });
                    } else {
                        zzdx.zzf("TAG", "Trying to send message on a dead thread.");
                        zzlqVar2.zzh(false);
                    }
                    z = true;
                    zzT();
                    return z;
                case 16:
                    zzP((zzbb) message.obj, false);
                    z = true;
                    zzT();
                    return z;
                case 17:
                    zzkh zzkhVar = (zzkh) message.obj;
                    this.zzB.zza(1);
                    if (zzkhVar.zzb != -1) {
                        this.zzM = new zzkl(new zzls(zzkhVar.zza, zzkhVar.zzd), zzkhVar.zzb, zzkhVar.zzc);
                    }
                    zzO(this.zzs.zzn(zzkhVar.zza, zzkhVar.zzd), false);
                    z = true;
                    zzT();
                    return z;
                case 18:
                    zzkh zzkhVar2 = (zzkh) message.obj;
                    int iZza = message.arg1;
                    this.zzB.zza(1);
                    zzll zzllVar = this.zzs;
                    if (iZza == -1) {
                        iZza = zzllVar.zza();
                    }
                    zzO(zzllVar.zzk(iZza, zzkhVar2.zza, zzkhVar2.zzd), false);
                    z = true;
                    zzT();
                    return z;
                case 19:
                    zzki zzkiVar = (zzki) message.obj;
                    this.zzB.zza(1);
                    zzll zzllVar2 = this.zzs;
                    int i9 = zzkiVar.zza;
                    int i10 = zzkiVar.zzb;
                    int i11 = zzkiVar.zzc;
                    zzwv zzwvVar = zzkiVar.zzd;
                    zzO(zzllVar2.zzl(0, 0, 0, null), false);
                    z = true;
                    zzT();
                    return z;
                case 20:
                    int i12 = message.arg1;
                    int i13 = message.arg2;
                    zzwv zzwvVar2 = (zzwv) message.obj;
                    this.zzB.zza(1);
                    zzO(this.zzs.zzm(i12, i13, zzwvVar2), false);
                    z = true;
                    zzT();
                    return z;
                case 21:
                    zzwv zzwvVar3 = (zzwv) message.obj;
                    this.zzB.zza(1);
                    zzO(this.zzs.zzo(zzwvVar3), false);
                    z = true;
                    zzT();
                    return z;
                case 22:
                    zzO(this.zzs.zzb(), true);
                    z = true;
                    zzT();
                    return z;
                case 23:
                    this.zzD = message.arg1 != 0;
                    zzZ();
                    if (this.zzE) {
                        zzkz zzkzVar5 = this.zzr;
                        if (zzkzVar5.zzn() != zzkzVar5.zzj()) {
                            zzad(true);
                            zzN(false);
                        }
                    }
                    z = true;
                    zzT();
                    return z;
                case 24:
                default:
                    return false;
                case 25:
                    zzX();
                    z = true;
                    zzT();
                    return z;
                case 26:
                    zzX();
                    z = true;
                    zzT();
                    return z;
                case 27:
                    int i14 = message.arg1;
                    int i15 = message.arg2;
                    List list = (List) message.obj;
                    this.zzB.zza(1);
                    zzO(this.zzs.zzc(i14, i15, list), false);
                    z = true;
                    zzT();
                    return z;
                case 28:
                    zzis zzisVar = (zzis) message.obj;
                    this.zzT = zzisVar;
                    this.zzr.zzw(this.zzA.zza, zzisVar);
                    z = true;
                    zzT();
                    return z;
                case 29:
                    this.zzB.zza(1);
                    zzY(false, false, false, true);
                    this.zzg.zzc(this.zzu);
                    zzag(true != this.zzA.zza.zzo() ? 2 : 4);
                    zzan();
                    this.zzs.zzg(this.zzh.zze());
                    this.zzi.zzj(2);
                    z = true;
                    zzT();
                    return z;
                case 30:
                    Pair pair = (Pair) message.obj;
                    Object obj2 = pair.first;
                    AtomicBoolean atomicBoolean2 = (AtomicBoolean) pair.second;
                    zzlz[] zzlzVarArr3 = this.zzb;
                    for (int i16 = 0; i16 < 2; i16++) {
                        zzlzVarArr3[i16].zzv(obj2);
                    }
                    int i17 = this.zzA.zze;
                    if (i17 == 3 || i17 == 2) {
                        this.zzi.zzj(2);
                    }
                    if (atomicBoolean2 != null) {
                        synchronized (this) {
                            atomicBoolean2.set(true);
                            notifyAll();
                            break;
                        }
                    }
                    z = true;
                    zzT();
                    return z;
                case 31:
                    zze zzeVar2 = (zze) message.obj;
                    int i18 = message.arg1;
                    this.zze.zzk(zzeVar2);
                    zzhw zzhwVar = this.zzy;
                    if (i18 != 0) {
                        zzeVar = zzeVar2;
                    }
                    zzhwVar.zze(zzeVar);
                    zzan();
                    z = true;
                    zzT();
                    return z;
                case 32:
                    zzah(((Float) message.obj).floatValue());
                    z = true;
                    zzT();
                    return z;
                case 33:
                    int i19 = message.arg1;
                    zzlm zzlmVar6 = this.zzA;
                    zzap(zzlmVar6.zzl, i19, zzlmVar6.zzn, zzlmVar6.zzm);
                    z = true;
                    zzT();
                    return z;
                case 34:
                    zzah(this.zzW);
                    z = true;
                    zzT();
                    return z;
            }
        } catch (zzaz e8) {
            e = e8;
        } catch (zzgf e9) {
            e = e9;
        } catch (zzii e10) {
            e = e10;
        } catch (zzrr e11) {
            e = e11;
        } catch (zzty e12) {
            e = e12;
        } catch (IOException e13) {
            e = e13;
        } catch (RuntimeException e14) {
            e = e14;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final void zza(int i) {
        this.zzi.zzd(33, i, 0).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final void zzb(float f) {
        this.zzi.zzj(34);
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void zzc(zzbb zzbbVar) {
        this.zzi.zzc(16, zzbbVar).zza();
    }

    public final Looper zze() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* bridge */ /* synthetic */ void zzj(zzwu zzwuVar) {
        this.zzi.zzc(9, (zzuw) zzwuVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlk
    public final void zzk() {
        zzdq zzdqVar = this.zzi;
        zzdqVar.zzg(2);
        zzdqVar.zzj(22);
    }

    @Override // com.google.android.gms.internal.ads.zzuv
    public final void zzl(zzuw zzuwVar) {
        this.zzi.zzc(8, zzuwVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyu
    public final void zzm() {
        this.zzi.zzj(10);
    }

    public final void zzn() {
        this.zzi.zzb(29).zza();
    }

    public final void zzo(zzbl zzblVar, int i, long j) {
        this.zzi.zzc(3, new zzkl(zzblVar, i, j)).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final synchronized void zzp(zzlq zzlqVar) {
        if (!this.zzC && this.zzk.getThread().isAlive()) {
            this.zzi.zzc(14, zzlqVar).zza();
            return;
        }
        zzdx.zzf("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        zzlqVar.zzh(false);
    }

    public final void zzq(zze zzeVar, boolean z) {
        this.zzi.zze(31, 0, 0, zzeVar).zza();
    }

    public final void zzr(boolean z, int i, int i2) {
        this.zzi.zzd(1, z ? 1 : 0, (i2 << 4) | 1).zza();
    }

    public final void zzs(float f) {
        this.zzi.zzc(32, Float.valueOf(f)).zza();
    }

    public final void zzt() {
        this.zzi.zzb(6).zza();
    }

    public final synchronized boolean zzu() {
        if (!this.zzC && this.zzk.getThread().isAlive()) {
            this.zzi.zzj(7);
            zzat(new zzfuo() { // from class: com.google.android.gms.internal.ads.zzkb
                @Override // com.google.android.gms.internal.ads.zzfuo
                public final Object zza() {
                    return Boolean.valueOf(this.zza.zzC);
                }
            }, this.zzt);
            return this.zzC;
        }
        return true;
    }

    public final synchronized boolean zzv(Object obj, long j) {
        if (!this.zzC && this.zzk.getThread().isAlive()) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.zzi.zzc(30, new Pair(obj, atomicBoolean)).zza();
            if (j != -9223372036854775807L) {
                Objects.requireNonNull(atomicBoolean);
                zzat(new zzfuo() { // from class: com.google.android.gms.internal.ads.zzke
                    @Override // com.google.android.gms.internal.ads.zzfuo
                    public final Object zza() {
                        return Boolean.valueOf(atomicBoolean.get());
                    }
                }, j);
                return atomicBoolean.get();
            }
        }
        return true;
    }

    public final void zzw(List list, int i, long j, zzwv zzwvVar) {
        this.zzi.zzc(17, new zzkh(list, zzwvVar, i, j, null)).zza();
    }
}
