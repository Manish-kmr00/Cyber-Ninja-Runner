package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcne implements zzayh {
    private zzcel zza;
    private final Executor zzb;
    private final zzcmq zzc;
    private final Clock zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final zzcmt zzg = new zzcmt();

    public zzcne(Executor executor, zzcmq zzcmqVar, Clock clock) {
        this.zzb = executor;
        this.zzc = zzcmqVar;
        this.zzd = clock;
    }

    public static /* synthetic */ void zza(zzcne zzcneVar, JSONObject jSONObject) {
        String str = "Calling AFMA_updateActiveView(" + jSONObject.toString() + ")";
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zze(str);
        zzcneVar.zza.zzp("AFMA_updateActiveView", jSONObject);
    }

    private final void zzg() {
        try {
            final JSONObject jSONObjectZza = this.zzc.zzb(this.zzg);
            if (this.zza != null) {
                this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcnd
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcne.zza(this.zza, jSONObjectZza);
                    }
                });
            }
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Failed to call video active view js", e);
        }
    }

    public final void zzb() {
        this.zze = false;
    }

    public final void zzd() {
        this.zze = true;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    public final void zzdn(zzayg zzaygVar) {
        boolean z = this.zzf ? false : zzaygVar.zzj;
        zzcmt zzcmtVar = this.zzg;
        zzcmtVar.zza = z;
        zzcmtVar.zzd = this.zzd.elapsedRealtime();
        zzcmtVar.zzf = zzaygVar;
        if (this.zze) {
            zzg();
        }
    }

    public final void zze(boolean z) {
        this.zzf = z;
    }

    public final void zzf(zzcel zzcelVar) {
        this.zza = zzcelVar;
    }
}
