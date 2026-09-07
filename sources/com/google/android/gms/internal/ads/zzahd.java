package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzahd {
    public byte[] zzO;
    public zzaej zzU;
    public boolean zzV;
    public zzaei zzX;
    public int zzY;
    private int zzZ;
    public boolean zza;
    public String zzb;
    public String zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public boolean zzh;
    public byte[] zzi;
    public zzaeh zzj;
    public byte[] zzk;
    public zzs zzl;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = -1;
    public int zzq = -1;
    public int zzr = 0;
    public int zzs = -1;
    public float zzt = 0.0f;
    public float zzu = 0.0f;
    public float zzv = 0.0f;
    public byte[] zzw = null;
    public int zzx = -1;
    public boolean zzy = false;
    public int zzz = -1;
    public int zzA = -1;
    public int zzB = -1;
    public int zzC = 1000;
    public int zzD = 200;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public float zzM = -1.0f;
    public float zzN = -1.0f;
    public int zzP = 1;
    public int zzQ = -1;
    public int zzR = 8000;
    public long zzS = 0;
    public long zzT = 0;
    public boolean zzW = true;
    private String zzaa = "eng";

    protected zzahd() {
    }

    private static Pair zzf(zzek zzekVar) throws zzaz {
        try {
            zzekVar.zzM(16);
            long jZzs = zzekVar.zzs();
            if (jZzs == 1482049860) {
                return new Pair("video/divx", null);
            }
            if (jZzs == 859189832) {
                return new Pair("video/3gpp", null);
            }
            if (jZzs != 826496599) {
                zzdx.zzf("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair("video/x-unknown", null);
            }
            int iZzc = zzekVar.zzc() + 20;
            byte[] bArrZzN = zzekVar.zzN();
            while (true) {
                int length = bArrZzN.length;
                if (iZzc >= length - 4) {
                    throw zzaz.zza("Failed to find FourCC VC1 initialization data", null);
                }
                int i = iZzc + 1;
                if (bArrZzN[iZzc] == 0 && bArrZzN[i] == 0 && bArrZzN[iZzc + 2] == 1 && bArrZzN[iZzc + 3] == 15) {
                    return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrZzN, iZzc, length)));
                }
                iZzc = i;
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzaz.zza("Error parsing FourCC private data", null);
        }
    }

    private static List zzg(byte[] bArr) throws zzaz {
        int i;
        int i2;
        try {
            if (bArr[0] != 2) {
                throw zzaz.zza("Error parsing vorbis codec private", null);
            }
            int i3 = 0;
            int i4 = 1;
            while (true) {
                int i5 = bArr[i4];
                i4++;
                i = i5 & 255;
                if (i != 255) {
                    break;
                }
                i3 += 255;
            }
            int i6 = i3 + i;
            int i7 = 0;
            while (true) {
                int i8 = bArr[i4];
                i4++;
                i2 = i8 & 255;
                if (i2 != 255) {
                    break;
                }
                i7 += 255;
            }
            int i9 = i7 + i2;
            if (bArr[i4] != 1) {
                throw zzaz.zza("Error parsing vorbis codec private", null);
            }
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i4, bArr2, 0, i6);
            int i10 = i4 + i6;
            if (bArr[i10] != 3) {
                throw zzaz.zza("Error parsing vorbis codec private", null);
            }
            int i11 = i10 + i9;
            if (bArr[i11] != 5) {
                throw zzaz.zza("Error parsing vorbis codec private", null);
            }
            int length = bArr.length - i11;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i11, bArr3, 0, length);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzaz.zza("Error parsing vorbis codec private", null);
        }
    }

    private static boolean zzh(zzek zzekVar) throws zzaz {
        try {
            int iZzk = zzekVar.zzk();
            if (iZzk == 1) {
                return true;
            }
            if (iZzk == 65534) {
                zzekVar.zzL(24);
                if (zzekVar.zzt() == zzahf.zze.getMostSignificantBits() && zzekVar.zzt() == zzahf.zze.getLeastSignificantBits()) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzaz.zza("Error parsing MS/ACM codec private", null);
        }
    }

    @EnsuresNonNull({"codecPrivate"})
    private final byte[] zzi(String str) throws zzaz {
        byte[] bArr = this.zzk;
        if (bArr != null) {
            return bArr;
        }
        throw zzaz.zza("Missing CodecPrivate for codec ".concat(String.valueOf(str)), null);
    }

    /* JADX WARN: Code duplicated, block: B:132:0x024f A[PHI: r10
  0x024f: PHI (r10v11 int) = (r10v5 int), (r10v6 int), (r10v7 int), (r10v8 int), (r10v9 int), (r10v10 int), (r10v0 int) binds: [B:136:0x0269, B:130:0x0236, B:127:0x0218, B:125:0x0213, B:123:0x020e, B:121:0x020a, B:116:0x01ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:181:0x03be  */
    /* JADX WARN: Code duplicated, block: B:186:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:187:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:190:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:191:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:193:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:195:0x0400  */
    /* JADX WARN: Code duplicated, block: B:197:0x0404  */
    /* JADX WARN: Code duplicated, block: B:200:0x040c  */
    /* JADX WARN: Code duplicated, block: B:204:0x0416  */
    /* JADX WARN: Code duplicated, block: B:207:0x0424  */
    /* JADX WARN: Code duplicated, block: B:210:0x0429  */
    /* JADX WARN: Code duplicated, block: B:212:0x042f  */
    /* JADX WARN: Code duplicated, block: B:232:0x04e2  */
    /* JADX WARN: Code duplicated, block: B:234:0x0509  */
    /* JADX WARN: Code duplicated, block: B:237:0x050e  */
    /* JADX WARN: Code duplicated, block: B:242:0x052e  */
    /* JADX WARN: Code duplicated, block: B:261:0x057a  */
    /* JADX WARN: Code duplicated, block: B:263:0x059a  */
    /* JADX WARN: Code duplicated, block: B:265:0x05a0  */
    /* JADX WARN: Code duplicated, block: B:280:0x05d3  */
    /* JADX WARN: Code duplicated, block: B:285:0x05ed  */
    /* JADX WARN: Code duplicated, block: B:286:0x05f0  */
    @EnsuresNonNull({"this.output"})
    @RequiresNonNull({"codecId"})
    public final void zze(zzadf zzadfVar, int i) throws zzaz {
        byte b;
        List listZzo;
        List listZzp;
        String str;
        String str2;
        int i2;
        List listZzg;
        int i3;
        String str3;
        int i4;
        zzx zzxVar;
        int i5;
        float f;
        zzk zzkVarZzg;
        byte[] bArr;
        int i6;
        int i7;
        int i8;
        String str4;
        zzacy zzacyVarZza;
        String str5 = this.zzc;
        int iZzn = 4;
        int i9 = 0;
        int i10 = 3;
        int iIntValue = -1;
        switch (str5) {
            case "V_MPEG4/ISO/AP":
                b = 6;
                break;
            case "V_MPEG4/ISO/SP":
                b = 4;
                break;
            case "A_MS/ACM":
                b = Ascii.ETB;
                break;
            case "A_TRUEHD":
                b = Ascii.DC2;
                break;
            case "A_VORBIS":
                b = Ascii.VT;
                break;
            case "A_MPEG/L2":
                b = Ascii.SO;
                break;
            case "A_MPEG/L3":
                b = Ascii.SI;
                break;
            case "V_MS/VFW/FOURCC":
                b = 9;
                break;
            case "S_DVBSUB":
                b = 32;
                break;
            case "V_MPEG4/ISO/ASP":
                b = 5;
                break;
            case "V_MPEG4/ISO/AVC":
                b = 7;
                break;
            case "S_VOBSUB":
                b = Ascii.RS;
                break;
            case "A_DTS/LOSSLESS":
                b = Ascii.NAK;
                break;
            case "A_AAC":
                b = Ascii.CR;
                break;
            case "A_AC3":
                b = 16;
                break;
            case "A_DTS":
                b = 19;
                break;
            case "V_AV1":
                b = 2;
                break;
            case "V_VP8":
                b = 0;
                break;
            case "V_VP9":
                b = 1;
                break;
            case "S_HDMV/PGS":
                b = Ascii.US;
                break;
            case "V_THEORA":
                b = 10;
                break;
            case "A_DTS/EXPRESS":
                b = Ascii.DC4;
                break;
            case "A_PCM/FLOAT/IEEE":
                b = Ascii.SUB;
                break;
            case "A_PCM/INT/BIG":
                b = Ascii.EM;
                break;
            case "A_PCM/INT/LIT":
                b = 24;
                break;
            case "S_TEXT/ASS":
                b = Ascii.FS;
                break;
            case "V_MPEGH/ISO/HEVC":
                b = 8;
                break;
            case "S_TEXT/WEBVTT":
                b = Ascii.GS;
                break;
            case "S_TEXT/UTF8":
                b = Ascii.ESC;
                break;
            case "V_MPEG2":
                b = 3;
                break;
            case "A_EAC3":
                b = 17;
                break;
            case "A_FLAC":
                b = Ascii.SYN;
                break;
            case "A_OPUS":
                b = Ascii.FF;
                break;
            default:
                b = -1;
                break;
        }
        String str6 = "audio/raw";
        switch (b) {
            case 0:
                str6 = "video/x-vnd.on2.vp8";
                i2 = -1;
                iZzn = -1;
                listZzp = null;
                str2 = null;
                if (this.zzO != null && (zzacyVarZza = zzacy.zza(new zzek(this.zzO))) != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11 = (z ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1 || (i6 = this.zzq) == -1) {
                        f = -1.0f;
                    } else {
                        f = (this.zzn * i5) / (this.zzm * i6);
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f || this.zzF == -1.0f || this.zzG == -1.0f || this.zzH == -1.0f || this.zzI == -1.0f || this.zzJ == -1.0f || this.zzK == -1.0f || this.zzL == -1.0f || this.zzM == -1.0f || this.zzN == -1.0f) {
                            bArr = null;
                        } else {
                            bArr = new byte[25];
                            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                            byteBufferOrder.put((byte) 0);
                            byteBufferOrder.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) (this.zzM + 0.5f));
                            byteBufferOrder.putShort((short) (this.zzN + 0.5f));
                            byteBufferOrder.putShort((short) this.zzC);
                            byteBufferOrder.putShort((short) this.zzD);
                        }
                        zzi zziVar = new zzi();
                        zziVar.zzc(this.zzz);
                        zziVar.zzb(this.zzB);
                        zziVar.zzd(this.zzA);
                        zziVar.zze(bArr);
                        zziVar.zzf(this.zzo);
                        zziVar.zza(this.zzo);
                        zzkVarZzg = zziVar.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null && zzahf.zzf.containsKey(this.zzb)) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0 || Float.compare(this.zzt, 0.0f) != 0 || Float.compare(this.zzu, 0.0f) != 0) {
                        i9 = iIntValue;
                    } else if (Float.compare(this.zzv, 0.0f) != 0) {
                        if (Float.compare(this.zzv, 90.0f) == 0) {
                            i9 = 90;
                        } else if (Float.compare(this.zzv, -180.0f) == 0 || Float.compare(this.zzv, 180.0f) == 0) {
                            i9 = 180;
                        } else if (Float.compare(this.zzv, -90.0f) == 0) {
                            i9 = 270;
                        } else {
                            i9 = iIntValue;
                        }
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3) && !"text/x-ssa".equals(str3) && !"text/vtt".equals(str3) && !"application/vobsub".equals(str3) && !"application/pgs".equals(str3) && !"application/dvbsubs".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null && !zzahf.zzf.containsKey(this.zzb)) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i11);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj = zzxVar.zzaj();
                zzaei zzaeiVarZzw = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw;
                zzaeiVarZzw.zzm(zzzVarZzaj);
                return;
            case 1:
                byte[] bArr2 = this.zzk;
                listZzo = bArr2 == null ? null : zzfww.zzo(bArr2);
                str6 = "video/x-vnd.on2.vp9";
                listZzp = listZzo;
                i2 = -1;
                iZzn = -1;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z2 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i12 = (z2 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar2 = new zzi();
                        zziVar2.zzc(this.zzz);
                        zziVar2.zzb(this.zzB);
                        zziVar2.zzd(this.zzA);
                        zziVar2.zze(bArr);
                        zziVar2.zzf(this.zzo);
                        zziVar2.zza(this.zzo);
                        zzkVarZzg = zziVar2.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i12);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj2 = zzxVar.zzaj();
                zzaei zzaeiVarZzw2 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw2;
                zzaeiVarZzw2.zzm(zzzVarZzaj2);
                return;
            case 2:
                byte[] bArr3 = this.zzk;
                listZzo = bArr3 == null ? null : zzfww.zzo(bArr3);
                str6 = "video/av01";
                listZzp = listZzo;
                i2 = -1;
                iZzn = -1;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z3 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i13 = (z3 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar3 = new zzi();
                        zziVar3.zzc(this.zzz);
                        zziVar3.zzb(this.zzB);
                        zziVar3.zzd(this.zzA);
                        zziVar3.zze(bArr);
                        zziVar3.zzf(this.zzo);
                        zziVar3.zza(this.zzo);
                        zzkVarZzg = zziVar3.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i13);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj3 = zzxVar.zzaj();
                zzaei zzaeiVarZzw3 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw3;
                zzaeiVarZzw3.zzm(zzzVarZzaj3);
                return;
            case 3:
                str6 = "video/mpeg2";
                i2 = -1;
                iZzn = -1;
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z4 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i14 = (z4 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar4 = new zzi();
                        zziVar4.zzc(this.zzz);
                        zziVar4.zzb(this.zzB);
                        zziVar4.zzd(this.zzA);
                        zziVar4.zze(bArr);
                        zziVar4.zzf(this.zzo);
                        zziVar4.zza(this.zzo);
                        zzkVarZzg = zziVar4.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i14);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj4 = zzxVar.zzaj();
                zzaei zzaeiVarZzw4 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw4;
                zzaeiVarZzw4.zzm(zzzVarZzaj4);
                return;
            case 4:
            case 5:
            case 6:
                byte[] bArr4 = this.zzk;
                listZzo = bArr4 == null ? null : Collections.singletonList(bArr4);
                str6 = "video/mp4v-es";
                listZzp = listZzo;
                i2 = -1;
                iZzn = -1;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z5 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i15 = (z5 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar5 = new zzi();
                        zziVar5.zzc(this.zzz);
                        zziVar5.zzb(this.zzB);
                        zziVar5.zzd(this.zzA);
                        zziVar5.zze(bArr);
                        zziVar5.zzf(this.zzo);
                        zziVar5.zza(this.zzo);
                        zzkVarZzg = zziVar5.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i15);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj5 = zzxVar.zzaj();
                zzaei zzaeiVarZzw5 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw5;
                zzaeiVarZzw5.zzm(zzzVarZzaj5);
                return;
            case 7:
                zzacg zzacgVarZza = zzacg.zza(new zzek(zzi(this.zzc)));
                listZzp = zzacgVarZza.zza;
                this.zzY = zzacgVarZza.zzb;
                str = zzacgVarZza.zzl;
                str6 = "video/avc";
                str2 = str;
                i2 = -1;
                iZzn = -1;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z6 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i16 = (z6 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar6 = new zzi();
                        zziVar6.zzc(this.zzz);
                        zziVar6.zzb(this.zzB);
                        zziVar6.zzd(this.zzA);
                        zziVar6.zze(bArr);
                        zziVar6.zzf(this.zzo);
                        zziVar6.zza(this.zzo);
                        zzkVarZzg = zziVar6.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i16);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj6 = zzxVar.zzaj();
                zzaei zzaeiVarZzw6 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw6;
                zzaeiVarZzw6.zzm(zzzVarZzaj6);
                return;
            case 8:
                zzadr zzadrVarZza = zzadr.zza(new zzek(zzi(this.zzc)));
                listZzp = zzadrVarZza.zza;
                this.zzY = zzadrVarZza.zzb;
                str = zzadrVarZza.zzl;
                str6 = "video/hevc";
                str2 = str;
                i2 = -1;
                iZzn = -1;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z7 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i17 = (z7 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar7 = new zzi();
                        zziVar7.zzc(this.zzz);
                        zziVar7.zzb(this.zzB);
                        zziVar7.zzd(this.zzA);
                        zziVar7.zze(bArr);
                        zziVar7.zzf(this.zzo);
                        zziVar7.zza(this.zzo);
                        zzkVarZzg = zziVar7.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i17);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj7 = zzxVar.zzaj();
                zzaei zzaeiVarZzw7 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw7;
                zzaeiVarZzw7.zzm(zzzVarZzaj7);
                return;
            case 9:
                Pair pairZzf = zzf(new zzek(zzi(this.zzc)));
                str6 = (String) pairZzf.first;
                listZzo = (List) pairZzf.second;
                listZzp = listZzo;
                i2 = -1;
                iZzn = -1;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z8 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i18 = (z8 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar8 = new zzi();
                        zziVar8.zzc(this.zzz);
                        zziVar8.zzb(this.zzB);
                        zziVar8.zzd(this.zzA);
                        zziVar8.zze(bArr);
                        zziVar8.zzf(this.zzo);
                        zziVar8.zza(this.zzo);
                        zzkVarZzg = zziVar8.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i18);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj8 = zzxVar.zzaj();
                zzaei zzaeiVarZzw8 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw8;
                zzaeiVarZzw8.zzm(zzzVarZzaj8);
                return;
            case 10:
                str6 = "video/x-unknown";
                i2 = -1;
                iZzn = -1;
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z9 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i19 = (z9 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar9 = new zzi();
                        zziVar9.zzc(this.zzz);
                        zziVar9.zzb(this.zzB);
                        zziVar9.zzd(this.zzA);
                        zziVar9.zze(bArr);
                        zziVar9.zzf(this.zzo);
                        zziVar9.zza(this.zzo);
                        zzkVarZzg = zziVar9.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i19);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj9 = zzxVar.zzaj();
                zzaei zzaeiVarZzw9 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw9;
                zzaeiVarZzw9.zzm(zzzVarZzaj9);
                return;
            case 11:
                listZzg = zzg(zzi(str5));
                i3 = 8192;
                str6 = "audio/vorbis";
                listZzp = listZzg;
                iZzn = -1;
                i2 = i3;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z10 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i110 = (z10 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar10 = new zzi();
                        zziVar10.zzc(this.zzz);
                        zziVar10.zzb(this.zzB);
                        zziVar10.zzd(this.zzA);
                        zziVar10.zze(bArr);
                        zziVar10.zzf(this.zzo);
                        zziVar10.zza(this.zzo);
                        zzkVarZzg = zziVar10.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i110);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj10 = zzxVar.zzaj();
                zzaei zzaeiVarZzw10 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw10;
                zzaeiVarZzw10.zzm(zzzVarZzaj10);
                return;
            case 12:
                listZzg = new ArrayList(3);
                listZzg.add(zzi(this.zzc));
                listZzg.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzS).array());
                listZzg.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzT).array());
                i3 = 5760;
                str6 = "audio/opus";
                listZzp = listZzg;
                iZzn = -1;
                i2 = i3;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z11 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i111 = (z11 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar11 = new zzi();
                        zziVar11.zzc(this.zzz);
                        zziVar11.zzb(this.zzB);
                        zziVar11.zzd(this.zzA);
                        zziVar11.zze(bArr);
                        zziVar11.zzf(this.zzo);
                        zziVar11.zza(this.zzo);
                        zzkVarZzg = zziVar11.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i111);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj11 = zzxVar.zzaj();
                zzaei zzaeiVarZzw11 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw11;
                zzaeiVarZzw11.zzm(zzzVarZzaj11);
                return;
            case 13:
                List listSingletonList = Collections.singletonList(zzi(str5));
                zzabw zzabwVarZza = zzaby.zza(this.zzk);
                this.zzR = zzabwVarZza.zza;
                this.zzP = zzabwVarZza.zzb;
                str6 = "audio/mp4a-latm";
                str2 = zzabwVarZza.zzc;
                iZzn = -1;
                listZzp = listSingletonList;
                i2 = -1;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z12 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i112 = (z12 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar12 = new zzi();
                        zziVar12.zzc(this.zzz);
                        zziVar12.zzb(this.zzB);
                        zziVar12.zzd(this.zzA);
                        zziVar12.zze(bArr);
                        zziVar12.zzf(this.zzo);
                        zziVar12.zza(this.zzo);
                        zzkVarZzg = zziVar12.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i112);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj12 = zzxVar.zzaj();
                zzaei zzaeiVarZzw12 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw12;
                zzaeiVarZzw12.zzm(zzzVarZzaj12);
                return;
            case 14:
                str6 = "audio/mpeg-L2";
                iZzn = -1;
                i2 = 4096;
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z13 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i113 = (z13 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar13 = new zzi();
                        zziVar13.zzc(this.zzz);
                        zziVar13.zzb(this.zzB);
                        zziVar13.zzd(this.zzA);
                        zziVar13.zze(bArr);
                        zziVar13.zzf(this.zzo);
                        zziVar13.zza(this.zzo);
                        zzkVarZzg = zziVar13.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i113);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj13 = zzxVar.zzaj();
                zzaei zzaeiVarZzw13 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw13;
                zzaeiVarZzw13.zzm(zzzVarZzaj13);
                return;
            case 15:
                str6 = "audio/mpeg";
                iZzn = -1;
                i2 = 4096;
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z14 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i114 = (z14 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar14 = new zzi();
                        zziVar14.zzc(this.zzz);
                        zziVar14.zzb(this.zzB);
                        zziVar14.zzd(this.zzA);
                        zziVar14.zze(bArr);
                        zziVar14.zzf(this.zzo);
                        zziVar14.zza(this.zzo);
                        zzkVarZzg = zziVar14.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i114);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj14 = zzxVar.zzaj();
                zzaei zzaeiVarZzw14 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw14;
                zzaeiVarZzw14.zzm(zzzVarZzaj14);
                return;
            case 16:
                str6 = "audio/ac3";
                i2 = -1;
                iZzn = -1;
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z15 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i115 = (z15 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar15 = new zzi();
                        zziVar15.zzc(this.zzz);
                        zziVar15.zzb(this.zzB);
                        zziVar15.zzd(this.zzA);
                        zziVar15.zze(bArr);
                        zziVar15.zzf(this.zzo);
                        zziVar15.zza(this.zzo);
                        zzkVarZzg = zziVar15.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i115);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj15 = zzxVar.zzaj();
                zzaei zzaeiVarZzw15 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw15;
                zzaeiVarZzw15.zzm(zzzVarZzaj15);
                return;
            case 17:
                str6 = "audio/eac3";
                i2 = -1;
                iZzn = -1;
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z16 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i116 = (z16 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar16 = new zzi();
                        zziVar16.zzc(this.zzz);
                        zziVar16.zzb(this.zzB);
                        zziVar16.zzd(this.zzA);
                        zziVar16.zze(bArr);
                        zziVar16.zzf(this.zzo);
                        zziVar16.zza(this.zzo);
                        zzkVarZzg = zziVar16.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i116);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj16 = zzxVar.zzaj();
                zzaei zzaeiVarZzw16 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw16;
                zzaeiVarZzw16.zzm(zzzVarZzaj16);
                return;
            case 18:
                this.zzU = new zzaej();
                str6 = "audio/true-hd";
                i2 = -1;
                iZzn = -1;
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z17 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i117 = (z17 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar17 = new zzi();
                        zziVar17.zzc(this.zzz);
                        zziVar17.zzb(this.zzB);
                        zziVar17.zzd(this.zzA);
                        zziVar17.zze(bArr);
                        zziVar17.zzf(this.zzo);
                        zziVar17.zza(this.zzo);
                        zzkVarZzg = zziVar17.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i117);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj17 = zzxVar.zzaj();
                zzaei zzaeiVarZzw17 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw17;
                zzaeiVarZzw17.zzm(zzzVarZzaj17);
                return;
            case 19:
            case 20:
                str6 = "audio/vnd.dts";
                i2 = -1;
                iZzn = -1;
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z18 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i118 = (z18 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar18 = new zzi();
                        zziVar18.zzc(this.zzz);
                        zziVar18.zzb(this.zzB);
                        zziVar18.zzd(this.zzA);
                        zziVar18.zze(bArr);
                        zziVar18.zzf(this.zzo);
                        zziVar18.zza(this.zzo);
                        zzkVarZzg = zziVar18.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i118);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj18 = zzxVar.zzaj();
                zzaei zzaeiVarZzw18 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw18;
                zzaeiVarZzw18.zzm(zzzVarZzaj18);
                return;
            case 21:
                str6 = "audio/vnd.dts.hd";
                i2 = -1;
                iZzn = -1;
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z19 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i119 = (z19 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar19 = new zzi();
                        zziVar19.zzc(this.zzz);
                        zziVar19.zzb(this.zzB);
                        zziVar19.zzd(this.zzA);
                        zziVar19.zze(bArr);
                        zziVar19.zzf(this.zzo);
                        zziVar19.zza(this.zzo);
                        zzkVarZzg = zziVar19.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i119);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj19 = zzxVar.zzaj();
                zzaei zzaeiVarZzw19 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw19;
                zzaeiVarZzw19.zzm(zzzVarZzaj19);
                return;
            case 22:
                listZzo = Collections.singletonList(zzi(str5));
                str6 = "audio/flac";
                listZzp = listZzo;
                i2 = -1;
                iZzn = -1;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z110 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1110 = (z110 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar110 = new zzi();
                        zziVar110.zzc(this.zzz);
                        zziVar110.zzb(this.zzB);
                        zziVar110.zzd(this.zzA);
                        zziVar110.zze(bArr);
                        zziVar110.zzf(this.zzo);
                        zziVar110.zza(this.zzo);
                        zzkVarZzg = zziVar110.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i1110);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj110 = zzxVar.zzaj();
                zzaei zzaeiVarZzw110 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw110;
                zzaeiVarZzw110.zzm(zzzVarZzaj110);
                return;
            case 23:
                if (zzh(new zzek(zzi(this.zzc)))) {
                    iZzn = zzeu.zzn(this.zzQ);
                    if (iZzn == 0) {
                        zzdx.zzf("MatroskaExtractor", "Unsupported PCM bit depth: " + this.zzQ + ". Setting mimeType to audio/x-unknown");
                    } else {
                        i2 = -1;
                    }
                    listZzp = null;
                    str2 = null;
                    if (this.zzO != null) {
                        str2 = zzacyVarZza.zza;
                        str6 = "video/dolby-vision";
                    }
                    str3 = str6;
                    boolean z111 = this.zzW;
                    if (true != this.zzV) {
                        i4 = 0;
                    } else {
                        i4 = 2;
                    }
                    int i1111 = (z111 ? 1 : 0) | i4;
                    zzxVar = new zzx();
                    if (zzay.zzh(str3)) {
                        zzxVar.zzB(this.zzP);
                        zzxVar.zzae(this.zzR);
                        zzxVar.zzX(iZzn);
                        i10 = 1;
                    } else if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i7 = this.zzp;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzp = i7;
                            i8 = this.zzq;
                            if (i8 == -1) {
                                i8 = this.zzn;
                            }
                            this.zzq = i8;
                        }
                        i5 = this.zzp;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzi zziVar111 = new zzi();
                            zziVar111.zzc(this.zzz);
                            zziVar111.zzb(this.zzB);
                            zziVar111.zzd(this.zzA);
                            zziVar111.zze(bArr);
                            zziVar111.zzf(this.zzo);
                            zziVar111.zza(this.zzo);
                            zzkVarZzg = zziVar111.zzg();
                        } else {
                            zzkVarZzg = null;
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzxVar.zzai(this.zzm);
                        zzxVar.zzM(this.zzn);
                        zzxVar.zzZ(f);
                        zzxVar.zzac(i9);
                        zzxVar.zzaa(this.zzw);
                        zzxVar.zzag(this.zzx);
                        zzxVar.zzD(zzkVarZzg);
                        i10 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw zzaz.zza("Unexpected MIME type.", null);
                    }
                    if (this.zzb != null) {
                        zzxVar.zzQ(this.zzb);
                    }
                    zzxVar.zzN(i);
                    if (true != this.zza) {
                        str4 = "video/x-matroska";
                    } else {
                        str4 = "video/webm";
                    }
                    zzxVar.zzE(str4);
                    zzxVar.zzad(str3);
                    zzxVar.zzT(i2);
                    zzxVar.zzS(this.zzaa);
                    zzxVar.zzaf(i1111);
                    zzxVar.zzP(listZzp);
                    zzxVar.zzC(str2);
                    zzxVar.zzH(this.zzl);
                    zzz zzzVarZzaj111 = zzxVar.zzaj();
                    zzaei zzaeiVarZzw111 = zzadfVar.zzw(this.zzd, i10);
                    this.zzX = zzaeiVarZzw111;
                    zzaeiVarZzw111.zzm(zzzVarZzaj111);
                    return;
                }
                zzdx.zzf("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                i2 = -1;
                iZzn = -1;
                str6 = "audio/x-unknown";
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z112 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1112 = (z112 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar112 = new zzi();
                        zziVar112.zzc(this.zzz);
                        zziVar112.zzb(this.zzB);
                        zziVar112.zzd(this.zzA);
                        zziVar112.zze(bArr);
                        zziVar112.zzf(this.zzo);
                        zziVar112.zza(this.zzo);
                        zzkVarZzg = zziVar112.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i1112);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj112 = zzxVar.zzaj();
                zzaei zzaeiVarZzw112 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw112;
                zzaeiVarZzw112.zzm(zzzVarZzaj112);
                return;
            case 24:
                iZzn = zzeu.zzn(this.zzQ);
                if (iZzn == 0) {
                    zzdx.zzf("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + this.zzQ + ". Setting mimeType to audio/x-unknown");
                    i2 = -1;
                    iZzn = -1;
                    str6 = "audio/x-unknown";
                } else {
                    i2 = -1;
                }
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z113 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1113 = (z113 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar113 = new zzi();
                        zziVar113.zzc(this.zzz);
                        zziVar113.zzb(this.zzB);
                        zziVar113.zzd(this.zzA);
                        zziVar113.zze(bArr);
                        zziVar113.zzf(this.zzo);
                        zziVar113.zza(this.zzo);
                        zzkVarZzg = zziVar113.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i1113);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj113 = zzxVar.zzaj();
                zzaei zzaeiVarZzw113 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw113;
                zzaeiVarZzw113.zzm(zzzVarZzaj113);
                return;
            case 25:
                int i20 = this.zzQ;
                if (i20 == 8) {
                    iZzn = 3;
                } else if (i20 == 16) {
                    iZzn = 268435456;
                } else if (i20 == 24) {
                    iZzn = 1342177280;
                } else {
                    if (i20 != 32) {
                        zzdx.zzf("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + i20 + ". Setting mimeType to audio/x-unknown");
                        i2 = -1;
                        iZzn = -1;
                        str6 = "audio/x-unknown";
                        listZzp = null;
                        str2 = null;
                        if (this.zzO != null) {
                            str2 = zzacyVarZza.zza;
                            str6 = "video/dolby-vision";
                        }
                        str3 = str6;
                        boolean z114 = this.zzW;
                        if (true != this.zzV) {
                            i4 = 0;
                        } else {
                            i4 = 2;
                        }
                        int i1114 = (z114 ? 1 : 0) | i4;
                        zzxVar = new zzx();
                        if (zzay.zzh(str3)) {
                            zzxVar.zzB(this.zzP);
                            zzxVar.zzae(this.zzR);
                            zzxVar.zzX(iZzn);
                            i10 = 1;
                        } else if (zzay.zzj(str3)) {
                            if (this.zzr == 0) {
                                i7 = this.zzp;
                                if (i7 == -1) {
                                    i7 = this.zzm;
                                }
                                this.zzp = i7;
                                i8 = this.zzq;
                                if (i8 == -1) {
                                    i8 = this.zzn;
                                }
                                this.zzq = i8;
                            }
                            i5 = this.zzp;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.zzy) {
                                if (this.zzE != -1.0f) {
                                    bArr = null;
                                } else {
                                    bArr = null;
                                }
                                zzi zziVar114 = new zzi();
                                zziVar114.zzc(this.zzz);
                                zziVar114.zzb(this.zzB);
                                zziVar114.zzd(this.zzA);
                                zziVar114.zze(bArr);
                                zziVar114.zzf(this.zzo);
                                zziVar114.zza(this.zzo);
                                zzkVarZzg = zziVar114.zzg();
                            } else {
                                zzkVarZzg = null;
                            }
                            if (this.zzb != null) {
                                iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                            }
                            if (this.zzs == 0) {
                                i9 = iIntValue;
                            } else {
                                i9 = iIntValue;
                            }
                            zzxVar.zzai(this.zzm);
                            zzxVar.zzM(this.zzn);
                            zzxVar.zzZ(f);
                            zzxVar.zzac(i9);
                            zzxVar.zzaa(this.zzw);
                            zzxVar.zzag(this.zzx);
                            zzxVar.zzD(zzkVarZzg);
                            i10 = 2;
                        } else if (!"application/x-subrip".equals(str3)) {
                            throw zzaz.zza("Unexpected MIME type.", null);
                        }
                        if (this.zzb != null) {
                            zzxVar.zzQ(this.zzb);
                        }
                        zzxVar.zzN(i);
                        if (true != this.zza) {
                            str4 = "video/x-matroska";
                        } else {
                            str4 = "video/webm";
                        }
                        zzxVar.zzE(str4);
                        zzxVar.zzad(str3);
                        zzxVar.zzT(i2);
                        zzxVar.zzS(this.zzaa);
                        zzxVar.zzaf(i1114);
                        zzxVar.zzP(listZzp);
                        zzxVar.zzC(str2);
                        zzxVar.zzH(this.zzl);
                        zzz zzzVarZzaj114 = zzxVar.zzaj();
                        zzaei zzaeiVarZzw114 = zzadfVar.zzw(this.zzd, i10);
                        this.zzX = zzaeiVarZzw114;
                        zzaeiVarZzw114.zzm(zzzVarZzaj114);
                        return;
                    }
                    iZzn = 1610612736;
                }
                i2 = -1;
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z115 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1115 = (z115 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar115 = new zzi();
                        zziVar115.zzc(this.zzz);
                        zziVar115.zzb(this.zzB);
                        zziVar115.zzd(this.zzA);
                        zziVar115.zze(bArr);
                        zziVar115.zzf(this.zzo);
                        zziVar115.zza(this.zzo);
                        zzkVarZzg = zziVar115.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i1115);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj115 = zzxVar.zzaj();
                zzaei zzaeiVarZzw115 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw115;
                zzaeiVarZzw115.zzm(zzzVarZzaj115);
                return;
            case 26:
                int i21 = this.zzQ;
                if (i21 == 32) {
                    i2 = -1;
                } else {
                    zzdx.zzf("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + i21 + ". Setting mimeType to audio/x-unknown");
                    i2 = -1;
                    iZzn = -1;
                    str6 = "audio/x-unknown";
                }
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z116 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1116 = (z116 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar116 = new zzi();
                        zziVar116.zzc(this.zzz);
                        zziVar116.zzb(this.zzB);
                        zziVar116.zzd(this.zzA);
                        zziVar116.zze(bArr);
                        zziVar116.zzf(this.zzo);
                        zziVar116.zza(this.zzo);
                        zzkVarZzg = zziVar116.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i1116);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj116 = zzxVar.zzaj();
                zzaei zzaeiVarZzw116 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw116;
                zzaeiVarZzw116.zzm(zzzVarZzaj116);
                return;
            case 27:
                i2 = -1;
                iZzn = -1;
                str6 = "application/x-subrip";
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z117 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1117 = (z117 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar117 = new zzi();
                        zziVar117.zzc(this.zzz);
                        zziVar117.zzb(this.zzB);
                        zziVar117.zzd(this.zzA);
                        zziVar117.zze(bArr);
                        zziVar117.zzf(this.zzo);
                        zziVar117.zza(this.zzo);
                        zzkVarZzg = zziVar117.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i1117);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj117 = zzxVar.zzaj();
                zzaei zzaeiVarZzw117 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw117;
                zzaeiVarZzw117.zzm(zzzVarZzaj117);
                return;
            case 28:
                listZzp = zzfww.zzp(zzahf.zzb, zzi(this.zzc));
                i2 = -1;
                iZzn = -1;
                str6 = "text/x-ssa";
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z118 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1118 = (z118 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar118 = new zzi();
                        zziVar118.zzc(this.zzz);
                        zziVar118.zzb(this.zzB);
                        zziVar118.zzd(this.zzA);
                        zziVar118.zze(bArr);
                        zziVar118.zzf(this.zzo);
                        zziVar118.zza(this.zzo);
                        zzkVarZzg = zziVar118.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i1118);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj118 = zzxVar.zzaj();
                zzaei zzaeiVarZzw118 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw118;
                zzaeiVarZzw118.zzm(zzzVarZzaj118);
                return;
            case 29:
                str6 = "text/vtt";
                i2 = -1;
                iZzn = -1;
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z119 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1119 = (z119 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar119 = new zzi();
                        zziVar119.zzc(this.zzz);
                        zziVar119.zzb(this.zzB);
                        zziVar119.zzd(this.zzA);
                        zziVar119.zze(bArr);
                        zziVar119.zzf(this.zzo);
                        zziVar119.zza(this.zzo);
                        zzkVarZzg = zziVar119.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i1119);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj119 = zzxVar.zzaj();
                zzaei zzaeiVarZzw119 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw119;
                zzaeiVarZzw119.zzm(zzzVarZzaj119);
                return;
            case 30:
                listZzo = zzfww.zzo(zzi(str5));
                str6 = "application/vobsub";
                listZzp = listZzo;
                i2 = -1;
                iZzn = -1;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z1110 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11110 = (z1110 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar1110 = new zzi();
                        zziVar1110.zzc(this.zzz);
                        zziVar1110.zzb(this.zzB);
                        zziVar1110.zzd(this.zzA);
                        zziVar1110.zze(bArr);
                        zziVar1110.zzf(this.zzo);
                        zziVar1110.zza(this.zzo);
                        zzkVarZzg = zziVar1110.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i11110);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj1110 = zzxVar.zzaj();
                zzaei zzaeiVarZzw1110 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw1110;
                zzaeiVarZzw1110.zzm(zzzVarZzaj1110);
                return;
            case 31:
                str6 = "application/pgs";
                i2 = -1;
                iZzn = -1;
                listZzp = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z1111 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11111 = (z1111 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar1111 = new zzi();
                        zziVar1111.zzc(this.zzz);
                        zziVar1111.zzb(this.zzB);
                        zziVar1111.zzd(this.zzA);
                        zziVar1111.zze(bArr);
                        zziVar1111.zzf(this.zzo);
                        zziVar1111.zza(this.zzo);
                        zzkVarZzg = zziVar1111.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i11111);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj1111 = zzxVar.zzaj();
                zzaei zzaeiVarZzw1111 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw1111;
                zzaeiVarZzw1111.zzm(zzzVarZzaj1111);
                return;
            case 32:
                byte[] bArr5 = new byte[4];
                System.arraycopy(zzi(str5), 0, bArr5, 0, 4);
                listZzo = zzfww.zzo(bArr5);
                str6 = "application/dvbsubs";
                listZzp = listZzo;
                i2 = -1;
                iZzn = -1;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzacyVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z1112 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11112 = (z1112 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (zzay.zzh(str3)) {
                    zzxVar.zzB(this.zzP);
                    zzxVar.zzae(this.zzR);
                    zzxVar.zzX(iZzn);
                    i10 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i7 = this.zzp;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzp = i7;
                        i8 = this.zzq;
                        if (i8 == -1) {
                            i8 = this.zzn;
                        }
                        this.zzq = i8;
                    }
                    i5 = this.zzp;
                    if (i5 != -1) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f) {
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        zzi zziVar1112 = new zzi();
                        zziVar1112.zzc(this.zzz);
                        zziVar1112.zzb(this.zzB);
                        zziVar1112.zzd(this.zzA);
                        zziVar1112.zze(bArr);
                        zziVar1112.zzf(this.zzo);
                        zziVar1112.zza(this.zzo);
                        zzkVarZzg = zziVar1112.zzg();
                    } else {
                        zzkVarZzg = null;
                    }
                    if (this.zzb != null) {
                        iIntValue = ((Integer) zzahf.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0) {
                        i9 = iIntValue;
                    } else {
                        i9 = iIntValue;
                    }
                    zzxVar.zzai(this.zzm);
                    zzxVar.zzM(this.zzn);
                    zzxVar.zzZ(f);
                    zzxVar.zzac(i9);
                    zzxVar.zzaa(this.zzw);
                    zzxVar.zzag(this.zzx);
                    zzxVar.zzD(zzkVarZzg);
                    i10 = 2;
                } else if (!"application/x-subrip".equals(str3)) {
                    throw zzaz.zza("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    zzxVar.zzQ(this.zzb);
                }
                zzxVar.zzN(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzE(str4);
                zzxVar.zzad(str3);
                zzxVar.zzT(i2);
                zzxVar.zzS(this.zzaa);
                zzxVar.zzaf(i11112);
                zzxVar.zzP(listZzp);
                zzxVar.zzC(str2);
                zzxVar.zzH(this.zzl);
                zzz zzzVarZzaj1112 = zzxVar.zzaj();
                zzaei zzaeiVarZzw1112 = zzadfVar.zzw(this.zzd, i10);
                this.zzX = zzaeiVarZzw1112;
                zzaeiVarZzw1112.zzm(zzzVarZzaj1112);
                return;
            default:
                throw zzaz.zza("Unrecognized codec identifier.", null);
        }
    }
}
