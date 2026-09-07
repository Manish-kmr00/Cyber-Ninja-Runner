package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC3169a0 extends AbstractC3171b {
    private static Map<Object, AbstractC3169a0> defaultInstanceMap = new ConcurrentHashMap();
    protected C3212o1 unknownFields = C3212o1.f;
    protected int memoizedSerializedSize = -1;

    public static AbstractC3169a0 a(AbstractC3169a0 abstractC3169a0) throws C3211o0 {
        if (abstractC3169a0 == null || abstractC3169a0.isInitialized()) {
            return abstractC3169a0;
        }
        C3209n1 c3209n1NewUninitializedMessageException = abstractC3169a0.newUninitializedMessageException();
        c3209n1NewUninitializedMessageException.getClass();
        throw new C3211o0(c3209n1NewUninitializedMessageException.getMessage());
    }

    public static Y access$000(E e) {
        e.getClass();
        return (Y) e;
    }

    public static InterfaceC3175c0 emptyBooleanList() {
        return C3195j.d;
    }

    public static InterfaceC3178d0 emptyDoubleList() {
        return D.d;
    }

    public static InterfaceC3187g0 emptyFloatList() {
        return Q.d;
    }

    public static InterfaceC3190h0 emptyIntList() {
        return C3172b0.d;
    }

    public static InterfaceC3199k0 emptyLongList() {
        return C3228v0.d;
    }

    public static <E> InterfaceC3202l0 emptyProtobufList() {
        return R0.d;
    }

    public static <T extends AbstractC3169a0> T getDefaultInstance(Class<T> cls) {
        AbstractC3169a0 abstractC3169a0 = defaultInstanceMap.get(cls);
        if (abstractC3169a0 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC3169a0 = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (abstractC3169a0 == null) {
            try {
                abstractC3169a0 = (T) ((AbstractC3169a0) y1.f2305a.allocateInstance(cls)).getDefaultInstanceForType();
                if (abstractC3169a0 == null) {
                    throw new IllegalStateException();
                }
                defaultInstanceMap.put(cls, abstractC3169a0);
            } catch (Throwable th) {
                throw new IllegalStateException(th);
            }
        }
        return (T) abstractC3169a0;
    }

    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static InterfaceC3190h0 mutableCopy(InterfaceC3190h0 interfaceC3190h0) {
        C3172b0 c3172b0 = (C3172b0) interfaceC3190h0;
        int i = c3172b0.c;
        return c3172b0.b(i == 0 ? 10 : i * 2);
    }

    public static Object newMessageInfo(E0 e0, String str, Object[] objArr) {
        return new S0(e0, str, objArr);
    }

    public static <ContainingType extends E0, Type> Y newRepeatedGeneratedExtension(ContainingType containingtype, E0 e0, InterfaceC3184f0 interfaceC3184f0, int i, K1 k1, boolean z, Class cls) {
        return new Y(containingtype, Collections.emptyList(), e0, new X(interfaceC3184f0, i, k1, true, z));
    }

    public static <ContainingType extends E0, Type> Y newSingularGeneratedExtension(ContainingType containingtype, Type type, E0 e0, InterfaceC3184f0 interfaceC3184f0, int i, K1 k1, Class cls) {
        return new Y(containingtype, type, e0, new X(interfaceC3184f0, i, k1, false, false));
    }

    public static <T extends AbstractC3169a0> T parseDelimitedFrom(T t, InputStream inputStream) throws C3211o0 {
        return (T) a(a(t, inputStream, H.a()));
    }

    public static <T extends AbstractC3169a0> T parseFrom(T t, InputStream inputStream) throws C3211o0 {
        AbstractC3229w c3225u;
        if (inputStream == null) {
            byte[] bArr = AbstractC3205m0.b;
            int length = bArr.length;
            c3225u = new C3223t(bArr, 0, length, false);
            try {
                c3225u.d(length);
            } catch (C3211o0 e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            c3225u = new C3225u(inputStream);
        }
        return (T) a(parsePartialFrom(t, c3225u, H.a()));
    }

    public static <T extends AbstractC3169a0> T parsePartialFrom(T t, AbstractC3229w abstractC3229w, H h) throws C3211o0 {
        T t2 = (T) t.dynamicMethod(Z.NEW_MUTABLE_INSTANCE);
        try {
            Q0 q0 = Q0.c;
            q0.getClass();
            U0 u0A = q0.a(t2.getClass());
            C3231x c3231x = abstractC3229w.d;
            if (c3231x == null) {
                c3231x = new C3231x(abstractC3229w);
            }
            u0A.a(t2, c3231x, h);
            u0A.c(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof C3211o0) {
                throw ((C3211o0) e.getCause());
            }
            throw new C3211o0(e.getMessage());
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof C3211o0) {
                throw ((C3211o0) e2.getCause());
            }
            throw e2;
        }
    }

    public static <T extends AbstractC3169a0> void registerDefaultInstance(Class<T> cls, T t) {
        defaultInstanceMap.put(cls, t);
    }

    public Object buildMessageInfo() throws Exception {
        return dynamicMethod(Z.BUILD_MESSAGE_INFO);
    }

    public final <MessageType extends AbstractC3169a0, BuilderType extends U> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(Z.NEW_BUILDER);
    }

    public Object dynamicMethod(Z z, Object obj) {
        return dynamicMethod(z, obj, null);
    }

    public abstract Object dynamicMethod(Z z, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Q0 q0 = Q0.c;
        q0.getClass();
        return q0.a(getClass()).b(this, (AbstractC3169a0) obj);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3171b
    public int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize;
    }

    public final N0 getParserForType() {
        return (N0) dynamicMethod(Z.GET_PARSER);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.E0
    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            Q0 q0 = Q0.c;
            q0.getClass();
            this.memoizedSerializedSize = q0.a(getClass()).b(this);
        }
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        Q0 q0 = Q0.c;
        q0.getClass();
        int iD = q0.a(getClass()).d(this);
        this.memoizedHashCode = iD;
        return iD;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.F0
    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    public void makeImmutable() {
        Q0 q0 = Q0.c;
        q0.getClass();
        q0.a(getClass()).c(this);
    }

    public void mergeLengthDelimitedField(int i, AbstractC3221s abstractC3221s) {
        if (this.unknownFields == C3212o1.f) {
            this.unknownFields = new C3212o1();
        }
        C3212o1 c3212o1 = this.unknownFields;
        if (!c3212o1.e) {
            throw new UnsupportedOperationException();
        }
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        c3212o1.a((i << 3) | 2, abstractC3221s);
    }

    public final void mergeUnknownFields(C3212o1 c3212o1) {
        this.unknownFields = C3212o1.a(this.unknownFields, c3212o1);
    }

    public void mergeVarintField(int i, int i2) {
        if (this.unknownFields == C3212o1.f) {
            this.unknownFields = new C3212o1();
        }
        C3212o1 c3212o1 = this.unknownFields;
        if (!c3212o1.e) {
            throw new UnsupportedOperationException();
        }
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        c3212o1.a(i << 3, Long.valueOf(i2));
    }

    public boolean parseUnknownField(int i, AbstractC3229w abstractC3229w) throws IOException {
        if ((i & 7) == 4) {
            return false;
        }
        if (this.unknownFields == C3212o1.f) {
            this.unknownFields = new C3212o1();
        }
        return this.unknownFields.a(i, abstractC3229w);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3171b
    public void setMemoizedSerializedSize(int i) {
        this.memoizedSerializedSize = i;
    }

    public String toString() {
        String string = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(string);
        G0.a(this, sb, 0);
        return sb.toString();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.E0
    public void writeTo(B b) throws IOException {
        Q0 q0 = Q0.c;
        q0.getClass();
        U0 u0A = q0.a(getClass());
        C c = b.f2250a;
        if (c == null) {
            c = new C(b);
        }
        u0A.a((Object) this, c);
    }

    public static final <T extends AbstractC3169a0> boolean isInitialized(T t, boolean z) {
        byte bByteValue = ((Byte) t.dynamicMethod(Z.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        Q0 q0 = Q0.c;
        q0.getClass();
        boolean zA = q0.a(t.getClass()).a(t);
        if (z) {
            t.dynamicMethod(Z.SET_MEMOIZED_IS_INITIALIZED, zA ? t : null);
        }
        return zA;
    }

    public final <MessageType extends AbstractC3169a0, BuilderType extends U> BuilderType createBuilder(MessageType messagetype) {
        BuilderType buildertype = (BuilderType) createBuilder();
        buildertype.c();
        U.a(buildertype.b, messagetype);
        return buildertype;
    }

    public Object dynamicMethod(Z z) {
        return dynamicMethod(z, null, null);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.F0
    public final AbstractC3169a0 getDefaultInstanceForType() {
        return (AbstractC3169a0) dynamicMethod(Z.GET_DEFAULT_INSTANCE);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.E0
    public final U newBuilderForType() {
        return (U) dynamicMethod(Z.NEW_BUILDER);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.E0
    public final U toBuilder() {
        U u = (U) dynamicMethod(Z.NEW_BUILDER);
        u.c();
        U.a(u.b, this);
        return u;
    }

    public static InterfaceC3199k0 mutableCopy(InterfaceC3199k0 interfaceC3199k0) {
        C3228v0 c3228v0 = (C3228v0) interfaceC3199k0;
        int i = c3228v0.c;
        return c3228v0.b(i == 0 ? 10 : i * 2);
    }

    public static <T extends AbstractC3169a0> T parseDelimitedFrom(T t, InputStream inputStream, H h) throws C3211o0 {
        return (T) a(a(t, inputStream, h));
    }

    public static AbstractC3169a0 a(AbstractC3169a0 abstractC3169a0, InputStream inputStream, H h) throws C3211o0 {
        try {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            if ((i & 128) != 0) {
                i &= 127;
                int i2 = 7;
                while (i2 < 32) {
                    int i3 = inputStream.read();
                    if (i3 == -1) {
                        throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                    }
                    i |= (i3 & 127) << i2;
                    if ((i3 & 128) != 0) {
                        i2 += 7;
                    }
                }
                while (i2 < 64) {
                    int i4 = inputStream.read();
                    if (i4 == -1) {
                        throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                    }
                    if ((i4 & 128) != 0) {
                        i2 += 7;
                    }
                }
                throw new C3211o0("CodedInputStream encountered a malformed varint.");
            }
            C3225u c3225u = new C3225u(new C3168a(inputStream, i));
            AbstractC3169a0 partialFrom = parsePartialFrom(abstractC3169a0, c3225u, h);
            c3225u.a(0);
            return partialFrom;
        } catch (IOException e) {
            throw new C3211o0(e.getMessage());
        }
    }

    public static InterfaceC3187g0 mutableCopy(InterfaceC3187g0 interfaceC3187g0) {
        Q q = (Q) interfaceC3187g0;
        int i = q.c;
        return q.b(i == 0 ? 10 : i * 2);
    }

    public static InterfaceC3178d0 mutableCopy(InterfaceC3178d0 interfaceC3178d0) {
        D d = (D) interfaceC3178d0;
        int i = d.c;
        return d.b(i == 0 ? 10 : i * 2);
    }

    public static InterfaceC3175c0 mutableCopy(InterfaceC3175c0 interfaceC3175c0) {
        C3195j c3195j = (C3195j) interfaceC3175c0;
        int i = c3195j.c;
        return c3195j.b(i == 0 ? 10 : i * 2);
    }

    public static <E> InterfaceC3202l0 mutableCopy(InterfaceC3202l0 interfaceC3202l0) {
        int size = interfaceC3202l0.size();
        return interfaceC3202l0.b(size == 0 ? 10 : size * 2);
    }

    public static <T extends AbstractC3169a0> T parseFrom(T t, InputStream inputStream, H h) throws C3211o0 {
        AbstractC3229w c3225u;
        if (inputStream == null) {
            byte[] bArr = AbstractC3205m0.b;
            int length = bArr.length;
            c3225u = new C3223t(bArr, 0, length, false);
            try {
                c3225u.d(length);
            } catch (C3211o0 e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            c3225u = new C3225u(inputStream);
        }
        return (T) a(parsePartialFrom(t, c3225u, h));
    }

    public static <T extends AbstractC3169a0> T parsePartialFrom(T t, byte[] bArr, int i, int i2, H h) throws C3211o0 {
        T t2 = (T) t.dynamicMethod(Z.NEW_MUTABLE_INSTANCE);
        try {
            Q0 q0 = Q0.c;
            q0.getClass();
            U0 u0A = q0.a(t2.getClass());
            u0A.a(t2, bArr, i, i + i2, new C3183f(h));
            u0A.c(t2);
            if (t2.memoizedHashCode == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof C3211o0) {
                throw ((C3211o0) e.getCause());
            }
            throw new C3211o0(e.getMessage());
        } catch (IndexOutOfBoundsException unused) {
            throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public static <T extends AbstractC3169a0> T parsePartialFrom(T t, AbstractC3229w abstractC3229w) throws C3211o0 {
        return (T) parsePartialFrom(t, abstractC3229w, H.a());
    }

    public static <T extends AbstractC3169a0> T parseFrom(T t, ByteBuffer byteBuffer, H h) throws C3211o0 {
        C3223t c3223t;
        AbstractC3229w c3227v;
        if (byteBuffer.hasArray()) {
            byte[] bArrArray = byteBuffer.array();
            int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
            int iRemaining = byteBuffer.remaining();
            c3223t = new C3223t(bArrArray, iPosition, iRemaining, false);
            try {
                c3223t.d(iRemaining);
            } catch (C3211o0 e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            if (byteBuffer.isDirect() && y1.d) {
                c3227v = new C3227v(byteBuffer, false);
            } else {
                int iRemaining2 = byteBuffer.remaining();
                byte[] bArr = new byte[iRemaining2];
                byteBuffer.duplicate().get(bArr);
                C3223t c3223t2 = new C3223t(bArr, 0, iRemaining2, true);
                try {
                    c3223t2.d(iRemaining2);
                    c3223t = c3223t2;
                } catch (C3211o0 e2) {
                    throw new IllegalArgumentException(e2);
                }
            }
            return (T) a(parseFrom(t, c3227v, h));
        }
        c3227v = c3223t;
        return (T) a(parseFrom(t, c3227v, h));
    }

    public static <T extends AbstractC3169a0> T parseFrom(T t, ByteBuffer byteBuffer) throws C3211o0 {
        return (T) parseFrom(t, byteBuffer, H.a());
    }

    public static <T extends AbstractC3169a0> T parseFrom(T t, AbstractC3221s abstractC3221s) throws C3211o0 {
        return (T) a(parseFrom(t, abstractC3221s, H.a()));
    }

    public static <T extends AbstractC3169a0> T parseFrom(T t, AbstractC3221s abstractC3221s, H h) throws C3211o0 {
        AbstractC3229w abstractC3229wD = abstractC3221s.d();
        AbstractC3169a0 partialFrom = parsePartialFrom(t, abstractC3229wD, h);
        abstractC3229wD.a(0);
        return (T) a(partialFrom);
    }

    public static <T extends AbstractC3169a0> T parseFrom(T t, byte[] bArr) throws C3211o0 {
        return (T) a(parsePartialFrom(t, bArr, 0, bArr.length, H.a()));
    }

    public static <T extends AbstractC3169a0> T parseFrom(T t, byte[] bArr, H h) throws C3211o0 {
        return (T) a(parsePartialFrom(t, bArr, 0, bArr.length, h));
    }

    public static <T extends AbstractC3169a0> T parseFrom(T t, AbstractC3229w abstractC3229w) throws C3211o0 {
        return (T) parseFrom(t, abstractC3229w, H.a());
    }

    public static <T extends AbstractC3169a0> T parseFrom(T t, AbstractC3229w abstractC3229w, H h) throws C3211o0 {
        return (T) a(parsePartialFrom(t, abstractC3229w, h));
    }
}
