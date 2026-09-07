package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzahf implements zzadc {
    private static final byte[] zza = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzb;
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final UUID zze;
    private static final Map zzf;
    private long zzA;
    private boolean zzB;
    private zzahd zzC;
    private boolean zzD;
    private int zzE;
    private long zzF;
    private boolean zzG;
    private long zzH;
    private long zzI;
    private long zzJ;
    private zzdy zzK;
    private zzdy zzL;
    private boolean zzM;
    private boolean zzN;
    private int zzO;
    private long zzP;
    private long zzQ;
    private int zzR;
    private int zzS;
    private int[] zzT;
    private int zzU;
    private int zzV;
    private int zzW;
    private int zzX;
    private boolean zzY;
    private long zzZ;
    private int zzaa;
    private int zzab;
    private int zzac;
    private boolean zzad;
    private boolean zzae;
    private boolean zzaf;
    private int zzag;
    private byte zzah;
    private boolean zzai;
    private zzadf zzaj;
    private final zzaha zzak;
    private final zzahh zzg;
    private final SparseArray zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final zzajy zzk;
    private final zzek zzl;
    private final zzek zzm;
    private final zzek zzn;
    private final zzek zzo;
    private final zzek zzp;
    private final zzek zzq;
    private final zzek zzr;
    private final zzek zzs;
    private final zzek zzt;
    private final zzek zzu;
    private ByteBuffer zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        int i = zzeu.zza;
        zzb = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(StandardCharsets.UTF_8);
        zzc = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        zzd = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        zze = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        zzf = Collections.unmodifiableMap(map);
    }

    @Deprecated
    public zzahf() {
        this(new zzaha(), 2, zzajy.zza);
    }

    @RequiresNonNull({"#2.output"})
    private final int zzp(zzadd zzaddVar, zzahd zzahdVar, int i, boolean z) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzahdVar.zzc)) {
            zzx(zzaddVar, zza, i);
            int i3 = this.zzab;
            zzw();
            return i3;
        }
        if ("S_TEXT/ASS".equals(zzahdVar.zzc)) {
            zzx(zzaddVar, zzc, i);
            int i4 = this.zzab;
            zzw();
            return i4;
        }
        if ("S_TEXT/WEBVTT".equals(zzahdVar.zzc)) {
            zzx(zzaddVar, zzd, i);
            int i5 = this.zzab;
            zzw();
            return i5;
        }
        zzaei zzaeiVar = zzahdVar.zzX;
        if (!this.zzad) {
            if (zzahdVar.zzh) {
                this.zzW &= -1073741825;
                if (!this.zzae) {
                    zzek zzekVar = this.zzn;
                    zzaddVar.zzi(zzekVar.zzN(), 0, 1);
                    this.zzaa++;
                    if ((zzekVar.zzN()[0] & 128) == 128) {
                        throw zzaz.zza("Extension bit is set in signal byte", null);
                    }
                    this.zzah = zzekVar.zzN()[0];
                    this.zzae = true;
                }
                byte b = this.zzah;
                if ((b & 1) == 1) {
                    int i6 = b & 2;
                    this.zzW |= 1073741824;
                    if (!this.zzai) {
                        zzek zzekVar2 = this.zzs;
                        zzaddVar.zzi(zzekVar2.zzN(), 0, 8);
                        this.zzaa += 8;
                        this.zzai = true;
                        zzek zzekVar3 = this.zzn;
                        zzekVar3.zzN()[0] = (byte) ((i6 != 2 ? 0 : 128) | 8);
                        zzekVar3.zzL(0);
                        zzaeiVar.zzs(zzekVar3, 1, 1);
                        this.zzab++;
                        zzekVar2.zzL(0);
                        zzaeiVar.zzs(zzekVar2, 8, 1);
                        this.zzab += 8;
                    }
                    if (i6 == 2) {
                        if (!this.zzaf) {
                            zzek zzekVar4 = this.zzn;
                            zzaddVar.zzi(zzekVar4.zzN(), 0, 1);
                            this.zzaa++;
                            zzekVar4.zzL(0);
                            this.zzag = zzekVar4.zzm();
                            this.zzaf = true;
                        }
                        int i7 = this.zzag * 4;
                        zzek zzekVar5 = this.zzn;
                        zzekVar5.zzI(i7);
                        zzaddVar.zzi(zzekVar5.zzN(), 0, i7);
                        this.zzaa += i7;
                        int i8 = (this.zzag >> 1) + 1;
                        int i9 = (i8 * 6) + 2;
                        ByteBuffer byteBuffer = this.zzv;
                        if (byteBuffer == null || byteBuffer.capacity() < i9) {
                            this.zzv = ByteBuffer.allocate(i9);
                        }
                        this.zzv.position(0);
                        this.zzv.putShort((short) i8);
                        int i10 = 0;
                        int i11 = 0;
                        while (true) {
                            i2 = this.zzag;
                            if (i10 >= i2) {
                                break;
                            }
                            int iZzp = zzekVar5.zzp();
                            int i12 = iZzp - i11;
                            if (i10 % 2 == 0) {
                                this.zzv.putShort((short) i12);
                            } else {
                                this.zzv.putInt(i12);
                            }
                            i10++;
                            i11 = iZzp;
                        }
                        int i13 = (i - this.zzaa) - i11;
                        if ((i2 & 1) == 1) {
                            this.zzv.putInt(i13);
                        } else {
                            this.zzv.putShort((short) i13);
                            this.zzv.putInt(0);
                        }
                        zzek zzekVar6 = this.zzt;
                        zzekVar6.zzJ(this.zzv.array(), i9);
                        zzaeiVar.zzs(zzekVar6, i9, 1);
                        this.zzab += i9;
                    }
                }
            } else {
                byte[] bArr = zzahdVar.zzi;
                if (bArr != null) {
                    this.zzq.zzJ(bArr, bArr.length);
                }
            }
            if (!"A_OPUS".equals(zzahdVar.zzc) ? zzahdVar.zzg > 0 : z) {
                this.zzW |= 268435456;
                this.zzu.zzI(0);
                int iZzd = (this.zzq.zzd() + i) - this.zzaa;
                zzek zzekVar7 = this.zzn;
                zzekVar7.zzI(4);
                zzekVar7.zzN()[0] = (byte) ((iZzd >> 24) & 255);
                zzekVar7.zzN()[1] = (byte) ((iZzd >> 16) & 255);
                zzekVar7.zzN()[2] = (byte) ((iZzd >> 8) & 255);
                zzekVar7.zzN()[3] = (byte) (iZzd & 255);
                zzaeiVar.zzs(zzekVar7, 4, 2);
                this.zzab += 4;
            }
            this.zzad = true;
        }
        zzek zzekVar8 = this.zzq;
        int iZzd2 = i + zzekVar8.zzd();
        if (!"V_MPEG4/ISO/AVC".equals(zzahdVar.zzc) && !"V_MPEGH/ISO/HEVC".equals(zzahdVar.zzc)) {
            if (zzahdVar.zzU != null) {
                zzdc.zzf(zzekVar8.zzd() == 0);
                zzahdVar.zzU.zzd(zzaddVar);
            }
            while (true) {
                int i14 = this.zzaa;
                if (i14 >= iZzd2) {
                    break;
                }
                int iZzq = zzq(zzaddVar, zzaeiVar, iZzd2 - i14);
                this.zzaa += iZzq;
                this.zzab += iZzq;
            }
        } else {
            zzek zzekVar9 = this.zzm;
            byte[] bArrZzN = zzekVar9.zzN();
            bArrZzN[0] = 0;
            bArrZzN[1] = 0;
            bArrZzN[2] = 0;
            int i15 = zzahdVar.zzY;
            int i16 = 4 - i15;
            while (this.zzaa < iZzd2) {
                int i17 = this.zzac;
                if (i17 == 0) {
                    int iMin = Math.min(i15, zzekVar8.zza());
                    zzaddVar.zzi(bArrZzN, i16 + iMin, i15 - iMin);
                    if (iMin > 0) {
                        zzekVar8.zzH(bArrZzN, i16, iMin);
                    }
                    this.zzaa += i15;
                    zzekVar9.zzL(0);
                    this.zzac = zzekVar9.zzp();
                    zzek zzekVar10 = this.zzl;
                    zzekVar10.zzL(0);
                    zzaeiVar.zzr(zzekVar10, 4);
                    this.zzab += 4;
                } else {
                    int iZzq2 = zzq(zzaddVar, zzaeiVar, i17);
                    this.zzaa += iZzq2;
                    this.zzab += iZzq2;
                    this.zzac -= iZzq2;
                }
            }
        }
        if ("A_VORBIS".equals(zzahdVar.zzc)) {
            zzek zzekVar11 = this.zzo;
            zzekVar11.zzL(0);
            zzaeiVar.zzr(zzekVar11, 4);
            this.zzab += 4;
        }
        int i18 = this.zzab;
        zzw();
        return i18;
    }

    private final int zzq(zzadd zzaddVar, zzaei zzaeiVar, int i) throws IOException {
        zzek zzekVar = this.zzq;
        int iZza = zzekVar.zza();
        if (iZza <= 0) {
            return zzaeiVar.zzf(zzaddVar, i, false);
        }
        int iMin = Math.min(i, iZza);
        zzaeiVar.zzr(zzekVar, iMin);
        return iMin;
    }

    private final long zzr(long j) throws zzaz {
        long j2 = this.zzy;
        if (j2 != -9223372036854775807L) {
            return zzeu.zzu(j, j2, 1000L, RoundingMode.DOWN);
        }
        throw zzaz.zza("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private final void zzs(int i) throws zzaz {
        if (this.zzK == null || this.zzL == null) {
            throw zzaz.zza("Element " + i + " must be in a Cues", null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private final void zzt(int i) throws zzaz {
        if (this.zzC != null) {
            return;
        }
        throw zzaz.zza("Element " + i + " must be in a TrackEntry", null);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0090  */
    @RequiresNonNull({"#1.output"})
    private final void zzu(zzahd zzahdVar, long j, int i, int i2, int i3) {
        byte b;
        byte[] bArrZzy;
        int i4;
        int iZzd;
        zzaej zzaejVar = zzahdVar.zzU;
        if (zzaejVar != null) {
            zzaejVar.zzc(zzahdVar.zzX, j, i, i2, i3, zzahdVar.zzj);
        } else {
            if ("S_TEXT/UTF8".equals(zzahdVar.zzc) || "S_TEXT/ASS".equals(zzahdVar.zzc) || "S_TEXT/WEBVTT".equals(zzahdVar.zzc)) {
                if (this.zzS > 1) {
                    zzdx.zzf("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.zzQ;
                    if (j2 == -9223372036854775807L) {
                        zzdx.zzf("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        String str = zzahdVar.zzc;
                        zzek zzekVar = this.zzr;
                        byte[] bArrZzN = zzekVar.zzN();
                        int iHashCode = str.hashCode();
                        if (iHashCode != 738597099) {
                            if (iHashCode != 1045209816) {
                                if (iHashCode == 1422270023 && str.equals("S_TEXT/UTF8")) {
                                    b = 0;
                                } else {
                                    b = -1;
                                }
                            } else if (str.equals("S_TEXT/WEBVTT")) {
                                b = 2;
                            } else {
                                b = -1;
                            }
                        } else if (str.equals("S_TEXT/ASS")) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                        if (b == 0) {
                            bArrZzy = zzy(j2, "%02d:%02d:%02d,%03d", 1000L);
                            i4 = 19;
                        } else if (b == 1) {
                            bArrZzy = zzy(j2, "%01d:%02d:%02d:%02d", 10000L);
                            i4 = 21;
                        } else {
                            if (b != 2) {
                                throw new IllegalArgumentException();
                            }
                            bArrZzy = zzy(j2, "%02d:%02d:%02d.%03d", 1000L);
                            i4 = 25;
                        }
                        System.arraycopy(bArrZzy, 0, bArrZzN, i4, bArrZzy.length);
                        for (int iZzc = zzekVar.zzc(); iZzc < zzekVar.zzd(); iZzc++) {
                            if (zzekVar.zzN()[iZzc] == 0) {
                                zzekVar.zzK(iZzc);
                                break;
                            }
                        }
                        zzahdVar.zzX.zzr(zzekVar, zzekVar.zzd());
                        iZzd = i2 + zzekVar.zzd();
                    }
                }
                iZzd = i2;
            } else {
                iZzd = i2;
            }
            if ((i & 268435456) != 0) {
                if (this.zzS > 1) {
                    this.zzu.zzI(0);
                } else {
                    zzek zzekVar2 = this.zzu;
                    int iZzd2 = zzekVar2.zzd();
                    zzahdVar.zzX.zzs(zzekVar2, iZzd2, 2);
                    iZzd += iZzd2;
                }
            }
            zzahdVar.zzX.zzt(j, i, iZzd, i3, zzahdVar.zzj);
        }
        this.zzN = true;
    }

    private final void zzv(zzadd zzaddVar, int i) throws IOException {
        zzek zzekVar = this.zzn;
        if (zzekVar.zzd() >= i) {
            return;
        }
        if (zzekVar.zzb() < i) {
            int iZzb = zzekVar.zzb();
            zzekVar.zzF(Math.max(iZzb + iZzb, i));
        }
        zzaddVar.zzi(zzekVar.zzN(), zzekVar.zzd(), i - zzekVar.zzd());
        zzekVar.zzK(i);
    }

    private final void zzw() {
        this.zzaa = 0;
        this.zzab = 0;
        this.zzac = 0;
        this.zzad = false;
        this.zzae = false;
        this.zzaf = false;
        this.zzag = 0;
        this.zzah = (byte) 0;
        this.zzai = false;
        this.zzq.zzI(0);
    }

    private final void zzx(zzadd zzaddVar, byte[] bArr, int i) throws IOException {
        int length = bArr.length;
        int i2 = length + i;
        zzek zzekVar = this.zzr;
        if (zzekVar.zzb() < i2) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i2 + i);
            zzekVar.zzJ(bArrCopyOf, bArrCopyOf.length);
        } else {
            System.arraycopy(bArr, 0, zzekVar.zzN(), 0, length);
        }
        zzaddVar.zzi(zzekVar.zzN(), length, i);
        zzekVar.zzL(0);
        zzekVar.zzK(i2);
    }

    private static byte[] zzy(long j, String str, long j2) {
        zzdc.zzd(j != -9223372036854775807L);
        Locale locale = Locale.US;
        int i = (int) (j / 3600000000L);
        Integer numValueOf = Integer.valueOf(i);
        long j3 = j - (((long) i) * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        Integer numValueOf2 = Integer.valueOf(i2);
        long j4 = j3 - (((long) i2) * 60000000);
        int i3 = (int) (j4 / 1000000);
        String str2 = String.format(locale, str, numValueOf, numValueOf2, Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2)));
        int i4 = zzeu.zza;
        return str2.getBytes(StandardCharsets.UTF_8);
    }

    private static int[] zzz(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        int i = 0;
        this.zzN = false;
        while (!this.zzN) {
            if (this.zzak.zzc(zzaddVar)) {
                long jZzf = zzaddVar.zzf();
                if (this.zzG) {
                    this.zzI = jZzf;
                    zzadyVar.zza = this.zzH;
                    this.zzG = false;
                    return 1;
                }
                if (this.zzD) {
                    long j = this.zzI;
                    if (j != -1) {
                        zzadyVar.zza = j;
                        this.zzI = -1L;
                        return 1;
                    }
                }
            } else {
                while (true) {
                    SparseArray sparseArray = this.zzh;
                    if (i >= sparseArray.size()) {
                        return -1;
                    }
                    zzahd zzahdVar = (zzahd) sparseArray.valueAt(i);
                    zzahdVar.zzX.getClass();
                    zzaej zzaejVar = zzahdVar.zzU;
                    if (zzaejVar != null) {
                        zzaejVar.zza(zzahdVar.zzX, zzahdVar.zzj);
                    }
                    i++;
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ zzadc zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ List zzd() {
        return zzfww.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zze(zzadf zzadfVar) {
        if (this.zzj) {
            zzadfVar = new zzakb(zzadfVar, this.zzk);
        }
        this.zzaj = zzadfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        this.zzJ = -9223372036854775807L;
        int i = 0;
        this.zzO = 0;
        this.zzak.zzb();
        this.zzg.zze();
        zzw();
        while (true) {
            SparseArray sparseArray = this.zzh;
            if (i >= sparseArray.size()) {
                return;
            }
            zzaej zzaejVar = ((zzahd) sparseArray.valueAt(i)).zzU;
            if (zzaejVar != null) {
                zzaejVar.zzb();
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        return new zzahg().zza(zzaddVar);
    }

    protected final void zzj(int i) throws zzaz {
        int i2;
        zzaeb zzaeaVar;
        int i3;
        zzdc.zzb(this.zzaj);
        byte b = 8;
        int i4 = 0;
        if (i == 160) {
            if (this.zzO == 2) {
                zzahd zzahdVar = (zzahd) this.zzh.get(this.zzU);
                zzahdVar.zzX.getClass();
                if (this.zzZ > 0 && "A_OPUS".equals(zzahdVar.zzc)) {
                    zzek zzekVar = this.zzu;
                    byte[] bArrArray = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzZ).array();
                    zzekVar.zzJ(bArrArray, bArrArray.length);
                }
                int i5 = 0;
                for (int i6 = 0; i6 < this.zzS; i6++) {
                    i5 += this.zzT[i6];
                }
                int i7 = 0;
                while (i7 < this.zzS) {
                    long j = this.zzP + ((long) ((zzahdVar.zzf * i7) / 1000));
                    int i8 = this.zzW;
                    if (i7 == 0) {
                        if (!this.zzY) {
                            i8 |= 1;
                        }
                        i2 = 0;
                    } else {
                        i2 = i7;
                    }
                    int i9 = this.zzT[i2];
                    int i10 = i5 - i9;
                    zzu(zzahdVar, j, i8, i9, i10);
                    i7 = i2 + 1;
                    i5 = i10;
                }
                this.zzO = 0;
                return;
            }
            return;
        }
        if (i != 174) {
            if (i == 19899) {
                int i11 = this.zzE;
                if (i11 != -1) {
                    long j2 = this.zzF;
                    if (j2 != -1) {
                        if (i11 == 475249515) {
                            this.zzH = j2;
                            return;
                        }
                        return;
                    }
                }
                throw zzaz.zza("Mandatory element SeekID or SeekPosition not found", null);
            }
            if (i == 25152) {
                zzt(i);
                zzahd zzahdVar2 = this.zzC;
                if (zzahdVar2.zzh) {
                    if (zzahdVar2.zzj == null) {
                        throw zzaz.zza("Encrypted Track found but ContentEncKeyID was not found", null);
                    }
                    zzahdVar2.zzl = new zzs(null, new zzr(zzh.zza, null, "video/webm", this.zzC.zzj.zzb));
                    return;
                }
                return;
            }
            if (i == 28032) {
                zzt(i);
                zzahd zzahdVar3 = this.zzC;
                if (zzahdVar3.zzh && zzahdVar3.zzi != null) {
                    throw zzaz.zza("Combining encryption and compression is not supported", null);
                }
                return;
            }
            if (i == 357149030) {
                if (this.zzy == -9223372036854775807L) {
                    this.zzy = 1000000L;
                }
                long j3 = this.zzz;
                if (j3 != -9223372036854775807L) {
                    this.zzA = zzr(j3);
                    return;
                }
                return;
            }
            if (i == 374648427) {
                if (this.zzh.size() == 0) {
                    throw zzaz.zza("No valid tracks were found", null);
                }
                this.zzaj.zzG();
                return;
            }
            if (i != 475249515) {
                return;
            }
            if (!this.zzD) {
                zzadf zzadfVar = this.zzaj;
                zzdy zzdyVar = this.zzK;
                zzdy zzdyVar2 = this.zzL;
                if (this.zzx == -1 || this.zzA == -9223372036854775807L || zzdyVar == null || zzdyVar.zza() == 0 || zzdyVar2 == null || zzdyVar2.zza() != zzdyVar.zza()) {
                    zzaeaVar = new zzaea(this.zzA, 0L);
                } else {
                    int iZza = zzdyVar.zza();
                    int[] iArrCopyOf = new int[iZza];
                    long[] jArrCopyOf = new long[iZza];
                    long[] jArrCopyOf2 = new long[iZza];
                    long[] jArrCopyOf3 = new long[iZza];
                    for (int i12 = 0; i12 < iZza; i12++) {
                        jArrCopyOf3[i12] = zzdyVar.zzb(i12);
                        jArrCopyOf[i12] = this.zzx + zzdyVar2.zzb(i12);
                    }
                    while (true) {
                        i3 = iZza - 1;
                        if (i4 >= i3) {
                            break;
                        }
                        int i13 = i4 + 1;
                        iArrCopyOf[i4] = (int) (jArrCopyOf[i13] - jArrCopyOf[i4]);
                        jArrCopyOf2[i4] = jArrCopyOf3[i13] - jArrCopyOf3[i4];
                        i4 = i13;
                    }
                    int i14 = i3;
                    while (i14 > 0 && jArrCopyOf3[i14] > this.zzA) {
                        i14--;
                    }
                    iArrCopyOf[i14] = (int) ((this.zzx + this.zzw) - jArrCopyOf[i14]);
                    jArrCopyOf2[i14] = this.zzA - jArrCopyOf3[i14];
                    if (i14 < i3) {
                        zzdx.zzf("MatroskaExtractor", "Discarding trailing cue points with timestamps greater than total duration");
                        int i15 = i14 + 1;
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i15);
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i15);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i15);
                        jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i15);
                    }
                    zzaeaVar = new zzacp(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
                }
                zzadfVar.zzP(zzaeaVar);
                this.zzD = true;
            }
            this.zzK = null;
            this.zzL = null;
            return;
        }
        zzahd zzahdVar4 = this.zzC;
        zzdc.zzb(zzahdVar4);
        String str = zzahdVar4.zzc;
        if (str == null) {
            throw zzaz.zza("CodecId is missing in TrackEntry element", null);
        }
        switch (str.hashCode()) {
            case -2095576542:
                b = str.equals("V_MPEG4/ISO/AP") ? (byte) 6 : (byte) -1;
                break;
            case -2095575984:
                b = str.equals("V_MPEG4/ISO/SP") ? (byte) 4 : (byte) -1;
                break;
            case -1985379776:
                b = str.equals("A_MS/ACM") ? Ascii.ETB : (byte) -1;
                break;
            case -1784763192:
                b = str.equals("A_TRUEHD") ? Ascii.DC2 : (byte) -1;
                break;
            case -1730367663:
                b = str.equals("A_VORBIS") ? Ascii.FF : (byte) -1;
                break;
            case -1482641358:
                b = str.equals("A_MPEG/L2") ? Ascii.SO : (byte) -1;
                break;
            case -1482641357:
                b = str.equals("A_MPEG/L3") ? Ascii.SI : (byte) -1;
                break;
            case -1373388978:
                b = str.equals("V_MS/VFW/FOURCC") ? (byte) 9 : (byte) -1;
                break;
            case -933872740:
                b = str.equals("S_DVBSUB") ? (byte) 32 : (byte) -1;
                break;
            case -538363189:
                b = str.equals("V_MPEG4/ISO/ASP") ? (byte) 5 : (byte) -1;
                break;
            case -538363109:
                b = str.equals("V_MPEG4/ISO/AVC") ? (byte) 7 : (byte) -1;
                break;
            case -425012669:
                b = str.equals("S_VOBSUB") ? Ascii.RS : (byte) -1;
                break;
            case -356037306:
                b = str.equals("A_DTS/LOSSLESS") ? Ascii.NAK : (byte) -1;
                break;
            case 62923557:
                b = str.equals("A_AAC") ? Ascii.CR : (byte) -1;
                break;
            case 62923603:
                b = str.equals("A_AC3") ? Ascii.DLE : (byte) -1;
                break;
            case 62927045:
                b = str.equals("A_DTS") ? (byte) 19 : (byte) -1;
                break;
            case 82318131:
                b = str.equals("V_AV1") ? (byte) 2 : (byte) -1;
                break;
            case 82338133:
                b = str.equals("V_VP8") ? (byte) 0 : (byte) -1;
                break;
            case 82338134:
                b = str.equals("V_VP9") ? (byte) 1 : (byte) -1;
                break;
            case 99146302:
                b = str.equals("S_HDMV/PGS") ? Ascii.US : (byte) -1;
                break;
            case 444813526:
                b = str.equals("V_THEORA") ? (byte) 10 : (byte) -1;
                break;
            case 542569478:
                b = str.equals("A_DTS/EXPRESS") ? Ascii.DC4 : (byte) -1;
                break;
            case 635596514:
                b = str.equals("A_PCM/FLOAT/IEEE") ? Ascii.SUB : (byte) -1;
                break;
            case 725948237:
                b = str.equals("A_PCM/INT/BIG") ? Ascii.EM : (byte) -1;
                break;
            case 725957860:
                b = str.equals("A_PCM/INT/LIT") ? Ascii.CAN : (byte) -1;
                break;
            case 738597099:
                b = str.equals("S_TEXT/ASS") ? Ascii.FS : (byte) -1;
                break;
            case 855502857:
                if (!str.equals("V_MPEGH/ISO/HEVC")) {
                    b = -1;
                }
                break;
            case 1045209816:
                b = str.equals("S_TEXT/WEBVTT") ? Ascii.GS : (byte) -1;
                break;
            case 1422270023:
                b = str.equals("S_TEXT/UTF8") ? Ascii.ESC : (byte) -1;
                break;
            case 1809237540:
                b = str.equals("V_MPEG2") ? (byte) 3 : (byte) -1;
                break;
            case 1950749482:
                b = str.equals("A_EAC3") ? (byte) 17 : (byte) -1;
                break;
            case 1950789798:
                b = str.equals("A_FLAC") ? Ascii.SYN : (byte) -1;
                break;
            case 1951062397:
                b = str.equals("A_OPUS") ? Ascii.VT : (byte) -1;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                zzahdVar4.zze(this.zzaj, zzahdVar4.zzd);
                this.zzh.put(zzahdVar4.zzd, zzahdVar4);
                break;
        }
        this.zzC = null;
    }

    protected final void zzm(int i, long j, long j2) throws zzaz {
        zzdc.zzb(this.zzaj);
        if (i == 160) {
            this.zzY = false;
            this.zzZ = 0L;
            return;
        }
        if (i == 174) {
            zzahd zzahdVar = new zzahd();
            this.zzC = zzahdVar;
            zzahdVar.zza = this.zzB;
            return;
        }
        if (i == 187) {
            this.zzM = false;
            return;
        }
        if (i == 19899) {
            this.zzE = -1;
            this.zzF = -1L;
            return;
        }
        if (i == 20533) {
            zzt(i);
            this.zzC.zzh = true;
            return;
        }
        if (i == 21968) {
            zzt(i);
            this.zzC.zzy = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.zzx;
            if (j3 != -1 && j3 != j) {
                throw zzaz.zza("Multiple Segment elements not supported", null);
            }
            this.zzx = j;
            this.zzw = j2;
            return;
        }
        if (i == 475249515) {
            this.zzK = new zzdy(32);
            this.zzL = new zzdy(32);
        } else if (i == 524531317 && !this.zzD) {
            if (this.zzi && this.zzH != -1) {
                this.zzG = true;
            } else {
                this.zzaj.zzP(new zzaea(this.zzA, 0L));
                this.zzD = true;
            }
        }
    }

    zzahf(zzaha zzahaVar, int i, zzajy zzajyVar) {
        this.zzx = -1L;
        this.zzy = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzH = -1L;
        this.zzI = -1L;
        this.zzJ = -9223372036854775807L;
        this.zzak = zzahaVar;
        zzahaVar.zza(new zzahc(this, null));
        this.zzk = zzajyVar;
        this.zzi = 1 == ((i & 1) ^ 1);
        this.zzj = (i & 2) == 0;
        this.zzg = new zzahh();
        this.zzh = new SparseArray();
        this.zzn = new zzek(4);
        this.zzo = new zzek(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzp = new zzek(4);
        this.zzl = new zzek(zzfq.zza);
        this.zzm = new zzek(4);
        this.zzq = new zzek();
        this.zzr = new zzek();
        this.zzs = new zzek(8);
        this.zzt = new zzek();
        this.zzu = new zzek();
        this.zzT = new int[1];
    }

    protected final void zzn(int i, String str) throws zzaz {
        if (i == 134) {
            zzt(i);
            this.zzC.zzc = str;
            return;
        }
        if (i == 17026) {
            if ("webm".equals(str) || "matroska".equals(str)) {
                this.zzB = Objects.equals(str, "webm");
                return;
            }
            throw zzaz.zza("DocType " + str + " not supported", null);
        }
        if (i == 21358) {
            zzt(i);
            this.zzC.zzb = str;
        } else {
            if (i != 2274716) {
                return;
            }
            zzt(i);
            this.zzC.zzaa = str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0290  */
    /* JADX WARN: Code duplicated, block: B:112:0x0294  */
    /* JADX WARN: Code duplicated, block: B:114:0x029f  */
    /* JADX WARN: Code duplicated, block: B:115:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:117:0x02a6 A[PHI: r0
  0x02a6: PHI (r0v18 int) = (r0v0 int), (r0v25 int) binds: [B:109:0x028e, B:114:0x029f] A[DONT_GENERATE, DONT_INLINE]] */
    protected final void zzh(int i, int i2, zzadd zzaddVar) throws IOException {
        zzahd zzahdVar;
        int i3;
        zzahd zzahdVar2;
        zzahd zzahdVar3;
        long j;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = i;
        int i9 = 1;
        int i10 = 0;
        if (i8 != 161 && i8 != 163) {
            if (i8 == 165) {
                if (this.zzO != 2) {
                    return;
                }
                zzahd zzahdVar4 = (zzahd) this.zzh.get(this.zzU);
                if (this.zzX != 4 || !"V_VP9".equals(zzahdVar4.zzc)) {
                    zzaddVar.zzk(i2);
                    return;
                }
                zzek zzekVar = this.zzu;
                zzekVar.zzI(i2);
                zzaddVar.zzi(zzekVar.zzN(), 0, i2);
                return;
            }
            if (i8 == 16877) {
                zzt(i);
                zzahd zzahdVar5 = this.zzC;
                if (zzahdVar5.zzZ != 1685485123 && zzahdVar5.zzZ != 1685480259) {
                    zzaddVar.zzk(i2);
                    return;
                } else {
                    zzahdVar5.zzO = new byte[i2];
                    zzaddVar.zzi(zzahdVar5.zzO, 0, i2);
                    return;
                }
            }
            if (i8 == 16981) {
                zzt(i);
                zzahd zzahdVar6 = this.zzC;
                zzahdVar6.zzi = new byte[i2];
                zzaddVar.zzi(zzahdVar6.zzi, 0, i2);
                return;
            }
            if (i8 == 18402) {
                byte[] bArr = new byte[i2];
                zzaddVar.zzi(bArr, 0, i2);
                zzt(i);
                this.zzC.zzj = new zzaeh(1, bArr, 0, 0);
                return;
            }
            if (i8 == 21419) {
                zzek zzekVar2 = this.zzp;
                Arrays.fill(zzekVar2.zzN(), (byte) 0);
                zzaddVar.zzi(zzekVar2.zzN(), 4 - i2, i2);
                zzekVar2.zzL(0);
                this.zzE = (int) zzekVar2.zzu();
                return;
            }
            if (i8 == 25506) {
                zzt(i);
                zzahd zzahdVar7 = this.zzC;
                zzahdVar7.zzk = new byte[i2];
                zzaddVar.zzi(zzahdVar7.zzk, 0, i2);
                return;
            }
            if (i8 != 30322) {
                throw zzaz.zza("Unexpected id: " + i8, null);
            }
            zzt(i);
            zzahd zzahdVar8 = this.zzC;
            zzahdVar8.zzw = new byte[i2];
            zzaddVar.zzi(zzahdVar8.zzw, 0, i2);
            return;
        }
        int i11 = 8;
        if (this.zzO == 0) {
            zzahh zzahhVar = this.zzg;
            this.zzU = (int) zzahhVar.zzd(zzaddVar, false, true, 8);
            this.zzV = zzahhVar.zza();
            this.zzQ = -9223372036854775807L;
            this.zzO = 1;
            this.zzn.zzI(0);
        }
        zzahd zzahdVar9 = (zzahd) this.zzh.get(this.zzU);
        if (zzahdVar9 == null) {
            zzaddVar.zzk(i2 - this.zzV);
            this.zzO = 0;
            return;
        }
        zzahdVar9.zzX.getClass();
        if (this.zzO == 1) {
            zzv(zzaddVar, 3);
            zzek zzekVar3 = this.zzn;
            int i12 = (zzekVar3.zzN()[2] & 6) >> 1;
            if (i12 == 0) {
                this.zzS = 1;
                int[] iArrZzz = zzz(this.zzT, 1);
                this.zzT = iArrZzz;
                iArrZzz[0] = (i2 - this.zzV) - 3;
            } else {
                zzv(zzaddVar, 4);
                int i13 = (zzekVar3.zzN()[3] & 255) + 1;
                this.zzS = i13;
                int[] iArrZzz2 = zzz(this.zzT, i13);
                this.zzT = iArrZzz2;
                if (i12 == 2) {
                    int i14 = (i2 - this.zzV) - 4;
                    int i15 = this.zzS;
                    Arrays.fill(iArrZzz2, 0, i15, i14 / i15);
                } else {
                    if (i12 == 1) {
                        int i16 = 0;
                        int i17 = 0;
                        int i18 = 4;
                        while (true) {
                            i4 = this.zzS - 1;
                            if (i16 >= i4) {
                                break;
                            }
                            this.zzT[i16] = 0;
                            while (true) {
                                i5 = i18 + 1;
                                zzv(zzaddVar, i5);
                                int i19 = zzekVar3.zzN()[i18] & 255;
                                int[] iArr = this.zzT;
                                i6 = iArr[i16] + i19;
                                iArr[i16] = i6;
                                if (i19 != 255) {
                                    break;
                                } else {
                                    i18 = i5;
                                }
                            }
                            i17 += i6;
                            i16++;
                            i18 = i5;
                        }
                        this.zzT[i4] = ((i2 - this.zzV) - i18) - i17;
                    } else {
                        if (i12 != 3) {
                            throw zzaz.zza("Unexpected lacing value: 2", null);
                        }
                        int i20 = 0;
                        int i21 = 0;
                        int i22 = 4;
                        while (true) {
                            int i23 = this.zzS - 1;
                            if (i20 >= i23) {
                                zzahdVar2 = zzahdVar9;
                                this.zzT[i23] = ((i2 - this.zzV) - i22) - i21;
                                break;
                            }
                            this.zzT[i20] = i10;
                            int i24 = i22 + 1;
                            zzv(zzaddVar, i24);
                            if (zzekVar3.zzN()[i22] == 0) {
                                throw zzaz.zza("No valid varint length mask found", null);
                            }
                            int i25 = i10;
                            while (true) {
                                if (i25 >= i11) {
                                    zzahdVar3 = zzahdVar9;
                                    j = 0;
                                    break;
                                }
                                int i26 = i9 << (7 - i25);
                                if ((zzekVar3.zzN()[i22] & i26) != 0) {
                                    i24 += i25;
                                    zzv(zzaddVar, i24);
                                    j = zzekVar3.zzN()[i22] & 255 & (~i26);
                                    int i27 = i22 + 1;
                                    while (i27 < i24) {
                                        j = (j << i11) | ((long) (zzekVar3.zzN()[i27] & 255));
                                        i27++;
                                        zzahdVar9 = zzahdVar9;
                                        i11 = 8;
                                    }
                                    zzahdVar3 = zzahdVar9;
                                    if (i20 <= 0) {
                                        break;
                                    }
                                    j -= (1 << ((i25 * 7) + 6)) - 1;
                                    break;
                                }
                                i25++;
                                i9 = 1;
                                i11 = 8;
                            }
                            i22 = i24;
                            if (j < -2147483648L || j > 2147483647L) {
                                throw zzaz.zza("EBML lacing sample size out of range.", null);
                            }
                            int[] iArr2 = this.zzT;
                            int i28 = (int) j;
                            if (i20 != 0) {
                                i28 += iArr2[i20 - 1];
                            }
                            iArr2[i20] = i28;
                            i21 += i28;
                            i20++;
                            zzahdVar9 = zzahdVar3;
                            i9 = 1;
                            i10 = 0;
                            i11 = 8;
                        }
                    }
                    this.zzP = this.zzJ + zzr((zzekVar3.zzN()[0] << 8) | (zzekVar3.zzN()[1] & 255));
                    zzahdVar = zzahdVar2;
                    if (zzahdVar.zze == 2) {
                        i7 = 1;
                    } else {
                        if (i8 == 163) {
                            if ((zzekVar3.zzN()[2] & 128) == 128) {
                                i8 = 163;
                                i7 = 1;
                            } else {
                                i8 = 163;
                            }
                        }
                        i7 = 0;
                    }
                    this.zzW = i7;
                    this.zzO = 2;
                    this.zzR = 0;
                    i3 = 163;
                }
            }
            zzahdVar2 = zzahdVar9;
            this.zzP = this.zzJ + zzr((zzekVar3.zzN()[0] << 8) | (zzekVar3.zzN()[1] & 255));
            zzahdVar = zzahdVar2;
            if (zzahdVar.zze == 2) {
                i7 = 1;
            } else {
                if (i8 == 163) {
                    if ((zzekVar3.zzN()[2] & 128) == 128) {
                        i8 = 163;
                        i7 = 1;
                    } else {
                        i8 = 163;
                    }
                }
                i7 = 0;
            }
            this.zzW = i7;
            this.zzO = 2;
            this.zzR = 0;
            i3 = 163;
        } else {
            zzahdVar = zzahdVar9;
            i3 = 163;
        }
        if (i8 == i3) {
            while (true) {
                int i29 = this.zzR;
                if (i29 >= this.zzS) {
                    this.zzO = 0;
                    return;
                }
                zzu(zzahdVar, ((long) ((this.zzR * zzahdVar.zzf) / 1000)) + this.zzP, this.zzW, zzp(zzaddVar, zzahdVar, this.zzT[i29], false), 0);
                this.zzR++;
            }
        } else {
            while (true) {
                int i30 = this.zzR;
                if (i30 >= this.zzS) {
                    return;
                }
                int[] iArr3 = this.zzT;
                iArr3[i30] = zzp(zzaddVar, zzahdVar, iArr3[i30], true);
                this.zzR++;
            }
        }
    }

    public zzahf(zzajy zzajyVar, int i) {
        this(new zzaha(), 0, zzajyVar);
    }

    protected final void zzk(int i, double d) throws zzaz {
        if (i == 181) {
            zzt(i);
            this.zzC.zzR = (int) d;
            return;
        }
        if (i == 17545) {
            this.zzz = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                zzt(i);
                this.zzC.zzE = (float) d;
                break;
            case 21970:
                zzt(i);
                this.zzC.zzF = (float) d;
                break;
            case 21971:
                zzt(i);
                this.zzC.zzG = (float) d;
                break;
            case 21972:
                zzt(i);
                this.zzC.zzH = (float) d;
                break;
            case 21973:
                zzt(i);
                this.zzC.zzI = (float) d;
                break;
            case 21974:
                zzt(i);
                this.zzC.zzJ = (float) d;
                break;
            case 21975:
                zzt(i);
                this.zzC.zzK = (float) d;
                break;
            case 21976:
                zzt(i);
                this.zzC.zzL = (float) d;
                break;
            case 21977:
                zzt(i);
                this.zzC.zzM = (float) d;
                break;
            case 21978:
                zzt(i);
                this.zzC.zzN = (float) d;
                break;
            default:
                switch (i) {
                    case 30323:
                        zzt(i);
                        this.zzC.zzt = (float) d;
                        break;
                    case 30324:
                        zzt(i);
                        this.zzC.zzu = (float) d;
                        break;
                    case 30325:
                        zzt(i);
                        this.zzC.zzv = (float) d;
                        break;
                }
                break;
        }
    }

    protected final void zzl(int i, long j) throws zzaz {
        boolean z;
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw zzaz.zza("ContentEncodingOrder " + j + " not supported", null);
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw zzaz.zza("ContentEncodingScope " + j + " not supported", null);
        }
        switch (i) {
            case MRAID_JS_WRITE_FAILED_VALUE:
                zzt(i);
                this.zzC.zze = (int) j;
                return;
            case 136:
                z = j == 1;
                zzt(i);
                this.zzC.zzW = z;
                return;
            case 155:
                this.zzQ = zzr(j);
                return;
            case 159:
                zzt(i);
                this.zzC.zzP = (int) j;
                return;
            case 176:
                zzt(i);
                this.zzC.zzm = (int) j;
                return;
            case 179:
                zzs(i);
                this.zzK.zzc(zzr(j));
                return;
            case 186:
                zzt(i);
                this.zzC.zzn = (int) j;
                return;
            case AD_RESPONSE_EMPTY_VALUE:
                zzt(i);
                this.zzC.zzd = (int) j;
                return;
            case 231:
                this.zzJ = zzr(j);
                return;
            case 238:
                this.zzX = (int) j;
                return;
            case 241:
                if (this.zzM) {
                    return;
                }
                zzs(i);
                this.zzL.zzc(j);
                this.zzM = true;
                return;
            case 251:
                this.zzY = true;
                return;
            case 16871:
                zzt(i);
                this.zzC.zzZ = (int) j;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                throw zzaz.zza("ContentCompAlgo " + j + " not supported", null);
            case 17029:
                if (j < 1 || j > 2) {
                    throw zzaz.zza("DocTypeReadVersion " + j + " not supported", null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                throw zzaz.zza("EBMLReadVersion " + j + " not supported", null);
            case 18401:
                if (j == 5) {
                    return;
                }
                throw zzaz.zza("ContentEncAlgo " + j + " not supported", null);
            case 18408:
                if (j == 1) {
                    return;
                }
                throw zzaz.zza("AESSettingsCipherMode " + j + " not supported", null);
            case 21420:
                this.zzF = j + this.zzx;
                return;
            case 21432:
                int i2 = (int) j;
                zzt(i);
                if (i2 == 0) {
                    this.zzC.zzx = 0;
                    return;
                }
                if (i2 == 1) {
                    this.zzC.zzx = 2;
                    return;
                } else if (i2 == 3) {
                    this.zzC.zzx = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.zzC.zzx = 3;
                    return;
                }
            case 21680:
                zzt(i);
                this.zzC.zzp = (int) j;
                return;
            case 21682:
                zzt(i);
                this.zzC.zzr = (int) j;
                return;
            case 21690:
                zzt(i);
                this.zzC.zzq = (int) j;
                return;
            case 21930:
                z = j == 1;
                zzt(i);
                this.zzC.zzV = z;
                return;
            case 21938:
                zzt(i);
                zzahd zzahdVar = this.zzC;
                zzahdVar.zzy = true;
                zzahdVar.zzo = (int) j;
                return;
            case 21998:
                zzt(i);
                this.zzC.zzg = (int) j;
                return;
            case 22186:
                zzt(i);
                this.zzC.zzS = j;
                return;
            case 22203:
                zzt(i);
                this.zzC.zzT = j;
                return;
            case 25188:
                zzt(i);
                this.zzC.zzQ = (int) j;
                return;
            case 30114:
                this.zzZ = j;
                return;
            case 30321:
                int i3 = (int) j;
                zzt(i);
                if (i3 == 0) {
                    this.zzC.zzs = 0;
                    return;
                }
                if (i3 == 1) {
                    this.zzC.zzs = 1;
                    return;
                } else if (i3 == 2) {
                    this.zzC.zzs = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.zzC.zzs = 3;
                    return;
                }
            case 2352003:
                zzt(i);
                this.zzC.zzf = (int) j;
                return;
            case 2807729:
                this.zzy = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        int i4 = (int) j;
                        zzt(i);
                        if (i4 == 1) {
                            this.zzC.zzB = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.zzC.zzB = 1;
                            return;
                        }
                    case 21946:
                        zzt(i);
                        int iZzb = zzk.zzb((int) j);
                        if (iZzb != -1) {
                            this.zzC.zzA = iZzb;
                            return;
                        }
                        return;
                    case 21947:
                        zzt(i);
                        this.zzC.zzy = true;
                        int iZza = zzk.zza((int) j);
                        if (iZza != -1) {
                            this.zzC.zzz = iZza;
                            return;
                        }
                        return;
                    case 21948:
                        zzt(i);
                        this.zzC.zzC = (int) j;
                        return;
                    case 21949:
                        zzt(i);
                        this.zzC.zzD = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }
}
