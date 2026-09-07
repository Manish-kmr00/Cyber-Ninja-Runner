package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$ExtendableMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public abstract class GeneratedMessageLite$ExtendableMessage<MessageType extends GeneratedMessageLite$ExtendableMessage<MessageType, BuilderType>, BuilderType> extends AbstractC3169a0 implements F0 {
    protected N extensions = N.d;

    private void eagerlyMergeMessageSetExtension(AbstractC3229w abstractC3229w, Y y, H h, int i) throws IOException {
        parseExtension(abstractC3229w, h, y, (i << 3) | 2, i);
    }

    private void mergeMessageSetExtensionFromBytes(AbstractC3221s abstractC3221s, H h, Y y) throws IOException {
        E0 e0 = (E0) this.extensions.f2264a.get(y.d);
        D0 builder = e0 != null ? e0.toBuilder() : null;
        if (builder == null) {
            builder = y.c.newBuilderForType();
        }
        U u = (U) builder;
        u.getClass();
        try {
            AbstractC3229w abstractC3229wD = abstractC3221s.d();
            u.a(abstractC3229wD, h);
            abstractC3229wD.a(0);
            Object objA = u.a();
            N nEnsureExtensionsAreMutable = ensureExtensionsAreMutable();
            X x = y.d;
            if (x.c.a() == L1.ENUM) {
                objA = Integer.valueOf(((InterfaceC3181e0) objA).a());
            }
            nEnsureExtensionsAreMutable.c(x, objA);
        } catch (C3211o0 e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading " + u.getClass().getName() + " from a ByteString threw an IOException (should never happen).", e2);
        }
    }

    private <MessageType extends E0> void mergeMessageSetExtensionFromCodedStream(MessageType messagetype, AbstractC3229w abstractC3229w, H h) throws IOException {
        int iU = 0;
        C3216q c3216qE = null;
        Y yA = null;
        while (true) {
            int iT = abstractC3229w.t();
            if (iT == 0) {
                break;
            }
            if (iT == 16) {
                iU = abstractC3229w.u();
                if (iU != 0) {
                    yA = h.a(iU, messagetype);
                }
            } else if (iT == 26) {
                if (iU == 0 || yA == null) {
                    c3216qE = abstractC3229w.e();
                } else {
                    eagerlyMergeMessageSetExtension(abstractC3229w, yA, h, iU);
                    c3216qE = null;
                }
            } else if (!abstractC3229w.e(iT)) {
                break;
            }
        }
        abstractC3229w.a(12);
        if (c3216qE == null || iU == 0) {
            return;
        }
        if (yA != null) {
            mergeMessageSetExtensionFromBytes(c3216qE, h, yA);
        } else {
            mergeLengthDelimitedField(iU, c3216qE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v27, types: [com.fyber.inneractive.sdk.protobuf.e0] */
    /* JADX WARN: Type inference failed for: r10v30, types: [java.lang.Integer] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean parseExtension(AbstractC3229w abstractC3229w, H h, Y y, int i, int i2) throws IOException {
        boolean z;
        Object objA;
        E0 e0;
        int i3 = i & 7;
        boolean z2 = false;
        if (y == null) {
            z = false;
            z2 = true;
        } else {
            K1 k1 = y.d.c;
            N n = N.d;
            if (i3 == k1.b()) {
                z = false;
            } else {
                X x = y.d;
                if (x.d && x.c.c()) {
                    K1 k2 = y.d.c;
                    if (i3 == 2) {
                        z = true;
                    } else {
                        z = false;
                        z2 = true;
                    }
                } else {
                    z = false;
                    z2 = true;
                }
            }
        }
        if (z2) {
            return parseUnknownField(i, abstractC3229w);
        }
        ensureExtensionsAreMutable();
        if (z) {
            int iD = abstractC3229w.d(abstractC3229w.m());
            if (y.d.c == K1.ENUM) {
                while (abstractC3229w.a() > 0) {
                    Object objA2 = y.d.f2272a.a(abstractC3229w.g());
                    if (objA2 == 0) {
                        return true;
                    }
                    N n2 = this.extensions;
                    X x2 = y.d;
                    if (x2.c.a() == L1.ENUM) {
                        objA2 = Integer.valueOf(objA2.a());
                    }
                    n2.a(x2, objA2);
                }
            } else {
                while (abstractC3229w.a() > 0) {
                    K1 k3 = y.d.c;
                    N n3 = N.d;
                    this.extensions.a(y.d, Q1.a(abstractC3229w, k3, P1.LOOSE));
                }
            }
            abstractC3229w.c(iD);
        } else {
            int i4 = T.f2269a[y.d.c.a().ordinal()];
            if (i4 == 1) {
                X x3 = y.d;
                D0 builder = (x3.d || (e0 = (E0) this.extensions.f2264a.get(x3)) == null) ? null : e0.toBuilder();
                if (builder == null) {
                    builder = y.c.newBuilderForType();
                }
                X x4 = y.d;
                if (x4.c == K1.GROUP) {
                    abstractC3229w.a(x4.b, builder, h);
                } else {
                    abstractC3229w.a(builder, h);
                }
                objA = ((U) builder).a();
            } else if (i4 != 2) {
                K1 k4 = y.d.c;
                N n4 = N.d;
                objA = Q1.a(abstractC3229w, k4, P1.LOOSE);
            } else {
                int iG = abstractC3229w.g();
                InterfaceC3181e0 interfaceC3181e0A = y.d.f2272a.a(iG);
                if (interfaceC3181e0A == null) {
                    mergeVarintField(i2, iG);
                    return true;
                }
                objA = interfaceC3181e0A;
            }
            X x5 = y.d;
            if (x5.d) {
                N n5 = this.extensions;
                if (x5.c.a() == L1.ENUM) {
                    objA = Integer.valueOf(((InterfaceC3181e0) objA).a());
                }
                n5.a(x5, objA);
            } else {
                N n6 = this.extensions;
                if (x5.c.a() == L1.ENUM) {
                    objA = Integer.valueOf(((InterfaceC3181e0) objA).a());
                }
                n6.c(x5, objA);
            }
        }
        return true;
    }

    private void verifyExtensionContainingType(Y y) {
        if (y.f2274a != getDefaultInstanceForType()) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    public N ensureExtensionsAreMutable() {
        N n = this.extensions;
        if (n.b) {
            this.extensions = n.m4974clone();
        }
        return this.extensions;
    }

    public boolean extensionsAreInitialized() {
        return this.extensions.c();
    }

    public int extensionsSerializedSize() {
        return this.extensions.b();
    }

    public int extensionsSerializedSizeAsMessageSet() {
        return this.extensions.a();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3169a0, com.fyber.inneractive.sdk.protobuf.F0
    public /* bridge */ /* synthetic */ E0 getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [Type, java.util.ArrayList] */
    public final <Type> Type getExtension(E e) {
        Y yAccess$000 = AbstractC3169a0.access$000(e);
        verifyExtensionContainingType(yAccess$000);
        Type type = (Type) this.extensions.f2264a.get(yAccess$000.d);
        if (type == 0) {
            return (Type) yAccess$000.b;
        }
        X x = yAccess$000.d;
        if (!x.d) {
            return x.c.a() == L1.ENUM ? (Type) yAccess$000.d.f2272a.a(((Integer) type).intValue()) : type;
        }
        if (x.c.a() != L1.ENUM) {
            return type;
        }
        ?? r1 = (Type) new ArrayList();
        for (Object objA : (List) type) {
            if (yAccess$000.d.c.a() == L1.ENUM) {
                objA = yAccess$000.d.f2272a.a(((Integer) objA).intValue());
            }
            r1.add(objA);
        }
        return r1;
    }

    public final <Type> int getExtensionCount(E e) {
        Y yAccess$000 = AbstractC3169a0.access$000(e);
        verifyExtensionContainingType(yAccess$000);
        N n = this.extensions;
        X x = yAccess$000.d;
        n.getClass();
        if (!x.d) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object obj = n.f2264a.get(x);
        if (obj == null) {
            return 0;
        }
        return ((List) obj).size();
    }

    public final <Type> boolean hasExtension(E e) {
        Y yAccess$000 = AbstractC3169a0.access$000(e);
        verifyExtensionContainingType(yAccess$000);
        N n = this.extensions;
        X x = yAccess$000.d;
        n.getClass();
        if (x.d) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return n.f2264a.get(x) != null;
    }

    public final void mergeExtensionFields(MessageType messagetype) {
        N n = this.extensions;
        if (n.b) {
            this.extensions = n.m4974clone();
        }
        this.extensions.a(messagetype.extensions);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3169a0, com.fyber.inneractive.sdk.protobuf.E0
    public /* bridge */ /* synthetic */ D0 newBuilderForType() {
        return newBuilderForType();
    }

    public W newExtensionWriter() {
        return new W(this);
    }

    public W newMessageSetExtensionWriter() {
        return new W(this);
    }

    public <MessageType extends E0> boolean parseUnknownField(MessageType messagetype, AbstractC3229w abstractC3229w, H h, int i) throws IOException {
        int i2 = i >>> 3;
        return parseExtension(abstractC3229w, h, h.a(i2, messagetype), i, i2);
    }

    public <MessageType extends E0> boolean parseUnknownFieldAsMessageSet(MessageType messagetype, AbstractC3229w abstractC3229w, H h, int i) throws IOException {
        if (i != 11) {
            return (i & 7) == 2 ? parseUnknownField(messagetype, abstractC3229w, h, i) : abstractC3229w.e(i);
        }
        mergeMessageSetExtensionFromCodedStream(messagetype, abstractC3229w, h);
        return true;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3169a0, com.fyber.inneractive.sdk.protobuf.E0
    public /* bridge */ /* synthetic */ D0 toBuilder() {
        return toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <Type> Type getExtension(E e, int i) {
        Y yAccess$000 = AbstractC3169a0.access$000(e);
        verifyExtensionContainingType(yAccess$000);
        N n = this.extensions;
        X x = yAccess$000.d;
        n.getClass();
        if (x.d) {
            Object obj = n.f2264a.get(x);
            if (obj != null) {
                Type type = (Type) ((List) obj).get(i);
                return yAccess$000.d.c.a() == L1.ENUM ? (Type) yAccess$000.d.f2272a.a(((Integer) type).intValue()) : type;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
}
