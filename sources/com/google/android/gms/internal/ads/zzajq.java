package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzajq extends zzajo {
    private zzajp zza;
    private int zzb;
    private boolean zzc;
    private zzaen zzd;
    private zzael zze;

    zzajq() {
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    protected final long zza(zzek zzekVar) {
        if ((zzekVar.zzN()[0] & 1) == 1) {
            return -1L;
        }
        byte b = zzekVar.zzN()[0];
        zzajp zzajpVar = this.zza;
        zzdc.zzb(zzajpVar);
        int i = !zzajpVar.zzd[(b >> 1) & (255 >>> (8 - zzajpVar.zze))].zza ? zzajpVar.zza.zze : zzajpVar.zza.zzf;
        int i2 = this.zzc ? (this.zzb + i) / 4 : 0;
        if (zzekVar.zzb() < zzekVar.zzd() + 4) {
            byte[] bArrCopyOf = Arrays.copyOf(zzekVar.zzN(), zzekVar.zzd() + 4);
            zzekVar.zzJ(bArrCopyOf, bArrCopyOf.length);
        } else {
            zzekVar.zzK(zzekVar.zzd() + 4);
        }
        long j = i2;
        byte[] bArrZzN = zzekVar.zzN();
        bArrZzN[zzekVar.zzd() - 4] = (byte) (j & 255);
        bArrZzN[zzekVar.zzd() - 3] = (byte) ((j >>> 8) & 255);
        bArrZzN[zzekVar.zzd() - 2] = (byte) ((j >>> 16) & 255);
        bArrZzN[zzekVar.zzd() - 1] = (byte) ((j >>> 24) & 255);
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    protected final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    protected final void zzi(long j) {
        super.zzi(j);
        this.zzc = j != 0;
        zzaen zzaenVar = this.zzd;
        this.zzb = zzaenVar != null ? zzaenVar.zze : 0;
    }

    /* JADX WARN: Code duplicated, block: B:167:0x03b7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:169:0x03b9  */
    @Override // com.google.android.gms.internal.ads.zzajo
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzek zzekVar, long j, zzajl zzajlVar) throws IOException {
        zzajp zzajpVar;
        int i;
        int iZzb;
        int i2;
        int i3;
        if (this.zza != null) {
            zzajlVar.zza.getClass();
            return false;
        }
        zzaen zzaenVar = this.zzd;
        int i4 = 4;
        if (zzaenVar != null) {
            zzael zzaelVar = this.zze;
            if (zzaelVar == null) {
                this.zze = zzaeo.zzc(zzekVar, true, true);
            } else {
                byte[] bArr = new byte[zzekVar.zzd()];
                System.arraycopy(zzekVar.zzN(), 0, bArr, 0, zzekVar.zzd());
                int i5 = zzaenVar.zza;
                int i6 = 5;
                zzaeo.zzd(5, zzekVar, false);
                int iZzm = zzekVar.zzm() + 1;
                zzaek zzaekVar = new zzaek(zzekVar.zzN());
                zzaekVar.zzc(zzekVar.zzc() * 8);
                int i7 = 0;
                while (true) {
                    int i8 = 2;
                    int i9 = 16;
                    if (i7 >= iZzm) {
                        zzaen zzaenVar2 = zzaenVar;
                        int i10 = 6;
                        int iZzb2 = zzaekVar.zzb(6) + 1;
                        for (int i11 = 0; i11 < iZzb2; i11++) {
                            if (zzaekVar.zzb(16) != 0) {
                                throw zzaz.zza("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int i12 = 1;
                        int iZzb3 = zzaekVar.zzb(6) + 1;
                        int i13 = 0;
                        while (true) {
                            int i14 = 3;
                            if (i13 >= iZzb3) {
                                int i15 = 1;
                                int iZzb4 = zzaekVar.zzb(i10) + 1;
                                int i16 = 0;
                                while (i16 < iZzb4) {
                                    if (zzaekVar.zzb(16) > 2) {
                                        throw zzaz.zza("residueType greater than 2 is not decodable", null);
                                    }
                                    zzaekVar.zzc(24);
                                    zzaekVar.zzc(24);
                                    zzaekVar.zzc(24);
                                    int iZzb5 = zzaekVar.zzb(i10) + i15;
                                    int i17 = 8;
                                    zzaekVar.zzc(8);
                                    int[] iArr = new int[iZzb5];
                                    for (int i18 = 0; i18 < iZzb5; i18++) {
                                        iArr[i18] = ((zzaekVar.zzd() ? zzaekVar.zzb(5) : 0) * 8) + zzaekVar.zzb(3);
                                    }
                                    int i19 = 0;
                                    while (i19 < iZzb5) {
                                        int i20 = 0;
                                        while (i20 < i17) {
                                            if ((iArr[i19] & (1 << i20)) != 0) {
                                                zzaekVar.zzc(i17);
                                            }
                                            i20++;
                                            i17 = 8;
                                        }
                                        i19++;
                                        i17 = 8;
                                    }
                                    i16++;
                                    i10 = 6;
                                    i15 = 1;
                                }
                                int iZzb6 = zzaekVar.zzb(i10) + 1;
                                for (int i21 = 0; i21 < iZzb6; i21++) {
                                    int iZzb7 = zzaekVar.zzb(16);
                                    if (iZzb7 != 0) {
                                        zzdx.zzc("VorbisUtil", "mapping type other than 0 not supported: " + iZzb7);
                                    } else {
                                        if (zzaekVar.zzd()) {
                                            i = 1;
                                            iZzb = zzaekVar.zzb(4) + 1;
                                        } else {
                                            i = 1;
                                            iZzb = 1;
                                        }
                                        if (zzaekVar.zzd()) {
                                            int iZzb8 = zzaekVar.zzb(8) + i;
                                            for (int i22 = 0; i22 < iZzb8; i22++) {
                                                int i23 = i5 - 1;
                                                zzaekVar.zzc(zzaeo.zza(i23));
                                                zzaekVar.zzc(zzaeo.zza(i23));
                                            }
                                        }
                                        if (zzaekVar.zzb(2) != 0) {
                                            throw zzaz.zza("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iZzb > 1) {
                                            for (int i24 = 0; i24 < i5; i24++) {
                                                zzaekVar.zzc(4);
                                            }
                                        }
                                        for (int i25 = 0; i25 < iZzb; i25++) {
                                            zzaekVar.zzc(8);
                                            zzaekVar.zzc(8);
                                            zzaekVar.zzc(8);
                                        }
                                    }
                                }
                                int iZzb9 = zzaekVar.zzb(6);
                                int i26 = iZzb9 + 1;
                                zzaem[] zzaemVarArr = new zzaem[i26];
                                for (int i27 = 0; i27 < i26; i27++) {
                                    zzaemVarArr[i27] = new zzaem(zzaekVar.zzd(), zzaekVar.zzb(16), zzaekVar.zzb(16), zzaekVar.zzb(8));
                                }
                                if (!zzaekVar.zzd()) {
                                    throw zzaz.zza("framing bit after modes not set as expected", null);
                                }
                                zzajpVar = new zzajp(zzaenVar2, zzaelVar, bArr, zzaemVarArr, zzaeo.zza(iZzb9));
                                break;
                            }
                            int iZzb10 = zzaekVar.zzb(i9);
                            if (iZzb10 == 0) {
                                i2 = iZzb3;
                                int i28 = 8;
                                zzaekVar.zzc(8);
                                zzaekVar.zzc(16);
                                zzaekVar.zzc(16);
                                zzaekVar.zzc(6);
                                zzaekVar.zzc(8);
                                int iZzb11 = zzaekVar.zzb(4) + 1;
                                int i29 = 0;
                                while (i29 < iZzb11) {
                                    zzaekVar.zzc(i28);
                                    i29++;
                                    i28 = 8;
                                }
                            } else {
                                if (iZzb10 != i12) {
                                    throw zzaz.zza("floor type greater than 1 not decodable: " + iZzb10, null);
                                }
                                int iZzb12 = zzaekVar.zzb(i6);
                                int[] iArr2 = new int[iZzb12];
                                int i30 = -1;
                                for (int i31 = 0; i31 < iZzb12; i31++) {
                                    int iZzb13 = zzaekVar.zzb(4);
                                    iArr2[i31] = iZzb13;
                                    if (iZzb13 > i30) {
                                        i30 = iZzb13;
                                    }
                                }
                                int i32 = i30 + 1;
                                int[] iArr3 = new int[i32];
                                int i33 = 0;
                                while (i33 < i32) {
                                    iArr3[i33] = zzaekVar.zzb(i14) + 1;
                                    int iZzb14 = zzaekVar.zzb(i8);
                                    if (iZzb14 > 0) {
                                        i3 = 8;
                                        zzaekVar.zzc(8);
                                    } else {
                                        i3 = 8;
                                    }
                                    int i34 = iZzb3;
                                    int i35 = 0;
                                    for (int i36 = 1; i35 < (i36 << iZzb14); i36 = 1) {
                                        zzaekVar.zzc(i3);
                                        i35++;
                                        i3 = 8;
                                    }
                                    i33++;
                                    iZzb3 = i34;
                                    i8 = 2;
                                    i14 = 3;
                                }
                                i2 = iZzb3;
                                zzaekVar.zzc(i8);
                                int iZzb15 = zzaekVar.zzb(4);
                                int i37 = 0;
                                int i38 = 0;
                                for (int i39 = 0; i39 < iZzb12; i39++) {
                                    i37 += iArr3[iArr2[i39]];
                                    while (i38 < i37) {
                                        zzaekVar.zzc(iZzb15);
                                        i38++;
                                    }
                                }
                            }
                            i13++;
                            iZzb3 = i2;
                            i10 = 6;
                            i8 = 2;
                            i9 = 16;
                            i12 = 1;
                            i6 = 5;
                        }
                    } else {
                        if (zzaekVar.zzb(24) != 5653314) {
                            throw zzaz.zza("expected code book to start with [0x56, 0x43, 0x42] at " + zzaekVar.zza(), null);
                        }
                        int iZzb16 = zzaekVar.zzb(16);
                        int iZzb17 = zzaekVar.zzb(24);
                        if (zzaekVar.zzd()) {
                            zzaekVar.zzc(5);
                            for (int iZzb18 = 0; iZzb18 < iZzb17; iZzb18 += zzaekVar.zzb(zzaeo.zza(iZzb17 - iZzb18))) {
                            }
                        } else {
                            boolean zZzd = zzaekVar.zzd();
                            for (int i40 = 0; i40 < iZzb17; i40++) {
                                if (!zZzd) {
                                    zzaekVar.zzc(5);
                                } else if (zzaekVar.zzd()) {
                                    zzaekVar.zzc(5);
                                }
                            }
                        }
                        int iZzb19 = zzaekVar.zzb(i4);
                        if (iZzb19 > 2) {
                            throw zzaz.zza("lookup type greater than 2 not decodable: " + iZzb19, null);
                        }
                        if (iZzb19 != 1) {
                            if (iZzb19 != 2) {
                                zzaenVar = zzaenVar;
                            }
                            i7++;
                            zzaenVar = zzaenVar;
                            i4 = 4;
                        } else {
                            i8 = iZzb19;
                        }
                        zzaekVar.zzc(32);
                        zzaekVar.zzc(32);
                        int iZzb20 = zzaekVar.zzb(i4) + 1;
                        zzaekVar.zzc(1);
                        zzaekVar.zzc((int) ((i8 == 1 ? iZzb16 != 0 ? (long) Math.floor(Math.pow(iZzb17, 1.0d / ((double) iZzb16))) : 0L : ((long) iZzb16) * ((long) iZzb17)) * ((long) iZzb20)));
                        i7++;
                        zzaenVar = zzaenVar;
                        i4 = 4;
                    }
                }
            }
            this.zza = zzajpVar;
            if (zzajpVar == null) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            zzaen zzaenVar3 = zzajpVar.zza;
            arrayList.add(zzaenVar3.zzg);
            arrayList.add(zzajpVar.zzc);
            zzav zzavVarZzb = zzaeo.zzb(zzfww.zzm(zzajpVar.zzb.zza));
            zzx zzxVar = new zzx();
            zzxVar.zzE("audio/ogg");
            zzxVar.zzad("audio/vorbis");
            zzxVar.zzA(zzaenVar3.zzd);
            zzxVar.zzY(zzaenVar3.zzc);
            zzxVar.zzB(zzaenVar3.zza);
            zzxVar.zzae(zzaenVar3.zzb);
            zzxVar.zzP(arrayList);
            zzxVar.zzW(zzavVarZzb);
            zzajlVar.zza = zzxVar.zzaj();
            return true;
        }
        zzaeo.zzd(1, zzekVar, false);
        int iZzj = zzekVar.zzj();
        int iZzm2 = zzekVar.zzm();
        int iZzj2 = zzekVar.zzj();
        int iZzi = zzekVar.zzi();
        int i41 = iZzi <= 0 ? -1 : iZzi;
        int iZzi2 = zzekVar.zzi();
        int i42 = iZzi2 <= 0 ? -1 : iZzi2;
        int iZzi3 = zzekVar.zzi();
        int i43 = iZzi3 <= 0 ? -1 : iZzi3;
        int iZzm3 = zzekVar.zzm();
        this.zzd = new zzaen(iZzj, iZzm2, iZzj2, i41, i42, i43, (int) Math.pow(2.0d, iZzm3 & 15), (int) Math.pow(2.0d, (iZzm3 & 240) >> 4), 1 == (zzekVar.zzm() & 1), Arrays.copyOf(zzekVar.zzN(), zzekVar.zzd()));
        zzajpVar = null;
        this.zza = zzajpVar;
        if (zzajpVar == null) {
            return true;
        }
        ArrayList arrayList2 = new ArrayList();
        zzaen zzaenVar4 = zzajpVar.zza;
        arrayList2.add(zzaenVar4.zzg);
        arrayList2.add(zzajpVar.zzc);
        zzav zzavVarZzb2 = zzaeo.zzb(zzfww.zzm(zzajpVar.zzb.zza));
        zzx zzxVar2 = new zzx();
        zzxVar2.zzE("audio/ogg");
        zzxVar2.zzad("audio/vorbis");
        zzxVar2.zzA(zzaenVar4.zzd);
        zzxVar2.zzY(zzaenVar4.zzc);
        zzxVar2.zzB(zzaenVar4.zza);
        zzxVar2.zzae(zzaenVar4.zzb);
        zzxVar2.zzP(arrayList2);
        zzxVar2.zzW(zzavVarZzb2);
        zzajlVar.zza = zzxVar2.zzaj();
        return true;
    }
}
