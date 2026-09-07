package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.InputEvent;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import net.pubnative.lite.sdk.models.Protocol;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzclx {
    zzbtx zza;
    zzbtx zzb;
    private final Context zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;
    private final zzecb zze;
    private final zzdoj zzf;
    private final zzgcd zzg;
    private final Executor zzh;
    private final ScheduledExecutorService zzi;

    zzclx(Context context, com.google.android.gms.ads.internal.util.zzg zzgVar, zzecb zzecbVar, zzdoj zzdojVar, zzgcd zzgcdVar, zzgcd zzgcdVar2, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = context;
        this.zzd = zzgVar;
        this.zze = zzecbVar;
        this.zzf = zzdojVar;
        this.zzg = zzgcdVar;
        this.zzh = zzgcdVar2;
        this.zzi = scheduledExecutorService;
    }

    public static /* synthetic */ ListenableFuture zzb(zzclx zzclxVar, final Uri.Builder builder, String str, InputEvent inputEvent, Integer num) {
        if (num.intValue() != 1) {
            builder.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzko), "10");
            return zzgbs.zzh(builder.toString());
        }
        Uri.Builder builderBuildUpon = builder.build().buildUpon();
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkp), "1");
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzko), Protocol.VAST_4_1_WRAPPER);
        if (str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkq))) {
            builderBuildUpon.authority((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkr));
        }
        return (zzgbj) zzgbs.zzn(zzgbj.zzE(zzclxVar.zze.zzb(builderBuildUpon.build(), inputEvent)), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzclt
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzko);
                Uri.Builder builder2 = builder;
                builder2.appendQueryParameter(str2, Protocol.VAST_4_1_WRAPPER);
                return zzgbs.zzh(builder2.toString());
            }
        }, zzclxVar.zzh);
    }

    public static /* synthetic */ ListenableFuture zzc(final zzclx zzclxVar, String str, final Throwable th) {
        zzclxVar.zzg.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzclq
            @Override // java.lang.Runnable
            public final void run() {
                zzclx.zzg(this.zza, th);
            }
        });
        return zzgbs.zzh(str);
    }

    public static /* synthetic */ ListenableFuture zzd(final zzclx zzclxVar, Uri.Builder builder, final Throwable th) {
        zzclxVar.zzg.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzclp
            @Override // java.lang.Runnable
            public final void run() {
                zzclx.zzh(this.zza, th);
            }
        });
        builder.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzko), "9");
        return zzgbs.zzh(builder.toString());
    }

    public static /* synthetic */ void zzg(zzclx zzclxVar, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkt)).booleanValue()) {
            zzbtx zzbtxVarZzc = zzbtv.zzc(zzclxVar.zzc);
            zzclxVar.zzb = zzbtxVarZzc;
            zzbtxVarZzc.zzh(th, "AttributionReporting.getUpdatedUrlAndRegisterSource");
        } else {
            zzbtx zzbtxVarZza = zzbtv.zza(zzclxVar.zzc);
            zzclxVar.zza = zzbtxVarZza;
            zzbtxVarZza.zzh(th, "AttributionReportingSampled.getUpdatedUrlAndRegisterSource");
        }
    }

    public static /* synthetic */ void zzh(zzclx zzclxVar, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkt)).booleanValue()) {
            zzbtx zzbtxVarZzc = zzbtv.zzc(zzclxVar.zzc);
            zzclxVar.zzb = zzbtxVarZzc;
            zzbtxVarZzc.zzh(th, "AttributionReporting");
        } else {
            zzbtx zzbtxVarZza = zzbtv.zza(zzclxVar.zzc);
            zzclxVar.zza = zzbtxVarZza;
            zzbtxVarZza.zzh(th, "AttributionReportingSampled");
        }
    }

    public static boolean zzj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkm));
    }

    private final ListenableFuture zzk(final String str, final InputEvent inputEvent, Random random) {
        try {
            if (!str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkm)) || this.zzd.zzN()) {
                return zzgbs.zzh(str);
            }
            final Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkn), String.valueOf(random.nextInt(Integer.MAX_VALUE)));
            if (inputEvent != null) {
                return (zzgbj) zzgbs.zzf((zzgbj) zzgbs.zzn(zzgbj.zzE(this.zze.zza()), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzclr
                    @Override // com.google.android.gms.internal.ads.zzgaz
                    public final ListenableFuture zza(Object obj) {
                        return zzclx.zzb(this.zza, builderBuildUpon, str, inputEvent, (Integer) obj);
                    }
                }, this.zzh), Throwable.class, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzcls
                    @Override // com.google.android.gms.internal.ads.zzgaz
                    public final ListenableFuture zza(Object obj) {
                        return zzclx.zzd(this.zza, builderBuildUpon, (Throwable) obj);
                    }
                }, this.zzg);
            }
            builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzko), Protocol.VAST_4_1);
            return zzgbs.zzh(builderBuildUpon.toString());
        } catch (Exception e) {
            return zzgbs.zzg(e);
        }
    }

    public final ListenableFuture zze(final String str, Random random) {
        return TextUtils.isEmpty(str) ? zzgbs.zzh(str) : zzgbs.zzf(zzk(str, this.zzf.zza(), random), Throwable.class, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzclo
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzclx.zzc(this.zza, str, (Throwable) obj);
            }
        }, this.zzg);
    }

    public final void zzi(String str, zzfio zzfioVar, Random random, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzgbs.zzr(zzgbs.zzo(zzk(str, this.zzf.zza(), random), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzks)).intValue(), TimeUnit.MILLISECONDS, this.zzi), new zzclw(this, zzfioVar, str, zzvVar), this.zzg);
    }
}
