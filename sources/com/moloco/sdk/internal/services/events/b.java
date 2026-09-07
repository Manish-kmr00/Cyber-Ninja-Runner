package com.moloco.sdk.internal.services.events;

import com.moloco.sdk.UserIntent;
import com.moloco.sdk.internal.services.e0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6379a = "CustomUserEventBuilderServiceImpl";
    public static final String b = "user_ad_interaction_ext";

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6380a;

        static {
            int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a.values().length];
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a.SKIP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a.SKIP_DEC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a.MUTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a.UNMUTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a.CTA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a.REPLAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a.AD_BADGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f6380a = iArr;
        }
    }

    public static final UserIntent.UserAdInteractionExt.Button.Type a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a enumC0707a) {
        Intrinsics.checkNotNullParameter(enumC0707a, "<this>");
        switch (a.f6380a[enumC0707a.ordinal()]) {
            case 1:
                return UserIntent.UserAdInteractionExt.Button.Type.NONE;
            case 2:
                return UserIntent.UserAdInteractionExt.Button.Type.CLOSE;
            case 3:
                return UserIntent.UserAdInteractionExt.Button.Type.SKIP;
            case 4:
                return UserIntent.UserAdInteractionExt.Button.Type.DEC_SKIP;
            case 5:
                return UserIntent.UserAdInteractionExt.Button.Type.MUTE;
            case 6:
                return UserIntent.UserAdInteractionExt.Button.Type.UNMUTE;
            case 7:
                return UserIntent.UserAdInteractionExt.Button.Type.CTA;
            case 8:
                return UserIntent.UserAdInteractionExt.Button.Type.REPLAY;
            case 9:
                return UserIntent.UserAdInteractionExt.Button.Type.AD_BADGE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final UserIntent.UserAdInteractionExt.Position a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        UserIntent.UserAdInteractionExt.Position.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.Position.newBuilder();
        builderNewBuilder.setX(fVar.c());
        builderNewBuilder.setY(fVar.d());
        UserIntent.UserAdInteractionExt.Position positionBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(positionBuild, "newBuilder().apply {\n   … topLeftYDp\n    }.build()");
        return positionBuild;
    }

    public static final UserIntent.UserAdInteractionExt.Size a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        UserIntent.UserAdInteractionExt.Size.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.Size.newBuilder();
        builderNewBuilder.setW(gVar.d());
        builderNewBuilder.setH(gVar.c());
        UserIntent.UserAdInteractionExt.Size sizeBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(sizeBuild, "newBuilder().apply {\n   … = heightDp\n    }.build()");
        return sizeBuild;
    }

    public static final UserIntent.UserAdInteractionExt.Size a(e0 e0Var) {
        Intrinsics.checkNotNullParameter(e0Var, "<this>");
        UserIntent.UserAdInteractionExt.Size.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.Size.newBuilder();
        builderNewBuilder.setW(e0Var.m());
        builderNewBuilder.setH(e0Var.k());
        UserIntent.UserAdInteractionExt.Size sizeBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(sizeBuild, "newBuilder().apply {\n   …eenHeightDp\n    }.build()");
        return sizeBuild;
    }
}
