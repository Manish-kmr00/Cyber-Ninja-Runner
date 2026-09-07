package com.google.android.gms.internal.play_billing;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes13.dex */
final class zzip<T> implements zzix<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzjq.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzim zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzjj zzl;
    private final zzgx zzm;

    private zzip(int[] iArr, Object[] objArr, int i, int i2, zzim zzimVar, boolean z, int[] iArr2, int i3, int i4, zzir zzirVar, zzhz zzhzVar, zzjj zzjjVar, zzgx zzgxVar, zzih zzihVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzgxVar != null && (zzimVar instanceof zzhh)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzjjVar;
        this.zzm = zzgxVar;
        this.zzg = zzimVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzix zzixVarZzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZze = zzixVarZzv.zze();
                    zzixVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzixVarZzv.zze();
                zzixVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzixVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzix zzixVarZzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZze = zzixVarZzv.zze();
                    zzixVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzixVarZzv.zze();
                zzixVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzixVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzp = zzp(i);
        long j = 1048575 & iZzp;
        if (j == 1048575) {
            return;
        }
        zzjq.zzq(obj, j, (1 << (iZzp >>> 20)) | zzjq.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzjq.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int iZzp = zzp(i);
        long j = iZzp & 1048575;
        if (j != 1048575) {
            return (zzjq.zzc(obj, j) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i);
        long j2 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzjq.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzjq.zzb(obj, j2)) != 0;
            case 2:
                return zzjq.zzd(obj, j2) != 0;
            case 3:
                return zzjq.zzd(obj, j2) != 0;
            case 4:
                return zzjq.zzc(obj, j2) != 0;
            case 5:
                return zzjq.zzd(obj, j2) != 0;
            case 6:
                return zzjq.zzc(obj, j2) != 0;
            case 7:
                return zzjq.zzw(obj, j2);
            case 8:
                Object objZzf = zzjq.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzgk) {
                    return !zzgk.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzjq.zzf(obj, j2) != null;
            case 10:
                return !zzgk.zzb.equals(zzjq.zzf(obj, j2));
            case 11:
                return zzjq.zzc(obj, j2) != 0;
            case 12:
                return zzjq.zzc(obj, j2) != 0;
            case 13:
                return zzjq.zzc(obj, j2) != 0;
            case 14:
                return zzjq.zzd(obj, j2) != 0;
            case 15:
                return zzjq.zzc(obj, j2) != 0;
            case 16:
                return zzjq.zzd(obj, j2) != 0;
            case 17:
                return zzjq.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzix zzixVar) {
        return zzixVar.zzk(zzjq.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzhk) {
            return ((zzhk) obj).zzA();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzjq.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzjq.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzjw zzjwVar) throws IOException {
        if (obj instanceof String) {
            zzjwVar.zzG(i, (String) obj);
        } else {
            zzjwVar.zzd(i, (zzgk) obj);
        }
    }

    static zzjk zzd(Object obj) {
        zzhk zzhkVar = (zzhk) obj;
        zzjk zzjkVar = zzhkVar.zzc;
        if (zzjkVar != zzjk.zzc()) {
            return zzjkVar;
        }
        zzjk zzjkVarZzf = zzjk.zzf();
        zzhkVar.zzc = zzjkVarZzf;
        return zzjkVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:126:0x0268  */
    /* JADX WARN: Code duplicated, block: B:129:0x027f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0282  */
    /* JADX WARN: Code duplicated, block: B:169:0x0345  */
    /* JADX WARN: Code duplicated, block: B:183:0x0391  */
    /* JADX WARN: Code duplicated, block: B:186:0x039a  */
    static zzip zzl(Class cls, zzij zzijVar, zzir zzirVar, zzhz zzhzVar, zzjj zzjjVar, zzgx zzgxVar, zzih zzihVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int i17;
        int i18;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i19;
        int i20;
        int i21;
        Field fieldZzz;
        int i22;
        char cCharAt9;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        Object obj;
        Field fieldZzz2;
        int i28;
        Object obj2;
        Field fieldZzz3;
        int i29;
        char cCharAt10;
        int i30;
        char cCharAt11;
        int i31;
        char cCharAt12;
        int i32;
        char cCharAt13;
        if (!(zzijVar instanceof zziw)) {
            throw null;
        }
        zziw zziwVar = (zziw) zzijVar;
        String strZzd = zziwVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i33 = 1;
            while (true) {
                i = i33 + 1;
                if (strZzd.charAt(i33) < 55296) {
                    break;
                }
                i33 = i;
            }
        } else {
            i = 1;
        }
        int i34 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i35 = iCharAt3 & 8191;
            int i36 = 13;
            while (true) {
                i32 = i34 + 1;
                cCharAt13 = strZzd.charAt(i34);
                if (cCharAt13 < 55296) {
                    break;
                }
                i35 |= (cCharAt13 & 8191) << i36;
                i36 += 13;
                i34 = i32;
            }
            iCharAt3 = i35 | (cCharAt13 << i36);
            i34 = i32;
        }
        if (iCharAt3 == 0) {
            i4 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i2 = 0;
            i5 = 0;
            i3 = 0;
            iArr = zza;
            i6 = 0;
        } else {
            int i37 = i34 + 1;
            int iCharAt4 = strZzd.charAt(i34);
            if (iCharAt4 >= 55296) {
                int i38 = iCharAt4 & 8191;
                int i39 = 13;
                while (true) {
                    i14 = i37 + 1;
                    cCharAt8 = strZzd.charAt(i37);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt8 & 8191) << i39;
                    i39 += 13;
                    i37 = i14;
                }
                iCharAt4 = i38 | (cCharAt8 << i39);
                i37 = i14;
            }
            int i40 = i37 + 1;
            int iCharAt5 = strZzd.charAt(i37);
            if (iCharAt5 >= 55296) {
                int i41 = iCharAt5 & 8191;
                int i42 = 13;
                while (true) {
                    i13 = i40 + 1;
                    cCharAt7 = strZzd.charAt(i40);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt7 & 8191) << i42;
                    i42 += 13;
                    i40 = i13;
                }
                iCharAt5 = i41 | (cCharAt7 << i42);
                i40 = i13;
            }
            int i43 = i40 + 1;
            int iCharAt6 = strZzd.charAt(i40);
            if (iCharAt6 >= 55296) {
                int i44 = iCharAt6 & 8191;
                int i45 = 13;
                while (true) {
                    i12 = i43 + 1;
                    cCharAt6 = strZzd.charAt(i43);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt6 & 8191) << i45;
                    i45 += 13;
                    i43 = i12;
                }
                iCharAt6 = i44 | (cCharAt6 << i45);
                i43 = i12;
            }
            int i46 = i43 + 1;
            int iCharAt7 = strZzd.charAt(i43);
            if (iCharAt7 >= 55296) {
                int i47 = iCharAt7 & 8191;
                int i48 = 13;
                while (true) {
                    i11 = i46 + 1;
                    cCharAt5 = strZzd.charAt(i46);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt5 & 8191) << i48;
                    i48 += 13;
                    i46 = i11;
                }
                iCharAt7 = i47 | (cCharAt5 << i48);
                i46 = i11;
            }
            int i49 = i46 + 1;
            iCharAt = strZzd.charAt(i46);
            if (iCharAt >= 55296) {
                int i50 = iCharAt & 8191;
                int i51 = 13;
                while (true) {
                    i10 = i49 + 1;
                    cCharAt4 = strZzd.charAt(i49);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt4 & 8191) << i51;
                    i51 += 13;
                    i49 = i10;
                }
                iCharAt = i50 | (cCharAt4 << i51);
                i49 = i10;
            }
            int i52 = i49 + 1;
            iCharAt2 = strZzd.charAt(i49);
            if (iCharAt2 >= 55296) {
                int i53 = iCharAt2 & 8191;
                int i54 = 13;
                while (true) {
                    i9 = i52 + 1;
                    cCharAt3 = strZzd.charAt(i52);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt3 & 8191) << i54;
                    i54 += 13;
                    i52 = i9;
                }
                iCharAt2 = i53 | (cCharAt3 << i54);
                i52 = i9;
            }
            int i55 = i52 + 1;
            int iCharAt8 = strZzd.charAt(i52);
            if (iCharAt8 >= 55296) {
                int i56 = iCharAt8 & 8191;
                int i57 = 13;
                while (true) {
                    i8 = i55 + 1;
                    cCharAt2 = strZzd.charAt(i55);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt2 & 8191) << i57;
                    i57 += 13;
                    i55 = i8;
                }
                iCharAt8 = i56 | (cCharAt2 << i57);
                i55 = i8;
            }
            int i58 = i55 + 1;
            int iCharAt9 = strZzd.charAt(i55);
            if (iCharAt9 >= 55296) {
                int i59 = iCharAt9 & 8191;
                int i60 = 13;
                while (true) {
                    i7 = i58 + 1;
                    cCharAt = strZzd.charAt(i58);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i60;
                    i60 += 13;
                    i58 = i7;
                }
                iCharAt9 = i59 | (cCharAt << i60);
                i58 = i7;
            }
            int i61 = iCharAt4 + iCharAt4 + iCharAt5;
            int[] iArr2 = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i2 = iCharAt6;
            i3 = iCharAt9;
            i4 = i61;
            iArr = iArr2;
            i5 = iCharAt7;
            i6 = iCharAt4;
            i34 = i58;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zziwVar.zze();
        Class<?> cls2 = zziwVar.zza().getClass();
        int i62 = i3 + iCharAt2;
        int i63 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i63];
        int i64 = i3;
        int i65 = i62;
        int i66 = 0;
        int i67 = 0;
        while (i34 < length) {
            int i68 = i34 + 1;
            int iCharAt10 = strZzd.charAt(i34);
            if (iCharAt10 >= c) {
                int i69 = iCharAt10 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i31 = i70 + 1;
                    cCharAt12 = strZzd.charAt(i70);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i69 |= (cCharAt12 & 8191) << i71;
                    i71 += 13;
                    i70 = i31;
                }
                iCharAt10 = i69 | (cCharAt12 << i71);
                i15 = i31;
            } else {
                i15 = i68;
            }
            int i72 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            if (iCharAt11 >= c) {
                int i73 = iCharAt11 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i30 = i74 + 1;
                    cCharAt11 = strZzd.charAt(i74);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i75;
                    i75 += 13;
                    i74 = i30;
                }
                iCharAt11 = i73 | (cCharAt11 << i75);
                i16 = i30;
            } else {
                i16 = i72;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i66] = i67;
                i66++;
            }
            int i76 = iCharAt11 & 255;
            int i77 = length;
            int i78 = iCharAt11 & 2048;
            int i79 = i5;
            if (i76 >= 51) {
                int i80 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i81 = iCharAt12 & 8191;
                    int i82 = i80;
                    int i83 = 13;
                    while (true) {
                        i29 = i82 + 1;
                        cCharAt10 = strZzd.charAt(i82);
                        i17 = i2;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i81 |= (cCharAt10 & 8191) << i83;
                        i83 += 13;
                        i82 = i29;
                        i2 = i17;
                    }
                    iCharAt12 = i81 | (cCharAt10 << i83);
                    i25 = i29;
                } else {
                    i17 = i2;
                    i25 = i80;
                }
                int i84 = i76 - 51;
                int i85 = i25;
                if (i84 == 9 || i84 == 17) {
                    i26 = i4 + 1;
                    int i86 = i67 / 3;
                    objArr[i86 + i86 + 1] = objArrZze[i4];
                } else {
                    if (i84 == 12) {
                        if (zziwVar.zzc() == 1 || i78 != 0) {
                            i26 = i4 + 1;
                            int i87 = i67 / 3;
                            objArr[i87 + i87 + 1] = objArrZze[i4];
                        } else {
                            i78 = 0;
                        }
                    }
                    i27 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i27];
                    if (obj instanceof Field) {
                        fieldZzz2 = (Field) obj;
                    } else {
                        fieldZzz2 = zzz(cls2, (String) obj);
                        objArrZze[i27] = fieldZzz2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzz2);
                    i28 = i27 + 1;
                    obj2 = objArrZze[i28];
                    int i88 = i78;
                    if (obj2 instanceof Field) {
                        fieldZzz3 = (Field) obj2;
                    } else {
                        fieldZzz3 = zzz(cls2, (String) obj2);
                        objArrZze[i28] = fieldZzz3;
                    }
                    i18 = i4;
                    i19 = i85;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
                    i20 = 0;
                    strZzd = strZzd;
                    zziwVar = zziwVar;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i21 = i88;
                }
                i4 = i26;
                i27 = iCharAt12 + iCharAt12;
                obj = objArrZze[i27];
                if (obj instanceof Field) {
                    fieldZzz2 = (Field) obj;
                } else {
                    fieldZzz2 = zzz(cls2, (String) obj);
                    objArrZze[i27] = fieldZzz2;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzz2);
                i28 = i27 + 1;
                obj2 = objArrZze[i28];
                int i89 = i78;
                if (obj2 instanceof Field) {
                    fieldZzz3 = (Field) obj2;
                } else {
                    fieldZzz3 = zzz(cls2, (String) obj2);
                    objArrZze[i28] = fieldZzz3;
                }
                i18 = i4;
                i19 = i85;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
                i20 = 0;
                strZzd = strZzd;
                zziwVar = zziwVar;
                iObjectFieldOffset = iObjectFieldOffset4;
                i21 = i89;
            } else {
                i17 = i2;
                i18 = i4 + 1;
                Field fieldZzz4 = zzz(cls2, (String) objArrZze[i4]);
                if (i76 == 9 || i76 == 17) {
                    int i90 = i67 / 3;
                    objArr[i90 + i90 + 1] = fieldZzz4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i24 = i4 + 2;
                            i23 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            zziwVar = zziwVar;
                            if (zziwVar.zzc() == 1 || i78 != 0) {
                                i24 = i4 + 2;
                                int i91 = i67 / 3;
                                objArr[i91 + i91 + 1] = objArrZze[i18];
                                i18 = i24;
                            } else {
                                i78 = 0;
                            }
                        } else if (i76 == 50) {
                            int i92 = i4 + 2;
                            int i93 = i64 + 1;
                            iArr[i64] = i67;
                            int i94 = i67 / 3;
                            int i95 = i94 + i94;
                            objArr[i95] = objArrZze[i18];
                            if (i78 != 0) {
                                i18 = i4 + 3;
                                objArr[i95 + 1] = objArrZze[i92];
                                i64 = i93;
                                zziwVar = zziwVar;
                            } else {
                                i18 = i92;
                                i64 = i93;
                                i78 = 0;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt11 & 4096) != 0 || i76 > 17) {
                            i19 = i16;
                            i20 = 0;
                        } else {
                            int i96 = i16 + 1;
                            int iCharAt13 = strZzd.charAt(i16);
                            if (iCharAt13 >= 55296) {
                                int i97 = iCharAt13 & 8191;
                                int i98 = 13;
                                while (true) {
                                    i22 = i96 + 1;
                                    cCharAt9 = strZzd.charAt(i96);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i97 |= (cCharAt9 & 8191) << i98;
                                    i98 += 13;
                                    i96 = i22;
                                }
                                iCharAt13 = i97 | (cCharAt9 << i98);
                                i96 = i22;
                            }
                            int i99 = i6 + i6 + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i99];
                            i19 = i96;
                            if (obj3 instanceof Field) {
                                fieldZzz = (Field) obj3;
                            } else {
                                fieldZzz = zzz(cls2, (String) obj3);
                                objArrZze[i99] = fieldZzz;
                            }
                            i20 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz);
                        }
                        if (i76 >= 18 && i76 <= 49) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        i21 = i78;
                    } else {
                        i23 = 1;
                        i24 = i4 + 2;
                    }
                    int i100 = i67 / 3;
                    objArr[i100 + i100 + i23] = objArrZze[i18];
                    i18 = i24;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                    iObjectFieldOffset2 = 1048575;
                    if ((iCharAt11 & 4096) != 0) {
                        i19 = i16;
                        i20 = 0;
                    } else {
                        i19 = i16;
                        i20 = 0;
                    }
                    if (i76 >= 18) {
                        iArr[i65] = iObjectFieldOffset;
                        i65++;
                    }
                    i21 = i78;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) != 0) {
                    i19 = i16;
                    i20 = 0;
                } else {
                    i19 = i16;
                    i20 = 0;
                }
                if (i76 >= 18) {
                    iArr[i65] = iObjectFieldOffset;
                    i65++;
                }
                i21 = i78;
            }
            int i101 = i67 + 1;
            iArr3[i67] = iCharAt10;
            int i102 = i67 + 2;
            Class<?> cls3 = cls2;
            iArr3[i101] = iObjectFieldOffset | (i21 != 0 ? Integer.MIN_VALUE : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i76 << 20);
            i67 += 3;
            iArr3[i102] = (i20 << 20) | iObjectFieldOffset2;
            strZzd = strZzd;
            i4 = i18;
            length = i77;
            i5 = i79;
            cls2 = cls3;
            zziwVar = zziwVar;
            i34 = i19;
            i2 = i17;
            c = 55296;
        }
        return new zzip(iArr3, objArr, i2, i5, zziwVar.zza(), false, iArr, i3, i62, zzirVar, zzhzVar, zzjjVar, zzgxVar, zzihVar);
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzjq.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzjq.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzjq.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzjq.zzf(obj, j)).longValue();
    }

    private final zzhm zzu(int i) {
        int i2 = i / 3;
        return (zzhm) this.zzd[i2 + i2 + 1];
    }

    private final zzix zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzix zzixVar = (zzix) objArr[i3];
        if (zzixVar != null) {
            return zzixVar;
        }
        zzix zzixVarZzb = zziu.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzixVarZzb;
        return zzixVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzix zzixVarZzv = zzv(i);
        int iZzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzixVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzixVarZzv.zze();
        if (object != null) {
            zzixVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzix zzixVarZzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzixVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzixVarZzv.zze();
        if (object != null) {
            zzixVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
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

    /* JADX WARN: Code duplicated, block: B:137:0x038d  */
    /* JADX WARN: Code duplicated, block: B:207:0x054e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v118, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v120, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v185, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v256, types: [int] */
    /* JADX WARN: Type inference failed for: r0v264 */
    /* JADX WARN: Type inference failed for: r0v266 */
    /* JADX WARN: Type inference failed for: r0v267 */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r0v276 */
    /* JADX WARN: Type inference failed for: r0v277 */
    /* JADX WARN: Type inference failed for: r0v278 */
    /* JADX WARN: Type inference failed for: r0v279 */
    /* JADX WARN: Type inference failed for: r0v280 */
    /* JADX WARN: Type inference failed for: r0v281 */
    /* JADX WARN: Type inference failed for: r0v282 */
    /* JADX WARN: Type inference failed for: r0v283 */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r12v5, types: [int] */
    /* JADX WARN: Type inference failed for: r12v6, types: [int] */
    /* JADX WARN: Type inference failed for: r12v7, types: [int] */
    /* JADX WARN: Type inference failed for: r12v9, types: [int] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v120, types: [int] */
    /* JADX WARN: Type inference failed for: r1v123, types: [int] */
    /* JADX WARN: Type inference failed for: r1v162 */
    /* JADX WARN: Type inference failed for: r1v165 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v168 */
    /* JADX WARN: Type inference failed for: r1v169 */
    /* JADX WARN: Type inference failed for: r1v170 */
    /* JADX WARN: Type inference failed for: r1v80, types: [int] */
    /* JADX WARN: Type inference failed for: r1v82 */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46, types: [int] */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55, types: [int] */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [int] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30, types: [int] */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v39, types: [int] */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v46, types: [int] */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31, types: [int] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v38, types: [int] */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.play_billing.zzix
    public final int zza(Object obj) {
        int i;
        ?? r16;
        ?? r5;
        int iZzz;
        int iZzz2;
        int iZzz3;
        int iZzA;
        int iZzz4;
        int iZzz5;
        int iZzd;
        int iZzz6;
        ?? Zzg;
        int size;
        int iZzz7;
        int iZzy;
        int iZzy2;
        ?? r3;
        int iZzx;
        ?? Zzz;
        ?? Zzh;
        int iZze;
        int iZzz8;
        int iZzz9;
        ?? r4;
        ?? r6;
        ?? r1;
        Unsafe unsafe = zzb;
        boolean z = false;
        int i2 = 1048575;
        ?? r2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i3 < this.zzc.length) {
            int iZzs = zzs(i3);
            int iZzr = zzr(iZzs);
            int[] iArr = this.zzc;
            int i6 = iArr[i3];
            int i7 = iArr[i3 + 2];
            int i8 = i7 & i2;
            if (iZzr <= 17) {
                if (i8 != i5) {
                    r1 = i8 == i2 ? z : unsafe.getInt(obj, i8);
                    i5 = i8;
                }
                i = i5;
                r16 = r1;
                r5 = 1 << (i7 >>> 20);
            } else {
                r1 = r2;
                i = i5;
                r16 = r2 == true ? 1 : 0;
                r5 = z;
            }
            int i9 = iZzs & i2;
            if (iZzr >= zzhc.DOUBLE_LIST_PACKED.zza()) {
                zzhc.SINT64_LIST_PACKED.zza();
            }
            long j = i9;
            switch (iZzr) {
                case 0:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz = zzgr.zzz(i6 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 1:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz2 = zzgr.zzz(i6 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 2:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzz3 = zzgr.zzz(i6 << 3);
                        iZzA = zzgr.zzA(j2);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 3:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzz3 = zzgr.zzz(i6 << 3);
                        iZzA = zzgr.zzA(j3);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 4:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzz3 = zzgr.zzz(i6 << 3);
                        iZzA = zzgr.zzA(j4);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 5:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz = zzgr.zzz(i6 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 6:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz2 = zzgr.zzz(i6 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 7:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz4 = zzgr.zzz(i6 << 3);
                        Zzh = iZzz4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 8:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i10 = i6 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzgk) {
                            iZzz5 = zzgr.zzz(i10);
                            iZzd = ((zzgk) object).zzd();
                            iZzz6 = zzgr.zzz(iZzd);
                            Zzh = iZzz5 + iZzz6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzz3 = zzgr.zzz(i10);
                            iZzA = zzgr.zzy((String) object);
                            Zzh = iZzz3 + iZzA;
                            i4 += Zzh;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 9:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzh = zziz.zzh(i6, unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 10:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        zzgk zzgkVar = (zzgk) unsafe.getObject(obj, j);
                        iZzz5 = zzgr.zzz(i6 << 3);
                        iZzd = zzgkVar.zzd();
                        iZzz6 = zzgr.zzz(iZzd);
                        Zzh = iZzz5 + iZzz6 + iZzd;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 11:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i11 = unsafe.getInt(obj, j);
                        iZzz3 = zzgr.zzz(i6 << 3);
                        iZzA = zzgr.zzz(i11);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 12:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzz3 = zzgr.zzz(i6 << 3);
                        iZzA = zzgr.zzA(j5);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 13:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz2 = zzgr.zzz(i6 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 14:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz = zzgr.zzz(i6 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 15:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzz3 = zzgr.zzz(i6 << 3);
                        iZzA = zzgr.zzz((i12 >> 31) ^ (i12 + i12));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 16:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzz3 = zzgr.zzz(i6 << 3);
                        iZzA = zzgr.zzA((j6 >> 63) ^ (j6 + j6));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 17:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzh = zzgr.zzw(i6, (zzim) unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 18:
                    Zzh = zziz.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 19:
                    Zzh = zziz.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i13 = zziz.zza;
                    if (list.size() == 0) {
                        Zzg = z;
                    } else {
                        Zzg = zziz.zzg(list) + (list.size() * zzgr.zzz(i6 << 3));
                    }
                    i4 += Zzg;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i14 = zziz.zza;
                    size = list2.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zziz.zzl(list2);
                        iZzz7 = zzgr.zzz(i6 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i15 = zziz.zza;
                    size = list3.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zziz.zzf(list3);
                        iZzz7 = zzgr.zzz(i6 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 23:
                    Zzh = zziz.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 24:
                    Zzh = zziz.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i16 = zziz.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        Zzh = z;
                    } else {
                        Zzh = size2 * (zzgr.zzz(i6 << 3) + 1);
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 26:
                    ?? r0 = (List) unsafe.getObject(obj, j);
                    int i17 = zziz.zza;
                    int size3 = r0.size();
                    if (size3 == 0) {
                        Zzg = z;
                    } else {
                        int iZzz10 = zzgr.zzz(i6 << 3) * size3;
                        if (r0 instanceof zzhy) {
                            zzhy zzhyVar = (zzhy) r0;
                            for (?? r7 = z; r7 < size3; r7++) {
                                Object objZzc = zzhyVar.zzc();
                                if (objZzc instanceof zzgk) {
                                    Zzg = iZzz10;
                                    int iZzd2 = ((zzgk) objZzc).zzd();
                                    iZzy2 = Zzg + zzgr.zzz(iZzd2) + iZzd2;
                                } else {
                                    Zzg = iZzz10;
                                    iZzy2 = Zzg + zzgr.zzy((String) objZzc);
                                }
                                Zzg = iZzy2;
                            }
                            Zzg = iZzz10;
                        } else {
                            for (?? r8 = z; r8 < size3; r8++) {
                                Object obj2 = r0.get(r8);
                                if (obj2 instanceof zzgk) {
                                    Zzg = iZzz10;
                                    int iZzd3 = ((zzgk) obj2).zzd();
                                    iZzy = Zzg + zzgr.zzz(iZzd3) + iZzd3;
                                } else {
                                    Zzg = iZzz10;
                                    iZzy = Zzg + zzgr.zzy((String) obj2);
                                }
                                Zzg = iZzy;
                            }
                            Zzg = iZzz10;
                        }
                    }
                    i4 += Zzg;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 27:
                    ?? r9 = (List) unsafe.getObject(obj, j);
                    zzix zzixVarZzv = zzv(i3);
                    int i18 = zziz.zza;
                    int size4 = r9.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        int iZzz11 = zzgr.zzz(i6 << 3) * size4;
                        for (?? r10 = z; r10 < size4; r10++) {
                            Object obj3 = r9.get(r10);
                            if (obj3 instanceof zzhx) {
                                r3 = iZzz11;
                                int iZza = ((zzhx) obj3).zza();
                                iZzx = (r3 == true ? 1 : 0) + zzgr.zzz(iZza) + iZza;
                            } else {
                                r3 = iZzz11;
                                iZzx = (r3 == true ? 1 : 0) + zzgr.zzx((zzim) obj3, zzixVarZzv);
                            }
                            r3 = iZzx;
                        }
                        r3 = iZzz11;
                    }
                    i4 += r3;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 28:
                    ?? r11 = (List) unsafe.getObject(obj, j);
                    int i19 = zziz.zza;
                    int size5 = r11.size();
                    if (size5 == 0) {
                        Zzz = z;
                    } else {
                        Zzz = size5 * zzgr.zzz(i6 << 3);
                        for (?? r12 = z; r12 < r11.size(); r12++) {
                            int iZzd4 = ((zzgk) r11.get(r12)).zzd();
                            Zzz += zzgr.zzz(iZzd4) + iZzd4;
                        }
                    }
                    i4 += Zzz;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i20 = zziz.zza;
                    size = list5.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zziz.zzk(list5);
                        iZzz7 = zzgr.zzz(i6 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i21 = zziz.zza;
                    size = list6.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zziz.zza(list6);
                        iZzz7 = zzgr.zzz(i6 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 31:
                    Zzh = zziz.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 32:
                    Zzh = zziz.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i22 = zziz.zza;
                    size = list7.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zziz.zzi(list7);
                        iZzz7 = zzgr.zzz(i6 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i23 = zziz.zza;
                    size = list8.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zziz.zzj(list8);
                        iZzz7 = zzgr.zzz(i6 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 35:
                    iZze = zziz.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgr.zzz(i6 << 3);
                        iZzz9 = zzgr.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 36:
                    iZze = zziz.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgr.zzz(i6 << 3);
                        iZzz9 = zzgr.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 37:
                    iZze = zziz.zzg((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgr.zzz(i6 << 3);
                        iZzz9 = zzgr.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 38:
                    iZze = zziz.zzl((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgr.zzz(i6 << 3);
                        iZzz9 = zzgr.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 39:
                    iZze = zziz.zzf((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgr.zzz(i6 << 3);
                        iZzz9 = zzgr.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 40:
                    iZze = zziz.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgr.zzz(i6 << 3);
                        iZzz9 = zzgr.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 41:
                    iZze = zziz.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgr.zzz(i6 << 3);
                        iZzz9 = zzgr.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i24 = zziz.zza;
                    iZze = list9.size();
                    if (iZze > 0) {
                        iZzz8 = zzgr.zzz(i6 << 3);
                        iZzz9 = zzgr.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 43:
                    iZze = zziz.zzk((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgr.zzz(i6 << 3);
                        iZzz9 = zzgr.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 44:
                    iZze = zziz.zza((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgr.zzz(i6 << 3);
                        iZzz9 = zzgr.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 45:
                    iZze = zziz.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgr.zzz(i6 << 3);
                        iZzz9 = zzgr.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 46:
                    iZze = zziz.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgr.zzz(i6 << 3);
                        iZzz9 = zzgr.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 47:
                    iZze = zziz.zzi((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgr.zzz(i6 << 3);
                        iZzz9 = zzgr.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 48:
                    iZze = zziz.zzj((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgr.zzz(i6 << 3);
                        iZzz9 = zzgr.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 49:
                    ?? r13 = (List) unsafe.getObject(obj, j);
                    zzix zzixVarZzv2 = zzv(i3);
                    int i25 = zziz.zza;
                    int size6 = r13.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z2 = z;
                        r4 = z2;
                        while (r6 < size6) {
                            r6 = z2;
                            int iZzw = zzgr.zzw(i6, (zzim) r13.get(r6), zzixVarZzv2);
                            r6++;
                            r4 = (r4 == true ? 1 : 0) + iZzw;
                        }
                        r6 = z2;
                    }
                    i4 += r4;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 50:
                    zzig zzigVar = (zzig) unsafe.getObject(obj, j);
                    if (zzigVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzigVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                case 51:
                    if (zzM(obj, i6, i3)) {
                        iZzz = zzgr.zzz(i6 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 52:
                    if (zzM(obj, i6, i3)) {
                        iZzz2 = zzgr.zzz(i6 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 53:
                    if (zzM(obj, i6, i3)) {
                        long jZzt = zzt(obj, j);
                        iZzz3 = zzgr.zzz(i6 << 3);
                        iZzA = zzgr.zzA(jZzt);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 54:
                    if (zzM(obj, i6, i3)) {
                        long jZzt2 = zzt(obj, j);
                        iZzz3 = zzgr.zzz(i6 << 3);
                        iZzA = zzgr.zzA(jZzt2);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 55:
                    if (zzM(obj, i6, i3)) {
                        long jZzo = zzo(obj, j);
                        iZzz3 = zzgr.zzz(i6 << 3);
                        iZzA = zzgr.zzA(jZzo);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 56:
                    if (zzM(obj, i6, i3)) {
                        iZzz = zzgr.zzz(i6 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 57:
                    if (zzM(obj, i6, i3)) {
                        iZzz2 = zzgr.zzz(i6 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    if (zzM(obj, i6, i3)) {
                        iZzz4 = zzgr.zzz(i6 << 3);
                        Zzh = iZzz4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    if (zzM(obj, i6, i3)) {
                        int i26 = i6 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzgk) {
                            iZzz5 = zzgr.zzz(i26);
                            iZzd = ((zzgk) object2).zzd();
                            iZzz6 = zzgr.zzz(iZzd);
                            Zzh = iZzz5 + iZzz6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzz3 = zzgr.zzz(i26);
                            iZzA = zzgr.zzy((String) object2);
                            Zzh = iZzz3 + iZzA;
                            i4 += Zzh;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 60:
                    if (zzM(obj, i6, i3)) {
                        Zzh = zziz.zzh(i6, unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 61:
                    if (zzM(obj, i6, i3)) {
                        zzgk zzgkVar2 = (zzgk) unsafe.getObject(obj, j);
                        iZzz5 = zzgr.zzz(i6 << 3);
                        iZzd = zzgkVar2.zzd();
                        iZzz6 = zzgr.zzz(iZzd);
                        Zzh = iZzz5 + iZzz6 + iZzd;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 62:
                    if (zzM(obj, i6, i3)) {
                        int iZzo = zzo(obj, j);
                        iZzz3 = zzgr.zzz(i6 << 3);
                        iZzA = zzgr.zzz(iZzo);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 63:
                    if (zzM(obj, i6, i3)) {
                        long jZzo2 = zzo(obj, j);
                        iZzz3 = zzgr.zzz(i6 << 3);
                        iZzA = zzgr.zzA(jZzo2);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 64:
                    if (zzM(obj, i6, i3)) {
                        iZzz2 = zzgr.zzz(i6 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 65:
                    if (zzM(obj, i6, i3)) {
                        iZzz = zzgr.zzz(i6 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 66:
                    if (zzM(obj, i6, i3)) {
                        int iZzo2 = zzo(obj, j);
                        iZzz3 = zzgr.zzz(i6 << 3);
                        iZzA = zzgr.zzz((iZzo2 >> 31) ^ (iZzo2 + iZzo2));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 67:
                    if (zzM(obj, i6, i3)) {
                        long jZzt3 = zzt(obj, j);
                        iZzz3 = zzgr.zzz(i6 << 3);
                        iZzA = zzgr.zzA((jZzt3 >> 63) ^ (jZzt3 + jZzt3));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    if (zzM(obj, i6, i3)) {
                        Zzh = zzgr.zzw(i6, (zzim) unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                default:
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
            }
        }
        int iZza2 = i4 + ((zzhk) obj).zzc.zza();
        if (!this.zzh) {
            return iZza2;
        }
        zzhb zzhbVar = ((zzhh) obj).zzb;
        int iZzc = zzhbVar.zza.zzc();
        int iZzb = 0;
        for (int i27 = 0; i27 < iZzc; i27++) {
            Map.Entry entryZzg = zzhbVar.zza.zzg(i27);
            iZzb += zzhb.zzb((zzha) ((zzjb) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry2 : zzhbVar.zza.zzd()) {
            iZzb += zzhb.zzb((zzha) entry2.getKey(), entry2.getValue());
        }
        return iZza2 + iZzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int iZzs = zzs(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i6 = iArr[i4];
            long j = i5;
            int iHashCode = 37;
            switch (iZzr) {
                case 0:
                    i = i3 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzjq.zza(obj, j));
                    byte[] bArr = zzhp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzjq.zzb(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    jDoubleToLongBits = zzjq.zzd(obj, j);
                    byte[] bArr2 = zzhp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    jDoubleToLongBits = zzjq.zzd(obj, j);
                    byte[] bArr3 = zzhp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    iFloatToIntBits = zzjq.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    jDoubleToLongBits = zzjq.zzd(obj, j);
                    byte[] bArr4 = zzhp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    iFloatToIntBits = zzjq.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    iFloatToIntBits = zzhp.zza(zzjq.zzw(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    iFloatToIntBits = ((String) zzjq.zzf(obj, j)).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object objZzf = zzjq.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iFloatToIntBits = zzjq.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    iFloatToIntBits = zzjq.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    iFloatToIntBits = zzjq.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    iFloatToIntBits = zzjq.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    jDoubleToLongBits = zzjq.zzd(obj, j);
                    byte[] bArr5 = zzhp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    iFloatToIntBits = zzjq.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    jDoubleToLongBits = zzjq.zzd(obj, j);
                    byte[] bArr6 = zzhp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object objZzf2 = zzjq.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i3 = i2 + iHashCode;
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
                    i = i3 * 53;
                    iFloatToIntBits = zzjq.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    iFloatToIntBits = zzjq.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzhp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzhp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzhp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzhp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzhp.zza(zzN(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = ((String) zzjq.zzf(obj, j)).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzjq.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzjq.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzhp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzhp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzjq.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i3 * 53) + ((zzhk) obj).zzc.hashCode();
        return this.zzh ? (iHashCode2 * 53) + ((zzhh) obj).zzb.zza.hashCode() : iHashCode2;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0287  */
    /* JADX WARN: Code duplicated, block: B:104:0x028b  */
    /* JADX WARN: Code duplicated, block: B:113:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:115:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:117:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:118:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:127:0x0333  */
    /* JADX WARN: Code duplicated, block: B:128:0x0335  */
    /* JADX WARN: Code duplicated, block: B:160:0x041e  */
    /* JADX WARN: Code duplicated, block: B:162:0x0424  */
    /* JADX WARN: Code duplicated, block: B:163:0x0427  */
    /* JADX WARN: Code duplicated, block: B:171:0x047c  */
    /* JADX WARN: Code duplicated, block: B:172:0x048c  */
    /* JADX WARN: Code duplicated, block: B:175:0x0494  */
    /* JADX WARN: Code duplicated, block: B:177:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:178:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:180:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:182:0x04d5 A[LOOP:3: B:181:0x04d3->B:182:0x04d5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:184:0x04e5  */
    /* JADX WARN: Code duplicated, block: B:187:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:189:0x04fa  */
    /* JADX WARN: Code duplicated, block: B:191:0x050d  */
    /* JADX WARN: Code duplicated, block: B:193:0x0517 A[LOOP:4: B:190:0x050b->B:193:0x0517, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:195:0x052a  */
    /* JADX WARN: Code duplicated, block: B:196:0x0535  */
    /* JADX WARN: Code duplicated, block: B:198:0x053c  */
    /* JADX WARN: Code duplicated, block: B:200:0x0549 A[LOOP:5: B:199:0x0547->B:200:0x0549, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:205:0x0560 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:206:0x0562  */
    /* JADX WARN: Code duplicated, block: B:208:0x0575  */
    /* JADX WARN: Code duplicated, block: B:210:0x057d A[LOOP:6: B:207:0x0573->B:210:0x057d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:212:0x0597  */
    /* JADX WARN: Code duplicated, block: B:214:0x059e  */
    /* JADX WARN: Code duplicated, block: B:215:0x05a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:216:0x05aa  */
    /* JADX WARN: Code duplicated, block: B:219:0x05c8  */
    /* JADX WARN: Code duplicated, block: B:221:0x05cc  */
    /* JADX WARN: Code duplicated, block: B:223:0x05d9  */
    /* JADX WARN: Code duplicated, block: B:225:0x05eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:226:0x05ed  */
    /* JADX WARN: Code duplicated, block: B:228:0x05f7  */
    /* JADX WARN: Code duplicated, block: B:232:0x0604  */
    /* JADX WARN: Code duplicated, block: B:233:0x060c  */
    /* JADX WARN: Code duplicated, block: B:236:0x061c  */
    /* JADX WARN: Code duplicated, block: B:239:0x0634  */
    /* JADX WARN: Code duplicated, block: B:243:0x0654  */
    /* JADX WARN: Code duplicated, block: B:245:0x0660  */
    /* JADX WARN: Code duplicated, block: B:247:0x0668  */
    /* JADX WARN: Code duplicated, block: B:249:0x066c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:250:0x066e  */
    /* JADX WARN: Code duplicated, block: B:251:0x0674  */
    /* JADX WARN: Code duplicated, block: B:254:0x067e  */
    /* JADX WARN: Code duplicated, block: B:256:0x0686  */
    /* JADX WARN: Code duplicated, block: B:258:0x068e  */
    /* JADX WARN: Code duplicated, block: B:260:0x0692 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    /* JADX WARN: Code duplicated, block: B:272:0x06c0  */
    /* JADX WARN: Code duplicated, block: B:273:0x06c8  */
    /* JADX WARN: Code duplicated, block: B:275:0x06d4  */
    /* JADX WARN: Code duplicated, block: B:276:0x06f6  */
    /* JADX WARN: Code duplicated, block: B:278:0x0704  */
    /* JADX WARN: Code duplicated, block: B:280:0x0714  */
    /* JADX WARN: Code duplicated, block: B:282:0x071d  */
    /* JADX WARN: Code duplicated, block: B:284:0x0725 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:285:0x0727  */
    /* JADX WARN: Code duplicated, block: B:286:0x072d  */
    /* JADX WARN: Code duplicated, block: B:289:0x073c  */
    /* JADX WARN: Code duplicated, block: B:291:0x0744  */
    /* JADX WARN: Code duplicated, block: B:293:0x074c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:301:0x0770  */
    /* JADX WARN: Code duplicated, block: B:303:0x077a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:304:0x077c  */
    /* JADX WARN: Code duplicated, block: B:305:0x0784  */
    /* JADX WARN: Code duplicated, block: B:307:0x078c  */
    /* JADX WARN: Code duplicated, block: B:309:0x079d  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:311:0x07a5  */
    /* JADX WARN: Code duplicated, block: B:313:0x07ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:317:0x07bb  */
    /* JADX WARN: Code duplicated, block: B:31:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:327:0x07e9  */
    /* JADX WARN: Code duplicated, block: B:329:0x07f0  */
    /* JADX WARN: Code duplicated, block: B:331:0x07fe  */
    /* JADX WARN: Code duplicated, block: B:333:0x080c  */
    /* JADX WARN: Code duplicated, block: B:335:0x0816  */
    /* JADX WARN: Code duplicated, block: B:336:0x0818  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:342:0x0828 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:343:0x082a  */
    /* JADX WARN: Code duplicated, block: B:345:0x0839  */
    /* JADX WARN: Code duplicated, block: B:346:0x083b  */
    /* JADX WARN: Code duplicated, block: B:349:0x0842  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:351:0x084a  */
    /* JADX WARN: Code duplicated, block: B:353:0x0854  */
    /* JADX WARN: Code duplicated, block: B:354:0x0856  */
    /* JADX WARN: Code duplicated, block: B:356:0x085c  */
    /* JADX WARN: Code duplicated, block: B:358:0x086a  */
    /* JADX WARN: Code duplicated, block: B:360:0x087a  */
    /* JADX WARN: Code duplicated, block: B:362:0x0886 A[LOOP:14: B:361:0x0884->B:362:0x0886, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:369:0x08a0  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:371:0x08a3  */
    /* JADX WARN: Code duplicated, block: B:373:0x08b3  */
    /* JADX WARN: Code duplicated, block: B:375:0x08bb A[LOOP:15: B:372:0x08b1->B:375:0x08bb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:376:0x08c5  */
    /* JADX WARN: Code duplicated, block: B:378:0x08d3  */
    /* JADX WARN: Code duplicated, block: B:380:0x08e3  */
    /* JADX WARN: Code duplicated, block: B:382:0x08ef A[LOOP:16: B:381:0x08ed->B:382:0x08ef, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:389:0x0908  */
    /* JADX WARN: Code duplicated, block: B:391:0x090b  */
    /* JADX WARN: Code duplicated, block: B:393:0x091b  */
    /* JADX WARN: Code duplicated, block: B:395:0x0923 A[LOOP:17: B:392:0x0919->B:395:0x0923, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:397:0x0934  */
    /* JADX WARN: Code duplicated, block: B:399:0x0942  */
    /* JADX WARN: Code duplicated, block: B:401:0x094d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:402:0x094f  */
    /* JADX WARN: Code duplicated, block: B:404:0x0964  */
    /* JADX WARN: Code duplicated, block: B:405:0x0969  */
    /* JADX WARN: Code duplicated, block: B:407:0x0979  */
    /* JADX WARN: Code duplicated, block: B:409:0x0987 A[LOOP:18: B:408:0x0985->B:409:0x0987, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:414:0x099a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:415:0x099c  */
    /* JADX WARN: Code duplicated, block: B:417:0x09ac  */
    /* JADX WARN: Code duplicated, block: B:419:0x09b4 A[LOOP:19: B:416:0x09aa->B:419:0x09b4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:421:0x09c0  */
    /* JADX WARN: Code duplicated, block: B:423:0x09d0  */
    /* JADX WARN: Code duplicated, block: B:425:0x09e0  */
    /* JADX WARN: Code duplicated, block: B:427:0x09ec A[LOOP:20: B:426:0x09ea->B:427:0x09ec, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:434:0x0a09  */
    /* JADX WARN: Code duplicated, block: B:436:0x0a0c  */
    /* JADX WARN: Code duplicated, block: B:438:0x0a20  */
    /* JADX WARN: Code duplicated, block: B:440:0x0a28 A[LOOP:21: B:437:0x0a1e->B:440:0x0a28, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:442:0x0a3a  */
    /* JADX WARN: Code duplicated, block: B:444:0x0a4a  */
    /* JADX WARN: Code duplicated, block: B:446:0x0a5a  */
    /* JADX WARN: Code duplicated, block: B:448:0x0a66 A[LOOP:22: B:447:0x0a64->B:448:0x0a66, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:451:0x0a7c  */
    /* JADX WARN: Code duplicated, block: B:456:0x0a8a  */
    /* JADX WARN: Code duplicated, block: B:458:0x0a8f  */
    /* JADX WARN: Code duplicated, block: B:460:0x0aa3  */
    /* JADX WARN: Code duplicated, block: B:462:0x0aab A[LOOP:23: B:459:0x0aa1->B:462:0x0aab, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:465:0x0abe  */
    /* JADX WARN: Code duplicated, block: B:467:0x0ac6 A[LOOP:2: B:464:0x0abc->B:467:0x0ac6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:468:0x0ad9 A[PHI: r7 r8 r9 r10 r13 r14 r32
  0x0ad9: PHI (r7v33 com.google.android.gms.internal.play_billing.zzfz) = 
  (r7v6 com.google.android.gms.internal.play_billing.zzfz)
  (r7v30 com.google.android.gms.internal.play_billing.zzfz)
  (r7v37 com.google.android.gms.internal.play_billing.zzfz)
 binds: [B:457:0x0a8d, B:195:0x052a, B:176:0x04a0] A[DONT_GENERATE, DONT_INLINE]
  0x0ad9: PHI (r8v102 int) = (r8v56 int), (r8v99 int), (r8v105 int) binds: [B:457:0x0a8d, B:195:0x052a, B:176:0x04a0] A[DONT_GENERATE, DONT_INLINE]
  0x0ad9: PHI (r9v63 int) = (r9v25 int), (r9v60 int), (r9v66 int) binds: [B:457:0x0a8d, B:195:0x052a, B:176:0x04a0] A[DONT_GENERATE, DONT_INLINE]
  0x0ad9: PHI (r10v71 int) = (r10v36 int), (r10v66 int), (r10v75 int) binds: [B:457:0x0a8d, B:195:0x052a, B:176:0x04a0] A[DONT_GENERATE, DONT_INLINE]
  0x0ad9: PHI (r13v76 sun.misc.Unsafe) = (r13v39 sun.misc.Unsafe), (r13v73 sun.misc.Unsafe), (r13v79 sun.misc.Unsafe) binds: [B:457:0x0a8d, B:195:0x052a, B:176:0x04a0] A[DONT_GENERATE, DONT_INLINE]
  0x0ad9: PHI (r14v61 int) = (r14v35 int), (r14v58 int), (r14v64 int) binds: [B:457:0x0a8d, B:195:0x052a, B:176:0x04a0] A[DONT_GENERATE, DONT_INLINE]
  0x0ad9: PHI (r32v14 int) = (r32v5 int), (r5v56 int), (r5v56 int) binds: [B:457:0x0a8d, B:195:0x052a, B:176:0x04a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:479:0x0b24  */
    /* JADX WARN: Code duplicated, block: B:482:0x0b35  */
    /* JADX WARN: Code duplicated, block: B:484:0x0b43  */
    /* JADX WARN: Code duplicated, block: B:486:0x0b5a A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:487:0x0b62  */
    /* JADX WARN: Code duplicated, block: B:489:0x0b65  */
    /* JADX WARN: Code duplicated, block: B:490:0x0b8c  */
    /* JADX WARN: Code duplicated, block: B:492:0x0b8f  */
    /* JADX WARN: Code duplicated, block: B:493:0x0bac  */
    /* JADX WARN: Code duplicated, block: B:494:0x0bb0  */
    /* JADX WARN: Code duplicated, block: B:496:0x0bb5  */
    /* JADX WARN: Code duplicated, block: B:497:0x0bca  */
    /* JADX WARN: Code duplicated, block: B:499:0x0bcf  */
    /* JADX WARN: Code duplicated, block: B:505:0x0bef  */
    /* JADX WARN: Code duplicated, block: B:506:0x0bfa  */
    /* JADX WARN: Code duplicated, block: B:508:0x0c00  */
    /* JADX WARN: Code duplicated, block: B:512:0x0c16  */
    /* JADX WARN: Code duplicated, block: B:514:0x0c1c  */
    /* JADX WARN: Code duplicated, block: B:515:0x0c42  */
    /* JADX WARN: Code duplicated, block: B:517:0x0c48  */
    /* JADX WARN: Code duplicated, block: B:519:0x0c53  */
    /* JADX WARN: Code duplicated, block: B:521:0x0c5b  */
    /* JADX WARN: Code duplicated, block: B:522:0x0c61  */
    /* JADX WARN: Code duplicated, block: B:531:0x0c89  */
    /* JADX WARN: Code duplicated, block: B:533:0x0c92  */
    /* JADX WARN: Code duplicated, block: B:535:0x0c9d  */
    /* JADX WARN: Code duplicated, block: B:536:0x0ca0  */
    /* JADX WARN: Code duplicated, block: B:538:0x0cae  */
    /* JADX WARN: Code duplicated, block: B:540:0x0cb8  */
    /* JADX WARN: Code duplicated, block: B:541:0x0cca  */
    /* JADX WARN: Code duplicated, block: B:543:0x0cd4  */
    /* JADX WARN: Code duplicated, block: B:544:0x0ce6  */
    /* JADX WARN: Code duplicated, block: B:546:0x0cef  */
    /* JADX WARN: Code duplicated, block: B:547:0x0d01  */
    /* JADX WARN: Code duplicated, block: B:549:0x0d0a  */
    /* JADX WARN: Code duplicated, block: B:551:0x0d1d  */
    /* JADX WARN: Code duplicated, block: B:553:0x0d27  */
    /* JADX WARN: Code duplicated, block: B:554:0x0d3c  */
    /* JADX WARN: Code duplicated, block: B:556:0x0d46  */
    /* JADX WARN: Code duplicated, block: B:557:0x0d5b A[PHI: r6 r9 r14 r32
  0x0d5b: PHI (r6v93 int) = 
  (r6v78 int)
  (r6v79 int)
  (r6v80 int)
  (r6v81 int)
  (r6v82 int)
  (r6v83 int)
  (r6v85 int)
  (r6v86 int)
  (r6v89 int)
  (r6v94 int)
 binds: [B:555:0x0d44, B:552:0x0d25, B:548:0x0d08, B:545:0x0ced, B:542:0x0cd2, B:539:0x0cb6, B:532:0x0c90, B:518:0x0c51, B:516:0x0c45, B:486:0x0b5a] A[DONT_GENERATE, DONT_INLINE]
  0x0d5b: PHI (r9v90 com.google.android.gms.internal.play_billing.zzfz) = 
  (r9v69 com.google.android.gms.internal.play_billing.zzfz)
  (r9v70 com.google.android.gms.internal.play_billing.zzfz)
  (r9v71 com.google.android.gms.internal.play_billing.zzfz)
  (r9v72 com.google.android.gms.internal.play_billing.zzfz)
  (r9v73 com.google.android.gms.internal.play_billing.zzfz)
  (r9v74 com.google.android.gms.internal.play_billing.zzfz)
  (r9v76 com.google.android.gms.internal.play_billing.zzfz)
  (r9v77 com.google.android.gms.internal.play_billing.zzfz)
  (r6v77 com.google.android.gms.internal.play_billing.zzfz)
  (r9v91 com.google.android.gms.internal.play_billing.zzfz)
 binds: [B:555:0x0d44, B:552:0x0d25, B:548:0x0d08, B:545:0x0ced, B:542:0x0cd2, B:539:0x0cb6, B:532:0x0c90, B:518:0x0c51, B:516:0x0c45, B:486:0x0b5a] A[DONT_GENERATE, DONT_INLINE]
  0x0d5b: PHI (r14v89 int) = 
  (r14v66 int)
  (r14v67 int)
  (r14v68 int)
  (r14v69 int)
  (r14v70 int)
  (r14v71 int)
  (r14v73 int)
  (r14v74 int)
  (r14v80 int)
  (r14v90 int)
 binds: [B:555:0x0d44, B:552:0x0d25, B:548:0x0d08, B:545:0x0ced, B:542:0x0cd2, B:539:0x0cb6, B:532:0x0c90, B:518:0x0c51, B:516:0x0c45, B:486:0x0b5a] A[DONT_GENERATE, DONT_INLINE]
  0x0d5b: PHI (r32v34 int) = 
  (r32v16 int)
  (r32v17 int)
  (r32v18 int)
  (r32v19 int)
  (r32v20 int)
  (r32v21 int)
  (r32v23 int)
  (r32v24 int)
  (r3v82 int)
  (r32v35 int)
 binds: [B:555:0x0d44, B:552:0x0d25, B:548:0x0d08, B:545:0x0ced, B:542:0x0cd2, B:539:0x0cb6, B:532:0x0c90, B:518:0x0c51, B:516:0x0c45, B:486:0x0b5a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:566:0x0d86  */
    /* JADX WARN: Code duplicated, block: B:568:0x0d90  */
    /* JADX WARN: Code duplicated, block: B:56:0x0176  */
    /* JADX WARN: Code duplicated, block: B:570:0x0d9c  */
    /* JADX WARN: Code duplicated, block: B:573:0x0db3  */
    /* JADX WARN: Code duplicated, block: B:606:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x0106 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x0150 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x0194 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x01d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x0328 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:0x0343 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x0357 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x0371 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x0383 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x039e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:0x03b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x0412 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:0x04f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:0x055a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:0x06ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:0x06b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x06a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:0x06a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x076a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:0x075d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:0x07e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:630:0x07dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:0x07cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x07c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:0x0822 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:0x089a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:0x0894 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:0x0902 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x08fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:0x0994 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:639:0x0a03 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:640:0x09fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:641:0x0a84 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:642:0x0a7e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:0x0ade A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:644:0x0b0f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:0x0d5e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:0x0daf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:650:0x03ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:0x017b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:0x018e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x01cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:0x0321 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x033b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:0x034f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:660:0x036a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:0x037c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:662:0x0396 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:0x03ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:664:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:665:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:669:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:670:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:671:0x0310 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:672:0x02dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:673:0x02c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:674:0x0254 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:675:0x0281 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:676:0x02a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:677:0x030a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:678:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:679:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:680:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:681:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:682:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:683:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:684:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:685:0x0460 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:686:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:687:0x0457 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:688:0x040f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:689:0x0aff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:690:0x0af1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:691:0x0d71 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:692:0x0465 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:693:0x0b0c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x01da  */
    /* JADX WARN: Code duplicated, block: B:707:0x0adc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:709:0x058b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:710:0x0527 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:712:0x058b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:718:0x062c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x01e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:720:0x0616 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:722:0x069a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:724:0x06ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:725:0x0694 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:731:0x0763 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:732:0x0752 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:733:0x074e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:739:0x07d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:740:0x07b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:741:0x07af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:750:0x0946 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:755:0x0946 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:758:0x0946 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:761:0x09be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:764:0x0960 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:767:0x0ab9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:769:0x0215 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:772:0x023b A[EDGE_INSN: B:772:0x023b->B:88:0x023b BREAK  A[LOOP:26: B:84:0x0228->B:87:0x0232], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0203  */
    /* JADX WARN: Code duplicated, block: B:79:0x020b A[LOOP:24: B:76:0x0201->B:79:0x020b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:81:0x0217  */
    /* JADX WARN: Code duplicated, block: B:83:0x0221  */
    /* JADX WARN: Code duplicated, block: B:85:0x022a  */
    /* JADX WARN: Code duplicated, block: B:87:0x0232 A[LOOP:26: B:84:0x0228->B:87:0x0232, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:89:0x023f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0245 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0247  */
    /* JADX WARN: Code duplicated, block: B:95:0x025c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0264  */
    /* JADX WARN: Code duplicated, block: B:99:0x0268  */
    final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzfz zzfzVar) throws IOException {
        Unsafe unsafe;
        int i4;
        int i5;
        int iZzi;
        int i6;
        int i7;
        int iZzq;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        zzfz zzfzVar2;
        int i13;
        int i14;
        zzgw zzgwVar;
        zzim zzimVar;
        zzgw zzgwVar2;
        int i15;
        int[] iArr;
        int i16;
        int i17;
        int iZzr;
        long j;
        int i18;
        String str;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        boolean z;
        int i25;
        int i26;
        int i27;
        int i28;
        int iZzh;
        int i29;
        int length;
        int i30;
        char[] cArr;
        int i31;
        int i32;
        int i33;
        byte b;
        int i34;
        int i35;
        String str2;
        byte b2;
        byte b3;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        int i41;
        int i42;
        Unsafe unsafe2;
        zzfz zzfzVar3;
        int i43;
        Unsafe unsafe3;
        zzfz zzfzVar4;
        int i44;
        zzho zzhoVarZzd;
        int size;
        int i45;
        long j2;
        Unsafe unsafe4;
        Unsafe unsafe5;
        zzho zzhoVarZzd2;
        zzho zzhoVar;
        int i46;
        int i47;
        int i48;
        int i49;
        int i50;
        zzgt zzgtVar;
        int iZzh2;
        zzgt zzgtVar2;
        int iZzh3;
        int i51;
        int i52;
        int i53;
        zzhd zzhdVar;
        int iZzh4;
        zzhd zzhdVar2;
        int iZzh5;
        int i54;
        int i55;
        int i56;
        zzib zzibVar;
        int iZzh6;
        zzib zzibVar2;
        int i57;
        int i58;
        int i59;
        zzib zzibVar3;
        int iZzh7;
        zzib zzibVar4;
        int i60;
        int i61;
        zzhl zzhlVar;
        int iZzh8;
        zzhl zzhlVar2;
        int i62;
        int i63;
        zzgb zzgbVar;
        boolean z2;
        int iZzh9;
        boolean z3;
        zzgb zzgbVar2;
        int i64;
        boolean z4;
        int iZzh10;
        int i65;
        int i66;
        int iZzh11;
        int i67;
        int i68;
        int i69;
        Object obj2;
        int iZzh12;
        int i70;
        int i71;
        int i72;
        int i73;
        int iZzh13;
        int i74;
        int iZzj;
        zzhm zzhmVarZzu;
        zzjj zzjjVar;
        int i75;
        int i76;
        Iterator it;
        Object objZzn;
        int iIntValue;
        int size2;
        Object objZzn2;
        int i77;
        int i78;
        int iIntValue2;
        zzhl zzhlVar3;
        int iZzh14;
        zzhl zzhlVar4;
        int i79;
        zzib zzibVar5;
        int iZzh15;
        zzib zzibVar6;
        int i80;
        int i81;
        zzix zzixVarZzv;
        int iZzh16;
        Unsafe unsafe6;
        Object object;
        Unsafe unsafe7;
        long j3;
        int i82;
        int iZzk;
        boolean z5;
        int i83;
        int i84;
        int i85;
        int i86;
        zzhm zzhmVarZzu2;
        Object obj3 = obj;
        int i87 = i2;
        i3 = i3;
        zzfz zzfzVar5 = zzfzVar;
        zzA(obj);
        Unsafe unsafe8 = zzb;
        int i88 = 0;
        int iZzg = i;
        int i89 = 0;
        int i90 = 0;
        int i91 = 0;
        int i92 = -1;
        int i93 = 1048575;
        while (true) {
            if (iZzg < i87) {
                int i94 = iZzg + 1;
                int i95 = bArr[iZzg];
                if (i95 < 0) {
                    iZzi = zzga.zzi(i95, bArr, i94, zzfzVar5);
                    i5 = zzfzVar5.zza;
                } else {
                    i5 = i95;
                    iZzi = i94;
                }
                int i96 = i5 >>> 3;
                if (i96 > i92) {
                    iZzq = (i96 < this.zze || i96 > this.zzf) ? -1 : zzq(i96, i89 / 3);
                } else {
                    if (i96 < this.zze || i96 > this.zzf) {
                        i6 = -1;
                        i7 = -1;
                    } else {
                        iZzq = zzq(i96, i88);
                    }
                    if (i7 == i6) {
                        i15 = i5 & 7;
                        iArr = this.zzc;
                        i16 = iArr[i7 + 1];
                        i17 = i5;
                        iZzr = zzr(i16);
                        j = i16 & 1048575;
                        i18 = i96;
                        str = "Protocol message had invalid UTF-8.";
                        if (iZzr <= 17) {
                            int i97 = iArr[i7 + 2];
                            i19 = 1 << (i97 >>> 20);
                            i20 = i97 & 1048575;
                            if (i20 != i93) {
                                if (i93 != 1048575) {
                                    unsafe8.putInt(obj3, i93, i91);
                                }
                                if (i20 == 1048575) {
                                    i91 = 0;
                                } else {
                                    i91 = unsafe8.getInt(obj3, i20);
                                }
                                i10 = i20;
                            } else {
                                i10 = i93;
                            }
                            switch (iZzr) {
                                case 0:
                                    i21 = iZzi;
                                    i22 = i7;
                                    i88 = 0;
                                    if (i15 == 1) {
                                        iZzg = i21 + 8;
                                        i91 |= i19;
                                        zzjq.zzo(obj3, j, Double.longBitsToDouble(zzga.zzn(bArr, i21)));
                                        i89 = i22;
                                        i93 = i10;
                                        i90 = i17;
                                        i92 = i18;
                                        i87 = i2;
                                    } else {
                                        i23 = i21;
                                        i12 = i88;
                                        i24 = i22;
                                        i9 = i91;
                                        unsafe = unsafe8;
                                        i88 = i24;
                                        zzfzVar2 = zzfzVar5;
                                        i13 = i17;
                                        i11 = i18;
                                        i8 = i23;
                                        i4 = i3;
                                    }
                                    break;
                                case 1:
                                    i21 = iZzi;
                                    i22 = i7;
                                    i88 = 0;
                                    if (i15 == 5) {
                                        iZzg = i21 + 4;
                                        i91 |= i19;
                                        zzjq.zzp(obj3, j, Float.intBitsToFloat(zzga.zzb(bArr, i21)));
                                        i89 = i22;
                                        i93 = i10;
                                        i90 = i17;
                                        i92 = i18;
                                        i87 = i2;
                                    } else {
                                        i23 = i21;
                                        i12 = i88;
                                        i24 = i22;
                                        i9 = i91;
                                        unsafe = unsafe8;
                                        i88 = i24;
                                        zzfzVar2 = zzfzVar5;
                                        i13 = i17;
                                        i11 = i18;
                                        i8 = i23;
                                        i4 = i3;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    i21 = iZzi;
                                    i22 = i7;
                                    i88 = 0;
                                    if (i15 == 0) {
                                        int i98 = i91 | i19;
                                        int iZzk2 = zzga.zzk(bArr, i21, zzfzVar5);
                                        unsafe8.putLong(obj, j, zzfzVar5.zzb);
                                        i91 = i98;
                                        iZzg = iZzk2;
                                        i89 = i22;
                                        i93 = i10;
                                        i90 = i17;
                                        i92 = i18;
                                        i87 = i2;
                                    } else {
                                        i23 = i21;
                                        i12 = i88;
                                        i24 = i22;
                                        i9 = i91;
                                        unsafe = unsafe8;
                                        i88 = i24;
                                        zzfzVar2 = zzfzVar5;
                                        i13 = i17;
                                        i11 = i18;
                                        i8 = i23;
                                        i4 = i3;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    i21 = iZzi;
                                    i22 = i7;
                                    i88 = 0;
                                    if (i15 == 0) {
                                        i91 |= i19;
                                        iZzg = zzga.zzh(bArr, i21, zzfzVar5);
                                        unsafe8.putInt(obj3, j, zzfzVar5.zza);
                                        i89 = i22;
                                        i93 = i10;
                                        i90 = i17;
                                        i92 = i18;
                                        i87 = i2;
                                    } else {
                                        i23 = i21;
                                        i12 = i88;
                                        i24 = i22;
                                        i9 = i91;
                                        unsafe = unsafe8;
                                        i88 = i24;
                                        zzfzVar2 = zzfzVar5;
                                        i13 = i17;
                                        i11 = i18;
                                        i8 = i23;
                                        i4 = i3;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    i21 = iZzi;
                                    i22 = i7;
                                    i88 = 0;
                                    if (i15 == 1) {
                                        unsafe8.putLong(obj, j, zzga.zzn(bArr, i21));
                                        iZzg = i21 + 8;
                                        i91 = i19 | i91;
                                        i89 = i22;
                                        i93 = i10;
                                        i90 = i17;
                                        i92 = i18;
                                        i87 = i2;
                                    } else {
                                        i23 = i21;
                                        i12 = i88;
                                        i24 = i22;
                                        i9 = i91;
                                        unsafe = unsafe8;
                                        i88 = i24;
                                        zzfzVar2 = zzfzVar5;
                                        i13 = i17;
                                        i11 = i18;
                                        i8 = i23;
                                        i4 = i3;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    i21 = iZzi;
                                    i22 = i7;
                                    i88 = 0;
                                    if (i15 == 5) {
                                        iZzg = i21 + 4;
                                        i91 |= i19;
                                        unsafe8.putInt(obj3, j, zzga.zzb(bArr, i21));
                                        i89 = i22;
                                        i93 = i10;
                                        i90 = i17;
                                        i92 = i18;
                                        i87 = i2;
                                    } else {
                                        i23 = i21;
                                        i12 = i88;
                                        i24 = i22;
                                        i9 = i91;
                                        unsafe = unsafe8;
                                        i88 = i24;
                                        zzfzVar2 = zzfzVar5;
                                        i13 = i17;
                                        i11 = i18;
                                        i8 = i23;
                                        i4 = i3;
                                    }
                                    break;
                                case 7:
                                    i21 = iZzi;
                                    i22 = i7;
                                    i88 = 0;
                                    if (i15 == 0) {
                                        i91 |= i19;
                                        iZzg = zzga.zzk(bArr, i21, zzfzVar5);
                                        if (zzfzVar5.zzb != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        zzjq.zzm(obj3, j, z);
                                        i89 = i22;
                                        i93 = i10;
                                        i90 = i17;
                                        i92 = i18;
                                        i87 = i2;
                                    } else {
                                        i23 = i21;
                                        i12 = i88;
                                        i24 = i22;
                                        i9 = i91;
                                        unsafe = unsafe8;
                                        i88 = i24;
                                        zzfzVar2 = zzfzVar5;
                                        i13 = i17;
                                        i11 = i18;
                                        i8 = i23;
                                        i4 = i3;
                                    }
                                    break;
                                case 8:
                                    i25 = iZzi;
                                    i22 = i7;
                                    i26 = i17;
                                    if (i15 == 2) {
                                        if ((i16 & 536870912) != 0) {
                                            i28 = i91 | i19;
                                            iZzh = zzga.zzh(bArr, i25, zzfzVar5);
                                            i29 = zzfzVar5.zza;
                                            if (i29 >= 0) {
                                                throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            if (i29 == 0) {
                                                zzfzVar5.zzc = "";
                                                i32 = i28;
                                                i17 = i26;
                                                i88 = 0;
                                            } else {
                                                int i99 = zzjt.zza;
                                                length = bArr.length;
                                                if ((((length - iZzh) - i29) | iZzh | i29) >= 0) {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzh), Integer.valueOf(i29)));
                                                }
                                                i30 = iZzh + i29;
                                                cArr = new char[i29];
                                                i31 = 0;
                                                while (iZzh < i30) {
                                                    b3 = bArr[iZzh];
                                                    if (zzjr.zzd(b3)) {
                                                        iZzh++;
                                                        cArr[i31] = (char) b3;
                                                        i31++;
                                                    } else {
                                                        while (iZzh < i30) {
                                                            i33 = iZzh + 1;
                                                            b = bArr[iZzh];
                                                            if (zzjr.zzd(b)) {
                                                                cArr[i31] = (char) b;
                                                                i31++;
                                                                iZzh = i33;
                                                                while (iZzh < i30) {
                                                                    b2 = bArr[iZzh];
                                                                    if (zzjr.zzd(b2)) {
                                                                    }
                                                                    iZzh++;
                                                                    cArr[i31] = (char) b2;
                                                                    i31++;
                                                                    break;
                                                                }
                                                            } else {
                                                                i34 = i28;
                                                                if (b < -32) {
                                                                    i35 = i26;
                                                                    str2 = str;
                                                                    if (b < -16) {
                                                                        if (i33 < i30 - 1) {
                                                                            throw new zzhr(str2);
                                                                        }
                                                                        zzjr.zzb(b, bArr[i33], bArr[iZzh + 2], cArr, i31);
                                                                        str = str2;
                                                                        i31++;
                                                                        i28 = i34;
                                                                        i26 = i35;
                                                                        iZzh += 3;
                                                                    } else {
                                                                        if (i33 < i30 - 2) {
                                                                            throw new zzhr(str2);
                                                                        }
                                                                        byte b4 = bArr[i33];
                                                                        int i100 = iZzh + 3;
                                                                        byte b5 = bArr[iZzh + 2];
                                                                        iZzh += 4;
                                                                        zzjr.zza(b, b4, b5, bArr[i100], cArr, i31);
                                                                        i31 += 2;
                                                                        str = str2;
                                                                        i28 = i34;
                                                                        i26 = i35;
                                                                    }
                                                                } else {
                                                                    if (i33 < i30) {
                                                                        throw new zzhr(str);
                                                                    }
                                                                    iZzh += 2;
                                                                    zzjr.zzc(b, bArr[i33], cArr, i31);
                                                                    i31++;
                                                                    i28 = i34;
                                                                }
                                                            }
                                                        }
                                                        i32 = i28;
                                                        i17 = i26;
                                                        i88 = 0;
                                                        zzfzVar5.zzc = new String(cArr, 0, i31);
                                                        iZzh = i30;
                                                    }
                                                }
                                                while (iZzh < i30) {
                                                    i33 = iZzh + 1;
                                                    b = bArr[iZzh];
                                                    if (zzjr.zzd(b)) {
                                                        cArr[i31] = (char) b;
                                                        i31++;
                                                        iZzh = i33;
                                                        while (iZzh < i30) {
                                                            b2 = bArr[iZzh];
                                                            if (zzjr.zzd(b2)) {
                                                            }
                                                            iZzh++;
                                                            cArr[i31] = (char) b2;
                                                            i31++;
                                                            break;
                                                        }
                                                    } else {
                                                        i34 = i28;
                                                        if (b < -32) {
                                                            i35 = i26;
                                                            str2 = str;
                                                            if (b < -16) {
                                                                if (i33 < i30 - 1) {
                                                                    throw new zzhr(str2);
                                                                }
                                                                zzjr.zzb(b, bArr[i33], bArr[iZzh + 2], cArr, i31);
                                                                str = str2;
                                                                i31++;
                                                                i28 = i34;
                                                                i26 = i35;
                                                                iZzh += 3;
                                                            } else {
                                                                if (i33 < i30 - 2) {
                                                                    throw new zzhr(str2);
                                                                }
                                                                byte b6 = bArr[i33];
                                                                int i101 = iZzh + 3;
                                                                byte b7 = bArr[iZzh + 2];
                                                                iZzh += 4;
                                                                zzjr.zza(b, b6, b7, bArr[i101], cArr, i31);
                                                                i31 += 2;
                                                                str = str2;
                                                                i28 = i34;
                                                                i26 = i35;
                                                            }
                                                        } else {
                                                            if (i33 < i30) {
                                                                throw new zzhr(str);
                                                            }
                                                            iZzh += 2;
                                                            zzjr.zzc(b, bArr[i33], cArr, i31);
                                                            i31++;
                                                            i28 = i34;
                                                        }
                                                    }
                                                }
                                                i32 = i28;
                                                i17 = i26;
                                                i88 = 0;
                                                zzfzVar5.zzc = new String(cArr, 0, i31);
                                                iZzh = i30;
                                            }
                                            iZzg = iZzh;
                                            i91 = i32;
                                        } else {
                                            i17 = i26;
                                            i88 = 0;
                                            iZzg = zzga.zzh(bArr, i25, zzfzVar5);
                                            i27 = zzfzVar5.zza;
                                            if (i27 >= 0) {
                                                throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            i91 |= i19;
                                            if (i27 == 0) {
                                                zzfzVar5.zzc = "";
                                            } else {
                                                zzfzVar5.zzc = new String(bArr, iZzg, i27, zzhp.zza);
                                                iZzg += i27;
                                            }
                                        }
                                        unsafe8.putObject(obj3, j, zzfzVar5.zzc);
                                        i89 = i22;
                                        i93 = i10;
                                        i90 = i17;
                                        i92 = i18;
                                        i87 = i2;
                                    } else {
                                        i23 = i25;
                                        i17 = i26;
                                        i24 = i22;
                                        i12 = 0;
                                        i9 = i91;
                                        unsafe = unsafe8;
                                        i88 = i24;
                                        zzfzVar2 = zzfzVar5;
                                        i13 = i17;
                                        i11 = i18;
                                        i8 = i23;
                                        i4 = i3;
                                    }
                                    break;
                                case 9:
                                    i36 = i7;
                                    i37 = i17;
                                    if (i15 == 2) {
                                        int i102 = i91 | i19;
                                        Object objZzx = zzx(obj3, i36);
                                        iZzg = zzga.zzm(objZzx, zzv(i36), bArr, iZzi, i2, zzfzVar);
                                        zzF(obj3, i36, objZzx);
                                        i91 = i102;
                                        i90 = i37;
                                        i89 = i36;
                                        i93 = i10;
                                        i92 = i18;
                                        i88 = 0;
                                        i87 = i2;
                                        i3 = i3;
                                    } else {
                                        i23 = iZzi;
                                        i91 = i91;
                                        unsafe8 = unsafe8;
                                        i17 = i37;
                                        i24 = i36;
                                        i18 = i18;
                                        i12 = 0;
                                        i9 = i91;
                                        unsafe = unsafe8;
                                        i88 = i24;
                                        zzfzVar2 = zzfzVar5;
                                        i13 = i17;
                                        i11 = i18;
                                        i8 = i23;
                                        i4 = i3;
                                    }
                                    break;
                                case 10:
                                    i36 = i7;
                                    i37 = i17;
                                    if (i15 == 2) {
                                        i91 |= i19;
                                        iZzg = zzga.zza(bArr, iZzi, zzfzVar5);
                                        unsafe8.putObject(obj3, j, zzfzVar5.zzc);
                                        i90 = i37;
                                        i89 = i36;
                                        i93 = i10;
                                        i92 = i18;
                                        i88 = 0;
                                        i87 = i2;
                                        i3 = i3;
                                    } else {
                                        i23 = iZzi;
                                        i91 = i91;
                                        unsafe8 = unsafe8;
                                        i17 = i37;
                                        i24 = i36;
                                        i18 = i18;
                                        i12 = 0;
                                        i9 = i91;
                                        unsafe = unsafe8;
                                        i88 = i24;
                                        zzfzVar2 = zzfzVar5;
                                        i13 = i17;
                                        i11 = i18;
                                        i8 = i23;
                                        i4 = i3;
                                    }
                                    break;
                                case 12:
                                    i36 = i7;
                                    i37 = i17;
                                    if (i15 == 0) {
                                        iZzg = zzga.zzh(bArr, iZzi, zzfzVar5);
                                        i38 = zzfzVar5.zza;
                                        zzhm zzhmVarZzu3 = zzu(i36);
                                        if ((i16 & Integer.MIN_VALUE) != 0 || zzhmVarZzu3 == null || zzhmVarZzu3.zza(i38)) {
                                            i91 |= i19;
                                            unsafe8.putInt(obj3, j, i38);
                                        } else {
                                            zzd(obj).zzj(i37, Long.valueOf(i38));
                                        }
                                        i90 = i37;
                                        i89 = i36;
                                        i93 = i10;
                                        i92 = i18;
                                        i88 = 0;
                                        i87 = i2;
                                        i3 = i3;
                                    } else {
                                        i23 = iZzi;
                                        i91 = i91;
                                        unsafe8 = unsafe8;
                                        i17 = i37;
                                        i24 = i36;
                                        i18 = i18;
                                        i12 = 0;
                                        i9 = i91;
                                        unsafe = unsafe8;
                                        i88 = i24;
                                        zzfzVar2 = zzfzVar5;
                                        i13 = i17;
                                        i11 = i18;
                                        i8 = i23;
                                        i4 = i3;
                                    }
                                    break;
                                case 15:
                                    i36 = i7;
                                    i37 = i17;
                                    if (i15 == 0) {
                                        i91 |= i19;
                                        iZzg = zzga.zzh(bArr, iZzi, zzfzVar5);
                                        unsafe8.putInt(obj3, j, zzgn.zzb(zzfzVar5.zza));
                                        i90 = i37;
                                        i89 = i36;
                                        i93 = i10;
                                        i92 = i18;
                                        i88 = 0;
                                        i87 = i2;
                                        i3 = i3;
                                    } else {
                                        i23 = iZzi;
                                        i91 = i91;
                                        unsafe8 = unsafe8;
                                        i17 = i37;
                                        i24 = i36;
                                        i18 = i18;
                                        i12 = 0;
                                        i9 = i91;
                                        unsafe = unsafe8;
                                        i88 = i24;
                                        zzfzVar2 = zzfzVar5;
                                        i13 = i17;
                                        i11 = i18;
                                        i8 = i23;
                                        i4 = i3;
                                    }
                                    break;
                                case 16:
                                    if (i15 == 0) {
                                        int i103 = i91 | i19;
                                        int iZzk3 = zzga.zzk(bArr, iZzi, zzfzVar5);
                                        i36 = i7;
                                        i37 = i17;
                                        unsafe8.putLong(obj, j, zzgn.zzc(zzfzVar5.zzb));
                                        i91 = i103;
                                        iZzg = iZzk3;
                                        i90 = i37;
                                        i89 = i36;
                                        i93 = i10;
                                        i92 = i18;
                                        i88 = 0;
                                        i87 = i2;
                                        i3 = i3;
                                    } else {
                                        i23 = iZzi;
                                        i91 = i91;
                                        unsafe8 = unsafe8;
                                        i12 = 0;
                                        i24 = i7;
                                        i18 = i18;
                                        i9 = i91;
                                        unsafe = unsafe8;
                                        i88 = i24;
                                        zzfzVar2 = zzfzVar5;
                                        i13 = i17;
                                        i11 = i18;
                                        i8 = i23;
                                        i4 = i3;
                                    }
                                    break;
                                default:
                                    i21 = iZzi;
                                    i22 = i7;
                                    i88 = 0;
                                    if (i15 == 3) {
                                        Object objZzx2 = zzx(obj3, i22);
                                        int iZzl = zzga.zzl(objZzx2, zzv(i22), bArr, i21, i2, (i18 << 3) | 4, zzfzVar);
                                        zzF(obj3, i22, objZzx2);
                                        i3 = i3;
                                        zzfzVar5 = zzfzVar;
                                        i92 = i18;
                                        unsafe8 = unsafe8;
                                        i89 = i22;
                                        i87 = i2;
                                        iZzg = iZzl;
                                        i93 = i10;
                                        i90 = i17;
                                        i88 = 0;
                                        i91 |= i19;
                                    } else {
                                        i23 = i21;
                                        i12 = i88;
                                        i24 = i22;
                                        i9 = i91;
                                        unsafe = unsafe8;
                                        i88 = i24;
                                        zzfzVar2 = zzfzVar5;
                                        i13 = i17;
                                        i11 = i18;
                                        i8 = i23;
                                        i4 = i3;
                                    }
                                    break;
                            }
                        } else {
                            i39 = iZzi;
                            i10 = i93;
                            i12 = 0;
                            i40 = i2;
                            i41 = i18;
                            i9 = i91;
                            i42 = i7;
                            zzfz zzfzVar6 = zzfzVar5;
                            unsafe2 = unsafe8;
                            zzfzVar3 = zzfzVar6;
                            if (iZzr == 27) {
                                if (iZzr <= 49) {
                                    j2 = i16;
                                    unsafe4 = zzb;
                                    unsafe5 = unsafe2;
                                    zzhoVarZzd2 = (zzho) unsafe4.getObject(obj3, j);
                                    if (!zzhoVarZzd2.zzc()) {
                                        int size3 = zzhoVarZzd2.size();
                                        zzhoVarZzd2 = zzhoVarZzd2.zzd(size3 + size3);
                                        unsafe4.putObject(obj3, j, zzhoVarZzd2);
                                    }
                                    zzhoVar = zzhoVarZzd2;
                                    switch (iZzr) {
                                        case 18:
                                        case 35:
                                            i46 = i40;
                                            zzfzVar3 = zzfzVar3;
                                            i47 = i17;
                                            i48 = i39;
                                            i49 = i41;
                                            unsafe5 = unsafe5;
                                            i50 = i42;
                                            if (i15 == 2) {
                                                i42 = i50;
                                                if (i15 == 1) {
                                                    iZzg = i48 + 8;
                                                    int i104 = zzga.zza;
                                                    zzgtVar = (zzgt) zzhoVar;
                                                    zzgtVar.zzf(Double.longBitsToDouble(zzga.zzn(bArr, i48)));
                                                    while (iZzg < i46) {
                                                        iZzh2 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                        if (i47 == zzfzVar3.zza) {
                                                            zzgtVar.zzf(Double.longBitsToDouble(zzga.zzn(bArr, iZzh2)));
                                                            iZzg = iZzh2 + 8;
                                                        }
                                                    }
                                                }
                                                i56 = i42;
                                                iZzg = i48;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            } else {
                                                int i105 = zzga.zza;
                                                zzgtVar2 = (zzgt) zzhoVar;
                                                iZzh3 = zzga.zzh(bArr, i48, zzfzVar3);
                                                i51 = zzfzVar3.zza;
                                                i52 = iZzh3 + i51;
                                                if (i52 <= bArr.length) {
                                                    throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzgtVar2.zzg(zzgtVar2.size() + (i51 / 8));
                                                while (iZzh3 < i52) {
                                                    zzgtVar2.zzf(Double.longBitsToDouble(zzga.zzn(bArr, iZzh3)));
                                                    iZzh3 += 8;
                                                    i50 = i50;
                                                }
                                                i42 = i50;
                                                if (iZzh3 == i52) {
                                                    throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                iZzg = iZzh3;
                                            }
                                            i56 = i42;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                            break;
                                        case 19:
                                        case 36:
                                            i46 = i40;
                                            zzfzVar3 = zzfzVar3;
                                            i47 = i17;
                                            i48 = i39;
                                            i49 = i41;
                                            unsafe5 = unsafe5;
                                            i53 = i42;
                                            if (i15 == 2) {
                                                if (i15 == 5) {
                                                    iZzg = i48 + 4;
                                                    int i106 = zzga.zza;
                                                    zzhdVar = (zzhd) zzhoVar;
                                                    zzhdVar.zzf(Float.intBitsToFloat(zzga.zzb(bArr, i48)));
                                                    while (iZzg < i46) {
                                                        iZzh4 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                        if (i47 == zzfzVar3.zza) {
                                                            zzhdVar.zzf(Float.intBitsToFloat(zzga.zzb(bArr, iZzh4)));
                                                            iZzg = iZzh4 + 4;
                                                        }
                                                    }
                                                }
                                                i56 = i53;
                                                iZzg = i48;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            } else {
                                                int i107 = zzga.zza;
                                                zzhdVar2 = (zzhd) zzhoVar;
                                                iZzh5 = zzga.zzh(bArr, i48, zzfzVar3);
                                                i54 = zzfzVar3.zza;
                                                i55 = iZzh5 + i54;
                                                if (i55 <= bArr.length) {
                                                    throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzhdVar2.zzg(zzhdVar2.size() + (i54 / 4));
                                                while (iZzh5 < i55) {
                                                    zzhdVar2.zzf(Float.intBitsToFloat(zzga.zzb(bArr, iZzh5)));
                                                    iZzh5 += 4;
                                                }
                                                if (iZzh5 != i55) {
                                                    throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                iZzg = iZzh5;
                                            }
                                            i56 = i53;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            i46 = i40;
                                            zzfzVar3 = zzfzVar3;
                                            i47 = i17;
                                            i48 = i39;
                                            i49 = i41;
                                            unsafe5 = unsafe5;
                                            i53 = i42;
                                            if (i15 == 2) {
                                                if (i15 == 0) {
                                                    int i108 = zzga.zza;
                                                    zzibVar = (zzib) zzhoVar;
                                                    iZzh5 = zzga.zzk(bArr, i48, zzfzVar3);
                                                    zzibVar.zzf(zzfzVar3.zzb);
                                                    while (iZzh5 < i46) {
                                                        iZzh6 = zzga.zzh(bArr, iZzh5, zzfzVar3);
                                                        if (i47 == zzfzVar3.zza) {
                                                            iZzh5 = zzga.zzk(bArr, iZzh6, zzfzVar3);
                                                            zzibVar.zzf(zzfzVar3.zzb);
                                                        }
                                                    }
                                                }
                                                i56 = i53;
                                                iZzg = i48;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            } else {
                                                int i109 = zzga.zza;
                                                zzibVar2 = (zzib) zzhoVar;
                                                iZzh5 = zzga.zzh(bArr, i48, zzfzVar3);
                                                i57 = zzfzVar3.zza + iZzh5;
                                                while (iZzh5 < i57) {
                                                    iZzh5 = zzga.zzk(bArr, iZzh5, zzfzVar3);
                                                    zzibVar2.zzf(zzfzVar3.zzb);
                                                }
                                                if (iZzh5 != i57) {
                                                    throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            iZzg = iZzh5;
                                            i56 = i53;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            i58 = i40;
                                            zzfzVar3 = zzfzVar3;
                                            i47 = i17;
                                            i48 = i39;
                                            unsafe5 = unsafe5;
                                            i59 = i42;
                                            if (i15 == 2) {
                                                iZzg = zzga.zzf(bArr, i48, zzhoVar, zzfzVar3);
                                                i46 = i58;
                                                i56 = i59;
                                                i49 = i41;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            } else if (i15 == 0) {
                                                i46 = i58;
                                                i49 = i41;
                                                i53 = i59;
                                                iZzg = zzga.zzj(i47, bArr, i48, i2, zzhoVar, zzfzVar);
                                                i56 = i53;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            } else {
                                                i46 = i58;
                                                i49 = i41;
                                                i56 = i59;
                                                iZzg = i48;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            i58 = i40;
                                            zzfzVar3 = zzfzVar3;
                                            i47 = i17;
                                            i48 = i39;
                                            unsafe5 = unsafe5;
                                            i59 = i42;
                                            if (i15 == 2) {
                                                if (i15 == 1) {
                                                    iZzg = i48 + 8;
                                                    int i110 = zzga.zza;
                                                    zzibVar3 = (zzib) zzhoVar;
                                                    zzibVar3.zzf(zzga.zzn(bArr, i48));
                                                    while (iZzg < i58) {
                                                        iZzh7 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                        if (i47 == zzfzVar3.zza) {
                                                            zzibVar3.zzf(zzga.zzn(bArr, iZzh7));
                                                            iZzg = iZzh7 + 8;
                                                        }
                                                    }
                                                }
                                                i46 = i58;
                                                i56 = i59;
                                                i49 = i41;
                                                iZzg = i48;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            } else {
                                                int i111 = zzga.zza;
                                                zzibVar4 = (zzib) zzhoVar;
                                                iZzg = zzga.zzh(bArr, i48, zzfzVar3);
                                                i60 = zzfzVar3.zza;
                                                i61 = iZzg + i60;
                                                if (i61 <= bArr.length) {
                                                    throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzibVar4.zzg(zzibVar4.size() + (i60 / 8));
                                                while (iZzg < i61) {
                                                    zzibVar4.zzf(zzga.zzn(bArr, iZzg));
                                                    iZzg += 8;
                                                }
                                                if (iZzg != i61) {
                                                    throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i46 = i58;
                                            i56 = i59;
                                            i49 = i41;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            i58 = i40;
                                            zzfzVar3 = zzfzVar3;
                                            i47 = i17;
                                            i48 = i39;
                                            unsafe5 = unsafe5;
                                            i59 = i42;
                                            if (i15 == 2) {
                                                if (i15 == 5) {
                                                    iZzg = i48 + 4;
                                                    int i112 = zzga.zza;
                                                    zzhlVar = (zzhl) zzhoVar;
                                                    zzhlVar.zzg(zzga.zzb(bArr, i48));
                                                    while (iZzg < i58) {
                                                        iZzh8 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                        if (i47 == zzfzVar3.zza) {
                                                            zzhlVar.zzg(zzga.zzb(bArr, iZzh8));
                                                            iZzg = iZzh8 + 4;
                                                        }
                                                    }
                                                }
                                                i46 = i58;
                                                i56 = i59;
                                                i49 = i41;
                                                iZzg = i48;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            } else {
                                                int i113 = zzga.zza;
                                                zzhlVar2 = (zzhl) zzhoVar;
                                                iZzg = zzga.zzh(bArr, i48, zzfzVar3);
                                                i62 = zzfzVar3.zza;
                                                i63 = iZzg + i62;
                                                if (i63 <= bArr.length) {
                                                    throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzhlVar2.zzh(zzhlVar2.size() + (i62 / 4));
                                                while (iZzg < i63) {
                                                    zzhlVar2.zzg(zzga.zzb(bArr, iZzg));
                                                    iZzg += 4;
                                                }
                                                if (iZzg != i63) {
                                                    throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i46 = i58;
                                            i56 = i59;
                                            i49 = i41;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            i58 = i40;
                                            zzfzVar3 = zzfzVar3;
                                            i47 = i17;
                                            i48 = i39;
                                            unsafe5 = unsafe5;
                                            i59 = i42;
                                            if (i15 == 2) {
                                                if (i15 == 0) {
                                                    int i114 = zzga.zza;
                                                    zzgbVar = (zzgb) zzhoVar;
                                                    iZzg = zzga.zzk(bArr, i48, zzfzVar3);
                                                    if (zzfzVar3.zzb != 0) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = false;
                                                    }
                                                    zzgbVar.zze(z2);
                                                    while (iZzg < i58) {
                                                        iZzh9 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                        if (i47 == zzfzVar3.zza) {
                                                            iZzg = zzga.zzk(bArr, iZzh9, zzfzVar3);
                                                            if (zzfzVar3.zzb != 0) {
                                                                z3 = true;
                                                            } else {
                                                                z3 = false;
                                                            }
                                                            zzgbVar.zze(z3);
                                                        }
                                                    }
                                                }
                                                i46 = i58;
                                                i56 = i59;
                                                i49 = i41;
                                                iZzg = i48;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            } else {
                                                int i115 = zzga.zza;
                                                zzgbVar2 = (zzgb) zzhoVar;
                                                iZzg = zzga.zzh(bArr, i48, zzfzVar3);
                                                i64 = zzfzVar3.zza + iZzg;
                                                while (iZzg < i64) {
                                                    iZzg = zzga.zzk(bArr, iZzg, zzfzVar3);
                                                    if (zzfzVar3.zzb != 0) {
                                                        z4 = true;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    zzgbVar2.zze(z4);
                                                }
                                                if (iZzg != i64) {
                                                    throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i46 = i58;
                                            i56 = i59;
                                            i49 = i41;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                            break;
                                        case 26:
                                            zzfzVar3 = zzfzVar3;
                                            i47 = i17;
                                            i48 = i39;
                                            i59 = i42;
                                            if (i15 == 2) {
                                                unsafe5 = unsafe5;
                                                i46 = i40;
                                                i49 = i41;
                                                i56 = i59;
                                                iZzg = i48;
                                            } else if ((j2 & 536870912) == 0) {
                                                iZzg = zzga.zzh(bArr, i48, zzfzVar3);
                                                i69 = zzfzVar3.zza;
                                                if (i69 >= 0) {
                                                    throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i69 == 0) {
                                                    obj2 = "";
                                                    zzhoVar.add(obj2);
                                                } else {
                                                    obj2 = "";
                                                    zzhoVar.add(new String(bArr, iZzg, i69, zzhp.zza));
                                                    iZzg += i69;
                                                }
                                                while (iZzg < i40) {
                                                    iZzh12 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                    if (i47 == zzfzVar3.zza) {
                                                        iZzg = zzga.zzh(bArr, iZzh12, zzfzVar3);
                                                        i70 = zzfzVar3.zza;
                                                        if (i70 >= 0) {
                                                            throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i70 == 0) {
                                                            zzhoVar.add(obj2);
                                                        } else {
                                                            zzhoVar.add(new String(bArr, iZzg, i70, zzhp.zza));
                                                            iZzg += i70;
                                                        }
                                                    } else {
                                                        unsafe5 = unsafe5;
                                                        i46 = i40;
                                                        i49 = i41;
                                                        i56 = i59;
                                                    }
                                                }
                                                unsafe5 = unsafe5;
                                                i46 = i40;
                                                i49 = i41;
                                                i56 = i59;
                                            } else {
                                                iZzh10 = zzga.zzh(bArr, i48, zzfzVar3);
                                                i65 = zzfzVar3.zza;
                                                if (i65 >= 0) {
                                                    throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i65 == 0) {
                                                    zzhoVar.add("");
                                                } else {
                                                    i66 = iZzh10 + i65;
                                                    if (zzjt.zzd(bArr, iZzh10, i66)) {
                                                        throw new zzhr(str);
                                                    }
                                                    zzhoVar.add(new String(bArr, iZzh10, i65, zzhp.zza));
                                                    iZzh10 = i66;
                                                }
                                                while (iZzh10 < i40) {
                                                    iZzh11 = zzga.zzh(bArr, iZzh10, zzfzVar3);
                                                    if (i47 == zzfzVar3.zza) {
                                                        iZzh10 = zzga.zzh(bArr, iZzh11, zzfzVar3);
                                                        i67 = zzfzVar3.zza;
                                                        if (i67 >= 0) {
                                                            throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i67 == 0) {
                                                            zzhoVar.add("");
                                                        } else {
                                                            i68 = iZzh10 + i67;
                                                            if (zzjt.zzd(bArr, iZzh10, i68)) {
                                                                throw new zzhr(str);
                                                            }
                                                            zzhoVar.add(new String(bArr, iZzh10, i67, zzhp.zza));
                                                            iZzh10 = i68;
                                                        }
                                                    } else {
                                                        iZzg = iZzh10;
                                                        i46 = i40;
                                                        i56 = i59;
                                                        i49 = i41;
                                                        unsafe5 = unsafe5;
                                                    }
                                                }
                                                iZzg = iZzh10;
                                                i46 = i40;
                                                i56 = i59;
                                                i49 = i41;
                                                unsafe5 = unsafe5;
                                            }
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                            break;
                                        case 27:
                                            i40 = i40;
                                            i41 = i41;
                                            if (i15 == 2) {
                                                zzfzVar3 = zzfzVar3;
                                                i47 = i17;
                                                i48 = i39;
                                                unsafe5 = unsafe5;
                                                i49 = i41;
                                                i56 = i42;
                                                iZzg = zzga.zze(zzv(i42), i17, bArr, i39, i2, zzhoVar, zzfzVar);
                                                i46 = i40;
                                            } else {
                                                i56 = i42;
                                                i47 = i17;
                                                i48 = i39;
                                                int i116 = i40;
                                                i49 = i41;
                                                i46 = i116;
                                                iZzg = i48;
                                            }
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                            break;
                                        case 28:
                                            i40 = i40;
                                            i71 = i17;
                                            i72 = i39;
                                            i41 = i41;
                                            if (i15 == 2) {
                                                iZzg = zzga.zzh(bArr, i72, zzfzVar3);
                                                i73 = zzfzVar3.zza;
                                                if (i73 >= 0) {
                                                    throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i73 <= bArr.length - iZzg) {
                                                    throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                if (i73 == 0) {
                                                    zzhoVar.add(zzgk.zzb);
                                                } else {
                                                    zzhoVar.add(zzgk.zzj(bArr, iZzg, i73));
                                                    iZzg += i73;
                                                }
                                                while (iZzg < i40) {
                                                    iZzh13 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                    if (i71 == zzfzVar3.zza) {
                                                        i56 = i42;
                                                        i47 = i71;
                                                        i48 = i72;
                                                        int i117 = i40;
                                                        i49 = i41;
                                                        i46 = i117;
                                                        if (iZzg != i48) {
                                                            zzfzVar5 = zzfzVar3;
                                                            i92 = i49;
                                                            unsafe8 = unsafe5;
                                                            i90 = i47;
                                                            i93 = i10;
                                                            i88 = 0;
                                                            i91 = i9;
                                                            i89 = i56;
                                                            obj3 = obj;
                                                            i3 = i3;
                                                            i87 = i46;
                                                        } else {
                                                            i4 = i3;
                                                            i8 = iZzg;
                                                            i11 = i49;
                                                            unsafe = unsafe5;
                                                            i13 = i47;
                                                            i88 = i56;
                                                            zzfzVar2 = zzfzVar3;
                                                            obj3 = obj;
                                                        }
                                                        break;
                                                    } else {
                                                        iZzg = zzga.zzh(bArr, iZzh13, zzfzVar3);
                                                        i74 = zzfzVar3.zza;
                                                        if (i74 >= 0) {
                                                            throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i74 <= bArr.length - iZzg) {
                                                            throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                        if (i74 == 0) {
                                                            zzhoVar.add(zzgk.zzb);
                                                        } else {
                                                            zzhoVar.add(zzgk.zzj(bArr, iZzg, i74));
                                                            iZzg += i74;
                                                        }
                                                    }
                                                }
                                                i56 = i42;
                                                i47 = i71;
                                                i48 = i72;
                                                int i118 = i40;
                                                i49 = i41;
                                                i46 = i118;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            } else {
                                                i56 = i42;
                                                i47 = i71;
                                                i48 = i72;
                                                int i119 = i40;
                                                i49 = i41;
                                                i46 = i119;
                                                iZzg = i48;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            i71 = i17;
                                            i72 = i39;
                                            if (i15 == 2) {
                                                if (i15 == 0) {
                                                    iZzj = zzga.zzj(i71, bArr, i72, i2, zzhoVar, zzfzVar);
                                                }
                                                i46 = i40;
                                                zzfzVar3 = zzfzVar3;
                                                i49 = i41;
                                                unsafe5 = unsafe5;
                                                i56 = i42;
                                                i47 = i71;
                                                i48 = i72;
                                                iZzg = i48;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            } else {
                                                iZzj = zzga.zzf(bArr, i72, zzhoVar, zzfzVar3);
                                            }
                                            zzhmVarZzu = zzu(i42);
                                            zzjjVar = this.zzl;
                                            int i120 = zziz.zza;
                                            if (zzhmVarZzu != null) {
                                                i75 = iZzj;
                                                i76 = i42;
                                            } else if (zzhoVar instanceof RandomAccess) {
                                                size2 = zzhoVar.size();
                                                i75 = iZzj;
                                                objZzn2 = null;
                                                i77 = 0;
                                                i78 = 0;
                                                while (i77 < size2) {
                                                    int i121 = i42;
                                                    iIntValue2 = ((Integer) zzhoVar.get(i77)).intValue();
                                                    if (zzhmVarZzu.zza(iIntValue2)) {
                                                        if (i77 != i78) {
                                                            zzhoVar.set(i78, Integer.valueOf(iIntValue2));
                                                        }
                                                        i78++;
                                                    } else {
                                                        objZzn2 = zziz.zzn(obj3, i41, iIntValue2, objZzn2, zzjjVar);
                                                    }
                                                    i77++;
                                                    i42 = i121;
                                                }
                                                i76 = i42;
                                                if (i78 != size2) {
                                                    zzhoVar.subList(i78, size2).clear();
                                                }
                                            } else {
                                                i75 = iZzj;
                                                i76 = i42;
                                                it = zzhoVar.iterator();
                                                objZzn = null;
                                                while (it.hasNext()) {
                                                    iIntValue = ((Integer) it.next()).intValue();
                                                    if (!zzhmVarZzu.zza(iIntValue)) {
                                                        objZzn = zziz.zzn(obj3, i41, iIntValue, objZzn, zzjjVar);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            iZzg = i75;
                                            i56 = i76;
                                            i47 = i71;
                                            i48 = i72;
                                            int i1110 = i40;
                                            i49 = i41;
                                            i46 = i1110;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            i71 = i17;
                                            i72 = i39;
                                            if (i15 == 2) {
                                                if (i15 == 0) {
                                                    int i122 = zzga.zza;
                                                    zzhlVar3 = (zzhl) zzhoVar;
                                                    iZzg = zzga.zzh(bArr, i72, zzfzVar3);
                                                    zzhlVar3.zzg(zzgn.zzb(zzfzVar3.zza));
                                                    while (iZzg < i40) {
                                                        iZzh14 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                        if (i71 == zzfzVar3.zza) {
                                                            iZzg = zzga.zzh(bArr, iZzh14, zzfzVar3);
                                                            zzhlVar3.zzg(zzgn.zzb(zzfzVar3.zza));
                                                        }
                                                    }
                                                }
                                                i46 = i40;
                                                zzfzVar3 = zzfzVar3;
                                                i49 = i41;
                                                unsafe5 = unsafe5;
                                                i56 = i42;
                                                i47 = i71;
                                                i48 = i72;
                                                iZzg = i48;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            } else {
                                                int i123 = zzga.zza;
                                                zzhlVar4 = (zzhl) zzhoVar;
                                                iZzg = zzga.zzh(bArr, i72, zzfzVar3);
                                                i79 = zzfzVar3.zza + iZzg;
                                                while (iZzg < i79) {
                                                    iZzg = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                    zzhlVar4.zzg(zzgn.zzb(zzfzVar3.zza));
                                                }
                                                if (iZzg != i79) {
                                                    throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i46 = i40;
                                            zzfzVar3 = zzfzVar3;
                                            i49 = i41;
                                            unsafe5 = unsafe5;
                                            i56 = i42;
                                            i47 = i71;
                                            i48 = i72;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                            break;
                                        case 34:
                                        case 48:
                                            if (i15 == 2) {
                                                int i124 = zzga.zza;
                                                zzibVar6 = (zzib) zzhoVar;
                                                iZzg = zzga.zzh(bArr, i39, zzfzVar3);
                                                i80 = zzfzVar3.zza + iZzg;
                                                while (iZzg < i80) {
                                                    iZzg = zzga.zzk(bArr, iZzg, zzfzVar3);
                                                    zzibVar6.zzf(zzgn.zzc(zzfzVar3.zzb));
                                                }
                                                if (iZzg == i80) {
                                                    throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i46 = i40;
                                                i48 = i39;
                                                zzfzVar3 = zzfzVar3;
                                                i47 = i17;
                                                i49 = i41;
                                                unsafe5 = unsafe5;
                                                i56 = i42;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            } else {
                                                i72 = i39;
                                                if (i15 == 0) {
                                                    int i125 = zzga.zza;
                                                    zzibVar5 = (zzib) zzhoVar;
                                                    iZzg = zzga.zzk(bArr, i72, zzfzVar3);
                                                    zzibVar5.zzf(zzgn.zzc(zzfzVar3.zzb));
                                                    while (true) {
                                                        if (iZzg < i40) {
                                                            iZzh15 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                            i71 = i17;
                                                            if (i71 == zzfzVar3.zza) {
                                                                iZzg = zzga.zzk(bArr, iZzh15, zzfzVar3);
                                                                zzibVar5.zzf(zzgn.zzc(zzfzVar3.zzb));
                                                                i17 = i71;
                                                            }
                                                        } else {
                                                            i71 = i17;
                                                        }
                                                    }
                                                    i46 = i40;
                                                    zzfzVar3 = zzfzVar3;
                                                    i49 = i41;
                                                    unsafe5 = unsafe5;
                                                    i56 = i42;
                                                    i47 = i71;
                                                    i48 = i72;
                                                    if (iZzg != i48) {
                                                        zzfzVar5 = zzfzVar3;
                                                        i92 = i49;
                                                        unsafe8 = unsafe5;
                                                        i90 = i47;
                                                        i93 = i10;
                                                        i88 = 0;
                                                        i91 = i9;
                                                        i89 = i56;
                                                        obj3 = obj;
                                                        i3 = i3;
                                                        i87 = i46;
                                                    } else {
                                                        i4 = i3;
                                                        i8 = iZzg;
                                                        i11 = i49;
                                                        unsafe = unsafe5;
                                                        i13 = i47;
                                                        i88 = i56;
                                                        zzfzVar2 = zzfzVar3;
                                                        obj3 = obj;
                                                    }
                                                } else {
                                                    i46 = i40;
                                                    i48 = i72;
                                                    zzfzVar3 = zzfzVar3;
                                                    i47 = i17;
                                                    i49 = i41;
                                                    unsafe5 = unsafe5;
                                                    i56 = i42;
                                                    iZzg = i48;
                                                    if (iZzg != i48) {
                                                        zzfzVar5 = zzfzVar3;
                                                        i92 = i49;
                                                        unsafe8 = unsafe5;
                                                        i90 = i47;
                                                        i93 = i10;
                                                        i88 = 0;
                                                        i91 = i9;
                                                        i89 = i56;
                                                        obj3 = obj;
                                                        i3 = i3;
                                                        i87 = i46;
                                                    } else {
                                                        i4 = i3;
                                                        i8 = iZzg;
                                                        i11 = i49;
                                                        unsafe = unsafe5;
                                                        i13 = i47;
                                                        i88 = i56;
                                                        zzfzVar2 = zzfzVar3;
                                                        obj3 = obj;
                                                    }
                                                }
                                            }
                                            break;
                                        default:
                                            i46 = i40;
                                            zzfzVar3 = zzfzVar3;
                                            i47 = i17;
                                            i48 = i39;
                                            i49 = i41;
                                            unsafe5 = unsafe5;
                                            if (i15 == 3) {
                                                i81 = (i47 & (-8)) | 4;
                                                zzixVarZzv = zzv(i42);
                                                i56 = i42;
                                                iZzg = zzga.zzc(zzixVarZzv, bArr, i48, i2, i81, zzfzVar);
                                                zzhoVar.add(zzfzVar3.zzc);
                                                while (iZzg < i46) {
                                                    iZzh16 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                    if (i47 == zzfzVar3.zza) {
                                                        iZzg = zzga.zzc(zzixVarZzv, bArr, iZzh16, i2, i81, zzfzVar);
                                                        zzhoVar.add(zzfzVar3.zzc);
                                                    }
                                                }
                                            } else {
                                                i56 = i42;
                                                iZzg = i48;
                                            }
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                            break;
                                    }
                                } else {
                                    unsafe3 = unsafe2;
                                    i43 = i42;
                                    i44 = i17;
                                    i11 = i41;
                                    if (iZzr == 50) {
                                        zzfzVar2 = zzfzVar3;
                                        obj3 = obj;
                                        unsafe = unsafe3;
                                        unsafe7 = zzb;
                                        j3 = iArr[i43 + 2] & 1048575;
                                        switch (iZzr) {
                                            case 51:
                                                i43 = i43;
                                                zzfzVar2 = zzfzVar2;
                                                i13 = i44;
                                                i82 = i39;
                                                if (i15 == 1) {
                                                    iZzg = i82 + 8;
                                                    unsafe7.putObject(obj3, j, Double.valueOf(Double.longBitsToDouble(zzga.zzn(bArr, i82))));
                                                    unsafe7.putInt(obj3, j3, i11);
                                                } else {
                                                    iZzg = i82;
                                                }
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                                break;
                                            case 52:
                                                i43 = i43;
                                                zzfzVar2 = zzfzVar2;
                                                i13 = i44;
                                                i82 = i39;
                                                if (i15 == 5) {
                                                    iZzg = i82 + 4;
                                                    unsafe7.putObject(obj3, j, Float.valueOf(Float.intBitsToFloat(zzga.zzb(bArr, i82))));
                                                    unsafe7.putInt(obj3, j3, i11);
                                                } else {
                                                    iZzg = i82;
                                                }
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                                break;
                                            case 53:
                                            case 54:
                                                i43 = i43;
                                                zzfzVar2 = zzfzVar2;
                                                i13 = i44;
                                                i82 = i39;
                                                if (i15 == 0) {
                                                    iZzk = zzga.zzk(bArr, i82, zzfzVar2);
                                                    unsafe7.putObject(obj3, j, Long.valueOf(zzfzVar2.zzb));
                                                    unsafe7.putInt(obj3, j3, i11);
                                                    iZzg = iZzk;
                                                } else {
                                                    iZzg = i82;
                                                }
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                                break;
                                            case 55:
                                            case 62:
                                                i43 = i43;
                                                zzfzVar2 = zzfzVar2;
                                                i13 = i44;
                                                i82 = i39;
                                                if (i15 == 0) {
                                                    iZzg = zzga.zzh(bArr, i82, zzfzVar2);
                                                    unsafe7.putObject(obj3, j, Integer.valueOf(zzfzVar2.zza));
                                                    unsafe7.putInt(obj3, j3, i11);
                                                } else {
                                                    iZzg = i82;
                                                }
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                i43 = i43;
                                                zzfzVar2 = zzfzVar2;
                                                i13 = i44;
                                                i82 = i39;
                                                if (i15 == 1) {
                                                    iZzg = i82 + 8;
                                                    unsafe7.putObject(obj3, j, Long.valueOf(zzga.zzn(bArr, i82)));
                                                    unsafe7.putInt(obj3, j3, i11);
                                                } else {
                                                    iZzg = i82;
                                                }
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                i43 = i43;
                                                zzfzVar2 = zzfzVar2;
                                                i13 = i44;
                                                i82 = i39;
                                                if (i15 == 5) {
                                                    iZzg = i82 + 4;
                                                    unsafe7.putObject(obj3, j, Integer.valueOf(zzga.zzb(bArr, i82)));
                                                    unsafe7.putInt(obj3, j3, i11);
                                                } else {
                                                    iZzg = i82;
                                                }
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                                break;
                                            case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                                                i43 = i43;
                                                zzfzVar2 = zzfzVar2;
                                                i13 = i44;
                                                i82 = i39;
                                                if (i15 == 0) {
                                                    iZzk = zzga.zzk(bArr, i82, zzfzVar2);
                                                    if (zzfzVar2.zzb != 0) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    unsafe7.putObject(obj3, j, Boolean.valueOf(z5));
                                                    unsafe7.putInt(obj3, j3, i11);
                                                    iZzg = iZzk;
                                                } else {
                                                    iZzg = i82;
                                                }
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                                break;
                                            case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                                                i43 = i43;
                                                zzfzVar2 = zzfzVar2;
                                                i13 = i44;
                                                i82 = i39;
                                                if (i15 == 2) {
                                                    iZzg = zzga.zzh(bArr, i82, zzfzVar2);
                                                    i83 = zzfzVar2.zza;
                                                    if (i83 == 0) {
                                                        unsafe7.putObject(obj3, j, "");
                                                    } else {
                                                        i84 = iZzg + i83;
                                                        if ((i16 & 536870912) == 0 && !zzjt.zzd(bArr, iZzg, i84)) {
                                                            throw new zzhr(str);
                                                        }
                                                        unsafe7.putObject(obj3, j, new String(bArr, iZzg, i83, zzhp.zza));
                                                        iZzg = i84;
                                                    }
                                                    unsafe7.putInt(obj3, j3, i11);
                                                } else {
                                                    iZzg = i82;
                                                }
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                                break;
                                            case 60:
                                                i85 = i44;
                                                i82 = i39;
                                                if (i15 == 2) {
                                                    Object objZzy = zzy(obj3, i11, i43);
                                                    zzfzVar2 = zzfzVar2;
                                                    iZzg = zzga.zzm(objZzy, zzv(i43), bArr, i82, i2, zzfzVar);
                                                    zzG(obj3, i11, i43, objZzy);
                                                    i43 = i43;
                                                    i13 = i85;
                                                } else {
                                                    i13 = i85;
                                                    iZzg = i82;
                                                }
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                                break;
                                            case 61:
                                                i85 = i44;
                                                i82 = i39;
                                                if (i15 == 2) {
                                                    iZzg = zzga.zza(bArr, i82, zzfzVar2);
                                                    unsafe7.putObject(obj3, j, zzfzVar2.zzc);
                                                    unsafe7.putInt(obj3, j3, i11);
                                                    i13 = i85;
                                                    if (iZzg != i82) {
                                                        i11 = i11;
                                                        i87 = i2;
                                                        i3 = i3;
                                                        i92 = i11;
                                                        i90 = i13;
                                                        zzfzVar5 = zzfzVar2;
                                                        i93 = i10;
                                                        i88 = 0;
                                                        i91 = i9;
                                                        unsafe8 = unsafe;
                                                        i89 = i43;
                                                    } else {
                                                        i11 = i11;
                                                        i4 = i3;
                                                        i8 = iZzg;
                                                        i88 = i43;
                                                    }
                                                }
                                                i13 = i85;
                                                iZzg = i82;
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                                break;
                                            case 63:
                                                i85 = i44;
                                                i82 = i39;
                                                if (i15 == 0) {
                                                    iZzg = zzga.zzh(bArr, i82, zzfzVar2);
                                                    i86 = zzfzVar2.zza;
                                                    zzhmVarZzu2 = zzu(i43);
                                                    if (zzhmVarZzu2 != null || zzhmVarZzu2.zza(i86)) {
                                                        unsafe7.putObject(obj3, j, Integer.valueOf(i86));
                                                        unsafe7.putInt(obj3, j3, i11);
                                                    } else {
                                                        zzd(obj).zzj(i85, Long.valueOf(i86));
                                                    }
                                                    i13 = i85;
                                                    if (iZzg != i82) {
                                                        i11 = i11;
                                                        i87 = i2;
                                                        i3 = i3;
                                                        i92 = i11;
                                                        i90 = i13;
                                                        zzfzVar5 = zzfzVar2;
                                                        i93 = i10;
                                                        i88 = 0;
                                                        i91 = i9;
                                                        unsafe8 = unsafe;
                                                        i89 = i43;
                                                    } else {
                                                        i11 = i11;
                                                        i4 = i3;
                                                        i8 = iZzg;
                                                        i88 = i43;
                                                    }
                                                }
                                                i13 = i85;
                                                iZzg = i82;
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                                break;
                                            case 66:
                                                i85 = i44;
                                                i82 = i39;
                                                if (i15 == 0) {
                                                    iZzg = zzga.zzh(bArr, i82, zzfzVar2);
                                                    unsafe7.putObject(obj3, j, Integer.valueOf(zzgn.zzb(zzfzVar2.zza)));
                                                    unsafe7.putInt(obj3, j3, i11);
                                                    i13 = i85;
                                                    if (iZzg != i82) {
                                                        i11 = i11;
                                                        i87 = i2;
                                                        i3 = i3;
                                                        i92 = i11;
                                                        i90 = i13;
                                                        zzfzVar5 = zzfzVar2;
                                                        i93 = i10;
                                                        i88 = 0;
                                                        i91 = i9;
                                                        unsafe8 = unsafe;
                                                        i89 = i43;
                                                    } else {
                                                        i11 = i11;
                                                        i4 = i3;
                                                        i8 = iZzg;
                                                        i88 = i43;
                                                    }
                                                }
                                                i13 = i85;
                                                iZzg = i82;
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                                break;
                                            case 67:
                                                i85 = i44;
                                                if (i15 == 0) {
                                                    i82 = i39;
                                                    int iZzk4 = zzga.zzk(bArr, i82, zzfzVar2);
                                                    unsafe7.putObject(obj3, j, Long.valueOf(zzgn.zzc(zzfzVar2.zzb)));
                                                    unsafe7.putInt(obj3, j3, i11);
                                                    iZzg = iZzk4;
                                                    i13 = i85;
                                                    if (iZzg != i82) {
                                                        i11 = i11;
                                                        i87 = i2;
                                                        i3 = i3;
                                                        i92 = i11;
                                                        i90 = i13;
                                                        zzfzVar5 = zzfzVar2;
                                                        i93 = i10;
                                                        i88 = 0;
                                                        i91 = i9;
                                                        unsafe8 = unsafe;
                                                        i89 = i43;
                                                    } else {
                                                        i11 = i11;
                                                        i4 = i3;
                                                        i8 = iZzg;
                                                        i88 = i43;
                                                    }
                                                } else {
                                                    i82 = i39;
                                                    i13 = i85;
                                                    iZzg = i82;
                                                    if (iZzg != i82) {
                                                        i11 = i11;
                                                        i87 = i2;
                                                        i3 = i3;
                                                        i92 = i11;
                                                        i90 = i13;
                                                        zzfzVar5 = zzfzVar2;
                                                        i93 = i10;
                                                        i88 = 0;
                                                        i91 = i9;
                                                        unsafe8 = unsafe;
                                                        i89 = i43;
                                                    } else {
                                                        i11 = i11;
                                                        i4 = i3;
                                                        i8 = iZzg;
                                                        i88 = i43;
                                                    }
                                                }
                                                break;
                                            case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                                                if (i15 == 3) {
                                                    Object objZzy2 = zzy(obj3, i11, i43);
                                                    i85 = i44;
                                                    int iZzl2 = zzga.zzl(objZzy2, zzv(i43), bArr, i39, i2, (i44 & (-8)) | 4, zzfzVar);
                                                    zzG(obj3, i11, i43, objZzy2);
                                                    iZzg = iZzl2;
                                                    i82 = i39;
                                                    i13 = i85;
                                                    if (iZzg != i82) {
                                                        i11 = i11;
                                                        i87 = i2;
                                                        i3 = i3;
                                                        i92 = i11;
                                                        i90 = i13;
                                                        zzfzVar5 = zzfzVar2;
                                                        i93 = i10;
                                                        i88 = 0;
                                                        i91 = i9;
                                                        unsafe8 = unsafe;
                                                        i89 = i43;
                                                    } else {
                                                        i11 = i11;
                                                        i4 = i3;
                                                        i8 = iZzg;
                                                        i88 = i43;
                                                    }
                                                    break;
                                                }
                                            default:
                                                i43 = i43;
                                                zzfzVar2 = zzfzVar2;
                                                i13 = i44;
                                                i82 = i39;
                                                iZzg = i82;
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                                break;
                                        }
                                    } else {
                                        if (i15 == 2) {
                                            unsafe6 = zzb;
                                            Object objZzw = zzw(i43);
                                            object = unsafe6.getObject(obj, j);
                                            if (!((zzig) object).zze()) {
                                                zzig zzigVarZzb = zzig.zza().zzb();
                                                zzih.zza(zzigVarZzb, object);
                                                unsafe6.putObject(obj, j, zzigVarZzb);
                                            }
                                            throw null;
                                        }
                                        zzfzVar4 = zzfzVar3;
                                        obj3 = obj;
                                        i4 = i3;
                                        i88 = i43;
                                        zzfzVar2 = zzfzVar4;
                                        unsafe = unsafe3;
                                        i13 = i44;
                                        i8 = i39;
                                    }
                                }
                            } else if (i15 == 2) {
                                zzhoVarZzd = (zzho) unsafe2.getObject(obj3, j);
                                if (!zzhoVarZzd.zzc()) {
                                    size = zzhoVarZzd.size();
                                    if (size == 0) {
                                        i45 = 10;
                                    } else {
                                        i45 = size + size;
                                    }
                                    zzhoVarZzd = zzhoVarZzd.zzd(i45);
                                    unsafe2.putObject(obj3, j, zzhoVarZzd);
                                }
                                i3 = i3;
                                zzfzVar5 = zzfzVar3;
                                iZzg = zzga.zze(zzv(i42), i17, bArr, i39, i2, zzhoVarZzd, zzfzVar);
                                unsafe8 = unsafe2;
                                i89 = i42;
                                i87 = i40;
                                i93 = i10;
                                i90 = i17;
                                i88 = 0;
                                i91 = i9;
                                i92 = i41;
                            } else {
                                i43 = i42;
                                unsafe3 = unsafe2;
                                zzfzVar4 = zzfzVar3;
                                i44 = i17;
                                i11 = i41;
                                i4 = i3;
                                i88 = i43;
                                zzfzVar2 = zzfzVar4;
                                unsafe = unsafe3;
                                i13 = i44;
                                i8 = i39;
                            }
                        }
                    } else {
                        i8 = iZzi;
                        i9 = i91;
                        i10 = i93;
                        i11 = i96;
                        i12 = i88;
                        unsafe = unsafe8;
                        zzfzVar2 = zzfzVar5;
                        i4 = i3;
                        i13 = i5;
                    }
                    if (i13 == i4 || i4 == 0) {
                        if (this.zzh) {
                            zzgwVar = zzfzVar2.zzd;
                            int i126 = zzgw.zzb;
                            int i127 = zziu.zza;
                            if (zzgwVar != zzgw.zza) {
                                zzimVar = this.zzg;
                                zzgwVar2 = zzfzVar2.zzd;
                                int i128 = zzga.zza;
                                if (zzgwVar2.zzb(zzimVar, i11) == null) {
                                    throw null;
                                }
                                i14 = i13;
                                iZzg = zzga.zzg(i13, bArr, i8, i2, zzd(obj), zzfzVar);
                            } else {
                                i14 = i13;
                                iZzg = zzga.zzg(i14, bArr, i8, i2, zzd(obj), zzfzVar);
                            }
                        } else {
                            i14 = i13;
                            iZzg = zzga.zzg(i14, bArr, i8, i2, zzd(obj), zzfzVar);
                        }
                        i87 = i2;
                        i3 = i4;
                        i89 = i88;
                        i90 = i14;
                        i92 = i11;
                        i93 = i10;
                        i88 = i12;
                        i91 = i9;
                        unsafe8 = unsafe;
                        zzfzVar5 = zzfzVar2;
                    } else {
                        iZzg = i8;
                        i90 = i13;
                        i93 = i10;
                        i91 = i9;
                    }
                }
                i7 = iZzq;
                i6 = -1;
                if (i7 == i6) {
                    i15 = i5 & 7;
                    iArr = this.zzc;
                    i16 = iArr[i7 + 1];
                    i17 = i5;
                    iZzr = zzr(i16);
                    j = i16 & 1048575;
                    i18 = i96;
                    str = "Protocol message had invalid UTF-8.";
                    if (iZzr <= 17) {
                        int i910 = iArr[i7 + 2];
                        i19 = 1 << (i910 >>> 20);
                        i20 = i910 & 1048575;
                        if (i20 != i93) {
                            if (i93 != 1048575) {
                                unsafe8.putInt(obj3, i93, i91);
                            }
                            if (i20 == 1048575) {
                                i91 = 0;
                            } else {
                                i91 = unsafe8.getInt(obj3, i20);
                            }
                            i10 = i20;
                        } else {
                            i10 = i93;
                        }
                        switch (iZzr) {
                            case 0:
                                i21 = iZzi;
                                i22 = i7;
                                i88 = 0;
                                if (i15 == 1) {
                                    iZzg = i21 + 8;
                                    i91 |= i19;
                                    zzjq.zzo(obj3, j, Double.longBitsToDouble(zzga.zzn(bArr, i21)));
                                    i89 = i22;
                                    i93 = i10;
                                    i90 = i17;
                                    i92 = i18;
                                    i87 = i2;
                                } else {
                                    i23 = i21;
                                    i12 = i88;
                                    i24 = i22;
                                    i9 = i91;
                                    unsafe = unsafe8;
                                    i88 = i24;
                                    zzfzVar2 = zzfzVar5;
                                    i13 = i17;
                                    i11 = i18;
                                    i8 = i23;
                                    i4 = i3;
                                }
                                break;
                            case 1:
                                i21 = iZzi;
                                i22 = i7;
                                i88 = 0;
                                if (i15 == 5) {
                                    iZzg = i21 + 4;
                                    i91 |= i19;
                                    zzjq.zzp(obj3, j, Float.intBitsToFloat(zzga.zzb(bArr, i21)));
                                    i89 = i22;
                                    i93 = i10;
                                    i90 = i17;
                                    i92 = i18;
                                    i87 = i2;
                                } else {
                                    i23 = i21;
                                    i12 = i88;
                                    i24 = i22;
                                    i9 = i91;
                                    unsafe = unsafe8;
                                    i88 = i24;
                                    zzfzVar2 = zzfzVar5;
                                    i13 = i17;
                                    i11 = i18;
                                    i8 = i23;
                                    i4 = i3;
                                }
                                break;
                            case 2:
                            case 3:
                                i21 = iZzi;
                                i22 = i7;
                                i88 = 0;
                                if (i15 == 0) {
                                    int i911 = i91 | i19;
                                    int iZzk5 = zzga.zzk(bArr, i21, zzfzVar5);
                                    unsafe8.putLong(obj, j, zzfzVar5.zzb);
                                    i91 = i911;
                                    iZzg = iZzk5;
                                    i89 = i22;
                                    i93 = i10;
                                    i90 = i17;
                                    i92 = i18;
                                    i87 = i2;
                                } else {
                                    i23 = i21;
                                    i12 = i88;
                                    i24 = i22;
                                    i9 = i91;
                                    unsafe = unsafe8;
                                    i88 = i24;
                                    zzfzVar2 = zzfzVar5;
                                    i13 = i17;
                                    i11 = i18;
                                    i8 = i23;
                                    i4 = i3;
                                }
                                break;
                            case 4:
                            case 11:
                                i21 = iZzi;
                                i22 = i7;
                                i88 = 0;
                                if (i15 == 0) {
                                    i91 |= i19;
                                    iZzg = zzga.zzh(bArr, i21, zzfzVar5);
                                    unsafe8.putInt(obj3, j, zzfzVar5.zza);
                                    i89 = i22;
                                    i93 = i10;
                                    i90 = i17;
                                    i92 = i18;
                                    i87 = i2;
                                } else {
                                    i23 = i21;
                                    i12 = i88;
                                    i24 = i22;
                                    i9 = i91;
                                    unsafe = unsafe8;
                                    i88 = i24;
                                    zzfzVar2 = zzfzVar5;
                                    i13 = i17;
                                    i11 = i18;
                                    i8 = i23;
                                    i4 = i3;
                                }
                                break;
                            case 5:
                            case 14:
                                i21 = iZzi;
                                i22 = i7;
                                i88 = 0;
                                if (i15 == 1) {
                                    unsafe8.putLong(obj, j, zzga.zzn(bArr, i21));
                                    iZzg = i21 + 8;
                                    i91 = i19 | i91;
                                    i89 = i22;
                                    i93 = i10;
                                    i90 = i17;
                                    i92 = i18;
                                    i87 = i2;
                                } else {
                                    i23 = i21;
                                    i12 = i88;
                                    i24 = i22;
                                    i9 = i91;
                                    unsafe = unsafe8;
                                    i88 = i24;
                                    zzfzVar2 = zzfzVar5;
                                    i13 = i17;
                                    i11 = i18;
                                    i8 = i23;
                                    i4 = i3;
                                }
                                break;
                            case 6:
                            case 13:
                                i21 = iZzi;
                                i22 = i7;
                                i88 = 0;
                                if (i15 == 5) {
                                    iZzg = i21 + 4;
                                    i91 |= i19;
                                    unsafe8.putInt(obj3, j, zzga.zzb(bArr, i21));
                                    i89 = i22;
                                    i93 = i10;
                                    i90 = i17;
                                    i92 = i18;
                                    i87 = i2;
                                } else {
                                    i23 = i21;
                                    i12 = i88;
                                    i24 = i22;
                                    i9 = i91;
                                    unsafe = unsafe8;
                                    i88 = i24;
                                    zzfzVar2 = zzfzVar5;
                                    i13 = i17;
                                    i11 = i18;
                                    i8 = i23;
                                    i4 = i3;
                                }
                                break;
                            case 7:
                                i21 = iZzi;
                                i22 = i7;
                                i88 = 0;
                                if (i15 == 0) {
                                    i91 |= i19;
                                    iZzg = zzga.zzk(bArr, i21, zzfzVar5);
                                    if (zzfzVar5.zzb != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    zzjq.zzm(obj3, j, z);
                                    i89 = i22;
                                    i93 = i10;
                                    i90 = i17;
                                    i92 = i18;
                                    i87 = i2;
                                } else {
                                    i23 = i21;
                                    i12 = i88;
                                    i24 = i22;
                                    i9 = i91;
                                    unsafe = unsafe8;
                                    i88 = i24;
                                    zzfzVar2 = zzfzVar5;
                                    i13 = i17;
                                    i11 = i18;
                                    i8 = i23;
                                    i4 = i3;
                                }
                                break;
                            case 8:
                                i25 = iZzi;
                                i22 = i7;
                                i26 = i17;
                                if (i15 == 2) {
                                    if ((i16 & 536870912) != 0) {
                                        i28 = i91 | i19;
                                        iZzh = zzga.zzh(bArr, i25, zzfzVar5);
                                        i29 = zzfzVar5.zza;
                                        if (i29 >= 0) {
                                            throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                        }
                                        if (i29 == 0) {
                                            zzfzVar5.zzc = "";
                                            i32 = i28;
                                            i17 = i26;
                                            i88 = 0;
                                        } else {
                                            int i912 = zzjt.zza;
                                            length = bArr.length;
                                            if ((((length - iZzh) - i29) | iZzh | i29) >= 0) {
                                                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzh), Integer.valueOf(i29)));
                                            }
                                            i30 = iZzh + i29;
                                            cArr = new char[i29];
                                            i31 = 0;
                                            while (iZzh < i30) {
                                                b3 = bArr[iZzh];
                                                if (zzjr.zzd(b3)) {
                                                    iZzh++;
                                                    cArr[i31] = (char) b3;
                                                    i31++;
                                                } else {
                                                    while (iZzh < i30) {
                                                        i33 = iZzh + 1;
                                                        b = bArr[iZzh];
                                                        if (zzjr.zzd(b)) {
                                                            cArr[i31] = (char) b;
                                                            i31++;
                                                            iZzh = i33;
                                                            while (iZzh < i30) {
                                                                b2 = bArr[iZzh];
                                                                if (zzjr.zzd(b2)) {
                                                                }
                                                                iZzh++;
                                                                cArr[i31] = (char) b2;
                                                                i31++;
                                                                break;
                                                            }
                                                        } else {
                                                            i34 = i28;
                                                            if (b < -32) {
                                                                i35 = i26;
                                                                str2 = str;
                                                                if (b < -16) {
                                                                    if (i33 < i30 - 1) {
                                                                        throw new zzhr(str2);
                                                                    }
                                                                    zzjr.zzb(b, bArr[i33], bArr[iZzh + 2], cArr, i31);
                                                                    str = str2;
                                                                    i31++;
                                                                    i28 = i34;
                                                                    i26 = i35;
                                                                    iZzh += 3;
                                                                } else {
                                                                    if (i33 < i30 - 2) {
                                                                        throw new zzhr(str2);
                                                                    }
                                                                    byte b8 = bArr[i33];
                                                                    int i1010 = iZzh + 3;
                                                                    byte b9 = bArr[iZzh + 2];
                                                                    iZzh += 4;
                                                                    zzjr.zza(b, b8, b9, bArr[i1010], cArr, i31);
                                                                    i31 += 2;
                                                                    str = str2;
                                                                    i28 = i34;
                                                                    i26 = i35;
                                                                }
                                                            } else {
                                                                if (i33 < i30) {
                                                                    throw new zzhr(str);
                                                                }
                                                                iZzh += 2;
                                                                zzjr.zzc(b, bArr[i33], cArr, i31);
                                                                i31++;
                                                                i28 = i34;
                                                            }
                                                        }
                                                    }
                                                    i32 = i28;
                                                    i17 = i26;
                                                    i88 = 0;
                                                    zzfzVar5.zzc = new String(cArr, 0, i31);
                                                    iZzh = i30;
                                                }
                                            }
                                            while (iZzh < i30) {
                                                i33 = iZzh + 1;
                                                b = bArr[iZzh];
                                                if (zzjr.zzd(b)) {
                                                    cArr[i31] = (char) b;
                                                    i31++;
                                                    iZzh = i33;
                                                    while (iZzh < i30) {
                                                        b2 = bArr[iZzh];
                                                        if (zzjr.zzd(b2)) {
                                                        }
                                                        iZzh++;
                                                        cArr[i31] = (char) b2;
                                                        i31++;
                                                        break;
                                                    }
                                                } else {
                                                    i34 = i28;
                                                    if (b < -32) {
                                                        i35 = i26;
                                                        str2 = str;
                                                        if (b < -16) {
                                                            if (i33 < i30 - 1) {
                                                                throw new zzhr(str2);
                                                            }
                                                            zzjr.zzb(b, bArr[i33], bArr[iZzh + 2], cArr, i31);
                                                            str = str2;
                                                            i31++;
                                                            i28 = i34;
                                                            i26 = i35;
                                                            iZzh += 3;
                                                        } else {
                                                            if (i33 < i30 - 2) {
                                                                throw new zzhr(str2);
                                                            }
                                                            byte b10 = bArr[i33];
                                                            int i1011 = iZzh + 3;
                                                            byte b11 = bArr[iZzh + 2];
                                                            iZzh += 4;
                                                            zzjr.zza(b, b10, b11, bArr[i1011], cArr, i31);
                                                            i31 += 2;
                                                            str = str2;
                                                            i28 = i34;
                                                            i26 = i35;
                                                        }
                                                    } else {
                                                        if (i33 < i30) {
                                                            throw new zzhr(str);
                                                        }
                                                        iZzh += 2;
                                                        zzjr.zzc(b, bArr[i33], cArr, i31);
                                                        i31++;
                                                        i28 = i34;
                                                    }
                                                }
                                            }
                                            i32 = i28;
                                            i17 = i26;
                                            i88 = 0;
                                            zzfzVar5.zzc = new String(cArr, 0, i31);
                                            iZzh = i30;
                                        }
                                        iZzg = iZzh;
                                        i91 = i32;
                                    } else {
                                        i17 = i26;
                                        i88 = 0;
                                        iZzg = zzga.zzh(bArr, i25, zzfzVar5);
                                        i27 = zzfzVar5.zza;
                                        if (i27 >= 0) {
                                            throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                        }
                                        i91 |= i19;
                                        if (i27 == 0) {
                                            zzfzVar5.zzc = "";
                                        } else {
                                            zzfzVar5.zzc = new String(bArr, iZzg, i27, zzhp.zza);
                                            iZzg += i27;
                                        }
                                    }
                                    unsafe8.putObject(obj3, j, zzfzVar5.zzc);
                                    i89 = i22;
                                    i93 = i10;
                                    i90 = i17;
                                    i92 = i18;
                                    i87 = i2;
                                } else {
                                    i23 = i25;
                                    i17 = i26;
                                    i24 = i22;
                                    i12 = 0;
                                    i9 = i91;
                                    unsafe = unsafe8;
                                    i88 = i24;
                                    zzfzVar2 = zzfzVar5;
                                    i13 = i17;
                                    i11 = i18;
                                    i8 = i23;
                                    i4 = i3;
                                }
                                break;
                            case 9:
                                i36 = i7;
                                i37 = i17;
                                if (i15 == 2) {
                                    int i1012 = i91 | i19;
                                    Object objZzx3 = zzx(obj3, i36);
                                    iZzg = zzga.zzm(objZzx3, zzv(i36), bArr, iZzi, i2, zzfzVar);
                                    zzF(obj3, i36, objZzx3);
                                    i91 = i1012;
                                    i90 = i37;
                                    i89 = i36;
                                    i93 = i10;
                                    i92 = i18;
                                    i88 = 0;
                                    i87 = i2;
                                    i3 = i3;
                                } else {
                                    i23 = iZzi;
                                    i91 = i91;
                                    unsafe8 = unsafe8;
                                    i17 = i37;
                                    i24 = i36;
                                    i18 = i18;
                                    i12 = 0;
                                    i9 = i91;
                                    unsafe = unsafe8;
                                    i88 = i24;
                                    zzfzVar2 = zzfzVar5;
                                    i13 = i17;
                                    i11 = i18;
                                    i8 = i23;
                                    i4 = i3;
                                }
                                break;
                            case 10:
                                i36 = i7;
                                i37 = i17;
                                if (i15 == 2) {
                                    i91 |= i19;
                                    iZzg = zzga.zza(bArr, iZzi, zzfzVar5);
                                    unsafe8.putObject(obj3, j, zzfzVar5.zzc);
                                    i90 = i37;
                                    i89 = i36;
                                    i93 = i10;
                                    i92 = i18;
                                    i88 = 0;
                                    i87 = i2;
                                    i3 = i3;
                                } else {
                                    i23 = iZzi;
                                    i91 = i91;
                                    unsafe8 = unsafe8;
                                    i17 = i37;
                                    i24 = i36;
                                    i18 = i18;
                                    i12 = 0;
                                    i9 = i91;
                                    unsafe = unsafe8;
                                    i88 = i24;
                                    zzfzVar2 = zzfzVar5;
                                    i13 = i17;
                                    i11 = i18;
                                    i8 = i23;
                                    i4 = i3;
                                }
                                break;
                            case 12:
                                i36 = i7;
                                i37 = i17;
                                if (i15 == 0) {
                                    iZzg = zzga.zzh(bArr, iZzi, zzfzVar5);
                                    i38 = zzfzVar5.zza;
                                    zzhm zzhmVarZzu4 = zzu(i36);
                                    if ((i16 & Integer.MIN_VALUE) != 0) {
                                        i91 |= i19;
                                        unsafe8.putInt(obj3, j, i38);
                                    } else {
                                        i91 |= i19;
                                        unsafe8.putInt(obj3, j, i38);
                                    }
                                    i90 = i37;
                                    i89 = i36;
                                    i93 = i10;
                                    i92 = i18;
                                    i88 = 0;
                                    i87 = i2;
                                    i3 = i3;
                                } else {
                                    i23 = iZzi;
                                    i91 = i91;
                                    unsafe8 = unsafe8;
                                    i17 = i37;
                                    i24 = i36;
                                    i18 = i18;
                                    i12 = 0;
                                    i9 = i91;
                                    unsafe = unsafe8;
                                    i88 = i24;
                                    zzfzVar2 = zzfzVar5;
                                    i13 = i17;
                                    i11 = i18;
                                    i8 = i23;
                                    i4 = i3;
                                }
                                break;
                            case 15:
                                i36 = i7;
                                i37 = i17;
                                if (i15 == 0) {
                                    i91 |= i19;
                                    iZzg = zzga.zzh(bArr, iZzi, zzfzVar5);
                                    unsafe8.putInt(obj3, j, zzgn.zzb(zzfzVar5.zza));
                                    i90 = i37;
                                    i89 = i36;
                                    i93 = i10;
                                    i92 = i18;
                                    i88 = 0;
                                    i87 = i2;
                                    i3 = i3;
                                } else {
                                    i23 = iZzi;
                                    i91 = i91;
                                    unsafe8 = unsafe8;
                                    i17 = i37;
                                    i24 = i36;
                                    i18 = i18;
                                    i12 = 0;
                                    i9 = i91;
                                    unsafe = unsafe8;
                                    i88 = i24;
                                    zzfzVar2 = zzfzVar5;
                                    i13 = i17;
                                    i11 = i18;
                                    i8 = i23;
                                    i4 = i3;
                                }
                                break;
                            case 16:
                                if (i15 == 0) {
                                    int i1013 = i91 | i19;
                                    int iZzk6 = zzga.zzk(bArr, iZzi, zzfzVar5);
                                    i36 = i7;
                                    i37 = i17;
                                    unsafe8.putLong(obj, j, zzgn.zzc(zzfzVar5.zzb));
                                    i91 = i1013;
                                    iZzg = iZzk6;
                                    i90 = i37;
                                    i89 = i36;
                                    i93 = i10;
                                    i92 = i18;
                                    i88 = 0;
                                    i87 = i2;
                                    i3 = i3;
                                } else {
                                    i23 = iZzi;
                                    i91 = i91;
                                    unsafe8 = unsafe8;
                                    i12 = 0;
                                    i24 = i7;
                                    i18 = i18;
                                    i9 = i91;
                                    unsafe = unsafe8;
                                    i88 = i24;
                                    zzfzVar2 = zzfzVar5;
                                    i13 = i17;
                                    i11 = i18;
                                    i8 = i23;
                                    i4 = i3;
                                }
                                break;
                            default:
                                i21 = iZzi;
                                i22 = i7;
                                i88 = 0;
                                if (i15 == 3) {
                                    Object objZzx4 = zzx(obj3, i22);
                                    int iZzl3 = zzga.zzl(objZzx4, zzv(i22), bArr, i21, i2, (i18 << 3) | 4, zzfzVar);
                                    zzF(obj3, i22, objZzx4);
                                    i3 = i3;
                                    zzfzVar5 = zzfzVar;
                                    i92 = i18;
                                    unsafe8 = unsafe8;
                                    i89 = i22;
                                    i87 = i2;
                                    iZzg = iZzl3;
                                    i93 = i10;
                                    i90 = i17;
                                    i88 = 0;
                                    i91 |= i19;
                                } else {
                                    i23 = i21;
                                    i12 = i88;
                                    i24 = i22;
                                    i9 = i91;
                                    unsafe = unsafe8;
                                    i88 = i24;
                                    zzfzVar2 = zzfzVar5;
                                    i13 = i17;
                                    i11 = i18;
                                    i8 = i23;
                                    i4 = i3;
                                }
                                break;
                        }
                    } else {
                        i39 = iZzi;
                        i10 = i93;
                        i12 = 0;
                        i40 = i2;
                        i41 = i18;
                        i9 = i91;
                        i42 = i7;
                        zzfz zzfzVar7 = zzfzVar5;
                        unsafe2 = unsafe8;
                        zzfzVar3 = zzfzVar7;
                        if (iZzr == 27) {
                            if (iZzr <= 49) {
                                j2 = i16;
                                unsafe4 = zzb;
                                unsafe5 = unsafe2;
                                zzhoVarZzd2 = (zzho) unsafe4.getObject(obj3, j);
                                if (!zzhoVarZzd2.zzc()) {
                                    int size4 = zzhoVarZzd2.size();
                                    zzhoVarZzd2 = zzhoVarZzd2.zzd(size4 + size4);
                                    unsafe4.putObject(obj3, j, zzhoVarZzd2);
                                }
                                zzhoVar = zzhoVarZzd2;
                                switch (iZzr) {
                                    case 18:
                                    case 35:
                                        i46 = i40;
                                        zzfzVar3 = zzfzVar3;
                                        i47 = i17;
                                        i48 = i39;
                                        i49 = i41;
                                        unsafe5 = unsafe5;
                                        i50 = i42;
                                        if (i15 == 2) {
                                            i42 = i50;
                                            if (i15 == 1) {
                                                iZzg = i48 + 8;
                                                int i1014 = zzga.zza;
                                                zzgtVar = (zzgt) zzhoVar;
                                                zzgtVar.zzf(Double.longBitsToDouble(zzga.zzn(bArr, i48)));
                                                while (iZzg < i46) {
                                                    iZzh2 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                    if (i47 == zzfzVar3.zza) {
                                                        zzgtVar.zzf(Double.longBitsToDouble(zzga.zzn(bArr, iZzh2)));
                                                        iZzg = iZzh2 + 8;
                                                    }
                                                }
                                            }
                                            i56 = i42;
                                            iZzg = i48;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                        } else {
                                            int i1015 = zzga.zza;
                                            zzgtVar2 = (zzgt) zzhoVar;
                                            iZzh3 = zzga.zzh(bArr, i48, zzfzVar3);
                                            i51 = zzfzVar3.zza;
                                            i52 = iZzh3 + i51;
                                            if (i52 <= bArr.length) {
                                                throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzgtVar2.zzg(zzgtVar2.size() + (i51 / 8));
                                            while (iZzh3 < i52) {
                                                zzgtVar2.zzf(Double.longBitsToDouble(zzga.zzn(bArr, iZzh3)));
                                                iZzh3 += 8;
                                                i50 = i50;
                                            }
                                            i42 = i50;
                                            if (iZzh3 == i52) {
                                                throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            iZzg = iZzh3;
                                        }
                                        i56 = i42;
                                        if (iZzg != i48) {
                                            zzfzVar5 = zzfzVar3;
                                            i92 = i49;
                                            unsafe8 = unsafe5;
                                            i90 = i47;
                                            i93 = i10;
                                            i88 = 0;
                                            i91 = i9;
                                            i89 = i56;
                                            obj3 = obj;
                                            i3 = i3;
                                            i87 = i46;
                                        } else {
                                            i4 = i3;
                                            i8 = iZzg;
                                            i11 = i49;
                                            unsafe = unsafe5;
                                            i13 = i47;
                                            i88 = i56;
                                            zzfzVar2 = zzfzVar3;
                                            obj3 = obj;
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        i46 = i40;
                                        zzfzVar3 = zzfzVar3;
                                        i47 = i17;
                                        i48 = i39;
                                        i49 = i41;
                                        unsafe5 = unsafe5;
                                        i53 = i42;
                                        if (i15 == 2) {
                                            if (i15 == 5) {
                                                iZzg = i48 + 4;
                                                int i1016 = zzga.zza;
                                                zzhdVar = (zzhd) zzhoVar;
                                                zzhdVar.zzf(Float.intBitsToFloat(zzga.zzb(bArr, i48)));
                                                while (iZzg < i46) {
                                                    iZzh4 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                    if (i47 == zzfzVar3.zza) {
                                                        zzhdVar.zzf(Float.intBitsToFloat(zzga.zzb(bArr, iZzh4)));
                                                        iZzg = iZzh4 + 4;
                                                    }
                                                }
                                            }
                                            i56 = i53;
                                            iZzg = i48;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                        } else {
                                            int i1017 = zzga.zza;
                                            zzhdVar2 = (zzhd) zzhoVar;
                                            iZzh5 = zzga.zzh(bArr, i48, zzfzVar3);
                                            i54 = zzfzVar3.zza;
                                            i55 = iZzh5 + i54;
                                            if (i55 <= bArr.length) {
                                                throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzhdVar2.zzg(zzhdVar2.size() + (i54 / 4));
                                            while (iZzh5 < i55) {
                                                zzhdVar2.zzf(Float.intBitsToFloat(zzga.zzb(bArr, iZzh5)));
                                                iZzh5 += 4;
                                            }
                                            if (iZzh5 != i55) {
                                                throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            iZzg = iZzh5;
                                        }
                                        i56 = i53;
                                        if (iZzg != i48) {
                                            zzfzVar5 = zzfzVar3;
                                            i92 = i49;
                                            unsafe8 = unsafe5;
                                            i90 = i47;
                                            i93 = i10;
                                            i88 = 0;
                                            i91 = i9;
                                            i89 = i56;
                                            obj3 = obj;
                                            i3 = i3;
                                            i87 = i46;
                                        } else {
                                            i4 = i3;
                                            i8 = iZzg;
                                            i11 = i49;
                                            unsafe = unsafe5;
                                            i13 = i47;
                                            i88 = i56;
                                            zzfzVar2 = zzfzVar3;
                                            obj3 = obj;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        i46 = i40;
                                        zzfzVar3 = zzfzVar3;
                                        i47 = i17;
                                        i48 = i39;
                                        i49 = i41;
                                        unsafe5 = unsafe5;
                                        i53 = i42;
                                        if (i15 == 2) {
                                            if (i15 == 0) {
                                                int i1018 = zzga.zza;
                                                zzibVar = (zzib) zzhoVar;
                                                iZzh5 = zzga.zzk(bArr, i48, zzfzVar3);
                                                zzibVar.zzf(zzfzVar3.zzb);
                                                while (iZzh5 < i46) {
                                                    iZzh6 = zzga.zzh(bArr, iZzh5, zzfzVar3);
                                                    if (i47 == zzfzVar3.zza) {
                                                        iZzh5 = zzga.zzk(bArr, iZzh6, zzfzVar3);
                                                        zzibVar.zzf(zzfzVar3.zzb);
                                                    }
                                                }
                                            }
                                            i56 = i53;
                                            iZzg = i48;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                        } else {
                                            int i1019 = zzga.zza;
                                            zzibVar2 = (zzib) zzhoVar;
                                            iZzh5 = zzga.zzh(bArr, i48, zzfzVar3);
                                            i57 = zzfzVar3.zza + iZzh5;
                                            while (iZzh5 < i57) {
                                                iZzh5 = zzga.zzk(bArr, iZzh5, zzfzVar3);
                                                zzibVar2.zzf(zzfzVar3.zzb);
                                            }
                                            if (iZzh5 != i57) {
                                                throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        iZzg = iZzh5;
                                        i56 = i53;
                                        if (iZzg != i48) {
                                            zzfzVar5 = zzfzVar3;
                                            i92 = i49;
                                            unsafe8 = unsafe5;
                                            i90 = i47;
                                            i93 = i10;
                                            i88 = 0;
                                            i91 = i9;
                                            i89 = i56;
                                            obj3 = obj;
                                            i3 = i3;
                                            i87 = i46;
                                        } else {
                                            i4 = i3;
                                            i8 = iZzg;
                                            i11 = i49;
                                            unsafe = unsafe5;
                                            i13 = i47;
                                            i88 = i56;
                                            zzfzVar2 = zzfzVar3;
                                            obj3 = obj;
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case 39:
                                    case 43:
                                        i58 = i40;
                                        zzfzVar3 = zzfzVar3;
                                        i47 = i17;
                                        i48 = i39;
                                        unsafe5 = unsafe5;
                                        i59 = i42;
                                        if (i15 == 2) {
                                            iZzg = zzga.zzf(bArr, i48, zzhoVar, zzfzVar3);
                                            i46 = i58;
                                            i56 = i59;
                                            i49 = i41;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                        } else if (i15 == 0) {
                                            i46 = i58;
                                            i49 = i41;
                                            i53 = i59;
                                            iZzg = zzga.zzj(i47, bArr, i48, i2, zzhoVar, zzfzVar);
                                            i56 = i53;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                        } else {
                                            i46 = i58;
                                            i49 = i41;
                                            i56 = i59;
                                            iZzg = i48;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case 40:
                                    case 46:
                                        i58 = i40;
                                        zzfzVar3 = zzfzVar3;
                                        i47 = i17;
                                        i48 = i39;
                                        unsafe5 = unsafe5;
                                        i59 = i42;
                                        if (i15 == 2) {
                                            if (i15 == 1) {
                                                iZzg = i48 + 8;
                                                int i1111 = zzga.zza;
                                                zzibVar3 = (zzib) zzhoVar;
                                                zzibVar3.zzf(zzga.zzn(bArr, i48));
                                                while (iZzg < i58) {
                                                    iZzh7 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                    if (i47 == zzfzVar3.zza) {
                                                        zzibVar3.zzf(zzga.zzn(bArr, iZzh7));
                                                        iZzg = iZzh7 + 8;
                                                    }
                                                }
                                            }
                                            i46 = i58;
                                            i56 = i59;
                                            i49 = i41;
                                            iZzg = i48;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                        } else {
                                            int i1112 = zzga.zza;
                                            zzibVar4 = (zzib) zzhoVar;
                                            iZzg = zzga.zzh(bArr, i48, zzfzVar3);
                                            i60 = zzfzVar3.zza;
                                            i61 = iZzg + i60;
                                            if (i61 <= bArr.length) {
                                                throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzibVar4.zzg(zzibVar4.size() + (i60 / 8));
                                            while (iZzg < i61) {
                                                zzibVar4.zzf(zzga.zzn(bArr, iZzg));
                                                iZzg += 8;
                                            }
                                            if (iZzg != i61) {
                                                throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i46 = i58;
                                        i56 = i59;
                                        i49 = i41;
                                        if (iZzg != i48) {
                                            zzfzVar5 = zzfzVar3;
                                            i92 = i49;
                                            unsafe8 = unsafe5;
                                            i90 = i47;
                                            i93 = i10;
                                            i88 = 0;
                                            i91 = i9;
                                            i89 = i56;
                                            obj3 = obj;
                                            i3 = i3;
                                            i87 = i46;
                                        } else {
                                            i4 = i3;
                                            i8 = iZzg;
                                            i11 = i49;
                                            unsafe = unsafe5;
                                            i13 = i47;
                                            i88 = i56;
                                            zzfzVar2 = zzfzVar3;
                                            obj3 = obj;
                                        }
                                        break;
                                    case 24:
                                    case 31:
                                    case 41:
                                    case 45:
                                        i58 = i40;
                                        zzfzVar3 = zzfzVar3;
                                        i47 = i17;
                                        i48 = i39;
                                        unsafe5 = unsafe5;
                                        i59 = i42;
                                        if (i15 == 2) {
                                            if (i15 == 5) {
                                                iZzg = i48 + 4;
                                                int i1113 = zzga.zza;
                                                zzhlVar = (zzhl) zzhoVar;
                                                zzhlVar.zzg(zzga.zzb(bArr, i48));
                                                while (iZzg < i58) {
                                                    iZzh8 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                    if (i47 == zzfzVar3.zza) {
                                                        zzhlVar.zzg(zzga.zzb(bArr, iZzh8));
                                                        iZzg = iZzh8 + 4;
                                                    }
                                                }
                                            }
                                            i46 = i58;
                                            i56 = i59;
                                            i49 = i41;
                                            iZzg = i48;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                        } else {
                                            int i1114 = zzga.zza;
                                            zzhlVar2 = (zzhl) zzhoVar;
                                            iZzg = zzga.zzh(bArr, i48, zzfzVar3);
                                            i62 = zzfzVar3.zza;
                                            i63 = iZzg + i62;
                                            if (i63 <= bArr.length) {
                                                throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzhlVar2.zzh(zzhlVar2.size() + (i62 / 4));
                                            while (iZzg < i63) {
                                                zzhlVar2.zzg(zzga.zzb(bArr, iZzg));
                                                iZzg += 4;
                                            }
                                            if (iZzg != i63) {
                                                throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i46 = i58;
                                        i56 = i59;
                                        i49 = i41;
                                        if (iZzg != i48) {
                                            zzfzVar5 = zzfzVar3;
                                            i92 = i49;
                                            unsafe8 = unsafe5;
                                            i90 = i47;
                                            i93 = i10;
                                            i88 = 0;
                                            i91 = i9;
                                            i89 = i56;
                                            obj3 = obj;
                                            i3 = i3;
                                            i87 = i46;
                                        } else {
                                            i4 = i3;
                                            i8 = iZzg;
                                            i11 = i49;
                                            unsafe = unsafe5;
                                            i13 = i47;
                                            i88 = i56;
                                            zzfzVar2 = zzfzVar3;
                                            obj3 = obj;
                                        }
                                        break;
                                    case 25:
                                    case 42:
                                        i58 = i40;
                                        zzfzVar3 = zzfzVar3;
                                        i47 = i17;
                                        i48 = i39;
                                        unsafe5 = unsafe5;
                                        i59 = i42;
                                        if (i15 == 2) {
                                            if (i15 == 0) {
                                                int i1115 = zzga.zza;
                                                zzgbVar = (zzgb) zzhoVar;
                                                iZzg = zzga.zzk(bArr, i48, zzfzVar3);
                                                if (zzfzVar3.zzb != 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                zzgbVar.zze(z2);
                                                while (iZzg < i58) {
                                                    iZzh9 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                    if (i47 == zzfzVar3.zza) {
                                                        iZzg = zzga.zzk(bArr, iZzh9, zzfzVar3);
                                                        if (zzfzVar3.zzb != 0) {
                                                            z3 = true;
                                                        } else {
                                                            z3 = false;
                                                        }
                                                        zzgbVar.zze(z3);
                                                    }
                                                }
                                            }
                                            i46 = i58;
                                            i56 = i59;
                                            i49 = i41;
                                            iZzg = i48;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                        } else {
                                            int i1116 = zzga.zza;
                                            zzgbVar2 = (zzgb) zzhoVar;
                                            iZzg = zzga.zzh(bArr, i48, zzfzVar3);
                                            i64 = zzfzVar3.zza + iZzg;
                                            while (iZzg < i64) {
                                                iZzg = zzga.zzk(bArr, iZzg, zzfzVar3);
                                                if (zzfzVar3.zzb != 0) {
                                                    z4 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                zzgbVar2.zze(z4);
                                            }
                                            if (iZzg != i64) {
                                                throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i46 = i58;
                                        i56 = i59;
                                        i49 = i41;
                                        if (iZzg != i48) {
                                            zzfzVar5 = zzfzVar3;
                                            i92 = i49;
                                            unsafe8 = unsafe5;
                                            i90 = i47;
                                            i93 = i10;
                                            i88 = 0;
                                            i91 = i9;
                                            i89 = i56;
                                            obj3 = obj;
                                            i3 = i3;
                                            i87 = i46;
                                        } else {
                                            i4 = i3;
                                            i8 = iZzg;
                                            i11 = i49;
                                            unsafe = unsafe5;
                                            i13 = i47;
                                            i88 = i56;
                                            zzfzVar2 = zzfzVar3;
                                            obj3 = obj;
                                        }
                                        break;
                                    case 26:
                                        zzfzVar3 = zzfzVar3;
                                        i47 = i17;
                                        i48 = i39;
                                        i59 = i42;
                                        if (i15 == 2) {
                                            unsafe5 = unsafe5;
                                            i46 = i40;
                                            i49 = i41;
                                            i56 = i59;
                                            iZzg = i48;
                                        } else if ((j2 & 536870912) == 0) {
                                            iZzg = zzga.zzh(bArr, i48, zzfzVar3);
                                            i69 = zzfzVar3.zza;
                                            if (i69 >= 0) {
                                                throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            if (i69 == 0) {
                                                obj2 = "";
                                                zzhoVar.add(obj2);
                                            } else {
                                                obj2 = "";
                                                zzhoVar.add(new String(bArr, iZzg, i69, zzhp.zza));
                                                iZzg += i69;
                                            }
                                            while (iZzg < i40) {
                                                iZzh12 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                if (i47 == zzfzVar3.zza) {
                                                    iZzg = zzga.zzh(bArr, iZzh12, zzfzVar3);
                                                    i70 = zzfzVar3.zza;
                                                    if (i70 >= 0) {
                                                        throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i70 == 0) {
                                                        zzhoVar.add(obj2);
                                                    } else {
                                                        zzhoVar.add(new String(bArr, iZzg, i70, zzhp.zza));
                                                        iZzg += i70;
                                                    }
                                                } else {
                                                    unsafe5 = unsafe5;
                                                    i46 = i40;
                                                    i49 = i41;
                                                    i56 = i59;
                                                }
                                            }
                                            unsafe5 = unsafe5;
                                            i46 = i40;
                                            i49 = i41;
                                            i56 = i59;
                                        } else {
                                            iZzh10 = zzga.zzh(bArr, i48, zzfzVar3);
                                            i65 = zzfzVar3.zza;
                                            if (i65 >= 0) {
                                                throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            if (i65 == 0) {
                                                zzhoVar.add("");
                                            } else {
                                                i66 = iZzh10 + i65;
                                                if (zzjt.zzd(bArr, iZzh10, i66)) {
                                                    throw new zzhr(str);
                                                }
                                                zzhoVar.add(new String(bArr, iZzh10, i65, zzhp.zza));
                                                iZzh10 = i66;
                                            }
                                            while (iZzh10 < i40) {
                                                iZzh11 = zzga.zzh(bArr, iZzh10, zzfzVar3);
                                                if (i47 == zzfzVar3.zza) {
                                                    iZzh10 = zzga.zzh(bArr, iZzh11, zzfzVar3);
                                                    i67 = zzfzVar3.zza;
                                                    if (i67 >= 0) {
                                                        throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i67 == 0) {
                                                        zzhoVar.add("");
                                                    } else {
                                                        i68 = iZzh10 + i67;
                                                        if (zzjt.zzd(bArr, iZzh10, i68)) {
                                                            throw new zzhr(str);
                                                        }
                                                        zzhoVar.add(new String(bArr, iZzh10, i67, zzhp.zza));
                                                        iZzh10 = i68;
                                                    }
                                                } else {
                                                    iZzg = iZzh10;
                                                    i46 = i40;
                                                    i56 = i59;
                                                    i49 = i41;
                                                    unsafe5 = unsafe5;
                                                }
                                            }
                                            iZzg = iZzh10;
                                            i46 = i40;
                                            i56 = i59;
                                            i49 = i41;
                                            unsafe5 = unsafe5;
                                        }
                                        if (iZzg != i48) {
                                            zzfzVar5 = zzfzVar3;
                                            i92 = i49;
                                            unsafe8 = unsafe5;
                                            i90 = i47;
                                            i93 = i10;
                                            i88 = 0;
                                            i91 = i9;
                                            i89 = i56;
                                            obj3 = obj;
                                            i3 = i3;
                                            i87 = i46;
                                        } else {
                                            i4 = i3;
                                            i8 = iZzg;
                                            i11 = i49;
                                            unsafe = unsafe5;
                                            i13 = i47;
                                            i88 = i56;
                                            zzfzVar2 = zzfzVar3;
                                            obj3 = obj;
                                        }
                                        break;
                                    case 27:
                                        i40 = i40;
                                        i41 = i41;
                                        if (i15 == 2) {
                                            zzfzVar3 = zzfzVar3;
                                            i47 = i17;
                                            i48 = i39;
                                            unsafe5 = unsafe5;
                                            i49 = i41;
                                            i56 = i42;
                                            iZzg = zzga.zze(zzv(i42), i17, bArr, i39, i2, zzhoVar, zzfzVar);
                                            i46 = i40;
                                        } else {
                                            i56 = i42;
                                            i47 = i17;
                                            i48 = i39;
                                            int i1117 = i40;
                                            i49 = i41;
                                            i46 = i1117;
                                            iZzg = i48;
                                        }
                                        if (iZzg != i48) {
                                            zzfzVar5 = zzfzVar3;
                                            i92 = i49;
                                            unsafe8 = unsafe5;
                                            i90 = i47;
                                            i93 = i10;
                                            i88 = 0;
                                            i91 = i9;
                                            i89 = i56;
                                            obj3 = obj;
                                            i3 = i3;
                                            i87 = i46;
                                        } else {
                                            i4 = i3;
                                            i8 = iZzg;
                                            i11 = i49;
                                            unsafe = unsafe5;
                                            i13 = i47;
                                            i88 = i56;
                                            zzfzVar2 = zzfzVar3;
                                            obj3 = obj;
                                        }
                                        break;
                                    case 28:
                                        i40 = i40;
                                        i71 = i17;
                                        i72 = i39;
                                        i41 = i41;
                                        if (i15 == 2) {
                                            iZzg = zzga.zzh(bArr, i72, zzfzVar3);
                                            i73 = zzfzVar3.zza;
                                            if (i73 >= 0) {
                                                throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            if (i73 <= bArr.length - iZzg) {
                                                throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            if (i73 == 0) {
                                                zzhoVar.add(zzgk.zzb);
                                            } else {
                                                zzhoVar.add(zzgk.zzj(bArr, iZzg, i73));
                                                iZzg += i73;
                                            }
                                            while (iZzg < i40) {
                                                iZzh13 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                if (i71 == zzfzVar3.zza) {
                                                    i56 = i42;
                                                    i47 = i71;
                                                    i48 = i72;
                                                    int i1118 = i40;
                                                    i49 = i41;
                                                    i46 = i1118;
                                                    if (iZzg != i48) {
                                                        zzfzVar5 = zzfzVar3;
                                                        i92 = i49;
                                                        unsafe8 = unsafe5;
                                                        i90 = i47;
                                                        i93 = i10;
                                                        i88 = 0;
                                                        i91 = i9;
                                                        i89 = i56;
                                                        obj3 = obj;
                                                        i3 = i3;
                                                        i87 = i46;
                                                    } else {
                                                        i4 = i3;
                                                        i8 = iZzg;
                                                        i11 = i49;
                                                        unsafe = unsafe5;
                                                        i13 = i47;
                                                        i88 = i56;
                                                        zzfzVar2 = zzfzVar3;
                                                        obj3 = obj;
                                                    }
                                                    break;
                                                } else {
                                                    iZzg = zzga.zzh(bArr, iZzh13, zzfzVar3);
                                                    i74 = zzfzVar3.zza;
                                                    if (i74 >= 0) {
                                                        throw new zzhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i74 <= bArr.length - iZzg) {
                                                        throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    if (i74 == 0) {
                                                        zzhoVar.add(zzgk.zzb);
                                                    } else {
                                                        zzhoVar.add(zzgk.zzj(bArr, iZzg, i74));
                                                        iZzg += i74;
                                                    }
                                                }
                                            }
                                            i56 = i42;
                                            i47 = i71;
                                            i48 = i72;
                                            int i1119 = i40;
                                            i49 = i41;
                                            i46 = i1119;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                        } else {
                                            i56 = i42;
                                            i47 = i71;
                                            i48 = i72;
                                            int i11110 = i40;
                                            i49 = i41;
                                            i46 = i11110;
                                            iZzg = i48;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                        }
                                        break;
                                    case 30:
                                    case 44:
                                        i71 = i17;
                                        i72 = i39;
                                        if (i15 == 2) {
                                            if (i15 == 0) {
                                                iZzj = zzga.zzj(i71, bArr, i72, i2, zzhoVar, zzfzVar);
                                            }
                                            i46 = i40;
                                            zzfzVar3 = zzfzVar3;
                                            i49 = i41;
                                            unsafe5 = unsafe5;
                                            i56 = i42;
                                            i47 = i71;
                                            i48 = i72;
                                            iZzg = i48;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                        } else {
                                            iZzj = zzga.zzf(bArr, i72, zzhoVar, zzfzVar3);
                                        }
                                        zzhmVarZzu = zzu(i42);
                                        zzjjVar = this.zzl;
                                        int i129 = zziz.zza;
                                        if (zzhmVarZzu != null) {
                                            i75 = iZzj;
                                            i76 = i42;
                                        } else if (zzhoVar instanceof RandomAccess) {
                                            size2 = zzhoVar.size();
                                            i75 = iZzj;
                                            objZzn2 = null;
                                            i77 = 0;
                                            i78 = 0;
                                            while (i77 < size2) {
                                                int i1210 = i42;
                                                iIntValue2 = ((Integer) zzhoVar.get(i77)).intValue();
                                                if (zzhmVarZzu.zza(iIntValue2)) {
                                                    if (i77 != i78) {
                                                        zzhoVar.set(i78, Integer.valueOf(iIntValue2));
                                                    }
                                                    i78++;
                                                } else {
                                                    objZzn2 = zziz.zzn(obj3, i41, iIntValue2, objZzn2, zzjjVar);
                                                }
                                                i77++;
                                                i42 = i1210;
                                            }
                                            i76 = i42;
                                            if (i78 != size2) {
                                                zzhoVar.subList(i78, size2).clear();
                                            }
                                        } else {
                                            i75 = iZzj;
                                            i76 = i42;
                                            it = zzhoVar.iterator();
                                            objZzn = null;
                                            while (it.hasNext()) {
                                                iIntValue = ((Integer) it.next()).intValue();
                                                if (!zzhmVarZzu.zza(iIntValue)) {
                                                    objZzn = zziz.zzn(obj3, i41, iIntValue, objZzn, zzjjVar);
                                                    it.remove();
                                                }
                                            }
                                        }
                                        iZzg = i75;
                                        i56 = i76;
                                        i47 = i71;
                                        i48 = i72;
                                        int i11111 = i40;
                                        i49 = i41;
                                        i46 = i11111;
                                        if (iZzg != i48) {
                                            zzfzVar5 = zzfzVar3;
                                            i92 = i49;
                                            unsafe8 = unsafe5;
                                            i90 = i47;
                                            i93 = i10;
                                            i88 = 0;
                                            i91 = i9;
                                            i89 = i56;
                                            obj3 = obj;
                                            i3 = i3;
                                            i87 = i46;
                                        } else {
                                            i4 = i3;
                                            i8 = iZzg;
                                            i11 = i49;
                                            unsafe = unsafe5;
                                            i13 = i47;
                                            i88 = i56;
                                            zzfzVar2 = zzfzVar3;
                                            obj3 = obj;
                                        }
                                        break;
                                    case 33:
                                    case 47:
                                        i71 = i17;
                                        i72 = i39;
                                        if (i15 == 2) {
                                            if (i15 == 0) {
                                                int i1211 = zzga.zza;
                                                zzhlVar3 = (zzhl) zzhoVar;
                                                iZzg = zzga.zzh(bArr, i72, zzfzVar3);
                                                zzhlVar3.zzg(zzgn.zzb(zzfzVar3.zza));
                                                while (iZzg < i40) {
                                                    iZzh14 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                    if (i71 == zzfzVar3.zza) {
                                                        iZzg = zzga.zzh(bArr, iZzh14, zzfzVar3);
                                                        zzhlVar3.zzg(zzgn.zzb(zzfzVar3.zza));
                                                    }
                                                }
                                            }
                                            i46 = i40;
                                            zzfzVar3 = zzfzVar3;
                                            i49 = i41;
                                            unsafe5 = unsafe5;
                                            i56 = i42;
                                            i47 = i71;
                                            i48 = i72;
                                            iZzg = i48;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                        } else {
                                            int i1212 = zzga.zza;
                                            zzhlVar4 = (zzhl) zzhoVar;
                                            iZzg = zzga.zzh(bArr, i72, zzfzVar3);
                                            i79 = zzfzVar3.zza + iZzg;
                                            while (iZzg < i79) {
                                                iZzg = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                zzhlVar4.zzg(zzgn.zzb(zzfzVar3.zza));
                                            }
                                            if (iZzg != i79) {
                                                throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i46 = i40;
                                        zzfzVar3 = zzfzVar3;
                                        i49 = i41;
                                        unsafe5 = unsafe5;
                                        i56 = i42;
                                        i47 = i71;
                                        i48 = i72;
                                        if (iZzg != i48) {
                                            zzfzVar5 = zzfzVar3;
                                            i92 = i49;
                                            unsafe8 = unsafe5;
                                            i90 = i47;
                                            i93 = i10;
                                            i88 = 0;
                                            i91 = i9;
                                            i89 = i56;
                                            obj3 = obj;
                                            i3 = i3;
                                            i87 = i46;
                                        } else {
                                            i4 = i3;
                                            i8 = iZzg;
                                            i11 = i49;
                                            unsafe = unsafe5;
                                            i13 = i47;
                                            i88 = i56;
                                            zzfzVar2 = zzfzVar3;
                                            obj3 = obj;
                                        }
                                        break;
                                    case 34:
                                    case 48:
                                        if (i15 == 2) {
                                            int i1213 = zzga.zza;
                                            zzibVar6 = (zzib) zzhoVar;
                                            iZzg = zzga.zzh(bArr, i39, zzfzVar3);
                                            i80 = zzfzVar3.zza + iZzg;
                                            while (iZzg < i80) {
                                                iZzg = zzga.zzk(bArr, iZzg, zzfzVar3);
                                                zzibVar6.zzf(zzgn.zzc(zzfzVar3.zzb));
                                            }
                                            if (iZzg == i80) {
                                                throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            i46 = i40;
                                            i48 = i39;
                                            zzfzVar3 = zzfzVar3;
                                            i47 = i17;
                                            i49 = i41;
                                            unsafe5 = unsafe5;
                                            i56 = i42;
                                            if (iZzg != i48) {
                                                zzfzVar5 = zzfzVar3;
                                                i92 = i49;
                                                unsafe8 = unsafe5;
                                                i90 = i47;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                i89 = i56;
                                                obj3 = obj;
                                                i3 = i3;
                                                i87 = i46;
                                            } else {
                                                i4 = i3;
                                                i8 = iZzg;
                                                i11 = i49;
                                                unsafe = unsafe5;
                                                i13 = i47;
                                                i88 = i56;
                                                zzfzVar2 = zzfzVar3;
                                                obj3 = obj;
                                            }
                                        } else {
                                            i72 = i39;
                                            if (i15 == 0) {
                                                int i1214 = zzga.zza;
                                                zzibVar5 = (zzib) zzhoVar;
                                                iZzg = zzga.zzk(bArr, i72, zzfzVar3);
                                                zzibVar5.zzf(zzgn.zzc(zzfzVar3.zzb));
                                                while (true) {
                                                    if (iZzg < i40) {
                                                        iZzh15 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                        i71 = i17;
                                                        if (i71 == zzfzVar3.zza) {
                                                            iZzg = zzga.zzk(bArr, iZzh15, zzfzVar3);
                                                            zzibVar5.zzf(zzgn.zzc(zzfzVar3.zzb));
                                                            i17 = i71;
                                                        }
                                                    } else {
                                                        i71 = i17;
                                                    }
                                                }
                                                i46 = i40;
                                                zzfzVar3 = zzfzVar3;
                                                i49 = i41;
                                                unsafe5 = unsafe5;
                                                i56 = i42;
                                                i47 = i71;
                                                i48 = i72;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            } else {
                                                i46 = i40;
                                                i48 = i72;
                                                zzfzVar3 = zzfzVar3;
                                                i47 = i17;
                                                i49 = i41;
                                                unsafe5 = unsafe5;
                                                i56 = i42;
                                                iZzg = i48;
                                                if (iZzg != i48) {
                                                    zzfzVar5 = zzfzVar3;
                                                    i92 = i49;
                                                    unsafe8 = unsafe5;
                                                    i90 = i47;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    i89 = i56;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                    i87 = i46;
                                                } else {
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i11 = i49;
                                                    unsafe = unsafe5;
                                                    i13 = i47;
                                                    i88 = i56;
                                                    zzfzVar2 = zzfzVar3;
                                                    obj3 = obj;
                                                }
                                            }
                                        }
                                        break;
                                    default:
                                        i46 = i40;
                                        zzfzVar3 = zzfzVar3;
                                        i47 = i17;
                                        i48 = i39;
                                        i49 = i41;
                                        unsafe5 = unsafe5;
                                        if (i15 == 3) {
                                            i81 = (i47 & (-8)) | 4;
                                            zzixVarZzv = zzv(i42);
                                            i56 = i42;
                                            iZzg = zzga.zzc(zzixVarZzv, bArr, i48, i2, i81, zzfzVar);
                                            zzhoVar.add(zzfzVar3.zzc);
                                            while (iZzg < i46) {
                                                iZzh16 = zzga.zzh(bArr, iZzg, zzfzVar3);
                                                if (i47 == zzfzVar3.zza) {
                                                    iZzg = zzga.zzc(zzixVarZzv, bArr, iZzh16, i2, i81, zzfzVar);
                                                    zzhoVar.add(zzfzVar3.zzc);
                                                }
                                            }
                                        } else {
                                            i56 = i42;
                                            iZzg = i48;
                                        }
                                        if (iZzg != i48) {
                                            zzfzVar5 = zzfzVar3;
                                            i92 = i49;
                                            unsafe8 = unsafe5;
                                            i90 = i47;
                                            i93 = i10;
                                            i88 = 0;
                                            i91 = i9;
                                            i89 = i56;
                                            obj3 = obj;
                                            i3 = i3;
                                            i87 = i46;
                                        } else {
                                            i4 = i3;
                                            i8 = iZzg;
                                            i11 = i49;
                                            unsafe = unsafe5;
                                            i13 = i47;
                                            i88 = i56;
                                            zzfzVar2 = zzfzVar3;
                                            obj3 = obj;
                                        }
                                        break;
                                }
                            } else {
                                unsafe3 = unsafe2;
                                i43 = i42;
                                i44 = i17;
                                i11 = i41;
                                if (iZzr == 50) {
                                    zzfzVar2 = zzfzVar3;
                                    obj3 = obj;
                                    unsafe = unsafe3;
                                    unsafe7 = zzb;
                                    j3 = iArr[i43 + 2] & 1048575;
                                    switch (iZzr) {
                                        case 51:
                                            i43 = i43;
                                            zzfzVar2 = zzfzVar2;
                                            i13 = i44;
                                            i82 = i39;
                                            if (i15 == 1) {
                                                iZzg = i82 + 8;
                                                unsafe7.putObject(obj3, j, Double.valueOf(Double.longBitsToDouble(zzga.zzn(bArr, i82))));
                                                unsafe7.putInt(obj3, j3, i11);
                                            } else {
                                                iZzg = i82;
                                            }
                                            if (iZzg != i82) {
                                                i11 = i11;
                                                i87 = i2;
                                                i3 = i3;
                                                i92 = i11;
                                                i90 = i13;
                                                zzfzVar5 = zzfzVar2;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                unsafe8 = unsafe;
                                                i89 = i43;
                                            } else {
                                                i11 = i11;
                                                i4 = i3;
                                                i8 = iZzg;
                                                i88 = i43;
                                            }
                                            break;
                                        case 52:
                                            i43 = i43;
                                            zzfzVar2 = zzfzVar2;
                                            i13 = i44;
                                            i82 = i39;
                                            if (i15 == 5) {
                                                iZzg = i82 + 4;
                                                unsafe7.putObject(obj3, j, Float.valueOf(Float.intBitsToFloat(zzga.zzb(bArr, i82))));
                                                unsafe7.putInt(obj3, j3, i11);
                                            } else {
                                                iZzg = i82;
                                            }
                                            if (iZzg != i82) {
                                                i11 = i11;
                                                i87 = i2;
                                                i3 = i3;
                                                i92 = i11;
                                                i90 = i13;
                                                zzfzVar5 = zzfzVar2;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                unsafe8 = unsafe;
                                                i89 = i43;
                                            } else {
                                                i11 = i11;
                                                i4 = i3;
                                                i8 = iZzg;
                                                i88 = i43;
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            i43 = i43;
                                            zzfzVar2 = zzfzVar2;
                                            i13 = i44;
                                            i82 = i39;
                                            if (i15 == 0) {
                                                iZzk = zzga.zzk(bArr, i82, zzfzVar2);
                                                unsafe7.putObject(obj3, j, Long.valueOf(zzfzVar2.zzb));
                                                unsafe7.putInt(obj3, j3, i11);
                                                iZzg = iZzk;
                                            } else {
                                                iZzg = i82;
                                            }
                                            if (iZzg != i82) {
                                                i11 = i11;
                                                i87 = i2;
                                                i3 = i3;
                                                i92 = i11;
                                                i90 = i13;
                                                zzfzVar5 = zzfzVar2;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                unsafe8 = unsafe;
                                                i89 = i43;
                                            } else {
                                                i11 = i11;
                                                i4 = i3;
                                                i8 = iZzg;
                                                i88 = i43;
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            i43 = i43;
                                            zzfzVar2 = zzfzVar2;
                                            i13 = i44;
                                            i82 = i39;
                                            if (i15 == 0) {
                                                iZzg = zzga.zzh(bArr, i82, zzfzVar2);
                                                unsafe7.putObject(obj3, j, Integer.valueOf(zzfzVar2.zza));
                                                unsafe7.putInt(obj3, j3, i11);
                                            } else {
                                                iZzg = i82;
                                            }
                                            if (iZzg != i82) {
                                                i11 = i11;
                                                i87 = i2;
                                                i3 = i3;
                                                i92 = i11;
                                                i90 = i13;
                                                zzfzVar5 = zzfzVar2;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                unsafe8 = unsafe;
                                                i89 = i43;
                                            } else {
                                                i11 = i11;
                                                i4 = i3;
                                                i8 = iZzg;
                                                i88 = i43;
                                            }
                                            break;
                                        case 56:
                                        case 65:
                                            i43 = i43;
                                            zzfzVar2 = zzfzVar2;
                                            i13 = i44;
                                            i82 = i39;
                                            if (i15 == 1) {
                                                iZzg = i82 + 8;
                                                unsafe7.putObject(obj3, j, Long.valueOf(zzga.zzn(bArr, i82)));
                                                unsafe7.putInt(obj3, j3, i11);
                                            } else {
                                                iZzg = i82;
                                            }
                                            if (iZzg != i82) {
                                                i11 = i11;
                                                i87 = i2;
                                                i3 = i3;
                                                i92 = i11;
                                                i90 = i13;
                                                zzfzVar5 = zzfzVar2;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                unsafe8 = unsafe;
                                                i89 = i43;
                                            } else {
                                                i11 = i11;
                                                i4 = i3;
                                                i8 = iZzg;
                                                i88 = i43;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            i43 = i43;
                                            zzfzVar2 = zzfzVar2;
                                            i13 = i44;
                                            i82 = i39;
                                            if (i15 == 5) {
                                                iZzg = i82 + 4;
                                                unsafe7.putObject(obj3, j, Integer.valueOf(zzga.zzb(bArr, i82)));
                                                unsafe7.putInt(obj3, j3, i11);
                                            } else {
                                                iZzg = i82;
                                            }
                                            if (iZzg != i82) {
                                                i11 = i11;
                                                i87 = i2;
                                                i3 = i3;
                                                i92 = i11;
                                                i90 = i13;
                                                zzfzVar5 = zzfzVar2;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                unsafe8 = unsafe;
                                                i89 = i43;
                                            } else {
                                                i11 = i11;
                                                i4 = i3;
                                                i8 = iZzg;
                                                i88 = i43;
                                            }
                                            break;
                                        case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                                            i43 = i43;
                                            zzfzVar2 = zzfzVar2;
                                            i13 = i44;
                                            i82 = i39;
                                            if (i15 == 0) {
                                                iZzk = zzga.zzk(bArr, i82, zzfzVar2);
                                                if (zzfzVar2.zzb != 0) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                unsafe7.putObject(obj3, j, Boolean.valueOf(z5));
                                                unsafe7.putInt(obj3, j3, i11);
                                                iZzg = iZzk;
                                            } else {
                                                iZzg = i82;
                                            }
                                            if (iZzg != i82) {
                                                i11 = i11;
                                                i87 = i2;
                                                i3 = i3;
                                                i92 = i11;
                                                i90 = i13;
                                                zzfzVar5 = zzfzVar2;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                unsafe8 = unsafe;
                                                i89 = i43;
                                            } else {
                                                i11 = i11;
                                                i4 = i3;
                                                i8 = iZzg;
                                                i88 = i43;
                                            }
                                            break;
                                        case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                                            i43 = i43;
                                            zzfzVar2 = zzfzVar2;
                                            i13 = i44;
                                            i82 = i39;
                                            if (i15 == 2) {
                                                iZzg = zzga.zzh(bArr, i82, zzfzVar2);
                                                i83 = zzfzVar2.zza;
                                                if (i83 == 0) {
                                                    unsafe7.putObject(obj3, j, "");
                                                } else {
                                                    i84 = iZzg + i83;
                                                    if ((i16 & 536870912) == 0) {
                                                    }
                                                    unsafe7.putObject(obj3, j, new String(bArr, iZzg, i83, zzhp.zza));
                                                    iZzg = i84;
                                                }
                                                unsafe7.putInt(obj3, j3, i11);
                                            } else {
                                                iZzg = i82;
                                            }
                                            if (iZzg != i82) {
                                                i11 = i11;
                                                i87 = i2;
                                                i3 = i3;
                                                i92 = i11;
                                                i90 = i13;
                                                zzfzVar5 = zzfzVar2;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                unsafe8 = unsafe;
                                                i89 = i43;
                                            } else {
                                                i11 = i11;
                                                i4 = i3;
                                                i8 = iZzg;
                                                i88 = i43;
                                            }
                                            break;
                                        case 60:
                                            i85 = i44;
                                            i82 = i39;
                                            if (i15 == 2) {
                                                Object objZzy3 = zzy(obj3, i11, i43);
                                                zzfzVar2 = zzfzVar2;
                                                iZzg = zzga.zzm(objZzy3, zzv(i43), bArr, i82, i2, zzfzVar);
                                                zzG(obj3, i11, i43, objZzy3);
                                                i43 = i43;
                                                i13 = i85;
                                            } else {
                                                i13 = i85;
                                                iZzg = i82;
                                            }
                                            if (iZzg != i82) {
                                                i11 = i11;
                                                i87 = i2;
                                                i3 = i3;
                                                i92 = i11;
                                                i90 = i13;
                                                zzfzVar5 = zzfzVar2;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                unsafe8 = unsafe;
                                                i89 = i43;
                                            } else {
                                                i11 = i11;
                                                i4 = i3;
                                                i8 = iZzg;
                                                i88 = i43;
                                            }
                                            break;
                                        case 61:
                                            i85 = i44;
                                            i82 = i39;
                                            if (i15 == 2) {
                                                iZzg = zzga.zza(bArr, i82, zzfzVar2);
                                                unsafe7.putObject(obj3, j, zzfzVar2.zzc);
                                                unsafe7.putInt(obj3, j3, i11);
                                                i13 = i85;
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                            }
                                            i13 = i85;
                                            iZzg = i82;
                                            if (iZzg != i82) {
                                                i11 = i11;
                                                i87 = i2;
                                                i3 = i3;
                                                i92 = i11;
                                                i90 = i13;
                                                zzfzVar5 = zzfzVar2;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                unsafe8 = unsafe;
                                                i89 = i43;
                                            } else {
                                                i11 = i11;
                                                i4 = i3;
                                                i8 = iZzg;
                                                i88 = i43;
                                            }
                                            break;
                                        case 63:
                                            i85 = i44;
                                            i82 = i39;
                                            if (i15 == 0) {
                                                iZzg = zzga.zzh(bArr, i82, zzfzVar2);
                                                i86 = zzfzVar2.zza;
                                                zzhmVarZzu2 = zzu(i43);
                                                if (zzhmVarZzu2 != null) {
                                                    unsafe7.putObject(obj3, j, Integer.valueOf(i86));
                                                    unsafe7.putInt(obj3, j3, i11);
                                                } else {
                                                    unsafe7.putObject(obj3, j, Integer.valueOf(i86));
                                                    unsafe7.putInt(obj3, j3, i11);
                                                }
                                                i13 = i85;
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                            }
                                            i13 = i85;
                                            iZzg = i82;
                                            if (iZzg != i82) {
                                                i11 = i11;
                                                i87 = i2;
                                                i3 = i3;
                                                i92 = i11;
                                                i90 = i13;
                                                zzfzVar5 = zzfzVar2;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                unsafe8 = unsafe;
                                                i89 = i43;
                                            } else {
                                                i11 = i11;
                                                i4 = i3;
                                                i8 = iZzg;
                                                i88 = i43;
                                            }
                                            break;
                                        case 66:
                                            i85 = i44;
                                            i82 = i39;
                                            if (i15 == 0) {
                                                iZzg = zzga.zzh(bArr, i82, zzfzVar2);
                                                unsafe7.putObject(obj3, j, Integer.valueOf(zzgn.zzb(zzfzVar2.zza)));
                                                unsafe7.putInt(obj3, j3, i11);
                                                i13 = i85;
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                            }
                                            i13 = i85;
                                            iZzg = i82;
                                            if (iZzg != i82) {
                                                i11 = i11;
                                                i87 = i2;
                                                i3 = i3;
                                                i92 = i11;
                                                i90 = i13;
                                                zzfzVar5 = zzfzVar2;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                unsafe8 = unsafe;
                                                i89 = i43;
                                            } else {
                                                i11 = i11;
                                                i4 = i3;
                                                i8 = iZzg;
                                                i88 = i43;
                                            }
                                            break;
                                        case 67:
                                            i85 = i44;
                                            if (i15 == 0) {
                                                i82 = i39;
                                                int iZzk7 = zzga.zzk(bArr, i82, zzfzVar2);
                                                unsafe7.putObject(obj3, j, Long.valueOf(zzgn.zzc(zzfzVar2.zzb)));
                                                unsafe7.putInt(obj3, j3, i11);
                                                iZzg = iZzk7;
                                                i13 = i85;
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                            } else {
                                                i82 = i39;
                                                i13 = i85;
                                                iZzg = i82;
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                            }
                                            break;
                                        case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                                            if (i15 == 3) {
                                                Object objZzy4 = zzy(obj3, i11, i43);
                                                i85 = i44;
                                                int iZzl4 = zzga.zzl(objZzy4, zzv(i43), bArr, i39, i2, (i44 & (-8)) | 4, zzfzVar);
                                                zzG(obj3, i11, i43, objZzy4);
                                                iZzg = iZzl4;
                                                i82 = i39;
                                                i13 = i85;
                                                if (iZzg != i82) {
                                                    i11 = i11;
                                                    i87 = i2;
                                                    i3 = i3;
                                                    i92 = i11;
                                                    i90 = i13;
                                                    zzfzVar5 = zzfzVar2;
                                                    i93 = i10;
                                                    i88 = 0;
                                                    i91 = i9;
                                                    unsafe8 = unsafe;
                                                    i89 = i43;
                                                } else {
                                                    i11 = i11;
                                                    i4 = i3;
                                                    i8 = iZzg;
                                                    i88 = i43;
                                                }
                                                break;
                                            }
                                        default:
                                            i43 = i43;
                                            zzfzVar2 = zzfzVar2;
                                            i13 = i44;
                                            i82 = i39;
                                            iZzg = i82;
                                            if (iZzg != i82) {
                                                i11 = i11;
                                                i87 = i2;
                                                i3 = i3;
                                                i92 = i11;
                                                i90 = i13;
                                                zzfzVar5 = zzfzVar2;
                                                i93 = i10;
                                                i88 = 0;
                                                i91 = i9;
                                                unsafe8 = unsafe;
                                                i89 = i43;
                                            } else {
                                                i11 = i11;
                                                i4 = i3;
                                                i8 = iZzg;
                                                i88 = i43;
                                            }
                                            break;
                                    }
                                } else {
                                    if (i15 == 2) {
                                        unsafe6 = zzb;
                                        Object objZzw2 = zzw(i43);
                                        object = unsafe6.getObject(obj, j);
                                        if (!((zzig) object).zze()) {
                                            zzig zzigVarZzb2 = zzig.zza().zzb();
                                            zzih.zza(zzigVarZzb2, object);
                                            unsafe6.putObject(obj, j, zzigVarZzb2);
                                        }
                                        throw null;
                                    }
                                    zzfzVar4 = zzfzVar3;
                                    obj3 = obj;
                                    i4 = i3;
                                    i88 = i43;
                                    zzfzVar2 = zzfzVar4;
                                    unsafe = unsafe3;
                                    i13 = i44;
                                    i8 = i39;
                                }
                            }
                        } else if (i15 == 2) {
                            zzhoVarZzd = (zzho) unsafe2.getObject(obj3, j);
                            if (!zzhoVarZzd.zzc()) {
                                size = zzhoVarZzd.size();
                                if (size == 0) {
                                    i45 = 10;
                                } else {
                                    i45 = size + size;
                                }
                                zzhoVarZzd = zzhoVarZzd.zzd(i45);
                                unsafe2.putObject(obj3, j, zzhoVarZzd);
                            }
                            i3 = i3;
                            zzfzVar5 = zzfzVar3;
                            iZzg = zzga.zze(zzv(i42), i17, bArr, i39, i2, zzhoVarZzd, zzfzVar);
                            unsafe8 = unsafe2;
                            i89 = i42;
                            i87 = i40;
                            i93 = i10;
                            i90 = i17;
                            i88 = 0;
                            i91 = i9;
                            i92 = i41;
                        } else {
                            i43 = i42;
                            unsafe3 = unsafe2;
                            zzfzVar4 = zzfzVar3;
                            i44 = i17;
                            i11 = i41;
                            i4 = i3;
                            i88 = i43;
                            zzfzVar2 = zzfzVar4;
                            unsafe = unsafe3;
                            i13 = i44;
                            i8 = i39;
                        }
                    }
                } else {
                    i8 = iZzi;
                    i9 = i91;
                    i10 = i93;
                    i11 = i96;
                    i12 = i88;
                    unsafe = unsafe8;
                    zzfzVar2 = zzfzVar5;
                    i4 = i3;
                    i13 = i5;
                }
                if (i13 == i4) {
                }
                if (this.zzh) {
                    zzgwVar = zzfzVar2.zzd;
                    int i1215 = zzgw.zzb;
                    int i1216 = zziu.zza;
                    if (zzgwVar != zzgw.zza) {
                        zzimVar = this.zzg;
                        zzgwVar2 = zzfzVar2.zzd;
                        int i1217 = zzga.zza;
                        if (zzgwVar2.zzb(zzimVar, i11) == null) {
                            throw null;
                        }
                        i14 = i13;
                        iZzg = zzga.zzg(i13, bArr, i8, i2, zzd(obj), zzfzVar);
                    } else {
                        i14 = i13;
                        iZzg = zzga.zzg(i14, bArr, i8, i2, zzd(obj), zzfzVar);
                    }
                } else {
                    i14 = i13;
                    iZzg = zzga.zzg(i14, bArr, i8, i2, zzd(obj), zzfzVar);
                }
                i87 = i2;
                i3 = i4;
                i89 = i88;
                i90 = i14;
                i92 = i11;
                i93 = i10;
                i88 = i12;
                i91 = i9;
                unsafe8 = unsafe;
                zzfzVar5 = zzfzVar2;
            } else {
                unsafe = unsafe8;
                i4 = i3;
            }
        }
        if (i93 != 1048575) {
            unsafe.putInt(obj3, i93, i91);
        }
        for (int i130 = this.zzj; i130 < this.zzk; i130++) {
            int[] iArr2 = this.zzi;
            int[] iArr3 = this.zzc;
            int i131 = iArr2[i130];
            int i132 = iArr3[i131];
            Object objZzf = zzjq.zzf(obj3, zzs(i131) & 1048575);
            if (objZzf != null && zzu(i131) != null) {
                throw null;
            }
        }
        if (i4 == 0) {
            if (iZzg != i2) {
                throw new zzhr("Failed to parse the message.");
            }
        } else if (iZzg > i2 || i90 != i4) {
            throw new zzhr("Failed to parse the message.");
        }
        return iZzg;
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final Object zze() {
        return ((zzhk) this.zzg).zzp();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0071  */
    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzhk) {
                zzhk zzhkVar = (zzhk) obj;
                zzhkVar.zzy(Integer.MAX_VALUE);
                zzhkVar.zza = 0;
                zzhkVar.zzw();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzs = zzs(i);
                int i2 = 1048575 & iZzs;
                int iZzr = zzr(iZzs);
                long j = i2;
                if (iZzr != 9) {
                    if (iZzr != 60 && iZzr != 68) {
                        switch (iZzr) {
                            case 17:
                                if (zzI(obj, i)) {
                                    zzv(i).zzf(zzb.getObject(obj, j));
                                }
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
                                ((zzho) zzjq.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzig) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzM(obj, this.zzc[i], i)) {
                        zzv(i).zzf(zzb.getObject(obj, j));
                    }
                } else if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzl.zza(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            int i2 = 1048575 & iZzs;
            int[] iArr = this.zzc;
            int iZzr = zzr(iZzs);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzr) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzjq.zzo(obj, j, zzjq.zza(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 1:
                    if (zzI(obj2, i)) {
                        zzjq.zzp(obj, j, zzjq.zzb(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 2:
                    if (zzI(obj2, i)) {
                        zzjq.zzr(obj, j, zzjq.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 3:
                    if (zzI(obj2, i)) {
                        zzjq.zzr(obj, j, zzjq.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 4:
                    if (zzI(obj2, i)) {
                        zzjq.zzq(obj, j, zzjq.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 5:
                    if (zzI(obj2, i)) {
                        zzjq.zzr(obj, j, zzjq.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 6:
                    if (zzI(obj2, i)) {
                        zzjq.zzq(obj, j, zzjq.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 7:
                    if (zzI(obj2, i)) {
                        zzjq.zzm(obj, j, zzjq.zzw(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 8:
                    if (zzI(obj2, i)) {
                        zzjq.zzs(obj, j, zzjq.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzjq.zzs(obj, j, zzjq.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 11:
                    if (zzI(obj2, i)) {
                        zzjq.zzq(obj, j, zzjq.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 12:
                    if (zzI(obj2, i)) {
                        zzjq.zzq(obj, j, zzjq.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 13:
                    if (zzI(obj2, i)) {
                        zzjq.zzq(obj, j, zzjq.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 14:
                    if (zzI(obj2, i)) {
                        zzjq.zzr(obj, j, zzjq.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 15:
                    if (zzI(obj2, i)) {
                        zzjq.zzq(obj, j, zzjq.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 16:
                    if (zzI(obj2, i)) {
                        zzjq.zzr(obj, j, zzjq.zzd(obj2, j));
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
                    zzho zzhoVarZzd = (zzho) zzjq.zzf(obj, j);
                    zzho zzhoVar = (zzho) zzjq.zzf(obj2, j);
                    int size = zzhoVarZzd.size();
                    int size2 = zzhoVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzhoVarZzd.zzc()) {
                            zzhoVarZzd = zzhoVarZzd.zzd(size2 + size);
                        }
                        zzhoVarZzd.addAll(zzhoVar);
                    }
                    if (size > 0) {
                        zzhoVar = zzhoVarZzd;
                    }
                    zzjq.zzs(obj, j, zzhoVar);
                    break;
                case 50:
                    int i4 = zziz.zza;
                    zzjq.zzs(obj, j, zzih.zza(zzjq.zzf(obj, j), zzjq.zzf(obj2, j)));
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
                    if (zzM(obj2, i3, i)) {
                        zzjq.zzs(obj, j, zzjq.zzf(obj2, j));
                        zzE(obj, i3, i);
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
                    if (zzM(obj2, i3, i)) {
                        zzjq.zzs(obj, j, zzjq.zzf(obj2, j));
                        zzE(obj, i3, i);
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zziz.zzp(this.zzl, obj, obj2);
        if (this.zzh) {
            zziz.zzo(this.zzm, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzfz zzfzVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzfzVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzi(Object obj, zzjw zzjwVar) throws IOException {
        Map.Entry entry;
        int i;
        int i2;
        int i3;
        Map.Entry entry2;
        if (this.zzh) {
            zzhb zzhbVar = ((zzhh) obj).zzb;
            if (zzhbVar.zza.isEmpty()) {
                entry = null;
            } else {
                entry = (Map.Entry) zzhbVar.zze().next();
            }
        } else {
            entry = null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < iArr.length) {
            int iZzs = zzs(i7);
            int[] iArr2 = this.zzc;
            int iZzr = zzr(iZzs);
            int i8 = iArr2[i7];
            if (iZzr <= 17) {
                int i9 = iArr2[i7 + 2];
                int i10 = i9 & i4;
                if (i10 != i5) {
                    i6 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                i = i5;
                i2 = i6;
                i3 = 1 << (i9 >>> 20);
            } else {
                i = i5;
                i2 = i6;
                i3 = 0;
            }
            if (entry != null) {
                throw null;
            }
            long j = iZzs & i4;
            switch (iZzr) {
                case 0:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzf(i8, zzjq.zza(obj, j));
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 1:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzo(i8, zzjq.zzb(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 2:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzt(i8, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 3:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzK(i8, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 4:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzr(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 5:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzm(i8, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 6:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzk(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 7:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzb(i8, zzjq.zzw(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 8:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzO(i8, unsafe.getObject(obj, j), zzjwVar);
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 9:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzv(i8, unsafe.getObject(obj, j), zzv(i7));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 10:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzd(i8, (zzgk) unsafe.getObject(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 11:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzI(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 12:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzi(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 13:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzx(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 14:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzz(i8, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 15:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzB(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 16:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzD(i8, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 17:
                    entry2 = entry;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzjwVar.zzq(i8, unsafe.getObject(obj, j), zzv(i7));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 18:
                    zziz.zzr(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, false);
                    break;
                case 19:
                    zziz.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, false);
                    break;
                case 20:
                    zziz.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, false);
                    break;
                case 21:
                    zziz.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, false);
                    break;
                case 22:
                    zziz.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, false);
                    break;
                case 23:
                    zziz.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, false);
                    break;
                case 24:
                    zziz.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, false);
                    break;
                case 25:
                    zziz.zzq(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, false);
                    break;
                case 26:
                    int i11 = this.zzc[i7];
                    List list = (List) unsafe.getObject(obj, j);
                    int i12 = zziz.zza;
                    if (list != null && !list.isEmpty()) {
                        zzjwVar.zzH(i11, list);
                    }
                    break;
                case 27:
                    int i13 = this.zzc[i7];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzix zzixVarZzv = zzv(i7);
                    int i14 = zziz.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i15 = 0; i15 < list2.size(); i15++) {
                            ((zzgs) zzjwVar).zzv(i13, list2.get(i15), zzixVarZzv);
                        }
                    }
                    break;
                case 28:
                    int i16 = this.zzc[i7];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i17 = zziz.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzjwVar.zze(i16, list3);
                    }
                    break;
                case 29:
                    zziz.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, false);
                    break;
                case 30:
                    zziz.zzs(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, false);
                    break;
                case 31:
                    zziz.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, false);
                    break;
                case 32:
                    zziz.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, false);
                    break;
                case 33:
                    zziz.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, false);
                    break;
                case 34:
                    zziz.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, false);
                    break;
                case 35:
                    zziz.zzr(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, true);
                    break;
                case 36:
                    zziz.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, true);
                    break;
                case 37:
                    zziz.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, true);
                    break;
                case 38:
                    zziz.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, true);
                    break;
                case 39:
                    zziz.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, true);
                    break;
                case 40:
                    zziz.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, true);
                    break;
                case 41:
                    zziz.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, true);
                    break;
                case 42:
                    zziz.zzq(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, true);
                    break;
                case 43:
                    zziz.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, true);
                    break;
                case 44:
                    zziz.zzs(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, true);
                    break;
                case 45:
                    zziz.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, true);
                    break;
                case 46:
                    zziz.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, true);
                    break;
                case 47:
                    zziz.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, true);
                    break;
                case 48:
                    zziz.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzjwVar, true);
                    break;
                case 49:
                    int i18 = this.zzc[i7];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzix zzixVarZzv2 = zzv(i7);
                    int i19 = zziz.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i20 = 0; i20 < list4.size(); i20++) {
                            ((zzgs) zzjwVar).zzq(i18, list4.get(i20), zzixVarZzv2);
                        }
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    break;
                case 51:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzf(i8, zzm(obj, j));
                    }
                    break;
                case 52:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzo(i8, zzn(obj, j));
                    }
                    break;
                case 53:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzt(i8, zzt(obj, j));
                    }
                    break;
                case 54:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzK(i8, zzt(obj, j));
                    }
                    break;
                case 55:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzr(i8, zzo(obj, j));
                    }
                    break;
                case 56:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzm(i8, zzt(obj, j));
                    }
                    break;
                case 57:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzk(i8, zzo(obj, j));
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzb(i8, zzN(obj, j));
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    if (zzM(obj, i8, i7)) {
                        zzO(i8, unsafe.getObject(obj, j), zzjwVar);
                    }
                    break;
                case 60:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzv(i8, unsafe.getObject(obj, j), zzv(i7));
                    }
                    break;
                case 61:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzd(i8, (zzgk) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzI(i8, zzo(obj, j));
                    }
                    break;
                case 63:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzi(i8, zzo(obj, j));
                    }
                    break;
                case 64:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzx(i8, zzo(obj, j));
                    }
                    break;
                case 65:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzz(i8, zzt(obj, j));
                    }
                    break;
                case 66:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzB(i8, zzo(obj, j));
                    }
                    break;
                case 67:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzD(i8, zzt(obj, j));
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    if (zzM(obj, i8, i7)) {
                        zzjwVar.zzq(i8, unsafe.getObject(obj, j), zzv(i7));
                    }
                    break;
            }
            entry2 = entry;
            i7 += 3;
            i5 = i;
            entry = entry2;
            i6 = i2;
            i4 = 1048575;
        }
        Map.Entry entry3 = entry;
        if (entry3 != null) {
            throw null;
        }
        ((zzhk) obj).zzc.zzl(zzjwVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzE;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            long j = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzjq.zza(obj, j)) != Double.doubleToLongBits(zzjq.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzjq.zzb(obj, j)) != Float.floatToIntBits(zzjq.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i) || zzjq.zzd(obj, j) != zzjq.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i) || zzjq.zzd(obj, j) != zzjq.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i) || zzjq.zzc(obj, j) != zzjq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i) || zzjq.zzd(obj, j) != zzjq.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i) || zzjq.zzc(obj, j) != zzjq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i) || zzjq.zzw(obj, j) != zzjq.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i) || !zziz.zzE(zzjq.zzf(obj, j), zzjq.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i) || !zziz.zzE(zzjq.zzf(obj, j), zzjq.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i) || !zziz.zzE(zzjq.zzf(obj, j), zzjq.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i) || zzjq.zzc(obj, j) != zzjq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i) || zzjq.zzc(obj, j) != zzjq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i) || zzjq.zzc(obj, j) != zzjq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i) || zzjq.zzd(obj, j) != zzjq.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i) || zzjq.zzc(obj, j) != zzjq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i) || zzjq.zzd(obj, j) != zzjq.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i) || !zziz.zzE(zzjq.zzf(obj, j), zzjq.zzf(obj2, j))) {
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
                    zZzE = zziz.zzE(zzjq.zzf(obj, j), zzjq.zzf(obj2, j));
                    break;
                case 50:
                    zZzE = zziz.zzE(zzjq.zzf(obj, j), zzjq.zzf(obj2, j));
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
                    long jZzp = zzp(i) & 1048575;
                    if (zzjq.zzc(obj, jZzp) != zzjq.zzc(obj2, jZzp) || !zziz.zzE(zzjq.zzf(obj, j), zzjq.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzE) {
                return false;
            }
        }
        if (!((zzhk) obj).zzc.equals(((zzhk) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzhh) obj).zzb.equals(((zzhh) obj2).zzb);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009b  */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c0 A[LOOP:1: B:45:0x00af->B:50:0x00c0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00dd A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzix
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        List list;
        zzix zzixVarZzv;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int iZzs = zzs(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i4 = zzb.getInt(obj, i10);
                }
                i2 = i4;
                i = i10;
            } else {
                i = i6;
                i2 = i4;
            }
            if ((268435456 & iZzs) != 0 && !zzJ(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzr = zzr(iZzs);
            if (iZzr == 9 || iZzr == 17) {
                if (zzJ(obj, i7, i, i2, i11) && !zzK(obj, iZzs, zzv(i7))) {
                    return false;
                }
            } else if (iZzr == 27) {
                list = (List) zzjq.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzixVarZzv = zzv(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzixVarZzv.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzr == 60 || iZzr == 68) {
                if (zzM(obj, i8, i7) && !zzK(obj, iZzs, zzv(i7))) {
                    return false;
                }
            } else if (iZzr == 49) {
                list = (List) zzjq.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    zzixVarZzv = zzv(i7);
                    while (i3 < list.size()) {
                        if (!zzixVarZzv.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzr == 50 && !((zzig) zzjq.zzf(obj, iZzs & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        return !this.zzh || ((zzhh) obj).zzb.zzh();
    }
}
