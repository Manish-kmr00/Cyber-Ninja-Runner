package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdwz extends zzbup {
    final /* synthetic */ zzdxb zza;

    protected zzdwz(zzdxb zzdxbVar) {
        this.zza = zzdxbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuq
    public final void zze(com.google.android.gms.ads.internal.util.zzbb zzbbVar) {
        this.zza.zza.zzd(zzbbVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbuq
    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        zzdxb zzdxbVar = this.zza;
        zzdxbVar.zza.zzc(new zzdxr(autoCloseInputStream, zzdxbVar.zze));
    }

    @Override // com.google.android.gms.internal.ads.zzbuq
    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbuy zzbuyVar) {
        this.zza.zza.zzc(new zzdxr(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), zzbuyVar));
    }
}
