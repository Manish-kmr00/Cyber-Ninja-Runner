package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes14.dex */
final class zzdip implements zzbfh {
    final /* synthetic */ zzdjo zza;
    final /* synthetic */ ViewGroup zzb;

    zzdip(zzdjo zzdjoVar, ViewGroup viewGroup) {
        this.zza = zzdjoVar;
        this.zzb = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final JSONObject zza() {
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final JSONObject zzb() {
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzc() {
        zzfww zzfwwVar = zzdim.zza;
        zzdjo zzdjoVar = this.zza;
        Map mapZzm = zzdjoVar.zzm();
        if (mapZzm == null) {
            return;
        }
        int size = zzfwwVar.size();
        int i = 0;
        while (i < size) {
            Object obj = mapZzm.get((String) zzfwwVar.get(i));
            i++;
            if (obj != null) {
                zzdjoVar.onClick(this.zzb);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzd(MotionEvent motionEvent) {
        this.zza.onTouch(null, motionEvent);
    }
}
