package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcav {
    private final Context zza;
    private final zzcbg zzb;
    private final ViewGroup zzc;
    private final zzdre zzd;
    private zzcau zze;

    public zzcav(Context context, ViewGroup viewGroup, zzcel zzcelVar, zzdre zzdreVar) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzcelVar;
        this.zze = null;
        this.zzd = zzdreVar;
    }

    public final zzcau zza() {
        return this.zze;
    }

    public final Integer zzb() {
        zzcau zzcauVar = this.zze;
        if (zzcauVar != null) {
            return zzcauVar.zzl();
        }
        return null;
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzcau zzcauVar = this.zze;
        if (zzcauVar != null) {
            zzcauVar.zzF(i, i2, i3, i4);
        }
    }

    public final void zzd(int i, int i2, int i3, int i4, int i5, boolean z, zzcbf zzcbfVar) {
        if (this.zze != null) {
            return;
        }
        zzcbg zzcbgVar = this.zzb;
        zzbcp.zza(zzcbgVar.zzl().zza(), zzcbgVar.zzk(), "vpr2");
        zzcau zzcauVar = new zzcau(this.zza, zzcbgVar, i5, z, zzcbgVar.zzl().zza(), zzcbfVar, this.zzd);
        this.zze = zzcauVar;
        this.zzc.addView(zzcauVar, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zze.zzF(i, i2, i3, i4);
        zzcbgVar.zzz(false);
    }

    public final void zze() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzcau zzcauVar = this.zze;
        if (zzcauVar != null) {
            zzcauVar.zzq();
            this.zzc.removeView(this.zze);
            this.zze = null;
        }
    }

    public final void zzf() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzcau zzcauVar = this.zze;
        if (zzcauVar != null) {
            zzcauVar.zzu();
        }
    }

    public final void zzg(int i) {
        zzcau zzcauVar = this.zze;
        if (zzcauVar != null) {
            zzcauVar.zzC(i);
        }
    }
}
