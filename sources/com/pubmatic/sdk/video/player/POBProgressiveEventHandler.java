package com.pubmatic.sdk.video.player;

import com.pubmatic.sdk.video.vastmodels.POBVastCreative;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes8.dex */
public class POBProgressiveEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SortedMap f7823a = new TreeMap();
    private POBProgressiveEventListener b;

    public POBProgressiveEventHandler(POBProgressiveEventListener pOBProgressiveEventListener) {
        this.b = pOBProgressiveEventListener;
    }

    public void addProgressUrls(Integer num, POBVastCreative.POBEventTypes pOBEventTypes, List<String> list) {
        Map map = (Map) this.f7823a.get(num);
        if (map == null) {
            HashMap map2 = new HashMap();
            map2.put(pOBEventTypes, list);
            this.f7823a.put(num, map2);
        } else {
            List list2 = (List) map.get(pOBEventTypes);
            if (list2 == null) {
                map.put(pOBEventTypes, list);
            } else {
                list2.addAll(list);
            }
        }
    }

    public void onProgress(int i) {
        Map<POBVastCreative.POBEventTypes, List<String>> map;
        if (this.f7823a.isEmpty()) {
            return;
        }
        Integer num = (Integer) this.f7823a.firstKey();
        if (i < num.intValue() || (map = (Map) this.f7823a.get(num)) == null) {
            return;
        }
        this.b.onProgressReached(map);
        this.f7823a.remove(num);
    }
}
