package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzana implements zzanv {
    private final zzamg zza;
    private final zzej zzb = new zzej(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzer zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzana(zzamg zzamgVar) {
        this.zza = zzamgVar;
    }

    private final void zze(int i) {
        this.zzc = i;
        this.zzd = 0;
    }

    private final boolean zzf(zzek zzekVar, byte[] bArr, int i) {
        int iMin = Math.min(zzekVar.zza(), i - this.zzd);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            zzekVar.zzM(iMin);
        } else {
            zzekVar.zzH(bArr, this.zzd, iMin);
        }
        int i2 = this.zzd + iMin;
        this.zzd = i2;
        return i2 == i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r9v11, types: [com.google.android.gms.internal.ads.zzej] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v5, types: [int] */
    /* JADX WARN: Type inference failed for: r9v6, types: [com.google.android.gms.internal.ads.zzamg] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzanv
    public final void zza(zzek zzekVar, int i) throws zzaz {
        int i2;
        int i3;
        ?? r2;
        int i4;
        zzek zzekVar2;
        int i5;
        int i6;
        int i7;
        ?? r9;
        long jZzb;
        zzek zzekVar3 = zzekVar;
        zzdc.zzb(this.zze);
        int i8 = -1;
        int i9 = 2;
        ?? r6 = 0;
        int i10 = 1;
        if ((i & 1) != 0) {
            int i11 = this.zzc;
            if (i11 != 0 && i11 != 1) {
                if (i11 != 2) {
                    int i12 = this.zzj;
                    if (i12 != -1) {
                        zzdx.zzf("PesReader", "Unexpected start indicator: expected " + i12 + " more bytes");
                    }
                    this.zza.zzc(zzekVar.zzd() == 0);
                } else {
                    zzdx.zzf("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zze(1);
        }
        int i13 = i;
        while (zzekVar.zza() > 0) {
            int i14 = this.zzc;
            if (i14 == 0) {
                i2 = i13;
                i3 = i9;
                r2 = r6;
                i4 = i10;
                zzekVar2 = zzekVar3;
                i5 = i8;
                zzekVar2.zzM(zzekVar.zza());
            } else if (i14 == i10) {
                i2 = i13;
                zzej zzejVar = this.zzb;
                zzekVar2 = zzekVar;
                if (zzf(zzekVar2, zzejVar.zza, 9)) {
                    r2 = 0;
                    zzejVar.zzl(0);
                    int iZzd = zzejVar.zzd(24);
                    i4 = 1;
                    if (iZzd != 1) {
                        zzdx.zzf("PesReader", "Unexpected start code prefix: " + iZzd);
                        i5 = -1;
                        this.zzj = -1;
                        i6 = 0;
                        i3 = 2;
                    } else {
                        zzejVar.zzn(8);
                        int iZzd2 = zzejVar.zzd(16);
                        zzejVar.zzn(5);
                        this.zzk = zzejVar.zzp();
                        i3 = 2;
                        zzejVar.zzn(2);
                        this.zzf = zzejVar.zzp();
                        this.zzg = zzejVar.zzp();
                        zzejVar.zzn(6);
                        int iZzd3 = zzejVar.zzd(8);
                        this.zzi = iZzd3;
                        if (iZzd2 == 0) {
                            this.zzj = -1;
                            i5 = -1;
                        } else {
                            int i15 = (iZzd2 - 3) - iZzd3;
                            this.zzj = i15;
                            if (i15 < 0) {
                                zzdx.zzf("PesReader", "Found negative packet payload size: " + i15);
                                i5 = -1;
                                this.zzj = -1;
                            } else {
                                i5 = -1;
                            }
                        }
                        i6 = 2;
                    }
                    zze(i6);
                } else {
                    i5 = -1;
                    r2 = 0;
                    i4 = 1;
                    i3 = 2;
                }
            } else if (i14 != i9) {
                int iZza = zzekVar.zza();
                int i16 = this.zzj;
                if (i16 == i8) {
                    r9 = r6;
                } else {
                    i7 = iZza - i16;
                }
                if (r9 > 0) {
                    r9 = i7;
                    iZza -= r9;
                    zzekVar3.zzK(zzekVar.zzc() + iZza);
                }
                r9 = i7;
                ?? r10 = this.zza;
                r10.zza(zzekVar3);
                int i17 = this.zzj;
                if (i17 != i8) {
                    int i18 = i17 - iZza;
                    this.zzj = i18;
                    if (i18 == 0) {
                        r10.zzc(r6);
                        zze(i10);
                    }
                }
                i2 = i13;
                i3 = i9;
                r2 = r6;
                i4 = i10;
                zzekVar2 = zzekVar3;
                i5 = i8;
            } else {
                int iMin = Math.min(10, this.zzi);
                ?? r11 = this.zzb;
                if (zzf(zzekVar3, r11.zza, iMin) && zzf(zzekVar3, null, this.zzi)) {
                    r11.zzl(r6);
                    if (this.zzf) {
                        r11.zzn(4);
                        long jZzd = r11.zzd(3);
                        r11.zzn(i10);
                        int iZzd4 = r11.zzd(15) << 15;
                        r11.zzn(i10);
                        long jZzd2 = r11.zzd(15);
                        r11.zzn(i10);
                        if (!this.zzh && this.zzg) {
                            r11.zzn(4);
                            long jZzd3 = ((long) r11.zzd(3)) << 30;
                            r11.zzn(i10);
                            int iZzd5 = r11.zzd(15) << 15;
                            r11.zzn(i10);
                            long jZzd4 = r11.zzd(15);
                            r11.zzn(i10);
                            this.zze.zzb(jZzd4 | ((long) iZzd5) | jZzd3);
                            this.zzh = true;
                        }
                        jZzb = this.zze.zzb((jZzd << 30) | ((long) iZzd4) | jZzd2);
                    } else {
                        i13 = i13;
                        jZzb = -9223372036854775807L;
                    }
                    int i19 = i13 | (true != this.zzk ? 0 : 4);
                    this.zza.zzd(jZzb, i19);
                    zze(3);
                    zzekVar3 = zzekVar;
                    i13 = i19;
                    i8 = -1;
                    i9 = 2;
                    r6 = 0;
                    i10 = 1;
                } else {
                    i2 = i13;
                    i5 = i8;
                    i3 = i9;
                    r2 = r6;
                    i4 = i10;
                    zzekVar2 = zzekVar;
                }
            }
            i8 = i5;
            zzekVar3 = zzekVar2;
            i10 = i4;
            i9 = i3;
            r6 = r2;
            i13 = i2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final void zzb(zzer zzerVar, zzadf zzadfVar, zzanu zzanuVar) {
        this.zze = zzerVar;
        this.zza.zzb(zzadfVar, zzanuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }

    public final boolean zzd(boolean z) {
        return this.zzc == 3 && this.zzj == -1;
    }
}
