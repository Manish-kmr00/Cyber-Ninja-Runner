package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.AdFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfgn implements Runnable {
    private final zzfgq zzb;
    private String zzc;
    private String zze;
    private zzfbf zzf;
    private com.google.android.gms.ads.internal.client.zze zzg;
    private Future zzh;
    private final List zza = new ArrayList();
    private int zzi = 2;
    private zzfgs zzd = zzfgs.SCAR_REQUEST_TYPE_UNSPECIFIED;

    zzfgn(zzfgq zzfgqVar) {
        this.zzb = zzfgqVar;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        zzh();
    }

    public final synchronized zzfgn zza(zzfgc zzfgcVar) {
        if (((Boolean) zzbeb.zzc.zze()).booleanValue()) {
            List list = this.zza;
            zzfgcVar.zzj();
            list.add(zzfgcVar);
            Future future = this.zzh;
            if (future != null) {
                future.cancel(false);
            }
            this.zzh = zzbzk.zzd.schedule(this, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziR)).intValue(), TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public final synchronized zzfgn zzb(String str) {
        if (((Boolean) zzbeb.zzc.zze()).booleanValue() && zzfgm.zze(str)) {
            this.zzc = str;
        }
        return this;
    }

    public final synchronized zzfgn zzc(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) zzbeb.zzc.zze()).booleanValue()) {
            this.zzg = zzeVar;
        }
        return this;
    }

    public final synchronized zzfgn zzd(ArrayList arrayList) {
        if (((Boolean) zzbeb.zzc.zze()).booleanValue()) {
            if (arrayList.contains("banner") || arrayList.contains(AdFormat.BANNER.name())) {
                this.zzi = 3;
            } else if (arrayList.contains("interstitial") || arrayList.contains(AdFormat.INTERSTITIAL.name())) {
                this.zzi = 4;
            } else if (arrayList.contains("native") || arrayList.contains(AdFormat.NATIVE.name())) {
                this.zzi = 8;
            } else if (arrayList.contains("rewarded") || arrayList.contains(AdFormat.REWARDED.name())) {
                this.zzi = 5;
            } else if (arrayList.contains("app_open_ad")) {
                this.zzi = 7;
            } else if (arrayList.contains("rewarded_interstitial") || arrayList.contains(AdFormat.REWARDED_INTERSTITIAL.name())) {
                this.zzi = 6;
            }
        }
        return this;
    }

    public final synchronized zzfgn zze(String str) {
        if (((Boolean) zzbeb.zzc.zze()).booleanValue()) {
            this.zze = str;
        }
        return this;
    }

    public final synchronized zzfgn zzf(Bundle bundle) {
        if (((Boolean) zzbeb.zzc.zze()).booleanValue()) {
            this.zzd = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zza(bundle);
        }
        return this;
    }

    public final synchronized zzfgn zzg(zzfbf zzfbfVar) {
        if (((Boolean) zzbeb.zzc.zze()).booleanValue()) {
            this.zzf = zzfbfVar;
        }
        return this;
    }

    public final synchronized void zzh() {
        if (((Boolean) zzbeb.zzc.zze()).booleanValue()) {
            Future future = this.zzh;
            if (future != null) {
                future.cancel(false);
            }
            List<zzfgc> list = this.zza;
            for (zzfgc zzfgcVar : list) {
                int i = this.zzi;
                if (i != 2) {
                    zzfgcVar.zzn(i);
                }
                if (!TextUtils.isEmpty(this.zzc)) {
                    zzfgcVar.zze(this.zzc);
                }
                if (!TextUtils.isEmpty(this.zze) && !zzfgcVar.zzl()) {
                    zzfgcVar.zzd(this.zze);
                }
                zzfbf zzfbfVar = this.zzf;
                if (zzfbfVar != null) {
                    zzfgcVar.zzb(zzfbfVar);
                } else {
                    com.google.android.gms.ads.internal.client.zze zzeVar = this.zzg;
                    if (zzeVar != null) {
                        zzfgcVar.zza(zzeVar);
                    }
                }
                zzfgcVar.zzf(this.zzd);
                this.zzb.zzc(zzfgcVar.zzm());
            }
            list.clear();
        }
    }

    public final synchronized zzfgn zzi(int i) {
        if (((Boolean) zzbeb.zzc.zze()).booleanValue()) {
            this.zzi = i;
        }
        return this;
    }
}
