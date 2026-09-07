package com.yandex.div.internal.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.ListPopupWindow;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.json.b9;
import com.json.m5;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.reuse.InputFocusTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectView.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001(B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u000eH\u0014J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J0\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rH\u0014J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\rH\u0014J\u0014\u0010$\u001a\u00020\u000e2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/yandex/div/internal/widget/SelectView;", "Lcom/yandex/div/internal/widget/EllipsizedTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "focusTracker", "Lcom/yandex/div/core/view2/reuse/InputFocusTracker;", "getFocusTracker", "()Lcom/yandex/div/core/view2/reuse/InputFocusTracker;", "setFocusTracker", "(Lcom/yandex/div/core/view2/reuse/InputFocusTracker;)V", "onItemSelectedListener", "Lkotlin/Function1;", "", "", "getOnItemSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "popupWindow", "Lcom/yandex/div/internal/widget/SelectView$PopupWindow;", "onDetachedFromWindow", "onInitializeAccessibilityNodeInfo", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "onLayout", "changed", "", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "setItems", FirebaseAnalytics.Param.ITEMS, "", "", "PopupWindow", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class SelectView extends EllipsizedTextView {
    private InputFocusTracker focusTracker;
    private Function1<? super Integer, Unit> onItemSelectedListener;
    private final PopupWindow popupWindow;

    /* JADX WARN: Illegal instructions before constructor call */
    public SelectView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = 6;
        DefaultConstructorMarker defaultConstructorMarker = null;
        AttributeSet attributeSet = null;
        int i2 = 0;
        super(context, attributeSet, i2, i, defaultConstructorMarker);
        setOnClickListener(new View.OnClickListener() { // from class: com.yandex.div.internal.widget.SelectView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectView._init_$lambda$1(this.f$0, view);
            }
        });
        final PopupWindow popupWindow = new PopupWindow(context, attributeSet, i2, i, defaultConstructorMarker);
        popupWindow.setModal(true);
        popupWindow.setAnchorView(this);
        popupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yandex.div.internal.widget.SelectView$$ExternalSyntheticLambda1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i3, long j) {
                SelectView.popupWindow$lambda$3$lambda$2(this.f$0, popupWindow, adapterView, view, i3, j);
            }
        });
        popupWindow.setOverlapAnchor(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(-1));
        popupWindow.setAdapter(popupWindow.getAdapter());
        this.popupWindow = popupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(SelectView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InputFocusTracker inputFocusTracker = this$0.focusTracker;
        if (inputFocusTracker != null) {
            BaseDivViewExtensionsKt.clearFocusOnClick(this$0, inputFocusTracker);
        }
        this$0.popupWindow.resetPosition();
        this$0.popupWindow.show();
    }

    public final Function1<Integer, Unit> getOnItemSelectedListener() {
        return this.onItemSelectedListener;
    }

    public final void setOnItemSelectedListener(Function1<? super Integer, Unit> function1) {
        this.onItemSelectedListener = function1;
    }

    public final InputFocusTracker getFocusTracker() {
        return this.focusTracker;
    }

    public final void setFocusTracker(InputFocusTracker inputFocusTracker) {
        this.focusTracker = inputFocusTracker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void popupWindow$lambda$3$lambda$2(SelectView this$0, PopupWindow this_apply, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.sendAccessibilityEvent(4);
        Function1<? super Integer, Unit> function1 = this$0.onItemSelectedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i));
        }
        this_apply.dismiss();
    }

    public final void setItems(List<String> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.popupWindow.getAdapter().setItems(items);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed && this.popupWindow.isShowing()) {
            this.popupWindow.show();
        }
    }

    @Override // com.yandex.div.internal.widget.EllipsizedTextView, androidx.appcompat.widget.AppCompatTextView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.popupWindow.isShowing()) {
            this.popupWindow.dismiss();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0 || !this.popupWindow.isShowing()) {
            return;
        }
        this.popupWindow.dismiss();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        info.setCanOpenPopup(true);
        info.setText(getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SelectView.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0012\u0018\u00002\u00020\u0001:\u0001\u0011B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0018\u0010\t\u001a\u00060\nR\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/internal/widget/SelectView$PopupWindow;", "Landroidx/appcompat/widget/ListPopupWindow;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/yandex/div/internal/widget/SelectView$PopupWindow$PopupAdapter;", "getAdapter", "()Lcom/yandex/div/internal/widget/SelectView$PopupWindow$PopupAdapter;", "getInputMethodMode", "resetPosition", "", m5.v, "PopupAdapter", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static class PopupWindow extends ListPopupWindow {
        private final PopupAdapter adapter;
        private final Context context;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PopupWindow(Context context) {
            this(context, null, 0, 6, null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PopupWindow(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0, 4, null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // androidx.appcompat.widget.ListPopupWindow
        public int getInputMethodMode() {
            return 1;
        }

        public /* synthetic */ PopupWindow(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.listPopupWindowStyle : i);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PopupWindow(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.adapter = new PopupAdapter();
        }

        public PopupAdapter getAdapter() {
            return this.adapter;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.view.menu.ShowableListMenu
        public void show() {
            if (getListView() == null) {
                super.show();
                ListView listView = getListView();
                if (listView != null) {
                    listView.setChoiceMode(1);
                }
            }
            super.show();
        }

        public void resetPosition() {
            ListView listView = getListView();
            if (listView != null) {
                listView.setSelectionAfterHeaderView();
            }
        }

        /* JADX INFO: compiled from: SelectView.kt */
        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\tH\u0016J$\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/internal/widget/SelectView$PopupWindow$PopupAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/yandex/div/internal/widget/SelectView$PopupWindow;)V", FirebaseAnalytics.Param.ITEMS, "", "", "createView", "Landroid/widget/TextView;", "getCount", "", "getItem", b9.h.L, "getItemId", "", "getView", "convertView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "setItems", "", "newItems", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public final class PopupAdapter extends BaseAdapter {
            private List<String> items = CollectionsKt.emptyList();

            @Override // android.widget.Adapter
            public long getItemId(int position) {
                return position;
            }

            public PopupAdapter() {
            }

            public final void setItems(List<String> newItems) {
                Intrinsics.checkNotNullParameter(newItems, "newItems");
                this.items = newItems;
                notifyDataSetChanged();
            }

            @Override // android.widget.Adapter
            public int getCount() {
                return this.items.size();
            }

            @Override // android.widget.Adapter
            public String getItem(int position) {
                return this.items.get(position);
            }

            @Override // android.widget.Adapter
            public TextView getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = createView();
                }
                Intrinsics.checkNotNull(convertView, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) convertView;
                textView.setText(getItem(position));
                return textView;
            }

            private final TextView createView() {
                TextView textView = new TextView(PopupWindow.this.context, null, android.R.attr.spinnerDropDownItemStyle);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setSingleLine(true);
                DisplayMetrics displayMetrics = textView.getResources().getDisplayMetrics();
                Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
                textView.setLayoutParams(new ViewGroup.LayoutParams(-1, BaseDivViewExtensionsKt.dpToPx((Integer) 48, displayMetrics)));
                textView.setTextAlignment(5);
                return textView;
            }
        }
    }
}
