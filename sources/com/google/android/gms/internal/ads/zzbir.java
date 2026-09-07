package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbir implements zzbjj {
    zzbir() {
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcel zzcelVar = (zzcel) obj;
        if (TextUtils.isEmpty((CharSequence) map.get(RemoteConfigConstants.RequestFieldKey.APP_ID))) {
            com.google.android.gms.ads.internal.util.zze.zza("Missing App Id, cannot show LMD Overlay without it");
            return;
        }
        zzfsg zzfsgVarZzl = zzfsh.zzl();
        zzfsgVarZzl.zzb((String) map.get(RemoteConfigConstants.RequestFieldKey.APP_ID));
        zzfsgVarZzl.zzh(zzcelVar.getWidth());
        zzfsgVarZzl.zzg(zzcelVar.zzF().getWindowToken());
        if (map.containsKey("gravityX") && map.containsKey("gravityY")) {
            zzfsgVarZzl.zzd(Integer.parseInt((String) map.get("gravityX")) | Integer.parseInt((String) map.get("gravityY")));
        } else {
            zzfsgVarZzl.zzd(81);
        }
        if (map.containsKey("verticalMargin")) {
            zzfsgVarZzl.zze(Float.parseFloat((String) map.get("verticalMargin")));
        } else {
            zzfsgVarZzl.zze(0.02f);
        }
        if (map.containsKey("enifd")) {
            zzfsgVarZzl.zza((String) map.get("enifd"));
        }
        try {
            com.google.android.gms.ads.internal.zzv.zzk().zzj(zzcelVar, zzfsgVarZzl.zzi());
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "DefaultGmsgHandlers.ShowLMDOverlay");
            com.google.android.gms.ads.internal.util.zze.zza("Missing parameters for LMD Overlay show request");
        }
    }
}
