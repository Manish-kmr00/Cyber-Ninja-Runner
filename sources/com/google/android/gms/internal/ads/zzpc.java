package com.google.android.gms.internal.ads;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzpc extends AudioDeviceCallback {
    final /* synthetic */ zzpg zza;

    /* synthetic */ zzpc(zzpg zzpgVar, zzpf zzpfVar) {
        this.zza = zzpgVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzpg zzpgVar = this.zza;
        zzpgVar.zzj(zzpb.zzc(zzpgVar.zza, zzpgVar.zzh, zzpgVar.zzg));
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzpg zzpgVar = this.zza;
        zzph zzphVar = zzpgVar.zzg;
        int i = zzeu.zza;
        for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
            if (Objects.equals(audioDeviceInfo, zzphVar)) {
                zzpgVar.zzg = null;
                break;
            }
        }
        zzpgVar.zzj(zzpb.zzc(zzpgVar.zza, zzpgVar.zzh, zzpgVar.zzg));
    }
}
