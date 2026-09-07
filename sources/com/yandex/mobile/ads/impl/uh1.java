package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes11.dex */
public class uh1 extends Exception implements jm {
    public final int b;
    public final long c;

    static {
        new jm.a() { // from class: com.yandex.mobile.ads.impl.uh1$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return new uh1(bundle);
            }
        };
    }

    private static Throwable a(Bundle bundle) {
        String string = bundle.getString(Integer.toString(3, 36));
        String string2 = bundle.getString(Integer.toString(4, 36));
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(string, true, uh1.class.getClassLoader());
            Throwable th = Throwable.class.isAssignableFrom(cls) ? (Throwable) cls.getConstructor(String.class).newInstance(string2) : null;
            return th == null ? new RemoteException(string2) : th;
        } catch (Throwable unused) {
            return new RemoteException(string2);
        }
    }

    protected uh1(Bundle bundle) {
        this(bundle.getString(a(2)), a(bundle), bundle.getInt(a(0), 1000), bundle.getLong(a(1), SystemClock.elapsedRealtime()));
    }

    protected static String a(int i) {
        return Integer.toString(i, 36);
    }

    protected uh1(String str, Throwable th, int i, long j) {
        super(str, th);
        this.b = i;
        this.c = j;
    }
}
