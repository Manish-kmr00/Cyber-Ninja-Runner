package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public abstract class zzcgl implements zzckk {

    @Nullable
    private static zzcgl zza;

    private static synchronized zzcgl zzE(Context context, @Nullable zzboy zzboyVar, int i, boolean z, int i2, zzchr zzchrVar) {
        zzcgl zzcglVar = zza;
        if (zzcglVar != null) {
            return zzcglVar;
        }
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis();
        zzbci.zza(context);
        if (((Boolean) zzbea.zze.zze()).booleanValue()) {
            zzbbs.zzd(context);
        }
        zzfcl zzfclVarZzd = zzfcl.zzd(context);
        VersionInfoParcel versionInfoParcelZzc = zzfclVarZzd.zzc(251410000, false, i2);
        zzfclVarZzd.zzf(zzboyVar);
        zzcig zzcigVar = new zzcig(null);
        zzcgm zzcgmVar = new zzcgm();
        zzcgmVar.zzf(versionInfoParcelZzc);
        zzcgmVar.zze(context);
        zzcgmVar.zzd(jCurrentTimeMillis);
        zzcigVar.zzb(new zzcgo(zzcgmVar, null));
        zzcigVar.zzc(new zzcja(zzchrVar));
        zzcgl zzcglVarZza = zzcigVar.zza();
        com.google.android.gms.ads.internal.zzv.zzp().zzu(context, versionInfoParcelZzc);
        com.google.android.gms.ads.internal.zzv.zzc().zzi(context);
        com.google.android.gms.ads.internal.zzv.zzq().zzm(context);
        com.google.android.gms.ads.internal.zzv.zzq().zzl(context);
        com.google.android.gms.ads.internal.util.zzd.zza(context);
        com.google.android.gms.ads.internal.zzv.zzb().zzd(context);
        com.google.android.gms.ads.internal.zzv.zzw().zzb(context);
        ((com.google.android.gms.ads.internal.util.zzcb) ((zzchv) zzcglVarZza).zzai.zzb()).zzc();
        zzbxx.zzb(context);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgi)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaM)).booleanValue()) {
                new zzeag(context, versionInfoParcelZzc, new zzbbg(new zzbbm(context)), new zzdzl(new zzdzh(context), (zzgcd) ((zzchv) zzcglVarZza).zzd.zzb())).zzb(com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
            }
        }
        zza = zzcglVarZza;
        return zzcglVarZza;
    }

    public static zzcgl zza(Context context, @Nullable zzboy zzboyVar, int i) {
        return zzE(context, zzboyVar, 251410000, false, i, new zzchr());
    }

    public abstract Executor zzA();

    public abstract ScheduledExecutorService zzB();

    public abstract zzbyp zzC();

    @Override // com.google.android.gms.internal.ads.zzckk
    public final zzbyp zzD() {
        return zzC();
    }

    public abstract zzcjl zzb();

    public abstract zzcnm zzc();

    public abstract zzcpc zzd();

    public abstract zzcxv zze();

    public abstract zzdfd zzf();

    public abstract zzdfz zzg();

    public abstract zzdnm zzh();

    public abstract zzdre zzi();

    public abstract zzdso zzj();

    public abstract zzdud zzk();

    public abstract zzdva zzl();

    public abstract zzebe zzm();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzv zzn();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzab zzo();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzau zzp();

    @Override // com.google.android.gms.internal.ads.zzckk
    public final zzety zzq(zzbuy zzbuyVar, int i) {
        return zzr(new zzevb(zzbuyVar, i));
    }

    protected abstract zzety zzr(zzevb zzevbVar);

    public abstract zzevu zzs();

    public abstract zzexi zzt();

    public abstract zzeyz zzu();

    public abstract zzfan zzv();

    public abstract zzfce zzw();

    public abstract zzfco zzx();

    public abstract zzfgq zzy();

    public abstract zzfix zzz();
}
