package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzavz implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzawb zzb;

    zzavz(zzawb zzawbVar, int i, boolean z) {
        this.zza = i;
        this.zzb = zzawbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzasu zzasuVarZza;
        int i = this.zza;
        zzawb zzawbVar = this.zzb;
        if (i > 0) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            Context context = zzawbVar.zza;
            zzasuVarZza = zzfmz.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
        } catch (Throwable unused2) {
            zzasuVarZza = null;
        }
        zzawb zzawbVar2 = this.zzb;
        zzawbVar2.zzk = zzasuVarZza;
        int i2 = this.zza;
        if (i2 < 4) {
            if (zzasuVarZza != null && zzasuVarZza.zzaf() && !zzasuVarZza.zzg().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzasuVarZza.zzag() && zzasuVarZza.zzf().zzg() && zzasuVarZza.zzf().zza() != -2) {
                return;
            }
            zzawbVar2.zzn(i2 + 1, true);
        }
    }
}
