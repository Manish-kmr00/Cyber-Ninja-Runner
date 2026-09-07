package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class U7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11375a;
    public final ProtobufStateStorage b;
    public final W7 c;
    public final InterfaceC4599yn d;
    public final InterfaceC4274lm e;
    public final Ki f;
    public final Ii g;
    public final G6 h;
    public V7 i;

    public U7(Context context, ProtobufStateStorage protobufStateStorage, W7 w7, InterfaceC4599yn interfaceC4599yn, InterfaceC4274lm interfaceC4274lm, Ki ki, Ii ii, G6 g6, V7 v7) {
        this.f11375a = context;
        this.b = protobufStateStorage;
        this.c = w7;
        this.d = interfaceC4599yn;
        this.e = interfaceC4274lm;
        this.f = ki;
        this.g = ii;
        this.h = g6;
        this.i = v7;
    }

    public final synchronized V7 a() {
        return this.i;
    }

    public final synchronized boolean b(Y7 y7) {
        boolean z = false;
        if (y7.a() == X7.b) {
            return false;
        }
        if (Intrinsics.areEqual(y7, this.i.b())) {
            return false;
        }
        List listA = (List) this.d.invoke(this.i.a(), y7);
        boolean z2 = listA != null;
        if (listA == null) {
            listA = this.i.a();
        }
        if (this.c.a(y7, this.i.b())) {
            z = true;
        } else {
            y7 = (Y7) this.i.b();
        }
        if (z || z2) {
            V7 v7 = this.i;
            V7 v8 = (V7) this.e.invoke(y7, listA);
            this.i = v8;
            this.b.save(v8);
            Vi.a("Update distribution data: %s -> %s", v7, this.i);
        }
        return z;
    }

    public final synchronized Y7 c() {
        if (!this.g.a()) {
            Y7 y7 = (Y7) this.f.invoke();
            this.g.b();
            if (y7 != null) {
                b(y7);
            }
        }
        return (Y7) this.i.b();
    }

    public final Y7 a(Y7 y7) {
        Y7 y7C;
        this.h.a(this.f11375a);
        synchronized (this) {
            b(y7);
            y7C = c();
        }
        return y7C;
    }

    public final Y7 b() {
        this.h.a(this.f11375a);
        return c();
    }
}
