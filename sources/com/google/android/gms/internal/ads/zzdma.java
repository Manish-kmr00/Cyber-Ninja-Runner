package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes14.dex */
final class zzdma implements zzbfh {
    final /* synthetic */ String zza = NativeCustomFormatAd.ASSET_NAME_VIDEO;
    final /* synthetic */ zzdmb zzb;

    zzdma(zzdmb zzdmbVar, String str) {
        this.zzb = zzdmbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final JSONObject zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final JSONObject zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzc() {
        zzdmb zzdmbVar = this.zzb;
        if (zzdmbVar.zzd != null) {
            zzdmbVar.zzd.zzF(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzd(MotionEvent motionEvent) {
    }
}
