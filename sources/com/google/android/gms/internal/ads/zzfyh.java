package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzfyh implements Comparator {
    protected zzfyh() {
    }

    public static zzfyh zzb(Comparator comparator) {
        return new zzfwh(comparator);
    }

    public static zzfyh zzc() {
        return zzfyf.zza;
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public zzfyh zza() {
        return new zzfyq(this);
    }
}
