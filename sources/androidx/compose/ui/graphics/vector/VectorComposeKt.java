package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.constraintlayout.motion.widget.Key;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VectorCompose.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a©\u0001\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"Group", "", "name", "", Key.ROTATION, "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", VastAttributes.STROKE_COLOR, "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class VectorComposeKt {
    /* JADX WARN: Code duplicated, block: B:102:0x012f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0154  */
    /* JADX WARN: Code duplicated, block: B:110:0x015e  */
    /* JADX WARN: Code duplicated, block: B:117:0x0177 A[PHI: r1 r3 r4 r6 r7 r9 r13 r14 r15
  0x0177: PHI (r1v23 java.lang.String) = (r1v4 java.lang.String), (r1v24 java.lang.String) binds: [B:142:0x01a6, B:116:0x016b] A[DONT_GENERATE, DONT_INLINE]
  0x0177: PHI (r3v26 int) = (r3v22 int), (r3v27 int) binds: [B:142:0x01a6, B:116:0x016b] A[DONT_GENERATE, DONT_INLINE]
  0x0177: PHI (r4v6 float) = (r4v2 float), (r4v7 float) binds: [B:142:0x01a6, B:116:0x016b] A[DONT_GENERATE, DONT_INLINE]
  0x0177: PHI (r6v10 float) = (r6v6 float), (r6v11 float) binds: [B:142:0x01a6, B:116:0x016b] A[DONT_GENERATE, DONT_INLINE]
  0x0177: PHI (r7v14 float) = (r7v10 float), (r7v16 float) binds: [B:142:0x01a6, B:116:0x016b] A[DONT_GENERATE, DONT_INLINE]
  0x0177: PHI (r9v10 float) = (r9v6 float), (r9v11 float) binds: [B:142:0x01a6, B:116:0x016b] A[DONT_GENERATE, DONT_INLINE]
  0x0177: PHI (r13v6 float) = (r13v3 float), (r13v2 float) binds: [B:142:0x01a6, B:116:0x016b] A[DONT_GENERATE, DONT_INLINE]
  0x0177: PHI (r14v9 float) = (r14v6 float), (r14v10 float) binds: [B:142:0x01a6, B:116:0x016b] A[DONT_GENERATE, DONT_INLINE]
  0x0177: PHI (r15v7 float) = (r15v4 float), (r15v3 float) binds: [B:142:0x01a6, B:116:0x016b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:118:0x017a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x017c  */
    /* JADX WARN: Code duplicated, block: B:120:0x017f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0184  */
    /* JADX WARN: Code duplicated, block: B:124:0x0186  */
    /* JADX WARN: Code duplicated, block: B:126:0x018a  */
    /* JADX WARN: Code duplicated, block: B:127:0x018c  */
    /* JADX WARN: Code duplicated, block: B:129:0x0190  */
    /* JADX WARN: Code duplicated, block: B:132:0x0195  */
    /* JADX WARN: Code duplicated, block: B:135:0x0199  */
    /* JADX WARN: Code duplicated, block: B:137:0x019d  */
    /* JADX WARN: Code duplicated, block: B:138:0x019f  */
    /* JADX WARN: Code duplicated, block: B:141:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:143:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:146:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:149:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:155:0x026d  */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0057  */
    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    /* JADX WARN: Code duplicated, block: B:29:0x005e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0066  */
    /* JADX WARN: Code duplicated, block: B:32:0x0069  */
    /* JADX WARN: Code duplicated, block: B:37:0x0073  */
    /* JADX WARN: Code duplicated, block: B:38:0x0076  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0082  */
    /* JADX WARN: Code duplicated, block: B:43:0x0085  */
    /* JADX WARN: Code duplicated, block: B:48:0x008f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0092  */
    /* JADX WARN: Code duplicated, block: B:51:0x0098  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:84:0x0103  */
    /* JADX WARN: Code duplicated, block: B:85:0x0106  */
    /* JADX WARN: Code duplicated, block: B:89:0x010e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0116  */
    /* JADX WARN: Code duplicated, block: B:94:0x011a  */
    /* JADX WARN: Code duplicated, block: B:96:0x011f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0125  */
    /* JADX WARN: Code duplicated, block: B:99:0x0128  */
    public static final void Group(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List<? extends PathNode> list, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        float f8;
        int i7;
        int i8;
        float f9;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        String str2;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        List<? extends PathNode> emptyPath;
        AnonymousClass1 anonymousClass1;
        final float f15;
        final float f16;
        final float f17;
        final float f18;
        final float f19;
        final String str3;
        final List<? extends PathNode> list2;
        final float f20;
        final float f21;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-213417674);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Group)P(2,5,3,4,6,7,8,9)40@1441L585:VectorCompose.kt#huu6hf");
        int i18 = i2 & 1;
        if (i18 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i19 = i2 & 2;
        if (i19 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        f8 = f3;
                        if (composerStartRestartGroup.changed(f8)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((57344 & i) == 0) {
                            f9 = f4;
                            if (composerStartRestartGroup.changed(f9)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 32;
                        if (i10 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & 458752) == 0) {
                            if (composerStartRestartGroup.changed(f5)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        i12 = i2 & 64;
                        if (i12 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(f6)) {
                                i13 = 1048576;
                            } else {
                                i13 = 524288;
                            }
                            i3 |= i13;
                        }
                        i14 = i2 & 128;
                        if (i14 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 29360128) == 0) {
                            if (composerStartRestartGroup.changed(f7)) {
                                i15 = 8388608;
                            } else {
                                i15 = 4194304;
                            }
                            i3 |= i15;
                        }
                        i16 = i2 & 256;
                        if (i16 != 0) {
                            i3 |= 33554432;
                        }
                        if ((i2 & 512) != 0) {
                            if ((1879048192 & i) == 0) {
                                if (composerStartRestartGroup.changed(content)) {
                                    i17 = 536870912;
                                } else {
                                    i17 = 268435456;
                                }
                            }
                            if (i16 == 256 || (1533916891 & i3) != 306783378 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if (i16 != 0) {
                                        i3 &= -234881025;
                                    }
                                    str2 = str;
                                    f10 = f;
                                    f11 = f2;
                                    f12 = f5;
                                    f13 = f6;
                                    f14 = f7;
                                } else {
                                    if (i18 != 0) {
                                        str2 = "";
                                    } else {
                                        str2 = str;
                                    }
                                    if (i19 != 0) {
                                        f10 = 0.0f;
                                    } else {
                                        f10 = f;
                                    }
                                    if (i4 != 0) {
                                        f11 = 0.0f;
                                    } else {
                                        f11 = f2;
                                    }
                                    if (i6 != 0) {
                                        f8 = 0.0f;
                                    }
                                    if (i8 != 0) {
                                        f9 = 1.0f;
                                    }
                                    f12 = i10 == 0 ? f5 : 1.0f;
                                    if (i12 != 0) {
                                        f13 = 0.0f;
                                    } else {
                                        f13 = f6;
                                    }
                                    f14 = i14 == 0 ? f7 : 0.0f;
                                    if (i16 != 0) {
                                        emptyPath = VectorKt.getEmptyPath();
                                        i3 &= -234881025;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final GroupComponent invoke() {
                                            return new GroupComponent();
                                        }
                                    };
                                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composerStartRestartGroup.startNode();
                                    if (composerStartRestartGroup.getInserting()) {
                                        composerStartRestartGroup.createNode(anonymousClass1);
                                    } else {
                                        composerStartRestartGroup.useNode();
                                    }
                                    Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composerStartRestartGroup);
                                    Updater.m1293setimpl(composerM1286constructorimpl, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                            invoke2(groupComponent, str4);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(GroupComponent set, String it) {
                                            Intrinsics.checkNotNullParameter(set, "$this$set");
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            set.setName(it);
                                        }
                                    });
                                    Updater.m1293setimpl(composerM1286constructorimpl, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                            invoke(groupComponent, f22.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent set, float f22) {
                                            Intrinsics.checkNotNullParameter(set, "$this$set");
                                            set.setRotation(f22);
                                        }
                                    });
                                    Updater.m1293setimpl(composerM1286constructorimpl, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                            invoke(groupComponent, f22.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent set, float f22) {
                                            Intrinsics.checkNotNullParameter(set, "$this$set");
                                            set.setPivotX(f22);
                                        }
                                    });
                                    Updater.m1293setimpl(composerM1286constructorimpl, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                            invoke(groupComponent, f22.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent set, float f22) {
                                            Intrinsics.checkNotNullParameter(set, "$this$set");
                                            set.setPivotY(f22);
                                        }
                                    });
                                    Updater.m1293setimpl(composerM1286constructorimpl, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                            invoke(groupComponent, f22.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent set, float f22) {
                                            Intrinsics.checkNotNullParameter(set, "$this$set");
                                            set.setScaleX(f22);
                                        }
                                    });
                                    Updater.m1293setimpl(composerM1286constructorimpl, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                            invoke(groupComponent, f22.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent set, float f22) {
                                            Intrinsics.checkNotNullParameter(set, "$this$set");
                                            set.setScaleY(f22);
                                        }
                                    });
                                    Updater.m1293setimpl(composerM1286constructorimpl, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                            invoke(groupComponent, f22.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent set, float f22) {
                                            Intrinsics.checkNotNullParameter(set, "$this$set");
                                            set.setTranslationX(f22);
                                        }
                                    });
                                    Updater.m1293setimpl(composerM1286constructorimpl, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                            invoke(groupComponent, f22.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent set, float f22) {
                                            Intrinsics.checkNotNullParameter(set, "$this$set");
                                            set.setTranslationY(f22);
                                        }
                                    });
                                    Updater.m1293setimpl(composerM1286constructorimpl, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                            invoke2(groupComponent, list3);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                            Intrinsics.checkNotNullParameter(set, "$this$set");
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            set.setClipPathData(it);
                                        }
                                    });
                                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                                    composerStartRestartGroup.endReplaceableGroup();
                                    composerStartRestartGroup.endNode();
                                    composerStartRestartGroup.endReplaceableGroup();
                                    f15 = f11;
                                    f16 = f14;
                                    f17 = f12;
                                    f18 = f13;
                                    f19 = f9;
                                    str3 = str2;
                                    list2 = emptyPath;
                                    f20 = f10;
                                    f21 = f8;
                                }
                                emptyPath = list;
                                composerStartRestartGroup.endDefaults();
                                anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final GroupComponent invoke() {
                                        return new GroupComponent();
                                    }
                                };
                                composerStartRestartGroup.startReplaceableGroup(-548224868);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(anonymousClass1);
                                } else {
                                    composerStartRestartGroup.useNode();
                                }
                                Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composerStartRestartGroup);
                                Updater.m1293setimpl(composerM1286constructorimpl2, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                        invoke2(groupComponent, str4);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(GroupComponent set, String it) {
                                        Intrinsics.checkNotNullParameter(set, "$this$set");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        set.setName(it);
                                    }
                                });
                                Updater.m1293setimpl(composerM1286constructorimpl2, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                        invoke(groupComponent, f22.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GroupComponent set, float f22) {
                                        Intrinsics.checkNotNullParameter(set, "$this$set");
                                        set.setRotation(f22);
                                    }
                                });
                                Updater.m1293setimpl(composerM1286constructorimpl2, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                        invoke(groupComponent, f22.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GroupComponent set, float f22) {
                                        Intrinsics.checkNotNullParameter(set, "$this$set");
                                        set.setPivotX(f22);
                                    }
                                });
                                Updater.m1293setimpl(composerM1286constructorimpl2, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                        invoke(groupComponent, f22.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GroupComponent set, float f22) {
                                        Intrinsics.checkNotNullParameter(set, "$this$set");
                                        set.setPivotY(f22);
                                    }
                                });
                                Updater.m1293setimpl(composerM1286constructorimpl2, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                        invoke(groupComponent, f22.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GroupComponent set, float f22) {
                                        Intrinsics.checkNotNullParameter(set, "$this$set");
                                        set.setScaleX(f22);
                                    }
                                });
                                Updater.m1293setimpl(composerM1286constructorimpl2, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                        invoke(groupComponent, f22.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GroupComponent set, float f22) {
                                        Intrinsics.checkNotNullParameter(set, "$this$set");
                                        set.setScaleY(f22);
                                    }
                                });
                                Updater.m1293setimpl(composerM1286constructorimpl2, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                        invoke(groupComponent, f22.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GroupComponent set, float f22) {
                                        Intrinsics.checkNotNullParameter(set, "$this$set");
                                        set.setTranslationX(f22);
                                    }
                                });
                                Updater.m1293setimpl(composerM1286constructorimpl2, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                        invoke(groupComponent, f22.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GroupComponent set, float f22) {
                                        Intrinsics.checkNotNullParameter(set, "$this$set");
                                        set.setTranslationY(f22);
                                    }
                                });
                                Updater.m1293setimpl(composerM1286constructorimpl2, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                        invoke2(groupComponent, list3);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                        Intrinsics.checkNotNullParameter(set, "$this$set");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        set.setClipPathData(it);
                                    }
                                });
                                composerStartRestartGroup.startReplaceableGroup(-983907633);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                                content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endNode();
                                composerStartRestartGroup.endReplaceableGroup();
                                f15 = f11;
                                f16 = f14;
                                f17 = f12;
                                f18 = f13;
                                f19 = f9;
                                str3 = str2;
                                list2 = emptyPath;
                                f20 = f10;
                                f21 = f8;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                str3 = str;
                                f20 = f;
                                f15 = f2;
                                f17 = f5;
                                f18 = f6;
                                f16 = f7;
                                list2 = list;
                                f21 = f8;
                                f19 = f9;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                                public final void invoke(Composer composer2, int i20) {
                                    VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                                }
                            });
                        }
                        i17 = C.ENCODING_PCM_32BIT;
                        i3 |= i17;
                        if (i16 == 256) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) == 0) {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            } else {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final GroupComponent invoke() {
                                    return new GroupComponent();
                                }
                            };
                            composerStartRestartGroup.startReplaceableGroup(-548224868);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(anonymousClass1);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl3, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                    invoke2(groupComponent, str4);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, String it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setName(it);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl3, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setRotation(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl3, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl3, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl3, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl3, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl3, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl3, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl3, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                    invoke2(groupComponent, list3);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setClipPathData(it);
                                }
                            });
                            composerStartRestartGroup.startReplaceableGroup(-983907633);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                            content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            f15 = f11;
                            f16 = f14;
                            f17 = f12;
                            f18 = f13;
                            f19 = f9;
                            str3 = str2;
                            list2 = emptyPath;
                            f20 = f10;
                            f21 = f8;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) == 0) {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            } else {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final GroupComponent invoke() {
                                    return new GroupComponent();
                                }
                            };
                            composerStartRestartGroup.startReplaceableGroup(-548224868);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(anonymousClass1);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM1286constructorimpl4 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl4, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                    invoke2(groupComponent, str4);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, String it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setName(it);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl4, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setRotation(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl4, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl4, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl4, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl4, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl4, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl4, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl4, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                    invoke2(groupComponent, list3);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setClipPathData(it);
                                }
                            });
                            composerStartRestartGroup.startReplaceableGroup(-983907633);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                            content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            f15 = f11;
                            f16 = f14;
                            f17 = f12;
                            f18 = f13;
                            f19 = f9;
                            str3 = str2;
                            list2 = emptyPath;
                            f20 = f10;
                            f21 = f8;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                            public final void invoke(Composer composer2, int i20) {
                                VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                            }
                        });
                    }
                    i3 |= 24576;
                    f9 = f4;
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(f5)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(f6)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    i14 = i2 & 128;
                    if (i14 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(f7)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i3 |= i15;
                    }
                    i16 = i2 & 256;
                    if (i16 != 0) {
                        i3 |= 33554432;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i17 = 536870912;
                            } else {
                                i17 = 268435456;
                            }
                        }
                        if (i16 == 256) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) == 0) {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            } else {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final GroupComponent invoke() {
                                    return new GroupComponent();
                                }
                            };
                            composerStartRestartGroup.startReplaceableGroup(-548224868);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(anonymousClass1);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM1286constructorimpl5 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl5, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                    invoke2(groupComponent, str4);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, String it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setName(it);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl5, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setRotation(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl5, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl5, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl5, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl5, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl5, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl5, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl5, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                    invoke2(groupComponent, list3);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setClipPathData(it);
                                }
                            });
                            composerStartRestartGroup.startReplaceableGroup(-983907633);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                            content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            f15 = f11;
                            f16 = f14;
                            f17 = f12;
                            f18 = f13;
                            f19 = f9;
                            str3 = str2;
                            list2 = emptyPath;
                            f20 = f10;
                            f21 = f8;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) == 0) {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            } else {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final GroupComponent invoke() {
                                    return new GroupComponent();
                                }
                            };
                            composerStartRestartGroup.startReplaceableGroup(-548224868);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(anonymousClass1);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM1286constructorimpl6 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl6, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                    invoke2(groupComponent, str4);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, String it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setName(it);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl6, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setRotation(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl6, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl6, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl6, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl6, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl6, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl6, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl6, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                    invoke2(groupComponent, list3);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setClipPathData(it);
                                }
                            });
                            composerStartRestartGroup.startReplaceableGroup(-983907633);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                            content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            f15 = f11;
                            f16 = f14;
                            f17 = f12;
                            f18 = f13;
                            f19 = f9;
                            str3 = str2;
                            list2 = emptyPath;
                            f20 = f10;
                            f21 = f8;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                            public final void invoke(Composer composer2, int i20) {
                                VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                            }
                        });
                    }
                    i17 = C.ENCODING_PCM_32BIT;
                    i3 |= i17;
                    if (i16 == 256) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl7 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl7, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl7, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl7, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl7, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl7, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl7, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl7, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl7, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl7, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl8 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl8, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl8, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl8, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl8, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl8, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl8, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl8, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl8, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl8, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                        public final void invoke(Composer composer2, int i20) {
                            VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 3072;
                f8 = f3;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        f9 = f4;
                        if (composerStartRestartGroup.changed(f9)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(f5)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(f6)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    i14 = i2 & 128;
                    if (i14 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(f7)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i3 |= i15;
                    }
                    i16 = i2 & 256;
                    if (i16 != 0) {
                        i3 |= 33554432;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i17 = 536870912;
                            } else {
                                i17 = 268435456;
                            }
                        }
                        if (i16 == 256) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) == 0) {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            } else {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final GroupComponent invoke() {
                                    return new GroupComponent();
                                }
                            };
                            composerStartRestartGroup.startReplaceableGroup(-548224868);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(anonymousClass1);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM1286constructorimpl9 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl9, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                    invoke2(groupComponent, str4);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, String it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setName(it);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl9, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setRotation(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl9, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl9, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl9, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl9, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl9, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl9, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl9, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                    invoke2(groupComponent, list3);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setClipPathData(it);
                                }
                            });
                            composerStartRestartGroup.startReplaceableGroup(-983907633);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                            content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            f15 = f11;
                            f16 = f14;
                            f17 = f12;
                            f18 = f13;
                            f19 = f9;
                            str3 = str2;
                            list2 = emptyPath;
                            f20 = f10;
                            f21 = f8;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) == 0) {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            } else {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final GroupComponent invoke() {
                                    return new GroupComponent();
                                }
                            };
                            composerStartRestartGroup.startReplaceableGroup(-548224868);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(anonymousClass1);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM1286constructorimpl10 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl10, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                    invoke2(groupComponent, str4);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, String it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setName(it);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl10, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setRotation(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl10, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl10, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl10, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl10, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl10, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl10, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl10, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                    invoke2(groupComponent, list3);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setClipPathData(it);
                                }
                            });
                            composerStartRestartGroup.startReplaceableGroup(-983907633);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                            content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            f15 = f11;
                            f16 = f14;
                            f17 = f12;
                            f18 = f13;
                            f19 = f9;
                            str3 = str2;
                            list2 = emptyPath;
                            f20 = f10;
                            f21 = f8;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                            public final void invoke(Composer composer2, int i20) {
                                VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                            }
                        });
                    }
                    i17 = C.ENCODING_PCM_32BIT;
                    i3 |= i17;
                    if (i16 == 256) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl11 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl11, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl12 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl12, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl12, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl12, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl12, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl12, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl12, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl12, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl12, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl12, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                        public final void invoke(Composer composer2, int i20) {
                            VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                f9 = f4;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f5)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f6)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f7)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                i16 = i2 & 256;
                if (i16 != 0) {
                    i3 |= 33554432;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i17 = 536870912;
                        } else {
                            i17 = 268435456;
                        }
                    }
                    if (i16 == 256) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl13 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl13, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl13, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl13, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl13, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl13, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl13, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl13, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl13, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl13, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl14 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl14, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl14, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl14, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl14, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl14, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl14, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl14, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl14, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl14, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                        public final void invoke(Composer composer2, int i20) {
                            VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                        }
                    });
                }
                i17 = C.ENCODING_PCM_32BIT;
                i3 |= i17;
                if (i16 == 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl15 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl15, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl15, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl15, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl15, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl15, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl15, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl15, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl15, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl15, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl16 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl16, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl16, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl16, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl16, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl16, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl16, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl16, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl16, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl16, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                    public final void invoke(Composer composer2, int i20) {
                        VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 384;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    f8 = f3;
                    if (composerStartRestartGroup.changed(f8)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        f9 = f4;
                        if (composerStartRestartGroup.changed(f9)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(f5)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(f6)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    i14 = i2 & 128;
                    if (i14 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(f7)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i3 |= i15;
                    }
                    i16 = i2 & 256;
                    if (i16 != 0) {
                        i3 |= 33554432;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i17 = 536870912;
                            } else {
                                i17 = 268435456;
                            }
                        }
                        if (i16 == 256) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) == 0) {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            } else {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final GroupComponent invoke() {
                                    return new GroupComponent();
                                }
                            };
                            composerStartRestartGroup.startReplaceableGroup(-548224868);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(anonymousClass1);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM1286constructorimpl17 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl17, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                    invoke2(groupComponent, str4);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, String it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setName(it);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl17, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setRotation(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl17, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl17, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl17, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl17, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl17, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl17, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl17, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                    invoke2(groupComponent, list3);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setClipPathData(it);
                                }
                            });
                            composerStartRestartGroup.startReplaceableGroup(-983907633);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                            content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            f15 = f11;
                            f16 = f14;
                            f17 = f12;
                            f18 = f13;
                            f19 = f9;
                            str3 = str2;
                            list2 = emptyPath;
                            f20 = f10;
                            f21 = f8;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) == 0) {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            } else {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final GroupComponent invoke() {
                                    return new GroupComponent();
                                }
                            };
                            composerStartRestartGroup.startReplaceableGroup(-548224868);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(anonymousClass1);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM1286constructorimpl18 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl18, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                    invoke2(groupComponent, str4);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, String it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setName(it);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl18, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setRotation(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl18, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl18, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl18, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl18, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl18, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl18, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl18, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                    invoke2(groupComponent, list3);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setClipPathData(it);
                                }
                            });
                            composerStartRestartGroup.startReplaceableGroup(-983907633);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                            content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            f15 = f11;
                            f16 = f14;
                            f17 = f12;
                            f18 = f13;
                            f19 = f9;
                            str3 = str2;
                            list2 = emptyPath;
                            f20 = f10;
                            f21 = f8;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                            public final void invoke(Composer composer2, int i20) {
                                VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                            }
                        });
                    }
                    i17 = C.ENCODING_PCM_32BIT;
                    i3 |= i17;
                    if (i16 == 256) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl19 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl19, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl19, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl19, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl19, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl19, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl19, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl19, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl19, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl19, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl110 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl110, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl110, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl110, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl110, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl110, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl110, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl110, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl110, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl110, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                        public final void invoke(Composer composer2, int i20) {
                            VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                f9 = f4;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f5)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f6)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f7)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                i16 = i2 & 256;
                if (i16 != 0) {
                    i3 |= 33554432;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i17 = 536870912;
                        } else {
                            i17 = 268435456;
                        }
                    }
                    if (i16 == 256) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl111 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl111, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl112 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl112, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl112, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl112, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl112, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl112, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl112, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl112, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl112, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl112, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                        public final void invoke(Composer composer2, int i20) {
                            VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                        }
                    });
                }
                i17 = C.ENCODING_PCM_32BIT;
                i3 |= i17;
                if (i16 == 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl113 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl113, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl113, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl113, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl113, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl113, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl113, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl113, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl113, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl113, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl114 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl114, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl114, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl114, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl114, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl114, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl114, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl114, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl114, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl114, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                    public final void invoke(Composer composer2, int i20) {
                        VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            f8 = f3;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    f9 = f4;
                    if (composerStartRestartGroup.changed(f9)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f5)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f6)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f7)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                i16 = i2 & 256;
                if (i16 != 0) {
                    i3 |= 33554432;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i17 = 536870912;
                        } else {
                            i17 = 268435456;
                        }
                    }
                    if (i16 == 256) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl115 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl115, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl115, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl115, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl115, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl115, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl115, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl115, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl115, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl115, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl116 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl116, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl116, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl116, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl116, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl116, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl116, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl116, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl116, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl116, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                        public final void invoke(Composer composer2, int i20) {
                            VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                        }
                    });
                }
                i17 = C.ENCODING_PCM_32BIT;
                i3 |= i17;
                if (i16 == 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl117 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl117, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl117, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl117, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl117, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl117, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl117, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl117, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl117, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl117, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl118 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl118, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl118, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl118, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl118, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl118, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl118, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl118, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl118, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl118, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                    public final void invoke(Composer composer2, int i20) {
                        VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            f9 = f4;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(f5)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f6)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i14 = i2 & 128;
            if (i14 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(f7)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i3 |= i15;
            }
            i16 = i2 & 256;
            if (i16 != 0) {
                i3 |= 33554432;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i17 = 536870912;
                    } else {
                        i17 = 268435456;
                    }
                }
                if (i16 == 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl119 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl119, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl119, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl119, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl119, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl119, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl119, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl119, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl119, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl119, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl1110 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl1110, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1110, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1110, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1110, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1110, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1110, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1110, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1110, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1110, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                    public final void invoke(Composer composer2, int i20) {
                        VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                    }
                });
            }
            i17 = C.ENCODING_PCM_32BIT;
            i3 |= i17;
            if (i16 == 256) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GroupComponent invoke() {
                        return new GroupComponent();
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM1286constructorimpl1111 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl1111, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                        invoke2(groupComponent, str4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, String it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setName(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setRotation(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                        invoke2(groupComponent, list3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setClipPathData(it);
                    }
                });
                composerStartRestartGroup.startReplaceableGroup(-983907633);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                f15 = f11;
                f16 = f14;
                f17 = f12;
                f18 = f13;
                f19 = f9;
                str3 = str2;
                list2 = emptyPath;
                f20 = f10;
                f21 = f8;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GroupComponent invoke() {
                        return new GroupComponent();
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM1286constructorimpl1112 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl1112, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                        invoke2(groupComponent, str4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, String it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setName(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1112, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setRotation(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1112, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1112, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1112, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1112, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1112, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1112, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1112, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                        invoke2(groupComponent, list3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setClipPathData(it);
                    }
                });
                composerStartRestartGroup.startReplaceableGroup(-983907633);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                f15 = f11;
                f16 = f14;
                f17 = f12;
                f18 = f13;
                f19 = f9;
                str3 = str2;
                list2 = emptyPath;
                f20 = f10;
                f21 = f8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                public final void invoke(Composer composer2, int i20) {
                    VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    f8 = f3;
                    if (composerStartRestartGroup.changed(f8)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        f9 = f4;
                        if (composerStartRestartGroup.changed(f9)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(f5)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(f6)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    i14 = i2 & 128;
                    if (i14 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(f7)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i3 |= i15;
                    }
                    i16 = i2 & 256;
                    if (i16 != 0) {
                        i3 |= 33554432;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i17 = 536870912;
                            } else {
                                i17 = 268435456;
                            }
                        }
                        if (i16 == 256) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) == 0) {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            } else {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final GroupComponent invoke() {
                                    return new GroupComponent();
                                }
                            };
                            composerStartRestartGroup.startReplaceableGroup(-548224868);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(anonymousClass1);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM1286constructorimpl1113 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl1113, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                    invoke2(groupComponent, str4);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, String it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setName(it);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1113, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setRotation(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1113, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1113, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1113, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1113, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1113, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1113, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1113, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                    invoke2(groupComponent, list3);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setClipPathData(it);
                                }
                            });
                            composerStartRestartGroup.startReplaceableGroup(-983907633);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                            content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            f15 = f11;
                            f16 = f14;
                            f17 = f12;
                            f18 = f13;
                            f19 = f9;
                            str3 = str2;
                            list2 = emptyPath;
                            f20 = f10;
                            f21 = f8;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) == 0) {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            } else {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f11 = 0.0f;
                                } else {
                                    f11 = f2;
                                }
                                if (i6 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f9 = 1.0f;
                                }
                                if (i10 == 0) {
                                }
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                if (i14 == 0) {
                                }
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final GroupComponent invoke() {
                                    return new GroupComponent();
                                }
                            };
                            composerStartRestartGroup.startReplaceableGroup(-548224868);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(anonymousClass1);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM1286constructorimpl1114 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl1114, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                    invoke2(groupComponent, str4);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, String it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setName(it);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1114, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setRotation(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1114, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1114, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setPivotY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1114, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1114, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setScaleY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1114, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationX(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1114, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                    invoke(groupComponent, f22.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent set, float f22) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setTranslationY(f22);
                                }
                            });
                            Updater.m1293setimpl(composerM1286constructorimpl1114, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                    invoke2(groupComponent, list3);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setClipPathData(it);
                                }
                            });
                            composerStartRestartGroup.startReplaceableGroup(-983907633);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                            content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            f15 = f11;
                            f16 = f14;
                            f17 = f12;
                            f18 = f13;
                            f19 = f9;
                            str3 = str2;
                            list2 = emptyPath;
                            f20 = f10;
                            f21 = f8;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                            public final void invoke(Composer composer2, int i20) {
                                VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                            }
                        });
                    }
                    i17 = C.ENCODING_PCM_32BIT;
                    i3 |= i17;
                    if (i16 == 256) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl1115 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl1115, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1115, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1115, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1115, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1115, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1115, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1115, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1115, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1115, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl1116 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl1116, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1116, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1116, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1116, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1116, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1116, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1116, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1116, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1116, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                        public final void invoke(Composer composer2, int i20) {
                            VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                f9 = f4;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f5)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f6)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f7)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                i16 = i2 & 256;
                if (i16 != 0) {
                    i3 |= 33554432;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i17 = 536870912;
                        } else {
                            i17 = 268435456;
                        }
                    }
                    if (i16 == 256) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl1117 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl1117, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1117, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1117, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1117, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1117, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1117, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1117, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1117, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1117, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl1118 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl1118, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1118, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1118, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1118, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1118, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1118, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1118, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1118, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl1118, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                        public final void invoke(Composer composer2, int i20) {
                            VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                        }
                    });
                }
                i17 = C.ENCODING_PCM_32BIT;
                i3 |= i17;
                if (i16 == 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl1119 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl1119, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1119, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1119, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1119, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1119, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1119, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1119, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1119, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl1119, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl11110 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl11110, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11110, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11110, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11110, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11110, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11110, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11110, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11110, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11110, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                    public final void invoke(Composer composer2, int i20) {
                        VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            f8 = f3;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    f9 = f4;
                    if (composerStartRestartGroup.changed(f9)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f5)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f6)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f7)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                i16 = i2 & 256;
                if (i16 != 0) {
                    i3 |= 33554432;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i17 = 536870912;
                        } else {
                            i17 = 268435456;
                        }
                    }
                    if (i16 == 256) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl11111 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl11111, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11111, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11111, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11111, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11111, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11111, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11111, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11111, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11111, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl11112 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl11112, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11112, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11112, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11112, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11112, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11112, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11112, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11112, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11112, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                        public final void invoke(Composer composer2, int i20) {
                            VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                        }
                    });
                }
                i17 = C.ENCODING_PCM_32BIT;
                i3 |= i17;
                if (i16 == 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl11113 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl11113, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11113, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11113, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11113, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11113, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11113, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11113, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11113, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11113, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl11114 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl11114, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11114, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11114, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11114, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11114, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11114, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11114, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11114, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11114, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                    public final void invoke(Composer composer2, int i20) {
                        VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            f9 = f4;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(f5)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f6)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i14 = i2 & 128;
            if (i14 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(f7)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i3 |= i15;
            }
            i16 = i2 & 256;
            if (i16 != 0) {
                i3 |= 33554432;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i17 = 536870912;
                    } else {
                        i17 = 268435456;
                    }
                }
                if (i16 == 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl11115 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl11115, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11115, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11115, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11115, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11115, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11115, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11115, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11115, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11115, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl11116 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl11116, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11116, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11116, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11116, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11116, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11116, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11116, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11116, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl11116, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                    public final void invoke(Composer composer2, int i20) {
                        VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                    }
                });
            }
            i17 = C.ENCODING_PCM_32BIT;
            i3 |= i17;
            if (i16 == 256) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GroupComponent invoke() {
                        return new GroupComponent();
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM1286constructorimpl11117 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl11117, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                        invoke2(groupComponent, str4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, String it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setName(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11117, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setRotation(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11117, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11117, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11117, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11117, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11117, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11117, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11117, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                        invoke2(groupComponent, list3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setClipPathData(it);
                    }
                });
                composerStartRestartGroup.startReplaceableGroup(-983907633);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                f15 = f11;
                f16 = f14;
                f17 = f12;
                f18 = f13;
                f19 = f9;
                str3 = str2;
                list2 = emptyPath;
                f20 = f10;
                f21 = f8;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GroupComponent invoke() {
                        return new GroupComponent();
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM1286constructorimpl11118 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl11118, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                        invoke2(groupComponent, str4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, String it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setName(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11118, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setRotation(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11118, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11118, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11118, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11118, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11118, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11118, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl11118, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                        invoke2(groupComponent, list3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setClipPathData(it);
                    }
                });
                composerStartRestartGroup.startReplaceableGroup(-983907633);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                f15 = f11;
                f16 = f14;
                f17 = f12;
                f18 = f13;
                f19 = f9;
                str3 = str2;
                list2 = emptyPath;
                f20 = f10;
                f21 = f8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                public final void invoke(Composer composer2, int i20) {
                    VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                f8 = f3;
                if (composerStartRestartGroup.changed(f8)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    f9 = f4;
                    if (composerStartRestartGroup.changed(f9)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f5)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f6)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f7)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                i16 = i2 & 256;
                if (i16 != 0) {
                    i3 |= 33554432;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i17 = 536870912;
                        } else {
                            i17 = 268435456;
                        }
                    }
                    if (i16 == 256) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl11119 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl11119, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11119, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11119, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11119, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11119, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11119, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11119, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11119, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl11119, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f11 = 0.0f;
                            } else {
                                f11 = f2;
                            }
                            if (i6 != 0) {
                                f8 = 0.0f;
                            }
                            if (i8 != 0) {
                                f9 = 1.0f;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM1286constructorimpl111110 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl111110, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, String it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setName(it);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111110, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setRotation(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111110, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111110, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setPivotY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111110, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111110, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setScaleY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111110, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationX(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111110, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                                invoke(groupComponent, f22.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent set, float f22) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setTranslationY(f22);
                            }
                        });
                        Updater.m1293setimpl(composerM1286constructorimpl111110, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                invoke2(groupComponent, list3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.setClipPathData(it);
                            }
                        });
                        composerStartRestartGroup.startReplaceableGroup(-983907633);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        f15 = f11;
                        f16 = f14;
                        f17 = f12;
                        f18 = f13;
                        f19 = f9;
                        str3 = str2;
                        list2 = emptyPath;
                        f20 = f10;
                        f21 = f8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                        public final void invoke(Composer composer2, int i20) {
                            VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                        }
                    });
                }
                i17 = C.ENCODING_PCM_32BIT;
                i3 |= i17;
                if (i16 == 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl111111 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl111111, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111111, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111111, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111111, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111111, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111111, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111111, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111111, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111111, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl111112 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl111112, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111112, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111112, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111112, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111112, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111112, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111112, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111112, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111112, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                    public final void invoke(Composer composer2, int i20) {
                        VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            f9 = f4;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(f5)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f6)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i14 = i2 & 128;
            if (i14 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(f7)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i3 |= i15;
            }
            i16 = i2 & 256;
            if (i16 != 0) {
                i3 |= 33554432;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i17 = 536870912;
                    } else {
                        i17 = 268435456;
                    }
                }
                if (i16 == 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl111113 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl111113, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111113, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111113, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111113, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111113, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111113, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111113, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111113, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111113, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl111114 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl111114, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111114, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111114, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111114, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111114, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111114, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111114, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111114, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111114, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                    public final void invoke(Composer composer2, int i20) {
                        VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                    }
                });
            }
            i17 = C.ENCODING_PCM_32BIT;
            i3 |= i17;
            if (i16 == 256) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GroupComponent invoke() {
                        return new GroupComponent();
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM1286constructorimpl111115 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl111115, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                        invoke2(groupComponent, str4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, String it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setName(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111115, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setRotation(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111115, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111115, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111115, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111115, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111115, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111115, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111115, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                        invoke2(groupComponent, list3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setClipPathData(it);
                    }
                });
                composerStartRestartGroup.startReplaceableGroup(-983907633);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                f15 = f11;
                f16 = f14;
                f17 = f12;
                f18 = f13;
                f19 = f9;
                str3 = str2;
                list2 = emptyPath;
                f20 = f10;
                f21 = f8;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GroupComponent invoke() {
                        return new GroupComponent();
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM1286constructorimpl111116 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl111116, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                        invoke2(groupComponent, str4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, String it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setName(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111116, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setRotation(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111116, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111116, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111116, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111116, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111116, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111116, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111116, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                        invoke2(groupComponent, list3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setClipPathData(it);
                    }
                });
                composerStartRestartGroup.startReplaceableGroup(-983907633);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                f15 = f11;
                f16 = f14;
                f17 = f12;
                f18 = f13;
                f19 = f9;
                str3 = str2;
                list2 = emptyPath;
                f20 = f10;
                f21 = f8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                public final void invoke(Composer composer2, int i20) {
                    VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        f8 = f3;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((57344 & i) == 0) {
                f9 = f4;
                if (composerStartRestartGroup.changed(f9)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(f5)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f6)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i14 = i2 & 128;
            if (i14 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(f7)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i3 |= i15;
            }
            i16 = i2 & 256;
            if (i16 != 0) {
                i3 |= 33554432;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i17 = 536870912;
                    } else {
                        i17 = 268435456;
                    }
                }
                if (i16 == 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl111117 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl111117, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111117, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111117, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111117, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111117, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111117, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111117, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111117, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111117, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f11 = 0.0f;
                        } else {
                            f11 = f2;
                        }
                        if (i6 != 0) {
                            f8 = 0.0f;
                        }
                        if (i8 != 0) {
                            f9 = 1.0f;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1286constructorimpl111118 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl111118, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, String it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setName(it);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111118, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setRotation(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111118, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111118, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setPivotY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111118, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111118, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setScaleY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111118, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationX(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111118, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                            invoke(groupComponent, f22.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent set, float f22) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setTranslationY(f22);
                        }
                    });
                    Updater.m1293setimpl(composerM1286constructorimpl111118, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                            invoke2(groupComponent, list3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setClipPathData(it);
                        }
                    });
                    composerStartRestartGroup.startReplaceableGroup(-983907633);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    f15 = f11;
                    f16 = f14;
                    f17 = f12;
                    f18 = f13;
                    f19 = f9;
                    str3 = str2;
                    list2 = emptyPath;
                    f20 = f10;
                    f21 = f8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                    public final void invoke(Composer composer2, int i20) {
                        VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                    }
                });
            }
            i17 = C.ENCODING_PCM_32BIT;
            i3 |= i17;
            if (i16 == 256) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GroupComponent invoke() {
                        return new GroupComponent();
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM1286constructorimpl111119 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl111119, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                        invoke2(groupComponent, str4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, String it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setName(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111119, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setRotation(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111119, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111119, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111119, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111119, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111119, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111119, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl111119, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                        invoke2(groupComponent, list3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setClipPathData(it);
                    }
                });
                composerStartRestartGroup.startReplaceableGroup(-983907633);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                f15 = f11;
                f16 = f14;
                f17 = f12;
                f18 = f13;
                f19 = f9;
                str3 = str2;
                list2 = emptyPath;
                f20 = f10;
                f21 = f8;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GroupComponent invoke() {
                        return new GroupComponent();
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM1286constructorimpl1111110 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl1111110, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                        invoke2(groupComponent, str4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, String it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setName(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111110, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setRotation(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111110, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111110, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111110, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111110, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111110, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111110, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111110, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                        invoke2(groupComponent, list3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setClipPathData(it);
                    }
                });
                composerStartRestartGroup.startReplaceableGroup(-983907633);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                f15 = f11;
                f16 = f14;
                f17 = f12;
                f18 = f13;
                f19 = f9;
                str3 = str2;
                list2 = emptyPath;
                f20 = f10;
                f21 = f8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                public final void invoke(Composer composer2, int i20) {
                    VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        f9 = f4;
        i10 = i2 & 32;
        if (i10 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            if (composerStartRestartGroup.changed(f5)) {
                i11 = 131072;
            } else {
                i11 = 65536;
            }
            i3 |= i11;
        }
        i12 = i2 & 64;
        if (i12 != 0) {
            i3 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(f6)) {
                i13 = 1048576;
            } else {
                i13 = 524288;
            }
            i3 |= i13;
        }
        i14 = i2 & 128;
        if (i14 != 0) {
            i3 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changed(f7)) {
                i15 = 8388608;
            } else {
                i15 = 4194304;
            }
            i3 |= i15;
        }
        i16 = i2 & 256;
        if (i16 != 0) {
            i3 |= 33554432;
        }
        if ((i2 & 512) != 0) {
            if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i17 = 536870912;
                } else {
                    i17 = 268435456;
                }
            }
            if (i16 == 256) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GroupComponent invoke() {
                        return new GroupComponent();
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM1286constructorimpl1111111 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl1111111, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                        invoke2(groupComponent, str4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, String it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setName(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111111, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setRotation(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111111, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111111, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111111, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111111, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111111, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111111, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111111, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                        invoke2(groupComponent, list3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setClipPathData(it);
                    }
                });
                composerStartRestartGroup.startReplaceableGroup(-983907633);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                f15 = f11;
                f16 = f14;
                f17 = f12;
                f18 = f13;
                f19 = f9;
                str3 = str2;
                list2 = emptyPath;
                f20 = f10;
                f21 = f8;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f11 = 0.0f;
                    } else {
                        f11 = f2;
                    }
                    if (i6 != 0) {
                        f8 = 0.0f;
                    }
                    if (i8 != 0) {
                        f9 = 1.0f;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GroupComponent invoke() {
                        return new GroupComponent();
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM1286constructorimpl1111112 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl1111112, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                        invoke2(groupComponent, str4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, String it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setName(it);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111112, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setRotation(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111112, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111112, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111112, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111112, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111112, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationX(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111112, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                        invoke(groupComponent, f22.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float f22) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationY(f22);
                    }
                });
                Updater.m1293setimpl(composerM1286constructorimpl1111112, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                        invoke2(groupComponent, list3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setClipPathData(it);
                    }
                });
                composerStartRestartGroup.startReplaceableGroup(-983907633);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
                content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                f15 = f11;
                f16 = f14;
                f17 = f12;
                f18 = f13;
                f19 = f9;
                str3 = str2;
                list2 = emptyPath;
                f20 = f10;
                f21 = f8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                public final void invoke(Composer composer2, int i20) {
                    VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
                }
            });
        }
        i17 = C.ENCODING_PCM_32BIT;
        i3 |= i17;
        if (i16 == 256) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i18 != 0) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                if (i19 != 0) {
                    f10 = 0.0f;
                } else {
                    f10 = f;
                }
                if (i4 != 0) {
                    f11 = 0.0f;
                } else {
                    f11 = f2;
                }
                if (i6 != 0) {
                    f8 = 0.0f;
                }
                if (i8 != 0) {
                    f9 = 1.0f;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f13 = 0.0f;
                } else {
                    f13 = f6;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            } else {
                if (i18 != 0) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                if (i19 != 0) {
                    f10 = 0.0f;
                } else {
                    f10 = f;
                }
                if (i4 != 0) {
                    f11 = 0.0f;
                } else {
                    f11 = f2;
                }
                if (i6 != 0) {
                    f8 = 0.0f;
                }
                if (i8 != 0) {
                    f9 = 1.0f;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f13 = 0.0f;
                } else {
                    f13 = f6;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            }
            composerStartRestartGroup.endDefaults();
            anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final GroupComponent invoke() {
                    return new GroupComponent();
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-548224868);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(anonymousClass1);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM1286constructorimpl1111113 = Updater.m1286constructorimpl(composerStartRestartGroup);
            Updater.m1293setimpl(composerM1286constructorimpl1111113, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                    invoke2(groupComponent, str4);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GroupComponent set, String it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    set.setName(it);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111113, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                    invoke(groupComponent, f22.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent set, float f22) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setRotation(f22);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111113, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                    invoke(groupComponent, f22.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent set, float f22) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setPivotX(f22);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111113, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                    invoke(groupComponent, f22.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent set, float f22) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setPivotY(f22);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111113, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                    invoke(groupComponent, f22.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent set, float f22) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setScaleX(f22);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111113, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                    invoke(groupComponent, f22.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent set, float f22) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setScaleY(f22);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111113, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                    invoke(groupComponent, f22.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent set, float f22) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setTranslationX(f22);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111113, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                    invoke(groupComponent, f22.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent set, float f22) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setTranslationY(f22);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111113, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                    invoke2(groupComponent, list3);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    set.setClipPathData(it);
                }
            });
            composerStartRestartGroup.startReplaceableGroup(-983907633);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
            content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            f15 = f11;
            f16 = f14;
            f17 = f12;
            f18 = f13;
            f19 = f9;
            str3 = str2;
            list2 = emptyPath;
            f20 = f10;
            f21 = f8;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i18 != 0) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                if (i19 != 0) {
                    f10 = 0.0f;
                } else {
                    f10 = f;
                }
                if (i4 != 0) {
                    f11 = 0.0f;
                } else {
                    f11 = f2;
                }
                if (i6 != 0) {
                    f8 = 0.0f;
                }
                if (i8 != 0) {
                    f9 = 1.0f;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f13 = 0.0f;
                } else {
                    f13 = f6;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            } else {
                if (i18 != 0) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                if (i19 != 0) {
                    f10 = 0.0f;
                } else {
                    f10 = f;
                }
                if (i4 != 0) {
                    f11 = 0.0f;
                } else {
                    f11 = f2;
                }
                if (i6 != 0) {
                    f8 = 0.0f;
                }
                if (i8 != 0) {
                    f9 = 1.0f;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f13 = 0.0f;
                } else {
                    f13 = f6;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            }
            composerStartRestartGroup.endDefaults();
            anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final GroupComponent invoke() {
                    return new GroupComponent();
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-548224868);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode)P(1,2)334@12488L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(anonymousClass1);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM1286constructorimpl1111114 = Updater.m1286constructorimpl(composerStartRestartGroup);
            Updater.m1293setimpl(composerM1286constructorimpl1111114, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                    invoke2(groupComponent, str4);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GroupComponent set, String it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    set.setName(it);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111114, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                    invoke(groupComponent, f22.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent set, float f22) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setRotation(f22);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111114, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                    invoke(groupComponent, f22.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent set, float f22) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setPivotX(f22);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111114, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                    invoke(groupComponent, f22.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent set, float f22) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setPivotY(f22);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111114, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                    invoke(groupComponent, f22.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent set, float f22) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setScaleX(f22);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111114, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                    invoke(groupComponent, f22.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent set, float f22) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setScaleY(f22);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111114, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                    invoke(groupComponent, f22.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent set, float f22) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setTranslationX(f22);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111114, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f22) {
                    invoke(groupComponent, f22.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent set, float f22) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setTranslationY(f22);
                }
            });
            Updater.m1293setimpl(composerM1286constructorimpl1111114, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                    invoke2(groupComponent, list3);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    set.setClipPathData(it);
                }
            });
            composerStartRestartGroup.startReplaceableGroup(-983907633);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C54@2011L9:VectorCompose.kt#huu6hf");
            content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            f15 = f11;
            f16 = f14;
            f17 = f12;
            f18 = f13;
            f19 = f9;
            str3 = str2;
            list2 = emptyPath;
            f20 = f10;
            f21 = f8;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

            public final void invoke(Composer composer2, int i20) {
                VectorComposeKt.Group(str3, f20, f15, f21, f19, f17, f18, f16, list2, content, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: renamed from: Path-9cdaXJ4, reason: not valid java name */
    public static final void m2228Path9cdaXJ4(final List<? extends PathNode> pathData, int i, String str, Brush brush, float f, Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, Composer composer, final int i4, final int i5, final int i6) {
        Intrinsics.checkNotNullParameter(pathData, "pathData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1478270750);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Path)P(3,4:c#ui.graphics.PathFillType,2!4,10,7:c#ui.graphics.StrokeCap,8:c#ui.graphics.StrokeJoin!1,13)76@2665L876:VectorCompose.kt#huu6hf");
        final int defaultFillType = (i6 & 2) != 0 ? VectorKt.getDefaultFillType() : i;
        final String str2 = (i6 & 4) != 0 ? "" : str;
        final Brush brush3 = (i6 & 8) != 0 ? null : brush;
        float f8 = (i6 & 16) != 0 ? 1.0f : f;
        Brush brush4 = (i6 & 32) != 0 ? null : brush2;
        float f9 = (i6 & 64) != 0 ? 1.0f : f2;
        float f10 = (i6 & 128) != 0 ? 0.0f : f3;
        int defaultStrokeLineCap = (i6 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : i2;
        int defaultStrokeLineJoin = (i6 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i3;
        float f11 = (i6 & 1024) != 0 ? 4.0f : f4;
        float f12 = (i6 & 2048) != 0 ? 0.0f : f5;
        float f13 = (i6 & 4096) != 0 ? 1.0f : f6;
        float f14 = (i6 & 8192) != 0 ? 0.0f : f7;
        final VectorComposeKt$Path$1 vectorComposeKt$Path$1 = new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PathComponent invoke() {
                return new PathComponent();
            }
        };
        composerStartRestartGroup.startReplaceableGroup(1886828752);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComposeNode):Composables.kt#9igjgp");
        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path-9cdaXJ4$$inlined$ComposeNode$1
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.graphics.vector.PathComponent, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final PathComponent invoke() {
                    return vectorComposeKt$Path$1.invoke();
                }
            });
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composerStartRestartGroup);
        Updater.m1293setimpl(composerM1286constructorimpl, str2, new Function2<PathComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, String str3) {
                invoke2(pathComponent, str3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent set, String it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setName(it);
            }
        });
        Updater.m1293setimpl(composerM1286constructorimpl, pathData, new Function2<PathComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, List<? extends PathNode> list) {
                invoke2(pathComponent, list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent set, List<? extends PathNode> it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setPathData(it);
            }
        });
        Updater.m1293setimpl(composerM1286constructorimpl, PathFillType.m1867boximpl(defaultFillType), new Function2<PathComponent, PathFillType, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, PathFillType pathFillType) {
                m2230invokepweu1eQ(pathComponent, pathFillType.getValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-pweu1eQ, reason: not valid java name */
            public final void m2230invokepweu1eQ(PathComponent set, int i7) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.m2213setPathFillTypeoQ8Xj4U(i7);
            }
        });
        Updater.m1293setimpl(composerM1286constructorimpl, brush3, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush5) {
                invoke2(pathComponent, brush5);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent set, Brush brush5) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setFill(brush5);
            }
        });
        Updater.m1293setimpl(composerM1286constructorimpl, Float.valueOf(f8), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$5
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f15) {
                invoke(pathComponent, f15.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float f15) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setFillAlpha(f15);
            }
        });
        Updater.m1293setimpl(composerM1286constructorimpl, brush4, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$6
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush5) {
                invoke2(pathComponent, brush5);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent set, Brush brush5) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStroke(brush5);
            }
        });
        Updater.m1293setimpl(composerM1286constructorimpl, Float.valueOf(f9), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$7
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f15) {
                invoke(pathComponent, f15.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float f15) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStrokeAlpha(f15);
            }
        });
        Updater.m1293setimpl(composerM1286constructorimpl, Float.valueOf(f10), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$8
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f15) {
                invoke(pathComponent, f15.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float f15) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStrokeLineWidth(f15);
            }
        });
        Updater.m1293setimpl(composerM1286constructorimpl, StrokeJoin.m1938boximpl(defaultStrokeLineJoin), new Function2<PathComponent, StrokeJoin, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$9
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeJoin strokeJoin) {
                m2231invokekLtJ_vA(pathComponent, strokeJoin.getValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-kLtJ_vA, reason: not valid java name */
            public final void m2231invokekLtJ_vA(PathComponent set, int i7) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.m2215setStrokeLineJoinWw9F2mQ(i7);
            }
        });
        Updater.m1293setimpl(composerM1286constructorimpl, StrokeCap.m1928boximpl(defaultStrokeLineCap), new Function2<PathComponent, StrokeCap, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$10
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeCap strokeCap) {
                m2229invokeCSYIeUk(pathComponent, strokeCap.getValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-CSYIeUk, reason: not valid java name */
            public final void m2229invokeCSYIeUk(PathComponent set, int i7) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.m2214setStrokeLineCapBeK7IIE(i7);
            }
        });
        Updater.m1293setimpl(composerM1286constructorimpl, Float.valueOf(f11), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$11
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f15) {
                invoke(pathComponent, f15.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float f15) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStrokeLineMiter(f15);
            }
        });
        Updater.m1293setimpl(composerM1286constructorimpl, Float.valueOf(f12), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$12
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f15) {
                invoke(pathComponent, f15.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float f15) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setTrimPathStart(f15);
            }
        });
        Updater.m1293setimpl(composerM1286constructorimpl, Float.valueOf(f13), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$13
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f15) {
                invoke(pathComponent, f15.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float f15) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setTrimPathEnd(f15);
            }
        });
        Updater.m1293setimpl(composerM1286constructorimpl, Float.valueOf(f14), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$14
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f15) {
                invoke(pathComponent, f15.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float f15) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setTrimPathOffset(f15);
            }
        });
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final float f15 = f8;
        final Brush brush5 = brush4;
        final float f16 = f9;
        final float f17 = f10;
        final int i7 = defaultStrokeLineCap;
        final int i8 = defaultStrokeLineJoin;
        final float f18 = f11;
        final float f19 = f12;
        final float f20 = f13;
        final float f21 = f14;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$3
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

            public final void invoke(Composer composer2, int i9) {
                VectorComposeKt.m2228Path9cdaXJ4(pathData, defaultFillType, str2, brush3, f15, brush5, f16, f17, i7, i8, f18, f19, f20, f21, composer2, i4 | 1, i5, i6);
            }
        });
    }
}
