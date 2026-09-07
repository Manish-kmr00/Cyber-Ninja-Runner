package com.yandex.div.core;

import android.net.Uri;
import android.view.KeyEvent;
import com.yandex.div.core.actions.DivActionTypedHandlerProxy;
import com.yandex.div.core.downloader.DivDownloadActionHandler;
import com.yandex.div.core.expression.storedvalues.StoredValuesActionHandler;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.state.PathFormatException;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.ViewLocator;
import com.yandex.div.core.view2.divs.widgets.DivHolderView;
import com.yandex.div.core.view2.items.DivItemChangeActionHandler;
import com.yandex.div.data.VariableMutationException;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.core.VariableMutationHandler;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivDisappearAction;
import com.yandex.div2.DivSightAction;
import com.yandex.div2.DivVisibilityAction;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class DivActionHandler {
    private static final String AUTHORITY_HIDE_TOOLTIP = "hide_tooltip";
    private static final String AUTHORITY_SET_VARIABLE = "set_variable";
    private static final String AUTHORITY_SHOW_TOOLTIP = "show_tooltip";
    private static final String AUTHORITY_SWITCH_STATE = "set_state";
    private static final String AUTHORITY_TIMER = "timer";
    private static final String AUTHORITY_VIDEO = "video";
    private static final String PARAM_ACTION = "action";
    private static final String PARAM_ID = "id";
    private static final String PARAM_MULTIPLE = "multiple";
    private static final String PARAM_STATE_ID = "state_id";
    private static final String PARAM_TEMPORARY = "temporary";
    private static final String PARAM_VARIABLE_NAME = "name";
    private static final String PARAM_VARIABLE_VALUE = "value";
    private static final String SCHEME_DIV_ACTION = "div-action";

    public static class DivActionReason {
        public static final String ANIMATION_CANCEL = "animation_cancel";
        public static final String ANIMATION_END = "animation_end";
        public static final String BLUR = "blur";
        public static final String CLICK = "click";
        public static final String DOUBLE_CLICK = "double_click";
        public static final String ENTER = "enter";
        public static final String EXTERNAL = "external";
        public static final String FOCUS = "focus";
        public static final String HOVER = "hover";
        public static final String LONG_CLICK = "long_click";
        public static final String MENU = "menu";
        public static final String PATCH = "patch";
        public static final String PRESS = "press";
        public static final String RELEASE = "release";
        public static final String SELECTION = "selection";
        public static final String STATE_SWIPE_OUT = "state_swipe_out";
        public static final String TIMER = "timer";
        public static final String TRIGGER = "trigger";
        public static final String UNHOVER = "unhover";
        public static final String VIDEO = "video";
    }

    public boolean getUseActionUid() {
        return false;
    }

    public void handlePayload(JSONObject jSONObject) {
    }

    public boolean handleAction(DivAction divAction, DivViewFacade divViewFacade, ExpressionResolver expressionResolver) {
        Div2View div2View = (Div2View) divViewFacade;
        ExpressionResolver expressionResolverFindExpressionResolverById = findExpressionResolverById(div2View, divAction.scopeId);
        if (expressionResolverFindExpressionResolverById == null) {
            expressionResolverFindExpressionResolverById = expressionResolver;
        }
        if (DivActionTypedHandlerProxy.handleAction(divAction, divViewFacade, expressionResolverFindExpressionResolverById)) {
            return true;
        }
        Uri uriEvaluate = divAction.url != null ? divAction.url.evaluate(expressionResolver) : null;
        if (DivDownloadActionHandler.canHandle(uriEvaluate, divViewFacade)) {
            return DivDownloadActionHandler.handleAction(divAction, div2View, expressionResolverFindExpressionResolverById);
        }
        return handleAction(divAction.scopeId, uriEvaluate, divViewFacade, expressionResolverFindExpressionResolverById);
    }

    public boolean handleAction(DivAction divAction, DivViewFacade divViewFacade, ExpressionResolver expressionResolver, String str) {
        return handleAction(divAction, divViewFacade, expressionResolver);
    }

    public boolean handleActionWithReason(DivAction divAction, DivViewFacade divViewFacade, ExpressionResolver expressionResolver, String str) {
        return handleAction(divAction, divViewFacade, expressionResolver);
    }

    public boolean handleActionWithReason(DivAction divAction, DivViewFacade divViewFacade, ExpressionResolver expressionResolver, String str, String str2) {
        return handleAction(divAction, divViewFacade, expressionResolver, str);
    }

    public boolean handleAction(DivVisibilityAction divVisibilityAction, DivViewFacade divViewFacade, ExpressionResolver expressionResolver) {
        return handleAction((DivSightAction) divVisibilityAction, divViewFacade, expressionResolver);
    }

    public boolean handleAction(DivDisappearAction divDisappearAction, DivViewFacade divViewFacade, ExpressionResolver expressionResolver) {
        return handleAction((DivSightAction) divDisappearAction, divViewFacade, expressionResolver);
    }

    public boolean handleAction(DivSightAction divSightAction, DivViewFacade divViewFacade, ExpressionResolver expressionResolver) {
        Div2View div2View = (Div2View) divViewFacade;
        ExpressionResolver expressionResolverFindExpressionResolverById = findExpressionResolverById(div2View, divSightAction.getScopeId());
        if (expressionResolverFindExpressionResolverById == null) {
            expressionResolverFindExpressionResolverById = expressionResolver;
        }
        if (DivActionTypedHandlerProxy.handleVisibilityAction(divSightAction, divViewFacade, expressionResolverFindExpressionResolverById)) {
            return true;
        }
        Uri uriEvaluate = divSightAction.getUrl() != null ? divSightAction.getUrl().evaluate(expressionResolver) : null;
        if (DivDownloadActionHandler.canHandle(uriEvaluate, divViewFacade)) {
            return DivDownloadActionHandler.handleVisibilityAction(divSightAction, div2View, expressionResolverFindExpressionResolverById);
        }
        return handleAction(divSightAction.getScopeId(), uriEvaluate, divViewFacade, expressionResolver);
    }

    public boolean handleAction(DivVisibilityAction divVisibilityAction, DivViewFacade divViewFacade, ExpressionResolver expressionResolver, String str) {
        return handleAction(divVisibilityAction, divViewFacade, expressionResolver);
    }

    public boolean handleAction(DivDisappearAction divDisappearAction, DivViewFacade divViewFacade, ExpressionResolver expressionResolver, String str) {
        return handleAction(divDisappearAction, divViewFacade, expressionResolver);
    }

    public boolean handleAction(DivSightAction divSightAction, DivViewFacade divViewFacade, ExpressionResolver expressionResolver, String str) {
        return handleAction(divSightAction, divViewFacade, expressionResolver);
    }

    public boolean handleActionUrl(Uri uri, DivViewFacade divViewFacade) {
        return handleActionUrl(uri, divViewFacade, divViewFacade.getExpressionResolver());
    }

    public final boolean handleActionUrl(Uri uri, DivViewFacade divViewFacade, ExpressionResolver expressionResolver) {
        return handleActionUrl(null, uri, divViewFacade, expressionResolver);
    }

    public final boolean handleActionUrl(String str, Uri uri, DivViewFacade divViewFacade, ExpressionResolver expressionResolver) {
        ExpressionResolver expressionResolverFindExpressionResolverById = findExpressionResolverById((Div2View) divViewFacade, str);
        if (expressionResolverFindExpressionResolverById != null) {
            expressionResolver = expressionResolverFindExpressionResolverById;
        }
        return handleAction(str, uri, divViewFacade, expressionResolver);
    }

    private boolean handleAction(String str, Uri uri, DivViewFacade divViewFacade, ExpressionResolver expressionResolver) {
        if (uri != null && SCHEME_DIV_ACTION.equals(uri.getScheme())) {
            return handleActionInternal(str, uri, divViewFacade, expressionResolver);
        }
        return false;
    }

    private boolean handleActionInternal(String str, Uri uri, DivViewFacade divViewFacade, ExpressionResolver expressionResolver) {
        Div2View div2View;
        String authority = uri.getAuthority();
        if ("set_state".equals(authority)) {
            String queryParameter = uri.getQueryParameter("state_id");
            if (queryParameter == null) {
                Assert.fail("state_id param is required");
                return false;
            }
            try {
                divViewFacade.switchToState(DivStatePath.parse(queryParameter), uri.getBooleanQueryParameter(PARAM_TEMPORARY, true));
                return true;
            } catch (PathFormatException e) {
                Assert.fail("Invalid format of " + queryParameter, e);
                return false;
            }
        }
        if ("show_tooltip".equals(authority)) {
            String queryParameter2 = uri.getQueryParameter("id");
            if (queryParameter2 == null) {
                Assert.fail("id param is required");
                return false;
            }
            divViewFacade.showTooltip(queryParameter2, uri.getBooleanQueryParameter(PARAM_MULTIPLE, false));
            return true;
        }
        if ("hide_tooltip".equals(authority)) {
            String queryParameter3 = uri.getQueryParameter("id");
            if (queryParameter3 == null) {
                Assert.fail("id param is required");
                return false;
            }
            divViewFacade.hideTooltip(queryParameter3);
            return true;
        }
        if ("set_variable".equals(authority)) {
            String queryParameter4 = uri.getQueryParameter("name");
            if (queryParameter4 == null) {
                Assert.fail("name param is required");
                return false;
            }
            String queryParameter5 = uri.getQueryParameter("value");
            if (queryParameter5 == null) {
                Assert.fail("value param unspecified for " + queryParameter4);
                return false;
            }
            div2View = divViewFacade instanceof Div2View ? (Div2View) divViewFacade : null;
            if (div2View == null) {
                Assert.fail("Variable '" + queryParameter4 + "' mutation failed! View(" + divViewFacade.getClass().getSimpleName() + ") not supports variables!");
                return false;
            }
            try {
                VariableMutationHandler.setVariable(div2View, queryParameter4, queryParameter5, expressionResolver);
                return true;
            } catch (VariableMutationException e2) {
                Assert.fail("Variable '" + queryParameter4 + "' mutation failed: " + e2.getMessage(), e2);
                return false;
            }
        }
        if ("timer".equals(authority)) {
            String queryParameter6 = uri.getQueryParameter("id");
            if (queryParameter6 == null) {
                Assert.fail("id param is required");
                return false;
            }
            String queryParameter7 = uri.getQueryParameter("action");
            if (queryParameter7 == null) {
                Assert.fail("action param is required");
                return false;
            }
            div2View = divViewFacade instanceof Div2View ? (Div2View) divViewFacade : null;
            if (div2View == null) {
                Assert.fail("Timer '" + queryParameter6 + "' state changing failed! View(" + divViewFacade.getClass().getSimpleName() + ") not supports timers!");
                return false;
            }
            div2View.applyTimerCommand(queryParameter6, queryParameter7);
            return true;
        }
        if ("video".equals(authority)) {
            div2View = divViewFacade instanceof Div2View ? (Div2View) divViewFacade : null;
            if (div2View == null) {
                Assert.fail("Handler view is not instance of Div2View");
                return false;
            }
            String queryParameter8 = uri.getQueryParameter("id");
            if (queryParameter8 == null) {
                Assert.fail("Video action has no id param");
                return false;
            }
            String queryParameter9 = uri.getQueryParameter("action");
            if (queryParameter9 == null) {
                Assert.fail("Video action has no action param");
                return false;
            }
            return div2View.applyVideoCommand(queryParameter8, queryParameter9, expressionResolver);
        }
        if (DivItemChangeActionHandler.canHandle(authority)) {
            return DivItemChangeActionHandler.handleAction(uri, divViewFacade, expressionResolver);
        }
        if (StoredValuesActionHandler.canHandle(authority)) {
            return StoredValuesActionHandler.handleAction(uri, divViewFacade);
        }
        return false;
    }

    private static ExpressionResolver findExpressionResolverById(Div2View div2View, String str) {
        BindingContext bindingContext;
        if (str == null) {
            return null;
        }
        KeyEvent.Callback callbackFindSingleViewWithTag = ViewLocator.findSingleViewWithTag(div2View, str);
        if (!(callbackFindSingleViewWithTag instanceof DivHolderView) || (bindingContext = ((DivHolderView) callbackFindSingleViewWithTag).getBindingContext()) == null) {
            return null;
        }
        return bindingContext.getExpressionResolver();
    }
}
