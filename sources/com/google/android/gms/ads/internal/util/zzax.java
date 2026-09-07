package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzax implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ boolean zzd;

    zzax(zzay zzayVar, Context context, String str, boolean z, boolean z2) {
        this.zza = context;
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzv.zzq();
        Context context = this.zza;
        AlertDialog.Builder builderZzL = zzs.zzL(context);
        builderZzL.setMessage(this.zzb);
        if (this.zzc) {
            builderZzL.setTitle("Error");
        } else {
            builderZzL.setTitle("Info");
        }
        if (this.zzd) {
            builderZzL.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builderZzL.setPositiveButton("Learn More", new zzaw(this, context));
            builderZzL.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builderZzL.create().show();
    }
}
