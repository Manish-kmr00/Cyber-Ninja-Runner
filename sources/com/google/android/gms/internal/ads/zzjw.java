package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzjw implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, zzabs, zzpy, zzxg, zztw, zzhr {
    public static final /* synthetic */ int zzb = 0;
    final /* synthetic */ zzka zza;

    /* synthetic */ zzjw(zzka zzkaVar, zzjz zzjzVar) {
        this.zza = zzkaVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzka zzkaVar = this.zza;
        zzka.zzO(zzkaVar, surfaceTexture);
        zzkaVar.zzab(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzka zzkaVar = this.zza;
        zzkaVar.zzad(null);
        zzkaVar.zzab(0, 0);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zza.zzab(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.zza.zzab(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.zza.zzab(0, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zza(Exception exc) {
        this.zza.zzr.zzw(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zzb(String str, long j, long j2) {
        this.zza.zzr.zzx(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zzc(String str) {
        this.zza.zzr.zzy(str);
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zzd(zzhy zzhyVar) {
        this.zza.zzr.zzz(zzhyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zze(zzhy zzhyVar) {
        this.zza.zzr.zzA(zzhyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zzf(zzz zzzVar, zzhz zzhzVar) {
        this.zza.zzr.zzB(zzzVar, zzhzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zzg(long j) {
        this.zza.zzr.zzC(j);
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zzh(Exception exc) {
        this.zza.zzr.zzD(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zzi(zzpz zzpzVar) {
        this.zza.zzr.zzE(zzpzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zzj(zzpz zzpzVar) {
        this.zza.zzr.zzF(zzpzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zzk(int i, long j, long j2) {
        this.zza.zzr.zzG(i, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzl(int i, long j) {
        this.zza.zzr.zzH(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzm(Object obj, long j) {
        zzka zzkaVar = this.zza;
        zzkaVar.zzr.zzI(obj, j);
        if (zzkaVar.zzI == obj) {
            zzdw zzdwVar = zzkaVar.zzm;
            zzdwVar.zzd(26, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjv
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj2) {
                }
            });
            zzdwVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zzn(final boolean z) {
        zzka zzkaVar = this.zza;
        if (zzkaVar.zzO == z) {
            return;
        }
        zzkaVar.zzO = z;
        zzdw zzdwVar = zzkaVar.zzm;
        zzdwVar.zzd(23, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjt
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                int i = zzjw.zzb;
                ((zzbe) obj).zzo(z);
            }
        });
        zzdwVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzo(Exception exc) {
        this.zza.zzr.zzK(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzp(String str, long j, long j2) {
        this.zza.zzr.zzL(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzq(String str) {
        this.zza.zzr.zzM(str);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzr(zzhy zzhyVar) {
        this.zza.zzr.zzN(zzhyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzs(zzhy zzhyVar) {
        this.zza.zzr.zzO(zzhyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzt(long j, int i) {
        this.zza.zzr.zzP(j, i);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzu(zzz zzzVar, zzhz zzhzVar) {
        this.zza.zzr.zzQ(zzzVar, zzhzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzv(final zzcd zzcdVar) {
        zzdw zzdwVar = this.zza.zzm;
        zzdwVar.zzd(25, new zzdt() { // from class: com.google.android.gms.internal.ads.zzju
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                int i = zzjw.zzb;
                ((zzbe) obj).zzs(zzcdVar);
            }
        });
        zzdwVar.zzc();
    }
}
