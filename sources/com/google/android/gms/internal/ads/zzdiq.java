package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes14.dex */
public final class zzdiq {
    static final ImageView.ScaleType zza = ImageView.ScaleType.CENTER_INSIDE;
    private final com.google.android.gms.ads.internal.util.zzg zzb;
    private final zzfbp zzc;
    private final zzdhv zzd;
    private final zzdhq zze;
    private final zzdje zzf;
    private final zzdjm zzg;
    private final Executor zzh;
    private final Executor zzi;
    private final zzbfi zzj;
    private final zzdhn zzk;

    public zzdiq(com.google.android.gms.ads.internal.util.zzg zzgVar, zzfbp zzfbpVar, zzdhv zzdhvVar, zzdhq zzdhqVar, zzdje zzdjeVar, zzdjm zzdjmVar, Executor executor, Executor executor2, zzdhn zzdhnVar) {
        this.zzb = zzgVar;
        this.zzc = zzfbpVar;
        this.zzj = zzfbpVar.zzi;
        this.zzd = zzdhvVar;
        this.zze = zzdhqVar;
        this.zzf = zzdjeVar;
        this.zzg = zzdjmVar;
        this.zzh = executor;
        this.zzi = executor2;
        this.zzk = zzdhnVar;
    }

    public static /* synthetic */ void zza(zzdiq zzdiqVar, ViewGroup viewGroup) {
        zzdhq zzdhqVar = zzdiqVar.zze;
        if (zzdhqVar.zzf() != null) {
            boolean z = viewGroup != null;
            if (zzdhqVar.zzc() == 2 || zzdhqVar.zzc() == 1) {
                zzdiqVar.zzb.zzF(zzdiqVar.zzc.zzf, String.valueOf(zzdhqVar.zzc()), z);
            } else if (zzdhqVar.zzc() == 6) {
                com.google.android.gms.ads.internal.util.zzg zzgVar = zzdiqVar.zzb;
                String str = zzdiqVar.zzc.zzf;
                zzgVar.zzF(str, "2", z);
                zzgVar.zzF(str, "1", z);
            }
        }
    }

    public static /* synthetic */ void zzb(final zzdiq zzdiqVar, zzdjo zzdjoVar) {
        ViewGroup viewGroup;
        View viewZze;
        final ViewGroup viewGroup2;
        zzbfq zzbfqVarZza;
        Drawable drawable;
        zzdhv zzdhvVar = zzdiqVar.zzd;
        if (!zzdhvVar.zzf() && !zzdhvVar.zze()) {
            viewGroup = null;
            break;
        }
        String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, "3011"};
        int i = 0;
        while (true) {
            if (i < 2) {
                View viewZzg = zzdjoVar.zzg(strArr[i]);
                if (viewZzg != null && (viewZzg instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) viewZzg;
                    break;
                }
                i++;
            } else {
                viewGroup = null;
                break;
            }
        }
        Context context = zzdjoVar.zzf().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        zzdhq zzdhqVar = zzdiqVar.zze;
        if (zzdhqVar.zze() != null) {
            viewZze = zzdhqVar.zze();
            zzbfi zzbfiVar = zzdiqVar.zzj;
            if (zzbfiVar != null && viewGroup == null) {
                zzh(layoutParams, zzbfiVar.zze);
                viewZze.setLayoutParams(layoutParams);
                viewGroup = null;
            }
        } else if (zzdhqVar.zzl() instanceof zzbfd) {
            zzbfd zzbfdVar = (zzbfd) zzdhqVar.zzl();
            if (viewGroup == null) {
                zzh(layoutParams, zzbfdVar.zzc());
                viewGroup = null;
            }
            View zzbfeVar = new zzbfe(context, zzbfdVar, layoutParams);
            zzbfeVar.setContentDescription((CharSequence) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzea));
            viewZze = zzbfeVar;
        } else {
            viewZze = null;
        }
        if (viewZze != null) {
            if (viewZze.getParent() instanceof ViewGroup) {
                ((ViewGroup) viewZze.getParent()).removeView(viewZze);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(viewZze);
            } else {
                com.google.android.gms.ads.formats.zza zzaVar = new com.google.android.gms.ads.formats.zza(zzdjoVar.zzf().getContext());
                zzaVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                zzaVar.addView(viewZze);
                FrameLayout frameLayoutZzh = zzdjoVar.zzh();
                if (frameLayoutZzh != null) {
                    frameLayoutZzh.addView(zzaVar);
                }
            }
            zzdjoVar.zzq(zzdjoVar.zzk(), viewZze, true);
        }
        zzfww zzfwwVar = zzdim.zza;
        int size = zzfwwVar.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                viewGroup2 = null;
                break;
            }
            View viewZzg2 = zzdjoVar.zzg((String) zzfwwVar.get(i2));
            i2++;
            if (viewZzg2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) viewZzg2;
                break;
            }
        }
        zzdiqVar.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdin
            @Override // java.lang.Runnable
            public final void run() {
                zzdiq.zza(this.zza, viewGroup2);
            }
        });
        if (viewGroup2 == null) {
            return;
        }
        if (zzdiqVar.zzi(viewGroup2, true)) {
            if (zzdhqVar.zzs() != null) {
                zzdhqVar.zzs().zzar(new zzdip(zzdjoVar, viewGroup2));
                return;
            }
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzke)).booleanValue() && zzdiqVar.zzi(viewGroup2, false)) {
            if (zzdhqVar.zzq() != null) {
                zzdhqVar.zzq().zzar(new zzdip(zzdjoVar, viewGroup2));
                return;
            }
            return;
        }
        viewGroup2.removeAllViews();
        View viewZzf = zzdjoVar.zzf();
        Context context2 = viewZzf != null ? viewZzf.getContext() : null;
        if (context2 == null || (zzbfqVarZza = zzdiqVar.zzk.zza()) == null) {
            return;
        }
        try {
            IObjectWrapper iObjectWrapperZzi = zzbfqVarZza.zzi();
            if (iObjectWrapperZzi == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzi)) == null) {
                return;
            }
            ImageView imageView = new ImageView(context2);
            imageView.setImageDrawable(drawable);
            IObjectWrapper iObjectWrapperZzj = zzdjoVar.zzj();
            if (iObjectWrapperZzj == null || !((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgh)).booleanValue()) {
                imageView.setScaleType(zza);
            } else {
                imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(iObjectWrapperZzj));
            }
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            viewGroup2.addView(imageView);
        } catch (RemoteException unused) {
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not get main image drawable");
        }
    }

    private final boolean zzi(ViewGroup viewGroup, boolean z) {
        View viewZzf = z ? this.zze.zzf() : this.zze.zzg();
        if (viewZzf == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (viewZzf.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewZzf.getParent()).removeView(viewZzf);
        }
        viewGroup.addView(viewZzf, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzec)).booleanValue() ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-2, -2, 17));
        return true;
    }

    public final void zzc(zzdjo zzdjoVar) {
        zzdje zzdjeVar;
        if (zzdjoVar == null || (zzdjeVar = this.zzf) == null || zzdjoVar.zzh() == null || !this.zzd.zzg()) {
            return;
        }
        try {
            zzdjoVar.zzh().addView(zzdjeVar.zza());
        } catch (zzcex e) {
            com.google.android.gms.ads.internal.util.zze.zzb("web view can not be obtained", e);
        }
    }

    public final void zzd(zzdjo zzdjoVar) {
        if (zzdjoVar == null) {
            return;
        }
        Context context = zzdjoVar.zzf().getContext();
        if (com.google.android.gms.ads.internal.util.zzbv.zzh(context, this.zzd.zza)) {
            if (!(context instanceof Activity)) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Activity context is needed for policy validator.");
                return;
            }
            zzdjm zzdjmVar = this.zzg;
            if (zzdjmVar == null || zzdjoVar.zzh() == null) {
                return;
            }
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                windowManager.addView(zzdjmVar.zza(zzdjoVar.zzh(), windowManager), com.google.android.gms.ads.internal.util.zzbv.zzb());
            } catch (zzcex e) {
                com.google.android.gms.ads.internal.util.zze.zzb("web view can not be obtained", e);
            }
        }
    }

    public final void zze(final zzdjo zzdjoVar) {
        this.zzh.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdio
            @Override // java.lang.Runnable
            public final void run() {
                zzdiq.zzb(this.zza, zzdjoVar);
            }
        });
    }

    public final boolean zzf(ViewGroup viewGroup) {
        return zzi(viewGroup, false);
    }

    public final boolean zzg(ViewGroup viewGroup) {
        return zzi(viewGroup, true);
    }

    private static void zzh(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }
}
