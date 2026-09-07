package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzejr implements AppEventListener, zzcya, zzcwq, zzcvf, zzcvw, com.google.android.gms.ads.internal.client.zza, zzcvc, zzcxo, zzcvs, zzddc {
    final zzdre zza;
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicBoolean zzh = new AtomicBoolean(true);
    private final AtomicBoolean zzi = new AtomicBoolean(false);
    private final AtomicBoolean zzj = new AtomicBoolean(false);
    final BlockingQueue zzb = new ArrayBlockingQueue(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziV)).intValue());

    public zzejr(zzdre zzdreVar) {
        this.zza = zzdreVar;
    }

    private final void zzo() {
        if (this.zzi.get() && this.zzj.get()) {
            BlockingQueue<Pair> blockingQueue = this.zzb;
            for (final Pair pair : blockingQueue) {
                zzexz.zza(this.zzd, new zzexy() { // from class: com.google.android.gms.internal.ads.zzejc
                    @Override // com.google.android.gms.internal.ads.zzexy
                    public final void zza(Object obj) throws RemoteException {
                        Pair pair2 = pair;
                        ((com.google.android.gms.ads.internal.client.zzcl) obj).zzc((String) pair2.first, (String) pair2.second);
                    }
                });
            }
            blockingQueue.clear();
            this.zzh.set(false);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkQ)).booleanValue()) {
            return;
        }
        zzexz.zza(this.zzc, new zzejp());
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final synchronized void onAppEvent(final String str, final String str2) {
        if (!this.zzh.get()) {
            zzexz.zza(this.zzd, new zzexy() { // from class: com.google.android.gms.internal.ads.zzejj
                @Override // com.google.android.gms.internal.ads.zzexy
                public final void zza(Object obj) throws RemoteException {
                    ((com.google.android.gms.ads.internal.client.zzcl) obj).zzc(str, str2);
                }
            });
            return;
        }
        if (!this.zzb.offer(new Pair(str, str2))) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("The queue for app events is full, dropping the new event.");
            zzdre zzdreVar = this.zza;
            if (zzdreVar != null) {
                zzdrd zzdrdVarZza = zzdreVar.zza();
                zzdrdVarZza.zzb("action", "dae_action");
                zzdrdVarZza.zzb("dae_name", str);
                zzdrdVarZza.zzb("dae_data", str2);
                zzdrdVarZza.zzj();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zza() {
        zzexz.zza(this.zzc, new zzexy() { // from class: com.google.android.gms.internal.ads.zzeiz
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zzd();
            }
        });
        zzexz.zza(this.zzg, new zzexy() { // from class: com.google.android.gms.internal.ads.zzeja
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzcs) obj).zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzb() {
        zzexz.zza(this.zzc, new zzexy() { // from class: com.google.android.gms.internal.ads.zzejk
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zzh();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzc() {
        zzexz.zza(this.zzc, new zzexy() { // from class: com.google.android.gms.internal.ads.zzejm
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zzj();
            }
        });
        zzexy zzexyVar = new zzexy() { // from class: com.google.android.gms.internal.ads.zzejn
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzcs) obj).zzf();
            }
        };
        AtomicReference atomicReference = this.zzg;
        zzexz.zza(atomicReference, zzexyVar);
        zzexz.zza(atomicReference, new zzexy() { // from class: com.google.android.gms.internal.ads.zzejo
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzcs) obj).zze();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddc
    public final void zzdd() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkQ)).booleanValue()) {
            zzexz.zza(this.zzc, new zzejp());
        }
        zzexz.zza(this.zzg, new zzexy() { // from class: com.google.android.gms.internal.ads.zzejb
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzcs) obj).zzb();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdl(zzbuy zzbuyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdm(zzfbg zzfbgVar) {
        this.zzh.set(true);
        this.zzj.set(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzdq(zzbvk zzbvkVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcvf
    public final void zzdz(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzexy zzexyVar = new zzexy() { // from class: com.google.android.gms.internal.ads.zzejd
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zzf(zzeVar);
            }
        };
        AtomicReference atomicReference = this.zzc;
        zzexz.zza(atomicReference, zzexyVar);
        zzexz.zza(atomicReference, new zzexy() { // from class: com.google.android.gms.internal.ads.zzeje
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zze(zzeVar.zza);
            }
        });
        zzexz.zza(this.zzf, new zzexy() { // from class: com.google.android.gms.internal.ads.zzejf
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzbn) obj).zzb(zzeVar);
            }
        });
        this.zzh.set(false);
        this.zzb.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzf() {
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzbk zzg() {
        return (com.google.android.gms.ads.internal.client.zzbk) this.zzc.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcxo
    public final void zzh(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzexz.zza(this.zze, new zzexy() { // from class: com.google.android.gms.internal.ads.zzejq
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzdq) obj).zze(zztVar);
            }
        });
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzcl zzi() {
        return (com.google.android.gms.ads.internal.client.zzcl) this.zzd.get();
    }

    public final void zzj(com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        this.zzc.set(zzbkVar);
    }

    public final void zzk(com.google.android.gms.ads.internal.client.zzbn zzbnVar) {
        this.zzf.set(zzbnVar);
    }

    public final void zzl(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        this.zze.set(zzdqVar);
    }

    public final void zzm(com.google.android.gms.ads.internal.client.zzcl zzclVar) {
        this.zzd.set(zzclVar);
        this.zzi.set(true);
        zzo();
    }

    public final void zzn(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        this.zzg.set(zzcsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final void zzr(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzexz.zza(this.zzg, new zzexy() { // from class: com.google.android.gms.internal.ads.zzeji
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzcs) obj).zzd(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final void zzs() {
        zzexz.zza(this.zzc, new zzexy() { // from class: com.google.android.gms.internal.ads.zzeiy
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zzg();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final synchronized void zzt() {
        zzexz.zza(this.zzc, new zzexy() { // from class: com.google.android.gms.internal.ads.zzejg
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zzi();
            }
        });
        zzexz.zza(this.zzf, new zzexy() { // from class: com.google.android.gms.internal.ads.zzejh
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzbn) obj).zzc();
            }
        });
        this.zzj.set(true);
        zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzddc
    public final void zzu() {
        zzexz.zza(this.zzc, new zzexy() { // from class: com.google.android.gms.internal.ads.zzejl
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zzk();
            }
        });
    }
}
