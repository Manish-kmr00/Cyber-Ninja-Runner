package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;
import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaim {
    /* JADX WARN: Code duplicated, block: B:131:0x0262 A[Catch: all -> 0x01f4, TryCatch #0 {all -> 0x01f4, blocks: (B:9:0x0030, B:11:0x003b, B:13:0x0047, B:16:0x0053, B:19:0x0060, B:22:0x006f, B:25:0x007c, B:28:0x0089, B:30:0x0093, B:38:0x00ae, B:39:0x00bf, B:40:0x00d2, B:43:0x00de, B:46:0x00eb, B:49:0x00f8, B:52:0x0105, B:55:0x0112, B:58:0x011f, B:61:0x012c, B:64:0x0139, B:67:0x0146, B:70:0x0156, B:74:0x016a, B:76:0x0170, B:78:0x0185, B:79:0x018c, B:81:0x0193, B:86:0x019e, B:91:0x01aa, B:131:0x0262, B:92:0x01bf, B:94:0x01c6, B:96:0x01d0, B:97:0x01e5, B:112:0x0214, B:115:0x0221, B:118:0x022d, B:121:0x0239, B:124:0x0245, B:127:0x0251, B:130:0x025b, B:132:0x0276, B:133:0x027d), top: B:138:0x0022 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:131:0x0262, please report this as an issue */
    public static zzau zza(zzek zzekVar) {
        String str;
        zzau zzagdVar;
        int iZzc = zzekVar.zzc() + zzekVar.zzg();
        int iZzg = zzekVar.zzg();
        int i = (iZzg >> 24) & 255;
        zzau zzauVarZze = null;
        try {
            if (i == 169 || i == 253) {
                int i2 = iZzg & ViewCompat.MEASURED_SIZE_MASK;
                if (i2 == 6516084) {
                    int iZzg2 = zzekVar.zzg();
                    if (zzekVar.zzg() == 1684108385) {
                        zzekVar.zzM(8);
                        String strZzA = zzekVar.zzA(iZzg2 - 16);
                        zzauVarZze = new zzagh("und", strZzA, strZzA);
                    } else {
                        zzdx.zzf("MetadataUtil", "Failed to parse comment attribute: ".concat(zzfa.zze(iZzg)));
                    }
                } else if (i2 == 7233901 || i2 == 7631467) {
                    zzauVarZze = zze(iZzg, "TIT2", zzekVar);
                } else if (i2 == 6516589 || i2 == 7828084) {
                    zzauVarZze = zze(iZzg, "TCOM", zzekVar);
                } else if (i2 == 6578553) {
                    zzauVarZze = zze(iZzg, "TDRC", zzekVar);
                } else if (i2 == 4280916) {
                    zzauVarZze = zze(iZzg, "TPE1", zzekVar);
                } else if (i2 == 7630703) {
                    zzauVarZze = zze(iZzg, "TSSE", zzekVar);
                } else if (i2 == 6384738) {
                    zzauVarZze = zze(iZzg, "TALB", zzekVar);
                } else if (i2 == 7108978) {
                    zzauVarZze = zze(iZzg, "USLT", zzekVar);
                } else if (i2 == 6776174) {
                    zzauVarZze = zze(iZzg, "TCON", zzekVar);
                } else if (i2 == 6779504) {
                    zzauVarZze = zze(iZzg, "TIT1", zzekVar);
                } else {
                    zzdx.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzfa.zze(iZzg));
                }
            } else if (iZzg == 1735291493) {
                String strZza = zzagn.zza(zzb(zzekVar) - 1);
                if (strZza != null) {
                    zzagdVar = new zzagr("TCON", null, zzfww.zzo(strZza));
                    zzauVarZze = zzagdVar;
                } else {
                    zzdx.zzf("MetadataUtil", "Failed to parse standard genre code");
                }
            } else if (iZzg == 1684632427) {
                zzauVarZze = zzd(1684632427, "TPOS", zzekVar);
            } else if (iZzg == 1953655662) {
                zzauVarZze = zzd(1953655662, "TRCK", zzekVar);
            } else if (iZzg == 1953329263) {
                zzauVarZze = zzc(1953329263, "TBPM", zzekVar, true, false);
            } else if (iZzg == 1668311404) {
                zzauVarZze = zzc(1668311404, "TCMP", zzekVar, true, true);
            } else if (iZzg == 1668249202) {
                int iZzg3 = zzekVar.zzg();
                if (zzekVar.zzg() == 1684108385) {
                    int iZzg4 = zzekVar.zzg();
                    int i3 = zzaie.zza;
                    int i4 = iZzg4 & ViewCompat.MEASURED_SIZE_MASK;
                    if (i4 == 13) {
                        str = "image/jpeg";
                    } else if (i4 == 14) {
                        str = "image/png";
                        i4 = 14;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        zzdx.zzf("MetadataUtil", "Unrecognized cover art flags: " + i4);
                    } else {
                        zzekVar.zzM(4);
                        int i5 = iZzg3 - 16;
                        byte[] bArr = new byte[i5];
                        zzekVar.zzH(bArr, 0, i5);
                        zzagdVar = new zzagd(str, null, 3, bArr);
                        zzauVarZze = zzagdVar;
                    }
                } else {
                    zzdx.zzf("MetadataUtil", "Failed to parse cover art attribute");
                }
            } else if (iZzg == 1631670868) {
                zzauVarZze = zze(1631670868, "TPE2", zzekVar);
            } else if (iZzg == 1936682605) {
                zzauVarZze = zze(1936682605, "TSOT", zzekVar);
            } else if (iZzg == 1936679276) {
                zzauVarZze = zze(1936679276, "TSOA", zzekVar);
            } else if (iZzg == 1936679282) {
                zzauVarZze = zze(1936679282, "TSOP", zzekVar);
            } else if (iZzg == 1936679265) {
                zzauVarZze = zze(1936679265, "TSO2", zzekVar);
            } else if (iZzg == 1936679791) {
                zzauVarZze = zze(1936679791, "TSOC", zzekVar);
            } else if (iZzg == 1920233063) {
                zzauVarZze = zzc(1920233063, "ITUNESADVISORY", zzekVar, false, false);
            } else if (iZzg == 1885823344) {
                zzauVarZze = zzc(1885823344, "ITUNESGAPLESS", zzekVar, false, true);
            } else if (iZzg == 1936683886) {
                zzauVarZze = zze(1936683886, "TVSHOWSORT", zzekVar);
            } else if (iZzg == 1953919848) {
                zzauVarZze = zze(1953919848, "TVSHOW", zzekVar);
            } else if (iZzg == 757935405) {
                int i6 = -1;
                int i7 = -1;
                String strZzA2 = null;
                String strZzA3 = null;
                while (zzekVar.zzc() < iZzc) {
                    int iZzc2 = zzekVar.zzc();
                    int iZzg5 = zzekVar.zzg();
                    int iZzg6 = zzekVar.zzg();
                    zzekVar.zzM(4);
                    if (iZzg6 == 1835360622) {
                        strZzA2 = zzekVar.zzA(iZzg5 - 12);
                    } else {
                        int i8 = iZzg5 - 12;
                        if (iZzg6 == 1851878757) {
                            strZzA3 = zzekVar.zzA(i8);
                        } else {
                            if (iZzg6 == 1684108385) {
                                i7 = iZzg5;
                            }
                            if (iZzg6 == 1684108385) {
                                i6 = iZzc2;
                            }
                            zzekVar.zzM(i8);
                        }
                    }
                }
                if (strZzA2 != null && strZzA3 != null && i6 != -1) {
                    zzekVar.zzL(i6);
                    zzekVar.zzM(16);
                    zzauVarZze = new zzago(strZzA2, strZzA3, zzekVar.zzA(i7 - 16));
                }
            } else {
                zzdx.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzfa.zze(iZzg));
            }
            zzekVar.zzL(iZzc);
            return zzauVarZze;
        } catch (Throwable th) {
            zzekVar.zzL(iZzc);
            throw th;
        }
    }

    private static int zzb(zzek zzekVar) {
        int iZzg = zzekVar.zzg();
        if (zzekVar.zzg() == 1684108385) {
            zzekVar.zzM(8);
            int i = iZzg - 16;
            if (i == 1) {
                return zzekVar.zzm();
            }
            if (i == 2) {
                return zzekVar.zzq();
            }
            if (i == 3) {
                return zzekVar.zzo();
            }
            if (i == 4 && (zzekVar.zzf() & 128) == 0) {
                return zzekVar.zzp();
            }
        }
        zzdx.zzf("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    private static zzagm zzc(int i, String str, zzek zzekVar, boolean z, boolean z2) {
        int iZzb = zzb(zzekVar);
        if (z2) {
            iZzb = Math.min(1, iZzb);
        }
        if (iZzb >= 0) {
            return z ? new zzagr(str, null, zzfww.zzo(Integer.toString(iZzb))) : new zzagh("und", str, Integer.toString(iZzb));
        }
        zzdx.zzf("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzfa.zze(i)));
        return null;
    }

    private static zzagr zzd(int i, String str, zzek zzekVar) {
        int iZzg = zzekVar.zzg();
        if (zzekVar.zzg() == 1684108385 && iZzg >= 22) {
            zzekVar.zzM(10);
            int iZzq = zzekVar.zzq();
            if (iZzq > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(iZzq);
                String string = sb.toString();
                int iZzq2 = zzekVar.zzq();
                if (iZzq2 > 0) {
                    string = string + RemoteSettings.FORWARD_SLASH_STRING + iZzq2;
                }
                return new zzagr(str, null, zzfww.zzo(string));
            }
        }
        zzdx.zzf("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzfa.zze(i)));
        return null;
    }

    private static zzagr zze(int i, String str, zzek zzekVar) {
        int iZzg = zzekVar.zzg();
        if (zzekVar.zzg() == 1684108385) {
            zzekVar.zzM(8);
            return new zzagr(str, null, zzfww.zzo(zzekVar.zzA(iZzg - 16)));
        }
        zzdx.zzf("MetadataUtil", "Failed to parse text attribute: ".concat(zzfa.zze(i)));
        return null;
    }
}
