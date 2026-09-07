package com.fyber.inneractive.sdk.protobuf;

import com.json.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.o1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3212o1 {
    public static final C3212o1 f = new C3212o1(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2293a;
    public int[] b;
    public Object[] c;
    public int d;
    public boolean e;

    public C3212o1() {
        this(0, new int[8], new Object[8], true);
    }

    public static C3212o1 a(C3212o1 c3212o1, C3212o1 c3212o2) {
        int i = c3212o1.f2293a + c3212o2.f2293a;
        int[] iArrCopyOf = Arrays.copyOf(c3212o1.b, i);
        System.arraycopy(c3212o2.b, 0, iArrCopyOf, c3212o1.f2293a, c3212o2.f2293a);
        Object[] objArrCopyOf = Arrays.copyOf(c3212o1.c, i);
        System.arraycopy(c3212o2.c, 0, objArrCopyOf, c3212o1.f2293a, c3212o2.f2293a);
        return new C3212o1(i, iArrCopyOf, objArrCopyOf, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C3212o1)) {
            return false;
        }
        C3212o1 c3212o1 = (C3212o1) obj;
        int i = this.f2293a;
        if (i == c3212o1.f2293a) {
            int[] iArr = this.b;
            int[] iArr2 = c3212o1.b;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] == iArr2[i2]) {
                }
            }
            Object[] objArr = this.c;
            Object[] objArr2 = c3212o1.c;
            int i3 = this.f2293a;
            for (int i4 = 0; i4 < i3; i4++) {
                if (objArr[i4].equals(objArr2[i4])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f2293a;
        int i2 = (i + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
        int[] iArr = this.b;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.c;
        int i6 = this.f2293a;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public C3212o1(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.f2293a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }

    public final boolean a(int i, AbstractC3229w abstractC3229w) throws C3208n0 {
        int iT;
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            a(i, Long.valueOf(abstractC3229w.l()));
            return true;
        }
        if (i3 == 1) {
            a(i, Long.valueOf(abstractC3229w.i()));
            return true;
        }
        if (i3 == 2) {
            a(i, abstractC3229w.e());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                int i4 = C3211o0.f2292a;
                throw new C3208n0();
            }
            a(i, Integer.valueOf(abstractC3229w.h()));
            return true;
        }
        C3212o1 c3212o1 = new C3212o1();
        do {
            iT = abstractC3229w.t();
            if (iT == 0) {
                break;
            }
        } while (c3212o1.a(iT, abstractC3229w));
        abstractC3229w.a((i2 << 3) | 4);
        a(i, c3212o1);
        return true;
    }

    public final void a(int i, Object obj) {
        if (this.e) {
            int i2 = this.f2293a;
            int[] iArr = this.b;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.b = Arrays.copyOf(iArr, i3);
                this.c = Arrays.copyOf(this.c, i3);
            }
            int[] iArr2 = this.b;
            int i4 = this.f2293a;
            iArr2[i4] = i;
            this.c[i4] = obj;
            this.f2293a = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void a(C c) {
        if (this.f2293a == 0) {
            return;
        }
        c.getClass();
        for (int i = 0; i < this.f2293a; i++) {
            int i2 = this.b[i];
            Object obj = this.c[i];
            int i3 = i2 >>> 3;
            int i4 = i2 & 7;
            if (i4 == 0) {
                c.f2252a.b(i3, ((Long) obj).longValue());
            } else if (i4 == 1) {
                c.f2252a.a(i3, ((Long) obj).longValue());
            } else if (i4 == 2) {
                c.f2252a.a(i3, (AbstractC3221s) obj);
            } else if (i4 != 3) {
                if (i4 != 5) {
                    int i5 = C3211o0.f2292a;
                    throw new RuntimeException(new C3208n0());
                }
                c.f2252a.a(i3, ((Integer) obj).intValue());
            } else {
                c.f2252a.c(i3, 3);
                ((C3212o1) obj).a(c);
                c.f2252a.c(i3, 4);
            }
        }
    }

    public final int a() {
        int iB;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iA = 0;
        for (int i2 = 0; i2 < this.f2293a; i2++) {
            int i3 = this.b[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 == 0) {
                iB = B.b(i4) + B.a(((Long) this.c[i2]).longValue());
            } else if (i5 == 1) {
                ((Long) this.c[i2]).getClass();
                iB = B.b(i4) + 8;
            } else if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 5) {
                        int i6 = C3211o0.f2292a;
                        throw new IllegalStateException(new C3208n0());
                    }
                    ((Integer) this.c[i2]).getClass();
                    iB = B.b(i4) + 4;
                } else {
                    iA = ((C3212o1) this.c[i2]).a() + (B.b(i4) * 2) + iA;
                }
            } else {
                iB = B.a((AbstractC3221s) this.c[i2]) + B.b(i4);
            }
            iA = iB + iA;
        }
        this.d = iA;
        return iA;
    }
}
