package com.google.android.gms.internal.ads;

import com.amazon.device.ads.DtbConstants;
import com.google.common.primitives.SignedBytes;
import com.json.mediationsdk.utils.IronSourceConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzacf {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {2002, 2000, 1920, IronSourceConstants.RV_OPERATIONAL_LOAD_SUCCESS, IronSourceConstants.RV_OPERATIONAL_LOAD_AD, 1001, 1000, 960, 800, 800, DtbConstants.DEFAULT_PLAYER_HEIGHT, 400, 400, 2048};

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:144:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:146:0x0201  */
    /* JADX WARN: Code duplicated, block: B:153:0x0215  */
    /* JADX WARN: Code duplicated, block: B:155:0x0228 A[LOOP:2: B:154:0x0226->B:155:0x0228, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:158:0x023d  */
    /* JADX WARN: Code duplicated, block: B:160:0x0246  */
    /* JADX WARN: Code duplicated, block: B:161:0x024b  */
    /* JADX WARN: Code duplicated, block: B:165:0x0256  */
    /* JADX WARN: Code duplicated, block: B:168:0x025c  */
    /* JADX WARN: Code duplicated, block: B:170:0x026f  */
    /* JADX WARN: Instruction removed from duplicated block: B:168:0x025c, please report this as an issue */
    public static zzz zza(zzek zzekVar, String str, String str2, zzs zzsVar) throws zzaz {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean zZzp;
        int iZzd;
        int iZzd2;
        int iZza;
        boolean z;
        int iZzd3;
        int i7;
        int i8;
        int i9;
        int iZza2;
        int iZzd4;
        int i10;
        zzej zzejVar = new zzej();
        zzejVar.zzj(zzekVar);
        int iZza3 = zzejVar.zza();
        int iZzd5 = zzejVar.zzd(3);
        if (iZzd5 > 1) {
            throw zzaz.zzc("Unsupported AC-4 DSI version: " + iZzd5);
        }
        int iZzd6 = zzejVar.zzd(7);
        int i11 = true != zzejVar.zzp() ? 44100 : 48000;
        zzejVar.zzn(4);
        int iZzd7 = zzejVar.zzd(9);
        if (iZzd6 > 1) {
            if (iZzd5 == 0) {
                throw zzaz.zzc("Invalid AC-4 DSI version: 0");
            }
            if (zzejVar.zzp()) {
                zzejVar.zzn(16);
                if (zzejVar.zzp()) {
                    zzejVar.zzn(128);
                }
            }
        }
        if (iZzd5 == 1) {
            if (!zzg(zzejVar)) {
                throw zzaz.zzc("Invalid AC-4 DSI bitrate.");
            }
            zzejVar.zzf();
        }
        zzacc zzaccVar = new zzacc(null);
        int i12 = 0;
        while (true) {
            if (i12 < iZzd7) {
                if (iZzd5 == 0) {
                    zZzp = zzejVar.zzp();
                    iZzd = zzejVar.zzd(5);
                    iZzd2 = zzejVar.zzd(5);
                    iZza = 0;
                    z = false;
                    iZzd3 = 0;
                } else {
                    int iZzd8 = zzejVar.zzd(8);
                    iZzd3 = zzejVar.zzd(8);
                    if (iZzd3 == 255) {
                        iZzd3 = zzejVar.zzd(16) + 255;
                    }
                    if (iZzd8 > 2) {
                        zzejVar.zzn(iZzd3 * 8);
                        i12++;
                    } else {
                        iZza = (iZza3 - zzejVar.zza()) / 8;
                        int iZzd9 = zzejVar.zzd(5);
                        z = iZzd9 == 31;
                        iZzd2 = iZzd8;
                        iZzd = iZzd9;
                        zZzp = false;
                    }
                }
                if (zZzp || z || iZzd != 6) {
                    zzaccVar.zzf = zzejVar.zzd(3);
                    if (zzejVar.zzp()) {
                        zzejVar.zzn(5);
                    }
                    zzejVar.zzn(2);
                    if (iZzd5 == 1) {
                        if (iZzd2 == 1) {
                            zzejVar.zzn(2);
                        } else {
                            if (iZzd2 == 2) {
                                iZzd2 = 2;
                                zzejVar.zzn(2);
                            }
                            if (iZzd2 > 0) {
                                if (!zzejVar.zzp() && !zzg(zzejVar)) {
                                    throw zzaz.zzc("Can't parse bitrate DSI.");
                                }
                                if (zzejVar.zzp()) {
                                    zzejVar.zzf();
                                    zzejVar.zzo(zzejVar.zzd(16));
                                    iZzd4 = zzejVar.zzd(5);
                                    for (i10 = 0; i10 < iZzd4; i10++) {
                                        zzejVar.zzn(3);
                                        zzejVar.zzn(8);
                                    }
                                }
                            }
                            i = 3;
                            i5 = 8;
                            zzejVar.zzf();
                            if (iZzd5 == 1) {
                                iZza2 = ((iZza3 - zzejVar.zza()) / 8) - iZza;
                                if (iZzd3 < iZza2) {
                                    throw zzaz.zzc("pres_bytes is smaller than presentation bytes read.");
                                }
                                zzejVar.zzo(iZzd3 - iZza2);
                            }
                            if (zzaccVar.zza) {
                                i3 = -1;
                                if (zzaccVar.zzb == -1) {
                                    throw zzaz.zzc("Can't determine channel mode of presentation " + i12);
                                }
                            } else {
                                i3 = -1;
                            }
                        }
                    }
                    zzejVar.zzn(5);
                    zzejVar.zzn(10);
                    if (iZzd5 == 1) {
                        if (iZzd2 > 0) {
                            zzaccVar.zza = zzejVar.zzp();
                        }
                        if (zzaccVar.zza) {
                            if (iZzd2 != 1) {
                                if (iZzd2 == 2) {
                                    i9 = 2;
                                } else {
                                    i7 = 2;
                                    i9 = iZzd2;
                                }
                                zzejVar.zzn(24);
                                i8 = 1;
                            } else {
                                i9 = 1;
                            }
                            int iZzd10 = zzejVar.zzd(5);
                            if (iZzd10 >= 0 && iZzd10 <= 15) {
                                zzaccVar.zzb = iZzd10;
                            }
                            if (iZzd10 < 11 || iZzd10 > 14) {
                                i7 = 2;
                            } else {
                                zzaccVar.zzd = zzejVar.zzp();
                                i7 = 2;
                                zzaccVar.zze = zzejVar.zzd(2);
                            }
                            zzejVar.zzn(24);
                            i8 = 1;
                        } else {
                            i7 = 2;
                            i8 = 1;
                            i9 = iZzd2;
                        }
                        if (iZzd2 == i8 || iZzd2 == i7) {
                            if (zzejVar.zzp() && zzejVar.zzp()) {
                                zzejVar.zzn(i7);
                            }
                            if (zzejVar.zzp()) {
                                zzejVar.zzm();
                                int i13 = 8;
                                int iZzd11 = zzejVar.zzd(8);
                                int i14 = 0;
                                while (i14 < iZzd11) {
                                    zzejVar.zzn(i13);
                                    i14++;
                                    i13 = 8;
                                }
                            }
                        }
                        iZzd2 = i9;
                    }
                    if (zZzp || z) {
                        i2 = 2;
                        if (iZzd2 == 0) {
                            zzd(zzejVar, zzaccVar);
                            iZzd2 = 0;
                        } else {
                            zze(zzejVar, zzaccVar);
                        }
                    } else {
                        zzejVar.zzm();
                        if (iZzd != 0 && iZzd != 1 && iZzd != 2) {
                            if (iZzd == 3 || iZzd == 4) {
                                if (iZzd2 == 0) {
                                    for (int i15 = 0; i15 < 3; i15++) {
                                        zzd(zzejVar, zzaccVar);
                                    }
                                    iZzd2 = 0;
                                } else {
                                    int i16 = 0;
                                    for (int i17 = 3; i16 < i17; i17 = 3) {
                                        zze(zzejVar, zzaccVar);
                                        i16++;
                                    }
                                }
                            } else if (iZzd != 5) {
                                int iZzd12 = zzejVar.zzd(7);
                                for (int i18 = 0; i18 < iZzd12; i18++) {
                                    zzejVar.zzn(8);
                                }
                            } else if (iZzd2 == 0) {
                                zzd(zzejVar, zzaccVar);
                                iZzd2 = 0;
                            } else {
                                int iZzd13 = zzejVar.zzd(3);
                                for (int i19 = 0; i19 < iZzd13 + 2; i19++) {
                                    zze(zzejVar, zzaccVar);
                                }
                            }
                            i2 = 2;
                        } else if (iZzd2 == 0) {
                            i2 = 2;
                            for (int i20 = 0; i20 < 2; i20++) {
                                zzd(zzejVar, zzaccVar);
                            }
                            iZzd2 = 0;
                        } else {
                            i2 = 2;
                            for (int i21 = 0; i21 < 2; i21++) {
                                zze(zzejVar, zzaccVar);
                            }
                        }
                    }
                    zzejVar.zzm();
                    if (zzejVar.zzp()) {
                        i4 = 7;
                    } else {
                        i4 = 7;
                    }
                    if (iZzd2 > 0) {
                        if (!zzejVar.zzp()) {
                        }
                        if (zzejVar.zzp()) {
                            zzejVar.zzf();
                            zzejVar.zzo(zzejVar.zzd(16));
                            iZzd4 = zzejVar.zzd(5);
                            while (i10 < iZzd4) {
                                zzejVar.zzn(3);
                                zzejVar.zzn(8);
                            }
                        }
                    }
                    i = 3;
                    i5 = 8;
                    zzejVar.zzf();
                    if (iZzd5 == 1) {
                        iZza2 = ((iZza3 - zzejVar.zza()) / 8) - iZza;
                        if (iZzd3 < iZza2) {
                            throw zzaz.zzc("pres_bytes is smaller than presentation bytes read.");
                        }
                        zzejVar.zzo(iZzd3 - iZza2);
                    }
                    if (zzaccVar.zza) {
                        i3 = -1;
                        if (zzaccVar.zzb == -1) {
                            throw zzaz.zzc("Can't determine channel mode of presentation " + i12);
                        }
                    } else {
                        i3 = -1;
                    }
                } else {
                    i4 = 7;
                    i2 = 2;
                }
                int iZzd14 = zzejVar.zzd(i4);
                for (int i22 = 0; i22 < iZzd14; i22++) {
                    zzejVar.zzn(15);
                }
                if (iZzd2 > 0) {
                    if (!zzejVar.zzp()) {
                    }
                    if (zzejVar.zzp()) {
                        zzejVar.zzf();
                        zzejVar.zzo(zzejVar.zzd(16));
                        iZzd4 = zzejVar.zzd(5);
                        while (i10 < iZzd4) {
                            zzejVar.zzn(3);
                            zzejVar.zzn(8);
                        }
                    }
                }
                i = 3;
                i5 = 8;
                zzejVar.zzf();
                if (iZzd5 == 1) {
                    iZza2 = ((iZza3 - zzejVar.zza()) / 8) - iZza;
                    if (iZzd3 < iZza2) {
                        throw zzaz.zzc("pres_bytes is smaller than presentation bytes read.");
                    }
                    zzejVar.zzo(iZzd3 - iZza2);
                }
                if (zzaccVar.zza) {
                    i3 = -1;
                    if (zzaccVar.zzb == -1) {
                        throw zzaz.zzc("Can't determine channel mode of presentation " + i12);
                    }
                } else {
                    i3 = -1;
                }
            } else {
                i = 3;
                i2 = 2;
                i3 = -1;
                i4 = 7;
                i5 = 8;
            }
            if (zzaccVar.zza) {
                int i23 = zzaccVar.zzb;
                boolean z2 = zzaccVar.zzd;
                int i24 = zzaccVar.zze;
                switch (i23) {
                    case 0:
                        i6 = 11;
                        i4 = 1;
                        break;
                    case 1:
                        i4 = i2;
                        i6 = 11;
                        break;
                    case 2:
                        i4 = i;
                        i6 = 11;
                        break;
                    case 3:
                        i4 = 5;
                        i6 = 11;
                        break;
                    case 4:
                        i6 = 11;
                        i4 = 6;
                        break;
                    case 5:
                    case 7:
                    case 9:
                        i6 = 11;
                        break;
                    case 6:
                    case 8:
                    case 10:
                        i4 = i5;
                        i6 = 11;
                        break;
                    case 11:
                        i6 = 11;
                        i4 = 11;
                        break;
                    case 12:
                        i4 = 12;
                        i6 = 11;
                        break;
                    case 13:
                        i4 = 13;
                        i6 = 11;
                        break;
                    case 14:
                        i6 = 11;
                        i4 = 14;
                        break;
                    case 15:
                        i6 = 11;
                        i4 = 24;
                        break;
                    default:
                        i4 = i3;
                        i6 = 11;
                        break;
                }
                if (i23 == i6 || i23 == 12 || i23 == 13 || i23 == 14) {
                    if (!z2) {
                        i4 -= 2;
                    }
                    if (i24 == 0) {
                        i4 -= 4;
                    } else if (i24 == 1) {
                        i4 -= 2;
                    }
                }
            } else {
                i4 = zzaccVar.zzc + 1;
                if (zzaccVar.zzf == 4 && i4 == 17) {
                    i4 = 21;
                }
            }
            if (i4 <= 0) {
                throw zzaz.zzc("Can't determine channel count of presentation.");
            }
            zzx zzxVar = new zzx();
            zzxVar.zzO(str);
            zzxVar.zzad("audio/ac4");
            zzxVar.zzB(i4);
            zzxVar.zzae(i11);
            zzxVar.zzH(zzsVar);
            zzxVar.zzS(str2);
            return zzxVar.zzaj();
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0098  */
    /* JADX WARN: Code duplicated, block: B:49:0x009c  */
    public static zzacd zzb(zzej zzejVar) {
        int i;
        int i2;
        int iZzd;
        int iZzd2 = zzejVar.zzd(16);
        int iZzd3 = zzejVar.zzd(16);
        if (iZzd3 == 65535) {
            iZzd3 = zzejVar.zzd(24);
            i = 7;
        } else {
            i = 4;
        }
        int i3 = iZzd3 + i;
        if (iZzd2 == 44097) {
            i3 += 2;
        }
        int i4 = i3;
        int iZzd4 = zzejVar.zzd(2);
        int i5 = 0;
        if (iZzd4 == 3) {
            int i6 = 0;
            while (true) {
                iZzd = i6 + zzejVar.zzd(2);
                if (!zzejVar.zzp()) {
                    break;
                }
                i6 = (iZzd + 1) << 2;
            }
            iZzd4 = iZzd + 3;
        }
        int i7 = iZzd4;
        int iZzd5 = zzejVar.zzd(10);
        if (zzejVar.zzp() && zzejVar.zzd(3) > 0) {
            zzejVar.zzn(2);
        }
        int i8 = true != zzejVar.zzp() ? 44100 : 48000;
        int iZzd6 = zzejVar.zzd(4);
        if (i8 == 44100 && iZzd6 == 13) {
            i2 = zzb[13];
        } else {
            if (i8 == 48000 && iZzd6 < 14) {
                i5 = zzb[iZzd6];
                int i9 = iZzd5 % 5;
                if (i9 == 1) {
                    if (iZzd6 != 3 || iZzd6 == 8) {
                        i5++;
                    }
                } else if (i9 != 2) {
                    if (i9 != 3) {
                        if (i9 == 4 && (iZzd6 == 3 || iZzd6 == 8 || iZzd6 == 11)) {
                            i5++;
                        }
                    } else if (iZzd6 != 3) {
                        i5++;
                    } else {
                        i5++;
                    }
                } else if (iZzd6 == 8 || iZzd6 == 11) {
                    i5++;
                }
            }
            i2 = i5;
        }
        return new zzacd(i7, 2, i8, i4, i2, null);
    }

    public static void zzc(int i, zzek zzekVar) {
        zzekVar.zzI(7);
        byte[] bArrZzN = zzekVar.zzN();
        bArrZzN[0] = -84;
        bArrZzN[1] = SignedBytes.MAX_POWER_OF_TWO;
        bArrZzN[2] = -1;
        bArrZzN[3] = -1;
        bArrZzN[4] = (byte) ((i >> 16) & 255);
        bArrZzN[5] = (byte) ((i >> 8) & 255);
        bArrZzN[6] = (byte) (i & 255);
    }

    private static void zzd(zzej zzejVar, zzacc zzaccVar) throws zzaz {
        int iZzd = zzejVar.zzd(5);
        zzejVar.zzn(2);
        if (zzejVar.zzp()) {
            zzejVar.zzn(5);
        }
        if (iZzd >= 7 && iZzd <= 10) {
            zzejVar.zzm();
        }
        if (zzejVar.zzp()) {
            int iZzd2 = zzejVar.zzd(3);
            if (zzaccVar.zzb == -1 && iZzd >= 0 && iZzd <= 15 && (iZzd2 == 0 || iZzd2 == 1)) {
                zzaccVar.zzb = iZzd;
            }
            if (zzejVar.zzp()) {
                zzf(zzejVar);
            }
        }
    }

    private static void zze(zzej zzejVar, zzacc zzaccVar) throws zzaz {
        zzejVar.zzn(2);
        boolean zZzp = zzejVar.zzp();
        int iZzd = zzejVar.zzd(8);
        for (int i = 0; i < iZzd; i++) {
            zzejVar.zzn(2);
            if (zzejVar.zzp()) {
                zzejVar.zzn(5);
            }
            if (zZzp) {
                zzejVar.zzn(24);
            } else {
                if (zzejVar.zzp()) {
                    if (!zzejVar.zzp()) {
                        zzejVar.zzn(4);
                    }
                    zzaccVar.zzc = zzejVar.zzd(6) + 1;
                }
                zzejVar.zzn(4);
            }
        }
        if (zzejVar.zzp()) {
            zzejVar.zzn(3);
            if (zzejVar.zzp()) {
                zzf(zzejVar);
            }
        }
    }

    private static void zzf(zzej zzejVar) throws zzaz {
        int iZzd = zzejVar.zzd(6);
        if (iZzd < 2 || iZzd > 42) {
            throw zzaz.zzc(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(iZzd)));
        }
        zzejVar.zzn(iZzd * 8);
    }

    private static boolean zzg(zzej zzejVar) {
        if (zzejVar.zza() < 66) {
            return false;
        }
        zzejVar.zzn(66);
        return true;
    }
}
