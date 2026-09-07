package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.pubmatic.sdk.common.POBCommonConstants;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
@ParametersAreNonnullByDefault
public final class zzbmp implements zzbmh, zzbmg {
    private final zzcel zza;

    public zzbmp(Context context, VersionInfoParcel versionInfoParcel, zzauy zzauyVar, com.google.android.gms.ads.internal.zza zzaVar) throws zzcex {
        com.google.android.gms.ads.internal.zzv.zzA();
        zzcel zzcelVarZza = zzcey.zza(context, zzcgf.zza(), "", false, false, null, null, versionInfoParcel, null, null, null, zzbbg.zza(), null, null, null, null, null);
        this.zza = zzcelVarZza;
        zzcelVarZza.zzF().setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        if (com.google.android.gms.ads.internal.util.client.zzf.zzv()) {
            com.google.android.gms.ads.internal.util.zze.zza("runOnUiThread > the UI thread is the main thread, the runnable will be run now");
            runnable.run();
        } else {
            com.google.android.gms.ads.internal.util.zze.zza("runOnUiThread > the UI thread is not the main thread, the runnable will be added to the message queue");
            if (com.google.android.gms.ads.internal.util.zzs.zza.post(runnable)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzo.zzj("runOnUiThread > the runnable could not be placed to the message queue");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final void zza(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("invokeJavascript on adWebView from js");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbml
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza.zza(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final /* synthetic */ void zzb(String str, String str2) {
        zzbmf.zzc(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbmh
    public final void zzc() {
        this.zza.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final /* synthetic */ void zzd(String str, Map map) {
        zzbmf.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbmf.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbmh
    public final void zzf(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadHtml on adWebView from html");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbmm
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza.loadData(str, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8");
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbmh
    public final void zzg(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadHtmlWrapper on adWebView from path: ".concat(String.valueOf(str)));
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbmj
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza.loadUrl(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbmh
    public final void zzh(String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascript on adWebView from path: ".concat(String.valueOf(str)));
        final String str2 = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str);
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbmn
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza.loadData(str2, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8");
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbmh
    public final boolean zzi() {
        return this.zza.zzaE();
    }

    @Override // com.google.android.gms.internal.ads.zzbmh
    public final zzbno zzj() {
        return new zzbno(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbmh
    public final void zzk(final zzbms zzbmsVar) {
        zzcgd zzcgdVarZzN = this.zza.zzN();
        Objects.requireNonNull(zzbmsVar);
        zzcgdVarZzN.zzJ(new zzcgc() { // from class: com.google.android.gms.internal.ads.zzbmk
            @Override // com.google.android.gms.internal.ads.zzcgc
            public final void zza() {
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis();
                zzbms zzbmsVar2 = zzbmsVar;
                final long j = zzbmsVar2.zzc;
                final ArrayList arrayList = zzbmsVar2.zzb;
                arrayList.add(Long.valueOf(jCurrentTimeMillis - j));
                com.google.android.gms.ads.internal.util.zze.zza("LoadNewJavascriptEngine(onEngLoaded) latency is " + String.valueOf(arrayList.get(0)) + " ms.");
                zzfqf zzfqfVar = com.google.android.gms.ads.internal.util.zzs.zza;
                final zzbnm zzbnmVar = zzbmsVar2.zza;
                final zzbnl zzbnlVar = zzbmsVar2.zzd;
                final zzbmh zzbmhVar = zzbmsVar2.zze;
                zzfqfVar.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbmt
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbnm.zzi(zzbnmVar, zzbnlVar, zzbmhVar, arrayList, j);
                    }
                }, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzc)).intValue());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final /* synthetic */ void zzp(String str, JSONObject jSONObject) {
        zzbmf.zzd(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void zzq(String str, zzbjj zzbjjVar) {
        this.zza.zzag(str, new zzbmo(this, zzbjjVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void zzr(String str, final zzbjj zzbjjVar) {
        this.zza.zzaA(str, new Predicate() { // from class: com.google.android.gms.internal.ads.zzbmi
            @Override // com.google.android.gms.common.util.Predicate
            public final boolean apply(Object obj) {
                zzbjj zzbjjVar2 = (zzbjj) obj;
                if (zzbjjVar2 instanceof zzbmo) {
                    return ((zzbmo) zzbjjVar2).zzb.equals(zzbjjVar);
                }
                return false;
            }
        });
    }
}
