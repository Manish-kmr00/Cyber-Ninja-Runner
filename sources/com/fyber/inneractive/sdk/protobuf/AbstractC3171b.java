package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public abstract class AbstractC3171b implements E0 {
    protected int memoizedHashCode = 0;

    @Deprecated
    public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        U.a(iterable, (List) collection);
    }

    public static void checkByteStringIsUtf8(AbstractC3221s abstractC3221s) throws IllegalArgumentException {
        if (!abstractC3221s.c()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    public abstract int getMemoizedSerializedSize();

    public int getSerializedSize(U0 u0) {
        int memoizedSerializedSize = getMemoizedSerializedSize();
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int iB = u0.b(this);
        setMemoizedSerializedSize(iB);
        return iB;
    }

    public C3209n1 newUninitializedMessageException() {
        return new C3209n1();
    }

    public abstract void setMemoizedSerializedSize(int i);

    public byte[] toByteArray() {
        try {
            int serializedSize = getSerializedSize();
            byte[] bArr = new byte[serializedSize];
            Logger logger = B.b;
            C3233y c3233y = new C3233y(serializedSize, bArr);
            writeTo(c3233y);
            if (c3233y.a() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }

    public AbstractC3221s toByteString() {
        try {
            int serializedSize = getSerializedSize();
            C3216q c3216q = AbstractC3221s.b;
            byte[] bArr = new byte[serializedSize];
            Logger logger = B.b;
            C3233y c3233y = new C3233y(serializedSize, bArr);
            writeTo(c3233y);
            if (c3233y.a() == 0) {
                return new C3216q(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        int iC = B.c(serializedSize) + serializedSize;
        if (iC > 4096) {
            iC = 4096;
        }
        A a2 = new A(outputStream, iC);
        a2.j(5);
        a2.i(serializedSize);
        writeTo(a2);
        if (a2.f > 0) {
            a2.a();
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        Logger logger = B.b;
        if (serializedSize > 4096) {
            serializedSize = 4096;
        }
        A a2 = new A(outputStream, serializedSize);
        writeTo(a2);
        if (a2.f > 0) {
            a2.a();
        }
    }

    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        U.a(iterable, list);
    }
}
