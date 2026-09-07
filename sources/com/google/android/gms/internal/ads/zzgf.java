package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class zzgf extends IOException {
    public final int zza;

    public zzgf(int i) {
        this.zza = i;
    }

    public zzgf(String str, int i) {
        super(str);
        this.zza = i;
    }

    public zzgf(String str, Throwable th, int i) {
        super(str, th);
        this.zza = i;
    }

    public zzgf(Throwable th, int i) {
        super(th);
        this.zza = i;
    }
}
