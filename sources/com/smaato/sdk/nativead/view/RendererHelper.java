package com.smaato.sdk.nativead.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.core.util.fi.BiConsumer;
import com.smaato.sdk.nativead.NativeAdAssets;
import com.smaato.sdk.nativead.R;
import com.smaato.sdk.richmedia.widget.RichMediaAdContentView;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public abstract class RendererHelper {

    @Inject
    private static Logger logger;

    static void renderText(TextView textView, String str) {
        if (textView != null) {
            if (str == null) {
                str = "";
            }
            textView.setText(str);
        }
    }

    static void renderRating(View view, Double d) {
        if (view == null || d == null) {
            return;
        }
        if (view instanceof RatingBar) {
            ((RatingBar) view).setRating(d.floatValue());
        } else {
            logWarning("Attempted to set rating to non RatingBar view.");
        }
    }

    static void renderImage(BiConsumer biConsumer, View view, NativeAdAssets.Image image) {
        if (view == null || image == null) {
            return;
        }
        if (view instanceof ImageView) {
            Drawable drawable = image.drawable();
            if (drawable != null) {
                ((ImageView) view).setImageDrawable(drawable);
                return;
            } else {
                biConsumer.accept(image.uri(), (ImageView) view);
                return;
            }
        }
        logWarning("Attempted to set image to non ImageView view.");
    }

    static void renderImage(BiConsumer biConsumer, View view, List list) {
        if (view == null) {
            return;
        }
        if (list.size() > 1) {
            logWarning("Multiple images rendering does not supported yet.");
        }
        if (list.isEmpty()) {
            return;
        }
        renderImage(biConsumer, view, (NativeAdAssets.Image) list.get(0));
    }

    public static void renderRichMedia(final View view, final RichMediaAdContentView richMediaAdContentView) {
        if (view instanceof FrameLayout) {
            view.post(new Runnable() { // from class: com.smaato.sdk.nativead.view.RendererHelper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    RendererHelper.lambda$renderRichMedia$0(view, richMediaAdContentView);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Cannot render rich media ad in view of type " + (view != null ? view.getClass().getSimpleName() : "null"));
    }

    static /* synthetic */ void lambda$renderRichMedia$0(View view, RichMediaAdContentView richMediaAdContentView) {
        ((FrameLayout) view).addView(richMediaAdContentView);
        richMediaAdContentView.startShowingView();
    }

    static void renderPrivacyIcon(View view, Runnable runnable) {
        if (view instanceof ImageView) {
            renderPrivacyIcon((ImageView) view, runnable);
        } else {
            if (view instanceof ViewGroup) {
                ImageButton imageButton = new ImageButton(view.getContext());
                renderPrivacyIcon((ImageView) imageButton, runnable);
                ((ViewGroup) view).addView(imageButton);
                return;
            }
            logWarning(String.format("Attempted to render privacy icon on unknown view (%s).", view));
        }
    }

    private static void renderPrivacyIcon(ImageView imageView, final Runnable runnable) {
        imageView.setBackgroundColor(0);
        imageView.setImageResource(R.drawable.smaato_sdk_native_ic_privacy);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.smaato.sdk.nativead.view.RendererHelper$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                runnable.run();
            }
        });
        imageView.setClickable(true);
    }

    private static void logWarning(String str) {
        if (logger == null) {
            AndroidsInjector.injectStatic(RendererHelper.class);
        }
        logger.warning(LogDomain.NATIVE, str, new Object[0]);
    }
}
