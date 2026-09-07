package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdShowListener;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes11.dex */
public final class t<T extends AdShowListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> f6272a;
    public com.moloco.sdk.internal.ortb.model.q b;
    public j c;
    public Job d;
    public y e;

    public t() {
        this(null, null, null, null, null, 31, null);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> a() {
        return this.f6272a;
    }

    public final Job b() {
        return this.d;
    }

    public final j c() {
        return this.c;
    }

    public final y d() {
        return this.e;
    }

    public final com.moloco.sdk.internal.ortb.model.q e() {
        return this.b;
    }

    public t(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> kVar, com.moloco.sdk.internal.ortb.model.q qVar, j jVar, Job job, y yVar) {
        this.f6272a = kVar;
        this.b = qVar;
        this.c = jVar;
        this.d = job;
        this.e = yVar;
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> kVar) {
        this.f6272a = kVar;
    }

    public final void a(com.moloco.sdk.internal.ortb.model.q qVar) {
        this.b = qVar;
    }

    public final void a(j jVar) {
        this.c = jVar;
    }

    public final void a(Job job) {
        this.d = job;
    }

    public final void a(y yVar) {
        this.e = yVar;
    }

    public /* synthetic */ t(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k kVar, com.moloco.sdk.internal.ortb.model.q qVar, j jVar, Job job, y yVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kVar, (i & 2) != 0 ? null : qVar, (i & 4) != 0 ? null : jVar, (i & 8) != 0 ? null : job, (i & 16) != 0 ? null : yVar);
    }
}
