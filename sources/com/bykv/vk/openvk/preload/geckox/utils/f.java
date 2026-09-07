package com.bykv.vk.openvk.preload.geckox.utils;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PiecemealSerialExecutor.java */
/* JADX INFO: loaded from: classes9.dex */
public class f implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f957a;

    public static f a() {
        if (f957a == null) {
            synchronized (f.class) {
                if (f957a == null) {
                    f957a = new f();
                }
            }
        }
        return f957a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        com.bykv.vk.openvk.preload.geckox.b.p().execute(runnable);
    }
}
