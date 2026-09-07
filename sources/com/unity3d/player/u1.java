package com.unity3d.player;

import android.content.Context;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes4.dex */
final class u1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayerForActivityOrService f8308a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ boolean d;
    final /* synthetic */ boolean e;
    final /* synthetic */ boolean f;
    final /* synthetic */ boolean g;
    final /* synthetic */ String h;
    final /* synthetic */ int i;
    final /* synthetic */ boolean j;
    final /* synthetic */ boolean k;
    final /* synthetic */ Semaphore l;
    final /* synthetic */ UnityPlayerForActivityOrService m;

    u1(UnityPlayerForActivityOrService unityPlayerForActivityOrService, UnityPlayerForActivityOrService unityPlayerForActivityOrService2, String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6, Semaphore semaphore) {
        this.m = unityPlayerForActivityOrService;
        this.f8308a = unityPlayerForActivityOrService2;
        this.b = str;
        this.c = i;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = z4;
        this.h = str2;
        this.i = i2;
        this.j = z5;
        this.k = z6;
        this.l = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                UnityPlayerForActivityOrService unityPlayerForActivityOrService = this.m;
                if (unityPlayerForActivityOrService.mSoftInput != null) {
                    unityPlayerForActivityOrService.dismissSoftInput();
                }
                UnityPlayerForActivityOrService unityPlayerForActivityOrService2 = this.m;
                int iA = SoftInputProvider.a();
                Context context = this.m.mContext;
                UnityPlayerForActivityOrService unityPlayerForActivityOrService3 = this.f8308a;
                unityPlayerForActivityOrService2.mSoftInput = com.unity3d.player.a.a.a(iA) != 2 ? new C3794e0(context, unityPlayerForActivityOrService3) : new Z(context, unityPlayerForActivityOrService3);
                this.m.mSoftInput.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
                U u = this.m.mSoftInput;
                u.f = new t1(this);
                u.d();
                this.m.nativeReportKeyboardConfigChanged();
            } catch (Exception e) {
                B.Log(6, "Exception when opening Softinput " + e);
            }
        } finally {
            this.l.release();
        }
    }
}
