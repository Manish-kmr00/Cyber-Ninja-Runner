package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeiv extends com.google.android.gms.ads.internal.client.zzbp {
    private final zzekc zza;

    public zzeiv(Context context, zzcgl zzcglVar, zzfbn zzfbnVar, zzdib zzdibVar, com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        zzeke zzekeVar = new zzeke(zzdibVar, zzcglVar.zzi());
        zzekeVar.zze(zzbkVar);
        this.zza = new zzekc(new zzeko(zzcglVar, context, zzekeVar, zzfbnVar), zzfbnVar.zzL());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized String zze() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized String zzf() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzg(com.google.android.gms.ads.internal.client.zzm zzmVar) throws RemoteException {
        this.zza.zzd(zzmVar, 1);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized void zzh(com.google.android.gms.ads.internal.client.zzm zzmVar, int i) throws RemoteException {
        this.zza.zzd(zzmVar, i);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized boolean zzi() throws RemoteException {
        return this.zza.zze();
    }
}
