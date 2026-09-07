package io.bidmachine.rendering.view;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.json.m5;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.R;
import io.bidmachine.rendering.internal.m;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.util.UtilsKt;
import io.bidmachine.util.appintents.IntentUtilsKt;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0019\b\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0005\u0010\rJ&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u001b\u0010\u0018\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u0005\u0010\u0017\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lio/bidmachine/rendering/view/PrivacySheetDialog;", "Landroid/app/Dialog;", "Landroid/view/Window;", "window", "", "a", "Lio/bidmachine/rendering/model/PrivacySheetParams;", "params", "Lio/bidmachine/rendering/model/PrivacySheetParams$Action;", "action", "", "data", "Lkotlin/Result;", "(Ljava/lang/String;)Ljava/lang/Object;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Lio/bidmachine/rendering/model/PrivacySheetParams;", "privacySheetParams", "Lio/bidmachine/rendering/internal/view/privacy/b;", "Lkotlin/Lazy;", "()Lio/bidmachine/rendering/internal/view/privacy/b;", "privacySheetLayout", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lio/bidmachine/rendering/model/PrivacySheetParams;)V", "Companion", "bidmachine-android-rendering_d_2_4_0"}, k = 1, mv = {1, 7, 1})
public final class PrivacySheetDialog extends Dialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static WeakReference c = new WeakReference(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final PrivacySheetParams privacySheetParams;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Lazy privacySheetLayout;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/bidmachine/rendering/view/PrivacySheetDialog$Companion;", "", "()V", "lastPrivacySheetDialogRef", "Ljava/lang/ref/WeakReference;", "Lio/bidmachine/rendering/view/PrivacySheetDialog;", m5.v, "context", "Landroid/content/Context;", "privacySheetParams", "Lio/bidmachine/rendering/model/PrivacySheetParams;", "bidmachine-android-rendering_d_2_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final PrivacySheetDialog show(Context context, PrivacySheetParams privacySheetParams) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(privacySheetParams, "privacySheetParams");
            PrivacySheetDialog privacySheetDialog = (PrivacySheetDialog) PrivacySheetDialog.c.get();
            if (privacySheetDialog != null && privacySheetDialog.isShowing()) {
                if (Intrinsics.areEqual(privacySheetDialog.privacySheetParams, privacySheetParams)) {
                    return privacySheetDialog;
                }
                privacySheetDialog.dismiss();
            }
            PrivacySheetDialog privacySheetDialog2 = new PrivacySheetDialog(context, privacySheetParams, null);
            PrivacySheetDialog.c = new WeakReference(privacySheetDialog2);
            try {
                privacySheetDialog2.show();
            } catch (Throwable th) {
                m.b(th);
            }
            return privacySheetDialog2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrivacySheetParams.ActionType.values().length];
            try {
                iArr[PrivacySheetParams.ActionType.REDIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrivacySheetParams.ActionType.COPY_TO_CLIPBOARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final class a extends Lambda implements Function0 {
        a() {
            super(0);
        }

        public final void a() {
            PrivacySheetDialog.this.dismiss();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f12446a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context) {
            super(0);
            this.f12446a = context;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.bidmachine.rendering.internal.view.privacy.b invoke() {
            return new io.bidmachine.rendering.internal.view.privacy.b(this.f12446a);
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ PrivacySheetParams.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(PrivacySheetParams.Action action) {
            super(0);
            this.b = action;
        }

        public final void a() {
            PrivacySheetDialog.this.a(this.b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    private PrivacySheetDialog(Context context, PrivacySheetParams privacySheetParams) {
        super(context, R.style.Bm_BottomSheetDialog);
        this.privacySheetParams = privacySheetParams;
        this.privacySheetLayout = LazyKt.lazy(new b(context));
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
    }

    private final void a(Window window) {
        if (Build.VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(false);
        } else {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1792);
        }
    }

    private final Object b(String data) {
        try {
            Result.Companion companion = Result.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return Result.m7904constructorimpl(Boolean.valueOf(IntentUtilsKt.openUrl(context, data)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    @JvmStatic
    public static final PrivacySheetDialog show(Context context, PrivacySheetParams privacySheetParams) {
        return INSTANCE.show(context, privacySheetParams);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        io.bidmachine.rendering.internal.view.privacy.b bVarA = a();
        bVarA.setOnCloseClickListener(new a());
        setContentView(bVarA);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
            a(window);
        }
        a(this.privacySheetParams);
    }

    public /* synthetic */ PrivacySheetDialog(Context context, PrivacySheetParams privacySheetParams, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, privacySheetParams);
    }

    private final Object a(String data) {
        try {
            Result.Companion companion = Result.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ClipboardManager clipboardManager = UtilsKt.getClipboardManager(context);
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("", data));
            }
            return Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final io.bidmachine.rendering.internal.view.privacy.b a() {
        return (io.bidmachine.rendering.internal.view.privacy.b) this.privacySheetLayout.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(PrivacySheetParams.Action action) {
        String data = action.getData();
        int i = WhenMappings.$EnumSwitchMapping$0[action.getType().ordinal()];
        if (i == 1) {
            b(data);
        } else {
            if (i != 2) {
                return;
            }
            a(data);
        }
    }

    private final void a(PrivacySheetParams params) {
        io.bidmachine.rendering.internal.view.privacy.b bVarA = a();
        bVarA.a();
        bVarA.setTitle(params.getTitle());
        bVarA.setSubtitle(params.getSubtitle());
        for (PrivacySheetParams.Action action : params.getActions()) {
            Bitmap icon = action.getIcon();
            bVarA.a(action.getTitle(), icon != null ? new BitmapDrawable(bVarA.getResources(), icon) : null, new c(action));
        }
    }
}
