package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.node.UiApplier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidView.android.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u000e\"\"\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"NoOpUpdate", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "AndroidView", "T", "factory", "Landroid/content/Context;", "modifier", "Landroidx/compose/ui/Modifier;", "update", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AndroidView_androidKt {
    private static final Function1<View, Unit> NoOpUpdate = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$NoOpUpdate$1
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics.checkNotNullParameter(view, "$this$null");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.INSTANCE;
        }
    };

    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0079 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:43:0x0081  */
    /* JADX WARN: Code duplicated, block: B:45:0x0084  */
    /* JADX WARN: Code duplicated, block: B:46:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:55:0x015b  */
    /* JADX WARN: Code duplicated, block: B:58:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:61:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:62:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:65:0x0232  */
    /* JADX WARN: Code duplicated, block: B:70:0x0249  */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    public static final <T extends View> void AndroidView(final Function1<? super Context, ? extends T> factory, Modifier modifier, Function1<? super T, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        int i4;
        Function1<? super T, Unit> function2;
        int i5;
        Modifier modifier3;
        Function1<? super T, Unit> function3;
        Object objRememberedValue;
        Object objRememberedValue2;
        final SaveableStateRegistry saveableStateRegistry;
        final String strValueOf;
        Object objRememberedValue3;
        final Ref ref;
        final Function0<LayoutNode> function0;
        final Function1<? super T, Unit> function4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(factory, "factory");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1783766393);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AndroidView)86@4146L7,89@4353L47,91@4503L37,98@5071L7,99@5126L7,100@5160L28,101@5240L7,102@5267L23,103@5333L40,109@5749L7,110@5820L7,112@5833L1313,140@7189L439:AndroidView.android.kt#z33iqn");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(factory) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changed(function2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i3 & 731) == 146 || !composerStartRestartGroup.getSkipping()) {
                    if (i6 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        function3 = NoOpUpdate;
                    } else {
                        function3 = function2;
                    }
                    ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localContext);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Context context = (Context) objConsume;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new NestedScrollConnection() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AndroidView_androidKt$AndroidView$noOpConnection$1$1 androidView_androidKt$AndroidView$noOpConnection$1$1 = (AndroidView_androidKt$AndroidView$noOpConnection$1$1) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new NestedScrollDispatcher();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final NestedScrollDispatcher nestedScrollDispatcher = (NestedScrollDispatcher) objRememberedValue2;
                    Modifier modifierMaterialize = ComposedModifierKt.materialize(composerStartRestartGroup, SemanticsModifierKt.semantics(modifier3.then(NestedScrollModifierKt.nestedScroll(Modifier.INSTANCE, androidView_androidKt$AndroidView$noOpConnection$1$1, nestedScrollDispatcher)), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$modifierWithSemantics$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    }));
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density = (Density) objConsume2;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection = (LayoutDirection) objConsume3;
                    final CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                    ProvidableCompositionLocal<SaveableStateRegistry> localSaveableStateRegistry = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localSaveableStateRegistry);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    saveableStateRegistry = (SaveableStateRegistry) objConsume4;
                    strValueOf = String.valueOf(ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0));
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Ref();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    ref = (Ref) objRememberedValue3;
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localLifecycleOwner);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LifecycleOwner lifecycleOwner = (LifecycleOwner) objConsume5;
                    ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localSavedStateRegistryOwner);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume6;
                    function0 = new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        /* JADX WARN: Type inference incomplete: some casts might be missing */
                        @Override // kotlin.jvm.functions.Function0
                        public final LayoutNode invoke() {
                            View typedView$ui_release;
                            ViewFactoryHolder viewFactoryHolder = new ViewFactoryHolder(context, compositionContextRememberCompositionContext, nestedScrollDispatcher);
                            viewFactoryHolder.setFactory(factory);
                            SaveableStateRegistry saveableStateRegistry2 = saveableStateRegistry;
                            Object objConsumeRestored = saveableStateRegistry2 != null ? saveableStateRegistry2.consumeRestored(strValueOf) : null;
                            SparseArray<Parcelable> sparseArray = objConsumeRestored instanceof SparseArray ? (SparseArray) objConsumeRestored : null;
                            if (sparseArray != null && (typedView$ui_release = viewFactoryHolder.getTypedView$ui_release()) != null) {
                                typedView$ui_release.restoreHierarchyState(sparseArray);
                            }
                            ref.setValue((ViewFactoryHolder<T>) viewFactoryHolder);
                            return viewFactoryHolder.getLayoutNode();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.LayoutNode, java.lang.Object] */
                            @Override // kotlin.jvm.functions.Function0
                            public final LayoutNode invoke() {
                                return function0.invoke();
                            }
                        });
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl, modifierMaterialize, new Function2<LayoutNode, Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Modifier modifier4) {
                            invoke2(layoutNode, modifier4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutNode set, Modifier it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            Object value = ref.getValue();
                            Intrinsics.checkNotNull(value);
                            ((ViewFactoryHolder) value).setModifier(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl, density, new Function2<LayoutNode, Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Density density2) {
                            invoke2(layoutNode, density2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutNode set, Density it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            Object value = ref.getValue();
                            Intrinsics.checkNotNull(value);
                            ((ViewFactoryHolder) value).setDensity(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl, lifecycleOwner, new Function2<LayoutNode, LifecycleOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LifecycleOwner lifecycleOwner2) {
                            invoke2(layoutNode, lifecycleOwner2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutNode set, LifecycleOwner it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            Object value = ref.getValue();
                            Intrinsics.checkNotNull(value);
                            ((ViewFactoryHolder) value).setLifecycleOwner(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl, savedStateRegistryOwner, new Function2<LayoutNode, SavedStateRegistryOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner2) {
                            invoke2(layoutNode, savedStateRegistryOwner2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutNode set, SavedStateRegistryOwner it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            Object value = ref.getValue();
                            Intrinsics.checkNotNull(value);
                            ((ViewFactoryHolder) value).setSavedStateRegistryOwner(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl, function3, (Function2<? super T, ? super Function1<? super T, Unit>, Unit>) new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                            invoke(layoutNode, (Function1) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LayoutNode set, Function1<? super T, Unit> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            ViewFactoryHolder<T> value = ref.getValue();
                            Intrinsics.checkNotNull(value);
                            value.setUpdateBlock(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, new Function2<LayoutNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$6

                        /* JADX INFO: compiled from: AndroidView.android.kt */
                        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                        public /* synthetic */ class WhenMappings {
                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                            static {
                                int[] iArr = new int[LayoutDirection.values().length];
                                iArr[LayoutDirection.Ltr.ordinal()] = 1;
                                iArr[LayoutDirection.Rtl.ordinal()] = 2;
                                $EnumSwitchMapping$0 = iArr;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LayoutDirection layoutDirection2) {
                            invoke2(layoutNode, layoutDirection2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutNode set, LayoutDirection it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            Object value = ref.getValue();
                            Intrinsics.checkNotNull(value);
                            ViewFactoryHolder viewFactoryHolder = (ViewFactoryHolder) value;
                            int i7 = WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
                            int i8 = 1;
                            if (i7 == 1) {
                                i8 = 0;
                            } else if (i7 != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            viewFactoryHolder.setLayoutDirection(i8);
                        }
                    });
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (saveableStateRegistry != null) {
                        EffectsKt.DisposableEffect(saveableStateRegistry, strValueOf, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                final Ref<ViewFactoryHolder<T>> ref2 = ref;
                                final SaveableStateRegistry.Entry entryRegisterProvider = saveableStateRegistry.registerProvider(strValueOf, new Function0<SparseArray<Parcelable>>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$valueProvider$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final SparseArray<Parcelable> invoke() {
                                        SparseArray<Parcelable> sparseArray = new SparseArray<>();
                                        Object value = ref2.getValue();
                                        Intrinsics.checkNotNull(value);
                                        View typedView$ui_release = ((ViewFactoryHolder) value).getTypedView$ui_release();
                                        if (typedView$ui_release != null) {
                                            typedView$ui_release.saveHierarchyState(sparseArray);
                                        }
                                        return sparseArray;
                                    }
                                });
                                return new DisposableEffectResult() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        entryRegisterProvider.unregister();
                                    }
                                };
                            }
                        }, composerStartRestartGroup, 8);
                    }
                    modifier2 = modifier3;
                    function4 = function3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function4 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.4
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

                    public final void invoke(Composer composer2, int i7) {
                        AndroidView_androidKt.AndroidView(factory, modifier2, function4, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 384;
            function2 = function1;
            if ((i3 & 731) == 146) {
                if (i6 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    function3 = NoOpUpdate;
                } else {
                    function3 = function2;
                }
                ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localContext2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Context context2 = (Context) objConsume7;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new NestedScrollConnection() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AndroidView_androidKt$AndroidView$noOpConnection$1$1 androidView_androidKt$AndroidView$noOpConnection$1$2 = (AndroidView_androidKt$AndroidView$noOpConnection$1$1) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new NestedScrollDispatcher();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                final NestedScrollDispatcher nestedScrollDispatcher2 = (NestedScrollDispatcher) objRememberedValue2;
                Modifier modifierMaterialize2 = ComposedModifierKt.materialize(composerStartRestartGroup, SemanticsModifierKt.semantics(modifier3.then(NestedScrollModifierKt.nestedScroll(Modifier.INSTANCE, androidView_androidKt$AndroidView$noOpConnection$1$2, nestedScrollDispatcher2)), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$modifierWithSemantics$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                }));
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density2 = (Density) objConsume8;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume9 = composerStartRestartGroup.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection2 = (LayoutDirection) objConsume9;
                final CompositionContext compositionContextRememberCompositionContext2 = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                ProvidableCompositionLocal<SaveableStateRegistry> localSaveableStateRegistry2 = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume10 = composerStartRestartGroup.consume(localSaveableStateRegistry2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                saveableStateRegistry = (SaveableStateRegistry) objConsume10;
                strValueOf = String.valueOf(ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Ref();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                ref = (Ref) objRememberedValue3;
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner2 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11 = composerStartRestartGroup.consume(localLifecycleOwner2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LifecycleOwner lifecycleOwner2 = (LifecycleOwner) objConsume11;
                ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner2 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume12 = composerStartRestartGroup.consume(localSavedStateRegistryOwner2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SavedStateRegistryOwner savedStateRegistryOwner2 = (SavedStateRegistryOwner) objConsume12;
                function0 = new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    @Override // kotlin.jvm.functions.Function0
                    public final LayoutNode invoke() {
                        View typedView$ui_release;
                        ViewFactoryHolder viewFactoryHolder = new ViewFactoryHolder(context2, compositionContextRememberCompositionContext2, nestedScrollDispatcher2);
                        viewFactoryHolder.setFactory(factory);
                        SaveableStateRegistry saveableStateRegistry2 = saveableStateRegistry;
                        Object objConsumeRestored = saveableStateRegistry2 != null ? saveableStateRegistry2.consumeRestored(strValueOf) : null;
                        SparseArray<Parcelable> sparseArray = objConsumeRestored instanceof SparseArray ? (SparseArray) objConsumeRestored : null;
                        if (sparseArray != null && (typedView$ui_release = viewFactoryHolder.getTypedView$ui_release()) != null) {
                            typedView$ui_release.restoreHierarchyState(sparseArray);
                        }
                        ref.setValue((ViewFactoryHolder<T>) viewFactoryHolder);
                        return viewFactoryHolder.getLayoutNode();
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(1886828752);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode):Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.LayoutNode, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        public final LayoutNode invoke() {
                            return function0.invoke();
                        }
                    });
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl2, modifierMaterialize2, new Function2<LayoutNode, Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Modifier modifier4) {
                        invoke2(layoutNode, modifier4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, Modifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setModifier(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl2, density2, new Function2<LayoutNode, Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Density density3) {
                        invoke2(layoutNode, density3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, Density it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setDensity(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl2, lifecycleOwner2, new Function2<LayoutNode, LifecycleOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LifecycleOwner lifecycleOwner3) {
                        invoke2(layoutNode, lifecycleOwner3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, LifecycleOwner it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setLifecycleOwner(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl2, savedStateRegistryOwner2, new Function2<LayoutNode, SavedStateRegistryOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner3) {
                        invoke2(layoutNode, savedStateRegistryOwner3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, SavedStateRegistryOwner it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setSavedStateRegistryOwner(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl2, function3, (Function2<? super T, ? super Function1<? super T, Unit>, Unit>) new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                        invoke(layoutNode, (Function1) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LayoutNode set, Function1<? super T, Unit> it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        ViewFactoryHolder<T> value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        value.setUpdateBlock(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, new Function2<LayoutNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$6

                    /* JADX INFO: compiled from: AndroidView.android.kt */
                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[LayoutDirection.values().length];
                            iArr[LayoutDirection.Ltr.ordinal()] = 1;
                            iArr[LayoutDirection.Rtl.ordinal()] = 2;
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LayoutDirection layoutDirection3) {
                        invoke2(layoutNode, layoutDirection3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, LayoutDirection it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ViewFactoryHolder viewFactoryHolder = (ViewFactoryHolder) value;
                        int i7 = WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
                        int i8 = 1;
                        if (i7 == 1) {
                            i8 = 0;
                        } else if (i7 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        viewFactoryHolder.setLayoutDirection(i8);
                    }
                });
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (saveableStateRegistry != null) {
                    EffectsKt.DisposableEffect(saveableStateRegistry, strValueOf, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            final Ref<ViewFactoryHolder<T>> ref2 = ref;
                            final SaveableStateRegistry.Entry entryRegisterProvider = saveableStateRegistry.registerProvider(strValueOf, new Function0<SparseArray<Parcelable>>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$valueProvider$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final SparseArray<Parcelable> invoke() {
                                    SparseArray<Parcelable> sparseArray = new SparseArray<>();
                                    Object value = ref2.getValue();
                                    Intrinsics.checkNotNull(value);
                                    View typedView$ui_release = ((ViewFactoryHolder) value).getTypedView$ui_release();
                                    if (typedView$ui_release != null) {
                                        typedView$ui_release.saveHierarchyState(sparseArray);
                                    }
                                    return sparseArray;
                                }
                            });
                            return new DisposableEffectResult() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    entryRegisterProvider.unregister();
                                }
                            };
                        }
                    }, composerStartRestartGroup, 8);
                }
                modifier2 = modifier3;
                function4 = function3;
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    function3 = NoOpUpdate;
                } else {
                    function3 = function2;
                }
                ProvidableCompositionLocal<Context> localContext3 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume13 = composerStartRestartGroup.consume(localContext3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Context context3 = (Context) objConsume13;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new NestedScrollConnection() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AndroidView_androidKt$AndroidView$noOpConnection$1$1 androidView_androidKt$AndroidView$noOpConnection$1$3 = (AndroidView_androidKt$AndroidView$noOpConnection$1$1) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new NestedScrollDispatcher();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                final NestedScrollDispatcher nestedScrollDispatcher3 = (NestedScrollDispatcher) objRememberedValue2;
                Modifier modifierMaterialize3 = ComposedModifierKt.materialize(composerStartRestartGroup, SemanticsModifierKt.semantics(modifier3.then(NestedScrollModifierKt.nestedScroll(Modifier.INSTANCE, androidView_androidKt$AndroidView$noOpConnection$1$3, nestedScrollDispatcher3)), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$modifierWithSemantics$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                }));
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume14 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density3 = (Density) objConsume14;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume15 = composerStartRestartGroup.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection3 = (LayoutDirection) objConsume15;
                final CompositionContext compositionContextRememberCompositionContext3 = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                ProvidableCompositionLocal<SaveableStateRegistry> localSaveableStateRegistry3 = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume16 = composerStartRestartGroup.consume(localSaveableStateRegistry3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                saveableStateRegistry = (SaveableStateRegistry) objConsume16;
                strValueOf = String.valueOf(ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Ref();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                ref = (Ref) objRememberedValue3;
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner3 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume17 = composerStartRestartGroup.consume(localLifecycleOwner3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LifecycleOwner lifecycleOwner3 = (LifecycleOwner) objConsume17;
                ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner3 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume18 = composerStartRestartGroup.consume(localSavedStateRegistryOwner3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SavedStateRegistryOwner savedStateRegistryOwner3 = (SavedStateRegistryOwner) objConsume18;
                function0 = new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    @Override // kotlin.jvm.functions.Function0
                    public final LayoutNode invoke() {
                        View typedView$ui_release;
                        ViewFactoryHolder viewFactoryHolder = new ViewFactoryHolder(context3, compositionContextRememberCompositionContext3, nestedScrollDispatcher3);
                        viewFactoryHolder.setFactory(factory);
                        SaveableStateRegistry saveableStateRegistry2 = saveableStateRegistry;
                        Object objConsumeRestored = saveableStateRegistry2 != null ? saveableStateRegistry2.consumeRestored(strValueOf) : null;
                        SparseArray<Parcelable> sparseArray = objConsumeRestored instanceof SparseArray ? (SparseArray) objConsumeRestored : null;
                        if (sparseArray != null && (typedView$ui_release = viewFactoryHolder.getTypedView$ui_release()) != null) {
                            typedView$ui_release.restoreHierarchyState(sparseArray);
                        }
                        ref.setValue((ViewFactoryHolder<T>) viewFactoryHolder);
                        return viewFactoryHolder.getLayoutNode();
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(1886828752);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode):Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.LayoutNode, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        public final LayoutNode invoke() {
                            return function0.invoke();
                        }
                    });
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl3, modifierMaterialize3, new Function2<LayoutNode, Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Modifier modifier4) {
                        invoke2(layoutNode, modifier4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, Modifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setModifier(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl3, density3, new Function2<LayoutNode, Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Density density4) {
                        invoke2(layoutNode, density4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, Density it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setDensity(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl3, lifecycleOwner3, new Function2<LayoutNode, LifecycleOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LifecycleOwner lifecycleOwner4) {
                        invoke2(layoutNode, lifecycleOwner4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, LifecycleOwner it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setLifecycleOwner(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl3, savedStateRegistryOwner3, new Function2<LayoutNode, SavedStateRegistryOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner4) {
                        invoke2(layoutNode, savedStateRegistryOwner4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, SavedStateRegistryOwner it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setSavedStateRegistryOwner(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl3, function3, (Function2<? super T, ? super Function1<? super T, Unit>, Unit>) new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                        invoke(layoutNode, (Function1) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LayoutNode set, Function1<? super T, Unit> it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        ViewFactoryHolder<T> value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        value.setUpdateBlock(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, new Function2<LayoutNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$6

                    /* JADX INFO: compiled from: AndroidView.android.kt */
                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[LayoutDirection.values().length];
                            iArr[LayoutDirection.Ltr.ordinal()] = 1;
                            iArr[LayoutDirection.Rtl.ordinal()] = 2;
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LayoutDirection layoutDirection4) {
                        invoke2(layoutNode, layoutDirection4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, LayoutDirection it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ViewFactoryHolder viewFactoryHolder = (ViewFactoryHolder) value;
                        int i7 = WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
                        int i8 = 1;
                        if (i7 == 1) {
                            i8 = 0;
                        } else if (i7 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        viewFactoryHolder.setLayoutDirection(i8);
                    }
                });
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (saveableStateRegistry != null) {
                    EffectsKt.DisposableEffect(saveableStateRegistry, strValueOf, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            final Ref<ViewFactoryHolder<T>> ref2 = ref;
                            final SaveableStateRegistry.Entry entryRegisterProvider = saveableStateRegistry.registerProvider(strValueOf, new Function0<SparseArray<Parcelable>>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$valueProvider$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final SparseArray<Parcelable> invoke() {
                                    SparseArray<Parcelable> sparseArray = new SparseArray<>();
                                    Object value = ref2.getValue();
                                    Intrinsics.checkNotNull(value);
                                    View typedView$ui_release = ((ViewFactoryHolder) value).getTypedView$ui_release();
                                    if (typedView$ui_release != null) {
                                        typedView$ui_release.saveHierarchyState(sparseArray);
                                    }
                                    return sparseArray;
                                }
                            });
                            return new DisposableEffectResult() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    entryRegisterProvider.unregister();
                                }
                            };
                        }
                    }, composerStartRestartGroup, 8);
                }
                modifier2 = modifier3;
                function4 = function3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.4
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

                public final void invoke(Composer composer2, int i7) {
                    AndroidView_androidKt.AndroidView(factory, modifier2, function4, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changed(function2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i3 & 731) == 146) {
                if (i6 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    function3 = NoOpUpdate;
                } else {
                    function3 = function2;
                }
                ProvidableCompositionLocal<Context> localContext4 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume19 = composerStartRestartGroup.consume(localContext4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Context context4 = (Context) objConsume19;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new NestedScrollConnection() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AndroidView_androidKt$AndroidView$noOpConnection$1$1 androidView_androidKt$AndroidView$noOpConnection$1$4 = (AndroidView_androidKt$AndroidView$noOpConnection$1$1) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new NestedScrollDispatcher();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                final NestedScrollDispatcher nestedScrollDispatcher4 = (NestedScrollDispatcher) objRememberedValue2;
                Modifier modifierMaterialize4 = ComposedModifierKt.materialize(composerStartRestartGroup, SemanticsModifierKt.semantics(modifier3.then(NestedScrollModifierKt.nestedScroll(Modifier.INSTANCE, androidView_androidKt$AndroidView$noOpConnection$1$4, nestedScrollDispatcher4)), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$modifierWithSemantics$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                }));
                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume110 = composerStartRestartGroup.consume(localDensity4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density4 = (Density) objConsume110;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111 = composerStartRestartGroup.consume(localLayoutDirection4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection4 = (LayoutDirection) objConsume111;
                final CompositionContext compositionContextRememberCompositionContext4 = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                ProvidableCompositionLocal<SaveableStateRegistry> localSaveableStateRegistry4 = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume112 = composerStartRestartGroup.consume(localSaveableStateRegistry4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                saveableStateRegistry = (SaveableStateRegistry) objConsume112;
                strValueOf = String.valueOf(ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Ref();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                ref = (Ref) objRememberedValue3;
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner4 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume113 = composerStartRestartGroup.consume(localLifecycleOwner4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LifecycleOwner lifecycleOwner4 = (LifecycleOwner) objConsume113;
                ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner4 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume114 = composerStartRestartGroup.consume(localSavedStateRegistryOwner4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SavedStateRegistryOwner savedStateRegistryOwner4 = (SavedStateRegistryOwner) objConsume114;
                function0 = new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    @Override // kotlin.jvm.functions.Function0
                    public final LayoutNode invoke() {
                        View typedView$ui_release;
                        ViewFactoryHolder viewFactoryHolder = new ViewFactoryHolder(context4, compositionContextRememberCompositionContext4, nestedScrollDispatcher4);
                        viewFactoryHolder.setFactory(factory);
                        SaveableStateRegistry saveableStateRegistry2 = saveableStateRegistry;
                        Object objConsumeRestored = saveableStateRegistry2 != null ? saveableStateRegistry2.consumeRestored(strValueOf) : null;
                        SparseArray<Parcelable> sparseArray = objConsumeRestored instanceof SparseArray ? (SparseArray) objConsumeRestored : null;
                        if (sparseArray != null && (typedView$ui_release = viewFactoryHolder.getTypedView$ui_release()) != null) {
                            typedView$ui_release.restoreHierarchyState(sparseArray);
                        }
                        ref.setValue((ViewFactoryHolder<T>) viewFactoryHolder);
                        return viewFactoryHolder.getLayoutNode();
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(1886828752);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode):Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.LayoutNode, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        public final LayoutNode invoke() {
                            return function0.invoke();
                        }
                    });
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM1286constructorimpl4 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl4, modifierMaterialize4, new Function2<LayoutNode, Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Modifier modifier4) {
                        invoke2(layoutNode, modifier4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, Modifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setModifier(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl4, density4, new Function2<LayoutNode, Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Density density5) {
                        invoke2(layoutNode, density5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, Density it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setDensity(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl4, lifecycleOwner4, new Function2<LayoutNode, LifecycleOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LifecycleOwner lifecycleOwner5) {
                        invoke2(layoutNode, lifecycleOwner5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, LifecycleOwner it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setLifecycleOwner(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl4, savedStateRegistryOwner4, new Function2<LayoutNode, SavedStateRegistryOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner5) {
                        invoke2(layoutNode, savedStateRegistryOwner5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, SavedStateRegistryOwner it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setSavedStateRegistryOwner(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl4, function3, (Function2<? super T, ? super Function1<? super T, Unit>, Unit>) new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                        invoke(layoutNode, (Function1) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LayoutNode set, Function1<? super T, Unit> it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        ViewFactoryHolder<T> value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        value.setUpdateBlock(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl4, layoutDirection4, new Function2<LayoutNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$6

                    /* JADX INFO: compiled from: AndroidView.android.kt */
                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[LayoutDirection.values().length];
                            iArr[LayoutDirection.Ltr.ordinal()] = 1;
                            iArr[LayoutDirection.Rtl.ordinal()] = 2;
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LayoutDirection layoutDirection5) {
                        invoke2(layoutNode, layoutDirection5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, LayoutDirection it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ViewFactoryHolder viewFactoryHolder = (ViewFactoryHolder) value;
                        int i7 = WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
                        int i8 = 1;
                        if (i7 == 1) {
                            i8 = 0;
                        } else if (i7 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        viewFactoryHolder.setLayoutDirection(i8);
                    }
                });
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (saveableStateRegistry != null) {
                    EffectsKt.DisposableEffect(saveableStateRegistry, strValueOf, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            final Ref<ViewFactoryHolder<T>> ref2 = ref;
                            final SaveableStateRegistry.Entry entryRegisterProvider = saveableStateRegistry.registerProvider(strValueOf, new Function0<SparseArray<Parcelable>>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$valueProvider$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final SparseArray<Parcelable> invoke() {
                                    SparseArray<Parcelable> sparseArray = new SparseArray<>();
                                    Object value = ref2.getValue();
                                    Intrinsics.checkNotNull(value);
                                    View typedView$ui_release = ((ViewFactoryHolder) value).getTypedView$ui_release();
                                    if (typedView$ui_release != null) {
                                        typedView$ui_release.saveHierarchyState(sparseArray);
                                    }
                                    return sparseArray;
                                }
                            });
                            return new DisposableEffectResult() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    entryRegisterProvider.unregister();
                                }
                            };
                        }
                    }, composerStartRestartGroup, 8);
                }
                modifier2 = modifier3;
                function4 = function3;
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    function3 = NoOpUpdate;
                } else {
                    function3 = function2;
                }
                ProvidableCompositionLocal<Context> localContext5 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume115 = composerStartRestartGroup.consume(localContext5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Context context5 = (Context) objConsume115;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new NestedScrollConnection() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AndroidView_androidKt$AndroidView$noOpConnection$1$1 androidView_androidKt$AndroidView$noOpConnection$1$5 = (AndroidView_androidKt$AndroidView$noOpConnection$1$1) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new NestedScrollDispatcher();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                final NestedScrollDispatcher nestedScrollDispatcher5 = (NestedScrollDispatcher) objRememberedValue2;
                Modifier modifierMaterialize5 = ComposedModifierKt.materialize(composerStartRestartGroup, SemanticsModifierKt.semantics(modifier3.then(NestedScrollModifierKt.nestedScroll(Modifier.INSTANCE, androidView_androidKt$AndroidView$noOpConnection$1$5, nestedScrollDispatcher5)), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$modifierWithSemantics$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                }));
                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume116 = composerStartRestartGroup.consume(localDensity5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density5 = (Density) objConsume116;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume117 = composerStartRestartGroup.consume(localLayoutDirection5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection5 = (LayoutDirection) objConsume117;
                final CompositionContext compositionContextRememberCompositionContext5 = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                ProvidableCompositionLocal<SaveableStateRegistry> localSaveableStateRegistry5 = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume118 = composerStartRestartGroup.consume(localSaveableStateRegistry5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                saveableStateRegistry = (SaveableStateRegistry) objConsume118;
                strValueOf = String.valueOf(ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Ref();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                ref = (Ref) objRememberedValue3;
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner5 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume119 = composerStartRestartGroup.consume(localLifecycleOwner5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LifecycleOwner lifecycleOwner5 = (LifecycleOwner) objConsume119;
                ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner5 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1110 = composerStartRestartGroup.consume(localSavedStateRegistryOwner5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SavedStateRegistryOwner savedStateRegistryOwner5 = (SavedStateRegistryOwner) objConsume1110;
                function0 = new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    @Override // kotlin.jvm.functions.Function0
                    public final LayoutNode invoke() {
                        View typedView$ui_release;
                        ViewFactoryHolder viewFactoryHolder = new ViewFactoryHolder(context5, compositionContextRememberCompositionContext5, nestedScrollDispatcher5);
                        viewFactoryHolder.setFactory(factory);
                        SaveableStateRegistry saveableStateRegistry2 = saveableStateRegistry;
                        Object objConsumeRestored = saveableStateRegistry2 != null ? saveableStateRegistry2.consumeRestored(strValueOf) : null;
                        SparseArray<Parcelable> sparseArray = objConsumeRestored instanceof SparseArray ? (SparseArray) objConsumeRestored : null;
                        if (sparseArray != null && (typedView$ui_release = viewFactoryHolder.getTypedView$ui_release()) != null) {
                            typedView$ui_release.restoreHierarchyState(sparseArray);
                        }
                        ref.setValue((ViewFactoryHolder<T>) viewFactoryHolder);
                        return viewFactoryHolder.getLayoutNode();
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(1886828752);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode):Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.LayoutNode, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        public final LayoutNode invoke() {
                            return function0.invoke();
                        }
                    });
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM1286constructorimpl5 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl5, modifierMaterialize5, new Function2<LayoutNode, Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Modifier modifier4) {
                        invoke2(layoutNode, modifier4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, Modifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setModifier(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl5, density5, new Function2<LayoutNode, Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Density density6) {
                        invoke2(layoutNode, density6);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, Density it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setDensity(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl5, lifecycleOwner5, new Function2<LayoutNode, LifecycleOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LifecycleOwner lifecycleOwner6) {
                        invoke2(layoutNode, lifecycleOwner6);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, LifecycleOwner it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setLifecycleOwner(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl5, savedStateRegistryOwner5, new Function2<LayoutNode, SavedStateRegistryOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner6) {
                        invoke2(layoutNode, savedStateRegistryOwner6);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, SavedStateRegistryOwner it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ((ViewFactoryHolder) value).setSavedStateRegistryOwner(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl5, function3, (Function2<? super T, ? super Function1<? super T, Unit>, Unit>) new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                        invoke(layoutNode, (Function1) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LayoutNode set, Function1<? super T, Unit> it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        ViewFactoryHolder<T> value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        value.setUpdateBlock(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl5, layoutDirection5, new Function2<LayoutNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$6

                    /* JADX INFO: compiled from: AndroidView.android.kt */
                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[LayoutDirection.values().length];
                            iArr[LayoutDirection.Ltr.ordinal()] = 1;
                            iArr[LayoutDirection.Rtl.ordinal()] = 2;
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LayoutDirection layoutDirection6) {
                        invoke2(layoutNode, layoutDirection6);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutNode set, LayoutDirection it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object value = ref.getValue();
                        Intrinsics.checkNotNull(value);
                        ViewFactoryHolder viewFactoryHolder = (ViewFactoryHolder) value;
                        int i7 = WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
                        int i8 = 1;
                        if (i7 == 1) {
                            i8 = 0;
                        } else if (i7 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        viewFactoryHolder.setLayoutDirection(i8);
                    }
                });
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (saveableStateRegistry != null) {
                    EffectsKt.DisposableEffect(saveableStateRegistry, strValueOf, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            final Ref<ViewFactoryHolder<T>> ref2 = ref;
                            final SaveableStateRegistry.Entry entryRegisterProvider = saveableStateRegistry.registerProvider(strValueOf, new Function0<SparseArray<Parcelable>>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$valueProvider$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final SparseArray<Parcelable> invoke() {
                                    SparseArray<Parcelable> sparseArray = new SparseArray<>();
                                    Object value = ref2.getValue();
                                    Intrinsics.checkNotNull(value);
                                    View typedView$ui_release = ((ViewFactoryHolder) value).getTypedView$ui_release();
                                    if (typedView$ui_release != null) {
                                        typedView$ui_release.saveHierarchyState(sparseArray);
                                    }
                                    return sparseArray;
                                }
                            });
                            return new DisposableEffectResult() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    entryRegisterProvider.unregister();
                                }
                            };
                        }
                    }, composerStartRestartGroup, 8);
                }
                modifier2 = modifier3;
                function4 = function3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.4
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

                public final void invoke(Composer composer2, int i7) {
                    AndroidView_androidKt.AndroidView(factory, modifier2, function4, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        function2 = function1;
        if ((i3 & 731) == 146) {
            if (i6 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                function3 = NoOpUpdate;
            } else {
                function3 = function2;
            }
            ProvidableCompositionLocal<Context> localContext6 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111 = composerStartRestartGroup.consume(localContext6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context6 = (Context) objConsume1111;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new NestedScrollConnection() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            AndroidView_androidKt$AndroidView$noOpConnection$1$1 androidView_androidKt$AndroidView$noOpConnection$1$6 = (AndroidView_androidKt$AndroidView$noOpConnection$1$1) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new NestedScrollDispatcher();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            final NestedScrollDispatcher nestedScrollDispatcher6 = (NestedScrollDispatcher) objRememberedValue2;
            Modifier modifierMaterialize6 = ComposedModifierKt.materialize(composerStartRestartGroup, SemanticsModifierKt.semantics(modifier3.then(NestedScrollModifierKt.nestedScroll(Modifier.INSTANCE, androidView_androidKt$AndroidView$noOpConnection$1$6, nestedScrollDispatcher6)), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$modifierWithSemantics$1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }
            }));
            ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1112 = composerStartRestartGroup.consume(localDensity6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density6 = (Density) objConsume1112;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1113 = composerStartRestartGroup.consume(localLayoutDirection6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection6 = (LayoutDirection) objConsume1113;
            final CompositionContext compositionContextRememberCompositionContext6 = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            ProvidableCompositionLocal<SaveableStateRegistry> localSaveableStateRegistry6 = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1114 = composerStartRestartGroup.consume(localSaveableStateRegistry6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            saveableStateRegistry = (SaveableStateRegistry) objConsume1114;
            strValueOf = String.valueOf(ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0));
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Ref();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ref = (Ref) objRememberedValue3;
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner6 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1115 = composerStartRestartGroup.consume(localLifecycleOwner6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LifecycleOwner lifecycleOwner6 = (LifecycleOwner) objConsume1115;
            ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner6 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1116 = composerStartRestartGroup.consume(localSavedStateRegistryOwner6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SavedStateRegistryOwner savedStateRegistryOwner6 = (SavedStateRegistryOwner) objConsume1116;
            function0 = new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference incomplete: some casts might be missing */
                @Override // kotlin.jvm.functions.Function0
                public final LayoutNode invoke() {
                    View typedView$ui_release;
                    ViewFactoryHolder viewFactoryHolder = new ViewFactoryHolder(context6, compositionContextRememberCompositionContext6, nestedScrollDispatcher6);
                    viewFactoryHolder.setFactory(factory);
                    SaveableStateRegistry saveableStateRegistry2 = saveableStateRegistry;
                    Object objConsumeRestored = saveableStateRegistry2 != null ? saveableStateRegistry2.consumeRestored(strValueOf) : null;
                    SparseArray<Parcelable> sparseArray = objConsumeRestored instanceof SparseArray ? (SparseArray) objConsumeRestored : null;
                    if (sparseArray != null && (typedView$ui_release = viewFactoryHolder.getTypedView$ui_release()) != null) {
                        typedView$ui_release.restoreHierarchyState(sparseArray);
                    }
                    ref.setValue((ViewFactoryHolder<T>) viewFactoryHolder);
                    return viewFactoryHolder.getLayoutNode();
                }
            };
            composerStartRestartGroup.startReplaceableGroup(1886828752);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode):Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.LayoutNode, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final LayoutNode invoke() {
                        return function0.invoke();
                    }
                });
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM1286constructorimpl6 = Updater.m1286constructorimpl(composerStartRestartGroup);
            Updater.m1293setimpl(composerM1286constructorimpl6, modifierMaterialize6, new Function2<LayoutNode, Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Modifier modifier4) {
                    invoke2(layoutNode, modifier4);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode set, Modifier it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object value = ref.getValue();
                    Intrinsics.checkNotNull(value);
                    ((ViewFactoryHolder) value).setModifier(it);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl6, density6, new Function2<LayoutNode, Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Density density7) {
                    invoke2(layoutNode, density7);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode set, Density it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object value = ref.getValue();
                    Intrinsics.checkNotNull(value);
                    ((ViewFactoryHolder) value).setDensity(it);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl6, lifecycleOwner6, new Function2<LayoutNode, LifecycleOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LifecycleOwner lifecycleOwner7) {
                    invoke2(layoutNode, lifecycleOwner7);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode set, LifecycleOwner it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object value = ref.getValue();
                    Intrinsics.checkNotNull(value);
                    ((ViewFactoryHolder) value).setLifecycleOwner(it);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl6, savedStateRegistryOwner6, new Function2<LayoutNode, SavedStateRegistryOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner7) {
                    invoke2(layoutNode, savedStateRegistryOwner7);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode set, SavedStateRegistryOwner it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object value = ref.getValue();
                    Intrinsics.checkNotNull(value);
                    ((ViewFactoryHolder) value).setSavedStateRegistryOwner(it);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl6, function3, (Function2<? super T, ? super Function1<? super T, Unit>, Unit>) new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                    invoke(layoutNode, (Function1) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(LayoutNode set, Function1<? super T, Unit> it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    ViewFactoryHolder<T> value = ref.getValue();
                    Intrinsics.checkNotNull(value);
                    value.setUpdateBlock(it);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl6, layoutDirection6, new Function2<LayoutNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$6

                /* JADX INFO: compiled from: AndroidView.android.kt */
                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[LayoutDirection.values().length];
                        iArr[LayoutDirection.Ltr.ordinal()] = 1;
                        iArr[LayoutDirection.Rtl.ordinal()] = 2;
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LayoutDirection layoutDirection7) {
                    invoke2(layoutNode, layoutDirection7);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode set, LayoutDirection it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object value = ref.getValue();
                    Intrinsics.checkNotNull(value);
                    ViewFactoryHolder viewFactoryHolder = (ViewFactoryHolder) value;
                    int i7 = WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
                    int i8 = 1;
                    if (i7 == 1) {
                        i8 = 0;
                    } else if (i7 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    viewFactoryHolder.setLayoutDirection(i8);
                }
            });
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (saveableStateRegistry != null) {
                EffectsKt.DisposableEffect(saveableStateRegistry, strValueOf, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        final Ref<ViewFactoryHolder<T>> ref2 = ref;
                        final SaveableStateRegistry.Entry entryRegisterProvider = saveableStateRegistry.registerProvider(strValueOf, new Function0<SparseArray<Parcelable>>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$valueProvider$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final SparseArray<Parcelable> invoke() {
                                SparseArray<Parcelable> sparseArray = new SparseArray<>();
                                Object value = ref2.getValue();
                                Intrinsics.checkNotNull(value);
                                View typedView$ui_release = ((ViewFactoryHolder) value).getTypedView$ui_release();
                                if (typedView$ui_release != null) {
                                    typedView$ui_release.saveHierarchyState(sparseArray);
                                }
                                return sparseArray;
                            }
                        });
                        return new DisposableEffectResult() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                entryRegisterProvider.unregister();
                            }
                        };
                    }
                }, composerStartRestartGroup, 8);
            }
            modifier2 = modifier3;
            function4 = function3;
        } else {
            if (i6 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                function3 = NoOpUpdate;
            } else {
                function3 = function2;
            }
            ProvidableCompositionLocal<Context> localContext7 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1117 = composerStartRestartGroup.consume(localContext7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context7 = (Context) objConsume1117;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new NestedScrollConnection() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            AndroidView_androidKt$AndroidView$noOpConnection$1$1 androidView_androidKt$AndroidView$noOpConnection$1$7 = (AndroidView_androidKt$AndroidView$noOpConnection$1$1) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new NestedScrollDispatcher();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            final NestedScrollDispatcher nestedScrollDispatcher7 = (NestedScrollDispatcher) objRememberedValue2;
            Modifier modifierMaterialize7 = ComposedModifierKt.materialize(composerStartRestartGroup, SemanticsModifierKt.semantics(modifier3.then(NestedScrollModifierKt.nestedScroll(Modifier.INSTANCE, androidView_androidKt$AndroidView$noOpConnection$1$7, nestedScrollDispatcher7)), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$modifierWithSemantics$1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }
            }));
            ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1118 = composerStartRestartGroup.consume(localDensity7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density7 = (Density) objConsume1118;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1119 = composerStartRestartGroup.consume(localLayoutDirection7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection7 = (LayoutDirection) objConsume1119;
            final CompositionContext compositionContextRememberCompositionContext7 = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            ProvidableCompositionLocal<SaveableStateRegistry> localSaveableStateRegistry7 = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume11110 = composerStartRestartGroup.consume(localSaveableStateRegistry7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            saveableStateRegistry = (SaveableStateRegistry) objConsume11110;
            strValueOf = String.valueOf(ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0));
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Ref();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ref = (Ref) objRememberedValue3;
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner7 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume11111 = composerStartRestartGroup.consume(localLifecycleOwner7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LifecycleOwner lifecycleOwner7 = (LifecycleOwner) objConsume11111;
            ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner7 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume11112 = composerStartRestartGroup.consume(localSavedStateRegistryOwner7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SavedStateRegistryOwner savedStateRegistryOwner7 = (SavedStateRegistryOwner) objConsume11112;
            function0 = new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference incomplete: some casts might be missing */
                @Override // kotlin.jvm.functions.Function0
                public final LayoutNode invoke() {
                    View typedView$ui_release;
                    ViewFactoryHolder viewFactoryHolder = new ViewFactoryHolder(context7, compositionContextRememberCompositionContext7, nestedScrollDispatcher7);
                    viewFactoryHolder.setFactory(factory);
                    SaveableStateRegistry saveableStateRegistry2 = saveableStateRegistry;
                    Object objConsumeRestored = saveableStateRegistry2 != null ? saveableStateRegistry2.consumeRestored(strValueOf) : null;
                    SparseArray<Parcelable> sparseArray = objConsumeRestored instanceof SparseArray ? (SparseArray) objConsumeRestored : null;
                    if (sparseArray != null && (typedView$ui_release = viewFactoryHolder.getTypedView$ui_release()) != null) {
                        typedView$ui_release.restoreHierarchyState(sparseArray);
                    }
                    ref.setValue((ViewFactoryHolder<T>) viewFactoryHolder);
                    return viewFactoryHolder.getLayoutNode();
                }
            };
            composerStartRestartGroup.startReplaceableGroup(1886828752);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode):Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.LayoutNode, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final LayoutNode invoke() {
                        return function0.invoke();
                    }
                });
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM1286constructorimpl7 = Updater.m1286constructorimpl(composerStartRestartGroup);
            Updater.m1293setimpl(composerM1286constructorimpl7, modifierMaterialize7, new Function2<LayoutNode, Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Modifier modifier4) {
                    invoke2(layoutNode, modifier4);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode set, Modifier it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object value = ref.getValue();
                    Intrinsics.checkNotNull(value);
                    ((ViewFactoryHolder) value).setModifier(it);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl7, density7, new Function2<LayoutNode, Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Density density8) {
                    invoke2(layoutNode, density8);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode set, Density it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object value = ref.getValue();
                    Intrinsics.checkNotNull(value);
                    ((ViewFactoryHolder) value).setDensity(it);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl7, lifecycleOwner7, new Function2<LayoutNode, LifecycleOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LifecycleOwner lifecycleOwner8) {
                    invoke2(layoutNode, lifecycleOwner8);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode set, LifecycleOwner it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object value = ref.getValue();
                    Intrinsics.checkNotNull(value);
                    ((ViewFactoryHolder) value).setLifecycleOwner(it);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl7, savedStateRegistryOwner7, new Function2<LayoutNode, SavedStateRegistryOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner8) {
                    invoke2(layoutNode, savedStateRegistryOwner8);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode set, SavedStateRegistryOwner it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object value = ref.getValue();
                    Intrinsics.checkNotNull(value);
                    ((ViewFactoryHolder) value).setSavedStateRegistryOwner(it);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl7, function3, (Function2<? super T, ? super Function1<? super T, Unit>, Unit>) new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                    invoke(layoutNode, (Function1) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(LayoutNode set, Function1<? super T, Unit> it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    ViewFactoryHolder<T> value = ref.getValue();
                    Intrinsics.checkNotNull(value);
                    value.setUpdateBlock(it);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl7, layoutDirection7, new Function2<LayoutNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$6

                /* JADX INFO: compiled from: AndroidView.android.kt */
                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[LayoutDirection.values().length];
                        iArr[LayoutDirection.Ltr.ordinal()] = 1;
                        iArr[LayoutDirection.Rtl.ordinal()] = 2;
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LayoutDirection layoutDirection8) {
                    invoke2(layoutNode, layoutDirection8);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode set, LayoutDirection it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object value = ref.getValue();
                    Intrinsics.checkNotNull(value);
                    ViewFactoryHolder viewFactoryHolder = (ViewFactoryHolder) value;
                    int i7 = WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
                    int i8 = 1;
                    if (i7 == 1) {
                        i8 = 0;
                    } else if (i7 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    viewFactoryHolder.setLayoutDirection(i8);
                }
            });
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (saveableStateRegistry != null) {
                EffectsKt.DisposableEffect(saveableStateRegistry, strValueOf, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        final Ref<ViewFactoryHolder<T>> ref2 = ref;
                        final SaveableStateRegistry.Entry entryRegisterProvider = saveableStateRegistry.registerProvider(strValueOf, new Function0<SparseArray<Parcelable>>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$valueProvider$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final SparseArray<Parcelable> invoke() {
                                SparseArray<Parcelable> sparseArray = new SparseArray<>();
                                Object value = ref2.getValue();
                                Intrinsics.checkNotNull(value);
                                View typedView$ui_release = ((ViewFactoryHolder) value).getTypedView$ui_release();
                                if (typedView$ui_release != null) {
                                    typedView$ui_release.saveHierarchyState(sparseArray);
                                }
                                return sparseArray;
                            }
                        });
                        return new DisposableEffectResult() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                entryRegisterProvider.unregister();
                            }
                        };
                    }
                }, composerStartRestartGroup, 8);
            }
            modifier2 = modifier3;
            function4 = function3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.4
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

            public final void invoke(Composer composer2, int i7) {
                AndroidView_androidKt.AndroidView(factory, modifier2, function4, composer2, i | 1, i2);
            }
        });
    }

    public static final Function1<View, Unit> getNoOpUpdate() {
        return NoOpUpdate;
    }
}
