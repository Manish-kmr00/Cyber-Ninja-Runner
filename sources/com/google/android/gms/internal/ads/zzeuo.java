package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeuo implements zzesv {
    private final JSONObject zza;

    zzeuo(Context context) {
        this.zza = zzbuu.zzc(context, VersionInfoParcel.forPackage());
    }

    public static /* synthetic */ void zzc(zzeuo zzeuoVar, JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", zzeuoVar.zza);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed putting version constants.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 46;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzma)).booleanValue() ? zzgbs.zzh(new zzesu() { // from class: com.google.android.gms.internal.ads.zzeum
            @Override // com.google.android.gms.internal.ads.zzesu
            public final /* synthetic */ void zza(Object obj) {
            }

            @Override // com.google.android.gms.internal.ads.zzesu
            public final void zzb(Object obj) {
            }
        }) : zzgbs.zzh(new zzesu() { // from class: com.google.android.gms.internal.ads.zzeun
            @Override // com.google.android.gms.internal.ads.zzesu
            public final /* synthetic */ void zza(Object obj) {
            }

            @Override // com.google.android.gms.internal.ads.zzesu
            public final void zzb(Object obj) {
                zzeuo.zzc(this.zza, (JSONObject) obj);
            }
        });
    }
}
