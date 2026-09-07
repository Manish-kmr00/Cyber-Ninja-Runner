package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzdou {
    private final zzfcl zza;
    private final zzdor zzb;

    zzdou(zzfcl zzfclVar, zzdor zzdorVar) {
        this.zza = zzfclVar;
        this.zzb = zzdorVar;
    }

    final zzboy zza() throws RemoteException {
        zzboy zzboyVarZzb = this.zza.zzb();
        if (zzboyVarZzb != null) {
            return zzboyVarZzb;
        }
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    public final zzbqx zzb(String str) throws RemoteException {
        zzbqx zzbqxVarZzc = zza().zzc(str);
        this.zzb.zzd(str, zzbqxVarZzc);
        return zzbqxVarZzc;
    }

    public final zzfcn zzc(String str, JSONObject jSONObject) throws zzfbw {
        zzbpb zzbpbVarZzb;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zzbpbVarZzb = new zzbpz(new AdMobAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zzbpbVarZzb = new zzbpz(new zzbrq());
            } else {
                zzboy zzboyVarZza = zza();
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                    try {
                        String string = jSONObject.getString("class_name");
                        if (zzboyVarZza.zze(string)) {
                            zzbpbVarZzb = zzboyVarZza.zzb("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
                        } else {
                            zzbpbVarZzb = zzboyVarZza.zzd(string) ? zzboyVarZza.zzb(string) : zzboyVarZza.zzb("com.google.ads.mediation.customevent.CustomEventAdapter");
                        }
                    } catch (JSONException e) {
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Invalid custom event.", e);
                        zzbpbVarZzb = zzboyVarZza.zzb(str);
                    }
                } else {
                    zzbpbVarZzb = zzboyVarZza.zzb(str);
                }
            }
            zzfcn zzfcnVar = new zzfcn(zzbpbVarZzb);
            this.zzb.zzc(str, zzfcnVar);
            return zzfcnVar;
        } catch (Throwable th) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzjv)).booleanValue()) {
                this.zzb.zzc(str, null);
            }
            throw new zzfbw(th);
        }
    }

    public final boolean zzd() {
        return this.zza.zzb() != null;
    }
}
