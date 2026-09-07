package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Crossfade.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n2&\u0010\t\u001a\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Crossfade", "", "T", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", "contentKey", "Lkotlin/ParameterName;", "name", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CrossfadeKt {
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:44:0x007e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:46:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0094  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:57:? A[RETURN, SYNTHETIC] */
    public static final <T> void Crossfade(final T t, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, final Function3<? super T, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        Modifier modifier2;
        FiniteAnimationSpec<Float> finiteAnimationSpecTween$default;
        final Modifier modifier3;
        final FiniteAnimationSpec<Float> finiteAnimationSpec2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(523603005);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Crossfade)P(3,2)53@2155L29,54@2200L53:Crossfade.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(t) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                i3 |= 128;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if (i4 == 4 || (i3 & 5851) != 1170 || !composerStartRestartGroup.getSkipping()) {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                } else {
                    finiteAnimationSpecTween$default = finiteAnimationSpec;
                }
                Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, (String) null, composerStartRestartGroup, i3 & 14, 2), modifier2, finiteAnimationSpecTween$default, null, content, composerStartRestartGroup, (i3 & 112) | 512 | ((i3 << 3) & 57344), 4);
                modifier3 = modifier2;
                finiteAnimationSpec2 = finiteAnimationSpecTween$default;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                finiteAnimationSpec2 = finiteAnimationSpec;
                modifier3 = modifier;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.1
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
                    CrossfadeKt.Crossfade(t, modifier3, finiteAnimationSpec2, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changed(content)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i3 |= i5;
        }
        if (i4 == 4) {
            if (i6 != 0) {
                modifier2 = Modifier.INSTANCE;
            } else {
                modifier2 = modifier;
            }
            if (i4 != 0) {
                finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
            } else {
                finiteAnimationSpecTween$default = finiteAnimationSpec;
            }
            Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, (String) null, composerStartRestartGroup, i3 & 14, 2), modifier2, finiteAnimationSpecTween$default, null, content, composerStartRestartGroup, (i3 & 112) | 512 | ((i3 << 3) & 57344), 4);
            modifier3 = modifier2;
            finiteAnimationSpec2 = finiteAnimationSpecTween$default;
        } else {
            if (i6 != 0) {
                modifier2 = Modifier.INSTANCE;
            } else {
                modifier2 = modifier;
            }
            if (i4 != 0) {
                finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
            } else {
                finiteAnimationSpecTween$default = finiteAnimationSpec;
            }
            Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, (String) null, composerStartRestartGroup, i3 & 14, 2), modifier2, finiteAnimationSpecTween$default, null, content, composerStartRestartGroup, (i3 & 112) | 512 | ((i3 << 3) & 57344), 4);
            modifier3 = modifier2;
            finiteAnimationSpec2 = finiteAnimationSpecTween$default;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.1
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
                CrossfadeKt.Crossfade(t, modifier3, finiteAnimationSpec2, content, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0261  */
    /* JADX WARN: Code duplicated, block: B:104:0x026d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0271  */
    /* JADX WARN: Code duplicated, block: B:108:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:111:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:117:0x031a  */
    /* JADX WARN: Code duplicated, block: B:119:0x01b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x01b5 A[EDGE_INSN: B:120:0x01b5->B:93:0x01b5 BREAK  A[LOOP:0: B:86:0x0191->B:91:0x01af], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0058  */
    /* JADX WARN: Code duplicated, block: B:29:0x005e  */
    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
    /* JADX WARN: Code duplicated, block: B:32:0x0065  */
    /* JADX WARN: Code duplicated, block: B:34:0x006d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0070  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:41:0x007d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0083  */
    /* JADX WARN: Code duplicated, block: B:45:0x0089  */
    /* JADX WARN: Code duplicated, block: B:46:0x008c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:70:0x0108  */
    /* JADX WARN: Code duplicated, block: B:73:0x0132  */
    /* JADX WARN: Code duplicated, block: B:79:0x015e  */
    /* JADX WARN: Code duplicated, block: B:81:0x0166  */
    /* JADX WARN: Code duplicated, block: B:85:0x0189  */
    /* JADX WARN: Code duplicated, block: B:88:0x0198  */
    /* JADX WARN: Code duplicated, block: B:91:0x01af A[LOOP:0: B:86:0x0191->B:91:0x01af, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:94:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:95:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d0 A[LOOP:1: B:97:0x01ce->B:98:0x01d0, LOOP_END] */
    @ExperimentalAnimationApi
    public static final <T> void Crossfade(final Transition<T> transition, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, Function1<? super T, ? extends Object> function1, final Function3<? super T, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        Function1<? super T, ? extends Object> function2;
        int i6;
        int i7;
        int i8;
        Modifier modifier3;
        FiniteAnimationSpec<Float> finiteAnimationSpecTween$default;
        Object objRememberedValue;
        Object obj;
        SnapshotStateList snapshotStateList;
        LinkedHashMap linkedHashMapRememberedValue;
        Map map;
        Map map2;
        Function0<ComposeUiNode> constructor;
        SnapshotStateList snapshotStateList2;
        int size;
        int i9;
        final Function1<? super T, ? extends Object> function3;
        final Modifier modifier4;
        final FiniteAnimationSpec<Float> finiteAnimationSpec2;
        Function2 function4;
        SnapshotStateList snapshotStateList3;
        Iterator<T> it;
        int i10;
        int size2;
        int i11;
        boolean zChanged;
        Object objRememberedValue2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(679005231);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Crossfade)P(3!1,2)85@3787L64,86@3873L66,120@5162L159:Crossfade.kt#xbi5r1");
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 1;
        if (i12 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 2;
            if (i4 != 0) {
                i3 |= 128;
            }
            i5 = i2 & 4;
            if (i5 != 0) {
                if ((i & 7168) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changed(function2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i3;
                if (i4 == 2 || (46811 & i8) != 9362 || !composerStartRestartGroup.getSkipping()) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                    } else {
                        finiteAnimationSpecTween$default = finiteAnimationSpec;
                    }
                    if (i5 != 0) {
                        function2 = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.2
                            @Override // kotlin.jvm.functions.Function1
                            public final T invoke(T t) {
                                return t;
                            }
                        };
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue;
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        SnapshotStateList snapshotStateListMutableStateListOf = SnapshotStateKt.mutableStateListOf();
                        snapshotStateListMutableStateListOf.add(transition.getCurrentState());
                        Unit unit = Unit.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf);
                        obj = snapshotStateListMutableStateListOf;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    snapshotStateList = (SnapshotStateList) obj;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    linkedHashMapRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (linkedHashMapRememberedValue == Composer.INSTANCE.getEmpty()) {
                        linkedHashMapRememberedValue = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(linkedHashMapRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    map = (Map) linkedHashMapRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-1621449801);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "93@4253L21");
                    if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState()) && (snapshotStateList.size() != 1 || !Intrinsics.areEqual(snapshotStateList.get(0), transition.getTargetState()))) {
                        SnapshotStateList snapshotStateList4 = snapshotStateList;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(transition);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(T t) {
                                    return Boolean.valueOf(!Intrinsics.areEqual(t, transition.getTargetState()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CollectionsKt.removeAll((List) snapshotStateList4, (Function1) objRememberedValue2);
                        map.clear();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (!map.containsKey(transition.getTargetState())) {
                        snapshotStateList3 = snapshotStateList;
                        it = snapshotStateList3.iterator();
                        i10 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i10 = -1;
                                break;
                            } else if (Intrinsics.areEqual(function2.invoke(it.next()), function2.invoke(transition.getTargetState()))) {
                                break;
                            } else {
                                i10++;
                            }
                        }
                        if (i10 == -1) {
                            snapshotStateList.add(transition.getTargetState());
                        } else {
                            snapshotStateList.set(i10, transition.getTargetState());
                        }
                        map.clear();
                        size2 = snapshotStateList3.size();
                        i11 = 0;
                        while (i11 < size2) {
                            T t = snapshotStateList3.get(i11);
                            Map map3 = map;
                            map3.put(t, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1426421288, true, new CrossfadeKt$Crossfade$4$1(transition, i8, finiteAnimationSpecTween$default, t, content)));
                            i11++;
                            map = map3;
                            snapshotStateList3 = snapshotStateList3;
                        }
                    }
                    map2 = map;
                    composerStartRestartGroup.startReplaceableGroup(-1990474327);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(1376089335);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density = (Density) objConsume;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-1253629305);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1930908853);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C:Crossfade.kt#xbi5r1");
                    snapshotStateList2 = snapshotStateList;
                    size = snapshotStateList2.size();
                    for (i9 = 0; i9 < size; i9++) {
                        Object obj2 = snapshotStateList2.get(i9);
                        composerStartRestartGroup.startMovableGroup(-450541954, function2.invoke(obj2));
                        ComposerKt.sourceInformation(composerStartRestartGroup, "123@5283L8");
                        function4 = (Function2) map2.get(obj2);
                        if (function4 != null) {
                            function4.invoke(composerStartRestartGroup, 0);
                            Unit unit2 = Unit.INSTANCE;
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    function3 = function2;
                    modifier4 = modifier3;
                    finiteAnimationSpec2 = finiteAnimationSpecTween$default;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                    function3 = function2;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.6
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

                    public final void invoke(Composer composer2, int i13) {
                        CrossfadeKt.Crossfade(transition, modifier4, finiteAnimationSpec2, function3, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            function2 = function1;
            if ((i2 & 8) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i3;
            if (i4 == 2) {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                } else {
                    finiteAnimationSpecTween$default = finiteAnimationSpec;
                }
                if (i5 != 0) {
                    function2 = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.2
                        @Override // kotlin.jvm.functions.Function1
                        public final T invoke(T t2) {
                            return t2;
                        }
                    };
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue;
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    SnapshotStateList snapshotStateListMutableStateListOf2 = SnapshotStateKt.mutableStateListOf();
                    snapshotStateListMutableStateListOf2.add(transition.getCurrentState());
                    Unit unit3 = Unit.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf2);
                    obj = snapshotStateListMutableStateListOf2;
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) obj;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                linkedHashMapRememberedValue = composerStartRestartGroup.rememberedValue();
                if (linkedHashMapRememberedValue == Composer.INSTANCE.getEmpty()) {
                    linkedHashMapRememberedValue = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(linkedHashMapRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                map = (Map) linkedHashMapRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-1621449801);
                ComposerKt.sourceInformation(composerStartRestartGroup, "93@4253L21");
                if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                    SnapshotStateList snapshotStateList5 = snapshotStateList;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(T t2) {
                                return Boolean.valueOf(!Intrinsics.areEqual(t2, transition.getTargetState()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(T t2) {
                                return Boolean.valueOf(!Intrinsics.areEqual(t2, transition.getTargetState()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CollectionsKt.removeAll((List) snapshotStateList5, (Function1) objRememberedValue2);
                    map.clear();
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (!map.containsKey(transition.getTargetState())) {
                    snapshotStateList3 = snapshotStateList;
                    it = snapshotStateList3.iterator();
                    i10 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i10 = -1;
                            break;
                        } else {
                            if (Intrinsics.areEqual(function2.invoke(it.next()), function2.invoke(transition.getTargetState()))) {
                                break;
                                break;
                            }
                            i10++;
                        }
                    }
                    if (i10 == -1) {
                        snapshotStateList.add(transition.getTargetState());
                    } else {
                        snapshotStateList.set(i10, transition.getTargetState());
                    }
                    map.clear();
                    size2 = snapshotStateList3.size();
                    i11 = 0;
                    while (i11 < size2) {
                        T t2 = snapshotStateList3.get(i11);
                        Map map4 = map;
                        map4.put(t2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1426421288, true, new CrossfadeKt$Crossfade$4$1(transition, i8, finiteAnimationSpecTween$default, t2, content)));
                        i11++;
                        map = map4;
                        snapshotStateList3 = snapshotStateList3;
                    }
                }
                map2 = map;
                composerStartRestartGroup.startReplaceableGroup(-1990474327);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(1376089335);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density2 = (Density) objConsume3;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection2 = (LayoutDirection) objConsume4;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifier3);
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
                Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-1253629305);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1930908853);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C:Crossfade.kt#xbi5r1");
                snapshotStateList2 = snapshotStateList;
                size = snapshotStateList2.size();
                while (i9 < size) {
                    Object obj3 = snapshotStateList2.get(i9);
                    composerStartRestartGroup.startMovableGroup(-450541954, function2.invoke(obj3));
                    ComposerKt.sourceInformation(composerStartRestartGroup, "123@5283L8");
                    function4 = (Function2) map2.get(obj3);
                    if (function4 != null) {
                        function4.invoke(composerStartRestartGroup, 0);
                        Unit unit4 = Unit.INSTANCE;
                    }
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                function3 = function2;
                modifier4 = modifier3;
                finiteAnimationSpec2 = finiteAnimationSpecTween$default;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                } else {
                    finiteAnimationSpecTween$default = finiteAnimationSpec;
                }
                if (i5 != 0) {
                    function2 = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.2
                        @Override // kotlin.jvm.functions.Function1
                        public final T invoke(T t3) {
                            return t3;
                        }
                    };
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue;
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    SnapshotStateList snapshotStateListMutableStateListOf3 = SnapshotStateKt.mutableStateListOf();
                    snapshotStateListMutableStateListOf3.add(transition.getCurrentState());
                    Unit unit5 = Unit.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf3);
                    obj = snapshotStateListMutableStateListOf3;
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) obj;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                linkedHashMapRememberedValue = composerStartRestartGroup.rememberedValue();
                if (linkedHashMapRememberedValue == Composer.INSTANCE.getEmpty()) {
                    linkedHashMapRememberedValue = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(linkedHashMapRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                map = (Map) linkedHashMapRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-1621449801);
                ComposerKt.sourceInformation(composerStartRestartGroup, "93@4253L21");
                if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                    SnapshotStateList snapshotStateList6 = snapshotStateList;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(T t3) {
                                return Boolean.valueOf(!Intrinsics.areEqual(t3, transition.getTargetState()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(T t3) {
                                return Boolean.valueOf(!Intrinsics.areEqual(t3, transition.getTargetState()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CollectionsKt.removeAll((List) snapshotStateList6, (Function1) objRememberedValue2);
                    map.clear();
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (!map.containsKey(transition.getTargetState())) {
                    snapshotStateList3 = snapshotStateList;
                    it = snapshotStateList3.iterator();
                    i10 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i10 = -1;
                            break;
                        } else {
                            if (Intrinsics.areEqual(function2.invoke(it.next()), function2.invoke(transition.getTargetState()))) {
                                break;
                                break;
                            }
                            i10++;
                        }
                    }
                    if (i10 == -1) {
                        snapshotStateList.add(transition.getTargetState());
                    } else {
                        snapshotStateList.set(i10, transition.getTargetState());
                    }
                    map.clear();
                    size2 = snapshotStateList3.size();
                    i11 = 0;
                    while (i11 < size2) {
                        T t3 = snapshotStateList3.get(i11);
                        Map map5 = map;
                        map5.put(t3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1426421288, true, new CrossfadeKt$Crossfade$4$1(transition, i8, finiteAnimationSpecTween$default, t3, content)));
                        i11++;
                        map = map5;
                        snapshotStateList3 = snapshotStateList3;
                    }
                }
                map2 = map;
                composerStartRestartGroup.startReplaceableGroup(-1990474327);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(1376089335);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density3 = (Density) objConsume5;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection3 = (LayoutDirection) objConsume6;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifier3);
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
                Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-1253629305);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1930908853);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C:Crossfade.kt#xbi5r1");
                snapshotStateList2 = snapshotStateList;
                size = snapshotStateList2.size();
                while (i9 < size) {
                    Object obj4 = snapshotStateList2.get(i9);
                    composerStartRestartGroup.startMovableGroup(-450541954, function2.invoke(obj4));
                    ComposerKt.sourceInformation(composerStartRestartGroup, "123@5283L8");
                    function4 = (Function2) map2.get(obj4);
                    if (function4 != null) {
                        function4.invoke(composerStartRestartGroup, 0);
                        Unit unit6 = Unit.INSTANCE;
                    }
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                function3 = function2;
                modifier4 = modifier3;
                finiteAnimationSpec2 = finiteAnimationSpecTween$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.6
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

                public final void invoke(Composer composer2, int i13) {
                    CrossfadeKt.Crossfade(transition, modifier4, finiteAnimationSpec2, function3, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 128;
        }
        i5 = i2 & 4;
        if (i5 != 0) {
            if ((i & 7168) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changed(function2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i2 & 8) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i3;
            if (i4 == 2) {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                } else {
                    finiteAnimationSpecTween$default = finiteAnimationSpec;
                }
                if (i5 != 0) {
                    function2 = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.2
                        @Override // kotlin.jvm.functions.Function1
                        public final T invoke(T t4) {
                            return t4;
                        }
                    };
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue;
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    SnapshotStateList snapshotStateListMutableStateListOf4 = SnapshotStateKt.mutableStateListOf();
                    snapshotStateListMutableStateListOf4.add(transition.getCurrentState());
                    Unit unit7 = Unit.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf4);
                    obj = snapshotStateListMutableStateListOf4;
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) obj;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                linkedHashMapRememberedValue = composerStartRestartGroup.rememberedValue();
                if (linkedHashMapRememberedValue == Composer.INSTANCE.getEmpty()) {
                    linkedHashMapRememberedValue = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(linkedHashMapRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                map = (Map) linkedHashMapRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-1621449801);
                ComposerKt.sourceInformation(composerStartRestartGroup, "93@4253L21");
                if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                    SnapshotStateList snapshotStateList7 = snapshotStateList;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(T t4) {
                                return Boolean.valueOf(!Intrinsics.areEqual(t4, transition.getTargetState()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(T t4) {
                                return Boolean.valueOf(!Intrinsics.areEqual(t4, transition.getTargetState()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CollectionsKt.removeAll((List) snapshotStateList7, (Function1) objRememberedValue2);
                    map.clear();
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (!map.containsKey(transition.getTargetState())) {
                    snapshotStateList3 = snapshotStateList;
                    it = snapshotStateList3.iterator();
                    i10 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i10 = -1;
                            break;
                        } else {
                            if (Intrinsics.areEqual(function2.invoke(it.next()), function2.invoke(transition.getTargetState()))) {
                                break;
                                break;
                            }
                            i10++;
                        }
                    }
                    if (i10 == -1) {
                        snapshotStateList.add(transition.getTargetState());
                    } else {
                        snapshotStateList.set(i10, transition.getTargetState());
                    }
                    map.clear();
                    size2 = snapshotStateList3.size();
                    i11 = 0;
                    while (i11 < size2) {
                        T t4 = snapshotStateList3.get(i11);
                        Map map6 = map;
                        map6.put(t4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1426421288, true, new CrossfadeKt$Crossfade$4$1(transition, i8, finiteAnimationSpecTween$default, t4, content)));
                        i11++;
                        map = map6;
                        snapshotStateList3 = snapshotStateList3;
                    }
                }
                map2 = map;
                composerStartRestartGroup.startReplaceableGroup(-1990474327);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(1376089335);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localDensity4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density4 = (Density) objConsume7;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localLayoutDirection4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection4 = (LayoutDirection) objConsume8;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifier3);
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
                Composer composerM1286constructorimpl4 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl4, measurePolicyRememberBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl4, density4, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl4, layoutDirection4, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf4.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-1253629305);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1930908853);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C:Crossfade.kt#xbi5r1");
                snapshotStateList2 = snapshotStateList;
                size = snapshotStateList2.size();
                while (i9 < size) {
                    Object obj5 = snapshotStateList2.get(i9);
                    composerStartRestartGroup.startMovableGroup(-450541954, function2.invoke(obj5));
                    ComposerKt.sourceInformation(composerStartRestartGroup, "123@5283L8");
                    function4 = (Function2) map2.get(obj5);
                    if (function4 != null) {
                        function4.invoke(composerStartRestartGroup, 0);
                        Unit unit8 = Unit.INSTANCE;
                    }
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                function3 = function2;
                modifier4 = modifier3;
                finiteAnimationSpec2 = finiteAnimationSpecTween$default;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                } else {
                    finiteAnimationSpecTween$default = finiteAnimationSpec;
                }
                if (i5 != 0) {
                    function2 = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.2
                        @Override // kotlin.jvm.functions.Function1
                        public final T invoke(T t5) {
                            return t5;
                        }
                    };
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue;
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    SnapshotStateList snapshotStateListMutableStateListOf5 = SnapshotStateKt.mutableStateListOf();
                    snapshotStateListMutableStateListOf5.add(transition.getCurrentState());
                    Unit unit9 = Unit.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf5);
                    obj = snapshotStateListMutableStateListOf5;
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) obj;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                linkedHashMapRememberedValue = composerStartRestartGroup.rememberedValue();
                if (linkedHashMapRememberedValue == Composer.INSTANCE.getEmpty()) {
                    linkedHashMapRememberedValue = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(linkedHashMapRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                map = (Map) linkedHashMapRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-1621449801);
                ComposerKt.sourceInformation(composerStartRestartGroup, "93@4253L21");
                if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                    SnapshotStateList snapshotStateList8 = snapshotStateList;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(T t5) {
                                return Boolean.valueOf(!Intrinsics.areEqual(t5, transition.getTargetState()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(T t5) {
                                return Boolean.valueOf(!Intrinsics.areEqual(t5, transition.getTargetState()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CollectionsKt.removeAll((List) snapshotStateList8, (Function1) objRememberedValue2);
                    map.clear();
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (!map.containsKey(transition.getTargetState())) {
                    snapshotStateList3 = snapshotStateList;
                    it = snapshotStateList3.iterator();
                    i10 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i10 = -1;
                            break;
                        } else {
                            if (Intrinsics.areEqual(function2.invoke(it.next()), function2.invoke(transition.getTargetState()))) {
                                break;
                                break;
                            }
                            i10++;
                        }
                    }
                    if (i10 == -1) {
                        snapshotStateList.add(transition.getTargetState());
                    } else {
                        snapshotStateList.set(i10, transition.getTargetState());
                    }
                    map.clear();
                    size2 = snapshotStateList3.size();
                    i11 = 0;
                    while (i11 < size2) {
                        T t5 = snapshotStateList3.get(i11);
                        Map map7 = map;
                        map7.put(t5, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1426421288, true, new CrossfadeKt$Crossfade$4$1(transition, i8, finiteAnimationSpecTween$default, t5, content)));
                        i11++;
                        map = map7;
                        snapshotStateList3 = snapshotStateList3;
                    }
                }
                map2 = map;
                composerStartRestartGroup.startReplaceableGroup(-1990474327);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(1376089335);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object objConsume9 = composerStartRestartGroup.consume(localDensity5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density5 = (Density) objConsume9;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object objConsume10 = composerStartRestartGroup.consume(localLayoutDirection5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection5 = (LayoutDirection) objConsume10;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifier3);
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
                Composer composerM1286constructorimpl5 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl5, measurePolicyRememberBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl5, density5, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl5, layoutDirection5, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf5.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-1253629305);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1930908853);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C:Crossfade.kt#xbi5r1");
                snapshotStateList2 = snapshotStateList;
                size = snapshotStateList2.size();
                while (i9 < size) {
                    Object obj6 = snapshotStateList2.get(i9);
                    composerStartRestartGroup.startMovableGroup(-450541954, function2.invoke(obj6));
                    ComposerKt.sourceInformation(composerStartRestartGroup, "123@5283L8");
                    function4 = (Function2) map2.get(obj6);
                    if (function4 != null) {
                        function4.invoke(composerStartRestartGroup, 0);
                        Unit unit10 = Unit.INSTANCE;
                    }
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                function3 = function2;
                modifier4 = modifier3;
                finiteAnimationSpec2 = finiteAnimationSpecTween$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.6
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

                public final void invoke(Composer composer2, int i13) {
                    CrossfadeKt.Crossfade(transition, modifier4, finiteAnimationSpec2, function3, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        function2 = function1;
        if ((i2 & 8) != 0) {
            i3 |= 24576;
        } else if ((57344 & i) == 0) {
            if (composerStartRestartGroup.changed(content)) {
                i7 = 16384;
            } else {
                i7 = 8192;
            }
            i3 |= i7;
        }
        i8 = i3;
        if (i4 == 2) {
            if (i12 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
            } else {
                finiteAnimationSpecTween$default = finiteAnimationSpec;
            }
            if (i5 != 0) {
                function2 = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.2
                    @Override // kotlin.jvm.functions.Function1
                    public final T invoke(T t6) {
                        return t6;
                    }
                };
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            obj = objRememberedValue;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                SnapshotStateList snapshotStateListMutableStateListOf6 = SnapshotStateKt.mutableStateListOf();
                snapshotStateListMutableStateListOf6.add(transition.getCurrentState());
                Unit unit11 = Unit.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf6);
                obj = snapshotStateListMutableStateListOf6;
            }
            composerStartRestartGroup.endReplaceableGroup();
            snapshotStateList = (SnapshotStateList) obj;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            linkedHashMapRememberedValue = composerStartRestartGroup.rememberedValue();
            if (linkedHashMapRememberedValue == Composer.INSTANCE.getEmpty()) {
                linkedHashMapRememberedValue = new LinkedHashMap();
                composerStartRestartGroup.updateRememberedValue(linkedHashMapRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            map = (Map) linkedHashMapRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-1621449801);
            ComposerKt.sourceInformation(composerStartRestartGroup, "93@4253L21");
            if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                SnapshotStateList snapshotStateList9 = snapshotStateList;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(transition);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(T t6) {
                            return Boolean.valueOf(!Intrinsics.areEqual(t6, transition.getTargetState()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(T t6) {
                            return Boolean.valueOf(!Intrinsics.areEqual(t6, transition.getTargetState()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CollectionsKt.removeAll((List) snapshotStateList9, (Function1) objRememberedValue2);
                map.clear();
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (!map.containsKey(transition.getTargetState())) {
                snapshotStateList3 = snapshotStateList;
                it = snapshotStateList3.iterator();
                i10 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i10 = -1;
                        break;
                    } else {
                        if (Intrinsics.areEqual(function2.invoke(it.next()), function2.invoke(transition.getTargetState()))) {
                            break;
                            break;
                        }
                        i10++;
                    }
                }
                if (i10 == -1) {
                    snapshotStateList.add(transition.getTargetState());
                } else {
                    snapshotStateList.set(i10, transition.getTargetState());
                }
                map.clear();
                size2 = snapshotStateList3.size();
                i11 = 0;
                while (i11 < size2) {
                    T t6 = snapshotStateList3.get(i11);
                    Map map8 = map;
                    map8.put(t6, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1426421288, true, new CrossfadeKt$Crossfade$4$1(transition, i8, finiteAnimationSpecTween$default, t6, content)));
                    i11++;
                    map = map8;
                    snapshotStateList3 = snapshotStateList3;
                }
            }
            map2 = map;
            composerStartRestartGroup.startReplaceableGroup(-1990474327);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(1376089335);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object objConsume11 = composerStartRestartGroup.consume(localDensity6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density6 = (Density) objConsume11;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object objConsume12 = composerStartRestartGroup.consume(localLayoutDirection6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection6 = (LayoutDirection) objConsume12;
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifier3);
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
            Composer composerM1286constructorimpl6 = Updater.m1286constructorimpl(composerStartRestartGroup);
            Updater.m1293setimpl(composerM1286constructorimpl6, measurePolicyRememberBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl6, density6, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl6, layoutDirection6, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf6.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-1253629305);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1930908853);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C:Crossfade.kt#xbi5r1");
            snapshotStateList2 = snapshotStateList;
            size = snapshotStateList2.size();
            while (i9 < size) {
                Object obj7 = snapshotStateList2.get(i9);
                composerStartRestartGroup.startMovableGroup(-450541954, function2.invoke(obj7));
                ComposerKt.sourceInformation(composerStartRestartGroup, "123@5283L8");
                function4 = (Function2) map2.get(obj7);
                if (function4 != null) {
                    function4.invoke(composerStartRestartGroup, 0);
                    Unit unit12 = Unit.INSTANCE;
                }
                composerStartRestartGroup.endMovableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            function3 = function2;
            modifier4 = modifier3;
            finiteAnimationSpec2 = finiteAnimationSpecTween$default;
        } else {
            if (i12 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
            } else {
                finiteAnimationSpecTween$default = finiteAnimationSpec;
            }
            if (i5 != 0) {
                function2 = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.2
                    @Override // kotlin.jvm.functions.Function1
                    public final T invoke(T t7) {
                        return t7;
                    }
                };
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            obj = objRememberedValue;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                SnapshotStateList snapshotStateListMutableStateListOf7 = SnapshotStateKt.mutableStateListOf();
                snapshotStateListMutableStateListOf7.add(transition.getCurrentState());
                Unit unit13 = Unit.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf7);
                obj = snapshotStateListMutableStateListOf7;
            }
            composerStartRestartGroup.endReplaceableGroup();
            snapshotStateList = (SnapshotStateList) obj;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            linkedHashMapRememberedValue = composerStartRestartGroup.rememberedValue();
            if (linkedHashMapRememberedValue == Composer.INSTANCE.getEmpty()) {
                linkedHashMapRememberedValue = new LinkedHashMap();
                composerStartRestartGroup.updateRememberedValue(linkedHashMapRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            map = (Map) linkedHashMapRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-1621449801);
            ComposerKt.sourceInformation(composerStartRestartGroup, "93@4253L21");
            if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                SnapshotStateList snapshotStateList10 = snapshotStateList;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(transition);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(T t7) {
                            return Boolean.valueOf(!Intrinsics.areEqual(t7, transition.getTargetState()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(T t7) {
                            return Boolean.valueOf(!Intrinsics.areEqual(t7, transition.getTargetState()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CollectionsKt.removeAll((List) snapshotStateList10, (Function1) objRememberedValue2);
                map.clear();
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (!map.containsKey(transition.getTargetState())) {
                snapshotStateList3 = snapshotStateList;
                it = snapshotStateList3.iterator();
                i10 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i10 = -1;
                        break;
                    } else {
                        if (Intrinsics.areEqual(function2.invoke(it.next()), function2.invoke(transition.getTargetState()))) {
                            break;
                            break;
                        }
                        i10++;
                    }
                }
                if (i10 == -1) {
                    snapshotStateList.add(transition.getTargetState());
                } else {
                    snapshotStateList.set(i10, transition.getTargetState());
                }
                map.clear();
                size2 = snapshotStateList3.size();
                i11 = 0;
                while (i11 < size2) {
                    T t7 = snapshotStateList3.get(i11);
                    Map map9 = map;
                    map9.put(t7, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1426421288, true, new CrossfadeKt$Crossfade$4$1(transition, i8, finiteAnimationSpecTween$default, t7, content)));
                    i11++;
                    map = map9;
                    snapshotStateList3 = snapshotStateList3;
                }
            }
            map2 = map;
            composerStartRestartGroup.startReplaceableGroup(-1990474327);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(1376089335);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object objConsume13 = composerStartRestartGroup.consume(localDensity7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density7 = (Density) objConsume13;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object objConsume14 = composerStartRestartGroup.consume(localLayoutDirection7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection7 = (LayoutDirection) objConsume14;
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf7 = LayoutKt.materializerOf(modifier3);
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
            Composer composerM1286constructorimpl7 = Updater.m1286constructorimpl(composerStartRestartGroup);
            Updater.m1293setimpl(composerM1286constructorimpl7, measurePolicyRememberBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl7, density7, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl7, layoutDirection7, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf7.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-1253629305);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1930908853);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C:Crossfade.kt#xbi5r1");
            snapshotStateList2 = snapshotStateList;
            size = snapshotStateList2.size();
            while (i9 < size) {
                Object obj8 = snapshotStateList2.get(i9);
                composerStartRestartGroup.startMovableGroup(-450541954, function2.invoke(obj8));
                ComposerKt.sourceInformation(composerStartRestartGroup, "123@5283L8");
                function4 = (Function2) map2.get(obj8);
                if (function4 != null) {
                    function4.invoke(composerStartRestartGroup, 0);
                    Unit unit14 = Unit.INSTANCE;
                }
                composerStartRestartGroup.endMovableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            function3 = function2;
            modifier4 = modifier3;
            finiteAnimationSpec2 = finiteAnimationSpecTween$default;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.6
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

            public final void invoke(Composer composer2, int i13) {
                CrossfadeKt.Crossfade(transition, modifier4, finiteAnimationSpec2, function3, content, composer2, i | 1, i2);
            }
        });
    }
}
