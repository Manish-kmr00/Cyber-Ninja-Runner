package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes13.dex */
public final class N {
    public static final N d = new N(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC3185f1 f2264a;
    public boolean b;
    public boolean c;

    public N() {
        int i = AbstractC3185f1.h;
        this.f2264a = new W0(16);
    }

    public static boolean b(Map.Entry entry) {
        X x = (X) entry.getKey();
        if (x.c.a() != L1.MESSAGE) {
            return true;
        }
        if (!x.d) {
            Object value = entry.getValue();
            if (value instanceof E0) {
                return ((E0) value).isInitialized();
            }
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!((E0) it.next()).isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public final void a(N n) {
        for (int i = 0; i < n.f2264a.b.size(); i++) {
            c((Map.Entry) n.f2264a.b.get(i));
        }
        Iterator it = n.f2264a.b().iterator();
        while (it.hasNext()) {
            c((Map.Entry) it.next());
        }
    }

    public final boolean c() {
        for (int i = 0; i < this.f2264a.b.size(); i++) {
            if (!b((Map.Entry) this.f2264a.b.get(i))) {
                return false;
            }
        }
        Iterator it = this.f2264a.b().iterator();
        while (it.hasNext()) {
            if (!b((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator d() {
        return this.c ? new C3214p0(this.f2264a.entrySet().iterator()) : this.f2264a.entrySet().iterator();
    }

    public final void e() {
        if (this.b) {
            return;
        }
        W0 w0 = (W0) this.f2264a;
        if (!w0.d) {
            for (int i = 0; i < w0.b.size(); i++) {
                Map.Entry entry = (Map.Entry) w0.b.get(i);
                if (((X) entry.getKey()).d) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
            for (Map.Entry entry2 : w0.b()) {
                if (((X) entry2.getKey()).d) {
                    entry2.setValue(Collections.unmodifiableList((List) entry2.getValue()));
                }
            }
        }
        if (!w0.d) {
            w0.c = w0.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(w0.c);
            w0.f = w0.f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(w0.f);
            w0.d = true;
        }
        this.b = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof N) {
            return this.f2264a.equals(((N) obj).f2264a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2264a.hashCode();
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final N m4974clone() {
        N n = new N();
        for (int i = 0; i < this.f2264a.b.size(); i++) {
            Map.Entry entry = (Map.Entry) this.f2264a.b.get(i);
            n.c((X) entry.getKey(), entry.getValue());
        }
        for (Map.Entry entry2 : this.f2264a.b()) {
            n.c((X) entry2.getKey(), entry2.getValue());
        }
        n.c = this.c;
        return n;
    }

    public N(int i) {
        int i2 = AbstractC3185f1.h;
        this.f2264a = new W0(0);
        e();
        e();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:15:0x002b  */
    /* JADX WARN: Code duplicated, block: B:22:0x003f  */
    public static void d(X x, Object obj) {
        boolean z;
        K1 k1 = x.c;
        Charset charset = AbstractC3205m0.f2291a;
        obj.getClass();
        switch (M.f2262a[k1.a().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof AbstractC3221s) || (obj instanceof byte[])) {
                    z = true;
                } else {
                    z = false;
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof InterfaceC3181e0)) {
                    z = true;
                } else {
                    z = false;
                }
                break;
            case 9:
                z = obj instanceof E0;
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(x.b), x.c.a(), obj.getClass().getName()));
        }
    }

    public final int a() {
        int iA = 0;
        for (int i = 0; i < this.f2264a.b.size(); i++) {
            iA += a((Map.Entry) this.f2264a.b.get(i));
        }
        Iterator it = this.f2264a.b().iterator();
        while (it.hasNext()) {
            iA += a((Map.Entry) it.next());
        }
        return iA;
    }

    public final void c(Map.Entry entry) {
        X x = (X) entry.getKey();
        Object value = entry.getValue();
        if (x.d) {
            Object arrayList = this.f2264a.get(x);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            for (Object obj : (List) value) {
                List list = (List) arrayList;
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    byte[] bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    obj = bArr2;
                }
                list.add(obj);
            }
            this.f2264a.a(x, arrayList);
            return;
        }
        if (x.c.a() == L1.MESSAGE) {
            Object obj2 = this.f2264a.get(x);
            if (obj2 == null) {
                AbstractC3185f1 abstractC3185f1 = this.f2264a;
                if (value instanceof byte[]) {
                    byte[] bArr3 = (byte[]) value;
                    byte[] bArr4 = new byte[bArr3.length];
                    System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                    value = bArr4;
                }
                abstractC3185f1.a(x, value);
                return;
            }
            U u = (U) ((E0) obj2).toBuilder();
            u.c();
            U.a(u.b, (AbstractC3169a0) ((E0) value));
            this.f2264a.a(x, u.a());
            return;
        }
        AbstractC3185f1 abstractC3185f2 = this.f2264a;
        if (value instanceof byte[]) {
            byte[] bArr5 = (byte[]) value;
            byte[] bArr6 = new byte[bArr5.length];
            System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
            value = bArr6;
        }
        abstractC3185f2.a(x, value);
    }

    public static int a(Map.Entry entry) {
        X x = (X) entry.getKey();
        Object value = entry.getValue();
        if (x.c.a() == L1.MESSAGE && !x.d && !x.e) {
            int i = ((X) entry.getKey()).b;
            int iC = B.c(i) + B.b(2) + (B.b(1) * 2);
            int iB = B.b(3);
            int serializedSize = ((E0) value).getSerializedSize();
            return L.a(serializedSize, serializedSize, iB, iC);
        }
        return b(x, value);
    }

    public final int b() {
        int iB = 0;
        for (int i = 0; i < this.f2264a.b.size(); i++) {
            Map.Entry entry = (Map.Entry) this.f2264a.b.get(i);
            iB += b((X) entry.getKey(), entry.getValue());
        }
        for (Map.Entry entry2 : this.f2264a.b()) {
            iB += b((X) entry2.getKey(), entry2.getValue());
        }
        return iB;
    }

    public static int b(X x, Object obj) {
        int iB;
        int iA;
        K1 k1 = x.c;
        int i = x.b;
        if (x.d) {
            int iA2 = 0;
            if (x.e) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iA2 += a(k1, it.next());
                }
                iB = B.b(i) + iA2;
                iA = B.c(iA2);
            } else {
                for (Object obj2 : (List) obj) {
                    int iB2 = B.b(i);
                    if (k1 == K1.GROUP) {
                        iB2 *= 2;
                    }
                    iA2 += a(k1, obj2) + iB2;
                }
                return iA2;
            }
        } else {
            iB = B.b(i);
            if (k1 == K1.GROUP) {
                iB *= 2;
            }
            iA = a(k1, obj);
        }
        return iA + iB;
    }

    public final void c(X x, Object obj) {
        if (x.d) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d(x, it.next());
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            d(x, obj);
        }
        this.f2264a.a(x, obj);
    }

    public static int a(K1 k1, Object obj) {
        int serializedSize;
        int iC;
        switch (M.b[k1.ordinal()]) {
            case 1:
                ((Double) obj).getClass();
                Logger logger = B.b;
                return 8;
            case 2:
                ((Float) obj).getClass();
                Logger logger2 = B.b;
                return 4;
            case 3:
                return B.a(((Long) obj).longValue());
            case 4:
                return B.a(((Long) obj).longValue());
            case 5:
                int iIntValue = ((Integer) obj).intValue();
                if (iIntValue >= 0) {
                    return B.c(iIntValue);
                }
                Logger logger3 = B.b;
                return 10;
            case 6:
                ((Long) obj).getClass();
                Logger logger4 = B.b;
                return 8;
            case 7:
                ((Integer) obj).getClass();
                Logger logger5 = B.b;
                return 4;
            case 8:
                ((Boolean) obj).getClass();
                Logger logger6 = B.b;
                return 1;
            case 9:
                Logger logger7 = B.b;
                return ((E0) obj).getSerializedSize();
            case 10:
                Logger logger8 = B.b;
                serializedSize = ((E0) obj).getSerializedSize();
                iC = B.c(serializedSize);
                break;
            case 11:
                if (obj instanceof AbstractC3221s) {
                    return B.a((AbstractC3221s) obj);
                }
                return B.a((String) obj);
            case 12:
                if (obj instanceof AbstractC3221s) {
                    return B.a((AbstractC3221s) obj);
                }
                Logger logger9 = B.b;
                serializedSize = ((byte[]) obj).length;
                iC = B.c(serializedSize);
                break;
                break;
            case 13:
                return B.c(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                Logger logger10 = B.b;
                return 4;
            case 15:
                ((Long) obj).getClass();
                Logger logger11 = B.b;
                return 8;
            case 16:
                return B.c(B.d(((Integer) obj).intValue()));
            case 17:
                return B.a(B.b(((Long) obj).longValue()));
            case 18:
                if (obj instanceof InterfaceC3181e0) {
                    return B.a(((InterfaceC3181e0) obj).a());
                }
                return B.a(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iC + serializedSize;
    }

    public final void a(X x, Object obj) {
        List arrayList;
        if (x.d) {
            d(x, obj);
            Object obj2 = this.f2264a.get(x);
            if (obj2 == null) {
                arrayList = new ArrayList();
                this.f2264a.a(x, arrayList);
            } else {
                arrayList = (List) obj2;
            }
            arrayList.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }
}
