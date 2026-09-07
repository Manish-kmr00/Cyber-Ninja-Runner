package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzfwl {
    private static final zzfwl zza = new zzfwi();
    private static final zzfwl zzb = new zzfwj(-1);
    private static final zzfwl zzc = new zzfwj(1);

    /* synthetic */ zzfwl(zzfwk zzfwkVar) {
    }

    public static zzfwl zzj() {
        return zza;
    }

    public abstract int zza();

    public abstract zzfwl zzb(int i, int i2);

    public abstract zzfwl zzc(Object obj, Object obj2, Comparator comparator);

    public abstract zzfwl zzd(boolean z, boolean z2);

    public abstract zzfwl zze(boolean z, boolean z2);
}
