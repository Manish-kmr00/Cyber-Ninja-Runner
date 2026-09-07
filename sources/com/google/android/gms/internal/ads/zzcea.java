package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcea extends zzcam {
    private final zzcbh zzc;
    private zzceb zzd;
    private Uri zze;
    private zzcal zzf;
    private boolean zzg;
    private int zzh;

    public zzcea(Context context, zzcbh zzcbhVar) {
        super(context);
        this.zzh = 1;
        this.zzg = false;
        this.zzc = zzcbhVar;
        zzcbhVar.zza(this);
    }

    public static /* synthetic */ void zzi(zzcea zzceaVar) {
        zzcal zzcalVar = zzceaVar.zzf;
        if (zzcalVar != null) {
            if (!zzceaVar.zzg) {
                zzcalVar.zzg();
                zzceaVar.zzg = true;
            }
            zzceaVar.zzf.zze();
        }
    }

    public static /* synthetic */ void zzk(zzcea zzceaVar) {
        zzcal zzcalVar = zzceaVar.zzf;
        if (zzcalVar != null) {
            zzcalVar.zzd();
        }
    }

    public static /* synthetic */ void zzl(zzcea zzceaVar) {
        zzcal zzcalVar = zzceaVar.zzf;
        if (zzcalVar != null) {
            zzcalVar.zzf();
        }
    }

    @EnsuresNonNullIf(expression = {"immersiveAdPlayer"}, result = true)
    private final boolean zzm() {
        int i = this.zzh;
        return (i == 1 || i == 2 || this.zzd == null) ? false : true;
    }

    private final void zzv(int i) {
        if (i == 4) {
            this.zzc.zzc();
            this.zzb.zzb();
        } else if (this.zzh == 4) {
            this.zzc.zze();
            this.zzb.zzc();
        }
        this.zzh = i;
    }

    @Override // com.google.android.gms.internal.ads.zzcam, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.h, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.google.android.gms.internal.ads.zzcam, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    public final String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final int zzb() {
        return zzm() ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final int zzc() {
        return zzm() ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final long zzf() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final long zzg() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final long zzh() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final String zzj() {
        return "ImmersivePlayer";
    }

    @Override // com.google.android.gms.internal.ads.zzcam, com.google.android.gms.internal.ads.zzcbj
    public final void zzn() {
        if (this.zzd != null) {
            this.zzb.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzo() {
        com.google.android.gms.ads.internal.util.zze.zza("AdImmersivePlayerView pause");
        if (zzm() && this.zzd.zzd()) {
            this.zzd.zza();
            zzv(5);
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdz
                @Override // java.lang.Runnable
                public final void run() {
                    zzcea.zzk(this.zza);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzp() {
        com.google.android.gms.ads.internal.util.zze.zza("AdImmersivePlayerView play");
        if (zzm()) {
            this.zzd.zzb();
            zzv(4);
            this.zza.zzb();
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdy
                @Override // java.lang.Runnable
                public final void run() {
                    zzcea.zzi(this.zza);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzq(int i) {
        com.google.android.gms.ads.internal.util.zze.zza("AdImmersivePlayerView seek " + i);
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzr(zzcal zzcalVar) {
        this.zzf = zzcalVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzs(String str) {
        if (str != null) {
            this.zze = Uri.parse(str);
            this.zzd = new zzceb(this.zze.toString());
            zzv(3);
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdx
                @Override // java.lang.Runnable
                public final void run() {
                    zzcea.zzl(this.zza);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzt() {
        com.google.android.gms.ads.internal.util.zze.zza("AdImmersivePlayerView stop");
        zzceb zzcebVar = this.zzd;
        if (zzcebVar != null) {
            zzcebVar.zzc();
            this.zzd = null;
            zzv(1);
        }
        this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzu(float f, float f2) {
    }
}
