package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzcoc extends zzcnz {
    private final Context zzc;
    private final View zzd;
    private final zzcel zze;
    private final zzfav zzf;
    private final zzcqe zzg;
    private final zzdib zzh;
    private final zzdde zzi;
    private final zzhes zzj;
    private final Executor zzk;
    private com.google.android.gms.ads.internal.client.zzr zzl;

    zzcoc(zzcqf zzcqfVar, Context context, zzfav zzfavVar, View view, zzcel zzcelVar, zzcqe zzcqeVar, zzdib zzdibVar, zzdde zzddeVar, zzhes zzhesVar, Executor executor) {
        super(zzcqfVar);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzcelVar;
        this.zzf = zzfavVar;
        this.zzg = zzcqeVar;
        this.zzh = zzdibVar;
        this.zzi = zzddeVar;
        this.zzj = zzhesVar;
        this.zzk = executor;
    }

    public static /* synthetic */ void zzj(zzcoc zzcocVar) {
        zzbhe zzbheVarZze = zzcocVar.zzh.zze();
        if (zzbheVarZze == null) {
            return;
        }
        try {
            zzbheVarZze.zze((com.google.android.gms.ads.internal.client.zzbx) zzcocVar.zzj.zzb(), ObjectWrapper.wrap(zzcocVar.zzc));
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("RemoteException when notifyAdLoad is called", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcnz
    public final int zza() {
        return this.zza.zzb.zzb.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcnz
    public final int zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhU)).booleanValue() && this.zzb.zzag) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhV)).booleanValue()) {
                return 0;
            }
        }
        return this.zza.zzb.zzb.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcnz
    public final View zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcnz
    public final com.google.android.gms.ads.internal.client.zzea zze() {
        try {
            return this.zzg.zza();
        } catch (zzfbw unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcnz
    public final zzfav zzf() {
        com.google.android.gms.ads.internal.client.zzr zzrVar = this.zzl;
        if (zzrVar != null) {
            return zzfbv.zzb(zzrVar);
        }
        zzfau zzfauVar = this.zzb;
        if (zzfauVar.zzac) {
            for (String str : zzfauVar.zza) {
                if (str == null || !str.contains("FirstParty")) {
                }
            }
            View view = this.zzd;
            return new zzfav(view.getWidth(), view.getHeight(), false);
        }
        return (zzfav) zzfauVar.zzr.get(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcnz
    public final zzfav zzg() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzcnz
    public final void zzh() {
        this.zzi.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcnz
    public final void zzi(ViewGroup viewGroup, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        zzcel zzcelVar;
        if (viewGroup == null || (zzcelVar = this.zze) == null) {
            return;
        }
        zzcelVar.zzaj(zzcgf.zzc(zzrVar));
        viewGroup.setMinimumHeight(zzrVar.zzc);
        viewGroup.setMinimumWidth(zzrVar.zzf);
        this.zzl = zzrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqg
    public final void zzk() {
        this.zzk.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcob
            @Override // java.lang.Runnable
            public final void run() {
                zzcoc.zzj(this.zza);
            }
        });
        super.zzk();
    }
}
