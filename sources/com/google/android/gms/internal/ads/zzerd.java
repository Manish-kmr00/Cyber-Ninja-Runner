package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzerd implements zzesv {
    private static String zza;
    private final zzgcd zzb;
    private final Context zzc;

    public zzerd(zzgcd zzgcdVar, Context context) {
        this.zzb = zzgcdVar;
        this.zzc = context;
    }

    public static /* synthetic */ zzere zzc(zzerd zzerdVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfm)).booleanValue()) {
            return new zzere(null);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfv)).booleanValue()) {
            return new zzere(com.google.android.gms.ads.internal.zzv.zzB().zzf(zzerdVar.zzc));
        }
        if (zza == null) {
            zza = com.google.android.gms.ads.internal.zzv.zzB().zzf(zzerdVar.zzc);
        }
        return new zzere(zza);
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 27;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzerc
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzerd.zzc(this.zza);
            }
        });
    }
}
