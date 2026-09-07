package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzelr implements zzesv {
    private final zzgcd zza;
    private final zzdou zzb;
    private final zzdti zzc;
    private final zzelt zzd;

    public zzelr(zzgcd zzgcdVar, zzdou zzdouVar, zzdti zzdtiVar, zzelt zzeltVar) {
        this.zza = zzgcdVar;
        this.zzb = zzdouVar;
        this.zzc = zzdtiVar;
        this.zzd = zzeltVar;
    }

    public static /* synthetic */ zzels zzc(zzelr zzelrVar) {
        List<String> listAsList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbD)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : listAsList) {
            try {
                zzfcn zzfcnVarZzc = zzelrVar.zzb.zzc(str, new JSONObject());
                zzfcnVarZzc.zzC();
                boolean zZzt = zzelrVar.zzc.zzt();
                Bundle bundle2 = new Bundle();
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlJ)).booleanValue() || zZzt) {
                    try {
                        zzbrm zzbrmVarZzf = zzfcnVarZzc.zzf();
                        if (zzbrmVarZzf != null) {
                            bundle2.putString("sdk_version", zzbrmVarZzf.toString());
                        }
                    } catch (zzfbw unused) {
                    }
                }
                try {
                    zzbrm zzbrmVarZze = zzfcnVarZzc.zze();
                    if (zzbrmVarZze != null) {
                        bundle2.putString("adapter_version", zzbrmVarZze.toString());
                    }
                } catch (zzfbw unused2) {
                }
                bundle.putBundle(str, bundle2);
            } catch (zzfbw unused3) {
            }
        }
        zzels zzelsVar = new zzels(bundle);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlJ)).booleanValue()) {
            zzelrVar.zzd.zzb(zzelsVar);
        }
        return zzelsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlJ)).booleanValue()) {
            zzelt zzeltVar = this.zzd;
            if (zzeltVar.zza() != null) {
                zzels zzelsVarZza = zzeltVar.zza();
                zzelsVarZza.getClass();
                return zzgbs.zzh(zzelsVarZza);
            }
        }
        if (!zzfun.zzd((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbD))) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlJ)).booleanValue() || (!this.zzd.zzd() && this.zzc.zzt())) {
                this.zzd.zzc(true);
                return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzelq
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzelr.zzc(this.zza);
                    }
                });
            }
        }
        return zzgbs.zzh(new zzels(new Bundle()));
    }
}
