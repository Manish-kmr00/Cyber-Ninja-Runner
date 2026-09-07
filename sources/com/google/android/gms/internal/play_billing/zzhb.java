package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes13.dex */
final class zzhb {
    private static final zzhb zzb = new zzhb(true);
    final zzjf zza = new zzja();
    private boolean zzc;
    private boolean zzd;

    private zzhb() {
    }

    static int zza(zzju zzjuVar, int i, Object obj) {
        zzgr.zzz(i << 3);
        if (zzju.GROUP == null) {
            zzim zzimVar = (zzim) obj;
            byte[] bArr = zzhp.zzb;
            if (zzimVar instanceof zzfw) {
                throw null;
            }
        }
        zzjv zzjvVar = zzjv.INT;
        throw null;
    }

    public static int zzb(zzha zzhaVar, Object obj) {
        zzju zzjuVarZzb = zzhaVar.zzb();
        int iZza = zzhaVar.zza();
        if (!zzhaVar.zze()) {
            return zza(zzjuVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        if (!zzhaVar.zzd()) {
            int iZza2 = 0;
            for (int i = 0; i < size; i++) {
                iZza2 += zza(zzjuVarZzb, iZza, list.get(i));
            }
            return iZza2;
        }
        if (list.isEmpty()) {
            return 0;
        }
        if (size <= 0) {
            return zzgr.zzz(iZza << 3) + zzgr.zzz(0);
        }
        list.get(0);
        zzju zzjuVar = zzju.DOUBLE;
        zzjv zzjvVar = zzjv.INT;
        throw null;
    }

    public static zzhb zzd() {
        return zzb;
    }

    private static boolean zzi(Map.Entry entry) {
        zzha zzhaVar = (zzha) entry.getKey();
        if (zzhaVar.zzc() != zzjv.MESSAGE) {
            return true;
        }
        if (!zzhaVar.zze()) {
            return zzj(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzj(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzj(Object obj) {
        if (obj instanceof zzin) {
            return ((zzin) obj).zzl();
        }
        if (obj instanceof zzhw) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzk(Map.Entry entry) {
        int i;
        int iZzz;
        int iZzz2;
        int iZzk;
        int iZzz3;
        zzha zzhaVar = (zzha) entry.getKey();
        Object value = entry.getValue();
        if (zzhaVar.zzc() != zzjv.MESSAGE || zzhaVar.zze() || zzhaVar.zzd()) {
            return zzb(zzhaVar, value);
        }
        if (value instanceof zzhw) {
            int iZza = ((zzha) entry.getKey()).zza();
            int iZzz4 = zzgr.zzz(8);
            i = iZzz4 + iZzz4;
            iZzz = zzgr.zzz(16) + zzgr.zzz(iZza);
            iZzz2 = zzgr.zzz(24);
            iZzk = ((zzhw) value).zza();
            iZzz3 = zzgr.zzz(iZzk);
        } else {
            int iZza2 = ((zzha) entry.getKey()).zza();
            int iZzz5 = zzgr.zzz(8);
            i = iZzz5 + iZzz5;
            iZzz = zzgr.zzz(16) + zzgr.zzz(iZza2);
            iZzz2 = zzgr.zzz(24);
            iZzk = ((zzim) value).zzk();
            iZzz3 = zzgr.zzz(iZzk);
        }
        return i + iZzz + iZzz2 + iZzz3 + iZzk;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void zzl(zzha zzhaVar, Object obj) {
        boolean z;
        zzhaVar.zzb();
        byte[] bArr = zzhp.zzb;
        obj.getClass();
        zzju zzjuVar = zzju.DOUBLE;
        zzjv zzjvVar = zzjv.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhaVar.zza()), zzhaVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhaVar.zza()), zzhaVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhaVar.zza()), zzhaVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhaVar.zza()), zzhaVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhaVar.zza()), zzhaVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhaVar.zza()), zzhaVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzgk) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhaVar.zza()), zzhaVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzkn)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhaVar.zza()), zzhaVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzim) || (obj instanceof zzhw)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhaVar.zza()), zzhaVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhaVar.zza()), zzhaVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzhb zzhbVar = new zzhb();
        int iZzc = this.zza.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            zzhbVar.zzg((zzha) ((zzjb) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzd()) {
            zzhbVar.zzg((zzha) entry.getKey(), entry.getValue());
        }
        zzhbVar.zzd = this.zzd;
        return zzhbVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhb) {
            return this.zza.equals(((zzhb) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzc() {
        int iZzc = this.zza.zzc();
        int iZzk = 0;
        for (int i = 0; i < iZzc; i++) {
            iZzk += zzk(this.zza.zzg(i));
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            iZzk += zzk((Map.Entry) it.next());
        }
        return iZzk;
    }

    public final Iterator zze() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.zzd ? new zzhu(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzf() {
        if (this.zzc) {
            return;
        }
        int iZzc = this.zza.zzc();
        for (int i = 0; i < iZzc; i++) {
            Object value = this.zza.zzg(i).getValue();
            if (value instanceof zzhk) {
                ((zzhk) value).zzv();
            }
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzhk) {
                ((zzhk) value2).zzv();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzg(zzha zzhaVar, Object obj) {
        if (!zzhaVar.zze()) {
            zzl(zzhaVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzl(zzhaVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzhw) {
            this.zzd = true;
        }
        this.zza.put(zzhaVar, obj);
    }

    public final boolean zzh() {
        int iZzc = this.zza.zzc();
        for (int i = 0; i < iZzc; i++) {
            if (!zzi(this.zza.zzg(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            if (!zzi((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzhb(boolean z) {
        zzf();
        zzf();
    }
}
