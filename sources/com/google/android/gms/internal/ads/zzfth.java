package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzfth implements zzftx {
    protected zzfth() {
    }

    public static zzfth zzc(char c) {
        return new zzfte(c);
    }

    @Override // com.google.android.gms.internal.ads.zzftx
    @Deprecated
    public final /* synthetic */ boolean zza(Object obj) {
        return zzb(((Character) obj).charValue());
    }

    public abstract boolean zzb(char c);
}
