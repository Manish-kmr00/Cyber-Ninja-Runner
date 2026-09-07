package coil.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil.ImageLoader;
import coil.request.ImageRequest;
import coil.size.SizeResolver;
import com.json.mediationsdk.logger.IronSourceError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: SubcomposeAsyncImage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a»\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a¯\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2&\b\u0002\u0010\u001e\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2&\b\u0002\u0010!\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2&\b\u0002\u0010#\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001a\u0095\u0001\u0010*\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010\u001e\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010!\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010#\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003¢\u0006\u0002\u0010+\u001a[\u0010,\u001a\u00020\u0001*\u00020\u00192\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020.2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010/\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"SubcomposeAsyncImage", "", "model", "", "contentDescription", "", "imageLoader", "Lcoil/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "content", "Lcoil/compose/SubcomposeAsyncImageScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "SubcomposeAsyncImage-sKDTAoQ", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "loading", "Lkotlin/Function2;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "success", "Lcoil/compose/AsyncImagePainter$State$Success;", "error", "Lcoil/compose/AsyncImagePainter$State$Error;", "onLoading", "onSuccess", "onError", "SubcomposeAsyncImage-Q4Kwu38", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "contentOf", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function3;", "SubcomposeAsyncImageContent", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lcoil/compose/SubcomposeAsyncImageScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "coil-compose-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SubcomposeAsyncImageKt {
    /* JADX INFO: renamed from: SubcomposeAsyncImage-Q4Kwu38, reason: not valid java name */
    public static final void m4350SubcomposeAsyncImageQ4Kwu38(final Object obj, final String str, final ImageLoader imageLoader, Modifier modifier, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function5, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function6, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function2, Function1<? super AsyncImagePainter.State.Error, Unit> function3, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, final int i2, final int i3, final int i4) {
        int iM2127getDefaultFilterQualityfv9h1I;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(934816934);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubcomposeAsyncImage)P(9,3,7,10,8,14,5,12,13,11!1,4!,6:c#ui.graphics.FilterQuality)");
        final Modifier modifier2 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function7 = (i4 & 16) != 0 ? null : function4;
        final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function8 = (i4 & 32) != 0 ? null : function5;
        final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function9 = (i4 & 64) != 0 ? null : function6;
        final Function1<? super AsyncImagePainter.State.Loading, Unit> function10 = (i4 & 128) != 0 ? null : function1;
        final Function1<? super AsyncImagePainter.State.Success, Unit> function11 = (i4 & 256) != 0 ? null : function2;
        final Function1<? super AsyncImagePainter.State.Error, Unit> function12 = (i4 & 512) != 0 ? null : function3;
        final Alignment center = (i4 & 1024) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        final ContentScale fit = (i4 & 2048) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        final float f2 = (i4 & 4096) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 8192) != 0 ? null : colorFilter;
        if ((i4 & 16384) != 0) {
            i5 = i3 & (-57345);
            iM2127getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m2127getDefaultFilterQualityfv9h1I();
        } else {
            iM2127getDefaultFilterQualityfv9h1I = i;
            i5 = i3;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(934816934, i2, i5, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:49)");
        }
        int i6 = i5 << 18;
        m4351SubcomposeAsyncImagesKDTAoQ(obj, str, imageLoader, modifier2, null, UtilsKt.onStateOf(function10, function11, function12), center, fit, f2, colorFilter2, iM2127getDefaultFilterQualityfv9h1I, contentOf(function7, function8, function9), composerStartRestartGroup, (i2 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION | (i2 & 7168) | (i6 & 3670016) | (i6 & 29360128) | (i6 & 234881024) | (i6 & 1879048192), (i5 >> 12) & 14, 16);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final ColorFilter colorFilter3 = colorFilter2;
        final int i7 = iM2127getDefaultFilterQualityfv9h1I;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i8) {
                SubcomposeAsyncImageKt.m4350SubcomposeAsyncImageQ4Kwu38(obj, str, imageLoader, modifier2, function7, function8, function9, function10, function11, function12, center, fit, f2, colorFilter3, i7, composer2, i2 | 1, i3, i4);
            }
        });
    }

    /* JADX INFO: renamed from: SubcomposeAsyncImage-sKDTAoQ, reason: not valid java name */
    public static final void m4351SubcomposeAsyncImagesKDTAoQ(final Object obj, final String str, final ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function2, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, final Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2, final int i3, final int i4) {
        int iM2127getDefaultFilterQualityfv9h1I;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(10937794);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubcomposeAsyncImage)P(8,4,7,9,11,10!1,5!2,6:c#ui.graphics.FilterQuality)");
        Modifier modifier2 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function4 = (i4 & 32) != 0 ? null : function2;
        Alignment center = (i4 & 64) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i4 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i4 & 256) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 512) != 0 ? null : colorFilter;
        if ((i4 & 1024) != 0) {
            iM2127getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m2127getDefaultFilterQualityfv9h1I();
            i5 = i3 & (-15);
        } else {
            iM2127getDefaultFilterQualityfv9h1I = i;
            i5 = i3;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(10937794, i2, i5, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:104)");
        }
        ImageRequest imageRequestUpdateRequest = AsyncImageKt.updateRequest(UtilsKt.requestOf(obj, composerStartRestartGroup, 8), fit, composerStartRestartGroup, 8 | ((i2 >> 18) & 112));
        int i6 = i2 >> 6;
        int i7 = i2 >> 9;
        final int i8 = i5;
        final ContentScale contentScale2 = fit;
        final Alignment alignment2 = center;
        final AsyncImagePainter asyncImagePainterM4326rememberAsyncImagePainter5jETZwI = AsyncImagePainterKt.m4326rememberAsyncImagePainter5jETZwI(imageRequestUpdateRequest, imageLoader, defaultTransform, function4, fit, iM2127getDefaultFilterQualityfv9h1I, composerStartRestartGroup, (i6 & 7168) | (i6 & 896) | 72 | (i7 & 57344) | ((i5 << 15) & 458752), 0);
        final SizeResolver sizeResolver = imageRequestUpdateRequest.getSizeResolver();
        if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
            composerStartRestartGroup.startReplaceableGroup(-247979203);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(alignment2, true, composerStartRestartGroup, (((((i7 & 14) | 384) | ((i2 >> 15) & 112)) >> 3) & 14) | 48);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier2);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composerStartRestartGroup);
            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            function3.invoke(new RealSubcomposeAsyncImageScope(BoxScopeInstance.INSTANCE, asyncImagePainterM4326rememberAsyncImagePainter5jETZwI, str, alignment2, contentScale2, f2, colorFilter2), composerStartRestartGroup, Integer.valueOf(i8 & 112));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-247978567);
            final float f3 = f2;
            final ColorFilter colorFilter3 = colorFilter2;
            BoxWithConstraintsKt.BoxWithConstraints(modifier2, alignment2, true, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1964284792, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                    invoke(boxWithConstraintsScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i9) {
                    int i10;
                    if ((i9 & 14) == 0) {
                        i10 = (composer2.changed(boxWithConstraintsScope) ? 4 : 2) | i9;
                    } else {
                        i10 = i9;
                    }
                    if ((i10 & 91) != 18 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1964284792, i9, -1, "coil.compose.SubcomposeAsyncImage.<anonymous> (SubcomposeAsyncImage.kt:150)");
                        }
                        ((ConstraintsSizeResolver) sizeResolver).m4330setConstraintsBRTryo0(boxWithConstraintsScope.getConstraints());
                        function3.invoke(new RealSubcomposeAsyncImageScope(boxWithConstraintsScope, asyncImagePainterM4326rememberAsyncImagePainter5jETZwI, str, alignment2, contentScale2, f3, colorFilter3), composer2, Integer.valueOf(i8 & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, (i7 & 14) | 3456 | ((i2 >> 15) & 112), 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function5 = defaultTransform;
        final Function1<? super AsyncImagePainter.State, Unit> function6 = function4;
        final float f4 = f2;
        final ColorFilter colorFilter4 = colorFilter2;
        final int i9 = iM2127getDefaultFilterQualityfv9h1I;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i10) {
                SubcomposeAsyncImageKt.m4351SubcomposeAsyncImagesKDTAoQ(obj, str, imageLoader, modifier3, function5, function6, alignment2, contentScale2, f4, colorFilter4, i9, function3, composer2, i2 | 1, i3, i4);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0149 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x014b  */
    /* JADX WARN: Code duplicated, block: B:115:0x0152  */
    /* JADX WARN: Code duplicated, block: B:116:0x015b  */
    /* JADX WARN: Code duplicated, block: B:119:0x0161  */
    /* JADX WARN: Code duplicated, block: B:120:0x0168  */
    /* JADX WARN: Code duplicated, block: B:123:0x016d  */
    /* JADX WARN: Code duplicated, block: B:124:0x0174  */
    /* JADX WARN: Code duplicated, block: B:127:0x0179  */
    /* JADX WARN: Code duplicated, block: B:128:0x0180  */
    /* JADX WARN: Code duplicated, block: B:131:0x0185  */
    /* JADX WARN: Code duplicated, block: B:132:0x018c  */
    /* JADX WARN: Code duplicated, block: B:135:0x0191  */
    /* JADX WARN: Code duplicated, block: B:139:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:142:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:147:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    /* JADX WARN: Code duplicated, block: B:29:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0064  */
    /* JADX WARN: Code duplicated, block: B:34:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:44:0x0082  */
    /* JADX WARN: Code duplicated, block: B:45:0x0085  */
    /* JADX WARN: Code duplicated, block: B:48:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:55:0x009f  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:77:0x00db  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:88:0x0101  */
    /* JADX WARN: Code duplicated, block: B:90:0x0114  */
    public static final void SubcomposeAsyncImageContent(final SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        String str2;
        Alignment alignment2;
        ContentScale contentScale2;
        float f2;
        ColorFilter colorFilter2;
        final AsyncImagePainter painter2;
        String contentDescription;
        Alignment alignment3;
        ContentScale contentScale3;
        float alpha;
        int i5;
        float f3;
        ColorFilter colorFilter3;
        final float f4;
        final String str3;
        final Alignment alignment4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-263982313);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubcomposeAsyncImageContent)P(5,6,3!1,4)");
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(subcomposeAsyncImageScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 1;
        if (i7 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 2;
            if (i4 != 0) {
                i3 |= 128;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    str2 = str;
                    int i8 = composerStartRestartGroup.changed(str2) ? 2048 : 1024;
                    i3 |= i8;
                } else {
                    str2 = str;
                }
                i3 |= i8;
            } else {
                str2 = str;
            }
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    alignment2 = alignment;
                    int i9 = composerStartRestartGroup.changed(alignment2) ? 16384 : 8192;
                    i3 |= i9;
                } else {
                    alignment2 = alignment;
                }
                i3 |= i9;
            } else {
                alignment2 = alignment;
            }
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    contentScale2 = contentScale;
                    int i10 = composerStartRestartGroup.changed(contentScale2) ? 131072 : 65536;
                    i3 |= i10;
                } else {
                    contentScale2 = contentScale;
                }
                i3 |= i10;
            } else {
                contentScale2 = contentScale;
            }
            if ((i & 3670016) == 0) {
                f2 = f;
                if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(f2)) {
                    i6 = 524288;
                } else {
                    i6 = 1048576;
                }
                i3 |= i6;
            } else {
                f2 = f;
            }
            if ((i & 29360128) == 0) {
                if ((i2 & 128) == 0) {
                    colorFilter2 = colorFilter;
                    int i11 = composerStartRestartGroup.changed(colorFilter2) ? 8388608 : 4194304;
                    i3 |= i11;
                } else {
                    colorFilter2 = colorFilter;
                }
                i3 |= i11;
            } else {
                colorFilter2 = colorFilter;
            }
            if (i4 == 2 || (23967451 & i3) != 4793490 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        painter2 = subcomposeAsyncImageScope.getPainter();
                        i3 &= -897;
                    } else {
                        painter2 = painter;
                    }
                    if ((i2 & 4) != 0) {
                        contentDescription = subcomposeAsyncImageScope.getContentDescription();
                        i3 &= -7169;
                    } else {
                        contentDescription = str2;
                    }
                    if ((i2 & 8) != 0) {
                        alignment3 = subcomposeAsyncImageScope.getAlignment();
                        i3 &= -57345;
                    } else {
                        alignment3 = alignment2;
                    }
                    if ((i2 & 16) != 0) {
                        contentScale3 = subcomposeAsyncImageScope.getContentScale();
                        i3 &= -458753;
                    } else {
                        contentScale3 = contentScale2;
                    }
                    if ((i2 & 32) != 0) {
                        alpha = subcomposeAsyncImageScope.getAlpha();
                        i3 &= -3670017;
                    } else {
                        alpha = f2;
                    }
                    if ((i2 & 64) != 0) {
                        colorFilter2 = subcomposeAsyncImageScope.getColorFilter();
                        i3 &= -29360129;
                    }
                    i5 = i3;
                    f3 = alpha;
                    colorFilter3 = colorFilter2;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if (i4 != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -3670017;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -29360129;
                    }
                    painter2 = painter;
                    i5 = i3;
                    contentDescription = str2;
                    alignment3 = alignment2;
                    colorFilter3 = colorFilter2;
                    contentScale3 = contentScale2;
                    f3 = f2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-263982313, i5, -1, "coil.compose.SubcomposeAsyncImageContent (SubcomposeAsyncImage.kt:202)");
                }
                int i12 = i5 >> 3;
                AsyncImageKt.Content(modifier2, painter2, contentDescription, alignment3, contentScale3, f3, colorFilter3, composerStartRestartGroup, (i12 & 14) | 64 | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (i12 & 3670016));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorFilter2 = colorFilter3;
                Alignment alignment5 = alignment3;
                f4 = f3;
                str3 = contentDescription;
                alignment4 = alignment5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                painter2 = painter;
                str3 = str2;
                alignment4 = alignment2;
                contentScale3 = contentScale2;
                f4 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            final Modifier modifier3 = modifier2;
            final ContentScale contentScale4 = contentScale3;
            final ColorFilter colorFilter4 = colorFilter2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt.SubcomposeAsyncImageContent.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(subcomposeAsyncImageScope, modifier3, painter2, str3, alignment4, contentScale4, f4, colorFilter4, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 128;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                str2 = str;
                if (composerStartRestartGroup.changed(str2)) {
                }
                i3 |= i8;
            } else {
                str2 = str;
            }
            i3 |= i8;
        } else {
            str2 = str;
        }
        if ((i & 57344) == 0) {
            if ((i2 & 16) == 0) {
                alignment2 = alignment;
                if (composerStartRestartGroup.changed(alignment2)) {
                }
                i3 |= i9;
            } else {
                alignment2 = alignment;
            }
            i3 |= i9;
        } else {
            alignment2 = alignment;
        }
        if ((i & 458752) == 0) {
            if ((i2 & 32) == 0) {
                contentScale2 = contentScale;
                if (composerStartRestartGroup.changed(contentScale2)) {
                }
                i3 |= i10;
            } else {
                contentScale2 = contentScale;
            }
            i3 |= i10;
        } else {
            contentScale2 = contentScale;
        }
        if ((i & 3670016) == 0) {
            f2 = f;
            if ((i2 & 64) == 0) {
                i6 = 524288;
            } else {
                i6 = 524288;
            }
            i3 |= i6;
        } else {
            f2 = f;
        }
        if ((i & 29360128) == 0) {
            if ((i2 & 128) == 0) {
                colorFilter2 = colorFilter;
                if (composerStartRestartGroup.changed(colorFilter2)) {
                }
                i3 |= i11;
            } else {
                colorFilter2 = colorFilter;
            }
            i3 |= i11;
        } else {
            colorFilter2 = colorFilter;
        }
        if (i4 == 2) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    painter2 = subcomposeAsyncImageScope.getPainter();
                    i3 &= -897;
                } else {
                    painter2 = painter;
                }
                if ((i2 & 4) != 0) {
                    contentDescription = subcomposeAsyncImageScope.getContentDescription();
                    i3 &= -7169;
                } else {
                    contentDescription = str2;
                }
                if ((i2 & 8) != 0) {
                    alignment3 = subcomposeAsyncImageScope.getAlignment();
                    i3 &= -57345;
                } else {
                    alignment3 = alignment2;
                }
                if ((i2 & 16) != 0) {
                    contentScale3 = subcomposeAsyncImageScope.getContentScale();
                    i3 &= -458753;
                } else {
                    contentScale3 = contentScale2;
                }
                if ((i2 & 32) != 0) {
                    alpha = subcomposeAsyncImageScope.getAlpha();
                    i3 &= -3670017;
                } else {
                    alpha = f2;
                }
                if ((i2 & 64) != 0) {
                    colorFilter2 = subcomposeAsyncImageScope.getColorFilter();
                    i3 &= -29360129;
                }
                i5 = i3;
                f3 = alpha;
                colorFilter3 = colorFilter2;
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    painter2 = subcomposeAsyncImageScope.getPainter();
                    i3 &= -897;
                } else {
                    painter2 = painter;
                }
                if ((i2 & 4) != 0) {
                    contentDescription = subcomposeAsyncImageScope.getContentDescription();
                    i3 &= -7169;
                } else {
                    contentDescription = str2;
                }
                if ((i2 & 8) != 0) {
                    alignment3 = subcomposeAsyncImageScope.getAlignment();
                    i3 &= -57345;
                } else {
                    alignment3 = alignment2;
                }
                if ((i2 & 16) != 0) {
                    contentScale3 = subcomposeAsyncImageScope.getContentScale();
                    i3 &= -458753;
                } else {
                    contentScale3 = contentScale2;
                }
                if ((i2 & 32) != 0) {
                    alpha = subcomposeAsyncImageScope.getAlpha();
                    i3 &= -3670017;
                } else {
                    alpha = f2;
                }
                if ((i2 & 64) != 0) {
                    colorFilter2 = subcomposeAsyncImageScope.getColorFilter();
                    i3 &= -29360129;
                }
                i5 = i3;
                f3 = alpha;
                colorFilter3 = colorFilter2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-263982313, i5, -1, "coil.compose.SubcomposeAsyncImageContent (SubcomposeAsyncImage.kt:202)");
            }
            int i13 = i5 >> 3;
            AsyncImageKt.Content(modifier2, painter2, contentDescription, alignment3, contentScale3, f3, colorFilter3, composerStartRestartGroup, (i13 & 14) | 64 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (i13 & 3670016));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colorFilter2 = colorFilter3;
            Alignment alignment6 = alignment3;
            f4 = f3;
            str3 = contentDescription;
            alignment4 = alignment6;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    painter2 = subcomposeAsyncImageScope.getPainter();
                    i3 &= -897;
                } else {
                    painter2 = painter;
                }
                if ((i2 & 4) != 0) {
                    contentDescription = subcomposeAsyncImageScope.getContentDescription();
                    i3 &= -7169;
                } else {
                    contentDescription = str2;
                }
                if ((i2 & 8) != 0) {
                    alignment3 = subcomposeAsyncImageScope.getAlignment();
                    i3 &= -57345;
                } else {
                    alignment3 = alignment2;
                }
                if ((i2 & 16) != 0) {
                    contentScale3 = subcomposeAsyncImageScope.getContentScale();
                    i3 &= -458753;
                } else {
                    contentScale3 = contentScale2;
                }
                if ((i2 & 32) != 0) {
                    alpha = subcomposeAsyncImageScope.getAlpha();
                    i3 &= -3670017;
                } else {
                    alpha = f2;
                }
                if ((i2 & 64) != 0) {
                    colorFilter2 = subcomposeAsyncImageScope.getColorFilter();
                    i3 &= -29360129;
                }
                i5 = i3;
                f3 = alpha;
                colorFilter3 = colorFilter2;
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    painter2 = subcomposeAsyncImageScope.getPainter();
                    i3 &= -897;
                } else {
                    painter2 = painter;
                }
                if ((i2 & 4) != 0) {
                    contentDescription = subcomposeAsyncImageScope.getContentDescription();
                    i3 &= -7169;
                } else {
                    contentDescription = str2;
                }
                if ((i2 & 8) != 0) {
                    alignment3 = subcomposeAsyncImageScope.getAlignment();
                    i3 &= -57345;
                } else {
                    alignment3 = alignment2;
                }
                if ((i2 & 16) != 0) {
                    contentScale3 = subcomposeAsyncImageScope.getContentScale();
                    i3 &= -458753;
                } else {
                    contentScale3 = contentScale2;
                }
                if ((i2 & 32) != 0) {
                    alpha = subcomposeAsyncImageScope.getAlpha();
                    i3 &= -3670017;
                } else {
                    alpha = f2;
                }
                if ((i2 & 64) != 0) {
                    colorFilter2 = subcomposeAsyncImageScope.getColorFilter();
                    i3 &= -29360129;
                }
                i5 = i3;
                f3 = alpha;
                colorFilter3 = colorFilter2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-263982313, i5, -1, "coil.compose.SubcomposeAsyncImageContent (SubcomposeAsyncImage.kt:202)");
            }
            int i14 = i5 >> 3;
            AsyncImageKt.Content(modifier2, painter2, contentDescription, alignment3, contentScale3, f3, colorFilter3, composerStartRestartGroup, (i14 & 14) | 64 | (i14 & 896) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (i14 & 3670016));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colorFilter2 = colorFilter3;
            Alignment alignment7 = alignment3;
            f4 = f3;
            str3 = contentDescription;
            alignment4 = alignment7;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final ContentScale contentScale5 = contentScale3;
        final ColorFilter colorFilter5 = colorFilter2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt.SubcomposeAsyncImageContent.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i15) {
                SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(subcomposeAsyncImageScope, modifier4, painter2, str3, alignment4, contentScale5, f4, colorFilter5, composer2, i | 1, i2);
            }
        });
    }

    private static final Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf(final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function5, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function6) {
        return (function4 == null && function5 == null && function6 == null) ? ComposableSingletons$SubcomposeAsyncImageKt.INSTANCE.m4329getLambda1$coil_compose_base_release() : ComposableLambdaKt.composableLambdaInstance(-1302781228, true, new Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt.contentOf.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, Integer num) {
                invoke(subcomposeAsyncImageScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:46:0x00b8  */
            /* JADX WARN: Code duplicated, block: B:49:0x00ce  */
            /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
            public final void invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, int i) {
                int i2;
                if ((i & 14) == 0) {
                    i2 = (composer.changed(subcomposeAsyncImageScope) ? 4 : 2) | i;
                } else {
                    i2 = i;
                }
                if ((i2 & 91) != 18 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1302781228, i2, -1, "coil.compose.contentOf.<anonymous> (SubcomposeAsyncImage.kt:227)");
                    }
                    AsyncImagePainter.State state = subcomposeAsyncImageScope.getPainter().getState();
                    boolean z = false;
                    boolean z2 = true;
                    if (state instanceof AsyncImagePainter.State.Loading) {
                        composer.startReplaceableGroup(-418307549);
                        Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Loading, Composer, Integer, Unit> function7 = function4;
                        if (function7 != null) {
                            function7.invoke(subcomposeAsyncImageScope, (AsyncImagePainter.State.Loading) state, composer, Integer.valueOf((i2 & 14) | 64));
                            Unit unit = Unit.INSTANCE;
                        } else {
                            z = true;
                        }
                        composer.endReplaceableGroup();
                    } else {
                        if (!(state instanceof AsyncImagePainter.State.Success)) {
                            if (state instanceof AsyncImagePainter.State.Error) {
                                composer.startReplaceableGroup(-418307363);
                                Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Error, Composer, Integer, Unit> function8 = function6;
                                if (function8 != null) {
                                    function8.invoke(subcomposeAsyncImageScope, (AsyncImagePainter.State.Error) state, composer, Integer.valueOf((i2 & 14) | 64));
                                    Unit unit2 = Unit.INSTANCE;
                                } else {
                                    z = true;
                                }
                                composer.endReplaceableGroup();
                            } else if (state instanceof AsyncImagePainter.State.Empty) {
                                composer.startReplaceableGroup(-418307275);
                                composer.endReplaceableGroup();
                            } else {
                                composer.startReplaceableGroup(-418307215);
                                composer.endReplaceableGroup();
                            }
                            if (z2) {
                                SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, composer, i2 & 14, 127);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer.startReplaceableGroup(-418307455);
                        Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Success, Composer, Integer, Unit> function9 = function5;
                        if (function9 != null) {
                            function9.invoke(subcomposeAsyncImageScope, (AsyncImagePainter.State.Success) state, composer, Integer.valueOf((i2 & 14) | 64));
                            Unit unit3 = Unit.INSTANCE;
                        } else {
                            z = true;
                        }
                        composer.endReplaceableGroup();
                    }
                    z2 = z;
                    if (z2) {
                        SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, composer, i2 & 14, 127);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        });
    }
}
