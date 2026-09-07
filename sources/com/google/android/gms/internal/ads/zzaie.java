package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaie {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb;

    static {
        int i = zzeu.zza;
        zzb = "OpusHead".getBytes(StandardCharsets.UTF_8);
    }

    public static int zza(int i) {
        return (i >> 24) & 255;
    }

    public static zzav zzb(zzex zzexVar) {
        zzew zzewVar;
        zzey zzeyVarZzb = zzexVar.zzb(1751411826);
        zzey zzeyVarZzb2 = zzexVar.zzb(1801812339);
        zzey zzeyVarZzb3 = zzexVar.zzb(1768715124);
        if (zzeyVarZzb != null && zzeyVarZzb2 != null && zzeyVarZzb3 != null && zzi(zzeyVarZzb.zza) == 1835299937) {
            zzek zzekVar = zzeyVarZzb2.zza;
            zzekVar.zzL(12);
            int iZzg = zzekVar.zzg();
            String[] strArr = new String[iZzg];
            for (int i = 0; i < iZzg; i++) {
                int iZzg2 = zzekVar.zzg();
                zzekVar.zzM(4);
                strArr[i] = zzekVar.zzB(iZzg2 - 8, StandardCharsets.UTF_8);
            }
            zzek zzekVar2 = zzeyVarZzb3.zza;
            zzekVar2.zzL(8);
            ArrayList arrayList = new ArrayList();
            while (zzekVar2.zza() > 8) {
                int iZzc = zzekVar2.zzc() + zzekVar2.zzg();
                int iZzg3 = zzekVar2.zzg() - 1;
                if (iZzg3 < 0 || iZzg3 >= iZzg) {
                    zzdx.zzf("BoxParsers", "Skipped metadata with unknown key index: " + iZzg3);
                } else {
                    String str = strArr[iZzg3];
                    while (true) {
                        int iZzc2 = zzekVar2.zzc();
                        if (iZzc2 >= iZzc) {
                            zzewVar = null;
                            break;
                        }
                        int iZzg4 = zzekVar2.zzg();
                        if (zzekVar2.zzg() == 1684108385) {
                            int iZzg5 = zzekVar2.zzg();
                            int iZzg6 = zzekVar2.zzg();
                            int i2 = iZzg4 - 16;
                            byte[] bArr = new byte[i2];
                            zzekVar2.zzH(bArr, 0, i2);
                            zzewVar = new zzew(str, bArr, iZzg6, iZzg5);
                            break;
                        }
                        zzekVar2.zzL(iZzc2 + iZzg4);
                    }
                    if (zzewVar != null) {
                        arrayList.add(zzewVar);
                    }
                }
                zzekVar2.zzL(iZzc);
            }
            if (!arrayList.isEmpty()) {
                return new zzav(arrayList);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00da  */
    public static zzav zzc(zzey zzeyVar) {
        int iZzn;
        zzek zzekVar = zzeyVar.zza;
        zzekVar.zzL(8);
        zzav zzavVar = new zzav(-9223372036854775807L, new zzau[0]);
        while (zzekVar.zza() >= 8) {
            int iZzc = zzekVar.zzc();
            int iZzg = zzekVar.zzg() + iZzc;
            int iZzg2 = zzekVar.zzg();
            zzav zzavVar2 = null;
            if (iZzg2 == 1835365473) {
                zzekVar.zzL(iZzc);
                zzekVar.zzM(8);
                zzg(zzekVar);
                while (zzekVar.zzc() < iZzg) {
                    int iZzc2 = zzekVar.zzc();
                    int iZzg3 = zzekVar.zzg() + iZzc2;
                    if (zzekVar.zzg() == 1768715124) {
                        zzekVar.zzL(iZzc2);
                        zzekVar.zzM(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzekVar.zzc() < iZzg3) {
                            zzau zzauVarZza = zzaim.zza(zzekVar);
                            if (zzauVarZza != null) {
                                arrayList.add(zzauVarZza);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            zzavVar2 = new zzav(arrayList);
                            break;
                        }
                        break;
                    }
                    zzekVar.zzL(iZzg3);
                }
                zzavVar = zzavVar.zzd(zzavVar2);
            } else if (iZzg2 == 1936553057) {
                zzekVar.zzL(iZzc);
                zzekVar.zzM(12);
                while (zzekVar.zzc() < iZzg) {
                    int iZzc3 = zzekVar.zzc();
                    int iZzg4 = zzekVar.zzg();
                    if (zzekVar.zzg() == 1935766900) {
                        if (iZzg4 < 16) {
                            break;
                        }
                        zzekVar.zzM(4);
                        int i = -1;
                        int i2 = 0;
                        for (int i3 = 0; i3 < 2; i3++) {
                            int iZzm = zzekVar.zzm();
                            int iZzm2 = zzekVar.zzm();
                            if (iZzm == 0) {
                                i = iZzm2;
                            } else if (iZzm == 1) {
                                i2 = iZzm2;
                            }
                        }
                        if (i == 12) {
                            iZzn = 240;
                        } else if (i == 13) {
                            iZzn = 120;
                        } else if (i == 21 && zzekVar.zza() >= 8 && zzekVar.zzc() + 8 <= iZzg) {
                            int iZzg5 = zzekVar.zzg();
                            int iZzg6 = zzekVar.zzg();
                            if (iZzg5 < 12 || iZzg6 != 1936877170) {
                                iZzn = -2147483647;
                            } else {
                                iZzn = zzekVar.zzn();
                            }
                        } else {
                            iZzn = -2147483647;
                        }
                        if (iZzn == -2147483647) {
                            break;
                        }
                        zzavVar2 = new zzav(-9223372036854775807L, new zzagw(iZzn, i2));
                        break;
                    }
                    zzekVar.zzL(iZzc3 + iZzg4);
                }
                zzavVar = zzavVar.zzd(zzavVar2);
            } else if (iZzg2 == -1451722374) {
                zzavVar = zzavVar.zzd(zzl(zzekVar));
            }
            zzekVar.zzL(iZzg);
        }
        return zzavVar;
    }

    public static zzfc zzd(zzek zzekVar) {
        long jZzt;
        long jZzt2;
        zzekVar.zzL(8);
        if (zza(zzekVar.zzg()) == 0) {
            jZzt = zzekVar.zzu();
            jZzt2 = zzekVar.zzu();
        } else {
            jZzt = zzekVar.zzt();
            jZzt2 = zzekVar.zzt();
        }
        return new zzfc(jZzt, jZzt2, zzekVar.zzu());
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0272 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x0274  */
    /* JADX WARN: Code duplicated, block: B:102:0x0282  */
    /* JADX WARN: Code duplicated, block: B:107:0x02a6 A[DONT_INVERT, LOOP:14: B:107:0x02a6->B:111:0x02b0, LOOP_START, PHI: r16
  0x02a6: PHI (r16v15 int) = (r16v3 int), (r16v16 int) binds: [B:106:0x02a4, B:111:0x02b0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:108:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:111:0x02b0 A[LOOP:14: B:107:0x02a6->B:111:0x02b0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:112:0x02b6 A[EDGE_INSN: B:112:0x02b6->B:113:0x02b7 BREAK  A[LOOP:14: B:107:0x02a6->B:111:0x02b0]] */
    /* JADX WARN: Code duplicated, block: B:114:0x02b9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x02bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x02bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:117:0x02bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:118:0x02c1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:120:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:121:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:122:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:123:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:124:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:126:0x030d  */
    /* JADX WARN: Code duplicated, block: B:129:0x0355  */
    /* JADX WARN: Code duplicated, block: B:130:0x0358  */
    /* JADX WARN: Code duplicated, block: B:283:0x020b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:285:0x0284 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:288:0x01f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:290:0x0237 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:291:0x02b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:292:0x02ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x01b6 A[PHI: r11
  0x01b6: PHI (r11v4 int) = (r11v3 int), (r11v3 int), (r11v22 int), (r11v3 int) binds: [B:40:0x00fe, B:47:0x011a, B:64:0x01b5, B:46:0x0118] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:68:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:70:0x01de  */
    /* JADX WARN: Code duplicated, block: B:72:0x01e4 A[LOOP:12: B:69:0x01dc->B:72:0x01e4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x0223  */
    /* JADX WARN: Code duplicated, block: B:80:0x0228 A[ADDED_TO_REGION, LOOP:13: B:80:0x0228->B:82:0x022c, LOOP_START, PHI: r8 r16 r30
  0x0228: PHI (r8v5 int) = (r8v3 int), (r8v6 int) binds: [B:78:0x0225, B:82:0x022c] A[DONT_GENERATE, DONT_INLINE]
  0x0228: PHI (r16v18 int) = (r16v3 int), (r16v19 int) binds: [B:78:0x0225, B:82:0x022c] A[DONT_GENERATE, DONT_INLINE]
  0x0228: PHI (r30v3 int) = (r30v1 int), (r30v7 int) binds: [B:78:0x0225, B:82:0x022c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:81:0x022a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x022c A[LOOP:13: B:80:0x0228->B:82:0x022c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:88:0x0248  */
    /* JADX WARN: Code duplicated, block: B:91:0x0250  */
    /* JADX WARN: Code duplicated, block: B:92:0x0252  */
    /* JADX WARN: Code duplicated, block: B:95:0x0257  */
    /* JADX WARN: Code duplicated, block: B:97:0x025e  */
    public static zzaiz zze(zzaiw zzaiwVar, zzex zzexVar, zzadq zzadqVar) throws zzaz {
        zzahx zzaibVar;
        boolean z;
        int iZzp;
        int iZzp2;
        int iZzp3;
        long[] jArrCopyOf;
        int[] iArrCopyOf;
        long[] jArrCopyOf2;
        int[] iArrCopyOf2;
        int i;
        zzaiw zzaiwVar2;
        int iZzp4;
        int i2;
        long j;
        long j2;
        int i3;
        int iZzp5;
        int i4;
        int i5;
        int i6;
        boolean z2;
        int i7;
        long[] jArr;
        long j3;
        int[] iArr;
        int i8;
        int[] iArr2;
        long[] jArr2;
        String str;
        long j4;
        boolean zZza;
        int i9;
        int iZzg;
        int iZzc;
        int i10;
        int[] iArr3;
        long[] jArr3;
        int[] iArr4;
        zzz zzzVar;
        long[] jArr4;
        zzaiw zzaiwVarZza;
        int[] iArr5;
        int i11;
        int[] iArr6;
        int i12;
        int[] iArr7;
        int[] iArr8;
        int i13;
        int i14;
        int length;
        long j5;
        zzaiw zzaiwVarZza2 = zzaiwVar;
        zzey zzeyVarZzb = zzexVar.zzb(1937011578);
        if (zzeyVarZzb != null) {
            zzaibVar = new zzaia(zzeyVarZzb, zzaiwVarZza2.zzg);
        } else {
            zzey zzeyVarZzb2 = zzexVar.zzb(1937013298);
            if (zzeyVarZzb2 == null) {
                throw zzaz.zza("Track has no sample table size information", null);
            }
            zzaibVar = new zzaib(zzeyVarZzb2);
        }
        int iZzb = zzaibVar.zzb();
        if (iZzb == 0) {
            return new zzaiz(zzaiwVar, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        if (zzaiwVarZza2.zzb == 2) {
            long j6 = zzaiwVarZza2.zzf;
            if (j6 > 0) {
                zzx zzxVarZzb = zzaiwVarZza2.zzg.zzb();
                zzxVarZzb.zzK(iZzb / (j6 / 1000000.0f));
                zzaiwVarZza2 = zzaiwVarZza2.zza(zzxVarZzb.zzaj());
            }
        }
        zzaiw zzaiwVar3 = zzaiwVarZza2;
        zzey zzeyVarZzb3 = zzexVar.zzb(1937007471);
        if (zzeyVarZzb3 == null) {
            zzeyVarZzb3 = zzexVar.zzb(1668232756);
            zzeyVarZzb3.getClass();
            z = true;
        } else {
            z = false;
        }
        zzey zzeyVarZzb4 = zzexVar.zzb(1937011555);
        zzeyVarZzb4.getClass();
        zzek zzekVar = zzeyVarZzb4.zza;
        zzey zzeyVarZzb5 = zzexVar.zzb(1937011827);
        zzeyVarZzb5.getClass();
        zzek zzekVar2 = zzeyVarZzb5.zza;
        zzey zzeyVarZzb6 = zzexVar.zzb(1937011571);
        zzek zzekVar3 = zzeyVarZzb6 != null ? zzeyVarZzb6.zza : null;
        zzey zzeyVarZzb7 = zzexVar.zzb(1668576371);
        zzek zzekVar4 = zzeyVarZzb7 != null ? zzeyVarZzb7.zza : null;
        zzaht zzahtVar = new zzaht(zzekVar, zzeyVarZzb3.zza, z);
        zzekVar2.zzL(12);
        int iZzp6 = zzekVar2.zzp() - 1;
        int iZzp7 = zzekVar2.zzp();
        int iZzp8 = zzekVar2.zzp();
        if (zzekVar4 != null) {
            zzekVar4.zzL(12);
            iZzp = zzekVar4.zzp();
        } else {
            iZzp = 0;
        }
        if (zzekVar3 != null) {
            zzekVar3.zzL(12);
            iZzp2 = zzekVar3.zzp();
            if (iZzp2 > 0) {
                iZzp3 = zzekVar3.zzp() - 1;
            } else {
                iZzp3 = -1;
                zzekVar3 = null;
            }
        } else {
            iZzp2 = 0;
            iZzp3 = -1;
        }
        int iZza = zzaibVar.zza();
        zzz zzzVar2 = zzaiwVar3.zzg;
        if (iZza != -1) {
            String str2 = zzzVar2.zzo;
            if ((!"audio/raw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/g711-alaw".equals(str2)) || iZzp6 != 0) {
                jArrCopyOf = new long[iZzb];
                iArrCopyOf = new int[iZzb];
                jArrCopyOf2 = new long[iZzb];
                iArrCopyOf2 = new int[iZzb];
                i = iZzp6;
                zzaiwVar2 = zzaiwVar3;
                iZzp4 = iZzp3;
                i2 = 0;
                j = 0;
                j2 = 0;
                i3 = 0;
                iZzp5 = 0;
                i4 = 0;
                i5 = iZzp;
                i6 = 0;
                while (i6 < iZzb) {
                    j4 = j;
                    zZza = true;
                    while (true) {
                        if (i3 != 0) {
                            i9 = i3;
                            break;
                        }
                        zZza = zzahtVar.zza();
                        if (!zZza) {
                            i9 = 0;
                            break;
                        }
                        zzek zzekVar5 = zzekVar2;
                        long j7 = zzahtVar.zzd;
                        i3 = zzahtVar.zzc;
                        j4 = j7;
                        zzekVar2 = zzekVar5;
                        zzekVar3 = zzekVar3;
                        iZzb = iZzb;
                    }
                    if (!zZza) {
                        zzdx.zzf("BoxParsers", "Unexpected end of chunk data");
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i6);
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i6);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i6);
                        iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i6);
                        iZzb = i6;
                        break;
                    }
                    iZzg = i4;
                    if (zzekVar4 != null) {
                        while (iZzp5 == 0) {
                            if (i5 <= 0) {
                                iZzp5 = 0;
                                break;
                            }
                            i5--;
                            iZzp5 = zzekVar4.zzp();
                            iZzg = zzekVar4.zzg();
                        }
                        iZzp5--;
                    }
                    jArrCopyOf[i6] = j4;
                    iZzc = zzaibVar.zzc();
                    iArrCopyOf[i6] = iZzc;
                    if (iZzc > i2) {
                        i2 = iZzc;
                    }
                    jArrCopyOf2[i6] = j2 + ((long) iZzg);
                    if (zzekVar3 == 0) {
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    iArrCopyOf2[i6] = i10;
                    if (i6 == iZzp4) {
                        iArrCopyOf2[i6] = 1;
                        iZzp2--;
                        if (iZzp2 > 0) {
                            zzekVar3.getClass();
                            iZzp4 = zzekVar3.zzp() - 1;
                        }
                    }
                    j2 += (long) iZzp8;
                    iZzp7--;
                    if (iZzp7 == 0) {
                        if (i > 0) {
                            i--;
                            iZzp7 = zzekVar2.zzp();
                            iZzp8 = zzekVar2.zzg();
                        } else {
                            iZzp7 = 0;
                        }
                    }
                    long j8 = j4 + ((long) iArrCopyOf[i6]);
                    i3 = i9 - 1;
                    i6++;
                    i4 = iZzg;
                    iZzb = iZzb;
                    zzekVar2 = zzekVar2;
                    j = j8;
                    zzekVar3 = zzekVar3;
                }
                long j9 = j2 + ((long) i4);
                if (zzekVar4 == null) {
                    z2 = true;
                    break;
                }
                while (true) {
                    if (i5 <= 0) {
                        z2 = true;
                        break;
                    }
                    if (zzekVar4.zzp() != 0) {
                        z2 = false;
                        break;
                    }
                    zzekVar4.zzg();
                    i5--;
                }
                if (iZzp2 == 0) {
                    if (iZzp7 == 0) {
                        if (i3 != 0) {
                            i7 = 0;
                        } else if (i != 0) {
                            z2 = z2;
                            jArrCopyOf = jArrCopyOf;
                            i = i;
                            zzaiwVar2 = zzaiwVar2;
                            iZzp5 = iZzp5;
                            i7 = 0;
                            iZzp2 = 0;
                            i3 = 0;
                        } else if (iZzp5 != 0) {
                            z2 = z2;
                            jArrCopyOf = jArrCopyOf;
                            zzaiwVar2 = zzaiwVar2;
                            iZzp5 = iZzp5;
                            i7 = 0;
                            iZzp2 = 0;
                            i3 = 0;
                            i = 0;
                        } else if (z2) {
                            jArrCopyOf = jArrCopyOf;
                            zzaiwVar2 = zzaiwVar2;
                        } else {
                            jArrCopyOf = jArrCopyOf;
                            zzaiwVar2 = zzaiwVar2;
                            i7 = 0;
                            iZzp2 = 0;
                            i3 = 0;
                            i = 0;
                            iZzp5 = 0;
                            z2 = false;
                        }
                        jArr = jArrCopyOf2;
                        j3 = j9;
                        iZzb = iZzb;
                        iArr = iArrCopyOf;
                        long[] jArr5 = jArrCopyOf;
                        i8 = i2;
                        iArr2 = iArrCopyOf2;
                        jArr2 = jArr5;
                    } else {
                        i7 = iZzp7;
                    }
                    iZzp2 = 0;
                } else {
                    z2 = z2;
                    jArrCopyOf = jArrCopyOf;
                    i7 = iZzp7;
                    i3 = i3;
                    i = i;
                    zzaiwVar2 = zzaiwVar2;
                    iZzp5 = iZzp5;
                }
                int i15 = zzaiwVar2.zza;
                StringBuilder sb = new StringBuilder("Inconsistent stbl box for track ");
                sb.append(i15);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(iZzp2);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i7);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i3);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i);
                sb.append(", remainingSamplesAtTimestampOffset ");
                sb.append(iZzp5);
                if (true != z2) {
                    str = ", ctts invalid";
                } else {
                    str = "";
                }
                sb.append(str);
                zzdx.zzf("BoxParsers", sb.toString());
                jArr = jArrCopyOf2;
                j3 = j9;
                iZzb = iZzb;
                iArr = iArrCopyOf;
                long[] jArr6 = jArrCopyOf;
                i8 = i2;
                iArr2 = iArrCopyOf2;
                jArr2 = jArr6;
            } else if (iZzp == 0 && iZzp2 == 0) {
                int i16 = zzahtVar.zza;
                long[] jArr7 = new long[i16];
                int[] iArr9 = new int[i16];
                while (zzahtVar.zza()) {
                    int i17 = zzahtVar.zzb;
                    jArr7[i17] = zzahtVar.zzd;
                    iArr9[i17] = zzahtVar.zzc;
                }
                long j10 = iZzp8;
                int i18 = 8192 / iZza;
                int i19 = 0;
                for (int i20 = 0; i20 < i16; i20++) {
                    int i21 = iArr9[i20];
                    int i22 = zzeu.zza;
                    i19 += ((i21 + i18) - 1) / i18;
                }
                long[] jArr8 = new long[i19];
                int[] iArr10 = new int[i19];
                long[] jArr9 = new long[i19];
                int[] iArr11 = new int[i19];
                int i23 = 0;
                int i24 = 0;
                i8 = 0;
                int i25 = 0;
                while (i24 < i16) {
                    int i26 = iArr9[i24];
                    long j11 = jArr7[i24];
                    int i27 = i25;
                    int i28 = i16;
                    int iMax = i8;
                    int i29 = i27;
                    long[] jArr10 = jArr7;
                    int i30 = i26;
                    while (i30 > 0) {
                        int iMin = Math.min(i18, i30);
                        jArr8[i29] = j11;
                        int i31 = i18;
                        int i32 = iZza * iMin;
                        iArr10[i29] = i32;
                        iMax = Math.max(iMax, i32);
                        jArr9[i29] = ((long) i23) * j10;
                        iArr11[i29] = 1;
                        j11 += (long) iArr10[i29];
                        i23 += iMin;
                        i30 -= iMin;
                        i29++;
                        i18 = i31;
                        iZza = iZza;
                    }
                    i24++;
                    jArr7 = jArr10;
                    int i33 = i29;
                    i8 = iMax;
                    i16 = i28;
                    i25 = i33;
                }
                j3 = j10 * ((long) i23);
                zzaiwVar2 = zzaiwVar3;
                jArr = jArr9;
                iArr2 = iArr11;
                iArr = iArr10;
                jArr2 = jArr8;
            } else {
                iZzp6 = 0;
                jArrCopyOf = new long[iZzb];
                iArrCopyOf = new int[iZzb];
                jArrCopyOf2 = new long[iZzb];
                iArrCopyOf2 = new int[iZzb];
                i = iZzp6;
                zzaiwVar2 = zzaiwVar3;
                iZzp4 = iZzp3;
                i2 = 0;
                j = 0;
                j2 = 0;
                i3 = 0;
                iZzp5 = 0;
                i4 = 0;
                i5 = iZzp;
                i6 = 0;
                while (i6 < iZzb) {
                    j4 = j;
                    zZza = true;
                    while (true) {
                        if (i3 != 0) {
                            i9 = i3;
                            break;
                        }
                        zZza = zzahtVar.zza();
                        if (!zZza) {
                            i9 = 0;
                            break;
                        }
                        zzek zzekVar6 = zzekVar2;
                        long j12 = zzahtVar.zzd;
                        i3 = zzahtVar.zzc;
                        j4 = j12;
                        zzekVar2 = zzekVar6;
                        zzekVar3 = zzekVar3;
                        iZzb = iZzb;
                    }
                    if (!zZza) {
                        zzdx.zzf("BoxParsers", "Unexpected end of chunk data");
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i6);
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i6);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i6);
                        iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i6);
                        iZzb = i6;
                        break;
                    }
                    iZzg = i4;
                    if (zzekVar4 != null) {
                        while (iZzp5 == 0) {
                            if (i5 <= 0) {
                                iZzp5 = 0;
                                break;
                            }
                            i5--;
                            iZzp5 = zzekVar4.zzp();
                            iZzg = zzekVar4.zzg();
                        }
                        iZzp5--;
                    }
                    jArrCopyOf[i6] = j4;
                    iZzc = zzaibVar.zzc();
                    iArrCopyOf[i6] = iZzc;
                    if (iZzc > i2) {
                        i2 = iZzc;
                    }
                    jArrCopyOf2[i6] = j2 + ((long) iZzg);
                    if (zzekVar3 == 0) {
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    iArrCopyOf2[i6] = i10;
                    if (i6 == iZzp4) {
                        iArrCopyOf2[i6] = 1;
                        iZzp2--;
                        if (iZzp2 > 0) {
                            zzekVar3.getClass();
                            iZzp4 = zzekVar3.zzp() - 1;
                        }
                    }
                    j2 += (long) iZzp8;
                    iZzp7--;
                    if (iZzp7 == 0) {
                        if (i > 0) {
                            i--;
                            iZzp7 = zzekVar2.zzp();
                            iZzp8 = zzekVar2.zzg();
                        } else {
                            iZzp7 = 0;
                        }
                    }
                    long j13 = j4 + ((long) iArrCopyOf[i6]);
                    i3 = i9 - 1;
                    i6++;
                    i4 = iZzg;
                    iZzb = iZzb;
                    zzekVar2 = zzekVar2;
                    j = j13;
                    zzekVar3 = zzekVar3;
                }
                long j14 = j2 + ((long) i4);
                if (zzekVar4 == null) {
                    z2 = true;
                    break;
                }
                while (true) {
                    if (i5 <= 0) {
                        z2 = true;
                        break;
                    }
                    if (zzekVar4.zzp() != 0) {
                        z2 = false;
                        break;
                    }
                    zzekVar4.zzg();
                    i5--;
                }
                if (iZzp2 == 0) {
                    if (iZzp7 == 0) {
                        if (i3 != 0) {
                            i7 = 0;
                        } else if (i != 0) {
                            z2 = z2;
                            jArrCopyOf = jArrCopyOf;
                            i = i;
                            zzaiwVar2 = zzaiwVar2;
                            iZzp5 = iZzp5;
                            i7 = 0;
                            iZzp2 = 0;
                            i3 = 0;
                        } else if (iZzp5 != 0) {
                            z2 = z2;
                            jArrCopyOf = jArrCopyOf;
                            zzaiwVar2 = zzaiwVar2;
                            iZzp5 = iZzp5;
                            i7 = 0;
                            iZzp2 = 0;
                            i3 = 0;
                            i = 0;
                        } else if (z2) {
                            jArrCopyOf = jArrCopyOf;
                            zzaiwVar2 = zzaiwVar2;
                            i7 = 0;
                            iZzp2 = 0;
                            i3 = 0;
                            i = 0;
                            iZzp5 = 0;
                            z2 = false;
                        } else {
                            jArrCopyOf = jArrCopyOf;
                            zzaiwVar2 = zzaiwVar2;
                        }
                        jArr = jArrCopyOf2;
                        j3 = j14;
                        iZzb = iZzb;
                        iArr = iArrCopyOf;
                        long[] jArr11 = jArrCopyOf;
                        i8 = i2;
                        iArr2 = iArrCopyOf2;
                        jArr2 = jArr11;
                    } else {
                        i7 = iZzp7;
                    }
                    iZzp2 = 0;
                } else {
                    z2 = z2;
                    jArrCopyOf = jArrCopyOf;
                    i7 = iZzp7;
                    i3 = i3;
                    i = i;
                    zzaiwVar2 = zzaiwVar2;
                    iZzp5 = iZzp5;
                }
                int i110 = zzaiwVar2.zza;
                StringBuilder sb2 = new StringBuilder("Inconsistent stbl box for track ");
                sb2.append(i110);
                sb2.append(": remainingSynchronizationSamples ");
                sb2.append(iZzp2);
                sb2.append(", remainingSamplesAtTimestampDelta ");
                sb2.append(i7);
                sb2.append(", remainingSamplesInChunk ");
                sb2.append(i3);
                sb2.append(", remainingTimestampDeltaChanges ");
                sb2.append(i);
                sb2.append(", remainingSamplesAtTimestampOffset ");
                sb2.append(iZzp5);
                if (true != z2) {
                    str = ", ctts invalid";
                } else {
                    str = "";
                }
                sb2.append(str);
                zzdx.zzf("BoxParsers", sb2.toString());
                jArr = jArrCopyOf2;
                j3 = j14;
                iZzb = iZzb;
                iArr = iArrCopyOf;
                long[] jArr12 = jArrCopyOf;
                i8 = i2;
                iArr2 = iArrCopyOf2;
                jArr2 = jArr12;
            }
        } else {
            jArrCopyOf = new long[iZzb];
            iArrCopyOf = new int[iZzb];
            jArrCopyOf2 = new long[iZzb];
            iArrCopyOf2 = new int[iZzb];
            i = iZzp6;
            zzaiwVar2 = zzaiwVar3;
            iZzp4 = iZzp3;
            i2 = 0;
            j = 0;
            j2 = 0;
            i3 = 0;
            iZzp5 = 0;
            i4 = 0;
            i5 = iZzp;
            i6 = 0;
            while (i6 < iZzb) {
                j4 = j;
                zZza = true;
                while (true) {
                    if (i3 != 0) {
                        i9 = i3;
                        break;
                    }
                    zZza = zzahtVar.zza();
                    if (!zZza) {
                        i9 = 0;
                        break;
                    }
                    zzek zzekVar7 = zzekVar2;
                    long j15 = zzahtVar.zzd;
                    i3 = zzahtVar.zzc;
                    j4 = j15;
                    zzekVar2 = zzekVar7;
                    zzekVar3 = zzekVar3;
                    iZzb = iZzb;
                }
                if (!zZza) {
                    zzdx.zzf("BoxParsers", "Unexpected end of chunk data");
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i6);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i6);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i6);
                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i6);
                    iZzb = i6;
                    break;
                }
                iZzg = i4;
                if (zzekVar4 != null) {
                    while (iZzp5 == 0) {
                        if (i5 <= 0) {
                            iZzp5 = 0;
                            break;
                        }
                        i5--;
                        iZzp5 = zzekVar4.zzp();
                        iZzg = zzekVar4.zzg();
                    }
                    iZzp5--;
                }
                jArrCopyOf[i6] = j4;
                iZzc = zzaibVar.zzc();
                iArrCopyOf[i6] = iZzc;
                if (iZzc > i2) {
                    i2 = iZzc;
                }
                jArrCopyOf2[i6] = j2 + ((long) iZzg);
                if (zzekVar3 == 0) {
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                iArrCopyOf2[i6] = i10;
                if (i6 == iZzp4) {
                    iArrCopyOf2[i6] = 1;
                    iZzp2--;
                    if (iZzp2 > 0) {
                        zzekVar3.getClass();
                        iZzp4 = zzekVar3.zzp() - 1;
                    }
                }
                j2 += (long) iZzp8;
                iZzp7--;
                if (iZzp7 == 0) {
                    if (i > 0) {
                        i--;
                        iZzp7 = zzekVar2.zzp();
                        iZzp8 = zzekVar2.zzg();
                    } else {
                        iZzp7 = 0;
                    }
                }
                long j16 = j4 + ((long) iArrCopyOf[i6]);
                i3 = i9 - 1;
                i6++;
                i4 = iZzg;
                iZzb = iZzb;
                zzekVar2 = zzekVar2;
                j = j16;
                zzekVar3 = zzekVar3;
            }
            long j17 = j2 + ((long) i4);
            if (zzekVar4 == null) {
                z2 = true;
                break;
            }
            while (true) {
                if (i5 <= 0) {
                    z2 = true;
                    break;
                }
                if (zzekVar4.zzp() != 0) {
                    z2 = false;
                    break;
                }
                zzekVar4.zzg();
                i5--;
            }
            if (iZzp2 == 0) {
                if (iZzp7 == 0) {
                    if (i3 != 0) {
                        i7 = 0;
                    } else if (i != 0) {
                        z2 = z2;
                        jArrCopyOf = jArrCopyOf;
                        i = i;
                        zzaiwVar2 = zzaiwVar2;
                        iZzp5 = iZzp5;
                        i7 = 0;
                        iZzp2 = 0;
                        i3 = 0;
                    } else if (iZzp5 != 0) {
                        z2 = z2;
                        jArrCopyOf = jArrCopyOf;
                        zzaiwVar2 = zzaiwVar2;
                        iZzp5 = iZzp5;
                        i7 = 0;
                        iZzp2 = 0;
                        i3 = 0;
                        i = 0;
                    } else if (z2) {
                        jArrCopyOf = jArrCopyOf;
                        zzaiwVar2 = zzaiwVar2;
                        i7 = 0;
                        iZzp2 = 0;
                        i3 = 0;
                        i = 0;
                        iZzp5 = 0;
                        z2 = false;
                    } else {
                        jArrCopyOf = jArrCopyOf;
                        zzaiwVar2 = zzaiwVar2;
                    }
                    jArr = jArrCopyOf2;
                    j3 = j17;
                    iZzb = iZzb;
                    iArr = iArrCopyOf;
                    long[] jArr13 = jArrCopyOf;
                    i8 = i2;
                    iArr2 = iArrCopyOf2;
                    jArr2 = jArr13;
                } else {
                    i7 = iZzp7;
                }
                iZzp2 = 0;
            } else {
                z2 = z2;
                jArrCopyOf = jArrCopyOf;
                i7 = iZzp7;
                i3 = i3;
                i = i;
                zzaiwVar2 = zzaiwVar2;
                iZzp5 = iZzp5;
            }
            int i111 = zzaiwVar2.zza;
            StringBuilder sb3 = new StringBuilder("Inconsistent stbl box for track ");
            sb3.append(i111);
            sb3.append(": remainingSynchronizationSamples ");
            sb3.append(iZzp2);
            sb3.append(", remainingSamplesAtTimestampDelta ");
            sb3.append(i7);
            sb3.append(", remainingSamplesInChunk ");
            sb3.append(i3);
            sb3.append(", remainingTimestampDeltaChanges ");
            sb3.append(i);
            sb3.append(", remainingSamplesAtTimestampOffset ");
            sb3.append(iZzp5);
            if (true != z2) {
                str = ", ctts invalid";
            } else {
                str = "";
            }
            sb3.append(str);
            zzdx.zzf("BoxParsers", sb3.toString());
            jArr = jArrCopyOf2;
            j3 = j17;
            iZzb = iZzb;
            iArr = iArrCopyOf;
            long[] jArr14 = jArrCopyOf;
            i8 = i2;
            iArr2 = iArrCopyOf2;
            jArr2 = jArr14;
        }
        long j18 = zzaiwVar2.zzc;
        long[] jArr15 = zzaiwVar2.zzi;
        int[] iArr12 = iArr2;
        long jZzu = zzeu.zzu(j3, 1000000L, j18, RoundingMode.DOWN);
        if (jArr15 == null) {
            zzeu.zzG(jArr, 1000000L, j18);
            return new zzaiz(zzaiwVar2, jArr2, iArr, i8, jArr, iArr12, jZzu);
        }
        int length2 = jArr15.length;
        int i34 = 1;
        if (length2 == 1) {
            if (zzaiwVar2.zzb != 1 || (length = jArr.length) < 2) {
                iArr3 = iArr12;
                jArr3 = jArr2;
                iArr4 = iArr;
                zzzVar = zzzVar2;
                jArr4 = jArr15;
            } else {
                long[] jArr16 = zzaiwVar2.zzj;
                jArr16.getClass();
                long j19 = jArr16[0];
                long j20 = jArr15[0];
                long j21 = zzaiwVar2.zzd;
                iArr3 = iArr12;
                jArr3 = jArr2;
                iArr4 = iArr;
                long jZzu2 = j19 + zzeu.zzu(j20, j18, j21, RoundingMode.DOWN);
                int i35 = length - 1;
                int iMax2 = Math.max(0, Math.min(4, i35));
                int iMax3 = Math.max(0, Math.min(length - 4, i35));
                long j22 = jArr[0];
                if (j22 > j19 || j19 >= jArr[iMax2] || jArr[iMax3] >= jZzu2 || jZzu2 > j3) {
                    zzzVar = zzzVar2;
                } else {
                    long j23 = zzzVar2.zzF;
                    zzzVar = zzzVar2;
                    long jZzu3 = zzeu.zzu(j19 - j22, j23, j18, RoundingMode.DOWN);
                    long jZzu4 = zzeu.zzu(j3 - jZzu2, j23, j18, RoundingMode.DOWN);
                    if (jZzu3 != 0) {
                        j5 = jZzu3;
                    } else if (jZzu4 != 0) {
                        j5 = 0;
                    }
                    if (j5 <= 2147483647L && jZzu4 <= 2147483647L) {
                        zzadqVar.zza = (int) j5;
                        zzadqVar.zzb = (int) jZzu4;
                        zzeu.zzG(jArr, 1000000L, j18);
                        return new zzaiz(zzaiwVar2, jArr3, iArr4, i8, jArr, iArr3, zzeu.zzu(jArr15[0], 1000000L, j21, RoundingMode.DOWN));
                    }
                }
                jArr4 = jArr15;
            }
            length2 = 1;
            i34 = 1;
        } else {
            iArr3 = iArr12;
            jArr3 = jArr2;
            iArr4 = iArr;
            zzzVar = zzzVar2;
            jArr4 = jArr15;
        }
        if (length2 == i34 && jArr4[0] == 0) {
            long[] jArr17 = zzaiwVar2.zzj;
            jArr17.getClass();
            long j24 = jArr17[0];
            for (int i36 = 0; i36 < jArr.length; i36++) {
                jArr[i36] = zzeu.zzu(jArr[i36] - j24, 1000000L, j18, RoundingMode.DOWN);
            }
            return new zzaiz(zzaiwVar2, jArr3, iArr4, i8, jArr, iArr3, zzeu.zzu(j3 - j24, 1000000L, j18, RoundingMode.DOWN));
        }
        int i37 = zzaiwVar2.zzb;
        boolean z3 = i37 == 1;
        long[] jArr18 = zzaiwVar2.zzj;
        int[] iArr13 = new int[length2];
        int[] iArr14 = new int[length2];
        jArr18.getClass();
        long[] jArr19 = jArr18;
        int i38 = 0;
        int i39 = 0;
        int i40 = 0;
        boolean z4 = false;
        while (i40 < jArr4.length) {
            long j25 = jArr19[i40];
            if (j25 != -1) {
                iArr6 = iArr14;
                int i41 = i39;
                int i42 = i38;
                i12 = i40;
                iArr7 = iArr13;
                long jZzu5 = zzeu.zzu(jArr4[i40], j18, zzaiwVar2.zzd, RoundingMode.DOWN);
                int i43 = 1;
                iArr7[i12] = zzeu.zzd(jArr, j25, true, true);
                long j26 = jZzu5 + j25;
                iArr6[i12] = zzeu.zza(jArr, j26, z3, false);
                int i44 = iArr7[i12];
                while (true) {
                    i14 = iArr7[i12];
                    iArr8 = iArr3;
                    if (i14 < 0 || (iArr8[i14] & i43) != 0) {
                        break;
                    }
                    iArr7[i12] = i14 - 1;
                    iArr3 = iArr8;
                    i43 = 1;
                }
                if (i14 < 0) {
                    iArr7[i12] = i44;
                    while (true) {
                        i14 = iArr7[i12];
                        if (i14 >= iArr6[i12] || (iArr8[i14] & 1) != 0) {
                            break;
                        }
                        iArr7[i12] = i14 + 1;
                    }
                }
                if (i37 == 2 && i14 != iArr6[i12]) {
                    while (true) {
                        int i45 = iArr6[i12];
                        if (i45 >= jArr.length - 1) {
                            break;
                        }
                        int i46 = i45 + 1;
                        if (jArr[i46] > j26) {
                            break;
                        }
                        iArr6[i12] = i46;
                    }
                }
                int i47 = iArr6[i12];
                int i48 = iArr7[i12];
                int i49 = (i47 - i48) + i42;
                z4 |= i41 != i48;
                i13 = i49;
                i39 = i47;
            } else {
                iArr6 = iArr14;
                i12 = i40;
                iArr7 = iArr13;
                iArr8 = iArr3;
                i13 = i38;
            }
            i40 = i12 + 1;
            i38 = i13;
            iArr3 = iArr8;
            iArr14 = iArr6;
            iZzb = iZzb;
            iArr13 = iArr7;
            zzaiwVar2 = zzaiwVar2;
            jArr18 = jArr18;
            jArr4 = jArr4;
        }
        int[] iArr15 = iArr14;
        int[] iArr16 = iArr13;
        long[] jArr20 = jArr4;
        long[] jArr21 = jArr18;
        zzaiw zzaiwVar4 = zzaiwVar2;
        int[] iArr17 = iArr3;
        int i50 = i38;
        boolean z5 = z4 | (i50 != iZzb);
        long[] jArr22 = z5 ? new long[i50] : jArr3;
        int[] iArr18 = z5 ? new int[i50] : iArr4;
        if (true == z5) {
            i8 = 0;
        }
        int[] iArr19 = z5 ? new int[i50] : iArr17;
        long[] jArr23 = new long[i50];
        int i51 = 0;
        boolean z6 = false;
        int i52 = 0;
        int i53 = i8;
        long[] jArr24 = jArr20;
        long j27 = 0;
        while (i52 < jArr24.length) {
            long j28 = jArr21[i52];
            int i54 = iArr16[i52];
            int i55 = iArr15[i52];
            if (z5) {
                int i56 = i55 - i54;
                System.arraycopy(jArr3, i54, jArr22, i51, i56);
                iArr5 = iArr4;
                System.arraycopy(iArr5, i54, iArr18, i51, i56);
                System.arraycopy(iArr17, i54, iArr19, i51, i56);
            } else {
                iArr5 = iArr4;
            }
            int i57 = i53;
            int i58 = i51;
            boolean z7 = z6;
            while (i54 < i55) {
                int[] iArr20 = iArr5;
                zzaiw zzaiwVar5 = zzaiwVar4;
                long jZzu6 = zzeu.zzu(j27, 1000000L, zzaiwVar5.zzd, RoundingMode.DOWN);
                long[] jArr25 = jArr;
                int i59 = i54;
                int i60 = i57;
                int i61 = i52;
                long[] jArr26 = jArr24;
                int[] iArr21 = iArr19;
                long jZzu7 = zzeu.zzu(jArr[i54] - j28, 1000000L, j18, RoundingMode.DOWN);
                z7 = (!(jZzu7 >= 0)) | z7;
                jArr23[i58] = jZzu6 + jZzu7;
                if (z5) {
                    i11 = i60;
                    if (iArr18[i58] > i11) {
                        i57 = iArr20[i59];
                    }
                    i58++;
                    zzaiwVar4 = zzaiwVar5;
                    i54 = i59 + 1;
                    jArr24 = jArr26;
                    i52 = i61;
                    iArr19 = iArr21;
                    iArr5 = iArr20;
                    jArr = jArr25;
                } else {
                    i11 = i60;
                }
                i57 = i11;
                i58++;
                zzaiwVar4 = zzaiwVar5;
                i54 = i59 + 1;
                jArr24 = jArr26;
                i52 = i61;
                iArr19 = iArr21;
                iArr5 = iArr20;
                jArr = jArr25;
            }
            iArr4 = iArr5;
            int i62 = i57;
            int i63 = i52;
            long[] jArr27 = jArr24;
            j27 += jArr27[i63];
            i52 = i63 + 1;
            i53 = i62;
            jArr24 = jArr27;
            i51 = i58;
            z6 = z7;
            jArr = jArr;
        }
        int i64 = i53;
        int[] iArr22 = iArr19;
        zzaiw zzaiwVar6 = zzaiwVar4;
        long jZzu8 = zzeu.zzu(j27, 1000000L, zzaiwVar6.zzd, RoundingMode.DOWN);
        if (z6) {
            zzx zzxVarZzb2 = zzzVar.zzb();
            zzxVarZzb2.zzL(true);
            zzaiwVarZza = zzaiwVar6.zza(zzxVarZzb2.zzaj());
        } else {
            zzaiwVarZza = zzaiwVar6;
        }
        return new zzaiz(zzaiwVarZza, jArr22, iArr18, i64, jArr23, iArr22, jZzu8);
    }

    /* JADX WARN: Code duplicated, block: B:586:0x0d65  */
    /* JADX WARN: Code duplicated, block: B:587:0x0d69  */
    /* JADX WARN: Code duplicated, block: B:590:0x0d9e  */
    /* JADX WARN: Code duplicated, block: B:591:0x0dd1  */
    /* JADX WARN: Code duplicated, block: B:63:0x0125 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x0127 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x0129 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x012b  */
    /* JADX WARN: Code duplicated, block: B:67:0x012e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0131  */
    /* JADX WARN: Code duplicated, block: B:71:0x0134  */
    /* JADX WARN: Code duplicated, block: B:77:0x0140  */
    /* JADX WARN: Multi-variable type inference failed */
    public static List zzf(zzex zzexVar, zzadq zzadqVar, long j, zzs zzsVar, boolean z, boolean z2, zzftl zzftlVar) throws zzaz {
        int i;
        long jZzu;
        long j2;
        int i2;
        long j3;
        String str;
        int i3;
        ArrayList arrayList;
        zzex zzexVar2;
        long[] jArr;
        long[] jArr2;
        zzz zzzVar;
        zzaiw zzaiwVar;
        Pair pairCreate;
        zzek zzekVar;
        zzs zzsVarZzb;
        int i4;
        String str2;
        byte b;
        char c;
        String str3;
        int i5;
        int i6;
        int i7;
        zzahz zzahzVar;
        String str4;
        List list;
        int i8;
        zzfn zzfnVar;
        boolean z3;
        String str5;
        boolean z4;
        String str6;
        boolean z5;
        char c2;
        int i9;
        boolean z6;
        int i10;
        String str7;
        int i11;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        String str8;
        long j4;
        zzfww zzfwwVarZzo;
        zzaiw zzaiwVar2;
        ArrayList arrayList2;
        ArrayList arrayList3 = new ArrayList();
        int i12 = 0;
        while (true) {
            List list2 = zzexVar.zzc;
            if (i12 >= list2.size()) {
                return arrayList3;
            }
            zzex zzexVar3 = (zzex) list2.get(i12);
            if (zzexVar3.zzd != 1953653099) {
                arrayList2 = arrayList3;
                i3 = i12;
            } else {
                zzey zzeyVarZzb = zzexVar.zzb(1836476516);
                zzeyVarZzb.getClass();
                zzex zzexVarZza = zzexVar3.zza(1835297121);
                zzexVarZza.getClass();
                zzey zzeyVarZzb2 = zzexVarZza.zzb(1751411826);
                zzeyVarZzb2.getClass();
                int iZzi = zzi(zzeyVarZzb2.zza);
                if (iZzi == 1936684398) {
                    i = 1;
                } else if (iZzi == 1986618469) {
                    i = 2;
                } else if (iZzi == 1952807028 || iZzi == 1935832172 || iZzi == 1937072756 || iZzi == 1668047728) {
                    i = 3;
                } else {
                    i = iZzi == 1835365473 ? 5 : -1;
                }
                if (i == -1) {
                    arrayList = arrayList3;
                    i3 = i12;
                    zzexVar2 = zzexVar3;
                } else {
                    zzey zzeyVarZzb3 = zzexVar3.zzb(1953196132);
                    zzeyVarZzb3.getClass();
                    zzek zzekVar2 = zzeyVarZzb3.zza;
                    zzekVar2.zzL(8);
                    int iZza = zza(zzekVar2.zzg());
                    zzekVar2.zzM(iZza == 0 ? 8 : 16);
                    int iZzg = zzekVar2.zzg();
                    zzekVar2.zzM(4);
                    int iZzc = zzekVar2.zzc();
                    int i13 = 0;
                    while (true) {
                        int i14 = iZza == 0 ? 4 : 8;
                        jZzu = -9223372036854775807L;
                        if (i13 >= i14) {
                            zzekVar2.zzM(i14);
                        } else {
                            if (zzekVar2.zzN()[iZzc + i13] != -1) {
                                long jZzu2 = iZza == 0 ? zzekVar2.zzu() : zzekVar2.zzw();
                                if (jZzu2 != 0) {
                                    j2 = jZzu2;
                                    break;
                                }
                                break;
                            }
                            i13++;
                        }
                        j2 = -9223372036854775807L;
                        break;
                    }
                    zzekVar2.zzM(16);
                    int iZzg2 = zzekVar2.zzg();
                    int iZzg3 = zzekVar2.zzg();
                    zzekVar2.zzM(4);
                    int iZzg4 = zzekVar2.zzg();
                    int iZzg5 = zzekVar2.zzg();
                    int i15 = 65536;
                    if (iZzg2 != 0) {
                        if (iZzg2 == 0) {
                            if (iZzg3 == -65536) {
                                if (iZzg4 == 65536) {
                                    i15 = iZzg4;
                                } else if (iZzg5 == 0) {
                                    i2 = 270;
                                }
                                iZzg3 = -65536;
                            } else {
                                i15 = iZzg4;
                            }
                            iZzg2 = 0;
                        } else {
                            i15 = iZzg4;
                        }
                        if (iZzg2 != -65536 && iZzg3 == 0 && i15 == 0 && iZzg5 == -65536) {
                            i2 = 180;
                        } else {
                            i2 = 0;
                        }
                    } else {
                        if (iZzg3 == 65536) {
                            if (iZzg4 == -65536) {
                                if (iZzg5 == 0) {
                                    i2 = 90;
                                } else {
                                    iZzg4 = -65536;
                                }
                            }
                            iZzg3 = 65536;
                        }
                        iZzg2 = 0;
                        if (iZzg2 == 0) {
                            if (iZzg3 == -65536) {
                                if (iZzg4 == 65536) {
                                    i15 = iZzg4;
                                } else if (iZzg5 == 0) {
                                    i2 = 270;
                                }
                                iZzg3 = -65536;
                            } else {
                                i15 = iZzg4;
                            }
                            iZzg2 = 0;
                        } else {
                            i15 = iZzg4;
                        }
                        if (iZzg2 != -65536) {
                            i2 = 0;
                        } else {
                            i2 = 0;
                        }
                    }
                    zzaic zzaicVar = new zzaic(iZzg, j2, i2);
                    long j5 = j == -9223372036854775807L ? zzaicVar.zzb : j;
                    long j6 = zzd(zzeyVarZzb.zza).zzc;
                    long jZzu3 = j5 == -9223372036854775807L ? -9223372036854775807L : zzeu.zzu(j5, 1000000L, j6, RoundingMode.DOWN);
                    zzex zzexVarZza2 = zzexVarZza.zza(1835626086);
                    zzexVarZza2.getClass();
                    zzex zzexVarZza3 = zzexVarZza2.zza(1937007212);
                    zzexVarZza3.getClass();
                    zzey zzeyVarZzb4 = zzexVarZza.zzb(1835296868);
                    zzeyVarZzb4.getClass();
                    zzek zzekVar3 = zzeyVarZzb4.zza;
                    zzekVar3.zzL(8);
                    int iZza2 = zza(zzekVar3.zzg());
                    zzekVar3.zzM(iZza2 == 0 ? 8 : 16);
                    long jZzu4 = zzekVar3.zzu();
                    int iZzc2 = zzekVar3.zzc();
                    int i16 = 0;
                    while (true) {
                        int i17 = iZza2 == 0 ? 4 : 8;
                        if (i16 >= i17) {
                            j3 = j6;
                            zzekVar3.zzM(i17);
                            break;
                        }
                        j3 = j6;
                        if (zzekVar3.zzN()[iZzc2 + i16] != -1) {
                            long jZzu5 = iZza2 == 0 ? zzekVar3.zzu() : zzekVar3.zzw();
                            if (jZzu5 == 0) {
                                break;
                            }
                            jZzu = zzeu.zzu(jZzu5, 1000000L, jZzu4, RoundingMode.DOWN);
                            break;
                        }
                        i16++;
                        j6 = j3;
                    }
                    long j7 = jZzu;
                    int iZzq = zzekVar3.zzq();
                    char[] cArr = {(char) (((iZzq >> 10) & 31) + 96), (char) (((iZzq >> 5) & 31) + 96), (char) ((iZzq & 31) + 96)};
                    int i18 = 0;
                    while (true) {
                        if (i18 >= 3) {
                            str = new String(cArr);
                            break;
                        }
                        char c3 = cArr[i18];
                        if (c3 < 'a' || c3 > 'z') {
                            str = null;
                            break;
                        }
                        i18++;
                    }
                    zzahw zzahwVar = new zzahw(jZzu4, j7, str);
                    zzey zzeyVarZzb5 = zzexVarZza3.zzb(1937011556);
                    if (zzeyVarZzb5 == null) {
                        throw zzaz.zza("Malformed sample table (stbl) missing sample description (stsd)", null);
                    }
                    int i19 = zzaicVar.zza;
                    int i20 = zzaicVar.zzc;
                    String str9 = zzahwVar.zzc;
                    zzek zzekVar4 = zzeyVarZzb5.zza;
                    zzekVar4.zzL(12);
                    int iZzg6 = zzekVar4.zzg();
                    zzahz zzahzVar2 = new zzahz(iZzg6);
                    i3 = i12;
                    int i21 = 0;
                    while (i21 < iZzg6) {
                        ArrayList arrayList4 = arrayList3;
                        int iZzc3 = zzekVar4.zzc();
                        zzahw zzahwVar2 = zzahwVar;
                        int iZzg7 = zzekVar4.zzg();
                        String str10 = "childAtomSize must be positive";
                        zzadg.zzb(iZzg7 > 0, "childAtomSize must be positive");
                        int iZzg8 = zzekVar4.zzg();
                        int i22 = iZzg6;
                        if (iZzg8 == 1635148593 || iZzg8 == 1635148595 || iZzg8 == 1701733238 || iZzg8 == 1831958048 || iZzg8 == 1836070006 || iZzg8 == 1752589105 || iZzg8 == 1751479857 || iZzg8 == 1932670515 || iZzg8 == 1211250227 || iZzg8 == 1748121139 || iZzg8 == 1987063864 || iZzg8 == 1987063865 || iZzg8 == 1635135537 || iZzg8 == 1685479798 || iZzg8 == 1685479729 || iZzg8 == 1685481573 || iZzg8 == 1685481521 || iZzg8 == 1634760241) {
                            zzahz zzahzVar3 = zzahzVar2;
                            String str11 = str9;
                            i = i;
                            int i23 = i20;
                            int i24 = i19;
                            zzaicVar = zzaicVar;
                            zzexVar3 = zzexVar3;
                            j3 = j3;
                            zzekVar = zzekVar4;
                            zzekVar.zzL(iZzc3 + 16);
                            zzekVar.zzM(16);
                            int iZzq2 = zzekVar.zzq();
                            int iZzq3 = zzekVar.zzq();
                            zzekVar.zzM(50);
                            int iZzc4 = zzekVar.zzc();
                            if (iZzg8 == 1701733238) {
                                Pair pairZzj = zzj(zzekVar, iZzc3, iZzg7);
                                if (pairZzj != null) {
                                    int iIntValue = ((Integer) pairZzj.first).intValue();
                                    zzsVarZzb = zzsVar == null ? null : zzsVar.zzb(((zzaix) pairZzj.second).zzb);
                                    zzahzVar3.zza[i21] = (zzaix) pairZzj.second;
                                    iZzg8 = iIntValue;
                                } else {
                                    zzahzVar3 = zzahzVar3;
                                    iZzg8 = 1701733238;
                                    zzsVarZzb = zzsVar;
                                }
                                zzekVar.zzL(iZzc4);
                            } else {
                                zzahzVar3 = zzahzVar3;
                                zzsVarZzb = zzsVar;
                            }
                            if (iZzg8 == 1831958048) {
                                int i25 = iZzg8;
                                str2 = "video/mpeg";
                                i4 = i25;
                            } else {
                                i4 = 1211250227;
                                if (iZzg8 == 1211250227) {
                                    str2 = "video/3gpp";
                                } else {
                                    i4 = iZzg8;
                                    str2 = null;
                                }
                            }
                            int i26 = i4;
                            int i27 = iZzc4;
                            zzs zzsVar2 = zzsVarZzb;
                            float fZzp = 1.0f;
                            i21 = i21;
                            int iZzb = -1;
                            int i28 = -1;
                            int i29 = 8;
                            zzfn zzfnVar2 = null;
                            int i30 = 8;
                            int i31 = -1;
                            List listZzo = null;
                            int i32 = -1;
                            ByteBuffer byteBufferZzo = null;
                            zzahs zzahsVarZzm = null;
                            zzahu zzahuVar = null;
                            boolean z11 = false;
                            byte[] bArrCopyOfRange = null;
                            int i33 = -1;
                            int i34 = -1;
                            String str12 = null;
                            while (i27 - iZzc3 < iZzg7) {
                                zzekVar.zzL(i27);
                                int iZzc5 = zzekVar.zzc();
                                int iZzg9 = zzekVar.zzg();
                                if (iZzg9 != 0) {
                                    i5 = iZzg9;
                                } else {
                                    if (zzekVar.zzc() - iZzc3 == iZzg7) {
                                        break;
                                    }
                                    i5 = 0;
                                }
                                zzadg.zzb(i5 > 0, str10);
                                int iZzg10 = zzekVar.zzg();
                                int i35 = iZzc3;
                                if (iZzg10 == 1635148611) {
                                    int i36 = iZzc5 + 8;
                                    zzadg.zzb(str2 == null, null);
                                    zzekVar.zzL(i36);
                                    zzacg zzacgVarZza = zzacg.zza(zzekVar);
                                    List list3 = zzacgVarZza.zza;
                                    zzahzVar3.zzc = zzacgVarZza.zzb;
                                    if (z11) {
                                        z10 = true;
                                    } else {
                                        fZzp = zzacgVarZza.zzk;
                                        z10 = false;
                                    }
                                    String str13 = zzacgVarZza.zzl;
                                    int i37 = zzacgVarZza.zzj;
                                    int i38 = zzacgVarZza.zzg;
                                    int i39 = zzacgVarZza.zzh;
                                    int i40 = zzacgVarZza.zzi;
                                    z11 = z10;
                                    str12 = str13;
                                    i33 = i37;
                                    zzahzVar = zzahzVar3;
                                    i6 = i39;
                                    str4 = str10;
                                    i7 = zzacgVarZza.zze;
                                    str2 = "video/avc";
                                    i8 = i26;
                                    i30 = zzacgVarZza.zzf;
                                    listZzo = list3;
                                    iZzb = i40;
                                    i31 = i38;
                                } else if (iZzg10 == 1752589123) {
                                    int i41 = iZzc5 + 8;
                                    zzadg.zzb(str2 == null, null);
                                    zzekVar.zzL(i41);
                                    zzadr zzadrVarZza = zzadr.zza(zzekVar);
                                    List list4 = zzadrVarZza.zza;
                                    zzahzVar3.zzc = zzadrVarZza.zzb;
                                    if (z11) {
                                        z9 = true;
                                    } else {
                                        fZzp = zzadrVarZza.zzj;
                                        z9 = false;
                                    }
                                    int i42 = zzadrVarZza.zzk;
                                    int i43 = zzadrVarZza.zzc;
                                    String str14 = zzadrVarZza.zzl;
                                    int i44 = zzadrVarZza.zzi;
                                    if (i44 != -1) {
                                        i32 = i44;
                                    }
                                    int i45 = zzadrVarZza.zzf;
                                    int i46 = zzadrVarZza.zzg;
                                    int i47 = zzadrVarZza.zzh;
                                    int i48 = zzadrVarZza.zzd;
                                    i33 = i42;
                                    i34 = i43;
                                    str12 = str14;
                                    zzahzVar = zzahzVar3;
                                    i6 = i46;
                                    str4 = str10;
                                    i30 = zzadrVarZza.zze;
                                    i7 = i48;
                                    str2 = "video/hevc";
                                    i8 = i26;
                                    listZzo = list4;
                                    z11 = z9;
                                    iZzb = i47;
                                    i31 = i45;
                                    zzfnVar2 = zzadrVarZza.zzm;
                                } else if (iZzg10 == 1818785347) {
                                    int i49 = iZzc5 + 8;
                                    zzadg.zzb("video/hevc".equals(str2), "lhvC must follow hvcC atom");
                                    if (zzfnVar2 != null) {
                                        z8 = zzfnVar2.zza.size() >= 2;
                                    } else {
                                        z8 = false;
                                        zzfnVar2 = null;
                                    }
                                    zzadg.zzb(z8, "must have at least two layers");
                                    zzekVar.zzL(i49);
                                    zzfnVar2.getClass();
                                    zzadr zzadrVarZzb = zzadr.zzb(zzekVar, zzfnVar2);
                                    zzadg.zzb(zzahzVar3.zzc == zzadrVarZzb.zzb, "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms");
                                    int i50 = zzadrVarZzb.zzf;
                                    if (i50 != -1) {
                                        zzadg.zzb(i31 == i50, "colorSpace must be the same for both views");
                                    }
                                    int i51 = zzadrVarZzb.zzg;
                                    if (i51 != -1) {
                                        zzadg.zzb(i28 == i51, "colorRange must be the same for both views");
                                    }
                                    int i52 = zzadrVarZzb.zzh;
                                    if (i52 != -1) {
                                        zzadg.zzb(iZzb == i52, "colorTransfer must be the same for both views");
                                    }
                                    zzadg.zzb(i29 == zzadrVarZzb.zzd, "bitdepthLuma must be the same for both views");
                                    zzadg.zzb(i30 == zzadrVarZzb.zze, "bitdepthChroma must be the same for both views");
                                    if (listZzo != null) {
                                        int i53 = zzfww.zzd;
                                        zzfwt zzfwtVar = new zzfwt();
                                        zzfwtVar.zzh(listZzo);
                                        zzfwtVar.zzh(zzadrVarZzb.zza);
                                        listZzo = zzfwtVar.zzi();
                                    } else {
                                        zzadg.zzb(false, "initializationData must be already set from hvcC atom");
                                    }
                                    str12 = zzadrVarZzb.zzl;
                                    str2 = "video/mv-hevc";
                                    i6 = i28;
                                    i7 = i29;
                                    zzahzVar = zzahzVar3;
                                    str4 = str10;
                                    i8 = i26;
                                } else if (iZzg10 == 1986361461) {
                                    zzekVar.zzL(iZzc5 + 8);
                                    int iZzc6 = zzekVar.zzc();
                                    zzahzVar = zzahzVar3;
                                    zzahv zzahvVar = null;
                                    while (iZzc6 - iZzc5 < i5) {
                                        zzekVar.zzL(iZzc6);
                                        int iZzg11 = zzekVar.zzg();
                                        zzadg.zzb(iZzg11 > 0, str10);
                                        int i54 = i29;
                                        if (zzekVar.zzg() == 1702454643) {
                                            zzekVar.zzL(iZzc6 + 8);
                                            int iZzc7 = zzekVar.zzc();
                                            while (true) {
                                                if (iZzc7 - iZzc6 >= iZzg11) {
                                                    i28 = i28;
                                                    str7 = str10;
                                                    zzahvVar = null;
                                                    break;
                                                }
                                                zzekVar.zzL(iZzc7);
                                                int iZzg12 = zzekVar.zzg();
                                                zzadg.zzb(iZzg12 > 0, str10);
                                                str7 = str10;
                                                if (zzekVar.zzg() == 1937011305) {
                                                    zzekVar.zzM(4);
                                                    int iZzm = zzekVar.zzm();
                                                    int i55 = iZzm & 1;
                                                    boolean z12 = (iZzm & 2) == 2;
                                                    if ((iZzm & 8) == 8) {
                                                        i11 = 1;
                                                        z7 = true;
                                                    } else {
                                                        i11 = 1;
                                                        z7 = false;
                                                    }
                                                    zzahvVar = new zzahv(new zzahy(i11 != i55 ? 0 : i11, z12, z7));
                                                } else {
                                                    iZzc7 += iZzg12;
                                                    str10 = str7;
                                                }
                                            }
                                            iZzc6 += iZzg11;
                                            i28 = i28;
                                            i30 = i30;
                                            i29 = i54;
                                            str10 = str7;
                                        } else {
                                            i28 = i28;
                                            str7 = str10;
                                        }
                                        iZzc6 += iZzg11;
                                        i28 = i28;
                                        i30 = i30;
                                        i29 = i54;
                                        str10 = str7;
                                    }
                                    i6 = i28;
                                    i7 = i29;
                                    i30 = i30;
                                    str4 = str10;
                                    zzaid zzaidVar = zzahvVar == null ? null : new zzaid(zzahvVar);
                                    if (zzaidVar != null) {
                                        if (zzfnVar2 == null) {
                                            z6 = true;
                                            i10 = -1;
                                            zzfnVar2 = null;
                                        } else if (zzfnVar2.zza.size() >= 2) {
                                            zzadg.zzb(zzaidVar.zzb(), "both eye views must be marked as available");
                                            zzadg.zzb(!zzaidVar.zza.zza.zzc, "for MV-HEVC, eye_views_reversed must be set to false");
                                        } else {
                                            z6 = true;
                                            i10 = -1;
                                        }
                                        if (i32 != i10) {
                                            i8 = i26;
                                            i30 = i30;
                                        } else if (z6 != zzaidVar.zza.zza.zzc) {
                                            i8 = i26;
                                            i30 = i30;
                                            i32 = 4;
                                        } else {
                                            i32 = 5;
                                            i8 = i26;
                                            i30 = i30;
                                        }
                                    }
                                    list = listZzo;
                                    i8 = i26;
                                    zzfnVar = zzfnVar2;
                                    zzfnVar2 = zzfnVar;
                                    i30 = i30;
                                    listZzo = list;
                                } else {
                                    i6 = i28;
                                    i7 = i29;
                                    zzahzVar = zzahzVar3;
                                    i30 = i30;
                                    str4 = str10;
                                    if (iZzg10 == 1685480259 || iZzg10 == 1685485123) {
                                        list = listZzo;
                                        i8 = i26;
                                        zzfnVar = zzfnVar2;
                                        zzacy zzacyVarZza = zzacy.zza(zzekVar);
                                        if (zzacyVarZza != null) {
                                            str2 = "video/dolby-vision";
                                            str12 = zzacyVarZza.zza;
                                        }
                                    } else if (iZzg10 == 1987076931) {
                                        int i56 = iZzc5 + 12;
                                        if (str2 == null) {
                                            str6 = null;
                                            z5 = true;
                                        } else {
                                            str6 = null;
                                            z5 = false;
                                        }
                                        zzadg.zzb(z5, str6);
                                        zzekVar.zzL(i56);
                                        byte bZzm = (byte) zzekVar.zzm();
                                        byte bZzm2 = (byte) zzekVar.zzm();
                                        int iZzm2 = zzekVar.zzm();
                                        int i57 = iZzm2 >> 4;
                                        int i58 = iZzm2 >> 1;
                                        int i59 = i26;
                                        String str15 = i59 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                        if (str15.equals("video/x-vnd.on2.vp9")) {
                                            int i60 = zzdh.zza;
                                            c2 = 3;
                                            listZzo = zzfww.zzo(new byte[]{1, 1, bZzm, 2, 1, bZzm2, 3, 1, (byte) i57, 4, 1, (byte) (i58 & 7)});
                                            i9 = 1;
                                        } else {
                                            c2 = 3;
                                            i9 = 1;
                                        }
                                        int i61 = iZzm2 & 1;
                                        int iZzm3 = zzekVar.zzm();
                                        int iZzm4 = zzekVar.zzm();
                                        int iZza3 = zzk.zza(iZzm3);
                                        i6 = i9 != i61 ? 2 : 1;
                                        iZzb = zzk.zzb(iZzm4);
                                        i7 = i57;
                                        i31 = iZza3;
                                        i8 = i59;
                                        i30 = i7;
                                        str2 = str15;
                                    } else {
                                        int i62 = i26;
                                        if (iZzg10 == 1635135811) {
                                            int i63 = i5 - 8;
                                            byte[] bArr = new byte[i63];
                                            zzekVar.zzH(bArr, 0, i63);
                                            zzfww zzfwwVarZzo2 = zzfww.zzo(bArr);
                                            zzekVar.zzL(iZzc5 + 8);
                                            zzk zzkVarZzk = zzk(zzekVar);
                                            int i64 = zzkVarZzk.zzf;
                                            int i65 = zzkVarZzk.zzg;
                                            int i66 = zzkVarZzk.zzb;
                                            int i67 = zzkVarZzk.zzc;
                                            iZzb = zzkVarZzk.zzd;
                                            listZzo = zzfwwVarZzo2;
                                            i7 = i64;
                                            i8 = i62;
                                            i6 = i67;
                                            i30 = i65;
                                            str2 = "video/av01";
                                            i31 = i66;
                                        } else if (iZzg10 == 1668050025) {
                                            if (byteBufferZzo == null) {
                                                byteBufferZzo = zzo();
                                            }
                                            ByteBuffer byteBuffer = byteBufferZzo;
                                            byteBuffer.position(21);
                                            byteBuffer.putShort(zzekVar.zzE());
                                            byteBuffer.putShort(zzekVar.zzE());
                                            byteBufferZzo = byteBuffer;
                                            i8 = i62;
                                        } else {
                                            if (iZzg10 == 1835295606) {
                                                if (byteBufferZzo == null) {
                                                    byteBufferZzo = zzo();
                                                }
                                                ByteBuffer byteBuffer2 = byteBufferZzo;
                                                short sZzE = zzekVar.zzE();
                                                short sZzE2 = zzekVar.zzE();
                                                short sZzE3 = zzekVar.zzE();
                                                short sZzE4 = zzekVar.zzE();
                                                short sZzE5 = zzekVar.zzE();
                                                short sZzE6 = zzekVar.zzE();
                                                zzfnVar = zzfnVar2;
                                                short sZzE7 = zzekVar.zzE();
                                                i8 = i62;
                                                short sZzE8 = zzekVar.zzE();
                                                long jZzu6 = zzekVar.zzu();
                                                long jZzu7 = zzekVar.zzu();
                                                list = listZzo;
                                                byteBuffer2.position(1);
                                                byteBuffer2.putShort(sZzE5);
                                                byteBuffer2.putShort(sZzE6);
                                                byteBuffer2.putShort(sZzE);
                                                byteBuffer2.putShort(sZzE2);
                                                byteBuffer2.putShort(sZzE3);
                                                byteBuffer2.putShort(sZzE4);
                                                byteBuffer2.putShort(sZzE7);
                                                byteBuffer2.putShort(sZzE8);
                                                byteBuffer2.putShort((short) (jZzu6 / 10000));
                                                byteBuffer2.putShort((short) (jZzu7 / 10000));
                                                byteBufferZzo = byteBuffer2;
                                            } else {
                                                zzfnVar = zzfnVar2;
                                                i8 = i62;
                                                list = listZzo;
                                                if (iZzg10 == 1681012275) {
                                                    if (str2 == null) {
                                                        str5 = null;
                                                        z4 = true;
                                                    } else {
                                                        str5 = null;
                                                        z4 = false;
                                                    }
                                                    zzadg.zzb(z4, str5);
                                                    str2 = "video/3gpp";
                                                } else if (iZzg10 == 1702061171) {
                                                    zzadg.zzb(str2 == null, null);
                                                    zzahu zzahuVarZzn = zzn(zzekVar, iZzc5);
                                                    String str16 = zzahuVarZzn.zza;
                                                    byte[] bArr2 = zzahuVarZzn.zzb;
                                                    if (bArr2 != null) {
                                                        zzahuVar = zzahuVarZzn;
                                                        listZzo = zzfww.zzo(bArr2);
                                                        zzfnVar2 = zzfnVar;
                                                        i30 = i30;
                                                        str2 = str16;
                                                    } else {
                                                        zzahuVar = zzahuVarZzn;
                                                        str2 = str16;
                                                    }
                                                } else if (iZzg10 == 1651798644) {
                                                    zzahsVarZzm = zzm(zzekVar, iZzc5);
                                                } else if (iZzg10 == 1885434736) {
                                                    zzekVar.zzL(iZzc5 + 8);
                                                    fZzp = zzekVar.zzp() / zzekVar.zzp();
                                                    zzfnVar2 = zzfnVar;
                                                    i30 = i30;
                                                    listZzo = list;
                                                    z11 = true;
                                                } else if (iZzg10 == 1937126244) {
                                                    int i68 = iZzc5 + 8;
                                                    while (true) {
                                                        if (i68 - iZzc5 < i5) {
                                                            zzekVar.zzL(i68);
                                                            int iZzg13 = zzekVar.zzg() + i68;
                                                            if (zzekVar.zzg() == 1886547818) {
                                                                bArrCopyOfRange = Arrays.copyOfRange(zzekVar.zzN(), i68, iZzg13);
                                                            } else {
                                                                i68 = iZzg13;
                                                            }
                                                        } else {
                                                            zzfnVar2 = zzfnVar;
                                                            i30 = i30;
                                                            listZzo = list;
                                                            bArrCopyOfRange = null;
                                                        }
                                                    }
                                                } else if (iZzg10 == 1936995172) {
                                                    int iZzm5 = zzekVar.zzm();
                                                    zzekVar.zzM(3);
                                                    if (iZzm5 == 0) {
                                                        int iZzm6 = zzekVar.zzm();
                                                        if (iZzm6 == 0) {
                                                            zzfnVar2 = zzfnVar;
                                                            i30 = i30;
                                                            listZzo = list;
                                                            i32 = 0;
                                                        } else if (iZzm6 == 1) {
                                                            zzfnVar2 = zzfnVar;
                                                            i30 = i30;
                                                            listZzo = list;
                                                            i32 = 1;
                                                        } else if (iZzm6 == 2) {
                                                            zzfnVar2 = zzfnVar;
                                                            i30 = i30;
                                                            listZzo = list;
                                                            i32 = 2;
                                                        } else if (iZzm6 == 3) {
                                                            i32 = 3;
                                                            zzfnVar2 = zzfnVar;
                                                            listZzo = list;
                                                        }
                                                    }
                                                } else if (iZzg10 == 1634760259) {
                                                    int i69 = i5 - 12;
                                                    byte[] bArr3 = new byte[i69];
                                                    zzekVar.zzL(iZzc5 + 12);
                                                    zzekVar.zzH(bArr3, 0, i69);
                                                    zzfww zzfwwVarZzo3 = zzfww.zzo(bArr3);
                                                    zzek zzekVar5 = new zzek(bArr3);
                                                    zzi zziVar = new zzi();
                                                    byte[] bArrZzN = zzekVar5.zzN();
                                                    zzej zzejVar = new zzej(bArrZzN, bArrZzN.length);
                                                    int i70 = 8;
                                                    zzejVar.zzl(zzekVar5.zzc() * 8);
                                                    int i71 = 1;
                                                    zzejVar.zzo(1);
                                                    int iZzd = zzejVar.zzd(8);
                                                    int i72 = 0;
                                                    while (i72 < iZzd) {
                                                        zzejVar.zzo(i71);
                                                        int iZzd2 = zzejVar.zzd(i70);
                                                        int i73 = 0;
                                                        while (i73 < iZzd2) {
                                                            zzejVar.zzn(6);
                                                            boolean zZzp = zzejVar.zzp();
                                                            zzejVar.zzm();
                                                            zzejVar.zzo(11);
                                                            zzejVar.zzn(4);
                                                            int iZzd3 = zzejVar.zzd(4) + i70;
                                                            zziVar.zzf(iZzd3);
                                                            zziVar.zza(iZzd3);
                                                            zzejVar.zzo(1);
                                                            if (zZzp) {
                                                                int iZzd4 = zzejVar.zzd(i70);
                                                                int iZzd5 = zzejVar.zzd(i70);
                                                                zzejVar.zzo(1);
                                                                boolean zZzp2 = zzejVar.zzp();
                                                                zziVar.zzc(zzk.zza(iZzd4));
                                                                zziVar.zzb(true != zZzp2 ? 2 : 1);
                                                                zziVar.zzd(zzk.zzb(iZzd5));
                                                            }
                                                            i73++;
                                                            i70 = 8;
                                                        }
                                                        i72++;
                                                        i71 = 1;
                                                        i70 = 8;
                                                    }
                                                    zzk zzkVarZzg = zziVar.zzg();
                                                    int i74 = zzkVarZzg.zzf;
                                                    int i75 = zzkVarZzg.zzg;
                                                    int i76 = zzkVarZzg.zzb;
                                                    int i77 = zzkVarZzg.zzc;
                                                    iZzb = zzkVarZzg.zzd;
                                                    listZzo = zzfwwVarZzo3;
                                                    i7 = i74;
                                                    i31 = i76;
                                                    i6 = i77;
                                                    zzfnVar2 = zzfnVar;
                                                    i30 = i75;
                                                    str2 = "video/apv";
                                                } else if (iZzg10 == 1668246642 && i31 == -1) {
                                                    if (iZzb == -1) {
                                                        int iZzg14 = zzekVar.zzg();
                                                        if (iZzg14 == 1852009592 || iZzg14 == 1852009571) {
                                                            int iZzq4 = zzekVar.zzq();
                                                            int iZzq5 = zzekVar.zzq();
                                                            zzekVar.zzM(2);
                                                            if (i5 != 19) {
                                                                z3 = false;
                                                            } else if ((zzekVar.zzm() & 128) != 0) {
                                                                i5 = 19;
                                                                z3 = true;
                                                            } else {
                                                                z3 = false;
                                                                i5 = 19;
                                                            }
                                                            int iZza4 = zzk.zza(iZzq4);
                                                            int i78 = true != z3 ? 2 : 1;
                                                            i31 = iZza4;
                                                            iZzb = zzk.zzb(iZzq5);
                                                            i6 = i78;
                                                        } else {
                                                            zzdx.zzf("BoxParsers", "Unsupported color type: ".concat(zzfa.zze(iZzg14)));
                                                            iZzb = -1;
                                                            i31 = -1;
                                                        }
                                                    } else {
                                                        i31 = -1;
                                                    }
                                                }
                                            }
                                            zzfnVar2 = zzfnVar;
                                            i30 = i30;
                                            listZzo = list;
                                        }
                                    }
                                    zzfnVar2 = zzfnVar;
                                    i30 = i30;
                                    listZzo = list;
                                }
                                i27 += i5;
                                i28 = i6;
                                iZzg7 = iZzg7;
                                iZzc3 = i35;
                                zzahzVar3 = zzahzVar;
                                i29 = i7;
                                str10 = str4;
                                i26 = i8;
                            }
                            iZzg7 = iZzg7;
                            int i79 = i28;
                            int i80 = i29;
                            zzahz zzahzVar4 = zzahzVar3;
                            int i81 = i30;
                            iZzc3 = iZzc3;
                            List list5 = listZzo;
                            b = -1;
                            c = 3;
                            if (str2 == null) {
                                str3 = str11;
                                i20 = i23;
                                i19 = i24;
                                zzahzVar2 = zzahzVar4;
                            } else {
                                zzx zzxVar = new zzx();
                                i19 = i24;
                                zzxVar.zzN(i19);
                                zzxVar.zzad(str2);
                                zzxVar.zzC(str12);
                                zzxVar.zzai(iZzq2);
                                zzxVar.zzM(iZzq3);
                                zzxVar.zzZ(fZzp);
                                i20 = i23;
                                zzxVar.zzac(i20);
                                zzxVar.zzaa(bArrCopyOfRange);
                                zzxVar.zzag(i32);
                                zzxVar.zzP(list5);
                                zzxVar.zzU(i33);
                                zzxVar.zzV(i34);
                                zzxVar.zzH(zzsVar2);
                                str3 = str11;
                                zzxVar.zzS(str3);
                                zzi zziVar2 = new zzi();
                                zziVar2.zzc(i31);
                                zziVar2.zzb(i79);
                                zziVar2.zzd(iZzb);
                                zziVar2.zze(byteBufferZzo != null ? byteBufferZzo.array() : null);
                                zziVar2.zzf(i80);
                                zziVar2.zza(i81);
                                zzxVar.zzD(zziVar2.zzg());
                                if (zzahsVarZzm != null) {
                                    zzxVar.zzA(zzfzz.zzf(zzahsVarZzm.zza));
                                    zzxVar.zzY(zzfzz.zzf(zzahsVarZzm.zzb));
                                } else if (zzahuVar != null) {
                                    zzxVar.zzA(zzfzz.zzf(zzahuVar.zzc));
                                    zzxVar.zzY(zzfzz.zzf(zzahuVar.zzd));
                                }
                                zzz zzzVarZzaj = zzxVar.zzaj();
                                zzahzVar2 = zzahzVar4;
                                zzahzVar2.zzb = zzzVarZzaj;
                            }
                        } else if (iZzg8 == 1836069985 || iZzg8 == 1701733217 || iZzg8 == 1633889587 || iZzg8 == 1700998451 || iZzg8 == 1633889588 || iZzg8 == 1835823201 || iZzg8 == 1685353315 || iZzg8 == 1685353317 || iZzg8 == 1685353320 || iZzg8 == 1685353324 || iZzg8 == 1685353336 || iZzg8 == 1935764850 || iZzg8 == 1935767394 || iZzg8 == 1819304813 || iZzg8 == 1936684916 || iZzg8 == 1953984371 || iZzg8 == 778924082 || iZzg8 == 778924083 || iZzg8 == 1835557169 || iZzg8 == 1835560241 || iZzg8 == 1634492771 || iZzg8 == 1634492791 || iZzg8 == 1970037111 || iZzg8 == 1332770163 || iZzg8 == 1716281667 || iZzg8 == 1767992678) {
                            zzaicVar = zzaicVar;
                            zzekVar = zzekVar4;
                            String str17 = str9;
                            zzexVar3 = zzexVar3;
                            i = i;
                            int i82 = i20;
                            j3 = j3;
                            zzp(zzekVar4, iZzg8, iZzc3, iZzg7, i19, str17, z2, zzsVar, zzahzVar2, i21);
                            iZzg7 = iZzg7;
                            iZzc3 = iZzc3;
                            i21 = i21;
                            str3 = str17;
                            i20 = i82;
                            i19 = i19;
                            zzahzVar2 = zzahzVar2;
                            b = -1;
                            c = 3;
                        } else {
                            if (iZzg8 == 1414810956 || iZzg8 == 1954034535 || iZzg8 == 2004251764 || iZzg8 == 1937010800 || iZzg8 == 1664495672) {
                                zzekVar4.zzL(iZzc3 + 16);
                                if (iZzg8 == 1414810956) {
                                    str8 = "application/ttml+xml";
                                } else {
                                    if (iZzg8 == 1954034535) {
                                        int i83 = iZzg7 - 16;
                                        byte[] bArr4 = new byte[i83];
                                        zzekVar4.zzH(bArr4, 0, i83);
                                        j4 = Long.MAX_VALUE;
                                        zzfwwVarZzo = zzfww.zzo(bArr4);
                                        str8 = "application/x-quicktime-tx3g";
                                    } else if (iZzg8 == 2004251764) {
                                        str8 = "application/x-mp4-vtt";
                                    } else if (iZzg8 == 1937010800) {
                                        str8 = "application/ttml+xml";
                                        j4 = 0;
                                        zzfwwVarZzo = null;
                                    } else {
                                        zzahzVar2.zzd = 1;
                                        str8 = "application/x-mp4-cea-608";
                                    }
                                    zzx zzxVar2 = new zzx();
                                    zzxVar2.zzN(i19);
                                    zzxVar2.zzad(str8);
                                    zzxVar2.zzS(str9);
                                    zzxVar2.zzah(j4);
                                    zzxVar2.zzP(zzfwwVarZzo);
                                    zzahzVar2.zzb = zzxVar2.zzaj();
                                }
                                zzfwwVarZzo = null;
                                j4 = Long.MAX_VALUE;
                                zzx zzxVar3 = new zzx();
                                zzxVar3.zzN(i19);
                                zzxVar3.zzad(str8);
                                zzxVar3.zzS(str9);
                                zzxVar3.zzah(j4);
                                zzxVar3.zzP(zzfwwVarZzo);
                                zzahzVar2.zzb = zzxVar3.zzaj();
                            } else if (iZzg8 == 1835365492) {
                                zzekVar4.zzL(iZzc3 + 16);
                                zzekVar4.zzy((char) 0);
                                String strZzy = zzekVar4.zzy((char) 0);
                                if (strZzy != null) {
                                    zzx zzxVar4 = new zzx();
                                    zzxVar4.zzN(i19);
                                    zzxVar4.zzad(strZzy);
                                    zzahzVar2.zzb = zzxVar4.zzaj();
                                }
                            } else if (iZzg8 == 1667329389) {
                                zzx zzxVar5 = new zzx();
                                zzxVar5.zzN(i19);
                                zzxVar5.zzad("application/x-camera-motion");
                                zzahzVar2.zzb = zzxVar5.zzaj();
                            }
                            b = -1;
                            zzekVar = zzekVar4;
                            str3 = str9;
                            c = 3;
                        }
                        zzekVar.zzL(iZzc3 + iZzg7);
                        i21++;
                        zzsVar = zzsVar;
                        zzahzVar2 = zzahzVar2;
                        i19 = i19;
                        str9 = str3;
                        zzekVar4 = zzekVar;
                        zzahwVar = zzahwVar2;
                        zzaicVar = zzaicVar;
                        i = i;
                        iZzg6 = i22;
                        arrayList3 = arrayList4;
                        zzexVar3 = zzexVar3;
                        j3 = j3;
                        i20 = i20;
                    }
                    zzahw zzahwVar3 = zzahwVar;
                    zzahz zzahzVar5 = zzahzVar2;
                    int i84 = i;
                    arrayList = arrayList3;
                    zzaic zzaicVar2 = zzaicVar;
                    zzex zzexVar4 = zzexVar3;
                    long j8 = j3;
                    if (z) {
                        zzexVar2 = zzexVar4;
                    } else {
                        zzexVar2 = zzexVar4;
                        zzex zzexVarZza4 = zzexVar2.zza(1701082227);
                        if (zzexVarZza4 != null) {
                            zzey zzeyVarZzb6 = zzexVarZza4.zzb(1701606260);
                            if (zzeyVarZzb6 == null) {
                                pairCreate = null;
                            } else {
                                zzek zzekVar6 = zzeyVarZzb6.zza;
                                zzekVar6.zzL(8);
                                int iZza5 = zza(zzekVar6.zzg());
                                int iZzp = zzekVar6.zzp();
                                long[] jArr3 = new long[iZzp];
                                long[] jArr4 = new long[iZzp];
                                for (int i85 = 0; i85 < iZzp; i85++) {
                                    jArr3[i85] = iZza5 == 1 ? zzekVar6.zzw() : zzekVar6.zzu();
                                    jArr4[i85] = iZza5 == 1 ? zzekVar6.zzt() : zzekVar6.zzg();
                                    if (zzekVar6.zzE() != 1) {
                                        throw new IllegalArgumentException("Unsupported media rate.");
                                    }
                                    zzekVar6.zzM(2);
                                }
                                pairCreate = Pair.create(jArr3, jArr4);
                            }
                            if (pairCreate != null) {
                                jArr2 = (long[]) pairCreate.first;
                                jArr = (long[]) pairCreate.second;
                            }
                        }
                        zzzVar = zzahzVar5.zzb;
                        if (zzzVar == null) {
                            zzaiwVar = new zzaiw(zzaicVar2.zza, i84, zzahwVar3.zza, j8, jZzu3, zzahwVar3.zzb, zzzVar, zzahzVar5.zzd, zzahzVar5.zza, zzahzVar5.zzc, jArr2, jArr);
                            zzftlVar = zzftlVar;
                        }
                        zzaiwVar2 = (zzaiw) zzftlVar.apply(zzaiwVar);
                        if (zzaiwVar2 != null) {
                            zzex zzexVarZza5 = zzexVar2.zza(1835297121);
                            zzexVarZza5.getClass();
                            zzex zzexVarZza6 = zzexVarZza5.zza(1835626086);
                            zzexVarZza6.getClass();
                            zzex zzexVarZza7 = zzexVarZza6.zza(1937007212);
                            zzexVarZza7.getClass();
                            zzaiz zzaizVarZze = zze(zzaiwVar2, zzexVarZza7, zzadqVar);
                            arrayList2 = arrayList;
                            arrayList2.add(zzaizVarZze);
                        } else {
                            arrayList2 = arrayList;
                        }
                    }
                    jArr = null;
                    jArr2 = null;
                    zzzVar = zzahzVar5.zzb;
                    if (zzzVar == null) {
                        zzaiwVar = new zzaiw(zzaicVar2.zza, i84, zzahwVar3.zza, j8, jZzu3, zzahwVar3.zzb, zzzVar, zzahzVar5.zzd, zzahzVar5.zza, zzahzVar5.zzc, jArr2, jArr);
                        zzftlVar = zzftlVar;
                    }
                    zzaiwVar2 = (zzaiw) zzftlVar.apply(zzaiwVar);
                    if (zzaiwVar2 != null) {
                        zzex zzexVarZza8 = zzexVar2.zza(1835297121);
                        zzexVarZza8.getClass();
                        zzex zzexVarZza9 = zzexVarZza8.zza(1835626086);
                        zzexVarZza9.getClass();
                        zzex zzexVarZza10 = zzexVarZza9.zza(1937007212);
                        zzexVarZza10.getClass();
                        zzaiz zzaizVarZze2 = zze(zzaiwVar2, zzexVarZza10, zzadqVar);
                        arrayList2 = arrayList;
                        arrayList2.add(zzaizVarZze2);
                    } else {
                        arrayList2 = arrayList;
                    }
                }
                zzaiwVar = null;
                zzaiwVar2 = (zzaiw) zzftlVar.apply(zzaiwVar);
                if (zzaiwVar2 != null) {
                    zzex zzexVarZza11 = zzexVar2.zza(1835297121);
                    zzexVarZza11.getClass();
                    zzex zzexVarZza12 = zzexVarZza11.zza(1835626086);
                    zzexVarZza12.getClass();
                    zzex zzexVarZza13 = zzexVarZza12.zza(1937007212);
                    zzexVarZza13.getClass();
                    zzaiz zzaizVarZze3 = zze(zzaiwVar2, zzexVarZza13, zzadqVar);
                    arrayList2 = arrayList;
                    arrayList2.add(zzaizVarZze3);
                } else {
                    arrayList2 = arrayList;
                }
            }
            i12 = i3 + 1;
            arrayList3 = arrayList2;
        }
    }

    public static void zzg(zzek zzekVar) {
        int iZzc = zzekVar.zzc();
        zzekVar.zzM(4);
        if (zzekVar.zzg() != 1751411826) {
            iZzc += 4;
        }
        zzekVar.zzL(iZzc);
    }

    private static int zzh(zzek zzekVar) {
        int iZzm = zzekVar.zzm();
        int i = iZzm & 127;
        while ((iZzm & 128) == 128) {
            iZzm = zzekVar.zzm();
            i = (i << 7) | (iZzm & 127);
        }
        return i;
    }

    private static int zzi(zzek zzekVar) {
        zzekVar.zzL(16);
        return zzekVar.zzg();
    }

    private static Pair zzj(zzek zzekVar, int i, int i2) throws zzaz {
        zzaix zzaixVar;
        Pair pairCreate;
        int i3;
        int i4;
        byte[] bArr;
        int iZzc = zzekVar.zzc();
        while (iZzc - i < i2) {
            zzekVar.zzL(iZzc);
            int iZzg = zzekVar.zzg();
            zzadg.zzb(iZzg > 0, "childAtomSize must be positive");
            if (zzekVar.zzg() == 1936289382) {
                int i5 = iZzc + 8;
                int i6 = 0;
                int i7 = -1;
                String strZzB = null;
                Integer numValueOf = null;
                while (i5 - iZzc < iZzg) {
                    zzekVar.zzL(i5);
                    int iZzg2 = zzekVar.zzg();
                    int iZzg3 = zzekVar.zzg();
                    if (iZzg3 == 1718775137) {
                        numValueOf = Integer.valueOf(zzekVar.zzg());
                    } else if (iZzg3 == 1935894637) {
                        zzekVar.zzM(4);
                        strZzB = zzekVar.zzB(4, StandardCharsets.UTF_8);
                    } else if (iZzg3 == 1935894633) {
                        i7 = i5;
                        i6 = iZzg2;
                    }
                    i5 += iZzg2;
                }
                if ("cenc".equals(strZzB) || "cbc1".equals(strZzB) || "cens".equals(strZzB) || "cbcs".equals(strZzB)) {
                    zzadg.zzb(numValueOf != null, "frma atom is mandatory");
                    zzadg.zzb(i7 != -1, "schi atom is mandatory");
                    int i8 = i7 + 8;
                    while (true) {
                        if (i8 - i7 >= i6) {
                            zzaixVar = null;
                            break;
                        }
                        zzekVar.zzL(i8);
                        int iZzg4 = zzekVar.zzg();
                        if (zzekVar.zzg() == 1952804451) {
                            int iZza = zza(zzekVar.zzg());
                            zzekVar.zzM(1);
                            if (iZza == 0) {
                                zzekVar.zzM(1);
                                i3 = 0;
                                i4 = 0;
                            } else {
                                int iZzm = zzekVar.zzm();
                                int i9 = (iZzm & 240) >> 4;
                                i3 = iZzm & 15;
                                i4 = i9;
                            }
                            boolean z = zzekVar.zzm() == 1;
                            int iZzm2 = zzekVar.zzm();
                            byte[] bArr2 = new byte[16];
                            zzekVar.zzH(bArr2, 0, 16);
                            if (z && iZzm2 == 0) {
                                int iZzm3 = zzekVar.zzm();
                                byte[] bArr3 = new byte[iZzm3];
                                zzekVar.zzH(bArr3, 0, iZzm3);
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            zzaixVar = new zzaix(z, strZzB, iZzm2, bArr2, i4, i3, bArr);
                            break;
                        }
                        i8 += iZzg4;
                    }
                    zzadg.zzb(zzaixVar != null, "tenc atom is mandatory");
                    int i10 = zzeu.zza;
                    pairCreate = Pair.create(numValueOf, zzaixVar);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            iZzc += iZzg;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0047 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0049  */
    /* JADX WARN: Code duplicated, block: B:75:0x0151  */
    /* JADX WARN: Code duplicated, block: B:83:0x016b A[PHI: r3
  0x016b: PHI (r3v5 int) = (r3v4 int), (r3v4 int), (r3v8 int) binds: [B:76:0x015d, B:77:0x015f, B:82:0x016a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x017a  */
    private static zzk zzk(zzek zzekVar) {
        int i;
        int iZzd;
        int iZzd2;
        zzi zziVar = new zzi();
        byte[] bArrZzN = zzekVar.zzN();
        zzej zzejVar = new zzej(bArrZzN, bArrZzN.length);
        zzejVar.zzl(zzekVar.zzc() * 8);
        zzejVar.zzo(1);
        int iZzd3 = zzejVar.zzd(3);
        zzejVar.zzn(6);
        boolean zZzp = zzejVar.zzp();
        boolean zZzp2 = zzejVar.zzp();
        boolean z = false;
        if (iZzd3 != 2) {
            if (iZzd3 <= 2) {
                i = true != zZzp ? 8 : 10;
                zziVar.zzf(i);
                zziVar.zza(i);
            }
        } else if (zZzp) {
            i = true == zZzp2 ? 12 : 10;
            zziVar.zzf(i);
            zziVar.zza(i);
        } else {
            zZzp = false;
            iZzd3 = 2;
            if (iZzd3 <= 2) {
                if (true != zZzp) {
                }
                zziVar.zzf(i);
                zziVar.zza(i);
            }
        }
        int i2 = 13;
        zzejVar.zzn(13);
        zzejVar.zzm();
        int iZzd4 = zzejVar.zzd(4);
        if (iZzd4 != 1) {
            zzdx.zze("BoxParsers", "Unsupported obu_type: " + iZzd4);
            return zziVar.zzg();
        }
        if (zzejVar.zzp()) {
            zzdx.zze("BoxParsers", "Unsupported obu_extension_flag");
            return zziVar.zzg();
        }
        boolean zZzp3 = zzejVar.zzp();
        zzejVar.zzm();
        if (zZzp3 && zzejVar.zzd(8) > 127) {
            zzdx.zze("BoxParsers", "Excessive obu_size");
            return zziVar.zzg();
        }
        int iZzd5 = zzejVar.zzd(3);
        zzejVar.zzm();
        if (zzejVar.zzp()) {
            zzdx.zze("BoxParsers", "Unsupported reduced_still_picture_header");
            return zziVar.zzg();
        }
        if (zzejVar.zzp()) {
            zzdx.zze("BoxParsers", "Unsupported timing_info_present_flag");
            return zziVar.zzg();
        }
        if (zzejVar.zzp()) {
            zzdx.zze("BoxParsers", "Unsupported initial_display_delay_present_flag");
            return zziVar.zzg();
        }
        int iZzd6 = zzejVar.zzd(5);
        for (int i3 = 0; i3 <= iZzd6; i3++) {
            zzejVar.zzn(12);
            if (zzejVar.zzd(5) > 7) {
                zzejVar.zzm();
            }
        }
        int iZzd7 = zzejVar.zzd(4);
        int iZzd8 = zzejVar.zzd(4);
        zzejVar.zzn(iZzd7 + 1);
        zzejVar.zzn(iZzd8 + 1);
        if (zzejVar.zzp()) {
            zzejVar.zzn(7);
        }
        zzejVar.zzn(7);
        boolean zZzp4 = zzejVar.zzp();
        if (zZzp4) {
            zzejVar.zzn(2);
        }
        if ((zzejVar.zzp() || zzejVar.zzd(1) > 0) && !zzejVar.zzp()) {
            zzejVar.zzn(1);
        }
        if (zZzp4) {
            zzejVar.zzn(3);
        }
        zzejVar.zzn(3);
        boolean zZzp5 = zzejVar.zzp();
        if (iZzd5 != 2) {
            if (iZzd5 != 1) {
            }
            if (zzejVar.zzp()) {
                int iZzd9 = zzejVar.zzd(8);
                iZzd = zzejVar.zzd(8);
                int iZzd10 = zzejVar.zzd(8);
                if (!z || iZzd9 != 1) {
                    i2 = iZzd;
                    iZzd2 = zzejVar.zzd(1);
                } else if (iZzd != 13) {
                    iZzd9 = 1;
                    i2 = iZzd;
                    iZzd2 = zzejVar.zzd(1);
                } else if (iZzd10 == 0) {
                    iZzd2 = 1;
                    iZzd9 = 1;
                } else {
                    iZzd9 = 1;
                    iZzd2 = zzejVar.zzd(1);
                }
                zziVar.zzc(zzk.zza(iZzd9));
                zziVar.zzb(iZzd2 != 1 ? 2 : 1);
                zziVar.zzd(zzk.zzb(i2));
            }
            return zziVar.zzg();
        }
        if (zZzp5) {
            zzejVar.zzm();
        }
        if (zzejVar.zzp()) {
            z = true;
        }
        if (zzejVar.zzp()) {
            int iZzd11 = zzejVar.zzd(8);
            iZzd = zzejVar.zzd(8);
            int iZzd12 = zzejVar.zzd(8);
            if (!z) {
                i2 = iZzd;
                iZzd2 = zzejVar.zzd(1);
            } else {
                i2 = iZzd;
                iZzd2 = zzejVar.zzd(1);
            }
            zziVar.zzc(zzk.zza(iZzd11));
            zziVar.zzb(iZzd2 != 1 ? 2 : 1);
            zziVar.zzd(zzk.zzb(i2));
        }
        return zziVar.zzg();
    }

    private static zzav zzl(zzek zzekVar) {
        short sZzE = zzekVar.zzE();
        zzekVar.zzM(2);
        String strZzB = zzekVar.zzB(sZzE, StandardCharsets.UTF_8);
        int iMax = Math.max(strZzB.lastIndexOf(43), strZzB.lastIndexOf(45));
        try {
            return new zzav(-9223372036854775807L, new zzfb(Float.parseFloat(strZzB.substring(0, iMax)), Float.parseFloat(strZzB.substring(iMax, strZzB.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static zzahs zzm(zzek zzekVar, int i) {
        zzekVar.zzL(i + 8);
        zzekVar.zzM(4);
        return new zzahs(zzekVar.zzu(), zzekVar.zzu());
    }

    private static zzahu zzn(zzek zzekVar, int i) {
        zzekVar.zzL(i + 12);
        zzekVar.zzM(1);
        zzh(zzekVar);
        zzekVar.zzM(2);
        int iZzm = zzekVar.zzm();
        if ((iZzm & 128) != 0) {
            zzekVar.zzM(2);
        }
        if ((iZzm & 64) != 0) {
            zzekVar.zzM(zzekVar.zzm());
        }
        if ((iZzm & 32) != 0) {
            zzekVar.zzM(2);
        }
        zzekVar.zzM(1);
        zzh(zzekVar);
        String strZzd = zzay.zzd(zzekVar.zzm());
        if ("audio/mpeg".equals(strZzd) || "audio/vnd.dts".equals(strZzd) || "audio/vnd.dts.hd".equals(strZzd)) {
            return new zzahu(strZzd, null, -1L, -1L);
        }
        zzekVar.zzM(4);
        long jZzu = zzekVar.zzu();
        long jZzu2 = zzekVar.zzu();
        zzekVar.zzM(1);
        int iZzh = zzh(zzekVar);
        byte[] bArr = new byte[iZzh];
        zzekVar.zzH(bArr, 0, iZzh);
        return new zzahu(strZzd, bArr, jZzu2 <= 0 ? -1L : jZzu2, jZzu > 0 ? jZzu : -1L);
    }

    private static ByteBuffer zzo() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: Code duplicated, block: B:246:0x04bb A[PHI: r1 r16 r22
  0x04bb: PHI (r1v38 java.lang.String) = (r1v29 java.lang.String), (r1v39 java.lang.String), (r1v29 java.lang.String), (r1v29 java.lang.String) binds: [B:223:0x042f, B:225:0x043d, B:221:0x0404, B:219:0x03ea] A[DONT_GENERATE, DONT_INLINE]
  0x04bb: PHI (r16v2 com.google.android.gms.internal.ads.zzahu) = 
  (r16v1 com.google.android.gms.internal.ads.zzahu)
  (r16v3 com.google.android.gms.internal.ads.zzahu)
  (r16v1 com.google.android.gms.internal.ads.zzahu)
  (r16v1 com.google.android.gms.internal.ads.zzahu)
 binds: [B:223:0x042f, B:225:0x043d, B:221:0x0404, B:219:0x03ea] A[DONT_GENERATE, DONT_INLINE]
  0x04bb: PHI (r22v1 java.lang.String) = (r22v2 java.lang.String), (r22v2 java.lang.String), (r22v3 java.lang.String), (r22v3 java.lang.String) binds: [B:223:0x042f, B:225:0x043d, B:221:0x0404, B:219:0x03ea] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x007f  */
    /* JADX WARN: Code duplicated, block: B:84:0x014b  */
    private static void zzp(zzek zzekVar, int i, int i2, int i3, int i4, String str, boolean z, zzs zzsVar, zzahz zzahzVar, int i5) throws zzaz {
        int iZzq;
        int iZzq2;
        int iZzn;
        int iZzg;
        int i6;
        String str2;
        int i7;
        int i8;
        String str3;
        boolean z2;
        boolean z3;
        zzek zzekVar2 = zzekVar;
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        zzs zzsVarZzb = zzsVar;
        zzekVar2.zzL(i10 + 16);
        if (z) {
            iZzq = zzekVar.zzq();
            zzekVar2.zzM(6);
        } else {
            zzekVar2.zzM(8);
            iZzq = 0;
        }
        if (iZzq == 0 || iZzq == 1) {
            iZzq2 = zzekVar.zzq();
            zzekVar2.zzM(6);
            iZzn = zzekVar.zzn();
            zzekVar2.zzL(zzekVar.zzc() - 4);
            iZzg = zzekVar.zzg();
            if (iZzq == 1) {
                zzekVar2.zzM(16);
            }
            i6 = -1;
        } else {
            if (iZzq != 2) {
                return;
            }
            zzekVar2.zzM(16);
            iZzn = (int) Math.round(Double.longBitsToDouble(zzekVar.zzt()));
            int iZzp = zzekVar.zzp();
            zzekVar2.zzM(4);
            int iZzp2 = zzekVar.zzp();
            int iZzp3 = zzekVar.zzp();
            int i12 = iZzp3 & 1;
            int i13 = iZzp3 & 2;
            if (i12 == 0) {
                if (iZzp2 == 8) {
                    i6 = 3;
                } else if (iZzp2 == 16) {
                    i6 = i13 != 0 ? 268435456 : 2;
                } else if (iZzp2 == 24) {
                    i6 = i13 != 0 ? 1342177280 : 21;
                } else if (iZzp2 == 32) {
                    i6 = i13 != 0 ? 1610612736 : 22;
                } else {
                    i6 = -1;
                }
            } else if (iZzp2 == 32) {
                i6 = 4;
            } else {
                i6 = -1;
            }
            zzekVar2.zzM(8);
            iZzq2 = iZzp;
            iZzg = 0;
        }
        if (i9 == 1767992678) {
            iZzn = -1;
            iZzq2 = -1;
        } else {
            if (i9 == 1935764850) {
                iZzn = 8000;
            } else if (i9 == 1935767394) {
                iZzn = 16000;
                i9 = 1935767394;
            }
            iZzq2 = 1;
        }
        int iZzc = zzekVar.zzc();
        int iIntValue = 1701733217;
        if (i9 == 1701733217) {
            Pair pairZzj = zzj(zzekVar2, i10, i11);
            if (pairZzj != null) {
                iIntValue = ((Integer) pairZzj.first).intValue();
                zzsVarZzb = zzsVarZzb == null ? null : zzsVarZzb.zzb(((zzaix) pairZzj.second).zzb);
                zzahzVar.zza[i5] = (zzaix) pairZzj.second;
            }
            i9 = iIntValue;
            zzekVar2.zzL(iZzc);
        }
        String str4 = "audio/mhm1";
        if (i9 == 1633889587) {
            str2 = "audio/ac3";
        } else if (i9 == 1700998451) {
            str2 = "audio/eac3";
        } else if (i9 == 1633889588) {
            str2 = "audio/ac4";
        } else if (i9 == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (i9 == 1685353320 || i9 == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (i9 == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i9 == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (i9 == 1935764850) {
            str2 = "audio/3gpp";
        } else if (i9 == 1935767394) {
            str2 = "audio/amr-wb";
        } else if (i9 == 1936684916) {
            str2 = "audio/raw";
            i6 = 2;
        } else if (i9 == 1953984371) {
            str2 = "audio/raw";
            i6 = 268435456;
        } else if (i9 == 1819304813) {
            if (i6 == -1) {
                str2 = "audio/raw";
                i6 = 2;
            } else {
                str2 = "audio/raw";
            }
        } else if (i9 == 778924082 || i9 == 778924083) {
            str2 = "audio/mpeg";
        } else if (i9 == 1835557169) {
            str2 = "audio/mha1";
        } else if (i9 == 1835560241) {
            str2 = "audio/mhm1";
        } else if (i9 == 1634492771) {
            str2 = "audio/alac";
        } else if (i9 == 1634492791) {
            str2 = "audio/g711-alaw";
        } else if (i9 == 1970037111) {
            str2 = "audio/g711-mlaw";
        } else if (i9 == 1332770163) {
            str2 = "audio/opus";
        } else if (i9 == 1716281667) {
            str2 = "audio/flac";
        } else if (i9 == 1835823201) {
            str2 = "audio/true-hd";
        } else {
            str2 = i9 == 1767992678 ? "audio/iamf" : null;
        }
        int i14 = i6;
        String str5 = null;
        List listZzo = null;
        zzahu zzahuVarZzn = null;
        zzahs zzahsVarZzm = null;
        while (iZzc - i10 < i11) {
            zzekVar2.zzL(iZzc);
            int iZzg2 = zzekVar.zzg();
            String str6 = "childAtomSize must be positive";
            zzadg.zzb(iZzg2 > 0, "childAtomSize must be positive");
            int iZzg3 = zzekVar.zzg();
            str5 = str5;
            if (iZzg3 == 1835557187) {
                zzekVar2.zzL(iZzc + 8);
                zzekVar2.zzM(1);
                int iZzm = zzekVar.zzm();
                zzekVar2.zzM(1);
                String str7 = Objects.equals(str2, str4) ? String.format("mhm1.%02X", Integer.valueOf(iZzm)) : String.format("mha1.%02X", Integer.valueOf(iZzm));
                int iZzq3 = zzekVar.zzq();
                byte[] bArr = new byte[iZzq3];
                str5 = str7;
                z3 = false;
                zzekVar2.zzH(bArr, 0, iZzq3);
                if (listZzo == null) {
                    listZzo = zzfww.zzo(bArr);
                    str4 = str4;
                    str5 = str5;
                } else {
                    listZzo = zzfww.zzp(bArr, (byte[]) listZzo.get(0));
                    str5 = str5;
                    str4 = str4;
                }
            } else {
                if (iZzg3 == 1835557200) {
                    zzekVar2.zzL(iZzc + 8);
                    int iZzm2 = zzekVar.zzm();
                    if (iZzm2 > 0) {
                        byte[] bArr2 = new byte[iZzm2];
                        z3 = false;
                        zzekVar2.zzH(bArr2, 0, iZzm2);
                        if (listZzo == null) {
                            listZzo = zzfww.zzo(bArr2);
                            str4 = str4;
                            str5 = str5;
                        } else {
                            listZzo = zzfww.zzp((byte[]) listZzo.get(0), bArr2);
                            str5 = str5;
                            str4 = str4;
                        }
                    } else {
                        str4 = str4;
                    }
                } else {
                    if (iZzg3 == 1702061171) {
                        str4 = str4;
                        i7 = iZzc;
                        i8 = -1;
                    } else if (z && iZzg3 == 2002876005) {
                        int iZzc2 = zzekVar.zzc();
                        if (iZzc2 >= iZzc) {
                            str3 = null;
                            z2 = true;
                        } else {
                            str3 = null;
                            z2 = false;
                        }
                        zzadg.zzb(z2, str3);
                        int i15 = iZzc2;
                        while (true) {
                            if (i15 - iZzc >= iZzg2) {
                                str4 = str4;
                                i7 = -1;
                                break;
                            }
                            zzekVar2.zzL(i15);
                            int iZzg4 = zzekVar.zzg();
                            zzadg.zzb(iZzg4 > 0, str6);
                            String str8 = str6;
                            if (zzekVar.zzg() == 1702061171) {
                                i7 = i15;
                                break;
                            } else {
                                i15 += iZzg4;
                                str4 = str4;
                                str6 = str8;
                            }
                        }
                        i8 = -1;
                    } else {
                        str4 = str4;
                        if (iZzg3 == 1651798644) {
                            zzahsVarZzm = zzm(zzekVar2, iZzc);
                        } else if (iZzg3 == 1684103987) {
                            zzekVar2.zzL(iZzc + 8);
                            zzahzVar.zzb = zzacb.zzc(zzekVar2, Integer.toString(i4), str, zzsVarZzb);
                        } else if (iZzg3 == 1684366131) {
                            zzekVar2.zzL(iZzc + 8);
                            zzahzVar.zzb = zzacb.zzd(zzekVar2, Integer.toString(i4), str, zzsVarZzb);
                        } else if (iZzg3 == 1684103988) {
                            zzekVar2.zzL(iZzc + 8);
                            zzahzVar.zzb = zzacf.zza(zzekVar2, Integer.toString(i4), str, zzsVarZzb);
                        } else if (iZzg3 != 1684892784) {
                            if (iZzg3 == 1684305011 || iZzg3 == 1969517683) {
                                zzx zzxVar = new zzx();
                                zzxVar.zzN(i4);
                                zzxVar.zzad(str2);
                                zzxVar.zzB(iZzq2);
                                zzxVar.zzae(iZzn);
                                zzxVar.zzH(zzsVarZzb);
                                zzxVar.zzS(str);
                                zzahzVar.zzb = zzxVar.zzaj();
                            } else if (iZzg3 == 1682927731) {
                                int i16 = iZzg2 - 8;
                                byte[] bArr3 = zzb;
                                int length = bArr3.length;
                                byte[] bArrCopyOf = Arrays.copyOf(bArr3, length + i16);
                                zzekVar2.zzL(iZzc + 8);
                                zzekVar2.zzH(bArrCopyOf, length, i16);
                                listZzo = zzadx.zze(bArrCopyOf);
                            } else if (iZzg3 == 1684425825) {
                                byte[] bArr4 = new byte[iZzg2 - 8];
                                bArr4[0] = 102;
                                bArr4[1] = 76;
                                bArr4[2] = 97;
                                bArr4[3] = 67;
                                zzekVar2.zzL(iZzc + 12);
                                zzekVar2.zzH(bArr4, 4, iZzg2 - 12);
                                listZzo = zzfww.zzo(bArr4);
                            } else if (iZzg3 == 1634492771) {
                                int i17 = iZzg2 - 12;
                                byte[] bArr5 = new byte[i17];
                                zzekVar2.zzL(iZzc + 12);
                                zzekVar2.zzH(bArr5, 0, i17);
                                int i18 = zzdh.zza;
                                zzek zzekVar3 = new zzek(bArr5);
                                zzekVar3.zzL(9);
                                int iZzm3 = zzekVar3.zzm();
                                zzekVar3.zzL(20);
                                Pair pairCreate = Pair.create(Integer.valueOf(zzekVar3.zzp()), Integer.valueOf(iZzm3));
                                iZzn = ((Integer) pairCreate.first).intValue();
                                int iIntValue2 = ((Integer) pairCreate.second).intValue();
                                listZzo = zzfww.zzo(bArr5);
                                iZzq2 = iIntValue2;
                            } else if (iZzg3 == 1767990114) {
                                zzekVar2.zzL(iZzc + 9);
                                int iZzb = zzfzz.zzb(zzekVar.zzv());
                                byte[] bArr6 = new byte[iZzb];
                                zzekVar2.zzH(bArr6, 0, iZzb);
                                listZzo = zzfww.zzo(bArr6);
                            }
                            str5 = str5;
                        } else {
                            if (iZzg <= 0) {
                                throw zzaz.zza("Invalid sample rate for Dolby TrueHD MLP stream: " + iZzg, null);
                            }
                            str5 = str5;
                            iZzn = iZzg;
                            iZzq2 = 2;
                        }
                        str5 = str5;
                    }
                    if (i7 != i8) {
                        zzahuVarZzn = zzn(zzekVar2, i7);
                        str2 = zzahuVarZzn.zza;
                        byte[] bArr7 = zzahuVarZzn.zzb;
                        if (bArr7 != null) {
                            if ("audio/vorbis".equals(str2)) {
                                zzek zzekVar4 = new zzek(bArr7);
                                int i19 = 1;
                                zzekVar4.zzM(1);
                                int i20 = 0;
                                while (zzekVar4.zza() > 0 && zzekVar4.zzf() == 255) {
                                    zzekVar4.zzM(i19);
                                    i20 += 255;
                                    i19 = 1;
                                }
                                int iZzm4 = i20 + zzekVar4.zzm();
                                int i21 = 0;
                                while (zzekVar4.zza() > 0 && zzekVar4.zzf() == 255) {
                                    zzekVar4.zzM(1);
                                    i21 += 255;
                                }
                                int iZzm5 = i21 + zzekVar4.zzm();
                                byte[] bArr8 = new byte[iZzm4];
                                int iZzc3 = zzekVar4.zzc();
                                System.arraycopy(bArr7, iZzc3, bArr8, 0, iZzm4);
                                int i22 = iZzc3 + iZzm4 + iZzm5;
                                int length2 = bArr7.length - i22;
                                byte[] bArr9 = new byte[length2];
                                System.arraycopy(bArr7, i22, bArr9, 0, length2);
                                listZzo = zzfww.zzp(bArr8, bArr9);
                            } else {
                                if ("audio/mp4a-latm".equals(str2)) {
                                    zzabw zzabwVarZza = zzaby.zza(bArr7);
                                    iZzn = zzabwVarZza.zza;
                                    iZzq2 = zzabwVarZza.zzb;
                                    str5 = zzabwVarZza.zzc;
                                } else {
                                    str5 = str5;
                                }
                                listZzo = zzfww.zzo(bArr7);
                            }
                        }
                        str5 = str5;
                    } else {
                        str5 = str5;
                    }
                }
                str5 = str5;
            }
            iZzc += iZzg2;
            zzekVar2 = zzekVar;
            i10 = i2;
            i11 = i3;
            str4 = str4;
        }
        String str9 = str5;
        if (zzahzVar.zzb != null || str2 == null) {
            return;
        }
        zzx zzxVar2 = new zzx();
        zzxVar2.zzN(i4);
        zzxVar2.zzad(str2);
        zzxVar2.zzC(str9);
        zzxVar2.zzB(iZzq2);
        zzxVar2.zzae(iZzn);
        zzxVar2.zzX(i14);
        zzxVar2.zzP(listZzo);
        zzxVar2.zzH(zzsVarZzb);
        zzxVar2.zzS(str);
        if (zzahuVarZzn != null) {
            zzxVar2.zzA(zzfzz.zzf(zzahuVarZzn.zzc));
            zzxVar2.zzY(zzfzz.zzf(zzahuVarZzn.zzd));
        } else if (zzahsVarZzm != null) {
            zzxVar2.zzA(zzfzz.zzf(zzahsVarZzm.zza));
            zzxVar2.zzY(zzfzz.zzf(zzahsVarZzm.zzb));
        }
        zzahzVar.zzb = zzxVar2.zzaj();
    }
}
