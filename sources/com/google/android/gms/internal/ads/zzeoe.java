package com.google.android.gms.internal.ads;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeoe implements zzhey {
    public static zzeoe zza() {
        return zzeod.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* synthetic */ Object zzb() {
        List arrayList = new ArrayList();
        if (!((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlP)).isEmpty()) {
            arrayList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlP)).split(StringUtils.COMMA));
        }
        zzhfg.zzb(arrayList);
        return arrayList;
    }
}
