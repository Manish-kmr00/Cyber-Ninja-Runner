package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes14.dex */
public final class zzdjr implements zzcvw {
    private final zzdhq zza;
    private final zzdhv zzb;
    private final Executor zzc;
    private final Executor zzd;

    public zzdjr(zzdhq zzdhqVar, zzdhv zzdhvVar, Executor executor, Executor executor2) {
        this.zza = zzdhqVar;
        this.zzb = zzdhvVar;
        this.zzc = executor;
        this.zzd = executor2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(final zzcel zzcelVar) {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdjp
            @Override // java.lang.Runnable
            public final void run() {
                zzcelVar.zzd("onSdkImpression", new ArrayMap());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final void zzs() {
        if (this.zzb.zzd()) {
            zzdhq zzdhqVar = this.zza;
            zzeca zzecaVarZzu = zzdhqVar.zzu();
            if (zzecaVarZzu == null && zzdhqVar.zzw() != null && ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzft)).booleanValue()) {
                ListenableFuture listenableFutureZzw = zzdhqVar.zzw();
                zzbzp zzbzpVarZzp = zzdhqVar.zzp();
                if (listenableFutureZzw == null || zzbzpVarZzp == null) {
                    return;
                }
                zzgbs.zzr(zzgbs.zzl(listenableFutureZzw, zzbzpVarZzp), new zzdjq(this), this.zzd);
                return;
            }
            if (zzecaVarZzu != null) {
                zzcel zzcelVarZzr = zzdhqVar.zzr();
                zzcel zzcelVarZzs = zzdhqVar.zzs();
                if (zzcelVarZzr == null) {
                    zzcelVarZzr = zzcelVarZzs == null ? null : zzcelVarZzs;
                }
                if (zzcelVarZzr != null) {
                    zzb(zzcelVarZzr);
                }
            }
        }
    }
}
