package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.IOUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdyu extends zzbul {
    private final Context zza;
    private final zzgcd zzb;
    private final zzdzc zzc;
    private final zzckk zzd;
    private final ArrayDeque zze;
    private final zzfgq zzf;
    private final zzbvg zzg;

    public zzdyu(Context context, zzgcd zzgcdVar, zzbvg zzbvgVar, zzckk zzckkVar, zzdzc zzdzcVar, ArrayDeque arrayDeque, zzdyz zzdyzVar, zzfgq zzfgqVar) {
        zzbci.zza(context);
        this.zza = context;
        this.zzb = zzgcdVar;
        this.zzg = zzbvgVar;
        this.zzc = zzdzcVar;
        this.zzd = zzckkVar;
        this.zze = arrayDeque;
        this.zzf = zzfgqVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InputStream zzk(zzdyu zzdyuVar, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzbuy zzbuyVar, zzfgc zzfgcVar) {
        String strZze = ((zzbva) listenableFuture.get()).zze();
        zzdyuVar.zzo(new zzdyr((zzbva) listenableFuture.get(), (JSONObject) listenableFuture2.get(), zzbuyVar.zzh, strZze, zzfgcVar));
        return new ByteArrayInputStream(strZze.getBytes(StandardCharsets.UTF_8));
    }

    private final synchronized zzdyr zzl(String str) {
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            zzdyr zzdyrVar = (zzdyr) it.next();
            if (zzdyrVar.zzc.equals(str)) {
                it.remove();
                return zzdyrVar;
            }
        }
        return null;
    }

    private static ListenableFuture zzm(ListenableFuture listenableFuture, zzfft zzfftVar, zzboa zzboaVar, zzfgn zzfgnVar, zzfgc zzfgcVar) {
        zzbnq zzbnqVarZza = zzboaVar.zza("AFMA_getAdDictionary", zzbnx.zza, new zzbns() { // from class: com.google.android.gms.internal.ads.zzdyl
            @Override // com.google.android.gms.internal.ads.zzbns
            public final Object zza(JSONObject jSONObject) {
                return new zzbva(jSONObject);
            }
        });
        zzfgm.zzd(listenableFuture, zzfgcVar);
        zzfez zzfezVarZza = zzfftVar.zzb(zzffn.BUILD_URL, listenableFuture).zzf(zzbnqVarZza).zza();
        zzfgm.zzc(zzfezVarZza, zzfgnVar, zzfgcVar);
        return zzfezVarZza;
    }

    private static ListenableFuture zzn(final zzbuy zzbuyVar, zzfft zzfftVar, final zzety zzetyVar) {
        zzgaz zzgazVar = new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdyf
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzetyVar.zzb().zza(com.google.android.gms.ads.internal.client.zzbb.zzb().zzj((Bundle) obj), zzbuyVar.zzm, false);
            }
        };
        return zzfftVar.zzb(zzffn.GMS_SIGNALS, zzgbs.zzh(zzbuyVar.zza)).zzf(zzgazVar).zze(new zzfex() { // from class: com.google.android.gms.internal.ads.zzdyg
            @Override // com.google.android.gms.internal.ads.zzfex
            public final Object zza(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                com.google.android.gms.ads.internal.util.zze.zza("Ad request signals:");
                com.google.android.gms.ads.internal.util.zze.zza(jSONObject.toString(2));
                return jSONObject;
            }
        }).zza();
    }

    private final synchronized void zzo(zzdyr zzdyrVar) {
        zzp();
        this.zze.addLast(zzdyrVar);
    }

    private final synchronized void zzp() {
        int iIntValue = ((Long) zzbep.zzb.zze()).intValue();
        while (true) {
            ArrayDeque arrayDeque = this.zze;
            if (arrayDeque.size() >= iIntValue) {
                arrayDeque.removeFirst();
            }
        }
    }

    private final void zzq(ListenableFuture listenableFuture, zzbuq zzbuqVar, zzbuy zzbuyVar) {
        zzgbs.zzr(zzgbs.zzn(listenableFuture, new zzgaz(this) { // from class: com.google.android.gms.internal.ads.zzdym
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) throws IOException {
                final InputStream inputStream = (InputStream) obj;
                ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
                ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorArrCreatePipe[0];
                final ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptorArrCreatePipe[1];
                zzbzk.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfcp
                    @Override // java.lang.Runnable
                    public final void run() {
                        InputStream inputStream2 = inputStream;
                        try {
                            try {
                                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor2);
                                try {
                                    IOUtils.copyStream(inputStream2, autoCloseOutputStream);
                                    autoCloseOutputStream.close();
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                } catch (Throwable th) {
                                    try {
                                        autoCloseOutputStream.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable th4) {
                                        th3.addSuppressed(th4);
                                    }
                                }
                                throw th3;
                            }
                        } catch (IOException unused) {
                        }
                    }
                });
                return zzgbs.zzh(parcelFileDescriptor);
            }
        }, zzbzk.zza), new zzdyq(this, zzbuyVar, zzbuqVar), zzbzk.zzg);
    }

    public final ListenableFuture zzb(final zzbuy zzbuyVar, int i) {
        if (!((Boolean) zzbep.zza.zze()).booleanValue()) {
            return zzgbs.zzg(new Exception("Split request is disabled."));
        }
        zzfdj zzfdjVar = zzbuyVar.zzi;
        if (zzfdjVar == null) {
            return zzgbs.zzg(new Exception("Pool configuration missing from request."));
        }
        if (zzfdjVar.zzc == 0 || zzfdjVar.zzd == 0) {
            return zzgbs.zzg(new Exception("Caching is disabled."));
        }
        Context context = this.zza;
        zzboa zzboaVarZzb = com.google.android.gms.ads.internal.zzv.zzg().zzb(context, VersionInfoParcel.forPackage(), this.zzf);
        zzety zzetyVarZzq = this.zzd.zzq(zzbuyVar, i);
        zzfft zzfftVarZze = zzetyVarZzq.zze();
        final ListenableFuture listenableFutureZzn = zzn(zzbuyVar, zzfftVarZze, zzetyVarZzq);
        zzfgn zzfgnVarZzf = zzetyVarZzq.zzf();
        final zzfgc zzfgcVarZza = zzfgb.zza(context, 9);
        final ListenableFuture listenableFutureZzm = zzm(listenableFutureZzn, zzfftVarZze, zzboaVarZzb, zzfgnVarZzf, zzfgcVarZza);
        return zzfftVarZze.zza(zzffn.GET_URL_AND_CACHE_KEY, listenableFutureZzn, listenableFutureZzm).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdyj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzdyu.zzk(this.zza, listenableFutureZzm, listenableFutureZzn, zzbuyVar, zzfgcVarZza);
            }
        }).zza();
    }

    public final ListenableFuture zzc(final zzbuy zzbuyVar, int i) {
        zzdyr zzdyrVarZzl;
        zzfez zzfezVarZza;
        zzbnr zzbnrVarZzg = com.google.android.gms.ads.internal.zzv.zzg();
        Context context = this.zza;
        zzboa zzboaVarZzb = zzbnrVarZzg.zzb(context, VersionInfoParcel.forPackage(), this.zzf);
        zzety zzetyVarZzq = this.zzd.zzq(zzbuyVar, i);
        zzbnq zzbnqVarZza = zzboaVarZzb.zza("google.afma.response.normalize", zzdyt.zza, zzbnx.zzb);
        if (((Boolean) zzbep.zza.zze()).booleanValue()) {
            zzdyrVarZzl = zzl(zzbuyVar.zzh);
            if (zzdyrVarZzl == null) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but no matching parameters were found.");
            }
        } else {
            String str = zzbuyVar.zzj;
            zzdyrVarZzl = null;
            if (str != null && !str.isEmpty()) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        }
        zzfgc zzfgcVarZza = zzdyrVarZzl == null ? zzfgb.zza(context, 9) : zzdyrVarZzl.zzd;
        zzfgn zzfgnVarZzf = zzetyVarZzq.zzf();
        zzfgnVarZzf.zzd(zzbuyVar.zza.getStringArrayList("ad_types"));
        zzdzb zzdzbVar = new zzdzb(zzbuyVar.zzg, zzfgnVarZzf, zzfgcVarZza);
        zzdyy zzdyyVar = new zzdyy(context, zzbuyVar.zzb.afmaVersion, this.zzg, i);
        zzfft zzfftVarZze = zzetyVarZzq.zze();
        zzfgc zzfgcVarZza2 = zzfgb.zza(context, 11);
        if (zzdyrVarZzl == null) {
            final ListenableFuture listenableFutureZzn = zzn(zzbuyVar, zzfftVarZze, zzetyVarZzq);
            final ListenableFuture listenableFutureZzm = zzm(listenableFutureZzn, zzfftVarZze, zzboaVarZzb, zzfgnVarZzf, zzfgcVarZza);
            zzfgc zzfgcVarZza3 = zzfgb.zza(context, 10);
            final zzfez zzfezVarZza2 = zzfftVarZze.zza(zzffn.HTTP, listenableFutureZzm, listenableFutureZzn).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdyh
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Bundle bundle;
                    zzbva zzbvaVar = (zzbva) listenableFutureZzm.get();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcq)).booleanValue() && (bundle = zzbuyVar.zzm) != null) {
                        bundle.putLong(zzdqm.GET_AD_DICTIONARY_SDKCORE_START.zza(), zzbvaVar.zzc());
                        bundle.putLong(zzdqm.GET_AD_DICTIONARY_SDKCORE_END.zza(), zzbvaVar.zzb());
                    }
                    return new zzdza((JSONObject) listenableFutureZzn.get(), zzbvaVar);
                }
            }).zze(zzdzbVar).zze(new zzfgi(zzfgcVarZza3)).zze(zzdyyVar).zza();
            zzfgm.zza(zzfezVarZza2, zzfgnVarZzf, zzfgcVarZza3);
            zzfgm.zzd(zzfezVarZza2, zzfgcVarZza2);
            zzfezVarZza = zzfftVarZze.zza(zzffn.PRE_PROCESS, listenableFutureZzn, listenableFutureZzm, zzfezVarZza2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdyi
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Bundle bundle;
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcq)).booleanValue() && (bundle = zzbuyVar.zzm) != null) {
                        bundle.putLong(zzdqm.HTTP_RESPONSE_READY.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
                    }
                    return new zzdyt((zzdyx) zzfezVarZza2.get(), (JSONObject) listenableFutureZzn.get(), (zzbva) listenableFutureZzm.get());
                }
            }).zzf(zzbnqVarZza).zza();
        } else {
            zzdza zzdzaVar = new zzdza(zzdyrVarZzl.zzb, zzdyrVarZzl.zza);
            zzfgc zzfgcVarZza4 = zzfgb.zza(context, 10);
            final zzfez zzfezVarZza3 = zzfftVarZze.zzb(zzffn.HTTP, zzgbs.zzh(zzdzaVar)).zze(zzdzbVar).zze(new zzfgi(zzfgcVarZza4)).zze(zzdyyVar).zza();
            zzfgm.zza(zzfezVarZza3, zzfgnVarZzf, zzfgcVarZza4);
            final ListenableFuture listenableFutureZzh = zzgbs.zzh(zzdyrVarZzl);
            zzfgm.zzd(zzfezVarZza3, zzfgcVarZza2);
            zzfezVarZza = zzfftVarZze.zza(zzffn.PRE_PROCESS, zzfezVarZza3, listenableFutureZzh).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdye
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzdyx zzdyxVar = (zzdyx) zzfezVarZza3.get();
                    ListenableFuture listenableFuture = listenableFutureZzh;
                    return new zzdyt(zzdyxVar, ((zzdyr) listenableFuture.get()).zzb, ((zzdyr) listenableFuture.get()).zza);
                }
            }).zzf(zzbnqVarZza).zza();
        }
        zzfgm.zza(zzfezVarZza, zzfgnVarZzf, zzfgcVarZza2);
        return zzfezVarZza;
    }

    public final ListenableFuture zzd(final zzbuy zzbuyVar, int i) {
        zzbnr zzbnrVarZzg = com.google.android.gms.ads.internal.zzv.zzg();
        Context context = this.zza;
        zzboa zzboaVarZzb = zzbnrVarZzg.zzb(context, VersionInfoParcel.forPackage(), this.zzf);
        if (!((Boolean) zzbeu.zza.zze()).booleanValue()) {
            return zzgbs.zzg(new Exception("Signal collection disabled."));
        }
        zzety zzetyVarZzq = this.zzd.zzq(zzbuyVar, i);
        final zzesy zzesyVarZza = zzetyVarZzq.zza();
        zzbnq zzbnqVarZza = zzboaVarZzb.zza("google.afma.request.getSignals", zzbnx.zza, zzbnx.zzb);
        zzfgc zzfgcVarZza = zzfgb.zza(context, 22);
        zzfft zzfftVarZze = zzetyVarZzq.zze();
        zzffn zzffnVar = zzffn.GET_SIGNALS;
        Bundle bundle = zzbuyVar.zza;
        zzfez zzfezVarZza = zzfftVarZze.zzb(zzffnVar, zzgbs.zzh(bundle)).zze(new zzfgi(zzfgcVarZza)).zzf(new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdyn
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) throws JSONException {
                return zzesyVarZza.zza(com.google.android.gms.ads.internal.client.zzbb.zzb().zzj((Bundle) obj), zzbuyVar.zzm, false);
            }
        }).zzb(zzffn.JS_SIGNALS).zzf(zzbnqVarZza).zza();
        zzfgn zzfgnVarZzf = zzetyVarZzq.zzf();
        zzfgnVarZzf.zzd(bundle.getStringArrayList("ad_types"));
        zzfgnVarZzf.zzf(bundle.getBundle("extras"));
        zzfgm.zzb(zzfezVarZza, zzfgnVarZzf, zzfgcVarZza);
        if (((Boolean) zzbei.zzf.zze()).booleanValue()) {
            zzdzc zzdzcVar = this.zzc;
            Objects.requireNonNull(zzdzcVar);
            zzfezVarZza.addListener(new zzdyk(zzdzcVar), this.zzb);
        }
        return zzfezVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zze(zzbuy zzbuyVar, zzbuq zzbuqVar) {
        zzq(zzb(zzbuyVar, Binder.getCallingUid()), zzbuqVar, zzbuyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zzf(zzbuy zzbuyVar, zzbuq zzbuqVar) {
        Bundle bundle;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcq)).booleanValue() && (bundle = zzbuyVar.zzm) != null) {
            bundle.putLong(zzdqm.SERVICE_CONNECTED.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        zzq(zzd(zzbuyVar, Binder.getCallingUid()), zzbuqVar, zzbuyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zzg(zzbuy zzbuyVar, zzbuq zzbuqVar) {
        Bundle bundle;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcq)).booleanValue() && (bundle = zzbuyVar.zzm) != null) {
            bundle.putLong(zzdqm.SERVICE_CONNECTED.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        ListenableFuture listenableFutureZzc = zzc(zzbuyVar, Binder.getCallingUid());
        zzq(listenableFutureZzc, zzbuqVar, zzbuyVar);
        if (((Boolean) zzbei.zze.zze()).booleanValue()) {
            zzdzc zzdzcVar = this.zzc;
            Objects.requireNonNull(zzdzcVar);
            listenableFutureZzc.addListener(new zzdyk(zzdzcVar), this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zzh(String str, zzbuq zzbuqVar) {
        zzq(zzj(str), zzbuqVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zzi(zzbui zzbuiVar, zzbur zzburVar) {
        if (((Boolean) zzbew.zza.zze()).booleanValue()) {
            this.zzd.zzD();
            String str = zzbuiVar.zza;
            zzgbs.zzr(zzgbs.zzh(null), new zzdyo(this, zzburVar, zzbuiVar), zzbzk.zzg);
        } else {
            try {
                zzburVar.zzf("", zzbuiVar);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.zze.zzb("Service can't call client", e);
            }
        }
    }

    public final ListenableFuture zzj(String str) {
        if (((Boolean) zzbep.zza.zze()).booleanValue()) {
            return zzl(str) == null ? zzgbs.zzg(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str)))) : zzgbs.zzh(new zzdyp(this));
        }
        return zzgbs.zzg(new Exception("Split request is disabled."));
    }
}
