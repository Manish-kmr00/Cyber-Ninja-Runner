package com.yandex.div.core.player;

import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivContainer;
import com.yandex.div2.DivCustom;
import com.yandex.div2.DivData;
import com.yandex.div2.DivGallery;
import com.yandex.div2.DivGrid;
import com.yandex.div2.DivPager;
import com.yandex.div2.DivState;
import com.yandex.div2.DivTabs;
import com.yandex.div2.DivVideo;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivVideoActionHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\fJ\"\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/core/player/DivVideoActionHandler;", "", "videoViewMapper", "Lcom/yandex/div/core/player/DivVideoViewMapper;", "(Lcom/yandex/div/core/player/DivVideoViewMapper;)V", "findDivVideoWithId", "Lcom/yandex/div2/DivVideo;", "div", "Lcom/yandex/div2/DivBase;", "id", "", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "handleAction", "", "div2View", "Lcom/yandex/div/core/view2/Div2View;", "divId", "action", "expressionResolver", "searchDivDataForVideo", "divData", "Lcom/yandex/div2/DivData;", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivVideoActionHandler {
    public static final String PAUSE_COMMAND = "pause";
    public static final String START_COMMAND = "start";
    private final DivVideoViewMapper videoViewMapper;

    @Inject
    public DivVideoActionHandler(DivVideoViewMapper videoViewMapper) {
        Intrinsics.checkNotNullParameter(videoViewMapper, "videoViewMapper");
        this.videoViewMapper = videoViewMapper;
    }

    public final boolean handleAction(Div2View div2View, String divId, String action, ExpressionResolver expressionResolver) {
        DivVideo divVideoSearchDivDataForVideo;
        DivPlayer player;
        Intrinsics.checkNotNullParameter(div2View, "div2View");
        Intrinsics.checkNotNullParameter(divId, "divId");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        DivData divData = div2View.getDivData();
        if (divData == null || (divVideoSearchDivDataForVideo = searchDivDataForVideo(divData, divId, expressionResolver)) == null || (player = this.videoViewMapper.getPlayer(divVideoSearchDivDataForVideo)) == null) {
            return false;
        }
        if (Intrinsics.areEqual(action, "start")) {
            player.play();
            return true;
        }
        if (Intrinsics.areEqual(action, "pause")) {
            player.pause();
            return true;
        }
        KAssert kAssert = KAssert.INSTANCE;
        if (Assert.isEnabled()) {
            Assert.fail("No such video action: " + action);
        }
        return false;
    }

    private final DivVideo searchDivDataForVideo(DivData divData, String id, ExpressionResolver resolver) {
        Iterator<T> it = divData.states.iterator();
        while (it.hasNext()) {
            DivVideo divVideoFindDivVideoWithId = findDivVideoWithId(((DivData.State) it.next()).div.value(), id, resolver);
            if (divVideoFindDivVideoWithId != null) {
                return divVideoFindDivVideoWithId;
            }
        }
        return null;
    }

    private final DivVideo findDivVideoWithId(DivBase div, String id, ExpressionResolver resolver) {
        DivBase divBaseValue;
        DivVideo divVideoFindDivVideoWithId;
        if (div instanceof DivVideo) {
            if (Intrinsics.areEqual(div.getId(), id)) {
                return (DivVideo) div;
            }
            return null;
        }
        if (!(div instanceof DivGallery)) {
            if (!(div instanceof DivContainer)) {
                if (!(div instanceof DivGrid)) {
                    if (!(div instanceof DivPager)) {
                        if (!(div instanceof DivTabs)) {
                            if (div instanceof DivCustom) {
                                List<Div> list = ((DivCustom) div).items;
                                if (list != null) {
                                    Iterator<T> it = list.iterator();
                                    while (it.hasNext()) {
                                        DivVideo divVideoFindDivVideoWithId2 = findDivVideoWithId(((Div) it.next()).value(), id, resolver);
                                        if (divVideoFindDivVideoWithId2 != null) {
                                            return divVideoFindDivVideoWithId2;
                                        }
                                    }
                                }
                                return null;
                            }
                            if (div instanceof DivState) {
                                Iterator<T> it2 = ((DivState) div).states.iterator();
                                while (it2.hasNext()) {
                                    Div div2 = ((DivState.State) it2.next()).div;
                                    if (div2 != null && (divBaseValue = div2.value()) != null && (divVideoFindDivVideoWithId = findDivVideoWithId(divBaseValue, id, resolver)) != null) {
                                        return divVideoFindDivVideoWithId;
                                    }
                                }
                            }
                            return null;
                        }
                        Iterator<T> it3 = ((DivTabs) div).items.iterator();
                        while (it3.hasNext()) {
                            DivVideo divVideoFindDivVideoWithId3 = findDivVideoWithId(((DivTabs.Item) it3.next()).div.value(), id, resolver);
                            if (divVideoFindDivVideoWithId3 != null) {
                                return divVideoFindDivVideoWithId3;
                            }
                        }
                        return null;
                    }
                    for (DivItemBuilderResult divItemBuilderResult : DivCollectionExtensionsKt.buildItems((DivPager) div, resolver)) {
                        DivVideo divVideoFindDivVideoWithId4 = findDivVideoWithId(divItemBuilderResult.getDiv().value(), id, divItemBuilderResult.getExpressionResolver());
                        if (divVideoFindDivVideoWithId4 != null) {
                            return divVideoFindDivVideoWithId4;
                        }
                    }
                    return null;
                }
                Iterator<T> it4 = DivCollectionExtensionsKt.getNonNullItems((DivGrid) div).iterator();
                while (it4.hasNext()) {
                    DivVideo divVideoFindDivVideoWithId5 = findDivVideoWithId(((Div) it4.next()).value(), id, resolver);
                    if (divVideoFindDivVideoWithId5 != null) {
                        return divVideoFindDivVideoWithId5;
                    }
                }
                return null;
            }
            for (DivItemBuilderResult divItemBuilderResult2 : DivCollectionExtensionsKt.buildItems((DivContainer) div, resolver)) {
                DivVideo divVideoFindDivVideoWithId6 = findDivVideoWithId(divItemBuilderResult2.getDiv().value(), id, divItemBuilderResult2.getExpressionResolver());
                if (divVideoFindDivVideoWithId6 != null) {
                    return divVideoFindDivVideoWithId6;
                }
            }
            return null;
        }
        for (DivItemBuilderResult divItemBuilderResult3 : DivCollectionExtensionsKt.buildItems((DivGallery) div, resolver)) {
            DivVideo divVideoFindDivVideoWithId7 = findDivVideoWithId(divItemBuilderResult3.getDiv().value(), id, divItemBuilderResult3.getExpressionResolver());
            if (divVideoFindDivVideoWithId7 != null) {
                return divVideoFindDivVideoWithId7;
            }
        }
        return null;
    }
}
