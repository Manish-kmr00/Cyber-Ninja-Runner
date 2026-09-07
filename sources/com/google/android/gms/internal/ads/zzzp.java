package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzzp implements Runnable {
    private final zzzo zza;

    public zzzp(zzzo zzzoVar) {
        this.zza = zzzoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzM();
    }
}
