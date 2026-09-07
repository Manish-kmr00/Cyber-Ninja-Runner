package com.yandex.div.core.view2.divs.gallery;

import android.view.View;
import com.json.b9;
import com.yandex.div.R;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.core.view2.divs.DivCollectionViewHolder;
import com.yandex.div.core.widget.DivViewWrapper;
import com.yandex.div.internal.KLog;
import com.yandex.div.logging.Severity;
import com.yandex.div2.Div;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivGalleryViewHolder.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dBe\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00126\u0010\n\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J \u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0014J\r\u0010\u001b\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\n\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/yandex/div/core/view2/divs/gallery/DivGalleryViewHolder;", "Lcom/yandex/div/core/view2/divs/DivCollectionViewHolder;", "parentContext", "Lcom/yandex/div/core/view2/BindingContext;", "rootView", "Lcom/yandex/div/core/widget/DivViewWrapper;", "divBinder", "Lcom/yandex/div/core/view2/DivBinder;", "viewCreator", "Lcom/yandex/div/core/view2/DivViewCreator;", "itemStateBinder", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "itemView", "Lcom/yandex/div2/Div;", "div", "", "path", "Lcom/yandex/div/core/state/DivStatePath;", "(Lcom/yandex/div/core/view2/BindingContext;Lcom/yandex/div/core/widget/DivViewWrapper;Lcom/yandex/div/core/view2/DivBinder;Lcom/yandex/div/core/view2/DivViewCreator;Lkotlin/jvm/functions/Function2;Lcom/yandex/div/core/state/DivStatePath;)V", "bind", "bindingContext", b9.h.L, "", "logReuseError", "updateState", "()Lkotlin/Unit;", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivGalleryViewHolder extends DivCollectionViewHolder {
    public static final String TAG = "DivGalleryViewHolder";
    private final DivBinder divBinder;
    private final Function2<View, Div, Unit> itemStateBinder;
    private final DivViewWrapper rootView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DivGalleryViewHolder(BindingContext parentContext, DivViewWrapper rootView, DivBinder divBinder, DivViewCreator viewCreator, Function2<? super View, ? super Div, Unit> itemStateBinder, DivStatePath path) {
        super(rootView, parentContext, divBinder, viewCreator, path);
        Intrinsics.checkNotNullParameter(parentContext, "parentContext");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(divBinder, "divBinder");
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        Intrinsics.checkNotNullParameter(itemStateBinder, "itemStateBinder");
        Intrinsics.checkNotNullParameter(path, "path");
        this.rootView = rootView;
        this.divBinder = divBinder;
        this.itemStateBinder = itemStateBinder;
    }

    @Override // com.yandex.div.core.view2.divs.DivCollectionViewHolder
    public void bind(BindingContext bindingContext, Div div, int position) {
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(div, "div");
        super.bind(bindingContext, div, position);
        this.rootView.setTag(R.id.div_gallery_item_index, Integer.valueOf(position));
        this.divBinder.attachIndicators$div_release();
    }

    @Override // com.yandex.div.core.view2.divs.DivCollectionViewHolder
    protected void logReuseError() {
        KLog kLog = KLog.INSTANCE;
        if (kLog.isAtLeast(Severity.DEBUG)) {
            kLog.print(3, TAG, "Gallery holder reuse failed");
        }
    }

    public final Unit updateState() {
        Div oldDiv = getOldDiv();
        if (oldDiv == null) {
            return null;
        }
        this.itemStateBinder.invoke(this.rootView, oldDiv);
        return Unit.INSTANCE;
    }
}
