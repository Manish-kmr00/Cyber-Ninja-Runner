package com.yandex.mobile.ads.impl;

import com.google.firebase.FirebaseError;
import java.io.IOException;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes4.dex */
final class rz implements x40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f10154a = new byte[8];
    private final ArrayDeque<a> b = new ArrayDeque<>();
    private final i92 c = new i92();
    private w40 d;
    private int e;
    private int f;
    private long g;

    public final void a(w40 w40Var) {
        this.d = w40Var;
    }

    public final boolean a(tz tzVar) throws IOException {
        int i;
        String str;
        double dLongBitsToDouble;
        int iA;
        int iA2;
        if (this.d == null) {
            throw new IllegalStateException();
        }
        while (true) {
            a aVarPeek = this.b.peek();
            if (aVarPeek != null && tzVar.a() >= aVarPeek.b) {
                hu0.this.b(this.b.pop().f10155a);
                return true;
            }
            if (this.e == 0) {
                long jA = this.c.a(tzVar, true, false, 4);
                if (jA == -2) {
                    tzVar.c();
                    while (true) {
                        tzVar.b(this.f10154a, 0, 4, false);
                        iA = i92.a(this.f10154a[0]);
                        if (iA != -1 && iA <= 4) {
                            iA2 = (int) i92.a(this.f10154a, iA, false);
                            hu0.this.getClass();
                            if (iA2 == 357149030 || iA2 == 524531317 || iA2 == 475249515 || iA2 == 374648427) {
                            }
                        }
                        tzVar.a(1);
                    }
                    tzVar.a(iA);
                    jA = iA2;
                }
                if (jA == -1) {
                    return false;
                }
                this.f = (int) jA;
                this.e = 1;
            }
            if (this.e == 1) {
                this.g = this.c.a(tzVar, false, true, 8);
                this.e = 2;
            }
            w40 w40Var = this.d;
            int i2 = this.f;
            hu0.this.getClass();
            switch (i2) {
                case MRAID_JS_WRITE_FAILED_VALUE:
                case 136:
                case 155:
                case 159:
                case 176:
                case 179:
                case 186:
                case AD_RESPONSE_EMPTY_VALUE:
                case 231:
                case 238:
                case 241:
                case 251:
                case 16871:
                case 16980:
                case 17029:
                case 17143:
                case 18401:
                case 18408:
                case 20529:
                case 20530:
                case 21420:
                case 21432:
                case 21680:
                case 21682:
                case 21690:
                case 21930:
                case 21945:
                case 21946:
                case 21947:
                case 21948:
                case 21949:
                case 21998:
                case 22186:
                case 22203:
                case 25188:
                case 30114:
                case 30321:
                case 2352003:
                case 2807729:
                    i = 2;
                    break;
                case 134:
                case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
                case 21358:
                case 2274716:
                    i = 3;
                    break;
                case 160:
                case 166:
                case 174:
                case 183:
                case 187:
                case 224:
                case 225:
                case 16868:
                case 18407:
                case 19899:
                case 20532:
                case 20533:
                case 21936:
                case 21968:
                case 25152:
                case 28032:
                case 30113:
                case 30320:
                case 290298740:
                case 357149030:
                case 374648427:
                case 408125543:
                case 440786851:
                case 475249515:
                case 524531317:
                    i = 1;
                    break;
                case 161:
                case 163:
                case 165:
                case 16877:
                case 16981:
                case 18402:
                case 21419:
                case 25506:
                case 30322:
                    i = 4;
                    break;
                case 181:
                case 17545:
                case 21969:
                case 21970:
                case 21971:
                case 21972:
                case 21973:
                case 21974:
                case 21975:
                case 21976:
                case 21977:
                case 21978:
                case 30323:
                case 30324:
                case 30325:
                    i = 5;
                    break;
                default:
                    i = 0;
                    break;
            }
            if (i != 0) {
                if (i == 1) {
                    long jA2 = tzVar.a();
                    this.b.push(new a(this.f, this.g + jA2));
                    ((hu0.a) this.d).a(this.f, jA2, this.g);
                    this.e = 0;
                    return true;
                }
                long j = 0;
                if (i == 2) {
                    long j2 = this.g;
                    if (j2 <= 8) {
                        w40 w40Var2 = this.d;
                        int i3 = this.f;
                        int i4 = (int) j2;
                        tzVar.a(this.f10154a, 0, i4, false);
                        for (int i5 = 0; i5 < i4; i5++) {
                            j = (j << 8) | ((long) (this.f10154a[i5] & 255));
                        }
                        ((hu0.a) w40Var2).a(i3, j);
                        this.e = 0;
                        return true;
                    }
                    throw ag1.a("Invalid integer size: " + this.g, (Exception) null);
                }
                if (i == 3) {
                    long j3 = this.g;
                    if (j3 <= 2147483647L) {
                        w40 w40Var3 = this.d;
                        int i6 = this.f;
                        int i7 = (int) j3;
                        if (i7 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i7];
                            tzVar.a(bArr, 0, i7, false);
                            while (i7 > 0 && bArr[i7 - 1] == 0) {
                                i7--;
                            }
                            str = new String(bArr, 0, i7);
                        }
                        ((hu0.a) w40Var3).a(i6, str);
                        this.e = 0;
                        return true;
                    }
                    throw ag1.a("String element size: " + this.g, (Exception) null);
                }
                if (i == 4) {
                    ((hu0.a) this.d).a(this.f, (int) this.g, tzVar);
                    this.e = 0;
                    return true;
                }
                if (i != 5) {
                    throw ag1.a("Invalid element type " + i, (Exception) null);
                }
                long j4 = this.g;
                if (j4 != 4 && j4 != 8) {
                    throw ag1.a("Invalid float size: " + this.g, (Exception) null);
                }
                w40 w40Var4 = this.d;
                int i8 = this.f;
                int i9 = (int) j4;
                tzVar.a(this.f10154a, 0, i9, false);
                for (int i10 = 0; i10 < i9; i10++) {
                    j = ((long) (this.f10154a[i10] & 255)) | (j << 8);
                }
                if (i9 == 4) {
                    dLongBitsToDouble = Float.intBitsToFloat((int) j);
                } else {
                    dLongBitsToDouble = Double.longBitsToDouble(j);
                }
                ((hu0.a) w40Var4).a(i8, dLongBitsToDouble);
                this.e = 0;
                return true;
            }
            tzVar.a((int) this.g);
            this.e = 0;
        }
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10155a;
        private final long b;

        private a(int i, long j) {
            this.f10155a = i;
            this.b = j;
        }
    }

    public final void a() {
        this.e = 0;
        this.b.clear();
        this.c.b();
    }
}
