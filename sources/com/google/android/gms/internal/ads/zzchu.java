package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzchu extends zzety {
    private final zzchv zzA;
    final zzhfh zza;
    final zzhfh zzb;
    final zzhfh zzc;
    final zzhfh zzd;
    final zzhfh zze;
    final zzhfh zzf;
    final zzhfh zzg;
    final zzhfh zzh;
    final zzhfh zzi;
    final zzhfh zzj;
    final zzhfh zzk;
    final zzhfh zzl;
    final zzhfh zzm;
    final zzhfh zzn;
    final zzhfh zzo;
    final zzhfh zzp;
    final zzhfh zzq;
    final zzhfh zzr;
    final zzhfh zzs;
    final zzhfh zzt;
    final zzhfh zzu;
    final zzhfh zzv;
    final zzhfh zzw;
    final zzhfh zzx;
    final zzhfh zzy;
    private final zzevb zzz;

    zzchu(zzchv zzchvVar, zzevb zzevbVar) {
        this.zzA = zzchvVar;
        this.zzz = zzevbVar;
        this.zza = zzhex.zzc(new zzfgo(zzchvVar.zzx));
        zzevd zzevdVar = new zzevd(zzevbVar);
        this.zzb = zzevdVar;
        zzeve zzeveVar = new zzeve(zzevbVar);
        this.zzc = zzeveVar;
        zzevg zzevgVar = new zzevg(zzevbVar);
        this.zzd = zzevgVar;
        zzckg zzckgVar = zzckf.zza;
        zzhfh zzhfhVar = zzchvVar.zzf;
        zzhfh zzhfhVar2 = zzchvVar.zzc;
        this.zze = new zzetx(zzckgVar, zzhfhVar, zzhfhVar2, zzfen.zza(), zzevdVar, zzeveVar, zzevgVar);
        this.zzf = new zzeul(zzcjz.zza, zzfen.zza(), zzhfhVar);
        zzevc zzevcVar = new zzevc(zzevbVar);
        this.zzg = zzevcVar;
        this.zzh = new zzeut(zzckb.zza, zzfen.zza(), zzevcVar);
        this.zzi = new zzeva(zzckd.zza, zzhfhVar2, zzhfhVar);
        this.zzj = new zzevt(zzfen.zza());
        zzevf zzevfVar = new zzevf(zzevbVar);
        this.zzk = zzevfVar;
        zzevi zzeviVar = new zzevi(zzevbVar);
        this.zzl = zzeviVar;
        zzevj zzevjVar = new zzevj(zzevbVar);
        this.zzm = zzevjVar;
        zzhfh zzhfhVar3 = zzchvVar.zzaj;
        this.zzn = new zzevp(zzhfhVar3, zzevfVar, zzevgVar, zzckh.zza, zzfen.zza(), zzevcVar, zzhfhVar2, zzeviVar, zzevjVar);
        this.zzo = new zzeuh(zzevcVar, zzcjx.zza, zzhfhVar3, zzhfhVar2, zzfen.zza());
        zzevh zzevhVar = new zzevh(zzevbVar);
        this.zzp = zzevhVar;
        zzhfh zzhfhVarZzc = zzhex.zzc(zzdpy.zza());
        this.zzq = zzhfhVarZzc;
        zzhfh zzhfhVarZzc2 = zzhex.zzc(zzdpw.zza());
        this.zzr = zzhfhVarZzc2;
        zzhfh zzhfhVarZzc3 = zzhex.zzc(zzdqa.zza());
        this.zzs = zzhfhVarZzc3;
        zzhfh zzhfhVarZzc4 = zzhex.zzc(zzdqc.zza());
        this.zzt = zzhfhVarZzc4;
        zzhfb zzhfbVarZzc = zzhfc.zzc(4);
        zzhfbVarZzc.zzb(zzffn.GMS_SIGNALS, zzhfhVarZzc);
        zzhfbVarZzc.zzb(zzffn.BUILD_URL, zzhfhVarZzc2);
        zzhfbVarZzc.zzb(zzffn.HTTP, zzhfhVarZzc3);
        zzhfbVarZzc.zzb(zzffn.PRE_PROCESS, zzhfhVarZzc4);
        zzhfc zzhfcVarZzc = zzhfbVarZzc.zzc();
        this.zzu = zzhfcVarZzc;
        zzhfh zzhfhVarZzc5 = zzhex.zzc(new zzdqd(zzevhVar, zzchvVar.zzf, zzfen.zza(), zzhfcVarZzc));
        this.zzv = zzhfhVarZzc5;
        zzhfj zzhfjVarZza = zzhfk.zza(0, 1);
        zzhfjVarZza.zza(zzhfhVarZzc5);
        zzhfk zzhfkVarZzc = zzhfjVarZza.zzc();
        this.zzw = zzhfkVarZzc;
        zzffw zzffwVar = new zzffw(zzhfkVarZzc);
        this.zzx = zzffwVar;
        this.zzy = zzhex.zzc(new zzffv(zzfen.zza(), zzchvVar.zzc, zzffwVar));
    }

    @Override // com.google.android.gms.internal.ads.zzety
    public final zzesy zza() {
        zzchv zzchvVar = this.zzA;
        Context contextZzc = zzcgs.zzc(zzchvVar.zzbn);
        zzhfh zzhfhVar = this.zza;
        zzhfh zzhfhVar2 = this.zzo;
        zzhfh zzhfhVar3 = this.zzn;
        zzhfh zzhfhVar4 = this.zzj;
        zzhfh zzhfhVar5 = this.zzi;
        zzhfh zzhfhVar6 = this.zzh;
        zzhfh zzhfhVar7 = this.zzf;
        zzhfh zzhfhVar8 = this.zze;
        return zzevk.zza(contextZzc, zzckc.zza(), zzcki.zza(), zzchvVar.zzbm.zzb(), zzc(), zzd(), zzhex.zza(zzhfhVar8), zzhex.zza(zzhfhVar7), zzhex.zza(zzhfhVar6), zzhex.zza(zzhfhVar5), zzhex.zza(zzhfhVar4), zzhex.zza(zzhfhVar3), zzhex.zza(zzhfhVar2), zzfen.zzc(), (zzfgn) zzhfhVar.zzb(), (zzdre) zzchvVar.zzK.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzety
    public final zzesy zzb() {
        zzchv zzchvVar = this.zzA;
        Context contextZzc = zzcgs.zzc(zzchvVar.zzbn);
        zzevb zzevbVar = this.zzz;
        zzgcd zzgcdVarZzc = zzfen.zzc();
        zzeur zzeurVar = new zzeur(zzckc.zza(), zzfen.zzc(), zzevc.zzc(zzevbVar));
        zzhfh zzhfhVar = zzchvVar.zzc;
        return new zzesy(contextZzc, zzgcdVarZzc, zzfxb.zzs(new zzerh(zzeurVar, 0L, (ScheduledExecutorService) zzhfhVar.zzb()), new zzerh(new zzeuy(zzcke.zza(), (ScheduledExecutorService) zzhfhVar.zzb(), zzcgs.zzc(zzchvVar.zzbn)), ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzer)).longValue(), (ScheduledExecutorService) zzhfhVar.zzb()), new zzerh(zzetx.zza(zzckg.zza(), zzcgs.zzc(zzchvVar.zzbn), (ScheduledExecutorService) zzhfhVar.zzb(), zzfen.zzc(), zzevbVar.zza(), zzeve.zzc(zzevbVar), zzevg.zzc(zzevbVar)), 0L, (ScheduledExecutorService) zzhfhVar.zzb()), new zzerh(new zzevr(zzfen.zzc()), 0L, (ScheduledExecutorService) zzhfhVar.zzb()), new zzeuj(zzcka.zza(), zzfen.zzc(), zzcgs.zzc(zzchvVar.zzbn)), zzd(), zzc(), (zzesv) zzchvVar.zzbm.zzb(), zzeuh.zza(zzevc.zzc(zzevbVar), zzcjy.zza(), (zzbza) zzchvVar.zzaj.zzb(), (ScheduledExecutorService) zzhfhVar.zzb(), zzfen.zzc())), (zzfgn) this.zza.zzb(), (zzdre) zzchvVar.zzK.zzb());
    }

    final zzeub zzc() {
        zzevb zzevbVar = this.zzz;
        return new zzeub(zzckg.zza(), zzfen.zzc(), zzevbVar.zzf(), zzevbVar.zzd(), zzevbVar.zza());
    }

    final zzeuv zzd() {
        zzevb zzevbVar = this.zzz;
        zzbbr zzbbrVarZza = zzcjv.zza();
        zzgcd zzgcdVarZzc = zzfen.zzc();
        List listZzh = zzevbVar.zzh();
        zzhfg.zzb(listZzh);
        return new zzeuv(zzbbrVarZza, zzgcdVarZzc, listZzh);
    }

    @Override // com.google.android.gms.internal.ads.zzety
    public final zzfft zze() {
        return (zzfft) this.zzy.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzety
    public final zzfgn zzf() {
        return (zzfgn) this.zza.zzb();
    }
}
