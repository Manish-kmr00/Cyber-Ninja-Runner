package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class eh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ig<?>> f8797a;
    private c71 b;

    /* JADX WARN: Multi-variable type inference failed */
    public eh(List<? extends ig<?>> assets) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        this.f8797a = assets;
    }

    public final HashMap a() {
        jg<?> jgVarA;
        dx0.a aVarF;
        String strA;
        HashMap map = new HashMap();
        Iterator<ig<?>> it = this.f8797a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ig<?> next = it.next();
            String strB = next.b();
            c71 c71Var = this.b;
            if (c71Var != null && (jgVarA = c71Var.a(next)) != null && jgVarA.b()) {
                HashMap map2 = new HashMap();
                dh2 dh2VarC = jgVarA.c();
                if (dh2VarC != null) {
                    map2.put("width", Integer.valueOf(dh2VarC.b()));
                    map2.put("height", Integer.valueOf(dh2VarC.a()));
                }
                vu0 vu0Var = jgVarA instanceof vu0 ? (vu0) jgVarA : null;
                if (vu0Var != null && (aVarF = vu0Var.f()) != null && (strA = aVarF.a()) != null) {
                    map2.put("value_type", strA);
                }
                map.put(strB, map2);
            }
        }
        c71 c71Var2 = this.b;
        View viewE = c71Var2 != null ? c71Var2.e() : null;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        if (viewE != null) {
            mapCreateMapBuilder.put("width", Integer.valueOf(viewE.getWidth()));
            mapCreateMapBuilder.put("height", Integer.valueOf(viewE.getHeight()));
        }
        Map mapBuild = MapsKt.build(mapCreateMapBuilder);
        if (!mapBuild.isEmpty()) {
            map.put("superview", mapBuild);
        }
        return map;
    }

    public final void a(c71 c71Var) {
        this.b = c71Var;
    }
}
