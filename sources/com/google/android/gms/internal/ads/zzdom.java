package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzdom implements zzcvx {
    private final zzcel zza;

    zzdom(zzcel zzcelVar) {
        this.zza = zzcelVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcvx
    public final void zzdh(Context context) {
        zzcel zzcelVar = this.zza;
        if (zzcelVar != null) {
            zzcelVar.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvx
    public final void zzdj(Context context) {
        zzcel zzcelVar = this.zza;
        if (zzcelVar != null) {
            zzcelVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvx
    public final void zzdk(Context context) {
        zzcel zzcelVar = this.zza;
        if (zzcelVar != null) {
            zzcelVar.onResume();
        }
    }
}
