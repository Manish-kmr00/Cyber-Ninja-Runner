package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes14.dex */
public final class zzdjm {
    private final zzdoe zza;
    private final zzdmt zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdjm(zzdoe zzdoeVar, zzdmt zzdmtVar) {
        this.zza = zzdoeVar;
        this.zzb = zzdmtVar;
    }

    public static /* synthetic */ void zzb(zzdjm zzdjmVar, WindowManager windowManager, View view, zzcel zzcelVar, Map map) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Hide native ad policy validator overlay.");
        zzcelVar.zzF().setVisibility(8);
        if (zzcelVar.zzF().getWindowToken() != null) {
            windowManager.removeView(zzcelVar.zzF());
        }
        zzcelVar.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (zzdjmVar.zzc == null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(zzdjmVar.zzc);
    }

    public static /* synthetic */ void zzc(final zzdjm zzdjmVar, final View view, final WindowManager windowManager, final zzcel zzcelVar, final Map map) {
        zzcelVar.zzN().zzC(new zzcgb() { // from class: com.google.android.gms.internal.ads.zzdjk
            @Override // com.google.android.gms.internal.ads.zzcgb
            public final void zza(boolean z, int i, String str, String str2) {
                zzdjm.zzd(this.zza, map, z, i, str, str2);
            }
        });
        if (map == null) {
            return;
        }
        Context context = view.getContext();
        int iZzf = zzf(context, (String) map.get("validator_width"), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzig)).intValue());
        int iZzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzih)).intValue());
        int iZzf3 = zzf(context, (String) map.get("validator_x"), 0);
        int iZzf4 = zzf(context, (String) map.get("validator_y"), 0);
        zzcelVar.zzaj(zzcgf.zzb(iZzf, iZzf2));
        try {
            zzcelVar.zzG().getSettings().setUseWideViewPort(((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzii)).booleanValue());
            zzcelVar.zzG().getSettings().setLoadWithOverviewMode(((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzij)).booleanValue());
        } catch (NullPointerException unused) {
        }
        final WindowManager.LayoutParams layoutParamsZzb = com.google.android.gms.ads.internal.util.zzbv.zzb();
        layoutParamsZzb.x = iZzf3;
        layoutParamsZzb.y = iZzf4;
        windowManager.updateViewLayout(zzcelVar.zzF(), layoutParamsZzb);
        final String str = (String) map.get("orientation");
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            final int i = (("1".equals(str) || "2".equals(str)) ? rect.bottom : rect.top) - iZzf4;
            zzdjmVar.zzc = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.gms.internal.ads.zzdjl
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    Rect rect2 = new Rect();
                    if (view.getGlobalVisibleRect(rect2)) {
                        zzcel zzcelVar2 = zzcelVar;
                        if (zzcelVar2.zzF().getWindowToken() == null) {
                            return;
                        }
                        int i2 = i;
                        WindowManager.LayoutParams layoutParams = layoutParamsZzb;
                        String str2 = str;
                        if ("1".equals(str2) || "2".equals(str2)) {
                            layoutParams.y = rect2.bottom - i2;
                        } else {
                            layoutParams.y = rect2.top - i2;
                        }
                        windowManager.updateViewLayout(zzcelVar2.zzF(), layoutParams);
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnScrollChangedListener(zzdjmVar.zzc);
            }
        }
        String str2 = (String) map.get("overlay_url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        zzcelVar.loadUrl(str2);
    }

    public static /* synthetic */ void zzd(zzdjm zzdjmVar, Map map, boolean z, int i, String str, String str2) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "validatorHtmlLoaded");
        map2.put("id", (String) map.get("id"));
        zzdjmVar.zzb.zzj("sendMessageToNativeJs", map2);
    }

    private static final int zzf(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        return com.google.android.gms.ads.internal.util.client.zzf.zzy(context, i);
    }

    public final View zza(final View view, final WindowManager windowManager) throws zzcex {
        zzcel zzcelVarZza = this.zza.zza(com.google.android.gms.ads.internal.client.zzr.zzc(), null, null);
        zzcelVarZza.zzF().setVisibility(4);
        zzcelVarZza.zzF().setContentDescription("policy_validator");
        zzcelVarZza.zzag("/sendMessageToSdk", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdjg
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                this.zza.zzb.zzj("sendMessageToNativeJs", map);
            }
        });
        zzcelVarZza.zzag("/hideValidatorOverlay", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdjh
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                zzdjm.zzb(this.zza, windowManager, view, (zzcel) obj, map);
            }
        });
        zzcelVarZza.zzag("/open", new zzbjv(null, null, null, null, null));
        WeakReference weakReference = new WeakReference(zzcelVarZza);
        zzbjj zzbjjVar = new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdji
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                zzdjm.zzc(this.zza, view, windowManager, (zzcel) obj, map);
            }
        };
        zzdmt zzdmtVar = this.zzb;
        zzdmtVar.zzm(weakReference, "/loadNativeAdPolicyViolations", zzbjjVar);
        zzdmtVar.zzm(new WeakReference(zzcelVarZza), "/showValidatorOverlay", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdjj
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Show native ad policy validator overlay.");
                ((zzcel) obj).zzF().setVisibility(0);
            }
        });
        return zzcelVarZza.zzF();
    }
}
