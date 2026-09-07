package com.yandex.div.core.view2.items;

import android.net.Uri;
import com.smaato.sdk.video.vast.model.Category;
import com.yandex.div.core.DivViewFacade;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.json.expressions.ExpressionResolver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivItemChangeActionHandler.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0017\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J-\u0010\u001b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u001a\u0010\u001c\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dH\u0082\bJ\u0016\u0010 \u001a\u00020\u001e*\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u001eH\u0002¨\u0006\""}, d2 = {"Lcom/yandex/div/core/view2/items/DivItemChangeActionHandler;", "", "()V", "canHandle", "", Category.AUTHORITY, "", "direction", "Lcom/yandex/div/core/view2/items/Direction;", "handleAction", "uri", "Landroid/net/Uri;", "view", "Lcom/yandex/div/core/DivViewFacade;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "handleNextItem", "animated", "viewController", "Lcom/yandex/div/core/view2/items/DivViewWithItemsController;", "handlePreviousItem", "handleScrollBackward", "handleScrollForward", "handleScrollTo", "handleScrollToTheEnd", "handleScrollToTheStart", "handleSetCurrentItem", "withOverflowAndStep", "actionOnViewController", "Lkotlin/Function2;", "", "", "getStepParam", "default", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivItemChangeActionHandler {
    public static final DivItemChangeActionHandler INSTANCE = new DivItemChangeActionHandler();

    private DivItemChangeActionHandler() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:30:0x0052 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    public static final boolean canHandle(String authority) {
        if (authority != null) {
            switch (authority.hashCode()) {
                case -1789088446:
                    if (authority.equals("set_next_item")) {
                        return true;
                    }
                    break;
                case -1509135083:
                    if (authority.equals("scroll_backward")) {
                        return true;
                    }
                    break;
                case -1348467885:
                    if (authority.equals("scroll_forward")) {
                        return true;
                    }
                    break;
                case -1280379330:
                    if (authority.equals("set_previous_item")) {
                        return true;
                    }
                    break;
                case -770388272:
                    if (authority.equals("scroll_to_start")) {
                        return true;
                    }
                    break;
                case -88123690:
                    if (authority.equals("set_current_item")) {
                        return true;
                    }
                    break;
                case 633820873:
                    if (authority.equals("scroll_to_end")) {
                        return true;
                    }
                    break;
                case 1099321339:
                    if (authority.equals("scroll_to_position")) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    public static final boolean handleAction(Uri uri, DivViewFacade view, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        String queryParameter = uri.getQueryParameter("id");
        if (queryParameter == null) {
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("id param is required to set item");
            }
            return false;
        }
        String authority = uri.getAuthority();
        DivViewWithItemsController.Companion companion = DivViewWithItemsController.INSTANCE;
        DivItemChangeActionHandler divItemChangeActionHandler = INSTANCE;
        DivViewWithItemsController divViewWithItemsControllerCreate = companion.create(queryParameter, view, resolver, divItemChangeActionHandler.direction(authority));
        if (divViewWithItemsControllerCreate == null) {
            return false;
        }
        String queryParameter2 = uri.getQueryParameter("animated");
        boolean z = queryParameter2 != null ? Boolean.parseBoolean(queryParameter2) : true;
        if (authority == null) {
            return false;
        }
        switch (authority.hashCode()) {
            case -1789088446:
                if (authority.equals("set_next_item")) {
                    return divItemChangeActionHandler.handleNextItem(uri, z, divViewWithItemsControllerCreate);
                }
                return false;
            case -1509135083:
                if (authority.equals("scroll_backward")) {
                    return divItemChangeActionHandler.handleScrollBackward(uri, z, divViewWithItemsControllerCreate);
                }
                return false;
            case -1348467885:
                if (authority.equals("scroll_forward")) {
                    return divItemChangeActionHandler.handleScrollForward(uri, z, divViewWithItemsControllerCreate);
                }
                return false;
            case -1280379330:
                if (authority.equals("set_previous_item")) {
                    return divItemChangeActionHandler.handlePreviousItem(uri, z, divViewWithItemsControllerCreate);
                }
                return false;
            case -770388272:
                if (authority.equals("scroll_to_start")) {
                    return divItemChangeActionHandler.handleScrollToTheStart(z, divViewWithItemsControllerCreate);
                }
                return false;
            case -88123690:
                if (authority.equals("set_current_item")) {
                    return divItemChangeActionHandler.handleSetCurrentItem(uri, z, divViewWithItemsControllerCreate);
                }
                return false;
            case 633820873:
                if (authority.equals("scroll_to_end")) {
                    return divItemChangeActionHandler.handleScrollToTheEnd(z, divViewWithItemsControllerCreate);
                }
                return false;
            case 1099321339:
                if (authority.equals("scroll_to_position")) {
                    return divItemChangeActionHandler.handleScrollTo(uri, z, divViewWithItemsControllerCreate);
                }
                return false;
            default:
                return false;
        }
    }

    private final boolean handleSetCurrentItem(Uri uri, boolean animated, DivViewWithItemsController viewController) {
        String queryParameter = uri.getQueryParameter("item");
        if (queryParameter == null) {
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("item is required to set current item");
            }
            return false;
        }
        try {
            viewController.setCurrentItem(Integer.parseInt(queryParameter), animated);
            return true;
        } catch (NumberFormatException unused) {
            KAssert kAssert2 = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail(queryParameter + " is not a number");
            }
            return false;
        }
    }

    private final boolean handleScrollTo(Uri uri, boolean animated, DivViewWithItemsController viewController) {
        viewController.scrollTo(getStepParam$default(this, uri, 0, 1, null), animated);
        return true;
    }

    private final boolean handleScrollToTheEnd(boolean animated, DivViewWithItemsController viewController) {
        viewController.scrollToEnd(animated);
        return true;
    }

    private final boolean handleScrollToTheStart(boolean animated, DivViewWithItemsController viewController) {
        viewController.scrollToStart(animated);
        return true;
    }

    static /* synthetic */ int getStepParam$default(DivItemChangeActionHandler divItemChangeActionHandler, Uri uri, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return divItemChangeActionHandler.getStepParam(uri, i);
    }

    private final int getStepParam(Uri uri, int i) {
        String queryParameter = uri.getQueryParameter("step");
        if (queryParameter == null) {
            return i;
        }
        try {
            return Integer.parseInt(queryParameter);
        } catch (NumberFormatException unused) {
            KAssert kAssert = KAssert.INSTANCE;
            if (!Assert.isEnabled()) {
                return i;
            }
            Assert.fail(queryParameter + " is not a number");
            return i;
        }
    }

    private final boolean withOverflowAndStep(Uri uri, Function2<? super String, ? super Integer, Unit> actionOnViewController) {
        actionOnViewController.invoke(uri.getQueryParameter("overflow"), Integer.valueOf(getStepParam$default(this, uri, 0, 1, null)));
        return true;
    }

    private final Direction direction(String authority) {
        if (Intrinsics.areEqual(authority, "set_previous_item")) {
            return Direction.PREVIOUS;
        }
        return Intrinsics.areEqual(authority, "set_next_item") ? Direction.NEXT : Direction.NEXT;
    }

    private final boolean handleNextItem(Uri uri, boolean animated, DivViewWithItemsController viewController) {
        viewController.changeCurrentItemByStep(uri.getQueryParameter("overflow"), getStepParam$default(this, uri, 0, 1, null), animated);
        return true;
    }

    private final boolean handlePreviousItem(Uri uri, boolean animated, DivViewWithItemsController viewController) {
        viewController.changeCurrentItemByStep(uri.getQueryParameter("overflow"), -getStepParam$default(this, uri, 0, 1, null), animated);
        return true;
    }

    private final boolean handleScrollForward(Uri uri, boolean animated, DivViewWithItemsController viewController) {
        viewController.scrollByOffset(uri.getQueryParameter("overflow"), getStepParam$default(this, uri, 0, 1, null), animated);
        return true;
    }

    private final boolean handleScrollBackward(Uri uri, boolean animated, DivViewWithItemsController viewController) {
        viewController.scrollByOffset(uri.getQueryParameter("overflow"), -getStepParam$default(this, uri, 0, 1, null), animated);
        return true;
    }
}
