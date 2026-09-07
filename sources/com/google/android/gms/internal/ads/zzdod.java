package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdod {
    private final zzcva zza;
    private final zzdda zzb;
    private final zzcwj zzc;
    private final zzcww zzd;
    private final zzcxi zze;
    private final zzczz zzf;
    private final Executor zzg;
    private final zzdcw zzh;
    private final zzcmu zzi;
    private final com.google.android.gms.ads.internal.zzb zzj;
    private final zzbxi zzk;
    private final zzauy zzl;
    private final zzczq zzm;
    private final zzeat zzn;
    private final zzfio zzo;
    private final zzdre zzp;
    private final zzclx zzq;
    private final zzdoj zzr;

    public zzdod(zzcva zzcvaVar, zzcwj zzcwjVar, zzcww zzcwwVar, zzcxi zzcxiVar, zzczz zzczzVar, Executor executor, zzdcw zzdcwVar, zzcmu zzcmuVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbxi zzbxiVar, zzauy zzauyVar, zzczq zzczqVar, zzeat zzeatVar, zzfio zzfioVar, zzdre zzdreVar, zzdda zzddaVar, zzclx zzclxVar, zzdoj zzdojVar) {
        this.zza = zzcvaVar;
        this.zzc = zzcwjVar;
        this.zzd = zzcwwVar;
        this.zze = zzcxiVar;
        this.zzf = zzczzVar;
        this.zzg = executor;
        this.zzh = zzdcwVar;
        this.zzi = zzcmuVar;
        this.zzj = zzbVar;
        this.zzk = zzbxiVar;
        this.zzl = zzauyVar;
        this.zzm = zzczqVar;
        this.zzn = zzeatVar;
        this.zzo = zzfioVar;
        this.zzp = zzdreVar;
        this.zzb = zzddaVar;
        this.zzq = zzclxVar;
        this.zzr = zzdojVar;
    }

    public static /* synthetic */ boolean zzh(zzdod zzdodVar, View view, MotionEvent motionEvent) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkf)).booleanValue() && motionEvent != null && motionEvent.getAction() == 0) {
            zzdodVar.zzr.zzb(motionEvent);
        }
        zzdodVar.zzj.zza();
        if (view == null) {
            return false;
        }
        view.performClick();
        return false;
    }

    public static final ListenableFuture zzj(zzcel zzcelVar, String str, String str2, final Bundle bundle) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcs)).booleanValue()) {
            bundle.putLong(zzdqm.RENDERING_WEBVIEW_LOAD_HTML_START.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        final zzbzp zzbzpVar = new zzbzp();
        zzcelVar.zzN().zzC(new zzcgb() { // from class: com.google.android.gms.internal.ads.zzdnu
            @Override // com.google.android.gms.internal.ads.zzcgb
            public final void zza(boolean z, int i, String str3, String str4) {
                zzbzp zzbzpVar2 = zzbzpVar;
                if (z) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcs)).booleanValue()) {
                        bundle.putLong(zzdqm.RENDERING_WEBVIEW_LOAD_HTML_END.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
                    }
                    zzbzpVar2.zzc(null);
                    return;
                }
                zzbzpVar2.zzd(new Exception("Ad Web View failed to load. Error code: " + i + ", Description: " + str3 + ", Failing URL: " + str4));
            }
        });
        zzcelVar.zzae(str, str2, null);
        return zzbzpVar;
    }

    public final void zzi(final zzcel zzcelVar, boolean z, zzbjm zzbjmVar, Bundle bundle) {
        zzaut zzautVarZzc;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcs)).booleanValue()) {
            bundle.putLong(zzdqm.RENDERING_CONFIGURE_WEBVIEW_START.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        zzcelVar.zzN().zzV(new com.google.android.gms.ads.internal.client.zza() { // from class: com.google.android.gms.internal.ads.zzdnv
            @Override // com.google.android.gms.ads.internal.client.zza
            public final void onAdClicked() {
                this.zza.zza.onAdClicked();
            }
        }, this.zzd, this.zze, new zzbib() { // from class: com.google.android.gms.internal.ads.zzdnw
            @Override // com.google.android.gms.internal.ads.zzbib
            public final void zzb(String str, String str2) {
                this.zza.zzf.zzb(str, str2);
            }
        }, new com.google.android.gms.ads.internal.overlay.zzac() { // from class: com.google.android.gms.internal.ads.zzdnx
            @Override // com.google.android.gms.ads.internal.overlay.zzac
            public final void zzg() {
                this.zza.zzc.zzb();
            }
        }, z, zzbjmVar, this.zzj, new zzdoc(this), this.zzk, this.zzn, this.zzo, this.zzp, null, this.zzb, null, null, null, this.zzq);
        zzcelVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.gms.internal.ads.zzdny
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                zzdod.zzh(this.zza, view, motionEvent);
                return false;
            }
        });
        zzcelVar.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzdnz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.zza.zzj.zza();
            }
        });
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcQ)).booleanValue() && (zzautVarZzc = this.zzl.zzc()) != null) {
            zzautVarZzc.zzo(zzcelVar.zzF());
        }
        zzdcw zzdcwVar = this.zzh;
        Executor executor = this.zzg;
        zzdcwVar.zzo(zzcelVar, executor);
        zzdcwVar.zzo(new zzayh() { // from class: com.google.android.gms.internal.ads.zzdoa
            @Override // com.google.android.gms.internal.ads.zzayh
            public final void zzdn(zzayg zzaygVar) {
                zzcgd zzcgdVarZzN = zzcelVar.zzN();
                Rect rect = zzaygVar.zzd;
                zzcgdVarZzN.zzr(rect.left, rect.top, false);
            }
        }, executor);
        zzdcwVar.zza(zzcelVar.zzF());
        zzcelVar.zzag("/trackActiveViewUnit", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdob
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                this.zza.zzi.zzh(zzcelVar);
            }
        });
        this.zzi.zzi(zzcelVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcs)).booleanValue()) {
            bundle.putLong(zzdqm.RENDERING_CONFIGURE_WEBVIEW_END.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
    }
}
