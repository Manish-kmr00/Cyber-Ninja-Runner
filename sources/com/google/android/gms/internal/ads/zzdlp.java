package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes14.dex */
public final class zzdlp {
    private final zzfbp zza;
    private final Executor zzb;
    private final zzdoe zzc;
    private final zzdmz zzd;
    private final Context zze;
    private final zzdre zzf;
    private final zzfio zzg;
    private final zzeat zzh;

    public zzdlp(zzfbp zzfbpVar, Executor executor, zzdoe zzdoeVar, Context context, zzdre zzdreVar, zzfio zzfioVar, zzeat zzeatVar, zzdmz zzdmzVar) {
        this.zza = zzfbpVar;
        this.zzb = executor;
        this.zzc = zzdoeVar;
        this.zze = context;
        this.zzf = zzdreVar;
        this.zzg = zzfioVar;
        this.zzh = zzeatVar;
        this.zzd = zzdmzVar;
    }

    public static /* synthetic */ ListenableFuture zza(final zzdlp zzdlpVar, com.google.android.gms.ads.internal.client.zzr zzrVar, zzfau zzfauVar, zzfax zzfaxVar, String str, String str2, Object obj) throws zzcex {
        final zzcel zzcelVarZza = zzdlpVar.zzc.zza(zzrVar, zzfauVar, zzfaxVar);
        final zzbzo zzbzoVarZza = zzbzo.zza(zzcelVarZza);
        if (zzdlpVar.zza.zzb != null) {
            zzdlpVar.zzh(zzcelVarZza);
            zzcelVarZza.zzaj(zzcgf.zzd());
        } else {
            zzdmw zzdmwVarZzb = zzdlpVar.zzd.zzb();
            zzcelVarZza.zzN().zzV(zzdmwVarZzb, zzdmwVarZzb, zzdmwVarZzb, zzdmwVarZzb, zzdmwVarZzb, false, null, new com.google.android.gms.ads.internal.zzb(zzdlpVar.zze, null, null), null, null, zzdlpVar.zzh, zzdlpVar.zzg, zzdlpVar.zzf, null, zzdmwVarZzb, null, null, null, null);
            zzj(zzcelVarZza);
        }
        zzcelVarZza.zzN().zzC(new zzcgb() { // from class: com.google.android.gms.internal.ads.zzdlj
            @Override // com.google.android.gms.internal.ads.zzcgb
            public final void zza(boolean z, int i, String str3, String str4) {
                zzdlp.zzf(this.zza, zzcelVarZza, zzbzoVarZza, z, i, str3, str4);
            }
        });
        zzcelVarZza.zzae(str, str2, null);
        return zzbzoVarZza;
    }

    public static /* synthetic */ ListenableFuture zzb(zzdlp zzdlpVar, Object obj) throws zzcex {
        zzcel zzcelVarZza = zzdlpVar.zzc.zza(com.google.android.gms.ads.internal.client.zzr.zzc(), null, null);
        final zzbzo zzbzoVarZza = zzbzo.zza(zzcelVarZza);
        zzdlpVar.zzh(zzcelVarZza);
        zzcelVarZza.zzN().zzJ(new zzcgc() { // from class: com.google.android.gms.internal.ads.zzdlh
            @Override // com.google.android.gms.internal.ads.zzcgc
            public final void zza() {
                zzbzoVarZza.zzb();
            }
        });
        zzcelVarZza.loadUrl((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdY));
        return zzbzoVarZza;
    }

    public static /* synthetic */ ListenableFuture zzc(final zzdlp zzdlpVar, JSONObject jSONObject, final zzcel zzcelVar) {
        zzblt zzbltVar = zzdlpVar.zza.zzb;
        final zzbzo zzbzoVarZza = zzbzo.zza(zzcelVar);
        if (zzbltVar != null) {
            zzcelVar.zzaj(zzcgf.zzd());
        } else {
            zzcelVar.zzaj(zzcgf.zze());
        }
        zzcelVar.zzN().zzC(new zzcgb() { // from class: com.google.android.gms.internal.ads.zzdli
            @Override // com.google.android.gms.internal.ads.zzcgb
            public final void zza(boolean z, int i, String str, String str2) {
                zzdlp.zzg(this.zza, zzcelVar, zzbzoVarZza, z, i, str, str2);
            }
        });
        zzcelVar.zzp("google.afma.nativeAds.renderVideo", jSONObject);
        return zzbzoVarZza;
    }

    public static /* synthetic */ void zzf(zzdlp zzdlpVar, zzcel zzcelVar, zzbzo zzbzoVar, boolean z, int i, String str, String str2) {
        if (z) {
            com.google.android.gms.ads.internal.client.zzfw zzfwVar = zzdlpVar.zza.zza;
            if (zzfwVar != null && zzcelVar.zzq() != null) {
                zzcelVar.zzq().zzs(zzfwVar);
            }
            zzbzoVar.zzb();
            return;
        }
        zzbzoVar.zzd(new zzefy(1, "Html video Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }

    public static /* synthetic */ void zzg(zzdlp zzdlpVar, zzcel zzcelVar, zzbzo zzbzoVar, boolean z, int i, String str, String str2) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeg)).booleanValue()) {
            zzdlpVar.zzi(zzcelVar, zzbzoVar);
            return;
        }
        if (z) {
            zzdlpVar.zzi(zzcelVar, zzbzoVar);
            return;
        }
        zzbzoVar.zzd(new zzefy(1, "Native Video WebView failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }

    private final void zzh(zzcel zzcelVar) {
        zzj(zzcelVar);
        zzcelVar.zzag("/video", zzbji.zzl);
        zzcelVar.zzag("/videoMeta", zzbji.zzm);
        zzcelVar.zzag("/precache", new zzcct());
        zzcelVar.zzag("/delayPageLoaded", zzbji.zzp);
        zzcelVar.zzag("/instrument", zzbji.zzn);
        zzcelVar.zzag("/log", zzbji.zzg);
        zzcelVar.zzag("/click", new zzbih(null, 0 == true ? 1 : 0));
        if (this.zza.zzb != null) {
            zzcelVar.zzN().zzG(true);
            zzcelVar.zzag("/open", new zzbjv(null, null, null, null, null));
        } else {
            zzcelVar.zzN().zzG(false);
        }
        if (com.google.android.gms.ads.internal.zzv.zzo().zzp(zzcelVar.getContext())) {
            Map map = new HashMap();
            if (zzcelVar.zzD() != null) {
                map = zzcelVar.zzD().zzaw;
            }
            zzcelVar.zzag("/logScionEvent", new zzbjp(zzcelVar.getContext(), map));
        }
    }

    private final void zzi(zzcel zzcelVar, zzbzo zzbzoVar) {
        com.google.android.gms.ads.internal.client.zzfw zzfwVar = this.zza.zza;
        if (zzfwVar != null && zzcelVar.zzq() != null) {
            zzcelVar.zzq().zzs(zzfwVar);
        }
        zzbzoVar.zzb();
    }

    private static final void zzj(zzcel zzcelVar) {
        zzcelVar.zzag("/videoClicked", zzbji.zzh);
        zzcelVar.zzN().zzI(true);
        zzcelVar.zzag("/getNativeAdViewSignals", zzbji.zzs);
        zzcelVar.zzag("/getNativeClickMeta", zzbji.zzt);
    }

    public final ListenableFuture zzd(final JSONObject jSONObject) {
        ListenableFuture listenableFutureZzh = zzgbs.zzh(null);
        zzgaz zzgazVar = new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdlg
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzdlp.zzb(this.zza, obj);
            }
        };
        Executor executor = this.zzb;
        return zzgbs.zzn(zzgbs.zzn(listenableFutureZzh, zzgazVar, executor), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdlf
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzdlp.zzc(this.zza, jSONObject, (zzcel) obj);
            }
        }, executor);
    }

    public final ListenableFuture zze(final String str, final String str2, final zzfau zzfauVar, final zzfax zzfaxVar, final com.google.android.gms.ads.internal.client.zzr zzrVar) {
        return zzgbs.zzn(zzgbs.zzh(null), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdle
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzdlp.zza(this.zza, zzrVar, zzfauVar, zzfaxVar, str, str2, obj);
            }
        }, this.zzb);
    }
}
