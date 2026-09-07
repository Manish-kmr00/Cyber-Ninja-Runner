package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzdmt {
    private final com.google.android.gms.ads.internal.zza zzb;
    private final Context zzc;
    private final zzdre zzd;
    private final Executor zze;
    private final zzauy zzf;
    private final VersionInfoParcel zzg;
    private final zzeat zzi;
    private final zzfio zzj;
    private final zzebe zzk;
    private final zzfbt zzl;
    private ListenableFuture zzm;
    private final zzdmg zza = new zzdmg();
    private final zzbjz zzh = new zzbjz();

    zzdmt(zzdmq zzdmqVar) {
        this.zzc = zzdmqVar.zzb;
        this.zze = zzdmqVar.zze;
        this.zzf = zzdmqVar.zzf;
        this.zzg = zzdmqVar.zzg;
        this.zzb = zzdmqVar.zza;
        this.zzi = zzdmqVar.zzd;
        this.zzj = zzdmqVar.zzh;
        this.zzd = zzdmqVar.zzc;
        this.zzk = zzdmqVar.zzi;
        this.zzl = zzdmqVar.zzj;
    }

    public static /* synthetic */ zzcel zza(zzdmt zzdmtVar, zzcel zzcelVar) {
        zzcelVar.zzag("/result", zzdmtVar.zzh);
        zzcgd zzcgdVarZzN = zzcelVar.zzN();
        com.google.android.gms.ads.internal.zzb zzbVar = new com.google.android.gms.ads.internal.zzb(zzdmtVar.zzc, null, null);
        zzeat zzeatVar = zzdmtVar.zzi;
        zzfio zzfioVar = zzdmtVar.zzj;
        zzdre zzdreVar = zzdmtVar.zzd;
        zzdmg zzdmgVar = zzdmtVar.zza;
        zzcgdVarZzN.zzV(null, zzdmgVar, zzdmgVar, zzdmgVar, zzdmgVar, false, null, zzbVar, null, null, zzeatVar, zzfioVar, zzdreVar, null, null, null, null, null, null);
        return zzcelVar;
    }

    public final synchronized ListenableFuture zzg(final String str, final JSONObject jSONObject) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return zzgbs.zzh(null);
        }
        return zzgbs.zzn(listenableFuture, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdmh
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzh.zzb((zzcel) obj, str, jSONObject);
            }
        }, this.zze);
    }

    public final synchronized void zzh(zzfau zzfauVar, zzfax zzfaxVar, zzclx zzclxVar) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzgbs.zzr(listenableFuture, new zzdmn(this, zzfauVar, zzfaxVar, zzclxVar), this.zze);
    }

    public final synchronized void zzi() {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzgbs.zzr(listenableFuture, new zzdmj(this), this.zze);
        this.zzm = null;
    }

    public final synchronized void zzj(String str, Map map) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzgbs.zzr(listenableFuture, new zzdmm(this, "sendMessageToNativeJs", map), this.zze);
    }

    public final synchronized void zzk() {
        final String str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdX);
        final Context context = this.zzc;
        final zzauy zzauyVar = this.zzf;
        final VersionInfoParcel versionInfoParcel = this.zzg;
        final com.google.android.gms.ads.internal.zza zzaVar = this.zzb;
        final zzebe zzebeVar = this.zzk;
        final zzfbt zzfbtVar = this.zzl;
        final zzdre zzdreVar = this.zzd;
        ListenableFuture listenableFutureZzm = zzgbs.zzm(zzgbs.zzk(new zzgay() { // from class: com.google.android.gms.internal.ads.zzceu
            @Override // com.google.android.gms.internal.ads.zzgay
            public final ListenableFuture zza() throws zzcex {
                com.google.android.gms.ads.internal.zzv.zzA();
                Context context2 = context;
                zzebe zzebeVar2 = zzebeVar;
                zzcgf zzcgfVarZza = zzcgf.zza();
                zzauy zzauyVar2 = zzauyVar;
                zzfbt zzfbtVar2 = zzfbtVar;
                com.google.android.gms.ads.internal.zza zzaVar2 = zzaVar;
                zzcel zzcelVarZza = zzcey.zza(context2, zzcgfVarZza, "", false, false, zzauyVar2, null, versionInfoParcel, null, null, zzaVar2, zzbbg.zza(), null, null, zzebeVar2, zzfbtVar2, zzdreVar);
                final zzbzo zzbzoVarZza = zzbzo.zza(zzcelVarZza);
                zzcelVarZza.zzN().zzC(new zzcgb() { // from class: com.google.android.gms.internal.ads.zzcev
                    @Override // com.google.android.gms.internal.ads.zzcgb
                    public final void zza(boolean z, int i, String str2, String str3) {
                        zzbzoVarZza.zzb();
                    }
                });
                zzcelVarZza.loadUrl(str);
                return zzbzoVarZza;
            }
        }, zzbzk.zzf), new zzftl() { // from class: com.google.android.gms.internal.ads.zzdmi
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                zzcel zzcelVar = (zzcel) obj;
                zzdmt.zza(this.zza, zzcelVar);
                return zzcelVar;
            }
        }, this.zze);
        this.zzm = listenableFutureZzm;
        zzbzn.zza(listenableFutureZzm, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzl(String str, zzbjj zzbjjVar) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzgbs.zzr(listenableFuture, new zzdmk(this, str, zzbjjVar), this.zze);
    }

    public final void zzm(WeakReference weakReference, String str, zzbjj zzbjjVar) {
        zzl(str, new zzdmr(this, weakReference, str, zzbjjVar, null));
    }

    public final synchronized void zzn(String str, zzbjj zzbjjVar) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzgbs.zzr(listenableFuture, new zzdml(this, str, zzbjjVar), this.zze);
    }
}
