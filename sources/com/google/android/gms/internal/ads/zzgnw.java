package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgnw extends RuntimeException {
    public zzgnw(String str) {
        super(str);
    }

    public static Object zza(zzgnv zzgnvVar) {
        try {
            return zzgnvVar.zza();
        } catch (Exception e) {
            throw new zzgnw(e);
        }
    }

    public zzgnw(String str, Throwable th) {
        super(str, th);
    }

    public zzgnw(Throwable th) {
        super(th);
    }
}
