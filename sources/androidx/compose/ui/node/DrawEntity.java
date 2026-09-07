package androidx.compose.ui.node;

import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.draw.DrawCacheModifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DrawEntity.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0019B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0006\u0010\u0017\u001a\u00020\u0012J\n\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/node/DrawEntity;", "Landroidx/compose/ui/node/LayoutNodeEntity;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/node/OwnerScope;", "layoutNodeWrapper", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/draw/DrawModifier;)V", "buildCacheParams", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "cacheDrawModifier", "Landroidx/compose/ui/draw/DrawCacheModifier;", "invalidateCache", "", "isValid", "()Z", "updateCache", "Lkotlin/Function0;", "", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "onAttach", "onMeasureResultChanged", "updateCacheDrawModifier", "Companion", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DrawEntity extends LayoutNodeEntity<DrawEntity, DrawModifier> implements OwnerScope {
    private static final Function1<DrawEntity, Unit> onCommitAffectingDrawEntity = new Function1<DrawEntity, Unit>() { // from class: androidx.compose.ui.node.DrawEntity$Companion$onCommitAffectingDrawEntity$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DrawEntity drawEntity) {
            invoke2(drawEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DrawEntity drawEntity) {
            Intrinsics.checkNotNullParameter(drawEntity, "drawEntity");
            if (drawEntity.isValid()) {
                drawEntity.invalidateCache = true;
                drawEntity.getLayoutNodeWrapper().invalidateLayer();
            }
        }
    };
    private final BuildDrawCacheParams buildCacheParams;
    private DrawCacheModifier cacheDrawModifier;
    private boolean invalidateCache;
    private final Function0<Unit> updateCache;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawEntity(final LayoutNodeWrapper layoutNodeWrapper, DrawModifier modifier) {
        super(layoutNodeWrapper, modifier);
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "layoutNodeWrapper");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        this.cacheDrawModifier = updateCacheDrawModifier();
        this.buildCacheParams = new BuildDrawCacheParams() { // from class: androidx.compose.ui.node.DrawEntity$buildCacheParams$1
            private final Density density;

            {
                this.density = this.this$0.getLayoutNode().getDensity();
            }

            @Override // androidx.compose.ui.draw.BuildDrawCacheParams
            public Density getDensity() {
                return this.density;
            }

            @Override // androidx.compose.ui.draw.BuildDrawCacheParams
            public LayoutDirection getLayoutDirection() {
                return this.this$0.getLayoutNode().getLayoutDirection();
            }

            @Override // androidx.compose.ui.draw.BuildDrawCacheParams
            /* JADX INFO: renamed from: getSize-NH-jbRc */
            public long mo1317getSizeNHjbRc() {
                return IntSizeKt.m4013toSizeozmzZPI(layoutNodeWrapper.mo3126getSizeYbymL2g());
            }
        };
        this.invalidateCache = true;
        this.updateCache = new Function0<Unit>() { // from class: androidx.compose.ui.node.DrawEntity$updateCache$1
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
                DrawCacheModifier drawCacheModifier = this.this$0.cacheDrawModifier;
                if (drawCacheModifier != null) {
                    drawCacheModifier.onBuildCache(this.this$0.buildCacheParams);
                }
                this.this$0.invalidateCache = false;
            }
        };
    }

    private final DrawCacheModifier updateCacheDrawModifier() {
        DrawModifier modifier = getModifier();
        if (modifier instanceof DrawCacheModifier) {
            return (DrawCacheModifier) modifier;
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LayoutNodeEntity
    public void onAttach() {
        this.cacheDrawModifier = updateCacheDrawModifier();
        this.invalidateCache = true;
        super.onAttach();
    }

    public final void onMeasureResultChanged() {
        this.invalidateCache = true;
    }

    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        long jM4013toSizeozmzZPI = IntSizeKt.m4013toSizeozmzZPI(m3260getSizeYbymL2g());
        if (this.cacheDrawModifier != null && this.invalidateCache) {
            LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingDrawEntity, this.updateCache);
        }
        LayoutNodeDrawScope mDrawScope$ui_release = getLayoutNode().getMDrawScope$ui_release();
        LayoutNodeWrapper layoutNodeWrapper = getLayoutNodeWrapper();
        DrawEntity drawEntity = mDrawScope$ui_release.drawEntity;
        mDrawScope$ui_release.drawEntity = this;
        CanvasDrawScope canvasDrawScope = mDrawScope$ui_release.canvasDrawScope;
        MeasureScope measureScope = layoutNodeWrapper.getMeasureScope();
        LayoutDirection layoutDirection = layoutNodeWrapper.getMeasureScope().getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
        Density density = drawParams.getDensity();
        LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
        Canvas canvas2 = drawParams.getCanvas();
        long size = drawParams.getSize();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
        drawParams2.setDensity(measureScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m2049setSizeuvyYCjk(jM4013toSizeozmzZPI);
        canvas.save();
        getModifier().draw(mDrawScope$ui_release);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
        drawParams3.setDensity(density);
        drawParams3.setLayoutDirection(layoutDirection2);
        drawParams3.setCanvas(canvas2);
        drawParams3.m2049setSizeuvyYCjk(size);
        mDrawScope$ui_release.drawEntity = drawEntity;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValid() {
        return getLayoutNodeWrapper().isAttached();
    }
}
