package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaxl extends zzaxo {
    private final View zzh;

    public zzaxl(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2, View view) {
        super(zzawbVar, "AjBekD8OAvnbcm+fCHiCamPJ8yOatZla9r0vCGcxk0kvLONYAtrizxoNBJMj4UJd", "1LVA+oN7RWnXoeYH8xRoaxx/0X5kk95KVCfYyybQlO4=", zzarzVar, i, 57);
        this.zzh = view;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        View view = this.zzh;
        if (view != null) {
            Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdF);
            Boolean bool2 = (Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlb);
            zzawf zzawfVar = new zzawf((String) this.zze.invoke(null, view, this.zza.zzb().getResources().getDisplayMetrics(), bool, bool2));
            zzass zzassVarZza = zzast.zza();
            zzassVarZza.zzb(zzawfVar.zza.longValue());
            zzassVarZza.zzd(zzawfVar.zzb.longValue());
            zzassVarZza.zze(zzawfVar.zzc.longValue());
            if (bool2.booleanValue()) {
                zzassVarZza.zzc(zzawfVar.zze.longValue());
            }
            if (bool.booleanValue()) {
                zzassVarZza.zza(zzawfVar.zzd.longValue());
            }
            this.zzd.zzW((zzast) zzassVarZza.zzbr());
        }
    }
}
