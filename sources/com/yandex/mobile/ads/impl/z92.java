package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class z92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p2 f10802a;
    private final Map<String, String> b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p2 f10803a;
        private Map<String, String> b;

        public a(p2 adBreak) {
            Intrinsics.checkNotNullParameter(adBreak, "adBreak");
            this.f10803a = adBreak;
            ud2.a(adBreak);
        }

        public final a c() {
            this.b = null;
            return this;
        }

        public final p2 a() {
            return this.f10803a;
        }

        public final Map<String, String> b() {
            return this.b;
        }
    }

    private z92(a aVar) {
        this.f10802a = aVar.a();
        this.b = aVar.b();
    }

    public final p2 a() {
        return this.f10802a;
    }

    public final Map<String, String> b() {
        return this.b;
    }

    public /* synthetic */ z92(a aVar, int i) {
        this(aVar);
    }
}
