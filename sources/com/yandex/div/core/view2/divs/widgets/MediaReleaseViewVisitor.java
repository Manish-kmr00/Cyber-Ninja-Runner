package com.yandex.div.core.view2.divs.widgets;

import com.yandex.div.core.dagger.DivViewScope;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaReleaseViewVisitor.kt */
/* JADX INFO: loaded from: classes8.dex */
@DivViewScope
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/MediaReleaseViewVisitor;", "Lcom/yandex/div/core/view2/divs/widgets/DivViewVisitor;", "()V", "visit", "", "view", "Lcom/yandex/div/core/view2/divs/widgets/DivVideoView;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class MediaReleaseViewVisitor extends DivViewVisitor {
    @Inject
    public MediaReleaseViewVisitor() {
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivViewVisitor
    public void visit(DivVideoView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.release();
    }
}
