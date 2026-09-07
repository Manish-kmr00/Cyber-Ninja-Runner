package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaph implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzapj zzc;

    zzaph(zzapj zzapjVar, String str, long j) {
        this.zza = str;
        this.zzb = j;
        this.zzc = zzapjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzapj zzapjVar = this.zzc;
        zzapjVar.zza.zza(this.zza, this.zzb);
        zzapjVar.zza.zzb(zzapjVar.toString());
    }
}
