package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public abstract class zzfmd extends AsyncTask {
    private zzfme zza;
    protected final zzflv zzd;

    public zzfmd(zzflv zzflvVar) {
        this.zzd = zzflvVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        zzfme zzfmeVar = this.zza;
        if (zzfmeVar != null) {
            zzfmeVar.zza(this);
        }
    }

    public final void zzb(zzfme zzfmeVar) {
        this.zza = zzfmeVar;
    }
}
