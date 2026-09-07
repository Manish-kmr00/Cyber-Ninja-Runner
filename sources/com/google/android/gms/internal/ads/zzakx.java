package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.Pair;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzakx {
    public final String zza;
    public final String zzb;
    public final boolean zzc;
    public final long zzd;
    public final long zze;
    public final zzald zzf;
    public final String zzg;
    public final String zzh;
    public final zzakx zzi;
    private final String[] zzj;
    private final HashMap zzk;
    private final HashMap zzl;
    private List zzm;

    public static zzakx zzb(String str, long j, long j2, zzald zzaldVar, String[] strArr, String str2, String str3, zzakx zzakxVar) {
        return new zzakx(str, null, j, j2, zzaldVar, strArr, str2, str3, zzakxVar);
    }

    public static zzakx zzc(String str) {
        return new zzakx(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    private static SpannableStringBuilder zzi(String str, Map map) {
        if (!map.containsKey(str)) {
            zzcs zzcsVar = new zzcs();
            zzcsVar.zzl(new SpannableStringBuilder());
            map.put(str, zzcsVar);
        }
        CharSequence charSequenceZzq = ((zzcs) map.get(str)).zzq();
        charSequenceZzq.getClass();
        return (SpannableStringBuilder) charSequenceZzq;
    }

    private final void zzj(TreeSet treeSet, boolean z) {
        String str = this.zza;
        boolean zEquals = "p".equals(str);
        boolean zEquals2 = "div".equals(str);
        if (z || zEquals || (zEquals2 && this.zzh != null)) {
            long j = this.zzd;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.zze;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.zzm != null) {
            for (int i = 0; i < this.zzm.size(); i++) {
                zzakx zzakxVar = (zzakx) this.zzm.get(i);
                boolean z2 = true;
                if (!z && !zEquals) {
                    z2 = false;
                }
                zzakxVar.zzj(treeSet, z2);
            }
        }
    }

    private final void zzk(long j, String str, List list) {
        String str2;
        String str3 = this.zzg;
        if (true != "".equals(str3)) {
            str = str3;
        }
        if (zzg(j) && "div".equals(this.zza) && (str2 = this.zzh) != null) {
            list.add(new Pair(str, str2));
            return;
        }
        for (int i = 0; i < zza(); i++) {
            zzd(i).zzk(j, str, list);
        }
    }

    private final void zzl(long j, Map map, Map map2, String str, Map map3) {
        zzakx zzakxVar;
        zzald zzaldVarZza;
        boolean z;
        int i;
        if (zzg(j)) {
            String str2 = this.zzg;
            String str3 = true != "".equals(str2) ? str2 : str;
            Iterator it = this.zzl.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str4 = (String) entry.getKey();
                HashMap map4 = this.zzk;
                int iIntValue = map4.containsKey(str4) ? ((Integer) map4.get(str4)).intValue() : 0;
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (iIntValue != iIntValue2) {
                    zzcs zzcsVar = (zzcs) map3.get(str4);
                    zzcsVar.getClass();
                    zzalb zzalbVar = (zzalb) map2.get(str3);
                    zzalbVar.getClass();
                    int i2 = zzalbVar.zzj;
                    zzald zzaldVarZza2 = zzalc.zza(this.zzf, this.zzj, map);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) zzcsVar.zzq();
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        zzcsVar.zzl(spannableStringBuilder);
                    }
                    if (zzaldVarZza2 != null) {
                        zzakx zzakxVar2 = this.zzi;
                        if (zzaldVarZza2.zzh() != -1) {
                            spannableStringBuilder.setSpan(new StyleSpan(zzaldVarZza2.zzh()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaldVarZza2.zzM()) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (zzaldVarZza2.zzN()) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (zzaldVarZza2.zzL()) {
                            zzcz.zzb(spannableStringBuilder, new ForegroundColorSpan(zzaldVarZza2.zzd()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaldVarZza2.zzK()) {
                            zzcz.zzb(spannableStringBuilder, new BackgroundColorSpan(zzaldVarZza2.zzc()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaldVarZza2.zzG() != null) {
                            zzcz.zzb(spannableStringBuilder, new TypefaceSpan(zzaldVarZza2.zzG()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaldVarZza2.zzk() != null) {
                            zzakw zzakwVarZzk = zzaldVarZza2.zzk();
                            zzakwVarZzk.getClass();
                            int i3 = zzakwVarZzk.zza;
                            if (i3 == -1) {
                                i3 = (i2 == 2 || i2 == 1) ? 3 : 1;
                                i = 1;
                            } else {
                                i = zzakwVarZzk.zzb;
                            }
                            int i4 = zzakwVarZzk.zzc;
                            if (i4 == -2) {
                                i4 = 1;
                            }
                            zzcz.zzb(spannableStringBuilder, new zzda(i3, i, i4), iIntValue, iIntValue2, 33);
                        }
                        int iZzg = zzaldVarZza2.zzg();
                        if (iZzg == 2) {
                            while (true) {
                                if (zzakxVar2 == null) {
                                    zzakxVar2 = null;
                                    break;
                                }
                                zzald zzaldVarZza3 = zzalc.zza(zzakxVar2.zzf, zzakxVar2.zzj, map);
                                if (zzaldVarZza3 != null && zzaldVarZza3.zzg() == 1) {
                                    break;
                                } else {
                                    zzakxVar2 = zzakxVar2.zzi;
                                }
                            }
                            if (zzakxVar2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(zzakxVar2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        zzakxVar = null;
                                        break;
                                    }
                                    zzakx zzakxVar3 = (zzakx) arrayDeque.pop();
                                    zzald zzaldVarZza4 = zzalc.zza(zzakxVar3.zzf, zzakxVar3.zzj, map);
                                    if (zzaldVarZza4 != null && zzaldVarZza4.zzg() == 3) {
                                        zzakxVar = zzakxVar3;
                                        break;
                                    }
                                    for (int iZza = zzakxVar3.zza() - 1; iZza >= 0; iZza--) {
                                        arrayDeque.push(zzakxVar3.zzd(iZza));
                                    }
                                }
                                if (zzakxVar != null) {
                                    if (zzakxVar.zza() != 1 || zzakxVar.zzd(0).zzb == null) {
                                        zzdx.zze("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                    } else {
                                        String str5 = zzakxVar.zzd(0).zzb;
                                        int i5 = zzeu.zza;
                                        zzald zzaldVarZza5 = zzalc.zza(zzakxVar.zzf, zzakxVar.zzj, map);
                                        int iZzf = zzaldVarZza5 != null ? zzaldVarZza5.zzf() : -1;
                                        if (iZzf == -1 && (zzaldVarZza = zzalc.zza(zzakxVar2.zzf, zzakxVar2.zzj, map)) != null) {
                                            iZzf = zzaldVarZza.zzf();
                                        }
                                        spannableStringBuilder.setSpan(new zzcy(str5, iZzf), iIntValue, iIntValue2, 33);
                                    }
                                }
                            }
                        } else if (iZzg == 3 || iZzg == 4) {
                            spannableStringBuilder.setSpan(new zzakv(), iIntValue, iIntValue2, 33);
                        }
                        if (zzaldVarZza2.zzJ()) {
                            zzcz.zzb(spannableStringBuilder, new zzcx(), iIntValue, iIntValue2, 33);
                        }
                        int iZze = zzaldVarZza2.zze();
                        if (iZze != 1) {
                            if (iZze == 2) {
                                zzcz.zzb(spannableStringBuilder, new RelativeSizeSpan(zzaldVarZza2.zza()), iIntValue, iIntValue2, 33);
                            } else if (iZze == 3) {
                                zzcz.zza(spannableStringBuilder, zzaldVarZza2.zza() / 100.0f, iIntValue, iIntValue2, 33);
                            }
                            z = true;
                        } else {
                            z = true;
                            zzcz.zzb(spannableStringBuilder, new AbsoluteSizeSpan((int) zzaldVarZza2.zza(), true), iIntValue, iIntValue2, 33);
                        }
                        if ("p".equals(this.zza)) {
                            if (zzaldVarZza2.zzb() != Float.MAX_VALUE) {
                                zzcsVar.zzj((zzaldVarZza2.zzb() * (-90.0f)) / 100.0f);
                            }
                            if (zzaldVarZza2.zzj() != null) {
                                zzcsVar.zzm(zzaldVarZza2.zzj());
                            }
                            if (zzaldVarZza2.zzi() != null) {
                                zzcsVar.zzg(zzaldVarZza2.zzi());
                            }
                        }
                        it = it;
                    }
                }
            }
            for (int i6 = 0; i6 < zza(); i6++) {
                zzd(i6).zzl(j, map, map2, str3, map3);
            }
        }
    }

    private final void zzm(long j, boolean z, String str, Map map) {
        HashMap map2 = this.zzk;
        map2.clear();
        HashMap map3 = this.zzl;
        map3.clear();
        String str2 = this.zza;
        if ("metadata".equals(str2)) {
            return;
        }
        String str3 = this.zzg;
        String str4 = true != "".equals(str3) ? str3 : str;
        if (this.zzc && z) {
            SpannableStringBuilder spannableStringBuilderZzi = zzi(str4, map);
            String str5 = this.zzb;
            str5.getClass();
            spannableStringBuilderZzi.append((CharSequence) str5);
            return;
        }
        if ("br".equals(str2) && z) {
            zzi(str4, map).append('\n');
            return;
        }
        if (zzg(j)) {
            for (Map.Entry entry : map.entrySet()) {
                String str6 = (String) entry.getKey();
                CharSequence charSequenceZzq = ((zzcs) entry.getValue()).zzq();
                charSequenceZzq.getClass();
                map2.put(str6, Integer.valueOf(charSequenceZzq.length()));
            }
            boolean zEquals = "p".equals(str2);
            for (int i = 0; i < zza(); i++) {
                zzd(i).zzm(j, z || zEquals, str4, map);
            }
            if (zEquals) {
                SpannableStringBuilder spannableStringBuilderZzi2 = zzi(str4, map);
                int length = spannableStringBuilderZzi2.length();
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (spannableStringBuilderZzi2.charAt(length) == ' ');
                if (length >= 0 && spannableStringBuilderZzi2.charAt(length) != '\n') {
                    spannableStringBuilderZzi2.append('\n');
                }
            }
            for (Map.Entry entry2 : map.entrySet()) {
                String str7 = (String) entry2.getKey();
                CharSequence charSequenceZzq2 = ((zzcs) entry2.getValue()).zzq();
                charSequenceZzq2.getClass();
                map3.put(str7, Integer.valueOf(charSequenceZzq2.length()));
            }
        }
    }

    public final int zza() {
        List list = this.zzm;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final zzakx zzd(int i) {
        List list = this.zzm;
        if (list != null) {
            return (zzakx) list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List zze(long j, Map map, Map map2, Map map3) {
        List arrayList = new ArrayList();
        String str = this.zzg;
        zzk(j, str, arrayList);
        TreeMap treeMap = new TreeMap();
        zzm(j, false, str, treeMap);
        zzl(j, map, map2, str, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Pair pair = (Pair) arrayList.get(i);
            String str2 = (String) map3.get(pair.second);
            if (str2 != null) {
                byte[] bArrDecode = Base64.decode(str2, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                zzalb zzalbVar = (zzalb) map2.get(pair.first);
                zzalbVar.getClass();
                zzcs zzcsVar = new zzcs();
                zzcsVar.zzc(bitmapDecodeByteArray);
                zzcsVar.zzh(zzalbVar.zzb);
                zzcsVar.zzi(0);
                zzcsVar.zze(zzalbVar.zzc, 0);
                zzcsVar.zzf(zzalbVar.zze);
                zzcsVar.zzk(zzalbVar.zzf);
                zzcsVar.zzd(zzalbVar.zzg);
                zzcsVar.zzo(zzalbVar.zzj);
                arrayList2.add(zzcsVar.zzp());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            zzalb zzalbVar2 = (zzalb) map2.get(entry.getKey());
            zzalbVar2.getClass();
            zzcs zzcsVar2 = (zzcs) entry.getValue();
            CharSequence charSequenceZzq = zzcsVar2.zzq();
            charSequenceZzq.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequenceZzq;
            for (zzakv zzakvVar : (zzakv[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), zzakv.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(zzakvVar), spannableStringBuilder.getSpanEnd(zzakvVar), (CharSequence) "");
            }
            int i2 = 0;
            while (i2 < spannableStringBuilder.length()) {
                int i3 = i2 + 1;
                if (spannableStringBuilder.charAt(i2) == ' ') {
                    int i4 = i3;
                    while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                        i4++;
                    }
                    int i5 = i4 - i3;
                    if (i5 > 0) {
                        spannableStringBuilder.delete(i2, i5 + i2);
                    }
                }
                i2 = i3;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            int i6 = 0;
            while (i6 < spannableStringBuilder.length() - 1) {
                int i7 = i6 + 1;
                if (spannableStringBuilder.charAt(i6) == '\n' && spannableStringBuilder.charAt(i7) == ' ') {
                    spannableStringBuilder.delete(i7, i6 + 2);
                }
                i6 = i7;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            int i8 = 0;
            while (i8 < spannableStringBuilder.length() - 1) {
                int i9 = i8 + 1;
                if (spannableStringBuilder.charAt(i8) == ' ' && spannableStringBuilder.charAt(i9) == '\n') {
                    spannableStringBuilder.delete(i8, i9);
                }
                i8 = i9;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            zzcsVar2.zze(zzalbVar2.zzc, zzalbVar2.zzd);
            zzcsVar2.zzf(zzalbVar2.zze);
            zzcsVar2.zzh(zzalbVar2.zzb);
            zzcsVar2.zzk(zzalbVar2.zzf);
            zzcsVar2.zzn(zzalbVar2.zzi, zzalbVar2.zzh);
            zzcsVar2.zzo(zzalbVar2.zzj);
            arrayList2.add(zzcsVar2.zzp());
        }
        return arrayList2;
    }

    public final void zzf(zzakx zzakxVar) {
        if (this.zzm == null) {
            this.zzm = new ArrayList();
        }
        this.zzm.add(zzakxVar);
    }

    public final boolean zzg(long j) {
        long j2 = this.zzd;
        if (j2 == -9223372036854775807L) {
            if (this.zze == -9223372036854775807L) {
                return true;
            }
            j2 = -9223372036854775807L;
        }
        if (j2 <= j && this.zze == -9223372036854775807L) {
            return true;
        }
        if (j2 != -9223372036854775807L || j >= this.zze) {
            return j2 <= j && j < this.zze;
        }
        return true;
    }

    public final long[] zzh() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        zzj(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    private zzakx(String str, String str2, long j, long j2, zzald zzaldVar, String[] strArr, String str3, String str4, zzakx zzakxVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzh = str4;
        this.zzf = zzaldVar;
        this.zzj = strArr;
        this.zzc = str2 != null;
        this.zzd = j;
        this.zze = j2;
        str3.getClass();
        this.zzg = str3;
        this.zzi = zzakxVar;
        this.zzk = new HashMap();
        this.zzl = new HashMap();
    }
}
