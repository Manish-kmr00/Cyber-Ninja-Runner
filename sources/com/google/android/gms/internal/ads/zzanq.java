package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzanq implements zzadc {
    private final int zza;
    private final List zzb;
    private final zzek zzc;
    private final SparseIntArray zzd;
    private final zzant zze;
    private final zzajy zzf;
    private final SparseArray zzg;
    private final SparseBooleanArray zzh;
    private final SparseBooleanArray zzi;
    private final zzann zzj;
    private zzanm zzk;
    private zzadf zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;

    @Deprecated
    public zzanq() {
        this(1, 1, zzajy.zza, new zzer(0L), new zzamd(0), 112800);
    }

    /* JADX WARN: Code duplicated, block: B:97:0x019f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.util.SparseArray] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.google.android.gms.internal.ads.zzana] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.util.SparseBooleanArray] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.google.android.gms.internal.ads.zzanv] */
    /* JADX WARN: Type inference failed for: r9v7 */
    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        ?? r3;
        ?? r9;
        zzanv zzanvVar;
        long j;
        boolean z;
        long jZzd = zzaddVar.zzd();
        if (this.zzn) {
            if (jZzd != -1) {
                zzann zzannVar = this.zzj;
                if (!zzannVar.zzd()) {
                    return zzannVar.zza(zzaddVar, zzadyVar, this.zzr);
                }
            }
            if (this.zzo) {
                j = 0;
            } else {
                this.zzo = true;
                zzann zzannVar2 = this.zzj;
                if (zzannVar2.zzb() != -9223372036854775807L) {
                    j = 0;
                    zzanm zzanmVar = new zzanm(zzannVar2.zzc(), zzannVar2.zzb(), jZzd, this.zzr, 112800);
                    this.zzk = zzanmVar;
                    this.zzl.zzP(zzanmVar.zzb());
                } else {
                    j = 0;
                    this.zzl.zzP(new zzaea(zzannVar2.zzb(), 0L));
                }
            }
            if (this.zzp) {
                z = false;
                this.zzp = false;
                zzf(j, j);
                if (zzaddVar.zzf() != j) {
                    zzadyVar.zza = j;
                    return 1;
                }
            } else {
                z = false;
            }
            zzanm zzanmVar2 = this.zzk;
            r3 = z;
            if (zzanmVar2 != null && zzanmVar2.zze()) {
                r3 = z;
                return zzanmVar2.zza(zzaddVar, zzadyVar);
            }
        } else {
            r3 = 0;
        }
        r3 = z;
        zzek zzekVar = this.zzc;
        byte[] bArrZzN = zzekVar.zzN();
        if (9400 - zzekVar.zzc() < 188) {
            int iZza = zzekVar.zza();
            if (iZza > 0) {
                System.arraycopy(bArrZzN, zzekVar.zzc(), bArrZzN, r3, iZza);
            }
            zzekVar.zzJ(bArrZzN, iZza);
        }
        while (zzekVar.zza() < 188) {
            int iZzd = zzekVar.zzd();
            int iZza2 = zzaddVar.zza(bArrZzN, iZzd, 9400 - iZzd);
            if (iZza2 == -1) {
                ?? r10 = r3;
                while (true) {
                    ?? r1 = this.zzg;
                    if (r10 >= r1.size()) {
                        return -1;
                    }
                    zzanv zzanvVar2 = (zzanv) r1.valueAt(r10);
                    if (zzanvVar2 instanceof zzana) {
                        ?? r2 = (zzana) zzanvVar2;
                        if (r2.zzd(r3)) {
                            r2.zza(new zzek(), 1);
                        }
                    }
                    r10++;
                }
            } else {
                zzekVar.zzK(iZzd + iZza2);
            }
        }
        int iZzc = zzekVar.zzc();
        int iZzd2 = zzekVar.zzd();
        int iZza3 = zzanw.zza(zzekVar.zzN(), iZzc, iZzd2);
        zzekVar.zzL(iZza3);
        int i = iZza3 + 188;
        if (i > iZzd2) {
            this.zzq += iZza3 - iZzc;
        } else {
            this.zzq = r3;
        }
        int iZzd3 = zzekVar.zzd();
        if (i > iZzd3) {
            return r3;
        }
        int iZzg = zzekVar.zzg();
        if ((8388608 & iZzg) != 0) {
            zzekVar.zzL(i);
            return r3;
        }
        ?? r11 = (4194304 & iZzg) != 0 ? 1 : r3;
        int i2 = iZzg & 32;
        int i3 = (iZzg >> 8) & 8191;
        if ((iZzg & 16) != 0) {
            zzanvVar = (zzanv) this.zzg.get(i3);
        } else {
            r9 = 0;
        }
        if (r9 == 0) {
            r9 = zzanvVar;
            zzekVar.zzL(i);
            return r3;
        }
        int i4 = iZzg & 15;
        SparseIntArray sparseIntArray = this.zzd;
        int i5 = sparseIntArray.get(i3, i4 - 1);
        sparseIntArray.put(i3, i4);
        if (i5 == i4) {
            r9 = zzanvVar;
            zzekVar.zzL(i);
            return r3;
        }
        if (i4 != ((i5 + 1) & 15)) {
            r9 = zzanvVar;
            r9.zzc();
        }
        if (i2 != 0) {
            int iZzm = zzekVar.zzm();
            r11 = (r11 == true ? 1 : 0) | ((zzekVar.zzm() & 64) != 0 ? 2 : r3);
            zzekVar.zzM(iZzm - 1);
        }
        boolean z2 = this.zzn;
        if (z2 || !this.zzi.get(i3, r3)) {
            zzekVar.zzK(i);
            r9.zza(zzekVar, r11);
            zzekVar.zzK(iZzd3);
            if (!z2) {
                if (this.zzn && jZzd != -1) {
                    this.zzp = true;
                }
            }
        } else if (this.zzn) {
            this.zzp = true;
        }
        zzekVar.zzL(i);
        return r3;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ zzadc zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ List zzd() {
        return zzfww.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zze(zzadf zzadfVar) {
        if (this.zza == 0) {
            zzadfVar = new zzakb(zzadfVar, this.zzf);
        }
        this.zzl = zzadfVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002f  */
    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        zzanm zzanmVar;
        List list = this.zzb;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            zzer zzerVar = (zzer) list.get(i);
            if (zzerVar.zzf() != -9223372036854775807L) {
                long jZzd = zzerVar.zzd();
                if (jZzd != -9223372036854775807L && jZzd != 0 && jZzd != j2) {
                    zzerVar.zzi(j2);
                }
            } else {
                zzerVar.zzi(j2);
            }
        }
        if (j2 != 0 && (zzanmVar = this.zzk) != null) {
            zzanmVar.zzd(j2);
        }
        this.zzc.zzI(0);
        this.zzd.clear();
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.zzg;
            if (i2 >= sparseArray.size()) {
                this.zzq = 0;
                return;
            } else {
                ((zzanv) sparseArray.valueAt(i2)).zzc();
                i2++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        byte[] bArrZzN = this.zzc.zzN();
        zzacr zzacrVar = (zzacr) zzaddVar;
        zzacrVar.zzm(bArrZzN, 0, 940, false);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    zzacrVar.zzo(i, false);
                    return true;
                }
                if (bArrZzN[(i2 * 188) + i] != 71) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public zzanq(int i, int i2, zzajy zzajyVar, zzer zzerVar, zzant zzantVar, int i3) {
        this.zze = zzantVar;
        this.zza = i2;
        this.zzf = zzajyVar;
        this.zzb = Collections.singletonList(zzerVar);
        this.zzc = new zzek(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.zzh = sparseBooleanArray;
        this.zzi = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.zzg = sparseArray;
        this.zzd = new SparseIntArray();
        this.zzj = new zzann(112800);
        this.zzl = zzadf.zza;
        this.zzr = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArrayZza = zzantVar.zza();
        int size = sparseArrayZza.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.zzg.put(sparseArrayZza.keyAt(i4), (zzanv) sparseArrayZza.valueAt(i4));
        }
        this.zzg.put(0, new zzani(new zzano(this)));
    }
}
