package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfbp {
    public final com.google.android.gms.ads.internal.client.zzfw zza;
    public final zzblt zzb;
    public final zzejr zzc;
    public final com.google.android.gms.ads.internal.client.zzm zzd;
    public final com.google.android.gms.ads.internal.client.zzr zze;
    public final String zzf;
    public final ArrayList zzg;
    public final ArrayList zzh;
    public final zzbfi zzi;
    public final com.google.android.gms.ads.internal.client.zzx zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final com.google.android.gms.ads.internal.client.zzcl zzn;
    public final zzfbc zzo;
    public final boolean zzp;
    public final boolean zzq;
    public final boolean zzr;
    public final Bundle zzs;
    public final com.google.android.gms.ads.internal.client.zzcp zzt;

    /* synthetic */ zzfbp(zzfbn zzfbnVar, zzfbo zzfboVar) {
        this.zze = zzfbnVar.zzb;
        this.zzf = zzfbnVar.zzc;
        this.zzt = zzfbnVar.zzu;
        int i = zzfbnVar.zza.zza;
        long j = zzfbnVar.zza.zzb;
        Bundle bundle = zzfbnVar.zza.zzc;
        int i2 = zzfbnVar.zza.zzd;
        List list = zzfbnVar.zza.zze;
        boolean z = zzfbnVar.zza.zzf;
        int i3 = zzfbnVar.zza.zzg;
        boolean z2 = true;
        if (!zzfbnVar.zza.zzh && !zzfbnVar.zze) {
            z2 = false;
        }
        this.zzd = new com.google.android.gms.ads.internal.client.zzm(i, j, bundle, i2, list, z, i3, z2, zzfbnVar.zza.zzi, zzfbnVar.zza.zzj, zzfbnVar.zza.zzk, zzfbnVar.zza.zzl, zzfbnVar.zza.zzm, zzfbnVar.zza.zzn, zzfbnVar.zza.zzo, zzfbnVar.zza.zzp, zzfbnVar.zza.zzq, zzfbnVar.zza.zzr, zzfbnVar.zza.zzs, zzfbnVar.zza.zzt, zzfbnVar.zza.zzu, zzfbnVar.zza.zzv, com.google.android.gms.ads.internal.util.zzs.zza(zzfbnVar.zza.zzw), zzfbnVar.zza.zzx, zzfbnVar.zza.zzy, zzfbnVar.zza.zzz);
        this.zza = zzfbnVar.zzd != null ? zzfbnVar.zzd : zzfbnVar.zzh != null ? zzfbnVar.zzh.zzf : null;
        this.zzg = zzfbnVar.zzf;
        this.zzh = zzfbnVar.zzg;
        this.zzi = zzfbnVar.zzf == null ? null : zzfbnVar.zzh == null ? new zzbfi(new NativeAdOptions.Builder().build()) : zzfbnVar.zzh;
        this.zzj = zzfbnVar.zzi;
        this.zzk = zzfbnVar.zzm;
        this.zzl = zzfbnVar.zzj;
        this.zzm = zzfbnVar.zzk;
        this.zzn = zzfbnVar.zzl;
        this.zzb = zzfbnVar.zzn;
        this.zzo = new zzfbc(zzfbnVar.zzo, null);
        this.zzp = zzfbnVar.zzp;
        this.zzq = zzfbnVar.zzq;
        this.zzc = zzfbnVar.zzr;
        this.zzr = zzfbnVar.zzs;
        this.zzs = zzfbnVar.zzt;
    }

    public final boolean zza() {
        return this.zzf.matches((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdu));
    }
}
