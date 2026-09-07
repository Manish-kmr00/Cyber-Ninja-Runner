package com.smaato.sdk.core.init;

import com.smaato.sdk.core.framework.BaseModuleInterface;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class BaseModuleValidationUtils {
    public static <T extends BaseModuleInterface> List<T> getValidModuleInterfaces(String str, Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (t.version().equals(str)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}
