package com.yandex.div.core.view2.divs;

import android.content.Context;
import android.view.View;
import com.yandex.div.core.DecodeBase64ImageTask;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.expression.variables.TwoWayIntegerVariableBinder;
import com.yandex.div.core.player.DivPlayer;
import com.yandex.div.core.player.DivPlayerFactory;
import com.yandex.div.core.player.DivPlayerPlaybackConfig;
import com.yandex.div.core.player.DivPlayerView;
import com.yandex.div.core.player.DivVideoSource;
import com.yandex.div.core.player.DivVideoViewMapper;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.util.ImageRepresentation;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivViewBinder;
import com.yandex.div.core.view2.divs.widgets.DivVideoView;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivVideo;
import com.yandex.div2.DivVideoScale;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivVideoBinder.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B7\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J*\u0010\u001e\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0014\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020\u00120\"H\u0002J,\u0010$\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J$\u0010'\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0002J,\u0010(\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivVideoBinder;", "Lcom/yandex/div/core/view2/DivViewBinder;", "Lcom/yandex/div2/DivVideo;", "Lcom/yandex/div/core/view2/divs/widgets/DivVideoView;", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "variableBinder", "Lcom/yandex/div/core/expression/variables/TwoWayIntegerVariableBinder;", "divActionBinder", "Lcom/yandex/div/core/view2/divs/DivActionBinder;", "videoViewMapper", "Lcom/yandex/div/core/player/DivVideoViewMapper;", "executorService", "Ljava/util/concurrent/ExecutorService;", "playerFactory", "Lcom/yandex/div/core/player/DivPlayerFactory;", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Lcom/yandex/div/core/expression/variables/TwoWayIntegerVariableBinder;Lcom/yandex/div/core/view2/divs/DivActionBinder;Lcom/yandex/div/core/player/DivVideoViewMapper;Ljava/util/concurrent/ExecutorService;Lcom/yandex/div/core/player/DivPlayerFactory;)V", "bindView", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div", "path", "Lcom/yandex/div/core/state/DivStatePath;", "createObserver", "Lcom/yandex/div/core/player/DivPlayer$Observer;", "bindingContext", "previewImageView", "Landroid/view/View;", "applyPreview", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "onPreviewDecoded", "Lkotlin/Function1;", "Lcom/yandex/div/core/util/ImageRepresentation;", "observeElapsedTime", "player", "Lcom/yandex/div/core/player/DivPlayer;", "observeMuted", "observeScale", "playerView", "Lcom/yandex/div/core/player/DivPlayerView;", "previewView", "Lcom/yandex/div/core/view2/divs/PreviewImageView;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivVideoBinder implements DivViewBinder<DivVideo, DivVideoView> {
    private final DivBaseBinder baseBinder;
    private final DivActionBinder divActionBinder;
    private final ExecutorService executorService;
    private final DivPlayerFactory playerFactory;
    private final TwoWayIntegerVariableBinder variableBinder;
    private final DivVideoViewMapper videoViewMapper;

    @Inject
    public DivVideoBinder(DivBaseBinder baseBinder, TwoWayIntegerVariableBinder variableBinder, DivActionBinder divActionBinder, DivVideoViewMapper videoViewMapper, ExecutorService executorService, DivPlayerFactory playerFactory) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(variableBinder, "variableBinder");
        Intrinsics.checkNotNullParameter(divActionBinder, "divActionBinder");
        Intrinsics.checkNotNullParameter(videoViewMapper, "videoViewMapper");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(playerFactory, "playerFactory");
        this.baseBinder = baseBinder;
        this.variableBinder = variableBinder;
        this.divActionBinder = divActionBinder;
        this.videoViewMapper = videoViewMapper;
        this.executorService = executorService;
        this.playerFactory = playerFactory;
    }

    @Override // com.yandex.div.core.view2.DivViewBinder
    public void bindView(BindingContext context, DivVideoView view, DivVideo div, DivStatePath path) {
        PreviewImageView previewImageView;
        final DivPlayerView divPlayerView;
        final PreviewImageView previewImageView2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(path, "path");
        DivVideo div2 = view.getDiv();
        if (div == div2) {
            return;
        }
        DivVideoView divVideoView = view;
        this.baseBinder.bindView(context, divVideoView, div, div2);
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        List<DivVideoSource> listCreateSource = DivVideoBinderKt.createSource(div, expressionResolver);
        DivPlayerPlaybackConfig divPlayerPlaybackConfig = new DivPlayerPlaybackConfig(div.autostart.evaluate(expressionResolver).booleanValue(), div.muted.evaluate(expressionResolver).booleanValue(), div.repeatable.evaluate(expressionResolver).booleanValue(), div.playerSettingsPayload);
        DivPlayerView playerView = view.getPlayerView();
        int childCount = view.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                previewImageView = null;
                break;
            }
            View childAt = view.getChildAt(i);
            if (childAt instanceof PreviewImageView) {
                previewImageView = (PreviewImageView) childAt;
                break;
            }
            i++;
        }
        if (playerView == null) {
            DivPlayerFactory divPlayerFactory = this.playerFactory;
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            DivPlayerView divPlayerViewMakePlayerView = divPlayerFactory.makePlayerView(context2);
            divPlayerViewMakePlayerView.setVisibility(4);
            divPlayerView = divPlayerViewMakePlayerView;
        } else {
            divPlayerView = playerView;
        }
        if (previewImageView == null) {
            Context context3 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "view.context");
            previewImageView2 = new PreviewImageView(context3);
        } else {
            previewImageView2 = previewImageView;
        }
        applyPreview(div, expressionResolver, new Function1<ImageRepresentation, Unit>() { // from class: com.yandex.div.core.view2.divs.DivVideoBinder.bindView.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ImageRepresentation imageRepresentation) {
                invoke2(imageRepresentation);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ImageRepresentation imageRepresentation) {
                if (imageRepresentation != null) {
                    PreviewImageView previewImageView3 = previewImageView2;
                    previewImageView3.setVisibility(0);
                    if (imageRepresentation instanceof ImageRepresentation.PictureDrawable) {
                        previewImageView3.setImageDrawable(((ImageRepresentation.PictureDrawable) imageRepresentation).m6136unboximpl());
                    } else if (imageRepresentation instanceof ImageRepresentation.Bitmap) {
                        previewImageView3.setImageBitmap(((ImageRepresentation.Bitmap) imageRepresentation).m6129unboximpl());
                    }
                }
                divPlayerView.setVisibility(0);
            }
        });
        DivPlayer divPlayerMakePlayer = this.playerFactory.makePlayer(listCreateSource, divPlayerPlaybackConfig);
        View view2 = previewImageView2;
        divPlayerMakePlayer.addObserver(createObserver(context, div, view2));
        divPlayerView.attach(divPlayerMakePlayer);
        observeElapsedTime(view, div, context, divPlayerMakePlayer, path);
        observeMuted(view, div, expressionResolver, divPlayerMakePlayer);
        observeScale(view, div, expressionResolver, divPlayerView, previewImageView2);
        if (previewImageView == null && playerView == null) {
            view.removeAllViews();
            view.addView(divPlayerView);
            view.addView(view2);
        }
        this.videoViewMapper.addView(view, div);
        BaseDivViewExtensionsKt.bindAspectRatio(divVideoView, div.aspect, div2 != null ? div2.aspect : null, expressionResolver);
    }

    private final DivPlayer.Observer createObserver(BindingContext bindingContext, final DivVideo div, final View previewImageView) {
        final Div2View divView = bindingContext.getDivView();
        final ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        return new DivPlayer.Observer() { // from class: com.yandex.div.core.view2.divs.DivVideoBinder.createObserver.1
            @Override // com.yandex.div.core.player.DivPlayer.Observer
            public void onPlay() {
                DivActionBinder.handleActions$div_release$default(DivVideoBinder.this.divActionBinder, divView, expressionResolver, div.resumeActions, "video", null, 16, null);
            }

            @Override // com.yandex.div.core.player.DivPlayer.Observer
            public void onPause() {
                DivActionBinder.handleActions$div_release$default(DivVideoBinder.this.divActionBinder, divView, expressionResolver, div.pauseActions, "video", null, 16, null);
            }

            @Override // com.yandex.div.core.player.DivPlayer.Observer
            public void onBuffering() {
                DivActionBinder.handleActions$div_release$default(DivVideoBinder.this.divActionBinder, divView, expressionResolver, div.bufferingActions, "video", null, 16, null);
            }

            @Override // com.yandex.div.core.player.DivPlayer.Observer
            public void onEnd() {
                DivActionBinder.handleActions$div_release$default(DivVideoBinder.this.divActionBinder, divView, expressionResolver, div.endActions, "video", null, 16, null);
            }

            @Override // com.yandex.div.core.player.DivPlayer.Observer
            public void onFatal() {
                DivActionBinder.handleActions$div_release$default(DivVideoBinder.this.divActionBinder, divView, expressionResolver, div.fatalActions, "video", null, 16, null);
            }

            @Override // com.yandex.div.core.player.DivPlayer.Observer
            public void onReady() {
                previewImageView.setVisibility(4);
            }
        };
    }

    private final void observeElapsedTime(DivVideoView divVideoView, DivVideo divVideo, BindingContext bindingContext, final DivPlayer divPlayer, DivStatePath divStatePath) {
        String str = divVideo.elapsedTimeVariable;
        if (str == null) {
            return;
        }
        divVideoView.addSubscription(this.variableBinder.bindVariable(bindingContext, str, new TwoWayIntegerVariableBinder.Callbacks() { // from class: com.yandex.div.core.view2.divs.DivVideoBinder$observeElapsedTime$callbacks$1
            @Override // com.yandex.div.core.expression.variables.TwoWayVariableBinder.Callbacks
            public void onVariableChanged(Long value) {
                if (value != null) {
                    DivPlayer divPlayer2 = divPlayer;
                    value.longValue();
                    divPlayer2.seek(value.longValue());
                }
            }

            @Override // com.yandex.div.core.expression.variables.TwoWayVariableBinder.Callbacks
            public void setViewStateChangeListener(final Function1<? super Long, Unit> valueUpdater) {
                Intrinsics.checkNotNullParameter(valueUpdater, "valueUpdater");
                divPlayer.addObserver(new DivPlayer.Observer() { // from class: com.yandex.div.core.view2.divs.DivVideoBinder$observeElapsedTime$callbacks$1$setViewStateChangeListener$1
                    @Override // com.yandex.div.core.player.DivPlayer.Observer
                    public void onCurrentTimeChange(long timeMs) {
                        valueUpdater.invoke(Long.valueOf(timeMs));
                    }
                });
            }
        }, divStatePath));
    }

    private final void observeMuted(DivVideoView divVideoView, DivVideo divVideo, ExpressionResolver expressionResolver, final DivPlayer divPlayer) {
        divVideoView.addSubscription(divVideo.muted.observeAndGet(expressionResolver, new Function1<Boolean, Unit>() { // from class: com.yandex.div.core.view2.divs.DivVideoBinder.observeMuted.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                divPlayer.setMuted(z);
            }
        }));
    }

    private final void observeScale(DivVideoView divVideoView, DivVideo divVideo, ExpressionResolver expressionResolver, final DivPlayerView divPlayerView, final PreviewImageView previewImageView) {
        divVideoView.addSubscription(divVideo.scale.observeAndGet(expressionResolver, new Function1<DivVideoScale, Unit>() { // from class: com.yandex.div.core.view2.divs.DivVideoBinder.observeScale.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DivVideoScale divVideoScale) {
                invoke2(divVideoScale);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DivVideoScale it) {
                Intrinsics.checkNotNullParameter(it, "it");
                divPlayerView.setScale(it);
                previewImageView.setScale(it);
            }
        }));
    }

    private final void applyPreview(DivVideo divVideo, ExpressionResolver expressionResolver, Function1<? super ImageRepresentation, Unit> function1) {
        Expression<String> expression = divVideo.preview;
        String strEvaluate = expression != null ? expression.evaluate(expressionResolver) : null;
        if (strEvaluate == null) {
            function1.invoke(null);
        } else {
            this.executorService.submit(new DecodeBase64ImageTask(strEvaluate, false, function1));
        }
    }
}
