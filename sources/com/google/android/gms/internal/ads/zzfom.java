package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzfom extends Exception {
    private final int zza;

    public zzfom(int i, String str) {
        super(str);
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzfom(int i, Throwable th) {
        super(th);
        this.zza = i;
    }
}
