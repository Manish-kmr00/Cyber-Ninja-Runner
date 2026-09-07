package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzeiw implements zzekg {
    final /* synthetic */ zzeix zza;

    zzeiw(zzeix zzeixVar) {
        this.zza = zzeixVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekg
    public final void zza() {
        zzeix zzeixVar = this.zza;
        synchronized (zzeixVar) {
            zzeixVar.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekg
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzeix zzeixVar = this.zza;
        zzcnz zzcnzVar = (zzcnz) obj;
        synchronized (zzeixVar) {
            if (zzeixVar.zzi != null) {
                zzeixVar.zzi.zzb();
            }
            zzeixVar.zzi = zzcnzVar;
            zzeixVar.zzi.zzk();
        }
    }
}
