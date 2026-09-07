package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzyl extends zzyi {
    private final boolean zze;
    private final zzyb zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final boolean zzs;
    private final boolean zzt;
    private final int zzu;

    /* JADX WARN: Code duplicated, block: B:122:0x017f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0040  */
    /* JADX WARN: Code duplicated, block: B:32:0x004f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0053  */
    /* JADX WARN: Code duplicated, block: B:36:0x0057  */
    /* JADX WARN: Code duplicated, block: B:38:0x005d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0064  */
    /* JADX WARN: Code duplicated, block: B:42:0x0068  */
    /* JADX WARN: Code duplicated, block: B:45:0x006e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0125  */
    public zzyl(int i, zzbm zzbmVar, int i2, zzyb zzybVar, int i3, String str, int i4, boolean z) {
        boolean z2;
        boolean z3;
        int i5;
        int iZzc;
        int i6;
        byte b;
        boolean z4;
        int i7;
        float f;
        int i8;
        zzz zzzVar;
        int i9;
        int i10;
        int i11;
        super(i, zzbmVar, i2);
        this.zzf = zzybVar;
        int i12 = 1;
        int i13 = true != zzybVar.zzI ? 16 : 24;
        boolean z5 = zzybVar.zzH;
        if (!z || (((i9 = (zzzVar = this.zzd).zzv) != -1 && i9 > zzybVar.zza) || ((i10 = zzzVar.zzw) != -1 && i10 > zzybVar.zzb))) {
            z2 = false;
        } else {
            float f2 = zzzVar.zzx;
            if ((f2 == -1.0f || f2 <= zzybVar.zzc) && ((i11 = zzzVar.zzj) == -1 || i11 <= zzybVar.zzd)) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        this.zze = z2;
        if (z) {
            zzz zzzVar2 = this.zzd;
            int i14 = zzzVar2.zzv;
            if (i14 != -1) {
                int i15 = zzybVar.zze;
                if (i14 >= 0) {
                    i7 = zzzVar2.zzw;
                    if (i7 != -1) {
                        int i16 = zzybVar.zzf;
                        if (i7 >= 0) {
                            f = zzzVar2.zzx;
                            if (f != -1.0f) {
                                int i17 = zzybVar.zzg;
                                if (f >= 0.0f) {
                                    i8 = zzzVar2.zzj;
                                    if (i8 != -1) {
                                        int i18 = zzybVar.zzh;
                                        if (i8 >= 0) {
                                            z3 = false;
                                        }
                                    }
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                            } else {
                                i8 = zzzVar2.zzj;
                                if (i8 != -1) {
                                    int i19 = zzybVar.zzh;
                                    if (i8 >= 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = true;
                            }
                        } else {
                            z3 = false;
                        }
                    } else {
                        f = zzzVar2.zzx;
                        if (f != -1.0f) {
                            int i110 = zzybVar.zzg;
                            if (f >= 0.0f) {
                                i8 = zzzVar2.zzj;
                                if (i8 != -1) {
                                    int i111 = zzybVar.zzh;
                                    if (i8 >= 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } else {
                            i8 = zzzVar2.zzj;
                            if (i8 != -1) {
                                int i112 = zzybVar.zzh;
                                if (i8 >= 0) {
                                    z3 = false;
                                }
                            }
                            z3 = true;
                        }
                    }
                } else {
                    z3 = false;
                }
            } else {
                i7 = zzzVar2.zzw;
                if (i7 != -1) {
                    int i113 = zzybVar.zzf;
                    if (i7 >= 0) {
                        f = zzzVar2.zzx;
                        if (f != -1.0f) {
                            int i114 = zzybVar.zzg;
                            if (f >= 0.0f) {
                                i8 = zzzVar2.zzj;
                                if (i8 != -1) {
                                    int i115 = zzybVar.zzh;
                                    if (i8 >= 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } else {
                            i8 = zzzVar2.zzj;
                            if (i8 != -1) {
                                int i116 = zzybVar.zzh;
                                if (i8 >= 0) {
                                    z3 = false;
                                }
                            }
                            z3 = true;
                        }
                    } else {
                        z3 = false;
                    }
                } else {
                    f = zzzVar2.zzx;
                    if (f != -1.0f) {
                        int i117 = zzybVar.zzg;
                        if (f >= 0.0f) {
                            i8 = zzzVar2.zzj;
                            if (i8 != -1) {
                                int i118 = zzybVar.zzh;
                                if (i8 >= 0) {
                                    z3 = false;
                                }
                            }
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    } else {
                        i8 = zzzVar2.zzj;
                        if (i8 != -1) {
                            int i119 = zzybVar.zzh;
                            if (i8 >= 0) {
                                z3 = false;
                            }
                        }
                        z3 = true;
                    }
                }
            }
        } else {
            z3 = false;
        }
        this.zzg = z3;
        this.zzh = zzlv.zza(i3, false);
        zzz zzzVar3 = this.zzd;
        float f3 = zzzVar3.zzx;
        this.zzi = f3 != -1.0f && f3 >= 10.0f;
        this.zzj = zzzVar3.zzj;
        this.zzk = zzzVar3.zza();
        int i20 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i20 >= zzybVar.zzn.size()) {
                iZzc = 0;
                i20 = Integer.MAX_VALUE;
                break;
            } else {
                iZzc = zzyn.zzc(this.zzd, (String) zzybVar.zzn.get(i20), false);
                if (iZzc > 0) {
                    break;
                } else {
                    i20++;
                }
            }
        }
        this.zzm = i20;
        this.zzn = iZzc;
        int i21 = this.zzd.zzf;
        int i22 = zzybVar.zzo;
        this.zzo = zzyn.zzb(i21, 0);
        int i23 = this.zzd.zzf;
        this.zzp = i23 == 0 || (i23 & 1) != 0;
        this.zzq = zzyn.zzc(this.zzd, str, zzyn.zzh(str) == null);
        for (int i24 = 0; i24 < zzybVar.zzm.size(); i24++) {
            String str2 = this.zzd.zzo;
            if (str2 != null && str2.equals(zzybVar.zzm.get(i24))) {
                i5 = i24;
                break;
            }
        }
        this.zzl = i5;
        this.zzs = (i3 & 384) == 128;
        this.zzt = (i3 & 64) == 64;
        zzz zzzVar4 = this.zzd;
        String str3 = zzzVar4.zzo;
        if (str3 == null) {
            i6 = 0;
        } else {
            i6 = 4;
            switch (str3) {
                case "video/dolby-vision":
                    b = 0;
                    break;
                case "video/av01":
                    b = 1;
                    break;
                case "video/hevc":
                    b = 2;
                    break;
                case "video/avc":
                    b = 4;
                    break;
                case "video/x-vnd.on2.vp9":
                    b = 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                i6 = 5;
            } else if (b != 1) {
                if (b == 2) {
                    i6 = 3;
                } else if (b == 3) {
                    i6 = 2;
                } else if (b != 4) {
                    i6 = 0;
                } else {
                    i6 = 1;
                }
            }
        }
        this.zzu = i6;
        if ((zzzVar4.zzf & 16384) != 0) {
            i12 = 0;
        } else {
            zzyb zzybVar2 = this.zzf;
            if (!zzlv.zza(i3, zzybVar2.zzR) || (!(z4 = this.zze) && !zzybVar2.zzG)) {
                i12 = 0;
            } else if (zzlv.zza(i3, false) && this.zzg && z4 && zzzVar4.zzj != -1) {
                boolean z6 = zzybVar2.zzC;
                boolean z7 = zzybVar2.zzB;
                if ((i13 & i3) != 0) {
                    i12 = 2;
                }
            }
        }
        this.zzr = i12;
    }

    public static /* synthetic */ int zza(zzyl zzylVar, zzyl zzylVar2) {
        zzfyh zzfyhVarZza = (zzylVar.zze && zzylVar.zzh) ? zzyn.zzc : zzyn.zzc.zza();
        zzfwl zzfwlVarZzj = zzfwl.zzj();
        boolean z = zzylVar.zzf.zzB;
        return zzfwlVarZzj.zzc(Integer.valueOf(zzylVar.zzk), Integer.valueOf(zzylVar2.zzk), zzfyhVarZza).zzc(Integer.valueOf(zzylVar.zzj), Integer.valueOf(zzylVar2.zzj), zzfyhVarZza).zza();
    }

    public static /* synthetic */ int zzd(zzyl zzylVar, zzyl zzylVar2) {
        zzfwl zzfwlVarZzc = zzfwl.zzj().zzd(zzylVar.zzh, zzylVar2.zzh).zzc(Integer.valueOf(zzylVar.zzm), Integer.valueOf(zzylVar2.zzm), zzfyh.zzc().zza()).zzb(zzylVar.zzn, zzylVar2.zzn).zzb(zzylVar.zzo, zzylVar2.zzo).zzd(zzylVar.zzp, zzylVar2.zzp).zzb(zzylVar.zzq, zzylVar2.zzq).zzd(zzylVar.zzi, zzylVar2.zzi).zzd(zzylVar.zze, zzylVar2.zze).zzd(zzylVar.zzg, zzylVar2.zzg).zzc(Integer.valueOf(zzylVar.zzl), Integer.valueOf(zzylVar2.zzl), zzfyh.zzc().zza());
        boolean z = zzylVar.zzs;
        zzfwl zzfwlVarZzd = zzfwlVarZzc.zzd(z, zzylVar2.zzs);
        boolean z2 = zzylVar.zzt;
        zzfwl zzfwlVarZzd2 = zzfwlVarZzd.zzd(z2, zzylVar2.zzt);
        if (z && z2) {
            zzfwlVarZzd2 = zzfwlVarZzd2.zzb(zzylVar.zzu, zzylVar2.zzu);
        }
        return zzfwlVarZzd2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final int zzb() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final /* bridge */ /* synthetic */ boolean zzc(zzyi zzyiVar) {
        zzyl zzylVar = (zzyl) zzyiVar;
        if (!Objects.equals(this.zzd.zzo, zzylVar.zzd.zzo)) {
            return false;
        }
        boolean z = this.zzf.zzJ;
        return this.zzs == zzylVar.zzs && this.zzt == zzylVar.zzt;
    }
}
