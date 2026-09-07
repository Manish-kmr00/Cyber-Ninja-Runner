package com.google.android.gms.internal.ads;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcmu implements zzayh, zzcvx, com.google.android.gms.ads.internal.overlay.zzr, zzcvw {
    private final zzcmp zza;
    private final zzcmq zzb;
    private final zzbom zzd;
    private final Executor zze;
    private final Clock zzf;
    private final Set zzc = new HashSet();
    private final AtomicBoolean zzg = new AtomicBoolean(false);
    private final zzcmt zzh = new zzcmt();
    private boolean zzi = false;
    private WeakReference zzj = new WeakReference(this);

    public zzcmu(zzboj zzbojVar, zzcmq zzcmqVar, Executor executor, zzcmp zzcmpVar, Clock clock) {
        this.zza = zzcmpVar;
        this.zzd = zzbojVar.zza("google.afma.activeView.handleUpdate", zzbnx.zza, zzbnx.zza);
        this.zzb = zzcmqVar;
        this.zze = executor;
        this.zzf = clock;
    }

    private final void zzk() {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            this.zza.zzf((zzcel) it.next());
        }
        this.zza.zze();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdE() {
        this.zzh.zzb = false;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcvx
    public final synchronized void zzdh(Context context) {
        this.zzh.zze = ApsMetricsDataMap.APSMETRICS_FIELD_URL;
        zzg();
        zzk();
        this.zzi = true;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdi() {
        this.zzh.zzb = true;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcvx
    public final synchronized void zzdj(Context context) {
        this.zzh.zzb = true;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcvx
    public final synchronized void zzdk(Context context) {
        this.zzh.zzb = false;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    public final synchronized void zzdn(zzayg zzaygVar) {
        zzcmt zzcmtVar = this.zzh;
        zzcmtVar.zza = zzaygVar.zzj;
        zzcmtVar.zzf = zzaygVar;
        zzg();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdo() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdp() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdr() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzds(int i) {
    }

    public final synchronized void zzg() {
        if (this.zzj.get() == null) {
            zzj();
            return;
        }
        if (this.zzi || !this.zzg.get()) {
            return;
        }
        try {
            zzcmt zzcmtVar = this.zzh;
            zzcmtVar.zzd = this.zzf.elapsedRealtime();
            final JSONObject jSONObjectZza = this.zzb.zzb(zzcmtVar);
            for (final zzcel zzcelVar : this.zzc) {
                this.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcms
                    @Override // java.lang.Runnable
                    public final void run() {
                        JSONObject jSONObject = jSONObjectZza;
                        String str = "Calling AFMA_updateActiveView(" + jSONObject.toString() + ")";
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zze(str);
                        zzcelVar.zzp("AFMA_updateActiveView", jSONObject);
                    }
                });
            }
            zzbzn.zzb(this.zzd.zzc(jSONObjectZza), "ActiveViewListener.callActiveViewJs");
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Failed to call ActiveViewJS", e);
        }
    }

    public final synchronized void zzh(zzcel zzcelVar) {
        this.zzc.add(zzcelVar);
        this.zza.zzd(zzcelVar);
    }

    public final void zzi(Object obj) {
        this.zzj = new WeakReference(obj);
    }

    public final synchronized void zzj() {
        zzk();
        this.zzi = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final synchronized void zzs() {
        if (this.zzg.compareAndSet(false, true)) {
            this.zza.zzc(this);
            zzg();
        }
    }
}
