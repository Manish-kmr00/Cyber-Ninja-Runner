package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzgx extends zzgv {
    public final int zzc;

    public zzgx(int i, String str, IOException iOException, Map map, zzgj zzgjVar, byte[] bArr) {
        super("Response code: " + i, iOException, zzgjVar, 2004, 1);
        this.zzc = i;
    }
}
