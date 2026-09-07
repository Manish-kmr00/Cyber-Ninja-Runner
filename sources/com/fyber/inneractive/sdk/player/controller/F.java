package com.fyber.inneractive.sdk.player.controller;

import android.view.View;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.util.h0;

/* JADX INFO: loaded from: classes13.dex */
public interface F {
    com.fyber.inneractive.sdk.util.D a(h0 h0Var, EnumC3243g enumC3243g);

    com.fyber.inneractive.sdk.util.D a(String str, h0 h0Var, boolean z);

    void a(View view);

    void a(View view, String str);

    void a(String str, String str2);

    void a(boolean z);

    void a(boolean z, Orientation orientation);

    void c();

    void e();

    void f();

    void h();

    void i();

    void j();

    com.fyber.inneractive.sdk.ignite.m o();

    void onCompleted();

    void onPlayerError();

    void onProgress(int i, int i2);
}
