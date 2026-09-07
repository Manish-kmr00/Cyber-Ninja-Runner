package com.ogury.ad.internal;

import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class n8 implements o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l3 f7368a;
    public final LinkedList<v9> b;

    public n8(x9 loadCallback) {
        Intrinsics.checkNotNullParameter(loadCallback, "loadCallback");
        this.f7368a = loadCallback;
        this.b = new LinkedList<>();
    }

    @Override // com.ogury.ad.internal.o3
    public final void a(LinkedList loadCommands, int i) {
        Intrinsics.checkNotNullParameter(loadCommands, "loadCommands");
        this.b.addAll(loadCommands);
        v9 v9VarPollFirst = this.b.pollFirst();
        if (v9VarPollFirst != null) {
            v9VarPollFirst.a(this.f7368a, i);
        }
    }

    @Override // com.ogury.ad.internal.o3
    public final void a() {
        v9 v9VarPollFirst = this.b.pollFirst();
        if (v9VarPollFirst != null) {
            v9VarPollFirst.a(this.f7368a, 0);
        }
    }
}
