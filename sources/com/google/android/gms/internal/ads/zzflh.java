package com.google.android.gms.internal.ads;

import android.os.Build;
import android.webkit.WebView;
import com.amazon.device.ads.DtbDeviceData;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.pubmatic.sdk.crashanalytics.POBCrashAnalyticsConstants;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public class zzflh {
    private final String zza;
    private zzfmj zzb;
    private long zzc;
    private int zzd;

    public zzflh(String str) {
        zzb();
        this.zza = str;
        this.zzb = new zzfmj(null);
    }

    public final WebView zza() {
        return (WebView) this.zzb.get();
    }

    public final void zzb() {
        this.zzc = System.nanoTime();
        this.zzd = 1;
    }

    public void zzc() {
        this.zzb.clear();
    }

    public final void zzd(String str, long j) {
        if (j < this.zzc || this.zzd == 3) {
            return;
        }
        this.zzd = 3;
        zzfky.zza().zzh(zza(), this.zza, str);
    }

    public final void zze() {
        zzfky.zza().zzc(zza(), this.zza);
    }

    public final void zzf(zzfjw zzfjwVar) {
        zzfky.zza().zzd(zza(), this.zza, zzfjwVar.zzb());
    }

    public final void zzg(Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        zzfln.zze(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        zzfky.zza().zzf(zza(), jSONObject);
    }

    public final void zzh(String str, long j) {
        if (j >= this.zzc) {
            this.zzd = 2;
            zzfky.zza().zzh(zza(), this.zza, str);
        }
    }

    public void zzi(zzfjz zzfjzVar, zzfjx zzfjxVar) {
        zzj(zzfjzVar, zzfjxVar, null);
    }

    protected final void zzj(zzfjz zzfjzVar, zzfjx zzfjxVar, JSONObject jSONObject) {
        String strZzh = zzfjzVar.zzh();
        JSONObject jSONObject2 = new JSONObject();
        zzfln.zze(jSONObject2, "environment", "app");
        zzfln.zze(jSONObject2, "adSessionType", zzfjxVar.zzd());
        JSONObject jSONObject3 = new JSONObject();
        zzfln.zze(jSONObject3, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        zzfln.zze(jSONObject3, DtbDeviceData.DEVICE_DATA_OS_VERSION_KEY, Integer.toString(Build.VERSION.SDK_INT));
        zzfln.zze(jSONObject3, "os", "Android");
        zzfln.zze(jSONObject2, POBCrashAnalyticsConstants.DEVICE_INFO_KEY, jSONObject3);
        zzfln.zze(jSONObject2, "deviceCategory", zzflm.zza().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zzfln.zze(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzfln.zze(jSONObject4, HandleInvocationsFromAdViewer.KEY_OM_PARTNER, zzfjxVar.zze().zzb());
        zzfln.zze(jSONObject4, HandleInvocationsFromAdViewer.KEY_OM_PARTNER_VERSION, zzfjxVar.zze().zzc());
        zzfln.zze(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzfln.zze(jSONObject5, "libraryVersion", "1.5.2-google_20241009");
        zzfln.zze(jSONObject5, RemoteConfigConstants.RequestFieldKey.APP_ID, zzfkw.zzb().zza().getApplicationContext().getPackageName());
        zzfln.zze(jSONObject2, "app", jSONObject5);
        if (zzfjxVar.zzf() != null) {
            zzfln.zze(jSONObject2, "contentUrl", zzfjxVar.zzf());
        }
        if (zzfjxVar.zzg() != null) {
            zzfln.zze(jSONObject2, "customReferenceData", zzfjxVar.zzg());
        }
        JSONObject jSONObject6 = new JSONObject();
        Iterator it = zzfjxVar.zzh().iterator();
        if (it.hasNext()) {
            throw null;
        }
        zzfky.zza().zzj(zza(), strZzh, jSONObject2, jSONObject6, jSONObject);
    }

    public final void zzk(boolean z) {
        if (zzp()) {
            zzfky.zza().zzi(zza(), this.zza, true != z ? "backgrounded" : "foregrounded");
        }
    }

    public final void zzl(float f) {
        zzfky.zza().zze(zza(), this.zza, f);
    }

    public final void zzm(boolean z) {
        if (zzp()) {
            zzfky.zza().zzg(zza(), this.zza, true != z ? "unlocked" : "locked");
        }
    }

    final void zzn(WebView webView) {
        this.zzb = new zzfmj(webView);
    }

    public void zzo() {
    }

    public final boolean zzp() {
        return this.zzb.get() != null;
    }
}
