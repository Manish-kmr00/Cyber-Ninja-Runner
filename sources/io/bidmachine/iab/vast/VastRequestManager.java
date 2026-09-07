package io.bidmachine.iab.vast;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes11.dex */
public class VastRequestManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f12270a = new WeakHashMap();

    static synchronized void a(VastRequest vastRequest) {
        if (vastRequest == null) {
            return;
        }
        f12270a.remove(vastRequest);
    }

    public static synchronized VastRequest get(String vastRequestId) {
        if (TextUtils.isEmpty(vastRequestId)) {
            return null;
        }
        Iterator it = f12270a.entrySet().iterator();
        while (it.hasNext()) {
            VastRequest vastRequest = (VastRequest) ((Map.Entry) it.next()).getKey();
            if (vastRequest.getId().equals(vastRequestId)) {
                return vastRequest;
            }
        }
        return null;
    }

    public static synchronized void store(VastRequest vastRequest) {
        if (vastRequest == null) {
            return;
        }
        f12270a.put(vastRequest, Boolean.TRUE);
    }
}
