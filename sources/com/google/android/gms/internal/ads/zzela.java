package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzela implements zzesv {
    private final zzgcd zza;
    private final zzfbp zzb;
    private final int zzc;

    zzela(zzgcd zzgcdVar, zzfbp zzfbpVar, zzfce zzfceVar, int i) {
        this.zza = zzgcdVar;
        this.zzb = zzfbpVar;
        this.zzc = i;
    }

    public static /* synthetic */ zzelb zzc(zzela zzelaVar) {
        boolean zEquals;
        String strZza = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgY)).booleanValue()) {
            zzfbp zzfbpVar = zzelaVar.zzb;
            if (zzelaVar.zzc != 2) {
                String strZzc = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzc(zzfbpVar.zzd);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgZ)).booleanValue()) {
                    zEquals = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzha)).split(StringUtils.COMMA)).contains(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzb(strZzc));
                } else {
                    zEquals = Objects.equals(strZzc, "requester_type_2");
                }
                if (zEquals) {
                    strZza = zzfce.zza();
                }
            }
        }
        return new zzelb(strZza);
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 5;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzekz
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzela.zzc(this.zza);
            }
        });
    }
}
