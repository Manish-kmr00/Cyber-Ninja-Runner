package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbeb;
import com.google.android.gms.internal.ads.zzbyf;
import com.google.android.gms.internal.ads.zzbym;
import com.google.android.gms.internal.ads.zzfgc;
import com.google.android.gms.internal.ads.zzfgn;
import com.google.android.gms.internal.ads.zzgbo;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzaq implements zzgbo {
    final /* synthetic */ ListenableFuture zza;
    final /* synthetic */ zzbym zzb;
    final /* synthetic */ zzbyf zzc;
    final /* synthetic */ zzfgc zzd;
    final /* synthetic */ zzau zze;

    zzaq(zzau zzauVar, ListenableFuture listenableFuture, zzbym zzbymVar, zzbyf zzbyfVar, zzfgc zzfgcVar) {
        this.zza = listenableFuture;
        this.zzb = zzbymVar;
        this.zzc = zzbyfVar;
        this.zzd = zzfgcVar;
        this.zze = zzauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        String message = th.getMessage();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhM)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zzp().zzv(th, "SignalGeneratorImpl.generateSignals");
        } else {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "SignalGeneratorImpl.generateSignals");
        }
        zzfgn zzfgnVarZzs = zzau.zzs(this.zza, this.zzb);
        if (((Boolean) zzbeb.zze.zze()).booleanValue() && zzfgnVarZzs != null) {
            zzfgc zzfgcVar = this.zzd;
            zzfgcVar.zzh(th);
            zzfgcVar.zzg(false);
            zzfgnVarZzs.zza(zzfgcVar);
            zzfgnVarZzs.zzh();
        }
        zzbyf zzbyfVar = this.zzc;
        if (zzbyfVar == null) {
            return;
        }
        try {
            if (!"Unknown format is no longer supported.".equals(message)) {
                message = "Internal error. " + message;
            }
            zzbyfVar.zzb(message);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbk zzbkVar = (zzbk) obj;
        zzfgn zzfgnVarZzs = zzau.zzs(this.zza, this.zzb);
        this.zze.zzG.set(true);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhG)).booleanValue()) {
            try {
                zzbyf zzbyfVar = this.zzc;
                if (zzbyfVar != null) {
                    zzbyfVar.zzb("QueryInfo generation has been disabled.");
                }
            } catch (RemoteException e) {
                String strConcat = "QueryInfo generation has been disabled.".concat(e.toString());
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg(strConcat);
            }
            if (!((Boolean) zzbeb.zze.zze()).booleanValue() || zzfgnVarZzs == null) {
                return;
            }
            zzfgc zzfgcVar = this.zzd;
            zzfgcVar.zzc("QueryInfo generation has been disabled.");
            zzfgcVar.zzg(false);
            zzfgnVarZzs.zza(zzfgcVar);
            zzfgnVarZzs.zzh();
            return;
        }
        try {
            if (zzbkVar == null) {
                zzbyf zzbyfVar2 = this.zzc;
                if (zzbyfVar2 != null) {
                    zzbyfVar2.zzc(null, null, null);
                }
                zzfgc zzfgcVar2 = this.zzd;
                zzfgcVar2.zzg(true);
                if (!((Boolean) zzbeb.zze.zze()).booleanValue() || zzfgnVarZzs == null) {
                    return;
                }
                zzfgnVarZzs.zza(zzfgcVar2);
                zzfgnVarZzs.zzh();
                return;
            }
            try {
                if (TextUtils.isEmpty((!TextUtils.isEmpty(zzbkVar.zzc) ? new JSONObject(zzbkVar.zzc) : new JSONObject(zzbkVar.zzb)).optString("request_id", ""))) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("The request ID is empty in request JSON.");
                    zzbyf zzbyfVar3 = this.zzc;
                    if (zzbyfVar3 != null) {
                        zzbyfVar3.zzb("Internal error: request ID is empty in request JSON.");
                    }
                    zzfgc zzfgcVar3 = this.zzd;
                    zzfgcVar3.zzc("Request ID empty");
                    zzfgcVar3.zzg(false);
                    if (!((Boolean) zzbeb.zze.zze()).booleanValue() || zzfgnVarZzs == null) {
                        return;
                    }
                    zzfgnVarZzs.zza(zzfgcVar3);
                    zzfgnVarZzs.zzh();
                    return;
                }
                Bundle bundle = zzbkVar.zzf;
                zzau zzauVar = this.zze;
                if (zzauVar.zzu && bundle != null && bundle.getInt(zzauVar.zzw, -1) == -1) {
                    bundle.putInt(zzauVar.zzw, zzauVar.zzx.get());
                }
                if (zzauVar.zzt && bundle != null && TextUtils.isEmpty(bundle.getString(zzauVar.zzv))) {
                    if (TextUtils.isEmpty(zzauVar.zzz)) {
                        zzauVar.zzz = com.google.android.gms.ads.internal.zzv.zzq().zzc(zzauVar.zzg, zzauVar.zzy.afmaVersion);
                    }
                    bundle.putString(zzauVar.zzv, zzauVar.zzz);
                }
                zzbyf zzbyfVar4 = this.zzc;
                if (zzbyfVar4 != null) {
                    if (TextUtils.isEmpty(zzbkVar.zzc)) {
                        zzbyfVar4.zzc(zzbkVar.zza, zzbkVar.zzb, bundle);
                    } else {
                        zzbyfVar4.zzc(zzbkVar.zza, zzbkVar.zzc, bundle);
                    }
                }
                this.zzd.zzg(true);
                if (!((Boolean) zzbeb.zze.zze()).booleanValue() || zzfgnVarZzs == null) {
                    return;
                }
                zzfgnVarZzs.zza(this.zzd);
                zzfgnVarZzs.zzh();
            } catch (JSONException e2) {
                int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to create JSON object from the request string.");
                zzbyf zzbyfVar5 = this.zzc;
                if (zzbyfVar5 != null) {
                    zzbyfVar5.zzb("Internal error for request JSON: " + e2.toString());
                }
                zzfgc zzfgcVar4 = this.zzd;
                zzfgcVar4.zzh(e2);
                zzfgcVar4.zzg(false);
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e2, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (!((Boolean) zzbeb.zze.zze()).booleanValue() || zzfgnVarZzs == null) {
                    return;
                }
                zzfgnVarZzs.zza(zzfgcVar4);
                zzfgnVarZzs.zzh();
            }
        } catch (RemoteException e3) {
            zzfgc zzfgcVar5 = this.zzd;
            zzfgcVar5.zzh(e3);
            zzfgcVar5.zzg(false);
            int i4 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e3);
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e3, "SignalGeneratorImpl.generateSignals.onSuccess");
        } finally {
            if (((Boolean) zzbeb.zze.zze()).booleanValue() && zzfgnVarZzs != null) {
                zzfgnVarZzs.zza(this.zzd);
                zzfgnVarZzs.zzh();
            }
        }
    }
}
