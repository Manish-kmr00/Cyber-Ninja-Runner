package com.bytedance.sdk.component.Bzk;

import com.bytedance.sdk.component.utils.WV;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class Og {
    public static boolean pA(List<String> list, String str) {
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                try {
                    if (Pattern.matches(it.next(), str)) {
                        return true;
                    }
                } catch (Throwable th) {
                    WV.Og(th.toString());
                }
            }
        }
        return false;
    }
}
