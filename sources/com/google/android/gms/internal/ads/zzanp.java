package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzanp implements zzanh {
    final /* synthetic */ zzanq zza;
    private final zzej zzb = new zzej(new byte[5], 5);
    private final SparseArray zzc = new SparseArray();
    private final SparseIntArray zzd = new SparseIntArray();
    private final int zze;

    public zzanp(zzanq zzanqVar, int i) {
        this.zza = zzanqVar;
        this.zze = i;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:35:0x00eb  */
    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zza(zzek zzekVar) {
        zzer zzerVar;
        int i;
        int i2;
        if (zzekVar.zzm() == 2) {
            zzanq zzanqVar = this.zza;
            zzer zzerVar2 = (zzer) zzanqVar.zzb.get(0);
            if ((zzekVar.zzm() & 128) != 0) {
                zzekVar.zzM(1);
                int iZzq = zzekVar.zzq();
                int i3 = 3;
                zzekVar.zzM(3);
                zzej zzejVar = this.zzb;
                zzekVar.zzG(zzejVar, 2);
                zzejVar.zzn(3);
                int i4 = 13;
                zzanqVar.zzr = zzejVar.zzd(13);
                zzekVar.zzG(zzejVar, 2);
                int i5 = 4;
                zzejVar.zzn(4);
                int i6 = 12;
                zzekVar.zzM(zzejVar.zzd(12));
                SparseArray sparseArray = this.zzc;
                sparseArray.clear();
                SparseIntArray sparseIntArray = this.zzd;
                sparseIntArray.clear();
                int iZza = zzekVar.zza();
                while (iZza > 0) {
                    int i7 = 5;
                    zzekVar.zzG(zzejVar, 5);
                    int iZzd = zzejVar.zzd(8);
                    zzejVar.zzn(i3);
                    int iZzd2 = zzejVar.zzd(i4);
                    zzejVar.zzn(i5);
                    int iZzd3 = zzejVar.zzd(i6);
                    int iZzc = zzekVar.zzc();
                    int i8 = iZzc + iZzd3;
                    String str = null;
                    ArrayList arrayList = null;
                    int i9 = -1;
                    int iZzm = 0;
                    while (zzekVar.zzc() < i8) {
                        int iZzm2 = zzekVar.zzm();
                        int iZzc2 = zzekVar.zzc() + zzekVar.zzm();
                        if (iZzc2 > i8) {
                            break;
                        }
                        if (iZzm2 == i7) {
                            long jZzu = zzekVar.zzu();
                            if (jZzu == 1094921523) {
                                i9 = 129;
                            } else if (jZzu == 1161904947) {
                                i9 = 135;
                            } else if (jZzu == 1094921524) {
                                i9 = 172;
                            } else if (jZzu == 1212503619) {
                                i2 = 36;
                                i9 = i2;
                            }
                        } else if (iZzm2 == 106) {
                            i9 = 129;
                        } else if (iZzm2 == 122) {
                            i9 = 135;
                        } else if (iZzm2 == 127) {
                            int iZzm3 = zzekVar.zzm();
                            if (iZzm3 == 21) {
                                i9 = 172;
                            } else {
                                if (iZzm3 == 14) {
                                    i2 = 136;
                                } else if (iZzm3 == 33) {
                                    i2 = 139;
                                }
                                i9 = i2;
                            }
                        } else if (iZzm2 == 123) {
                            i2 = 138;
                            i9 = i2;
                        } else if (iZzm2 == 10) {
                            String strTrim = zzekVar.zzB(3, StandardCharsets.UTF_8).trim();
                            iZzm = zzekVar.zzm();
                            str = strTrim;
                        } else if (iZzm2 == 89) {
                            ArrayList arrayList2 = new ArrayList();
                            while (zzekVar.zzc() < iZzc2) {
                                zzej zzejVar2 = zzejVar;
                                String strTrim2 = zzekVar.zzB(3, StandardCharsets.UTF_8).trim();
                                int iZzm4 = zzekVar.zzm();
                                zzer zzerVar3 = zzerVar2;
                                byte[] bArr = new byte[4];
                                zzekVar.zzH(bArr, 0, 4);
                                arrayList2.add(new zzanr(strTrim2, iZzm4, bArr));
                                zzerVar2 = zzerVar3;
                                zzejVar = zzejVar2;
                                iZzq = iZzq;
                            }
                            zzerVar2 = zzerVar2;
                            iZzq = iZzq;
                            zzejVar = zzejVar;
                            arrayList = arrayList2;
                            i9 = 89;
                        } else {
                            zzerVar2 = zzerVar2;
                            iZzq = iZzq;
                            zzejVar = zzejVar;
                            if (iZzm2 == 111) {
                                i9 = 257;
                            }
                        }
                        zzekVar.zzM(iZzc2 - zzekVar.zzc());
                        zzerVar2 = zzerVar2;
                        zzejVar = zzejVar;
                        iZzq = iZzq;
                        i7 = 5;
                    }
                    zzer zzerVar4 = zzerVar2;
                    int i10 = iZzq;
                    zzej zzejVar3 = zzejVar;
                    zzekVar.zzL(i8);
                    zzans zzansVar = new zzans(i9, str, iZzm, arrayList, Arrays.copyOfRange(zzekVar.zzN(), iZzc, i8));
                    if (iZzd == 6 || iZzd == 5) {
                        iZzd = zzansVar.zza;
                    }
                    iZza -= iZzd3 + 5;
                    if (!zzanqVar.zzh.get(iZzd2)) {
                        zzanv zzanvVarZzb = zzanqVar.zze.zzb(iZzd, zzansVar);
                        sparseIntArray.put(iZzd2, iZzd2);
                        sparseArray.put(iZzd2, zzanvVarZzb);
                    }
                    i5 = 4;
                    zzerVar2 = zzerVar4;
                    zzejVar = zzejVar3;
                    iZzq = i10;
                    i3 = 3;
                    i4 = 13;
                    i6 = 12;
                }
                zzer zzerVar5 = zzerVar2;
                int i11 = iZzq;
                int size = sparseIntArray.size();
                int i12 = 0;
                while (i12 < size) {
                    int iKeyAt = sparseIntArray.keyAt(i12);
                    int iValueAt = sparseIntArray.valueAt(i12);
                    zzanqVar.zzh.put(iKeyAt, true);
                    zzanqVar.zzi.put(iValueAt, true);
                    zzanv zzanvVar = (zzanv) sparseArray.valueAt(i12);
                    if (zzanvVar != null) {
                        zzadf zzadfVar = zzanqVar.zzl;
                        i = i11;
                        zzanu zzanuVar = new zzanu(i, iKeyAt, 8192);
                        zzerVar = zzerVar5;
                        zzanvVar.zzb(zzerVar, zzadfVar, zzanuVar);
                        zzanqVar.zzg.put(iValueAt, zzanvVar);
                    } else {
                        zzerVar = zzerVar5;
                        i = i11;
                    }
                    i12++;
                    zzerVar5 = zzerVar;
                    i11 = i;
                }
                zzanqVar.zzg.remove(this.zze);
                zzanqVar.zzm = 0;
                if (zzanqVar.zzm == 0) {
                    zzanqVar.zzl.zzG();
                    zzanqVar.zzn = true;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzb(zzer zzerVar, zzadf zzadfVar, zzanu zzanuVar) {
    }
}
