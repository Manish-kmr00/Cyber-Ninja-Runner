package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleServiceEventHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.hd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4166hd extends Gg {
    public final ArrayList b;

    public C4166hd(C4282m5 c4282m5) {
        super(c4282m5);
        String strB = c4282m5.b().b();
        strB = strB == null ? "empty" : strB;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String.format("[ModulesEventHandler-%s]", Arrays.copyOf(new Object[]{strB}, 1));
        LinkedHashMap linkedHashMapA = C4486ua.j().n().a(strB);
        ArrayList arrayList = new ArrayList(linkedHashMapA.size());
        for (Map.Entry entry : linkedHashMapA.entrySet()) {
            arrayList.add(TuplesKt.to(entry.getValue(), new Yc(c4282m5, (String) entry.getKey())));
        }
        this.b = arrayList;
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        ArrayList<Pair> arrayList = this.b;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            for (Pair pair : arrayList) {
                ModuleServiceEventHandler moduleServiceEventHandler = (ModuleServiceEventHandler) pair.component1();
                Yc yc = (Yc) pair.component2();
                if (moduleServiceEventHandler.handle(new C4016bd(yc.b, yc.f11434a, new C3991ad(yc.c, c3984a6)), c3984a6)) {
                    return true;
                }
            }
        }
        return false;
    }
}
