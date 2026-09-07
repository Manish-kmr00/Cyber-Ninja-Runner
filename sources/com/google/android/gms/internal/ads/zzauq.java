package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzauq implements zzaut {
    private static zzauq zzb;
    private final Context zzc;
    private final zzfoe zzd;
    private final zzfol zze;
    private final zzfon zzf;
    private final zzavv zzg;
    private final zzfmr zzh;
    private final Executor zzi;
    private final zzfok zzj;
    private final zzawk zzl;
    private final zzawc zzm;
    private final zzavt zzn;
    private volatile boolean zzp;
    private volatile boolean zzq;
    private final int zzr;
    volatile long zza = 0;
    private final Object zzo = new Object();
    private final CountDownLatch zzk = new CountDownLatch(1);

    zzauq(Context context, zzfmr zzfmrVar, zzfoe zzfoeVar, zzfol zzfolVar, zzfon zzfonVar, zzavv zzavvVar, Executor executor, zzfmm zzfmmVar, int i, zzawk zzawkVar, zzawc zzawcVar, zzavt zzavtVar) {
        this.zzq = false;
        this.zzc = context;
        this.zzh = zzfmrVar;
        this.zzd = zzfoeVar;
        this.zze = zzfolVar;
        this.zzf = zzfonVar;
        this.zzg = zzavvVar;
        this.zzi = executor;
        this.zzr = i;
        this.zzl = zzawkVar;
        this.zzm = zzawcVar;
        this.zzn = zzavtVar;
        this.zzq = false;
        this.zzj = new zzauo(this, zzfmmVar);
    }

    public static synchronized zzauq zza(Context context, zzard zzardVar, boolean z) {
        zzfms zzfmsVarZzc;
        zzfmsVarZzc = zzfmt.zzc();
        zzfmsVarZzc.zza(zzardVar.zzf());
        zzfmsVarZzc.zzg(zzardVar.zzi());
        return zzs(context, Executors.newCachedThreadPool(), zzfmsVarZzc.zzh(), z);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00cf A[Catch: all -> 0x011b, zzgyk -> 0x011d, TryCatch #0 {zzgyk -> 0x011d, blocks: (B:6:0x0021, B:8:0x0033, B:12:0x0039, B:13:0x0045, B:15:0x0053, B:17:0x0061, B:20:0x006e, B:27:0x009d, B:31:0x00b6, B:37:0x00cf, B:38:0x00dc, B:40:0x00e2, B:42:0x00ea, B:43:0x00ec, B:34:0x00c0, B:35:0x00c7, B:23:0x0075, B:25:0x008b, B:44:0x00f6, B:45:0x0103, B:46:0x0110), top: B:56:0x0021, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f6 A[Catch: all -> 0x011b, zzgyk -> 0x011d, TryCatch #0 {zzgyk -> 0x011d, blocks: (B:6:0x0021, B:8:0x0033, B:12:0x0039, B:13:0x0045, B:15:0x0053, B:17:0x0061, B:20:0x006e, B:27:0x009d, B:31:0x00b6, B:37:0x00cf, B:38:0x00dc, B:40:0x00e2, B:42:0x00ea, B:43:0x00ec, B:34:0x00c0, B:35:0x00c7, B:23:0x0075, B:25:0x008b, B:44:0x00f6, B:45:0x0103, B:46:0x0110), top: B:56:0x0021, outer: #2 }] */
    static /* bridge */ /* synthetic */ void zzj(zzauq zzauqVar) {
        String str;
        String strZzj;
        int length;
        boolean zZza;
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzfod zzfodVarZzu = zzauqVar.zzu(1);
        if (zzfodVarZzu != null) {
            String strZzk = zzfodVarZzu.zza().zzk();
            strZzj = zzfodVarZzu.zza().zzj();
            str = strZzk;
        } else {
            str = null;
            strZzj = null;
        }
        try {
            try {
                Context context = zzauqVar.zzc;
                int i = zzauqVar.zzr;
                zzfmr zzfmrVar = zzauqVar.zzh;
                zzfoi zzfoiVarZza = zzfnb.zza(context, 1, i, str, strZzj, "1", zzfmrVar);
                byte[] bArr = zzfoiVarZza.zzb;
                if (bArr == null || (length = bArr.length) == 0) {
                    zzfmrVar.zzd(IronSourceConstants.errorCode_adClosed, System.currentTimeMillis() - jCurrentTimeMillis);
                } else {
                    try {
                        zzaxt zzaxtVarZzb = zzaxt.zzb(zzgwn.zzv(bArr, 0, length), zzgxf.zza());
                        if (zzaxtVarZzb.zzc().zzk().isEmpty() || zzaxtVarZzb.zzc().zzj().isEmpty() || zzaxtVarZzb.zzd().zzA().length == 0) {
                            zzauqVar.zzh.zzd(IronSourceConstants.errorCode_destroy, System.currentTimeMillis() - jCurrentTimeMillis);
                        } else {
                            zzfod zzfodVarZzu2 = zzauqVar.zzu(1);
                            if (zzfodVarZzu2 != null) {
                                zzaxw zzaxwVarZza = zzfodVarZzu2.zza();
                                if (zzaxtVarZzb.zzc().zzk().equals(zzaxwVarZza.zzk()) && zzaxtVarZzb.zzc().zzj().equals(zzaxwVarZza.zzj())) {
                                    zzauqVar.zzh.zzd(IronSourceConstants.errorCode_destroy, System.currentTimeMillis() - jCurrentTimeMillis);
                                }
                            }
                            zzfok zzfokVar = zzauqVar.zzj;
                            int i2 = zzfoiVarZza.zzc;
                            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcA)).booleanValue()) {
                                zZza = zzauqVar.zzd.zza(zzaxtVarZzb, zzfokVar);
                            } else if (i2 == 3) {
                                zZza = zzauqVar.zze.zza(zzaxtVarZzb);
                            } else if (i2 == 4) {
                                zZza = zzauqVar.zze.zzb(zzaxtVarZzb, zzfokVar);
                            } else {
                                zzauqVar.zzh.zzd(IronSourceConstants.NT_INSTANCE_SHOW, System.currentTimeMillis() - jCurrentTimeMillis);
                            }
                            if (zZza) {
                                zzfod zzfodVarZzu3 = zzauqVar.zzu(1);
                                if (zzfodVarZzu3 != null) {
                                    if (zzauqVar.zzf.zzc(zzfodVarZzu3)) {
                                        zzauqVar.zzq = true;
                                    }
                                    zzauqVar.zza = System.currentTimeMillis() / 1000;
                                }
                            } else {
                                zzauqVar.zzh.zzd(IronSourceConstants.NT_INSTANCE_SHOW, System.currentTimeMillis() - jCurrentTimeMillis);
                            }
                        }
                    } catch (NullPointerException unused) {
                        zzauqVar.zzh.zzd(IronSourceError.ERROR_OLD_API_INIT_IN_PROGRESS, System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                }
            } finally {
                zzauqVar.zzk.countDown();
            }
        } catch (zzgyk e) {
            zzauqVar.zzh.zzc(4002, System.currentTimeMillis() - jCurrentTimeMillis, e);
        }
    }

    private static synchronized zzauq zzs(Context context, Executor executor, zzfmt zzfmtVar, boolean z) {
        if (zzb == null) {
            zzfmr zzfmrVarZza = zzfmr.zza(context, executor, z);
            zzave zzaveVarZzc = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdD)).booleanValue() ? zzave.zzc(context) : null;
            zzawk zzawkVarZzd = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdE)).booleanValue() ? zzawk.zzd(context, executor) : null;
            zzawc zzawcVar = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcS)).booleanValue() ? new zzawc() : null;
            zzavt zzavtVar = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzda)).booleanValue() ? new zzavt() : null;
            zzfni zzfniVarZzc = zzfni.zzc(context, executor, zzfmrVarZza, zzfmtVar);
            zzavu zzavuVar = new zzavu(context);
            zzavv zzavvVar = new zzavv(zzfmtVar, zzfniVarZzc, new zzawi(context, zzavuVar), zzavuVar, zzaveVarZzc, zzawkVarZzd, zzawcVar, zzavtVar);
            int iZzb = zzfnr.zzb(context, zzfmrVarZza);
            zzfmm zzfmmVar = new zzfmm();
            zzauq zzauqVar = new zzauq(context, zzfmrVarZza, new zzfoe(context, iZzb), new zzfol(context, iZzb, new zzaun(zzfmrVarZza), ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcC)).booleanValue()), new zzfon(context, zzavvVar, zzfmrVarZza, zzfmmVar), zzavvVar, executor, zzfmmVar, iZzb, zzawkVarZzd, zzawcVar, zzavtVar);
            zzb = zzauqVar;
            zzauqVar.zzm();
            zzb.zzp();
        }
        return zzb;
    }

    private final void zzt() {
        zzawk zzawkVar = this.zzl;
        if (zzawkVar != null) {
            zzawkVar.zzh();
        }
    }

    private final zzfod zzu(int i) {
        if (zzfnr.zza(this.zzr)) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcA)).booleanValue() ? this.zze.zzc(1) : this.zzd.zzc(1);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final String zzd(Context context, String str, View view) {
        return zze(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final String zze(Context context, String str, View view, Activity activity) {
        zzt();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcS)).booleanValue()) {
            this.zzm.zzi();
        }
        zzp();
        zzfmu zzfmuVarZza = this.zzf.zza();
        if (zzfmuVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZza = zzfmuVarZza.zza(context, null, str, view, activity);
        this.zzh.zzf(5000, System.currentTimeMillis() - jCurrentTimeMillis, strZza, null);
        return strZza;
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final String zzf(Context context) {
        zzt();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcS)).booleanValue()) {
            this.zzm.zzj();
        }
        zzp();
        zzfmu zzfmuVarZza = this.zzf.zza();
        if (zzfmuVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzc = zzfmuVarZza.zzc(context, null);
        this.zzh.zzf(5001, System.currentTimeMillis() - jCurrentTimeMillis, strZzc, null);
        return strZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final String zzg(Context context) {
        return "19";
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final String zzh(Context context, View view, Activity activity) {
        zzt();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcS)).booleanValue()) {
            this.zzm.zzk(context, view);
        }
        zzp();
        zzfmu zzfmuVarZza = this.zzf.zza();
        if (zzfmuVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzb = zzfmuVarZza.zzb(context, null, view, activity);
        this.zzh.zzf(5002, System.currentTimeMillis() - jCurrentTimeMillis, strZzb, null);
        return strZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final void zzk(MotionEvent motionEvent) {
        zzfmu zzfmuVarZza = this.zzf.zza();
        if (zzfmuVarZza != null) {
            try {
                zzfmuVarZza.zzd(null, motionEvent);
            } catch (zzfom e) {
                this.zzh.zzc(e.zza(), -1L, e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final void zzl(int i, int i2, int i3) {
        DisplayMetrics displayMetrics;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmb)).booleanValue() || (displayMetrics = this.zzc.getResources().getDisplayMetrics()) == null) {
            return;
        }
        float f = i;
        float f2 = i2;
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 0, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain);
        motionEventObtain.recycle();
        MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, 0L, 2, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain2);
        motionEventObtain2.recycle();
        MotionEvent motionEventObtain3 = MotionEvent.obtain(0L, i3, 1, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain3);
        motionEventObtain3.recycle();
    }

    final synchronized void zzm() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzfod zzfodVarZzu = zzu(1);
        if (zzfodVarZzu == null) {
            this.zzh.zzd(4013, System.currentTimeMillis() - jCurrentTimeMillis);
        } else if (this.zzf.zzc(zzfodVarZzu)) {
            this.zzq = true;
            this.zzk.countDown();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzavt zzavtVar = this.zzn;
        if (zzavtVar != null) {
            zzavtVar.zzb(Arrays.asList(stackTraceElementArr));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final void zzo(View view) {
        this.zzg.zzd(view);
    }

    public final void zzp() {
        if (this.zzp) {
            return;
        }
        synchronized (this.zzo) {
            if (!this.zzp) {
                if ((System.currentTimeMillis() / 1000) - this.zza < 3600) {
                    return;
                }
                zzfod zzfodVarZzb = this.zzf.zzb();
                if ((zzfodVarZzb == null || zzfodVarZzb.zzd(3600L)) && zzfnr.zza(this.zzr)) {
                    this.zzi.execute(new zzaup(this));
                }
            }
        }
    }

    public final synchronized boolean zzr() {
        return this.zzq;
    }
}
