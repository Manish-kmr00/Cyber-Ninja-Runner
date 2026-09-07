package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.common.primitives.SignedBytes;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzamd implements zzant {
    private final List zza;

    public zzamd() {
        this(0);
    }

    public zzamd(int i, List list) {
        this.zza = list;
    }

    private final zzank zzc(zzans zzansVar) {
        return new zzank(zze(zzansVar), "video/mp2t");
    }

    private final zzanx zzd(zzans zzansVar) {
        return new zzanx(zze(zzansVar), "video/mp2t");
    }

    private final List zze(zzans zzansVar) {
        String str;
        int i;
        List listSingletonList;
        zzek zzekVar = new zzek(zzansVar.zze);
        List arrayList = this.zza;
        while (zzekVar.zza() > 0) {
            int iZzm = zzekVar.zzm();
            int iZzc = zzekVar.zzc() + zzekVar.zzm();
            if (iZzm == 134) {
                arrayList = new ArrayList();
                int iZzm2 = zzekVar.zzm() & 31;
                for (int i2 = 0; i2 < iZzm2; i2++) {
                    String strZzB = zzekVar.zzB(3, StandardCharsets.UTF_8);
                    int iZzm3 = zzekVar.zzm();
                    boolean z = (iZzm3 & 128) != 0;
                    if (z) {
                        i = iZzm3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte bZzm = (byte) zzekVar.zzm();
                    zzekVar.zzM(1);
                    if (z) {
                        int i3 = bZzm & SignedBytes.MAX_POWER_OF_TWO;
                        int i4 = zzdh.zza;
                        listSingletonList = Collections.singletonList(i3 != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    zzx zzxVar = new zzx();
                    zzxVar.zzad(str);
                    zzxVar.zzS(strZzB);
                    zzxVar.zzz(i);
                    zzxVar.zzP(listSingletonList);
                    arrayList.add(zzxVar.zzaj());
                }
            }
            zzekVar.zzL(iZzc);
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final SparseArray zza() {
        return new SparseArray();
    }

    public zzamd(int i) {
        this.zza = zzfww.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final zzanv zzb(int i, zzans zzansVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new zzana(new zzams(zzansVar.zzb, zzansVar.zza(), "video/mp2t"));
            }
            if (i == 21) {
                return new zzana(new zzamq("video/mp2t"));
            }
            if (i == 27) {
                return new zzana(new zzamn(zzc(zzansVar), false, false, "video/mp2t"));
            }
            if (i == 36) {
                return new zzana(new zzamp(zzc(zzansVar), "video/mp2t"));
            }
            if (i == 45) {
                return new zzana(new zzamt("video/mp2t"));
            }
            if (i == 89) {
                return new zzana(new zzamf(zzansVar.zzd, "video/mp2t"));
            }
            if (i == 172) {
                return new zzana(new zzama(zzansVar.zzb, zzansVar.zza(), "video/mp2t"));
            }
            if (i == 257) {
                return new zzani(new zzamz("application/vnd.dvb.ait", "video/mp2t"));
            }
            if (i != 128) {
                if (i != 129) {
                    if (i != 138) {
                        if (i == 139) {
                            return new zzana(new zzame(zzansVar.zzb, zzansVar.zza(), 5408, "video/mp2t"));
                        }
                        switch (i) {
                            case 15:
                                return new zzana(new zzamc(false, zzansVar.zzb, zzansVar.zza(), "video/mp2t"));
                            case 16:
                                return new zzana(new zzaml(zzd(zzansVar), "video/mp2t"));
                            case 17:
                                return new zzana(new zzamr(zzansVar.zzb, zzansVar.zza(), "video/mp2t"));
                            default:
                                switch (i) {
                                    case 134:
                                        return new zzani(new zzamz("application/x-scte35", "video/mp2t"));
                                    case 135:
                                        break;
                                    case 136:
                                        break;
                                    default:
                                        return null;
                                }
                                break;
                        }
                    }
                    return new zzana(new zzame(zzansVar.zzb, zzansVar.zza(), 4096, "video/mp2t"));
                }
                return new zzana(new zzaly(zzansVar.zzb, zzansVar.zza(), "video/mp2t"));
            }
        }
        return new zzana(new zzami(zzd(zzansVar), "video/mp2t"));
    }
}
