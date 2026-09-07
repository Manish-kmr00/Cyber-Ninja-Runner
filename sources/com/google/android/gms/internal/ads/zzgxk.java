package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgxk {
    private static final zzgxk zzb = new zzgxk(true);
    final zzhah zza = new zzhac();
    private boolean zzc;
    private boolean zzd;

    private zzgxk() {
    }

    static int zza(zzhay zzhayVar, int i, Object obj) {
        int iZzD = zzgxa.zzD(i << 3);
        if (zzhayVar == zzhay.GROUP) {
            zzgzg zzgzgVar = (zzgzg) obj;
            byte[] bArr = zzgyi.zzb;
            if (zzgzgVar instanceof zzgvx) {
                throw null;
            }
            iZzD += iZzD;
        }
        return iZzD + zzb(zzhayVar, obj);
    }

    static int zzb(zzhay zzhayVar, Object obj) {
        int iZzd;
        int iZzD;
        zzhay zzhayVar2 = zzhay.DOUBLE;
        zzhaz zzhazVar = zzhaz.INT;
        switch (zzhayVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                int i = zzgxa.zzf;
                return 8;
            case FLOAT:
                ((Float) obj).floatValue();
                int i2 = zzgxa.zzf;
                return 4;
            case INT64:
                return zzgxa.zzE(((Long) obj).longValue());
            case UINT64:
                return zzgxa.zzE(((Long) obj).longValue());
            case INT32:
                return zzgxa.zzE(((Integer) obj).intValue());
            case FIXED64:
                ((Long) obj).longValue();
                int i3 = zzgxa.zzf;
                return 8;
            case FIXED32:
                ((Integer) obj).intValue();
                int i4 = zzgxa.zzf;
                return 4;
            case BOOL:
                ((Boolean) obj).booleanValue();
                int i5 = zzgxa.zzf;
                return 1;
            case STRING:
                if (!(obj instanceof zzgwn)) {
                    return zzgxa.zzC((String) obj);
                }
                int i6 = zzgxa.zzf;
                iZzd = ((zzgwn) obj).zzd();
                iZzD = zzgxa.zzD(iZzd);
                break;
                break;
            case GROUP:
                int i7 = zzgxa.zzf;
                return ((zzgzg) obj).zzaY();
            case MESSAGE:
                if (!(obj instanceof zzgyq)) {
                    return zzgxa.zzz((zzgzg) obj);
                }
                int i8 = zzgxa.zzf;
                iZzd = ((zzgyq) obj).zza();
                iZzD = zzgxa.zzD(iZzd);
                break;
                break;
            case BYTES:
                if (!(obj instanceof zzgwn)) {
                    int i9 = zzgxa.zzf;
                    iZzd = ((byte[]) obj).length;
                    iZzD = zzgxa.zzD(iZzd);
                } else {
                    int i10 = zzgxa.zzf;
                    iZzd = ((zzgwn) obj).zzd();
                    iZzD = zzgxa.zzD(iZzd);
                }
                break;
            case UINT32:
                return zzgxa.zzD(((Integer) obj).intValue());
            case ENUM:
                return obj instanceof zzgxz ? zzgxa.zzE(((zzgxz) obj).zza()) : zzgxa.zzE(((Integer) obj).intValue());
            case SFIXED32:
                ((Integer) obj).intValue();
                int i11 = zzgxa.zzf;
                return 4;
            case SFIXED64:
                ((Long) obj).longValue();
                int i12 = zzgxa.zzf;
                return 8;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                return zzgxa.zzD((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                return zzgxa.zzE((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iZzD + iZzd;
    }

    public static int zzc(zzgxj zzgxjVar, Object obj) {
        zzhay zzhayVarZzb = zzgxjVar.zzb();
        int iZza = zzgxjVar.zza();
        if (!zzgxjVar.zze()) {
            return zza(zzhayVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzgxjVar.zzd()) {
            int iZza2 = 0;
            while (i < size) {
                iZza2 += zza(zzhayVarZzb, iZza, list.get(i));
                i++;
            }
            return iZza2;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iZzb = 0;
        while (i < size) {
            iZzb += zzb(zzhayVarZzb, list.get(i));
            i++;
        }
        return zzgxa.zzD(iZza << 3) + iZzb + zzgxa.zzD(iZzb);
    }

    public static zzgxk zze() {
        return zzb;
    }

    private static boolean zzj(Map.Entry entry) {
        zzgxj zzgxjVar = (zzgxj) entry.getKey();
        if (zzgxjVar.zzc() != zzhaz.MESSAGE) {
            return true;
        }
        if (!zzgxjVar.zze()) {
            return zzk(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzk(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzk(Object obj) {
        if (obj instanceof zzgzh) {
            return ((zzgzh) obj).zzbw();
        }
        if (obj instanceof zzgyq) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzl(Map.Entry entry) {
        int i;
        int iZzD;
        int iZzD2;
        zzgxj zzgxjVar = (zzgxj) entry.getKey();
        Object value = entry.getValue();
        if (zzgxjVar.zzc() != zzhaz.MESSAGE || zzgxjVar.zze() || zzgxjVar.zzd()) {
            return zzc(zzgxjVar, value);
        }
        if (value instanceof zzgyq) {
            int iZza = ((zzgxj) entry.getKey()).zza();
            int iZzD3 = zzgxa.zzD(8);
            i = iZzD3 + iZzD3;
            iZzD = zzgxa.zzD(16) + zzgxa.zzD(iZza);
            int iZzD4 = zzgxa.zzD(24);
            int iZza2 = ((zzgyq) value).zza();
            iZzD2 = iZzD4 + zzgxa.zzD(iZza2) + iZza2;
        } else {
            int iZza3 = ((zzgxj) entry.getKey()).zza();
            int iZzD5 = zzgxa.zzD(8);
            i = iZzD5 + iZzD5;
            iZzD = zzgxa.zzD(16) + zzgxa.zzD(iZza3);
            iZzD2 = zzgxa.zzD(24) + zzgxa.zzz((zzgzg) value);
        }
        return i + iZzD + iZzD2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void zzm(zzgxj zzgxjVar, Object obj) {
        boolean z;
        zzgxjVar.zzb();
        byte[] bArr = zzgyi.zzb;
        obj.getClass();
        zzhay zzhayVar = zzhay.DOUBLE;
        zzhaz zzhazVar = zzhaz.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgxjVar.zza()), zzgxjVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgxjVar.zza()), zzgxjVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgxjVar.zza()), zzgxjVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgxjVar.zza()), zzgxjVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgxjVar.zza()), zzgxjVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgxjVar.zza()), zzgxjVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzgwn) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgxjVar.zza()), zzgxjVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzgxz)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgxjVar.zza()), zzgxjVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzgzg) || (obj instanceof zzgyq)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgxjVar.zza()), zzgxjVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgxjVar.zza()), zzgxjVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgxk zzgxkVar = new zzgxk();
        zzhah zzhahVar = this.zza;
        int iZzc = zzhahVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzg = zzhahVar.zzg(i);
            zzgxkVar.zzh((zzgxj) ((zzhad) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry : zzhahVar.zzd()) {
            zzgxkVar.zzh((zzgxj) entry.getKey(), entry.getValue());
        }
        zzgxkVar.zzd = this.zzd;
        return zzgxkVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgxk) {
            return this.zza.equals(((zzgxk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzd() {
        zzhah zzhahVar = this.zza;
        int iZzc = zzhahVar.zzc();
        int iZzl = 0;
        for (int i = 0; i < iZzc; i++) {
            iZzl += zzl(zzhahVar.zzg(i));
        }
        Iterator it = zzhahVar.zzd().iterator();
        while (it.hasNext()) {
            iZzl += zzl((Map.Entry) it.next());
        }
        return iZzl;
    }

    public final Iterator zzf() {
        zzhah zzhahVar = this.zza;
        if (zzhahVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.zzd ? new zzgyo(zzhahVar.entrySet().iterator()) : zzhahVar.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        zzhah zzhahVar = this.zza;
        int iZzc = zzhahVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Object value = zzhahVar.zzg(i).getValue();
            if (value instanceof zzgxv) {
                ((zzgxv) value).zzbU();
            }
        }
        Iterator it = zzhahVar.zzd().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzgxv) {
                ((zzgxv) value2).zzbU();
            }
        }
        zzhahVar.zza();
        this.zzc = true;
    }

    public final void zzh(zzgxj zzgxjVar, Object obj) {
        if (!zzgxjVar.zze()) {
            zzm(zzgxjVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzm(zzgxjVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzgyq) {
            this.zzd = true;
        }
        this.zza.put(zzgxjVar, obj);
    }

    public final boolean zzi() {
        zzhah zzhahVar = this.zza;
        int iZzc = zzhahVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            if (!zzj(zzhahVar.zzg(i))) {
                return false;
            }
        }
        Iterator it = zzhahVar.zzd().iterator();
        while (it.hasNext()) {
            if (!zzj((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzgxk(boolean z) {
        zzg();
        zzg();
    }
}
