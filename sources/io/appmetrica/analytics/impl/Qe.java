package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
public final class Qe implements InterfaceC4599yn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11313a;

    public Qe(Se se) {
        boolean z;
        List<Re> list = se.b;
        if ((list instanceof Collection) && list.isEmpty()) {
            z = true;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((Re) it.next()).c == X7.c) {
                    z = false;
                }
            }
            z = true;
        }
        this.f11313a = z;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final List<Re> invoke(List<? extends Re> list, C4118ff c4118ff) {
        Re re = new Re(c4118ff.f11551a, c4118ff.b, c4118ff.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((Re) it.next()).c == c4118ff.e) {
                    if (re.c == X7.c && this.f11313a) {
                        return CollectionsKt.plus((Collection<? extends Re>) list, re);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends Re>) list, re);
    }
}
