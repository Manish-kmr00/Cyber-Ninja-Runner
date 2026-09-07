package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcjl extends com.google.android.gms.ads.internal.client.zzcx {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzdou zzc;
    private final zzech zzd;
    private final zzein zze;
    private final zzdti zzf;
    private final zzbxw zzg;
    private final zzdoz zzh;
    private final zzdud zzi;
    private final zzbfb zzj;
    private final zzfgq zzk;
    private final zzfcl zzl;
    private final zzcsr zzm;
    private final zzdre zzn;
    private boolean zzo = false;
    private final Long zzp = Long.valueOf(com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime());

    zzcjl(Context context, VersionInfoParcel versionInfoParcel, zzdou zzdouVar, zzech zzechVar, zzein zzeinVar, zzdti zzdtiVar, zzbxw zzbxwVar, zzdoz zzdozVar, zzdud zzdudVar, zzbfb zzbfbVar, zzfgq zzfgqVar, zzfcl zzfclVar, zzcsr zzcsrVar, zzdre zzdreVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzdouVar;
        this.zzd = zzechVar;
        this.zze = zzeinVar;
        this.zzf = zzdtiVar;
        this.zzg = zzbxwVar;
        this.zzh = zzdozVar;
        this.zzi = zzdudVar;
        this.zzj = zzbfbVar;
        this.zzk = zzfgqVar;
        this.zzl = zzfclVar;
        this.zzm = zzcsrVar;
        this.zzn = zzdreVar;
    }

    public static /* synthetic */ void zzc(zzcjl zzcjlVar, Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map mapZze = com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zze();
        if (mapZze.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not initialize rewarded ads.", th);
                return;
            }
        }
        if (zzcjlVar.zzc.zzd()) {
            HashMap map = new HashMap();
            Iterator it = mapZze.values().iterator();
            while (it.hasNext()) {
                for (zzbor zzborVar : ((zzbos) it.next()).zza) {
                    String str = zzborVar.zzb;
                    for (String str2 : zzborVar.zza) {
                        if (!map.containsKey(str2)) {
                            map.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((List) map.get(str2)).add(str);
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzeci zzeciVarZza = zzcjlVar.zzd.zza(str3, jSONObject);
                    if (zzeciVarZza != null) {
                        zzfcn zzfcnVar = (zzfcn) zzeciVarZza.zzb;
                        if (!zzfcnVar.zzC() && zzfcnVar.zzB()) {
                            zzfcnVar.zzj(zzcjlVar.zza, (zzedx) zzeciVarZza.zzc, (List) entry.getValue());
                            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zze("Initialized rewarded video mediation adapter " + str3);
                        }
                    }
                } catch (zzfbw e) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to initialize rewarded video mediation adapter \"" + str3 + "\"", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final synchronized float zze() {
        return com.google.android.gms.ads.internal.zzv.zzs().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final String zzf() {
        return this.zzb.afmaVersion;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final List zzg() throws RemoteException {
        return this.zzf.zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzh(String str) {
        this.zze.zzg(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzi() {
        this.zzf.zzq();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzj(boolean z) throws RemoteException {
        try {
            Context context = this.zza;
            zzfqk.zza(context).zzc(z);
            if (z) {
                return;
            }
            try {
                if (context.getSharedPreferences("query_info_shared_prefs", 0).edit().clear().commit()) {
                    return;
                } else {
                    throw new IOException("Failed to remove query_info_shared_prefs");
                }
            } catch (IOException e) {
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "clearStorageOnGpidPubDisable_scar");
                return;
            }
            throw new RemoteException(e.getMessage());
        } catch (IOException e2) {
            throw new RemoteException(e2.getMessage());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final synchronized void zzk() {
        if (this.zzo) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Mobile ads is initialized already.");
            return;
        }
        Context context = this.zza;
        zzbci.zza(context);
        com.google.android.gms.ads.internal.zzv.zzp().zzu(context, this.zzb);
        this.zzm.zzd();
        com.google.android.gms.ads.internal.zzv.zzc().zzi(context);
        this.zzo = true;
        this.zzf.zzr();
        this.zze.zzf();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzek)).booleanValue()) {
            this.zzh.zzf();
        }
        this.zzi.zzg();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzjn)).booleanValue()) {
            zzbzk.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjg
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzx();
                }
            });
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzla)).booleanValue()) {
            zzbzk.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjj
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj.zza(new zzbua());
                }
            });
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdi)).booleanValue()) {
            zzbzk.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjh
                @Override // java.lang.Runnable
                public final void run() {
                    zzfct.zzb(this.zza.zza, true);
                }
            });
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeN)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeO)).booleanValue()) {
                zzbzk.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcji
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcjl zzcjlVar = this.zza;
                        com.google.android.gms.ads.internal.zzv.zzf().zzd(zzcjlVar.zza, zzcjlVar.zzn);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzl(String str, IObjectWrapper iObjectWrapper) {
        String strZzq;
        Runnable runnable;
        Context context = this.zza;
        zzbci.zza(context);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzep)).booleanValue()) {
            try {
                com.google.android.gms.ads.internal.zzv.zzq();
                strZzq = com.google.android.gms.ads.internal.util.zzs.zzq(context);
            } catch (RemoteException | RuntimeException e) {
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "NonagonMobileAdsSettingManager_AppId");
                strZzq = "";
            }
        } else {
            strZzq = "";
        }
        boolean z = true;
        String str2 = true == TextUtils.isEmpty(strZzq) ? str : strZzq;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzei)).booleanValue();
        zzbbz zzbbzVar = zzbci.zzbe;
        boolean zBooleanValue2 = zBooleanValue | ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbbzVar)).booleanValue();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbbzVar)).booleanValue()) {
            final Runnable runnable2 = (Runnable) ObjectWrapper.unwrap(iObjectWrapper);
            runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjk
                @Override // java.lang.Runnable
                public final void run() {
                    zzgcd zzgcdVar = zzbzk.zzf;
                    final zzcjl zzcjlVar = this.zza;
                    final Runnable runnable3 = runnable2;
                    zzgcdVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjf
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcjl.zzc(zzcjlVar, runnable3);
                        }
                    });
                }
            };
        } else {
            runnable = null;
            z = zBooleanValue2;
        }
        Runnable runnable3 = runnable;
        if (z) {
            com.google.android.gms.ads.internal.zzv.zza().zzc(this.zza, this.zzb, str2, runnable3, this.zzk, this.zzn, this.zzp, this.zzi.zzq());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzm(com.google.android.gms.ads.internal.client.zzdk zzdkVar) throws RemoteException {
        this.zzi.zzh(zzdkVar, zzduc.API);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzn(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Context is null. Failed to open debug menu.");
        } else {
            com.google.android.gms.ads.internal.util.zzau zzauVar = new com.google.android.gms.ads.internal.util.zzau(context);
            zzauVar.zzn(str);
            zzauVar.zzo(this.zzb.afmaVersion);
            zzauVar.zzr();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzo(zzboy zzboyVar) throws RemoteException {
        this.zzl.zzf(zzboyVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final synchronized void zzp(boolean z) {
        com.google.android.gms.ads.internal.zzv.zzs().zzc(z);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final synchronized void zzq(float f) {
        com.google.android.gms.ads.internal.zzv.zzs().zzd(f);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final synchronized void zzr(String str) {
        Context context = this.zza;
        zzbci.zza(context);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzei)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zza().zzc(context, this.zzb, str, null, this.zzk, null, null, this.zzi.zzq());
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzs(zzblo zzbloVar) throws RemoteException {
        this.zzf.zzs(zzbloVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzt(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzjy)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zzp().zzz(str);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzu(com.google.android.gms.ads.internal.client.zzfr zzfrVar) throws RemoteException {
        this.zzg.zzn(this.zza, zzfrVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final synchronized boolean zzv() {
        return com.google.android.gms.ads.internal.zzv.zzs().zze();
    }

    final void zzx() {
        if (com.google.android.gms.ads.internal.zzv.zzp().zzi().zzM()) {
            String strZzi = com.google.android.gms.ads.internal.zzv.zzp().zzi().zzi();
            if (com.google.android.gms.ads.internal.zzv.zzt().zzj(this.zza, strZzi, this.zzb.afmaVersion)) {
                return;
            }
            com.google.android.gms.ads.internal.zzv.zzp().zzi().zzx(false);
            com.google.android.gms.ads.internal.zzv.zzp().zzi().zzw("");
        }
    }
}
