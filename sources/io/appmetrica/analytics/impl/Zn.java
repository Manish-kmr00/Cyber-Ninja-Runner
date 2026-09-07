package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class Zn extends SimpleThreadSafeToggle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap f11453a;

    public Zn() {
        super(false, "[WakelocksToggle]");
        this.f11453a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f11453a.put(obj, null);
        if (this.f11453a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f11453a.remove(obj);
        if (this.f11453a.isEmpty()) {
            updateState(false);
        }
    }
}
