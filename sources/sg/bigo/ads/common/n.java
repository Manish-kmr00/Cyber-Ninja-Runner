package sg.bigo.ads.common;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static int a(Parcel parcel, int i) {
        return parcel.dataAvail() > 0 ? parcel.readInt() : i;
    }

    public static long a(Parcel parcel, long j) {
        return parcel.dataAvail() > 0 ? parcel.readLong() : j;
    }

    public static String a(Parcel parcel, String str) {
        return parcel.dataAvail() > 0 ? parcel.readString() : str;
    }

    public static <T extends f> List<T> a(Parcel parcel, f.a<T> aVar) {
        ArrayList arrayList = new ArrayList();
        if (parcel.dataAvail() <= 0) {
            return arrayList;
        }
        for (int i = parcel.readInt(); i > 0; i--) {
            f fVarB = b(parcel, aVar);
            if (fVarB != null) {
                arrayList.add(fVarB);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.Map<java.lang.String, T extends sg.bigo.ads.common.f>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Map<java.lang.String, T extends sg.bigo.ads.common.f>] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.HashMap, java.util.Map] */
    public static <T extends f> Map<String, T> a(Parcel parcel, f.a<T> aVar, Map<String, T> map) {
        String string;
        if (parcel.dataAvail() > 0) {
            map = new HashMap();
            if (parcel.dataAvail() > 0) {
                for (int i = parcel.readInt(); i > 0; i--) {
                    f fVarA = aVar != null ? aVar.a() : null;
                    if (b(parcel, fVarA) && (string = parcel.readString()) != null && fVarA != null) {
                        map.put(string, fVarA);
                    }
                }
            }
        }
        return (Map<String, T>) map;
    }

    public static <K extends f, V extends f> Map<K, V> a(Parcel parcel, f.a<K> aVar, f.a<V> aVar2) {
        HashMap map = new HashMap();
        if (parcel.dataAvail() <= 0) {
            return map;
        }
        for (int i = parcel.readInt(); i > 0; i--) {
            f fVarB = b(parcel, aVar);
            f fVarB2 = b(parcel, aVar2);
            if (fVarB != null && fVarB2 != null) {
                map.put(fVarB, fVarB2);
            }
        }
        return map;
    }

    public static <T extends f> void a(Parcel parcel, Collection<T> collection) {
        int size = collection == null ? 0 : collection.size();
        parcel.writeInt(size);
        if (size == 0) {
            return;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            a(parcel, it.next());
        }
    }

    public static <K extends f, V extends f> void a(Parcel parcel, Map<K, V> map) {
        int size = map == null ? 0 : map.size();
        parcel.writeInt(size);
        if (size == 0) {
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            a(parcel, key);
            a(parcel, value);
        }
    }

    public static <T extends f> void a(Parcel parcel, T t) {
        if (t == null) {
            parcel.writeInt(0);
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        t.a(parcelObtain);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcel.writeInt(bArrMarshall.length);
        parcel.writeByteArray(bArrMarshall);
    }

    public static void a(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static <K extends f, V extends f> Map<K, List<V>> b(Parcel parcel, f.a<K> aVar, f.a<V> aVar2) {
        HashMap map = new HashMap();
        if (parcel.dataAvail() <= 0) {
            return map;
        }
        for (int i = parcel.readInt(); i > 0; i--) {
            f fVarB = b(parcel, aVar);
            List listA = a(parcel, aVar2);
            if (fVarB != null && !sg.bigo.ads.common.utils.k.a((Collection) listA)) {
                map.put(fVarB, listA);
            }
        }
        return map;
    }

    public static <T extends f> T b(Parcel parcel, f.a<T> aVar) {
        T t = null;
        if (parcel.dataAvail() <= 0) {
            return null;
        }
        int i = parcel.readInt();
        if (i != 0 && i <= parcel.dataAvail()) {
            byte[] bArr = new byte[i];
            parcel.readByteArray(bArr);
            if (aVar != null) {
                t = (T) aVar.a();
            }
            if (t != null) {
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.unmarshall(bArr, 0, i);
                parcelObtain.setDataPosition(0);
                t.b(parcelObtain);
            }
        }
        return t;
    }

    public static <K extends f, V extends f> void b(Parcel parcel, Map<K, List<V>> map) {
        int size = map == null ? 0 : map.size();
        parcel.writeInt(size);
        if (size == 0) {
            return;
        }
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            a(parcel, entry.getKey());
            a(parcel, entry.getValue());
        }
    }

    public static <T extends f> boolean b(Parcel parcel, T t) {
        int i;
        if (parcel.dataAvail() <= 0 || (i = parcel.readInt()) == 0 || i > parcel.dataAvail()) {
            return false;
        }
        byte[] bArr = new byte[i];
        parcel.readByteArray(bArr);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, i);
        parcelObtain.setDataPosition(0);
        if (t == null) {
            return true;
        }
        t.b(parcelObtain);
        return true;
    }

    public static boolean b(Parcel parcel, boolean z) {
        if (parcel.dataAvail() > 0) {
            return parcel.readInt() != 0;
        }
        return z;
    }
}
