package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class kj<T extends ViewGroup> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9424a;
    private final ViewGroup b;
    private final fr0<T> c;
    private final dr0<T> d;
    private final jj<T> e;

    public /* synthetic */ kj(Context context, ViewGroup viewGroup, List list, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
        this(context, viewGroup, list, onPreDrawListener, new fr0(list), new dr0(), new jj(onPreDrawListener));
    }

    public kj(Context context, ViewGroup container, List<br0<T>> designs, ViewTreeObserver.OnPreDrawListener preDrawListener, fr0<T> layoutDesignProvider, dr0<T> layoutDesignCreator, jj<T> layoutDesignBinder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(designs, "designs");
        Intrinsics.checkNotNullParameter(preDrawListener, "preDrawListener");
        Intrinsics.checkNotNullParameter(layoutDesignProvider, "layoutDesignProvider");
        Intrinsics.checkNotNullParameter(layoutDesignCreator, "layoutDesignCreator");
        Intrinsics.checkNotNullParameter(layoutDesignBinder, "layoutDesignBinder");
        this.f9424a = context;
        this.b = container;
        this.c = layoutDesignProvider;
        this.d = layoutDesignCreator;
        this.e = layoutDesignBinder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean a(zy1 zy1Var) {
        ViewGroup viewGroupA;
        br0<V> br0VarA = this.c.a(this.f9424a);
        if (br0VarA == 0 || (viewGroupA = this.d.a(this.b, br0VarA)) == null) {
            return false;
        }
        this.e.a(this.b, viewGroupA, br0VarA, zy1Var);
        return true;
    }

    public final void a() {
        this.e.a();
    }
}
