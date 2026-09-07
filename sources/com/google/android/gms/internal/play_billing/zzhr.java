package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes13.dex */
public class zzhr extends IOException {
    public zzhr(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public zzhr(String str) {
        super(str);
    }
}
