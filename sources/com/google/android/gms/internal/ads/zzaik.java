package com.google.android.gms.internal.ads;

import android.util.Pair;
import android.util.SparseArray;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaik implements zzadc {
    private static final byte[] zza = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzz zzb;
    private long zzA;
    private zzaij zzB;
    private int zzC;
    private int zzD;
    private int zzE;
    private boolean zzF;
    private boolean zzG;
    private zzadf zzH;
    private zzaei[] zzI;
    private zzaei[] zzJ;
    private boolean zzK;
    private final zzajy zzc;
    private final int zzd;
    private final List zze;
    private final SparseArray zzf;
    private final zzek zzg;
    private final zzek zzh;
    private final zzek zzi;
    private final byte[] zzj;
    private final zzek zzk;
    private final zzafz zzl;
    private final zzek zzm;
    private final ArrayDeque zzn;
    private final ArrayDeque zzo;
    private final zzfu zzp;
    private zzfww zzq;
    private int zzr;
    private int zzs;
    private long zzt;
    private int zzu;
    private zzek zzv;
    private long zzw;
    private int zzx;
    private long zzy;
    private long zzz;

    static {
        zzx zzxVar = new zzx();
        zzxVar.zzad("application/x-emsg");
        zzb = zzxVar.zzaj();
    }

    @Deprecated
    public zzaik() {
        this(zzajy.zza, 32, null, null, zzfww.zzn(), null);
    }

    private static int zzg(int i) throws zzaz {
        if (i >= 0) {
            return i;
        }
        throw zzaz.zza("Unexpected negative value: " + i, null);
    }

    private static zzs zzh(List list) {
        int i;
        ArrayList arrayList;
        UUID[] uuidArr;
        zzais zzaisVar;
        int size = list.size();
        int i2 = 0;
        ArrayList arrayList2 = null;
        while (i2 < size) {
            zzey zzeyVar = (zzey) list.get(i2);
            if (zzeyVar.zzd == 1886614376) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                byte[] bArrZzN = zzeyVar.zza.zzN();
                zzek zzekVar = new zzek(bArrZzN);
                if (zzekVar.zzd() < 32) {
                    i = i2;
                    arrayList = arrayList2;
                    zzaisVar = null;
                } else {
                    zzekVar.zzL(0);
                    int iZza = zzekVar.zza();
                    int iZzg = zzekVar.zzg();
                    if (iZzg != iZza) {
                        zzdx.zzf("PsshAtomUtil", "Advertised atom size (" + iZzg + ") does not match buffer size: " + iZza);
                    } else {
                        int iZzg2 = zzekVar.zzg();
                        if (iZzg2 != 1886614376) {
                            zzdx.zzf("PsshAtomUtil", "Atom type is not pssh: " + iZzg2);
                        } else {
                            int iZza2 = zzaie.zza(zzekVar.zzg());
                            if (iZza2 > 1) {
                                zzdx.zzf("PsshAtomUtil", "Unsupported pssh version: " + iZza2);
                            } else {
                                UUID uuid = new UUID(zzekVar.zzt(), zzekVar.zzt());
                                if (iZza2 == 1) {
                                    int iZzp = zzekVar.zzp();
                                    uuidArr = new UUID[iZzp];
                                    int i3 = 0;
                                    while (i3 < iZzp) {
                                        uuidArr[i3] = new UUID(zzekVar.zzt(), zzekVar.zzt());
                                        i3++;
                                        i2 = i2;
                                        arrayList2 = arrayList2;
                                    }
                                    i = i2;
                                    arrayList = arrayList2;
                                } else {
                                    i = i2;
                                    arrayList = arrayList2;
                                    uuidArr = null;
                                }
                                int iZzp2 = zzekVar.zzp();
                                int iZza3 = zzekVar.zza();
                                if (iZzp2 != iZza3) {
                                    zzdx.zzf("PsshAtomUtil", "Atom data size (" + iZzp2 + ") does not match the bytes left: " + iZza3);
                                    zzaisVar = null;
                                } else {
                                    byte[] bArr = new byte[iZzp2];
                                    zzekVar.zzH(bArr, 0, iZzp2);
                                    zzaisVar = new zzais(uuid, iZza2, bArr, uuidArr);
                                }
                            }
                        }
                    }
                    i = i2;
                    arrayList = arrayList2;
                    zzaisVar = null;
                }
                UUID uuid2 = zzaisVar == null ? null : zzaisVar.zza;
                if (uuid2 == null) {
                    zzdx.zzf("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                    arrayList2 = arrayList;
                } else {
                    arrayList2 = arrayList;
                    arrayList2.add(new zzr(uuid2, null, "video/mp4", bArrZzN));
                }
                i2 = i + 1;
            } else {
                i = i2;
            }
            i2 = i + 1;
        }
        if (arrayList2 == null) {
            return null;
        }
        return new zzs(arrayList2);
    }

    private final void zzj() {
        this.zzr = 0;
        this.zzu = 0;
    }

    private static void zzk(zzek zzekVar, int i, zzaiy zzaiyVar) throws zzaz {
        zzekVar.zzL(i + 8);
        int iZzg = zzekVar.zzg();
        int i2 = zzaie.zza;
        if ((iZzg & 1) != 0) {
            throw zzaz.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iZzg & 2) != 0;
        int iZzp = zzekVar.zzp();
        if (iZzp == 0) {
            Arrays.fill(zzaiyVar.zzl, 0, zzaiyVar.zze, false);
            return;
        }
        int i3 = zzaiyVar.zze;
        if (iZzp != i3) {
            throw zzaz.zza("Senc sample count " + iZzp + " is different from fragment sample count" + i3, null);
        }
        Arrays.fill(zzaiyVar.zzl, 0, iZzp, z);
        zzaiyVar.zza(zzekVar.zza());
        zzek zzekVar2 = zzaiyVar.zzn;
        zzekVar.zzH(zzekVar2.zzN(), 0, zzekVar2.zzd());
        zzekVar2.zzL(0);
        zzaiyVar.zzo = false;
    }

    /* JADX WARN: Code duplicated, block: B:133:0x0363  */
    /* JADX WARN: Code duplicated, block: B:136:0x0373 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:137:0x0375  */
    /* JADX WARN: Code duplicated, block: B:138:0x037e  */
    /* JADX WARN: Code duplicated, block: B:141:0x0387  */
    /* JADX WARN: Code duplicated, block: B:142:0x0390  */
    /* JADX WARN: Code duplicated, block: B:145:0x0399  */
    /* JADX WARN: Code duplicated, block: B:146:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:147:0x03a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:148:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:149:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:150:0x03a9 A[PHI: r12
  0x03a9: PHI (r12v26 int) = (r12v24 int), (r12v27 int) binds: [B:146:0x03a0, B:149:0x03a8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:152:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:153:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:156:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:157:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:160:0x03ec A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:161:0x03ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:162:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:163:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:164:0x03f5  */
    private final void zzl(long j) throws zzaz {
        int i;
        byte[] bArr;
        int i2;
        byte[] bArr2;
        byte[] bArr3;
        int i3;
        boolean z;
        int i4;
        List list;
        int i5;
        int[] iArr;
        long[] jArr;
        boolean[] zArr;
        boolean z2;
        int i6;
        long j2;
        long j3;
        int iZzg;
        int iZzg2;
        int iZzg3;
        int iZzg4;
        long jZzu;
        boolean z3;
        long[] jArr2;
        final zzaik zzaikVar = this;
        while (true) {
            ArrayDeque arrayDeque = zzaikVar.zzn;
            if (arrayDeque.isEmpty() || ((zzex) arrayDeque.peek()).zza != j) {
                break;
            }
            zzex zzexVar = (zzex) arrayDeque.pop();
            int i7 = zzexVar.zzd;
            int i8 = 12;
            int i9 = 8;
            if (i7 == 1836019574) {
                zzs zzsVarZzh = zzh(zzexVar.zzb);
                zzex zzexVarZza = zzexVar.zza(1836475768);
                zzexVarZza.getClass();
                SparseArray sparseArray = new SparseArray();
                List list2 = zzexVarZza.zzb;
                int size = list2.size();
                long jZzu2 = -9223372036854775807L;
                int i10 = 0;
                while (i10 < size) {
                    zzey zzeyVar = (zzey) list2.get(i10);
                    int i11 = zzeyVar.zzd;
                    if (i11 == 1953654136) {
                        zzek zzekVar = zzeyVar.zza;
                        zzekVar.zzL(i8);
                        Pair pairCreate = Pair.create(Integer.valueOf(zzekVar.zzg()), new zzaif(zzekVar.zzg() - 1, zzekVar.zzg(), zzekVar.zzg(), zzekVar.zzg()));
                        sparseArray.put(((Integer) pairCreate.first).intValue(), (zzaif) pairCreate.second);
                    } else if (i11 == 1835362404) {
                        zzek zzekVar2 = zzeyVar.zza;
                        zzekVar2.zzL(8);
                        jZzu2 = zzaie.zza(zzekVar2.zzg()) == 0 ? zzekVar2.zzu() : zzekVar2.zzw();
                    }
                    i10++;
                    i8 = 12;
                }
                List listZzf = zzaie.zzf(zzexVar, new zzadq(), jZzu2, zzsVarZzh, (zzaikVar.zzd & 16) != 0, false, new zzftl(zzaikVar) { // from class: com.google.android.gms.internal.ads.zzaig
                    @Override // com.google.android.gms.internal.ads.zzftl
                    public final Object apply(Object obj) {
                        return (zzaiw) obj;
                    }
                });
                int size2 = listZzf.size();
                SparseArray sparseArray2 = zzaikVar.zzf;
                if (sparseArray2.size() == 0) {
                    String strZza = zzain.zza(listZzf);
                    for (int i12 = 0; i12 < size2; i12++) {
                        zzaiz zzaizVar = (zzaiz) listZzf.get(i12);
                        zzaiw zzaiwVar = zzaizVar.zza;
                        zzaei zzaeiVarZzw = zzaikVar.zzH.zzw(i12, zzaiwVar.zzb);
                        long j4 = zzaiwVar.zze;
                        zzaeiVarZzw.zzl(j4);
                        int i13 = zzaiwVar.zza;
                        sparseArray2.put(i13, new zzaij(zzaeiVarZzw, zzaizVar, zzm(sparseArray, i13), strZza));
                        zzaikVar.zzz = Math.max(zzaikVar.zzz, j4);
                    }
                    zzaikVar.zzH.zzG();
                } else {
                    zzdc.zzf(sparseArray2.size() == size2);
                    for (int i14 = 0; i14 < size2; i14++) {
                        zzaiz zzaizVar2 = (zzaiz) listZzf.get(i14);
                        int i15 = zzaizVar2.zza.zza;
                        ((zzaij) sparseArray2.get(i15)).zzh(zzaizVar2, zzm(sparseArray, i15));
                    }
                }
            } else if (i7 == 1836019558) {
                SparseArray sparseArray3 = zzaikVar.zzf;
                int i16 = zzaikVar.zzd;
                byte[] bArr4 = zzaikVar.zzj;
                List list3 = zzexVar.zzc;
                int size3 = list3.size();
                int i17 = 0;
                while (i17 < size3) {
                    zzex zzexVar2 = (zzex) list3.get(i17);
                    if (zzexVar2.zzd == 1953653094) {
                        zzey zzeyVarZzb = zzexVar2.zzb(1952868452);
                        zzeyVarZzb.getClass();
                        zzek zzekVar3 = zzeyVarZzb.zza;
                        zzekVar3.zzL(i9);
                        int iZzg5 = zzekVar3.zzg();
                        int i18 = zzaie.zza;
                        zzaij zzaijVar = (zzaij) sparseArray3.get(zzekVar3.zzg());
                        if (zzaijVar == null) {
                            zzaijVar = null;
                        } else {
                            if ((iZzg5 & 1) != 0) {
                                long jZzw = zzekVar3.zzw();
                                zzaiy zzaiyVar = zzaijVar.zzb;
                                zzaiyVar.zzb = jZzw;
                                zzaiyVar.zzc = jZzw;
                            }
                            zzaif zzaifVar = zzaijVar.zze;
                            zzaijVar.zzb.zza = new zzaif((iZzg5 & 2) != 0 ? zzekVar3.zzg() - 1 : zzaifVar.zza, (iZzg5 & 8) != 0 ? zzekVar3.zzg() : zzaifVar.zzb, (iZzg5 & 16) != 0 ? zzekVar3.zzg() : zzaifVar.zzc, (iZzg5 & 32) != 0 ? zzekVar3.zzg() : zzaifVar.zzd);
                        }
                        if (zzaijVar == null) {
                            i = 8;
                        } else {
                            zzaiy zzaiyVar2 = zzaijVar.zzb;
                            long j5 = zzaiyVar2.zzp;
                            boolean z4 = zzaiyVar2.zzq;
                            zzaijVar.zzi();
                            zzaijVar.zzm = true;
                            zzey zzeyVarZzb2 = zzexVar2.zzb(1952867444);
                            if (zzeyVarZzb2 == null || (i16 & 2) != 0) {
                                zzaiyVar2.zzp = j5;
                                zzaiyVar2.zzq = z4;
                            } else {
                                zzek zzekVar4 = zzeyVarZzb2.zza;
                                zzekVar4.zzL(8);
                                zzaiyVar2.zzp = zzaie.zza(zzekVar4.zzg()) == 1 ? zzekVar4.zzw() : zzekVar4.zzu();
                                zzaiyVar2.zzq = true;
                            }
                            List list4 = zzexVar2.zzb;
                            int size4 = list4.size();
                            list3 = list3;
                            int i19 = 0;
                            int i20 = 0;
                            int i21 = 0;
                            while (true) {
                                i2 = 1953658222;
                                if (i19 >= size4) {
                                    break;
                                }
                                int i22 = size3;
                                zzey zzeyVar2 = (zzey) list4.get(i19);
                                if (zzeyVar2.zzd == 1953658222) {
                                    zzek zzekVar5 = zzeyVar2.zza;
                                    zzekVar5.zzL(12);
                                    int iZzp = zzekVar5.zzp();
                                    if (iZzp > 0) {
                                        i21 += iZzp;
                                        i20++;
                                    }
                                }
                                i19++;
                                size3 = i22;
                            }
                            size3 = size3;
                            zzaijVar.zzh = 0;
                            zzaijVar.zzg = 0;
                            zzaijVar.zzf = 0;
                            zzaiyVar2.zzd = i20;
                            zzaiyVar2.zze = i21;
                            if (zzaiyVar2.zzg.length < i20) {
                                zzaiyVar2.zzf = new long[i20];
                                zzaiyVar2.zzg = new int[i20];
                            }
                            if (zzaiyVar2.zzh.length < i21) {
                                int i23 = (i21 * Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) / 100;
                                zzaiyVar2.zzh = new int[i23];
                                zzaiyVar2.zzi = new long[i23];
                                zzaiyVar2.zzj = new boolean[i23];
                                zzaiyVar2.zzl = new boolean[i23];
                            }
                            int i24 = 0;
                            int i25 = 0;
                            int i26 = 0;
                            while (true) {
                                long j6 = 0;
                                if (i24 >= size4) {
                                    break;
                                }
                                zzey zzeyVar3 = (zzey) list4.get(i24);
                                if (zzeyVar3.zzd == i2) {
                                    int i27 = i25 + 1;
                                    zzek zzekVar6 = zzeyVar3.zza;
                                    zzekVar6.zzL(8);
                                    int iZzg6 = zzekVar6.zzg();
                                    zzaiw zzaiwVar2 = zzaijVar.zzd.zza;
                                    zzaif zzaifVar2 = zzaiyVar2.zza;
                                    int i28 = zzeu.zza;
                                    zzaiyVar2.zzg[i25] = zzekVar6.zzp();
                                    long[] jArr3 = zzaiyVar2.zzf;
                                    long j7 = zzaiyVar2.zzb;
                                    jArr3[i25] = j7;
                                    if ((iZzg6 & 1) != 0) {
                                        jArr3[i25] = j7 + ((long) zzekVar6.zzg());
                                    }
                                    boolean z5 = (iZzg6 & 4) != 0;
                                    int i29 = zzaifVar2.zzd;
                                    int iZzg7 = z5 ? zzekVar6.zzg() : i29;
                                    int i30 = iZzg6 & 256;
                                    int i31 = iZzg6 & 512;
                                    int i32 = iZzg6 & 1024;
                                    int i33 = iZzg6 & 2048;
                                    int i34 = iZzg7;
                                    long[] jArr4 = zzaiwVar2.zzi;
                                    if (jArr4 != null) {
                                        list = list4;
                                        i4 = i24;
                                        if (jArr4.length == 1 && (jArr2 = zzaiwVar2.zzj) != null) {
                                            long j8 = jArr4[0];
                                            if (j8 == 0) {
                                                i32 = i32;
                                                i5 = i33;
                                            } else {
                                                i32 = i32;
                                                i5 = i33;
                                                if (zzeu.zzu(j8, 1000000L, zzaiwVar2.zzd, RoundingMode.DOWN) + zzeu.zzu(jArr2[0], 1000000L, zzaiwVar2.zzc, RoundingMode.DOWN) >= zzaiwVar2.zze) {
                                                }
                                            }
                                            j6 = jArr2[0];
                                        }
                                        iArr = zzaiyVar2.zzh;
                                        jArr = zzaiyVar2.zzi;
                                        zArr = zzaiyVar2.zzj;
                                        if (zzaiwVar2.zzb == 2 || (i16 & 1) == 0) {
                                            z2 = false;
                                        } else {
                                            z2 = true;
                                        }
                                        i6 = zzaiyVar2.zzg[i25] + i26;
                                        j2 = zzaiwVar2.zzc;
                                        j3 = zzaiyVar2.zzp;
                                        while (i26 < i6) {
                                            if (i30 != 0) {
                                                iZzg = zzekVar6.zzg();
                                            } else {
                                                iZzg = zzaifVar2.zzb;
                                            }
                                            zzg(iZzg);
                                            if (i31 != 0) {
                                                iZzg2 = zzekVar6.zzg();
                                            } else {
                                                iZzg2 = zzaifVar2.zzc;
                                            }
                                            zzg(iZzg2);
                                            if (i32 != 0) {
                                                iZzg3 = zzekVar6.zzg();
                                            } else if (i26 != 0) {
                                                iZzg3 = i29;
                                            } else if (z5) {
                                                iZzg3 = i34;
                                                i26 = 0;
                                            } else {
                                                i26 = 0;
                                                iZzg3 = i29;
                                            }
                                            if (i5 != 0) {
                                                iZzg4 = zzekVar6.zzg();
                                            } else {
                                                iZzg4 = 0;
                                            }
                                            jZzu = zzeu.zzu((((long) iZzg4) + j3) - j6, 1000000L, j2, RoundingMode.DOWN);
                                            jArr[i26] = jZzu;
                                            if (!zzaiyVar2.zzq) {
                                                jArr[i26] = jZzu + zzaijVar.zzd.zzh;
                                            }
                                            iArr[i26] = iZzg2;
                                            if (((iZzg3 >> 16) & 1) != 0) {
                                                z3 = false;
                                            } else if (z2) {
                                                z3 = true;
                                            } else if (i26 == 0) {
                                                z3 = true;
                                                i26 = 0;
                                            } else {
                                                z3 = false;
                                            }
                                            zArr[i26] = z3;
                                            j3 += (long) iZzg;
                                            i26++;
                                            j2 = j2;
                                            i6 = i6;
                                            i30 = i30;
                                            z5 = z5;
                                            z2 = z2;
                                        }
                                        zzaiyVar2.zzp = j3;
                                        i25 = i27;
                                        i26 = i6;
                                    } else {
                                        i4 = i24;
                                        list = list4;
                                    }
                                    i5 = i33;
                                    iArr = zzaiyVar2.zzh;
                                    jArr = zzaiyVar2.zzi;
                                    zArr = zzaiyVar2.zzj;
                                    if (zzaiwVar2.zzb == 2) {
                                        z2 = false;
                                    } else {
                                        z2 = false;
                                    }
                                    i6 = zzaiyVar2.zzg[i25] + i26;
                                    j2 = zzaiwVar2.zzc;
                                    j3 = zzaiyVar2.zzp;
                                    while (i26 < i6) {
                                        if (i30 != 0) {
                                            iZzg = zzekVar6.zzg();
                                        } else {
                                            iZzg = zzaifVar2.zzb;
                                        }
                                        zzg(iZzg);
                                        if (i31 != 0) {
                                            iZzg2 = zzekVar6.zzg();
                                        } else {
                                            iZzg2 = zzaifVar2.zzc;
                                        }
                                        zzg(iZzg2);
                                        if (i32 != 0) {
                                            iZzg3 = zzekVar6.zzg();
                                        } else if (i26 != 0) {
                                            iZzg3 = i29;
                                        } else if (z5) {
                                            iZzg3 = i34;
                                            i26 = 0;
                                        } else {
                                            i26 = 0;
                                            iZzg3 = i29;
                                        }
                                        if (i5 != 0) {
                                            iZzg4 = zzekVar6.zzg();
                                        } else {
                                            iZzg4 = 0;
                                        }
                                        jZzu = zzeu.zzu((((long) iZzg4) + j3) - j6, 1000000L, j2, RoundingMode.DOWN);
                                        jArr[i26] = jZzu;
                                        if (!zzaiyVar2.zzq) {
                                            jArr[i26] = jZzu + zzaijVar.zzd.zzh;
                                        }
                                        iArr[i26] = iZzg2;
                                        if (((iZzg3 >> 16) & 1) != 0) {
                                            z3 = false;
                                        } else if (z2) {
                                            z3 = true;
                                        } else if (i26 == 0) {
                                            z3 = true;
                                            i26 = 0;
                                        } else {
                                            z3 = false;
                                        }
                                        zArr[i26] = z3;
                                        j3 += (long) iZzg;
                                        i26++;
                                        j2 = j2;
                                        i6 = i6;
                                        i30 = i30;
                                        z5 = z5;
                                        z2 = z2;
                                    }
                                    zzaiyVar2.zzp = j3;
                                    i25 = i27;
                                    i26 = i6;
                                } else {
                                    i4 = i24;
                                    list = list4;
                                    i17 = i17;
                                    zzexVar2 = zzexVar2;
                                }
                                i24 = i4 + 1;
                                size4 = size4;
                                sparseArray3 = sparseArray3;
                                zzexVar = zzexVar;
                                bArr4 = bArr4;
                                i17 = i17;
                                zzexVar2 = zzexVar2;
                                list4 = list;
                                i16 = i16;
                                i2 = 1953658222;
                            }
                            sparseArray3 = sparseArray3;
                            i16 = i16;
                            zzexVar = zzexVar;
                            byte[] bArr5 = bArr4;
                            List list5 = list4;
                            i17 = i17;
                            zzex zzexVar3 = zzexVar2;
                            zzaiw zzaiwVar3 = zzaijVar.zzd.zza;
                            zzaif zzaifVar3 = zzaiyVar2.zza;
                            zzaifVar3.getClass();
                            zzaix zzaixVarZzb = zzaiwVar3.zzb(zzaifVar3.zza);
                            zzey zzeyVarZzb3 = zzexVar3.zzb(1935763834);
                            if (zzeyVarZzb3 != null) {
                                zzaixVarZzb.getClass();
                                int i35 = zzaixVarZzb.zzd;
                                zzek zzekVar7 = zzeyVarZzb3.zza;
                                zzekVar7.zzL(8);
                                if ((zzekVar7.zzg() & 1) == 1) {
                                    zzekVar7.zzM(8);
                                }
                                int iZzm = zzekVar7.zzm();
                                int iZzp2 = zzekVar7.zzp();
                                int i36 = zzaiyVar2.zze;
                                if (iZzp2 > i36) {
                                    throw zzaz.zza("Saiz sample count " + iZzp2 + " is greater than fragment sample count" + i36, null);
                                }
                                if (iZzm == 0) {
                                    boolean[] zArr2 = zzaiyVar2.zzl;
                                    i3 = 0;
                                    for (int i37 = 0; i37 < iZzp2; i37++) {
                                        int iZzm2 = zzekVar7.zzm();
                                        i3 += iZzm2;
                                        zArr2[i37] = iZzm2 > i35;
                                    }
                                    z = false;
                                } else {
                                    boolean z6 = iZzm > i35;
                                    i3 = iZzm * iZzp2;
                                    z = false;
                                    Arrays.fill(zzaiyVar2.zzl, 0, iZzp2, z6);
                                }
                                Arrays.fill(zzaiyVar2.zzl, iZzp2, zzaiyVar2.zze, z);
                                if (i3 > 0) {
                                    zzaiyVar2.zza(i3);
                                }
                            }
                            zzey zzeyVarZzb4 = zzexVar3.zzb(1935763823);
                            if (zzeyVarZzb4 != null) {
                                zzek zzekVar8 = zzeyVarZzb4.zza;
                                zzekVar8.zzL(8);
                                int iZzg8 = zzekVar8.zzg();
                                if ((iZzg8 & 1) == 1) {
                                    zzekVar8.zzM(8);
                                }
                                int iZzp3 = zzekVar8.zzp();
                                if (iZzp3 != 1) {
                                    throw zzaz.zza("Unexpected saio entry count: " + iZzp3, null);
                                }
                                zzaiyVar2.zzc += zzaie.zza(iZzg8) == 0 ? zzekVar8.zzu() : zzekVar8.zzw();
                            }
                            zzey zzeyVarZzb5 = zzexVar3.zzb(1936027235);
                            if (zzeyVarZzb5 != null) {
                                zzk(zzeyVarZzb5.zza, 0, zzaiyVar2);
                            }
                            String str = zzaixVarZzb != null ? zzaixVarZzb.zzb : null;
                            zzek zzekVar9 = null;
                            zzek zzekVar10 = null;
                            int i38 = 0;
                            while (i38 < list5.size()) {
                                List list6 = list5;
                                zzey zzeyVar4 = (zzey) list6.get(i38);
                                zzek zzekVar11 = zzeyVar4.zza;
                                int i39 = zzeyVar4.zzd;
                                if (i39 == 1935828848) {
                                    zzekVar11.zzL(12);
                                    if (zzekVar11.zzg() == 1936025959) {
                                        zzekVar9 = zzekVar11;
                                    }
                                } else if (i39 == 1936158820) {
                                    zzekVar11.zzL(12);
                                    if (zzekVar11.zzg() == 1936025959) {
                                        zzekVar10 = zzekVar11;
                                    }
                                }
                                i38++;
                                list5 = list6;
                            }
                            List list7 = list5;
                            if (zzekVar9 != null && zzekVar10 != null) {
                                zzekVar9.zzL(8);
                                int iZza = zzaie.zza(zzekVar9.zzg());
                                zzekVar9.zzM(4);
                                if (iZza == 1) {
                                    zzekVar9.zzM(4);
                                }
                                if (zzekVar9.zzg() != 1) {
                                    throw zzaz.zzc("Entry count in sbgp != 1 (unsupported).");
                                }
                                zzekVar10.zzL(8);
                                int iZza2 = zzaie.zza(zzekVar10.zzg());
                                zzekVar10.zzM(4);
                                if (iZza2 == 1) {
                                    if (zzekVar10.zzu() == 0) {
                                        throw zzaz.zzc("Variable length description in sgpd found (unsupported)");
                                    }
                                } else if (iZza2 >= 2) {
                                    zzekVar10.zzM(4);
                                }
                                if (zzekVar10.zzu() != 1) {
                                    throw zzaz.zzc("Entry count in sgpd != 1 (unsupported).");
                                }
                                zzekVar10.zzM(1);
                                int iZzm3 = zzekVar10.zzm();
                                int i40 = (iZzm3 & 240) >> 4;
                                int i41 = iZzm3 & 15;
                                if (zzekVar10.zzm() == 1) {
                                    int iZzm4 = zzekVar10.zzm();
                                    byte[] bArr6 = new byte[16];
                                    zzekVar10.zzH(bArr6, 0, 16);
                                    if (iZzm4 == 0) {
                                        int iZzm5 = zzekVar10.zzm();
                                        byte[] bArr7 = new byte[iZzm5];
                                        zzekVar10.zzH(bArr7, 0, iZzm5);
                                        bArr3 = bArr7;
                                    } else {
                                        bArr3 = null;
                                    }
                                    zzaiyVar2.zzk = true;
                                    zzaiyVar2.zzm = new zzaix(true, str, iZzm4, bArr6, i40, i41, bArr3);
                                }
                            }
                            int size5 = list7.size();
                            int i42 = 0;
                            while (i42 < size5) {
                                zzey zzeyVar5 = (zzey) list7.get(i42);
                                if (zzeyVar5.zzd == 1970628964) {
                                    zzek zzekVar12 = zzeyVar5.zza;
                                    zzekVar12.zzL(8);
                                    bArr2 = bArr5;
                                    zzekVar12.zzH(bArr2, 0, 16);
                                    if (Arrays.equals(bArr2, zza)) {
                                        zzk(zzekVar12, 16, zzaiyVar2);
                                    }
                                } else {
                                    bArr2 = bArr5;
                                }
                                i42++;
                                bArr5 = bArr2;
                            }
                            bArr = bArr5;
                            i = 8;
                        }
                        i17++;
                        i9 = i;
                        bArr4 = bArr;
                        list3 = list3;
                        size3 = size3;
                        sparseArray3 = sparseArray3;
                        zzexVar = zzexVar;
                        i16 = i16;
                    } else {
                        i = i9;
                    }
                    bArr = bArr4;
                    i17++;
                    i9 = i;
                    bArr4 = bArr;
                    list3 = list3;
                    size3 = size3;
                    sparseArray3 = sparseArray3;
                    zzexVar = zzexVar;
                    i16 = i16;
                }
                SparseArray sparseArray4 = sparseArray3;
                zzs zzsVarZzh2 = zzh(zzexVar.zzb);
                if (zzsVarZzh2 != null) {
                    int size6 = sparseArray4.size();
                    for (int i43 = 0; i43 < size6; i43++) {
                        ((zzaij) sparseArray4.valueAt(i43)).zzj(zzsVarZzh2);
                    }
                }
                zzaikVar = this;
                if (zzaikVar.zzy != -9223372036854775807L) {
                    int size7 = sparseArray4.size();
                    for (int i44 = 0; i44 < size7; i44++) {
                        zzaij zzaijVar2 = (zzaij) sparseArray4.valueAt(i44);
                        long j9 = zzaikVar.zzy;
                        int i45 = zzaijVar2.zzf;
                        while (true) {
                            zzaiy zzaiyVar3 = zzaijVar2.zzb;
                            if (i45 >= zzaiyVar3.zze || zzaiyVar3.zzi[i45] > j9) {
                                break;
                            }
                            if (zzaiyVar3.zzj[i45]) {
                                zzaijVar2.zzi = i45;
                            }
                            i45++;
                        }
                    }
                    zzaikVar.zzy = -9223372036854775807L;
                }
            } else if (!arrayDeque.isEmpty()) {
                ((zzex) arrayDeque.peek()).zzc(zzexVar);
            }
        }
        zzj();
    }

    private static final zzaif zzm(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (zzaif) sparseArray.valueAt(0);
        }
        zzaif zzaifVar = (zzaif) sparseArray.get(i);
        zzaifVar.getClass();
        return zzaifVar;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0203  */
    /* JADX WARN: Code duplicated, block: B:109:0x0215  */
    /* JADX WARN: Code duplicated, block: B:117:0x0234  */
    /* JADX WARN: Code duplicated, block: B:119:0x023d  */
    /* JADX WARN: Code duplicated, block: B:121:0x026c  */
    /* JADX WARN: Code duplicated, block: B:123:0x0274  */
    /* JADX WARN: Code duplicated, block: B:124:0x0278  */
    /* JADX WARN: Code duplicated, block: B:126:0x0280  */
    /* JADX WARN: Code duplicated, block: B:129:0x0290  */
    /* JADX WARN: Code duplicated, block: B:130:0x0294  */
    /* JADX WARN: Code duplicated, block: B:135:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:138:0x02be  */
    /* JADX WARN: Code duplicated, block: B:139:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:143:0x02da  */
    /* JADX WARN: Code duplicated, block: B:145:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:148:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:151:0x030e  */
    /* JADX WARN: Code duplicated, block: B:431:0x02ab A[EDGE_INSN: B:431:0x02ab->B:133:0x02ab BREAK  A[LOOP:7: B:66:0x014d->B:68:0x0153], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:432:0x0308 A[EDGE_INSN: B:432:0x0308->B:149:0x0308 BREAK  A[LOOP:8: B:141:0x02d2->B:435:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:437:0x022c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x014d A[LOOP:7: B:66:0x014d->B:68:0x0153, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:68:0x0153 A[LOOP:7: B:66:0x014d->B:68:0x0153, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:69:0x015e  */
    /* JADX WARN: Code duplicated, block: B:72:0x0174  */
    /* JADX WARN: Code duplicated, block: B:74:0x0178  */
    /* JADX WARN: Code duplicated, block: B:80:0x0184  */
    /* JADX WARN: Code duplicated, block: B:82:0x0195  */
    /* JADX WARN: Code duplicated, block: B:83:0x0197  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a8  */
    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        int i;
        zzaij zzaijVar;
        zzaiw zzaiwVar;
        zzaei zzaeiVar;
        long jZze;
        int i2;
        zzek zzekVar;
        byte[] bArrZzN;
        int i3;
        int i4;
        int iZzf;
        int i5;
        zzfu zzfuVar;
        zzfu zzfuVar2;
        zzfu zzfuVar3;
        int iZzb;
        int i6;
        int iZzg;
        String str;
        int i7;
        char c;
        int iZza;
        zzaix zzaixVarZzf;
        zzaeh zzaehVar;
        ArrayDeque arrayDeque;
        int i8;
        zzaii zzaiiVar;
        int i9;
        long j;
        long j2;
        int i10;
        int i11;
        int i12;
        int iZzc;
        long jZzu;
        long jZzu2;
        String str2;
        String str3;
        long jZzu3;
        long j3;
        long jZzw;
        long jZzw2;
        while (true) {
            int i13 = this.zzr;
            i = 0;
            if (i13 == 0) {
                if (this.zzu == 0) {
                    zzek zzekVar2 = this.zzm;
                    if (!zzaddVar.zzn(zzekVar2.zzN(), 0, 8, true)) {
                        this.zzp.zzd();
                        return -1;
                    }
                    this.zzu = 8;
                    zzekVar2.zzL(0);
                    this.zzt = zzekVar2.zzu();
                    this.zzs = zzekVar2.zzg();
                }
                long j4 = this.zzt;
                if (j4 == 1) {
                    zzek zzekVar3 = this.zzm;
                    zzaddVar.zzi(zzekVar3.zzN(), 8, 8);
                    this.zzu += 8;
                    this.zzt = zzekVar3.zzw();
                } else if (j4 == 0) {
                    long jZzd = zzaddVar.zzd();
                    if (jZzd == -1) {
                        ArrayDeque arrayDeque2 = this.zzn;
                        jZzd = !arrayDeque2.isEmpty() ? ((zzex) arrayDeque2.peek()).zza : -1L;
                    }
                    if (jZzd != -1) {
                        this.zzt = (jZzd - zzaddVar.zzf()) + ((long) this.zzu);
                    }
                }
                long j5 = this.zzt;
                long j6 = this.zzu;
                if (j5 < j6) {
                    throw zzaz.zzc("Atom size less than header length (unsupported).");
                }
                long jZzf = zzaddVar.zzf() - j6;
                int i14 = this.zzs;
                if ((i14 == 1836019558 || i14 == 1835295092) && !this.zzK) {
                    this.zzH.zzP(new zzaea(this.zzz, jZzf));
                    this.zzK = true;
                }
                if (this.zzs == 1836019558) {
                    SparseArray sparseArray = this.zzf;
                    int size = sparseArray.size();
                    for (int i15 = 0; i15 < size; i15++) {
                        zzaiy zzaiyVar = ((zzaij) sparseArray.valueAt(i15)).zzb;
                        zzaiyVar.zzc = jZzf;
                        zzaiyVar.zzb = jZzf;
                    }
                }
                int i16 = this.zzs;
                if (i16 == 1835295092) {
                    this.zzB = null;
                    this.zzw = jZzf + this.zzt;
                    this.zzr = 2;
                } else if (i16 == 1836019574 || i16 == 1953653099 || i16 == 1835297121 || i16 == 1835626086 || i16 == 1937007212 || i16 == 1836019558 || i16 == 1953653094 || i16 == 1836475768 || i16 == 1701082227) {
                    long jZzf2 = (zzaddVar.zzf() + this.zzt) - 8;
                    this.zzn.push(new zzex(i16, jZzf2));
                    if (this.zzt == this.zzu) {
                        zzl(jZzf2);
                    } else {
                        zzj();
                    }
                } else if (i16 == 1751411826 || i16 == 1835296868 || i16 == 1836476516 || i16 == 1936286840 || i16 == 1937011556 || i16 == 1937011827 || i16 == 1668576371 || i16 == 1937011555 || i16 == 1937011578 || i16 == 1937013298 || i16 == 1937007471 || i16 == 1668232756 || i16 == 1937011571 || i16 == 1952867444 || i16 == 1952868452 || i16 == 1953196132 || i16 == 1953654136 || i16 == 1953658222 || i16 == 1886614376 || i16 == 1935763834 || i16 == 1935763823 || i16 == 1936027235 || i16 == 1970628964 || i16 == 1935828848 || i16 == 1936158820 || i16 == 1701606260 || i16 == 1835362404 || i16 == 1701671783) {
                    if (this.zzu != 8) {
                        throw zzaz.zzc("Leaf atom defines extended atom size (unsupported).");
                    }
                    if (this.zzt > 2147483647L) {
                        throw zzaz.zzc("Leaf atom with length > 2147483647 (unsupported).");
                    }
                    zzek zzekVar4 = new zzek((int) this.zzt);
                    System.arraycopy(this.zzm.zzN(), 0, zzekVar4.zzN(), 0, 8);
                    this.zzv = zzekVar4;
                    this.zzr = 1;
                } else {
                    if (this.zzt > 2147483647L) {
                        throw zzaz.zzc("Skipping atom with length > 2147483647 (unsupported).");
                    }
                    this.zzv = null;
                    this.zzr = 1;
                }
            } else if (i13 != 1) {
                long j7 = Long.MAX_VALUE;
                if (i13 != 2) {
                    zzaijVar = this.zzB;
                    if (zzaijVar != null) {
                        break;
                    }
                    SparseArray sparseArray2 = this.zzf;
                    int size2 = sparseArray2.size();
                    long j8 = Long.MAX_VALUE;
                    zzaij zzaijVar2 = null;
                    for (int i17 = 0; i17 < size2; i17++) {
                        zzaij zzaijVar3 = (zzaij) sparseArray2.valueAt(i17);
                        if ((zzaijVar3.zzm || zzaijVar3.zzf != zzaijVar3.zzd.zzb) && (!zzaijVar3.zzm || zzaijVar3.zzh != zzaijVar3.zzb.zzd)) {
                            long jZzd2 = zzaijVar3.zzd();
                            if (jZzd2 < j8) {
                                zzaijVar2 = zzaijVar3;
                                j8 = jZzd2;
                            }
                        }
                    }
                    if (zzaijVar2 != null) {
                        int iZzd = (int) (zzaijVar2.zzd() - zzaddVar.zzf());
                        if (iZzd < 0) {
                            zzdx.zzf("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                            iZzd = 0;
                        }
                        zzaddVar.zzk(iZzd);
                        this.zzB = zzaijVar2;
                        zzaijVar = zzaijVar2;
                        break;
                    }
                    int iZzf2 = (int) (this.zzw - zzaddVar.zzf());
                    if (iZzf2 < 0) {
                        throw zzaz.zza("Offset to end of mdat was negative.", null);
                    }
                    zzaddVar.zzk(iZzf2);
                    zzj();
                } else {
                    SparseArray sparseArray3 = this.zzf;
                    int size3 = sparseArray3.size();
                    zzaij zzaijVar4 = null;
                    for (int i18 = 0; i18 < size3; i18++) {
                        zzaiy zzaiyVar2 = ((zzaij) sparseArray3.valueAt(i18)).zzb;
                        if (zzaiyVar2.zzo) {
                            long j9 = zzaiyVar2.zzc;
                            if (j9 < j7) {
                                zzaijVar4 = (zzaij) sparseArray3.valueAt(i18);
                                j7 = j9;
                            }
                        }
                    }
                    if (zzaijVar4 == null) {
                        this.zzr = 3;
                    } else {
                        int iZzf3 = (int) (j7 - zzaddVar.zzf());
                        if (iZzf3 < 0) {
                            throw zzaz.zza("Offset to encryption data was negative.", null);
                        }
                        zzaddVar.zzk(iZzf3);
                        zzaiy zzaiyVar3 = zzaijVar4.zzb;
                        zzek zzekVar5 = zzaiyVar3.zzn;
                        zzaddVar.zzi(zzekVar5.zzN(), 0, zzekVar5.zzd());
                        zzekVar5.zzL(0);
                        zzaiyVar3.zzo = false;
                    }
                }
            } else {
                long j10 = this.zzt - ((long) this.zzu);
                zzek zzekVar6 = this.zzv;
                int i19 = (int) j10;
                if (zzekVar6 != null) {
                    zzaddVar.zzi(zzekVar6.zzN(), 8, i19);
                    zzey zzeyVar = new zzey(this.zzs, zzekVar6);
                    long jZzf3 = zzaddVar.zzf();
                    ArrayDeque arrayDeque3 = this.zzn;
                    if (arrayDeque3.isEmpty()) {
                        int i20 = zzeyVar.zzd;
                        if (i20 == 1936286840) {
                            zzek zzekVar7 = zzeyVar.zza;
                            zzekVar7.zzL(8);
                            int iZza2 = zzaie.zza(zzekVar7.zzg());
                            zzekVar7.zzM(4);
                            long jZzu4 = zzekVar7.zzu();
                            if (iZza2 == 0) {
                                jZzw = zzekVar7.zzu();
                                jZzw2 = zzekVar7.zzu();
                            } else {
                                jZzw = zzekVar7.zzw();
                                jZzw2 = zzekVar7.zzw();
                            }
                            long j11 = jZzf3 + jZzw2;
                            long jZzu5 = zzeu.zzu(jZzw, 1000000L, jZzu4, RoundingMode.DOWN);
                            zzekVar7.zzM(2);
                            int iZzq = zzekVar7.zzq();
                            int[] iArr = new int[iZzq];
                            long[] jArr = new long[iZzq];
                            long[] jArr2 = new long[iZzq];
                            long[] jArr3 = new long[iZzq];
                            long jZzu6 = jZzu5;
                            int i21 = 0;
                            while (i21 < iZzq) {
                                int iZzg2 = zzekVar7.zzg();
                                if ((iZzg2 & Integer.MIN_VALUE) != 0) {
                                    throw zzaz.zza("Unhandled indirect reference", null);
                                }
                                long jZzu7 = zzekVar7.zzu();
                                iArr[i21] = iZzg2 & Integer.MAX_VALUE;
                                jArr[i21] = j11;
                                jArr3[i21] = jZzu6;
                                long j12 = jZzw + jZzu7;
                                int i22 = i21;
                                int i23 = iZzq;
                                long[] jArr4 = jArr2;
                                long[] jArr5 = jArr3;
                                int[] iArr2 = iArr;
                                jZzu6 = zzeu.zzu(j12, 1000000L, jZzu4, RoundingMode.DOWN);
                                jArr4[i22] = jZzu6 - jArr5[i22];
                                zzekVar7.zzM(4);
                                j11 += (long) iArr2[i22];
                                jArr2 = jArr4;
                                jArr3 = jArr5;
                                iArr = iArr2;
                                i21 = i22 + 1;
                                jZzw = j12;
                                jArr = jArr;
                                iZzq = i23;
                            }
                            Pair pairCreate = Pair.create(Long.valueOf(jZzu5), new zzacp(iArr, jArr, jArr2, jArr3));
                            this.zzA = ((Long) pairCreate.first).longValue();
                            this.zzH.zzP((zzaeb) pairCreate.second);
                            this.zzK = true;
                        } else if (i20 == 1701671783) {
                            zzek zzekVar8 = zzeyVar.zza;
                            if (this.zzI.length != 0) {
                                zzekVar8.zzL(8);
                                int iZza3 = zzaie.zza(zzekVar8.zzg());
                                if (iZza3 == 0) {
                                    String strZzy = zzekVar8.zzy((char) 0);
                                    strZzy.getClass();
                                    String strZzy2 = zzekVar8.zzy((char) 0);
                                    strZzy2.getClass();
                                    long jZzu8 = zzekVar8.zzu();
                                    jZzu = zzeu.zzu(zzekVar8.zzu(), 1000000L, jZzu8, RoundingMode.DOWN);
                                    long j13 = this.zzA;
                                    long j14 = j13 != -9223372036854775807L ? j13 + jZzu : -9223372036854775807L;
                                    jZzu2 = zzeu.zzu(zzekVar8.zzu(), 1000L, jZzu8, RoundingMode.DOWN);
                                    str2 = strZzy;
                                    str3 = strZzy2;
                                    jZzu3 = zzekVar8.zzu();
                                    j3 = j14;
                                } else if (iZza3 != 1) {
                                    zzdx.zzf("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + iZza3);
                                } else {
                                    long jZzu9 = zzekVar8.zzu();
                                    long jZzu10 = zzeu.zzu(zzekVar8.zzw(), 1000000L, jZzu9, RoundingMode.DOWN);
                                    long jZzu11 = zzeu.zzu(zzekVar8.zzu(), 1000L, jZzu9, RoundingMode.DOWN);
                                    long jZzu12 = zzekVar8.zzu();
                                    String strZzy3 = zzekVar8.zzy((char) 0);
                                    strZzy3.getClass();
                                    String strZzy4 = zzekVar8.zzy((char) 0);
                                    strZzy4.getClass();
                                    jZzu2 = jZzu11;
                                    jZzu3 = jZzu12;
                                    str2 = strZzy3;
                                    str3 = strZzy4;
                                    j3 = jZzu10;
                                    jZzu = -9223372036854775807L;
                                }
                                byte[] bArr = new byte[zzekVar8.zza()];
                                zzekVar8.zzH(bArr, 0, zzekVar8.zza());
                                zzek zzekVar9 = new zzek(this.zzl.zza(new zzafy(str2, str3, jZzu2, jZzu3, bArr)));
                                int iZza4 = zzekVar9.zza();
                                for (zzaei zzaeiVar2 : this.zzI) {
                                    zzekVar9.zzL(0);
                                    zzaeiVar2.zzr(zzekVar9, iZza4);
                                }
                                if (j3 == -9223372036854775807L) {
                                    this.zzo.addLast(new zzaii(jZzu, true, iZza4));
                                    this.zzx += iZza4;
                                } else {
                                    ArrayDeque arrayDeque4 = this.zzo;
                                    if (arrayDeque4.isEmpty()) {
                                        for (zzaei zzaeiVar3 : this.zzI) {
                                            zzaeiVar3.zzt(j3, 1, iZza4, 0, null);
                                        }
                                    } else {
                                        arrayDeque4.addLast(new zzaii(j3, false, iZza4));
                                        this.zzx += iZza4;
                                    }
                                }
                            }
                        }
                    } else {
                        ((zzex) arrayDeque3.peek()).zzd(zzeyVar);
                    }
                } else {
                    zzaddVar.zzk(i19);
                }
                zzl(zzaddVar.zzf());
            }
        }
        String str4 = "video/avc";
        if (this.zzr == 3) {
            this.zzC = zzaijVar.zzb();
            String str5 = zzaijVar.zzd.zza.zzg.zzo;
            if (!Objects.equals(str5, "video/avc")) {
                Objects.equals(str5, "video/hevc");
            }
            this.zzF = true;
            if (zzaijVar.zzf < zzaijVar.zzi) {
                zzaddVar.zzk(this.zzC);
                zzaix zzaixVarZzf2 = zzaijVar.zzf();
                if (zzaixVarZzf2 != null) {
                    zzaiy zzaiyVar4 = zzaijVar.zzb;
                    zzek zzekVar10 = zzaiyVar4.zzn;
                    int i24 = zzaixVarZzf2.zzd;
                    if (i24 != 0) {
                        zzekVar10.zzM(i24);
                    }
                    if (zzaiyVar4.zzb(zzaijVar.zzf)) {
                        zzekVar10.zzM(zzekVar10.zzq() * 6);
                    }
                }
                if (!zzaijVar.zzl()) {
                    this.zzB = null;
                }
                i8 = 3;
            } else {
                if (zzaijVar.zzd.zza.zzh == 1) {
                    this.zzC -= 8;
                    zzaddVar.zzk(8);
                }
                if ("audio/ac4".equals(zzaijVar.zzd.zza.zzg.zzo)) {
                    this.zzD = zzaijVar.zzc(this.zzC, 7);
                    int i25 = this.zzC;
                    zzek zzekVar11 = this.zzk;
                    zzacf.zzc(i25, zzekVar11);
                    zzaijVar.zza.zzr(zzekVar11, 7);
                    iZzc = this.zzD + 7;
                    this.zzD = iZzc;
                } else {
                    iZzc = zzaijVar.zzc(this.zzC, 0);
                    this.zzD = iZzc;
                }
                this.zzC += iZzc;
                this.zzr = 4;
                this.zzE = 0;
                zzaiwVar = zzaijVar.zzd.zza;
                zzaeiVar = zzaijVar.zza;
                jZze = zzaijVar.zze();
                i2 = zzaiwVar.zzk;
                if (i2 == 0) {
                    while (true) {
                        i11 = this.zzD;
                        i12 = this.zzC;
                        if (i11 < i12) {
                            break;
                        }
                        this.zzD += zzaeiVar.zzf(zzaddVar, i12 - i11, false);
                    }
                } else {
                    zzekVar = this.zzh;
                    bArrZzN = zzekVar.zzN();
                    bArrZzN[0] = 0;
                    bArrZzN[1] = 0;
                    bArrZzN[2] = 0;
                    i3 = 4 - i2;
                    while (this.zzD < this.zzC) {
                        i4 = this.zzE;
                        if (i4 == 0) {
                            if (this.zzJ.length <= 0 || !this.zzF) {
                                iZzb = zzfq.zzb(zzaiwVar.zzg);
                                if (i2 + iZzb > this.zzC - this.zzD) {
                                    i6 = 0;
                                } else {
                                    i6 = iZzb;
                                }
                            } else {
                                i6 = i;
                            }
                            zzaddVar.zzi(bArrZzN, i3, i2 + i6);
                            zzekVar.zzL(0);
                            iZzg = zzekVar.zzg();
                            if (iZzg >= 0) {
                                throw zzaz.zza("Invalid NAL length", null);
                            }
                            this.zzE = iZzg - i6;
                            zzek zzekVar12 = this.zzg;
                            zzekVar12.zzL(0);
                            zzaeiVar.zzr(zzekVar12, 4);
                            this.zzD += 4;
                            this.zzC += i3;
                            if (this.zzJ.length > 0 || i6 <= 0) {
                                str = str4;
                                i7 = i3;
                                c = 6;
                            } else {
                                zzz zzzVar = zzaiwVar.zzg;
                                byte b = bArrZzN[4];
                                byte[] bArr2 = zzfq.zza;
                                String str6 = zzzVar.zzo;
                                if (Objects.equals(str6, str4)) {
                                    i7 = i3;
                                } else {
                                    i7 = i3;
                                    if (!zzay.zzg(zzzVar.zzk, str4)) {
                                        str = str4;
                                        c = 6;
                                    }
                                    boolean z = (!Objects.equals(str6, "video/hevc") || zzay.zzg(zzzVar.zzk, "video/hevc")) && ((b & 126) >> 1) == 39;
                                    this.zzG = z;
                                    zzaeiVar.zzr(zzekVar, i6);
                                    this.zzD += i6;
                                    if (i6 > 0 && !this.zzF && zzfq.zzj(bArrZzN, 4, i6, zzaiwVar.zzg)) {
                                        this.zzF = true;
                                    }
                                    i3 = i7;
                                    str4 = str;
                                }
                                str = str4;
                                c = 6;
                                if ((b & Ascii.US) != 6) {
                                    if (Objects.equals(str6, "video/hevc")) {
                                    }
                                }
                                this.zzG = z;
                                zzaeiVar.zzr(zzekVar, i6);
                                this.zzD += i6;
                                if (i6 > 0) {
                                    this.zzF = true;
                                }
                                i3 = i7;
                                str4 = str;
                            }
                            this.zzG = z;
                            zzaeiVar.zzr(zzekVar, i6);
                            this.zzD += i6;
                            if (i6 > 0) {
                                this.zzF = true;
                            }
                            i3 = i7;
                            str4 = str;
                        } else {
                            String str7 = str4;
                            int i26 = i3;
                            if (this.zzG) {
                                zzek zzekVar13 = this.zzi;
                                zzekVar13.zzI(i4);
                                zzaddVar.zzi(zzekVar13.zzN(), 0, this.zzE);
                                zzaeiVar.zzr(zzekVar13, this.zzE);
                                iZzf = this.zzE;
                                int iZzc2 = zzfq.zzc(zzekVar13.zzN(), zzekVar13.zzd());
                                zzekVar13.zzL(0);
                                zzekVar13.zzK(iZzc2);
                                i5 = zzaiwVar.zzg.zzq;
                                if (i5 == -1) {
                                    zzfuVar3 = this.zzp;
                                    if (zzfuVar3.zza() != 0) {
                                        zzfuVar3.zze(0);
                                    }
                                } else {
                                    zzfuVar = this.zzp;
                                    if (zzfuVar.zza() != i5) {
                                        zzfuVar.zze(i5);
                                    }
                                }
                                zzfuVar2 = this.zzp;
                                zzfuVar2.zzb(jZze, zzekVar13);
                                if ((zzaijVar.zza() & 4) != 0) {
                                    zzfuVar2.zzd();
                                }
                            } else {
                                iZzf = zzaeiVar.zzf(zzaddVar, i4, false);
                            }
                            this.zzD += iZzf;
                            this.zzE -= iZzf;
                            i3 = i26;
                            str4 = str7;
                        }
                        i = 0;
                    }
                }
                iZza = zzaijVar.zza();
                if (!this.zzF) {
                    iZza |= 67108864;
                }
                int i27 = iZza;
                zzaixVarZzf = zzaijVar.zzf();
                if (zzaixVarZzf != null) {
                    zzaehVar = zzaixVarZzf.zzc;
                } else {
                    zzaehVar = null;
                }
                zzaeiVar.zzt(jZze, i27, this.zzC, 0, zzaehVar);
                while (true) {
                    arrayDeque = this.zzo;
                    if (!arrayDeque.isEmpty()) {
                        break;
                    }
                    zzaiiVar = (zzaii) arrayDeque.removeFirst();
                    int i28 = this.zzx;
                    i9 = zzaiiVar.zzc;
                    this.zzx = i28 - i9;
                    j = zzaiiVar.zza;
                    if (zzaiiVar.zzb) {
                        j += jZze;
                    }
                    j2 = j;
                    for (zzaei zzaeiVar4 : this.zzI) {
                        zzaeiVar4.zzt(j2, 1, i9, this.zzx, null);
                    }
                }
                if (!zzaijVar.zzl()) {
                    this.zzB = null;
                }
                i8 = 3;
            }
        } else {
            zzaiwVar = zzaijVar.zzd.zza;
            zzaeiVar = zzaijVar.zza;
            jZze = zzaijVar.zze();
            i2 = zzaiwVar.zzk;
            if (i2 == 0) {
                while (true) {
                    i11 = this.zzD;
                    i12 = this.zzC;
                    if (i11 < i12) {
                        break;
                        break;
                    }
                    this.zzD += zzaeiVar.zzf(zzaddVar, i12 - i11, false);
                }
            } else {
                zzekVar = this.zzh;
                bArrZzN = zzekVar.zzN();
                bArrZzN[0] = 0;
                bArrZzN[1] = 0;
                bArrZzN[2] = 0;
                i3 = 4 - i2;
                while (this.zzD < this.zzC) {
                    i4 = this.zzE;
                    if (i4 == 0) {
                        if (this.zzJ.length <= 0) {
                            iZzb = zzfq.zzb(zzaiwVar.zzg);
                            if (i2 + iZzb > this.zzC - this.zzD) {
                                i6 = 0;
                            } else {
                                i6 = iZzb;
                            }
                        } else {
                            iZzb = zzfq.zzb(zzaiwVar.zzg);
                            if (i2 + iZzb > this.zzC - this.zzD) {
                                i6 = 0;
                            } else {
                                i6 = iZzb;
                            }
                        }
                        zzaddVar.zzi(bArrZzN, i3, i2 + i6);
                        zzekVar.zzL(0);
                        iZzg = zzekVar.zzg();
                        if (iZzg >= 0) {
                            throw zzaz.zza("Invalid NAL length", null);
                        }
                        this.zzE = iZzg - i6;
                        zzek zzekVar14 = this.zzg;
                        zzekVar14.zzL(0);
                        zzaeiVar.zzr(zzekVar14, 4);
                        this.zzD += 4;
                        this.zzC += i3;
                        if (this.zzJ.length > 0) {
                            str = str4;
                            i7 = i3;
                            c = 6;
                        } else {
                            str = str4;
                            i7 = i3;
                            c = 6;
                        }
                        this.zzG = z;
                        zzaeiVar.zzr(zzekVar, i6);
                        this.zzD += i6;
                        if (i6 > 0) {
                            this.zzF = true;
                        }
                        i3 = i7;
                        str4 = str;
                    } else {
                        String str8 = str4;
                        int i29 = i3;
                        if (this.zzG) {
                            zzek zzekVar15 = this.zzi;
                            zzekVar15.zzI(i4);
                            zzaddVar.zzi(zzekVar15.zzN(), 0, this.zzE);
                            zzaeiVar.zzr(zzekVar15, this.zzE);
                            iZzf = this.zzE;
                            int iZzc3 = zzfq.zzc(zzekVar15.zzN(), zzekVar15.zzd());
                            zzekVar15.zzL(0);
                            zzekVar15.zzK(iZzc3);
                            i5 = zzaiwVar.zzg.zzq;
                            if (i5 == -1) {
                                zzfuVar3 = this.zzp;
                                if (zzfuVar3.zza() != 0) {
                                    zzfuVar3.zze(0);
                                }
                            } else {
                                zzfuVar = this.zzp;
                                if (zzfuVar.zza() != i5) {
                                    zzfuVar.zze(i5);
                                }
                            }
                            zzfuVar2 = this.zzp;
                            zzfuVar2.zzb(jZze, zzekVar15);
                            if ((zzaijVar.zza() & 4) != 0) {
                                zzfuVar2.zzd();
                            }
                        } else {
                            iZzf = zzaeiVar.zzf(zzaddVar, i4, false);
                        }
                        this.zzD += iZzf;
                        this.zzE -= iZzf;
                        i3 = i29;
                        str4 = str8;
                    }
                    i = 0;
                }
            }
            iZza = zzaijVar.zza();
            if (!this.zzF) {
                iZza |= 67108864;
            }
            int i210 = iZza;
            zzaixVarZzf = zzaijVar.zzf();
            if (zzaixVarZzf != null) {
                zzaehVar = zzaixVarZzf.zzc;
            } else {
                zzaehVar = null;
            }
            zzaeiVar.zzt(jZze, i210, this.zzC, 0, zzaehVar);
            while (true) {
                arrayDeque = this.zzo;
                if (!arrayDeque.isEmpty()) {
                    break;
                    break;
                }
                zzaiiVar = (zzaii) arrayDeque.removeFirst();
                int i211 = this.zzx;
                i9 = zzaiiVar.zzc;
                this.zzx = i211 - i9;
                j = zzaiiVar.zza;
                if (zzaiiVar.zzb) {
                    j += jZze;
                }
                j2 = j;
                while (i10 < r3) {
                    zzaeiVar4.zzt(j2, 1, i9, this.zzx, null);
                }
            }
            if (!zzaijVar.zzl()) {
                this.zzB = null;
            }
            i8 = 3;
        }
        this.zzr = i8;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ zzadc zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ List zzd() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zze(zzadf zzadfVar) {
        int i;
        int i2 = this.zzd;
        if ((i2 & 32) == 0) {
            zzadfVar = new zzakb(zzadfVar, this.zzc);
        }
        this.zzH = zzadfVar;
        zzj();
        zzaei[] zzaeiVarArr = new zzaei[2];
        this.zzI = zzaeiVarArr;
        int i3 = 100;
        int i4 = 0;
        if ((i2 & 4) != 0) {
            zzaeiVarArr[0] = this.zzH.zzw(100, 5);
            i = 1;
            i3 = 101;
        } else {
            i = 0;
        }
        zzaei[] zzaeiVarArr2 = (zzaei[]) zzeu.zzQ(this.zzI, i);
        this.zzI = zzaeiVarArr2;
        for (zzaei zzaeiVar : zzaeiVarArr2) {
            zzaeiVar.zzm(zzb);
        }
        List list = this.zze;
        this.zzJ = new zzaei[list.size()];
        while (i4 < this.zzJ.length) {
            zzaei zzaeiVarZzw = this.zzH.zzw(i3, 3);
            zzaeiVarZzw.zzm((zzz) list.get(i4));
            this.zzJ[i4] = zzaeiVarZzw;
            i4++;
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        SparseArray sparseArray = this.zzf;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            ((zzaij) sparseArray.valueAt(i)).zzi();
        }
        this.zzo.clear();
        this.zzx = 0;
        this.zzp.zzc();
        this.zzy = j2;
        this.zzn.clear();
        zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        zzaef zzaefVarZza = zzaiv.zza(zzaddVar);
        this.zzq = zzaefVarZza != null ? zzfww.zzo(zzaefVarZza) : zzfww.zzn();
        return zzaefVarZza == null;
    }

    public zzaik(zzajy zzajyVar, int i, zzer zzerVar, zzaiw zzaiwVar, List list, zzaei zzaeiVar) {
        this.zzc = zzajyVar;
        this.zzd = i;
        this.zze = Collections.unmodifiableList(list);
        this.zzl = new zzafz();
        this.zzm = new zzek(16);
        this.zzg = new zzek(zzfq.zza);
        this.zzh = new zzek(6);
        this.zzi = new zzek();
        byte[] bArr = new byte[16];
        this.zzj = bArr;
        this.zzk = new zzek(bArr);
        this.zzn = new ArrayDeque();
        this.zzo = new ArrayDeque();
        this.zzf = new SparseArray();
        this.zzq = zzfww.zzn();
        this.zzz = -9223372036854775807L;
        this.zzy = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzH = zzadf.zza;
        this.zzI = new zzaei[0];
        this.zzJ = new zzaei[0];
        this.zzp = new zzfu(new zzft() { // from class: com.google.android.gms.internal.ads.zzaih
            @Override // com.google.android.gms.internal.ads.zzft
            public final void zza(long j, zzek zzekVar) {
                zzaco.zza(j, zzekVar, this.zza.zzJ);
            }
        });
    }
}
