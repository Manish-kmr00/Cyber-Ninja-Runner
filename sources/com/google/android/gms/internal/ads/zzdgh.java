package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.json.b9;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdgh implements zzbjj {
    private final WeakReference zza;

    /* synthetic */ zzdgh(zzdgm zzdgmVar, zzdgl zzdglVar) {
        this.zza = new WeakReference(zzdgmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        zzdgm zzdgmVar = (zzdgm) this.zza.get();
        if (zzdgmVar != null && "_ac".equals((String) map.get(b9.h.j0))) {
            zzdgmVar.zzh.onAdClicked();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkQ)).booleanValue()) {
                zzdgmVar.zzi.zzdd();
                if (TextUtils.isEmpty((CharSequence) map.get("sccg"))) {
                    return;
                }
                zzdgmVar.zzi.zzu();
            }
        }
    }
}
