package com.yandex.div.core.downloader;

import android.net.Uri;
import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.DivViewFacade;
import com.yandex.div.core.images.LoadReference;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.internal.Assert;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivActionDownload;
import com.yandex.div2.DivDownloadCallbacks;
import com.yandex.div2.DivPatch;
import com.yandex.div2.DivSightAction;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivDownloadActionHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J@\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J*\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J(\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007¨\u0006\u001c"}, d2 = {"Lcom/yandex/div/core/downloader/DivDownloadActionHandler;", "", "()V", "canHandle", "", "uri", "Landroid/net/Uri;", "divViewFacade", "Lcom/yandex/div/core/DivViewFacade;", "executeDownload", "downloadUrl", "", "onSuccessActions", "", "Lcom/yandex/div2/DivAction;", "onFailActions", "view", "Lcom/yandex/div/core/view2/Div2View;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "handleAction", "downloadCallbacks", "Lcom/yandex/div2/DivDownloadCallbacks;", "action", "Lcom/yandex/div2/DivActionDownload;", "callbacks", "handleVisibilityAction", "Lcom/yandex/div2/DivSightAction;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivDownloadActionHandler {
    public static final DivDownloadActionHandler INSTANCE = new DivDownloadActionHandler();

    private DivDownloadActionHandler() {
    }

    @JvmStatic
    public static final boolean canHandle(Uri uri, DivViewFacade divViewFacade) {
        String authority;
        Intrinsics.checkNotNullParameter(divViewFacade, "divViewFacade");
        if (uri == null || (authority = uri.getAuthority()) == null || !Intrinsics.areEqual("download", authority)) {
            return false;
        }
        if (uri.getQueryParameter("url") == null) {
            Assert.fail("url param is required!");
            return false;
        }
        if (divViewFacade instanceof Div2View) {
            return true;
        }
        Assert.fail("Div2View should be used!");
        return false;
    }

    @JvmStatic
    public static final boolean handleAction(DivAction action, Div2View view, ExpressionResolver resolver) {
        Uri uriEvaluate;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Expression<Uri> expression = action.url;
        if (expression == null || (uriEvaluate = expression.evaluate(resolver)) == null) {
            return false;
        }
        return INSTANCE.handleAction(uriEvaluate, action.downloadCallbacks, view, resolver);
    }

    @JvmStatic
    public static final boolean handleVisibilityAction(DivSightAction action, Div2View view, ExpressionResolver resolver) {
        Uri uriEvaluate;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Expression<Uri> url = action.getUrl();
        if (url == null || (uriEvaluate = url.evaluate(resolver)) == null) {
            return false;
        }
        return INSTANCE.handleAction(uriEvaluate, action.getDownloadCallbacks(), view, resolver);
    }

    public final boolean handleAction(DivActionDownload action, DivDownloadCallbacks callbacks, Div2View view, ExpressionResolver resolver) {
        List<DivAction> list;
        List<DivAction> list2;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Uri uriEvaluate = action.url.evaluate(resolver);
        List<DivAction> list3 = action.onFailActions;
        if (list3 != null) {
            list = list3;
        } else if (callbacks != null) {
            list3 = callbacks.onFailActions;
            list = list3;
        } else {
            list = null;
        }
        List<DivAction> list4 = action.onSuccessActions;
        if (list4 == null) {
            list2 = callbacks != null ? callbacks.onSuccessActions : null;
        } else {
            list2 = list4;
        }
        String string = uriEvaluate.toString();
        Intrinsics.checkNotNullExpressionValue(string, "url.toString()");
        return executeDownload(string, list2, list, view, resolver);
    }

    private final boolean handleAction(Uri uri, DivDownloadCallbacks downloadCallbacks, Div2View view, ExpressionResolver resolver) {
        String queryParameter = uri.getQueryParameter("url");
        if (queryParameter == null) {
            return false;
        }
        return executeDownload(queryParameter, downloadCallbacks != null ? downloadCallbacks.onSuccessActions : null, downloadCallbacks != null ? downloadCallbacks.onFailActions : null, view, resolver);
    }

    private final boolean executeDownload(String downloadUrl, final List<DivAction> onSuccessActions, final List<DivAction> onFailActions, final Div2View view, final ExpressionResolver resolver) {
        LoadReference loadRef = view.getDiv2Component().getDivDownloader().downloadPatch(view, downloadUrl, new DivPatchDownloadCallback() { // from class: com.yandex.div.core.downloader.DivDownloadActionHandler$executeDownload$callback$1
            @Override // com.yandex.div.core.downloader.DivPatchDownloadCallback
            public void onSuccess(DivPatch patch) {
                Intrinsics.checkNotNullParameter(patch, "patch");
                if (view.applyPatch(patch)) {
                    Div2View div2View = view;
                    final List<DivAction> list = onSuccessActions;
                    final Div2View div2View2 = view;
                    final ExpressionResolver expressionResolver = resolver;
                    div2View.bulkActions$div_release(new Function0<Unit>() { // from class: com.yandex.div.core.downloader.DivDownloadActionHandler$executeDownload$callback$1$onSuccess$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            List<DivAction> list2 = list;
                            if (list2 != null) {
                                Div2View div2View3 = div2View2;
                                ExpressionResolver expressionResolver2 = expressionResolver;
                                Iterator<T> it = list2.iterator();
                                while (it.hasNext()) {
                                    div2View3.handleAction((DivAction) it.next(), DivActionHandler.DivActionReason.PATCH, expressionResolver2);
                                }
                            }
                        }
                    });
                }
            }

            @Override // com.yandex.div.core.downloader.DivPatchDownloadCallback
            public void onFail() {
                Div2View div2View = view;
                final List<DivAction> list = onFailActions;
                final Div2View div2View2 = view;
                final ExpressionResolver expressionResolver = resolver;
                div2View.bulkActions$div_release(new Function0<Unit>() { // from class: com.yandex.div.core.downloader.DivDownloadActionHandler$executeDownload$callback$1$onFail$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        List<DivAction> list2 = list;
                        if (list2 != null) {
                            Div2View div2View3 = div2View2;
                            ExpressionResolver expressionResolver2 = expressionResolver;
                            Iterator<T> it = list2.iterator();
                            while (it.hasNext()) {
                                div2View3.handleAction((DivAction) it.next(), DivActionHandler.DivActionReason.PATCH, expressionResolver2);
                            }
                        }
                    }
                });
            }
        });
        Intrinsics.checkNotNullExpressionValue(loadRef, "loadRef");
        view.addLoadReference(loadRef, view);
        return true;
    }
}
