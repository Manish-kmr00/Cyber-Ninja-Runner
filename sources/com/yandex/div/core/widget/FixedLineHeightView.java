package com.yandex.div.core.widget;

import kotlin.Metadata;

/* JADX INFO: compiled from: FixedLineHeightView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b`\u0018\u0000 \b2\u00020\u0001:\u0001\bR\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/widget/FixedLineHeightView;", "", "fixedLineHeight", "", "getFixedLineHeight", "()I", "setFixedLineHeight", "(I)V", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface FixedLineHeightView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int UNDEFINED_LINE_HEIGHT = -1;

    int getFixedLineHeight();

    void setFixedLineHeight(int i);

    /* JADX INFO: compiled from: FixedLineHeightView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/core/widget/FixedLineHeightView$Companion;", "", "()V", "UNDEFINED_LINE_HEIGHT", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int UNDEFINED_LINE_HEIGHT = -1;

        private Companion() {
        }
    }
}
