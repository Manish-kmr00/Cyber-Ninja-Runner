package com.json;

import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes9.dex */
public class r8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4217a = true;
    private IronSourceError b = null;

    public IronSourceError a() {
        return this.b;
    }

    public void a(IronSourceError ironSourceError) {
        this.f4217a = false;
        this.b = ironSourceError;
    }

    public boolean b() {
        return this.f4217a;
    }

    public void c() {
        this.f4217a = true;
        this.b = null;
    }

    public String toString() {
        return (b() ? new StringBuilder("valid:").append(this.f4217a) : new StringBuilder("valid:").append(this.f4217a).append(", IronSourceError:").append(this.b)).toString();
    }
}
