package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public class zzdvg extends Exception {
    private final int zza;

    public zzdvg(int i) {
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzdvg(int i, String str) {
        super(str);
        this.zza = i;
    }

    public zzdvg(int i, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
