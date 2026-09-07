package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.AccessController;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes7.dex */
public final class J0 implements U0 {
    public static final int[] q = new int[0];
    public static final Unsafe r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f2259a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final E0 e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int[] i;
    public final int j;
    public final int k;
    public final L0 l;
    public final AbstractC3226u0 m;
    public final C3215p1 n;
    public final J o;
    public final A0 p;

    static {
        Unsafe unsafe;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new t1());
        } catch (Throwable unused) {
            unsafe = null;
        }
        r = unsafe;
    }

    public J0(int[] iArr, Object[] objArr, int i, int i2, E0 e0, boolean z, int[] iArr2, int i3, int i4, L0 l0, AbstractC3226u0 abstractC3226u0, C3215p1 c3215p1, J j, A0 a0) {
        this.f2259a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.g = e0 instanceof AbstractC3169a0;
        this.h = z;
        this.f = j != null && (e0 instanceof GeneratedMessageLite$ExtendableMessage);
        this.i = iArr2;
        this.j = i3;
        this.k = i4;
        this.l = l0;
        this.m = abstractC3226u0;
        this.n = c3215p1;
        this.o = j;
        this.e = e0;
        this.p = a0;
    }

    /* JADX WARN: Code duplicated, block: B:128:0x026e  */
    /* JADX WARN: Code duplicated, block: B:129:0x0271  */
    /* JADX WARN: Code duplicated, block: B:132:0x0289  */
    /* JADX WARN: Code duplicated, block: B:133:0x028c  */
    public static J0 a(S0 s0, L0 l0, AbstractC3226u0 abstractC3226u0, C3215p1 c3215p1, J j, A0 a0) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int iCharAt3;
        int i3;
        int i4;
        int[] iArr;
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
        int i17;
        int i18;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i19;
        int i20;
        Field fieldA;
        char cCharAt9;
        int i21;
        int i22;
        int i23;
        Object obj;
        Field fieldA2;
        int i24;
        Object obj2;
        Field fieldA3;
        int i25;
        char cCharAt10;
        int i26;
        char cCharAt11;
        int i27;
        char cCharAt12;
        int i28;
        char cCharAt13;
        if (!(s0 instanceof S0)) {
            s0.getClass();
            throw new ClassCastException();
        }
        int i29 = 0;
        boolean z = ((s0.d & 1) == 1 ? P0.PROTO2 : P0.PROTO3) == P0.PROTO3;
        String str = s0.b;
        int length = str.length();
        if (str.charAt(0) >= 55296) {
            int i30 = 1;
            while (true) {
                i = i30 + 1;
                if (str.charAt(i30) < 55296) {
                    break;
                }
                i30 = i;
            }
        } else {
            i = 1;
        }
        int i31 = i + 1;
        int iCharAt4 = str.charAt(i);
        if (iCharAt4 >= 55296) {
            int i32 = iCharAt4 & 8191;
            int i33 = 13;
            while (true) {
                i28 = i31 + 1;
                cCharAt13 = str.charAt(i31);
                if (cCharAt13 < 55296) {
                    break;
                }
                i32 |= (cCharAt13 & 8191) << i33;
                i33 += 13;
                i31 = i28;
            }
            iCharAt4 = i32 | (cCharAt13 << i33);
            i31 = i28;
        }
        if (iCharAt4 == 0) {
            i5 = 0;
            iCharAt2 = 0;
            i3 = 0;
            iCharAt3 = 0;
            i2 = i31;
            iArr = q;
            iCharAt = 0;
            i4 = 0;
        } else {
            int i34 = i31 + 1;
            iCharAt = str.charAt(i31);
            if (iCharAt >= 55296) {
                int i35 = iCharAt & 8191;
                int i36 = 13;
                while (true) {
                    i13 = i34 + 1;
                    cCharAt8 = str.charAt(i34);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i35 |= (cCharAt8 & 8191) << i36;
                    i36 += 13;
                    i34 = i13;
                }
                iCharAt = i35 | (cCharAt8 << i36);
                i34 = i13;
            }
            int i37 = i34 + 1;
            int iCharAt5 = str.charAt(i34);
            if (iCharAt5 >= 55296) {
                int i38 = iCharAt5 & 8191;
                int i39 = 13;
                while (true) {
                    i12 = i37 + 1;
                    cCharAt7 = str.charAt(i37);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt7 & 8191) << i39;
                    i39 += 13;
                    i37 = i12;
                }
                iCharAt5 = i38 | (cCharAt7 << i39);
                i37 = i12;
            }
            int i40 = i37 + 1;
            int iCharAt6 = str.charAt(i37);
            if (iCharAt6 >= 55296) {
                int i41 = iCharAt6 & 8191;
                int i42 = 13;
                while (true) {
                    i11 = i40 + 1;
                    cCharAt6 = str.charAt(i40);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt6 & 8191) << i42;
                    i42 += 13;
                    i40 = i11;
                }
                iCharAt6 = i41 | (cCharAt6 << i42);
                i40 = i11;
            }
            int i43 = i40 + 1;
            int iCharAt7 = str.charAt(i40);
            if (iCharAt7 >= 55296) {
                int i44 = iCharAt7 & 8191;
                int i45 = 13;
                while (true) {
                    i10 = i43 + 1;
                    cCharAt5 = str.charAt(i43);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt5 & 8191) << i45;
                    i45 += 13;
                    i43 = i10;
                }
                iCharAt7 = i44 | (cCharAt5 << i45);
                i43 = i10;
            }
            int i46 = i43 + 1;
            iCharAt2 = str.charAt(i43);
            if (iCharAt2 >= 55296) {
                int i47 = iCharAt2 & 8191;
                int i48 = 13;
                while (true) {
                    i9 = i46 + 1;
                    cCharAt4 = str.charAt(i46);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt4 & 8191) << i48;
                    i48 += 13;
                    i46 = i9;
                }
                iCharAt2 = i47 | (cCharAt4 << i48);
                i46 = i9;
            }
            int i49 = i46 + 1;
            int iCharAt8 = str.charAt(i46);
            if (iCharAt8 >= 55296) {
                int i50 = iCharAt8 & 8191;
                int i51 = 13;
                while (true) {
                    i8 = i49 + 1;
                    cCharAt3 = str.charAt(i49);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt3 & 8191) << i51;
                    i51 += 13;
                    i49 = i8;
                }
                iCharAt8 = i50 | (cCharAt3 << i51);
                i49 = i8;
            }
            int i52 = i49 + 1;
            int iCharAt9 = str.charAt(i49);
            if (iCharAt9 >= 55296) {
                int i53 = iCharAt9 & 8191;
                int i54 = 13;
                while (true) {
                    i7 = i52 + 1;
                    cCharAt2 = str.charAt(i52);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt2 & 8191) << i54;
                    i54 += 13;
                    i52 = i7;
                }
                iCharAt9 = i53 | (cCharAt2 << i54);
                i52 = i7;
            }
            i2 = i52 + 1;
            iCharAt3 = str.charAt(i52);
            if (iCharAt3 >= 55296) {
                int i55 = iCharAt3 & 8191;
                int i56 = i2;
                int i57 = 13;
                while (true) {
                    i6 = i56 + 1;
                    cCharAt = str.charAt(i56);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i55 |= (cCharAt & 8191) << i57;
                    i57 += 13;
                    i56 = i6;
                }
                iCharAt3 = i55 | (cCharAt << i57);
                i2 = i6;
            }
            int[] iArr2 = new int[iCharAt3 + iCharAt8 + iCharAt9];
            i3 = (iCharAt * 2) + iCharAt5;
            i4 = iCharAt8;
            iArr = iArr2;
            i29 = iCharAt6;
            i5 = iCharAt7;
        }
        Unsafe unsafe = r;
        Object[] objArr = s0.c;
        Class<?> cls = s0.f2268a.getClass();
        int[] iArr3 = new int[iCharAt2 * 3];
        Object[] objArr2 = new Object[iCharAt2 * 2];
        int i58 = iCharAt3 + i4;
        int i59 = iCharAt3;
        int i60 = i2;
        int i61 = i58;
        int i62 = 0;
        int i63 = 0;
        while (i60 < length) {
            int i64 = i60 + 1;
            int iCharAt10 = str.charAt(i60);
            int i65 = length;
            if (iCharAt10 >= 55296) {
                int i66 = iCharAt10 & 8191;
                int i67 = i64;
                int i68 = 13;
                while (true) {
                    i27 = i67 + 1;
                    cCharAt12 = str.charAt(i67);
                    i14 = iCharAt3;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i66 |= (cCharAt12 & 8191) << i68;
                    i68 += 13;
                    i67 = i27;
                    iCharAt3 = i14;
                }
                iCharAt10 = i66 | (cCharAt12 << i68);
                i15 = i27;
            } else {
                i14 = iCharAt3;
                i15 = i64;
            }
            int i69 = i15 + 1;
            int iCharAt11 = str.charAt(i15);
            if (iCharAt11 >= 55296) {
                int i70 = iCharAt11 & 8191;
                int i71 = i69;
                int i72 = 13;
                while (true) {
                    i26 = i71 + 1;
                    cCharAt11 = str.charAt(i71);
                    i16 = i5;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i70 |= (cCharAt11 & 8191) << i72;
                    i72 += 13;
                    i71 = i26;
                    i5 = i16;
                }
                iCharAt11 = i70 | (cCharAt11 << i72);
                i17 = i26;
            } else {
                i16 = i5;
                i17 = i69;
            }
            int i73 = iCharAt11 & 255;
            int i74 = i29;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i62] = i63;
                i62++;
            }
            if (i73 >= 51) {
                int i75 = i17 + 1;
                int iCharAt12 = str.charAt(i17);
                char c = 55296;
                if (iCharAt12 >= 55296) {
                    int i76 = iCharAt12 & 8191;
                    int i77 = 13;
                    while (true) {
                        i25 = i75 + 1;
                        cCharAt10 = str.charAt(i75);
                        if (cCharAt10 < c) {
                            break;
                        }
                        i76 |= (cCharAt10 & 8191) << i77;
                        i77 += 13;
                        i75 = i25;
                        c = 55296;
                    }
                    iCharAt12 = i76 | (cCharAt10 << i77);
                    i75 = i25;
                }
                int i78 = i73 - 51;
                int i79 = i75;
                if (i78 == 9 || i78 == 17) {
                    i22 = i3 + 1;
                    objArr2[((i63 / 3) * 2) + 1] = objArr[i3];
                } else {
                    if (i78 == 12 && !z) {
                        i22 = i3 + 1;
                        objArr2[((i63 / 3) * 2) + 1] = objArr[i3];
                    }
                    i23 = iCharAt12 * 2;
                    obj = objArr[i23];
                    if (obj instanceof Field) {
                        fieldA2 = (Field) obj;
                    } else {
                        fieldA2 = a((Class) cls, (String) obj);
                        objArr[i23] = fieldA2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldA2);
                    i24 = i23 + 1;
                    obj2 = objArr[i24];
                    if (obj2 instanceof Field) {
                        fieldA3 = (Field) obj2;
                    } else {
                        fieldA3 = a((Class) cls, (String) obj2);
                        objArr[i24] = fieldA3;
                    }
                    str = str;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldA3);
                    i18 = i3;
                    i60 = i79;
                    i19 = 0;
                    iObjectFieldOffset = iObjectFieldOffset3;
                }
                i3 = i22;
                i23 = iCharAt12 * 2;
                obj = objArr[i23];
                if (obj instanceof Field) {
                    fieldA2 = (Field) obj;
                } else {
                    fieldA2 = a((Class) cls, (String) obj);
                    objArr[i23] = fieldA2;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldA2);
                i24 = i23 + 1;
                obj2 = objArr[i24];
                if (obj2 instanceof Field) {
                    fieldA3 = (Field) obj2;
                } else {
                    fieldA3 = a((Class) cls, (String) obj2);
                    objArr[i24] = fieldA3;
                }
                str = str;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldA3);
                i18 = i3;
                i60 = i79;
                i19 = 0;
                iObjectFieldOffset = iObjectFieldOffset4;
            } else {
                i18 = i3 + 1;
                Field fieldA4 = a((Class) cls, (String) objArr[i3]);
                if (i73 == 9 || i73 == 17) {
                    objArr2[((i63 / 3) * 2) + 1] = fieldA4.getType();
                } else {
                    if (i73 == 27 || i73 == 49) {
                        i21 = i3 + 2;
                        objArr2[((i63 / 3) * 2) + 1] = objArr[i18];
                    } else if (i73 == 12 || i73 == 30 || i73 == 44) {
                        if (!z) {
                            i21 = i3 + 2;
                            objArr2[((i63 / 3) * 2) + 1] = objArr[i18];
                        }
                    } else if (i73 == 50) {
                        int i80 = i59 + 1;
                        iArr[i59] = i63;
                        int i81 = (i63 / 3) * 2;
                        int i82 = i3 + 2;
                        objArr2[i81] = objArr[i18];
                        if ((iCharAt11 & 2048) != 0) {
                            i18 = i3 + 3;
                            objArr2[i81 + 1] = objArr[i82];
                            i59 = i80;
                        } else {
                            i59 = i80;
                            i18 = i82;
                        }
                    }
                    i18 = i21;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldA4);
                if ((iCharAt11 & 4096) != 4096 || i73 > 17) {
                    iObjectFieldOffset2 = 1048575;
                    i19 = 0;
                } else {
                    int i83 = i17 + 1;
                    int iCharAt13 = str.charAt(i17);
                    if (iCharAt13 >= 55296) {
                        int i84 = iCharAt13 & 8191;
                        int i85 = 13;
                        while (true) {
                            i20 = i83 + 1;
                            cCharAt9 = str.charAt(i83);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i84 |= (cCharAt9 & 8191) << i85;
                            i85 += 13;
                            i83 = i20;
                        }
                        iCharAt13 = i84 | (cCharAt9 << i85);
                    } else {
                        i20 = i83;
                    }
                    int i86 = (iCharAt13 / 32) + (iCharAt * 2);
                    Object obj3 = objArr[i86];
                    if (obj3 instanceof Field) {
                        fieldA = (Field) obj3;
                    } else {
                        fieldA = a((Class) cls, (String) obj3);
                        objArr[i86] = fieldA;
                    }
                    i19 = iCharAt13 % 32;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldA);
                    i17 = i20;
                }
                if (i73 >= 18 && i73 <= 49) {
                    iArr[i61] = iObjectFieldOffset;
                    i61++;
                }
                i60 = i17;
            }
            int i87 = i63 + 1;
            iArr3[i63] = iCharAt10;
            int i88 = i63 + 2;
            iArr3[i87] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i73 << 20) | iObjectFieldOffset;
            i63 += 3;
            iArr3[i88] = (i19 << 20) | iObjectFieldOffset2;
            iArr3 = iArr3;
            str = str;
            i29 = i74;
            length = i65;
            iCharAt3 = i14;
            i5 = i16;
            i3 = i18;
        }
        return new J0(iArr3, objArr2, i29, i5, s0.f2268a, z, iArr, iCharAt3, i58, l0, abstractC3226u0, c3215p1, j, a0);
    }

    public static long d(int i) {
        return i & 1048575;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x01cb  */
    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final boolean b(Object obj, Object obj2) {
        int length = this.f2259a.length;
        int i = 0;
        while (true) {
            boolean zA = true;
            if (i >= length) {
                this.n.getClass();
                C3212o1 c3212o1 = ((AbstractC3169a0) obj).unknownFields;
                this.n.getClass();
                if (!c3212o1.equals(((AbstractC3169a0) obj2).unknownFields)) {
                    return false;
                }
                if (!this.f) {
                    return true;
                }
                this.o.getClass();
                N n = ((GeneratedMessageLite$ExtendableMessage) obj).extensions;
                this.o.getClass();
                return n.equals(((GeneratedMessageLite$ExtendableMessage) obj2).extensions);
            }
            int[] iArr = this.f2259a;
            int i2 = iArr[i + 1];
            long j = i2 & 1048575;
            switch ((i2 & 267386880) >>> 20) {
                case 0:
                    if (!a(i, obj, obj2)) {
                        zA = false;
                    } else {
                        x1 x1Var = y1.c;
                        if (Double.doubleToLongBits(x1Var.c(obj, j)) != Double.doubleToLongBits(x1Var.c(obj2, j))) {
                            zA = false;
                        }
                    }
                    break;
                case 1:
                    if (!a(i, obj, obj2)) {
                        zA = false;
                    } else {
                        x1 x1Var2 = y1.c;
                        if (Float.floatToIntBits(x1Var2.d(obj, j)) != Float.floatToIntBits(x1Var2.d(obj2, j))) {
                            zA = false;
                        }
                    }
                    break;
                case 2:
                    if (!a(i, obj, obj2) || y1.d(obj, j) != y1.d(obj2, j)) {
                        zA = false;
                    }
                    break;
                case 3:
                    if (!a(i, obj, obj2) || y1.d(obj, j) != y1.d(obj2, j)) {
                        zA = false;
                    }
                    break;
                case 4:
                    if (!a(i, obj, obj2) || y1.c(obj, j) != y1.c(obj2, j)) {
                        zA = false;
                    }
                    break;
                case 5:
                    if (!a(i, obj, obj2) || y1.d(obj, j) != y1.d(obj2, j)) {
                        zA = false;
                    }
                    break;
                case 6:
                    if (!a(i, obj, obj2) || y1.c(obj, j) != y1.c(obj2, j)) {
                        zA = false;
                    }
                    break;
                case 7:
                    if (!a(i, obj, obj2)) {
                        zA = false;
                    } else {
                        x1 x1Var3 = y1.c;
                        if (x1Var3.a(obj, j) != x1Var3.a(obj2, j)) {
                            zA = false;
                        }
                    }
                    break;
                case 8:
                    if (!a(i, obj, obj2) || !V0.a(y1.e(obj, j), y1.e(obj2, j))) {
                        zA = false;
                    }
                    break;
                case 9:
                    if (!a(i, obj, obj2) || !V0.a(y1.e(obj, j), y1.e(obj2, j))) {
                        zA = false;
                    }
                    break;
                case 10:
                    if (!a(i, obj, obj2) || !V0.a(y1.e(obj, j), y1.e(obj2, j))) {
                        zA = false;
                    }
                    break;
                case 11:
                    if (!a(i, obj, obj2) || y1.c(obj, j) != y1.c(obj2, j)) {
                        zA = false;
                    }
                    break;
                case 12:
                    if (!a(i, obj, obj2) || y1.c(obj, j) != y1.c(obj2, j)) {
                        zA = false;
                    }
                    break;
                case 13:
                    if (!a(i, obj, obj2) || y1.c(obj, j) != y1.c(obj2, j)) {
                        zA = false;
                    }
                    break;
                case 14:
                    if (!a(i, obj, obj2) || y1.d(obj, j) != y1.d(obj2, j)) {
                        zA = false;
                    }
                    break;
                case 15:
                    if (!a(i, obj, obj2) || y1.c(obj, j) != y1.c(obj2, j)) {
                        zA = false;
                    }
                    break;
                case 16:
                    if (!a(i, obj, obj2) || y1.d(obj, j) != y1.d(obj2, j)) {
                        zA = false;
                    }
                    break;
                case 17:
                    if (!a(i, obj, obj2) || !V0.a(y1.e(obj, j), y1.e(obj2, j))) {
                        zA = false;
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
                    zA = V0.a(y1.e(obj, j), y1.e(obj2, j));
                    break;
                case 50:
                    zA = V0.a(y1.e(obj, j), y1.e(obj2, j));
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
                    long j2 = iArr[i + 2] & 1048575;
                    if (y1.c(obj, j2) != y1.c(obj2, j2) || !V0.a(y1.e(obj, j), y1.e(obj2, j))) {
                        zA = false;
                    }
                    break;
            }
            if (!zA) {
                return false;
            }
            i += 3;
        }
    }

    public final U0 c(int i) {
        int i2 = (i / 3) * 2;
        Object[] objArr = this.b;
        U0 u0 = (U0) objArr[i2];
        if (u0 != null) {
            return u0;
        }
        U0 u0A = Q0.c.a((Class) objArr[i2 + 1]);
        this.b[i2] = u0A;
        return u0A;
    }

    public final void e(int i, Object obj, Object obj2) {
        int[] iArr = this.f2259a;
        int i2 = iArr[i + 1];
        int i3 = iArr[i];
        long j = i2 & 1048575;
        if (a(obj2, i3, i)) {
            Object objE = a(obj, i3, i) ? y1.e(obj, j) : null;
            Object objE2 = y1.e(obj2, j);
            if (objE != null && objE2 != null) {
                y1.a(j, obj, AbstractC3205m0.a(objE, objE2));
                b(obj, i3, i);
            } else if (objE2 != null) {
                y1.a(j, obj, objE2);
                b(obj, i3, i);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:83:0x0228 A[PHI: r2
  0x0228: PHI (r2v30 int) = (r2v10 int), (r2v31 int) binds: [B:81:0x0225, B:40:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final int d(Object obj) {
        int i;
        long jDoubleToLongBits;
        int i2;
        int iFloatToIntBits;
        int i3;
        int i4;
        int length = this.f2259a.length;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6 += 3) {
            int[] iArr = this.f2259a;
            int i7 = iArr[i6 + 1];
            int i8 = iArr[i6];
            long j = 1048575 & i7;
            int i9 = 1231;
            int iHashCode = 37;
            switch ((i7 & 267386880) >>> 20) {
                case 0:
                    i = i5 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(y1.c.c(obj, j));
                    Charset charset = AbstractC3205m0.f2291a;
                    i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    i5 = i4;
                    break;
                case 1:
                    i2 = i5 * 53;
                    iFloatToIntBits = Float.floatToIntBits(y1.c.d(obj, j));
                    i4 = iFloatToIntBits + i2;
                    i5 = i4;
                    break;
                case 2:
                    i = i5 * 53;
                    jDoubleToLongBits = y1.d(obj, j);
                    Charset charset2 = AbstractC3205m0.f2291a;
                    i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    i5 = i4;
                    break;
                case 3:
                    i = i5 * 53;
                    jDoubleToLongBits = y1.d(obj, j);
                    Charset charset3 = AbstractC3205m0.f2291a;
                    i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    i5 = i4;
                    break;
                case 4:
                    i2 = i5 * 53;
                    iFloatToIntBits = y1.c(obj, j);
                    i4 = iFloatToIntBits + i2;
                    i5 = i4;
                    break;
                case 5:
                    i = i5 * 53;
                    jDoubleToLongBits = y1.d(obj, j);
                    Charset charset4 = AbstractC3205m0.f2291a;
                    i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    i5 = i4;
                    break;
                case 6:
                    i2 = i5 * 53;
                    iFloatToIntBits = y1.c(obj, j);
                    i4 = iFloatToIntBits + i2;
                    i5 = i4;
                    break;
                case 7:
                    i3 = i5 * 53;
                    boolean zA = y1.c.a(obj, j);
                    Charset charset5 = AbstractC3205m0.f2291a;
                    if (!zA) {
                        i9 = 1237;
                    }
                    i4 = i9 + i3;
                    i5 = i4;
                    break;
                case 8:
                    i2 = i5 * 53;
                    iFloatToIntBits = ((String) y1.e(obj, j)).hashCode();
                    i4 = iFloatToIntBits + i2;
                    i5 = i4;
                    break;
                case 9:
                    Object objE = y1.e(obj, j);
                    if (objE != null) {
                        iHashCode = objE.hashCode();
                    }
                    iFloatToIntBits = i5 * 53;
                    i2 = iHashCode;
                    i4 = iFloatToIntBits + i2;
                    i5 = i4;
                    break;
                case 10:
                    i2 = i5 * 53;
                    iFloatToIntBits = y1.e(obj, j).hashCode();
                    i4 = iFloatToIntBits + i2;
                    i5 = i4;
                    break;
                case 11:
                    i2 = i5 * 53;
                    iFloatToIntBits = y1.c(obj, j);
                    i4 = iFloatToIntBits + i2;
                    i5 = i4;
                    break;
                case 12:
                    i2 = i5 * 53;
                    iFloatToIntBits = y1.c(obj, j);
                    i4 = iFloatToIntBits + i2;
                    i5 = i4;
                    break;
                case 13:
                    i2 = i5 * 53;
                    iFloatToIntBits = y1.c(obj, j);
                    i4 = iFloatToIntBits + i2;
                    i5 = i4;
                    break;
                case 14:
                    i = i5 * 53;
                    jDoubleToLongBits = y1.d(obj, j);
                    Charset charset6 = AbstractC3205m0.f2291a;
                    i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    i5 = i4;
                    break;
                case 15:
                    i2 = i5 * 53;
                    iFloatToIntBits = y1.c(obj, j);
                    i4 = iFloatToIntBits + i2;
                    i5 = i4;
                    break;
                case 16:
                    i = i5 * 53;
                    jDoubleToLongBits = y1.d(obj, j);
                    Charset charset7 = AbstractC3205m0.f2291a;
                    i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    i5 = i4;
                    break;
                case 17:
                    Object objE2 = y1.e(obj, j);
                    if (objE2 != null) {
                        iHashCode = objE2.hashCode();
                    }
                    iFloatToIntBits = i5 * 53;
                    i2 = iHashCode;
                    i4 = iFloatToIntBits + i2;
                    i5 = i4;
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
                    i2 = i5 * 53;
                    iFloatToIntBits = y1.e(obj, j).hashCode();
                    i4 = iFloatToIntBits + i2;
                    i5 = i4;
                    break;
                case 50:
                    i2 = i5 * 53;
                    iFloatToIntBits = y1.e(obj, j).hashCode();
                    i4 = iFloatToIntBits + i2;
                    i5 = i4;
                    break;
                case 51:
                    if (a(obj, i8, i6)) {
                        i = i5 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(((Double) y1.e(obj, j)).doubleValue());
                        Charset charset8 = AbstractC3205m0.f2291a;
                        i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        i5 = i4;
                    }
                    break;
                case 52:
                    if (a(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = Float.floatToIntBits(((Float) y1.e(obj, j)).floatValue());
                        i4 = iFloatToIntBits + i2;
                        i5 = i4;
                    }
                    break;
                case 53:
                    if (a(obj, i8, i6)) {
                        i = i5 * 53;
                        jDoubleToLongBits = ((Long) y1.e(obj, j)).longValue();
                        Charset charset9 = AbstractC3205m0.f2291a;
                        i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        i5 = i4;
                    }
                    break;
                case 54:
                    if (a(obj, i8, i6)) {
                        i = i5 * 53;
                        jDoubleToLongBits = ((Long) y1.e(obj, j)).longValue();
                        Charset charset10 = AbstractC3205m0.f2291a;
                        i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        i5 = i4;
                    }
                    break;
                case 55:
                    if (a(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = ((Integer) y1.e(obj, j)).intValue();
                        i4 = iFloatToIntBits + i2;
                        i5 = i4;
                    }
                    break;
                case 56:
                    if (a(obj, i8, i6)) {
                        i = i5 * 53;
                        jDoubleToLongBits = ((Long) y1.e(obj, j)).longValue();
                        Charset charset11 = AbstractC3205m0.f2291a;
                        i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        i5 = i4;
                    }
                    break;
                case 57:
                    if (a(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = ((Integer) y1.e(obj, j)).intValue();
                        i4 = iFloatToIntBits + i2;
                        i5 = i4;
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    if (a(obj, i8, i6)) {
                        i3 = i5 * 53;
                        boolean zBooleanValue = ((Boolean) y1.e(obj, j)).booleanValue();
                        Charset charset12 = AbstractC3205m0.f2291a;
                        if (!zBooleanValue) {
                            i9 = 1237;
                        }
                        i4 = i9 + i3;
                        i5 = i4;
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    if (a(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = ((String) y1.e(obj, j)).hashCode();
                        i4 = iFloatToIntBits + i2;
                        i5 = i4;
                    }
                    break;
                case 60:
                    if (a(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = y1.e(obj, j).hashCode();
                        i4 = iFloatToIntBits + i2;
                        i5 = i4;
                    }
                    break;
                case 61:
                    if (a(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = y1.e(obj, j).hashCode();
                        i4 = iFloatToIntBits + i2;
                        i5 = i4;
                    }
                    break;
                case 62:
                    if (a(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = ((Integer) y1.e(obj, j)).intValue();
                        i4 = iFloatToIntBits + i2;
                        i5 = i4;
                    }
                    break;
                case 63:
                    if (a(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = ((Integer) y1.e(obj, j)).intValue();
                        i4 = iFloatToIntBits + i2;
                        i5 = i4;
                    }
                    break;
                case 64:
                    if (a(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = ((Integer) y1.e(obj, j)).intValue();
                        i4 = iFloatToIntBits + i2;
                        i5 = i4;
                    }
                    break;
                case 65:
                    if (a(obj, i8, i6)) {
                        i = i5 * 53;
                        jDoubleToLongBits = ((Long) y1.e(obj, j)).longValue();
                        Charset charset13 = AbstractC3205m0.f2291a;
                        i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        i5 = i4;
                    }
                    break;
                case 66:
                    if (a(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = ((Integer) y1.e(obj, j)).intValue();
                        i4 = iFloatToIntBits + i2;
                        i5 = i4;
                    }
                    break;
                case 67:
                    if (a(obj, i8, i6)) {
                        i = i5 * 53;
                        jDoubleToLongBits = ((Long) y1.e(obj, j)).longValue();
                        Charset charset14 = AbstractC3205m0.f2291a;
                        i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        i5 = i4;
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    if (a(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = y1.e(obj, j).hashCode();
                        i4 = iFloatToIntBits + i2;
                        i5 = i4;
                    }
                    break;
            }
        }
        this.n.getClass();
        int iHashCode2 = ((AbstractC3169a0) obj).unknownFields.hashCode() + (i5 * 53);
        if (!this.f) {
            return iHashCode2;
        }
        this.o.getClass();
        return (iHashCode2 * 53) + ((GeneratedMessageLite$ExtendableMessage) obj).extensions.f2264a.hashCode();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final void c(Object obj) {
        int i;
        int i2 = this.j;
        while (true) {
            i = this.k;
            if (i2 >= i) {
                break;
            }
            long j = this.f2259a[this.i[i2] + 1] & 1048575;
            Object objE = y1.e(obj, j);
            if (objE != null) {
                this.p.getClass();
                ((C3236z0) objE).f2306a = false;
                y1.a(j, obj, objE);
            }
            i2++;
        }
        int length = this.i.length;
        while (i < length) {
            this.m.a(obj, this.i[i]);
            i++;
        }
        this.n.getClass();
        ((AbstractC3169a0) obj).unknownFields.e = false;
        if (this.f) {
            this.o.getClass();
            ((GeneratedMessageLite$ExtendableMessage) obj).extensions.e();
        }
    }

    public final void c(int i, Object obj, Object obj2) {
        long j = this.f2259a[i + 1] & 1048575;
        Object objE = y1.e(obj, j);
        if (objE != null) {
            this.p.getClass();
            if (!((C3236z0) objE).f2306a) {
                this.p.getClass();
                C3236z0 c3236z0 = C3236z0.b;
                C3236z0 c3236z1 = c3236z0.isEmpty() ? new C3236z0() : new C3236z0(c3236z0);
                this.p.getClass();
                A0.a(c3236z1, objE);
                y1.a(j, obj, c3236z1);
                objE = c3236z1;
            }
        } else {
            this.p.getClass();
            C3236z0 c3236z2 = C3236z0.b;
            objE = c3236z2.isEmpty() ? new C3236z0() : new C3236z0(c3236z2);
            y1.a(j, obj, objE);
        }
        this.p.getClass();
        this.p.getClass();
        obj2.getClass();
        throw new ClassCastException();
    }

    /* JADX WARN: Code duplicated, block: B:136:0x0398  */
    /* JADX WARN: Code duplicated, block: B:161:0x0446  */
    /* JADX WARN: Code duplicated, block: B:238:0x0634 A[PHI: r6
  0x0634: PHI (r6v70 int) = (r6v8 int), (r6v72 int) binds: [B:236:0x062d, B:59:0x017e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:387:0x0a28  */
    /* JADX WARN: Code duplicated, block: B:412:0x0ad6  */
    /* JADX WARN: Code duplicated, block: B:489:0x0ca8 A[PHI: r4
  0x0ca8: PHI (r4v68 int) = (r4v5 int), (r4v70 int) binds: [B:487:0x0ca1, B:311:0x080b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final int b(Object obj) {
        int i;
        int i2;
        int iA;
        int iB;
        int iA2;
        int iB2;
        int iC;
        int iB3;
        int iA3;
        int iB4;
        int iB5;
        int iA4;
        int iB6;
        int iA5;
        int iA6;
        int iB7;
        int iC2;
        int iB8;
        int iA7;
        int iB9;
        int i3 = 267386880;
        int i4 = 1048575;
        if (this.h) {
            Unsafe unsafe = r;
            int i5 = 0;
            int iB10 = 0;
            while (true) {
                int[] iArr = this.f2259a;
                if (i5 < iArr.length) {
                    int i6 = iArr[i5 + 1];
                    int i7 = (i6 & 267386880) >>> 20;
                    int i8 = iArr[i5];
                    long j = i6 & i4;
                    if (i7 >= FieldType.DOUBLE_LIST_PACKED.id() && i7 <= FieldType.SINT64_LIST_PACKED.id()) {
                        int i9 = this.f2259a[i5 + 2];
                    }
                    switch (i7) {
                        case 0:
                            if (a(i5, obj)) {
                                iA4 = H0.a(i8, 8, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 1:
                            if (a(i5, obj)) {
                                iA4 = H0.a(i8, 4, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 2:
                            if (a(i5, obj)) {
                                long jD = y1.d(obj, j);
                                iB6 = B.b(i8);
                                iA5 = B.a(jD);
                                iA6 = iA5 + iB6;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 3:
                            if (a(i5, obj)) {
                                iA6 = B.a(y1.d(obj, j)) + B.b(i8);
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 4:
                            if (a(i5, obj)) {
                                int iC3 = y1.c(obj, j);
                                iB7 = B.b(i8);
                                if (iC3 >= 0) {
                                    iC2 = B.c(iC3);
                                } else {
                                    iC2 = 10;
                                }
                                iA6 = iC2 + iB7;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 5:
                            if (a(i5, obj)) {
                                iA4 = H0.a(i8, 8, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 6:
                            if (a(i5, obj)) {
                                iA4 = H0.a(i8, 4, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 7:
                            if (a(i5, obj)) {
                                iA4 = H0.a(i8, 1, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 8:
                            if (a(i5, obj)) {
                                Object objE = y1.e(obj, j);
                                if (objE instanceof AbstractC3221s) {
                                    iB8 = B.b(i8);
                                    iA7 = B.a((AbstractC3221s) objE);
                                } else {
                                    iB8 = B.b(i8);
                                    iA7 = B.a((String) objE);
                                }
                                iA6 = iA7 + iB8;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 9:
                            if (a(i5, obj)) {
                                Object objE2 = y1.e(obj, j);
                                U0 u0C = c(i5);
                                Class cls = V0.f2271a;
                                int iB11 = B.b(i8);
                                int serializedSize = ((AbstractC3171b) ((E0) objE2)).getSerializedSize(u0C);
                                iA4 = L.a(serializedSize, serializedSize, iB11, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 10:
                            if (a(i5, obj)) {
                                AbstractC3221s abstractC3221s = (AbstractC3221s) y1.e(obj, j);
                                iB8 = B.b(i8);
                                iA7 = B.a(abstractC3221s);
                                iA6 = iA7 + iB8;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 11:
                            if (a(i5, obj)) {
                                int iC4 = y1.c(obj, j);
                                iB8 = B.b(i8);
                                iA7 = B.c(iC4);
                                iA6 = iA7 + iB8;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 12:
                            if (a(i5, obj)) {
                                int iC5 = y1.c(obj, j);
                                iB8 = B.b(i8);
                                iA7 = B.a(iC5);
                                iA6 = iA7 + iB8;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 13:
                            if (a(i5, obj)) {
                                iA4 = H0.a(i8, 4, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 14:
                            if (a(i5, obj)) {
                                iA4 = H0.a(i8, 8, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 15:
                            if (a(i5, obj)) {
                                int iC6 = y1.c(obj, j);
                                iB6 = B.b(i8);
                                iA5 = B.c(B.d(iC6));
                                iA6 = iA5 + iB6;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 16:
                            if (a(i5, obj)) {
                                long jD2 = y1.d(obj, j);
                                iB6 = B.b(i8);
                                iA5 = B.a(B.b(jD2));
                                iA6 = iA5 + iB6;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 17:
                            if (a(i5, obj)) {
                                E0 e0 = (E0) y1.e(obj, j);
                                U0 u0C2 = c(i5);
                                iB6 = B.b(i8) * 2;
                                iA5 = ((AbstractC3171b) e0).getSerializedSize(u0C2);
                                iA6 = iA5 + iB6;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 18:
                            iA6 = V0.b(i8, (List) y1.e(obj, j));
                            iA4 = iA6 + iB10;
                            iB10 = iA4;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 19:
                            iA6 = V0.a(i8, (List) y1.e(obj, j));
                            iA4 = iA6 + iB10;
                            iB10 = iA4;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 20:
                            List list = (List) y1.e(obj, j);
                            Class cls2 = V0.f2271a;
                            if (list.size() == 0) {
                                iA6 = 0;
                            } else {
                                iA6 = I0.a(i8, list.size(), V0.c(list));
                            }
                            iA4 = iA6 + iB10;
                            iB10 = iA4;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 21:
                            List list2 = (List) y1.e(obj, j);
                            Class cls3 = V0.f2271a;
                            int size = list2.size();
                            if (size == 0) {
                                iA6 = 0;
                            } else {
                                iA6 = I0.a(i8, size, V0.g(list2));
                            }
                            iA4 = iA6 + iB10;
                            iB10 = iA4;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 22:
                            List list3 = (List) y1.e(obj, j);
                            Class cls4 = V0.f2271a;
                            int size2 = list3.size();
                            if (size2 == 0) {
                                iA6 = 0;
                            } else {
                                iA6 = I0.a(i8, size2, V0.b(list3));
                            }
                            iA4 = iA6 + iB10;
                            iB10 = iA4;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 23:
                            iA6 = V0.b(i8, (List) y1.e(obj, j));
                            iA4 = iA6 + iB10;
                            iB10 = iA4;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 24:
                            iA6 = V0.a(i8, (List) y1.e(obj, j));
                            iA4 = iA6 + iB10;
                            iB10 = iA4;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 25:
                            List list4 = (List) y1.e(obj, j);
                            Class cls5 = V0.f2271a;
                            int size3 = list4.size();
                            iB10 = (size3 == 0 ? 0 : (B.b(i8) + 1) * size3) + iB10;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 26:
                            iA6 = V0.c(i8, (List) y1.e(obj, j));
                            iA4 = iA6 + iB10;
                            iB10 = iA4;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 27:
                            List list5 = (List) y1.e(obj, j);
                            U0 u0C3 = c(i5);
                            Class cls6 = V0.f2271a;
                            int size4 = list5.size();
                            if (size4 == 0) {
                                iB9 = 0;
                            } else {
                                iB9 = B.b(i8) * size4;
                                for (int i10 = 0; i10 < size4; i10++) {
                                    int serializedSize2 = ((AbstractC3171b) ((E0) list5.get(i10))).getSerializedSize(u0C3);
                                    iB9 = B.c(serializedSize2) + serializedSize2 + iB9;
                                }
                            }
                            iB10 = iB9 + iB10;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 28:
                            List list6 = (List) y1.e(obj, j);
                            Class cls7 = V0.f2271a;
                            int size5 = list6.size();
                            if (size5 == 0) {
                                iB9 = 0;
                            } else {
                                iB9 = B.b(i8) * size5;
                                for (int i11 = 0; i11 < list6.size(); i11++) {
                                    iB9 = B.a((AbstractC3221s) list6.get(i11)) + iB9;
                                }
                            }
                            iB10 = iB9 + iB10;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 29:
                            List list7 = (List) y1.e(obj, j);
                            Class cls8 = V0.f2271a;
                            int size6 = list7.size();
                            if (size6 == 0) {
                                iA6 = 0;
                            } else {
                                iA6 = I0.a(i8, size6, V0.f(list7));
                            }
                            iA4 = iA6 + iB10;
                            iB10 = iA4;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 30:
                            List list8 = (List) y1.e(obj, j);
                            Class cls9 = V0.f2271a;
                            int size7 = list8.size();
                            if (size7 == 0) {
                                iA6 = 0;
                            } else {
                                iA6 = I0.a(i8, size7, V0.a(list8));
                            }
                            iA4 = iA6 + iB10;
                            iB10 = iA4;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 31:
                            iA6 = V0.a(i8, (List) y1.e(obj, j));
                            iA4 = iA6 + iB10;
                            iB10 = iA4;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 32:
                            iA6 = V0.b(i8, (List) y1.e(obj, j));
                            iA4 = iA6 + iB10;
                            iB10 = iA4;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 33:
                            List list9 = (List) y1.e(obj, j);
                            Class cls10 = V0.f2271a;
                            int size8 = list9.size();
                            if (size8 == 0) {
                                iA6 = 0;
                            } else {
                                iA6 = I0.a(i8, size8, V0.d(list9));
                            }
                            iA4 = iA6 + iB10;
                            iB10 = iA4;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 34:
                            List list10 = (List) y1.e(obj, j);
                            Class cls11 = V0.f2271a;
                            int size9 = list10.size();
                            if (size9 == 0) {
                                iA6 = 0;
                            } else {
                                iA6 = I0.a(i8, size9, V0.e(list10));
                            }
                            iA4 = iA6 + iB10;
                            iB10 = iA4;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 35:
                            List list11 = (List) unsafe.getObject(obj, j);
                            Class cls12 = V0.f2271a;
                            int size10 = list11.size() * 8;
                            if (size10 > 0) {
                                iA4 = L.a(size10, B.b(i8), size10, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 36:
                            List list12 = (List) unsafe.getObject(obj, j);
                            Class cls13 = V0.f2271a;
                            int size11 = list12.size() * 4;
                            if (size11 > 0) {
                                iA4 = L.a(size11, B.b(i8), size11, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 37:
                            int iC7 = V0.c((List) unsafe.getObject(obj, j));
                            if (iC7 > 0) {
                                iA4 = L.a(iC7, B.b(i8), iC7, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 38:
                            int iG = V0.g((List) unsafe.getObject(obj, j));
                            if (iG > 0) {
                                iA4 = L.a(iG, B.b(i8), iG, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 39:
                            int iB12 = V0.b((List) unsafe.getObject(obj, j));
                            if (iB12 > 0) {
                                iA4 = L.a(iB12, B.b(i8), iB12, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 40:
                            List list13 = (List) unsafe.getObject(obj, j);
                            Class cls14 = V0.f2271a;
                            int size12 = list13.size() * 8;
                            if (size12 > 0) {
                                iA4 = L.a(size12, B.b(i8), size12, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 41:
                            List list14 = (List) unsafe.getObject(obj, j);
                            Class cls15 = V0.f2271a;
                            int size13 = list14.size() * 4;
                            if (size13 > 0) {
                                iA4 = L.a(size13, B.b(i8), size13, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 42:
                            List list15 = (List) unsafe.getObject(obj, j);
                            Class cls16 = V0.f2271a;
                            int size14 = list15.size();
                            if (size14 > 0) {
                                iA4 = L.a(size14, B.b(i8), size14, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 43:
                            int iF = V0.f((List) unsafe.getObject(obj, j));
                            if (iF > 0) {
                                iA4 = L.a(iF, B.b(i8), iF, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 44:
                            int iA8 = V0.a((List) unsafe.getObject(obj, j));
                            if (iA8 > 0) {
                                iA4 = L.a(iA8, B.b(i8), iA8, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 45:
                            List list16 = (List) unsafe.getObject(obj, j);
                            Class cls17 = V0.f2271a;
                            int size15 = list16.size() * 4;
                            if (size15 > 0) {
                                iA4 = L.a(size15, B.b(i8), size15, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 46:
                            List list17 = (List) unsafe.getObject(obj, j);
                            Class cls18 = V0.f2271a;
                            int size16 = list17.size() * 8;
                            if (size16 > 0) {
                                iA4 = L.a(size16, B.b(i8), size16, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 47:
                            int iD = V0.d((List) unsafe.getObject(obj, j));
                            if (iD > 0) {
                                iA4 = L.a(iD, B.b(i8), iD, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 48:
                            int iE = V0.e((List) unsafe.getObject(obj, j));
                            if (iE > 0) {
                                iA4 = L.a(iE, B.b(i8), iE, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 49:
                            List list18 = (List) y1.e(obj, j);
                            U0 u0C4 = c(i5);
                            Class cls19 = V0.f2271a;
                            int size17 = list18.size();
                            if (size17 == 0) {
                                iB9 = 0;
                            } else {
                                iB9 = 0;
                                for (int i12 = 0; i12 < size17; i12++) {
                                    iB9 = ((AbstractC3171b) ((E0) list18.get(i12))).getSerializedSize(u0C4) + (B.b(i8) * 2) + iB9;
                                }
                            }
                            iB10 = iB9 + iB10;
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 50:
                            A0 a0 = this.p;
                            Object objE3 = y1.e(obj, j);
                            Object objB = b(i5);
                            a0.getClass();
                            C3236z0 c3236z0 = (C3236z0) objE3;
                            if (objB == null) {
                                if (c3236z0.isEmpty()) {
                                    continue;
                                } else {
                                    Iterator it = c3236z0.entrySet().iterator();
                                    if (it.hasNext()) {
                                        Map.Entry entry = (Map.Entry) it.next();
                                        entry.getKey();
                                        entry.getValue();
                                        throw null;
                                    }
                                }
                                i5 += 3;
                                i4 = 1048575;
                            } else {
                                throw new ClassCastException();
                            }
                            break;
                        case 51:
                            if (a(obj, i8, i5)) {
                                iA4 = H0.a(i8, 8, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 52:
                            if (a(obj, i8, i5)) {
                                iA4 = H0.a(i8, 4, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 53:
                            if (a(obj, i8, i5)) {
                                long jLongValue = ((Long) y1.e(obj, j)).longValue();
                                iB6 = B.b(i8);
                                iA5 = B.a(jLongValue);
                                iA6 = iA5 + iB6;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 54:
                            if (a(obj, i8, i5)) {
                                long jLongValue2 = ((Long) y1.e(obj, j)).longValue();
                                iB6 = B.b(i8);
                                iA5 = B.a(jLongValue2);
                                iA6 = iA5 + iB6;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 55:
                            if (a(obj, i8, i5)) {
                                int iIntValue = ((Integer) y1.e(obj, j)).intValue();
                                iB7 = B.b(i8);
                                if (iIntValue >= 0) {
                                    iC2 = B.c(iIntValue);
                                } else {
                                    iC2 = 10;
                                }
                                iA6 = iC2 + iB7;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 56:
                            if (a(obj, i8, i5)) {
                                iA4 = H0.a(i8, 8, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 57:
                            if (a(obj, i8, i5)) {
                                iA4 = H0.a(i8, 4, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                            if (a(obj, i8, i5)) {
                                iA4 = H0.a(i8, 1, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                            if (a(obj, i8, i5)) {
                                Object objE4 = y1.e(obj, j);
                                if (objE4 instanceof AbstractC3221s) {
                                    iB8 = B.b(i8);
                                    iA7 = B.a((AbstractC3221s) objE4);
                                } else {
                                    iB8 = B.b(i8);
                                    iA7 = B.a((String) objE4);
                                }
                                iA6 = iA7 + iB8;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 60:
                            if (a(obj, i8, i5)) {
                                Object objE5 = y1.e(obj, j);
                                U0 u0C5 = c(i5);
                                Class cls20 = V0.f2271a;
                                int iB13 = B.b(i8);
                                int serializedSize3 = ((AbstractC3171b) ((E0) objE5)).getSerializedSize(u0C5);
                                iA4 = L.a(serializedSize3, serializedSize3, iB13, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 61:
                            if (a(obj, i8, i5)) {
                                AbstractC3221s abstractC3221s2 = (AbstractC3221s) y1.e(obj, j);
                                iB8 = B.b(i8);
                                iA7 = B.a(abstractC3221s2);
                                iA6 = iA7 + iB8;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 62:
                            if (a(obj, i8, i5)) {
                                int iIntValue2 = ((Integer) y1.e(obj, j)).intValue();
                                iB8 = B.b(i8);
                                iA7 = B.c(iIntValue2);
                                iA6 = iA7 + iB8;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 63:
                            if (a(obj, i8, i5)) {
                                int iIntValue3 = ((Integer) y1.e(obj, j)).intValue();
                                iB8 = B.b(i8);
                                iA7 = B.a(iIntValue3);
                                iA6 = iA7 + iB8;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 64:
                            if (a(obj, i8, i5)) {
                                iA4 = H0.a(i8, 4, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 65:
                            if (a(obj, i8, i5)) {
                                iA4 = H0.a(i8, 8, iB10);
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 66:
                            if (a(obj, i8, i5)) {
                                int iIntValue4 = ((Integer) y1.e(obj, j)).intValue();
                                iB6 = B.b(i8);
                                iA5 = B.c(B.d(iIntValue4));
                                iA6 = iA5 + iB6;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case 67:
                            if (a(obj, i8, i5)) {
                                long jLongValue3 = ((Long) y1.e(obj, j)).longValue();
                                iB6 = B.b(i8);
                                iA5 = B.a(B.b(jLongValue3));
                                iA6 = iA5 + iB6;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                            if (a(obj, i8, i5)) {
                                E0 e1 = (E0) y1.e(obj, j);
                                U0 u0C6 = c(i5);
                                iB6 = B.b(i8) * 2;
                                iA5 = ((AbstractC3171b) e1).getSerializedSize(u0C6);
                                iA6 = iA5 + iB6;
                                iA4 = iA6 + iB10;
                                iB10 = iA4;
                            }
                            i5 += 3;
                            i4 = 1048575;
                            break;
                        default:
                            i5 += 3;
                            i4 = 1048575;
                            break;
                    }
                } else {
                    this.n.getClass();
                    return ((AbstractC3169a0) obj).unknownFields.a() + iB10;
                }
            }
        } else {
            Unsafe unsafe2 = r;
            int i13 = 0;
            int iB14 = 0;
            int i14 = 1048575;
            int i15 = 0;
            while (true) {
                int[] iArr2 = this.f2259a;
                if (i13 < iArr2.length) {
                    int i16 = iArr2[i13 + 1];
                    int i17 = iArr2[i13];
                    int i18 = (i16 & i3) >>> 20;
                    if (i18 <= 17) {
                        int i19 = iArr2[i13 + 2];
                        i = 1048575;
                        int i20 = i19 & 1048575;
                        i2 = 1 << (i19 >>> 20);
                        if (i20 != i14) {
                            i15 = unsafe2.getInt(obj, i20);
                            i14 = i20;
                        }
                    } else {
                        i = 1048575;
                        i2 = 0;
                    }
                    long j2 = i16 & i;
                    switch (i18) {
                        case 0:
                            if ((i15 & i2) != 0) {
                                iA = H0.a(i17, 8, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 1:
                            if ((i15 & i2) != 0) {
                                iA = H0.a(i17, 4, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 2:
                            if ((i15 & i2) != 0) {
                                long j3 = unsafe2.getLong(obj, j2);
                                iB = B.b(i17);
                                iA2 = B.a(j3);
                                iB4 = iA2 + iB;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 3:
                            if ((i15 & i2) != 0) {
                                long j4 = unsafe2.getLong(obj, j2);
                                iB = B.b(i17);
                                iA2 = B.a(j4);
                                iB4 = iA2 + iB;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 4:
                            if ((i15 & i2) != 0) {
                                int i21 = unsafe2.getInt(obj, j2);
                                iB2 = B.b(i17);
                                if (i21 >= 0) {
                                    iC = B.c(i21);
                                } else {
                                    iC = 10;
                                }
                                iB4 = iC + iB2;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 5:
                            if ((i15 & i2) != 0) {
                                iA = H0.a(i17, 8, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 6:
                            if ((i15 & i2) != 0) {
                                iA = H0.a(i17, 4, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 7:
                            if ((i15 & i2) != 0) {
                                iA = H0.a(i17, 1, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 8:
                            if ((i15 & i2) != 0) {
                                Object object = unsafe2.getObject(obj, j2);
                                if (object instanceof AbstractC3221s) {
                                    iB3 = B.b(i17);
                                    iA3 = B.a((AbstractC3221s) object);
                                } else {
                                    iB3 = B.b(i17);
                                    iA3 = B.a((String) object);
                                }
                                iB4 = iA3 + iB3;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 9:
                            if ((i15 & i2) != 0) {
                                Object object2 = unsafe2.getObject(obj, j2);
                                U0 u0C7 = c(i13);
                                Class cls21 = V0.f2271a;
                                int iB15 = B.b(i17);
                                int serializedSize4 = ((AbstractC3171b) ((E0) object2)).getSerializedSize(u0C7);
                                iA = L.a(serializedSize4, serializedSize4, iB15, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 10:
                            if ((i15 & i2) != 0) {
                                AbstractC3221s abstractC3221s3 = (AbstractC3221s) unsafe2.getObject(obj, j2);
                                iB3 = B.b(i17);
                                iA3 = B.a(abstractC3221s3);
                                iB4 = iA3 + iB3;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 11:
                            if ((i15 & i2) != 0) {
                                int i22 = unsafe2.getInt(obj, j2);
                                iB3 = B.b(i17);
                                iA3 = B.c(i22);
                                iB4 = iA3 + iB3;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 12:
                            if ((i15 & i2) != 0) {
                                int i23 = unsafe2.getInt(obj, j2);
                                iB3 = B.b(i17);
                                iA3 = B.a(i23);
                                iB4 = iA3 + iB3;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 13:
                            if ((i15 & i2) != 0) {
                                iA = H0.a(i17, 4, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 14:
                            if ((i15 & i2) != 0) {
                                iA = H0.a(i17, 8, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 15:
                            if ((i15 & i2) != 0) {
                                int i24 = unsafe2.getInt(obj, j2);
                                iB = B.b(i17);
                                iA2 = B.c(B.d(i24));
                                iB4 = iA2 + iB;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 16:
                            if ((i15 & i2) != 0) {
                                long j5 = unsafe2.getLong(obj, j2);
                                iB = B.b(i17);
                                iA2 = B.a(B.b(j5));
                                iB4 = iA2 + iB;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 17:
                            if ((i15 & i2) != 0) {
                                E0 e2 = (E0) unsafe2.getObject(obj, j2);
                                U0 u0C8 = c(i13);
                                iB = B.b(i17) * 2;
                                iA2 = ((AbstractC3171b) e2).getSerializedSize(u0C8);
                                iB4 = iA2 + iB;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 18:
                            iB4 = V0.b(i17, (List) unsafe2.getObject(obj, j2));
                            iA = iB4 + iB14;
                            iB14 = iA;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 19:
                            iB4 = V0.a(i17, (List) unsafe2.getObject(obj, j2));
                            iA = iB4 + iB14;
                            iB14 = iA;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 20:
                            List list19 = (List) unsafe2.getObject(obj, j2);
                            Class cls22 = V0.f2271a;
                            if (list19.size() == 0) {
                                iB4 = 0;
                            } else {
                                iB4 = I0.a(i17, list19.size(), V0.c(list19));
                            }
                            iA = iB4 + iB14;
                            iB14 = iA;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 21:
                            List list20 = (List) unsafe2.getObject(obj, j2);
                            Class cls23 = V0.f2271a;
                            int size18 = list20.size();
                            if (size18 == 0) {
                                iB4 = 0;
                            } else {
                                iB4 = I0.a(i17, size18, V0.g(list20));
                            }
                            iA = iB4 + iB14;
                            iB14 = iA;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 22:
                            List list21 = (List) unsafe2.getObject(obj, j2);
                            Class cls24 = V0.f2271a;
                            int size19 = list21.size();
                            if (size19 == 0) {
                                iB4 = 0;
                            } else {
                                iB4 = I0.a(i17, size19, V0.b(list21));
                            }
                            iA = iB4 + iB14;
                            iB14 = iA;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 23:
                            iB4 = V0.b(i17, (List) unsafe2.getObject(obj, j2));
                            iA = iB4 + iB14;
                            iB14 = iA;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 24:
                            iB4 = V0.a(i17, (List) unsafe2.getObject(obj, j2));
                            iA = iB4 + iB14;
                            iB14 = iA;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 25:
                            List list22 = (List) unsafe2.getObject(obj, j2);
                            Class cls25 = V0.f2271a;
                            int size20 = list22.size();
                            iB14 = (size20 == 0 ? 0 : (B.b(i17) + 1) * size20) + iB14;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 26:
                            iB4 = V0.c(i17, (List) unsafe2.getObject(obj, j2));
                            iA = iB4 + iB14;
                            iB14 = iA;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 27:
                            List list23 = (List) unsafe2.getObject(obj, j2);
                            U0 u0C9 = c(i13);
                            Class cls26 = V0.f2271a;
                            int size21 = list23.size();
                            if (size21 == 0) {
                                iB5 = 0;
                            } else {
                                iB5 = B.b(i17) * size21;
                                for (int i25 = 0; i25 < size21; i25++) {
                                    int serializedSize5 = ((AbstractC3171b) ((E0) list23.get(i25))).getSerializedSize(u0C9);
                                    iB5 = B.c(serializedSize5) + serializedSize5 + iB5;
                                }
                            }
                            iB14 = iB5 + iB14;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 28:
                            List list24 = (List) unsafe2.getObject(obj, j2);
                            Class cls27 = V0.f2271a;
                            int size22 = list24.size();
                            if (size22 == 0) {
                                iB5 = 0;
                            } else {
                                iB5 = B.b(i17) * size22;
                                for (int i26 = 0; i26 < list24.size(); i26++) {
                                    iB5 = B.a((AbstractC3221s) list24.get(i26)) + iB5;
                                }
                            }
                            iB14 = iB5 + iB14;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 29:
                            List list25 = (List) unsafe2.getObject(obj, j2);
                            Class cls28 = V0.f2271a;
                            int size23 = list25.size();
                            if (size23 == 0) {
                                iB4 = 0;
                            } else {
                                iB4 = I0.a(i17, size23, V0.f(list25));
                            }
                            iA = iB4 + iB14;
                            iB14 = iA;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 30:
                            List list26 = (List) unsafe2.getObject(obj, j2);
                            Class cls29 = V0.f2271a;
                            int size24 = list26.size();
                            if (size24 == 0) {
                                iB4 = 0;
                            } else {
                                iB4 = I0.a(i17, size24, V0.a(list26));
                            }
                            iA = iB4 + iB14;
                            iB14 = iA;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 31:
                            iB4 = V0.a(i17, (List) unsafe2.getObject(obj, j2));
                            iA = iB4 + iB14;
                            iB14 = iA;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 32:
                            iB4 = V0.b(i17, (List) unsafe2.getObject(obj, j2));
                            iA = iB4 + iB14;
                            iB14 = iA;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 33:
                            List list27 = (List) unsafe2.getObject(obj, j2);
                            Class cls30 = V0.f2271a;
                            int size25 = list27.size();
                            if (size25 == 0) {
                                iB4 = 0;
                            } else {
                                iB4 = I0.a(i17, size25, V0.d(list27));
                            }
                            iA = iB4 + iB14;
                            iB14 = iA;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 34:
                            List list28 = (List) unsafe2.getObject(obj, j2);
                            Class cls31 = V0.f2271a;
                            int size26 = list28.size();
                            if (size26 == 0) {
                                iB4 = 0;
                            } else {
                                iB4 = I0.a(i17, size26, V0.e(list28));
                            }
                            iA = iB4 + iB14;
                            iB14 = iA;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 35:
                            List list29 = (List) unsafe2.getObject(obj, j2);
                            Class cls32 = V0.f2271a;
                            int size27 = list29.size() * 8;
                            if (size27 > 0) {
                                iA = L.a(size27, B.b(i17), size27, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 36:
                            List list30 = (List) unsafe2.getObject(obj, j2);
                            Class cls33 = V0.f2271a;
                            int size28 = list30.size() * 4;
                            if (size28 > 0) {
                                iA = L.a(size28, B.b(i17), size28, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 37:
                            int iC8 = V0.c((List) unsafe2.getObject(obj, j2));
                            if (iC8 > 0) {
                                iA = L.a(iC8, B.b(i17), iC8, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 38:
                            int iG2 = V0.g((List) unsafe2.getObject(obj, j2));
                            if (iG2 > 0) {
                                iA = L.a(iG2, B.b(i17), iG2, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 39:
                            int iB16 = V0.b((List) unsafe2.getObject(obj, j2));
                            if (iB16 > 0) {
                                iA = L.a(iB16, B.b(i17), iB16, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 40:
                            List list31 = (List) unsafe2.getObject(obj, j2);
                            Class cls34 = V0.f2271a;
                            int size29 = list31.size() * 8;
                            if (size29 > 0) {
                                iA = L.a(size29, B.b(i17), size29, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 41:
                            List list32 = (List) unsafe2.getObject(obj, j2);
                            Class cls35 = V0.f2271a;
                            int size30 = list32.size() * 4;
                            if (size30 > 0) {
                                iA = L.a(size30, B.b(i17), size30, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 42:
                            List list33 = (List) unsafe2.getObject(obj, j2);
                            Class cls36 = V0.f2271a;
                            int size31 = list33.size();
                            if (size31 > 0) {
                                iA = L.a(size31, B.b(i17), size31, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 43:
                            int iF2 = V0.f((List) unsafe2.getObject(obj, j2));
                            if (iF2 > 0) {
                                iA = L.a(iF2, B.b(i17), iF2, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 44:
                            int iA9 = V0.a((List) unsafe2.getObject(obj, j2));
                            if (iA9 > 0) {
                                iA = L.a(iA9, B.b(i17), iA9, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 45:
                            List list34 = (List) unsafe2.getObject(obj, j2);
                            Class cls37 = V0.f2271a;
                            int size32 = list34.size() * 4;
                            if (size32 > 0) {
                                iA = L.a(size32, B.b(i17), size32, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 46:
                            List list35 = (List) unsafe2.getObject(obj, j2);
                            Class cls38 = V0.f2271a;
                            int size33 = list35.size() * 8;
                            if (size33 > 0) {
                                iA = L.a(size33, B.b(i17), size33, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 47:
                            int iD2 = V0.d((List) unsafe2.getObject(obj, j2));
                            if (iD2 > 0) {
                                iA = L.a(iD2, B.b(i17), iD2, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 48:
                            int iE2 = V0.e((List) unsafe2.getObject(obj, j2));
                            if (iE2 > 0) {
                                iA = L.a(iE2, B.b(i17), iE2, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 49:
                            List list36 = (List) unsafe2.getObject(obj, j2);
                            U0 u0C10 = c(i13);
                            Class cls39 = V0.f2271a;
                            int size34 = list36.size();
                            if (size34 == 0) {
                                iB5 = 0;
                            } else {
                                iB5 = 0;
                                for (int i27 = 0; i27 < size34; i27++) {
                                    iB5 = ((AbstractC3171b) ((E0) list36.get(i27))).getSerializedSize(u0C10) + (B.b(i17) * 2) + iB5;
                                }
                            }
                            iB14 = iB5 + iB14;
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 50:
                            A0 a1 = this.p;
                            Object object3 = unsafe2.getObject(obj, j2);
                            Object objB2 = b(i13);
                            a1.getClass();
                            C3236z0 c3236z1 = (C3236z0) object3;
                            if (objB2 == null) {
                                if (c3236z1.isEmpty()) {
                                    continue;
                                } else {
                                    Iterator it2 = c3236z1.entrySet().iterator();
                                    if (it2.hasNext()) {
                                        Map.Entry entry2 = (Map.Entry) it2.next();
                                        entry2.getKey();
                                        entry2.getValue();
                                        throw null;
                                    }
                                }
                                i13 += 3;
                                i3 = 267386880;
                            } else {
                                throw new ClassCastException();
                            }
                            break;
                        case 51:
                            if (a(obj, i17, i13)) {
                                iA = H0.a(i17, 8, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 52:
                            if (a(obj, i17, i13)) {
                                iA = H0.a(i17, 4, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 53:
                            if (a(obj, i17, i13)) {
                                long jLongValue4 = ((Long) y1.e(obj, j2)).longValue();
                                iB = B.b(i17);
                                iA2 = B.a(jLongValue4);
                                iB4 = iA2 + iB;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 54:
                            if (a(obj, i17, i13)) {
                                long jLongValue5 = ((Long) y1.e(obj, j2)).longValue();
                                iB = B.b(i17);
                                iA2 = B.a(jLongValue5);
                                iB4 = iA2 + iB;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 55:
                            if (a(obj, i17, i13)) {
                                int iIntValue5 = ((Integer) y1.e(obj, j2)).intValue();
                                iB2 = B.b(i17);
                                if (iIntValue5 >= 0) {
                                    iC = B.c(iIntValue5);
                                } else {
                                    iC = 10;
                                }
                                iB4 = iC + iB2;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 56:
                            if (a(obj, i17, i13)) {
                                iA = H0.a(i17, 8, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 57:
                            if (a(obj, i17, i13)) {
                                iA = H0.a(i17, 4, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                            if (a(obj, i17, i13)) {
                                iA = H0.a(i17, 1, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                            if (a(obj, i17, i13)) {
                                Object object4 = unsafe2.getObject(obj, j2);
                                if (object4 instanceof AbstractC3221s) {
                                    iB3 = B.b(i17);
                                    iA3 = B.a((AbstractC3221s) object4);
                                } else {
                                    iB3 = B.b(i17);
                                    iA3 = B.a((String) object4);
                                }
                                iB4 = iA3 + iB3;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 60:
                            if (a(obj, i17, i13)) {
                                Object object5 = unsafe2.getObject(obj, j2);
                                U0 u0C11 = c(i13);
                                Class cls40 = V0.f2271a;
                                int iB17 = B.b(i17);
                                int serializedSize6 = ((AbstractC3171b) ((E0) object5)).getSerializedSize(u0C11);
                                iA = L.a(serializedSize6, serializedSize6, iB17, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 61:
                            if (a(obj, i17, i13)) {
                                AbstractC3221s abstractC3221s4 = (AbstractC3221s) unsafe2.getObject(obj, j2);
                                iB3 = B.b(i17);
                                iA3 = B.a(abstractC3221s4);
                                iB4 = iA3 + iB3;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 62:
                            if (a(obj, i17, i13)) {
                                int iIntValue6 = ((Integer) y1.e(obj, j2)).intValue();
                                iB3 = B.b(i17);
                                iA3 = B.c(iIntValue6);
                                iB4 = iA3 + iB3;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 63:
                            if (a(obj, i17, i13)) {
                                int iIntValue7 = ((Integer) y1.e(obj, j2)).intValue();
                                iB3 = B.b(i17);
                                iA3 = B.a(iIntValue7);
                                iB4 = iA3 + iB3;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 64:
                            if (a(obj, i17, i13)) {
                                iA = H0.a(i17, 4, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 65:
                            if (a(obj, i17, i13)) {
                                iA = H0.a(i17, 8, iB14);
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 66:
                            if (a(obj, i17, i13)) {
                                int iIntValue8 = ((Integer) y1.e(obj, j2)).intValue();
                                iB = B.b(i17);
                                iA2 = B.c(B.d(iIntValue8));
                                iB4 = iA2 + iB;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case 67:
                            if (a(obj, i17, i13)) {
                                long jLongValue6 = ((Long) y1.e(obj, j2)).longValue();
                                iB = B.b(i17);
                                iA2 = B.a(B.b(jLongValue6));
                                iB4 = iA2 + iB;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                            if (a(obj, i17, i13)) {
                                E0 e3 = (E0) unsafe2.getObject(obj, j2);
                                U0 u0C12 = c(i13);
                                iB = B.b(i17) * 2;
                                iA2 = ((AbstractC3171b) e3).getSerializedSize(u0C12);
                                iB4 = iA2 + iB;
                                iA = iB4 + iB14;
                                iB14 = iA;
                            }
                            i13 += 3;
                            i3 = 267386880;
                            break;
                        default:
                            i13 += 3;
                            i3 = 267386880;
                            break;
                    }
                } else {
                    this.n.getClass();
                    int iA10 = ((AbstractC3169a0) obj).unknownFields.a() + iB14;
                    if (!this.f) {
                        return iA10;
                    }
                    this.o.getClass();
                    return ((GeneratedMessageLite$ExtendableMessage) obj).extensions.b() + iA10;
                }
            }
        }
    }

    public final void d(int i, Object obj, Object obj2) {
        long j = this.f2259a[i + 1] & 1048575;
        if (a(i, obj2)) {
            Object objE = y1.e(obj, j);
            Object objE2 = y1.e(obj2, j);
            if (objE != null && objE2 != null) {
                y1.a(j, obj, AbstractC3205m0.a(objE, objE2));
                b(i, obj);
            } else if (objE2 != null) {
                y1.a(j, obj, objE2);
                b(i, obj);
            }
        }
    }

    public static Field a(Class cls, String str) {
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

    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final Object a() {
        L0 l0 = this.l;
        E0 e0 = this.e;
        l0.getClass();
        return ((AbstractC3169a0) e0).dynamicMethod(Z.NEW_MUTABLE_INSTANCE);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final void a(Object obj, Object obj2) {
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.f2259a;
            if (i < iArr.length) {
                int i2 = iArr[i + 1];
                long j = 1048575 & i2;
                int i3 = iArr[i];
                switch ((i2 & 267386880) >>> 20) {
                    case 0:
                        if (a(i, obj2)) {
                            x1 x1Var = y1.c;
                            x1Var.a(obj, j, x1Var.c(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 1:
                        if (a(i, obj2)) {
                            x1 x1Var2 = y1.c;
                            x1Var2.a(obj, j, x1Var2.d(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 2:
                        if (a(i, obj2)) {
                            y1.a(obj, j, y1.d(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 3:
                        if (a(i, obj2)) {
                            y1.a(obj, j, y1.d(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 4:
                        if (a(i, obj2)) {
                            y1.a(obj, j, y1.c(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 5:
                        if (a(i, obj2)) {
                            y1.a(obj, j, y1.d(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 6:
                        if (a(i, obj2)) {
                            y1.a(obj, j, y1.c(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 7:
                        if (a(i, obj2)) {
                            x1 x1Var3 = y1.c;
                            x1Var3.a(obj, j, x1Var3.a(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 8:
                        if (a(i, obj2)) {
                            y1.a(j, obj, y1.e(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 9:
                        d(i, obj, obj2);
                        break;
                    case 10:
                        if (a(i, obj2)) {
                            y1.a(j, obj, y1.e(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 11:
                        if (a(i, obj2)) {
                            y1.a(obj, j, y1.c(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 12:
                        if (a(i, obj2)) {
                            y1.a(obj, j, y1.c(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 13:
                        if (a(i, obj2)) {
                            y1.a(obj, j, y1.c(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 14:
                        if (a(i, obj2)) {
                            y1.a(obj, j, y1.d(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 15:
                        if (a(i, obj2)) {
                            y1.a(obj, j, y1.c(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 16:
                        if (a(i, obj2)) {
                            y1.a(obj, j, y1.d(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 17:
                        d(i, obj, obj2);
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
                        this.m.a(j, obj, obj2);
                        break;
                    case 50:
                        A0 a0 = this.p;
                        Class cls = V0.f2271a;
                        Object objE = y1.e(obj, j);
                        Object objE2 = y1.e(obj2, j);
                        a0.getClass();
                        y1.a(j, obj, A0.a(objE, objE2));
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
                        if (a(obj2, i3, i)) {
                            y1.a(j, obj, y1.e(obj2, j));
                            b(obj, i3, i);
                        }
                        break;
                    case 60:
                        e(i, obj, obj2);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (a(obj2, i3, i)) {
                            y1.a(j, obj, y1.e(obj2, j));
                            b(obj, i3, i);
                        }
                        break;
                    case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                        e(i, obj, obj2);
                        break;
                }
                i += 3;
            } else {
                C3215p1 c3215p1 = this.n;
                Class cls2 = V0.f2271a;
                c3215p1.getClass();
                AbstractC3169a0 abstractC3169a0 = (AbstractC3169a0) obj;
                C3212o1 c3212o1A = abstractC3169a0.unknownFields;
                C3212o1 c3212o1 = ((AbstractC3169a0) obj2).unknownFields;
                if (!c3212o1.equals(C3212o1.f)) {
                    c3212o1A = C3212o1.a(c3212o1A, c3212o1);
                }
                abstractC3169a0.unknownFields = c3212o1A;
                if (this.f) {
                    this.o.getClass();
                    N n = ((GeneratedMessageLite$ExtendableMessage) obj2).extensions;
                    if (n.f2264a.isEmpty()) {
                        return;
                    }
                    ((GeneratedMessageLite$ExtendableMessage) obj).ensureExtensionsAreMutable().a(n);
                    return;
                }
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x030b  */
    /* JADX WARN: Code duplicated, block: B:101:0x031c  */
    /* JADX WARN: Code duplicated, block: B:102:0x032d  */
    /* JADX WARN: Code duplicated, block: B:103:0x033e  */
    /* JADX WARN: Code duplicated, block: B:104:0x034f  */
    /* JADX WARN: Code duplicated, block: B:105:0x0360  */
    /* JADX WARN: Code duplicated, block: B:106:0x0371  */
    /* JADX WARN: Code duplicated, block: B:107:0x0382  */
    /* JADX WARN: Code duplicated, block: B:108:0x0393  */
    /* JADX WARN: Code duplicated, block: B:109:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:110:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:111:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:112:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:113:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:114:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:115:0x040e  */
    /* JADX WARN: Code duplicated, block: B:116:0x041f  */
    /* JADX WARN: Code duplicated, block: B:117:0x0430  */
    /* JADX WARN: Code duplicated, block: B:118:0x0441  */
    /* JADX WARN: Code duplicated, block: B:119:0x0452  */
    /* JADX WARN: Code duplicated, block: B:120:0x0463  */
    /* JADX WARN: Code duplicated, block: B:121:0x0474  */
    /* JADX WARN: Code duplicated, block: B:122:0x0485  */
    /* JADX WARN: Code duplicated, block: B:123:0x0496  */
    /* JADX WARN: Code duplicated, block: B:124:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:126:0x04ad  */
    /* JADX WARN: Code duplicated, block: B:127:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:129:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:130:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:132:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:133:0x04de  */
    /* JADX WARN: Code duplicated, block: B:135:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:136:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:138:0x04f7  */
    /* JADX WARN: Code duplicated, block: B:139:0x0504  */
    /* JADX WARN: Code duplicated, block: B:141:0x050a  */
    /* JADX WARN: Code duplicated, block: B:142:0x0517  */
    /* JADX WARN: Code duplicated, block: B:144:0x051d  */
    /* JADX WARN: Code duplicated, block: B:145:0x052a  */
    /* JADX WARN: Code duplicated, block: B:147:0x0530  */
    /* JADX WARN: Code duplicated, block: B:148:0x053f  */
    /* JADX WARN: Code duplicated, block: B:150:0x0545  */
    /* JADX WARN: Code duplicated, block: B:151:0x0558  */
    /* JADX WARN: Code duplicated, block: B:153:0x055e  */
    /* JADX WARN: Code duplicated, block: B:154:0x0569  */
    /* JADX WARN: Code duplicated, block: B:156:0x056f  */
    /* JADX WARN: Code duplicated, block: B:157:0x057e  */
    /* JADX WARN: Code duplicated, block: B:159:0x0584  */
    /* JADX WARN: Code duplicated, block: B:160:0x0590  */
    /* JADX WARN: Code duplicated, block: B:162:0x0596  */
    /* JADX WARN: Code duplicated, block: B:163:0x05a2  */
    /* JADX WARN: Code duplicated, block: B:165:0x05a8  */
    /* JADX WARN: Code duplicated, block: B:166:0x05b4  */
    /* JADX WARN: Code duplicated, block: B:168:0x05ba  */
    /* JADX WARN: Code duplicated, block: B:169:0x05c6  */
    /* JADX WARN: Code duplicated, block: B:171:0x05cc  */
    /* JADX WARN: Code duplicated, block: B:172:0x05d8  */
    /* JADX WARN: Code duplicated, block: B:174:0x05de  */
    /* JADX WARN: Code duplicated, block: B:175:0x05ea  */
    /* JADX WARN: Code duplicated, block: B:177:0x05f0  */
    /* JADX WARN: Code duplicated, block: B:192:0x0643  */
    /* JADX WARN: Code duplicated, block: B:19:0x0076  */
    /* JADX WARN: Code duplicated, block: B:212:0x06a5  */
    /* JADX WARN: Code duplicated, block: B:214:0x06ab  */
    /* JADX WARN: Code duplicated, block: B:215:0x06b8  */
    /* JADX WARN: Code duplicated, block: B:217:0x06be  */
    /* JADX WARN: Code duplicated, block: B:218:0x06cd  */
    /* JADX WARN: Code duplicated, block: B:220:0x06d3  */
    /* JADX WARN: Code duplicated, block: B:221:0x06e2  */
    /* JADX WARN: Code duplicated, block: B:223:0x06e8  */
    /* JADX WARN: Code duplicated, block: B:224:0x06f9  */
    /* JADX WARN: Code duplicated, block: B:226:0x06ff  */
    /* JADX WARN: Code duplicated, block: B:227:0x0710  */
    /* JADX WARN: Code duplicated, block: B:229:0x0716  */
    /* JADX WARN: Code duplicated, block: B:230:0x0727  */
    /* JADX WARN: Code duplicated, block: B:232:0x072d  */
    /* JADX WARN: Code duplicated, block: B:233:0x073e  */
    /* JADX WARN: Code duplicated, block: B:235:0x0744  */
    /* JADX WARN: Code duplicated, block: B:236:0x0751  */
    /* JADX WARN: Code duplicated, block: B:238:0x0757  */
    /* JADX WARN: Code duplicated, block: B:239:0x0768  */
    /* JADX WARN: Code duplicated, block: B:241:0x076e  */
    /* JADX WARN: Code duplicated, block: B:242:0x0777  */
    /* JADX WARN: Code duplicated, block: B:244:0x077d  */
    /* JADX WARN: Code duplicated, block: B:245:0x078e  */
    /* JADX WARN: Code duplicated, block: B:247:0x0794  */
    /* JADX WARN: Code duplicated, block: B:248:0x07a5  */
    /* JADX WARN: Code duplicated, block: B:250:0x07ab  */
    /* JADX WARN: Code duplicated, block: B:251:0x07bc  */
    /* JADX WARN: Code duplicated, block: B:253:0x07c2  */
    /* JADX WARN: Code duplicated, block: B:254:0x07d3  */
    /* JADX WARN: Code duplicated, block: B:256:0x07d9  */
    /* JADX WARN: Code duplicated, block: B:257:0x07ea  */
    /* JADX WARN: Code duplicated, block: B:259:0x07f0  */
    /* JADX WARN: Code duplicated, block: B:260:0x0801  */
    /* JADX WARN: Code duplicated, block: B:262:0x0807  */
    /* JADX WARN: Code duplicated, block: B:263:0x0816  */
    /* JADX WARN: Code duplicated, block: B:265:0x081c  */
    /* JADX WARN: Code duplicated, block: B:266:0x082b  */
    /* JADX WARN: Code duplicated, block: B:271:0x0845  */
    /* JADX WARN: Code duplicated, block: B:272:0x0858  */
    /* JADX WARN: Code duplicated, block: B:273:0x0867  */
    /* JADX WARN: Code duplicated, block: B:274:0x0876  */
    /* JADX WARN: Code duplicated, block: B:275:0x0885  */
    /* JADX WARN: Code duplicated, block: B:276:0x0894  */
    /* JADX WARN: Code duplicated, block: B:277:0x08a3  */
    /* JADX WARN: Code duplicated, block: B:278:0x08b2  */
    /* JADX WARN: Code duplicated, block: B:279:0x08c1  */
    /* JADX WARN: Code duplicated, block: B:280:0x08d0  */
    /* JADX WARN: Code duplicated, block: B:281:0x08df  */
    /* JADX WARN: Code duplicated, block: B:282:0x08ee  */
    /* JADX WARN: Code duplicated, block: B:283:0x08fd  */
    /* JADX WARN: Code duplicated, block: B:284:0x090c  */
    /* JADX WARN: Code duplicated, block: B:285:0x091b  */
    /* JADX WARN: Code duplicated, block: B:286:0x092a  */
    /* JADX WARN: Code duplicated, block: B:287:0x0939  */
    /* JADX WARN: Code duplicated, block: B:288:0x0948  */
    /* JADX WARN: Code duplicated, block: B:289:0x0957  */
    /* JADX WARN: Code duplicated, block: B:290:0x0966  */
    /* JADX WARN: Code duplicated, block: B:291:0x0975  */
    /* JADX WARN: Code duplicated, block: B:293:0x0986  */
    /* JADX WARN: Code duplicated, block: B:294:0x0994  */
    /* JADX WARN: Code duplicated, block: B:295:0x09a6  */
    /* JADX WARN: Code duplicated, block: B:296:0x09b3  */
    /* JADX WARN: Code duplicated, block: B:297:0x09b6  */
    /* JADX WARN: Code duplicated, block: B:298:0x09c6  */
    /* JADX WARN: Code duplicated, block: B:299:0x09d6  */
    /* JADX WARN: Code duplicated, block: B:300:0x09e6  */
    /* JADX WARN: Code duplicated, block: B:301:0x09f6  */
    /* JADX WARN: Code duplicated, block: B:302:0x0a06  */
    /* JADX WARN: Code duplicated, block: B:303:0x0a16  */
    /* JADX WARN: Code duplicated, block: B:304:0x0a26  */
    /* JADX WARN: Code duplicated, block: B:305:0x0a36  */
    /* JADX WARN: Code duplicated, block: B:307:0x0a3b  */
    /* JADX WARN: Code duplicated, block: B:308:0x0a48  */
    /* JADX WARN: Code duplicated, block: B:310:0x0a4d  */
    /* JADX WARN: Code duplicated, block: B:311:0x0a56  */
    /* JADX WARN: Code duplicated, block: B:313:0x0a5b  */
    /* JADX WARN: Code duplicated, block: B:314:0x0a64  */
    /* JADX WARN: Code duplicated, block: B:316:0x0a69  */
    /* JADX WARN: Code duplicated, block: B:317:0x0a74  */
    /* JADX WARN: Code duplicated, block: B:319:0x0a79  */
    /* JADX WARN: Code duplicated, block: B:320:0x0a84  */
    /* JADX WARN: Code duplicated, block: B:322:0x0a89  */
    /* JADX WARN: Code duplicated, block: B:323:0x0a94  */
    /* JADX WARN: Code duplicated, block: B:325:0x0a99  */
    /* JADX WARN: Code duplicated, block: B:326:0x0aa4  */
    /* JADX WARN: Code duplicated, block: B:328:0x0aa9  */
    /* JADX WARN: Code duplicated, block: B:329:0x0ab6  */
    /* JADX WARN: Code duplicated, block: B:331:0x0abb  */
    /* JADX WARN: Code duplicated, block: B:332:0x0acc  */
    /* JADX WARN: Code duplicated, block: B:334:0x0ad1  */
    /* JADX WARN: Code duplicated, block: B:335:0x0ada  */
    /* JADX WARN: Code duplicated, block: B:337:0x0adf  */
    /* JADX WARN: Code duplicated, block: B:338:0x0aeb  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:340:0x0af0  */
    /* JADX WARN: Code duplicated, block: B:341:0x0afa  */
    /* JADX WARN: Code duplicated, block: B:343:0x0aff  */
    /* JADX WARN: Code duplicated, block: B:344:0x0b09  */
    /* JADX WARN: Code duplicated, block: B:346:0x0b0e  */
    /* JADX WARN: Code duplicated, block: B:347:0x0b18  */
    /* JADX WARN: Code duplicated, block: B:349:0x0b1d  */
    /* JADX WARN: Code duplicated, block: B:350:0x0b27  */
    /* JADX WARN: Code duplicated, block: B:352:0x0b2c  */
    /* JADX WARN: Code duplicated, block: B:353:0x0b36  */
    /* JADX WARN: Code duplicated, block: B:355:0x0b3b  */
    /* JADX WARN: Code duplicated, block: B:356:0x0b45  */
    /* JADX WARN: Code duplicated, block: B:358:0x0b4a  */
    /* JADX WARN: Code duplicated, block: B:35:0x00be  */
    /* JADX WARN: Code duplicated, block: B:368:0x026d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:370:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:372:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:374:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:376:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:378:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:380:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:382:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:384:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:386:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:388:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:390:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:392:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:394:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:396:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:398:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:400:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:402:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:404:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:438:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:440:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:442:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:444:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:446:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:448:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0101  */
    /* JADX WARN: Code duplicated, block: B:450:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:452:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:454:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:456:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:458:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0114  */
    /* JADX WARN: Code duplicated, block: B:460:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:462:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:464:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:466:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:468:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:470:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:472:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:473:0x05fb A[DONT_GENERATE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:474:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x011a  */
    /* JADX WARN: Code duplicated, block: B:488:0x0833 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x012d  */
    /* JADX WARN: Code duplicated, block: B:501:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:503:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:505:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:507:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:509:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x0133  */
    /* JADX WARN: Code duplicated, block: B:511:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:513:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:515:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:517:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:519:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0146  */
    /* JADX WARN: Code duplicated, block: B:521:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:523:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:525:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:527:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:529:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:531:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:533:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:535:0x0b53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x014c  */
    /* JADX WARN: Code duplicated, block: B:54:0x015f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0165  */
    /* JADX WARN: Code duplicated, block: B:57:0x0174  */
    /* JADX WARN: Code duplicated, block: B:59:0x017a  */
    /* JADX WARN: Code duplicated, block: B:60:0x018d  */
    /* JADX WARN: Code duplicated, block: B:62:0x0193  */
    /* JADX WARN: Code duplicated, block: B:63:0x019e  */
    /* JADX WARN: Code duplicated, block: B:65:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:66:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:68:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:69:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:72:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:74:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:75:0x0202  */
    /* JADX WARN: Code duplicated, block: B:77:0x0208  */
    /* JADX WARN: Code duplicated, block: B:78:0x021b  */
    /* JADX WARN: Code duplicated, block: B:80:0x0221  */
    /* JADX WARN: Code duplicated, block: B:81:0x0234  */
    /* JADX WARN: Code duplicated, block: B:83:0x023a  */
    /* JADX WARN: Code duplicated, block: B:84:0x024b  */
    /* JADX WARN: Code duplicated, block: B:86:0x0251  */
    /* JADX WARN: Code duplicated, block: B:87:0x0262  */
    /* JADX WARN: Code duplicated, block: B:92:0x027f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0294  */
    /* JADX WARN: Code duplicated, block: B:94:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:95:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:96:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:97:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:98:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:99:0x02fa  */
    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final void a(Object obj, C c) {
        Iterator itD;
        Map.Entry entry;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2;
        Map.Entry entry2;
        Iterator x0;
        c.getClass();
        int i3 = 267386880;
        int i4 = 1048575;
        if (R1.ASCENDING == R1.DESCENDING) {
            this.n.getClass();
            ((AbstractC3169a0) obj).unknownFields.a(c);
            if (this.f) {
                this.o.getClass();
                N n = ((GeneratedMessageLite$ExtendableMessage) obj).extensions;
                if (n.f2264a.isEmpty()) {
                    entry2 = null;
                    x0 = null;
                } else {
                    if (n.c) {
                        AbstractC3185f1 abstractC3185f1 = n.f2264a;
                        if (abstractC3185f1.g == null) {
                            abstractC3185f1.g = new Y0(abstractC3185f1);
                        }
                        x0 = new C3214p0(new X0(abstractC3185f1.g.b));
                    } else {
                        AbstractC3185f1 abstractC3185f2 = n.f2264a;
                        if (abstractC3185f2.g == null) {
                            abstractC3185f2.g = new Y0(abstractC3185f2);
                        }
                        x0 = new X0(abstractC3185f2.g.b);
                    }
                    entry2 = (Map.Entry) x0.next();
                }
            } else {
                entry2 = null;
                x0 = null;
            }
            for (int length = this.f2259a.length - 3; length >= 0; length -= 3) {
                int[] iArr = this.f2259a;
                int i5 = iArr[length + 1];
                int i6 = iArr[length];
                while (entry2 != null) {
                    this.o.getClass();
                    if (((X) entry2.getKey()).b > i6) {
                        this.o.getClass();
                        J.a(c, entry2);
                        entry2 = x0.hasNext() ? (Map.Entry) x0.next() : null;
                    } else {
                        switch ((i5 & 267386880) >>> 20) {
                            case 0:
                                if (a(length, obj)) {
                                    c.a(i6, y1.c.c(obj, i5 & 1048575));
                                }
                                break;
                            case 1:
                                if (a(length, obj)) {
                                    c.a(i6, y1.c.d(obj, i5 & 1048575));
                                }
                                break;
                            case 2:
                                if (a(length, obj)) {
                                    c.f2252a.b(i6, y1.d(obj, i5 & 1048575));
                                }
                                break;
                            case 3:
                                if (a(length, obj)) {
                                    c.f2252a.b(i6, y1.d(obj, i5 & 1048575));
                                }
                                break;
                            case 4:
                                if (a(length, obj)) {
                                    c.f2252a.b(i6, y1.c(obj, i5 & 1048575));
                                }
                                break;
                            case 5:
                                if (a(length, obj)) {
                                    c.f2252a.a(i6, y1.d(obj, i5 & 1048575));
                                }
                                break;
                            case 6:
                                if (a(length, obj)) {
                                    c.f2252a.a(i6, y1.c(obj, i5 & 1048575));
                                }
                                break;
                            case 7:
                                if (a(length, obj)) {
                                    c.f2252a.a(i6, y1.c.a(obj, i5 & 1048575));
                                }
                                break;
                            case 8:
                                if (a(length, obj)) {
                                    a(i6, y1.e(obj, i5 & 1048575), c);
                                }
                                break;
                            case 9:
                                if (a(length, obj)) {
                                    c.f2252a.a(i6, (E0) y1.e(obj, i5 & 1048575), c(length));
                                }
                                break;
                            case 10:
                                if (a(length, obj)) {
                                    c.f2252a.a(i6, (AbstractC3221s) y1.e(obj, i5 & 1048575));
                                }
                                break;
                            case 11:
                                if (a(length, obj)) {
                                    c.f2252a.d(i6, y1.c(obj, i5 & 1048575));
                                }
                                break;
                            case 12:
                                if (a(length, obj)) {
                                    c.f2252a.b(i6, y1.c(obj, i5 & 1048575));
                                }
                                break;
                            case 13:
                                if (a(length, obj)) {
                                    c.f2252a.a(i6, y1.c(obj, i5 & 1048575));
                                }
                                break;
                            case 14:
                                if (a(length, obj)) {
                                    c.f2252a.a(i6, y1.d(obj, i5 & 1048575));
                                }
                                break;
                            case 15:
                                if (a(length, obj)) {
                                    c.a(i6, y1.c(obj, i5 & 1048575));
                                }
                                break;
                            case 16:
                                if (a(length, obj)) {
                                    c.a(i6, y1.d(obj, i5 & 1048575));
                                }
                                break;
                            case 17:
                                if (a(length, obj)) {
                                    c.a(i6, y1.e(obj, i5 & 1048575), c(length));
                                }
                                break;
                            case 18:
                                V0.b(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                                break;
                            case 19:
                                V0.f(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                                break;
                            case 20:
                                V0.h(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                                break;
                            case 21:
                                V0.n(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                                break;
                            case 22:
                                V0.g(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                                break;
                            case 23:
                                V0.e(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                                break;
                            case 24:
                                V0.d(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                                break;
                            case 25:
                                V0.a(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                                break;
                            case 26:
                                V0.b(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c);
                                break;
                            case 27:
                                V0.b(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, c(length));
                                break;
                            case 28:
                                V0.a(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c);
                                break;
                            case 29:
                                V0.m(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                                break;
                            case 30:
                                V0.c(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                                break;
                            case 31:
                                V0.i(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                                break;
                            case 32:
                                V0.j(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                                break;
                            case 33:
                                V0.k(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                                break;
                            case 34:
                                V0.l(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                                break;
                            case 35:
                                V0.b(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                                break;
                            case 36:
                                V0.f(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                                break;
                            case 37:
                                V0.h(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                                break;
                            case 38:
                                V0.n(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                                break;
                            case 39:
                                V0.g(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                                break;
                            case 40:
                                V0.e(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                                break;
                            case 41:
                                V0.d(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                                break;
                            case 42:
                                V0.a(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                                break;
                            case 43:
                                V0.m(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                                break;
                            case 44:
                                V0.c(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                                break;
                            case 45:
                                V0.i(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                                break;
                            case 46:
                                V0.j(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                                break;
                            case 47:
                                V0.k(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                                break;
                            case 48:
                                V0.l(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                                break;
                            case 49:
                                V0.a(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, c(length));
                                break;
                            case 50:
                                if (y1.e(obj, i5 & 1048575) == null) {
                                    A0 a0 = this.p;
                                    Object objB = b(length);
                                    a0.getClass();
                                    objB.getClass();
                                    throw new ClassCastException();
                                }
                                break;
                                break;
                            case 51:
                                if (a(obj, i6, length)) {
                                    c.a(i6, ((Double) y1.e(obj, i5 & 1048575)).doubleValue());
                                }
                                break;
                            case 52:
                                if (a(obj, i6, length)) {
                                    c.a(i6, ((Float) y1.e(obj, i5 & 1048575)).floatValue());
                                }
                                break;
                            case 53:
                                if (a(obj, i6, length)) {
                                    c.f2252a.b(i6, ((Long) y1.e(obj, i5 & 1048575)).longValue());
                                }
                                break;
                            case 54:
                                if (a(obj, i6, length)) {
                                    c.f2252a.b(i6, ((Long) y1.e(obj, i5 & 1048575)).longValue());
                                }
                                break;
                            case 55:
                                if (a(obj, i6, length)) {
                                    c.f2252a.b(i6, ((Integer) y1.e(obj, i5 & 1048575)).intValue());
                                }
                                break;
                            case 56:
                                if (a(obj, i6, length)) {
                                    c.f2252a.a(i6, ((Long) y1.e(obj, i5 & 1048575)).longValue());
                                }
                                break;
                            case 57:
                                if (a(obj, i6, length)) {
                                    c.f2252a.a(i6, ((Integer) y1.e(obj, i5 & 1048575)).intValue());
                                }
                                break;
                            case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                                if (a(obj, i6, length)) {
                                    c.f2252a.a(i6, ((Boolean) y1.e(obj, i5 & 1048575)).booleanValue());
                                }
                                break;
                            case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                                if (a(obj, i6, length)) {
                                    a(i6, y1.e(obj, i5 & 1048575), c);
                                }
                                break;
                            case 60:
                                if (a(obj, i6, length)) {
                                    c.f2252a.a(i6, (E0) y1.e(obj, i5 & 1048575), c(length));
                                }
                                break;
                            case 61:
                                if (a(obj, i6, length)) {
                                    c.f2252a.a(i6, (AbstractC3221s) y1.e(obj, i5 & 1048575));
                                }
                                break;
                            case 62:
                                if (a(obj, i6, length)) {
                                    c.f2252a.d(i6, ((Integer) y1.e(obj, i5 & 1048575)).intValue());
                                }
                                break;
                            case 63:
                                if (a(obj, i6, length)) {
                                    c.f2252a.b(i6, ((Integer) y1.e(obj, i5 & 1048575)).intValue());
                                }
                                break;
                            case 64:
                                if (a(obj, i6, length)) {
                                    c.f2252a.a(i6, ((Integer) y1.e(obj, i5 & 1048575)).intValue());
                                }
                                break;
                            case 65:
                                if (a(obj, i6, length)) {
                                    c.f2252a.a(i6, ((Long) y1.e(obj, i5 & 1048575)).longValue());
                                }
                                break;
                            case 66:
                                if (a(obj, i6, length)) {
                                    c.a(i6, ((Integer) y1.e(obj, i5 & 1048575)).intValue());
                                }
                                break;
                            case 67:
                                if (a(obj, i6, length)) {
                                    c.a(i6, ((Long) y1.e(obj, i5 & 1048575)).longValue());
                                }
                                break;
                            case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                                if (a(obj, i6, length)) {
                                    c.a(i6, y1.e(obj, i5 & 1048575), c(length));
                                }
                                break;
                        }
                    }
                }
                switch ((i5 & 267386880) >>> 20) {
                    case 0:
                        if (a(length, obj)) {
                            c.a(i6, y1.c.c(obj, i5 & 1048575));
                        }
                        break;
                    case 1:
                        if (a(length, obj)) {
                            c.a(i6, y1.c.d(obj, i5 & 1048575));
                        }
                        break;
                    case 2:
                        if (a(length, obj)) {
                            c.f2252a.b(i6, y1.d(obj, i5 & 1048575));
                        }
                        break;
                    case 3:
                        if (a(length, obj)) {
                            c.f2252a.b(i6, y1.d(obj, i5 & 1048575));
                        }
                        break;
                    case 4:
                        if (a(length, obj)) {
                            c.f2252a.b(i6, y1.c(obj, i5 & 1048575));
                        }
                        break;
                    case 5:
                        if (a(length, obj)) {
                            c.f2252a.a(i6, y1.d(obj, i5 & 1048575));
                        }
                        break;
                    case 6:
                        if (a(length, obj)) {
                            c.f2252a.a(i6, y1.c(obj, i5 & 1048575));
                        }
                        break;
                    case 7:
                        if (a(length, obj)) {
                            c.f2252a.a(i6, y1.c.a(obj, i5 & 1048575));
                        }
                        break;
                    case 8:
                        if (a(length, obj)) {
                            a(i6, y1.e(obj, i5 & 1048575), c);
                        }
                        break;
                    case 9:
                        if (a(length, obj)) {
                            c.f2252a.a(i6, (E0) y1.e(obj, i5 & 1048575), c(length));
                        }
                        break;
                    case 10:
                        if (a(length, obj)) {
                            c.f2252a.a(i6, (AbstractC3221s) y1.e(obj, i5 & 1048575));
                        }
                        break;
                    case 11:
                        if (a(length, obj)) {
                            c.f2252a.d(i6, y1.c(obj, i5 & 1048575));
                        }
                        break;
                    case 12:
                        if (a(length, obj)) {
                            c.f2252a.b(i6, y1.c(obj, i5 & 1048575));
                        }
                        break;
                    case 13:
                        if (a(length, obj)) {
                            c.f2252a.a(i6, y1.c(obj, i5 & 1048575));
                        }
                        break;
                    case 14:
                        if (a(length, obj)) {
                            c.f2252a.a(i6, y1.d(obj, i5 & 1048575));
                        }
                        break;
                    case 15:
                        if (a(length, obj)) {
                            c.a(i6, y1.c(obj, i5 & 1048575));
                        }
                        break;
                    case 16:
                        if (a(length, obj)) {
                            c.a(i6, y1.d(obj, i5 & 1048575));
                        }
                        break;
                    case 17:
                        if (a(length, obj)) {
                            c.a(i6, y1.e(obj, i5 & 1048575), c(length));
                        }
                        break;
                    case 18:
                        V0.b(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                        break;
                    case 19:
                        V0.f(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                        break;
                    case 20:
                        V0.h(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                        break;
                    case 21:
                        V0.n(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                        break;
                    case 22:
                        V0.g(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                        break;
                    case 23:
                        V0.e(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                        break;
                    case 24:
                        V0.d(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                        break;
                    case 25:
                        V0.a(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                        break;
                    case 26:
                        V0.b(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c);
                        break;
                    case 27:
                        V0.b(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, c(length));
                        break;
                    case 28:
                        V0.a(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c);
                        break;
                    case 29:
                        V0.m(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                        break;
                    case 30:
                        V0.c(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                        break;
                    case 31:
                        V0.i(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                        break;
                    case 32:
                        V0.j(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                        break;
                    case 33:
                        V0.k(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                        break;
                    case 34:
                        V0.l(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, false);
                        break;
                    case 35:
                        V0.b(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                        break;
                    case 36:
                        V0.f(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                        break;
                    case 37:
                        V0.h(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                        break;
                    case 38:
                        V0.n(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                        break;
                    case 39:
                        V0.g(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                        break;
                    case 40:
                        V0.e(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                        break;
                    case 41:
                        V0.d(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                        break;
                    case 42:
                        V0.a(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                        break;
                    case 43:
                        V0.m(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                        break;
                    case 44:
                        V0.c(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                        break;
                    case 45:
                        V0.i(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                        break;
                    case 46:
                        V0.j(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                        break;
                    case 47:
                        V0.k(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                        break;
                    case 48:
                        V0.l(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, true);
                        break;
                    case 49:
                        V0.a(this.f2259a[length], (List) y1.e(obj, i5 & 1048575), c, c(length));
                        break;
                    case 50:
                        if (y1.e(obj, i5 & 1048575) == null) {
                            A0 a1 = this.p;
                            Object objB2 = b(length);
                            a1.getClass();
                            objB2.getClass();
                            throw new ClassCastException();
                        }
                        break;
                        break;
                    case 51:
                        if (a(obj, i6, length)) {
                            c.a(i6, ((Double) y1.e(obj, i5 & 1048575)).doubleValue());
                        }
                        break;
                    case 52:
                        if (a(obj, i6, length)) {
                            c.a(i6, ((Float) y1.e(obj, i5 & 1048575)).floatValue());
                        }
                        break;
                    case 53:
                        if (a(obj, i6, length)) {
                            c.f2252a.b(i6, ((Long) y1.e(obj, i5 & 1048575)).longValue());
                        }
                        break;
                    case 54:
                        if (a(obj, i6, length)) {
                            c.f2252a.b(i6, ((Long) y1.e(obj, i5 & 1048575)).longValue());
                        }
                        break;
                    case 55:
                        if (a(obj, i6, length)) {
                            c.f2252a.b(i6, ((Integer) y1.e(obj, i5 & 1048575)).intValue());
                        }
                        break;
                    case 56:
                        if (a(obj, i6, length)) {
                            c.f2252a.a(i6, ((Long) y1.e(obj, i5 & 1048575)).longValue());
                        }
                        break;
                    case 57:
                        if (a(obj, i6, length)) {
                            c.f2252a.a(i6, ((Integer) y1.e(obj, i5 & 1048575)).intValue());
                        }
                        break;
                    case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                        if (a(obj, i6, length)) {
                            c.f2252a.a(i6, ((Boolean) y1.e(obj, i5 & 1048575)).booleanValue());
                        }
                        break;
                    case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                        if (a(obj, i6, length)) {
                            a(i6, y1.e(obj, i5 & 1048575), c);
                        }
                        break;
                    case 60:
                        if (a(obj, i6, length)) {
                            c.f2252a.a(i6, (E0) y1.e(obj, i5 & 1048575), c(length));
                        }
                        break;
                    case 61:
                        if (a(obj, i6, length)) {
                            c.f2252a.a(i6, (AbstractC3221s) y1.e(obj, i5 & 1048575));
                        }
                        break;
                    case 62:
                        if (a(obj, i6, length)) {
                            c.f2252a.d(i6, ((Integer) y1.e(obj, i5 & 1048575)).intValue());
                        }
                        break;
                    case 63:
                        if (a(obj, i6, length)) {
                            c.f2252a.b(i6, ((Integer) y1.e(obj, i5 & 1048575)).intValue());
                        }
                        break;
                    case 64:
                        if (a(obj, i6, length)) {
                            c.f2252a.a(i6, ((Integer) y1.e(obj, i5 & 1048575)).intValue());
                        }
                        break;
                    case 65:
                        if (a(obj, i6, length)) {
                            c.f2252a.a(i6, ((Long) y1.e(obj, i5 & 1048575)).longValue());
                        }
                        break;
                    case 66:
                        if (a(obj, i6, length)) {
                            c.a(i6, ((Integer) y1.e(obj, i5 & 1048575)).intValue());
                        }
                        break;
                    case 67:
                        if (a(obj, i6, length)) {
                            c.a(i6, ((Long) y1.e(obj, i5 & 1048575)).longValue());
                        }
                        break;
                    case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                        if (a(obj, i6, length)) {
                            c.a(i6, y1.e(obj, i5 & 1048575), c(length));
                        }
                        break;
                }
            }
            while (entry2 != null) {
                this.o.getClass();
                J.a(c, entry2);
                entry2 = x0.hasNext() ? (Map.Entry) x0.next() : null;
            }
            return;
        }
        if (this.h) {
            b(obj, c);
            return;
        }
        if (this.f) {
            this.o.getClass();
            N n2 = ((GeneratedMessageLite$ExtendableMessage) obj).extensions;
            if (n2.f2264a.isEmpty()) {
                itD = null;
                entry = null;
            } else {
                itD = n2.d();
                entry = (Map.Entry) itD.next();
            }
        } else {
            itD = null;
            entry = null;
        }
        int length2 = this.f2259a.length;
        Unsafe unsafe = r;
        int i7 = 0;
        int i8 = 0;
        int i9 = 1048575;
        while (i7 < length2) {
            int[] iArr2 = this.f2259a;
            int i10 = iArr2[i7 + 1];
            int i11 = iArr2[i7];
            int i12 = (i10 & i3) >>> 20;
            if (i12 <= 17) {
                int i13 = iArr2[i7 + 2];
                int i14 = i13 & i4;
                if (i14 != i9) {
                    i8 = unsafe.getInt(obj, i14);
                    i9 = i14;
                }
                i = 1 << (i13 >>> 20);
            } else {
                i = 0;
            }
            while (entry != null) {
                this.o.getClass();
                if (((X) entry.getKey()).b <= i11) {
                    this.o.getClass();
                    J.a(c, entry);
                    entry = itD.hasNext() ? (Map.Entry) itD.next() : null;
                } else {
                    i2 = length2;
                    j = i10 & i4;
                    switch (i12) {
                        case 0:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.a(i11, y1.c.c(obj, j));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 1:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.a(i11, y1.c.d(obj, j));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 2:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.f2252a.b(i11, unsafe.getLong(obj, j));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 3:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.f2252a.b(i11, unsafe.getLong(obj, j));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 4:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.f2252a.b(i11, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 5:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.f2252a.a(i11, unsafe.getLong(obj, j));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 6:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.f2252a.a(i11, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 7:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.f2252a.a(i11, y1.c.a(obj, j));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 8:
                            z = false;
                            if ((i8 & i) != 0) {
                                a(i11, unsafe.getObject(obj, j), c);
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 9:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.f2252a.a(i11, (E0) unsafe.getObject(obj, j), c(i7));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 10:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.f2252a.a(i11, (AbstractC3221s) unsafe.getObject(obj, j));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 11:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.f2252a.d(i11, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 12:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.f2252a.b(i11, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 13:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.f2252a.a(i11, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 14:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.f2252a.a(i11, unsafe.getLong(obj, j));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 15:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.a(i11, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 16:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.a(i11, unsafe.getLong(obj, j));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 17:
                            z = false;
                            if ((i8 & i) != 0) {
                                c.a(i11, unsafe.getObject(obj, j), c(i7));
                            }
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 18:
                            z = false;
                            V0.b(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 19:
                            z = false;
                            V0.f(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 20:
                            z = false;
                            V0.h(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 21:
                            z = false;
                            V0.n(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 22:
                            z = false;
                            V0.g(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 23:
                            z = false;
                            V0.e(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 24:
                            z = false;
                            V0.d(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 25:
                            z = false;
                            V0.a(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 26:
                            V0.b(this.f2259a[i7], (List) unsafe.getObject(obj, j), c);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 27:
                            V0.b(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, c(i7));
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 28:
                            V0.a(this.f2259a[i7], (List) unsafe.getObject(obj, j), c);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 29:
                            z2 = false;
                            V0.m(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                            z = z2;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 30:
                            z2 = false;
                            V0.c(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                            z = z2;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 31:
                            z2 = false;
                            V0.i(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                            z = z2;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 32:
                            z2 = false;
                            V0.j(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                            z = z2;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 33:
                            z2 = false;
                            V0.k(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                            z = z2;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 34:
                            z2 = false;
                            V0.l(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                            z = z2;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 35:
                            V0.b(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 36:
                            V0.f(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 37:
                            V0.h(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 38:
                            V0.n(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 39:
                            V0.g(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 40:
                            V0.e(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 41:
                            V0.d(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 42:
                            V0.a(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 43:
                            V0.m(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 44:
                            V0.c(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 45:
                            V0.i(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 46:
                            V0.j(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 47:
                            V0.k(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 48:
                            V0.l(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 49:
                            V0.a(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, c(i7));
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 50:
                            if (unsafe.getObject(obj, j) != null) {
                                A0 a2 = this.p;
                                Object objB3 = b(i7);
                                a2.getClass();
                                objB3.getClass();
                                throw new ClassCastException();
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 51:
                            if (a(obj, i11, i7)) {
                                c.a(i11, ((Double) y1.e(obj, j)).doubleValue());
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 52:
                            if (a(obj, i11, i7)) {
                                c.a(i11, ((Float) y1.e(obj, j)).floatValue());
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 53:
                            if (a(obj, i11, i7)) {
                                c.f2252a.b(i11, ((Long) y1.e(obj, j)).longValue());
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 54:
                            if (a(obj, i11, i7)) {
                                c.f2252a.b(i11, ((Long) y1.e(obj, j)).longValue());
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 55:
                            if (a(obj, i11, i7)) {
                                c.f2252a.b(i11, ((Integer) y1.e(obj, j)).intValue());
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 56:
                            if (a(obj, i11, i7)) {
                                c.f2252a.a(i11, ((Long) y1.e(obj, j)).longValue());
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 57:
                            if (a(obj, i11, i7)) {
                                c.f2252a.a(i11, ((Integer) y1.e(obj, j)).intValue());
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                            if (a(obj, i11, i7)) {
                                c.f2252a.a(i11, ((Boolean) y1.e(obj, j)).booleanValue());
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                            if (a(obj, i11, i7)) {
                                a(i11, unsafe.getObject(obj, j), c);
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 60:
                            if (a(obj, i11, i7)) {
                                c.f2252a.a(i11, (E0) unsafe.getObject(obj, j), c(i7));
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 61:
                            if (a(obj, i11, i7)) {
                                c.f2252a.a(i11, (AbstractC3221s) unsafe.getObject(obj, j));
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 62:
                            if (a(obj, i11, i7)) {
                                c.f2252a.d(i11, ((Integer) y1.e(obj, j)).intValue());
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 63:
                            if (a(obj, i11, i7)) {
                                c.f2252a.b(i11, ((Integer) y1.e(obj, j)).intValue());
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 64:
                            if (a(obj, i11, i7)) {
                                c.f2252a.a(i11, ((Integer) y1.e(obj, j)).intValue());
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 65:
                            if (a(obj, i11, i7)) {
                                c.f2252a.a(i11, ((Long) y1.e(obj, j)).longValue());
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 66:
                            if (a(obj, i11, i7)) {
                                c.a(i11, ((Integer) y1.e(obj, j)).intValue());
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case 67:
                            if (a(obj, i11, i7)) {
                                c.a(i11, ((Long) y1.e(obj, j)).longValue());
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                            if (a(obj, i11, i7)) {
                                c.a(i11, unsafe.getObject(obj, j), c(i7));
                            }
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                        default:
                            z = false;
                            i7 += 3;
                            length2 = i2;
                            i3 = 267386880;
                            i4 = 1048575;
                            break;
                    }
                }
            }
            i2 = length2;
            j = i10 & i4;
            switch (i12) {
                case 0:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.a(i11, y1.c.c(obj, j));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 1:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.a(i11, y1.c.d(obj, j));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 2:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.f2252a.b(i11, unsafe.getLong(obj, j));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 3:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.f2252a.b(i11, unsafe.getLong(obj, j));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 4:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.f2252a.b(i11, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 5:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.f2252a.a(i11, unsafe.getLong(obj, j));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 6:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.f2252a.a(i11, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 7:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.f2252a.a(i11, y1.c.a(obj, j));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 8:
                    z = false;
                    if ((i8 & i) != 0) {
                        a(i11, unsafe.getObject(obj, j), c);
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 9:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.f2252a.a(i11, (E0) unsafe.getObject(obj, j), c(i7));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 10:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.f2252a.a(i11, (AbstractC3221s) unsafe.getObject(obj, j));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 11:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.f2252a.d(i11, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 12:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.f2252a.b(i11, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 13:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.f2252a.a(i11, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 14:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.f2252a.a(i11, unsafe.getLong(obj, j));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 15:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.a(i11, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 16:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.a(i11, unsafe.getLong(obj, j));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 17:
                    z = false;
                    if ((i8 & i) != 0) {
                        c.a(i11, unsafe.getObject(obj, j), c(i7));
                    }
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 18:
                    z = false;
                    V0.b(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 19:
                    z = false;
                    V0.f(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 20:
                    z = false;
                    V0.h(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 21:
                    z = false;
                    V0.n(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 22:
                    z = false;
                    V0.g(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 23:
                    z = false;
                    V0.e(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 24:
                    z = false;
                    V0.d(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 25:
                    z = false;
                    V0.a(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 26:
                    V0.b(this.f2259a[i7], (List) unsafe.getObject(obj, j), c);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 27:
                    V0.b(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, c(i7));
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 28:
                    V0.a(this.f2259a[i7], (List) unsafe.getObject(obj, j), c);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 29:
                    z2 = false;
                    V0.m(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                    z = z2;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 30:
                    z2 = false;
                    V0.c(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                    z = z2;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 31:
                    z2 = false;
                    V0.i(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                    z = z2;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 32:
                    z2 = false;
                    V0.j(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                    z = z2;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 33:
                    z2 = false;
                    V0.k(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                    z = z2;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 34:
                    z2 = false;
                    V0.l(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, false);
                    z = z2;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 35:
                    V0.b(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 36:
                    V0.f(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 37:
                    V0.h(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 38:
                    V0.n(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 39:
                    V0.g(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 40:
                    V0.e(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 41:
                    V0.d(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 42:
                    V0.a(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 43:
                    V0.m(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 44:
                    V0.c(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 45:
                    V0.i(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 46:
                    V0.j(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 47:
                    V0.k(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 48:
                    V0.l(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, true);
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 49:
                    V0.a(this.f2259a[i7], (List) unsafe.getObject(obj, j), c, c(i7));
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        A0 a3 = this.p;
                        Object objB4 = b(i7);
                        a3.getClass();
                        objB4.getClass();
                        throw new ClassCastException();
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 51:
                    if (a(obj, i11, i7)) {
                        c.a(i11, ((Double) y1.e(obj, j)).doubleValue());
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 52:
                    if (a(obj, i11, i7)) {
                        c.a(i11, ((Float) y1.e(obj, j)).floatValue());
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 53:
                    if (a(obj, i11, i7)) {
                        c.f2252a.b(i11, ((Long) y1.e(obj, j)).longValue());
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 54:
                    if (a(obj, i11, i7)) {
                        c.f2252a.b(i11, ((Long) y1.e(obj, j)).longValue());
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 55:
                    if (a(obj, i11, i7)) {
                        c.f2252a.b(i11, ((Integer) y1.e(obj, j)).intValue());
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 56:
                    if (a(obj, i11, i7)) {
                        c.f2252a.a(i11, ((Long) y1.e(obj, j)).longValue());
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 57:
                    if (a(obj, i11, i7)) {
                        c.f2252a.a(i11, ((Integer) y1.e(obj, j)).intValue());
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    if (a(obj, i11, i7)) {
                        c.f2252a.a(i11, ((Boolean) y1.e(obj, j)).booleanValue());
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    if (a(obj, i11, i7)) {
                        a(i11, unsafe.getObject(obj, j), c);
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 60:
                    if (a(obj, i11, i7)) {
                        c.f2252a.a(i11, (E0) unsafe.getObject(obj, j), c(i7));
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 61:
                    if (a(obj, i11, i7)) {
                        c.f2252a.a(i11, (AbstractC3221s) unsafe.getObject(obj, j));
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 62:
                    if (a(obj, i11, i7)) {
                        c.f2252a.d(i11, ((Integer) y1.e(obj, j)).intValue());
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 63:
                    if (a(obj, i11, i7)) {
                        c.f2252a.b(i11, ((Integer) y1.e(obj, j)).intValue());
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 64:
                    if (a(obj, i11, i7)) {
                        c.f2252a.a(i11, ((Integer) y1.e(obj, j)).intValue());
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 65:
                    if (a(obj, i11, i7)) {
                        c.f2252a.a(i11, ((Long) y1.e(obj, j)).longValue());
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 66:
                    if (a(obj, i11, i7)) {
                        c.a(i11, ((Integer) y1.e(obj, j)).intValue());
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case 67:
                    if (a(obj, i11, i7)) {
                        c.a(i11, ((Long) y1.e(obj, j)).longValue());
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    if (a(obj, i11, i7)) {
                        c.a(i11, unsafe.getObject(obj, j), c(i7));
                    }
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
                default:
                    z = false;
                    i7 += 3;
                    length2 = i2;
                    i3 = 267386880;
                    i4 = 1048575;
                    break;
            }
        }
        while (entry != null) {
            this.o.getClass();
            J.a(c, entry);
            entry = itD.hasNext() ? (Map.Entry) itD.next() : null;
        }
        this.n.getClass();
        ((AbstractC3169a0) obj).unknownFields.a(c);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0388  */
    /* JADX WARN: Code duplicated, block: B:101:0x0399  */
    /* JADX WARN: Code duplicated, block: B:102:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:103:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:104:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:105:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:106:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:107:0x0403  */
    /* JADX WARN: Code duplicated, block: B:108:0x0414  */
    /* JADX WARN: Code duplicated, block: B:109:0x0425  */
    /* JADX WARN: Code duplicated, block: B:110:0x0436  */
    /* JADX WARN: Code duplicated, block: B:111:0x0447  */
    /* JADX WARN: Code duplicated, block: B:112:0x0458  */
    /* JADX WARN: Code duplicated, block: B:114:0x045e  */
    /* JADX WARN: Code duplicated, block: B:115:0x046d  */
    /* JADX WARN: Code duplicated, block: B:117:0x0473  */
    /* JADX WARN: Code duplicated, block: B:118:0x047e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0484  */
    /* JADX WARN: Code duplicated, block: B:121:0x048f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0495  */
    /* JADX WARN: Code duplicated, block: B:124:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:126:0x04a8  */
    /* JADX WARN: Code duplicated, block: B:127:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:129:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:130:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:132:0x04ce  */
    /* JADX WARN: Code duplicated, block: B:133:0x04db  */
    /* JADX WARN: Code duplicated, block: B:135:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:136:0x04f0  */
    /* JADX WARN: Code duplicated, block: B:138:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:139:0x0509  */
    /* JADX WARN: Code duplicated, block: B:141:0x050f  */
    /* JADX WARN: Code duplicated, block: B:142:0x051a  */
    /* JADX WARN: Code duplicated, block: B:144:0x0520  */
    /* JADX WARN: Code duplicated, block: B:145:0x052f  */
    /* JADX WARN: Code duplicated, block: B:147:0x0535  */
    /* JADX WARN: Code duplicated, block: B:148:0x0541  */
    /* JADX WARN: Code duplicated, block: B:150:0x0547  */
    /* JADX WARN: Code duplicated, block: B:151:0x0553  */
    /* JADX WARN: Code duplicated, block: B:153:0x0559  */
    /* JADX WARN: Code duplicated, block: B:154:0x0565  */
    /* JADX WARN: Code duplicated, block: B:156:0x056b  */
    /* JADX WARN: Code duplicated, block: B:157:0x0577  */
    /* JADX WARN: Code duplicated, block: B:159:0x057d  */
    /* JADX WARN: Code duplicated, block: B:160:0x0589  */
    /* JADX WARN: Code duplicated, block: B:162:0x058f  */
    /* JADX WARN: Code duplicated, block: B:163:0x059b  */
    /* JADX WARN: Code duplicated, block: B:165:0x05a1  */
    /* JADX WARN: Code duplicated, block: B:175:0x021e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:187:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:199:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:201:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:205:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:207:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:209:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:211:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0069  */
    /* JADX WARN: Code duplicated, block: B:23:0x006f  */
    /* JADX WARN: Code duplicated, block: B:245:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:247:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:249:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x007e  */
    /* JADX WARN: Code duplicated, block: B:251:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:253:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:255:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:257:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:261:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:263:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:265:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:267:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:269:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0084  */
    /* JADX WARN: Code duplicated, block: B:271:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:273:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:275:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:277:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:279:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0095  */
    /* JADX WARN: Code duplicated, block: B:280:0x05ac A[DONT_GENERATE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:281:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x009b  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:35:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:36:0x00de  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:42:0x0110  */
    /* JADX WARN: Code duplicated, block: B:44:0x0116  */
    /* JADX WARN: Code duplicated, block: B:45:0x0125  */
    /* JADX WARN: Code duplicated, block: B:47:0x012b  */
    /* JADX WARN: Code duplicated, block: B:48:0x013e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0144  */
    /* JADX WARN: Code duplicated, block: B:51:0x014f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0155  */
    /* JADX WARN: Code duplicated, block: B:54:0x0168  */
    /* JADX WARN: Code duplicated, block: B:56:0x016e  */
    /* JADX WARN: Code duplicated, block: B:57:0x0181  */
    /* JADX WARN: Code duplicated, block: B:59:0x0187  */
    /* JADX WARN: Code duplicated, block: B:60:0x019a  */
    /* JADX WARN: Code duplicated, block: B:62:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:66:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:68:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:69:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:71:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:72:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:74:0x0202  */
    /* JADX WARN: Code duplicated, block: B:75:0x0213  */
    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    /* JADX WARN: Code duplicated, block: B:80:0x0230  */
    /* JADX WARN: Code duplicated, block: B:81:0x0245  */
    /* JADX WARN: Code duplicated, block: B:82:0x0256  */
    /* JADX WARN: Code duplicated, block: B:83:0x0267  */
    /* JADX WARN: Code duplicated, block: B:84:0x0278  */
    /* JADX WARN: Code duplicated, block: B:85:0x0289  */
    /* JADX WARN: Code duplicated, block: B:86:0x029a  */
    /* JADX WARN: Code duplicated, block: B:87:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:88:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:89:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:90:0x02de  */
    /* JADX WARN: Code duplicated, block: B:91:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:92:0x0300  */
    /* JADX WARN: Code duplicated, block: B:93:0x0311  */
    /* JADX WARN: Code duplicated, block: B:94:0x0322  */
    /* JADX WARN: Code duplicated, block: B:95:0x0333  */
    /* JADX WARN: Code duplicated, block: B:96:0x0344  */
    /* JADX WARN: Code duplicated, block: B:97:0x0355  */
    /* JADX WARN: Code duplicated, block: B:98:0x0366  */
    /* JADX WARN: Code duplicated, block: B:99:0x0377  */
    public final void b(Object obj, C c) {
        Iterator itD;
        Map.Entry entry;
        if (this.f) {
            this.o.getClass();
            N n = ((GeneratedMessageLite$ExtendableMessage) obj).extensions;
            if (n.f2264a.isEmpty()) {
                itD = null;
                entry = null;
            } else {
                itD = n.d();
                entry = (Map.Entry) itD.next();
            }
        } else {
            itD = null;
            entry = null;
        }
        int length = this.f2259a.length;
        for (int i = 0; i < length; i += 3) {
            int[] iArr = this.f2259a;
            int i2 = iArr[i + 1];
            int i3 = iArr[i];
            while (entry != null) {
                this.o.getClass();
                if (((X) entry.getKey()).b <= i3) {
                    this.o.getClass();
                    J.a(c, entry);
                    entry = itD.hasNext() ? (Map.Entry) itD.next() : null;
                } else {
                    switch ((267386880 & i2) >>> 20) {
                        case 0:
                            if (a(i, obj)) {
                                c.a(i3, y1.c.c(obj, i2 & 1048575));
                            }
                            break;
                        case 1:
                            if (a(i, obj)) {
                                c.a(i3, y1.c.d(obj, i2 & 1048575));
                            }
                            break;
                        case 2:
                            if (a(i, obj)) {
                                c.f2252a.b(i3, y1.d(obj, i2 & 1048575));
                            }
                            break;
                        case 3:
                            if (a(i, obj)) {
                                c.f2252a.b(i3, y1.d(obj, i2 & 1048575));
                            }
                            break;
                        case 4:
                            if (a(i, obj)) {
                                c.f2252a.b(i3, y1.c(obj, i2 & 1048575));
                            }
                            break;
                        case 5:
                            if (a(i, obj)) {
                                c.f2252a.a(i3, y1.d(obj, i2 & 1048575));
                            }
                            break;
                        case 6:
                            if (a(i, obj)) {
                                c.f2252a.a(i3, y1.c(obj, i2 & 1048575));
                            }
                            break;
                        case 7:
                            if (a(i, obj)) {
                                c.f2252a.a(i3, y1.c.a(obj, i2 & 1048575));
                            }
                            break;
                        case 8:
                            if (a(i, obj)) {
                                a(i3, y1.e(obj, i2 & 1048575), c);
                            }
                            break;
                        case 9:
                            if (a(i, obj)) {
                                c.f2252a.a(i3, (E0) y1.e(obj, i2 & 1048575), c(i));
                            }
                            break;
                        case 10:
                            if (a(i, obj)) {
                                c.f2252a.a(i3, (AbstractC3221s) y1.e(obj, i2 & 1048575));
                            }
                            break;
                        case 11:
                            if (a(i, obj)) {
                                c.f2252a.d(i3, y1.c(obj, i2 & 1048575));
                            }
                            break;
                        case 12:
                            if (a(i, obj)) {
                                c.f2252a.b(i3, y1.c(obj, i2 & 1048575));
                            }
                            break;
                        case 13:
                            if (a(i, obj)) {
                                c.f2252a.a(i3, y1.c(obj, i2 & 1048575));
                            }
                            break;
                        case 14:
                            if (a(i, obj)) {
                                c.f2252a.a(i3, y1.d(obj, i2 & 1048575));
                            }
                            break;
                        case 15:
                            if (a(i, obj)) {
                                c.a(i3, y1.c(obj, i2 & 1048575));
                            }
                            break;
                        case 16:
                            if (a(i, obj)) {
                                c.a(i3, y1.d(obj, i2 & 1048575));
                            }
                            break;
                        case 17:
                            if (a(i, obj)) {
                                c.a(i3, y1.e(obj, i2 & 1048575), c(i));
                            }
                            break;
                        case 18:
                            V0.b(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                            break;
                        case 19:
                            V0.f(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                            break;
                        case 20:
                            V0.h(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                            break;
                        case 21:
                            V0.n(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                            break;
                        case 22:
                            V0.g(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                            break;
                        case 23:
                            V0.e(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                            break;
                        case 24:
                            V0.d(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                            break;
                        case 25:
                            V0.a(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                            break;
                        case 26:
                            V0.b(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c);
                            break;
                        case 27:
                            V0.b(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, c(i));
                            break;
                        case 28:
                            V0.a(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c);
                            break;
                        case 29:
                            V0.m(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                            break;
                        case 30:
                            V0.c(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                            break;
                        case 31:
                            V0.i(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                            break;
                        case 32:
                            V0.j(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                            break;
                        case 33:
                            V0.k(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                            break;
                        case 34:
                            V0.l(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                            break;
                        case 35:
                            V0.b(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                            break;
                        case 36:
                            V0.f(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                            break;
                        case 37:
                            V0.h(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                            break;
                        case 38:
                            V0.n(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                            break;
                        case 39:
                            V0.g(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                            break;
                        case 40:
                            V0.e(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                            break;
                        case 41:
                            V0.d(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                            break;
                        case 42:
                            V0.a(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                            break;
                        case 43:
                            V0.m(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                            break;
                        case 44:
                            V0.c(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                            break;
                        case 45:
                            V0.i(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                            break;
                        case 46:
                            V0.j(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                            break;
                        case 47:
                            V0.k(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                            break;
                        case 48:
                            V0.l(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                            break;
                        case 49:
                            V0.a(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, c(i));
                            break;
                        case 50:
                            if (y1.e(obj, i2 & 1048575) == null) {
                                A0 a0 = this.p;
                                Object objB = b(i);
                                a0.getClass();
                                objB.getClass();
                                throw new ClassCastException();
                            }
                            break;
                            break;
                        case 51:
                            if (a(obj, i3, i)) {
                                c.a(i3, ((Double) y1.e(obj, i2 & 1048575)).doubleValue());
                            }
                            break;
                        case 52:
                            if (a(obj, i3, i)) {
                                c.a(i3, ((Float) y1.e(obj, i2 & 1048575)).floatValue());
                            }
                            break;
                        case 53:
                            if (a(obj, i3, i)) {
                                c.f2252a.b(i3, ((Long) y1.e(obj, i2 & 1048575)).longValue());
                            }
                            break;
                        case 54:
                            if (a(obj, i3, i)) {
                                c.f2252a.b(i3, ((Long) y1.e(obj, i2 & 1048575)).longValue());
                            }
                            break;
                        case 55:
                            if (a(obj, i3, i)) {
                                c.f2252a.b(i3, ((Integer) y1.e(obj, i2 & 1048575)).intValue());
                            }
                            break;
                        case 56:
                            if (a(obj, i3, i)) {
                                c.f2252a.a(i3, ((Long) y1.e(obj, i2 & 1048575)).longValue());
                            }
                            break;
                        case 57:
                            if (a(obj, i3, i)) {
                                c.f2252a.a(i3, ((Integer) y1.e(obj, i2 & 1048575)).intValue());
                            }
                            break;
                        case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                            if (a(obj, i3, i)) {
                                c.f2252a.a(i3, ((Boolean) y1.e(obj, i2 & 1048575)).booleanValue());
                            }
                            break;
                        case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                            if (a(obj, i3, i)) {
                                a(i3, y1.e(obj, i2 & 1048575), c);
                            }
                            break;
                        case 60:
                            if (a(obj, i3, i)) {
                                c.f2252a.a(i3, (E0) y1.e(obj, i2 & 1048575), c(i));
                            }
                            break;
                        case 61:
                            if (a(obj, i3, i)) {
                                c.f2252a.a(i3, (AbstractC3221s) y1.e(obj, i2 & 1048575));
                            }
                            break;
                        case 62:
                            if (a(obj, i3, i)) {
                                c.f2252a.d(i3, ((Integer) y1.e(obj, i2 & 1048575)).intValue());
                            }
                            break;
                        case 63:
                            if (a(obj, i3, i)) {
                                c.f2252a.b(i3, ((Integer) y1.e(obj, i2 & 1048575)).intValue());
                            }
                            break;
                        case 64:
                            if (a(obj, i3, i)) {
                                c.f2252a.a(i3, ((Integer) y1.e(obj, i2 & 1048575)).intValue());
                            }
                            break;
                        case 65:
                            if (a(obj, i3, i)) {
                                c.f2252a.a(i3, ((Long) y1.e(obj, i2 & 1048575)).longValue());
                            }
                            break;
                        case 66:
                            if (a(obj, i3, i)) {
                                c.a(i3, ((Integer) y1.e(obj, i2 & 1048575)).intValue());
                            }
                            break;
                        case 67:
                            if (a(obj, i3, i)) {
                                c.a(i3, ((Long) y1.e(obj, i2 & 1048575)).longValue());
                            }
                            break;
                        case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                            if (a(obj, i3, i)) {
                                c.a(i3, y1.e(obj, i2 & 1048575), c(i));
                            }
                            break;
                    }
                }
            }
            switch ((267386880 & i2) >>> 20) {
                case 0:
                    if (a(i, obj)) {
                        c.a(i3, y1.c.c(obj, i2 & 1048575));
                    }
                    break;
                case 1:
                    if (a(i, obj)) {
                        c.a(i3, y1.c.d(obj, i2 & 1048575));
                    }
                    break;
                case 2:
                    if (a(i, obj)) {
                        c.f2252a.b(i3, y1.d(obj, i2 & 1048575));
                    }
                    break;
                case 3:
                    if (a(i, obj)) {
                        c.f2252a.b(i3, y1.d(obj, i2 & 1048575));
                    }
                    break;
                case 4:
                    if (a(i, obj)) {
                        c.f2252a.b(i3, y1.c(obj, i2 & 1048575));
                    }
                    break;
                case 5:
                    if (a(i, obj)) {
                        c.f2252a.a(i3, y1.d(obj, i2 & 1048575));
                    }
                    break;
                case 6:
                    if (a(i, obj)) {
                        c.f2252a.a(i3, y1.c(obj, i2 & 1048575));
                    }
                    break;
                case 7:
                    if (a(i, obj)) {
                        c.f2252a.a(i3, y1.c.a(obj, i2 & 1048575));
                    }
                    break;
                case 8:
                    if (a(i, obj)) {
                        a(i3, y1.e(obj, i2 & 1048575), c);
                    }
                    break;
                case 9:
                    if (a(i, obj)) {
                        c.f2252a.a(i3, (E0) y1.e(obj, i2 & 1048575), c(i));
                    }
                    break;
                case 10:
                    if (a(i, obj)) {
                        c.f2252a.a(i3, (AbstractC3221s) y1.e(obj, i2 & 1048575));
                    }
                    break;
                case 11:
                    if (a(i, obj)) {
                        c.f2252a.d(i3, y1.c(obj, i2 & 1048575));
                    }
                    break;
                case 12:
                    if (a(i, obj)) {
                        c.f2252a.b(i3, y1.c(obj, i2 & 1048575));
                    }
                    break;
                case 13:
                    if (a(i, obj)) {
                        c.f2252a.a(i3, y1.c(obj, i2 & 1048575));
                    }
                    break;
                case 14:
                    if (a(i, obj)) {
                        c.f2252a.a(i3, y1.d(obj, i2 & 1048575));
                    }
                    break;
                case 15:
                    if (a(i, obj)) {
                        c.a(i3, y1.c(obj, i2 & 1048575));
                    }
                    break;
                case 16:
                    if (a(i, obj)) {
                        c.a(i3, y1.d(obj, i2 & 1048575));
                    }
                    break;
                case 17:
                    if (a(i, obj)) {
                        c.a(i3, y1.e(obj, i2 & 1048575), c(i));
                    }
                    break;
                case 18:
                    V0.b(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                    break;
                case 19:
                    V0.f(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                    break;
                case 20:
                    V0.h(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                    break;
                case 21:
                    V0.n(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                    break;
                case 22:
                    V0.g(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                    break;
                case 23:
                    V0.e(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                    break;
                case 24:
                    V0.d(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                    break;
                case 25:
                    V0.a(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                    break;
                case 26:
                    V0.b(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c);
                    break;
                case 27:
                    V0.b(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, c(i));
                    break;
                case 28:
                    V0.a(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c);
                    break;
                case 29:
                    V0.m(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                    break;
                case 30:
                    V0.c(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                    break;
                case 31:
                    V0.i(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                    break;
                case 32:
                    V0.j(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                    break;
                case 33:
                    V0.k(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                    break;
                case 34:
                    V0.l(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, false);
                    break;
                case 35:
                    V0.b(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                    break;
                case 36:
                    V0.f(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                    break;
                case 37:
                    V0.h(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                    break;
                case 38:
                    V0.n(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                    break;
                case 39:
                    V0.g(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                    break;
                case 40:
                    V0.e(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                    break;
                case 41:
                    V0.d(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                    break;
                case 42:
                    V0.a(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                    break;
                case 43:
                    V0.m(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                    break;
                case 44:
                    V0.c(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                    break;
                case 45:
                    V0.i(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                    break;
                case 46:
                    V0.j(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                    break;
                case 47:
                    V0.k(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                    break;
                case 48:
                    V0.l(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, true);
                    break;
                case 49:
                    V0.a(this.f2259a[i], (List) y1.e(obj, i2 & 1048575), c, c(i));
                    break;
                case 50:
                    if (y1.e(obj, i2 & 1048575) == null) {
                        A0 a1 = this.p;
                        Object objB2 = b(i);
                        a1.getClass();
                        objB2.getClass();
                        throw new ClassCastException();
                    }
                    break;
                    break;
                case 51:
                    if (a(obj, i3, i)) {
                        c.a(i3, ((Double) y1.e(obj, i2 & 1048575)).doubleValue());
                    }
                    break;
                case 52:
                    if (a(obj, i3, i)) {
                        c.a(i3, ((Float) y1.e(obj, i2 & 1048575)).floatValue());
                    }
                    break;
                case 53:
                    if (a(obj, i3, i)) {
                        c.f2252a.b(i3, ((Long) y1.e(obj, i2 & 1048575)).longValue());
                    }
                    break;
                case 54:
                    if (a(obj, i3, i)) {
                        c.f2252a.b(i3, ((Long) y1.e(obj, i2 & 1048575)).longValue());
                    }
                    break;
                case 55:
                    if (a(obj, i3, i)) {
                        c.f2252a.b(i3, ((Integer) y1.e(obj, i2 & 1048575)).intValue());
                    }
                    break;
                case 56:
                    if (a(obj, i3, i)) {
                        c.f2252a.a(i3, ((Long) y1.e(obj, i2 & 1048575)).longValue());
                    }
                    break;
                case 57:
                    if (a(obj, i3, i)) {
                        c.f2252a.a(i3, ((Integer) y1.e(obj, i2 & 1048575)).intValue());
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    if (a(obj, i3, i)) {
                        c.f2252a.a(i3, ((Boolean) y1.e(obj, i2 & 1048575)).booleanValue());
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    if (a(obj, i3, i)) {
                        a(i3, y1.e(obj, i2 & 1048575), c);
                    }
                    break;
                case 60:
                    if (a(obj, i3, i)) {
                        c.f2252a.a(i3, (E0) y1.e(obj, i2 & 1048575), c(i));
                    }
                    break;
                case 61:
                    if (a(obj, i3, i)) {
                        c.f2252a.a(i3, (AbstractC3221s) y1.e(obj, i2 & 1048575));
                    }
                    break;
                case 62:
                    if (a(obj, i3, i)) {
                        c.f2252a.d(i3, ((Integer) y1.e(obj, i2 & 1048575)).intValue());
                    }
                    break;
                case 63:
                    if (a(obj, i3, i)) {
                        c.f2252a.b(i3, ((Integer) y1.e(obj, i2 & 1048575)).intValue());
                    }
                    break;
                case 64:
                    if (a(obj, i3, i)) {
                        c.f2252a.a(i3, ((Integer) y1.e(obj, i2 & 1048575)).intValue());
                    }
                    break;
                case 65:
                    if (a(obj, i3, i)) {
                        c.f2252a.a(i3, ((Long) y1.e(obj, i2 & 1048575)).longValue());
                    }
                    break;
                case 66:
                    if (a(obj, i3, i)) {
                        c.a(i3, ((Integer) y1.e(obj, i2 & 1048575)).intValue());
                    }
                    break;
                case 67:
                    if (a(obj, i3, i)) {
                        c.a(i3, ((Long) y1.e(obj, i2 & 1048575)).longValue());
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    if (a(obj, i3, i)) {
                        c.a(i3, y1.e(obj, i2 & 1048575), c(i));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.o.getClass();
            J.a(c, entry);
            entry = itD.hasNext() ? (Map.Entry) itD.next() : null;
        }
        this.n.getClass();
        ((AbstractC3169a0) obj).unknownFields.a(c);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final void a(Object obj, T0 t0, H h) {
        h.getClass();
        a(this.n, this.o, obj, t0, h);
    }

    public final void a(C3215p1 c3215p1, J j, Object obj, T0 t0, H h) {
        Y yA;
        Object objA;
        Object objB = null;
        N nEnsureExtensionsAreMutable = null;
        while (true) {
            try {
                int iS = t0.s();
                int iA = (iS < this.c || iS > this.d) ? -1 : a(iS, 0);
                if (iA < 0) {
                    if (iS == Integer.MAX_VALUE) {
                        for (int i = this.j; i < this.k; i++) {
                            objB = b(this.i[i], obj, objB);
                        }
                        if (objB != null) {
                            c3215p1.getClass();
                            C3215p1.a(obj, objB);
                            return;
                        }
                        return;
                    }
                    if (this.f) {
                        E0 e0 = this.e;
                        j.getClass();
                        yA = h.a(iS, e0);
                    } else {
                        yA = null;
                    }
                    if (yA != null) {
                        if (nEnsureExtensionsAreMutable == null) {
                            j.getClass();
                            nEnsureExtensionsAreMutable = ((GeneratedMessageLite$ExtendableMessage) obj).ensureExtensionsAreMutable();
                        }
                        j.getClass();
                        objA = J.a(t0, yA, h, nEnsureExtensionsAreMutable, objB, c3215p1);
                        objB = objA;
                    } else {
                        c3215p1.getClass();
                        if (objB == null) {
                            AbstractC3169a0 abstractC3169a0 = (AbstractC3169a0) obj;
                            C3212o1 c3212o1 = abstractC3169a0.unknownFields;
                            if (c3212o1 == C3212o1.f) {
                                c3212o1 = new C3212o1();
                                abstractC3169a0.unknownFields = c3212o1;
                            }
                            objB = c3212o1;
                        }
                        if (!C3215p1.a(objB, t0)) {
                            for (int i2 = this.j; i2 < this.k; i2++) {
                                objB = b(this.i[i2], obj, objB);
                            }
                            if (objB != null) {
                                C3215p1.a(obj, objB);
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    int i3 = this.f2259a[iA + 1];
                    switch ((267386880 & i3) >>> 20) {
                        case 0:
                            y1.c.a(obj, d(i3), t0.h());
                            b(iA, obj);
                            break;
                        case 1:
                            y1.c.a(obj, d(i3), t0.k());
                            b(iA, obj);
                            break;
                        case 2:
                            y1.a(obj, d(i3), t0.o());
                            b(iA, obj);
                            break;
                        case 3:
                            y1.a(obj, d(i3), t0.f());
                            b(iA, obj);
                            break;
                        case 4:
                            y1.a(obj, d(i3), t0.d());
                            b(iA, obj);
                            break;
                        case 5:
                            y1.a(obj, d(i3), t0.g());
                            b(iA, obj);
                            break;
                        case 6:
                            y1.a(obj, d(i3), t0.q());
                            b(iA, obj);
                            break;
                        case 7:
                            y1.c.a(obj, d(i3), t0.r());
                            b(iA, obj);
                            break;
                        case 8:
                            if ((i3 & 536870912) != 0) {
                                y1.a(i3 & 1048575, obj, t0.p());
                            } else if (this.g) {
                                y1.a(i3 & 1048575, obj, t0.n());
                            } else {
                                y1.a(i3 & 1048575, obj, t0.a());
                            }
                            b(iA, obj);
                            break;
                        case 9:
                            if (a(iA, obj)) {
                                y1.a(d(i3), obj, AbstractC3205m0.a(y1.e(obj, d(i3)), t0.b(c(iA), h)));
                            } else {
                                y1.a(d(i3), obj, t0.b(c(iA), h));
                                b(iA, obj);
                            }
                            break;
                        case 10:
                            y1.a(d(i3), obj, t0.a());
                            b(iA, obj);
                            break;
                        case 11:
                            y1.a(obj, d(i3), t0.c());
                            b(iA, obj);
                            break;
                        case 12:
                            int iB = t0.b();
                            a(iA);
                            y1.a(obj, d(i3), iB);
                            b(iA, obj);
                            break;
                        case 13:
                            y1.a(obj, d(i3), t0.m());
                            b(iA, obj);
                            break;
                        case 14:
                            y1.a(obj, d(i3), t0.t());
                            b(iA, obj);
                            break;
                        case 15:
                            y1.a(obj, d(i3), t0.j());
                            b(iA, obj);
                            break;
                        case 16:
                            y1.a(obj, d(i3), t0.l());
                            b(iA, obj);
                            break;
                        case 17:
                            if (a(iA, obj)) {
                                y1.a(d(i3), obj, AbstractC3205m0.a(y1.e(obj, d(i3)), t0.a(c(iA), h)));
                            } else {
                                y1.a(d(i3), obj, t0.a(c(iA), h));
                                b(iA, obj);
                            }
                            break;
                        case 18:
                            t0.j(this.m.b(obj, d(i3)));
                            break;
                        case 19:
                            t0.d(this.m.b(obj, d(i3)));
                            break;
                        case 20:
                            t0.k(this.m.b(obj, d(i3)));
                            break;
                        case 21:
                            t0.a(this.m.b(obj, d(i3)));
                            break;
                        case 22:
                            t0.o(this.m.b(obj, d(i3)));
                            break;
                        case 23:
                            t0.n(this.m.b(obj, d(i3)));
                            break;
                        case 24:
                            t0.e(this.m.b(obj, d(i3)));
                            break;
                        case 25:
                            t0.l(this.m.b(obj, d(i3)));
                            break;
                        case 26:
                            a(obj, i3, t0);
                            break;
                        case 27:
                            a(obj, i3, t0, c(iA), h);
                            break;
                        case 28:
                            t0.h(this.m.b(obj, d(i3)));
                            break;
                        case 29:
                            t0.i(this.m.b(obj, d(i3)));
                            break;
                        case 30:
                            List listB = this.m.b(obj, d(i3));
                            t0.p(listB);
                            a(iA);
                            objA = V0.a(iS, listB, objB, c3215p1);
                            objB = objA;
                            break;
                        case 31:
                            t0.f(this.m.b(obj, d(i3)));
                            break;
                        case 32:
                            t0.m(this.m.b(obj, d(i3)));
                            break;
                        case 33:
                            t0.c(this.m.b(obj, d(i3)));
                            break;
                        case 34:
                            t0.g(this.m.b(obj, d(i3)));
                            break;
                        case 35:
                            t0.j(this.m.b(obj, d(i3)));
                            break;
                        case 36:
                            t0.d(this.m.b(obj, d(i3)));
                            break;
                        case 37:
                            t0.k(this.m.b(obj, d(i3)));
                            break;
                        case 38:
                            t0.a(this.m.b(obj, d(i3)));
                            break;
                        case 39:
                            t0.o(this.m.b(obj, d(i3)));
                            break;
                        case 40:
                            t0.n(this.m.b(obj, d(i3)));
                            break;
                        case 41:
                            t0.e(this.m.b(obj, d(i3)));
                            break;
                        case 42:
                            t0.l(this.m.b(obj, d(i3)));
                            break;
                        case 43:
                            t0.i(this.m.b(obj, d(i3)));
                            break;
                        case 44:
                            List listB2 = this.m.b(obj, d(i3));
                            t0.p(listB2);
                            a(iA);
                            objA = V0.a(iS, listB2, objB, c3215p1);
                            objB = objA;
                            break;
                        case 45:
                            t0.f(this.m.b(obj, d(i3)));
                            break;
                        case 46:
                            t0.m(this.m.b(obj, d(i3)));
                            break;
                        case 47:
                            t0.c(this.m.b(obj, d(i3)));
                            break;
                        case 48:
                            t0.g(this.m.b(obj, d(i3)));
                            break;
                        case 49:
                            a(obj, d(i3), t0, c(iA), h);
                            break;
                        case 50:
                            c(iA, obj, b(iA));
                            throw null;
                        case 51:
                            y1.a(d(i3), obj, Double.valueOf(t0.h()));
                            b(obj, iS, iA);
                            break;
                        case 52:
                            y1.a(d(i3), obj, Float.valueOf(t0.k()));
                            b(obj, iS, iA);
                            break;
                        case 53:
                            y1.a(d(i3), obj, Long.valueOf(t0.o()));
                            b(obj, iS, iA);
                            break;
                        case 54:
                            y1.a(d(i3), obj, Long.valueOf(t0.f()));
                            b(obj, iS, iA);
                            break;
                        case 55:
                            y1.a(d(i3), obj, Integer.valueOf(t0.d()));
                            b(obj, iS, iA);
                            break;
                        case 56:
                            y1.a(d(i3), obj, Long.valueOf(t0.g()));
                            b(obj, iS, iA);
                            break;
                        case 57:
                            y1.a(d(i3), obj, Integer.valueOf(t0.q()));
                            b(obj, iS, iA);
                            break;
                        case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                            y1.a(d(i3), obj, Boolean.valueOf(t0.r()));
                            b(obj, iS, iA);
                            break;
                        case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                            if ((i3 & 536870912) != 0) {
                                y1.a(i3 & 1048575, obj, t0.p());
                            } else if (this.g) {
                                y1.a(i3 & 1048575, obj, t0.n());
                            } else {
                                y1.a(i3 & 1048575, obj, t0.a());
                            }
                            b(obj, iS, iA);
                            break;
                        case 60:
                            if (a(obj, iS, iA)) {
                                y1.a(d(i3), obj, AbstractC3205m0.a(y1.e(obj, d(i3)), t0.b(c(iA), h)));
                            } else {
                                y1.a(d(i3), obj, t0.b(c(iA), h));
                                b(iA, obj);
                            }
                            b(obj, iS, iA);
                            break;
                        case 61:
                            y1.a(d(i3), obj, t0.a());
                            b(obj, iS, iA);
                            break;
                        case 62:
                            y1.a(d(i3), obj, Integer.valueOf(t0.c()));
                            b(obj, iS, iA);
                            break;
                        case 63:
                            int iB2 = t0.b();
                            a(iA);
                            y1.a(d(i3), obj, Integer.valueOf(iB2));
                            b(obj, iS, iA);
                            break;
                        case 64:
                            y1.a(d(i3), obj, Integer.valueOf(t0.m()));
                            b(obj, iS, iA);
                            break;
                        case 65:
                            y1.a(d(i3), obj, Long.valueOf(t0.t()));
                            b(obj, iS, iA);
                            break;
                        case 66:
                            y1.a(d(i3), obj, Integer.valueOf(t0.j()));
                            b(obj, iS, iA);
                            break;
                        case 67:
                            y1.a(d(i3), obj, Long.valueOf(t0.l()));
                            b(obj, iS, iA);
                            break;
                        case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                            y1.a(d(i3), obj, t0.a(c(iA), h));
                            b(obj, iS, iA);
                            break;
                        default:
                            if (objB == null) {
                                try {
                                    c3215p1.getClass();
                                    objB = new C3212o1();
                                } catch (C3208n0 unused) {
                                    c3215p1.getClass();
                                    if (objB == null) {
                                        AbstractC3169a0 abstractC3169a1 = (AbstractC3169a0) obj;
                                        C3212o1 c3212o2 = abstractC3169a1.unknownFields;
                                        if (c3212o2 == C3212o1.f) {
                                            c3212o2 = new C3212o1();
                                            abstractC3169a1.unknownFields = c3212o2;
                                        }
                                        objB = c3212o2;
                                    }
                                    if (!C3215p1.a(objB, t0)) {
                                        for (int i4 = this.j; i4 < this.k; i4++) {
                                            objB = b(this.i[i4], obj, objB);
                                        }
                                        if (objB != null) {
                                            C3215p1.a(obj, objB);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                break;
                            }
                            c3215p1.getClass();
                            if (!C3215p1.a(objB, t0)) {
                                for (int i5 = this.j; i5 < this.k; i5++) {
                                    objB = b(this.i[i5], obj, objB);
                                }
                                if (objB != null) {
                                    C3215p1.a(obj, objB);
                                    return;
                                }
                                return;
                            }
                            break;
                            break;
                    }
                }
            } catch (Throwable th) {
                for (int i6 = this.j; i6 < this.k; i6++) {
                    objB = b(this.i[i6], obj, objB);
                }
                if (objB != null) {
                    c3215p1.getClass();
                    C3215p1.a(obj, objB);
                }
                throw th;
            }
        }
    }

    public final Object b(int i) {
        return this.b[(i / 3) * 2];
    }

    public final Object b(int i, Object obj, Object obj2) {
        int[] iArr = this.f2259a;
        int i2 = iArr[i];
        if (y1.e(obj, iArr[i + 1] & 1048575) == null) {
            return obj2;
        }
        a(i);
        return obj2;
    }

    public final void b(int i, Object obj) {
        int i2 = this.f2259a[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        y1.a(obj, j, (1 << (i2 >>> 20)) | y1.c(obj, j));
    }

    public final void b(Object obj, int i, int i2) {
        y1.a(obj, this.f2259a[i2 + 2] & 1048575, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int a(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, long j, int i6, long j2, C3183f c3183f) throws C3211o0 {
        int iD;
        int i7;
        int iA = i;
        Unsafe unsafe = r;
        InterfaceC3202l0 interfaceC3202l0B = (InterfaceC3202l0) unsafe.getObject(obj, j2);
        if (!((AbstractC3174c) interfaceC3202l0B).f2277a) {
            int size = interfaceC3202l0B.size();
            interfaceC3202l0B = interfaceC3202l0B.b(size == 0 ? 10 : size * 2);
            unsafe.putObject(obj, j2, interfaceC3202l0B);
        }
        switch (i6) {
            case 18:
            case 35:
                if (i4 == 2) {
                    D d = (D) interfaceC3202l0B;
                    int iD2 = AbstractC3186g.d(bArr, iA, c3183f);
                    int i8 = c3183f.f2283a + iD2;
                    while (iD2 < i8) {
                        d.a(Double.longBitsToDouble(AbstractC3186g.b(iD2, bArr)));
                        iD2 += 8;
                    }
                    if (iD2 == i8) {
                        return iD2;
                    }
                    throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i4 == 1) {
                    D d2 = (D) interfaceC3202l0B;
                    d2.a(Double.longBitsToDouble(AbstractC3186g.b(iA, bArr)));
                    while (true) {
                        int i9 = iA + 8;
                        if (i9 >= i2) {
                            return i9;
                        }
                        iA = i9 + 1;
                        byte b = bArr[i9];
                        if (b >= 0) {
                            c3183f.f2283a = b;
                        } else {
                            iA = AbstractC3186g.a(b, bArr, iA, c3183f);
                        }
                        if (i3 != c3183f.f2283a) {
                            return i9;
                        }
                        d2.a(Double.longBitsToDouble(AbstractC3186g.b(iA, bArr)));
                    }
                }
                return iA;
            case 19:
            case 36:
                if (i4 == 2) {
                    Q q2 = (Q) interfaceC3202l0B;
                    int iD3 = AbstractC3186g.d(bArr, iA, c3183f);
                    int i10 = c3183f.f2283a + iD3;
                    while (iD3 < i10) {
                        q2.a(Float.intBitsToFloat(AbstractC3186g.a(iD3, bArr)));
                        iD3 += 4;
                    }
                    if (iD3 == i10) {
                        return iD3;
                    }
                    throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i4 == 5) {
                    Q q3 = (Q) interfaceC3202l0B;
                    q3.a(Float.intBitsToFloat(AbstractC3186g.a(iA, bArr)));
                    while (true) {
                        int i11 = iA + 4;
                        if (i11 >= i2) {
                            return i11;
                        }
                        iA = i11 + 1;
                        byte b2 = bArr[i11];
                        if (b2 >= 0) {
                            c3183f.f2283a = b2;
                        } else {
                            iA = AbstractC3186g.a(b2, bArr, iA, c3183f);
                        }
                        if (i3 != c3183f.f2283a) {
                            return i11;
                        }
                        q3.a(Float.intBitsToFloat(AbstractC3186g.a(iA, bArr)));
                    }
                }
                return iA;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i4 == 2) {
                    C3228v0 c3228v0 = (C3228v0) interfaceC3202l0B;
                    int iD4 = AbstractC3186g.d(bArr, iA, c3183f);
                    int i12 = c3183f.f2283a + iD4;
                    while (iD4 < i12) {
                        iD4 = AbstractC3186g.e(bArr, iD4, c3183f);
                        c3228v0.a(c3183f.b);
                    }
                    if (iD4 == i12) {
                        return iD4;
                    }
                    throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i4 == 0) {
                    C3228v0 c3228v1 = (C3228v0) interfaceC3202l0B;
                    int iE = AbstractC3186g.e(bArr, iA, c3183f);
                    c3228v1.a(c3183f.b);
                    while (iE < i2) {
                        int iA2 = iE + 1;
                        byte b3 = bArr[iE];
                        if (b3 >= 0) {
                            c3183f.f2283a = b3;
                        } else {
                            iA2 = AbstractC3186g.a(b3, bArr, iA2, c3183f);
                        }
                        if (i3 != c3183f.f2283a) {
                            return iE;
                        }
                        iE = AbstractC3186g.e(bArr, iA2, c3183f);
                        c3228v1.a(c3183f.b);
                    }
                    return iE;
                }
                return iA;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i4 == 2) {
                    return AbstractC3186g.a(bArr, iA, interfaceC3202l0B, c3183f);
                }
                if (i4 == 0) {
                    return AbstractC3186g.c(i3, bArr, i, i2, interfaceC3202l0B, c3183f);
                }
                return iA;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i4 == 2) {
                    C3228v0 c3228v2 = (C3228v0) interfaceC3202l0B;
                    int iD5 = AbstractC3186g.d(bArr, iA, c3183f);
                    int i13 = c3183f.f2283a + iD5;
                    while (iD5 < i13) {
                        c3228v2.a(AbstractC3186g.b(iD5, bArr));
                        iD5 += 8;
                    }
                    if (iD5 == i13) {
                        return iD5;
                    }
                    throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i4 == 1) {
                    C3228v0 c3228v3 = (C3228v0) interfaceC3202l0B;
                    c3228v3.a(AbstractC3186g.b(iA, bArr));
                    while (true) {
                        int i14 = iA + 8;
                        if (i14 >= i2) {
                            return i14;
                        }
                        iA = i14 + 1;
                        byte b4 = bArr[i14];
                        if (b4 >= 0) {
                            c3183f.f2283a = b4;
                        } else {
                            iA = AbstractC3186g.a(b4, bArr, iA, c3183f);
                        }
                        if (i3 != c3183f.f2283a) {
                            return i14;
                        }
                        c3228v3.a(AbstractC3186g.b(iA, bArr));
                    }
                }
                return iA;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i4 == 2) {
                    C3172b0 c3172b0 = (C3172b0) interfaceC3202l0B;
                    int iD6 = AbstractC3186g.d(bArr, iA, c3183f);
                    int i15 = c3183f.f2283a + iD6;
                    while (iD6 < i15) {
                        c3172b0.c(AbstractC3186g.a(iD6, bArr));
                        iD6 += 4;
                    }
                    if (iD6 == i15) {
                        return iD6;
                    }
                    throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i4 == 5) {
                    C3172b0 c3172b1 = (C3172b0) interfaceC3202l0B;
                    c3172b1.c(AbstractC3186g.a(iA, bArr));
                    while (true) {
                        int i16 = iA + 4;
                        if (i16 >= i2) {
                            return i16;
                        }
                        iA = i16 + 1;
                        byte b5 = bArr[i16];
                        if (b5 >= 0) {
                            c3183f.f2283a = b5;
                        } else {
                            iA = AbstractC3186g.a(b5, bArr, iA, c3183f);
                        }
                        if (i3 != c3183f.f2283a) {
                            return i16;
                        }
                        c3172b1.c(AbstractC3186g.a(iA, bArr));
                    }
                }
                return iA;
            case 25:
            case 42:
                if (i4 == 2) {
                    C3195j c3195j = (C3195j) interfaceC3202l0B;
                    iD = AbstractC3186g.d(bArr, iA, c3183f);
                    int i17 = c3183f.f2283a + iD;
                    while (iD < i17) {
                        iD = AbstractC3186g.e(bArr, iD, c3183f);
                        c3195j.a(c3183f.b != 0);
                    }
                    if (iD != i17) {
                        throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                    }
                    return iD;
                }
                if (i4 == 0) {
                    C3195j c3195j2 = (C3195j) interfaceC3202l0B;
                    iA = AbstractC3186g.e(bArr, iA, c3183f);
                    c3195j2.a(c3183f.b != 0);
                    while (iA < i2) {
                        int iA3 = iA + 1;
                        byte b6 = bArr[iA];
                        if (b6 >= 0) {
                            c3183f.f2283a = b6;
                        } else {
                            iA3 = AbstractC3186g.a(b6, bArr, iA3, c3183f);
                        }
                        if (i3 == c3183f.f2283a) {
                            iA = AbstractC3186g.e(bArr, iA3, c3183f);
                            c3195j2.a(c3183f.b != 0);
                        }
                    }
                }
                return iA;
            case 26:
                if (i4 == 2) {
                    if ((j & 536870912) == 0) {
                        return AbstractC3186g.a(i3, bArr, i, i2, interfaceC3202l0B, c3183f);
                    }
                    return AbstractC3186g.b(i3, bArr, i, i2, interfaceC3202l0B, c3183f);
                }
                return iA;
            case 27:
                if (i4 == 2) {
                    U0 u0C = c(i5);
                    iA = AbstractC3186g.a(u0C, bArr, iA, i2, c3183f);
                    interfaceC3202l0B.add(c3183f.c);
                    while (iA < i2) {
                        int iA4 = iA + 1;
                        byte b7 = bArr[iA];
                        if (b7 >= 0) {
                            c3183f.f2283a = b7;
                        } else {
                            iA4 = AbstractC3186g.a(b7, bArr, iA4, c3183f);
                        }
                        if (i3 == c3183f.f2283a) {
                            iA = AbstractC3186g.a(u0C, bArr, iA4, i2, c3183f);
                            interfaceC3202l0B.add(c3183f.c);
                        }
                    }
                }
                return iA;
            case 28:
                if (i4 == 2) {
                    int iD7 = AbstractC3186g.d(bArr, iA, c3183f);
                    int i18 = c3183f.f2283a;
                    if (i18 >= 0) {
                        if (i18 > bArr.length - iD7) {
                            throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                        }
                        if (i18 == 0) {
                            interfaceC3202l0B.add(AbstractC3221s.b);
                            i7 = iD7;
                        } else {
                            i7 = iD7 + i18;
                            AbstractC3221s.a(iD7, i7, bArr.length);
                            interfaceC3202l0B.add(new C3216q(AbstractC3221s.c.a(bArr, iD7, i18)));
                        }
                        while (i7 < i2) {
                            int iA5 = i7 + 1;
                            byte b8 = bArr[i7];
                            if (b8 >= 0) {
                                c3183f.f2283a = b8;
                            } else {
                                iA5 = AbstractC3186g.a(b8, bArr, iA5, c3183f);
                            }
                            if (i3 != c3183f.f2283a) {
                                return i7;
                            }
                            int iA6 = iA5 + 1;
                            byte b9 = bArr[iA5];
                            if (b9 >= 0) {
                                c3183f.f2283a = b9;
                            } else {
                                iA6 = AbstractC3186g.a(b9, bArr, iA6, c3183f);
                            }
                            int i19 = c3183f.f2283a;
                            if (i19 >= 0) {
                                if (i19 > bArr.length - iA6) {
                                    throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                }
                                if (i19 == 0) {
                                    interfaceC3202l0B.add(AbstractC3221s.b);
                                    i7 = iA6;
                                } else {
                                    i7 = iA6 + i19;
                                    AbstractC3221s.a(iA6, i7, bArr.length);
                                    interfaceC3202l0B.add(new C3216q(AbstractC3221s.c.a(bArr, iA6, i19)));
                                }
                            } else {
                                throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                            }
                        }
                        return i7;
                    }
                    throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                }
                return iA;
            case 30:
            case 44:
                if (i4 != 2) {
                    if (i4 == 0) {
                        iD = AbstractC3186g.c(i3, bArr, i, i2, interfaceC3202l0B, c3183f);
                    }
                    return iA;
                }
                iD = AbstractC3186g.a(bArr, iA, interfaceC3202l0B, c3183f);
                AbstractC3169a0 abstractC3169a0 = (AbstractC3169a0) obj;
                C3212o1 c3212o1 = abstractC3169a0.unknownFields;
                if (c3212o1 == C3212o1.f) {
                    c3212o1 = null;
                }
                a(i5);
                Class cls = V0.f2271a;
                if (c3212o1 != null) {
                    abstractC3169a0.unknownFields = c3212o1;
                }
                return iD;
            case 33:
            case 47:
                if (i4 == 2) {
                    C3172b0 c3172b2 = (C3172b0) interfaceC3202l0B;
                    int iD8 = AbstractC3186g.d(bArr, iA, c3183f);
                    int i20 = c3183f.f2283a + iD8;
                    while (iD8 < i20) {
                        int i21 = iD8 + 1;
                        byte b10 = bArr[iD8];
                        if (b10 >= 0) {
                            c3183f.f2283a = b10;
                            iD8 = i21;
                        } else {
                            iD8 = AbstractC3186g.a(b10, bArr, i21, c3183f);
                        }
                        c3172b2.c(AbstractC3229w.b(c3183f.f2283a));
                    }
                    if (iD8 == i20) {
                        return iD8;
                    }
                    throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i4 == 0) {
                    C3172b0 c3172b3 = (C3172b0) interfaceC3202l0B;
                    int iD9 = AbstractC3186g.d(bArr, iA, c3183f);
                    c3172b3.c(AbstractC3229w.b(c3183f.f2283a));
                    while (iD9 < i2) {
                        int iA7 = iD9 + 1;
                        byte b11 = bArr[iD9];
                        if (b11 >= 0) {
                            c3183f.f2283a = b11;
                        } else {
                            iA7 = AbstractC3186g.a(b11, bArr, iA7, c3183f);
                        }
                        if (i3 != c3183f.f2283a) {
                            return iD9;
                        }
                        iD9 = iA7 + 1;
                        byte b12 = bArr[iA7];
                        if (b12 >= 0) {
                            c3183f.f2283a = b12;
                        } else {
                            iD9 = AbstractC3186g.a(b12, bArr, iD9, c3183f);
                        }
                        c3172b3.c(AbstractC3229w.b(c3183f.f2283a));
                    }
                    return iD9;
                }
                return iA;
            case 34:
            case 48:
                if (i4 == 2) {
                    C3228v0 c3228v4 = (C3228v0) interfaceC3202l0B;
                    int iD10 = AbstractC3186g.d(bArr, iA, c3183f);
                    int i22 = c3183f.f2283a + iD10;
                    while (iD10 < i22) {
                        iD10 = AbstractC3186g.e(bArr, iD10, c3183f);
                        c3228v4.a(AbstractC3229w.a(c3183f.b));
                    }
                    if (iD10 == i22) {
                        return iD10;
                    }
                    throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i4 == 0) {
                    C3228v0 c3228v5 = (C3228v0) interfaceC3202l0B;
                    int iE2 = AbstractC3186g.e(bArr, iA, c3183f);
                    c3228v5.a(AbstractC3229w.a(c3183f.b));
                    while (iE2 < i2) {
                        int iA8 = iE2 + 1;
                        byte b13 = bArr[iE2];
                        if (b13 >= 0) {
                            c3183f.f2283a = b13;
                        } else {
                            iA8 = AbstractC3186g.a(b13, bArr, iA8, c3183f);
                        }
                        if (i3 != c3183f.f2283a) {
                            return iE2;
                        }
                        iE2 = AbstractC3186g.e(bArr, iA8, c3183f);
                        c3228v5.a(AbstractC3229w.a(c3183f.b));
                    }
                    return iE2;
                }
                return iA;
            case 49:
                if (i4 == 3) {
                    U0 u0C2 = c(i5);
                    int i23 = (i3 & (-8)) | 4;
                    iA = AbstractC3186g.a(u0C2, bArr, i, i2, i23, c3183f);
                    interfaceC3202l0B.add(c3183f.c);
                    while (iA < i2) {
                        int iD11 = AbstractC3186g.d(bArr, iA, c3183f);
                        if (i3 == c3183f.f2283a) {
                            iA = AbstractC3186g.a(u0C2, bArr, iD11, i2, i23, c3183f);
                            interfaceC3202l0B.add(c3183f.c);
                        }
                    }
                }
                return iA;
            default:
                return iA;
        }
    }

    public final int a(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, C3183f c3183f) throws C3211o0 {
        Unsafe unsafe = r;
        long j2 = this.f2259a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(AbstractC3186g.b(i, bArr))));
                int i9 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i9;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(AbstractC3186g.a(i, bArr))));
                int i10 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i10;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iE = AbstractC3186g.e(bArr, i, c3183f);
                unsafe.putObject(obj, j, Long.valueOf(c3183f.b));
                unsafe.putInt(obj, j2, i4);
                return iE;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iD = AbstractC3186g.d(bArr, i, c3183f);
                unsafe.putObject(obj, j, Integer.valueOf(c3183f.f2283a));
                unsafe.putInt(obj, j2, i4);
                return iD;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(AbstractC3186g.b(i, bArr)));
                int i11 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i11;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(AbstractC3186g.a(i, bArr)));
                int i12 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i12;
            case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                if (i5 != 0) {
                    return i;
                }
                int iE2 = AbstractC3186g.e(bArr, i, c3183f);
                unsafe.putObject(obj, j, Boolean.valueOf(c3183f.b != 0));
                unsafe.putInt(obj, j2, i4);
                return iE2;
            case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                if (i5 != 2) {
                    return i;
                }
                int iD2 = AbstractC3186g.d(bArr, i, c3183f);
                int i13 = c3183f.f2283a;
                if (i13 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & 536870912) != 0) {
                        if (!E1.f2253a.b(bArr, iD2, iD2 + i13)) {
                            throw new C3211o0("Protocol message had invalid UTF-8.");
                        }
                    }
                    unsafe.putObject(obj, j, new String(bArr, iD2, i13, AbstractC3205m0.f2291a));
                    iD2 += i13;
                }
                unsafe.putInt(obj, j2, i4);
                return iD2;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iA = AbstractC3186g.a(c(i8), bArr, i, i2, c3183f);
                Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object == null) {
                    unsafe.putObject(obj, j, c3183f.c);
                } else {
                    unsafe.putObject(obj, j, AbstractC3205m0.a(object, c3183f.c));
                }
                unsafe.putInt(obj, j2, i4);
                return iA;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iA2 = AbstractC3186g.a(bArr, i, c3183f);
                unsafe.putObject(obj, j, c3183f.c);
                unsafe.putInt(obj, j2, i4);
                return iA2;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iD3 = AbstractC3186g.d(bArr, i, c3183f);
                int i14 = c3183f.f2283a;
                a(i8);
                unsafe.putObject(obj, j, Integer.valueOf(i14));
                unsafe.putInt(obj, j2, i4);
                return iD3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iD4 = AbstractC3186g.d(bArr, i, c3183f);
                unsafe.putObject(obj, j, Integer.valueOf(AbstractC3229w.b(c3183f.f2283a)));
                unsafe.putInt(obj, j2, i4);
                return iD4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iE3 = AbstractC3186g.e(bArr, i, c3183f);
                unsafe.putObject(obj, j, Long.valueOf(AbstractC3229w.a(c3183f.b)));
                unsafe.putInt(obj, j2, i4);
                return iE3;
            case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                if (i5 != 3) {
                    return i;
                }
                int iA3 = AbstractC3186g.a(c(i8), bArr, i, i2, (i3 & (-8)) | 4, c3183f);
                Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object2 == null) {
                    unsafe.putObject(obj, j, c3183f.c);
                } else {
                    unsafe.putObject(obj, j, AbstractC3205m0.a(object2, c3183f.c));
                }
                unsafe.putInt(obj, j2, i4);
                return iA3;
            default:
                return i;
        }
    }

    public final void a(int i) {
        if (this.b[((i / 3) * 2) + 1] != null) {
            throw new ClassCastException();
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 23781. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final int a(java.lang.Object r33, byte[] r34, int r35, int r36, int r37, com.fyber.inneractive.sdk.protobuf.C3183f r38) throws com.fyber.inneractive.sdk.protobuf.C3211o0 {
        /*
            Method dump skipped, instruction units count: 2378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.J0.a(java.lang.Object, byte[], int, int, int, com.fyber.inneractive.sdk.protobuf.f):int");
    }

    /* JADX WARN: Code duplicated, block: B:149:0x0393 A[PHI: r0 r15 r17 r18 r19 r26 r27 r28
  0x0393: PHI (r0v74 int) = (r0v69 int), (r0v78 int) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]
  0x0393: PHI (r15v9 java.lang.Object) = (r15v7 java.lang.Object), (r15v12 java.lang.Object) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]
  0x0393: PHI (r17v6 int) = (r17v5 int), (r17v9 int) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]
  0x0393: PHI (r18v6 int) = (r18v5 int), (r18v8 int) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]
  0x0393: PHI (r19v6 int) = (r19v5 int), (r19v8 int) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]
  0x0393: PHI (r26v5 int) = (r26v4 int), (r26v7 int) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]
  0x0393: PHI (r27v1 int) = (r27v0 int), (r27v3 int) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]
  0x0393: PHI (r28v8 sun.misc.Unsafe) = (r28v7 sun.misc.Unsafe), (r28v10 sun.misc.Unsafe) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:150:0x03a8 A[PHI: r0 r15 r17 r18 r19 r26 r27 r28
  0x03a8: PHI (r0v75 int) = (r0v69 int), (r0v78 int) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]
  0x03a8: PHI (r15v10 java.lang.Object) = (r15v7 java.lang.Object), (r15v12 java.lang.Object) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]
  0x03a8: PHI (r17v7 int) = (r17v5 int), (r17v9 int) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]
  0x03a8: PHI (r18v7 int) = (r18v5 int), (r18v8 int) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]
  0x03a8: PHI (r19v7 int) = (r19v5 int), (r19v8 int) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]
  0x03a8: PHI (r26v6 int) = (r26v4 int), (r26v7 int) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]
  0x03a8: PHI (r27v2 int) = (r27v0 int), (r27v3 int) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]
  0x03a8: PHI (r28v9 sun.misc.Unsafe) = (r28v7 sun.misc.Unsafe), (r28v10 sun.misc.Unsafe) binds: [B:148:0x0391, B:131:0x02fc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x004c  */
    /* JADX WARN: Failed to find 'out' block for switch in B:36:0x009f. Please report as an issue. */
    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final void a(Object obj, byte[] bArr, int i, int i2, C3183f c3183f) throws C3211o0 {
        int iA;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        int i8;
        Unsafe unsafe;
        int i9;
        int i10;
        int i11;
        int iE;
        int iC;
        int i12;
        boolean z2;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z3;
        this = this;
        Object obj2 = obj;
        bArr = bArr;
        i2 = i2;
        c3183f = c3183f;
        if (this.h) {
            Unsafe unsafe2 = r;
            int i17 = -1;
            int i18 = 0;
            int iA2 = i;
            int i19 = -1;
            int i20 = 0;
            int i21 = 0;
            int i22 = 1048575;
            while (iA2 < i2) {
                int iA3 = iA2 + 1;
                int i23 = bArr[iA2];
                if (i23 < 0) {
                    iA3 = AbstractC3186g.a(i23, bArr, iA3, c3183f);
                    i23 = c3183f.f2283a;
                }
                int i24 = i23;
                int i25 = (i24 == true ? 1 : 0) >>> 3;
                int i26 = (i24 == true ? 1 : 0) & 7;
                if (i25 > i19) {
                    int i27 = i20 / 3;
                    if (i25 < this.c || i25 > this.d) {
                        i3 = i17;
                    } else {
                        iA = this.a(i25, i27);
                        i3 = iA;
                    }
                } else if (i25 < this.c || i25 > this.d) {
                    i3 = i17;
                } else {
                    iA = this.a(i25, i18);
                    i3 = iA;
                }
                if (i3 == i17) {
                    i4 = i25;
                    i5 = iA3;
                    z = i24 == true ? 1 : 0;
                    i6 = i21;
                    i7 = i17;
                    i8 = i18;
                    unsafe = unsafe2;
                } else {
                    int[] iArr = this.f2259a;
                    int i28 = iArr[i3 + 1];
                    int i29 = (i28 & 267386880) >>> 20;
                    int i30 = iA3;
                    int i31 = i24 == true ? 1 : 0;
                    long j = i28 & 1048575;
                    if (i29 <= 17) {
                        int i32 = iArr[i3 + 2];
                        int i33 = 1 << (i32 >>> 20);
                        int i34 = i32 & 1048575;
                        if (i34 != i22) {
                            if (i22 != 1048575) {
                                unsafe2.putInt(obj2, i22, i21);
                            }
                            if (i34 != 1048575) {
                                i21 = unsafe2.getInt(obj2, i34);
                            }
                            i9 = i34;
                        } else {
                            i9 = i22;
                        }
                        int i35 = i21;
                        switch (i29) {
                            case 0:
                                i4 = i25;
                                i18 = i3;
                                i10 = i30;
                                if (i26 == 1) {
                                    i11 = i10;
                                    y1.c.a(obj, j, Double.longBitsToDouble(AbstractC3186g.b(i10, bArr)));
                                    iE = i11 + 8;
                                    i21 = i35 | i33;
                                    iA2 = iE;
                                    i22 = i9;
                                    i20 = i18;
                                    unsafe = unsafe2;
                                    i7 = -1;
                                    i8 = 0;
                                }
                                i12 = i10;
                                i6 = i35;
                                i5 = i12;
                                i22 = i9;
                                unsafe = unsafe2;
                                z = i31 == true ? 1 : 0;
                                i7 = -1;
                                i8 = 0;
                                break;
                            case 1:
                                i4 = i25;
                                i18 = i3;
                                i10 = i30;
                                if (i26 == 5) {
                                    y1.c.a(obj2, j, Float.intBitsToFloat(AbstractC3186g.a(i10, bArr)));
                                    iE = i10 + 4;
                                    i21 = i35 | i33;
                                    iA2 = iE;
                                    i22 = i9;
                                    i20 = i18;
                                    unsafe = unsafe2;
                                    i7 = -1;
                                    i8 = 0;
                                }
                                i12 = i10;
                                i6 = i35;
                                i5 = i12;
                                i22 = i9;
                                unsafe = unsafe2;
                                z = i31 == true ? 1 : 0;
                                i7 = -1;
                                i8 = 0;
                                break;
                            case 2:
                            case 3:
                                i4 = i25;
                                i18 = i3;
                                i10 = i30;
                                if (i26 == 0) {
                                    iE = AbstractC3186g.e(bArr, i10, c3183f);
                                    unsafe2.putLong(obj, j, c3183f.b);
                                    i21 = i35 | i33;
                                    iA2 = iE;
                                    i22 = i9;
                                    i20 = i18;
                                    unsafe = unsafe2;
                                    i7 = -1;
                                    i8 = 0;
                                }
                                i12 = i10;
                                i6 = i35;
                                i5 = i12;
                                i22 = i9;
                                unsafe = unsafe2;
                                z = i31 == true ? 1 : 0;
                                i7 = -1;
                                i8 = 0;
                                break;
                            case 4:
                            case 11:
                                i4 = i25;
                                i18 = i3;
                                i10 = i30;
                                if (i26 == 0) {
                                    int iA4 = i10 + 1;
                                    int i36 = bArr[i10];
                                    if (i36 >= 0) {
                                        c3183f.f2283a = i36;
                                    } else {
                                        iA4 = AbstractC3186g.a(i36, bArr, iA4, c3183f);
                                    }
                                    iE = iA4;
                                    unsafe2.putInt(obj2, j, c3183f.f2283a);
                                    i21 = i35 | i33;
                                    iA2 = iE;
                                    i22 = i9;
                                    i20 = i18;
                                    unsafe = unsafe2;
                                    i7 = -1;
                                    i8 = 0;
                                }
                                i12 = i10;
                                i6 = i35;
                                i5 = i12;
                                i22 = i9;
                                unsafe = unsafe2;
                                z = i31 == true ? 1 : 0;
                                i7 = -1;
                                i8 = 0;
                                break;
                            case 5:
                            case 14:
                                i4 = i25;
                                i18 = i3;
                                i10 = i30;
                                if (i26 == 1) {
                                    i11 = i10;
                                    unsafe2.putLong(obj, j, AbstractC3186g.b(i10, bArr));
                                    iE = i11 + 8;
                                    i21 = i35 | i33;
                                    iA2 = iE;
                                    i22 = i9;
                                    i20 = i18;
                                    unsafe = unsafe2;
                                    i7 = -1;
                                    i8 = 0;
                                }
                                i12 = i10;
                                i6 = i35;
                                i5 = i12;
                                i22 = i9;
                                unsafe = unsafe2;
                                z = i31 == true ? 1 : 0;
                                i7 = -1;
                                i8 = 0;
                                break;
                            case 6:
                            case 13:
                                i4 = i25;
                                i18 = i3;
                                i10 = i30;
                                if (i26 == 5) {
                                    unsafe2.putInt(obj2, j, AbstractC3186g.a(i10, bArr));
                                    iE = i10 + 4;
                                    i21 = i35 | i33;
                                    iA2 = iE;
                                    i22 = i9;
                                    i20 = i18;
                                    unsafe = unsafe2;
                                    i7 = -1;
                                    i8 = 0;
                                }
                                i12 = i10;
                                i6 = i35;
                                i5 = i12;
                                i22 = i9;
                                unsafe = unsafe2;
                                z = i31 == true ? 1 : 0;
                                i7 = -1;
                                i8 = 0;
                                break;
                            case 7:
                                i4 = i25;
                                i18 = i3;
                                i10 = i30;
                                if (i26 == 0) {
                                    iE = AbstractC3186g.e(bArr, i10, c3183f);
                                    y1.c.a(obj2, j, c3183f.b != 0);
                                    i21 = i35 | i33;
                                    iA2 = iE;
                                    i22 = i9;
                                    i20 = i18;
                                    unsafe = unsafe2;
                                    i7 = -1;
                                    i8 = 0;
                                }
                                i12 = i10;
                                i6 = i35;
                                i5 = i12;
                                i22 = i9;
                                unsafe = unsafe2;
                                z = i31 == true ? 1 : 0;
                                i7 = -1;
                                i8 = 0;
                                break;
                            case 8:
                                i4 = i25;
                                i18 = i3;
                                i10 = i30;
                                if (i26 == 2) {
                                    if ((i28 & 536870912) == 0) {
                                        iC = AbstractC3186g.b(bArr, i10, c3183f);
                                    } else {
                                        iC = AbstractC3186g.c(bArr, i10, c3183f);
                                    }
                                    iE = iC;
                                    unsafe2.putObject(obj2, j, c3183f.c);
                                    i21 = i35 | i33;
                                    iA2 = iE;
                                    i22 = i9;
                                    i20 = i18;
                                    unsafe = unsafe2;
                                    i7 = -1;
                                    i8 = 0;
                                }
                                i12 = i10;
                                i6 = i35;
                                i5 = i12;
                                i22 = i9;
                                unsafe = unsafe2;
                                z = i31 == true ? 1 : 0;
                                i7 = -1;
                                i8 = 0;
                                break;
                            case 9:
                                i4 = i25;
                                i18 = i3;
                                i10 = i30;
                                if (i26 == 2) {
                                    iE = AbstractC3186g.a(this.c(i18), bArr, i10, i2, c3183f);
                                    Object object = unsafe2.getObject(obj2, j);
                                    if (object == null) {
                                        unsafe2.putObject(obj2, j, c3183f.c);
                                    } else {
                                        unsafe2.putObject(obj2, j, AbstractC3205m0.a(object, c3183f.c));
                                    }
                                    i21 = i35 | i33;
                                    iA2 = iE;
                                    i22 = i9;
                                    i20 = i18;
                                    unsafe = unsafe2;
                                    i7 = -1;
                                    i8 = 0;
                                }
                                i12 = i10;
                                i6 = i35;
                                i5 = i12;
                                i22 = i9;
                                unsafe = unsafe2;
                                z = i31 == true ? 1 : 0;
                                i7 = -1;
                                i8 = 0;
                                break;
                            case 10:
                                i4 = i25;
                                i18 = i3;
                                i10 = i30;
                                if (i26 == 2) {
                                    iE = AbstractC3186g.a(bArr, i10, c3183f);
                                    unsafe2.putObject(obj2, j, c3183f.c);
                                    i21 = i35 | i33;
                                    iA2 = iE;
                                    i22 = i9;
                                    i20 = i18;
                                    unsafe = unsafe2;
                                    i7 = -1;
                                    i8 = 0;
                                }
                                i12 = i10;
                                i6 = i35;
                                i5 = i12;
                                i22 = i9;
                                unsafe = unsafe2;
                                z = i31 == true ? 1 : 0;
                                i7 = -1;
                                i8 = 0;
                                break;
                            case 12:
                                i4 = i25;
                                i18 = i3;
                                i10 = i30;
                                if (i26 == 0) {
                                    int iA5 = i10 + 1;
                                    int i37 = bArr[i10];
                                    if (i37 >= 0) {
                                        c3183f.f2283a = i37;
                                    } else {
                                        iA5 = AbstractC3186g.a(i37, bArr, iA5, c3183f);
                                    }
                                    iE = iA5;
                                    unsafe2.putInt(obj2, j, c3183f.f2283a);
                                    i21 = i35 | i33;
                                    iA2 = iE;
                                    i22 = i9;
                                    i20 = i18;
                                    unsafe = unsafe2;
                                    i7 = -1;
                                    i8 = 0;
                                }
                                i12 = i10;
                                i6 = i35;
                                i5 = i12;
                                i22 = i9;
                                unsafe = unsafe2;
                                z = i31 == true ? 1 : 0;
                                i7 = -1;
                                i8 = 0;
                                break;
                            case 15:
                                i4 = i25;
                                i18 = i3;
                                i10 = i30;
                                if (i26 == 0) {
                                    int iA6 = i10 + 1;
                                    int i38 = bArr[i10];
                                    if (i38 >= 0) {
                                        c3183f.f2283a = i38;
                                    } else {
                                        iA6 = AbstractC3186g.a(i38, bArr, iA6, c3183f);
                                    }
                                    iE = iA6;
                                    unsafe2.putInt(obj2, j, AbstractC3229w.b(c3183f.f2283a));
                                    i21 = i35 | i33;
                                    iA2 = iE;
                                    i22 = i9;
                                    i20 = i18;
                                    unsafe = unsafe2;
                                    i7 = -1;
                                    i8 = 0;
                                }
                                i12 = i10;
                                i6 = i35;
                                i5 = i12;
                                i22 = i9;
                                unsafe = unsafe2;
                                z = i31 == true ? 1 : 0;
                                i7 = -1;
                                i8 = 0;
                                break;
                            case 16:
                                if (i26 != 0) {
                                    i4 = i25;
                                    i18 = i3;
                                    i10 = i30;
                                    i12 = i10;
                                    i6 = i35;
                                    i5 = i12;
                                    i22 = i9;
                                    unsafe = unsafe2;
                                    z = i31 == true ? 1 : 0;
                                    i7 = -1;
                                    i8 = 0;
                                } else {
                                    iE = AbstractC3186g.e(bArr, i30, c3183f);
                                    i18 = i3;
                                    i4 = i25;
                                    unsafe2.putLong(obj, j, AbstractC3229w.a(c3183f.b));
                                    i21 = i35 | i33;
                                    iA2 = iE;
                                    i22 = i9;
                                    i20 = i18;
                                    unsafe = unsafe2;
                                    i7 = -1;
                                    i8 = 0;
                                }
                                break;
                            default:
                                i4 = i25;
                                i18 = i3;
                                i12 = i30;
                                i6 = i35;
                                i5 = i12;
                                i22 = i9;
                                unsafe = unsafe2;
                                z = i31 == true ? 1 : 0;
                                i7 = -1;
                                i8 = 0;
                                break;
                        }
                        i17 = i7;
                        i18 = i8;
                        i19 = i4;
                        unsafe2 = unsafe;
                    } else {
                        i4 = i25;
                        int i39 = i3;
                        if (i29 != 27) {
                            z2 = i31 == true ? 1 : 0;
                            if (i29 <= 49) {
                                i6 = i21;
                                i13 = i22;
                                i7 = -1;
                                i8 = 0;
                                unsafe = unsafe2;
                                iA2 = a(obj, bArr, i30, i2, z2 ? 1 : 0, i26, i39, i28, i29, j, c3183f);
                                i16 = i39;
                                obj2 = obj;
                                if (iA2 != i30) {
                                    i20 = i16;
                                    i17 = i7;
                                    i18 = i8;
                                    i19 = i4;
                                    i21 = i6;
                                    i22 = i13;
                                } else {
                                    i5 = iA2;
                                    i18 = i16;
                                    i22 = i13;
                                    z = z2;
                                }
                            } else {
                                i6 = i21;
                                i13 = i22;
                                i14 = i30;
                                i15 = i39;
                                unsafe = unsafe2;
                                i7 = -1;
                                i8 = 0;
                                if (i29 != 50) {
                                    i16 = i15;
                                    obj2 = obj;
                                    iA2 = a(obj, bArr, i14, i2, z2 ? 1 : 0, i4, i26, i28, i29, j, i16, c3183f);
                                    if (iA2 != i14) {
                                        i20 = i16;
                                        i17 = i7;
                                        i18 = i8;
                                        i19 = i4;
                                        i21 = i6;
                                        i22 = i13;
                                    } else {
                                        i5 = iA2;
                                        i18 = i16;
                                        i22 = i13;
                                        z = z2;
                                    }
                                } else if (i26 == 2) {
                                    z3 = z2;
                                    Unsafe unsafe3 = r;
                                    Object objB = b(i15);
                                    Object object2 = unsafe3.getObject(obj, j);
                                    this.p.getClass();
                                    if (!((C3236z0) object2).f2306a) {
                                        this.p.getClass();
                                        C3236z0 c3236z0 = C3236z0.b;
                                        C3236z0 c3236z1 = c3236z0.isEmpty() ? new C3236z0() : new C3236z0(c3236z0);
                                        this.p.getClass();
                                        A0.a(c3236z1, object2);
                                        unsafe3.putObject(obj, j, c3236z1);
                                    }
                                    this.p.getClass();
                                    objB.getClass();
                                    throw new ClassCastException();
                                }
                            }
                            unsafe2 = unsafe;
                        } else if (i26 == 2) {
                            InterfaceC3202l0 interfaceC3202l0B = (InterfaceC3202l0) unsafe2.getObject(obj2, j);
                            if (!((AbstractC3174c) interfaceC3202l0B).f2277a) {
                                int size = interfaceC3202l0B.size();
                                interfaceC3202l0B = interfaceC3202l0B.b(size == 0 ? 10 : size * 2);
                                unsafe2.putObject(obj2, j, interfaceC3202l0B);
                            }
                            U0 u0C = this.c(i39);
                            int iA7 = AbstractC3186g.a(u0C, bArr, i30, i2, c3183f);
                            interfaceC3202l0B.add(c3183f.c);
                            while (iA7 < i2) {
                                int iA8 = iA7 + 1;
                                int i40 = bArr[iA7];
                                if (i40 >= 0) {
                                    c3183f.f2283a = i40;
                                } else {
                                    iA8 = AbstractC3186g.a(i40, bArr, iA8, c3183f);
                                }
                                int i41 = i31;
                                if (i41 != c3183f.f2283a) {
                                    iA2 = iA7;
                                    i20 = i39;
                                    i19 = i4;
                                    i17 = -1;
                                    i18 = 0;
                                } else {
                                    iA7 = AbstractC3186g.a(u0C, bArr, iA8, i2, c3183f);
                                    interfaceC3202l0B.add(c3183f.c);
                                    i31 = i41 == true ? 1 : 0;
                                }
                            }
                            iA2 = iA7;
                            i20 = i39;
                            i19 = i4;
                            i17 = -1;
                            i18 = 0;
                        } else {
                            i6 = i21;
                            i13 = i22;
                            i14 = i30;
                            i15 = i39;
                            unsafe = unsafe2;
                            z3 = i31 == true ? 1 : 0;
                            i7 = -1;
                            i8 = 0;
                        }
                        z3 = z2;
                        i5 = i14;
                        i18 = i15;
                        i22 = i13;
                        obj2 = obj;
                        z = z3;
                    }
                }
                AbstractC3169a0 abstractC3169a0 = (AbstractC3169a0) obj2;
                C3212o1 c3212o1 = abstractC3169a0.unknownFields;
                if (c3212o1 == C3212o1.f) {
                    c3212o1 = new C3212o1();
                    abstractC3169a0.unknownFields = c3212o1;
                }
                iA2 = AbstractC3186g.a(z ? 1 : 0, bArr, i5, i2, c3212o1, c3183f);
                i20 = i18;
                i21 = i6;
                i17 = i7;
                i18 = i8;
                i19 = i4;
                unsafe2 = unsafe;
            }
            int i42 = i21;
            Unsafe unsafe4 = unsafe2;
            if (i22 != 1048575) {
                unsafe4.putInt(obj2, i22, i42);
            }
            if (iA2 != i2) {
                throw new C3211o0("Failed to parse the message.");
            }
            return;
        }
        a(obj, bArr, i, i2, 0, c3183f);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cd A[LOOP:1: B:49:0x00bc->B:54:0x00cd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:76:0x00cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x00f0 A[SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final boolean a(Object obj) {
        List list;
        U0 u0C;
        int i;
        boolean zA;
        int i2 = 1048575;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean zA2 = true;
            if (i3 < this.j) {
                int i5 = this.i[i3];
                int[] iArr = this.f2259a;
                int i6 = iArr[i5];
                int i7 = iArr[i5 + 1];
                int i8 = iArr[i5 + 2];
                int i9 = i8 & 1048575;
                int i10 = 1 << (i8 >>> 20);
                if (i9 != i2) {
                    if (i9 != 1048575) {
                        i4 = r.getInt(obj, i9);
                    }
                    i2 = i9;
                }
                if ((268435456 & i7) != 0) {
                    if (i2 == 1048575) {
                        zA = a(i5, obj);
                    } else {
                        zA = (i4 & i10) != 0;
                    }
                    if (!zA) {
                        return false;
                    }
                }
                int i11 = (267386880 & i7) >>> 20;
                if (i11 == 9 || i11 == 17) {
                    if (i2 == 1048575) {
                        zA2 = a(i5, obj);
                    } else if ((i10 & i4) == 0) {
                        zA2 = false;
                    }
                    if (zA2 && !c(i5).a(y1.e(obj, i7 & 1048575))) {
                        return false;
                    }
                } else if (i11 == 27) {
                    list = (List) y1.e(obj, i7 & 1048575);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        u0C = c(i5);
                        for (i = 0; i < list.size(); i++) {
                            if (!u0C.a(list.get(i))) {
                                return false;
                            }
                        }
                    }
                } else if (i11 == 60 || i11 == 68) {
                    if (a(obj, i6, i5) && !c(i5).a(y1.e(obj, i7 & 1048575))) {
                        return false;
                    }
                } else if (i11 == 49) {
                    list = (List) y1.e(obj, i7 & 1048575);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        u0C = c(i5);
                        while (i < list.size()) {
                            if (!u0C.a(list.get(i))) {
                                return false;
                            }
                        }
                    }
                } else if (i11 != 50) {
                    continue;
                } else {
                    A0 a0 = this.p;
                    Object objE = y1.e(obj, i7 & 1048575);
                    a0.getClass();
                    if (!((C3236z0) objE).isEmpty()) {
                        Object objB = b(i5);
                        this.p.getClass();
                        objB.getClass();
                        throw new ClassCastException();
                    }
                }
                i3++;
            } else {
                if (this.f) {
                    this.o.getClass();
                    if (!((GeneratedMessageLite$ExtendableMessage) obj).extensions.c()) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public static void a(int i, Object obj, C c) {
        if (obj instanceof String) {
            c.f2252a.a((String) obj, i);
        } else {
            c.f2252a.a(i, (AbstractC3221s) obj);
        }
    }

    public final void a(Object obj, int i, T0 t0) {
        if ((536870912 & i) != 0) {
            t0.b(this.m.b(obj, i & 1048575));
        } else {
            t0.q(this.m.b(obj, i & 1048575));
        }
    }

    public final void a(Object obj, int i, T0 t0, U0 u0, H h) {
        t0.b(this.m.b(obj, i & 1048575), u0, h);
    }

    public final void a(Object obj, long j, T0 t0, U0 u0, H h) {
        t0.a(this.m.b(obj, j), u0, h);
    }

    public final boolean a(int i, Object obj) {
        int[] iArr = this.f2259a;
        int i2 = iArr[i + 2];
        long j = i2 & 1048575;
        if (j != 1048575) {
            return ((1 << (i2 >>> 20)) & y1.c(obj, j)) != 0;
        }
        int i3 = iArr[i + 1];
        long j2 = i3 & 1048575;
        switch ((i3 & 267386880) >>> 20) {
            case 0:
                return y1.c.c(obj, j2) != 0.0d;
            case 1:
                return y1.c.d(obj, j2) != 0.0f;
            case 2:
                return y1.d(obj, j2) != 0;
            case 3:
                return y1.d(obj, j2) != 0;
            case 4:
                return y1.c(obj, j2) != 0;
            case 5:
                return y1.d(obj, j2) != 0;
            case 6:
                return y1.c(obj, j2) != 0;
            case 7:
                return y1.c.a(obj, j2);
            case 8:
                Object objE = y1.e(obj, j2);
                if (objE instanceof String) {
                    return !((String) objE).isEmpty();
                }
                if (objE instanceof AbstractC3221s) {
                    return !AbstractC3221s.b.equals(objE);
                }
                throw new IllegalArgumentException();
            case 9:
                return y1.e(obj, j2) != null;
            case 10:
                return !AbstractC3221s.b.equals(y1.e(obj, j2));
            case 11:
                return y1.c(obj, j2) != 0;
            case 12:
                return y1.c(obj, j2) != 0;
            case 13:
                return y1.c(obj, j2) != 0;
            case 14:
                return y1.d(obj, j2) != 0;
            case 15:
                return y1.c(obj, j2) != 0;
            case 16:
                return y1.d(obj, j2) != 0;
            case 17:
                return y1.e(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean a(Object obj, int i, int i2) {
        return y1.c(obj, (long) (this.f2259a[i2 + 2] & 1048575)) == i;
    }

    public final boolean a(int i, Object obj, Object obj2) {
        return a(i, obj) == a(i, obj2);
    }

    public final int a(int i, int i2) {
        int length = (this.f2259a.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.f2259a[i4];
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
}
