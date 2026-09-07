package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Handler;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzpg {
    private final Context zza;
    private final Handler zzb;
    private final zzpc zzc;
    private final BroadcastReceiver zzd;
    private final zzpd zze;
    private zzpb zzf;
    private zzph zzg;
    private zze zzh;
    private boolean zzi;
    private final zzqp zzj;

    zzpg(Context context, zzqp zzqpVar, zze zzeVar, zzph zzphVar) {
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        this.zzj = zzqpVar;
        this.zzh = zzeVar;
        this.zzg = zzphVar;
        Handler handler = new Handler(zzeu.zzz(), null);
        this.zzb = handler;
        this.zzc = new zzpc(this, 0 == true ? 1 : 0);
        this.zzd = new zzpe(this, 0 == true ? 1 : 0);
        Uri uriZza = zzpb.zza();
        this.zze = uriZza != null ? new zzpd(this, handler, applicationContext.getContentResolver(), uriZza) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj(zzpb zzpbVar) {
        if (!this.zzi || zzpbVar.equals(this.zzf)) {
            return;
        }
        this.zzf = zzpbVar;
        this.zzj.zza.zzJ(zzpbVar);
    }

    public final void zzg(zze zzeVar) {
        this.zzh = zzeVar;
        zzj(zzpb.zzc(this.zza, zzeVar, this.zzg));
    }

    public final void zzh(AudioDeviceInfo audioDeviceInfo) {
        zzph zzphVar = this.zzg;
        if (Objects.equals(audioDeviceInfo, zzphVar == null ? null : zzphVar.zza)) {
            return;
        }
        zzph zzphVar2 = audioDeviceInfo != null ? new zzph(audioDeviceInfo) : null;
        this.zzg = zzphVar2;
        zzj(zzpb.zzc(this.zza, this.zzh, zzphVar2));
    }

    public final void zzi() {
        if (this.zzi) {
            this.zzf = null;
            int i = zzeu.zza;
            zzpc zzpcVar = this.zzc;
            if (zzpcVar != null) {
                zzcj.zzc(this.zza).unregisterAudioDeviceCallback(zzpcVar);
            }
            this.zza.unregisterReceiver(this.zzd);
            zzpd zzpdVar = this.zze;
            if (zzpdVar != null) {
                zzpdVar.zzb();
            }
            this.zzi = false;
        }
    }

    public final zzpb zzc() {
        if (this.zzi) {
            zzpb zzpbVar = this.zzf;
            zzpbVar.getClass();
            return zzpbVar;
        }
        this.zzi = true;
        zzpd zzpdVar = this.zze;
        if (zzpdVar != null) {
            zzpdVar.zza();
        }
        int i = zzeu.zza;
        zzpc zzpcVar = this.zzc;
        if (zzpcVar != null) {
            Context context = this.zza;
            zzcj.zzc(context).registerAudioDeviceCallback(zzpcVar, this.zzb);
        }
        Context context2 = this.zza;
        zzpb zzpbVarZzd = zzpb.zzd(context2, context2.registerReceiver(this.zzd, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, this.zzb), this.zzh, this.zzg);
        this.zzf = zzpbVarZzd;
        return zzpbVarZzd;
    }
}
