package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import io.bidmachine.media3.exoplayer.dash.DashMediaSource;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzqj {
    private long zzA;
    private boolean zzB;
    private long zzC;
    private long zzD;
    private boolean zzE;
    private long zzF;
    private zzdg zzG;
    private final zzqi zza;
    private final long[] zzb;
    private AudioTrack zzc;
    private int zzd;
    private zzqh zze;
    private int zzf;
    private long zzg;
    private float zzh;
    private boolean zzi;
    private long zzj;
    private long zzk;
    private Method zzl;
    private long zzm;
    private boolean zzn;
    private boolean zzo;
    private long zzp;
    private long zzq;
    private long zzr;
    private long zzs;
    private int zzt;
    private int zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzqj(zzqi zzqiVar) {
        this.zza = zzqiVar;
        try {
            this.zzl = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzb = new long[10];
        this.zzG = zzdg.zza;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0068  */
    private final long zzl() {
        if (this.zzv != -9223372036854775807L) {
            return Math.min(this.zzy, zzn());
        }
        long jZzb = this.zzG.zzb();
        if (jZzb - this.zzq >= 5) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            int playState = audioTrack.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
                if (zzeu.zza > 29) {
                    if (this.zzr > playbackHeadPosition) {
                        this.zzs++;
                    }
                    this.zzr = playbackHeadPosition;
                } else {
                    if (playbackHeadPosition == 0) {
                        if (this.zzr <= 0 || playState != 3) {
                            playbackHeadPosition = 0;
                        } else if (this.zzw == -9223372036854775807L) {
                            this.zzw = jZzb;
                        }
                    }
                    this.zzw = -9223372036854775807L;
                    if (this.zzr > playbackHeadPosition) {
                        this.zzs++;
                    }
                    this.zzr = playbackHeadPosition;
                }
            }
            this.zzq = jZzb;
        }
        return this.zzr + this.zzF + (this.zzs << 32);
    }

    private final long zzm() {
        return zzeu.zzt(zzl(), this.zzf);
    }

    private final long zzn() {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 2) {
            return this.zzx;
        }
        return this.zzx + zzeu.zzp(zzeu.zzq(zzeu.zzs(this.zzG.zzb()) - this.zzv, this.zzh), this.zzf);
    }

    private final void zzo() {
        this.zzj = 0L;
        this.zzu = 0;
        this.zzt = 0;
        this.zzk = 0L;
        this.zzA = 0L;
        this.zzD = 0L;
        this.zzi = false;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0075  */
    /* JADX WARN: Code duplicated, block: B:19:0x0077  */
    /* JADX WARN: Code duplicated, block: B:21:0x008d  */
    /* JADX WARN: Code duplicated, block: B:22:0x0099  */
    /* JADX WARN: Code duplicated, block: B:24:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:25:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d0 A[Catch: Exception -> 0x00fb, TryCatch #0 {Exception -> 0x00fb, blocks: (B:33:0x00cc, B:35:0x00d0, B:37:0x00f2, B:38:0x00fa), top: B:69:0x00cc }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00f2 A[Catch: Exception -> 0x00fb, TryCatch #0 {Exception -> 0x00fb, blocks: (B:33:0x00cc, B:35:0x00d0, B:37:0x00f2, B:38:0x00fa), top: B:69:0x00cc }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00fa A[Catch: Exception -> 0x00fb, TRY_LEAVE, TryCatch #0 {Exception -> 0x00fb, blocks: (B:33:0x00cc, B:35:0x00d0, B:37:0x00f2, B:38:0x00fa), top: B:69:0x00cc }] */
    public final long zza() {
        long jZzq;
        long jMax;
        zzqh zzqhVar;
        long jZzb;
        long jZza;
        long jZzm;
        int i;
        Method method;
        AudioTrack audioTrack;
        long jMax2;
        AudioTrack audioTrack2 = this.zzc;
        audioTrack2.getClass();
        if (audioTrack2.getPlayState() == 3) {
            long jZzc = this.zzG.zzc() / 1000;
            if (jZzc - this.zzk >= 30000) {
                long jZzm2 = zzm();
                if (jZzm2 != 0) {
                    long[] jArr = this.zzb;
                    jArr[this.zzt] = zzeu.zzr(jZzm2, this.zzh) - jZzc;
                    this.zzt = (this.zzt + 1) % 10;
                    int i2 = this.zzu;
                    if (i2 < 10) {
                        this.zzu = i2 + 1;
                    }
                    this.zzk = jZzc;
                    this.zzj = 0L;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.zzu;
                        if (i3 >= i4) {
                            break;
                        }
                        this.zzj += jArr[i3] / ((long) i4);
                        i3++;
                    }
                    zzqhVar = this.zze;
                    zzqhVar.getClass();
                    if (zzqhVar.zzg(jZzc)) {
                        jZzb = zzqhVar.zzb();
                        jZza = zzqhVar.zza();
                        jZzm = zzm();
                        if (Math.abs(jZzb - jZzc) > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                            i = 0;
                            this.zza.zzd(jZza, jZzb, jZzc, jZzm);
                            zzqhVar.zzd();
                        } else {
                            i = 0;
                            if (Math.abs(zzeu.zzt(jZza, this.zzf) - jZzm) > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                                this.zza.zzc(jZza, jZzb, jZzc, jZzm);
                                zzqhVar.zzd();
                            } else {
                                zzqhVar.zzc();
                            }
                        }
                    } else {
                        i = 0;
                    }
                    if (this.zzo && (method = this.zzl) != null && jZzc - this.zzp >= 500000) {
                        try {
                            audioTrack = this.zzc;
                            if (audioTrack != null) {
                                throw null;
                            }
                            Integer num = (Integer) method.invoke(audioTrack, new Object[i]);
                            int i5 = zzeu.zza;
                            long jIntValue = (((long) num.intValue()) * 1000) - this.zzg;
                            this.zzm = jIntValue;
                            jMax2 = Math.max(jIntValue, 0L);
                            this.zzm = jMax2;
                            if (jMax2 > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                                this.zza.zza(jMax2);
                                this.zzm = 0L;
                            }
                            this.zzp = jZzc;
                        } catch (Exception unused) {
                            this.zzl = null;
                        }
                    }
                }
            } else {
                zzqhVar = this.zze;
                zzqhVar.getClass();
                if (zzqhVar.zzg(jZzc)) {
                    i = 0;
                } else {
                    jZzb = zzqhVar.zzb();
                    jZza = zzqhVar.zza();
                    jZzm = zzm();
                    if (Math.abs(jZzb - jZzc) > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                        i = 0;
                        this.zza.zzd(jZza, jZzb, jZzc, jZzm);
                        zzqhVar.zzd();
                    } else {
                        i = 0;
                        if (Math.abs(zzeu.zzt(jZza, this.zzf) - jZzm) > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                            this.zza.zzc(jZza, jZzb, jZzc, jZzm);
                            zzqhVar.zzd();
                        } else {
                            zzqhVar.zzc();
                        }
                    }
                }
                if (this.zzo) {
                    audioTrack = this.zzc;
                    if (audioTrack != null) {
                        throw null;
                    }
                    Integer num2 = (Integer) method.invoke(audioTrack, new Object[i]);
                    int i6 = zzeu.zza;
                    long jIntValue2 = (((long) num2.intValue()) * 1000) - this.zzg;
                    this.zzm = jIntValue2;
                    jMax2 = Math.max(jIntValue2, 0L);
                    this.zzm = jMax2;
                    if (jMax2 > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                        this.zza.zza(jMax2);
                        this.zzm = 0L;
                    }
                    this.zzp = jZzc;
                }
            }
        }
        long jZzc2 = this.zzG.zzc() / 1000;
        zzqh zzqhVar2 = this.zze;
        zzqhVar2.getClass();
        boolean zZzf = zzqhVar2.zzf();
        if (zZzf) {
            jMax = zzeu.zzt(zzqhVar2.zza(), this.zzf) + zzeu.zzq(jZzc2 - zzqhVar2.zzb(), this.zzh);
        } else {
            if (this.zzu == 0) {
                jZzq = this.zzv != -9223372036854775807L ? zzeu.zzt(zzn(), this.zzf) : zzm();
            } else {
                jZzq = zzeu.zzq(this.zzj + jZzc2, this.zzh);
            }
            jMax = Math.max(0L, jZzq - this.zzm);
            if (this.zzv != -9223372036854775807L) {
                jMax = Math.min(zzeu.zzt(this.zzy, this.zzf), jMax);
            }
        }
        if (this.zzB != zZzf) {
            this.zzD = this.zzA;
            this.zzC = this.zzz;
        }
        long j = jZzc2 - this.zzD;
        if (j < 1000000) {
            long jZzq2 = this.zzC + zzeu.zzq(j, this.zzh);
            long j2 = (j * 1000) / 1000000;
            jMax = ((jMax * j2) + ((1000 - j2) * jZzq2)) / 1000;
        }
        if (!this.zzi && jMax > this.zzz && audioTrack2.getPlayState() == 3) {
            this.zzi = true;
            long j3 = jMax - this.zzz;
            int i7 = zzeu.zza;
            this.zza.zzb(this.zzG.zza() - zzeu.zzv(zzeu.zzr(zzeu.zzv(j3), this.zzh)));
        }
        this.zzA = jZzc2;
        this.zzz = jMax;
        this.zzB = zZzf;
        return jMax;
    }

    public final void zzb(long j) {
        this.zzx = zzl();
        this.zzv = zzeu.zzs(this.zzG.zzb());
        this.zzy = j;
    }

    public final void zzc() {
        zzo();
        this.zzc = null;
        this.zze = null;
    }

    public final void zzd(AudioTrack audioTrack, boolean z, int i, int i2, int i3) {
        this.zzc = audioTrack;
        this.zzd = i3;
        this.zze = new zzqh(audioTrack);
        this.zzf = audioTrack.getSampleRate();
        if (z) {
            int i4 = zzeu.zza;
        }
        boolean zZzK = zzeu.zzK(i);
        this.zzo = zZzK;
        this.zzg = zZzK ? zzeu.zzt(i3 / i2, this.zzf) : -9223372036854775807L;
        this.zzr = 0L;
        this.zzs = 0L;
        this.zzE = false;
        this.zzF = 0L;
        this.zzn = false;
        this.zzv = -9223372036854775807L;
        this.zzw = -9223372036854775807L;
        this.zzp = 0L;
        this.zzm = 0L;
        this.zzh = 1.0f;
    }

    public final void zze(zzdg zzdgVar) {
        this.zzG = zzdgVar;
    }

    public final void zzf() {
        if (this.zzv != -9223372036854775807L) {
            this.zzv = zzeu.zzs(this.zzG.zzb());
        }
        zzqh zzqhVar = this.zze;
        zzqhVar.getClass();
        zzqhVar.zze();
    }

    public final boolean zzg(long j) {
        return j > zzeu.zzp(zza(), this.zzf);
    }

    public final boolean zzh() {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        return audioTrack.getPlayState() == 3;
    }

    public final boolean zzi(long j) {
        return this.zzw != -9223372036854775807L && j > 0 && this.zzG.zzb() - this.zzw >= 200;
    }

    public final boolean zzj(long j) {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        int playState = audioTrack.getPlayState();
        boolean z = this.zzn;
        boolean zZzg = zzg(j);
        this.zzn = zZzg;
        if (z && !zZzg && playState != 1) {
            this.zza.zze(this.zzd, zzeu.zzv(this.zzg));
        }
        return true;
    }

    public final boolean zzk() {
        zzo();
        if (this.zzv != -9223372036854775807L) {
            this.zzx = zzl();
            return false;
        }
        zzqh zzqhVar = this.zze;
        zzqhVar.getClass();
        zzqhVar.zze();
        return true;
    }
}
