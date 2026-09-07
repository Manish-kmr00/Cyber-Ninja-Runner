package com.yandex.div.core.view2.errors;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.TransactionTooLargeException;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.webkit.internal.AssetHelper;
import com.yandex.div.R;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.widget.FrameContainerLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\u001c\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0010\u0010\u0011\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/yandex/div/core/view2/errors/ErrorView;", "Lcom/yandex/div/core/Disposable;", "root", "Landroid/view/ViewGroup;", "errorModel", "Lcom/yandex/div/core/view2/errors/ErrorModel;", "showPermanently", "", "(Landroid/view/ViewGroup;Lcom/yandex/div/core/view2/errors/ErrorModel;Z)V", "counterView", "detailsView", "Lcom/yandex/div/core/view2/errors/DetailsViewGroup;", "modelObservation", "value", "Lcom/yandex/div/core/view2/errors/ErrorViewModel;", "viewModel", "setViewModel", "(Lcom/yandex/div/core/view2/errors/ErrorViewModel;)V", "close", "", "pasteToClipBoard", "Lkotlin/Result;", "s", "", "pasteToClipBoard-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "tryAddCounterView", "tryAddDetailsView", "updateView", "old", "new", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ErrorView implements Disposable {
    private ViewGroup counterView;
    private DetailsViewGroup detailsView;
    private final ErrorModel errorModel;
    private final Disposable modelObservation;
    private final ViewGroup root;
    private final boolean showPermanently;
    private ErrorViewModel viewModel;

    public ErrorView(ViewGroup root, ErrorModel errorModel, boolean z) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(errorModel, "errorModel");
        this.root = root;
        this.errorModel = errorModel;
        this.showPermanently = z;
        this.modelObservation = errorModel.observeAndGet(new Function1<ErrorViewModel, Unit>() { // from class: com.yandex.div.core.view2.errors.ErrorView$modelObservation$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ErrorViewModel errorViewModel) {
                invoke2(errorViewModel);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ErrorViewModel m) {
                Intrinsics.checkNotNullParameter(m, "m");
                this.this$0.setViewModel(m);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setViewModel(ErrorViewModel errorViewModel) {
        updateView(this.viewModel, errorViewModel);
        this.viewModel = errorViewModel;
    }

    private final void updateView(ErrorViewModel old, ErrorViewModel errorViewModel) {
        if (old == null || errorViewModel == null || old.getShowDetails() != errorViewModel.getShowDetails()) {
            ViewGroup viewGroup = this.counterView;
            if (viewGroup != null) {
                this.root.removeView(viewGroup);
            }
            this.counterView = null;
            DetailsViewGroup detailsViewGroup = this.detailsView;
            if (detailsViewGroup != null) {
                this.root.removeView(detailsViewGroup);
            }
            this.detailsView = null;
        }
        if (errorViewModel == null) {
            return;
        }
        if (errorViewModel.getShowDetails()) {
            tryAddDetailsView();
            DetailsViewGroup detailsViewGroup2 = this.detailsView;
            if (detailsViewGroup2 != null) {
                detailsViewGroup2.setText(errorViewModel.getDetails());
            }
            DetailsViewGroup detailsViewGroup3 = this.detailsView;
            if (detailsViewGroup3 != null) {
                detailsViewGroup3.updateVariables(this.errorModel.getAllControllers());
                return;
            }
            return;
        }
        if (errorViewModel.getCounterText().length() > 0 || this.showPermanently) {
            tryAddCounterView();
        } else {
            ViewGroup viewGroup2 = this.counterView;
            if (viewGroup2 != null) {
                this.root.removeView(viewGroup2);
            }
            this.counterView = null;
        }
        ViewGroup viewGroup3 = this.counterView;
        View childAt = viewGroup3 != null ? viewGroup3.getChildAt(0) : null;
        AppCompatTextView appCompatTextView = childAt instanceof AppCompatTextView ? (AppCompatTextView) childAt : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(errorViewModel.getCounterText());
            appCompatTextView.setBackgroundResource(errorViewModel.getCounterBackground());
        }
    }

    private final void tryAddDetailsView() {
        if (this.detailsView != null) {
            return;
        }
        Context context = this.root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        DetailsViewGroup detailsViewGroup = new DetailsViewGroup(context, this.errorModel.getErrorHandler(), new Function0<Unit>() { // from class: com.yandex.div.core.view2.errors.ErrorView$tryAddDetailsView$view$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.errorModel.hideDetails();
            }
        }, new Function0<Unit>() { // from class: com.yandex.div.core.view2.errors.ErrorView$tryAddDetailsView$view$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (this.this$0.viewModel != null) {
                    ErrorView errorView = this.this$0;
                    Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(errorView.m6149pasteToClipBoardIoAF18A(ErrorModel.generateReport$default(errorView.errorModel, false, 1, null)));
                    if (thM7907exceptionOrNullimpl == null || !(thM7907exceptionOrNullimpl instanceof TransactionTooLargeException)) {
                        return;
                    }
                    errorView.m6149pasteToClipBoardIoAF18A(errorView.errorModel.generateReport(false));
                }
            }
        });
        this.root.addView(detailsViewGroup, new ViewGroup.LayoutParams(-1, -1));
        this.detailsView = detailsViewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: pasteToClipBoard-IoAF18A, reason: not valid java name */
    public final Object m6149pasteToClipBoardIoAF18A(String s) {
        Object systemService = this.root.getContext().getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager == null) {
            Assert.fail("Failed to access clipboard manager!");
            Result.Companion companion = Result.INSTANCE;
            return Result.m7904constructorimpl(Unit.INSTANCE);
        }
        try {
            clipboardManager.setPrimaryClip(new ClipData("Error report", new String[]{AssetHelper.DEFAULT_MIME_TYPE}, new ClipData.Item(s)));
            Toast.makeText(this.root.getContext(), "Errors, DivData and Variables are dumped to clipboard!", 1).show();
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (TransactionTooLargeException e) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(new RuntimeException("Failed paste report to clipboard!", e)));
        }
    }

    private final void tryAddCounterView() {
        if (this.counterView != null) {
            return;
        }
        AppCompatTextView appCompatTextView = new AppCompatTextView(this.root.getContext());
        appCompatTextView.setBackgroundResource(R.drawable.error_counter_background);
        appCompatTextView.setTextSize(12.0f);
        appCompatTextView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        appCompatTextView.setGravity(17);
        appCompatTextView.setElevation(appCompatTextView.getResources().getDimension(R.dimen.div_shadow_elevation));
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.yandex.div.core.view2.errors.ErrorView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ErrorView.tryAddCounterView$lambda$6$lambda$5(this.f$0, view);
            }
        });
        DisplayMetrics metrics = this.root.getContext().getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
        int iDpToPx = BaseDivViewExtensionsKt.dpToPx((Integer) 24, metrics);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(iDpToPx, iDpToPx);
        int iDpToPx2 = BaseDivViewExtensionsKt.dpToPx((Integer) 8, metrics);
        marginLayoutParams.topMargin = iDpToPx2;
        marginLayoutParams.leftMargin = iDpToPx2;
        marginLayoutParams.rightMargin = iDpToPx2;
        marginLayoutParams.bottomMargin = iDpToPx2;
        Context context = this.root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        FrameContainerLayout frameContainerLayout = new FrameContainerLayout(context, null, 0, 6, null);
        frameContainerLayout.addView(appCompatTextView, marginLayoutParams);
        this.root.addView(frameContainerLayout, -1, -1);
        this.counterView = frameContainerLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryAddCounterView$lambda$6$lambda$5(ErrorView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.errorModel.showDetails();
    }

    @Override // com.yandex.div.core.Disposable, java.lang.AutoCloseable, java.io.Closeable
    public void close() {
        this.modelObservation.close();
        this.root.removeView(this.counterView);
        this.root.removeView(this.detailsView);
    }
}
