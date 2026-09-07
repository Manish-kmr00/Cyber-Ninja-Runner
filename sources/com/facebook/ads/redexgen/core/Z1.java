package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class Z1 extends Exception implements InterfaceC1775Nb {
    public final int A00;
    public final long A01;
    public static final String A03 = AbstractC2471gE.A0h(0);
    public static final String A04 = AbstractC2471gE.A0h(1);
    public static final String A07 = AbstractC2471gE.A0h(2);
    public static final String A05 = AbstractC2471gE.A0h(3);
    public static final String A06 = AbstractC2471gE.A0h(4);
    public static final InterfaceC1774Na<Z1> A02 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.Z7
        @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
        public final InterfaceC1775Nb A6V(Bundle bundle) {
            return new Z1(bundle);
        }
    };

    public Z1(Bundle bundle) {
        this(bundle.getString(A07), A09(bundle), bundle.getInt(A03, 1000), bundle.getLong(A04, SystemClock.elapsedRealtime()));
    }

    public Z1(String str, Throwable th, int i, long j) {
        super(str, th);
        this.A00 = i;
        this.A01 = j;
    }

    public static RemoteException A08(String str) {
        return new RemoteException(str);
    }

    public static Throwable A09(Bundle bundle) {
        String string = bundle.getString(A05);
        String causeClassName = A06;
        String string2 = bundle.getString(causeClassName);
        Throwable thA0A = null;
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(string, true, Z1.class.getClassLoader());
            if (Throwable.class.isAssignableFrom(cls)) {
                thA0A = A0A(cls, string2);
            }
            if (thA0A == null) {
                return A08(string2);
            }
            return thA0A;
        } catch (Throwable unused) {
            if (thA0A != null) {
                return thA0A;
            }
        }
    }

    public static Throwable A0A(Class<?> clazz, String str) throws Exception {
        return (Throwable) clazz.getConstructor(String.class).newInstance(str);
    }
}
