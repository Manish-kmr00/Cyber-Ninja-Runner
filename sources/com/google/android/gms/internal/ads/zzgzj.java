package com.google.android.gms.internal.ads;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgzj<T> implements zzgzz<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhas.zzi();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgzg zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzhal zzm;
    private final zzgxg zzn;

    private zzgzj(int[] iArr, Object[] objArr, int i, int i2, zzgzg zzgzgVar, boolean z, int[] iArr2, int i3, int i4, zzgzm zzgzmVar, zzgyt zzgytVar, zzhal zzhalVar, zzgxg zzgxgVar, zzgzb zzgzbVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzgzgVar instanceof zzgxv;
        boolean z2 = false;
        if (zzgxgVar != null && (zzgzgVar instanceof zzgxr)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzhalVar;
        this.zzn = zzgxgVar;
        this.zzg = zzgzgVar;
    }

    private final Object zzA(Object obj, int i) {
        zzgzz zzgzzVarZzx = zzx(i);
        int iZzu = zzu(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzgzzVarZzx.zze();
        }
        Object object = zzb.getObject(obj, iZzu);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzgzzVarZzx.zze();
        if (object != null) {
            zzgzzVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzB(Object obj, int i, int i2) {
        zzgzz zzgzzVarZzx = zzx(i2);
        if (!zzR(obj, i, i2)) {
            return zzgzzVarZzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i2) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzgzzVarZzx.zze();
        if (object != null) {
            zzgzzVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzC(Class cls, String str) {
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

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzE(Object obj, Object obj2, int i) {
        if (zzN(obj2, i)) {
            int iZzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgzz zzgzzVarZzx = zzx(i);
            if (!zzN(obj, i)) {
                if (zzQ(object)) {
                    Object objZze = zzgzzVarZzx.zze();
                    zzgzzVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzH(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzgzzVarZzx.zze();
                zzgzzVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgzzVarZzx.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzR(obj2, i2, i)) {
            int iZzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzgzz zzgzzVarZzx = zzx(i);
            if (!zzR(obj, i2, i)) {
                if (zzQ(object)) {
                    Object objZze = zzgzzVarZzx.zze();
                    zzgzzVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzI(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzgzzVarZzx.zze();
                zzgzzVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgzzVarZzx.zzg(object2, object);
        }
    }

    private final void zzG(Object obj, int i, zzgzt zzgztVar) throws IOException {
        long j = i & 1048575;
        if (zzM(i)) {
            zzhas.zzv(obj, j, zzgztVar.zzs());
        } else if (this.zzi) {
            zzhas.zzv(obj, j, zzgztVar.zzr());
        } else {
            zzhas.zzv(obj, j, zzgztVar.zzp());
        }
    }

    private final void zzH(Object obj, int i) {
        int iZzr = zzr(i);
        long j = 1048575 & iZzr;
        if (j == 1048575) {
            return;
        }
        zzhas.zzt(obj, j, (1 << (iZzr >>> 20)) | zzhas.zzd(obj, j));
    }

    private final void zzI(Object obj, int i, int i2) {
        zzhas.zzt(obj, zzr(i2) & 1048575, i);
    }

    private final void zzJ(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzu(i) & 1048575, obj2);
        zzH(obj, i);
    }

    private final void zzK(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzu(i2) & 1048575, obj2);
        zzI(obj, i, i2);
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzN(obj, i) == zzN(obj2, i);
    }

    private static boolean zzM(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i) {
        int iZzr = zzr(i);
        long j = iZzr & 1048575;
        if (j != 1048575) {
            return (zzhas.zzd(obj, j) & (1 << (iZzr >>> 20))) != 0;
        }
        int iZzu = zzu(i);
        long j2 = iZzu & 1048575;
        switch (zzt(iZzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzhas.zzb(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhas.zzc(obj, j2)) != 0;
            case 2:
                return zzhas.zzf(obj, j2) != 0;
            case 3:
                return zzhas.zzf(obj, j2) != 0;
            case 4:
                return zzhas.zzd(obj, j2) != 0;
            case 5:
                return zzhas.zzf(obj, j2) != 0;
            case 6:
                return zzhas.zzd(obj, j2) != 0;
            case 7:
                return zzhas.zzz(obj, j2);
            case 8:
                Object objZzh = zzhas.zzh(obj, j2);
                if (objZzh instanceof String) {
                    return !((String) objZzh).isEmpty();
                }
                if (objZzh instanceof zzgwn) {
                    return !zzgwn.zzb.equals(objZzh);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhas.zzh(obj, j2) != null;
            case 10:
                return !zzgwn.zzb.equals(zzhas.zzh(obj, j2));
            case 11:
                return zzhas.zzd(obj, j2) != 0;
            case 12:
                return zzhas.zzd(obj, j2) != 0;
            case 13:
                return zzhas.zzd(obj, j2) != 0;
            case 14:
                return zzhas.zzf(obj, j2) != 0;
            case 15:
                return zzhas.zzd(obj, j2) != 0;
            case 16:
                return zzhas.zzf(obj, j2) != 0;
            case 17:
                return zzhas.zzh(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzO(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzN(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzP(Object obj, int i, zzgzz zzgzzVar) {
        return zzgzzVar.zzl(zzhas.zzh(obj, i & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgxv) {
            return ((zzgxv) obj).zzcd();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzhas.zzd(obj, (long) (zzr(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzhas.zzh(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zzhba zzhbaVar) throws IOException {
        if (obj instanceof String) {
            zzhbaVar.zzG(i, (String) obj);
        } else {
            zzhbaVar.zzd(i, (zzgwn) obj);
        }
    }

    static zzham zzd(Object obj) {
        zzgxv zzgxvVar = (zzgxv) obj;
        zzham zzhamVar = zzgxvVar.zzt;
        if (zzhamVar != zzham.zzc()) {
            return zzhamVar;
        }
        zzham zzhamVarZzf = zzham.zzf();
        zzgxvVar.zzt = zzhamVarZzf;
        return zzhamVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:126:0x0268  */
    /* JADX WARN: Code duplicated, block: B:129:0x027f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0282  */
    /* JADX WARN: Code duplicated, block: B:169:0x0345  */
    /* JADX WARN: Code duplicated, block: B:183:0x0391  */
    /* JADX WARN: Code duplicated, block: B:186:0x039a  */
    static zzgzj zzm(Class cls, zzgzd zzgzdVar, zzgzm zzgzmVar, zzgyt zzgytVar, zzhal zzhalVar, zzgxg zzgxgVar, zzgzb zzgzbVar) {
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
        Field fieldZzC;
        int i22;
        char cCharAt9;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        Object obj;
        Field fieldZzC2;
        int i28;
        Object obj2;
        Field fieldZzC3;
        int i29;
        char cCharAt10;
        int i30;
        char cCharAt11;
        int i31;
        char cCharAt12;
        int i32;
        char cCharAt13;
        if (!(zzgzdVar instanceof zzgzs)) {
            throw null;
        }
        zzgzs zzgzsVar = (zzgzs) zzgzdVar;
        String strZzd = zzgzsVar.zzd();
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
        Object[] objArrZze = zzgzsVar.zze();
        Class<?> cls2 = zzgzsVar.zza().getClass();
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
                        if (zzgzsVar.zzc() == 1 || i78 != 0) {
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
                        fieldZzC2 = (Field) obj;
                    } else {
                        fieldZzC2 = zzC(cls2, (String) obj);
                        objArrZze[i27] = fieldZzC2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzC2);
                    i28 = i27 + 1;
                    obj2 = objArrZze[i28];
                    int i88 = i78;
                    if (obj2 instanceof Field) {
                        fieldZzC3 = (Field) obj2;
                    } else {
                        fieldZzC3 = zzC(cls2, (String) obj2);
                        objArrZze[i28] = fieldZzC3;
                    }
                    i18 = i4;
                    i19 = i85;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzC3);
                    i20 = 0;
                    strZzd = strZzd;
                    zzgzsVar = zzgzsVar;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i21 = i88;
                }
                i4 = i26;
                i27 = iCharAt12 + iCharAt12;
                obj = objArrZze[i27];
                if (obj instanceof Field) {
                    fieldZzC2 = (Field) obj;
                } else {
                    fieldZzC2 = zzC(cls2, (String) obj);
                    objArrZze[i27] = fieldZzC2;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzC2);
                i28 = i27 + 1;
                obj2 = objArrZze[i28];
                int i89 = i78;
                if (obj2 instanceof Field) {
                    fieldZzC3 = (Field) obj2;
                } else {
                    fieldZzC3 = zzC(cls2, (String) obj2);
                    objArrZze[i28] = fieldZzC3;
                }
                i18 = i4;
                i19 = i85;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzC3);
                i20 = 0;
                strZzd = strZzd;
                zzgzsVar = zzgzsVar;
                iObjectFieldOffset = iObjectFieldOffset4;
                i21 = i89;
            } else {
                i17 = i2;
                i18 = i4 + 1;
                Field fieldZzC4 = zzC(cls2, (String) objArrZze[i4]);
                if (i76 == 9 || i76 == 17) {
                    int i90 = i67 / 3;
                    objArr[i90 + i90 + 1] = fieldZzC4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i24 = i4 + 2;
                            i23 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            zzgzsVar = zzgzsVar;
                            if (zzgzsVar.zzc() == 1 || i78 != 0) {
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
                                zzgzsVar = zzgzsVar;
                            } else {
                                i18 = i92;
                                i64 = i93;
                                i78 = 0;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC4);
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
                                fieldZzC = (Field) obj3;
                            } else {
                                fieldZzC = zzC(cls2, (String) obj3);
                                objArrZze[i99] = fieldZzC;
                            }
                            i20 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzC);
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
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC4);
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
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC4);
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
            zzgzsVar = zzgzsVar;
            i34 = i19;
            i2 = i17;
            c = 55296;
        }
        return new zzgzj(iArr3, objArr, i2, i5, zzgzsVar.zza(), false, iArr, i3, i62, zzgzmVar, zzgytVar, zzhalVar, zzgxgVar, zzgzbVar);
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzhas.zzh(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzhas.zzh(obj, j)).floatValue();
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zzhas.zzh(obj, j)).intValue();
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzs(i, 0);
    }

    private final int zzr(int i) {
        return this.zzc[i + 2];
    }

    private final int zzs(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
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

    private static int zzt(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzu(int i) {
        return this.zzc[i + 1];
    }

    private static long zzv(Object obj, long j) {
        return ((Long) zzhas.zzh(obj, j)).longValue();
    }

    private final zzgyb zzw(int i) {
        int i2 = i / 3;
        return (zzgyb) this.zzd[i2 + i2 + 1];
    }

    private final zzgzz zzx(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgzz zzgzzVar = (zzgzz) objArr[i3];
        if (zzgzzVar != null) {
            return zzgzzVar;
        }
        zzgzz zzgzzVarZzb = zzgzq.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzgzzVarZzb;
        return zzgzzVarZzb;
    }

    private final Object zzy(Object obj, int i, Object obj2, zzhal zzhalVar, Object obj3) {
        int i2 = this.zzc[i];
        Object objZzh = zzhas.zzh(obj, zzu(i) & 1048575);
        if (objZzh == null || zzw(i) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    /* JADX WARN: Code duplicated, block: B:137:0x038b  */
    /* JADX WARN: Code duplicated, block: B:207:0x054c  */
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
    /* JADX WARN: Type inference failed for: r1v118, types: [int] */
    /* JADX WARN: Type inference failed for: r1v121, types: [int] */
    /* JADX WARN: Type inference failed for: r1v160 */
    /* JADX WARN: Type inference failed for: r1v163 */
    /* JADX WARN: Type inference failed for: r1v164 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v167 */
    /* JADX WARN: Type inference failed for: r1v168 */
    /* JADX WARN: Type inference failed for: r1v78, types: [int] */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41, types: [int] */
    /* JADX WARN: Type inference failed for: r2v45, types: [int] */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54, types: [int] */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [int] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v40, types: [int] */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v47, types: [int] */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30, types: [int] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v37, types: [int] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.ads.zzgzz
    public final int zza(Object obj) {
        int i;
        ?? r16;
        ?? r5;
        int iZzD;
        int iZzD2;
        int iZzD3;
        int iZzE;
        int iZzD4;
        int iZzD5;
        int iZzd;
        int iZzD6;
        ?? Zzg;
        int size;
        int iZzD7;
        int iZzC;
        int iZzC2;
        ?? r3;
        int iZzA;
        ?? ZzD;
        ?? Zzh;
        int iZze;
        int iZzD8;
        int iZzD9;
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
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iZza = i4 + ((zzgxv) obj).zzt.zza();
                if (!this.zzh) {
                    return iZza;
                }
                zzhah zzhahVar = ((zzgxr) obj).zza.zza;
                int iZzc = zzhahVar.zzc();
                int iZzc2 = 0;
                for (int i6 = 0; i6 < iZzc; i6++) {
                    Map.Entry entryZzg = zzhahVar.zzg(i6);
                    iZzc2 += zzgxk.zzc((zzgxj) ((zzhad) entryZzg).zza(), entryZzg.getValue());
                }
                for (Map.Entry entry : zzhahVar.zzd()) {
                    iZzc2 += zzgxk.zzc((zzgxj) entry.getKey(), entry.getValue());
                }
                return iZza + iZzc2;
            }
            int iZzu = zzu(i3);
            int iZzt = zzt(iZzu);
            int i7 = iArr[i3];
            int i8 = iArr[i3 + 2];
            int i9 = i8 & i2;
            if (iZzt <= 17) {
                if (i9 != i5) {
                    r1 = i9 == i2 ? z : unsafe.getInt(obj, i9);
                    i5 = i9;
                }
                i = i5;
                r16 = r1;
                r5 = 1 << (i8 >>> 20);
            } else {
                r1 = r2;
                i = i5;
                r16 = r2 == true ? 1 : 0;
                r5 = z;
            }
            int i10 = iZzu & i2;
            if (iZzt >= zzgxl.DOUBLE_LIST_PACKED.zza()) {
                zzgxl.SINT64_LIST_PACKED.zza();
            }
            long j = i10;
            switch (iZzt) {
                case 0:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzD = zzgxa.zzD(i7 << 3);
                        Zzh = iZzD + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 1:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzD2 = zzgxa.zzD(i7 << 3);
                        Zzh = iZzD2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 2:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzD3 = zzgxa.zzD(i7 << 3);
                        iZzE = zzgxa.zzE(j2);
                        Zzh = iZzD3 + iZzE;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 3:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzD3 = zzgxa.zzD(i7 << 3);
                        iZzE = zzgxa.zzE(j3);
                        Zzh = iZzD3 + iZzE;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 4:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzD3 = zzgxa.zzD(i7 << 3);
                        iZzE = zzgxa.zzE(j4);
                        Zzh = iZzD3 + iZzE;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 5:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzD = zzgxa.zzD(i7 << 3);
                        Zzh = iZzD + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 6:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzD2 = zzgxa.zzD(i7 << 3);
                        Zzh = iZzD2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 7:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzD4 = zzgxa.zzD(i7 << 3);
                        Zzh = iZzD4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 8:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i11 = i7 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzgwn) {
                            iZzD5 = zzgxa.zzD(i11);
                            iZzd = ((zzgwn) object).zzd();
                            iZzD6 = zzgxa.zzD(iZzd);
                            Zzh = iZzD5 + iZzD6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzD3 = zzgxa.zzD(i11);
                            iZzE = zzgxa.zzC((String) object);
                            Zzh = iZzD3 + iZzE;
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
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzh = zzhab.zzh(i7, unsafe.getObject(obj, j), zzx(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 10:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        zzgwn zzgwnVar = (zzgwn) unsafe.getObject(obj, j);
                        iZzD5 = zzgxa.zzD(i7 << 3);
                        iZzd = zzgwnVar.zzd();
                        iZzD6 = zzgxa.zzD(iZzd);
                        Zzh = iZzD5 + iZzD6 + iZzd;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 11:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzD3 = zzgxa.zzD(i7 << 3);
                        iZzE = zzgxa.zzD(i12);
                        Zzh = iZzD3 + iZzE;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 12:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzD3 = zzgxa.zzD(i7 << 3);
                        iZzE = zzgxa.zzE(j5);
                        Zzh = iZzD3 + iZzE;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 13:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzD2 = zzgxa.zzD(i7 << 3);
                        Zzh = iZzD2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 14:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzD = zzgxa.zzD(i7 << 3);
                        Zzh = iZzD + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 15:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i13 = unsafe.getInt(obj, j);
                        iZzD3 = zzgxa.zzD(i7 << 3);
                        iZzE = zzgxa.zzD((i13 >> 31) ^ (i13 + i13));
                        Zzh = iZzD3 + iZzE;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 16:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzD3 = zzgxa.zzD(i7 << 3);
                        iZzE = zzgxa.zzE((j6 >> 63) ^ (j6 + j6));
                        Zzh = iZzD3 + iZzE;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 17:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzh = zzgxa.zzy(i7, (zzgzg) unsafe.getObject(obj, j), zzx(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 18:
                    Zzh = zzhab.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 19:
                    Zzh = zzhab.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zzhab.zza;
                    if (list.size() == 0) {
                        Zzg = z;
                    } else {
                        Zzg = zzhab.zzg(list) + (list.size() * zzgxa.zzD(i7 << 3));
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
                    int i15 = zzhab.zza;
                    size = list2.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzD3 = zzhab.zzl(list2);
                        iZzD7 = zzgxa.zzD(i7 << 3);
                        iZzE = size * iZzD7;
                        Zzh = iZzD3 + iZzE;
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
                    int i16 = zzhab.zza;
                    size = list3.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzD3 = zzhab.zzf(list3);
                        iZzD7 = zzgxa.zzD(i7 << 3);
                        iZzE = size * iZzD7;
                        Zzh = iZzD3 + iZzE;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 23:
                    Zzh = zzhab.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 24:
                    Zzh = zzhab.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zzhab.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        Zzh = z;
                    } else {
                        Zzh = size2 * (zzgxa.zzD(i7 << 3) + 1);
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
                    int i18 = zzhab.zza;
                    int size3 = r0.size();
                    if (size3 == 0) {
                        Zzg = z;
                    } else {
                        int iZzD10 = zzgxa.zzD(i7 << 3) * size3;
                        if (r0 instanceof zzgys) {
                            zzgys zzgysVar = (zzgys) r0;
                            for (?? r7 = z; r7 < size3; r7++) {
                                Object objZzc = zzgysVar.zzc();
                                if (objZzc instanceof zzgwn) {
                                    Zzg = iZzD10;
                                    int iZzd2 = ((zzgwn) objZzc).zzd();
                                    iZzC2 = Zzg + zzgxa.zzD(iZzd2) + iZzd2;
                                } else {
                                    Zzg = iZzD10;
                                    iZzC2 = Zzg + zzgxa.zzC((String) objZzc);
                                }
                                Zzg = iZzC2;
                            }
                            Zzg = iZzD10;
                        } else {
                            for (?? r8 = z; r8 < size3; r8++) {
                                Object obj2 = r0.get(r8);
                                if (obj2 instanceof zzgwn) {
                                    Zzg = iZzD10;
                                    int iZzd3 = ((zzgwn) obj2).zzd();
                                    iZzC = Zzg + zzgxa.zzD(iZzd3) + iZzd3;
                                } else {
                                    Zzg = iZzD10;
                                    iZzC = Zzg + zzgxa.zzC((String) obj2);
                                }
                                Zzg = iZzC;
                            }
                            Zzg = iZzD10;
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
                    zzgzz zzgzzVarZzx = zzx(i3);
                    int i19 = zzhab.zza;
                    int size4 = r9.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        int iZzD11 = zzgxa.zzD(i7 << 3) * size4;
                        for (?? r10 = z; r10 < size4; r10++) {
                            Object obj3 = r9.get(r10);
                            if (obj3 instanceof zzgyr) {
                                r3 = iZzD11;
                                int iZza2 = ((zzgyr) obj3).zza();
                                iZzA = (r3 == true ? 1 : 0) + zzgxa.zzD(iZza2) + iZza2;
                            } else {
                                r3 = iZzD11;
                                iZzA = (r3 == true ? 1 : 0) + zzgxa.zzA((zzgzg) obj3, zzgzzVarZzx);
                            }
                            r3 = iZzA;
                        }
                        r3 = iZzD11;
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
                    int i20 = zzhab.zza;
                    int size5 = r11.size();
                    if (size5 == 0) {
                        ZzD = z;
                    } else {
                        ZzD = size5 * zzgxa.zzD(i7 << 3);
                        for (?? r12 = z; r12 < r11.size(); r12++) {
                            int iZzd4 = ((zzgwn) r11.get(r12)).zzd();
                            ZzD += zzgxa.zzD(iZzd4) + iZzd4;
                        }
                    }
                    i4 += ZzD;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i21 = zzhab.zza;
                    size = list5.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzD3 = zzhab.zzk(list5);
                        iZzD7 = zzgxa.zzD(i7 << 3);
                        iZzE = size * iZzD7;
                        Zzh = iZzD3 + iZzE;
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
                    int i22 = zzhab.zza;
                    size = list6.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzD3 = zzhab.zza(list6);
                        iZzD7 = zzgxa.zzD(i7 << 3);
                        iZzE = size * iZzD7;
                        Zzh = iZzD3 + iZzE;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 31:
                    Zzh = zzhab.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 32:
                    Zzh = zzhab.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zzhab.zza;
                    size = list7.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzD3 = zzhab.zzi(list7);
                        iZzD7 = zzgxa.zzD(i7 << 3);
                        iZzE = size * iZzD7;
                        Zzh = iZzD3 + iZzE;
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
                    int i24 = zzhab.zza;
                    size = list8.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzD3 = zzhab.zzj(list8);
                        iZzD7 = zzgxa.zzD(i7 << 3);
                        iZzE = size * iZzD7;
                        Zzh = iZzD3 + iZzE;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 35:
                    iZze = zzhab.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzD8 = zzgxa.zzD(i7 << 3);
                        iZzD9 = zzgxa.zzD(iZze);
                        ZzD = iZzD8 + iZzD9 + iZze;
                        i4 += ZzD;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 36:
                    iZze = zzhab.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzD8 = zzgxa.zzD(i7 << 3);
                        iZzD9 = zzgxa.zzD(iZze);
                        ZzD = iZzD8 + iZzD9 + iZze;
                        i4 += ZzD;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 37:
                    iZze = zzhab.zzg((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzD8 = zzgxa.zzD(i7 << 3);
                        iZzD9 = zzgxa.zzD(iZze);
                        ZzD = iZzD8 + iZzD9 + iZze;
                        i4 += ZzD;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 38:
                    iZze = zzhab.zzl((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzD8 = zzgxa.zzD(i7 << 3);
                        iZzD9 = zzgxa.zzD(iZze);
                        ZzD = iZzD8 + iZzD9 + iZze;
                        i4 += ZzD;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 39:
                    iZze = zzhab.zzf((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzD8 = zzgxa.zzD(i7 << 3);
                        iZzD9 = zzgxa.zzD(iZze);
                        ZzD = iZzD8 + iZzD9 + iZze;
                        i4 += ZzD;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 40:
                    iZze = zzhab.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzD8 = zzgxa.zzD(i7 << 3);
                        iZzD9 = zzgxa.zzD(iZze);
                        ZzD = iZzD8 + iZzD9 + iZze;
                        i4 += ZzD;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 41:
                    iZze = zzhab.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzD8 = zzgxa.zzD(i7 << 3);
                        iZzD9 = zzgxa.zzD(iZze);
                        ZzD = iZzD8 + iZzD9 + iZze;
                        i4 += ZzD;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zzhab.zza;
                    iZze = list9.size();
                    if (iZze > 0) {
                        iZzD8 = zzgxa.zzD(i7 << 3);
                        iZzD9 = zzgxa.zzD(iZze);
                        ZzD = iZzD8 + iZzD9 + iZze;
                        i4 += ZzD;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 43:
                    iZze = zzhab.zzk((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzD8 = zzgxa.zzD(i7 << 3);
                        iZzD9 = zzgxa.zzD(iZze);
                        ZzD = iZzD8 + iZzD9 + iZze;
                        i4 += ZzD;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 44:
                    iZze = zzhab.zza((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzD8 = zzgxa.zzD(i7 << 3);
                        iZzD9 = zzgxa.zzD(iZze);
                        ZzD = iZzD8 + iZzD9 + iZze;
                        i4 += ZzD;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 45:
                    iZze = zzhab.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzD8 = zzgxa.zzD(i7 << 3);
                        iZzD9 = zzgxa.zzD(iZze);
                        ZzD = iZzD8 + iZzD9 + iZze;
                        i4 += ZzD;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 46:
                    iZze = zzhab.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzD8 = zzgxa.zzD(i7 << 3);
                        iZzD9 = zzgxa.zzD(iZze);
                        ZzD = iZzD8 + iZzD9 + iZze;
                        i4 += ZzD;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 47:
                    iZze = zzhab.zzi((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzD8 = zzgxa.zzD(i7 << 3);
                        iZzD9 = zzgxa.zzD(iZze);
                        ZzD = iZzD8 + iZzD9 + iZze;
                        i4 += ZzD;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 48:
                    iZze = zzhab.zzj((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzD8 = zzgxa.zzD(i7 << 3);
                        iZzD9 = zzgxa.zzD(iZze);
                        ZzD = iZzD8 + iZzD9 + iZze;
                        i4 += ZzD;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 49:
                    ?? r13 = (List) unsafe.getObject(obj, j);
                    zzgzz zzgzzVarZzx2 = zzx(i3);
                    int i26 = zzhab.zza;
                    int size6 = r13.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z2 = z;
                        r4 = z2;
                        while (r6 < size6) {
                            r6 = z2;
                            int iZzy = zzgxa.zzy(i7, (zzgzg) r13.get(r6), zzgzzVarZzx2);
                            r6++;
                            r4 = (r4 == true ? 1 : 0) + iZzy;
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
                    zzgza zzgzaVar = (zzgza) unsafe.getObject(obj, j);
                    if (zzgzaVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzgzaVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) it.next();
                            entry2.getKey();
                            entry2.getValue();
                            throw null;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                case 51:
                    if (zzR(obj, i7, i3)) {
                        iZzD = zzgxa.zzD(i7 << 3);
                        Zzh = iZzD + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 52:
                    if (zzR(obj, i7, i3)) {
                        iZzD2 = zzgxa.zzD(i7 << 3);
                        Zzh = iZzD2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 53:
                    if (zzR(obj, i7, i3)) {
                        long jZzv = zzv(obj, j);
                        iZzD3 = zzgxa.zzD(i7 << 3);
                        iZzE = zzgxa.zzE(jZzv);
                        Zzh = iZzD3 + iZzE;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 54:
                    if (zzR(obj, i7, i3)) {
                        long jZzv2 = zzv(obj, j);
                        iZzD3 = zzgxa.zzD(i7 << 3);
                        iZzE = zzgxa.zzE(jZzv2);
                        Zzh = iZzD3 + iZzE;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 55:
                    if (zzR(obj, i7, i3)) {
                        long jZzp = zzp(obj, j);
                        iZzD3 = zzgxa.zzD(i7 << 3);
                        iZzE = zzgxa.zzE(jZzp);
                        Zzh = iZzD3 + iZzE;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 56:
                    if (zzR(obj, i7, i3)) {
                        iZzD = zzgxa.zzD(i7 << 3);
                        Zzh = iZzD + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 57:
                    if (zzR(obj, i7, i3)) {
                        iZzD2 = zzgxa.zzD(i7 << 3);
                        Zzh = iZzD2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    if (zzR(obj, i7, i3)) {
                        iZzD4 = zzgxa.zzD(i7 << 3);
                        Zzh = iZzD4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    if (zzR(obj, i7, i3)) {
                        int i27 = i7 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzgwn) {
                            iZzD5 = zzgxa.zzD(i27);
                            iZzd = ((zzgwn) object2).zzd();
                            iZzD6 = zzgxa.zzD(iZzd);
                            Zzh = iZzD5 + iZzD6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzD3 = zzgxa.zzD(i27);
                            iZzE = zzgxa.zzC((String) object2);
                            Zzh = iZzD3 + iZzE;
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
                    if (zzR(obj, i7, i3)) {
                        Zzh = zzhab.zzh(i7, unsafe.getObject(obj, j), zzx(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 61:
                    if (zzR(obj, i7, i3)) {
                        zzgwn zzgwnVar2 = (zzgwn) unsafe.getObject(obj, j);
                        iZzD5 = zzgxa.zzD(i7 << 3);
                        iZzd = zzgwnVar2.zzd();
                        iZzD6 = zzgxa.zzD(iZzd);
                        Zzh = iZzD5 + iZzD6 + iZzd;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 62:
                    if (zzR(obj, i7, i3)) {
                        int iZzp = zzp(obj, j);
                        iZzD3 = zzgxa.zzD(i7 << 3);
                        iZzE = zzgxa.zzD(iZzp);
                        Zzh = iZzD3 + iZzE;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 63:
                    if (zzR(obj, i7, i3)) {
                        long jZzp2 = zzp(obj, j);
                        iZzD3 = zzgxa.zzD(i7 << 3);
                        iZzE = zzgxa.zzE(jZzp2);
                        Zzh = iZzD3 + iZzE;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 64:
                    if (zzR(obj, i7, i3)) {
                        iZzD2 = zzgxa.zzD(i7 << 3);
                        Zzh = iZzD2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 65:
                    if (zzR(obj, i7, i3)) {
                        iZzD = zzgxa.zzD(i7 << 3);
                        Zzh = iZzD + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 66:
                    if (zzR(obj, i7, i3)) {
                        int iZzp2 = zzp(obj, j);
                        iZzD3 = zzgxa.zzD(i7 << 3);
                        iZzE = zzgxa.zzD((iZzp2 >> 31) ^ (iZzp2 + iZzp2));
                        Zzh = iZzD3 + iZzE;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 67:
                    if (zzR(obj, i7, i3)) {
                        long jZzv3 = zzv(obj, j);
                        iZzD3 = zzgxa.zzD(i7 << 3);
                        iZzE = zzgxa.zzE((jZzv3 >> 63) ^ (jZzv3 + jZzv3));
                        Zzh = iZzD3 + iZzE;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    if (zzR(obj, i7, i3)) {
                        Zzh = zzgxa.zzy(i7, (zzgzg) unsafe.getObject(obj, j), zzx(i3));
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
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iHashCode = (i4 * 53) + ((zzgxv) obj).zzt.hashCode();
                return this.zzh ? (iHashCode * 53) + ((zzgxr) obj).zza.zza.hashCode() : iHashCode;
            }
            int iZzu = zzu(i3);
            int i5 = 1048575 & iZzu;
            int iZzt = zzt(iZzu);
            int i6 = iArr[i3];
            long j = i5;
            int iHashCode2 = 37;
            switch (iZzt) {
                case 0:
                    i = i4 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzhas.zzb(obj, j));
                    byte[] bArr = zzgyi.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzhas.zzc(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzhas.zzf(obj, j);
                    byte[] bArr2 = zzgyi.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzhas.zzf(obj, j);
                    byte[] bArr3 = zzgyi.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    iFloatToIntBits = zzhas.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzhas.zzf(obj, j);
                    byte[] bArr4 = zzgyi.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    iFloatToIntBits = zzhas.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    iFloatToIntBits = zzgyi.zza(zzhas.zzz(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    iFloatToIntBits = ((String) zzhas.zzh(obj, j)).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object objZzh = zzhas.zzh(obj, j);
                    if (objZzh != null) {
                        iHashCode2 = objZzh.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 10:
                    i = i4 * 53;
                    iFloatToIntBits = zzhas.zzh(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i4 * 53;
                    iFloatToIntBits = zzhas.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i4 * 53;
                    iFloatToIntBits = zzhas.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    iFloatToIntBits = zzhas.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzhas.zzf(obj, j);
                    byte[] bArr5 = zzgyi.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i4 * 53;
                    iFloatToIntBits = zzhas.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzhas.zzf(obj, j);
                    byte[] bArr6 = zzgyi.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object objZzh2 = zzhas.zzh(obj, j);
                    if (objZzh2 != null) {
                        iHashCode2 = objZzh2.hashCode();
                    }
                    i4 = i2 + iHashCode2;
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
                    i = i4 * 53;
                    iFloatToIntBits = zzhas.zzh(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i4 * 53;
                    iFloatToIntBits = zzhas.zzh(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzn(obj, j));
                        byte[] bArr7 = zzgyi.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzo(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr8 = zzgyi.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr9 = zzgyi.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr10 = zzgyi.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzgyi.zza(zzS(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = ((String) zzhas.zzh(obj, j)).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzhas.zzh(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzhas.zzh(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr11 = zzgyi.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr12 = zzgyi.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzhas.zzh(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:397:0x08b3 A[PHI: r7 r8 r9 r10 r14
  0x08b3: PHI (r7v29 int) = (r7v7 int), (r7v9 int), (r7v10 int), (r7v17 int), (r7v25 int), (r7v33 int) binds: [B:386:0x0868, B:366:0x07fb, B:346:0x0795, B:261:0x0610, B:209:0x0534, B:134:0x039a] A[DONT_GENERATE, DONT_INLINE]
  0x08b3: PHI (r8v86 int) = (r8v40 int), (r8v42 int), (r8v43 int), (r8v55 int), (r8v82 int), (r8v88 int) binds: [B:386:0x0868, B:366:0x07fb, B:346:0x0795, B:261:0x0610, B:209:0x0534, B:134:0x039a] A[DONT_GENERATE, DONT_INLINE]
  0x08b3: PHI (r9v71 int) = (r9v38 int), (r9v40 int), (r9v41 int), (r9v50 int), (r9v67 int), (r9v74 int) binds: [B:386:0x0868, B:366:0x07fb, B:346:0x0795, B:261:0x0610, B:209:0x0534, B:134:0x039a] A[DONT_GENERATE, DONT_INLINE]
  0x08b3: PHI (r10v54 int) = (r10v39 int), (r10v41 int), (r10v42 int), (r10v44 int), (r10v52 int), (r10v57 int) binds: [B:386:0x0868, B:366:0x07fb, B:346:0x0795, B:261:0x0610, B:209:0x0534, B:134:0x039a] A[DONT_GENERATE, DONT_INLINE]
  0x08b3: PHI (r14v43 sun.misc.Unsafe) = 
  (r14v17 sun.misc.Unsafe)
  (r14v19 sun.misc.Unsafe)
  (r14v20 sun.misc.Unsafe)
  (r14v22 sun.misc.Unsafe)
  (r14v39 sun.misc.Unsafe)
  (r14v46 sun.misc.Unsafe)
 binds: [B:386:0x0868, B:366:0x07fb, B:346:0x0795, B:261:0x0610, B:209:0x0534, B:134:0x039a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:441:0x0a2c A[PHI: r0 r3 r8 r11
  0x0a2c: PHI (r0v240 int) = (r0v232 int), (r0v235 int), (r0v236 int), (r0v239 int), (r0v241 int) binds: [B:439:0x0a06, B:435:0x09e8, B:426:0x09b0, B:423:0x098f, B:420:0x0966] A[DONT_GENERATE, DONT_INLINE]
  0x0a2c: PHI (r3v80 com.google.android.gms.internal.ads.zzgwb) = 
  (r3v72 com.google.android.gms.internal.ads.zzgwb)
  (r3v75 com.google.android.gms.internal.ads.zzgwb)
  (r3v76 com.google.android.gms.internal.ads.zzgwb)
  (r3v79 com.google.android.gms.internal.ads.zzgwb)
  (r3v82 com.google.android.gms.internal.ads.zzgwb)
 binds: [B:439:0x0a06, B:435:0x09e8, B:426:0x09b0, B:423:0x098f, B:420:0x0966] A[DONT_GENERATE, DONT_INLINE]
  0x0a2c: PHI (r8v104 int) = (r8v99 int), (r8v100 int), (r8v101 int), (r8v103 int), (r8v105 int) binds: [B:439:0x0a06, B:435:0x09e8, B:426:0x09b0, B:423:0x098f, B:420:0x0966] A[DONT_GENERATE, DONT_INLINE]
  0x0a2c: PHI (r11v34 int) = (r11v29 int), (r11v30 int), (r11v31 int), (r11v33 int), (r11v35 int) binds: [B:439:0x0a06, B:435:0x09e8, B:426:0x09b0, B:423:0x098f, B:420:0x0966] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:482:0x0b60 A[PHI: r3 r5 r8 r11 r12
  0x0b60: PHI (r3v89 int) = 
  (r3v64 int)
  (r3v65 int)
  (r3v66 int)
  (r3v67 int)
  (r3v68 int)
  (r3v69 int)
  (r3v70 int)
  (r3v71 int)
  (r3v81 int)
  (r3v90 int)
 binds: [B:480:0x0b49, B:477:0x0b26, B:474:0x0b07, B:471:0x0ae8, B:468:0x0ac9, B:465:0x0aa9, B:458:0x0a80, B:443:0x0a3e, B:441:0x0a2c, B:415:0x0922] A[DONT_GENERATE, DONT_INLINE]
  0x0b60: PHI (r5v57 com.google.android.gms.internal.ads.zzgwb) = 
  (r5v41 com.google.android.gms.internal.ads.zzgwb)
  (r5v42 com.google.android.gms.internal.ads.zzgwb)
  (r5v43 com.google.android.gms.internal.ads.zzgwb)
  (r5v44 com.google.android.gms.internal.ads.zzgwb)
  (r5v45 com.google.android.gms.internal.ads.zzgwb)
  (r5v46 com.google.android.gms.internal.ads.zzgwb)
  (r5v47 com.google.android.gms.internal.ads.zzgwb)
  (r5v48 com.google.android.gms.internal.ads.zzgwb)
  (r5v52 com.google.android.gms.internal.ads.zzgwb)
  (r5v58 com.google.android.gms.internal.ads.zzgwb)
 binds: [B:480:0x0b49, B:477:0x0b26, B:474:0x0b07, B:471:0x0ae8, B:468:0x0ac9, B:465:0x0aa9, B:458:0x0a80, B:443:0x0a3e, B:441:0x0a2c, B:415:0x0922] A[DONT_GENERATE, DONT_INLINE]
  0x0b60: PHI (r8v110 int) = 
  (r8v91 int)
  (r8v92 int)
  (r8v93 int)
  (r8v94 int)
  (r8v95 int)
  (r8v96 int)
  (r8v97 int)
  (r8v98 int)
  (r8v104 int)
  (r8v111 int)
 binds: [B:480:0x0b49, B:477:0x0b26, B:474:0x0b07, B:471:0x0ae8, B:468:0x0ac9, B:465:0x0aa9, B:458:0x0a80, B:443:0x0a3e, B:441:0x0a2c, B:415:0x0922] A[DONT_GENERATE, DONT_INLINE]
  0x0b60: PHI (r11v40 int) = 
  (r11v21 int)
  (r11v22 int)
  (r11v23 int)
  (r11v24 int)
  (r11v25 int)
  (r11v26 int)
  (r11v27 int)
  (r11v28 int)
  (r11v34 int)
  (r11v41 int)
 binds: [B:480:0x0b49, B:477:0x0b26, B:474:0x0b07, B:471:0x0ae8, B:468:0x0ac9, B:465:0x0aa9, B:458:0x0a80, B:443:0x0a3e, B:441:0x0a2c, B:415:0x0922] A[DONT_GENERATE, DONT_INLINE]
  0x0b60: PHI (r12v42 int) = 
  (r12v22 int)
  (r12v23 int)
  (r12v24 int)
  (r12v25 int)
  (r12v26 int)
  (r12v27 int)
  (r12v28 int)
  (r12v29 int)
  (r12v36 int)
  (r12v43 int)
 binds: [B:480:0x0b49, B:477:0x0b26, B:474:0x0b07, B:471:0x0ae8, B:468:0x0ac9, B:465:0x0aa9, B:458:0x0a80, B:443:0x0a3e, B:441:0x0a2c, B:415:0x0922] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:498:0x0bb6  */
    /* JADX WARN: Code duplicated, block: B:560:0x08b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:563:0x0b63 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:0x08c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:0x0b74 A[SYNTHETIC] */
    final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzgwb zzgwbVar) throws IOException {
        Unsafe unsafe;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Unsafe unsafe2;
        zzgwb zzgwbVar2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int iZzk;
        int i18;
        int i19;
        int i20;
        int i21;
        Unsafe unsafe3;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int iZzh;
        Object obj2;
        int i27;
        int iZzj;
        int i28;
        zzgwb zzgwbVar3;
        int i29;
        int iZza;
        Object obj3 = obj;
        i2 = i2;
        i3 = i3;
        zzgwb zzgwbVar4 = zzgwbVar;
        zzD(obj);
        Unsafe unsafe4 = zzb;
        int i30 = -1;
        int iZzg = i;
        int i31 = -1;
        int i32 = 0;
        int i33 = 0;
        int i34 = 0;
        int i35 = 1048575;
        while (true) {
            if (iZzg < i2) {
                int i36 = iZzg + 1;
                int i37 = bArr[iZzg];
                if (i37 < 0) {
                    int iZzi = zzgwc.zzi(i37, bArr, i36, zzgwbVar4);
                    i7 = zzgwbVar4.zza;
                    i36 = iZzi;
                } else {
                    i7 = i37;
                }
                int i38 = i7 >>> 3;
                int iZzs = i38 > i31 ? (i38 < this.zze || i38 > this.zzf) ? i30 : zzs(i38, i32 / 3) : zzq(i38);
                if (iZzs != i30) {
                    int i39 = i7 & 7;
                    int[] iArr = this.zzc;
                    int i40 = iArr[iZzs + 1];
                    int i41 = i38;
                    int iZzt = zzt(i40);
                    long j = i40 & 1048575;
                    int i42 = i7;
                    if (iZzt <= 17) {
                        int i43 = iArr[iZzs + 2];
                        int i44 = 1 << (i43 >>> 20);
                        int i45 = 1048575;
                        int i46 = i43 & 1048575;
                        if (i46 != i35) {
                            if (i35 != 1048575) {
                                unsafe4.putInt(obj3, i35, i34);
                                i45 = 1048575;
                            }
                            i34 = i46 == i45 ? 0 : unsafe4.getInt(obj3, i46);
                            i10 = i46;
                        } else {
                            i10 = i35;
                        }
                        switch (iZzt) {
                            case 0:
                                i14 = iZzs;
                                i15 = i41;
                                i16 = i42;
                                if (i39 == 1) {
                                    iZzg = i36 + 8;
                                    i34 |= i44;
                                    zzhas.zzr(obj3, j, Double.longBitsToDouble(zzgwc.zzn(bArr, i36)));
                                    i2 = i2;
                                    i3 = i3;
                                    i33 = i16;
                                    i31 = i15;
                                    i32 = i14;
                                    i35 = i10;
                                    i30 = -1;
                                } else {
                                    i34 = i34;
                                    i18 = i16;
                                    i41 = i15;
                                    i19 = i14;
                                    i11 = -1;
                                    i3 = i3;
                                    i9 = i34;
                                    i12 = i19;
                                    i7 = i18;
                                    i8 = i36;
                                    unsafe2 = unsafe4;
                                    zzgwbVar2 = zzgwbVar4;
                                    i13 = i41;
                                }
                                break;
                            case 1:
                                i14 = iZzs;
                                i15 = i41;
                                i16 = i42;
                                if (i39 == 5) {
                                    iZzg = i36 + 4;
                                    i34 |= i44;
                                    zzhas.zzs(obj3, j, Float.intBitsToFloat(zzgwc.zzb(bArr, i36)));
                                    i2 = i2;
                                    i3 = i3;
                                    i33 = i16;
                                    i31 = i15;
                                    i32 = i14;
                                    i35 = i10;
                                    i30 = -1;
                                } else {
                                    i34 = i34;
                                    i18 = i16;
                                    i41 = i15;
                                    i19 = i14;
                                    i11 = -1;
                                    i3 = i3;
                                    i9 = i34;
                                    i12 = i19;
                                    i7 = i18;
                                    i8 = i36;
                                    unsafe2 = unsafe4;
                                    zzgwbVar2 = zzgwbVar4;
                                    i13 = i41;
                                }
                                break;
                            case 2:
                            case 3:
                                i14 = iZzs;
                                i15 = i41;
                                i16 = i42;
                                if (i39 == 0) {
                                    i17 = i34 | i44;
                                    iZzk = zzgwc.zzk(bArr, i36, zzgwbVar4);
                                    unsafe4.putLong(obj, j, zzgwbVar4.zzb);
                                    i2 = i2;
                                    i3 = i3;
                                    i33 = i16;
                                    i31 = i15;
                                    i32 = i14;
                                    i34 = i17;
                                    iZzg = iZzk;
                                    i35 = i10;
                                    i30 = -1;
                                } else {
                                    i34 = i34;
                                    i18 = i16;
                                    i41 = i15;
                                    i19 = i14;
                                    i11 = -1;
                                    i3 = i3;
                                    i9 = i34;
                                    i12 = i19;
                                    i7 = i18;
                                    i8 = i36;
                                    unsafe2 = unsafe4;
                                    zzgwbVar2 = zzgwbVar4;
                                    i13 = i41;
                                }
                                break;
                            case 4:
                            case 11:
                                i14 = iZzs;
                                i15 = i41;
                                i16 = i42;
                                if (i39 == 0) {
                                    i34 |= i44;
                                    iZzg = zzgwc.zzh(bArr, i36, zzgwbVar4);
                                    unsafe4.putInt(obj3, j, zzgwbVar4.zza);
                                    i2 = i2;
                                    i3 = i3;
                                    i33 = i16;
                                    i31 = i15;
                                    i32 = i14;
                                    i35 = i10;
                                    i30 = -1;
                                } else {
                                    i34 = i34;
                                    i18 = i16;
                                    i41 = i15;
                                    i19 = i14;
                                    i11 = -1;
                                    i3 = i3;
                                    i9 = i34;
                                    i12 = i19;
                                    i7 = i18;
                                    i8 = i36;
                                    unsafe2 = unsafe4;
                                    zzgwbVar2 = zzgwbVar4;
                                    i13 = i41;
                                }
                                break;
                            case 5:
                            case 14:
                                i14 = iZzs;
                                i15 = i41;
                                i16 = i42;
                                if (i39 == 1) {
                                    iZzk = i36 + 8;
                                    i17 = i34 | i44;
                                    unsafe4.putLong(obj, j, zzgwc.zzn(bArr, i36));
                                    i2 = i2;
                                    i3 = i3;
                                    i33 = i16;
                                    i31 = i15;
                                    i32 = i14;
                                    i34 = i17;
                                    iZzg = iZzk;
                                    i35 = i10;
                                    i30 = -1;
                                } else {
                                    i34 = i34;
                                    i18 = i16;
                                    i41 = i15;
                                    i19 = i14;
                                    i11 = -1;
                                    i3 = i3;
                                    i9 = i34;
                                    i12 = i19;
                                    i7 = i18;
                                    i8 = i36;
                                    unsafe2 = unsafe4;
                                    zzgwbVar2 = zzgwbVar4;
                                    i13 = i41;
                                }
                                break;
                            case 6:
                            case 13:
                                i14 = iZzs;
                                i15 = i41;
                                i16 = i42;
                                if (i39 == 5) {
                                    iZzg = i36 + 4;
                                    i34 |= i44;
                                    unsafe4.putInt(obj3, j, zzgwc.zzb(bArr, i36));
                                    i2 = i2;
                                    i3 = i3;
                                    i33 = i16;
                                    i31 = i15;
                                    i32 = i14;
                                    i35 = i10;
                                    i30 = -1;
                                } else {
                                    i34 = i34;
                                    i18 = i16;
                                    i41 = i15;
                                    i19 = i14;
                                    i11 = -1;
                                    i3 = i3;
                                    i9 = i34;
                                    i12 = i19;
                                    i7 = i18;
                                    i8 = i36;
                                    unsafe2 = unsafe4;
                                    zzgwbVar2 = zzgwbVar4;
                                    i13 = i41;
                                }
                                break;
                            case 7:
                                i14 = iZzs;
                                i15 = i41;
                                i16 = i42;
                                if (i39 == 0) {
                                    i34 |= i44;
                                    iZzg = zzgwc.zzk(bArr, i36, zzgwbVar4);
                                    zzhas.zzp(obj3, j, zzgwbVar4.zzb != 0);
                                    i2 = i2;
                                    i3 = i3;
                                    i33 = i16;
                                    i31 = i15;
                                    i32 = i14;
                                    i35 = i10;
                                    i30 = -1;
                                } else {
                                    i34 = i34;
                                    i18 = i16;
                                    i41 = i15;
                                    i19 = i14;
                                    i11 = -1;
                                    i3 = i3;
                                    i9 = i34;
                                    i12 = i19;
                                    i7 = i18;
                                    i8 = i36;
                                    unsafe2 = unsafe4;
                                    zzgwbVar2 = zzgwbVar4;
                                    i13 = i41;
                                }
                                break;
                            case 8:
                                i14 = iZzs;
                                i15 = i41;
                                i16 = i42;
                                if (i39 == 2) {
                                    if (zzM(i40)) {
                                        iZzg = zzgwc.zzh(bArr, i36, zzgwbVar4);
                                        int i47 = zzgwbVar4.zza;
                                        if (i47 < 0) {
                                            throw new zzgyk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                        }
                                        int i48 = i34 | i44;
                                        if (i47 == 0) {
                                            zzgwbVar4.zzc = "";
                                        } else {
                                            zzgwbVar4.zzc = zzhax.zzh(bArr, iZzg, i47);
                                            iZzg += i47;
                                        }
                                        i34 = i48;
                                    } else {
                                        int i49 = i34 | i44;
                                        int iZzh2 = zzgwc.zzh(bArr, i36, zzgwbVar4);
                                        int i50 = zzgwbVar4.zza;
                                        if (i50 < 0) {
                                            throw new zzgyk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                        }
                                        if (i50 == 0) {
                                            zzgwbVar4.zzc = "";
                                        } else {
                                            zzgwbVar4.zzc = new String(bArr, iZzh2, i50, zzgyi.zza);
                                            iZzh2 += i50;
                                        }
                                        i34 = i49;
                                        iZzg = iZzh2;
                                    }
                                    unsafe4.putObject(obj3, j, zzgwbVar4.zzc);
                                    i2 = i2;
                                    i3 = i3;
                                    i33 = i16;
                                    i31 = i15;
                                    i32 = i14;
                                    i35 = i10;
                                    i30 = -1;
                                } else {
                                    i34 = i34;
                                    i18 = i16;
                                    i41 = i15;
                                    i19 = i14;
                                    i11 = -1;
                                    i3 = i3;
                                    i9 = i34;
                                    i12 = i19;
                                    i7 = i18;
                                    i8 = i36;
                                    unsafe2 = unsafe4;
                                    zzgwbVar2 = zzgwbVar4;
                                    i13 = i41;
                                }
                                break;
                            case 9:
                                i14 = iZzs;
                                i15 = i41;
                                i16 = i42;
                                if (i39 == 2) {
                                    Object objZzA = zzA(obj3, i14);
                                    iZzg = zzgwc.zzm(objZzA, zzx(i14), bArr, i36, i2, zzgwbVar);
                                    zzJ(obj3, i14, objZzA);
                                    i2 = i2;
                                    i33 = i16;
                                    i31 = i15;
                                    i32 = i14;
                                    i34 |= i44;
                                    i35 = i10;
                                    i30 = -1;
                                    i3 = i3;
                                } else {
                                    i34 = i34;
                                    i18 = i16;
                                    i41 = i15;
                                    i19 = i14;
                                    i11 = -1;
                                    i3 = i3;
                                    i9 = i34;
                                    i12 = i19;
                                    i7 = i18;
                                    i8 = i36;
                                    unsafe2 = unsafe4;
                                    zzgwbVar2 = zzgwbVar4;
                                    i13 = i41;
                                }
                                break;
                            case 10:
                                i14 = iZzs;
                                i15 = i41;
                                i16 = i42;
                                if (i39 == 2) {
                                    i34 |= i44;
                                    iZzg = zzgwc.zza(bArr, i36, zzgwbVar4);
                                    unsafe4.putObject(obj3, j, zzgwbVar4.zzc);
                                    i2 = i2;
                                    i3 = i3;
                                    i33 = i16;
                                    i31 = i15;
                                    i32 = i14;
                                    i35 = i10;
                                    i30 = -1;
                                } else {
                                    i34 = i34;
                                    i18 = i16;
                                    i41 = i15;
                                    i19 = i14;
                                    i11 = -1;
                                    i3 = i3;
                                    i9 = i34;
                                    i12 = i19;
                                    i7 = i18;
                                    i8 = i36;
                                    unsafe2 = unsafe4;
                                    zzgwbVar2 = zzgwbVar4;
                                    i13 = i41;
                                }
                                break;
                            case 12:
                                i14 = iZzs;
                                i15 = i41;
                                if (i39 == 0) {
                                    iZzg = zzgwc.zzh(bArr, i36, zzgwbVar4);
                                    int i51 = zzgwbVar4.zza;
                                    zzgyb zzgybVarZzw = zzw(i14);
                                    if ((i40 & Integer.MIN_VALUE) == 0 || zzgybVarZzw == null || zzgybVarZzw.zza(i51)) {
                                        i16 = i42;
                                        i34 |= i44;
                                        unsafe4.putInt(obj3, j, i51);
                                    } else {
                                        i16 = i42;
                                        zzd(obj).zzj(i16, Long.valueOf(i51));
                                    }
                                    i2 = i2;
                                    i3 = i3;
                                    i33 = i16;
                                    i31 = i15;
                                    i32 = i14;
                                    i35 = i10;
                                    i30 = -1;
                                } else {
                                    i41 = i15;
                                    i19 = i14;
                                    i18 = i42;
                                    i11 = -1;
                                    i3 = i3;
                                    i9 = i34;
                                    i12 = i19;
                                    i7 = i18;
                                    i8 = i36;
                                    unsafe2 = unsafe4;
                                    zzgwbVar2 = zzgwbVar4;
                                    i13 = i41;
                                }
                                break;
                            case 15:
                                i14 = iZzs;
                                i15 = i41;
                                if (i39 == 0) {
                                    i34 |= i44;
                                    iZzg = zzgwc.zzh(bArr, i36, zzgwbVar4);
                                    unsafe4.putInt(obj3, j, zzgwt.zzD(zzgwbVar4.zza));
                                    i31 = i15;
                                    i32 = i14;
                                    i33 = i42;
                                    i35 = i10;
                                    i30 = -1;
                                } else {
                                    i41 = i15;
                                    i19 = i14;
                                    i18 = i42;
                                    i11 = -1;
                                    i3 = i3;
                                    i9 = i34;
                                    i12 = i19;
                                    i7 = i18;
                                    i8 = i36;
                                    unsafe2 = unsafe4;
                                    zzgwbVar2 = zzgwbVar4;
                                    i13 = i41;
                                }
                                break;
                            case 16:
                                if (i39 == 0) {
                                    int i52 = i34 | i44;
                                    int iZzk2 = zzgwc.zzk(bArr, i36, zzgwbVar4);
                                    i15 = i41;
                                    i14 = iZzs;
                                    unsafe4.putLong(obj, j, zzgwt.zzF(zzgwbVar4.zzb));
                                    iZzg = iZzk2;
                                    i34 = i52;
                                    i31 = i15;
                                    i32 = i14;
                                    i33 = i42;
                                    i35 = i10;
                                    i30 = -1;
                                } else {
                                    i19 = iZzs;
                                    i18 = i42;
                                    i11 = -1;
                                    i3 = i3;
                                    i9 = i34;
                                    i12 = i19;
                                    i7 = i18;
                                    i8 = i36;
                                    unsafe2 = unsafe4;
                                    zzgwbVar2 = zzgwbVar4;
                                    i13 = i41;
                                }
                                break;
                            default:
                                i14 = iZzs;
                                i15 = i41;
                                i16 = i42;
                                if (i39 == 3) {
                                    int i53 = i34 | i44;
                                    Object objZzA2 = zzA(obj3, i14);
                                    int iZzl = zzgwc.zzl(objZzA2, zzx(i14), bArr, i36, i2, (i15 << 3) | 4, zzgwbVar);
                                    zzJ(obj3, i14, objZzA2);
                                    i3 = i3;
                                    zzgwbVar4 = zzgwbVar4;
                                    i2 = i2;
                                    unsafe4 = unsafe4;
                                    iZzg = iZzl;
                                    i30 = -1;
                                    i35 = i10;
                                    i34 = i53;
                                    i33 = i16;
                                    i32 = i14;
                                    i31 = i15;
                                } else {
                                    i34 = i34;
                                    i18 = i16;
                                    i41 = i15;
                                    i19 = i14;
                                    i11 = -1;
                                    i3 = i3;
                                    i9 = i34;
                                    i12 = i19;
                                    i7 = i18;
                                    i8 = i36;
                                    unsafe2 = unsafe4;
                                    zzgwbVar2 = zzgwbVar4;
                                    i13 = i41;
                                }
                                break;
                        }
                    } else {
                        int i54 = iZzs;
                        i9 = i34;
                        i10 = i35;
                        Unsafe unsafe5 = unsafe4;
                        int i55 = i42;
                        i11 = -1;
                        int i56 = i2;
                        if (iZzt != 27) {
                            zzgwbVar4 = zzgwbVar;
                            if (iZzt <= 49) {
                                long j2 = i40;
                                zzgyh zzgyhVarZzf = (zzgyh) unsafe5.getObject(obj3, j);
                                if (!zzgyhVarZzf.zzc()) {
                                    int size = zzgyhVarZzf.size();
                                    zzgyhVarZzf = zzgyhVarZzf.zzf(size + size);
                                    unsafe5.putObject(obj3, j, zzgyhVarZzf);
                                }
                                zzgyh zzgyhVar = zzgyhVarZzf;
                                switch (iZzt) {
                                    case 18:
                                    case 35:
                                        i21 = i36;
                                        i56 = i56;
                                        unsafe3 = unsafe5;
                                        i54 = i54;
                                        i22 = i41;
                                        if (i39 == 2) {
                                            int i57 = zzgwc.zza;
                                            zzgxc zzgxcVar = (zzgxc) zzgyhVar;
                                            iZzg = zzgwc.zzh(bArr, i21, zzgwbVar4);
                                            int i58 = zzgwbVar4.zza;
                                            int i59 = iZzg + i58;
                                            if (i59 > bArr.length) {
                                                throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzgxcVar.zzi(zzgxcVar.size() + (i58 / 8));
                                            while (iZzg < i59) {
                                                zzgxcVar.zzh(Double.longBitsToDouble(zzgwc.zzn(bArr, iZzg)));
                                                iZzg += 8;
                                            }
                                            if (iZzg != i59) {
                                                throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        } else if (i39 == 1) {
                                            i23 = i21 + 8;
                                            int i60 = zzgwc.zza;
                                            zzgxc zzgxcVar2 = (zzgxc) zzgyhVar;
                                            zzgxcVar2.zzh(Double.longBitsToDouble(zzgwc.zzn(bArr, i21)));
                                            while (i23 < i56) {
                                                int iZzh3 = zzgwc.zzh(bArr, i23, zzgwbVar4);
                                                if (i55 == zzgwbVar4.zza) {
                                                    zzgxcVar2.zzh(Double.longBitsToDouble(zzgwc.zzn(bArr, iZzh3)));
                                                    i23 = iZzh3 + 8;
                                                } else {
                                                    iZzg = i23;
                                                }
                                            }
                                            iZzg = i23;
                                        } else {
                                            iZzg = i21;
                                        }
                                        if (iZzg != i21) {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i3 = i3;
                                            i32 = i54;
                                            i31 = i22;
                                            i33 = i55;
                                            unsafe4 = unsafe3;
                                            i30 = -1;
                                            i34 = i9;
                                            i35 = i10;
                                            i2 = i56;
                                        } else {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i8 = iZzg;
                                            i13 = i22;
                                            zzgwbVar2 = zzgwbVar4;
                                            unsafe2 = unsafe3;
                                            int i61 = i55;
                                            i12 = i54;
                                            i7 = i61;
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        i21 = i36;
                                        i56 = i56;
                                        unsafe3 = unsafe5;
                                        i54 = i54;
                                        i22 = i41;
                                        if (i39 == 2) {
                                            int i62 = zzgwc.zza;
                                            zzgxm zzgxmVar = (zzgxm) zzgyhVar;
                                            iZzg = zzgwc.zzh(bArr, i21, zzgwbVar4);
                                            int i63 = zzgwbVar4.zza;
                                            int i64 = iZzg + i63;
                                            if (i64 > bArr.length) {
                                                throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzgxmVar.zzi(zzgxmVar.size() + (i63 / 4));
                                            while (iZzg < i64) {
                                                zzgxmVar.zzh(Float.intBitsToFloat(zzgwc.zzb(bArr, iZzg)));
                                                iZzg += 4;
                                            }
                                            if (iZzg != i64) {
                                                throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        } else if (i39 == 5) {
                                            i23 = i21 + 4;
                                            int i65 = zzgwc.zza;
                                            zzgxm zzgxmVar2 = (zzgxm) zzgyhVar;
                                            zzgxmVar2.zzh(Float.intBitsToFloat(zzgwc.zzb(bArr, i21)));
                                            while (i23 < i56) {
                                                int iZzh4 = zzgwc.zzh(bArr, i23, zzgwbVar4);
                                                if (i55 == zzgwbVar4.zza) {
                                                    zzgxmVar2.zzh(Float.intBitsToFloat(zzgwc.zzb(bArr, iZzh4)));
                                                    i23 = iZzh4 + 4;
                                                } else {
                                                    iZzg = i23;
                                                }
                                            }
                                            iZzg = i23;
                                        } else {
                                            iZzg = i21;
                                        }
                                        if (iZzg != i21) {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i3 = i3;
                                            i32 = i54;
                                            i31 = i22;
                                            i33 = i55;
                                            unsafe4 = unsafe3;
                                            i30 = -1;
                                            i34 = i9;
                                            i35 = i10;
                                            i2 = i56;
                                        } else {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i8 = iZzg;
                                            i13 = i22;
                                            zzgwbVar2 = zzgwbVar4;
                                            unsafe2 = unsafe3;
                                            int i66 = i55;
                                            i12 = i54;
                                            i7 = i66;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        i21 = i36;
                                        i56 = i56;
                                        unsafe3 = unsafe5;
                                        i54 = i54;
                                        i22 = i41;
                                        if (i39 == 2) {
                                            int i67 = zzgwc.zza;
                                            zzgyv zzgyvVar = (zzgyv) zzgyhVar;
                                            iZzg = zzgwc.zzh(bArr, i21, zzgwbVar4);
                                            int i68 = zzgwbVar4.zza + iZzg;
                                            while (iZzg < i68) {
                                                iZzg = zzgwc.zzk(bArr, iZzg, zzgwbVar4);
                                                zzgyvVar.zzg(zzgwbVar4.zzb);
                                            }
                                            if (iZzg != i68) {
                                                throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        } else if (i39 == 0) {
                                            int i69 = zzgwc.zza;
                                            zzgyv zzgyvVar2 = (zzgyv) zzgyhVar;
                                            iZzg = zzgwc.zzk(bArr, i21, zzgwbVar4);
                                            zzgyvVar2.zzg(zzgwbVar4.zzb);
                                            while (iZzg < i56) {
                                                int iZzh5 = zzgwc.zzh(bArr, iZzg, zzgwbVar4);
                                                if (i55 == zzgwbVar4.zza) {
                                                    iZzg = zzgwc.zzk(bArr, iZzh5, zzgwbVar4);
                                                    zzgyvVar2.zzg(zzgwbVar4.zzb);
                                                }
                                            }
                                        } else {
                                            iZzg = i21;
                                        }
                                        if (iZzg != i21) {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i3 = i3;
                                            i32 = i54;
                                            i31 = i22;
                                            i33 = i55;
                                            unsafe4 = unsafe3;
                                            i30 = -1;
                                            i34 = i9;
                                            i35 = i10;
                                            i2 = i56;
                                        } else {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i8 = iZzg;
                                            i13 = i22;
                                            zzgwbVar2 = zzgwbVar4;
                                            unsafe2 = unsafe3;
                                            int i610 = i55;
                                            i12 = i54;
                                            i7 = i610;
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case 39:
                                    case 43:
                                        i21 = i36;
                                        i24 = i56;
                                        i25 = i54;
                                        i26 = i41;
                                        if (i39 == 2) {
                                            iZzg = zzgwc.zzf(bArr, i21, zzgyhVar, zzgwbVar4);
                                            i54 = i25;
                                            i56 = i24;
                                            i22 = i26;
                                            unsafe3 = unsafe5;
                                        } else if (i39 == 0) {
                                            i54 = i25;
                                            i56 = i24;
                                            i22 = i26;
                                            unsafe3 = unsafe5;
                                            iZzg = zzgwc.zzj(i55, bArr, i21, i2, zzgyhVar, zzgwbVar);
                                        } else {
                                            i54 = i25;
                                            i56 = i24;
                                            i22 = i26;
                                            unsafe3 = unsafe5;
                                            iZzg = i21;
                                        }
                                        if (iZzg != i21) {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i3 = i3;
                                            i32 = i54;
                                            i31 = i22;
                                            i33 = i55;
                                            unsafe4 = unsafe3;
                                            i30 = -1;
                                            i34 = i9;
                                            i35 = i10;
                                            i2 = i56;
                                        } else {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i8 = iZzg;
                                            i13 = i22;
                                            zzgwbVar2 = zzgwbVar4;
                                            unsafe2 = unsafe3;
                                            int i611 = i55;
                                            i12 = i54;
                                            i7 = i611;
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case 40:
                                    case 46:
                                        i21 = i36;
                                        i24 = i56;
                                        i25 = i54;
                                        i26 = i41;
                                        if (i39 != 2) {
                                            if (i39 == 1) {
                                                iZzg = i21 + 8;
                                                int i70 = zzgwc.zza;
                                                zzgyv zzgyvVar3 = (zzgyv) zzgyhVar;
                                                zzgyvVar3.zzg(zzgwc.zzn(bArr, i21));
                                                while (iZzg < i24) {
                                                    int iZzh6 = zzgwc.zzh(bArr, iZzg, zzgwbVar4);
                                                    if (i55 == zzgwbVar4.zza) {
                                                        zzgyvVar3.zzg(zzgwc.zzn(bArr, iZzh6));
                                                        iZzg = iZzh6 + 8;
                                                    }
                                                }
                                            }
                                            i54 = i25;
                                            i56 = i24;
                                            i22 = i26;
                                            unsafe3 = unsafe5;
                                            iZzg = i21;
                                            if (iZzg != i21) {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i3 = i3;
                                                i32 = i54;
                                                i31 = i22;
                                                i33 = i55;
                                                unsafe4 = unsafe3;
                                                i30 = -1;
                                                i34 = i9;
                                                i35 = i10;
                                                i2 = i56;
                                            } else {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i8 = iZzg;
                                                i13 = i22;
                                                zzgwbVar2 = zzgwbVar4;
                                                unsafe2 = unsafe3;
                                                int i612 = i55;
                                                i12 = i54;
                                                i7 = i612;
                                            }
                                        } else {
                                            int i71 = zzgwc.zza;
                                            zzgyv zzgyvVar4 = (zzgyv) zzgyhVar;
                                            iZzg = zzgwc.zzh(bArr, i21, zzgwbVar4);
                                            int i72 = zzgwbVar4.zza;
                                            int i73 = iZzg + i72;
                                            if (i73 > bArr.length) {
                                                throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzgyvVar4.zzi(zzgyvVar4.size() + (i72 / 8));
                                            while (iZzg < i73) {
                                                zzgyvVar4.zzg(zzgwc.zzn(bArr, iZzg));
                                                iZzg += 8;
                                            }
                                            if (iZzg != i73) {
                                                throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i54 = i25;
                                        i56 = i24;
                                        i22 = i26;
                                        unsafe3 = unsafe5;
                                        if (iZzg != i21) {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i3 = i3;
                                            i32 = i54;
                                            i31 = i22;
                                            i33 = i55;
                                            unsafe4 = unsafe3;
                                            i30 = -1;
                                            i34 = i9;
                                            i35 = i10;
                                            i2 = i56;
                                        } else {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i8 = iZzg;
                                            i13 = i22;
                                            zzgwbVar2 = zzgwbVar4;
                                            unsafe2 = unsafe3;
                                            int i613 = i55;
                                            i12 = i54;
                                            i7 = i613;
                                        }
                                        break;
                                    case 24:
                                    case 31:
                                    case 41:
                                    case 45:
                                        i21 = i36;
                                        i24 = i56;
                                        i25 = i54;
                                        i26 = i41;
                                        if (i39 != 2) {
                                            if (i39 == 5) {
                                                iZzg = i21 + 4;
                                                int i74 = zzgwc.zza;
                                                zzgxw zzgxwVar = (zzgxw) zzgyhVar;
                                                zzgxwVar.zzi(zzgwc.zzb(bArr, i21));
                                                while (iZzg < i24) {
                                                    int iZzh7 = zzgwc.zzh(bArr, iZzg, zzgwbVar4);
                                                    if (i55 == zzgwbVar4.zza) {
                                                        zzgxwVar.zzi(zzgwc.zzb(bArr, iZzh7));
                                                        iZzg = iZzh7 + 4;
                                                    }
                                                }
                                            }
                                            i54 = i25;
                                            i56 = i24;
                                            i22 = i26;
                                            unsafe3 = unsafe5;
                                            iZzg = i21;
                                            if (iZzg != i21) {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i3 = i3;
                                                i32 = i54;
                                                i31 = i22;
                                                i33 = i55;
                                                unsafe4 = unsafe3;
                                                i30 = -1;
                                                i34 = i9;
                                                i35 = i10;
                                                i2 = i56;
                                            } else {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i8 = iZzg;
                                                i13 = i22;
                                                zzgwbVar2 = zzgwbVar4;
                                                unsafe2 = unsafe3;
                                                int i614 = i55;
                                                i12 = i54;
                                                i7 = i614;
                                            }
                                        } else {
                                            int i75 = zzgwc.zza;
                                            zzgxw zzgxwVar2 = (zzgxw) zzgyhVar;
                                            iZzg = zzgwc.zzh(bArr, i21, zzgwbVar4);
                                            int i76 = zzgwbVar4.zza;
                                            int i77 = iZzg + i76;
                                            if (i77 > bArr.length) {
                                                throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzgxwVar2.zzj(zzgxwVar2.size() + (i76 / 4));
                                            while (iZzg < i77) {
                                                zzgxwVar2.zzi(zzgwc.zzb(bArr, iZzg));
                                                iZzg += 4;
                                            }
                                            if (iZzg != i77) {
                                                throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i54 = i25;
                                        i56 = i24;
                                        i22 = i26;
                                        unsafe3 = unsafe5;
                                        if (iZzg != i21) {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i3 = i3;
                                            i32 = i54;
                                            i31 = i22;
                                            i33 = i55;
                                            unsafe4 = unsafe3;
                                            i30 = -1;
                                            i34 = i9;
                                            i35 = i10;
                                            i2 = i56;
                                        } else {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i8 = iZzg;
                                            i13 = i22;
                                            zzgwbVar2 = zzgwbVar4;
                                            unsafe2 = unsafe3;
                                            int i615 = i55;
                                            i12 = i54;
                                            i7 = i615;
                                        }
                                        break;
                                    case 25:
                                    case 42:
                                        i21 = i36;
                                        i24 = i56;
                                        i25 = i54;
                                        i26 = i41;
                                        if (i39 != 2) {
                                            if (i39 == 0) {
                                                int i78 = zzgwc.zza;
                                                zzgwd zzgwdVar = (zzgwd) zzgyhVar;
                                                iZzg = zzgwc.zzk(bArr, i21, zzgwbVar4);
                                                zzgwdVar.zzg(zzgwbVar4.zzb != 0);
                                                while (iZzg < i24) {
                                                    int iZzh8 = zzgwc.zzh(bArr, iZzg, zzgwbVar4);
                                                    if (i55 == zzgwbVar4.zza) {
                                                        iZzg = zzgwc.zzk(bArr, iZzh8, zzgwbVar4);
                                                        zzgwdVar.zzg(zzgwbVar4.zzb != 0);
                                                    }
                                                }
                                            }
                                            i54 = i25;
                                            i56 = i24;
                                            i22 = i26;
                                            unsafe3 = unsafe5;
                                            iZzg = i21;
                                            if (iZzg != i21) {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i3 = i3;
                                                i32 = i54;
                                                i31 = i22;
                                                i33 = i55;
                                                unsafe4 = unsafe3;
                                                i30 = -1;
                                                i34 = i9;
                                                i35 = i10;
                                                i2 = i56;
                                            } else {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i8 = iZzg;
                                                i13 = i22;
                                                zzgwbVar2 = zzgwbVar4;
                                                unsafe2 = unsafe3;
                                                int i616 = i55;
                                                i12 = i54;
                                                i7 = i616;
                                            }
                                        } else {
                                            int i79 = zzgwc.zza;
                                            zzgwd zzgwdVar2 = (zzgwd) zzgyhVar;
                                            iZzg = zzgwc.zzh(bArr, i21, zzgwbVar4);
                                            int i80 = zzgwbVar4.zza + iZzg;
                                            while (iZzg < i80) {
                                                iZzg = zzgwc.zzk(bArr, iZzg, zzgwbVar4);
                                                zzgwdVar2.zzg(zzgwbVar4.zzb != 0);
                                            }
                                            if (iZzg != i80) {
                                                throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i54 = i25;
                                        i56 = i24;
                                        i22 = i26;
                                        unsafe3 = unsafe5;
                                        if (iZzg != i21) {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i3 = i3;
                                            i32 = i54;
                                            i31 = i22;
                                            i33 = i55;
                                            unsafe4 = unsafe3;
                                            i30 = -1;
                                            i34 = i9;
                                            i35 = i10;
                                            i2 = i56;
                                        } else {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i8 = iZzg;
                                            i13 = i22;
                                            zzgwbVar2 = zzgwbVar4;
                                            unsafe2 = unsafe3;
                                            int i617 = i55;
                                            i12 = i54;
                                            i7 = i617;
                                        }
                                        break;
                                    case 26:
                                        i21 = i36;
                                        i24 = i56;
                                        i54 = i54;
                                        i26 = i41;
                                        if (i39 == 2) {
                                            if ((j2 & 536870912) == 0) {
                                                iZzh = zzgwc.zzh(bArr, i21, zzgwbVar4);
                                                int i81 = zzgwbVar4.zza;
                                                if (i81 < 0) {
                                                    throw new zzgyk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i81 == 0) {
                                                    obj2 = "";
                                                    zzgyhVar.add(obj2);
                                                } else {
                                                    obj2 = "";
                                                    zzgyhVar.add(new String(bArr, iZzh, i81, zzgyi.zza));
                                                    iZzh += i81;
                                                }
                                                while (iZzh < i24) {
                                                    int iZzh9 = zzgwc.zzh(bArr, iZzh, zzgwbVar4);
                                                    if (i55 == zzgwbVar4.zza) {
                                                        iZzh = zzgwc.zzh(bArr, iZzh9, zzgwbVar4);
                                                        int i82 = zzgwbVar4.zza;
                                                        if (i82 < 0) {
                                                            throw new zzgyk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i82 == 0) {
                                                            zzgyhVar.add(obj2);
                                                        } else {
                                                            zzgyhVar.add(new String(bArr, iZzh, i82, zzgyi.zza));
                                                            iZzh += i82;
                                                        }
                                                    }
                                                }
                                            } else {
                                                iZzh = zzgwc.zzh(bArr, i21, zzgwbVar4);
                                                int i83 = zzgwbVar4.zza;
                                                if (i83 < 0) {
                                                    throw new zzgyk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i83 == 0) {
                                                    zzgyhVar.add("");
                                                } else {
                                                    int i84 = iZzh + i83;
                                                    if (!zzhax.zzi(bArr, iZzh, i84)) {
                                                        throw new zzgyk("Protocol message had invalid UTF-8.");
                                                    }
                                                    zzgyhVar.add(new String(bArr, iZzh, i83, zzgyi.zza));
                                                    iZzh = i84;
                                                }
                                                while (iZzh < i24) {
                                                    int iZzh10 = zzgwc.zzh(bArr, iZzh, zzgwbVar4);
                                                    if (i55 == zzgwbVar4.zza) {
                                                        iZzh = zzgwc.zzh(bArr, iZzh10, zzgwbVar4);
                                                        int i85 = zzgwbVar4.zza;
                                                        if (i85 < 0) {
                                                            throw new zzgyk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i85 == 0) {
                                                            zzgyhVar.add("");
                                                        } else {
                                                            int i86 = iZzh + i85;
                                                            if (!zzhax.zzi(bArr, iZzh, i86)) {
                                                                throw new zzgyk("Protocol message had invalid UTF-8.");
                                                            }
                                                            zzgyhVar.add(new String(bArr, iZzh, i85, zzgyi.zza));
                                                            iZzh = i86;
                                                        }
                                                    }
                                                }
                                            }
                                            iZzg = iZzh;
                                            i56 = i24;
                                            i22 = i26;
                                            unsafe3 = unsafe5;
                                            if (iZzg != i21) {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i3 = i3;
                                                i32 = i54;
                                                i31 = i22;
                                                i33 = i55;
                                                unsafe4 = unsafe3;
                                                i30 = -1;
                                                i34 = i9;
                                                i35 = i10;
                                                i2 = i56;
                                            } else {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i8 = iZzg;
                                                i13 = i22;
                                                zzgwbVar2 = zzgwbVar4;
                                                unsafe2 = unsafe3;
                                                int i618 = i55;
                                                i12 = i54;
                                                i7 = i618;
                                            }
                                        } else {
                                            i54 = i54;
                                            i56 = i24;
                                            i22 = i26;
                                            unsafe3 = unsafe5;
                                            iZzg = i21;
                                            if (iZzg != i21) {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i3 = i3;
                                                i32 = i54;
                                                i31 = i22;
                                                i33 = i55;
                                                unsafe4 = unsafe3;
                                                i30 = -1;
                                                i34 = i9;
                                                i35 = i10;
                                                i2 = i56;
                                            } else {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i8 = iZzg;
                                                i13 = i22;
                                                zzgwbVar2 = zzgwbVar4;
                                                unsafe2 = unsafe3;
                                                int i619 = i55;
                                                i12 = i54;
                                                i7 = i619;
                                            }
                                        }
                                        break;
                                    case 27:
                                        i27 = i36;
                                        i56 = i56;
                                        unsafe5 = unsafe5;
                                        if (i39 == 2) {
                                            i21 = i27;
                                            int iZze = zzgwc.zze(zzx(i54), i55, bArr, i27, i2, zzgyhVar, zzgwbVar);
                                            i22 = i41;
                                            unsafe3 = unsafe5;
                                            iZzg = iZze;
                                        } else {
                                            i21 = i27;
                                            unsafe3 = unsafe5;
                                            i54 = i54;
                                            i22 = i41;
                                            iZzg = i21;
                                        }
                                        if (iZzg != i21) {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i3 = i3;
                                            i32 = i54;
                                            i31 = i22;
                                            i33 = i55;
                                            unsafe4 = unsafe3;
                                            i30 = -1;
                                            i34 = i9;
                                            i35 = i10;
                                            i2 = i56;
                                        } else {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i8 = iZzg;
                                            i13 = i22;
                                            zzgwbVar2 = zzgwbVar4;
                                            unsafe2 = unsafe3;
                                            int i6110 = i55;
                                            i12 = i54;
                                            i7 = i6110;
                                        }
                                        break;
                                    case 28:
                                        i27 = i36;
                                        i56 = i56;
                                        unsafe5 = unsafe5;
                                        if (i39 == 2) {
                                            iZzg = zzgwc.zzh(bArr, i27, zzgwbVar4);
                                            int i87 = zzgwbVar4.zza;
                                            if (i87 < 0) {
                                                throw new zzgyk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            if (i87 > bArr.length - iZzg) {
                                                throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            if (i87 == 0) {
                                                zzgyhVar.add(zzgwn.zzb);
                                            } else {
                                                zzgyhVar.add(zzgwn.zzv(bArr, iZzg, i87));
                                                iZzg += i87;
                                            }
                                            while (iZzg < i56) {
                                                int iZzh11 = zzgwc.zzh(bArr, iZzg, zzgwbVar4);
                                                if (i55 != zzgwbVar4.zza) {
                                                    i21 = i27;
                                                    unsafe3 = unsafe5;
                                                    i54 = i54;
                                                    i22 = i41;
                                                    if (iZzg != i21) {
                                                        i55 = i55;
                                                        zzgwbVar4 = zzgwbVar4;
                                                        i56 = i56;
                                                        i54 = i54;
                                                        obj3 = obj;
                                                        i3 = i3;
                                                        i32 = i54;
                                                        i31 = i22;
                                                        i33 = i55;
                                                        unsafe4 = unsafe3;
                                                        i30 = -1;
                                                        i34 = i9;
                                                        i35 = i10;
                                                        i2 = i56;
                                                    } else {
                                                        i55 = i55;
                                                        zzgwbVar4 = zzgwbVar4;
                                                        i56 = i56;
                                                        i54 = i54;
                                                        obj3 = obj;
                                                        i8 = iZzg;
                                                        i13 = i22;
                                                        zzgwbVar2 = zzgwbVar4;
                                                        unsafe2 = unsafe3;
                                                        int i6111 = i55;
                                                        i12 = i54;
                                                        i7 = i6111;
                                                    }
                                                    break;
                                                } else {
                                                    iZzg = zzgwc.zzh(bArr, iZzh11, zzgwbVar4);
                                                    int i88 = zzgwbVar4.zza;
                                                    if (i88 < 0) {
                                                        throw new zzgyk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i88 > bArr.length - iZzg) {
                                                        throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    if (i88 == 0) {
                                                        zzgyhVar.add(zzgwn.zzb);
                                                    } else {
                                                        zzgyhVar.add(zzgwn.zzv(bArr, iZzg, i88));
                                                        iZzg += i88;
                                                    }
                                                }
                                            }
                                            i21 = i27;
                                            unsafe3 = unsafe5;
                                            i54 = i54;
                                            i22 = i41;
                                            if (iZzg != i21) {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i3 = i3;
                                                i32 = i54;
                                                i31 = i22;
                                                i33 = i55;
                                                unsafe4 = unsafe3;
                                                i30 = -1;
                                                i34 = i9;
                                                i35 = i10;
                                                i2 = i56;
                                            } else {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i8 = iZzg;
                                                i13 = i22;
                                                zzgwbVar2 = zzgwbVar4;
                                                unsafe2 = unsafe3;
                                                int i6112 = i55;
                                                i12 = i54;
                                                i7 = i6112;
                                            }
                                        }
                                        i21 = i27;
                                        unsafe3 = unsafe5;
                                        i54 = i54;
                                        i22 = i41;
                                        iZzg = i21;
                                        if (iZzg != i21) {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i3 = i3;
                                            i32 = i54;
                                            i31 = i22;
                                            i33 = i55;
                                            unsafe4 = unsafe3;
                                            i30 = -1;
                                            i34 = i9;
                                            i35 = i10;
                                            i2 = i56;
                                        } else {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i8 = iZzg;
                                            i13 = i22;
                                            zzgwbVar2 = zzgwbVar4;
                                            unsafe2 = unsafe3;
                                            int i6113 = i55;
                                            i12 = i54;
                                            i7 = i6113;
                                        }
                                        break;
                                    case 30:
                                    case 44:
                                        if (i39 != 2) {
                                            if (i39 == 0) {
                                                iZzj = zzgwc.zzj(i55, bArr, i36, i2, zzgyhVar, zzgwbVar);
                                            }
                                            i21 = i36;
                                            i56 = i56;
                                            unsafe3 = unsafe5;
                                            i54 = i54;
                                            i22 = i41;
                                            iZzg = i21;
                                            if (iZzg != i21) {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i3 = i3;
                                                i32 = i54;
                                                i31 = i22;
                                                i33 = i55;
                                                unsafe4 = unsafe3;
                                                i30 = -1;
                                                i34 = i9;
                                                i35 = i10;
                                                i2 = i56;
                                            } else {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i8 = iZzg;
                                                i13 = i22;
                                                zzgwbVar2 = zzgwbVar4;
                                                unsafe2 = unsafe3;
                                                int i6114 = i55;
                                                i12 = i54;
                                                i7 = i6114;
                                            }
                                        } else {
                                            iZzj = zzgwc.zzf(bArr, i36, zzgyhVar, zzgwbVar4);
                                        }
                                        zzhab.zzn(obj, i41, zzgyhVar, zzw(i54), null, this.zzm);
                                        i21 = i36;
                                        iZzg = iZzj;
                                        unsafe3 = unsafe5;
                                        i54 = i54;
                                        i22 = i41;
                                        if (iZzg != i21) {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i3 = i3;
                                            i32 = i54;
                                            i31 = i22;
                                            i33 = i55;
                                            unsafe4 = unsafe3;
                                            i30 = -1;
                                            i34 = i9;
                                            i35 = i10;
                                            i2 = i56;
                                        } else {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i8 = iZzg;
                                            i13 = i22;
                                            zzgwbVar2 = zzgwbVar4;
                                            unsafe2 = unsafe3;
                                            int i6115 = i55;
                                            i12 = i54;
                                            i7 = i6115;
                                        }
                                        break;
                                    case 33:
                                    case 47:
                                        if (i39 != 2) {
                                            if (i39 == 0) {
                                                int i89 = zzgwc.zza;
                                                zzgxw zzgxwVar3 = (zzgxw) zzgyhVar;
                                                iZzg = zzgwc.zzh(bArr, i36, zzgwbVar4);
                                                zzgxwVar3.zzi(zzgwt.zzD(zzgwbVar4.zza));
                                                while (iZzg < i56) {
                                                    int iZzh12 = zzgwc.zzh(bArr, iZzg, zzgwbVar4);
                                                    if (i55 == zzgwbVar4.zza) {
                                                        iZzg = zzgwc.zzh(bArr, iZzh12, zzgwbVar4);
                                                        zzgxwVar3.zzi(zzgwt.zzD(zzgwbVar4.zza));
                                                    }
                                                }
                                            }
                                            i21 = i36;
                                            i56 = i56;
                                            unsafe3 = unsafe5;
                                            i54 = i54;
                                            i22 = i41;
                                            iZzg = i21;
                                            if (iZzg != i21) {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i3 = i3;
                                                i32 = i54;
                                                i31 = i22;
                                                i33 = i55;
                                                unsafe4 = unsafe3;
                                                i30 = -1;
                                                i34 = i9;
                                                i35 = i10;
                                                i2 = i56;
                                            } else {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i8 = iZzg;
                                                i13 = i22;
                                                zzgwbVar2 = zzgwbVar4;
                                                unsafe2 = unsafe3;
                                                int i6116 = i55;
                                                i12 = i54;
                                                i7 = i6116;
                                            }
                                        } else {
                                            int i90 = zzgwc.zza;
                                            zzgxw zzgxwVar4 = (zzgxw) zzgyhVar;
                                            iZzg = zzgwc.zzh(bArr, i36, zzgwbVar4);
                                            int i91 = zzgwbVar4.zza + iZzg;
                                            while (iZzg < i91) {
                                                iZzg = zzgwc.zzh(bArr, iZzg, zzgwbVar4);
                                                zzgxwVar4.zzi(zzgwt.zzD(zzgwbVar4.zza));
                                            }
                                            if (iZzg != i91) {
                                                throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i21 = i36;
                                        i56 = i56;
                                        unsafe3 = unsafe5;
                                        i54 = i54;
                                        i22 = i41;
                                        if (iZzg != i21) {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i3 = i3;
                                            i32 = i54;
                                            i31 = i22;
                                            i33 = i55;
                                            unsafe4 = unsafe3;
                                            i30 = -1;
                                            i34 = i9;
                                            i35 = i10;
                                            i2 = i56;
                                        } else {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i8 = iZzg;
                                            i13 = i22;
                                            zzgwbVar2 = zzgwbVar4;
                                            unsafe2 = unsafe3;
                                            int i6117 = i55;
                                            i12 = i54;
                                            i7 = i6117;
                                        }
                                        break;
                                    case 34:
                                    case 48:
                                        if (i39 != 2) {
                                            if (i39 == 0) {
                                                int i92 = zzgwc.zza;
                                                zzgyv zzgyvVar5 = (zzgyv) zzgyhVar;
                                                iZzg = zzgwc.zzk(bArr, i36, zzgwbVar4);
                                                zzgyvVar5.zzg(zzgwt.zzF(zzgwbVar4.zzb));
                                                while (iZzg < i56) {
                                                    int iZzh13 = zzgwc.zzh(bArr, iZzg, zzgwbVar4);
                                                    if (i55 == zzgwbVar4.zza) {
                                                        iZzg = zzgwc.zzk(bArr, iZzh13, zzgwbVar4);
                                                        zzgyvVar5.zzg(zzgwt.zzF(zzgwbVar4.zzb));
                                                    }
                                                }
                                            }
                                            i21 = i36;
                                            i56 = i56;
                                            unsafe3 = unsafe5;
                                            i54 = i54;
                                            i22 = i41;
                                            iZzg = i21;
                                            if (iZzg != i21) {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i3 = i3;
                                                i32 = i54;
                                                i31 = i22;
                                                i33 = i55;
                                                unsafe4 = unsafe3;
                                                i30 = -1;
                                                i34 = i9;
                                                i35 = i10;
                                                i2 = i56;
                                            } else {
                                                i55 = i55;
                                                zzgwbVar4 = zzgwbVar4;
                                                i56 = i56;
                                                i54 = i54;
                                                obj3 = obj;
                                                i8 = iZzg;
                                                i13 = i22;
                                                zzgwbVar2 = zzgwbVar4;
                                                unsafe2 = unsafe3;
                                                int i6118 = i55;
                                                i12 = i54;
                                                i7 = i6118;
                                            }
                                        } else {
                                            int i93 = zzgwc.zza;
                                            zzgyv zzgyvVar6 = (zzgyv) zzgyhVar;
                                            iZzg = zzgwc.zzh(bArr, i36, zzgwbVar4);
                                            int i94 = zzgwbVar4.zza + iZzg;
                                            while (iZzg < i94) {
                                                iZzg = zzgwc.zzk(bArr, iZzg, zzgwbVar4);
                                                zzgyvVar6.zzg(zzgwt.zzF(zzgwbVar4.zzb));
                                            }
                                            if (iZzg != i94) {
                                                throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i21 = i36;
                                        i56 = i56;
                                        unsafe3 = unsafe5;
                                        i54 = i54;
                                        i22 = i41;
                                        if (iZzg != i21) {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i3 = i3;
                                            i32 = i54;
                                            i31 = i22;
                                            i33 = i55;
                                            unsafe4 = unsafe3;
                                            i30 = -1;
                                            i34 = i9;
                                            i35 = i10;
                                            i2 = i56;
                                        } else {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i8 = iZzg;
                                            i13 = i22;
                                            zzgwbVar2 = zzgwbVar4;
                                            unsafe2 = unsafe3;
                                            int i6119 = i55;
                                            i12 = i54;
                                            i7 = i6119;
                                        }
                                        break;
                                    default:
                                        i21 = i36;
                                        i56 = i56;
                                        unsafe3 = unsafe5;
                                        i54 = i54;
                                        i22 = i41;
                                        if (i39 == 3) {
                                            int i95 = (i55 & (-8)) | 4;
                                            zzgzz zzgzzVarZzx = zzx(i54);
                                            iZzg = zzgwc.zzc(zzgzzVarZzx, bArr, i21, i2, i95, zzgwbVar);
                                            zzgyhVar.add(zzgwbVar4.zzc);
                                            while (iZzg < i56) {
                                                int iZzh14 = zzgwc.zzh(bArr, iZzg, zzgwbVar4);
                                                if (i55 == zzgwbVar4.zza) {
                                                    iZzg = zzgwc.zzc(zzgzzVarZzx, bArr, iZzh14, i2, i95, zzgwbVar);
                                                    zzgyhVar.add(zzgwbVar4.zzc);
                                                }
                                            }
                                        } else {
                                            iZzg = i21;
                                        }
                                        if (iZzg != i21) {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i3 = i3;
                                            i32 = i54;
                                            i31 = i22;
                                            i33 = i55;
                                            unsafe4 = unsafe3;
                                            i30 = -1;
                                            i34 = i9;
                                            i35 = i10;
                                            i2 = i56;
                                        } else {
                                            i55 = i55;
                                            zzgwbVar4 = zzgwbVar4;
                                            i56 = i56;
                                            i54 = i54;
                                            obj3 = obj;
                                            i8 = iZzg;
                                            i13 = i22;
                                            zzgwbVar2 = zzgwbVar4;
                                            unsafe2 = unsafe3;
                                            int i61110 = i55;
                                            i12 = i54;
                                            i7 = i61110;
                                        }
                                        break;
                                }
                            } else {
                                int i96 = i36;
                                unsafe2 = unsafe5;
                                i13 = i41;
                                i54 = i54;
                                if (iZzt != 50) {
                                    obj3 = obj;
                                    long j3 = iArr[i54 + 2] & 1048575;
                                    switch (iZzt) {
                                        case 51:
                                            i28 = i96;
                                            i13 = i13;
                                            zzgwbVar2 = zzgwbVar;
                                            i12 = i54;
                                            i7 = i55;
                                            if (i39 == 1) {
                                                iZzg = i28 + 8;
                                                unsafe2.putObject(obj3, j, Double.valueOf(Double.longBitsToDouble(zzgwc.zzn(bArr, i28))));
                                                unsafe2.putInt(obj3, j3, i13);
                                            } else {
                                                iZzg = i28;
                                            }
                                            if (iZzg == i28) {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i2 = i2;
                                                i3 = i3;
                                                i31 = i13;
                                                zzgwbVar4 = zzgwbVar2;
                                                i33 = i7;
                                                i32 = i12;
                                                i30 = -1;
                                                i35 = i10;
                                                unsafe4 = unsafe2;
                                                i34 = i9;
                                            } else {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i3 = i3;
                                                i8 = iZzg;
                                            }
                                            break;
                                        case 52:
                                            i28 = i96;
                                            i13 = i13;
                                            zzgwbVar2 = zzgwbVar;
                                            i12 = i54;
                                            i7 = i55;
                                            if (i39 == 5) {
                                                iZzg = i28 + 4;
                                                unsafe2.putObject(obj3, j, Float.valueOf(Float.intBitsToFloat(zzgwc.zzb(bArr, i28))));
                                                unsafe2.putInt(obj3, j3, i13);
                                            } else {
                                                iZzg = i28;
                                            }
                                            if (iZzg == i28) {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i2 = i2;
                                                i3 = i3;
                                                i31 = i13;
                                                zzgwbVar4 = zzgwbVar2;
                                                i33 = i7;
                                                i32 = i12;
                                                i30 = -1;
                                                i35 = i10;
                                                unsafe4 = unsafe2;
                                                i34 = i9;
                                            } else {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i3 = i3;
                                                i8 = iZzg;
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            i28 = i96;
                                            i13 = i13;
                                            zzgwbVar2 = zzgwbVar;
                                            i12 = i54;
                                            i7 = i55;
                                            if (i39 == 0) {
                                                iZzg = zzgwc.zzk(bArr, i28, zzgwbVar2);
                                                unsafe2.putObject(obj3, j, Long.valueOf(zzgwbVar2.zzb));
                                                unsafe2.putInt(obj3, j3, i13);
                                            } else {
                                                iZzg = i28;
                                            }
                                            if (iZzg == i28) {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i2 = i2;
                                                i3 = i3;
                                                i31 = i13;
                                                zzgwbVar4 = zzgwbVar2;
                                                i33 = i7;
                                                i32 = i12;
                                                i30 = -1;
                                                i35 = i10;
                                                unsafe4 = unsafe2;
                                                i34 = i9;
                                            } else {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i3 = i3;
                                                i8 = iZzg;
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            i28 = i96;
                                            i13 = i13;
                                            zzgwbVar2 = zzgwbVar;
                                            i12 = i54;
                                            i7 = i55;
                                            if (i39 == 0) {
                                                iZzg = zzgwc.zzh(bArr, i28, zzgwbVar2);
                                                unsafe2.putObject(obj3, j, Integer.valueOf(zzgwbVar2.zza));
                                                unsafe2.putInt(obj3, j3, i13);
                                            } else {
                                                iZzg = i28;
                                            }
                                            if (iZzg == i28) {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i2 = i2;
                                                i3 = i3;
                                                i31 = i13;
                                                zzgwbVar4 = zzgwbVar2;
                                                i33 = i7;
                                                i32 = i12;
                                                i30 = -1;
                                                i35 = i10;
                                                unsafe4 = unsafe2;
                                                i34 = i9;
                                            } else {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i3 = i3;
                                                i8 = iZzg;
                                            }
                                            break;
                                        case 56:
                                        case 65:
                                            i28 = i96;
                                            i13 = i13;
                                            zzgwbVar2 = zzgwbVar;
                                            i12 = i54;
                                            i7 = i55;
                                            if (i39 == 1) {
                                                iZzg = i28 + 8;
                                                unsafe2.putObject(obj3, j, Long.valueOf(zzgwc.zzn(bArr, i28)));
                                                unsafe2.putInt(obj3, j3, i13);
                                            } else {
                                                iZzg = i28;
                                            }
                                            if (iZzg == i28) {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i2 = i2;
                                                i3 = i3;
                                                i31 = i13;
                                                zzgwbVar4 = zzgwbVar2;
                                                i33 = i7;
                                                i32 = i12;
                                                i30 = -1;
                                                i35 = i10;
                                                unsafe4 = unsafe2;
                                                i34 = i9;
                                            } else {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i3 = i3;
                                                i8 = iZzg;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            i28 = i96;
                                            i13 = i13;
                                            zzgwbVar2 = zzgwbVar;
                                            i12 = i54;
                                            i7 = i55;
                                            if (i39 == 5) {
                                                iZzg = i28 + 4;
                                                unsafe2.putObject(obj3, j, Integer.valueOf(zzgwc.zzb(bArr, i28)));
                                                unsafe2.putInt(obj3, j3, i13);
                                            } else {
                                                iZzg = i28;
                                            }
                                            if (iZzg == i28) {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i2 = i2;
                                                i3 = i3;
                                                i31 = i13;
                                                zzgwbVar4 = zzgwbVar2;
                                                i33 = i7;
                                                i32 = i12;
                                                i30 = -1;
                                                i35 = i10;
                                                unsafe4 = unsafe2;
                                                i34 = i9;
                                            } else {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i3 = i3;
                                                i8 = iZzg;
                                            }
                                            break;
                                        case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                                            i28 = i96;
                                            i13 = i13;
                                            zzgwbVar2 = zzgwbVar;
                                            i12 = i54;
                                            i7 = i55;
                                            if (i39 == 0) {
                                                iZzg = zzgwc.zzk(bArr, i28, zzgwbVar2);
                                                unsafe2.putObject(obj3, j, Boolean.valueOf(zzgwbVar2.zzb != 0));
                                                unsafe2.putInt(obj3, j3, i13);
                                            } else {
                                                iZzg = i28;
                                            }
                                            if (iZzg == i28) {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i2 = i2;
                                                i3 = i3;
                                                i31 = i13;
                                                zzgwbVar4 = zzgwbVar2;
                                                i33 = i7;
                                                i32 = i12;
                                                i30 = -1;
                                                i35 = i10;
                                                unsafe4 = unsafe2;
                                                i34 = i9;
                                            } else {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i3 = i3;
                                                i8 = iZzg;
                                            }
                                            break;
                                        case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                                            i28 = i96;
                                            i13 = i13;
                                            zzgwbVar2 = zzgwbVar;
                                            i12 = i54;
                                            i7 = i55;
                                            if (i39 == 2) {
                                                iZzg = zzgwc.zzh(bArr, i28, zzgwbVar2);
                                                int i97 = zzgwbVar2.zza;
                                                if (i97 == 0) {
                                                    unsafe2.putObject(obj3, j, "");
                                                } else {
                                                    int i98 = iZzg + i97;
                                                    if ((i40 & 536870912) != 0 && !zzhax.zzi(bArr, iZzg, i98)) {
                                                        throw new zzgyk("Protocol message had invalid UTF-8.");
                                                    }
                                                    unsafe2.putObject(obj3, j, new String(bArr, iZzg, i97, zzgyi.zza));
                                                    iZzg = i98;
                                                }
                                                unsafe2.putInt(obj3, j3, i13);
                                            } else {
                                                iZzg = i28;
                                            }
                                            if (iZzg == i28) {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i2 = i2;
                                                i3 = i3;
                                                i31 = i13;
                                                zzgwbVar4 = zzgwbVar2;
                                                i33 = i7;
                                                i32 = i12;
                                                i30 = -1;
                                                i35 = i10;
                                                unsafe4 = unsafe2;
                                                i34 = i9;
                                            } else {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i3 = i3;
                                                i8 = iZzg;
                                            }
                                            break;
                                        case 60:
                                            zzgwbVar3 = zzgwbVar;
                                            i29 = i13;
                                            i12 = i54;
                                            i7 = i55;
                                            if (i39 == 2) {
                                                Object objZzB = zzB(obj3, i29, i12);
                                                i28 = i96;
                                                iZzg = zzgwc.zzm(objZzB, zzx(i12), bArr, i96, i2, zzgwbVar);
                                                zzK(obj3, i29, i12, objZzB);
                                                zzgwbVar2 = zzgwbVar3;
                                                i13 = i29;
                                            } else {
                                                i28 = i96;
                                                zzgwbVar2 = zzgwbVar3;
                                                i13 = i29;
                                                iZzg = i28;
                                            }
                                            if (iZzg == i28) {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i2 = i2;
                                                i3 = i3;
                                                i31 = i13;
                                                zzgwbVar4 = zzgwbVar2;
                                                i33 = i7;
                                                i32 = i12;
                                                i30 = -1;
                                                i35 = i10;
                                                unsafe4 = unsafe2;
                                                i34 = i9;
                                            } else {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i3 = i3;
                                                i8 = iZzg;
                                            }
                                            break;
                                        case 61:
                                            i29 = i13;
                                            zzgwbVar3 = zzgwbVar;
                                            i12 = i54;
                                            i7 = i55;
                                            if (i39 == 2) {
                                                iZza = zzgwc.zza(bArr, i96, zzgwbVar3);
                                                unsafe2.putObject(obj3, j, zzgwbVar3.zzc);
                                                unsafe2.putInt(obj3, j3, i29);
                                                i28 = i96;
                                                zzgwbVar2 = zzgwbVar3;
                                                i13 = i29;
                                                iZzg = iZza;
                                                if (iZzg == i28) {
                                                    unsafe2 = unsafe2;
                                                    i13 = i13;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    i31 = i13;
                                                    zzgwbVar4 = zzgwbVar2;
                                                    i33 = i7;
                                                    i32 = i12;
                                                    i30 = -1;
                                                    i35 = i10;
                                                    unsafe4 = unsafe2;
                                                    i34 = i9;
                                                } else {
                                                    unsafe2 = unsafe2;
                                                    i13 = i13;
                                                    i3 = i3;
                                                    i8 = iZzg;
                                                }
                                            }
                                            i28 = i96;
                                            zzgwbVar2 = zzgwbVar3;
                                            i13 = i29;
                                            iZzg = i28;
                                            if (iZzg == i28) {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i2 = i2;
                                                i3 = i3;
                                                i31 = i13;
                                                zzgwbVar4 = zzgwbVar2;
                                                i33 = i7;
                                                i32 = i12;
                                                i30 = -1;
                                                i35 = i10;
                                                unsafe4 = unsafe2;
                                                i34 = i9;
                                            } else {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i3 = i3;
                                                i8 = iZzg;
                                            }
                                            break;
                                        case 63:
                                            i29 = i13;
                                            zzgwbVar3 = zzgwbVar;
                                            i12 = i54;
                                            i7 = i55;
                                            if (i39 == 0) {
                                                iZza = zzgwc.zzh(bArr, i96, zzgwbVar3);
                                                int i99 = zzgwbVar3.zza;
                                                zzgyb zzgybVarZzw2 = zzw(i12);
                                                if (zzgybVarZzw2 == null || zzgybVarZzw2.zza(i99)) {
                                                    unsafe2.putObject(obj3, j, Integer.valueOf(i99));
                                                    unsafe2.putInt(obj3, j3, i29);
                                                } else {
                                                    zzd(obj).zzj(i7, Long.valueOf(i99));
                                                }
                                                i28 = i96;
                                                zzgwbVar2 = zzgwbVar3;
                                                i13 = i29;
                                                iZzg = iZza;
                                                if (iZzg == i28) {
                                                    unsafe2 = unsafe2;
                                                    i13 = i13;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    i31 = i13;
                                                    zzgwbVar4 = zzgwbVar2;
                                                    i33 = i7;
                                                    i32 = i12;
                                                    i30 = -1;
                                                    i35 = i10;
                                                    unsafe4 = unsafe2;
                                                    i34 = i9;
                                                } else {
                                                    unsafe2 = unsafe2;
                                                    i13 = i13;
                                                    i3 = i3;
                                                    i8 = iZzg;
                                                }
                                            }
                                            i28 = i96;
                                            zzgwbVar2 = zzgwbVar3;
                                            i13 = i29;
                                            iZzg = i28;
                                            if (iZzg == i28) {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i2 = i2;
                                                i3 = i3;
                                                i31 = i13;
                                                zzgwbVar4 = zzgwbVar2;
                                                i33 = i7;
                                                i32 = i12;
                                                i30 = -1;
                                                i35 = i10;
                                                unsafe4 = unsafe2;
                                                i34 = i9;
                                            } else {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i3 = i3;
                                                i8 = iZzg;
                                            }
                                            break;
                                        case 66:
                                            i29 = i13;
                                            zzgwbVar3 = zzgwbVar;
                                            i12 = i54;
                                            i7 = i55;
                                            if (i39 == 0) {
                                                iZza = zzgwc.zzh(bArr, i96, zzgwbVar3);
                                                unsafe2.putObject(obj3, j, Integer.valueOf(zzgwt.zzD(zzgwbVar3.zza)));
                                                unsafe2.putInt(obj3, j3, i29);
                                                i28 = i96;
                                                zzgwbVar2 = zzgwbVar3;
                                                i13 = i29;
                                                iZzg = iZza;
                                                if (iZzg == i28) {
                                                    unsafe2 = unsafe2;
                                                    i13 = i13;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    i31 = i13;
                                                    zzgwbVar4 = zzgwbVar2;
                                                    i33 = i7;
                                                    i32 = i12;
                                                    i30 = -1;
                                                    i35 = i10;
                                                    unsafe4 = unsafe2;
                                                    i34 = i9;
                                                } else {
                                                    unsafe2 = unsafe2;
                                                    i13 = i13;
                                                    i3 = i3;
                                                    i8 = iZzg;
                                                }
                                            }
                                            i28 = i96;
                                            zzgwbVar2 = zzgwbVar3;
                                            i13 = i29;
                                            iZzg = i28;
                                            if (iZzg == i28) {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i2 = i2;
                                                i3 = i3;
                                                i31 = i13;
                                                zzgwbVar4 = zzgwbVar2;
                                                i33 = i7;
                                                i32 = i12;
                                                i30 = -1;
                                                i35 = i10;
                                                unsafe4 = unsafe2;
                                                i34 = i9;
                                            } else {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i3 = i3;
                                                i8 = iZzg;
                                            }
                                            break;
                                        case 67:
                                            i29 = i13;
                                            zzgwbVar3 = zzgwbVar;
                                            i12 = i54;
                                            i7 = i55;
                                            if (i39 == 0) {
                                                int iZzk3 = zzgwc.zzk(bArr, i96, zzgwbVar3);
                                                unsafe2.putObject(obj3, j, Long.valueOf(zzgwt.zzF(zzgwbVar3.zzb)));
                                                unsafe2.putInt(obj3, j3, i29);
                                                i28 = i96;
                                                zzgwbVar2 = zzgwbVar3;
                                                i13 = i29;
                                                iZzg = iZzk3;
                                            } else {
                                                i28 = i96;
                                                zzgwbVar2 = zzgwbVar3;
                                                i13 = i29;
                                                iZzg = i28;
                                            }
                                            if (iZzg == i28) {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i2 = i2;
                                                i3 = i3;
                                                i31 = i13;
                                                zzgwbVar4 = zzgwbVar2;
                                                i33 = i7;
                                                i32 = i12;
                                                i30 = -1;
                                                i35 = i10;
                                                unsafe4 = unsafe2;
                                                i34 = i9;
                                            } else {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i3 = i3;
                                                i8 = iZzg;
                                            }
                                            break;
                                        case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                                            if (i39 == 3) {
                                                Object objZzB2 = zzB(obj3, i13, i54);
                                                int iZzl2 = zzgwc.zzl(objZzB2, zzx(i54), bArr, i96, i2, (i55 & (-8)) | 4, zzgwbVar);
                                                zzK(obj3, i13, i54, objZzB2);
                                                i12 = i54;
                                                i28 = i96;
                                                zzgwbVar2 = zzgwbVar;
                                                iZzg = iZzl2;
                                                i7 = i55;
                                            }
                                            if (iZzg == i28) {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i3 = i3;
                                                i8 = iZzg;
                                                break;
                                            } else {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i2 = i2;
                                                i3 = i3;
                                                i31 = i13;
                                                zzgwbVar4 = zzgwbVar2;
                                                i33 = i7;
                                                i32 = i12;
                                                i30 = -1;
                                                i35 = i10;
                                                unsafe4 = unsafe2;
                                                i34 = i9;
                                                break;
                                            }
                                        default:
                                            i28 = i96;
                                            i13 = i13;
                                            zzgwbVar2 = zzgwbVar;
                                            i12 = i54;
                                            i7 = i55;
                                            iZzg = i28;
                                            if (iZzg == i28) {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i2 = i2;
                                                i3 = i3;
                                                i31 = i13;
                                                zzgwbVar4 = zzgwbVar2;
                                                i33 = i7;
                                                i32 = i12;
                                                i30 = -1;
                                                i35 = i10;
                                                unsafe4 = unsafe2;
                                                i34 = i9;
                                            } else {
                                                unsafe2 = unsafe2;
                                                i13 = i13;
                                                i3 = i3;
                                                i8 = iZzg;
                                            }
                                            break;
                                    }
                                } else {
                                    if (i39 == 2) {
                                        Object objZzz = zzz(i54);
                                        Object object = unsafe2.getObject(obj, j);
                                        if (zzgzb.zza(object)) {
                                            zzgza zzgzaVarZzb = zzgza.zza().zzb();
                                            zzgzb.zzb(zzgzaVarZzb, object);
                                            unsafe2.putObject(obj, j, zzgzaVarZzb);
                                        }
                                        throw null;
                                    }
                                    i20 = i96;
                                    obj3 = obj;
                                    i8 = i20;
                                    zzgwbVar2 = zzgwbVar4;
                                    int i61111 = i55;
                                    i12 = i54;
                                    i7 = i61111;
                                }
                            }
                        } else if (i39 == 2) {
                            zzgyh zzgyhVarZzf2 = (zzgyh) unsafe5.getObject(obj3, j);
                            if (!zzgyhVarZzf2.zzc()) {
                                int size2 = zzgyhVarZzf2.size();
                                zzgyhVarZzf2 = zzgyhVarZzf2.zzf(size2 == 0 ? 10 : size2 + size2);
                                unsafe5.putObject(obj3, j, zzgyhVarZzf2);
                            }
                            int iZze2 = zzgwc.zze(zzx(i54), i55, bArr, i36, i2, zzgyhVarZzf2, zzgwbVar);
                            i3 = i3;
                            zzgwbVar4 = zzgwbVar;
                            i2 = i56;
                            unsafe4 = unsafe5;
                            i30 = -1;
                            i34 = i9;
                            i35 = i10;
                            i33 = i55;
                            i32 = i54;
                            i31 = i41;
                            iZzg = iZze2;
                        } else {
                            zzgwbVar4 = zzgwbVar;
                            unsafe2 = unsafe5;
                            i20 = i36;
                            i13 = i41;
                            i8 = i20;
                            zzgwbVar2 = zzgwbVar4;
                            int i61112 = i55;
                            i12 = i54;
                            i7 = i61112;
                        }
                    }
                } else {
                    i8 = i36;
                    i9 = i34;
                    i10 = i35;
                    i11 = i30;
                    unsafe2 = unsafe4;
                    zzgwbVar2 = zzgwbVar4;
                    i3 = i3;
                    i12 = 0;
                    i13 = i38;
                }
                if (i7 != i3 || i3 == 0) {
                    if (this.zzh) {
                        zzgxf zzgxfVar = zzgwbVar2.zzd;
                        int i100 = zzgxf.zzb;
                        int i101 = zzgzq.zza;
                        if (zzgxfVar != zzgxf.zza) {
                            zzgzg zzgzgVar = this.zzg;
                            int i102 = zzgwc.zza;
                            if (zzgxfVar.zzc(zzgzgVar, i13) != null) {
                                throw null;
                            }
                            iZzg = zzgwc.zzg(i7, bArr, i8, i2, zzd(obj), zzgwbVar);
                        } else {
                            iZzg = zzgwc.zzg(i7, bArr, i8, i2, zzd(obj), zzgwbVar);
                        }
                    } else {
                        iZzg = zzgwc.zzg(i7, bArr, i8, i2, zzd(obj), zzgwbVar);
                    }
                    i2 = i2;
                    i33 = i7;
                    i32 = i12;
                    i31 = i13;
                    unsafe4 = unsafe2;
                    i30 = i11;
                    i34 = i9;
                    i35 = i10;
                    zzgwbVar4 = zzgwbVar;
                    i3 = i3;
                } else {
                    unsafe = unsafe2;
                    i5 = i7;
                    i34 = i9;
                    i35 = i10;
                    i6 = 1048575;
                    i4 = i8;
                }
            } else {
                i3 = i3;
                unsafe = unsafe4;
                i4 = iZzg;
                i5 = i33;
                i6 = 1048575;
            }
        }
        if (i35 != i6) {
            unsafe.putInt(obj3, i35, i34);
        }
        for (int i103 = this.zzk; i103 < this.zzl; i103++) {
            zzy(obj, this.zzj[i103], null, this.zzm, obj);
        }
        if (i3 == 0) {
            if (i4 != i2) {
                throw new zzgyk("Failed to parse the message.");
            }
        } else if (i4 > i2 || i5 != i3) {
            throw new zzgyk("Failed to parse the message.");
        }
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final Object zze() {
        return ((zzgxv) this.zzg).zzbj();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgzz
    public final void zzf(Object obj) {
        if (zzQ(obj)) {
            if (obj instanceof zzgxv) {
                zzgxv zzgxvVar = (zzgxv) obj;
                zzgxvVar.zzbT();
                zzgxvVar.zzbS();
                zzgxvVar.zzbV();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzu = zzu(i);
                int i2 = 1048575 & iZzu;
                int iZzt = zzt(iZzu);
                long j = i2;
                if (iZzt != 9) {
                    if (iZzt != 60 && iZzt != 68) {
                        switch (iZzt) {
                            case 17:
                                if (zzN(obj, i)) {
                                    zzx(i).zzf(zzb.getObject(obj, j));
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
                                ((zzgyh) zzhas.zzh(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzgza) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzR(obj, iArr[i], i)) {
                        zzx(i).zzf(zzb.getObject(obj, j));
                    }
                } else if (zzN(obj, i)) {
                    zzx(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzi(obj);
            if (this.zzh) {
                this.zzn.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzhab.zzq(this.zzm, obj, obj2);
                if (this.zzh) {
                    zzhab.zzp(this.zzn, obj, obj2);
                    return;
                }
                return;
            }
            int iZzu = zzu(i);
            int i2 = 1048575 & iZzu;
            int iZzt = zzt(iZzu);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzt) {
                case 0:
                    if (zzN(obj2, i)) {
                        zzhas.zzr(obj, j, zzhas.zzb(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 1:
                    if (zzN(obj2, i)) {
                        zzhas.zzs(obj, j, zzhas.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 2:
                    if (zzN(obj2, i)) {
                        zzhas.zzu(obj, j, zzhas.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 3:
                    if (zzN(obj2, i)) {
                        zzhas.zzu(obj, j, zzhas.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 4:
                    if (zzN(obj2, i)) {
                        zzhas.zzt(obj, j, zzhas.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 5:
                    if (zzN(obj2, i)) {
                        zzhas.zzu(obj, j, zzhas.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 6:
                    if (zzN(obj2, i)) {
                        zzhas.zzt(obj, j, zzhas.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 7:
                    if (zzN(obj2, i)) {
                        zzhas.zzp(obj, j, zzhas.zzz(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 8:
                    if (zzN(obj2, i)) {
                        zzhas.zzv(obj, j, zzhas.zzh(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 9:
                    zzE(obj, obj2, i);
                    break;
                case 10:
                    if (zzN(obj2, i)) {
                        zzhas.zzv(obj, j, zzhas.zzh(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 11:
                    if (zzN(obj2, i)) {
                        zzhas.zzt(obj, j, zzhas.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 12:
                    if (zzN(obj2, i)) {
                        zzhas.zzt(obj, j, zzhas.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 13:
                    if (zzN(obj2, i)) {
                        zzhas.zzt(obj, j, zzhas.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 14:
                    if (zzN(obj2, i)) {
                        zzhas.zzu(obj, j, zzhas.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 15:
                    if (zzN(obj2, i)) {
                        zzhas.zzt(obj, j, zzhas.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 16:
                    if (zzN(obj2, i)) {
                        zzhas.zzu(obj, j, zzhas.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 17:
                    zzE(obj, obj2, i);
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
                    zzgyh zzgyhVarZzf = (zzgyh) zzhas.zzh(obj, j);
                    zzgyh zzgyhVar = (zzgyh) zzhas.zzh(obj2, j);
                    int size = zzgyhVarZzf.size();
                    int size2 = zzgyhVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzgyhVarZzf.zzc()) {
                            zzgyhVarZzf = zzgyhVarZzf.zzf(size2 + size);
                        }
                        zzgyhVarZzf.addAll(zzgyhVar);
                    }
                    if (size > 0) {
                        zzgyhVar = zzgyhVarZzf;
                    }
                    zzhas.zzv(obj, j, zzgyhVar);
                    break;
                case 50:
                    int i4 = zzhab.zza;
                    zzhas.zzv(obj, j, zzgzb.zzb(zzhas.zzh(obj, j), zzhas.zzh(obj2, j)));
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
                    if (zzR(obj2, i3, i)) {
                        zzhas.zzv(obj, j, zzhas.zzh(obj2, j));
                        zzI(obj, i3, i);
                    }
                    break;
                case 60:
                    zzF(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzR(obj2, i3, i)) {
                        zzhas.zzv(obj, j, zzhas.zzh(obj2, j));
                        zzI(obj, i3, i);
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    zzF(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:140:0x050e  */
    /* JADX WARN: Code duplicated, block: B:318:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgzz
    public final void zzh(Object obj, zzgzt zzgztVar, zzgxf zzgxfVar) throws IOException {
        zzgxfVar.getClass();
        zzD(obj);
        zzhal zzhalVar = this.zzm;
        Object objZza = null;
        while (true) {
            try {
                int iZzc = zzgztVar.zzc();
                int iZzq = zzq(iZzc);
                if (iZzq >= 0) {
                    int iZzu = zzu(iZzq);
                    try {
                        switch (zzt(iZzu)) {
                            case 0:
                                zzhas.zzr(obj, iZzu & 1048575, zzgztVar.zza());
                                zzH(obj, iZzq);
                                break;
                            case 1:
                                zzhas.zzs(obj, iZzu & 1048575, zzgztVar.zzb());
                                zzH(obj, iZzq);
                                break;
                            case 2:
                                zzhas.zzu(obj, iZzu & 1048575, zzgztVar.zzl());
                                zzH(obj, iZzq);
                                break;
                            case 3:
                                zzhas.zzu(obj, iZzu & 1048575, zzgztVar.zzo());
                                zzH(obj, iZzq);
                                break;
                            case 4:
                                zzhas.zzt(obj, iZzu & 1048575, zzgztVar.zzg());
                                zzH(obj, iZzq);
                                break;
                            case 5:
                                zzhas.zzu(obj, iZzu & 1048575, zzgztVar.zzk());
                                zzH(obj, iZzq);
                                break;
                            case 6:
                                zzhas.zzt(obj, iZzu & 1048575, zzgztVar.zzf());
                                zzH(obj, iZzq);
                                break;
                            case 7:
                                zzhas.zzp(obj, iZzu & 1048575, zzgztVar.zzN());
                                zzH(obj, iZzq);
                                break;
                            case 8:
                                zzG(obj, iZzu, zzgztVar);
                                zzH(obj, iZzq);
                                break;
                            case 9:
                                zzgzg zzgzgVar = (zzgzg) zzA(obj, iZzq);
                                zzgztVar.zzu(zzgzgVar, zzx(iZzq), zzgxfVar);
                                zzJ(obj, iZzq, zzgzgVar);
                                break;
                            case 10:
                                zzhas.zzv(obj, iZzu & 1048575, zzgztVar.zzp());
                                zzH(obj, iZzq);
                                break;
                            case 11:
                                zzhas.zzt(obj, iZzu & 1048575, zzgztVar.zzj());
                                zzH(obj, iZzq);
                                break;
                            case 12:
                                int iZze = zzgztVar.zze();
                                zzgyb zzgybVarZzw = zzw(iZzq);
                                if (zzgybVarZzw == null || zzgybVarZzw.zza(iZze)) {
                                    zzhas.zzt(obj, iZzu & 1048575, iZze);
                                    zzH(obj, iZzq);
                                } else {
                                    objZza = zzhab.zzo(obj, iZzc, iZze, objZza, zzhalVar);
                                }
                                break;
                            case 13:
                                zzhas.zzt(obj, iZzu & 1048575, zzgztVar.zzh());
                                zzH(obj, iZzq);
                                break;
                            case 14:
                                zzhas.zzu(obj, iZzu & 1048575, zzgztVar.zzm());
                                zzH(obj, iZzq);
                                break;
                            case 15:
                                zzhas.zzt(obj, iZzu & 1048575, zzgztVar.zzi());
                                zzH(obj, iZzq);
                                break;
                            case 16:
                                zzhas.zzu(obj, iZzu & 1048575, zzgztVar.zzn());
                                zzH(obj, iZzq);
                                break;
                            case 17:
                                zzgzg zzgzgVar2 = (zzgzg) zzA(obj, iZzq);
                                zzgztVar.zzt(zzgzgVar2, zzx(iZzq), zzgxfVar);
                                zzJ(obj, iZzq, zzgzgVar2);
                                break;
                            case 18:
                                zzgztVar.zzx(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 19:
                                zzgztVar.zzB(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 20:
                                zzgztVar.zzE(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 21:
                                zzgztVar.zzM(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 22:
                                zzgztVar.zzD(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 23:
                                zzgztVar.zzA(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 24:
                                zzgztVar.zzz(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 25:
                                zzgztVar.zzv(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 26:
                                if (zzM(iZzu)) {
                                    ((zzgwu) zzgztVar).zzK(zzgyt.zza(obj, iZzu & 1048575), true);
                                } else {
                                    ((zzgwu) zzgztVar).zzK(zzgyt.zza(obj, iZzu & 1048575), false);
                                }
                                break;
                            case 27:
                                zzgztVar.zzF(zzgyt.zza(obj, iZzu & 1048575), zzx(iZzq), zzgxfVar);
                                break;
                            case 28:
                                zzgztVar.zzw(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 29:
                                zzgztVar.zzL(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 30:
                                List listZza = zzgyt.zza(obj, iZzu & 1048575);
                                zzgztVar.zzy(listZza);
                                objZza = zzhab.zzn(obj, iZzc, listZza, zzw(iZzq), objZza, zzhalVar);
                                break;
                            case 31:
                                zzgztVar.zzG(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 32:
                                zzgztVar.zzH(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 33:
                                zzgztVar.zzI(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 34:
                                zzgztVar.zzJ(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 35:
                                zzgztVar.zzx(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 36:
                                zzgztVar.zzB(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 37:
                                zzgztVar.zzE(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 38:
                                zzgztVar.zzM(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 39:
                                zzgztVar.zzD(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 40:
                                zzgztVar.zzA(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 41:
                                zzgztVar.zzz(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 42:
                                zzgztVar.zzv(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 43:
                                zzgztVar.zzL(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 44:
                                List listZza2 = zzgyt.zza(obj, iZzu & 1048575);
                                zzgztVar.zzy(listZza2);
                                objZza = zzhab.zzn(obj, iZzc, listZza2, zzw(iZzq), objZza, zzhalVar);
                                break;
                            case 45:
                                zzgztVar.zzG(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 46:
                                zzgztVar.zzH(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 47:
                                zzgztVar.zzI(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 48:
                                zzgztVar.zzJ(zzgyt.zza(obj, iZzu & 1048575));
                                break;
                            case 49:
                                zzgztVar.zzC(zzgyt.zza(obj, iZzu & 1048575), zzx(iZzq), zzgxfVar);
                                break;
                            case 50:
                                Object objZzz = zzz(iZzq);
                                long jZzu = zzu(iZzq) & 1048575;
                                Object objZzh = zzhas.zzh(obj, jZzu);
                                if (objZzh == null) {
                                    objZzh = zzgza.zza().zzb();
                                    zzhas.zzv(obj, jZzu, objZzh);
                                } else if (zzgzb.zza(objZzh)) {
                                    Object objZzb = zzgza.zza().zzb();
                                    zzgzb.zzb(objZzb, objZzh);
                                    zzhas.zzv(obj, jZzu, objZzb);
                                    objZzh = objZzb;
                                }
                                throw null;
                            case 51:
                                zzhas.zzv(obj, iZzu & 1048575, Double.valueOf(zzgztVar.zza()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 52:
                                zzhas.zzv(obj, iZzu & 1048575, Float.valueOf(zzgztVar.zzb()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 53:
                                zzhas.zzv(obj, iZzu & 1048575, Long.valueOf(zzgztVar.zzl()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 54:
                                zzhas.zzv(obj, iZzu & 1048575, Long.valueOf(zzgztVar.zzo()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 55:
                                zzhas.zzv(obj, iZzu & 1048575, Integer.valueOf(zzgztVar.zzg()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 56:
                                zzhas.zzv(obj, iZzu & 1048575, Long.valueOf(zzgztVar.zzk()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 57:
                                zzhas.zzv(obj, iZzu & 1048575, Integer.valueOf(zzgztVar.zzf()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                                zzhas.zzv(obj, iZzu & 1048575, Boolean.valueOf(zzgztVar.zzN()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                                zzG(obj, iZzu, zzgztVar);
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 60:
                                zzgzg zzgzgVar3 = (zzgzg) zzB(obj, iZzc, iZzq);
                                zzgztVar.zzu(zzgzgVar3, zzx(iZzq), zzgxfVar);
                                zzK(obj, iZzc, iZzq, zzgzgVar3);
                                break;
                            case 61:
                                zzhas.zzv(obj, iZzu & 1048575, zzgztVar.zzp());
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 62:
                                zzhas.zzv(obj, iZzu & 1048575, Integer.valueOf(zzgztVar.zzj()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 63:
                                int iZze2 = zzgztVar.zze();
                                zzgyb zzgybVarZzw2 = zzw(iZzq);
                                if (zzgybVarZzw2 == null || zzgybVarZzw2.zza(iZze2)) {
                                    zzhas.zzv(obj, iZzu & 1048575, Integer.valueOf(iZze2));
                                    zzI(obj, iZzc, iZzq);
                                } else {
                                    objZza = zzhab.zzo(obj, iZzc, iZze2, objZza, zzhalVar);
                                }
                                break;
                            case 64:
                                zzhas.zzv(obj, iZzu & 1048575, Integer.valueOf(zzgztVar.zzh()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 65:
                                zzhas.zzv(obj, iZzu & 1048575, Long.valueOf(zzgztVar.zzm()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 66:
                                zzhas.zzv(obj, iZzu & 1048575, Integer.valueOf(zzgztVar.zzi()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 67:
                                zzhas.zzv(obj, iZzu & 1048575, Long.valueOf(zzgztVar.zzn()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                                zzgzg zzgzgVar4 = (zzgzg) zzB(obj, iZzc, iZzq);
                                zzgztVar.zzt(zzgzgVar4, zzx(iZzq), zzgxfVar);
                                zzK(obj, iZzc, iZzq, zzgzgVar4);
                                break;
                            default:
                                if (objZza == null) {
                                    objZza = zzhalVar.zza(obj);
                                }
                                if (!zzhalVar.zzk(objZza, zzgztVar, 0)) {
                                    for (int i = this.zzk; i < this.zzl; i++) {
                                        zzy(obj, this.zzj[i], objZza, zzhalVar, obj);
                                    }
                                }
                                break;
                        }
                    } catch (zzgyj unused) {
                        if (objZza == null) {
                            objZza = zzhalVar.zza(obj);
                        }
                        if (!zzhalVar.zzk(objZza, zzgztVar, 0)) {
                            for (int i2 = this.zzk; i2 < this.zzl; i2++) {
                                zzy(obj, this.zzj[i2], objZza, zzhalVar, obj);
                            }
                            if (objZza != null) {
                                zzhalVar.zzj(obj, objZza);
                            }
                        }
                    }
                } else if (iZzc == Integer.MAX_VALUE) {
                    for (int i3 = this.zzk; i3 < this.zzl; i3++) {
                        zzy(obj, this.zzj[i3], objZza, zzhalVar, obj);
                    }
                } else {
                    if ((!this.zzh ? null : zzgxfVar.zzc(this.zzg, iZzc)) != null) {
                        throw null;
                    }
                    if (objZza == null) {
                        objZza = zzhalVar.zza(obj);
                    }
                    if (!zzhalVar.zzk(objZza, zzgztVar, 0)) {
                        for (int i4 = this.zzk; i4 < this.zzl; i4++) {
                            zzy(obj, this.zzj[i4], objZza, zzhalVar, obj);
                        }
                    }
                }
            } catch (Throwable th) {
                for (int i5 = this.zzk; i5 < this.zzl; i5++) {
                    zzy(obj, this.zzj[i5], objZza, zzhalVar, obj);
                }
                if (objZza != null) {
                    zzhalVar.zzj(obj, objZza);
                }
                throw th;
            }
        }
        if (objZza != null) {
            zzhalVar.zzj(obj, objZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgwb zzgwbVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzgwbVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x0245  */
    /* JADX WARN: Code duplicated, block: B:101:0x0255  */
    /* JADX WARN: Code duplicated, block: B:102:0x0265  */
    /* JADX WARN: Code duplicated, block: B:103:0x0275  */
    /* JADX WARN: Code duplicated, block: B:104:0x0285  */
    /* JADX WARN: Code duplicated, block: B:105:0x0295  */
    /* JADX WARN: Code duplicated, block: B:106:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:107:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:108:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:109:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:110:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:111:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:112:0x0305  */
    /* JADX WARN: Code duplicated, block: B:113:0x0315  */
    /* JADX WARN: Code duplicated, block: B:114:0x0323  */
    /* JADX WARN: Code duplicated, block: B:115:0x0335  */
    /* JADX WARN: Code duplicated, block: B:117:0x034a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0359  */
    /* JADX WARN: Code duplicated, block: B:119:0x0368  */
    /* JADX WARN: Code duplicated, block: B:120:0x0377  */
    /* JADX WARN: Code duplicated, block: B:121:0x0386  */
    /* JADX WARN: Code duplicated, block: B:122:0x0395  */
    /* JADX WARN: Code duplicated, block: B:123:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:124:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:126:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:128:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:129:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:131:0x040f  */
    /* JADX WARN: Code duplicated, block: B:132:0x0418  */
    /* JADX WARN: Code duplicated, block: B:134:0x0433  */
    /* JADX WARN: Code duplicated, block: B:135:0x043c  */
    /* JADX WARN: Code duplicated, block: B:137:0x0457  */
    /* JADX WARN: Code duplicated, block: B:138:0x0460  */
    /* JADX WARN: Code duplicated, block: B:140:0x047b  */
    /* JADX WARN: Code duplicated, block: B:141:0x0484  */
    /* JADX WARN: Code duplicated, block: B:143:0x049f  */
    /* JADX WARN: Code duplicated, block: B:144:0x04a8  */
    /* JADX WARN: Code duplicated, block: B:146:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:147:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:149:0x04e7  */
    /* JADX WARN: Code duplicated, block: B:150:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:152:0x050d  */
    /* JADX WARN: Code duplicated, block: B:153:0x051a  */
    /* JADX WARN: Code duplicated, block: B:155:0x0535  */
    /* JADX WARN: Code duplicated, block: B:156:0x053e  */
    /* JADX WARN: Code duplicated, block: B:158:0x0559  */
    /* JADX WARN: Code duplicated, block: B:159:0x0562  */
    /* JADX WARN: Code duplicated, block: B:161:0x057d  */
    /* JADX WARN: Code duplicated, block: B:162:0x0586  */
    /* JADX WARN: Code duplicated, block: B:164:0x05a1  */
    /* JADX WARN: Code duplicated, block: B:165:0x05aa  */
    /* JADX WARN: Code duplicated, block: B:167:0x05c5  */
    /* JADX WARN: Code duplicated, block: B:168:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:170:0x05e9  */
    /* JADX WARN: Code duplicated, block: B:171:0x05f2  */
    /* JADX WARN: Code duplicated, block: B:173:0x060d  */
    /* JADX WARN: Code duplicated, block: B:174:0x0615  */
    /* JADX WARN: Code duplicated, block: B:176:0x0630  */
    /* JADX WARN: Code duplicated, block: B:177:0x0638  */
    /* JADX WARN: Code duplicated, block: B:179:0x0653  */
    /* JADX WARN: Code duplicated, block: B:190:0x01b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:200:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:206:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:208:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:210:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:212:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:214:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:220:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:222:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:224:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:226:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:228:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0094  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:53:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:54:0x0106  */
    /* JADX WARN: Code duplicated, block: B:56:0x010c  */
    /* JADX WARN: Code duplicated, block: B:57:0x0117  */
    /* JADX WARN: Code duplicated, block: B:59:0x011d  */
    /* JADX WARN: Code duplicated, block: B:60:0x012a  */
    /* JADX WARN: Code duplicated, block: B:62:0x0130  */
    /* JADX WARN: Code duplicated, block: B:63:0x0139  */
    /* JADX WARN: Code duplicated, block: B:65:0x013f  */
    /* JADX WARN: Code duplicated, block: B:66:0x0148  */
    /* JADX WARN: Code duplicated, block: B:68:0x014e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0157  */
    /* JADX WARN: Code duplicated, block: B:71:0x015d  */
    /* JADX WARN: Code duplicated, block: B:72:0x0166  */
    /* JADX WARN: Code duplicated, block: B:74:0x016c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0175  */
    /* JADX WARN: Code duplicated, block: B:77:0x017b  */
    /* JADX WARN: Code duplicated, block: B:78:0x0184  */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    /* JADX WARN: Code duplicated, block: B:80:0x018a  */
    /* JADX WARN: Code duplicated, block: B:81:0x0193  */
    /* JADX WARN: Code duplicated, block: B:83:0x0199  */
    /* JADX WARN: Code duplicated, block: B:84:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:87:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:92:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:93:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:94:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:95:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:96:0x0205  */
    /* JADX WARN: Code duplicated, block: B:97:0x0215  */
    /* JADX WARN: Code duplicated, block: B:98:0x0225  */
    /* JADX WARN: Code duplicated, block: B:99:0x0235  */
    @Override // com.google.android.gms.internal.ads.zzgzz
    public final void zzj(Object obj, zzhba zzhbaVar) throws IOException {
        Map.Entry entry;
        Iterator it;
        int i;
        int i2;
        int i3;
        long j;
        boolean z;
        if (this.zzh) {
            zzgxk zzgxkVar = ((zzgxr) obj).zza;
            if (zzgxkVar.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzf = zzgxkVar.zzf();
                entry = (Map.Entry) itZzf.next();
                it = itZzf;
            }
        } else {
            entry = null;
            it = null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < iArr.length) {
            int iZzu = zzu(i7);
            int iZzt = zzt(iZzu);
            int i8 = iArr[i7];
            if (iZzt <= 17) {
                int i9 = iArr[i7 + 2];
                int i10 = i9 & i4;
                if (i10 != i5) {
                    i6 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                } else {
                    i9 = i9;
                }
                i2 = i6;
                i3 = 1 << (i9 >>> 20);
                i = i5;
            } else {
                i = i5;
                i2 = i6;
                i3 = 0;
            }
            while (entry != null) {
                zzgxg zzgxgVar = this.zzn;
                if (((zzgxs) entry.getKey()).zza > i8) {
                    j = iZzu & 1048575;
                    switch (iZzt) {
                        case 0:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzf(i8, zzhas.zzb(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 1:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzo(i8, zzhas.zzc(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 2:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzt(i8, unsafe.getLong(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 3:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzK(i8, unsafe.getLong(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 4:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzr(i8, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 5:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzm(i8, unsafe.getLong(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 6:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzk(i8, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 7:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzb(i8, zzhas.zzz(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 8:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzT(i8, unsafe.getObject(obj, j), zzhbaVar);
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 9:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 10:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzd(i8, (zzgwn) unsafe.getObject(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 11:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzI(i8, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 12:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzi(i8, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 13:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzx(i8, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 14:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzz(i8, unsafe.getLong(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 15:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzB(i8, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 16:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzD(i8, unsafe.getLong(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 17:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhbaVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 18:
                            z = false;
                            zzhab.zzt(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 19:
                            z = false;
                            zzhab.zzx(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 20:
                            z = false;
                            zzhab.zzA(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 21:
                            z = false;
                            zzhab.zzI(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 22:
                            z = false;
                            zzhab.zzz(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 23:
                            z = false;
                            zzhab.zzw(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 24:
                            z = false;
                            zzhab.zzv(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 25:
                            z = false;
                            zzhab.zzr(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 26:
                            zzhab.zzG(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 27:
                            zzhab.zzB(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, zzx(i7));
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 28:
                            zzhab.zzs(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 29:
                            z = false;
                            zzhab.zzH(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 30:
                            z = false;
                            zzhab.zzu(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 31:
                            z = false;
                            zzhab.zzC(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 32:
                            z = false;
                            zzhab.zzD(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 33:
                            z = false;
                            zzhab.zzE(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 34:
                            z = false;
                            zzhab.zzF(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 35:
                            zzhab.zzt(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 36:
                            zzhab.zzx(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 37:
                            zzhab.zzA(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 38:
                            zzhab.zzI(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 39:
                            zzhab.zzz(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 40:
                            zzhab.zzw(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 41:
                            zzhab.zzv(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 42:
                            zzhab.zzr(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 43:
                            zzhab.zzH(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 44:
                            zzhab.zzu(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 45:
                            zzhab.zzC(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 46:
                            zzhab.zzD(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 47:
                            zzhab.zzE(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 48:
                            zzhab.zzF(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 49:
                            zzhab.zzy(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, zzx(i7));
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 50:
                            if (unsafe.getObject(obj, j) != null) {
                                throw null;
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 51:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzf(i8, zzn(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 52:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzo(i8, zzo(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 53:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzt(i8, zzv(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 54:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzK(i8, zzv(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 55:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzr(i8, zzp(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 56:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzm(i8, zzv(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 57:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzk(i8, zzp(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzb(i8, zzS(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                            if (zzR(obj, i8, i7)) {
                                zzT(i8, unsafe.getObject(obj, j), zzhbaVar);
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 60:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 61:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzd(i8, (zzgwn) unsafe.getObject(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 62:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzI(i8, zzp(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 63:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzi(i8, zzp(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 64:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzx(i8, zzp(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 65:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzz(i8, zzv(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 66:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzB(i8, zzp(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 67:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzD(i8, zzv(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                            if (zzR(obj, i8, i7)) {
                                zzhbaVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        default:
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                    }
                } else {
                    zzgxgVar.zzb(zzhbaVar, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
            }
            j = iZzu & 1048575;
            switch (iZzt) {
                case 0:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzf(i8, zzhas.zzb(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 1:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzo(i8, zzhas.zzc(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 2:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzt(i8, unsafe.getLong(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 3:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzK(i8, unsafe.getLong(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 4:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzr(i8, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 5:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzm(i8, unsafe.getLong(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 6:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzk(i8, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 7:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzb(i8, zzhas.zzz(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 8:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzT(i8, unsafe.getObject(obj, j), zzhbaVar);
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 9:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 10:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzd(i8, (zzgwn) unsafe.getObject(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 11:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzI(i8, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 12:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzi(i8, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 13:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzx(i8, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 14:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzz(i8, unsafe.getLong(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 15:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzB(i8, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 16:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzD(i8, unsafe.getLong(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 17:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhbaVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 18:
                    z = false;
                    zzhab.zzt(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 19:
                    z = false;
                    zzhab.zzx(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 20:
                    z = false;
                    zzhab.zzA(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 21:
                    z = false;
                    zzhab.zzI(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 22:
                    z = false;
                    zzhab.zzz(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 23:
                    z = false;
                    zzhab.zzw(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 24:
                    z = false;
                    zzhab.zzv(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 25:
                    z = false;
                    zzhab.zzr(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 26:
                    zzhab.zzG(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 27:
                    zzhab.zzB(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, zzx(i7));
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 28:
                    zzhab.zzs(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 29:
                    z = false;
                    zzhab.zzH(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 30:
                    z = false;
                    zzhab.zzu(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 31:
                    z = false;
                    zzhab.zzC(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 32:
                    z = false;
                    zzhab.zzD(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 33:
                    z = false;
                    zzhab.zzE(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 34:
                    z = false;
                    zzhab.zzF(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 35:
                    zzhab.zzt(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 36:
                    zzhab.zzx(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 37:
                    zzhab.zzA(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 38:
                    zzhab.zzI(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 39:
                    zzhab.zzz(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 40:
                    zzhab.zzw(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 41:
                    zzhab.zzv(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 42:
                    zzhab.zzr(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 43:
                    zzhab.zzH(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 44:
                    zzhab.zzu(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 45:
                    zzhab.zzC(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 46:
                    zzhab.zzD(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 47:
                    zzhab.zzE(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 48:
                    zzhab.zzF(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 49:
                    zzhab.zzy(iArr[i7], (List) unsafe.getObject(obj, j), zzhbaVar, zzx(i7));
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 51:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzf(i8, zzn(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 52:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzo(i8, zzo(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 53:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzt(i8, zzv(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 54:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzK(i8, zzv(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 55:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzr(i8, zzp(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 56:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzm(i8, zzv(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 57:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzk(i8, zzp(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzb(i8, zzS(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    if (zzR(obj, i8, i7)) {
                        zzT(i8, unsafe.getObject(obj, j), zzhbaVar);
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 60:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 61:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzd(i8, (zzgwn) unsafe.getObject(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 62:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzI(i8, zzp(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 63:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzi(i8, zzp(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 64:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzx(i8, zzp(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 65:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzz(i8, zzv(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 66:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzB(i8, zzp(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 67:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzD(i8, zzv(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    if (zzR(obj, i8, i7)) {
                        zzhbaVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                default:
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
            }
        }
        Iterator it2 = it;
        while (entry != null) {
            this.zzn.zzb(zzhbaVar, entry);
            entry = it2.hasNext() ? (Map.Entry) it2.next() : null;
        }
        ((zzgxv) obj).zzt.zzl(zzhbaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final boolean zzk(Object obj, Object obj2) {
        boolean zZzJ;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzu = zzu(i);
            long j = iZzu & 1048575;
            switch (zzt(iZzu)) {
                case 0:
                    if (!zzL(obj, obj2, i) || Double.doubleToLongBits(zzhas.zzb(obj, j)) != Double.doubleToLongBits(zzhas.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i) || Float.floatToIntBits(zzhas.zzc(obj, j)) != Float.floatToIntBits(zzhas.zzc(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i) || zzhas.zzf(obj, j) != zzhas.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i) || zzhas.zzf(obj, j) != zzhas.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i) || zzhas.zzd(obj, j) != zzhas.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i) || zzhas.zzf(obj, j) != zzhas.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i) || zzhas.zzd(obj, j) != zzhas.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i) || zzhas.zzz(obj, j) != zzhas.zzz(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i) || !zzhab.zzJ(zzhas.zzh(obj, j), zzhas.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i) || !zzhab.zzJ(zzhas.zzh(obj, j), zzhas.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i) || !zzhab.zzJ(zzhas.zzh(obj, j), zzhas.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i) || zzhas.zzd(obj, j) != zzhas.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i) || zzhas.zzd(obj, j) != zzhas.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i) || zzhas.zzd(obj, j) != zzhas.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i) || zzhas.zzf(obj, j) != zzhas.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i) || zzhas.zzd(obj, j) != zzhas.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i) || zzhas.zzf(obj, j) != zzhas.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i) || !zzhab.zzJ(zzhas.zzh(obj, j), zzhas.zzh(obj2, j))) {
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
                    zZzJ = zzhab.zzJ(zzhas.zzh(obj, j), zzhas.zzh(obj2, j));
                    break;
                case 50:
                    zZzJ = zzhab.zzJ(zzhas.zzh(obj, j), zzhas.zzh(obj2, j));
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
                    long jZzr = zzr(i) & 1048575;
                    if (zzhas.zzd(obj, jZzr) != zzhas.zzd(obj2, jZzr) || !zzhab.zzJ(zzhas.zzh(obj, j), zzhas.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzJ) {
                return false;
            }
        }
        if (!((zzgxv) obj).zzt.equals(((zzgxv) obj2).zzt)) {
            return false;
        }
        if (this.zzh) {
            return ((zzgxr) obj).zza.equals(((zzgxr) obj2).zza);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0099  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:50:0x00be A[LOOP:1: B:45:0x00ad->B:50:0x00be, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00db A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgzz
    public final boolean zzl(Object obj) {
        int i;
        int i2;
        List list;
        zzgzz zzgzzVarZzx;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int iZzu = zzu(i7);
            int i9 = iArr2[i7 + 2];
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
            if ((268435456 & iZzu) != 0 && !zzO(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzt = zzt(iZzu);
            if (iZzt == 9 || iZzt == 17) {
                if (zzO(obj, i7, i, i2, i11) && !zzP(obj, iZzu, zzx(i7))) {
                    return false;
                }
            } else if (iZzt == 27) {
                list = (List) zzhas.zzh(obj, iZzu & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgzzVarZzx = zzx(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzgzzVarZzx.zzl(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzt == 60 || iZzt == 68) {
                if (zzR(obj, i8, i7) && !zzP(obj, iZzu, zzx(i7))) {
                    return false;
                }
            } else if (iZzt == 49) {
                list = (List) zzhas.zzh(obj, iZzu & 1048575);
                if (list.isEmpty()) {
                    zzgzzVarZzx = zzx(i7);
                    while (i3 < list.size()) {
                        if (!zzgzzVarZzx.zzl(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzt == 50 && !((zzgza) zzhas.zzh(obj, iZzu & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        return !this.zzh || ((zzgxr) obj).zza.zzi();
    }
}
