package com.fyber.inneractive.sdk.protobuf;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class K0 implements U0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E0 f2261a;
    public final C3215p1 b;
    public final boolean c;
    public final J d;

    public K0(C3215p1 c3215p1, J j, E0 e0) {
        this.b = c3215p1;
        j.getClass();
        this.c = e0 instanceof GeneratedMessageLite$ExtendableMessage;
        this.d = j;
        this.f2261a = e0;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final Object a() {
        return ((U) this.f2261a.newBuilderForType()).b();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final boolean b(Object obj, Object obj2) {
        this.b.getClass();
        C3212o1 c3212o1 = ((AbstractC3169a0) obj).unknownFields;
        this.b.getClass();
        if (!c3212o1.equals(((AbstractC3169a0) obj2).unknownFields)) {
            return false;
        }
        if (!this.c) {
            return true;
        }
        this.d.getClass();
        N n = ((GeneratedMessageLite$ExtendableMessage) obj).extensions;
        this.d.getClass();
        return n.equals(((GeneratedMessageLite$ExtendableMessage) obj2).extensions);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final void c(Object obj) {
        this.b.getClass();
        ((AbstractC3169a0) obj).unknownFields.e = false;
        this.d.getClass();
        ((GeneratedMessageLite$ExtendableMessage) obj).extensions.e();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final int d(Object obj) {
        this.b.getClass();
        int iHashCode = ((AbstractC3169a0) obj).unknownFields.hashCode();
        if (!this.c) {
            return iHashCode;
        }
        this.d.getClass();
        return (iHashCode * 53) + ((GeneratedMessageLite$ExtendableMessage) obj).extensions.f2264a.hashCode();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final void a(Object obj, Object obj2) {
        C3215p1 c3215p1 = this.b;
        Class cls = V0.f2271a;
        c3215p1.getClass();
        AbstractC3169a0 abstractC3169a0 = (AbstractC3169a0) obj;
        C3212o1 c3212o1A = abstractC3169a0.unknownFields;
        C3212o1 c3212o1 = ((AbstractC3169a0) obj2).unknownFields;
        if (!c3212o1.equals(C3212o1.f)) {
            c3212o1A = C3212o1.a(c3212o1A, c3212o1);
        }
        abstractC3169a0.unknownFields = c3212o1A;
        if (this.c) {
            this.d.getClass();
            N n = ((GeneratedMessageLite$ExtendableMessage) obj2).extensions;
            if (n.f2264a.isEmpty()) {
                return;
            }
            ((GeneratedMessageLite$ExtendableMessage) obj).ensureExtensionsAreMutable().a(n);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final int b(Object obj) {
        this.b.getClass();
        C3212o1 c3212o1 = ((AbstractC3169a0) obj).unknownFields;
        int i = c3212o1.d;
        if (i == -1) {
            int iA = 0;
            for (int i2 = 0; i2 < c3212o1.f2293a; i2++) {
                int i3 = c3212o1.b[i2] >>> 3;
                iA += B.a((AbstractC3221s) c3212o1.c[i2]) + B.b(3) + B.c(i3) + B.b(2) + (B.b(1) * 2);
            }
            c3212o1.d = iA;
            i = iA;
        }
        if (!this.c) {
            return i;
        }
        this.d.getClass();
        return i + ((GeneratedMessageLite$ExtendableMessage) obj).extensions.a();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final void a(Object obj, C c) {
        this.d.getClass();
        Iterator itD = ((GeneratedMessageLite$ExtendableMessage) obj).extensions.d();
        while (itD.hasNext()) {
            Map.Entry entry = (Map.Entry) itD.next();
            X x = (X) entry.getKey();
            if (x.c.a() == L1.MESSAGE && !x.d && !x.e) {
                int i = x.b;
                Object value = entry.getValue();
                c.getClass();
                if (value instanceof AbstractC3221s) {
                    c.f2252a.b(i, (AbstractC3221s) value);
                } else {
                    c.f2252a.a(i, (E0) value);
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        this.b.getClass();
        C3212o1 c3212o1 = ((AbstractC3169a0) obj).unknownFields;
        c3212o1.getClass();
        c.getClass();
        if (R1.ASCENDING == R1.DESCENDING) {
            for (int i2 = c3212o1.f2293a - 1; i2 >= 0; i2--) {
                int i3 = c3212o1.b[i2] >>> 3;
                Object obj2 = c3212o1.c[i2];
                if (obj2 instanceof AbstractC3221s) {
                    c.f2252a.b(i3, (AbstractC3221s) obj2);
                } else {
                    c.f2252a.a(i3, (E0) obj2);
                }
            }
            return;
        }
        for (int i4 = 0; i4 < c3212o1.f2293a; i4++) {
            int i5 = c3212o1.b[i4] >>> 3;
            Object obj3 = c3212o1.c[i4];
            if (obj3 instanceof AbstractC3221s) {
                c.f2252a.b(i5, (AbstractC3221s) obj3);
            } else {
                c.f2252a.a(i5, (E0) obj3);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c8 A[SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final void a(Object obj, byte[] bArr, int i, int i2, C3183f c3183f) throws C3211o0 {
        AbstractC3169a0 abstractC3169a0 = (AbstractC3169a0) obj;
        C3212o1 c3212o1 = abstractC3169a0.unknownFields;
        if (c3212o1 == C3212o1.f) {
            c3212o1 = new C3212o1();
            abstractC3169a0.unknownFields = c3212o1;
        }
        N nEnsureExtensionsAreMutable = ((GeneratedMessageLite$ExtendableMessage) obj).ensureExtensionsAreMutable();
        Y yA = null;
        while (i < i2) {
            int iD = AbstractC3186g.d(bArr, i, c3183f);
            int i3 = c3183f.f2283a;
            if (i3 == 11) {
                int i4 = 0;
                AbstractC3221s abstractC3221s = null;
                while (iD < i2) {
                    int iA = iD + 1;
                    byte b = bArr[iD];
                    if (b >= 0) {
                        c3183f.f2283a = b;
                    } else {
                        iA = AbstractC3186g.a(b, bArr, iA, c3183f);
                    }
                    int i5 = c3183f.f2283a;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (yA != null) {
                                iD = AbstractC3186g.a(Q0.c.a(yA.c.getClass()), bArr, iA, i2, c3183f);
                                nEnsureExtensionsAreMutable.c(yA.d, c3183f.c);
                            } else if (i7 == 2) {
                                iD = AbstractC3186g.a(bArr, iA, c3183f);
                                abstractC3221s = (AbstractC3221s) c3183f.c;
                            }
                        }
                        if (i5 == 12) {
                            iD = iA;
                            break;
                        }
                        iD = AbstractC3186g.a(i5, bArr, iA, i2, c3183f);
                    } else if (i7 == 0) {
                        int iA2 = iA + 1;
                        byte b2 = bArr[iA];
                        if (b2 >= 0) {
                            c3183f.f2283a = b2;
                        } else {
                            iA2 = AbstractC3186g.a(b2, bArr, iA2, c3183f);
                        }
                        iD = iA2;
                        i4 = c3183f.f2283a;
                        J j = this.d;
                        H h = c3183f.d;
                        E0 e0 = this.f2261a;
                        j.getClass();
                        yA = h.a(i4, e0);
                    } else {
                        if (i5 == 12) {
                            iD = iA;
                            break;
                        }
                        iD = AbstractC3186g.a(i5, bArr, iA, i2, c3183f);
                    }
                }
                if (abstractC3221s != null) {
                    c3212o1.a((i4 << 3) | 2, abstractC3221s);
                }
                i = iD;
            } else if ((i3 & 7) == 2) {
                J j2 = this.d;
                H h2 = c3183f.d;
                E0 e1 = this.f2261a;
                j2.getClass();
                Y yA2 = h2.a(i3 >>> 3, e1);
                if (yA2 != null) {
                    i = AbstractC3186g.a(Q0.c.a(yA2.c.getClass()), bArr, iD, i2, c3183f);
                    nEnsureExtensionsAreMutable.c(yA2.d, c3183f.c);
                } else {
                    i = AbstractC3186g.a(i3, bArr, iD, i2, c3212o1, c3183f);
                }
                yA = yA2;
            } else {
                i = AbstractC3186g.a(i3, bArr, iD, i2, c3183f);
            }
        }
        if (i != i2) {
            throw new C3211o0("Failed to parse the message.");
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final void a(Object obj, T0 t0, H h) {
        C3215p1 c3215p1 = this.b;
        J j = this.d;
        c3215p1.getClass();
        AbstractC3169a0 abstractC3169a0 = (AbstractC3169a0) obj;
        C3212o1 c3212o1 = abstractC3169a0.unknownFields;
        if (c3212o1 == C3212o1.f) {
            c3212o1 = new C3212o1();
            abstractC3169a0.unknownFields = c3212o1;
        }
        C3212o1 c3212o2 = c3212o1;
        j.getClass();
        N nEnsureExtensionsAreMutable = ((GeneratedMessageLite$ExtendableMessage) obj).ensureExtensionsAreMutable();
        while (t0.s() != Integer.MAX_VALUE && a(t0, h, j, nEnsureExtensionsAreMutable, c3215p1, c3212o2)) {
            try {
            } finally {
                abstractC3169a0.unknownFields = c3212o2;
            }
        }
    }

    public final boolean a(T0 t0, H h, J j, N n, C3215p1 c3215p1, C3212o1 c3212o1) throws C3211o0 {
        byte[] bArr;
        int iE = t0.e();
        if (iE != 11) {
            if ((iE & 7) == 2) {
                E0 e0 = this.f2261a;
                j.getClass();
                Y yA = h.a(iE >>> 3, e0);
                if (yA != null) {
                    n.c(yA.d, t0.b(yA.c.getClass(), h));
                    return true;
                }
                c3215p1.getClass();
                return C3215p1.a((Object) c3212o1, t0);
            }
            return t0.i();
        }
        Y yA2 = null;
        int iC = 0;
        AbstractC3221s abstractC3221sA = null;
        while (t0.s() != Integer.MAX_VALUE) {
            int iE2 = t0.e();
            if (iE2 == 16) {
                iC = t0.c();
                E0 e1 = this.f2261a;
                j.getClass();
                yA2 = h.a(iC, e1);
            } else if (iE2 == 26) {
                if (yA2 != null) {
                    j.getClass();
                    n.c(yA2.d, t0.b(yA2.c.getClass(), h));
                } else {
                    abstractC3221sA = t0.a();
                }
            } else if (!t0.i()) {
                break;
            }
        }
        if (t0.e() != 12) {
            throw new C3211o0("Protocol message end-group tag did not match expected tag.");
        }
        if (abstractC3221sA != null) {
            if (yA2 != null) {
                j.getClass();
                AbstractC3169a0 abstractC3169a0B = ((U) yA2.c.newBuilderForType()).b();
                int size = abstractC3221sA.size();
                if (size == 0) {
                    bArr = AbstractC3205m0.b;
                } else {
                    byte[] bArr2 = new byte[size];
                    abstractC3221sA.a(size, bArr2);
                    bArr = bArr2;
                }
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                if (byteBufferWrap.hasArray()) {
                    C3189h c3189h = new C3189h(byteBufferWrap);
                    Q0 q0 = Q0.c;
                    q0.getClass();
                    q0.a(abstractC3169a0B.getClass()).a(abstractC3169a0B, c3189h, h);
                    n.c(yA2.d, abstractC3169a0B);
                    if (c3189h.s() != Integer.MAX_VALUE) {
                        throw new C3211o0("Protocol message end-group tag did not match expected tag.");
                    }
                } else {
                    throw new IllegalArgumentException("Direct buffers not yet supported");
                }
            } else {
                c3215p1.getClass();
                c3212o1.a((iC << 3) | 2, abstractC3221sA);
            }
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.U0
    public final boolean a(Object obj) {
        this.d.getClass();
        return ((GeneratedMessageLite$ExtendableMessage) obj).extensions.c();
    }
}
