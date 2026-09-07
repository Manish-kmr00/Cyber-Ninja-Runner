package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbrv implements View.OnClickListener {
    final /* synthetic */ zzbrw zza;

    zzbrv(zzbrw zzbrwVar) {
        this.zza = zzbrwVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zza.zzb(true);
    }
}
