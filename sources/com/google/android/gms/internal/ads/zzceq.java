package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzceq implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzbxi zza;
    final /* synthetic */ zzcet zzb;

    zzceq(zzcet zzcetVar, zzbxi zzbxiVar) {
        this.zza = zzbxiVar;
        this.zzb = zzcetVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzaa(view, this.zza, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
