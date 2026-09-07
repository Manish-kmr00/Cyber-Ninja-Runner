package com.yandex.div.core.view2.errors;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yandex.div.R;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VariableMonitorView.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\f\u0010\u001d\u001a\u00020\f*\u00020\u0006H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/yandex/div/core/view2/errors/VariableView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "nameText", "Landroid/widget/TextView;", "getNameText", "()Landroid/widget/TextView;", "onEnterAction", "Lkotlin/Function1;", "", "", "getOnEnterAction", "()Lkotlin/jvm/functions/Function1;", "setOnEnterAction", "(Lkotlin/jvm/functions/Function1;)V", "typeText", "getTypeText", "valueText", "Landroid/widget/EditText;", "getValueText", "()Landroid/widget/EditText;", "addCell", "cell", "width", "", "createCell", "createEditableCell", "configureCommon", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class VariableView extends LinearLayout {
    public static final int CELL_PADDING = 8;
    public static final int NAME_WIDTH = 200;
    public static final int TYPE_WIDTH = 60;
    private final TextView nameText;
    private Function1<? super String, Unit> onEnterAction;
    private final TextView typeText;
    private final EditText valueText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VariableView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        TextView textViewCreateCell = createCell();
        this.nameText = textViewCreateCell;
        TextView textViewCreateCell2 = createCell();
        this.typeText = textViewCreateCell2;
        EditText editTextCreateEditableCell = createEditableCell();
        this.valueText = editTextCreateEditableCell;
        this.onEnterAction = new Function1<String, Unit>() { // from class: com.yandex.div.core.view2.errors.VariableView$onEnterAction$1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        };
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(0);
        addCell(textViewCreateCell, 200);
        addCell(textViewCreateCell2, 60);
        addView(editTextCreateEditableCell, new LinearLayout.LayoutParams(-2, -2, 1.0f));
    }

    public final TextView getNameText() {
        return this.nameText;
    }

    public final TextView getTypeText() {
        return this.typeText;
    }

    public final EditText getValueText() {
        return this.valueText;
    }

    public final Function1<String, Unit> getOnEnterAction() {
        return this.onEnterAction;
    }

    public final void setOnEnterAction(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onEnterAction = function1;
    }

    private final TextView createCell() {
        TextView textView = new TextView(getContext());
        configureCommon(textView);
        return textView;
    }

    private final EditText createEditableCell() {
        final EditText editText = new EditText(getContext());
        configureCommon(editText);
        editText.setImeOptions(6);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.yandex.div.core.view2.errors.VariableView$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return VariableView.createEditableCell$lambda$2$lambda$1(this.f$0, editText, textView, i, keyEvent);
            }
        });
        return editText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean createEditableCell$lambda$2$lambda$1(VariableView this$0, EditText this_apply, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if ((keyEvent != null && keyEvent.getAction() != 0) || i != 6) {
            return false;
        }
        this$0.onEnterAction.invoke(this_apply.getText().toString());
        return true;
    }

    private final void configureCommon(TextView textView) {
        DisplayMetrics displayMetrics = textView.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
        int iDpToPx = BaseDivViewExtensionsKt.dpToPx((Integer) 8, displayMetrics);
        textView.setPadding(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        textView.setTextColor(-1);
        textView.setBackgroundResource(R.drawable.table_cell_background);
        textView.setHorizontallyScrolling(true);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setMaxLines(1);
    }

    private final void addCell(TextView cell, int width) {
        Integer numValueOf = Integer.valueOf(width);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
        addView(cell, new LinearLayout.LayoutParams(BaseDivViewExtensionsKt.dpToPx(numValueOf, displayMetrics), -1));
    }
}
