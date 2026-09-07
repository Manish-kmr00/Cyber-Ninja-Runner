package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.view.View;
import com.pubmatic.sdk.common.POBCommonConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes14.dex */
public final class zzdje {
    private final zzdoe zza;
    private final zzdmt zzb;
    private final zzcne zzc;
    private final zzdhy zzd;

    public zzdje(zzdoe zzdoeVar, zzdmt zzdmtVar, zzcne zzcneVar, zzdhy zzdhyVar) {
        this.zza = zzdoeVar;
        this.zzb = zzdmtVar;
        this.zzc = zzcneVar;
        this.zzd = zzdhyVar;
    }

    public static /* synthetic */ void zzb(zzdje zzdjeVar, zzcel zzcelVar, Map map) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Hiding native ads overlay.");
        zzcelVar.zzF().setVisibility(8);
        zzdjeVar.zzc.zze(false);
    }

    public static /* synthetic */ void zzd(zzdje zzdjeVar, zzcel zzcelVar, Map map) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Showing native ads overlay.");
        zzcelVar.zzF().setVisibility(0);
        zzdjeVar.zzc.zze(true);
    }

    public static /* synthetic */ void zze(zzdje zzdjeVar, Map map, boolean z, int i, String str, String str2) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "htmlLoaded");
        map2.put("id", (String) map.get("id"));
        zzdjeVar.zzb.zzj("sendMessageToNativeJs", map2);
    }

    public final View zza() throws zzcex {
        zzcel zzcelVarZza = this.zza.zza(com.google.android.gms.ads.internal.client.zzr.zzc(), null, null);
        zzcelVarZza.zzF().setVisibility(8);
        zzcelVarZza.zzag("/sendMessageToSdk", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdiy
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                this.zza.zzb.zzj("sendMessageToNativeJs", map);
            }
        });
        zzcelVarZza.zzag("/adMuted", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdiz
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                this.zza.zzd.zzi();
            }
        });
        WeakReference weakReference = new WeakReference(zzcelVarZza);
        zzbjj zzbjjVar = new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdja
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, final Map map) {
                zzcel zzcelVar = (zzcel) obj;
                zzcgd zzcgdVarZzN = zzcelVar.zzN();
                final zzdje zzdjeVar = this.zza;
                zzcgdVarZzN.zzC(new zzcgb() { // from class: com.google.android.gms.internal.ads.zzdjd
                    @Override // com.google.android.gms.internal.ads.zzcgb
                    public final void zza(boolean z, int i, String str, String str2) {
                        zzdje.zze(zzdjeVar, map, z, i, str, str2);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzcelVar.loadData(str, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8");
                } else {
                    zzcelVar.loadDataWithBaseURL(str2, str, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
                }
            }
        };
        zzdmt zzdmtVar = this.zzb;
        zzdmtVar.zzm(weakReference, "/loadHtml", zzbjjVar);
        zzdmtVar.zzm(new WeakReference(zzcelVarZza), "/showOverlay", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdjb
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                zzdje.zzd(this.zza, (zzcel) obj, map);
            }
        });
        zzdmtVar.zzm(new WeakReference(zzcelVarZza), "/hideOverlay", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdjc
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                zzdje.zzb(this.zza, (zzcel) obj, map);
            }
        });
        return zzcelVarZza.zzF();
    }
}
