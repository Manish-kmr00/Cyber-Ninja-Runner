package com.yandex.div.core.view2.errors;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.yandex.div.core.expression.variables.VariableController;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0001H\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\u0001H\u0002J\u001a\u0010\u001d\u001a\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020 0\u001fR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/yandex/div/core/view2/errors/DetailsViewGroup;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "errorHandler", "Lkotlin/Function1;", "", "", "onCloseAction", "Lkotlin/Function0;", "onCopyAction", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "errorsOutput", "Landroidx/appcompat/widget/AppCompatTextView;", "monitorView", "Lcom/yandex/div/core/view2/errors/VariableMonitorView;", "value", "", "text", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "variableMonitor", "Lcom/yandex/div/core/view2/errors/VariableMonitor;", "configureView", "createControls", "createErrorsOutput", "createTopPanel", "updateVariables", "controllers", "", "Lcom/yandex/div/core/expression/variables/VariableController;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class DetailsViewGroup extends LinearLayout {
    private final AppCompatTextView errorsOutput;
    private final VariableMonitorView monitorView;
    private final Function0<Unit> onCloseAction;
    private final Function0<Unit> onCopyAction;
    private final VariableMonitor variableMonitor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailsViewGroup(Context context, Function1<? super Throwable, Unit> errorHandler, Function0<Unit> onCloseAction, Function0<Unit> onCopyAction) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(errorHandler, "errorHandler");
        Intrinsics.checkNotNullParameter(onCloseAction, "onCloseAction");
        Intrinsics.checkNotNullParameter(onCopyAction, "onCopyAction");
        this.onCloseAction = onCloseAction;
        this.onCopyAction = onCopyAction;
        VariableMonitor variableMonitor = new VariableMonitor(errorHandler);
        this.variableMonitor = variableMonitor;
        this.errorsOutput = createErrorsOutput();
        this.monitorView = new VariableMonitorView(context, variableMonitor);
        configureView();
    }

    public final void setText(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.errorsOutput.setText(value);
    }

    public final String getText() {
        return this.errorsOutput.getText().toString();
    }

    public final void updateVariables(Map<String, ? extends VariableController> controllers) {
        Intrinsics.checkNotNullParameter(controllers, "controllers");
        this.variableMonitor.setControllerMap(controllers);
    }

    private final LinearLayout createTopPanel() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        LinearLayout linearLayoutCreateControls = createControls();
        DisplayMetrics displayMetrics = linearLayout.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
        linearLayout.addView(linearLayoutCreateControls, new LinearLayout.LayoutParams(BaseDivViewExtensionsKt.dpToPx((Integer) 32, displayMetrics), -2));
        linearLayout.addView(this.errorsOutput, new LinearLayout.LayoutParams(-2, -2));
        return linearLayout;
    }

    private final LinearLayout createControls() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        DisplayMetrics displayMetrics = linearLayout.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
        linearLayout.setPadding(0, 0, BaseDivViewExtensionsKt.dpToPx((Integer) 8, displayMetrics), 0);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(linearLayout.getContext());
        imageView.setImageResource(R.drawable.ic_menu_close_clear_cancel);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.yandex.div.core.view2.errors.DetailsViewGroup$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailsViewGroup.createControls$lambda$5$lambda$2$lambda$1(this.f$0, view);
            }
        });
        ImageView imageView2 = new ImageView(linearLayout.getContext());
        imageView2.setImageResource(R.drawable.ic_menu_save);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.yandex.div.core.view2.errors.DetailsViewGroup$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailsViewGroup.createControls$lambda$5$lambda$4$lambda$3(this.f$0, view);
            }
        });
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(imageView2, new LinearLayout.LayoutParams(-2, -2));
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createControls$lambda$5$lambda$2$lambda$1(DetailsViewGroup this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onCloseAction.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createControls$lambda$5$lambda$4$lambda$3(DetailsViewGroup this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onCopyAction.invoke();
    }

    private final AppCompatTextView createErrorsOutput() {
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        appCompatTextView.setTextColor(-1);
        appCompatTextView.setGravity(3);
        return appCompatTextView;
    }

    private final void configureView() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
        int iDpToPx = BaseDivViewExtensionsKt.dpToPx((Integer) 8, displayMetrics);
        setPadding(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        setOrientation(1);
        setBackgroundColor(Color.argb(186, 0, 0, 0));
        setElevation(getResources().getDimension(com.yandex.div.R.dimen.div_shadow_elevation));
        addView(createTopPanel(), new LinearLayout.LayoutParams(-2, -2));
        addView(this.monitorView, new LinearLayout.LayoutParams(-1, -2));
    }
}
