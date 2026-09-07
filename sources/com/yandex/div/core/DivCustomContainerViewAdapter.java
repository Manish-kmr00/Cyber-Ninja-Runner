package com.yandex.div.core;

import android.view.View;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivCustom;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivCustomContainerViewAdapter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/DivCustomContainerViewAdapter;", "", "bindView", "", "view", "Landroid/view/View;", "div", "Lcom/yandex/div2/DivCustom;", "divView", "Lcom/yandex/div/core/view2/Div2View;", "expressionResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "path", "Lcom/yandex/div/core/state/DivStatePath;", "createView", "isCustomTypeSupported", "", "type", "", LinkHeader.Rel.PreLoad, "Lcom/yandex/div/core/DivPreloader$PreloadReference;", "callBack", "Lcom/yandex/div/core/DivPreloader$Callback;", "release", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivCustomContainerViewAdapter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final DivCustomContainerViewAdapter STUB = new DivCustomContainerViewAdapter() { // from class: com.yandex.div.core.DivCustomContainerViewAdapter$Companion$STUB$1
        @Override // com.yandex.div.core.DivCustomContainerViewAdapter
        public void bindView(View view, DivCustom div, Div2View divView, ExpressionResolver expressionResolver, DivStatePath path) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(div, "div");
            Intrinsics.checkNotNullParameter(divView, "divView");
            Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
            Intrinsics.checkNotNullParameter(path, "path");
        }

        @Override // com.yandex.div.core.DivCustomContainerViewAdapter
        public boolean isCustomTypeSupported(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return false;
        }

        @Override // com.yandex.div.core.DivCustomContainerViewAdapter
        public void release(View view, DivCustom div) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(div, "div");
        }

        @Override // com.yandex.div.core.DivCustomContainerViewAdapter
        public View createView(DivCustom div, Div2View divView, ExpressionResolver expressionResolver, DivStatePath path) {
            Intrinsics.checkNotNullParameter(div, "div");
            Intrinsics.checkNotNullParameter(divView, "divView");
            Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
            Intrinsics.checkNotNullParameter(path, "path");
            throw new UnsupportedOperationException();
        }

        @Override // com.yandex.div.core.DivCustomContainerViewAdapter
        public DivPreloader.PreloadReference preload(DivCustom div, DivPreloader.Callback callBack) {
            Intrinsics.checkNotNullParameter(div, "div");
            Intrinsics.checkNotNullParameter(callBack, "callBack");
            return DivPreloader.PreloadReference.INSTANCE.getEMPTY();
        }
    };

    void bindView(View view, DivCustom div, Div2View divView, ExpressionResolver expressionResolver, DivStatePath path);

    View createView(DivCustom div, Div2View divView, ExpressionResolver expressionResolver, DivStatePath path);

    boolean isCustomTypeSupported(String type);

    void release(View view, DivCustom div);

    default DivPreloader.PreloadReference preload(DivCustom div, DivPreloader.Callback callBack) {
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        return DivPreloader.PreloadReference.INSTANCE.getEMPTY();
    }

    /* JADX INFO: compiled from: DivCustomContainerViewAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\t"}, d2 = {"Lcom/yandex/div/core/DivCustomContainerViewAdapter$Companion;", "", "()V", "STUB", "Lcom/yandex/div/core/DivCustomContainerViewAdapter;", "getDivChildFactory", "Lcom/yandex/div/core/DivCustomContainerChildFactory;", "div2View", "Lcom/yandex/div/core/view2/Div2View;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final DivCustomContainerChildFactory getDivChildFactory(Div2View div2View) {
            Intrinsics.checkNotNullParameter(div2View, "div2View");
            return div2View.getCustomContainerChildFactory$div_release();
        }
    }
}
