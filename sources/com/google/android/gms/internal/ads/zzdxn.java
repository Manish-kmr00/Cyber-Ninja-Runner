package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdxn implements zzdxp {
    private final Map zza;
    private final zzgcd zzb;
    private final zzcxy zzc;

    public zzdxn(Map map, zzgcd zzgcdVar, zzcxy zzcxyVar) {
        this.zza = map;
        this.zzb = zzgcdVar;
        this.zzc = zzcxyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final ListenableFuture zzc(final zzbuy zzbuyVar) {
        this.zzc.zzdl(zzbuyVar);
        ListenableFuture listenableFutureZzg = zzgbs.zzg(new zzdvg(3));
        for (String str : ((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzin)).split(StringUtils.COMMA)) {
            final zzhfn zzhfnVar = (zzhfn) this.zza.get(str.trim());
            if (zzhfnVar != null) {
                listenableFutureZzg = zzgbs.zzf(listenableFutureZzg, zzdvg.class, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdxl
                    @Override // com.google.android.gms.internal.ads.zzgaz
                    public final ListenableFuture zza(Object obj) {
                        return ((zzdxp) zzhfnVar.zzb()).zzc(zzbuyVar);
                    }
                }, this.zzb);
            }
        }
        zzgbs.zzr(listenableFutureZzg, new zzdxm(this), zzbzk.zzg);
        return listenableFutureZzg;
    }
}
