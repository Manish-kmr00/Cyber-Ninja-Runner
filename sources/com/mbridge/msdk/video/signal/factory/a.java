package com.mbridge.msdk.video.signal.factory;

import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.video.signal.impl.e;
import com.mbridge.msdk.video.signal.impl.h;
import com.mbridge.msdk.video.signal.j;

/* JADX INFO: compiled from: DefaultJSFactory.java */
/* JADX INFO: loaded from: classes13.dex */
public class a implements IJSFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.mbridge.msdk.video.signal.b f5945a;
    protected d b;
    protected j c;
    protected g d;
    protected f e;
    protected i f;
    protected c g;

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.b getActivityProxy() {
        if (this.f5945a == null) {
            this.f5945a = new com.mbridge.msdk.video.signal.impl.b();
        }
        return this.f5945a;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        if (this.f == null) {
            this.f = new com.mbridge.msdk.video.signal.impl.g();
        }
        return this.f;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public c getJSBTModule() {
        if (this.g == null) {
            this.g = new com.mbridge.msdk.video.signal.impl.c();
        }
        return this.g;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public d getJSCommon() {
        if (this.b == null) {
            this.b = new com.mbridge.msdk.video.signal.impl.d();
        }
        return this.b;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public f getJSContainerModule() {
        if (this.e == null) {
            this.e = new e();
        }
        return this.e;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        if (this.d == null) {
            this.d = new com.mbridge.msdk.video.signal.impl.f();
        }
        return this.d;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public j getJSVideoModule() {
        if (this.c == null) {
            this.c = new h();
        }
        return this.c;
    }
}
