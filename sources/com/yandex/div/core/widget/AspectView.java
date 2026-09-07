package com.yandex.div.core.widget;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AspectView.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b`\u0018\u0000 \b2\u00020\u0001:\u0001\bR\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/widget/AspectView;", "", "aspectRatio", "", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface AspectView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final float DEFAULT_ASPECT_RATIO = 0.0f;

    float getAspectRatio();

    void setAspectRatio(float f);

    /* JADX INFO: compiled from: AspectView.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0000¢\u0006\u0002\b\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div/core/widget/AspectView$Companion;", "", "()V", "DEFAULT_ASPECT_RATIO", "", "aspectRatioProperty", "Lkotlin/properties/ReadWriteProperty;", "Landroid/view/View;", "aspectRatioProperty$div_release", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final float DEFAULT_ASPECT_RATIO = 0.0f;

        private Companion() {
        }

        public final ReadWriteProperty<View, Float> aspectRatioProperty$div_release() {
            return ViewsKt.dimensionAffecting(Float.valueOf(0.0f), new Function1<Float, Float>() { // from class: com.yandex.div.core.widget.AspectView$Companion$aspectRatioProperty$1
                public final Float invoke(float f) {
                    return Float.valueOf(RangesKt.coerceAtLeast(f, 0.0f));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Float f) {
                    return invoke(f.floatValue());
                }
            });
        }
    }
}
