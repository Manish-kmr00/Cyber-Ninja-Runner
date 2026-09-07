package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfbn {
    private com.google.android.gms.ads.internal.client.zzm zza;
    private com.google.android.gms.ads.internal.client.zzr zzb;
    private String zzc;
    private com.google.android.gms.ads.internal.client.zzfw zzd;
    private boolean zze;
    private ArrayList zzf;
    private ArrayList zzg;
    private zzbfi zzh;
    private com.google.android.gms.ads.internal.client.zzx zzi;
    private AdManagerAdViewOptions zzj;
    private PublisherAdViewOptions zzk;
    private com.google.android.gms.ads.internal.client.zzcl zzl;
    private zzblt zzn;
    private zzejr zzr;
    private Bundle zzt;
    private com.google.android.gms.ads.internal.client.zzcp zzu;
    private int zzm = 1;
    private final zzfba zzo = new zzfba();
    private boolean zzp = false;
    private boolean zzq = false;
    private boolean zzs = false;

    public final zzfbn zzA(Bundle bundle) {
        this.zzt = bundle;
        return this;
    }

    public final zzfbn zzB(boolean z) {
        this.zze = z;
        return this;
    }

    public final zzfbn zzC(int i) {
        this.zzm = i;
        return this;
    }

    public final zzfbn zzD(zzbfi zzbfiVar) {
        this.zzh = zzbfiVar;
        return this;
    }

    public final zzfbn zzE(ArrayList arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzfbn zzF(ArrayList arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzfbn zzG(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zzb();
            this.zzl = publisherAdViewOptions.zza();
        }
        return this;
    }

    public final zzfbn zzH(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.zza = zzmVar;
        return this;
    }

    public final zzfbn zzI(com.google.android.gms.ads.internal.client.zzfw zzfwVar) {
        this.zzd = zzfwVar;
        return this;
    }

    public final zzfbp zzJ() {
        Preconditions.checkNotNull(this.zzc, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzb, "ad size must not be null");
        Preconditions.checkNotNull(this.zza, "ad request must not be null");
        return new zzfbp(this, null);
    }

    public final String zzL() {
        return this.zzc;
    }

    public final boolean zzS() {
        return this.zzp;
    }

    public final boolean zzT() {
        return this.zzq;
    }

    public final zzfbn zzV(com.google.android.gms.ads.internal.client.zzcp zzcpVar) {
        this.zzu = zzcpVar;
        return this;
    }

    public final com.google.android.gms.ads.internal.client.zzm zzf() {
        return this.zza;
    }

    public final com.google.android.gms.ads.internal.client.zzr zzh() {
        return this.zzb;
    }

    public final zzfba zzp() {
        return this.zzo;
    }

    public final zzfbn zzq(zzfbp zzfbpVar) {
        this.zzo.zza(zzfbpVar.zzo.zza);
        this.zza = zzfbpVar.zzd;
        this.zzb = zzfbpVar.zze;
        this.zzu = zzfbpVar.zzt;
        this.zzc = zzfbpVar.zzf;
        this.zzd = zzfbpVar.zza;
        this.zzf = zzfbpVar.zzg;
        this.zzg = zzfbpVar.zzh;
        this.zzh = zzfbpVar.zzi;
        this.zzi = zzfbpVar.zzj;
        zzr(zzfbpVar.zzl);
        zzG(zzfbpVar.zzm);
        this.zzp = zzfbpVar.zzp;
        this.zzq = zzfbpVar.zzq;
        this.zzr = zzfbpVar.zzc;
        this.zzs = zzfbpVar.zzr;
        this.zzt = zzfbpVar.zzs;
        return this;
    }

    public final zzfbn zzr(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzfbn zzs(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzb = zzrVar;
        return this;
    }

    public final zzfbn zzt(String str) {
        this.zzc = str;
        return this;
    }

    public final zzfbn zzu(com.google.android.gms.ads.internal.client.zzx zzxVar) {
        this.zzi = zzxVar;
        return this;
    }

    public final zzfbn zzv(zzejr zzejrVar) {
        this.zzr = zzejrVar;
        return this;
    }

    public final zzfbn zzw(zzblt zzbltVar) {
        this.zzn = zzbltVar;
        this.zzd = new com.google.android.gms.ads.internal.client.zzfw(false, true, false);
        return this;
    }

    public final zzfbn zzx(boolean z) {
        this.zzp = z;
        return this;
    }

    public final zzfbn zzy(boolean z) {
        this.zzq = z;
        return this;
    }

    public final zzfbn zzz(boolean z) {
        this.zzs = true;
        return this;
    }
}
