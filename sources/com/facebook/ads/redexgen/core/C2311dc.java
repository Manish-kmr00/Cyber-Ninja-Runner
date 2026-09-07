package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2311dc extends IOException {
    public final int A00;

    public C2311dc(int i) {
        this.A00 = i;
    }

    public C2311dc(String str, int i) {
        super(str);
        this.A00 = i;
    }

    public C2311dc(String str, Throwable th, int i) {
        super(str, th);
        this.A00 = i;
    }

    public C2311dc(Throwable th, int i) {
        super(th);
        this.A00 = i;
    }

    public static boolean A06(IOException iOException) {
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof C2311dc) && ((C2311dc) cause).A00 == 2008) {
                return true;
            }
        }
        return false;
    }
}
