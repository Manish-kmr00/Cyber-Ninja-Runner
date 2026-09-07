package com.yandex.div.core.actions;

import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.webkit.internal.AssetHelper;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.internal.Assert;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivActionCopyToClipboardContent;
import com.yandex.div2.DivActionTyped;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivActionTypedCopyToClipboardHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Singleton
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0014\u0010\u0011\u001a\u00020\u0012*\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0014\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0014\u0010\u0011\u001a\u00020\u0012*\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/actions/DivActionTypedCopyToClipboardHandler;", "Lcom/yandex/div/core/actions/DivActionTypedHandler;", "()V", "handleAction", "", "scopeId", "", "action", "Lcom/yandex/div2/DivActionTyped;", "view", "Lcom/yandex/div/core/view2/Div2View;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "handleCopyToClipboard", "", "content", "Lcom/yandex/div2/DivActionCopyToClipboardContent;", "getClipData", "Landroid/content/ClipData;", "Lcom/yandex/div2/DivActionCopyToClipboardContent$ContentTextCase;", "Lcom/yandex/div2/DivActionCopyToClipboardContent$ContentUrlCase;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionTypedCopyToClipboardHandler implements DivActionTypedHandler {
    @Inject
    public DivActionTypedCopyToClipboardHandler() {
    }

    @Override // com.yandex.div.core.actions.DivActionTypedHandler
    public boolean handleAction(String scopeId, DivActionTyped action, Div2View view, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (!(action instanceof DivActionTyped.CopyToClipboard)) {
            return false;
        }
        handleCopyToClipboard(((DivActionTyped.CopyToClipboard) action).getValue().content, view, resolver);
        return true;
    }

    private final void handleCopyToClipboard(DivActionCopyToClipboardContent content, Div2View view, ExpressionResolver resolver) {
        Object systemService = view.getContext().getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager == null) {
            Assert.fail("Failed to access clipboard manager!");
        } else {
            clipboardManager.setPrimaryClip(getClipData(content, resolver));
        }
    }

    private final ClipData getClipData(DivActionCopyToClipboardContent divActionCopyToClipboardContent, ExpressionResolver expressionResolver) {
        if (divActionCopyToClipboardContent instanceof DivActionCopyToClipboardContent.ContentTextCase) {
            return getClipData((DivActionCopyToClipboardContent.ContentTextCase) divActionCopyToClipboardContent, expressionResolver);
        }
        if (divActionCopyToClipboardContent instanceof DivActionCopyToClipboardContent.ContentUrlCase) {
            return getClipData((DivActionCopyToClipboardContent.ContentUrlCase) divActionCopyToClipboardContent, expressionResolver);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final ClipData getClipData(DivActionCopyToClipboardContent.ContentUrlCase contentUrlCase, ExpressionResolver expressionResolver) {
        return new ClipData("Copied url", new String[]{"text/uri-list"}, new ClipData.Item(contentUrlCase.getValue().value.evaluate(expressionResolver)));
    }

    private final ClipData getClipData(DivActionCopyToClipboardContent.ContentTextCase contentTextCase, ExpressionResolver expressionResolver) {
        return new ClipData("Copied text", new String[]{AssetHelper.DEFAULT_MIME_TYPE}, new ClipData.Item(contentTextCase.getValue().value.evaluate(expressionResolver)));
    }
}
