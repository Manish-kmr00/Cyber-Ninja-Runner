package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes11.dex */
public final class k<L extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<L> f6198a;
    public com.moloco.sdk.internal.ortb.model.q b;
    public j c;
    public Job d;
    public String e;
    public String f;
    public boolean g;

    public k() {
        this(null, null, null, null, null, null, false, 127, null);
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<L> wVar) {
        this.f6198a = wVar;
    }

    public final j b() {
        return this.c;
    }

    public final String c() {
        return this.f;
    }

    public final String d() {
        return this.e;
    }

    public final com.moloco.sdk.internal.ortb.model.q e() {
        return this.b;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<L> f() {
        return this.f6198a;
    }

    public final boolean g() {
        return this.g;
    }

    public k(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<L> wVar, com.moloco.sdk.internal.ortb.model.q qVar, j jVar, Job job, String str, String str2, boolean z) {
        this.f6198a = wVar;
        this.b = qVar;
        this.c = jVar;
        this.d = job;
        this.e = str;
        this.f = str2;
        this.g = z;
    }

    public final void a(com.moloco.sdk.internal.ortb.model.q qVar) {
        this.b = qVar;
    }

    public final void b(String str) {
        this.e = str;
    }

    public final void a(j jVar) {
        this.c = jVar;
    }

    public final Job a() {
        return this.d;
    }

    public final void a(Job job) {
        this.d = job;
    }

    public final void a(String str) {
        this.f = str;
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public /* synthetic */ k(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w wVar, com.moloco.sdk.internal.ortb.model.q qVar, j jVar, Job job, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : wVar, (i & 2) != 0 ? null : qVar, (i & 4) != 0 ? null : jVar, (i & 8) != 0 ? null : job, (i & 16) != 0 ? null : str, (i & 32) == 0 ? str2 : null, (i & 64) != 0 ? false : z);
    }
}
