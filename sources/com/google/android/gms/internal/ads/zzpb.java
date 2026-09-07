package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioProfile;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import android.util.SparseArray;
import com.json.b9;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzpb {
    static final zzfwz zzb;
    private final SparseArray zzd = new SparseArray();
    private final int zze;
    public static final zzpb zza = new zzpb(zzfww.zzo(zzpa.zza));
    private static final zzfww zzc = zzfww.zzq(2, 5, 6);

    static {
        zzfwy zzfwyVar = new zzfwy();
        zzfwyVar.zza(5, 6);
        zzfwyVar.zza(17, 6);
        zzfwyVar.zza(7, 6);
        zzfwyVar.zza(30, 10);
        zzfwyVar.zza(18, 6);
        zzfwyVar.zza(6, 8);
        zzfwyVar.zza(8, 8);
        zzfwyVar.zza(14, 8);
        zzb = zzfwyVar.zzc();
    }

    private zzpb(List list) {
        for (int i = 0; i < list.size(); i++) {
            zzpa zzpaVar = (zzpa) list.get(i);
            this.zzd.put(zzpaVar.zzb, zzpaVar);
        }
        int iMax = 0;
        for (int i2 = 0; i2 < this.zzd.size(); i2++) {
            iMax = Math.max(iMax, ((zzpa) this.zzd.valueAt(i2)).zzc);
        }
        this.zze = iMax;
    }

    static Uri zza() {
        if (zzf()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    static zzpb zzc(Context context, zze zzeVar, zzph zzphVar) {
        return zzd(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), zzeVar, zzphVar);
    }

    static zzpb zzd(Context context, Intent intent, zze zzeVar, zzph zzphVar) {
        AudioManager audioManagerZzc = zzcj.zzc(context);
        if (zzphVar == null) {
            zzph zzphVar2 = null;
            if (zzeu.zza >= 33) {
                try {
                    AudioManager audioManager = audioManagerZzc;
                    List<AudioDeviceInfo> audioDevicesForAttributes = audioManagerZzc.getAudioDevicesForAttributes(zzeVar.zza().zza);
                    if (!audioDevicesForAttributes.isEmpty()) {
                        zzphVar2 = new zzph(audioDevicesForAttributes.get(0));
                    }
                } catch (RuntimeException unused) {
                }
            }
            zzphVar = zzphVar2;
        }
        int i = zzeu.zza;
        if (i >= 33 && (zzeu.zzN(context) || zzeu.zzJ(context))) {
            List<AudioProfile> directProfilesForAttributes = audioManagerZzc.getDirectProfilesForAttributes(zzeVar.zza().zza);
            HashMap map = new HashMap();
            map.put(2, new HashSet(zzfzz.zzh(12)));
            for (int i2 = 0; i2 < directProfilesForAttributes.size(); i2++) {
                AudioProfile audioProfile = directProfilesForAttributes.get(i2);
                if (audioProfile.getEncapsulationType() != 1) {
                    int format = audioProfile.getFormat();
                    if (zzeu.zzK(format) || zzb.containsKey(Integer.valueOf(format))) {
                        Integer numValueOf = Integer.valueOf(format);
                        if (map.containsKey(numValueOf)) {
                            Set set = (Set) map.get(numValueOf);
                            set.getClass();
                            set.addAll(zzfzz.zzh(audioProfile.getChannelMasks()));
                        } else {
                            map.put(numValueOf, new HashSet(zzfzz.zzh(audioProfile.getChannelMasks())));
                        }
                    }
                }
            }
            int i3 = zzfww.zzd;
            zzfwt zzfwtVar = new zzfwt();
            for (Map.Entry entry : map.entrySet()) {
                zzfwtVar.zzf(new zzpa(((Integer) entry.getKey()).intValue(), (Set) entry.getValue()));
            }
            return new zzpb(zzfwtVar.zzi());
        }
        AudioDeviceInfo[] devices = zzphVar == null ? audioManagerZzc.getDevices(2) : new AudioDeviceInfo[]{zzphVar.zza};
        zzfxa zzfxaVar = new zzfxa();
        zzfxaVar.zzg(8, 7);
        if (i >= 31) {
            zzfxaVar.zzg(26, 27);
        }
        int i4 = zzeu.zza;
        if (i4 >= 33) {
            zzfxaVar.zzf((Object) 30);
        }
        zzfxb zzfxbVarZzi = zzfxaVar.zzi();
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            if (zzfxbVarZzi.contains(Integer.valueOf(audioDeviceInfo.getType()))) {
                return zza;
            }
        }
        zzfxa zzfxaVar2 = new zzfxa();
        zzfxaVar2.zzf((Object) 2);
        if (i4 >= 29 && (zzeu.zzN(context) || zzeu.zzJ(context))) {
            int i5 = zzfww.zzd;
            zzfwt zzfwtVar2 = new zzfwt();
            zzfzc it = zzb.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (i4 >= zzeu.zzh(iIntValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), zzeVar.zza().zza)) {
                    zzfwtVar2.zzf(Integer.valueOf(iIntValue));
                }
            }
            zzfwtVar2.zzf((Object) 2);
            zzfxaVar2.zzh(zzfwtVar2.zzi());
            return new zzpb(zze(zzfzz.zzi(zzfxaVar2.zzi()), 10));
        }
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = Settings.Global.getInt(contentResolver, "use_external_surround_sound_flag", 0) == 1;
        if ((z || zzf()) && Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
            zzfxaVar2.zzh(zzc);
        }
        if (intent == null || z || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
            return new zzpb(zze(zzfzz.zzi(zzfxaVar2.zzi()), 10));
        }
        int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
        if (intArrayExtra != null) {
            zzfxaVar2.zzh(zzfzz.zzh(intArrayExtra));
        }
        return new zzpb(zze(zzfzz.zzi(zzfxaVar2.zzi()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)));
    }

    private static zzfww zze(int[] iArr, int i) {
        int i2 = zzfww.zzd;
        zzfwt zzfwtVar = new zzfwt();
        for (int i3 : iArr) {
            zzfwtVar.zzf(new zzpa(i3, i));
        }
        return zzfwtVar.zzi();
    }

    private static boolean zzf() {
        return Build.MANUFACTURER.equals("Amazon") || Build.MANUFACTURER.equals("Xiaomi");
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0045 A[RETURN] */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpb)) {
            return false;
        }
        zzpb zzpbVar = (zzpb) obj;
        SparseArray sparseArray = this.zzd;
        SparseArray<?> sparseArray2 = zzpbVar.zzd;
        if (zzeu.zza < 31) {
            int size = sparseArray.size();
            if (size == sparseArray2.size()) {
                for (int i = 0; i < size; i++) {
                    if (Objects.equals(sparseArray.valueAt(i), sparseArray2.get(sparseArray.keyAt(i)))) {
                    }
                }
                if (this.zze == zzpbVar.zze) {
                    return true;
                }
            }
        } else if (sparseArray.contentEquals(sparseArray2)) {
            if (this.zze == zzpbVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iContentHashCode;
        int i = zzeu.zza;
        SparseArray sparseArray = this.zzd;
        if (i >= 31) {
            iContentHashCode = sparseArray.contentHashCode();
        } else {
            int iKeyAt = 17;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                iKeyAt = (((iKeyAt * 31) + sparseArray.keyAt(i2)) * 31) + Objects.hashCode(sparseArray.valueAt(i2));
            }
            iContentHashCode = iKeyAt;
        }
        return this.zze + (iContentHashCode * 31);
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.zze + ", audioProfiles=" + this.zzd.toString() + b9.i.e;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0031  */
    /* JADX WARN: Code duplicated, block: B:14:0x0039  */
    /* JADX WARN: Code duplicated, block: B:15:0x003b  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d A[PHI: r1
  0x003d: PHI (r1v5 int) = (r1v4 int), (r1v9 int) binds: [B:11:0x002f, B:14:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:18:0x0041  */
    /* JADX WARN: Code duplicated, block: B:52:0x009f  */
    public final Pair zzb(zzz zzzVar, zze zzeVar) {
        String str = zzzVar.zzo;
        str.getClass();
        int iZza = zzay.zza(str, zzzVar.zzk);
        if (!zzb.containsKey(Integer.valueOf(iZza))) {
            return null;
        }
        int i = 6;
        if (iZza != 18) {
            if (iZza != 8) {
                if (iZza == 30 && !zzeu.zzH(this.zzd, 30)) {
                    iZza = 7;
                }
            } else if (zzeu.zzH(this.zzd, 8)) {
                iZza = 8;
                if (iZza == 30) {
                    iZza = 7;
                }
            } else {
                iZza = 7;
            }
        } else if (zzeu.zzH(this.zzd, 18)) {
            iZza = 18;
            if (iZza != 8) {
                if (iZza == 30) {
                    iZza = 7;
                }
            } else if (zzeu.zzH(this.zzd, 8)) {
                iZza = 8;
                if (iZza == 30) {
                    iZza = 7;
                }
            } else {
                iZza = 7;
            }
        } else {
            iZza = 6;
        }
        SparseArray sparseArray = this.zzd;
        if (!zzeu.zzH(sparseArray, iZza)) {
            return null;
        }
        zzpa zzpaVar = (zzpa) sparseArray.get(iZza);
        zzpaVar.getClass();
        int iZza2 = zzzVar.zzE;
        if (iZza2 == -1 || iZza == 18) {
            int i2 = zzzVar.zzF;
            if (i2 == -1) {
                i2 = 48000;
            }
            iZza2 = zzpaVar.zza(i2, zzeVar);
        } else if (!str.equals("audio/vnd.dts.uhd;profile=p2") || zzeu.zza >= 33) {
            if (!zzpaVar.zzb(iZza2)) {
                return null;
            }
        } else if (iZza2 > 10) {
            return null;
        }
        if (zzeu.zza > 28) {
            i = iZza2;
        } else if (iZza2 == 7) {
            i = 8;
        } else if (iZza2 != 3 && iZza2 != 4 && iZza2 != 5) {
            i = iZza2;
        }
        if (zzeu.zza <= 26 && "fugu".equals(Build.DEVICE) && i == 1) {
            i = 2;
        }
        int iZzi = zzeu.zzi(i);
        if (iZzi != 0) {
            return Pair.create(Integer.valueOf(iZza), Integer.valueOf(iZzi));
        }
        return null;
    }
}
