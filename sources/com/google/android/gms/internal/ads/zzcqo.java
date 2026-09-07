package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcqo implements zzefv {
    public final List zza;

    public zzcqo(zzcqg zzcqgVar) {
        this.zza = Collections.singletonList(zzgbs.zzh(zzcqgVar));
    }

    public zzcqo(List list) {
        this.zza = list;
    }

    @Override // com.google.android.gms.internal.ads.zzefv
    public final void zzq() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzgbs.zzr((ListenableFuture) it.next(), new zzcqn(this), zzgck.zzc());
        }
    }
}
