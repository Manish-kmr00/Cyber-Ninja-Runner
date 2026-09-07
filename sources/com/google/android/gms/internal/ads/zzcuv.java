package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcuv extends com.google.android.gms.ads.internal.client.zzdw {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final List zze;
    private final long zzf;
    private final String zzg;
    private final zzeck zzh;
    private final Bundle zzi;
    private final double zzj;

    public zzcuv(zzfau zzfauVar, String str, zzeck zzeckVar, zzfax zzfaxVar, String str2) {
        String string = null;
        this.zzb = zzfauVar == null ? null : zzfauVar.zzab;
        this.zzc = str2;
        this.zzd = zzfaxVar == null ? null : zzfaxVar.zzb;
        if (("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) && zzfauVar != null) {
            try {
                string = zzfauVar.zzv.getString("class_name");
            } catch (JSONException unused) {
            }
        }
        this.zza = string != null ? string : str;
        this.zze = zzeckVar.zzc();
        this.zzh = zzeckVar;
        this.zzj = zzfauVar == null ? 0.0d : zzfauVar.zzaz;
        this.zzf = com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis() / 1000;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgL)).booleanValue() || zzfaxVar == null) {
            this.zzi = new Bundle();
        } else {
            this.zzi = zzfaxVar.zzk;
        }
        this.zzg = (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzjp)).booleanValue() || zzfaxVar == null || TextUtils.isEmpty(zzfaxVar.zzi)) ? "" : zzfaxVar.zzi;
    }

    public final double zzc() {
        return this.zzj;
    }

    public final long zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdx
    public final Bundle zze() {
        return this.zzi;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdx
    public final com.google.android.gms.ads.internal.client.zzv zzf() {
        zzeck zzeckVar = this.zzh;
        if (zzeckVar != null) {
            return zzeckVar.zza();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdx
    public final String zzg() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdx
    public final String zzh() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdx
    public final String zzi() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdx
    public final List zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzg;
    }

    public final String zzl() {
        return this.zzd;
    }
}
