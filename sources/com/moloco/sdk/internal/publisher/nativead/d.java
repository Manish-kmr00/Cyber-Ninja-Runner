package com.moloco.sdk.internal.publisher.nativead;

import com.moloco.sdk.internal.h;
import com.moloco.sdk.internal.ortb.model.q;
import com.moloco.sdk.internal.publisher.a0;
import com.moloco.sdk.internal.publisher.j;
import com.moloco.sdk.internal.publisher.y;
import com.moloco.sdk.internal.services.f;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m;
import com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6230a;
    public final com.moloco.sdk.internal.ortb.model.c b;
    public final com.moloco.sdk.internal.publisher.nativead.model.b c;
    public final f d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a e;
    public final AdFormatType f;
    public final i g;
    public final m h;
    public final y i;
    public final a j;

    public static final class b extends Lambda implements Function0<q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.c f6234a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.internal.ortb.model.c cVar) {
            super(0);
            this.f6234a = cVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final q invoke() {
            return this.f6234a.e().g();
        }
    }

    public static final class c extends Lambda implements Function0<j> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final j invoke() {
            String strC = d.this.b.c();
            if (strC != null) {
                return new j(strC, Float.valueOf(d.this.b.g()));
            }
            return null;
        }
    }

    public d(String adUnitId, com.moloco.sdk.internal.ortb.model.c bid, com.moloco.sdk.internal.publisher.nativead.model.b ortbResponse, f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, AdFormatType adFormatType, i persistentHttpRequest, m externalLinkHandler) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(ortbResponse, "ortbResponse");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        this.f6230a = adUnitId;
        this.b = bid;
        this.c = ortbResponse;
        this.d = appLifecycleTrackerService;
        this.e = customUserEventBuilderService;
        this.f = adFormatType;
        this.g = persistentHttpRequest;
        this.h = externalLinkHandler;
        this.i = a();
        this.j = b();
    }

    public final a b() {
        com.moloco.sdk.internal.publisher.nativead.model.b bVar = this.c;
        return new a(bVar.c(), bVar.b(), this.g);
    }

    public final void c() {
        com.moloco.sdk.internal.publisher.nativead.model.b.c cVarD = this.c.d();
        if (cVarD != null) {
            this.j.a(cVarD.a());
            this.h.a(cVarD.c());
        }
        this.i.onAdClicked(MolocoAdKt.createAdInfo$default(this.f6230a, null, 2, null));
    }

    public final void d() {
        this.j.a();
        this.i.onAdShowSuccess(MolocoAdKt.createAdInfo$default(this.f6230a, null, 2, null));
    }

    public final y a() {
        return a0.a(null, this.d, this.e, new b(this.b), new c(), (96 & 32) != 0 ? com.moloco.sdk.internal.y.a() : null, (96 & 64) != 0 ? h.a() : null, this.f);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f6231a;
        public List<com.moloco.sdk.internal.publisher.nativead.model.b.C0550b> b;
        public final i c;
        public final Set<String> d;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.d$a$a, reason: collision with other inner class name */
        public static final class C0547a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0547a f6232a = new C0547a();
            public static final int b = 1;
            public static final int c = 0;
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f6233a = new b();
            public static final int b = 1;
            public static final int c = 0;
        }

        public a(List<String> list, List<com.moloco.sdk.internal.publisher.nativead.model.b.C0550b> list2, i persistentHttpRequest) {
            Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
            this.f6231a = list;
            this.b = list2;
            this.c = persistentHttpRequest;
            this.d = new LinkedHashSet();
        }

        public final void a() {
            List<String> list = this.f6231a;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    this.c.a((String) it.next());
                }
            }
            this.f6231a = null;
            List<com.moloco.sdk.internal.publisher.nativead.model.b.C0550b> list2 = this.b;
            if (list2 != null) {
                for (com.moloco.sdk.internal.publisher.nativead.model.b.C0550b c0550b : list2) {
                    if (c0550b.c() != null && c0550b.a() == 1 && c0550b.b() == 1) {
                        this.c.a(c0550b.c());
                    }
                }
            }
            this.b = null;
        }

        public final void a(List<String> urls) {
            Intrinsics.checkNotNullParameter(urls, "urls");
            for (String str : urls) {
                if (!this.d.contains(str)) {
                    this.c.a(str);
                    this.d.add(str);
                }
            }
        }
    }
}
