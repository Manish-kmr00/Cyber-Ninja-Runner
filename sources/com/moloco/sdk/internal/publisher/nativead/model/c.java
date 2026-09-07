package com.moloco.sdk.internal.publisher.nativead.model;

import android.net.Uri;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.internal.publisher.nativead.model.b.a f6241a;
    public final int b;
    public final boolean c;

    public static final class a extends c {
        public static final int e = 0;
        public final String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.moloco.sdk.internal.publisher.nativead.model.b.a.C0548a originAsset) {
            super(originAsset, null);
            Intrinsics.checkNotNullParameter(originAsset, "originAsset");
            this.d = originAsset.e();
        }

        public final String d() {
            return this.d;
        }
    }

    public static final class b extends c {
        public static final int e = 8;
        public final Uri d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.internal.publisher.nativead.model.b.a.C0549b originAsset, Uri precachedAssetUri) {
            super(originAsset, null);
            Intrinsics.checkNotNullParameter(originAsset, "originAsset");
            Intrinsics.checkNotNullParameter(precachedAssetUri, "precachedAssetUri");
            this.d = precachedAssetUri;
        }

        public final Uri d() {
            return this.d;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.model.c$c, reason: collision with other inner class name */
    public static final class C0551c extends c {
        public static final int e = 0;
        public final String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0551c(com.moloco.sdk.internal.publisher.nativead.model.b.a.c originAsset) {
            super(originAsset, null);
            Intrinsics.checkNotNullParameter(originAsset, "originAsset");
            this.d = originAsset.d();
        }

        public final String d() {
            return this.d;
        }
    }

    public static final class d extends c {
        public static final int e = 8;
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.moloco.sdk.internal.publisher.nativead.model.b.a.d originAsset, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a vastAd) {
            super(originAsset, null);
            Intrinsics.checkNotNullParameter(originAsset, "originAsset");
            Intrinsics.checkNotNullParameter(vastAd, "vastAd");
            this.d = vastAd;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a d() {
            return this.d;
        }
    }

    public /* synthetic */ c(com.moloco.sdk.internal.publisher.nativead.model.b.a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    public final int a() {
        return this.b;
    }

    public final com.moloco.sdk.internal.publisher.nativead.model.b.a b() {
        return this.f6241a;
    }

    public final boolean c() {
        return this.c;
    }

    public c(com.moloco.sdk.internal.publisher.nativead.model.b.a aVar) {
        this.f6241a = aVar;
        this.b = aVar.a();
        this.c = aVar.b();
    }
}
