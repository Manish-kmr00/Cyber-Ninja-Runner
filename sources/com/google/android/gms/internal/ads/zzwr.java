package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzwr implements zzaei {
    private boolean zzA;
    private zzrz zzB;
    private final zzwl zza;
    private final zzry zzd;
    private final zzrt zze;
    private zzwp zzf;
    private zzz zzg;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private boolean zzv;
    private zzz zzy;
    private final zzwn zzb = new zzwn();
    private int zzh = 1000;
    private long[] zzi = new long[1000];
    private long[] zzj = new long[1000];
    private long[] zzm = new long[1000];
    private int[] zzl = new int[1000];
    private int[] zzk = new int[1000];
    private zzaeh[] zzn = new zzaeh[1000];
    private final zzwy zzc = new zzwy(new zzdk() { // from class: com.google.android.gms.internal.ads.zzwm
        @Override // com.google.android.gms.internal.ads.zzdk
        public final void zza(Object obj) {
            zzrx zzrxVar = ((zzwo) obj).zzb;
        }
    });
    private long zzs = Long.MIN_VALUE;
    private long zzt = Long.MIN_VALUE;
    private long zzu = Long.MIN_VALUE;
    private boolean zzx = true;
    private boolean zzw = true;
    private boolean zzz = true;

    protected zzwr(zzze zzzeVar, zzry zzryVar, zzrt zzrtVar) {
        this.zzd = zzryVar;
        this.zze = zzrtVar;
        this.zza = new zzwl(zzzeVar);
    }

    private final int zzB(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.zzm[i];
            if (j2 > j) {
                break;
            }
            if (!z || (this.zzl[i] & 1) != 0) {
                i3 = i4;
                if (j2 == j) {
                    break;
                }
            }
            i++;
            if (i == this.zzh) {
                i = 0;
            }
        }
        return i3;
    }

    private final int zzC(int i) {
        int i2 = this.zzq + i;
        int i3 = this.zzh;
        return i2 < i3 ? i2 : i2 - i3;
    }

    private final synchronized int zzD(zzkp zzkpVar, zzhn zzhnVar, boolean z, boolean z2, zzwn zzwnVar) {
        zzhnVar.zzd = false;
        if (!zzL()) {
            if (!z2 && !this.zzv) {
                zzz zzzVar = this.zzy;
                if (zzzVar == null || (!z && zzzVar == this.zzg)) {
                    return -3;
                }
                zzI(zzzVar, zzkpVar);
                return -5;
            }
            zzhnVar.zzc(4);
            zzhnVar.zze = Long.MIN_VALUE;
            return -4;
        }
        zzz zzzVar2 = ((zzwo) this.zzc.zza(this.zzp + this.zzr)).zza;
        if (!z && zzzVar2 == this.zzg) {
            int iZzC = zzC(this.zzr);
            if (!zzM(iZzC)) {
                zzhnVar.zzd = true;
                return -3;
            }
            zzhnVar.zzc(this.zzl[iZzC]);
            if (this.zzr == this.zzo - 1 && (z2 || this.zzv)) {
                zzhnVar.zza(536870912);
            }
            zzhnVar.zze = this.zzm[iZzC];
            zzwnVar.zza = this.zzk[iZzC];
            zzwnVar.zzb = this.zzj[iZzC];
            zzwnVar.zzc = this.zzn[iZzC];
            return -4;
        }
        zzI(zzzVar2, zzkpVar);
        return -5;
    }

    private final synchronized long zzE(long j, boolean z, boolean z2) {
        int i;
        int i2 = this.zzo;
        if (i2 != 0) {
            long[] jArr = this.zzm;
            int i3 = this.zzq;
            if (j >= jArr[i3]) {
                if (z2 && (i = this.zzr) != i2) {
                    i2 = i + 1;
                }
                int iZzB = zzB(i3, i2, j, false);
                if (iZzB != -1) {
                    return zzG(iZzB);
                }
            }
        }
        return -1L;
    }

    private final synchronized long zzF() {
        int i = this.zzo;
        if (i == 0) {
            return -1L;
        }
        return zzG(i);
    }

    private final synchronized void zzH(long j, int i, long j2, int i2, zzaeh zzaehVar) {
        int i3 = this.zzo;
        if (i3 > 0) {
            int iZzC = zzC(i3 - 1);
            zzdc.zzd(this.zzj[iZzC] + ((long) this.zzk[iZzC]) <= j2);
        }
        this.zzv = (536870912 & i) != 0;
        this.zzu = Math.max(this.zzu, j);
        int iZzC2 = zzC(this.zzo);
        this.zzm[iZzC2] = j;
        this.zzj[iZzC2] = j2;
        this.zzk[iZzC2] = i2;
        this.zzl[iZzC2] = i;
        this.zzn[iZzC2] = zzaehVar;
        this.zzi[iZzC2] = 0;
        zzwy zzwyVar = this.zzc;
        if (zzwyVar.zzf() || !((zzwo) zzwyVar.zzb()).zza.equals(this.zzy)) {
            zzz zzzVar = this.zzy;
            if (zzzVar == null) {
                throw null;
            }
            zzwyVar.zzc(this.zzp + this.zzo, new zzwo(zzzVar, this.zzd.zzb(this.zze, zzzVar), null));
        }
        int i4 = this.zzo + 1;
        this.zzo = i4;
        int i5 = this.zzh;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            long[] jArr = new long[i6];
            long[] jArr2 = new long[i6];
            long[] jArr3 = new long[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            zzaeh[] zzaehVarArr = new zzaeh[i6];
            int i7 = this.zzq;
            int i8 = i5 - i7;
            System.arraycopy(this.zzj, i7, jArr2, 0, i8);
            System.arraycopy(this.zzm, this.zzq, jArr3, 0, i8);
            System.arraycopy(this.zzl, this.zzq, iArr, 0, i8);
            System.arraycopy(this.zzk, this.zzq, iArr2, 0, i8);
            System.arraycopy(this.zzn, this.zzq, zzaehVarArr, 0, i8);
            System.arraycopy(this.zzi, this.zzq, jArr, 0, i8);
            int i9 = this.zzq;
            System.arraycopy(this.zzj, 0, jArr2, i8, i9);
            System.arraycopy(this.zzm, 0, jArr3, i8, i9);
            System.arraycopy(this.zzl, 0, iArr, i8, i9);
            System.arraycopy(this.zzk, 0, iArr2, i8, i9);
            System.arraycopy(this.zzn, 0, zzaehVarArr, i8, i9);
            System.arraycopy(this.zzi, 0, jArr, i8, i9);
            this.zzj = jArr2;
            this.zzm = jArr3;
            this.zzl = iArr;
            this.zzk = iArr2;
            this.zzn = zzaehVarArr;
            this.zzi = jArr;
            this.zzq = 0;
            this.zzh = i6;
        }
    }

    private final void zzI(zzz zzzVar, zzkp zzkpVar) {
        zzz zzzVar2 = this.zzg;
        zzs zzsVar = zzzVar2 == null ? null : zzzVar2.zzs;
        this.zzg = zzzVar;
        zzs zzsVar2 = zzzVar.zzs;
        zzry zzryVar = this.zzd;
        zzkpVar.zza = zzzVar.zzc(zzryVar.zza(zzzVar));
        zzkpVar.zzb = this.zzB;
        if (zzzVar2 == null || !Objects.equals(zzsVar, zzsVar2)) {
            zzrz zzrzVarZzc = zzryVar.zzc(this.zze, zzzVar);
            this.zzB = zzrzVarZzc;
            zzkpVar.zzb = zzrzVarZzc;
        }
    }

    private final void zzJ() {
        if (this.zzB != null) {
            this.zzB = null;
            this.zzg = null;
        }
    }

    private final synchronized void zzK() {
        this.zzr = 0;
        this.zza.zzg();
    }

    private final boolean zzL() {
        return this.zzr != this.zzo;
    }

    private final boolean zzM(int i) {
        if (this.zzB != null) {
            return (this.zzl[i] & 1073741824) != 0 ? false : false;
        }
        return true;
    }

    private final synchronized boolean zzN(zzz zzzVar) {
        this.zzx = false;
        if (Objects.equals(zzzVar, this.zzy)) {
            return false;
        }
        zzwy zzwyVar = this.zzc;
        if (zzwyVar.zzf() || !((zzwo) zzwyVar.zzb()).zza.equals(zzzVar)) {
            this.zzy = zzzVar;
        } else {
            this.zzy = ((zzwo) zzwyVar.zzb()).zza;
        }
        boolean z = this.zzz;
        zzz zzzVar2 = this.zzy;
        this.zzz = z & zzay.zzf(zzzVar2.zzo, zzzVar2.zzk);
        this.zzA = false;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0028 A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:28:0x0055, B:25:0x0047), top: B:36:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x002e A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:28:0x0055, B:25:0x0047), top: B:36:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0036 A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:28:0x0055, B:25:0x0047), top: B:36:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x003c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0044 A[EDGE_INSN: B:23:0x0044->B:26:0x0052 BREAK  A[LOOP:0: B:14:0x002c->B:20:0x003d]] */
    /* JADX WARN: Code duplicated, block: B:24:0x0045 A[EDGE_INSN: B:24:0x0045->B:26:0x0052 BREAK  A[LOOP:0: B:14:0x002c->B:20:0x003d]] */
    /* JADX WARN: Code duplicated, block: B:25:0x0047 A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:28:0x0055, B:25:0x0047), top: B:36:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055 A[Catch: all -> 0x0060, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:28:0x0055, B:25:0x0047), top: B:36:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x003d A[SYNTHETIC] */
    public final synchronized boolean zzA(long j, boolean z) {
        int iZzB;
        int i;
        zzK();
        int i2 = this.zzr;
        int iZzC = zzC(i2);
        if (zzL() && j >= this.zzm[iZzC]) {
            if (j <= this.zzu) {
                if (this.zzz) {
                    iZzB = this.zzo - i2;
                    i = 0;
                    while (true) {
                        if (i < iZzB) {
                            if (z) {
                                iZzB = -1;
                                break;
                            }
                            break;
                        }
                        if (this.zzm[iZzC] < j) {
                            iZzB = i;
                            break;
                        }
                        iZzC++;
                        if (iZzC == this.zzh) {
                            iZzC = 0;
                        }
                        i++;
                    }
                } else {
                    iZzB = zzB(iZzC, this.zzo - i2, j, true);
                }
                if (iZzB == -1) {
                    this.zzs = j;
                    this.zzr += iZzB;
                    return true;
                }
            } else if (z) {
                z = true;
                if (this.zzz) {
                    iZzB = this.zzo - i2;
                    i = 0;
                    while (true) {
                        if (i < iZzB) {
                            if (z) {
                                iZzB = -1;
                                break;
                            }
                            break;
                            break;
                        }
                        if (this.zzm[iZzC] < j) {
                            iZzB = i;
                            break;
                        }
                        iZzC++;
                        if (iZzC == this.zzh) {
                            iZzC = 0;
                        }
                        i++;
                    }
                } else {
                    iZzB = zzB(iZzC, this.zzo - i2, j, true);
                }
                if (iZzB == -1) {
                    this.zzs = j;
                    this.zzr += iZzB;
                    return true;
                }
            }
        }
        return false;
    }

    public final int zza() {
        return this.zzp;
    }

    public final int zzb() {
        return this.zzp + this.zzr;
    }

    public final synchronized int zzc(long j, boolean z) {
        int i = this.zzr;
        int iZzC = zzC(i);
        if (zzL() && j >= this.zzm[iZzC]) {
            if (j > this.zzu && z) {
                return this.zzo - i;
            }
            int iZzB = zzB(iZzC, this.zzo - i, j, true);
            if (iZzB == -1) {
                return 0;
            }
            return iZzB;
        }
        return 0;
    }

    public final int zzd() {
        return this.zzp + this.zzo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r9 != 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zze(com.google.android.gms.internal.ads.zzkp r9, com.google.android.gms.internal.ads.zzhn r10, int r11, boolean r12) {
        /*
            r8 = this;
            r0 = r11 & 2
            r1 = 1
            if (r0 == 0) goto L7
            r5 = r1
            goto L9
        L7:
            r0 = 0
            r5 = r0
        L9:
            com.google.android.gms.internal.ads.zzwn r0 = r8.zzb
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r12
            r7 = r0
            int r9 = r2.zzD(r3, r4, r5, r6, r7)
            r12 = -4
            if (r9 != r12) goto L3b
            boolean r9 = r10.zzf()
            if (r9 != 0) goto L3a
            r9 = r11 & 1
            r11 = r11 & 4
            if (r11 != 0) goto L31
            if (r9 == 0) goto L2b
            com.google.android.gms.internal.ads.zzwl r9 = r8.zza
            r9.zzd(r10, r0)
            goto L3a
        L2b:
            com.google.android.gms.internal.ads.zzwl r9 = r8.zza
            r9.zze(r10, r0)
            goto L34
        L31:
            if (r9 == 0) goto L34
            goto L3a
        L34:
            int r9 = r8.zzr
            int r9 = r9 + r1
            r8.zzr = r9
            return r12
        L3a:
            r9 = r12
        L3b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwr.zze(com.google.android.gms.internal.ads.zzkp, com.google.android.gms.internal.ads.zzhn, int, boolean):int");
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final /* synthetic */ int zzf(zzl zzlVar, int i, boolean z) {
        return zzaeg.zza(this, zzlVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final int zzg(zzl zzlVar, int i, boolean z, int i2) throws IOException {
        return this.zza.zza(zzlVar, i, z);
    }

    public final synchronized long zzh() {
        return this.zzu;
    }

    public final synchronized zzz zzi() {
        if (this.zzx) {
            return null;
        }
        return this.zzy;
    }

    public final void zzj(long j, boolean z, boolean z2) {
        this.zza.zzc(zzE(j, false, z2));
    }

    public final void zzk() {
        this.zza.zzc(zzF());
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final /* synthetic */ void zzl(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final void zzm(zzz zzzVar) {
        boolean zZzN = zzN(zzzVar);
        zzwp zzwpVar = this.zzf;
        if (zzwpVar == null || !zZzN) {
            return;
        }
        zzwpVar.zzN(zzzVar);
    }

    public final void zzn() throws IOException {
        zzrz zzrzVar = this.zzB;
        if (zzrzVar != null) {
            throw zzrzVar.zza();
        }
    }

    public final void zzo() {
        zzk();
        zzJ();
    }

    public final void zzp() {
        zzq(true);
        zzJ();
    }

    public final void zzq(boolean z) {
        this.zza.zzf();
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzw = true;
        this.zzs = Long.MIN_VALUE;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = false;
        this.zzc.zzd();
        if (z) {
            this.zzy = null;
            this.zzx = true;
            this.zzz = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final /* synthetic */ void zzr(zzek zzekVar, int i) {
        zzaeg.zzb(this, zzekVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final void zzs(zzek zzekVar, int i, int i2) {
        this.zza.zzh(zzekVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final void zzt(long j, int i, int i2, int i3, zzaeh zzaehVar) {
        if (this.zzw) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.zzw = false;
            }
        }
        if (this.zzz) {
            if (j < this.zzs) {
                return;
            }
            if ((i & 1) == 0) {
                if (!this.zzA) {
                    zzdx.zzf("SampleQueue", "Overriding unexpected non-sync sample for format: ".concat(String.valueOf(String.valueOf(this.zzy))));
                    this.zzA = true;
                }
                i |= 1;
            }
        }
        zzH(j, i, (this.zza.zzb() - ((long) i2)) - ((long) i3), i2, zzaehVar);
    }

    public final void zzu(long j) {
        this.zzs = j;
    }

    public final void zzv(zzwp zzwpVar) {
        this.zzf = zzwpVar;
    }

    public final synchronized void zzw(int i) {
        boolean z = false;
        if (i >= 0) {
            try {
                if (this.zzr + i <= this.zzo) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzdc.zzd(z);
        this.zzr += i;
    }

    public final synchronized boolean zzx() {
        return this.zzv;
    }

    public final synchronized boolean zzy(boolean z) {
        boolean z2 = true;
        if (zzL()) {
            if (((zzwo) this.zzc.zza(this.zzp + this.zzr)).zza != this.zzg) {
                return true;
            }
            return zzM(zzC(this.zzr));
        }
        if (!z && !this.zzv) {
            zzz zzzVar = this.zzy;
            if (zzzVar == null) {
                z2 = false;
            } else if (zzzVar == this.zzg) {
                return false;
            }
        }
        return z2;
    }

    public final synchronized boolean zzz(int i) {
        zzK();
        int i2 = this.zzp;
        if (i >= i2 && i <= this.zzo + i2) {
            this.zzs = Long.MIN_VALUE;
            this.zzr = i - i2;
            return true;
        }
        return false;
    }

    private final long zzG(int i) {
        long j = this.zzt;
        long jMax = Long.MIN_VALUE;
        if (i != 0) {
            int iZzC = zzC(i - 1);
            for (int i2 = 0; i2 < i; i2++) {
                jMax = Math.max(jMax, this.zzm[iZzC]);
                if ((this.zzl[iZzC] & 1) != 0) {
                    break;
                }
                iZzC--;
                if (iZzC == -1) {
                    iZzC = this.zzh - 1;
                }
            }
        }
        this.zzt = Math.max(j, jMax);
        this.zzo -= i;
        int i3 = this.zzp + i;
        this.zzp = i3;
        int i4 = this.zzq + i;
        this.zzq = i4;
        int i5 = this.zzh;
        if (i4 >= i5) {
            this.zzq = i4 - i5;
        }
        int i6 = this.zzr - i;
        this.zzr = i6;
        if (i6 < 0) {
            this.zzr = 0;
        }
        this.zzc.zze(i3);
        if (this.zzo != 0) {
            return this.zzj[this.zzq];
        }
        int i7 = this.zzq;
        if (i7 == 0) {
            i7 = this.zzh;
        }
        int i8 = i7 - 1;
        return this.zzj[i8] + ((long) this.zzk[i8]);
    }
}
