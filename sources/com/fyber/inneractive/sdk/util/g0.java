package com.fyber.inneractive.sdk.util;

import android.net.Uri;
import com.json.b9;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g0 {
    public static String a(String str, HashMap map) {
        StringBuilder sb = new StringBuilder(str);
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            sb.append(z ? "?" : b9.i.c);
            sb.append((String) entry.getKey());
            sb.append("=");
            sb.append(Uri.encode((String) entry.getValue()));
            z = false;
        }
        return sb.toString();
    }
}
