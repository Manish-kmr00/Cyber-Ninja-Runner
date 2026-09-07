package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.internal.ads.zzfmk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeh {
    private final String zza;
    private final List zzb;
    private final Set zzc;
    private final Bundle zzd;
    private final String zze;
    private final String zzf;
    private final int zzg;
    private final Set zzh;
    private final Bundle zzi;
    private final Set zzj;
    private final boolean zzk;
    private final String zzl;
    private final int zzm;
    private long zzn = 0;

    public zzeh(zzeg zzegVar, zzfmk zzfmkVar) {
        this.zza = zzegVar.zzg;
        this.zzb = zzegVar.zzh;
        this.zzc = Collections.unmodifiableSet(zzegVar.zza);
        this.zzd = zzegVar.zzb;
        Collections.unmodifiableMap(zzegVar.zzc);
        this.zze = zzegVar.zzi;
        this.zzf = zzegVar.zzj;
        this.zzg = zzegVar.zzk;
        this.zzh = Collections.unmodifiableSet(zzegVar.zzd);
        this.zzi = zzegVar.zze;
        this.zzj = Collections.unmodifiableSet(zzegVar.zzf);
        this.zzk = zzegVar.zzl;
        this.zzl = zzegVar.zzm;
        this.zzm = zzegVar.zzn;
    }

    public final int zza() {
        return this.zzm;
    }

    public final int zzb() {
        return this.zzg;
    }

    public final long zzc() {
        return this.zzn;
    }

    public final Bundle zzd(Class cls) {
        Bundle bundle = this.zzd.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle zze() {
        return this.zzi;
    }

    public final Bundle zzf(Class cls) {
        return this.zzd.getBundle(cls.getName());
    }

    public final Bundle zzg() {
        return this.zzd;
    }

    public final String zzh() {
        return this.zzl;
    }

    public final String zzi() {
        return this.zza;
    }

    public final String zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzf;
    }

    public final List zzl() {
        return new ArrayList(this.zzb);
    }

    public final Set zzm() {
        return this.zzj;
    }

    public final Set zzn() {
        return this.zzc;
    }

    public final void zzo(long j) {
        this.zzn = j;
    }

    @Deprecated
    public final boolean zzp() {
        return this.zzk;
    }

    public final boolean zzq(Context context) {
        RequestConfiguration requestConfigurationZzc = zzet.zzf().zzc();
        zzbb.zzb();
        Set set = this.zzh;
        String strZzz = com.google.android.gms.ads.internal.util.client.zzf.zzz(context);
        return set.contains(strZzz) || requestConfigurationZzc.getTestDeviceIds().contains(strZzz);
    }
}
