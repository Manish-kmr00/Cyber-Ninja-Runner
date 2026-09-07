package com.json;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class wa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, va> f4557a = new LinkedHashMap();
    private final Map<String, va> b = new LinkedHashMap();
    private final Map<String, va> c = new LinkedHashMap();

    private void a(eh.e eVar, String str, va vaVar) {
        Map<String, va> mapB;
        if (TextUtils.isEmpty(str) || vaVar == null || (mapB = b(eVar)) == null) {
            return;
        }
        mapB.put(str, vaVar);
    }

    private Map<String, va> b(eh.e eVar) {
        if (eVar.name().equalsIgnoreCase(eh.e.RewardedVideo.name())) {
            return this.f4557a;
        }
        if (eVar.name().equalsIgnoreCase(eh.e.Interstitial.name())) {
            return this.b;
        }
        if (eVar.name().equalsIgnoreCase(eh.e.Banner.name())) {
            return this.c;
        }
        return null;
    }

    public va a(eh.e eVar, rj rjVar) {
        va vaVar = new va(rjVar);
        a(eVar, rjVar.e(), vaVar);
        return vaVar;
    }

    public va a(eh.e eVar, String str) {
        Map<String, va> mapB;
        if (TextUtils.isEmpty(str) || (mapB = b(eVar)) == null) {
            return null;
        }
        return mapB.get(str);
    }

    public va a(eh.e eVar, String str, Map<String, String> map, io ioVar) {
        va vaVar = new va(str, str, map, ioVar);
        a(eVar, str, vaVar);
        return vaVar;
    }

    public Collection<va> a(eh.e eVar) {
        Map<String, va> mapB = b(eVar);
        return mapB != null ? mapB.values() : new ArrayList();
    }

    public void b(eh.e eVar, String str) {
        Map<String, va> mapB;
        va vaVarRemove;
        if (TextUtils.isEmpty(str) || (mapB = b(eVar)) == null || (vaVarRemove = mapB.remove(str)) == null) {
            return;
        }
        vaVarRemove.a();
    }
}
