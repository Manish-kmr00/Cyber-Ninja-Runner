package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzjx;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzke;
import com.google.android.gms.internal.play_billing.zzki;
import com.google.android.gms.internal.play_billing.zzkl;
import com.google.android.gms.internal.play_billing.zzlo;
import com.google.android.gms.internal.play_billing.zzlq;
import com.google.android.gms.internal.play_billing.zzlu;
import com.vungle.ads.internal.protos.Sdk;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes7.dex */
final class zzba implements ServiceConnection {
    final /* synthetic */ BillingClientImpl zza;
    private final BillingClientStateListener zzb;

    /* synthetic */ zzba(BillingClientImpl billingClientImpl, BillingClientStateListener billingClientStateListener, zzbl zzblVar) {
        this.zza = billingClientImpl;
        this.zzb = billingClientStateListener;
    }

    private final void zzc(BillingResult billingResult) {
        synchronized (this.zza.zza) {
            if (this.zza.zzb == 3) {
                return;
            }
            this.zzb.onBillingSetupFinished(billingResult);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Billing service died.");
        try {
            if (BillingClientImpl.zzaq(this.zza)) {
                zzch zzchVar = this.zza.zzg;
                zzjx zzjxVarZzc = zzjz.zzc();
                zzjxVarZzc.zzn(6);
                zzke zzkeVarZzc = zzki.zzc();
                zzkeVarZzc.zzo(Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
                zzjxVarZzc.zza(zzkeVarZzc);
                zzchVar.zza((zzjz) zzjxVarZzc.zzf());
            } else {
                this.zza.zzg.zze(zzkl.zzB());
            }
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
        synchronized (this.zza.zza) {
            if (this.zza.zzb != 3 && this.zza.zzb != 0) {
                this.zza.zzaJ(0);
                this.zza.zzaL();
                this.zzb.onBillingServiceDisconnected();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Billing service connected.");
        synchronized (this.zza.zza) {
            if (this.zza.zzb == 3) {
                return;
            }
            this.zza.zzh = com.google.android.gms.internal.play_billing.zzam.zzu(iBinder);
            BillingClientImpl billingClientImpl = this.zza;
            if (BillingClientImpl.zzE(new Callable() { // from class: com.android.billingclient.api.zzay
                @Override // java.util.concurrent.Callable
                public final Object call() throws Exception {
                    this.zza.zza();
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzaz
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb();
                }
            }, billingClientImpl.zzax(), billingClientImpl.zzaD()) == null) {
                BillingClientImpl billingClientImpl2 = this.zza;
                BillingResult billingResultZzaA = billingClientImpl2.zzaA();
                billingClientImpl2.zzbe(25, 6, billingResultZzaA);
                zzc(billingResultZzaA);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Billing service disconnected.");
        try {
            if (BillingClientImpl.zzaq(this.zza)) {
                zzch zzchVar = this.zza.zzg;
                zzjx zzjxVarZzc = zzjz.zzc();
                zzjxVarZzc.zzn(6);
                zzke zzkeVarZzc = zzki.zzc();
                zzkeVarZzc.zzo(Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
                zzjxVarZzc.zza(zzkeVarZzc);
                zzchVar.zza((zzjz) zzjxVarZzc.zzf());
            } else {
                this.zza.zzg.zzg(zzlu.zzB());
            }
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
        synchronized (this.zza.zza) {
            if (this.zza.zzb == 3) {
                return;
            }
            this.zza.zzaJ(0);
            this.zzb.onBillingServiceDisconnected();
        }
    }

    /* JADX WARN: Code duplicated, block: B:158:0x0271  */
    /* JADX WARN: Code duplicated, block: B:159:0x0276  */
    final /* synthetic */ Object zza() throws Exception {
        Bundle bundle;
        boolean z;
        int i;
        int i2;
        String strZza;
        int iZzy;
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        synchronized (this.zza.zza) {
            if (this.zza.zzb != 3) {
                int i3 = this.zza.zzb;
                if (TextUtils.isEmpty(null)) {
                    bundle = null;
                } else {
                    bundle = new Bundle();
                    bundle.putString("accountName", null);
                    BillingClientImpl billingClientImpl = this.zza;
                    com.google.android.gms.internal.play_billing.zze.zzc(bundle, billingClientImpl.zzc, billingClientImpl.zzF.longValue());
                }
                try {
                    synchronized (this.zza.zza) {
                        zzanVar = this.zza.zzh;
                    }
                    if (zzanVar == null) {
                        this.zza.zzaJ(0);
                        this.zza.zzbe(Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 6, zzcj.zzm);
                        zzc(zzcj.zzm);
                    } else {
                        String packageName = this.zza.zzf.getPackageName();
                        iZzy = 3;
                        int i4 = 23;
                        while (true) {
                            if (i4 < 3) {
                                i4 = 0;
                                break;
                            }
                            iZzy = bundle == null ? zzanVar.zzy(i4, packageName, "subs") : zzanVar.zzc(i4, packageName, "subs", bundle);
                            if (iZzy == 0) {
                                com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "highestLevelSupportedForSubs: " + i4);
                                break;
                            }
                            i4--;
                        }
                        this.zza.zzk = i4 >= 5;
                        this.zza.zzj = i4 >= 3;
                        if (i4 < 3) {
                            com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "In-app billing API does not support subscription on this device.");
                            i = 9;
                        } else {
                            i = 1;
                        }
                        for (int i5 = 23; i5 >= 3; i5--) {
                            iZzy = bundle == null ? zzanVar.zzy(i5, packageName, "inapp") : zzanVar.zzc(i5, packageName, "inapp", bundle);
                            if (iZzy == 0) {
                                this.zza.zzl = i5;
                                com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "mHighestLevelSupportedForInApp: " + this.zza.zzl);
                                break;
                            }
                        }
                        BillingClientImpl billingClientImpl2 = this.zza;
                        billingClientImpl2.zzA = billingClientImpl2.zzl >= 23;
                        BillingClientImpl billingClientImpl3 = this.zza;
                        billingClientImpl3.zzz = billingClientImpl3.zzl >= 22;
                        BillingClientImpl billingClientImpl4 = this.zza;
                        billingClientImpl4.zzy = billingClientImpl4.zzl >= 21;
                        BillingClientImpl billingClientImpl5 = this.zza;
                        billingClientImpl5.zzx = billingClientImpl5.zzl >= 20;
                        BillingClientImpl billingClientImpl6 = this.zza;
                        billingClientImpl6.zzw = billingClientImpl6.zzl >= 19;
                        BillingClientImpl billingClientImpl7 = this.zza;
                        billingClientImpl7.zzv = billingClientImpl7.zzl >= 18;
                        BillingClientImpl billingClientImpl8 = this.zza;
                        billingClientImpl8.zzu = billingClientImpl8.zzl >= 17;
                        BillingClientImpl billingClientImpl9 = this.zza;
                        billingClientImpl9.zzt = billingClientImpl9.zzl >= 16;
                        BillingClientImpl billingClientImpl10 = this.zza;
                        billingClientImpl10.zzs = billingClientImpl10.zzl >= 15;
                        BillingClientImpl billingClientImpl11 = this.zza;
                        billingClientImpl11.zzr = billingClientImpl11.zzl >= 14;
                        BillingClientImpl billingClientImpl12 = this.zza;
                        billingClientImpl12.zzq = billingClientImpl12.zzl >= 12;
                        BillingClientImpl billingClientImpl13 = this.zza;
                        billingClientImpl13.zzp = billingClientImpl13.zzl >= 10;
                        BillingClientImpl billingClientImpl14 = this.zza;
                        billingClientImpl14.zzo = billingClientImpl14.zzl >= 9;
                        BillingClientImpl billingClientImpl15 = this.zza;
                        billingClientImpl15.zzn = billingClientImpl15.zzl >= 8;
                        BillingClientImpl billingClientImpl16 = this.zza;
                        billingClientImpl16.zzm = billingClientImpl16.zzl >= 6;
                        if (this.zza.zzl < 3) {
                            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "In-app billing API version 3 is not supported on this device.");
                            i = 36;
                        }
                        if (iZzy == 0) {
                            synchronized (this.zza.zza) {
                                if (this.zza.zzb != 3) {
                                    z = i3 != 1;
                                    this.zza.zzaJ(2);
                                    zzn zznVar = this.zza.zze != null ? this.zza.zze : null;
                                    if (zznVar != null) {
                                        zznVar.zzg(this.zza.zzy);
                                    }
                                }
                            }
                        } else {
                            z = i3 != 1;
                            this.zza.zzaJ(0);
                        }
                        strZza = null;
                        if (iZzy == 0) {
                            try {
                                if (true != z) {
                                    this.zza.zzbg(6);
                                } else {
                                    zzch zzchVar = this.zza.zzg;
                                    zzlo zzloVarZzc = zzlq.zzc();
                                    zzke zzkeVarZzc = zzki.zzc();
                                    zzkeVarZzc.zzn(0);
                                    zzloVarZzc.zza(zzkeVarZzc);
                                    zzchVar.zzf((zzlq) zzloVarZzc.zzf());
                                }
                            } catch (Throwable th) {
                                com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
                            }
                            zzc(zzcj.zzl);
                        } else {
                            BillingResult billingResult = zzcj.zza;
                            try {
                                if (true != z) {
                                    this.zza.zzbf(i, 6, billingResult, strZza);
                                } else {
                                    zzke zzkeVarZzc2 = zzki.zzc();
                                    zzkeVarZzc2.zzn(billingResult.getResponseCode());
                                    zzkeVarZzc2.zzm(billingResult.getDebugMessage());
                                    zzkeVarZzc2.zzo(i);
                                    if (strZza != null) {
                                        zzkeVarZzc2.zza(strZza);
                                    }
                                    zzch zzchVar2 = this.zza.zzg;
                                    zzlo zzloVarZzc2 = zzlq.zzc();
                                    zzloVarZzc2.zzm((zzki) zzkeVarZzc2.zzf());
                                    zzchVar2.zzf((zzlq) zzloVarZzc2.zzf());
                                }
                            } catch (Throwable th2) {
                                com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th2);
                            }
                            zzc(zzcj.zza);
                        }
                    }
                } catch (Exception e) {
                    z = i3 != 1;
                    com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Exception while checking if billing is supported; try to reconnect", e);
                    if (e instanceof DeadObjectException) {
                        i2 = 101;
                    } else if (e instanceof RemoteException) {
                        i2 = 100;
                    } else {
                        if (e instanceof SecurityException) {
                            i2 = 102;
                        } else {
                            i = 42;
                        }
                        if (i == 42) {
                            strZza = zzcg.zza(e);
                        } else {
                            strZza = null;
                        }
                        this.zza.zzaJ(0);
                        iZzy = 6;
                    }
                    i = i2;
                    if (i == 42) {
                        strZza = zzcg.zza(e);
                    } else {
                        strZza = null;
                    }
                    this.zza.zzaJ(0);
                    iZzy = 6;
                }
            }
        }
        return null;
    }

    final /* synthetic */ void zzb() {
        this.zza.zzaJ(0);
        this.zza.zzbe(24, 6, zzcj.zzn);
        zzc(zzcj.zzn);
    }
}
