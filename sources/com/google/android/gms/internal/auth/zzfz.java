package com.google.android.gms.internal.auth;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
/* JADX INFO: loaded from: classes12.dex */
final class zzfz<T> implements zzgh<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhi.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfw zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfk zzl;
    private final zzgy zzm;
    private final zzel zzn;
    private final zzgb zzo;
    private final zzfr zzp;

    private zzfz(int[] iArr, Object[] objArr, int i, int i2, zzfw zzfwVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzh = z;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzo = zzgbVar;
        this.zzl = zzfkVar;
        this.zzm = zzgyVar;
        this.zzn = zzelVar;
        this.zzg = zzfwVar;
        this.zzp = zzfrVar;
    }

    private static Field zzA(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        long jZzv = zzv(i) & 1048575;
        if (zzG(obj2, i)) {
            Object objZzf = zzhi.zzf(obj, jZzv);
            Object objZzf2 = zzhi.zzf(obj2, jZzv);
            if (objZzf != null && objZzf2 != null) {
                zzhi.zzp(obj, jZzv, zzez.zzg(objZzf, objZzf2));
                zzD(obj, i);
            } else if (objZzf2 != null) {
                zzhi.zzp(obj, jZzv, objZzf2);
                zzD(obj, i);
            }
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int iZzv = zzv(i);
        int i2 = this.zzc[i];
        long j = iZzv & 1048575;
        if (zzJ(obj2, i2, i)) {
            Object objZzf = zzJ(obj, i2, i) ? zzhi.zzf(obj, j) : null;
            Object objZzf2 = zzhi.zzf(obj2, j);
            if (objZzf != null && objZzf2 != null) {
                zzhi.zzp(obj, j, zzez.zzg(objZzf, objZzf2));
                zzE(obj, i2, i);
            } else if (objZzf2 != null) {
                zzhi.zzp(obj, j, objZzf2);
                zzE(obj, i2, i);
            }
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzs = zzs(i);
        long j = 1048575 & iZzs;
        if (j == 1048575) {
            return;
        }
        zzhi.zzn(obj, j, (1 << (iZzs >>> 20)) | zzhi.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzhi.zzn(obj, zzs(i2) & 1048575, i);
    }

    private final boolean zzF(Object obj, Object obj2, int i) {
        return zzG(obj, i) == zzG(obj2, i);
    }

    private final boolean zzG(Object obj, int i) {
        int iZzs = zzs(i);
        long j = iZzs & 1048575;
        if (j != 1048575) {
            return (zzhi.zzc(obj, j) & (1 << (iZzs >>> 20))) != 0;
        }
        int iZzv = zzv(i);
        long j2 = iZzv & 1048575;
        switch (zzu(iZzv)) {
            case 0:
                return Double.doubleToRawLongBits(zzhi.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhi.zzb(obj, j2)) != 0;
            case 2:
                return zzhi.zzd(obj, j2) != 0;
            case 3:
                return zzhi.zzd(obj, j2) != 0;
            case 4:
                return zzhi.zzc(obj, j2) != 0;
            case 5:
                return zzhi.zzd(obj, j2) != 0;
            case 6:
                return zzhi.zzc(obj, j2) != 0;
            case 7:
                return zzhi.zzt(obj, j2);
            case 8:
                Object objZzf = zzhi.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzee) {
                    return !zzee.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhi.zzf(obj, j2) != null;
            case 10:
                return !zzee.zzb.equals(zzhi.zzf(obj, j2));
            case 11:
                return zzhi.zzc(obj, j2) != 0;
            case 12:
                return zzhi.zzc(obj, j2) != 0;
            case 13:
                return zzhi.zzc(obj, j2) != 0;
            case 14:
                return zzhi.zzd(obj, j2) != 0;
            case 15:
                return zzhi.zzc(obj, j2) != 0;
            case 16:
                return zzhi.zzd(obj, j2) != 0;
            case 17:
                return zzhi.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzH(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzG(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzI(Object obj, int i, zzgh zzghVar) {
        return zzghVar.zzi(zzhi.zzf(obj, i & 1048575));
    }

    private final boolean zzJ(Object obj, int i, int i2) {
        return zzhi.zzc(obj, (long) (zzs(i2) & 1048575)) == i;
    }

    static zzgz zzc(Object obj) {
        zzeu zzeuVar = (zzeu) obj;
        zzgz zzgzVar = zzeuVar.zzc;
        if (zzgzVar != zzgz.zza()) {
            return zzgzVar;
        }
        zzgz zzgzVarZzc = zzgz.zzc();
        zzeuVar.zzc = zzgzVarZzc;
        return zzgzVarZzc;
    }

    static zzfz zzj(Class cls, zzft zzftVar, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar) {
        if (zzftVar instanceof zzgg) {
            return zzk((zzgg) zzftVar, zzgbVar, zzfkVar, zzgyVar, zzelVar, zzfrVar);
        }
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x025e  */
    /* JADX WARN: Code duplicated, block: B:124:0x0261  */
    /* JADX WARN: Code duplicated, block: B:127:0x0279  */
    /* JADX WARN: Code duplicated, block: B:128:0x027c  */
    /* JADX WARN: Code duplicated, block: B:162:0x0330  */
    /* JADX WARN: Code duplicated, block: B:177:0x037f  */
    /* JADX WARN: Code duplicated, block: B:180:0x0389  */
    static zzfz zzk(zzgg zzggVar, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int[] iArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        char cCharAt;
        int i7;
        char cCharAt2;
        int i8;
        char cCharAt3;
        int i9;
        char cCharAt4;
        int i10;
        char cCharAt5;
        int i11;
        char cCharAt6;
        int i12;
        char cCharAt7;
        int i13;
        char cCharAt8;
        int i14;
        int i15;
        int i16;
        int[] iArr2;
        int i17;
        int i18;
        int i19;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        Object[] objArr;
        int i20;
        int i21;
        Field fieldZzA;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        int i25;
        Object obj;
        Field fieldZzA2;
        int i26;
        Object obj2;
        Field fieldZzA3;
        int i27;
        char cCharAt10;
        int i28;
        char cCharAt11;
        int i29;
        char cCharAt12;
        int i30;
        char cCharAt13;
        boolean z = zzggVar.zzc() == 2;
        String strZzd = zzggVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i31 = 1;
            while (true) {
                i = i31 + 1;
                if (strZzd.charAt(i31) < 55296) {
                    break;
                }
                i31 = i;
            }
        } else {
            i = 1;
        }
        int i32 = i + 1;
        int iCharAt4 = strZzd.charAt(i);
        if (iCharAt4 >= 55296) {
            int i33 = iCharAt4 & 8191;
            int i34 = 13;
            while (true) {
                i30 = i32 + 1;
                cCharAt13 = strZzd.charAt(i32);
                if (cCharAt13 < 55296) {
                    break;
                }
                i33 |= (cCharAt13 & 8191) << i34;
                i34 += 13;
                i32 = i30;
            }
            iCharAt4 = i33 | (cCharAt13 << i34);
            i32 = i30;
        }
        if (iCharAt4 == 0) {
            iCharAt = 0;
            i5 = 0;
            iCharAt2 = 0;
            i4 = 0;
            iCharAt3 = 0;
            i2 = 0;
            iArr = zza;
            i3 = 0;
        } else {
            int i35 = i32 + 1;
            int iCharAt5 = strZzd.charAt(i32);
            if (iCharAt5 >= 55296) {
                int i36 = iCharAt5 & 8191;
                int i37 = 13;
                while (true) {
                    i13 = i35 + 1;
                    cCharAt8 = strZzd.charAt(i35);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt8 & 8191) << i37;
                    i37 += 13;
                    i35 = i13;
                }
                iCharAt5 = i36 | (cCharAt8 << i37);
                i35 = i13;
            }
            int i38 = i35 + 1;
            int iCharAt6 = strZzd.charAt(i35);
            if (iCharAt6 >= 55296) {
                int i39 = iCharAt6 & 8191;
                int i40 = 13;
                while (true) {
                    i12 = i38 + 1;
                    cCharAt7 = strZzd.charAt(i38);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt7 & 8191) << i40;
                    i40 += 13;
                    i38 = i12;
                }
                iCharAt6 = i39 | (cCharAt7 << i40);
                i38 = i12;
            }
            int i41 = i38 + 1;
            iCharAt = strZzd.charAt(i38);
            if (iCharAt >= 55296) {
                int i42 = iCharAt & 8191;
                int i43 = 13;
                while (true) {
                    i11 = i41 + 1;
                    cCharAt6 = strZzd.charAt(i41);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt6 & 8191) << i43;
                    i43 += 13;
                    i41 = i11;
                }
                iCharAt = i42 | (cCharAt6 << i43);
                i41 = i11;
            }
            int i44 = i41 + 1;
            int iCharAt7 = strZzd.charAt(i41);
            if (iCharAt7 >= 55296) {
                int i45 = iCharAt7 & 8191;
                int i46 = 13;
                while (true) {
                    i10 = i44 + 1;
                    cCharAt5 = strZzd.charAt(i44);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt5 & 8191) << i46;
                    i46 += 13;
                    i44 = i10;
                }
                iCharAt7 = i45 | (cCharAt5 << i46);
                i44 = i10;
            }
            int i47 = i44 + 1;
            iCharAt2 = strZzd.charAt(i44);
            if (iCharAt2 >= 55296) {
                int i48 = iCharAt2 & 8191;
                int i49 = 13;
                while (true) {
                    i9 = i47 + 1;
                    cCharAt4 = strZzd.charAt(i47);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt4 & 8191) << i49;
                    i49 += 13;
                    i47 = i9;
                }
                iCharAt2 = i48 | (cCharAt4 << i49);
                i47 = i9;
            }
            int i50 = i47 + 1;
            int iCharAt8 = strZzd.charAt(i47);
            if (iCharAt8 >= 55296) {
                int i51 = iCharAt8 & 8191;
                int i52 = 13;
                while (true) {
                    i8 = i50 + 1;
                    cCharAt3 = strZzd.charAt(i50);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt3 & 8191) << i52;
                    i52 += 13;
                    i50 = i8;
                }
                iCharAt8 = i51 | (cCharAt3 << i52);
                i50 = i8;
            }
            int i53 = i50 + 1;
            int iCharAt9 = strZzd.charAt(i50);
            if (iCharAt9 >= 55296) {
                int i54 = iCharAt9 & 8191;
                int i55 = 13;
                while (true) {
                    i7 = i53 + 1;
                    cCharAt2 = strZzd.charAt(i53);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt2 & 8191) << i55;
                    i55 += 13;
                    i53 = i7;
                }
                iCharAt9 = i54 | (cCharAt2 << i55);
                i53 = i7;
            }
            int i56 = i53 + 1;
            iCharAt3 = strZzd.charAt(i53);
            if (iCharAt3 >= 55296) {
                int i57 = iCharAt3 & 8191;
                int i58 = 13;
                while (true) {
                    i6 = i56 + 1;
                    cCharAt = strZzd.charAt(i56);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i57 |= (cCharAt & 8191) << i58;
                    i58 += 13;
                    i56 = i6;
                }
                iCharAt3 = i57 | (cCharAt << i58);
                i56 = i6;
            }
            iArr = new int[iCharAt3 + iCharAt8 + iCharAt9];
            i2 = iCharAt5 + iCharAt5 + iCharAt6;
            i3 = iCharAt5;
            i32 = i56;
            int i59 = iCharAt8;
            i4 = iCharAt7;
            i5 = i59;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzggVar.zze();
        Class<?> cls = zzggVar.zza().getClass();
        int[] iArr3 = new int[iCharAt2 * 3];
        Object[] objArr2 = new Object[iCharAt2 + iCharAt2];
        int i60 = iCharAt3 + i5;
        int i61 = iCharAt3;
        int i62 = i60;
        int i63 = 0;
        int i64 = 0;
        while (i32 < length) {
            int i65 = i32 + 1;
            int iCharAt10 = strZzd.charAt(i32);
            if (iCharAt10 >= c) {
                int i66 = iCharAt10 & 8191;
                int i67 = i65;
                int i68 = 13;
                while (true) {
                    i29 = i67 + 1;
                    cCharAt12 = strZzd.charAt(i67);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i66 |= (cCharAt12 & 8191) << i68;
                    i68 += 13;
                    i67 = i29;
                }
                iCharAt10 = i66 | (cCharAt12 << i68);
                i14 = i29;
            } else {
                i14 = i65;
            }
            int i69 = i14 + 1;
            int iCharAt11 = strZzd.charAt(i14);
            if (iCharAt11 >= c) {
                int i70 = iCharAt11 & 8191;
                int i71 = i69;
                int i72 = 13;
                while (true) {
                    i28 = i71 + 1;
                    cCharAt11 = strZzd.charAt(i71);
                    i15 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i70 |= (cCharAt11 & 8191) << i72;
                    i72 += 13;
                    i71 = i28;
                    length = i15;
                }
                iCharAt11 = i70 | (cCharAt11 << i72);
                i16 = i28;
            } else {
                i15 = length;
                i16 = i69;
            }
            int i73 = iCharAt11 & 255;
            int i74 = iCharAt3;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i64] = i63;
                i64++;
            }
            if (i73 >= 51) {
                int i75 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i76 = iCharAt12 & 8191;
                    int i77 = i75;
                    int i78 = 13;
                    while (true) {
                        i27 = i77 + 1;
                        cCharAt10 = strZzd.charAt(i77);
                        i18 = i4;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i76 |= (cCharAt10 & 8191) << i78;
                        i78 += 13;
                        i77 = i27;
                        i4 = i18;
                    }
                    iCharAt12 = i76 | (cCharAt10 << i78);
                    i23 = i27;
                } else {
                    i18 = i4;
                    i23 = i75;
                }
                int i79 = i73 - 51;
                int i80 = i23;
                if (i79 == 9 || i79 == 17) {
                    int i81 = i63 / 3;
                    i24 = i2 + 1;
                    objArr2[i81 + i81 + 1] = objArrZze[i2];
                } else {
                    if (i79 == 12 && !z) {
                        int i82 = i63 / 3;
                        i24 = i2 + 1;
                        objArr2[i82 + i82 + 1] = objArrZze[i2];
                    }
                    i25 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i25];
                    if (obj instanceof Field) {
                        fieldZzA2 = (Field) obj;
                    } else {
                        fieldZzA2 = zzA(cls, (String) obj);
                        objArrZze[i25] = fieldZzA2;
                    }
                    iArr2 = iArr3;
                    i17 = iCharAt;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzA2);
                    i26 = i25 + 1;
                    obj2 = objArrZze[i26];
                    if (obj2 instanceof Field) {
                        fieldZzA3 = (Field) obj2;
                    } else {
                        fieldZzA3 = zzA(cls, (String) obj2);
                        objArrZze[i26] = fieldZzA3;
                    }
                    strZzd = strZzd;
                    objArr = objArr2;
                    i19 = i2;
                    i20 = i80;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzA3);
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i21 = 0;
                }
                i2 = i24;
                i25 = iCharAt12 + iCharAt12;
                obj = objArrZze[i25];
                if (obj instanceof Field) {
                    fieldZzA2 = (Field) obj;
                } else {
                    fieldZzA2 = zzA(cls, (String) obj);
                    objArrZze[i25] = fieldZzA2;
                }
                iArr2 = iArr3;
                i17 = iCharAt;
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzA2);
                i26 = i25 + 1;
                obj2 = objArrZze[i26];
                if (obj2 instanceof Field) {
                    fieldZzA3 = (Field) obj2;
                } else {
                    fieldZzA3 = zzA(cls, (String) obj2);
                    objArrZze[i26] = fieldZzA3;
                }
                strZzd = strZzd;
                objArr = objArr2;
                i19 = i2;
                i20 = i80;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzA3);
                iObjectFieldOffset = iObjectFieldOffset4;
                i21 = 0;
            } else {
                iArr2 = iArr3;
                i17 = iCharAt;
                i18 = i4;
                int i83 = i2 + 1;
                Field fieldZzA4 = zzA(cls, (String) objArrZze[i2]);
                if (i73 == 9 || i73 == 17) {
                    int i84 = i63 / 3;
                    objArr2[i84 + i84 + 1] = fieldZzA4.getType();
                } else {
                    if (i73 == 27 || i73 == 49) {
                        int i85 = i63 / 3;
                        i22 = i2 + 2;
                        objArr2[i85 + i85 + 1] = objArrZze[i83];
                    } else if (i73 == 12 || i73 == 30 || i73 == 44) {
                        if (!z) {
                            int i86 = i63 / 3;
                            i22 = i2 + 2;
                            objArr2[i86 + i86 + 1] = objArrZze[i83];
                        }
                    } else if (i73 == 50) {
                        int i87 = i61 + 1;
                        iArr[i61] = i63;
                        int i88 = i63 / 3;
                        int i89 = i88 + i88;
                        int i90 = i2 + 2;
                        objArr2[i89] = objArrZze[i83];
                        if ((iCharAt11 & 2048) != 0) {
                            i83 = i2 + 3;
                            objArr2[i89 + 1] = objArrZze[i90];
                            i61 = i87;
                        } else {
                            i61 = i87;
                            i19 = i90;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzA4);
                        iObjectFieldOffset2 = 1048575;
                        objArr = objArr2;
                        if ((iCharAt11 & 4096) == 4096 || i73 > 17) {
                            i20 = i16;
                            i21 = 0;
                        } else {
                            int i91 = i16 + 1;
                            int iCharAt13 = strZzd.charAt(i16);
                            if (iCharAt13 >= 55296) {
                                int i92 = iCharAt13 & 8191;
                                int i93 = 13;
                                while (true) {
                                    i20 = i91 + 1;
                                    cCharAt9 = strZzd.charAt(i91);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i92 |= (cCharAt9 & 8191) << i93;
                                    i93 += 13;
                                    i91 = i20;
                                }
                                iCharAt13 = i92 | (cCharAt9 << i93);
                            } else {
                                i20 = i91;
                            }
                            int i94 = i3 + i3 + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i94];
                            if (obj3 instanceof Field) {
                                fieldZzA = (Field) obj3;
                            } else {
                                fieldZzA = zzA(cls, (String) obj3);
                                objArrZze[i94] = fieldZzA;
                            }
                            i21 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzA);
                        }
                        if (i73 >= 18 && i73 <= 49) {
                            iArr[i62] = iObjectFieldOffset;
                            i62++;
                        }
                    }
                    i19 = i22;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzA4);
                    iObjectFieldOffset2 = 1048575;
                    objArr = objArr2;
                    if ((iCharAt11 & 4096) == 4096) {
                        i20 = i16;
                        i21 = 0;
                    } else {
                        i20 = i16;
                        i21 = 0;
                    }
                    if (i73 >= 18) {
                        iArr[i62] = iObjectFieldOffset;
                        i62++;
                    }
                }
                i19 = i83;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzA4);
                iObjectFieldOffset2 = 1048575;
                objArr = objArr2;
                if ((iCharAt11 & 4096) == 4096) {
                    i20 = i16;
                    i21 = 0;
                } else {
                    i20 = i16;
                    i21 = 0;
                }
                if (i73 >= 18) {
                    iArr[i62] = iObjectFieldOffset;
                    i62++;
                }
            }
            int i95 = i63 + 1;
            iArr2[i63] = iCharAt10;
            int i96 = i63 + 2;
            iArr2[i95] = ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | (i73 << 20) | iObjectFieldOffset;
            i63 += 3;
            iArr2[i96] = (i21 << 20) | iObjectFieldOffset2;
            i2 = i19;
            iCharAt = i17;
            iCharAt3 = i74;
            i32 = i20;
            length = i15;
            objArr2 = objArr;
            strZzd = strZzd;
            iArr3 = iArr2;
            i4 = i18;
            c = 55296;
        }
        return new zzfz(iArr3, objArr2, iCharAt, i4, zzggVar.zza(), z, false, iArr, iCharAt3, i60, zzgbVar, zzfkVar, zzgyVar, zzelVar, zzfrVar, null);
    }

    private static int zzl(Object obj, long j) {
        return ((Integer) zzhi.zzf(obj, j)).intValue();
    }

    private final int zzm(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzds zzdsVar) throws IOException {
        Unsafe unsafe = zzb;
        Object objZzz = zzz(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzfq) object).zze()) {
            zzfq zzfqVarZzb = zzfq.zza().zzb();
            zzfr.zza(zzfqVarZzb, object);
            unsafe.putObject(obj, j, zzfqVarZzb);
        }
        throw null;
    }

    private final int zzn(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzds zzdsVar) throws IOException {
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(zzdt.zzn(bArr, i))));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(zzdt.zzb(bArr, i))));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iZzm = zzdt.zzm(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, Long.valueOf(zzdsVar.zzb));
                unsafe.putInt(obj, j2, i4);
                return iZzm;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iZzj = zzdt.zzj(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzdsVar.zza));
                unsafe.putInt(obj, j2, i4);
                return iZzj;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(zzdt.zzn(bArr, i)));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(zzdt.zzb(bArr, i)));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                if (i5 != 0) {
                    return i;
                }
                int iZzm2 = zzdt.zzm(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, Boolean.valueOf(zzdsVar.zzb != 0));
                unsafe.putInt(obj, j2, i4);
                return iZzm2;
            case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                if (i5 != 2) {
                    return i;
                }
                int iZzj2 = zzdt.zzj(bArr, i, zzdsVar);
                int i9 = zzdsVar.zza;
                if (i9 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !zzhm.zzd(bArr, iZzj2, iZzj2 + i9)) {
                        throw zzfa.zzb();
                    }
                    unsafe.putObject(obj, j, new String(bArr, iZzj2, i9, zzez.zzb));
                    iZzj2 += i9;
                }
                unsafe.putInt(obj, j2, i4);
                return iZzj2;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iZzd = zzdt.zzd(zzy(i8), bArr, i, i2, zzdsVar);
                Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object == null) {
                    unsafe.putObject(obj, j, zzdsVar.zzc);
                } else {
                    unsafe.putObject(obj, j, zzez.zzg(object, zzdsVar.zzc));
                }
                unsafe.putInt(obj, j2, i4);
                return iZzd;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zzdt.zza(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, zzdsVar.zzc);
                unsafe.putInt(obj, j2, i4);
                return iZza;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iZzj3 = zzdt.zzj(bArr, i, zzdsVar);
                int i10 = zzdsVar.zza;
                zzex zzexVarZzx = zzx(i8);
                if (zzexVarZzx == null || zzexVarZzx.zza()) {
                    unsafe.putObject(obj, j, Integer.valueOf(i10));
                    unsafe.putInt(obj, j2, i4);
                } else {
                    zzc(obj).zzf(i3, Long.valueOf(i10));
                }
                return iZzj3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iZzj4 = zzdt.zzj(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzei.zzb(zzdsVar.zza)));
                unsafe.putInt(obj, j2, i4);
                return iZzj4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iZzm3 = zzdt.zzm(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, Long.valueOf(zzei.zzc(zzdsVar.zzb)));
                unsafe.putInt(obj, j2, i4);
                return iZzm3;
            case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                if (i5 != 3) {
                    return i;
                }
                int iZzc = zzdt.zzc(zzy(i8), bArr, i, i2, (i3 & (-8)) | 4, zzdsVar);
                Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object2 == null) {
                    unsafe.putObject(obj, j, zzdsVar.zzc);
                } else {
                    unsafe.putObject(obj, j, zzez.zzg(object2, zzdsVar.zzc));
                }
                unsafe.putInt(obj, j2, i4);
                return iZzc;
            default:
                return i;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0080. Please report as an issue. */
    private final int zzo(Object obj, byte[] bArr, int i, int i2, zzds zzdsVar) throws IOException {
        int i3;
        int iZzk;
        int i4;
        int i5;
        int i6;
        Unsafe unsafe;
        int i7;
        int i8;
        int i9;
        int i10;
        int iZzm;
        int iZzd;
        int i11;
        int i12;
        int i13;
        zzfz<T> zzfzVar = this;
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i14 = i2;
        zzdsVar = zzdsVar;
        Unsafe unsafe2 = zzb;
        int i15 = 1048575;
        int i16 = -1;
        int iZzi = i;
        int i17 = -1;
        int i18 = 1048575;
        int i19 = 0;
        int i20 = 0;
        while (iZzi < i14) {
            int i21 = iZzi + 1;
            byte b = bArr2[iZzi];
            if (b < 0) {
                iZzk = zzdt.zzk(b, bArr2, i21, zzdsVar);
                i3 = zzdsVar.zza;
            } else {
                i3 = b;
                iZzk = i21;
            }
            int i22 = i3 >>> 3;
            int i23 = i3 & 7;
            int iZzr = i22 > i17 ? zzfzVar.zzr(i22, i19 / 3) : zzfzVar.zzq(i22);
            if (iZzr == i16) {
                i4 = iZzk;
                i5 = i22;
                i6 = i16;
                unsafe = unsafe2;
                i7 = 0;
            } else {
                int[] iArr = zzfzVar.zzc;
                int i24 = iArr[iZzr + 1];
                int iZzu = zzu(i24);
                long j = i24 & i15;
                if (iZzu <= 17) {
                    int i25 = iArr[iZzr + 2];
                    int i26 = 1 << (i25 >>> 20);
                    i8 = 1048575;
                    int i27 = i25 & 1048575;
                    if (i27 != i18) {
                        if (i18 != 1048575) {
                            unsafe2.putInt(obj2, i18, i20);
                        }
                        if (i27 != 1048575) {
                            i20 = unsafe2.getInt(obj2, i27);
                        }
                        i18 = i27;
                    }
                    switch (iZzu) {
                        case 0:
                            i9 = iZzr;
                            i10 = iZzk;
                            i5 = i22;
                            if (i23 != 1) {
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                zzhi.zzl(obj2, j, Double.longBitsToDouble(zzdt.zzn(bArr2, i10)));
                                iZzi = i10 + 8;
                                i20 |= i26;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 1:
                            zzdsVar = zzdsVar;
                            i9 = iZzr;
                            i10 = iZzk;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 5) {
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                zzhi.zzm(obj2, j, Float.intBitsToFloat(zzdt.zzb(bArr2, i10)));
                                iZzi = i10 + 4;
                                i20 |= i26;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 2:
                        case 3:
                            zzdsVar = zzdsVar;
                            i9 = iZzr;
                            i10 = iZzk;
                            i5 = i22;
                            if (i23 != 0) {
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzm = zzdt.zzm(bArr2, i10, zzdsVar);
                                unsafe2.putLong(obj, j, zzdsVar.zzb);
                                i20 |= i26;
                                iZzi = iZzm;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 4:
                        case 11:
                            zzdsVar = zzdsVar;
                            i9 = iZzr;
                            i10 = iZzk;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 0) {
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzi = zzdt.zzj(bArr2, i10, zzdsVar);
                                unsafe2.putInt(obj2, j, zzdsVar.zza);
                                i20 |= i26;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 5:
                        case 14:
                            i9 = iZzr;
                            i5 = i22;
                            if (i23 != 1) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                i10 = iZzk;
                                unsafe2.putLong(obj, j, zzdt.zzn(bArr2, iZzk));
                                iZzi = i10 + 8;
                                i20 |= i26;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 6:
                        case 13:
                            zzdsVar = zzdsVar;
                            i9 = iZzr;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 5) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                unsafe2.putInt(obj2, j, zzdt.zzb(bArr2, iZzk));
                                iZzi = iZzk + 4;
                                i20 |= i26;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 7:
                            zzdsVar = zzdsVar;
                            i9 = iZzr;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 0) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzi = zzdt.zzm(bArr2, iZzk, zzdsVar);
                                zzhi.zzk(obj2, j, zzdsVar.zzb != 0);
                                i20 |= i26;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 8:
                            zzdsVar = zzdsVar;
                            i9 = iZzr;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 2) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzi = (536870912 & i24) == 0 ? zzdt.zzg(bArr2, iZzk, zzdsVar) : zzdt.zzh(bArr2, iZzk, zzdsVar);
                                unsafe2.putObject(obj2, j, zzdsVar.zzc);
                                i20 |= i26;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 9:
                            zzdsVar = zzdsVar;
                            i9 = iZzr;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 2) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzd = zzdt.zzd(zzfzVar.zzy(i9), bArr2, iZzk, i14, zzdsVar);
                                Object object = unsafe2.getObject(obj2, j);
                                if (object == null) {
                                    unsafe2.putObject(obj2, j, zzdsVar.zzc);
                                } else {
                                    unsafe2.putObject(obj2, j, zzez.zzg(object, zzdsVar.zzc));
                                }
                                i20 |= i26;
                                iZzi = iZzd;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 10:
                            zzdsVar = zzdsVar;
                            i9 = iZzr;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 2) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzd = zzdt.zza(bArr2, iZzk, zzdsVar);
                                unsafe2.putObject(obj2, j, zzdsVar.zzc);
                                i20 |= i26;
                                iZzi = iZzd;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 12:
                            zzdsVar = zzdsVar;
                            i9 = iZzr;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 0) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzd = zzdt.zzj(bArr2, iZzk, zzdsVar);
                                unsafe2.putInt(obj2, j, zzdsVar.zza);
                                i20 |= i26;
                                iZzi = iZzd;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 15:
                            zzdsVar = zzdsVar;
                            i9 = iZzr;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 0) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzd = zzdt.zzj(bArr2, iZzk, zzdsVar);
                                unsafe2.putInt(obj2, j, zzei.zzb(zzdsVar.zza));
                                i20 |= i26;
                                iZzi = iZzd;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 16:
                            if (i23 != 0) {
                                i5 = i22;
                                i9 = iZzr;
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                zzdsVar = zzdsVar;
                                iZzm = zzdt.zzm(bArr2, iZzk, zzdsVar);
                                i9 = iZzr;
                                i5 = i22;
                                unsafe2.putLong(obj, j, zzei.zzc(zzdsVar.zzb));
                                i20 |= i26;
                                iZzi = iZzm;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        default:
                            i5 = i22;
                            i9 = iZzr;
                            i10 = iZzk;
                            i4 = i10;
                            unsafe = unsafe2;
                            i7 = i9;
                            i6 = -1;
                            break;
                    }
                } else {
                    zzdsVar = zzdsVar;
                    i9 = iZzr;
                    int i28 = iZzk;
                    i8 = 1048575;
                    i5 = i22;
                    if (iZzu == 27) {
                        if (i23 == 2) {
                            zzey zzeyVarZzd = (zzey) unsafe2.getObject(obj2, j);
                            if (!zzeyVarZzd.zzc()) {
                                int size = zzeyVarZzd.size();
                                zzeyVarZzd = zzeyVarZzd.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj2, j, zzeyVarZzd);
                            }
                            iZzi = zzdt.zze(zzfzVar.zzy(i9), i3, bArr, i28, i2, zzeyVarZzd, zzdsVar);
                            i20 = i20;
                            i19 = i9;
                            i17 = i5;
                            i15 = i8;
                            i16 = -1;
                        } else {
                            i11 = i28;
                            i12 = i20;
                            i13 = i18;
                            unsafe = unsafe2;
                            i7 = i9;
                            i6 = -1;
                        }
                    } else if (iZzu <= 49) {
                        i12 = i20;
                        i13 = i18;
                        i6 = -1;
                        unsafe = unsafe2;
                        i7 = i9;
                        iZzi = zzp(obj, bArr, i28, i2, i3, i5, i23, i9, i24, iZzu, j, zzdsVar);
                        if (iZzi != i28) {
                            obj2 = obj;
                            bArr2 = bArr;
                            i14 = i2;
                            zzdsVar = zzdsVar;
                            i18 = i13;
                            i16 = i6;
                            i17 = i5;
                            i20 = i12;
                            i19 = i7;
                            unsafe2 = unsafe;
                            i15 = 1048575;
                            zzfzVar = this;
                        } else {
                            i4 = iZzi;
                            i18 = i13;
                            i20 = i12;
                        }
                    } else {
                        i11 = i28;
                        i12 = i20;
                        i13 = i18;
                        unsafe = unsafe2;
                        i7 = i9;
                        i6 = -1;
                        if (iZzu != 50) {
                            iZzi = zzn(obj, bArr, i11, i2, i3, i5, i23, i24, iZzu, j, i7, zzdsVar);
                            if (iZzi != i11) {
                                obj2 = obj;
                                bArr2 = bArr;
                                i14 = i2;
                                zzdsVar = zzdsVar;
                                i18 = i13;
                                i16 = i6;
                                i17 = i5;
                                i20 = i12;
                                i19 = i7;
                                unsafe2 = unsafe;
                                i15 = 1048575;
                                zzfzVar = this;
                            } else {
                                i4 = iZzi;
                                i18 = i13;
                                i20 = i12;
                            }
                        } else if (i23 == 2) {
                            iZzi = zzm(obj, bArr, i11, i2, i7, j, zzdsVar);
                            if (iZzi != i11) {
                                obj2 = obj;
                                bArr2 = bArr;
                                i14 = i2;
                                zzdsVar = zzdsVar;
                                i18 = i13;
                                i16 = i6;
                                i17 = i5;
                                i20 = i12;
                                i19 = i7;
                                unsafe2 = unsafe;
                                i15 = 1048575;
                                zzfzVar = this;
                            } else {
                                i4 = iZzi;
                                i18 = i13;
                                i20 = i12;
                            }
                        }
                    }
                    i4 = i11;
                    i18 = i13;
                    i20 = i12;
                }
            }
            iZzi = zzdt.zzi(i3, bArr, i4, i2, zzc(obj), zzdsVar);
            zzfzVar = this;
            obj2 = obj;
            bArr2 = bArr;
            i14 = i2;
            zzdsVar = zzdsVar;
            i16 = i6;
            i17 = i5;
            i19 = i7;
            unsafe2 = unsafe;
            i15 = 1048575;
        }
        int i29 = i20;
        int i30 = i18;
        Unsafe unsafe3 = unsafe2;
        if (i30 != i15) {
            unsafe3.putInt(obj, i30, i29);
        }
        if (iZzi == i2) {
            return iZzi;
        }
        throw zzfa.zzd();
    }

    private final int zzp(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzds zzdsVar) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        int iZzj;
        int iZzj2 = i;
        Unsafe unsafe = zzb;
        zzey zzeyVarZzd = (zzey) unsafe.getObject(obj, j2);
        if (!zzeyVarZzd.zzc()) {
            int size = zzeyVarZzd.size();
            zzeyVarZzd = zzeyVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j2, zzeyVarZzd);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzej zzejVar = (zzej) zzeyVarZzd;
                    int iZzj3 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i12 = zzdsVar.zza + iZzj3;
                    while (iZzj3 < i12) {
                        zzejVar.zze(Double.longBitsToDouble(zzdt.zzn(bArr, iZzj3)));
                        iZzj3 += 8;
                    }
                    if (iZzj3 == i12) {
                        return iZzj3;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 1) {
                    zzej zzejVar2 = (zzej) zzeyVarZzd;
                    zzejVar2.zze(Double.longBitsToDouble(zzdt.zzn(bArr, i)));
                    while (true) {
                        i8 = iZzj2 + 8;
                        if (i8 < i2) {
                            iZzj2 = zzdt.zzj(bArr, i8, zzdsVar);
                            if (i3 == zzdsVar.zza) {
                                zzejVar2.zze(Double.longBitsToDouble(zzdt.zzn(bArr, iZzj2)));
                            }
                        }
                    }
                    return i8;
                }
                return iZzj2;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzeq zzeqVar = (zzeq) zzeyVarZzd;
                    int iZzj4 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i13 = zzdsVar.zza + iZzj4;
                    while (iZzj4 < i13) {
                        zzeqVar.zze(Float.intBitsToFloat(zzdt.zzb(bArr, iZzj4)));
                        iZzj4 += 4;
                    }
                    if (iZzj4 == i13) {
                        return iZzj4;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 5) {
                    zzeq zzeqVar2 = (zzeq) zzeyVarZzd;
                    zzeqVar2.zze(Float.intBitsToFloat(zzdt.zzb(bArr, i)));
                    while (true) {
                        i9 = iZzj2 + 4;
                        if (i9 < i2) {
                            iZzj2 = zzdt.zzj(bArr, i9, zzdsVar);
                            if (i3 == zzdsVar.zza) {
                                zzeqVar2.zze(Float.intBitsToFloat(zzdt.zzb(bArr, iZzj2)));
                            }
                        }
                    }
                    return i9;
                }
                return iZzj2;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzfl zzflVar = (zzfl) zzeyVarZzd;
                    int iZzj5 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i14 = zzdsVar.zza + iZzj5;
                    while (iZzj5 < i14) {
                        iZzj5 = zzdt.zzm(bArr, iZzj5, zzdsVar);
                        zzflVar.zze(zzdsVar.zzb);
                    }
                    if (iZzj5 == i14) {
                        return iZzj5;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 0) {
                    zzfl zzflVar2 = (zzfl) zzeyVarZzd;
                    int iZzm = zzdt.zzm(bArr, iZzj2, zzdsVar);
                    zzflVar2.zze(zzdsVar.zzb);
                    while (iZzm < i2) {
                        int iZzj6 = zzdt.zzj(bArr, iZzm, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return iZzm;
                        }
                        iZzm = zzdt.zzm(bArr, iZzj6, zzdsVar);
                        zzflVar2.zze(zzdsVar.zzb);
                    }
                    return iZzm;
                }
                return iZzj2;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzdt.zzf(bArr, iZzj2, zzeyVarZzd, zzdsVar);
                }
                if (i5 == 0) {
                    return zzdt.zzl(i3, bArr, i, i2, zzeyVarZzd, zzdsVar);
                }
                return iZzj2;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzfl zzflVar3 = (zzfl) zzeyVarZzd;
                    int iZzj7 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i15 = zzdsVar.zza + iZzj7;
                    while (iZzj7 < i15) {
                        zzflVar3.zze(zzdt.zzn(bArr, iZzj7));
                        iZzj7 += 8;
                    }
                    if (iZzj7 == i15) {
                        return iZzj7;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 1) {
                    zzfl zzflVar4 = (zzfl) zzeyVarZzd;
                    zzflVar4.zze(zzdt.zzn(bArr, i));
                    while (true) {
                        i10 = iZzj2 + 8;
                        if (i10 < i2) {
                            iZzj2 = zzdt.zzj(bArr, i10, zzdsVar);
                            if (i3 == zzdsVar.zza) {
                                zzflVar4.zze(zzdt.zzn(bArr, iZzj2));
                            }
                        }
                    }
                    return i10;
                }
                return iZzj2;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzev zzevVar = (zzev) zzeyVarZzd;
                    int iZzj8 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i16 = zzdsVar.zza + iZzj8;
                    while (iZzj8 < i16) {
                        zzevVar.zze(zzdt.zzb(bArr, iZzj8));
                        iZzj8 += 4;
                    }
                    if (iZzj8 == i16) {
                        return iZzj8;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 5) {
                    zzev zzevVar2 = (zzev) zzeyVarZzd;
                    zzevVar2.zze(zzdt.zzb(bArr, i));
                    while (true) {
                        i11 = iZzj2 + 4;
                        if (i11 < i2) {
                            iZzj2 = zzdt.zzj(bArr, i11, zzdsVar);
                            if (i3 == zzdsVar.zza) {
                                zzevVar2.zze(zzdt.zzb(bArr, iZzj2));
                            }
                        }
                    }
                    return i11;
                }
                return iZzj2;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzdu zzduVar = (zzdu) zzeyVarZzd;
                    iZzj = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i17 = zzdsVar.zza + iZzj;
                    while (iZzj < i17) {
                        iZzj = zzdt.zzm(bArr, iZzj, zzdsVar);
                        zzduVar.zze(zzdsVar.zzb != 0);
                    }
                    if (iZzj != i17) {
                        throw zzfa.zzf();
                    }
                    return iZzj;
                }
                if (i5 == 0) {
                    zzdu zzduVar2 = (zzdu) zzeyVarZzd;
                    int iZzm2 = zzdt.zzm(bArr, iZzj2, zzdsVar);
                    zzduVar2.zze(zzdsVar.zzb != 0);
                    while (iZzm2 < i2) {
                        int iZzj9 = zzdt.zzj(bArr, iZzm2, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return iZzm2;
                        }
                        iZzm2 = zzdt.zzm(bArr, iZzj9, zzdsVar);
                        zzduVar2.zze(zzdsVar.zzb != 0);
                    }
                    return iZzm2;
                }
                return iZzj2;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iZzj10 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                        int i18 = zzdsVar.zza;
                        if (i18 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i18 == 0) {
                            zzeyVarZzd.add("");
                        } else {
                            zzeyVarZzd.add(new String(bArr, iZzj10, i18, zzez.zzb));
                            iZzj10 += i18;
                        }
                        while (iZzj10 < i2) {
                            int iZzj11 = zzdt.zzj(bArr, iZzj10, zzdsVar);
                            if (i3 != zzdsVar.zza) {
                                return iZzj10;
                            }
                            iZzj10 = zzdt.zzj(bArr, iZzj11, zzdsVar);
                            int i19 = zzdsVar.zza;
                            if (i19 < 0) {
                                throw zzfa.zzc();
                            }
                            if (i19 == 0) {
                                zzeyVarZzd.add("");
                            } else {
                                zzeyVarZzd.add(new String(bArr, iZzj10, i19, zzez.zzb));
                                iZzj10 += i19;
                            }
                        }
                        return iZzj10;
                    }
                    int iZzj12 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i20 = zzdsVar.zza;
                    if (i20 < 0) {
                        throw zzfa.zzc();
                    }
                    if (i20 == 0) {
                        zzeyVarZzd.add("");
                    } else {
                        int i21 = iZzj12 + i20;
                        if (!zzhm.zzd(bArr, iZzj12, i21)) {
                            throw zzfa.zzb();
                        }
                        zzeyVarZzd.add(new String(bArr, iZzj12, i20, zzez.zzb));
                        iZzj12 = i21;
                    }
                    while (iZzj12 < i2) {
                        int iZzj13 = zzdt.zzj(bArr, iZzj12, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return iZzj12;
                        }
                        iZzj12 = zzdt.zzj(bArr, iZzj13, zzdsVar);
                        int i22 = zzdsVar.zza;
                        if (i22 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i22 == 0) {
                            zzeyVarZzd.add("");
                        } else {
                            int i23 = iZzj12 + i22;
                            if (!zzhm.zzd(bArr, iZzj12, i23)) {
                                throw zzfa.zzb();
                            }
                            zzeyVarZzd.add(new String(bArr, iZzj12, i22, zzez.zzb));
                            iZzj12 = i23;
                        }
                    }
                    return iZzj12;
                }
                return iZzj2;
            case 27:
                if (i5 == 2) {
                    return zzdt.zze(zzy(i6), i3, bArr, i, i2, zzeyVarZzd, zzdsVar);
                }
                return iZzj2;
            case 28:
                if (i5 == 2) {
                    int iZzj14 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i24 = zzdsVar.zza;
                    if (i24 < 0) {
                        throw zzfa.zzc();
                    }
                    if (i24 > bArr.length - iZzj14) {
                        throw zzfa.zzf();
                    }
                    if (i24 == 0) {
                        zzeyVarZzd.add(zzee.zzb);
                    } else {
                        zzeyVarZzd.add(zzee.zzk(bArr, iZzj14, i24));
                        iZzj14 += i24;
                    }
                    while (iZzj14 < i2) {
                        int iZzj15 = zzdt.zzj(bArr, iZzj14, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return iZzj14;
                        }
                        iZzj14 = zzdt.zzj(bArr, iZzj15, zzdsVar);
                        int i25 = zzdsVar.zza;
                        if (i25 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i25 > bArr.length - iZzj14) {
                            throw zzfa.zzf();
                        }
                        if (i25 == 0) {
                            zzeyVarZzd.add(zzee.zzb);
                        } else {
                            zzeyVarZzd.add(zzee.zzk(bArr, iZzj14, i25));
                            iZzj14 += i25;
                        }
                    }
                    return iZzj14;
                }
                return iZzj2;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZzj = zzdt.zzl(i3, bArr, i, i2, zzeyVarZzd, zzdsVar);
                    }
                    return iZzj2;
                }
                iZzj = zzdt.zzf(bArr, iZzj2, zzeyVarZzd, zzdsVar);
                zzeu zzeuVar = (zzeu) obj;
                zzgz zzgzVar = zzeuVar.zzc;
                if (zzgzVar == zzgz.zza()) {
                    zzgzVar = null;
                }
                Object objZzd = zzgj.zzd(i4, zzeyVarZzd, zzx(i6), zzgzVar, this.zzm);
                if (objZzd != null) {
                    zzeuVar.zzc = (zzgz) objZzd;
                    return iZzj;
                }
                return iZzj;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzev zzevVar3 = (zzev) zzeyVarZzd;
                    int iZzj16 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i26 = zzdsVar.zza + iZzj16;
                    while (iZzj16 < i26) {
                        iZzj16 = zzdt.zzj(bArr, iZzj16, zzdsVar);
                        zzevVar3.zze(zzei.zzb(zzdsVar.zza));
                    }
                    if (iZzj16 == i26) {
                        return iZzj16;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 0) {
                    zzev zzevVar4 = (zzev) zzeyVarZzd;
                    int iZzj17 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    zzevVar4.zze(zzei.zzb(zzdsVar.zza));
                    while (iZzj17 < i2) {
                        int iZzj18 = zzdt.zzj(bArr, iZzj17, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return iZzj17;
                        }
                        iZzj17 = zzdt.zzj(bArr, iZzj18, zzdsVar);
                        zzevVar4.zze(zzei.zzb(zzdsVar.zza));
                    }
                    return iZzj17;
                }
                return iZzj2;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzfl zzflVar5 = (zzfl) zzeyVarZzd;
                    int iZzj19 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i27 = zzdsVar.zza + iZzj19;
                    while (iZzj19 < i27) {
                        iZzj19 = zzdt.zzm(bArr, iZzj19, zzdsVar);
                        zzflVar5.zze(zzei.zzc(zzdsVar.zzb));
                    }
                    if (iZzj19 == i27) {
                        return iZzj19;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 0) {
                    zzfl zzflVar6 = (zzfl) zzeyVarZzd;
                    int iZzm3 = zzdt.zzm(bArr, iZzj2, zzdsVar);
                    zzflVar6.zze(zzei.zzc(zzdsVar.zzb));
                    while (iZzm3 < i2) {
                        int iZzj20 = zzdt.zzj(bArr, iZzm3, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return iZzm3;
                        }
                        iZzm3 = zzdt.zzm(bArr, iZzj20, zzdsVar);
                        zzflVar6.zze(zzei.zzc(zzdsVar.zzb));
                    }
                    return iZzm3;
                }
                return iZzj2;
            default:
                if (i5 == 3) {
                    zzgh zzghVarZzy = zzy(i6);
                    int i28 = (i3 & (-8)) | 4;
                    int iZzc = zzdt.zzc(zzghVarZzy, bArr, i, i2, i28, zzdsVar);
                    zzeyVarZzd.add(zzdsVar.zzc);
                    while (iZzc < i2) {
                        int iZzj21 = zzdt.zzj(bArr, iZzc, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return iZzc;
                        }
                        iZzc = zzdt.zzc(zzghVarZzy, bArr, iZzj21, i2, i28, zzdsVar);
                        zzeyVarZzd.add(zzdsVar.zzc);
                    }
                    return iZzc;
                }
                return iZzj2;
        }
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzt(i, 0);
    }

    private final int zzr(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzt(i, i2);
    }

    private final int zzs(int i) {
        return this.zzc[i + 2];
    }

    private final int zzt(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzu(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzv(int i) {
        return this.zzc[i + 1];
    }

    private static long zzw(Object obj, long j) {
        return ((Long) zzhi.zzf(obj, j)).longValue();
    }

    private final zzex zzx(int i) {
        int i2 = i / 3;
        return (zzex) this.zzd[i2 + i2 + 1];
    }

    private final zzgh zzy(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgh zzghVar = (zzgh) this.zzd[i3];
        if (zzghVar != null) {
            return zzghVar;
        }
        zzgh zzghVarZzb = zzge.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzghVarZzb;
        return zzghVarZzb;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final int zza(Object obj) {
        int i;
        int iZzc;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzv = zzv(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzv;
            int iHashCode = 37;
            switch (zzu(iZzv)) {
                case 0:
                    i = i2 * 53;
                    iZzc = zzez.zzc(Double.doubleToLongBits(zzhi.zza(obj, j)));
                    i2 = i + iZzc;
                    break;
                case 1:
                    i = i2 * 53;
                    iZzc = Float.floatToIntBits(zzhi.zzb(obj, j));
                    i2 = i + iZzc;
                    break;
                case 2:
                    i = i2 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 3:
                    i = i2 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 4:
                    i = i2 * 53;
                    iZzc = zzhi.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 5:
                    i = i2 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 6:
                    i = i2 * 53;
                    iZzc = zzhi.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 7:
                    i = i2 * 53;
                    iZzc = zzez.zza(zzhi.zzt(obj, j));
                    i2 = i + iZzc;
                    break;
                case 8:
                    i = i2 * 53;
                    iZzc = ((String) zzhi.zzf(obj, j)).hashCode();
                    i2 = i + iZzc;
                    break;
                case 9:
                    Object objZzf = zzhi.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZzc = zzhi.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 11:
                    i = i2 * 53;
                    iZzc = zzhi.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 12:
                    i = i2 * 53;
                    iZzc = zzhi.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 13:
                    i = i2 * 53;
                    iZzc = zzhi.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 14:
                    i = i2 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 15:
                    i = i2 * 53;
                    iZzc = zzhi.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 16:
                    i = i2 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 17:
                    Object objZzf2 = zzhi.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iZzc = zzhi.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 50:
                    i = i2 * 53;
                    iZzc = zzhi.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 51:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(Double.doubleToLongBits(((Double) zzhi.zzf(obj, j)).doubleValue()));
                        i2 = i + iZzc;
                    }
                    break;
                case 52:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = Float.floatToIntBits(((Float) zzhi.zzf(obj, j)).floatValue());
                        i2 = i + iZzc;
                    }
                    break;
                case 53:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(zzw(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 54:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(zzw(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 55:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzl(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 56:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(zzw(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 57:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzl(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zza(((Boolean) zzhi.zzf(obj, j)).booleanValue());
                        i2 = i + iZzc;
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = ((String) zzhi.zzf(obj, j)).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 60:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzhi.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 61:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzhi.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 62:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzl(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 63:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzl(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 64:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzl(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 65:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(zzw(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 66:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzl(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 67:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(zzw(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzhi.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
            }
        }
        return (i2 * 53) + this.zzm.zza(obj).hashCode();
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0337 A[PHI: r0 r28
  0x0337: PHI (r0v66 int) = (r0v61 int), (r0v64 int), (r0v68 int) binds: [B:127:0x0398, B:122:0x0372, B:114:0x0335] A[DONT_GENERATE, DONT_INLINE]
  0x0337: PHI (r28v9 sun.misc.Unsafe) = (r28v7 sun.misc.Unsafe), (r28v7 sun.misc.Unsafe), (r28v10 sun.misc.Unsafe) binds: [B:127:0x0398, B:122:0x0372, B:114:0x0335] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:116:0x034f A[PHI: r0 r28
  0x034f: PHI (r0v65 int) = (r0v61 int), (r0v64 int), (r0v68 int) binds: [B:127:0x0398, B:122:0x0372, B:114:0x0335] A[DONT_GENERATE, DONT_INLINE]
  0x034f: PHI (r28v8 sun.misc.Unsafe) = (r28v7 sun.misc.Unsafe), (r28v7 sun.misc.Unsafe), (r28v10 sun.misc.Unsafe) binds: [B:127:0x0398, B:122:0x0372, B:114:0x0335] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x008e. Please report as an issue. */
    final int zzb(Object obj, byte[] bArr, int i, int i2, int i3, zzds zzdsVar) throws IOException {
        Unsafe unsafe;
        Object obj2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int iZzg;
        int i15;
        this = this;
        obj = obj;
        bArr = bArr;
        i2 = i2;
        int i16 = i3;
        zzdsVar = zzdsVar;
        Unsafe unsafe2 = zzb;
        int iZzi = i;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = -1;
        int i21 = 1048575;
        while (true) {
            if (iZzi < i2) {
                int i22 = iZzi + 1;
                byte b = bArr[iZzi];
                if (b < 0) {
                    int iZzk = zzdt.zzk(b, bArr, i22, zzdsVar);
                    i4 = zzdsVar.zza;
                    i22 = iZzk;
                } else {
                    i4 = b;
                }
                int i23 = i4 >>> 3;
                int i24 = i4 & 7;
                int iZzr = i23 > i20 ? this.zzr(i23, i18 / 3) : this.zzq(i23);
                if (iZzr == -1) {
                    i5 = i23;
                    i6 = i22;
                    i7 = i4;
                    i8 = i19;
                    unsafe = unsafe2;
                    i3 = i16;
                    i9 = 0;
                } else {
                    int[] iArr = this.zzc;
                    int i25 = iArr[iZzr + 1];
                    int iZzu = zzu(i25);
                    i5 = i23;
                    int i26 = i22;
                    long j = i25 & 1048575;
                    if (iZzu <= 17) {
                        int i27 = iArr[iZzr + 2];
                        int i28 = 1 << (i27 >>> 20);
                        int i29 = i27 & 1048575;
                        if (i29 != i21) {
                            if (i21 != 1048575) {
                                unsafe2.putInt(obj, i21, i19);
                            }
                            i19 = unsafe2.getInt(obj, i29);
                            i10 = i29;
                        } else {
                            i10 = i21;
                        }
                        int i30 = i19;
                        switch (iZzu) {
                            case 0:
                                i11 = iZzr;
                                i12 = i26;
                                if (i24 == 1) {
                                    zzhi.zzl(obj, j, Double.longBitsToDouble(zzdt.zzn(bArr, i12)));
                                    iZzi = i12 + 8;
                                    i19 = i30 | i28;
                                    i18 = i11;
                                    i17 = i4;
                                    i20 = i5;
                                    i21 = i10;
                                    i16 = i3;
                                } else {
                                    i8 = i30;
                                    unsafe = unsafe2;
                                    i9 = i11;
                                    i6 = i12;
                                    i7 = i4;
                                    i21 = i10;
                                }
                                break;
                            case 1:
                                i11 = iZzr;
                                i12 = i26;
                                if (i24 == 5) {
                                    zzhi.zzm(obj, j, Float.intBitsToFloat(zzdt.zzb(bArr, i12)));
                                    iZzi = i12 + 4;
                                    i19 = i30 | i28;
                                    i18 = i11;
                                    i17 = i4;
                                    i20 = i5;
                                    i21 = i10;
                                    i16 = i3;
                                } else {
                                    i8 = i30;
                                    unsafe = unsafe2;
                                    i9 = i11;
                                    i6 = i12;
                                    i7 = i4;
                                    i21 = i10;
                                }
                                break;
                            case 2:
                            case 3:
                                i11 = iZzr;
                                i12 = i26;
                                if (i24 == 0) {
                                    int iZzm = zzdt.zzm(bArr, i12, zzdsVar);
                                    unsafe2.putLong(obj, j, zzdsVar.zzb);
                                    i19 = i30 | i28;
                                    iZzi = iZzm;
                                    i18 = i11;
                                    i17 = i4;
                                    i20 = i5;
                                    i21 = i10;
                                    i16 = i3;
                                } else {
                                    i8 = i30;
                                    unsafe = unsafe2;
                                    i9 = i11;
                                    i6 = i12;
                                    i7 = i4;
                                    i21 = i10;
                                }
                                break;
                            case 4:
                            case 11:
                                i11 = iZzr;
                                i12 = i26;
                                if (i24 == 0) {
                                    iZzi = zzdt.zzj(bArr, i12, zzdsVar);
                                    unsafe2.putInt(obj, j, zzdsVar.zza);
                                    i19 = i30 | i28;
                                    i18 = i11;
                                    i17 = i4;
                                    i20 = i5;
                                    i21 = i10;
                                    i16 = i3;
                                } else {
                                    i8 = i30;
                                    unsafe = unsafe2;
                                    i9 = i11;
                                    i6 = i12;
                                    i7 = i4;
                                    i21 = i10;
                                }
                                break;
                            case 5:
                            case 14:
                                i11 = iZzr;
                                i13 = i4;
                                i14 = i26;
                                if (i24 == 1) {
                                    i4 = i13;
                                    i12 = i14;
                                    unsafe2.putLong(obj, j, zzdt.zzn(bArr, i14));
                                    iZzi = i12 + 8;
                                    i19 = i30 | i28;
                                    i18 = i11;
                                    i17 = i4;
                                    i20 = i5;
                                    i21 = i10;
                                    i16 = i3;
                                } else {
                                    i12 = i14;
                                    i4 = i13;
                                    i8 = i30;
                                    unsafe = unsafe2;
                                    i9 = i11;
                                    i6 = i12;
                                    i7 = i4;
                                    i21 = i10;
                                }
                                break;
                            case 6:
                            case 13:
                                i11 = iZzr;
                                i13 = i4;
                                i14 = i26;
                                if (i24 == 5) {
                                    unsafe2.putInt(obj, j, zzdt.zzb(bArr, i14));
                                    iZzi = i14 + 4;
                                    i19 = i30 | i28;
                                    i17 = i13;
                                    i18 = i11;
                                    i20 = i5;
                                    i21 = i10;
                                    i16 = i3;
                                } else {
                                    i12 = i14;
                                    i4 = i13;
                                    i8 = i30;
                                    unsafe = unsafe2;
                                    i9 = i11;
                                    i6 = i12;
                                    i7 = i4;
                                    i21 = i10;
                                }
                                break;
                            case 7:
                                i11 = iZzr;
                                i13 = i4;
                                i14 = i26;
                                if (i24 == 0) {
                                    iZzi = zzdt.zzm(bArr, i14, zzdsVar);
                                    zzhi.zzk(obj, j, zzdsVar.zzb != 0);
                                    i19 = i30 | i28;
                                    i17 = i13;
                                    i18 = i11;
                                    i20 = i5;
                                    i21 = i10;
                                    i16 = i3;
                                } else {
                                    i12 = i14;
                                    i4 = i13;
                                    i8 = i30;
                                    unsafe = unsafe2;
                                    i9 = i11;
                                    i6 = i12;
                                    i7 = i4;
                                    i21 = i10;
                                }
                                break;
                            case 8:
                                i11 = iZzr;
                                i13 = i4;
                                i14 = i26;
                                if (i24 == 2) {
                                    iZzg = (536870912 & i25) == 0 ? zzdt.zzg(bArr, i14, zzdsVar) : zzdt.zzh(bArr, i14, zzdsVar);
                                    unsafe2.putObject(obj, j, zzdsVar.zzc);
                                    i19 = i30 | i28;
                                    iZzi = iZzg;
                                    i17 = i13;
                                    i18 = i11;
                                    i20 = i5;
                                    i21 = i10;
                                    i16 = i3;
                                } else {
                                    i12 = i14;
                                    i4 = i13;
                                    i8 = i30;
                                    unsafe = unsafe2;
                                    i9 = i11;
                                    i6 = i12;
                                    i7 = i4;
                                    i21 = i10;
                                }
                                break;
                            case 9:
                                i11 = iZzr;
                                i13 = i4;
                                i14 = i26;
                                if (i24 == 2) {
                                    iZzg = zzdt.zzd(this.zzy(i11), bArr, i14, i2, zzdsVar);
                                    if ((i30 & i28) == 0) {
                                        unsafe2.putObject(obj, j, zzdsVar.zzc);
                                    } else {
                                        unsafe2.putObject(obj, j, zzez.zzg(unsafe2.getObject(obj, j), zzdsVar.zzc));
                                    }
                                    i19 = i30 | i28;
                                    iZzi = iZzg;
                                    i17 = i13;
                                    i18 = i11;
                                    i20 = i5;
                                    i21 = i10;
                                    i16 = i3;
                                } else {
                                    i12 = i14;
                                    i4 = i13;
                                    i8 = i30;
                                    unsafe = unsafe2;
                                    i9 = i11;
                                    i6 = i12;
                                    i7 = i4;
                                    i21 = i10;
                                }
                                break;
                            case 10:
                                i11 = iZzr;
                                i13 = i4;
                                i14 = i26;
                                if (i24 == 2) {
                                    iZzg = zzdt.zza(bArr, i14, zzdsVar);
                                    unsafe2.putObject(obj, j, zzdsVar.zzc);
                                    i19 = i30 | i28;
                                    iZzi = iZzg;
                                    i17 = i13;
                                    i18 = i11;
                                    i20 = i5;
                                    i21 = i10;
                                    i16 = i3;
                                } else {
                                    i12 = i14;
                                    i4 = i13;
                                    i8 = i30;
                                    unsafe = unsafe2;
                                    i9 = i11;
                                    i6 = i12;
                                    i7 = i4;
                                    i21 = i10;
                                }
                                break;
                            case 12:
                                i11 = iZzr;
                                i13 = i4;
                                i14 = i26;
                                if (i24 == 0) {
                                    iZzg = zzdt.zzj(bArr, i14, zzdsVar);
                                    int i31 = zzdsVar.zza;
                                    zzex zzexVarZzx = this.zzx(i11);
                                    if (zzexVarZzx == null || zzexVarZzx.zza()) {
                                        unsafe2.putInt(obj, j, i31);
                                        i19 = i30 | i28;
                                        iZzi = iZzg;
                                        i17 = i13;
                                    } else {
                                        zzc(obj).zzf(i13, Long.valueOf(i31));
                                        iZzi = iZzg;
                                        i17 = i13;
                                        i19 = i30;
                                    }
                                    i18 = i11;
                                    i20 = i5;
                                    i21 = i10;
                                    i16 = i3;
                                } else {
                                    i12 = i14;
                                    i4 = i13;
                                    i8 = i30;
                                    unsafe = unsafe2;
                                    i9 = i11;
                                    i6 = i12;
                                    i7 = i4;
                                    i21 = i10;
                                }
                                break;
                            case 15:
                                i11 = iZzr;
                                i13 = i4;
                                i14 = i26;
                                if (i24 == 0) {
                                    iZzi = zzdt.zzj(bArr, i14, zzdsVar);
                                    unsafe2.putInt(obj, j, zzei.zzb(zzdsVar.zza));
                                    i19 = i30 | i28;
                                    i17 = i13;
                                    i18 = i11;
                                    i20 = i5;
                                    i21 = i10;
                                    i16 = i3;
                                } else {
                                    i12 = i14;
                                    i4 = i13;
                                    i8 = i30;
                                    unsafe = unsafe2;
                                    i9 = i11;
                                    i6 = i12;
                                    i7 = i4;
                                    i21 = i10;
                                }
                                break;
                            case 16:
                                if (i24 == 0) {
                                    int iZzm2 = zzdt.zzm(bArr, i26, zzdsVar);
                                    i11 = iZzr;
                                    unsafe2.putLong(obj, j, zzei.zzc(zzdsVar.zzb));
                                    i19 = i30 | i28;
                                    iZzi = iZzm2;
                                    i17 = i4;
                                    i18 = i11;
                                    i20 = i5;
                                    i21 = i10;
                                    i16 = i3;
                                } else {
                                    i11 = iZzr;
                                    i12 = i26;
                                    i8 = i30;
                                    unsafe = unsafe2;
                                    i9 = i11;
                                    i6 = i12;
                                    i7 = i4;
                                    i21 = i10;
                                }
                                break;
                            default:
                                i11 = iZzr;
                                i12 = i26;
                                if (i24 == 3) {
                                    iZzi = zzdt.zzc(this.zzy(i11), bArr, i12, i2, (i5 << 3) | 4, zzdsVar);
                                    if ((i30 & i28) == 0) {
                                        unsafe2.putObject(obj, j, zzdsVar.zzc);
                                    } else {
                                        unsafe2.putObject(obj, j, zzez.zzg(unsafe2.getObject(obj, j), zzdsVar.zzc));
                                    }
                                    i19 = i30 | i28;
                                    i18 = i11;
                                    i17 = i4;
                                    i20 = i5;
                                    i21 = i10;
                                    i16 = i3;
                                } else {
                                    i8 = i30;
                                    unsafe = unsafe2;
                                    i9 = i11;
                                    i6 = i12;
                                    i7 = i4;
                                    i21 = i10;
                                }
                                break;
                        }
                    } else {
                        i4 = i4;
                        int i32 = iZzr;
                        if (iZzu != 27) {
                            i9 = i32;
                            i8 = i19;
                            i10 = i21;
                            if (iZzu <= 49) {
                                unsafe = unsafe2;
                                iZzi = zzp(obj, bArr, i26, i2, i4, i5, i24, i9, i25, iZzu, j, zzdsVar);
                                if (iZzi != i26) {
                                    i16 = i3;
                                    i17 = i4;
                                    i20 = i5;
                                    i18 = i9;
                                    i19 = i8;
                                    i21 = i10;
                                } else {
                                    i6 = iZzi;
                                    i7 = i4;
                                    i21 = i10;
                                }
                                unsafe2 = unsafe;
                            } else {
                                unsafe = unsafe2;
                                i15 = i26;
                                if (iZzu == 50) {
                                    if (i24 == 2) {
                                        iZzi = zzm(obj, bArr, i15, i2, i9, j, zzdsVar);
                                        if (iZzi != i15) {
                                            i16 = i3;
                                            i17 = i4;
                                            i20 = i5;
                                            i18 = i9;
                                            i19 = i8;
                                            i21 = i10;
                                        } else {
                                            i6 = iZzi;
                                        }
                                        unsafe2 = unsafe;
                                    }
                                    i7 = i4;
                                    i21 = i10;
                                } else {
                                    iZzi = zzn(obj, bArr, i15, i2, i4, i5, i24, i25, iZzu, j, i9, zzdsVar);
                                    if (iZzi != i15) {
                                        i16 = i3;
                                        i17 = i4;
                                        i20 = i5;
                                        i18 = i9;
                                        i19 = i8;
                                        i21 = i10;
                                    } else {
                                        i6 = iZzi;
                                        i7 = i4;
                                        i21 = i10;
                                    }
                                    unsafe2 = unsafe;
                                }
                            }
                        } else if (i24 == 2) {
                            zzey zzeyVarZzd = (zzey) unsafe2.getObject(obj, j);
                            if (!zzeyVarZzd.zzc()) {
                                int size = zzeyVarZzd.size();
                                zzeyVarZzd = zzeyVarZzd.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj, j, zzeyVarZzd);
                            }
                            i17 = i4;
                            iZzi = zzdt.zze(this.zzy(i32), i17, bArr, i26, i2, zzeyVarZzd, zzdsVar);
                            i2 = i2;
                            i16 = i3;
                            i20 = i5;
                            i18 = i32;
                            i19 = i19;
                            i21 = i21;
                        } else {
                            i9 = i32;
                            i8 = i19;
                            i10 = i21;
                            unsafe = unsafe2;
                            i15 = i26;
                        }
                        i6 = i15;
                        i7 = i4;
                        i21 = i10;
                    }
                }
                if (i7 != i3 || i3 == 0) {
                    iZzi = zzdt.zzi(i7, bArr, i6, i2, zzc(obj), zzdsVar);
                    i16 = i3;
                    i17 = i7;
                    i20 = i5;
                    i18 = i9;
                    i19 = i8;
                    unsafe2 = unsafe;
                } else {
                    iZzi = i6;
                    i17 = i7;
                    i19 = i8;
                }
            } else {
                unsafe = unsafe2;
                i3 = i16;
            }
        }
        if (i21 != 1048575) {
            long j2 = i21;
            obj2 = obj;
            unsafe.putInt(obj2, j2, i19);
        } else {
            obj2 = obj;
        }
        for (int i33 = this.zzj; i33 < this.zzk; i33++) {
            int i34 = this.zzi[i33];
            int i35 = this.zzc[i34];
            Object objZzf = zzhi.zzf(obj2, zzv(i34) & 1048575);
            if (objZzf != null && zzx(i34) != null) {
                throw null;
            }
        }
        if (i3 == 0) {
            if (iZzi != i2) {
                throw zzfa.zzd();
            }
        } else if (iZzi > i2 || i17 != i3) {
            throw zzfa.zzd();
        }
        return iZzi;
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final Object zzd() {
        return ((zzeu) this.zzg).zzi(4, null, null);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zze(Object obj) {
        int i;
        int i2 = this.zzj;
        while (true) {
            i = this.zzk;
            if (i2 >= i) {
                break;
            }
            long jZzv = zzv(this.zzi[i2]) & 1048575;
            Object objZzf = zzhi.zzf(obj, jZzv);
            if (objZzf != null) {
                ((zzfq) objZzf).zzc();
                zzhi.zzp(obj, jZzv, objZzf);
            }
            i2++;
        }
        int length = this.zzi.length;
        while (i < length) {
            this.zzl.zza(obj, this.zzi[i]);
            i++;
        }
        this.zzm.zze(obj);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzg(Object obj, byte[] bArr, int i, int i2, zzds zzdsVar) throws IOException {
        if (this.zzh) {
            zzo(obj, bArr, i, i2, zzdsVar);
        } else {
            zzb(obj, bArr, i, i2, 0, zzdsVar);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final boolean zzh(Object obj, Object obj2) {
        boolean zZzh;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzv = zzv(i);
            long j = iZzv & 1048575;
            switch (zzu(iZzv)) {
                case 0:
                    if (!zzF(obj, obj2, i) || Double.doubleToLongBits(zzhi.zza(obj, j)) != Double.doubleToLongBits(zzhi.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzF(obj, obj2, i) || Float.floatToIntBits(zzhi.zzb(obj, j)) != Float.floatToIntBits(zzhi.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzF(obj, obj2, i) || zzhi.zzd(obj, j) != zzhi.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzF(obj, obj2, i) || zzhi.zzd(obj, j) != zzhi.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzF(obj, obj2, i) || zzhi.zzd(obj, j) != zzhi.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzF(obj, obj2, i) || zzhi.zzt(obj, j) != zzhi.zzt(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzF(obj, obj2, i) || !zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzF(obj, obj2, i) || !zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzF(obj, obj2, i) || !zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzF(obj, obj2, i) || zzhi.zzd(obj, j) != zzhi.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzF(obj, obj2, i) || zzhi.zzd(obj, j) != zzhi.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzF(obj, obj2, i) || !zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZzh = zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j));
                    break;
                case 50:
                    zZzh = zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    long jZzs = zzs(i) & 1048575;
                    if (zzhi.zzc(obj, jZzs) != zzhi.zzc(obj2, jZzs) || !zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzh) {
                return false;
            }
        }
        return this.zzm.zza(obj).equals(this.zzm.zza(obj2));
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009b  */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c0 A[LOOP:1: B:45:0x00af->B:50:0x00c0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:62:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00dd A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.auth.zzgh
    public final boolean zzi(Object obj) {
        int i;
        int i2;
        List list;
        zzgh zzghVarZzy;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.zzj) {
            int i7 = this.zzi[i6];
            int i8 = this.zzc[i7];
            int iZzv = zzv(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = zzb.getInt(obj, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                i = i4;
                i2 = i5;
            }
            if ((268435456 & iZzv) != 0 && !zzH(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzu = zzu(iZzv);
            if (iZzu == 9 || iZzu == 17) {
                if (zzH(obj, i7, i, i2, i11) && !zzI(obj, iZzv, zzy(i7))) {
                    return false;
                }
            } else if (iZzu == 27) {
                list = (List) zzhi.zzf(obj, iZzv & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzghVarZzy = zzy(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzghVarZzy.zzi(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzu == 60 || iZzu == 68) {
                if (zzJ(obj, i8, i7) && !zzI(obj, iZzv, zzy(i7))) {
                    return false;
                }
            } else if (iZzu == 49) {
                list = (List) zzhi.zzf(obj, iZzv & 1048575);
                if (list.isEmpty()) {
                    zzghVarZzy = zzy(i7);
                    while (i3 < list.size()) {
                        if (!zzghVarZzy.zzi(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzu == 50 && !((zzfq) zzhi.zzf(obj, iZzv & 1048575)).isEmpty()) {
                throw null;
            }
            i6++;
            i4 = i;
            i5 = i2;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzf(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzv = zzv(i);
            long j = 1048575 & iZzv;
            int i2 = this.zzc[i];
            switch (zzu(iZzv)) {
                case 0:
                    if (zzG(obj2, i)) {
                        zzhi.zzl(obj, j, zzhi.zza(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 1:
                    if (zzG(obj2, i)) {
                        zzhi.zzm(obj, j, zzhi.zzb(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 2:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 3:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 4:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 5:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 6:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 7:
                    if (zzG(obj2, i)) {
                        zzhi.zzk(obj, j, zzhi.zzt(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 8:
                    if (zzG(obj2, i)) {
                        zzhi.zzp(obj, j, zzhi.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzG(obj2, i)) {
                        zzhi.zzp(obj, j, zzhi.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 11:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 12:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 13:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 14:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 15:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 16:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 17:
                    zzB(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzl.zzb(obj, obj2, j);
                    break;
                case 50:
                    zzgj.zzi(this.zzp, obj, obj2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    if (zzJ(obj2, i2, i)) {
                        zzhi.zzp(obj, j, zzhi.zzf(obj2, j));
                        zzE(obj, i2, i);
                    }
                    break;
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzJ(obj2, i2, i)) {
                        zzhi.zzp(obj, j, zzhi.zzf(obj2, j));
                        zzE(obj, i2, i);
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zzgj.zzf(this.zzm, obj, obj2);
    }
}
