package com.google.android.gms.internal.ads;

import io.ktor.util.date.GMTDateParser;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaiu {
    private static final zzful zza = zzful.zzb(zzfth.zzc(AbstractJsonLexerKt.COLON));
    private static final zzful zzb = zzful.zzb(zzfth.zzc(GMTDateParser.ANY));
    private final List zzc = new ArrayList();
    private int zzd = 0;
    private int zze;

    public final void zzb() {
        this.zzc.clear();
        this.zzd = 0;
    }

    public final int zza(zzadd zzaddVar, zzady zzadyVar, List list) throws IOException {
        byte b;
        char c;
        int i = this.zzd;
        if (i == 0) {
            long jZzd = zzaddVar.zzd();
            zzadyVar.zza = (jZzd == -1 || jZzd < 8) ? 0L : jZzd - 8;
            this.zzd = 1;
            return 1;
        }
        int i2 = 2;
        if (i != 1) {
            char c2 = 2819;
            short s = 2817;
            short s2 = 2816;
            short s3 = 2192;
            if (i != 2) {
                long jZzf = zzaddVar.zzf();
                int iZzd = (int) ((zzaddVar.zzd() - zzaddVar.zzf()) - ((long) this.zze));
                zzek zzekVar = new zzek(iZzd);
                zzaddVar.zzi(zzekVar.zzN(), 0, iZzd);
                int i3 = 0;
                while (true) {
                    List list2 = this.zzc;
                    if (i3 >= list2.size()) {
                        zzadyVar.zza = 0L;
                        return 1;
                    }
                    zzait zzaitVar = (zzait) list2.get(i3);
                    zzekVar.zzL((int) (zzaitVar.zza - jZzf));
                    zzekVar.zzM(4);
                    int iZzi = zzekVar.zzi();
                    switch (zzekVar.zzB(iZzi, StandardCharsets.UTF_8)) {
                        case "SlowMotion_Data":
                            b = 0;
                            break;
                        case "Super_SlowMotion_Edit_Data":
                            b = 3;
                            break;
                        case "Super_SlowMotion_Data":
                            b = 1;
                            break;
                        case "Super_SlowMotion_Deflickering_On":
                            b = 4;
                            break;
                        case "Super_SlowMotion_BGM":
                            b = 2;
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    if (b == 0) {
                        c = 2192;
                    } else if (b == 1) {
                        c = 2816;
                    } else if (b == 2) {
                        c = 2817;
                    } else if (b == 3) {
                        c = c2;
                    } else {
                        if (b != 4) {
                            throw zzaz.zza("Invalid SEF name", null);
                        }
                        c = 2820;
                    }
                    int i4 = zzaitVar.zzb - (iZzi + 8);
                    if (c == 2192) {
                        ArrayList arrayList = new ArrayList();
                        List listZzf = zzb.zzf(zzekVar.zzB(i4, StandardCharsets.UTF_8));
                        for (int i5 = 0; i5 < listZzf.size(); i5++) {
                            List listZzf2 = zza.zzf((CharSequence) listZzf.get(i5));
                            if (listZzf2.size() != 3) {
                                throw zzaz.zza(null, null);
                            }
                            try {
                                arrayList.add(new zzagu(Long.parseLong((String) listZzf2.get(0)), Long.parseLong((String) listZzf2.get(1)), 1 << (Integer.parseInt((String) listZzf2.get(2)) - 1)));
                            } catch (NumberFormatException e) {
                                throw zzaz.zza(null, e);
                            }
                        }
                        list.add(new zzagv(arrayList));
                    } else if (c != 2816 && c != 2817 && c != c2 && c != 2820) {
                        throw new IllegalStateException();
                    }
                    i3++;
                    c2 = 2819;
                }
            } else {
                long jZzd2 = zzaddVar.zzd();
                int i6 = this.zze - 20;
                zzek zzekVar2 = new zzek(i6);
                zzaddVar.zzi(zzekVar2.zzN(), 0, i6);
                int i7 = 0;
                while (i7 < i6 / 12) {
                    zzekVar2.zzM(i2);
                    short sZzD = zzekVar2.zzD();
                    if (sZzD == s3 || sZzD == s2 || sZzD == s || sZzD == 2819 || sZzD == 2820) {
                        this.zzc.add(new zzait(sZzD, (jZzd2 - ((long) this.zze)) - ((long) zzekVar2.zzi()), zzekVar2.zzi()));
                    } else {
                        zzekVar2.zzM(8);
                    }
                    i7++;
                    i6 = i6;
                    i2 = 2;
                    s = 2817;
                    s2 = 2816;
                    s3 = 2192;
                }
                List list3 = this.zzc;
                if (list3.isEmpty()) {
                    zzadyVar.zza = 0L;
                } else {
                    this.zzd = 3;
                    zzadyVar.zza = ((zzait) list3.get(0)).zza;
                }
            }
        } else {
            zzek zzekVar3 = new zzek(8);
            zzaddVar.zzi(zzekVar3.zzN(), 0, 8);
            this.zze = zzekVar3.zzi() + 8;
            if (zzekVar3.zzg() != 1397048916) {
                zzadyVar.zza = 0L;
            } else {
                zzadyVar.zza = zzaddVar.zzf() - ((long) (this.zze - 12));
                this.zzd = 2;
            }
        }
        return 1;
    }
}
