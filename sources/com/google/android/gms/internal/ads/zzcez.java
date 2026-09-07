package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final /* synthetic */ class zzcez implements Runnable {
    public final /* synthetic */ zzcel zza;

    public /* synthetic */ zzcez(zzcel zzcelVar) {
        this.zza = zzcelVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.destroy();
    }
}
