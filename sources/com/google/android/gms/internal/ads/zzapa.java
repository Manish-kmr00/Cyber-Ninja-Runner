package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzapa {
    private final Executor zza;

    public zzapa(Handler handler) {
        this.zza = new zzaoy(this, handler);
    }

    public final void zza(zzapj zzapjVar, zzaps zzapsVar) {
        zzapjVar.zzm("post-error");
        ((zzaoy) this.zza).zza.post(new zzaoz(zzapjVar, zzapp.zza(zzapsVar), null));
    }

    public final void zzb(zzapj zzapjVar, zzapp zzappVar, Runnable runnable) {
        zzapjVar.zzq();
        zzapjVar.zzm("post-response");
        ((zzaoy) this.zza).zza.post(new zzaoz(zzapjVar, zzappVar, runnable));
    }
}
