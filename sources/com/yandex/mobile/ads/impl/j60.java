package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes12.dex */
public final class j60 extends uh1 {
    public final int d;
    public final String e;
    public final int f;
    public final gc0 g;
    public final int h;
    public final nw0 i;
    final boolean j;

    public static /* synthetic */ j60 $r8$lambda$Fz0xTSHh5oXm91XYvK8e8ENPIJI(Bundle bundle) {
        return new j60(bundle);
    }

    static {
        new jm.a() { // from class: com.yandex.mobile.ads.impl.j60$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return j60.$r8$lambda$Fz0xTSHh5oXm91XYvK8e8ENPIJI(bundle);
            }
        };
    }

    private j60(int i, Throwable th, int i2, int i3) {
        this(a(i, null, null, -1, null, 4), th, i2, i, null, -1, null, 4, null, SystemClock.elapsedRealtime(), false);
    }

    public static j60 a() {
        return new j60(a(3, "Video load error occurred", null, -1, null, 4), null, 1001, 3, null, -1, null, 4, null, SystemClock.elapsedRealtime(), false);
    }

    public static j60 a(Exception exc, String str, int i, gc0 gc0Var, int i2, boolean z, int i3) {
        int i4 = gc0Var == null ? 4 : i2;
        return new j60(a(1, null, str, i, gc0Var, i4), exc, i3, 1, str, i, gc0Var, i4, null, SystemClock.elapsedRealtime(), z);
    }

    @Deprecated
    public static j60 a(IllegalStateException illegalStateException) {
        return new j60(2, illegalStateException, 1000, 0);
    }

    private j60(Bundle bundle) {
        super(bundle);
        this.d = bundle.getInt(uh1.a(1001), 2);
        this.e = bundle.getString(uh1.a(1002));
        this.f = bundle.getInt(uh1.a(1003), -1);
        Bundle bundle2 = bundle.getBundle(uh1.a(1004));
        this.g = bundle2 == null ? null : (gc0) gc0.I.fromBundle(bundle2);
        this.h = bundle.getInt(uh1.a(1005), 4);
        this.j = bundle.getBoolean(uh1.a(1006), false);
        this.i = null;
    }

    private j60(String str, Throwable th, int i, int i2, String str2, int i3, gc0 gc0Var, int i4, rw0.b bVar, long j, boolean z) {
        super(str, th, i, j);
        hg.a(!z || i2 == 1);
        hg.a(th != null || i2 == 3);
        this.d = i2;
        this.e = str2;
        this.f = i3;
        this.g = gc0Var;
        this.h = i4;
        this.i = bVar;
        this.j = z;
    }

    private static String a(int i, String str, String str2, int i2, gc0 gc0Var, int i3) {
        String string;
        String str3;
        if (i == 0) {
            string = "Source error";
        } else if (i == 1) {
            StringBuilder sbAppend = new StringBuilder().append(str2).append(" error, index=").append(i2).append(", format=").append(gc0Var).append(", format_supported=");
            int i4 = x82.f10629a;
            if (i3 == 0) {
                str3 = "NO";
            } else if (i3 == 1) {
                str3 = "NO_UNSUPPORTED_TYPE";
            } else if (i3 == 2) {
                str3 = "NO_UNSUPPORTED_DRM";
            } else if (i3 == 3) {
                str3 = "NO_EXCEEDS_CAPABILITIES";
            } else {
                if (i3 != 4) {
                    throw new IllegalStateException();
                }
                str3 = "YES";
            }
            string = sbAppend.append(str3).toString();
        } else if (i != 3) {
            string = "Unexpected runtime error";
        } else {
            string = "Remote error";
        }
        return !TextUtils.isEmpty(str) ? string + ": " + str : string;
    }

    public static j60 a(IOException iOException, int i) {
        return new j60(0, iOException, i, 0);
    }

    public static j60 a(RuntimeException runtimeException, int i) {
        return new j60(2, runtimeException, i, 0);
    }

    final j60 a(rw0.b bVar) {
        String message = getMessage();
        int i = x82.f10629a;
        return new j60(message, getCause(), this.b, this.d, this.e, this.f, this.g, this.h, bVar, this.c, this.j);
    }
}
