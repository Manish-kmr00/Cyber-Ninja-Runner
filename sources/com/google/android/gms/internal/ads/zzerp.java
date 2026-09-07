package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzerp implements zzesv {
    private final Context zza;
    private final zzgcd zzb;
    private final zzfbp zzc;
    private final VersionInfoParcel zzd;

    zzerp(Context context, zzgcd zzgcdVar, zzfbp zzfbpVar, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzgcdVar;
        this.zzc = zzfbpVar;
        this.zzd = versionInfoParcel;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0042 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:11:0x0044 A[Catch: IOException -> 0x0126, TryCatch #0 {IOException -> 0x0126, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00ef, B:28:0x0113, B:30:0x011e, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x0056 A[Catch: IOException -> 0x0126, TryCatch #0 {IOException -> 0x0126, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00ef, B:28:0x0113, B:30:0x011e, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x00bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x00bf A[Catch: IOException -> 0x0126, TryCatch #0 {IOException -> 0x0126, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00ef, B:28:0x0113, B:30:0x011e, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x00d1 A[Catch: IOException -> 0x0126, TryCatch #0 {IOException -> 0x0126, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00ef, B:28:0x0113, B:30:0x011e, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00ef A[Catch: IOException -> 0x0126, TryCatch #0 {IOException -> 0x0126, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00ef, B:28:0x0113, B:30:0x011e, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    public static /* synthetic */ zzerq zzc(zzerp zzerpVar) {
        zzfqj zzfqjVar;
        boolean z;
        boolean zZze;
        zzfqo zzfqoVarZzi;
        zzfqk zzfqkVarZza;
        try {
            Context context = zzerpVar.zza;
            boolean zZza = zzerpVar.zzc.zza();
            zzfqj zzfqjVar2 = new zzfqj();
            zzfqj zzfqjVar3 = new zzfqj();
            boolean zZzd = true;
            if (zZza) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdp)).booleanValue()) {
                    return new zzerq(true);
                }
            }
            if (!zZza) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdl)).booleanValue()) {
                    zzfqjVar2 = zzfqn.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdw)).longValue(), com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
                } else if (zZza) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdn)).booleanValue()) {
                        zzfqjVar2 = zzfqn.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdw)).longValue(), com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
                    }
                }
            } else if (zZza) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdn)).booleanValue()) {
                    zzfqjVar2 = zzfqn.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdw)).longValue(), com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdt)).booleanValue()) {
                if (zzerpVar.zzd.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzds)).intValue()) {
                    zzfqo.zzi(context).zzj();
                }
            }
            if (zZza) {
                if (zZza) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdo)).booleanValue()) {
                        zzfqoVarZzi = zzfqo.zzi(context);
                        zzfqkVarZza = zzfqk.zza(context);
                        if (zzerpVar.zzd.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzds)).intValue()) {
                            zzfqjVar3 = zzfqoVarZzi.zzh(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdx)).longValue(), com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
                            zZzd = zzfqkVarZza.zzd();
                        }
                        zZze = zzfqkVarZza.zze();
                        zzfqjVar = zzfqjVar3;
                        z = zZzd;
                    }
                }
                zzfqjVar = zzfqjVar3;
                z = true;
                zZze = true;
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdm)).booleanValue()) {
                    zzfqoVarZzi = zzfqo.zzi(context);
                    zzfqkVarZza = zzfqk.zza(context);
                    if (zzerpVar.zzd.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzds)).intValue()) {
                        zzfqjVar3 = zzfqoVarZzi.zzh(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdx)).longValue(), com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
                        zZzd = zzfqkVarZza.zzd();
                    }
                    zZze = zzfqkVarZza.zze();
                    zzfqjVar = zzfqjVar3;
                    z = zZzd;
                } else {
                    if (zZza) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdo)).booleanValue()) {
                            zzfqoVarZzi = zzfqo.zzi(context);
                            zzfqkVarZza = zzfqk.zza(context);
                            if (zzerpVar.zzd.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzds)).intValue()) {
                                zzfqjVar3 = zzfqoVarZzi.zzh(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdx)).longValue(), com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
                                zZzd = zzfqkVarZza.zzd();
                            }
                            zZze = zzfqkVarZza.zze();
                            zzfqjVar = zzfqjVar3;
                            z = zZzd;
                        }
                    }
                    zzfqjVar = zzfqjVar3;
                    z = true;
                    zZze = true;
                }
            }
            return new zzerq(zzfqjVar2, zzfqjVar, z, zZze, zZza);
        } catch (IOException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "PerAppIdSignal");
            return new zzerq(zzerpVar.zzc.zza());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 53;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzero
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzerp.zzc(this.zza);
            }
        });
    }
}
