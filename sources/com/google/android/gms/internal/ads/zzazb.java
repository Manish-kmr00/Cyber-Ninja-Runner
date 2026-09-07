package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
@ParametersAreNonnullByDefault
public final class zzazb {
    private final Object zza = new Object();
    private zzayz zzb = null;
    private boolean zzc = false;

    public final Activity zza() {
        synchronized (this.zza) {
            zzayz zzayzVar = this.zzb;
            if (zzayzVar == null) {
                return null;
            }
            return zzayzVar.zza();
        }
    }

    public final Context zzb() {
        synchronized (this.zza) {
            zzayz zzayzVar = this.zzb;
            if (zzayzVar == null) {
                return null;
            }
            return zzayzVar.zzb();
        }
    }

    public final void zzc(zzaza zzazaVar) {
        synchronized (this.zza) {
            if (this.zzb == null) {
                this.zzb = new zzayz();
            }
            this.zzb.zzf(zzazaVar);
        }
    }

    public final void zzd(Context context) {
        synchronized (this.zza) {
            if (!this.zzc) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Can not cast Context to Application");
                } else {
                    if (this.zzb == null) {
                        this.zzb = new zzayz();
                    }
                    this.zzb.zzg(application, context);
                    this.zzc = true;
                }
            }
        }
    }

    public final void zze(zzaza zzazaVar) {
        synchronized (this.zza) {
            zzayz zzayzVar = this.zzb;
            if (zzayzVar == null) {
                return;
            }
            zzayzVar.zzh(zzazaVar);
        }
    }
}
