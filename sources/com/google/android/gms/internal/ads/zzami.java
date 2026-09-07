package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzami implements zzamg {
    private static final double[] zza = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String zzb;
    private zzaei zzc;
    private final zzanx zzd;
    private final String zze;
    private final zzek zzf;
    private final zzamy zzg;
    private final boolean[] zzh = new boolean[4];
    private final zzamh zzi = new zzamh(128);
    private long zzj;
    private boolean zzk;
    private boolean zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private boolean zzq;
    private boolean zzr;

    zzami(zzanx zzanxVar, String str) {
        zzek zzekVar;
        this.zzd = zzanxVar;
        this.zze = str;
        if (zzanxVar != null) {
            this.zzg = new zzamy(178, 128);
            zzekVar = new zzek();
        } else {
            zzekVar = null;
            this.zzg = null;
        }
        this.zzf = zzekVar;
        this.zzn = -9223372036854775807L;
        this.zzp = -9223372036854775807L;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:39:0x012b  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zza(zzek zzekVar) {
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        long j;
        double d;
        int i5;
        int i6;
        zzdc.zzb(this.zzc);
        int iZzc = zzekVar.zzc();
        int iZzd = zzekVar.zzd();
        byte[] bArrZzN = zzekVar.zzN();
        this.zzj += (long) zzekVar.zza();
        this.zzc.zzr(zzekVar, zzekVar.zza());
        while (true) {
            int iZza = zzfq.zza(bArrZzN, iZzc, iZzd, this.zzh);
            if (iZza == iZzd) {
                break;
            }
            int i7 = iZza + 3;
            int i8 = zzekVar.zzN()[i7] & 255;
            int i9 = iZza - iZzc;
            if (!this.zzl) {
                if (i9 > 0) {
                    this.zzi.zza(bArrZzN, iZzc, iZza);
                }
                int i10 = i9 < 0 ? -i9 : 0;
                zzamh zzamhVar = this.zzi;
                if (zzamhVar.zzc(i8, i10)) {
                    String str = this.zzb;
                    str.getClass();
                    String str2 = this.zze;
                    byte[] bArrCopyOf = Arrays.copyOf(zzamhVar.zzc, zzamhVar.zza);
                    int i11 = bArrCopyOf[4] & 255;
                    byte b = bArrCopyOf[5];
                    int i12 = bArrCopyOf[6] & 255;
                    int i13 = (i11 << 4) | ((b & 255) >> 4);
                    int i14 = (bArrCopyOf[7] & 240) >> 4;
                    int i15 = i12 | ((b & Ascii.SI) << 8);
                    if (i14 == 2) {
                        i2 = i15 * 4;
                        i3 = i13 * 3;
                    } else if (i14 != 3) {
                        if (i14 != 4) {
                            f = 1.0f;
                        } else {
                            i2 = i15 * Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
                            i3 = i13 * 100;
                        }
                        zzx zzxVar = new zzx();
                        zzxVar.zzO(str);
                        zzxVar.zzE(str2);
                        zzxVar.zzad("video/mpeg2");
                        zzxVar.zzai(i13);
                        zzxVar.zzM(i15);
                        zzxVar.zzZ(f);
                        zzxVar.zzP(Collections.singletonList(bArrCopyOf));
                        zzz zzzVarZzaj = zzxVar.zzaj();
                        i4 = (bArrCopyOf[7] & Ascii.SI) - 1;
                        j = 0;
                        if (i4 >= 0 && i4 < 8) {
                            d = zza[i4];
                            byte b2 = bArrCopyOf[zzamhVar.zzb + 9];
                            i5 = (b2 & 96) >> 5;
                            i6 = b2 & Ascii.US;
                            if (i5 != i6) {
                                d *= (((double) i5) + 1.0d) / ((double) (i6 + 1));
                            }
                            j = (long) (1000000.0d / d);
                        }
                        Pair pairCreate = Pair.create(zzzVarZzaj, Long.valueOf(j));
                        this.zzc.zzm((zzz) pairCreate.first);
                        this.zzm = ((Long) pairCreate.second).longValue();
                        this.zzl = true;
                    } else {
                        i2 = i15 * 16;
                        i3 = i13 * 9;
                    }
                    f = i2 / i3;
                    zzx zzxVar2 = new zzx();
                    zzxVar2.zzO(str);
                    zzxVar2.zzE(str2);
                    zzxVar2.zzad("video/mpeg2");
                    zzxVar2.zzai(i13);
                    zzxVar2.zzM(i15);
                    zzxVar2.zzZ(f);
                    zzxVar2.zzP(Collections.singletonList(bArrCopyOf));
                    zzz zzzVarZzaj2 = zzxVar2.zzaj();
                    i4 = (bArrCopyOf[7] & Ascii.SI) - 1;
                    j = 0;
                    if (i4 >= 0) {
                        d = zza[i4];
                        byte b3 = bArrCopyOf[zzamhVar.zzb + 9];
                        i5 = (b3 & 96) >> 5;
                        i6 = b3 & Ascii.US;
                        if (i5 != i6) {
                            d *= (((double) i5) + 1.0d) / ((double) (i6 + 1));
                        }
                        j = (long) (1000000.0d / d);
                    }
                    Pair pairCreate2 = Pair.create(zzzVarZzaj2, Long.valueOf(j));
                    this.zzc.zzm((zzz) pairCreate2.first);
                    this.zzm = ((Long) pairCreate2.second).longValue();
                    this.zzl = true;
                }
            }
            zzamy zzamyVar = this.zzg;
            if (zzamyVar != null) {
                if (i9 > 0) {
                    zzamyVar.zza(bArrZzN, iZzc, iZza);
                    i = 0;
                } else {
                    i = -i9;
                }
                if (zzamyVar.zzd(i)) {
                    int iZzc2 = zzfq.zzc(zzamyVar.zza, zzamyVar.zzb);
                    zzek zzekVar2 = this.zzf;
                    int i16 = zzeu.zza;
                    zzekVar2.zzJ(zzamyVar.zza, iZzc2);
                    this.zzd.zza(this.zzp, zzekVar2);
                }
                if (i8 == 178) {
                    if (zzekVar.zzN()[iZza + 2] == 1) {
                        zzamyVar.zzc(178);
                    }
                    i8 = 178;
                }
            }
            if (i8 == 0 || i8 == 179) {
                int i17 = iZzd - iZza;
                if (this.zzr && this.zzl) {
                    long j2 = this.zzp;
                    if (j2 != -9223372036854775807L) {
                        this.zzc.zzt(j2, this.zzq ? 1 : 0, ((int) (this.zzj - this.zzo)) - i17, i17, null);
                    }
                }
                if (!this.zzk || this.zzr) {
                    this.zzo = this.zzj - ((long) i17);
                    long j3 = this.zzn;
                    if (j3 == -9223372036854775807L) {
                        long j4 = this.zzp;
                        j3 = j4 != -9223372036854775807L ? j4 + this.zzm : -9223372036854775807L;
                    }
                    this.zzp = j3;
                    z = false;
                    this.zzq = false;
                    this.zzn = -9223372036854775807L;
                    z2 = true;
                    this.zzk = true;
                } else {
                    z = false;
                    z2 = true;
                }
                this.zzr = i8 == 0 ? z2 : z;
            } else if (i8 == 184) {
                this.zzq = true;
            }
            iZzc = i7;
            iZzd = iZzd;
        }
        if (!this.zzl) {
            this.zzi.zza(bArrZzN, iZzc, iZzd);
        }
        zzamy zzamyVar2 = this.zzg;
        if (zzamyVar2 != null) {
            zzamyVar2.zza(bArrZzN, iZzc, iZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzb(zzadf zzadfVar, zzanu zzanuVar) {
        zzanuVar.zzc();
        this.zzb = zzanuVar.zzb();
        this.zzc = zzadfVar.zzw(zzanuVar.zza(), 2);
        zzanx zzanxVar = this.zzd;
        if (zzanxVar != null) {
            zzanxVar.zzb(zzadfVar, zzanuVar);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzc(boolean z) {
        zzdc.zzb(this.zzc);
        if (z) {
            boolean z2 = this.zzq;
            long j = this.zzj - this.zzo;
            this.zzc.zzt(this.zzp, z2 ? 1 : 0, (int) j, 0, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzd(long j, int i) {
        this.zzn = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zze() {
        zzfq.zzi(this.zzh);
        this.zzi.zzb();
        zzamy zzamyVar = this.zzg;
        if (zzamyVar != null) {
            zzamyVar.zzb();
        }
        this.zzj = 0L;
        this.zzk = false;
        this.zzn = -9223372036854775807L;
        this.zzp = -9223372036854775807L;
    }
}
