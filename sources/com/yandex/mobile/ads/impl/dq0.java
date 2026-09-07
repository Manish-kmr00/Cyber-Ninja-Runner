package com.yandex.mobile.ads.impl;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes9.dex */
public final class dq0 extends eq0 {

    private static class a extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final int[] b;
        final int c;
        final int d;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean isEmpty() {
            return false;
        }

        a(int i, int i2, int[] iArr) {
            this.b = iArr;
            this.c = i;
            this.d = i2;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i) {
            rj1.a(i, this.d - this.c);
            return Integer.valueOf(this.b[this.c + i]);
        }

        @Override // java.util.AbstractList, java.util.List
        public final List<Integer> subList(int i, int i2) {
            rj1.a(i, i2, this.d - this.c);
            if (i == i2) {
                return Collections.emptyList();
            }
            int[] iArr = this.b;
            int i3 = this.c;
            return new a(i + i3, i3 + i2, iArr);
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object set(int i, Object obj) {
            Integer num = (Integer) obj;
            rj1.a(i, this.d - this.c);
            int[] iArr = this.b;
            int i2 = this.c + i;
            int i3 = iArr[i2];
            num.getClass();
            iArr[i2] = num.intValue();
            return Integer.valueOf(i3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.d - this.c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean contains(@CheckForNull Object obj) {
            if (obj instanceof Integer) {
                int[] iArr = this.b;
                int iIntValue = ((Integer) obj).intValue();
                int i = this.d;
                for (int i2 = this.c; i2 < i; i2++) {
                    if (iArr[i2] == iIntValue) {
                        if (i2 != -1) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x001e  */
        @Override // java.util.AbstractList, java.util.List
        public final int indexOf(@CheckForNull Object obj) {
            if (obj instanceof Integer) {
                int[] iArr = this.b;
                int iIntValue = ((Integer) obj).intValue();
                int i = this.c;
                int i2 = this.d;
                while (i < i2) {
                    if (iArr[i] != iIntValue) {
                        i++;
                    } else if (i >= 0) {
                        return i - this.c;
                    }
                }
                i = -1;
                if (i >= 0) {
                    return i - this.c;
                }
            }
            return -1;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0020  */
        @Override // java.util.AbstractList, java.util.List
        public final int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Integer) {
                int[] iArr = this.b;
                int iIntValue = ((Integer) obj).intValue();
                int i = this.c;
                int i2 = this.d - 1;
                while (i2 >= i) {
                    if (iArr[i2] != iIntValue) {
                        i2--;
                    } else if (i2 >= 0) {
                        return i2 - this.c;
                    }
                }
                i2 = -1;
                if (i2 >= 0) {
                    return i2 - this.c;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                int i = this.d - this.c;
                if (aVar.d - aVar.c != i) {
                    return false;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (this.b[this.c + i2] != aVar.b[aVar.c + i2]) {
                        return false;
                    }
                }
                return true;
            }
            return super.equals(obj);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final int hashCode() {
            int i = 1;
            for (int i2 = this.c; i2 < this.d; i2++) {
                i = (i * 31) + this.b[i2];
            }
            return i;
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            StringBuilder sb = new StringBuilder((this.d - this.c) * 5);
            sb.append(AbstractJsonLexerKt.BEGIN_LIST).append(this.b[this.c]);
            int i = this.c;
            while (true) {
                i++;
                if (i < this.d) {
                    sb.append(", ").append(this.b[i]);
                } else {
                    return sb.append(AbstractJsonLexerKt.END_LIST).toString();
                }
            }
        }

        final int[] b() {
            return Arrays.copyOfRange(this.b, this.c, this.d);
        }
    }

    public static int b(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static List<Integer> a(int... iArr) {
        if (iArr.length == 0) {
            return Collections.emptyList();
        }
        return new a(0, iArr.length, iArr);
    }

    public static int a(long j) {
        int i = (int) j;
        if (((long) i) == j) {
            return i;
        }
        throw new IllegalArgumentException(b32.a("Out of range: %s", Long.valueOf(j)));
    }

    public static int[] a(AbstractCollection abstractCollection) {
        if (abstractCollection instanceof a) {
            return ((a) abstractCollection).b();
        }
        Object[] array = abstractCollection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            obj.getClass();
            iArr[i] = ((Number) obj).intValue();
        }
        return iArr;
    }
}
