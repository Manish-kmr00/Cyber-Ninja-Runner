package com.yandex.div.core.util;

import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractIterator;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: DivTreeWalk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0015\u0016\u0017\u0018B\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007BM\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0096\u0002J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eJ\u001a\u0010\b\u001a\u00020\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\tJ\u001a\u0010\u000b\u001a\u00020\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\tR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yandex/div/core/util/DivTreeWalk;", "Lkotlin/sequences/Sequence;", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "root", "Lcom/yandex/div2/Div;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "(Lcom/yandex/div2/Div;Lcom/yandex/div/json/expressions/ExpressionResolver;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "maxDepth", "", "(Lcom/yandex/div2/Div;Lcom/yandex/div/json/expressions/ExpressionResolver;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;I)V", "iterator", "", "depth", "predicate", "function", "BranchNode", "DivTreeWalkIterator", "LeafNode", "Node", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTreeWalk implements Sequence<DivItemBuilderResult> {
    private final int maxDepth;
    private final Function1<Div, Boolean> onEnter;
    private final Function1<Div, Unit> onLeave;
    private final ExpressionResolver resolver;
    private final Div root;

    /* JADX INFO: compiled from: DivTreeWalk.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bb\u0018\u00002\u00020\u0001J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/util/DivTreeWalk$Node;", "", "item", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "getItem", "()Lcom/yandex/div/internal/core/DivItemBuilderResult;", "step", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private interface Node {
        DivItemBuilderResult getItem();

        DivItemBuilderResult step();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DivTreeWalk(Div div, ExpressionResolver expressionResolver, Function1<? super Div, Boolean> function1, Function1<? super Div, Unit> function2, int i) {
        this.root = div;
        this.resolver = expressionResolver;
        this.onEnter = function1;
        this.onLeave = function2;
        this.maxDepth = i;
    }

    /* synthetic */ DivTreeWalk(Div div, ExpressionResolver expressionResolver, Function1 function1, Function1 function2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(div, expressionResolver, function1, function2, (i2 & 16) != 0 ? Integer.MAX_VALUE : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivTreeWalk(Div root, ExpressionResolver resolver) {
        this(root, resolver, null, null, 0, 16, null);
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<DivItemBuilderResult> iterator() {
        return new DivTreeWalkIterator(this, this.root, this.resolver);
    }

    public final DivTreeWalk onEnter(Function1<? super Div, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new DivTreeWalk(this.root, this.resolver, predicate, this.onLeave, this.maxDepth);
    }

    public final DivTreeWalk onLeave(Function1<? super Div, Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new DivTreeWalk(this.root, this.resolver, this.onEnter, function, this.maxDepth);
    }

    public final DivTreeWalk maxDepth(int depth) {
        if (depth <= 0) {
            throw new IllegalArgumentException("depth must be positive, but was " + depth + '.');
        }
        return new DivTreeWalk(this.root, this.resolver, this.onEnter, this.onLeave, depth);
    }

    /* JADX INFO: compiled from: DivTreeWalk.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0014J\n\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/util/DivTreeWalk$DivTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "root", "Lcom/yandex/div2/Div;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "(Lcom/yandex/div/core/util/DivTreeWalk;Lcom/yandex/div2/Div;Lcom/yandex/div/json/expressions/ExpressionResolver;)V", "stack", "Lkotlin/collections/ArrayDeque;", "Lcom/yandex/div/core/util/DivTreeWalk$Node;", "computeNext", "", "nextItem", "node", "item", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class DivTreeWalkIterator extends AbstractIterator<DivItemBuilderResult> {
        private final ExpressionResolver resolver;
        private final Div root;
        private final ArrayDeque<Node> stack;
        final /* synthetic */ DivTreeWalk this$0;

        public DivTreeWalkIterator(DivTreeWalk divTreeWalk, Div root, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            this.this$0 = divTreeWalk;
            this.root = root;
            this.resolver = resolver;
            ArrayDeque<Node> arrayDeque = new ArrayDeque<>();
            arrayDeque.addLast(node(DivCollectionExtensionsKt.toItemBuilderResult(root, resolver)));
            this.stack = arrayDeque;
        }

        @Override // kotlin.collections.AbstractIterator
        protected void computeNext() {
            DivItemBuilderResult divItemBuilderResultNextItem = nextItem();
            if (divItemBuilderResultNextItem != null) {
                setNext(divItemBuilderResultNextItem);
            } else {
                done();
            }
        }

        private final DivItemBuilderResult nextItem() {
            Node nodeLastOrNull = this.stack.lastOrNull();
            if (nodeLastOrNull == null) {
                return null;
            }
            DivItemBuilderResult divItemBuilderResultStep = nodeLastOrNull.step();
            if (divItemBuilderResultStep == null) {
                this.stack.removeLast();
                return nextItem();
            }
            if (divItemBuilderResultStep == nodeLastOrNull.getItem() || DivUtilKt.isLeaf(divItemBuilderResultStep.getDiv()) || this.stack.size() >= this.this$0.maxDepth) {
                return divItemBuilderResultStep;
            }
            this.stack.addLast(node(divItemBuilderResultStep));
            return nextItem();
        }

        private final Node node(DivItemBuilderResult item) {
            if (DivUtilKt.isBranch(item.getDiv())) {
                return new BranchNode(item, this.this$0.onEnter, this.this$0.onLeave);
            }
            return new LeafNode(item);
        }
    }

    /* JADX INFO: compiled from: DivTreeWalk.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/yandex/div/core/util/DivTreeWalk$LeafNode;", "Lcom/yandex/div/core/util/DivTreeWalk$Node;", "item", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "(Lcom/yandex/div/internal/core/DivItemBuilderResult;)V", "getItem", "()Lcom/yandex/div/internal/core/DivItemBuilderResult;", "visited", "", "step", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class LeafNode implements Node {
        private final DivItemBuilderResult item;
        private boolean visited;

        public LeafNode(DivItemBuilderResult item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        @Override // com.yandex.div.core.util.DivTreeWalk.Node
        public DivItemBuilderResult getItem() {
            return this.item;
        }

        @Override // com.yandex.div.core.util.DivTreeWalk.Node
        public DivItemBuilderResult step() {
            if (this.visited) {
                return null;
            }
            this.visited = true;
            return getItem();
        }
    }

    /* JADX INFO: compiled from: DivTreeWalk.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\n\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/yandex/div/core/util/DivTreeWalk$BranchNode;", "Lcom/yandex/div/core/util/DivTreeWalk$Node;", "item", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "onEnter", "Lkotlin/Function1;", "Lcom/yandex/div2/Div;", "", "onLeave", "", "(Lcom/yandex/div/internal/core/DivItemBuilderResult;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "childIndex", "", "children", "", "getItem", "()Lcom/yandex/div/internal/core/DivItemBuilderResult;", "rootVisited", "step", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class BranchNode implements Node {
        private int childIndex;
        private List<DivItemBuilderResult> children;
        private final DivItemBuilderResult item;
        private final Function1<Div, Boolean> onEnter;
        private final Function1<Div, Unit> onLeave;
        private boolean rootVisited;

        /* JADX WARN: Multi-variable type inference failed */
        public BranchNode(DivItemBuilderResult item, Function1<? super Div, Boolean> function1, Function1<? super Div, Unit> function2) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
            this.onEnter = function1;
            this.onLeave = function2;
        }

        @Override // com.yandex.div.core.util.DivTreeWalk.Node
        public DivItemBuilderResult getItem() {
            return this.item;
        }

        @Override // com.yandex.div.core.util.DivTreeWalk.Node
        public DivItemBuilderResult step() {
            if (!this.rootVisited) {
                Function1<Div, Boolean> function1 = this.onEnter;
                if (function1 != null && !function1.invoke(getItem().getDiv()).booleanValue()) {
                    return null;
                }
                this.rootVisited = true;
                return getItem();
            }
            List<DivItemBuilderResult> items = this.children;
            if (items == null) {
                items = DivTreeWalkKt.getItems(getItem().getDiv(), getItem().getExpressionResolver());
                this.children = items;
            }
            if (this.childIndex < items.size()) {
                int i = this.childIndex;
                this.childIndex = i + 1;
                return items.get(i);
            }
            Function1<Div, Unit> function2 = this.onLeave;
            if (function2 == null) {
                return null;
            }
            function2.invoke(getItem().getDiv());
            return null;
        }
    }
}
