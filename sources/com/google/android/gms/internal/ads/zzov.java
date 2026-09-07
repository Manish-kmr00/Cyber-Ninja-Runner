package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzov implements zzmj, zzow {
    private boolean zzA;
    private final Context zza;
    private final zzox zzc;
    private final PlaybackSession zzd;
    private String zzj;
    private PlaybackMetrics.Builder zzk;
    private int zzl;
    private zzba zzo;
    private zzou zzp;
    private zzou zzq;
    private zzou zzr;
    private zzz zzs;
    private zzz zzt;
    private zzz zzu;
    private boolean zzv;
    private boolean zzw;
    private int zzx;
    private int zzy;
    private int zzz;
    private final Executor zzb = zzdd.zza();
    private final zzbk zzf = new zzbk();
    private final zzbj zzg = new zzbj();
    private final HashMap zzi = new HashMap();
    private final HashMap zzh = new HashMap();
    private final long zze = SystemClock.elapsedRealtime();
    private int zzm = 0;
    private int zzn = 0;

    private zzov(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzd = playbackSession;
        zzoo zzooVar = new zzoo(zzoo.zza);
        this.zzc = zzooVar;
        zzooVar.zzh(this);
    }

    @RequiresNonNull({"metricsBuilder"})
    private final void zzA(zzbl zzblVar, zzuy zzuyVar) {
        int iZza;
        PlaybackMetrics.Builder builder = this.zzk;
        if (zzuyVar == null || (iZza = zzblVar.zza(zzuyVar.zza)) == -1) {
            return;
        }
        zzbj zzbjVar = this.zzg;
        int i = 0;
        zzblVar.zzd(iZza, zzbjVar, false);
        zzbk zzbkVar = this.zzf;
        zzblVar.zze(zzbjVar.zzc, zzbkVar, 0L);
        zzak zzakVar = zzbkVar.zzd.zzb;
        if (zzakVar != null) {
            int iZzo = zzeu.zzo(zzakVar.zza);
            if (iZzo == 0) {
                i = 3;
            } else if (iZzo != 1) {
                i = iZzo != 2 ? 1 : 4;
            } else {
                i = 5;
            }
        }
        builder.setStreamType(i);
        long j = zzbkVar.zzm;
        if (j != -9223372036854775807L && !zzbkVar.zzk && !zzbkVar.zzi && !zzbkVar.zzb()) {
            builder.setMediaDurationMillis(zzeu.zzv(j));
        }
        builder.setPlaybackType(true != zzbkVar.zzb() ? 1 : 2);
        this.zzA = true;
    }

    private final void zzB(long j, zzz zzzVar, int i) {
        if (Objects.equals(this.zzs, zzzVar)) {
            return;
        }
        int i2 = this.zzs == null ? 1 : 0;
        this.zzs = zzzVar;
        zzC(1, j, zzzVar, i2);
    }

    private final void zzC(int i, long j, zzz zzzVar, int i2) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i).setTimeSinceCreatedMillis(j - this.zze);
        if (zzzVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(i2 != 1 ? 1 : 2);
            String str = zzzVar.zzn;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = zzzVar.zzo;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = zzzVar.zzk;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i3 = zzzVar.zzj;
            if (i3 != -1) {
                timeSinceCreatedMillis.setBitrate(i3);
            }
            int i4 = zzzVar.zzv;
            if (i4 != -1) {
                timeSinceCreatedMillis.setWidth(i4);
            }
            int i5 = zzzVar.zzw;
            if (i5 != -1) {
                timeSinceCreatedMillis.setHeight(i5);
            }
            int i6 = zzzVar.zzE;
            if (i6 != -1) {
                timeSinceCreatedMillis.setChannelCount(i6);
            }
            int i7 = zzzVar.zzF;
            if (i7 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i7);
            }
            String str4 = zzzVar.zzd;
            if (str4 != null) {
                int i8 = zzeu.zza;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                if (pairCreate.second != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) pairCreate.second);
                }
            }
            float f = zzzVar.zzx;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzA = true;
        final TrackChangeEvent trackChangeEventBuild = timeSinceCreatedMillis.build();
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzop
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd.reportTrackChangeEvent(trackChangeEventBuild);
            }
        });
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private final boolean zzD(zzou zzouVar) {
        if (zzouVar != null) {
            return zzouVar.zzc.equals(this.zzc.zze());
        }
        return false;
    }

    public static zzov zzb(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new zzov(context, mediaMetricsManager.createPlaybackSession());
    }

    private static int zzw(int i) {
        switch (zzeu.zzl(i)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private final void zzx() {
        PlaybackMetrics.Builder builder = this.zzk;
        if (builder != null && this.zzA) {
            builder.setAudioUnderrunCount(this.zzz);
            this.zzk.setVideoFramesDropped(this.zzx);
            this.zzk.setVideoFramesPlayed(this.zzy);
            Long l = (Long) this.zzh.get(this.zzj);
            this.zzk.setNetworkTransferDurationMillis(l == null ? 0L : l.longValue());
            Long l2 = (Long) this.zzi.get(this.zzj);
            this.zzk.setNetworkBytesRead(l2 == null ? 0L : l2.longValue());
            this.zzk.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            final PlaybackMetrics playbackMetricsBuild = this.zzk.build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzos
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.reportPlaybackMetrics(playbackMetricsBuild);
                }
            });
        }
        this.zzk = null;
        this.zzj = null;
        this.zzz = 0;
        this.zzx = 0;
        this.zzy = 0;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzA = false;
    }

    private final void zzy(long j, zzz zzzVar, int i) {
        if (Objects.equals(this.zzt, zzzVar)) {
            return;
        }
        int i2 = this.zzt == null ? 1 : 0;
        this.zzt = zzzVar;
        zzC(0, j, zzzVar, i2);
    }

    private final void zzz(long j, zzz zzzVar, int i) {
        if (Objects.equals(this.zzu, zzzVar)) {
            return;
        }
        int i2 = this.zzu == null ? 1 : 0;
        this.zzu = zzzVar;
        zzC(2, j, zzzVar, i2);
    }

    public final LogSessionId zza() {
        return this.zzd.getSessionId();
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final /* synthetic */ void zze(zzmh zzmhVar, zzz zzzVar, zzhz zzhzVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zzf(zzmh zzmhVar, int i, long j, long j2) {
        zzuy zzuyVar = zzmhVar.zzd;
        if (zzuyVar != null) {
            String strZzf = this.zzc.zzf(zzmhVar.zzb, zzuyVar);
            HashMap map = this.zzi;
            Long l = (Long) map.get(strZzf);
            HashMap map2 = this.zzh;
            Long l2 = (Long) map2.get(strZzf);
            map.put(strZzf, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            map2.put(strZzf, Long.valueOf((l2 != null ? l2.longValue() : 0L) + ((long) i)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zzg(zzmh zzmhVar, zzuu zzuuVar) {
        zzuy zzuyVar = zzmhVar.zzd;
        if (zzuyVar == null) {
            return;
        }
        zzz zzzVar = zzuuVar.zzb;
        zzzVar.getClass();
        zzou zzouVar = new zzou(zzzVar, 0, this.zzc.zzf(zzmhVar.zzb, zzuyVar));
        int i = zzuuVar.zza;
        if (i != 0) {
            if (i == 1) {
                this.zzq = zzouVar;
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.zzr = zzouVar;
                return;
            }
        }
        this.zzp = zzouVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final /* synthetic */ void zzh(zzmh zzmhVar, int i, long j) {
    }

    /* JADX WARN: Code duplicated, block: B:137:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:140:0x01fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:141:0x01fe A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:142:0x0200  */
    /* JADX WARN: Code duplicated, block: B:145:0x0208  */
    /* JADX WARN: Code duplicated, block: B:146:0x0214  */
    /* JADX WARN: Code duplicated, block: B:148:0x021a  */
    /* JADX WARN: Code duplicated, block: B:150:0x0224  */
    /* JADX WARN: Code duplicated, block: B:152:0x0228  */
    /* JADX WARN: Code duplicated, block: B:153:0x022b  */
    /* JADX WARN: Code duplicated, block: B:155:0x022f  */
    /* JADX WARN: Code duplicated, block: B:156:0x0236  */
    /* JADX WARN: Code duplicated, block: B:158:0x023a  */
    /* JADX WARN: Code duplicated, block: B:159:0x0241  */
    /* JADX WARN: Code duplicated, block: B:161:0x0245  */
    /* JADX WARN: Code duplicated, block: B:162:0x0250  */
    /* JADX WARN: Code duplicated, block: B:172:0x029e  */
    /* JADX WARN: Code duplicated, block: B:174:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:176:0x02a8  */
    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zzi(zzbh zzbhVar, zzmi zzmiVar) {
        int i;
        int i2;
        int iZzw;
        int i3;
        int errorCode;
        int iZzm;
        zzs zzsVar;
        int i4;
        int i5;
        if (zzmiVar.zzb() == 0) {
            return;
        }
        for (int i6 = 0; i6 < zzmiVar.zzb(); i6++) {
            int iZza = zzmiVar.zza(i6);
            zzmh zzmhVarZzc = zzmiVar.zzc(iZza);
            if (iZza == 0) {
                this.zzc.zzk(zzmhVarZzc);
            } else if (iZza == 11) {
                this.zzc.zzj(zzmhVarZzc, this.zzl);
            } else {
                this.zzc.zzi(zzmhVarZzc);
            }
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (zzmiVar.zzd(0)) {
            zzmh zzmhVarZzc2 = zzmiVar.zzc(0);
            if (this.zzk != null) {
                zzA(zzmhVarZzc2.zzb, zzmhVarZzc2.zzd);
            }
        }
        if (zzmiVar.zzd(2) && this.zzk != null) {
            zzfww zzfwwVarZza = zzbhVar.zzp().zza();
            int size = zzfwwVarZza.size();
            int i7 = 0;
            loop1: while (true) {
                if (i7 >= size) {
                    zzsVar = null;
                    break;
                }
                zzbs zzbsVar = (zzbs) zzfwwVarZza.get(i7);
                int i8 = 0;
                while (true) {
                    i5 = i7 + 1;
                    if (i8 < zzbsVar.zza) {
                        if (zzbsVar.zzd(i8) && (zzsVar = zzbsVar.zzb(i8).zzs) != null) {
                            break loop1;
                        } else {
                            i8++;
                        }
                    }
                }
                i7 = i5;
            }
            if (zzsVar != null) {
                PlaybackMetrics.Builder builder = this.zzk;
                int i9 = zzeu.zza;
                int i10 = 0;
                while (true) {
                    if (i10 >= zzsVar.zzb) {
                        i4 = 1;
                        break;
                    }
                    UUID uuid = zzsVar.zza(i10).zza;
                    if (uuid.equals(zzh.zzd)) {
                        i4 = 3;
                        break;
                    } else if (uuid.equals(zzh.zze)) {
                        i4 = 2;
                        break;
                    } else {
                        if (uuid.equals(zzh.zzc)) {
                            i4 = 6;
                            break;
                        }
                        i10++;
                    }
                }
                builder.setDrmType(i4);
            }
        }
        if (zzmiVar.zzd(1011)) {
            this.zzz++;
        }
        zzba zzbaVar = this.zzo;
        if (zzbaVar != null) {
            Context context = this.zza;
            int i11 = zzbaVar.zza;
            if (i11 == 1001) {
                i3 = 20;
            } else {
                zzii zziiVar = (zzii) zzbaVar;
                boolean z = zziiVar.zzc == 1;
                int i12 = zziiVar.zzg;
                Throwable cause = zzbaVar.getCause();
                cause.getClass();
                if (cause instanceof IOException) {
                    if (cause instanceof zzgx) {
                        iZzm = ((zzgx) cause).zzc;
                        i3 = 5;
                    } else if ((cause instanceof zzgw) || (cause instanceof zzaz)) {
                        iZzm = 0;
                        i3 = 11;
                    } else {
                        boolean z2 = cause instanceof zzgv;
                        if (z2 || (cause instanceof zzhf)) {
                            if (zzei.zzb(context).zza() == 1) {
                                iZzm = 0;
                                i3 = 3;
                            } else {
                                Throwable cause2 = cause.getCause();
                                if (cause2 instanceof UnknownHostException) {
                                    iZzm = 0;
                                    i3 = 6;
                                } else if (cause2 instanceof SocketTimeoutException) {
                                    iZzm = 0;
                                    i3 = 7;
                                } else if (z2 && ((zzgv) cause).zzb == 1) {
                                    iZzm = 0;
                                    i3 = 4;
                                } else {
                                    iZzm = 0;
                                    i3 = 8;
                                }
                            }
                        } else if (i11 == 1002) {
                            i3 = 21;
                        } else if (cause instanceof zzrr) {
                            Throwable cause3 = cause.getCause();
                            cause3.getClass();
                            if (cause3 instanceof MediaDrm.MediaDrmStateException) {
                                errorCode = zzeu.zzm(((MediaDrm.MediaDrmStateException) cause3).getDiagnosticInfo());
                                iZzw = zzw(errorCode);
                                int i13 = iZzw;
                                iZzm = errorCode;
                                i3 = i13;
                            } else {
                                int i14 = zzeu.zza;
                                if (cause3 instanceof MediaDrmResetException) {
                                    i3 = 27;
                                } else if (cause3 instanceof NotProvisionedException) {
                                    i3 = 24;
                                } else if (cause3 instanceof DeniedByServerException) {
                                    i3 = 29;
                                } else if (cause3 instanceof zzsb) {
                                    iZzm = 0;
                                    i3 = 23;
                                } else {
                                    i3 = cause3 instanceof zzrq ? 28 : 30;
                                }
                            }
                        } else if ((cause instanceof zzgs) && (cause.getCause() instanceof FileNotFoundException)) {
                            Throwable cause4 = cause.getCause();
                            cause4.getClass();
                            Throwable cause5 = cause4.getCause();
                            if ((cause5 instanceof ErrnoException) && ((ErrnoException) cause5).errno == OsConstants.EACCES) {
                                i3 = 32;
                            } else {
                                iZzm = 0;
                                i3 = 31;
                            }
                        } else {
                            iZzm = 0;
                            i3 = 9;
                        }
                    }
                } else if (z) {
                    i3 = 35;
                    if (i12 != 0 && i12 != 1) {
                        if (!z && i12 == 3) {
                            i3 = 15;
                        } else if (!z && i12 == 2) {
                            iZzm = 0;
                            i3 = 23;
                        } else if (cause instanceof zztc) {
                            iZzm = zzeu.zzm(((zztc) cause).zzd);
                            i3 = 13;
                        } else {
                            iZzw = 14;
                            if (cause instanceof zzsy) {
                                errorCode = ((zzsy) cause).zza;
                            } else if (cause instanceof OutOfMemoryError) {
                                i3 = 14;
                            } else if (cause instanceof zzqb) {
                                errorCode = ((zzqb) cause).zza;
                                iZzw = 17;
                            } else if (cause instanceof zzqe) {
                                errorCode = ((zzqe) cause).zza;
                                iZzw = 18;
                            } else if (cause instanceof MediaCodec.CryptoException) {
                                errorCode = ((MediaCodec.CryptoException) cause).getErrorCode();
                                iZzw = zzw(errorCode);
                            } else {
                                i3 = 22;
                            }
                            int i15 = iZzw;
                            iZzm = errorCode;
                            i3 = i15;
                        }
                    }
                } else if (!z) {
                    if (!z) {
                    }
                    if (cause instanceof zztc) {
                        iZzm = zzeu.zzm(((zztc) cause).zzd);
                        i3 = 13;
                    } else {
                        iZzw = 14;
                        if (cause instanceof zzsy) {
                            errorCode = ((zzsy) cause).zza;
                        } else if (cause instanceof OutOfMemoryError) {
                            i3 = 14;
                        } else if (cause instanceof zzqb) {
                            errorCode = ((zzqb) cause).zza;
                            iZzw = 17;
                        } else if (cause instanceof zzqe) {
                            errorCode = ((zzqe) cause).zza;
                            iZzw = 18;
                        } else if (cause instanceof MediaCodec.CryptoException) {
                            errorCode = ((MediaCodec.CryptoException) cause).getErrorCode();
                            iZzw = zzw(errorCode);
                        } else {
                            i3 = 22;
                        }
                        int i16 = iZzw;
                        iZzm = errorCode;
                        i3 = i16;
                    }
                } else {
                    if (!z) {
                    }
                    if (cause instanceof zztc) {
                        iZzm = zzeu.zzm(((zztc) cause).zzd);
                        i3 = 13;
                    } else {
                        iZzw = 14;
                        if (cause instanceof zzsy) {
                            errorCode = ((zzsy) cause).zza;
                        } else if (cause instanceof OutOfMemoryError) {
                            i3 = 14;
                        } else if (cause instanceof zzqb) {
                            errorCode = ((zzqb) cause).zza;
                            iZzw = 17;
                        } else if (cause instanceof zzqe) {
                            errorCode = ((zzqe) cause).zza;
                            iZzw = 18;
                        } else if (cause instanceof MediaCodec.CryptoException) {
                            errorCode = ((MediaCodec.CryptoException) cause).getErrorCode();
                            iZzw = zzw(errorCode);
                        } else {
                            i3 = 22;
                        }
                        int i17 = iZzw;
                        iZzm = errorCode;
                        i3 = i17;
                    }
                }
                final PlaybackErrorEvent playbackErrorEventBuild = new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(jElapsedRealtime - this.zze).setErrorCode(i3).setSubErrorCode(iZzm).setException(zzbaVar).build();
                this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzor
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzd.reportPlaybackErrorEvent(playbackErrorEventBuild);
                    }
                });
                this.zzA = true;
                this.zzo = null;
            }
            iZzm = 0;
            final PlaybackErrorEvent playbackErrorEventBuild2 = new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(jElapsedRealtime - this.zze).setErrorCode(i3).setSubErrorCode(iZzm).setException(zzbaVar).build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzor
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.reportPlaybackErrorEvent(playbackErrorEventBuild2);
                }
            });
            this.zzA = true;
            this.zzo = null;
        }
        if (zzmiVar.zzd(2)) {
            zzbt zzbtVarZzp = zzbhVar.zzp();
            boolean zZzb = zzbtVarZzp.zzb(2);
            boolean zZzb2 = zzbtVarZzp.zzb(1);
            boolean zZzb3 = zzbtVarZzp.zzb(3);
            if (zZzb || zZzb2) {
                if (!zZzb) {
                    zzB(jElapsedRealtime, null, 0);
                }
                if (!zZzb2) {
                    zzy(jElapsedRealtime, null, 0);
                }
                if (!zZzb3) {
                    zzz(jElapsedRealtime, null, 0);
                }
            } else if (zZzb3) {
                zZzb3 = true;
                if (!zZzb) {
                    zzB(jElapsedRealtime, null, 0);
                }
                if (!zZzb2) {
                    zzy(jElapsedRealtime, null, 0);
                }
                if (!zZzb3) {
                    zzz(jElapsedRealtime, null, 0);
                }
            }
        }
        if (zzD(this.zzp)) {
            zzou zzouVar = this.zzp;
            zzz zzzVar = zzouVar.zza;
            if (zzzVar.zzw != -1) {
                int i18 = zzouVar.zzb;
                zzB(jElapsedRealtime, zzzVar, 0);
                this.zzp = null;
            }
        }
        if (zzD(this.zzq)) {
            zzou zzouVar2 = this.zzq;
            zzz zzzVar2 = zzouVar2.zza;
            int i19 = zzouVar2.zzb;
            zzy(jElapsedRealtime, zzzVar2, 0);
            this.zzq = null;
        }
        if (zzD(this.zzr)) {
            zzou zzouVar3 = this.zzr;
            zzz zzzVar3 = zzouVar3.zza;
            int i20 = zzouVar3.zzb;
            zzz(jElapsedRealtime, zzzVar3, 0);
            this.zzr = null;
        }
        switch (zzei.zzb(this.zza).zza()) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 9;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 6;
                break;
            case 6:
            case 8:
            default:
                i = 1;
                break;
            case 7:
                i = 3;
                break;
            case 9:
                i = 8;
                break;
            case 10:
                i = 7;
                break;
        }
        if (i != this.zzn) {
            this.zzn = i;
            final NetworkEvent networkEventBuild = new NetworkEvent.Builder().setNetworkType(i).setTimeSinceCreatedMillis(jElapsedRealtime - this.zze).build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoq
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.reportNetworkEvent(networkEventBuild);
                }
            });
        }
        if (zzbhVar.zzg() != 2) {
            this.zzv = false;
        }
        if (((zzmc) zzbhVar).zzD() == null) {
            this.zzw = false;
        } else if (zzmiVar.zzd(10)) {
            this.zzw = true;
        }
        int iZzg = zzbhVar.zzg();
        if (this.zzv) {
            i2 = 5;
        } else if (this.zzw) {
            i2 = 13;
        } else {
            i2 = 4;
            if (iZzg == 4) {
                i2 = 11;
            } else if (iZzg == 2) {
                int i21 = this.zzm;
                if (i21 == 0 || i21 == 2 || i21 == 12) {
                    i2 = 2;
                } else if (zzbhVar.zzv()) {
                    i2 = zzbhVar.zzh() != 0 ? 10 : 6;
                } else {
                    i2 = 7;
                }
            } else if (iZzg != 3) {
                i2 = (iZzg != 1 || this.zzm == 0) ? this.zzm : 12;
            } else if (zzbhVar.zzv()) {
                i2 = zzbhVar.zzh() != 0 ? 9 : 3;
            }
        }
        if (this.zzm != i2) {
            this.zzm = i2;
            this.zzA = true;
            final PlaybackStateEvent playbackStateEventBuild = new PlaybackStateEvent.Builder().setState(this.zzm).setTimeSinceCreatedMillis(jElapsedRealtime - this.zze).build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzot
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.reportPlaybackStateEvent(playbackStateEventBuild);
                }
            });
        }
        if (zzmiVar.zzd(1028)) {
            this.zzc.zzg(zzmiVar.zzc(1028));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zzj(zzmh zzmhVar, zzup zzupVar, zzuu zzuuVar, IOException iOException, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final /* synthetic */ void zzk(zzmh zzmhVar, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zzl(zzmh zzmhVar, zzba zzbaVar) {
        this.zzo = zzbaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zzm(zzmh zzmhVar, zzbf zzbfVar, zzbf zzbfVar2, int i) {
        if (i == 1) {
            this.zzv = true;
            i = 1;
        }
        this.zzl = i;
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final /* synthetic */ void zzn(zzmh zzmhVar, Object obj, long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zzo(zzmh zzmhVar, zzhy zzhyVar) {
        this.zzx += zzhyVar.zzg;
        this.zzy += zzhyVar.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final /* synthetic */ void zzp(zzmh zzmhVar, zzz zzzVar, zzhz zzhzVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zzq(zzmh zzmhVar, zzcd zzcdVar) {
        zzou zzouVar = this.zzp;
        if (zzouVar != null) {
            zzz zzzVar = zzouVar.zza;
            if (zzzVar.zzw == -1) {
                zzx zzxVarZzb = zzzVar.zzb();
                zzxVarZzb.zzai(zzcdVar.zzb);
                zzxVarZzb.zzM(zzcdVar.zzc);
                this.zzp = new zzou(zzxVarZzb.zzaj(), 0, zzouVar.zzc);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzow
    public final void zzu(zzmh zzmhVar, String str) {
        zzuy zzuyVar = zzmhVar.zzd;
        if (zzuyVar == null || !zzuyVar.zzb()) {
            zzx();
            this.zzj = str;
            this.zzk = new PlaybackMetrics.Builder().setPlayerName("AndroidXMedia3").setPlayerVersion("1.6.0");
            zzA(zzmhVar.zzb, zzuyVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzow
    public final void zzv(zzmh zzmhVar, String str, boolean z) {
        zzuy zzuyVar = zzmhVar.zzd;
        if ((zzuyVar == null || !zzuyVar.zzb()) && str.equals(this.zzj)) {
            zzx();
        }
        this.zzh.remove(str);
        this.zzi.remove(str);
    }
}
