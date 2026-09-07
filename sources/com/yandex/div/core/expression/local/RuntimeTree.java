package com.yandex.div.core.expression.local;

import com.yandex.div.core.expression.ExpressionsRuntime;
import com.yandex.div.core.expression.variables.VariableAndConstantController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RuntimeTree.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0005J\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\rJ*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u0012J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005J \u0010\u0014\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0005J \u0010\u000e\u001a\u00020\u000f*\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u0012H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yandex/div/core/expression/local/RuntimeTree;", "", "()V", "pathToNodes", "", "", "Lcom/yandex/div/core/expression/local/RuntimeTree$RuntimeNode;", "runtimesToNodes", "Lcom/yandex/div/core/expression/ExpressionsRuntime;", "getNode", "runtime", "path", "getPathToRuntimes", "", "invokeRecursively", "", "expressionsRuntime", "callback", "Lkotlin/Function1;", "removeRuntimeAndCleanup", "storeRuntime", "parentRuntime", "RuntimeNode", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RuntimeTree {
    private final Map<ExpressionsRuntime, RuntimeNode> runtimesToNodes = new LinkedHashMap();
    private final Map<String, RuntimeNode> pathToNodes = new LinkedHashMap();

    public final RuntimeNode getNode(ExpressionsRuntime runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        return this.runtimesToNodes.get(runtime);
    }

    public final RuntimeNode getNode(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.pathToNodes.get(path);
    }

    public final void storeRuntime(ExpressionsRuntime runtime, ExpressionsRuntime parentRuntime, String path) {
        RuntimeNode runtimeNode;
        List<RuntimeNode> children;
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(path, "path");
        RuntimeNode runtimeNode2 = new RuntimeNode(runtime, path, null, 4, null);
        this.pathToNodes.put(path, runtimeNode2);
        this.runtimesToNodes.put(runtime, runtimeNode2);
        if (parentRuntime == null || (runtimeNode = this.runtimesToNodes.get(parentRuntime)) == null || (children = runtimeNode.getChildren()) == null) {
            return;
        }
        children.add(runtimeNode2);
    }

    private final void invokeRecursively(RuntimeNode runtimeNode, Function1<? super RuntimeNode, Unit> function1) {
        function1.invoke(runtimeNode);
        Iterator<T> it = runtimeNode.getChildren().iterator();
        while (it.hasNext()) {
            invokeRecursively((RuntimeNode) it.next(), function1);
        }
    }

    public final void invokeRecursively(ExpressionsRuntime expressionsRuntime, String path, Function1<? super RuntimeNode, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionsRuntime, "expressionsRuntime");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        RuntimeNode runtimeNode = this.runtimesToNodes.get(expressionsRuntime);
        if (runtimeNode == null) {
            return;
        }
        if (StringsKt.startsWith$default(runtimeNode.getPath(), path, false, 2, (Object) null)) {
            invokeRecursively(runtimeNode, callback);
            return;
        }
        for (RuntimeNode runtimeNode2 : runtimeNode.getChildren()) {
            if (StringsKt.startsWith$default(runtimeNode2.getPath(), path, false, 2, (Object) null)) {
                invokeRecursively(runtimeNode2, callback);
            }
        }
    }

    public final void removeRuntimeAndCleanup(ExpressionsRuntime runtime, String path) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(path, "path");
        invokeRecursively(runtime, path, new Function1<RuntimeNode, Unit>() { // from class: com.yandex.div.core.expression.local.RuntimeTree.removeRuntimeAndCleanup.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RuntimeNode runtimeNode) {
                invoke2(runtimeNode);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RuntimeNode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                RuntimeTree.this.runtimesToNodes.remove(it.getRuntime());
                RuntimeTree.this.pathToNodes.remove(it.getPath());
                if (it.getRuntime().getVariableController() instanceof VariableAndConstantController) {
                    return;
                }
                it.getRuntime().cleanup$div_release();
            }
        });
    }

    public final Map<String, ExpressionsRuntime> getPathToRuntimes() {
        Map<String, RuntimeNode> map = this.pathToNodes;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, RuntimeNode> entry : map.entrySet()) {
            arrayList.add(TuplesKt.to(entry.getKey(), entry.getValue().getRuntime()));
        }
        return MapsKt.toMap(arrayList);
    }

    /* JADX INFO: compiled from: RuntimeTree.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007¢\u0006\u0002\u0010\bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/core/expression/local/RuntimeTree$RuntimeNode;", "", "runtime", "Lcom/yandex/div/core/expression/ExpressionsRuntime;", "path", "", "children", "", "(Lcom/yandex/div/core/expression/ExpressionsRuntime;Ljava/lang/String;Ljava/util/List;)V", "getChildren", "()Ljava/util/List;", "getPath", "()Ljava/lang/String;", "getRuntime", "()Lcom/yandex/div/core/expression/ExpressionsRuntime;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class RuntimeNode {
        private final List<RuntimeNode> children;
        private final String path;
        private final ExpressionsRuntime runtime;

        public RuntimeNode(ExpressionsRuntime runtime, String path, List<RuntimeNode> children) {
            Intrinsics.checkNotNullParameter(runtime, "runtime");
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(children, "children");
            this.runtime = runtime;
            this.path = path;
            this.children = children;
        }

        public final ExpressionsRuntime getRuntime() {
            return this.runtime;
        }

        public final String getPath() {
            return this.path;
        }

        public /* synthetic */ RuntimeNode(ExpressionsRuntime expressionsRuntime, String str, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(expressionsRuntime, str, (i & 4) != 0 ? new ArrayList() : arrayList);
        }

        public final List<RuntimeNode> getChildren() {
            return this.children;
        }
    }
}
