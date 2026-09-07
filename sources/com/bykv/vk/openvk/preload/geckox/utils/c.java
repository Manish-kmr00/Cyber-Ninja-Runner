package com.bykv.vk.openvk.preload.geckox.utils;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: IOSerialExecutor.java */
/* JADX INFO: loaded from: classes9.dex */
public class c implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f955a;

    public static c a() {
        if (f955a == null) {
            synchronized (c.class) {
                if (f955a == null) {
                    f955a = new c();
                }
            }
        }
        return f955a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        com.bykv.vk.openvk.preload.geckox.b.p().execute(runnable);
    }
}
