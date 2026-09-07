package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import com.google.android.gms.ads.MobileAds;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzdqi implements zzczx, com.google.android.gms.ads.internal.client.zza, zzcvw, zzcvg, zzdch {
    private final Context zzc;
    private final zzfch zzd;
    private final zzdre zze;
    private final zzfbg zzf;
    private final zzfau zzg;
    private final zzeat zzh;
    private final String zzi;
    private Boolean zzk;
    private long zzj = -1;
    final AtomicBoolean zza = new AtomicBoolean(false);
    final AtomicBoolean zzb = new AtomicBoolean(false);
    private final boolean zzl = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgM)).booleanValue();

    public zzdqi(Context context, zzfch zzfchVar, zzdre zzdreVar, zzfbg zzfbgVar, zzfau zzfauVar, zzeat zzeatVar, String str) {
        this.zzc = context;
        this.zzd = zzfchVar;
        this.zze = zzdreVar;
        this.zzf = zzfbgVar;
        this.zzg = zzfauVar;
        this.zzh = zzeatVar;
        this.zzi = str;
    }

    private final zzdrd zzd(String str) {
        zzfbg zzfbgVar = this.zzf;
        zzfbf zzfbfVar = zzfbgVar.zzb;
        zzdrd zzdrdVarZza = this.zze.zza();
        zzdrdVarZza.zzd(zzfbfVar.zzb);
        zzfau zzfauVar = this.zzg;
        zzdrdVarZza.zzc(zzfauVar);
        zzdrdVarZza.zzb("action", str);
        zzdrdVarZza.zzb("ad_format", this.zzi.toUpperCase(Locale.ROOT));
        List list = zzfauVar.zzt;
        if (!list.isEmpty()) {
            zzdrdVarZza.zzb("ancn", (String) list.get(0));
        }
        if (zzfauVar.zzb()) {
            zzdrdVarZza.zzb("device_connectivity", true != com.google.android.gms.ads.internal.zzv.zzp().zzA(this.zzc) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY);
            zzdrdVarZza.zzb("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis()));
            zzdrdVarZza.zzb("offline_ad", "1");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgT)).booleanValue()) {
            boolean zZzf = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzf(zzfbgVar);
            zzdrdVarZza.zzb("scar", String.valueOf(zZzf));
            if (zZzf) {
                com.google.android.gms.ads.internal.client.zzm zzmVar = zzfbgVar.zza.zza.zzd;
                zzdrdVarZza.zzb("ragent", zzmVar.zzp);
                zzdrdVarZza.zzb("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzc(zzmVar)));
            }
        }
        return zzdrdVarZza;
    }

    private final void zze(zzdrd zzdrdVar) {
        if (!this.zzg.zzb()) {
            zzdrdVar.zzj();
            return;
        }
        this.zzh.zzd(new zzeav(com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis(), this.zzf.zzb.zzb.zzb, zzdrdVar.zze(), 2));
    }

    private final boolean zzf() {
        String strZzq;
        if (this.zzk == null) {
            synchronized (this) {
                if (this.zzk == null) {
                    String str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbF);
                    com.google.android.gms.ads.internal.zzv.zzq();
                    try {
                        strZzq = com.google.android.gms.ads.internal.util.zzs.zzq(this.zzc);
                    } catch (RemoteException unused) {
                        strZzq = null;
                    }
                    boolean zMatches = false;
                    if (str != null && strZzq != null) {
                        try {
                            zMatches = Pattern.matches(str, strZzq);
                        } catch (RuntimeException e) {
                            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzk = Boolean.valueOf(zMatches);
                }
            }
        }
        return this.zzk.booleanValue();
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (this.zzg.zzb()) {
            zze(zzd("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.client.zze zzeVar2;
        if (this.zzl) {
            zzdrd zzdrdVarZzd = zzd("ifts");
            zzdrdVarZzd.zzb("reason", "adapter");
            int i = zzeVar.zza;
            String str = zzeVar.zzb;
            if (zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN) && (zzeVar2 = zzeVar.zzd) != null && !zzeVar2.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                com.google.android.gms.ads.internal.client.zze zzeVar3 = zzeVar.zzd;
                i = zzeVar3.zza;
                str = zzeVar3.zzb;
            }
            if (i >= 0) {
                zzdrdVarZzd.zzb("arec", String.valueOf(i));
            }
            String strZza = this.zzd.zza(str);
            if (strZza != null) {
                zzdrdVarZzd.zzb("areec", strZza);
            }
            zzdrdVarZzd.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzb() {
        if (this.zzl) {
            zzdrd zzdrdVarZzd = zzd("ifts");
            zzdrdVarZzd.zzb("reason", "blocked");
            zzdrdVarZzd.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzc(zzdfl zzdflVar) {
        if (this.zzl) {
            zzdrd zzdrdVarZzd = zzd("ifts");
            zzdrdVarZzd.zzb("reason", "exception");
            if (!TextUtils.isEmpty(zzdflVar.getMessage())) {
                zzdrdVarZzd.zzb("msg", zzdflVar.getMessage());
            }
            zzdrdVarZzd.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczx
    public final void zzi() {
        if (zzf()) {
            zzd("adapter_shown").zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczx
    public final void zzj() {
        if (zzf()) {
            zzdrd zzdrdVarZzd = zzd("adapter_impression");
            if (this.zza.get()) {
                zzdrdVarZzd.zzb("asc", "1");
                zzdrdVarZzd.zzb("sil", String.valueOf(com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis() - this.zzj));
            } else {
                zzdrdVarZzd.zzb("asc", "0");
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zznq)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zzq();
                zzdrdVarZzd.zzb("foreground", true != com.google.android.gms.ads.internal.util.zzs.zzH(this.zzc) ? "1" : "0");
                zzdrdVarZzd.zzb("fg_show", true != this.zzb.get() ? "0" : "1");
            }
            zzdrdVarZzd.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final void zzs() {
        if (zzf() || this.zzg.zzb()) {
            zzdrd zzdrdVarZzd = zzd("impression");
            if (this.zzj > 0) {
                zzdrdVarZzd.zzb("s_imp_l", String.valueOf(com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis() - this.zzj));
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zznq)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zzq();
                zzdrdVarZzd.zzb("foreground", true != com.google.android.gms.ads.internal.util.zzs.zzH(this.zzc) ? "1" : "0");
                zzdrdVarZzd.zzb("fg_show", true != this.zzb.get() ? "0" : "1");
            }
            zze(zzdrdVarZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdch
    public final void zzu() {
        if (zzf()) {
            this.zza.set(true);
            this.zzj = com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis();
            zzdrd zzdrdVarZzd = zzd("iscs");
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zznq)).booleanValue()) {
                AtomicBoolean atomicBoolean = this.zzb;
                com.google.android.gms.ads.internal.zzv.zzq();
                atomicBoolean.set(!com.google.android.gms.ads.internal.util.zzs.zzH(this.zzc));
                zzdrdVarZzd.zzb("foreground", true != atomicBoolean.get() ? "0" : "1");
            }
            zzdrdVarZzd.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdch
    public final void zzv() {
    }
}
