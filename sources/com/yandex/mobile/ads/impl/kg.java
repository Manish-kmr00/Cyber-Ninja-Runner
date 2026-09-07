package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class kg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f9412a;
    private final pj0 b;
    private final ex0 c;
    private final j91 d;
    private final p81 e;
    private final lp1 f;

    public kg(o8<?> adResponse, pj0 imageProvider, ex0 mediaViewAdapterCreator, j91 nativeMediaContent, p81 nativeForcePauseObserver, lp1 reporter) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(mediaViewAdapterCreator, "mediaViewAdapterCreator");
        Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
        Intrinsics.checkNotNullParameter(nativeForcePauseObserver, "nativeForcePauseObserver");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.f9412a = adResponse;
        this.b = imageProvider;
        this.c = mediaViewAdapterCreator;
        this.d = nativeMediaContent;
        this.e = nativeForcePauseObserver;
        this.f = reporter;
    }

    public final bj0 a(ImageView imageView) {
        za0 za0Var;
        if (imageView != null) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            za0Var = new za0(imageView, new gj0(context, new z81(this.f9412a), this.b));
        } else {
            za0Var = null;
        }
        if (za0Var != null) {
            return new bj0(za0Var);
        }
        return null;
    }

    public final vu0 a(ImageView imageView, CustomizableMediaView customizableMediaView) {
        ck0 ck0Var = imageView != null ? new ck0(imageView, this.b, this.f9412a) : null;
        dx0 dx0VarA = customizableMediaView != null ? this.c.a(customizableMediaView, this.b, this.d, this.e) : null;
        if (ck0Var == null && dx0VarA == null) {
            return null;
        }
        return new vu0(ck0Var, dx0VarA);
    }

    public final cz a(View view) {
        en1 en1Var = view instanceof fn1 ? new en1(view, this.f) : null;
        if (en1Var != null) {
            return new cz(en1Var);
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final jg<?> a(View view, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        switch (type.hashCode()) {
            case -1034364087:
                if (!type.equals("number")) {
                    return null;
                }
                break;
            case -891985903:
                if (!type.equals("string")) {
                    return null;
                }
                break;
            case -410956671:
                if (type.equals("container")) {
                    return new cz(new ms1(view));
                }
                return null;
            case 100313435:
                if (!type.equals("image")) {
                    return null;
                }
                if ((view instanceof ImageView ? (ImageView) view : null) != null) {
                    return new bj0(new ck0((ImageView) view, this.b, this.f9412a));
                }
                return null;
            case 103772132:
                if (!type.equals("media")) {
                    return null;
                }
                if ((view instanceof CustomizableMediaView ? (CustomizableMediaView) view : null) != null) {
                    return a((ImageView) null, (CustomizableMediaView) view);
                }
                return null;
            default:
                return null;
        }
        if ((view instanceof TextView ? (TextView) view : null) != null) {
            return new cz(new p42((TextView) view));
        }
        return null;
    }
}
