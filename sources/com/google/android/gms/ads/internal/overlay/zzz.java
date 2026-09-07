package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzcel;
import com.google.android.gms.internal.ads.zzfrl;
import com.google.android.gms.internal.ads.zzfrm;
import com.google.android.gms.internal.ads.zzfrn;
import com.google.android.gms.internal.ads.zzfro;
import com.google.android.gms.internal.ads.zzfsh;
import com.google.android.gms.internal.ads.zzfsj;
import com.google.android.gms.internal.ads.zzfsk;
import com.google.android.gms.internal.ads.zzfsl;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsz;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzz {
    private zzfsk zzf;
    private zzcel zzc = null;
    private boolean zze = false;
    private String zza = null;
    private zzfrn zzd = null;
    private String zzb = null;

    public static /* synthetic */ void zza(zzz zzzVar, String str, Map map) {
        zzcel zzcelVar = zzzVar.zzc;
        if (zzcelVar != null) {
            zzcelVar.zzd(str, map);
        }
    }

    private final zzfsm zzl() {
        zzfsl zzfslVarZzc = zzfsm.zzc();
        if (!((Boolean) zzbd.zzc().zzb(zzbci.zzlC)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzfslVarZzc.zzb(str);
            } else {
                zzg("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzfslVarZzc.zza(this.zzb);
        }
        return zzfslVarZzc.zzc();
    }

    private final void zzm() {
        if (this.zzf == null) {
            this.zzf = new zzy(this);
        }
    }

    public final synchronized void zzb(zzcel zzcelVar, Context context) {
        this.zzc = zzcelVar;
        if (!zzk(context)) {
            zzg("Unable to bind", "on_play_store_bind");
            return;
        }
        HashMap map = new HashMap();
        map.put("action", "fetch_completed");
        zzf("on_play_store_bind", map);
    }

    public final void zzc() {
        zzfrn zzfrnVar;
        if (!this.zze || (zzfrnVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
        } else {
            zzfrnVar.zza(zzl(), this.zzf);
            zze("onLMDOverlayCollapse");
        }
    }

    public final void zzd() {
        zzfrn zzfrnVar;
        if (!this.zze || (zzfrnVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfrl zzfrlVarZzc = zzfrm.zzc();
        if (!((Boolean) zzbd.zzc().zzb(zzbci.zzlC)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzfrlVarZzc.zzb(str);
            } else {
                zzg("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzfrlVarZzc.zza(this.zzb);
        }
        zzfrnVar.zzb(zzfrlVarZzc.zzc(), this.zzf);
    }

    final void zze(String str) {
        zzf(str, new HashMap());
    }

    final void zzf(final String str, final Map map) {
        zzbzk.zzf.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzx
            @Override // java.lang.Runnable
            public final void run() {
                zzz.zza(this.zza, str, map);
            }
        });
    }

    final void zzg(String str, String str2) {
        com.google.android.gms.ads.internal.util.zze.zza(str);
        if (this.zzc != null) {
            HashMap map = new HashMap();
            map.put("message", str);
            map.put("action", str2);
            zzf("onError", map);
        }
    }

    public final void zzh() {
        zzfrn zzfrnVar;
        if (!this.zze || (zzfrnVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
        } else {
            zzfrnVar.zzc(zzl(), this.zzf);
            zze("onLMDOverlayExpand");
        }
    }

    final void zzi(zzfsj zzfsjVar) {
        if (!TextUtils.isEmpty(zzfsjVar.zzb())) {
            if (!((Boolean) zzbd.zzc().zzb(zzbci.zzlC)).booleanValue()) {
                this.zza = zzfsjVar.zzb();
            }
        }
        switch (zzfsjVar.zza()) {
            case 8152:
                zze("onLMDOverlayOpened");
                break;
            case 8153:
                zze("onLMDOverlayClicked");
                break;
            case 8155:
                zze("onLMDOverlayClose");
                break;
            case 8157:
                this.zza = null;
                this.zzb = null;
                this.zze = false;
                break;
            case 8160:
            case 8161:
            case 8162:
                HashMap map = new HashMap();
                map.put("error", String.valueOf(zzfsjVar.zza()));
                zzf("onLMDOverlayFailedToOpen", map);
                break;
        }
    }

    public final void zzj(zzcel zzcelVar, zzfsh zzfshVar) {
        if (zzcelVar == null) {
            zzg("adWebview missing", "onLMDShow");
            return;
        }
        this.zzc = zzcelVar;
        if (!this.zze && !zzk(zzcelVar.getContext())) {
            zzg("LMDOverlay not bound", "on_play_store_bind");
            return;
        }
        if (((Boolean) zzbd.zzc().zzb(zzbci.zzlC)).booleanValue()) {
            this.zzb = zzfshVar.zzh();
        }
        zzm();
        zzfrn zzfrnVar = this.zzd;
        if (zzfrnVar != null) {
            zzfrnVar.zzd(zzfshVar, this.zzf);
        }
    }

    public final synchronized boolean zzk(Context context) {
        if (!zzfsz.zza(context)) {
            return false;
        }
        try {
            this.zzd = zzfro.zza(context);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Error connecting LMD Overlay service");
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (this.zzd == null) {
            this.zze = false;
            return false;
        }
        zzm();
        this.zze = true;
        return true;
    }
}
