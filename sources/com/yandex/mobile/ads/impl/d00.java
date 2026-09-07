package com.yandex.mobile.ads.impl;

import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes12.dex */
public final class d00 implements rw0.a {

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HashMap f8653a = new HashMap();
        private final HashMap b;
        private qv.a c;

        public a(uz uzVar) {
            new HashSet();
            this.b = new HashMap();
        }

        public final void a(lz.a aVar) {
            if (aVar != this.c) {
                this.c = aVar;
                this.f8653a.clear();
                this.b.clear();
            }
        }
    }

    public d00(lz.a aVar, uz uzVar) {
        new a(uzVar).a(aVar);
    }
}
