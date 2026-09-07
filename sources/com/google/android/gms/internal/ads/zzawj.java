package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzawj implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzawk zza;

    zzawj(zzawk zzawkVar) {
        this.zza = zzawkVar;
    }

    @Override // android.app.AppOpsManager.OnOpActiveChangedListener
    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        if (z) {
            zzawk zzawkVar = this.zza;
            zzawkVar.zzb = System.currentTimeMillis();
            zzawkVar.zze = true;
        } else {
            zzawk zzawkVar2 = this.zza;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (zzawkVar2.zzc > 0 && jCurrentTimeMillis >= zzawkVar2.zzc) {
                zzawkVar2.zzd = jCurrentTimeMillis - zzawkVar2.zzc;
            }
            zzawkVar2.zze = false;
        }
    }
}
