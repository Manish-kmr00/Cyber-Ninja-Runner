package com.bytedance.adsdk.Og;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes10.dex */
public final class pA<E> implements Collection<E>, Set<E> {
    private static int JG;
    private static Object[] ML;
    private static Object[] SD;
    private static int omh;
    private int[] Bzk;
    int Og;
    private DX<E, E> SGo;
    Object[] pA;
    private static final int[] KZx = new int[0];
    private static final Object[] ZZv = new Object[0];

    private int pA(Object obj, int i) {
        int i2 = this.Og;
        if (i2 == 0) {
            return -1;
        }
        int iPA = Og.pA(this.Bzk, i2, i);
        if (iPA < 0 || obj.equals(this.pA[iPA])) {
            return iPA;
        }
        int i3 = iPA + 1;
        while (i3 < i2 && this.Bzk[i3] == i) {
            if (obj.equals(this.pA[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iPA - 1; i4 >= 0 && this.Bzk[i4] == i; i4--) {
            if (obj.equals(this.pA[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    private int pA() {
        int i = this.Og;
        if (i == 0) {
            return -1;
        }
        int iPA = Og.pA(this.Bzk, i, 0);
        if (iPA < 0 || this.pA[iPA] == null) {
            return iPA;
        }
        int i2 = iPA + 1;
        while (i2 < i && this.Bzk[i2] == 0) {
            if (this.pA[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iPA - 1; i3 >= 0 && this.Bzk[i3] == 0; i3--) {
            if (this.pA[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private void ZZv(int i) {
        if (i == 8) {
            synchronized (pA.class) {
                Object[] objArr = SD;
                if (objArr != null) {
                    this.pA = objArr;
                    SD = (Object[]) objArr[0];
                    this.Bzk = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    omh--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (pA.class) {
                Object[] objArr2 = ML;
                if (objArr2 != null) {
                    this.pA = objArr2;
                    ML = (Object[]) objArr2[0];
                    this.Bzk = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    JG--;
                    return;
                }
            }
        }
        this.Bzk = new int[i];
        this.pA = new Object[i];
    }

    private static void pA(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (pA.class) {
                if (omh < 10) {
                    objArr[0] = SD;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    SD = objArr;
                    omh++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (pA.class) {
                if (JG < 10) {
                    objArr[0] = ML;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    ML = objArr;
                    JG++;
                }
            }
        }
    }

    public pA() {
        this(0);
    }

    public pA(int i) {
        if (i == 0) {
            this.Bzk = KZx;
            this.pA = ZZv;
        } else {
            ZZv(i);
        }
        this.Og = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.Og;
        if (i != 0) {
            pA(this.Bzk, this.pA, i);
            this.Bzk = KZx;
            this.pA = ZZv;
            this.Og = 0;
        }
    }

    public void pA(int i) {
        int[] iArr = this.Bzk;
        if (iArr.length < i) {
            Object[] objArr = this.pA;
            ZZv(i);
            int i2 = this.Og;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.Bzk, 0, i2);
                System.arraycopy(objArr, 0, this.pA, 0, this.Og);
            }
            pA(iArr, objArr, this.Og);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return pA(obj) >= 0;
    }

    public int pA(Object obj) {
        return obj == null ? pA() : pA(obj, obj.hashCode());
    }

    public E Og(int i) {
        return (E) this.pA[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.Og <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int iPA;
        if (e == null) {
            iPA = pA();
            i = 0;
        } else {
            int iHashCode = e.hashCode();
            i = iHashCode;
            iPA = pA(e, iHashCode);
        }
        if (iPA >= 0) {
            return false;
        }
        int i2 = ~iPA;
        int i3 = this.Og;
        int[] iArr = this.Bzk;
        if (i3 >= iArr.length) {
            int i4 = 8;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.pA;
            ZZv(i4);
            int[] iArr2 = this.Bzk;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.pA, 0, objArr.length);
            }
            pA(iArr, objArr, this.Og);
        }
        int i5 = this.Og;
        if (i2 < i5) {
            int[] iArr3 = this.Bzk;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.pA;
            System.arraycopy(objArr2, i2, objArr2, i6, this.Og - i2);
        }
        this.Bzk[i2] = i;
        this.pA[i2] = e;
        this.Og++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iPA = pA(obj);
        if (iPA < 0) {
            return false;
        }
        KZx(iPA);
        return true;
    }

    public E KZx(int i) {
        Object[] objArr = this.pA;
        E e = (E) objArr[i];
        int i2 = this.Og;
        if (i2 <= 1) {
            pA(this.Bzk, objArr, i2);
            this.Bzk = KZx;
            this.pA = ZZv;
            this.Og = 0;
        } else {
            int[] iArr = this.Bzk;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                ZZv(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.Og--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.Bzk, 0, i);
                    System.arraycopy(objArr, 0, this.pA, 0, i);
                }
                int i3 = this.Og;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, this.Bzk, i, i3 - i);
                    System.arraycopy(objArr, i4, this.pA, i, this.Og - i);
                }
            } else {
                int i5 = i2 - 1;
                this.Og = i5;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, iArr, i, i5 - i);
                    Object[] objArr2 = this.pA;
                    System.arraycopy(objArr2, i6, objArr2, i, this.Og - i);
                }
                this.pA[this.Og] = null;
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.Og;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.Og;
        Object[] objArr = new Object[i];
        System.arraycopy(this.pA, 0, objArr, 0, i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.Og) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.Og));
        }
        System.arraycopy(this.pA, 0, tArr, 0, this.Og);
        int length = tArr.length;
        int i = this.Og;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.Og; i++) {
                try {
                    if (!set.contains(Og(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.Bzk;
        int i = this.Og;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public String toString() {
        if (isEmpty()) {
            return JsonUtils.EMPTY_JSON;
        }
        StringBuilder sb = new StringBuilder(this.Og * 14);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i = 0; i < this.Og; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E eOg = Og(i);
            if (eOg != this) {
                sb.append(eOg);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    private DX<E, E> Og() {
        if (this.SGo == null) {
            this.SGo = new DX<E, E>() { // from class: com.bytedance.adsdk.Og.pA.1
                @Override // com.bytedance.adsdk.Og.DX
                protected int pA() {
                    return pA.this.Og;
                }

                @Override // com.bytedance.adsdk.Og.DX
                protected Object pA(int i, int i2) {
                    return pA.this.pA[i];
                }

                @Override // com.bytedance.adsdk.Og.DX
                protected int pA(Object obj) {
                    return pA.this.pA(obj);
                }

                @Override // com.bytedance.adsdk.Og.DX
                protected Map<E, E> Og() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // com.bytedance.adsdk.Og.DX
                protected void pA(int i) {
                    pA.this.KZx(i);
                }

                @Override // com.bytedance.adsdk.Og.DX
                protected void KZx() {
                    pA.this.clear();
                }
            };
        }
        return this.SGo;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return Og().ZZv().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        pA(this.Og + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.Og - 1; i >= 0; i--) {
            if (!collection.contains(this.pA[i])) {
                KZx(i);
                z = true;
            }
        }
        return z;
    }
}
