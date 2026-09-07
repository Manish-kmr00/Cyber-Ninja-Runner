package com.fyber.inneractive.sdk.protobuf;

import com.amazon.aps.shared.util.APSSharedUtil;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public abstract class AbstractC3221s implements Iterable, Serializable {
    public static final C3216q b = new C3216q(AbstractC3205m0.b);
    public static final InterfaceC3210o c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2297a = 0;

    static {
        c = AbstractC3177d.a() ? new r() : new C3204m();
    }

    public static C3216q a(String str) {
        return new C3216q(str.getBytes(AbstractC3205m0.f2291a));
    }

    public abstract int a(int i, int i2);

    public abstract void a(int i, byte[] bArr);

    public abstract void a(AbstractC3198k abstractC3198k);

    public abstract byte c(int i);

    public abstract boolean c();

    public abstract byte d(int i);

    public abstract AbstractC3229w d();

    public abstract AbstractC3221s e(int i);

    public abstract String e();

    public final String f() {
        Charset charset = AbstractC3205m0.f2291a;
        return size() == 0 ? "" : e();
    }

    public final int hashCode() {
        int iA = this.f2297a;
        if (iA == 0) {
            int size = size();
            iA = a(size, size);
            if (iA == 0) {
                iA = 1;
            }
            this.f2297a = iA;
        }
        return iA;
    }

    public abstract int size();

    public final String toString() {
        Locale locale = Locale.ROOT;
        return "<ByteString@" + Integer.toHexString(System.identityHashCode(this)) + " size=" + size() + " contents=\"" + (size() <= 50 ? AbstractC3194i1.a(this) : AbstractC3194i1.a(e(47)) + APSSharedUtil.TRUNCATE_SEPARATOR) + "\">";
    }

    public static int a(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }
}
