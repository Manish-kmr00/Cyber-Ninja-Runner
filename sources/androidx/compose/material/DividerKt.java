package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Divider.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"DividerAlpha", "", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "thickness", "Landroidx/compose/ui/unit/Dp;", "startIndent", "Divider-oMI9zvI", "(Landroidx/compose/ui/Modifier;JFFLandroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DividerKt {
    private static final float DividerAlpha = 0.12f;

    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00af  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:76:0x011e  */
    /* JADX WARN: Code duplicated, block: B:77:0x0141  */
    /* JADX WARN: Code duplicated, block: B:82:0x016e  */
    /* JADX WARN: Code duplicated, block: B:84:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Divider-oMI9zvI, reason: not valid java name */
    public static final void m1019DivideroMI9zvI(Modifier modifier, long j, float f, float f2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j2;
        float fM3843constructorimpl;
        int i4;
        float fM3843constructorimpl2;
        int i5;
        final Modifier.Companion companion;
        final long jM1630copywmQWz5c$default;
        Modifier.Companion companionM427paddingqDBjuR0$default;
        float fM3843constructorimpl3;
        final float f3;
        final float f4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1249392198);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Divider)P(1,0:c#ui.graphics.Color,3:c#ui.unit.Dp,2:c#ui.unit.Dp)45@1819L6,59@2200L147:Divider.kt#jmzs0o");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                j2 = j;
                int i7 = composerStartRestartGroup.changed(j2) ? 32 : 16;
                i3 |= i7;
            } else {
                j2 = j;
            }
            i3 |= i7;
        } else {
            j2 = j;
        }
        int i8 = i2 & 4;
        if (i8 == 0) {
            if ((i & 896) == 0) {
                fM3843constructorimpl = f;
                i3 |= composerStartRestartGroup.changed(fM3843constructorimpl) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    fM3843constructorimpl2 = f2;
                    if (composerStartRestartGroup.changed(fM3843constructorimpl2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i3 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m978getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                        if (i8 != 0) {
                            fM3843constructorimpl = Dp.m3843constructorimpl(1);
                        }
                        if (i4 != 0) {
                            fM3843constructorimpl2 = Dp.m3843constructorimpl(0);
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        companion = modifier2;
                        jM1630copywmQWz5c$default = j2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (fM3843constructorimpl2 != 0.0f) {
                        companionM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, fM3843constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        companionM427paddingqDBjuR0$default = Modifier.INSTANCE;
                    }
                    composerStartRestartGroup.startReplaceableGroup(1228914189);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*55@2139L7");
                    if (Dp.m3848equalsimpl0(fM3843constructorimpl, Dp.INSTANCE.m3861getHairlineD9Ej5fM())) {
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        fM3843constructorimpl3 = Dp.m3843constructorimpl(1.0f / ((Density) objConsume).getDensity());
                    } else {
                        fM3843constructorimpl3 = fM3843constructorimpl;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BoxKt.Box(BackgroundKt.m176backgroundbw27NRU$default(SizeKt.m450height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(companionM427paddingqDBjuR0$default), 0.0f, 1, null), fM3843constructorimpl3), jM1630copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    jM1630copywmQWz5c$default = j2;
                }
                f3 = fM3843constructorimpl;
                f4 = fM3843constructorimpl2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DividerKt$Divider$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        DividerKt.m1019DivideroMI9zvI(companion, jM1630copywmQWz5c$default, f3, f4, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            fM3843constructorimpl2 = f2;
            if ((i3 & 5851) == 1170) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m978getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                    if (i8 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM3843constructorimpl2 = Dp.m3843constructorimpl(0);
                    }
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m978getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                    if (i8 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM3843constructorimpl2 = Dp.m3843constructorimpl(0);
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (fM3843constructorimpl2 != 0.0f) {
                    companionM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, fM3843constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    companionM427paddingqDBjuR0$default = Modifier.INSTANCE;
                }
                composerStartRestartGroup.startReplaceableGroup(1228914189);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*55@2139L7");
                if (Dp.m3848equalsimpl0(fM3843constructorimpl, Dp.INSTANCE.m3861getHairlineD9Ej5fM())) {
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fM3843constructorimpl3 = Dp.m3843constructorimpl(1.0f / ((Density) objConsume2).getDensity());
                } else {
                    fM3843constructorimpl3 = fM3843constructorimpl;
                }
                composerStartRestartGroup.endReplaceableGroup();
                BoxKt.Box(BackgroundKt.m176backgroundbw27NRU$default(SizeKt.m450height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(companionM427paddingqDBjuR0$default), 0.0f, 1, null), fM3843constructorimpl3), jM1630copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m978getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                    if (i8 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM3843constructorimpl2 = Dp.m3843constructorimpl(0);
                    }
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m978getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                    if (i8 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM3843constructorimpl2 = Dp.m3843constructorimpl(0);
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (fM3843constructorimpl2 != 0.0f) {
                    companionM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, fM3843constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    companionM427paddingqDBjuR0$default = Modifier.INSTANCE;
                }
                composerStartRestartGroup.startReplaceableGroup(1228914189);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*55@2139L7");
                if (Dp.m3848equalsimpl0(fM3843constructorimpl, Dp.INSTANCE.m3861getHairlineD9Ej5fM())) {
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fM3843constructorimpl3 = Dp.m3843constructorimpl(1.0f / ((Density) objConsume3).getDensity());
                } else {
                    fM3843constructorimpl3 = fM3843constructorimpl;
                }
                composerStartRestartGroup.endReplaceableGroup();
                BoxKt.Box(BackgroundKt.m176backgroundbw27NRU$default(SizeKt.m450height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(companionM427paddingqDBjuR0$default), 0.0f, 1, null), fM3843constructorimpl3), jM1630copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
            }
            f3 = fM3843constructorimpl;
            f4 = fM3843constructorimpl2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DividerKt$Divider$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    DividerKt.m1019DivideroMI9zvI(companion, jM1630copywmQWz5c$default, f3, f4, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        fM3843constructorimpl = f;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                fM3843constructorimpl2 = f2;
                if (composerStartRestartGroup.changed(fM3843constructorimpl2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i3 & 5851) == 1170) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m978getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                    if (i8 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM3843constructorimpl2 = Dp.m3843constructorimpl(0);
                    }
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m978getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                    if (i8 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM3843constructorimpl2 = Dp.m3843constructorimpl(0);
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (fM3843constructorimpl2 != 0.0f) {
                    companionM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, fM3843constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    companionM427paddingqDBjuR0$default = Modifier.INSTANCE;
                }
                composerStartRestartGroup.startReplaceableGroup(1228914189);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*55@2139L7");
                if (Dp.m3848equalsimpl0(fM3843constructorimpl, Dp.INSTANCE.m3861getHairlineD9Ej5fM())) {
                    ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fM3843constructorimpl3 = Dp.m3843constructorimpl(1.0f / ((Density) objConsume4).getDensity());
                } else {
                    fM3843constructorimpl3 = fM3843constructorimpl;
                }
                composerStartRestartGroup.endReplaceableGroup();
                BoxKt.Box(BackgroundKt.m176backgroundbw27NRU$default(SizeKt.m450height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(companionM427paddingqDBjuR0$default), 0.0f, 1, null), fM3843constructorimpl3), jM1630copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m978getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                    if (i8 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM3843constructorimpl2 = Dp.m3843constructorimpl(0);
                    }
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m978getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                    if (i8 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM3843constructorimpl2 = Dp.m3843constructorimpl(0);
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (fM3843constructorimpl2 != 0.0f) {
                    companionM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, fM3843constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    companionM427paddingqDBjuR0$default = Modifier.INSTANCE;
                }
                composerStartRestartGroup.startReplaceableGroup(1228914189);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*55@2139L7");
                if (Dp.m3848equalsimpl0(fM3843constructorimpl, Dp.INSTANCE.m3861getHairlineD9Ej5fM())) {
                    ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fM3843constructorimpl3 = Dp.m3843constructorimpl(1.0f / ((Density) objConsume5).getDensity());
                } else {
                    fM3843constructorimpl3 = fM3843constructorimpl;
                }
                composerStartRestartGroup.endReplaceableGroup();
                BoxKt.Box(BackgroundKt.m176backgroundbw27NRU$default(SizeKt.m450height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(companionM427paddingqDBjuR0$default), 0.0f, 1, null), fM3843constructorimpl3), jM1630copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
            }
            f3 = fM3843constructorimpl;
            f4 = fM3843constructorimpl2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DividerKt$Divider$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    DividerKt.m1019DivideroMI9zvI(companion, jM1630copywmQWz5c$default, f3, f4, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        fM3843constructorimpl2 = f2;
        if ((i3 & 5851) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m978getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM1630copywmQWz5c$default = j2;
                }
                if (i8 != 0) {
                    fM3843constructorimpl = Dp.m3843constructorimpl(1);
                }
                if (i4 != 0) {
                    fM3843constructorimpl2 = Dp.m3843constructorimpl(0);
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m978getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM1630copywmQWz5c$default = j2;
                }
                if (i8 != 0) {
                    fM3843constructorimpl = Dp.m3843constructorimpl(1);
                }
                if (i4 != 0) {
                    fM3843constructorimpl2 = Dp.m3843constructorimpl(0);
                }
            }
            composerStartRestartGroup.endDefaults();
            if (fM3843constructorimpl2 != 0.0f) {
                companionM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, fM3843constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
            } else {
                companionM427paddingqDBjuR0$default = Modifier.INSTANCE;
            }
            composerStartRestartGroup.startReplaceableGroup(1228914189);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*55@2139L7");
            if (Dp.m3848equalsimpl0(fM3843constructorimpl, Dp.INSTANCE.m3861getHairlineD9Ej5fM())) {
                ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localDensity6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fM3843constructorimpl3 = Dp.m3843constructorimpl(1.0f / ((Density) objConsume6).getDensity());
            } else {
                fM3843constructorimpl3 = fM3843constructorimpl;
            }
            composerStartRestartGroup.endReplaceableGroup();
            BoxKt.Box(BackgroundKt.m176backgroundbw27NRU$default(SizeKt.m450height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(companionM427paddingqDBjuR0$default), 0.0f, 1, null), fM3843constructorimpl3), jM1630copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m978getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM1630copywmQWz5c$default = j2;
                }
                if (i8 != 0) {
                    fM3843constructorimpl = Dp.m3843constructorimpl(1);
                }
                if (i4 != 0) {
                    fM3843constructorimpl2 = Dp.m3843constructorimpl(0);
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m978getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM1630copywmQWz5c$default = j2;
                }
                if (i8 != 0) {
                    fM3843constructorimpl = Dp.m3843constructorimpl(1);
                }
                if (i4 != 0) {
                    fM3843constructorimpl2 = Dp.m3843constructorimpl(0);
                }
            }
            composerStartRestartGroup.endDefaults();
            if (fM3843constructorimpl2 != 0.0f) {
                companionM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, fM3843constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
            } else {
                companionM427paddingqDBjuR0$default = Modifier.INSTANCE;
            }
            composerStartRestartGroup.startReplaceableGroup(1228914189);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*55@2139L7");
            if (Dp.m3848equalsimpl0(fM3843constructorimpl, Dp.INSTANCE.m3861getHairlineD9Ej5fM())) {
                ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localDensity7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fM3843constructorimpl3 = Dp.m3843constructorimpl(1.0f / ((Density) objConsume7).getDensity());
            } else {
                fM3843constructorimpl3 = fM3843constructorimpl;
            }
            composerStartRestartGroup.endReplaceableGroup();
            BoxKt.Box(BackgroundKt.m176backgroundbw27NRU$default(SizeKt.m450height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(companionM427paddingqDBjuR0$default), 0.0f, 1, null), fM3843constructorimpl3), jM1630copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
        }
        f3 = fM3843constructorimpl;
        f4 = fM3843constructorimpl2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DividerKt$Divider$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i9) {
                DividerKt.m1019DivideroMI9zvI(companion, jM1630copywmQWz5c$default, f3, f4, composer2, i | 1, i2);
            }
        });
    }
}
