package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public class zzegn extends zzeho {
    private final zzddl zza;

    public zzegn(zzcva zzcvaVar, zzdda zzddaVar, zzcvu zzcvuVar, zzcwj zzcwjVar, zzcwo zzcwoVar, zzcvp zzcvpVar, zzczz zzczzVar, zzddx zzddxVar, zzcxi zzcxiVar, zzddl zzddlVar, zzczv zzczvVar) {
        super(zzcvaVar, zzddaVar, zzcvuVar, zzcwjVar, zzcwoVar, zzczzVar, zzcxiVar, zzddxVar, zzczvVar, zzcvpVar);
        this.zza = zzddlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeho, com.google.android.gms.internal.ads.zzbpe
    public final void zzs(zzbvw zzbvwVar) {
        this.zza.zza(zzbvwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeho, com.google.android.gms.internal.ads.zzbpe
    public final void zzt(zzbwa zzbwaVar) throws RemoteException {
        this.zza.zza(new zzbvw(zzbwaVar.zzf(), zzbwaVar.zze()));
    }

    @Override // com.google.android.gms.internal.ads.zzeho, com.google.android.gms.internal.ads.zzbpe
    public final void zzu() throws RemoteException {
        this.zza.zza(null);
    }

    @Override // com.google.android.gms.internal.ads.zzeho, com.google.android.gms.internal.ads.zzbpe
    public final void zzv() throws RemoteException {
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzeho, com.google.android.gms.internal.ads.zzbpe
    public final void zzw() {
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzeho, com.google.android.gms.internal.ads.zzbpe
    public final void zzz() {
        this.zza.zzc();
    }
}
