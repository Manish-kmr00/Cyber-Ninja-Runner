package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.util.JsonReader;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.internal.ads.zzbuy;
import com.google.android.gms.internal.ads.zzdwi;
import com.google.android.gms.internal.ads.zzdxr;
import com.google.android.gms.internal.ads.zzgaz;
import com.google.android.gms.internal.ads.zzgbs;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzbi implements zzgaz {
    private final Executor zza;
    private final zzdwi zzb;

    public zzbi(Executor executor, zzdwi zzdwiVar) {
        this.zza = executor;
        this.zzb = zzdwiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgaz
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        final zzbuy zzbuyVar = (zzbuy) obj;
        return zzgbs.zzn(this.zzb.zzc(zzbuyVar), new zzgaz() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbh
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj2) {
                zzdxr zzdxrVar = (zzdxr) obj2;
                zzbk zzbkVar = new zzbk(new JsonReader(new InputStreamReader(zzdxrVar.zzb())), zzdxrVar.zza());
                zzbuy zzbuyVar2 = zzbuyVar;
                try {
                    zzbkVar.zzb = com.google.android.gms.ads.internal.client.zzbb.zzb().zzj(zzbuyVar2.zza).toString();
                } catch (JSONException unused) {
                    zzbkVar.zzb = JsonUtils.EMPTY_JSON;
                }
                Bundle bundle = zzbuyVar2.zzn;
                if (!bundle.isEmpty()) {
                    try {
                        zzbkVar.zzc = com.google.android.gms.ads.internal.client.zzbb.zzb().zzj(bundle).toString();
                    } catch (JSONException unused2) {
                    }
                }
                return zzgbs.zzh(zzbkVar);
            }
        }, this.zza);
    }
}
