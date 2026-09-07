package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class n5 implements jm {
    public static final n5 h = new n5(null, new a[0], 0, -9223372036854775807L, 0);
    private static final a i = new a(0, -1, new int[0], new Uri[0], new long[0], 0, false).a();
    public static final jm.a<n5> j = new jm.a() { // from class: com.yandex.mobile.ads.impl.n5$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.jm.a
        public final jm fromBundle(Bundle bundle) {
            return n5.a(bundle);
        }
    };
    public final Object b;
    public final int c;
    public final long d;
    public final long e;
    public final int f;
    private final a[] g;

    public static final class a implements jm {
        public static final jm.a<a> i = new jm.a() { // from class: com.yandex.mobile.ads.impl.n5$a$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return n5.a.a(bundle);
            }
        };
        public final long b;
        public final int c;
        public final Uri[] d;
        public final int[] e;
        public final long[] f;
        public final long g;
        public final boolean h;

        /* JADX INFO: Access modifiers changed from: private */
        public static a a(Bundle bundle) {
            long j = bundle.getLong(Integer.toString(0, 36));
            int i2 = bundle.getInt(Integer.toString(1, 36), -1);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(Integer.toString(2, 36));
            int[] intArray = bundle.getIntArray(Integer.toString(3, 36));
            long[] longArray = bundle.getLongArray(Integer.toString(4, 36));
            return new a(j, i2, intArray == null ? new int[0] : intArray, parcelableArrayList == null ? new Uri[0] : (Uri[]) parcelableArrayList.toArray(new Uri[0]), longArray == null ? new long[0] : longArray, bundle.getLong(Integer.toString(5, 36)), bundle.getBoolean(Integer.toString(6, 36)));
        }

        private a(long j, int i2, int[] iArr, Uri[] uriArr, long[] jArr, long j2, boolean z) {
            hg.a(iArr.length == uriArr.length);
            this.b = j;
            this.c = i2;
            this.e = iArr;
            this.d = uriArr;
            this.f = jArr;
            this.g = j2;
            this.h = z;
        }

        public final int a(int i2) {
            int i3;
            int i4 = i2 + 1;
            while (true) {
                int[] iArr = this.e;
                if (i4 >= iArr.length || this.h || (i3 = iArr[i4]) == 0 || i3 == 1) {
                    break;
                }
                i4++;
            }
            return i4;
        }

        public final a a() {
            int[] iArr = this.e;
            int length = iArr.length;
            int iMax = Math.max(0, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            long[] jArr = this.f;
            int length2 = jArr.length;
            int iMax2 = Math.max(0, length2);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax2);
            Arrays.fill(jArrCopyOf, length2, iMax2, -9223372036854775807L);
            return new a(this.b, 0, iArrCopyOf, (Uri[]) Arrays.copyOf(this.d, 0), jArrCopyOf, this.g, this.h);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.c == aVar.c && Arrays.equals(this.d, aVar.d) && Arrays.equals(this.e, aVar.e) && Arrays.equals(this.f, aVar.f) && this.g == aVar.g && this.h == aVar.h;
        }

        public final int hashCode() {
            int i2 = this.c * 31;
            long j = this.b;
            int iHashCode = (Arrays.hashCode(this.f) + ((Arrays.hashCode(this.e) + ((((i2 + ((int) (j ^ (j >>> 32)))) * 31) + Arrays.hashCode(this.d)) * 31)) * 31)) * 31;
            long j2 = this.g;
            return ((iHashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.h ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static n5 a(Bundle bundle) {
        a[] aVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(Integer.toString(1, 36));
        if (parcelableArrayList == null) {
            aVarArr = new a[0];
        } else {
            a[] aVarArr2 = new a[parcelableArrayList.size()];
            for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                aVarArr2[i2] = (a) a.i.fromBundle((Bundle) parcelableArrayList.get(i2));
            }
            aVarArr = aVarArr2;
        }
        return new n5(null, aVarArr, bundle.getLong(Integer.toString(2, 36), 0L), bundle.getLong(Integer.toString(3, 36), -9223372036854775807L), bundle.getInt(Integer.toString(4, 36)));
    }

    private n5(Object obj, a[] aVarArr, long j2, long j3, int i2) {
        this.b = obj;
        this.d = j2;
        this.e = j3;
        this.c = aVarArr.length + i2;
        this.g = aVarArr;
        this.f = i2;
    }

    public final a a(int i2) {
        int i3 = this.f;
        if (i2 < i3) {
            return i;
        }
        return this.g[i2 - i3];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n5.class != obj.getClass()) {
            return false;
        }
        n5 n5Var = (n5) obj;
        return x82.a(this.b, n5Var.b) && this.c == n5Var.c && this.d == n5Var.d && this.e == n5Var.e && this.f == n5Var.f && Arrays.equals(this.g, n5Var.g);
    }

    public final int hashCode() {
        int i2 = this.c * 31;
        Object obj = this.b;
        return ((((((((i2 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.d)) * 31) + ((int) this.e)) * 31) + this.f) * 31) + Arrays.hashCode(this.g);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AdPlaybackState(adsId=");
        sb.append(this.b);
        sb.append(", adResumePositionUs=");
        sb.append(this.d);
        sb.append(", adGroups=[");
        for (int i2 = 0; i2 < this.g.length; i2++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.g[i2].b);
            sb.append(", ads=[");
            for (int i3 = 0; i3 < this.g[i2].e.length; i3++) {
                sb.append("ad(state=");
                int i4 = this.g[i2].e[i3];
                if (i4 == 0) {
                    sb.append('_');
                } else if (i4 == 1) {
                    sb.append('R');
                } else if (i4 == 2) {
                    sb.append('S');
                } else if (i4 == 3) {
                    sb.append('P');
                } else if (i4 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(this.g[i2].f[i3]);
                sb.append(')');
                if (i3 < this.g[i2].e.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i2 < this.g.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }
}
