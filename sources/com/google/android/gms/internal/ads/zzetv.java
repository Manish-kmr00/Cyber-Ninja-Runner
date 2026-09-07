package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzetv implements zzesv {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzbyr zzg;

    zzetv(zzbyr zzbyrVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        this.zzg = zzbyrVar;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i;
        this.zze = z;
        this.zzf = z2;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static /* synthetic */ zzetw zzc(zzetv zzetvVar, AdvertisingIdClient.Info info) {
        zzfqj zzfqjVar = new zzfqj();
        if (zzetvVar.zze) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdr)).booleanValue()) {
                Context context = zzetvVar.zza;
                zzfqjVar = zzfqn.zzj(context).zzi((String) Objects.requireNonNull(((AdvertisingIdClient.Info) Objects.requireNonNull(info)).getId()), context.getPackageName(), ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdw)).longValue(), zzetvVar.zzf);
            }
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdq)).booleanValue()) {
                try {
                    Context context2 = zzetvVar.zza;
                    zzfqjVar = zzfqn.zzj(context2).zzi((String) Objects.requireNonNull(((AdvertisingIdClient.Info) Objects.requireNonNull(info)).getId()), context2.getPackageName(), ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdw)).longValue(), zzetvVar.zzf);
                } catch (IOException | IllegalArgumentException e) {
                    com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdIdInfoSignalSource.getPaidV1");
                    zzfqjVar = new zzfqj();
                }
            }
        }
        return new zzetw(info, null, zzfqjVar);
    }

    public static /* synthetic */ zzetw zzd(zzetv zzetvVar, Throwable th) {
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        ContentResolver contentResolver = zzetvVar.zza.getContentResolver();
        return new zzetw(null, contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id"), new zzfqj());
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 40;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        zzgbj zzgbjVarZzE = zzgbj.zzE(this.zzg.zza(this.zza, this.zzd));
        zzftl zzftlVar = new zzftl() { // from class: com.google.android.gms.internal.ads.zzett
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                return zzetv.zzc(this.zza, (AdvertisingIdClient.Info) obj);
            }
        };
        Executor executor = this.zzc;
        return (zzgbj) zzgbs.zze((zzgbj) zzgbs.zzo((zzgbj) zzgbs.zzm(zzgbjVarZzE, zzftlVar, executor), ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbi)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzftl() { // from class: com.google.android.gms.internal.ads.zzetu
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                return zzetv.zzd(this.zza, (Throwable) obj);
            }
        }, executor);
    }
}
