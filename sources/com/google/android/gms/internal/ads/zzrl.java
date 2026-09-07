package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.adjust.sdk.Constants;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzrl extends zztg implements zzkv {
    private final Context zzb;
    private final zzpx zzc;
    private final zzqf zzd;
    private final zzss zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private zzz zzi;
    private zzz zzj;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private int zzo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzrl(Context context, zzsu zzsuVar, zzti zztiVar, boolean z, Handler handler, zzpy zzpyVar, zzqf zzqfVar) {
        super(1, zzsuVar, zztiVar, false, 44100.0f);
        zzrk zzrkVar = null;
        zzss zzssVar = zzeu.zza >= 35 ? new zzss(zzsr.zza) : null;
        this.zzb = context.getApplicationContext();
        this.zzd = zzqfVar;
        this.zze = zzssVar;
        this.zzo = -1000;
        this.zzc = new zzpx(handler, zzpyVar);
        zzqfVar.zzq(new zzrj(this, zzrkVar));
    }

    private final int zzaR(zzsz zzszVar, zzz zzzVar) {
        if (!"OMX.google.raw.decoder".equals(zzszVar.zza) || zzeu.zza >= 24 || (zzeu.zza == 23 && zzeu.zzN(this.zzb))) {
            return zzzVar.zzp;
        }
        return -1;
    }

    private static List zzaS(zzti zztiVar, zzz zzzVar, boolean z, zzqf zzqfVar) throws zztn {
        zzsz zzszVarZza;
        if (zzzVar.zzo == null) {
            return zzfww.zzn();
        }
        return (!zzqfVar.zzA(zzzVar) || (zzszVarZza = zztt.zza()) == null) ? zztt.zze(zztiVar, zzzVar, false, false) : zzfww.zzo(zzszVarZza);
    }

    private final void zzaT() {
        long jZzb = this.zzd.zzb(zzW());
        if (jZzb != Long.MIN_VALUE) {
            if (!this.zzl) {
                jZzb = Math.max(this.zzk, jZzb);
            }
            this.zzk = jZzb;
            this.zzl = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    protected final void zzA() {
        zzss zzssVar;
        this.zzd.zzk();
        if (zzeu.zza < 35 || (zzssVar = this.zze) == null) {
            return;
        }
        zzssVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zztg, com.google.android.gms.internal.ads.zzhx
    protected final void zzC() {
        this.zzn = false;
        try {
            super.zzC();
            if (this.zzm) {
            }
        } finally {
            if (this.zzm) {
                this.zzm = false;
                this.zzd.zzl();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    protected final void zzD() {
        this.zzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    protected final void zzE() {
        zzaT();
        this.zzd.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzlx
    public final String zzU() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zztg, com.google.android.gms.internal.ads.zzlu
    public final boolean zzW() {
        return super.zzW() && this.zzd.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zztg, com.google.android.gms.internal.ads.zzlu
    public final boolean zzX() {
        return this.zzd.zzy() || super.zzX();
    }

    @Override // com.google.android.gms.internal.ads.zztg
    protected final float zzZ(float f, zzz zzzVar, zzz[] zzzVarArr) {
        int iMax = -1;
        for (zzz zzzVar2 : zzzVarArr) {
            int i = zzzVar2.zzF;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f;
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final long zza() {
        if (zzcT() == 2) {
            zzaT();
        }
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zztg
    protected final int zzaa(zzti zztiVar, zzz zzzVar) throws zztn {
        int i;
        boolean z;
        String str = zzzVar.zzo;
        if (!zzay.zzh(str)) {
            return 128;
        }
        int i2 = zzzVar.zzL;
        boolean zZzaQ = zzaQ(zzzVar);
        int i3 = 1;
        if (!zZzaQ || (i2 != 0 && zztt.zza() == null)) {
            i = 0;
        } else {
            zzqf zzqfVar = this.zzd;
            zzpk zzpkVarZzd = zzqfVar.zzd(zzzVar);
            if (zzpkVarZzd.zzb) {
                i = true != zzpkVarZzd.zzc ? 512 : 1536;
                if (zzpkVarZzd.zzd) {
                    i |= 2048;
                }
            } else {
                i = 0;
            }
            if (zzqfVar.zzA(zzzVar)) {
                return i | 172;
            }
        }
        if (!"audio/raw".equals(str) || this.zzd.zzA(zzzVar)) {
            zzqf zzqfVar2 = this.zzd;
            if (zzqfVar2.zzA(zzeu.zzA(2, zzzVar.zzE, zzzVar.zzF))) {
                List listZzaS = zzaS(zztiVar, zzzVar, false, zzqfVar2);
                if (!listZzaS.isEmpty()) {
                    if (zZzaQ) {
                        zzsz zzszVar = (zzsz) listZzaS.get(0);
                        boolean zZze = zzszVar.zze(zzzVar);
                        if (!zZze) {
                            int i4 = 1;
                            while (true) {
                                if (i4 >= listZzaS.size()) {
                                    z = true;
                                    break;
                                }
                                zzsz zzszVar2 = (zzsz) listZzaS.get(i4);
                                if (zzszVar2.zze(zzzVar)) {
                                    z = false;
                                    zZze = true;
                                    zzszVar = zzszVar2;
                                    break;
                                }
                                i4++;
                            }
                        } else {
                            z = true;
                            break;
                        }
                        int i5 = true != zZze ? 3 : 4;
                        int i6 = 8;
                        if (zZze && zzszVar.zzf(zzzVar)) {
                            i6 = 16;
                        }
                        return i5 | i6 | 32 | (true != zzszVar.zzg ? 0 : 64) | (true != z ? 0 : 128) | i;
                    }
                    i3 = 2;
                }
            }
        }
        return i3 | 128;
    }

    @Override // com.google.android.gms.internal.ads.zztg
    protected final zzhz zzab(zzsz zzszVar, zzz zzzVar, zzz zzzVar2) {
        int i;
        int i2;
        zzhz zzhzVarZzb = zzszVar.zzb(zzzVar, zzzVar2);
        int i3 = zzhzVarZzb.zze;
        if (zzaM(zzzVar2)) {
            i3 |= 32768;
        }
        if (zzaR(zzszVar, zzzVar2) > this.zzf) {
            i3 |= 64;
        }
        String str = zzszVar.zza;
        if (i3 != 0) {
            i2 = i3;
            i = 0;
        } else {
            i = zzhzVarZzb.zzd;
            i2 = 0;
        }
        return new zzhz(str, zzzVar, zzzVar2, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zztg
    protected final zzst zzaf(zzsz zzszVar, zzz zzzVar, MediaCrypto mediaCrypto, float f) {
        zzz[] zzzVarArrZzT = zzT();
        int length = zzzVarArrZzT.length;
        int iZzaR = zzaR(zzszVar, zzzVar);
        if (length != 1) {
            for (zzz zzzVar2 : zzzVarArrZzT) {
                if (zzszVar.zzb(zzzVar, zzzVar2).zzd != 0) {
                    iZzaR = Math.max(iZzaR, zzaR(zzszVar, zzzVar2));
                }
            }
        }
        this.zzf = iZzaR;
        String str = zzszVar.zza;
        int i = zzeu.zza;
        this.zzg = i < 24 && "OMX.SEC.aac.dec".equals(str) && Constants.REFERRER_API_SAMSUNG.equals(Build.MANUFACTURER) && (Build.DEVICE.startsWith("zeroflte") || Build.DEVICE.startsWith("herolte") || Build.DEVICE.startsWith("heroqlte"));
        this.zzh = str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder");
        String str2 = zzszVar.zzc;
        int i2 = this.zzf;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str2);
        int i3 = zzzVar.zzE;
        mediaFormat.setInteger("channel-count", i3);
        int i4 = zzzVar.zzF;
        mediaFormat.setInteger("sample-rate", i4);
        zzea.zzb(mediaFormat, zzzVar.zzr);
        zzea.zza(mediaFormat, "max-input-size", i2);
        mediaFormat.setInteger(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, 0);
        if (f != -1.0f && (i != 23 || (!"ZTE B2017G".equals(Build.MODEL) && !"AXON 7 mini".equals(Build.MODEL)))) {
            mediaFormat.setFloat("operating-rate", f);
        }
        int i5 = zzeu.zza;
        if (i5 <= 28 && "audio/ac4".equals(zzzVar.zzo)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i5 >= 24 && this.zzd.zza(zzeu.zzA(4, i3, i4)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i5 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        if (i5 >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.zzo));
        }
        this.zzj = (!"audio/raw".equals(zzszVar.zzb) || "audio/raw".equals(zzzVar.zzo)) ? null : zzzVar;
        return zzst.zza(zzszVar, mediaFormat, zzzVar, null, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zztg
    protected final List zzag(zzti zztiVar, zzz zzzVar, boolean z) throws zztn {
        return zztt.zzf(zzaS(zztiVar, zzzVar, false, this.zzd), zzzVar);
    }

    @Override // com.google.android.gms.internal.ads.zztg
    protected final void zzaj(zzhn zzhnVar) {
        zzz zzzVar;
        if (zzeu.zza < 29 || (zzzVar = zzhnVar.zza) == null || !Objects.equals(zzzVar.zzo, "audio/opus") || !zzaL()) {
            return;
        }
        ByteBuffer byteBuffer = zzhnVar.zzf;
        byteBuffer.getClass();
        zzz zzzVar2 = zzhnVar.zza;
        zzzVar2.getClass();
        int i = zzzVar2.zzH;
        if (byteBuffer.remaining() == 8) {
            this.zzd.zzr(i, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
        }
    }

    @Override // com.google.android.gms.internal.ads.zztg
    protected final void zzak(Exception exc) {
        zzdx.zzd("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zzm(exc);
    }

    @Override // com.google.android.gms.internal.ads.zztg
    protected final void zzal(String str, zzst zzstVar, long j, long j2) {
        this.zzc.zzq(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zztg
    protected final void zzam(String str) {
        this.zzc.zzr(str);
    }

    protected final void zzao() {
        this.zzl = true;
    }

    @Override // com.google.android.gms.internal.ads.zztg
    protected final void zzap() {
        this.zzd.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zztg
    protected final void zzaq() throws zzii {
        try {
            this.zzd.zzj();
        } catch (zzqe e) {
            throw zzcW(e, e.zzc, e.zzb, true != zzaL() ? 5002 : 5003);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztg
    protected final boolean zzas(zzz zzzVar) {
        zzn();
        return this.zzd.zzA(zzzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final zzbb zzc() {
        return this.zzd.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void zzg(zzbb zzbbVar) {
        this.zzd.zzs(zzbbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final boolean zzj() {
        boolean z = this.zzn;
        this.zzn = false;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzhx, com.google.android.gms.internal.ads.zzlu
    public final zzkv zzl() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zztg, com.google.android.gms.internal.ads.zzhx
    protected final void zzx() {
        this.zzm = true;
        this.zzi = null;
        try {
            this.zzd.zzf();
            super.zzx();
        } catch (Throwable th) {
            super.zzx();
            throw th;
        } finally {
            this.zzc.zzs(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztg, com.google.android.gms.internal.ads.zzhx
    protected final void zzy(boolean z, boolean z2) throws zzii {
        super.zzy(z, z2);
        this.zzc.zzt(this.zza);
        zzn();
        zzqf zzqfVar = this.zzd;
        zzqfVar.zzt(zzo());
        zzqfVar.zzp(zzi());
    }

    @Override // com.google.android.gms.internal.ads.zztg, com.google.android.gms.internal.ads.zzhx
    protected final void zzz(long j, boolean z) throws zzii {
        super.zzz(j, z);
        this.zzd.zzf();
        this.zzk = j;
        this.zzn = false;
        this.zzl = true;
    }

    @Override // com.google.android.gms.internal.ads.zztg
    protected final zzhz zzac(zzkp zzkpVar) throws zzii {
        zzz zzzVar = zzkpVar.zza;
        zzzVar.getClass();
        this.zzi = zzzVar;
        zzhz zzhzVarZzac = super.zzac(zzkpVar);
        this.zzc.zzu(zzzVar, zzhzVarZzac);
        return zzhzVarZzac;
    }

    @Override // com.google.android.gms.internal.ads.zztg
    protected final boolean zzar(long j, long j2, zzsw zzswVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzz zzzVar) throws zzii {
        byteBuffer.getClass();
        if (this.zzj != null && (i2 & 2) != 0) {
            zzswVar.getClass();
            zzswVar.zzo(i, false);
            return true;
        }
        if (z) {
            if (zzswVar != null) {
                zzswVar.zzo(i, false);
            }
            this.zza.zzf += i3;
            this.zzd.zzg();
            return true;
        }
        try {
            if (!this.zzd.zzx(byteBuffer, j3, i3)) {
                return false;
            }
            if (zzswVar != null) {
                zzswVar.zzo(i, false);
            }
            this.zza.zze += i3;
            return true;
        } catch (zzqb e) {
            zzz zzzVar2 = this.zzi;
            if (zzaL()) {
                zzn();
            }
            throw zzcW(e, zzzVar2, e.zzb, 5001);
        } catch (zzqe e2) {
            if (zzaL()) {
                zzn();
            }
            throw zzcW(e2, zzzVar, e2.zzb, 5002);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztg, com.google.android.gms.internal.ads.zzhx, com.google.android.gms.internal.ads.zzlp
    public final void zzu(int i, Object obj) throws zzii {
        zzss zzssVar;
        if (i == 2) {
            zzqf zzqfVar = this.zzd;
            obj.getClass();
            zzqfVar.zzw(((Float) obj).floatValue());
            return;
        }
        if (i == 3) {
            zze zzeVar = (zze) obj;
            zzqf zzqfVar2 = this.zzd;
            zzeVar.getClass();
            zzqfVar2.zzm(zzeVar);
            return;
        }
        if (i == 6) {
            zzf zzfVar = (zzf) obj;
            zzqf zzqfVar3 = this.zzd;
            zzfVar.getClass();
            zzqfVar3.zzo(zzfVar);
            return;
        }
        if (i == 12) {
            int i2 = zzeu.zza;
            this.zzd.zzu((AudioDeviceInfo) obj);
            return;
        }
        if (i == 16) {
            obj.getClass();
            this.zzo = ((Integer) obj).intValue();
            zzsw zzswVarZzaz = zzaz();
            if (zzswVarZzaz == null || zzeu.zza < 35) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.zzo));
            zzswVarZzaz.zzq(bundle);
            return;
        }
        if (i == 9) {
            zzqf zzqfVar4 = this.zzd;
            obj.getClass();
            zzqfVar4.zzv(((Boolean) obj).booleanValue());
        } else {
            if (i != 10) {
                super.zzu(i, obj);
                return;
            }
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            this.zzd.zzn(iIntValue);
            if (zzeu.zza < 35 || (zzssVar = this.zze) == null) {
                return;
            }
            zzssVar.zzd(iIntValue);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztg
    protected final void zzan(zzz zzzVar, MediaFormat mediaFormat) throws zzii {
        int iZzn;
        int[] iArr;
        int i;
        zzz zzzVar2 = this.zzj;
        int[] iArr2 = null;
        if (zzzVar2 != null) {
            zzzVar = zzzVar2;
        } else if (zzaz() != null) {
            mediaFormat.getClass();
            if ("audio/raw".equals(zzzVar.zzo)) {
                iZzn = zzzVar.zzG;
            } else if (zzeu.zza < 24 || !mediaFormat.containsKey("pcm-encoding")) {
                iZzn = mediaFormat.containsKey("v-bits-per-sample") ? zzeu.zzn(mediaFormat.getInteger("v-bits-per-sample")) : 2;
            } else {
                iZzn = mediaFormat.getInteger("pcm-encoding");
            }
            zzx zzxVar = new zzx();
            zzxVar.zzad("audio/raw");
            zzxVar.zzX(iZzn);
            zzxVar.zzI(zzzVar.zzH);
            zzxVar.zzJ(zzzVar.zzI);
            zzxVar.zzW(zzzVar.zzl);
            Object obj = zzzVar.zzm;
            zzxVar.zzO(zzzVar.zza);
            zzxVar.zzQ(zzzVar.zzb);
            zzxVar.zzR(zzzVar.zzc);
            zzxVar.zzS(zzzVar.zzd);
            zzxVar.zzaf(zzzVar.zze);
            zzxVar.zzab(zzzVar.zzf);
            zzxVar.zzB(mediaFormat.getInteger("channel-count"));
            zzxVar.zzae(mediaFormat.getInteger("sample-rate"));
            zzz zzzVarZzaj = zzxVar.zzaj();
            if (this.zzg && zzzVarZzaj.zzE == 6 && (i = zzzVar.zzE) < 6) {
                iArr2 = new int[i];
                for (int i2 = 0; i2 < i; i2++) {
                    iArr2[i2] = i2;
                }
            } else if (this.zzh) {
                int i3 = zzzVarZzaj.zzE;
                if (i3 == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i3 == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i3 == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i3 == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i3 == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
                iArr2 = iArr;
            }
            zzzVar = zzzVarZzaj;
        }
        try {
            if (zzeu.zza >= 29 && zzaL()) {
                zzn();
            }
            this.zzd.zze(zzzVar, 0, iArr2);
        } catch (zzqa e) {
            throw zzcW(e, e.zza, false, 5001);
        }
    }
}
