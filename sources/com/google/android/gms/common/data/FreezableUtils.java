package com.google.android.gms.common.data;

import com.fyber.inneractive.sdk.flow.vast.i;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        i iVar = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            iVar.add(arrayList.get(i).freeze());
        }
        return iVar;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        i iVar = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            iVar.add(it.next().freeze());
        }
        return iVar;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        i iVar = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            iVar.add(e.freeze());
        }
        return iVar;
    }
}
