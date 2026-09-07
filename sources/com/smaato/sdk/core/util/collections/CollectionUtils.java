package com.smaato.sdk.core.util.collections;

import java.util.Collection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes13.dex */
public final class CollectionUtils {
    public static boolean equalsByElements(Collection<?> collection, Collection<?> collection2) {
        if (collection.size() != collection2.size()) {
            return false;
        }
        HashMap map = new HashMap();
        for (Object obj : collection) {
            Integer num = (Integer) map.get(obj);
            if (num == null) {
                num = 0;
            }
            map.put(obj, Integer.valueOf(num.intValue() + 1));
        }
        for (Object obj2 : collection2) {
            Integer num2 = (Integer) map.get(obj2);
            if (num2 == null) {
                return false;
            }
            int iIntValue = num2.intValue();
            if (iIntValue - 1 == 0) {
                map.remove(obj2);
            } else {
                map.put(obj2, Integer.valueOf(iIntValue - 2));
            }
        }
        return map.isEmpty();
    }
}
