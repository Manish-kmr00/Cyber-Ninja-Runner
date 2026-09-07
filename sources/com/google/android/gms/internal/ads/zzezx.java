package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzezx implements OnAdMetadataChangedListener, zzcwq, zzcvf, zzcvc, zzcvs, zzcxo, zzeyi, zzddc {
    private final zzfcy zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicReference zzh = new AtomicReference();
    private zzezx zzi = null;

    public zzezx(zzfcy zzfcyVar) {
        this.zza = zzfcyVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        zzezx zzezxVar = this.zzi;
        if (zzezxVar != null) {
            zzezxVar.onAdMetadataChanged();
        } else {
            zzexz.zza(this.zzb, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezl
                @Override // com.google.android.gms.internal.ads.zzexy
                public final void zza(Object obj) {
                    ((OnAdMetadataChangedListener) obj).onAdMetadataChanged();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zza() {
        zzezx zzezxVar = this.zzi;
        if (zzezxVar != null) {
            zzezxVar.zza();
            return;
        }
        this.zza.zza();
        zzexz.zza(this.zzd, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezt
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((zzbwg) obj).zzg();
            }
        });
        zzexz.zza(this.zze, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezu
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((zzbvq) obj).zzf();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddc
    public final void zzdd() {
        zzezx zzezxVar = this.zzi;
        if (zzezxVar != null) {
            zzezxVar.zzdd();
        } else {
            zzexz.zza(this.zzd, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezm
                @Override // com.google.android.gms.internal.ads.zzexy
                public final void zza(Object obj) throws RemoteException {
                    ((zzbwg) obj).zze();
                }
            });
        }
    }

    public final void zzg(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzb.set(onAdMetadataChangedListener);
    }

    @Override // com.google.android.gms.internal.ads.zzcxo
    public final void zzh(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzezx zzezxVar = this.zzi;
        if (zzezxVar != null) {
            zzezxVar.zzh(zztVar);
        } else {
            zzexz.zza(this.zzh, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezi
                @Override // com.google.android.gms.internal.ads.zzexy
                public final void zza(Object obj) throws RemoteException {
                    ((com.google.android.gms.ads.internal.client.zzdq) obj).zze(zztVar);
                }
            });
        }
    }

    public final void zzi(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        this.zzh.set(zzdqVar);
    }

    public final void zzj(zzbwg zzbwgVar) {
        this.zzd.set(zzbwgVar);
    }

    public final void zzk(zzbwk zzbwkVar) {
        this.zzc.set(zzbwkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeyi
    public final void zzl(zzeyi zzeyiVar) {
        this.zzi = (zzezx) zzeyiVar;
    }

    @Deprecated
    public final void zzm(zzbvq zzbvqVar) {
        this.zze.set(zzbvqVar);
    }

    @Deprecated
    public final void zzn(zzbvl zzbvlVar) {
        this.zzg.set(zzbvlVar);
    }

    public final void zzo(zzbwl zzbwlVar) {
        this.zzf.set(zzbwlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final void zzr(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzezx zzezxVar = this.zzi;
        if (zzezxVar != null) {
            zzezxVar.zzr(zzeVar);
            return;
        }
        AtomicReference atomicReference = this.zzd;
        zzexz.zza(atomicReference, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezn
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((zzbwg) obj).zzi(zzeVar);
            }
        });
        zzexz.zza(atomicReference, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezo
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((zzbwg) obj).zzh(zzeVar.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddc
    public final void zzu() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzb() {
        zzezx zzezxVar = this.zzi;
        if (zzezxVar != null) {
            zzezxVar.zzb();
        } else {
            zzexz.zza(this.zze, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezv
                @Override // com.google.android.gms.internal.ads.zzexy
                public final void zza(Object obj) throws RemoteException {
                    ((zzbvq) obj).zzh();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zze() {
        zzezx zzezxVar = this.zzi;
        if (zzezxVar != null) {
            zzezxVar.zze();
        } else {
            zzexz.zza(this.zze, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezp
                @Override // com.google.android.gms.internal.ads.zzexy
                public final void zza(Object obj) throws RemoteException {
                    ((zzbvq) obj).zzk();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzf() {
        zzezx zzezxVar = this.zzi;
        if (zzezxVar != null) {
            zzezxVar.zzf();
        } else {
            zzexz.zza(this.zze, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezb
                @Override // com.google.android.gms.internal.ads.zzexy
                public final void zza(Object obj) throws RemoteException {
                    ((zzbvq) obj).zzl();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzt() {
        zzezx zzezxVar = this.zzi;
        if (zzezxVar != null) {
            zzezxVar.zzt();
        } else {
            zzexz.zza(this.zzc, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezj
                @Override // com.google.android.gms.internal.ads.zzexy
                public final void zza(Object obj) throws RemoteException {
                    ((zzbwk) obj).zzg();
                }
            });
            zzexz.zza(this.zze, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezk
                @Override // com.google.android.gms.internal.ads.zzexy
                public final void zza(Object obj) throws RemoteException {
                    ((zzbvq) obj).zzi();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzc() {
        zzezx zzezxVar = this.zzi;
        if (zzezxVar != null) {
            zzezxVar.zzc();
            return;
        }
        AtomicReference atomicReference = this.zzd;
        zzexz.zza(atomicReference, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezf
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((zzbwg) obj).zzj();
            }
        });
        zzexz.zza(this.zze, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezg
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((zzbvq) obj).zzj();
            }
        });
        zzexz.zza(atomicReference, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezh
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((zzbwg) obj).zzf();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzdq(final zzbvk zzbvkVar, final String str, final String str2) {
        zzezx zzezxVar = this.zzi;
        if (zzezxVar != null) {
            zzezxVar.zzdq(zzbvkVar, str, str2);
            return;
        }
        zzexz.zza(this.zzd, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezw
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                zzbvk zzbvkVar2 = zzbvkVar;
                ((zzbwg) obj).zzk(new zzbwu(zzbvkVar2.zzc(), zzbvkVar2.zzb()));
            }
        });
        zzexz.zza(this.zzf, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezc
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                zzbvk zzbvkVar2 = zzbvkVar;
                ((zzbwl) obj).zze(new zzbwu(zzbvkVar2.zzc(), zzbvkVar2.zzb()), str, str2);
            }
        });
        zzexz.zza(this.zze, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezd
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((zzbvq) obj).zze(zzbvkVar);
            }
        });
        zzexz.zza(this.zzg, new zzexy() { // from class: com.google.android.gms.internal.ads.zzeze
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((zzbvl) obj).zze(zzbvkVar, str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvf
    public final void zzdz(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzezx zzezxVar = this.zzi;
        if (zzezxVar != null) {
            zzezxVar.zzdz(zzeVar);
            return;
        }
        final int i = zzeVar.zza;
        AtomicReference atomicReference = this.zzc;
        zzexz.zza(atomicReference, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezq
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((zzbwk) obj).zzf(zzeVar);
            }
        });
        zzexz.zza(atomicReference, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezr
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((zzbwk) obj).zze(i);
            }
        });
        zzexz.zza(this.zze, new zzexy() { // from class: com.google.android.gms.internal.ads.zzezs
            @Override // com.google.android.gms.internal.ads.zzexy
            public final void zza(Object obj) throws RemoteException {
                ((zzbvq) obj).zzg(i);
            }
        });
    }
}
