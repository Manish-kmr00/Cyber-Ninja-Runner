package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.json.b9;
import com.json.nu;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdsd implements AppEventListener, zzcya, com.google.android.gms.ads.internal.client.zza, zzcvc, zzcvw, zzcvx, zzcwq, zzcvf, zzffu {
    private final List zza;
    private final zzdrr zzb;
    private long zzc;

    public zzdsd(zzdrr zzdrrVar, zzcgl zzcglVar) {
        this.zzb = zzdrrVar;
        this.zza = Collections.singletonList(zzcglVar);
    }

    private final void zzg(Class cls, String str, Object... objArr) {
        this.zzb.zza(this.zza, "Event-".concat(String.valueOf(cls.getSimpleName())), str, objArr);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzg(com.google.android.gms.ads.internal.client.zza.class, nu.f, new Object[0]);
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final void onAppEvent(String str, String str2) {
        zzg(AppEventListener.class, "onAppEvent", str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zza() {
        zzg(zzcvc.class, nu.g, new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzb() {
        zzg(zzcvc.class, nu.k, new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzc() {
        zzg(zzcvc.class, nu.c, new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzd(zzffn zzffnVar, String str) {
        zzg(zzffm.class, "onTaskSucceeded", str);
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzdA(zzffn zzffnVar, String str) {
        zzg(zzffm.class, "onTaskCreated", str);
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzdB(zzffn zzffnVar, String str, Throwable th) {
        zzg(zzffm.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzdC(zzffn zzffnVar, String str) {
        zzg(zzffm.class, "onTaskStarted", str);
    }

    @Override // com.google.android.gms.internal.ads.zzcvx
    public final void zzdh(Context context) {
        zzg(zzcvx.class, "onDestroy", context);
    }

    @Override // com.google.android.gms.internal.ads.zzcvx
    public final void zzdj(Context context) {
        zzg(zzcvx.class, b9.h.t0, context);
    }

    @Override // com.google.android.gms.internal.ads.zzcvx
    public final void zzdk(Context context) {
        zzg(zzcvx.class, b9.h.u0, context);
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdl(zzbuy zzbuyVar) {
        this.zzc = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime();
        zzg(zzcya.class, "onAdRequest", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdm(zzfbg zzfbgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    @ParametersAreNonnullByDefault
    public final void zzdq(zzbvk zzbvkVar, String str, String str2) {
        zzg(zzcvc.class, "onRewarded", zzbvkVar, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcvf
    public final void zzdz(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzg(zzcvf.class, "onAdFailedToLoad", Integer.valueOf(zzeVar.zza), zzeVar.zzb, zzeVar.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zze() {
        zzg(zzcvc.class, "onRewardedVideoCompleted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzf() {
        zzg(zzcvc.class, "onRewardedVideoStarted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final void zzs() {
        zzg(zzcvw.class, "onAdImpression", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzt() {
        com.google.android.gms.ads.internal.util.zze.zza("Ad Request Latency : " + (com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - this.zzc));
        zzg(zzcwq.class, "onAdLoaded", new Object[0]);
    }
}
