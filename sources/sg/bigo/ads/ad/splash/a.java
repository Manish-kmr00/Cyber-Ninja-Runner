package sg.bigo.ads.ad.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.r;
import sg.bigo.ads.api.SplashAd;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.n.d;
import sg.bigo.ads.common.p.f;
import sg.bigo.ads.common.p.g;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.core.adview.h;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f13002a;
    public static boolean b;
    private static List<ObjectAnimator> c;

    public static int a(m mVar) {
        return b(mVar) ? R.layout.bigo_ad_splash_style_halfscreen : R.layout.bigo_ad_splash_style_fullscreen;
    }

    public static void a() {
        List<ObjectAnimator> list = c;
        if (list != null) {
            Iterator<ObjectAnimator> it = list.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            c.clear();
            c = null;
        }
    }

    protected static void a(int i, sg.bigo.ads.ad.b.c cVar, final ViewGroup viewGroup) {
        final int iA;
        if (i == 2) {
            iA = ViewCompat.MEASURED_STATE_MASK;
        } else if (i != 3) {
            iA = i != 4 ? -1 : r.a(cVar, -1);
        } else {
            iA = -7829368;
        }
        if (iA != -1) {
            d.b(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    ImageView imageView;
                    View viewFindViewWithTag = viewGroup.findViewWithTag("adview_background_main_tag");
                    if (viewFindViewWithTag instanceof ImageView) {
                        imageView = (ImageView) viewFindViewWithTag;
                    } else {
                        Context context = viewGroup.getContext();
                        if (context != null) {
                            ImageView imageView2 = new ImageView(context);
                            imageView2.setTag("adview_background_main_tag");
                            imageView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                            u.a(imageView2, viewGroup, null, 0);
                            imageView = imageView2;
                        } else {
                            imageView = null;
                        }
                    }
                    if (imageView != null) {
                        imageView.setBackgroundColor(iA);
                    }
                }
            });
        }
    }

    public static void a(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, 25.0f);
        objectAnimatorOfFloat.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, Key.ROTATION, 25.0f, -25.0f);
        objectAnimatorOfFloat2.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, Key.ROTATION, -25.0f, 0.0f);
        objectAnimatorOfFloat3.setDuration(300L);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, valueAnimatorOfFloat);
        animatorSet.addListener(new sg.bigo.ads.common.utils.b.d() { // from class: sg.bigo.ads.ad.splash.a.3
            @Override // sg.bigo.ads.common.utils.b.d, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (a.f13002a) {
                    animatorSet.start();
                } else {
                    animatorSet.cancel();
                }
            }
        });
        animatorSet.start();
    }

    public static void a(View view, float f) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(100L);
        float fA = e.a(view.getContext(), 200);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat2.setDuration(800L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "translationY", f, -fA);
        objectAnimatorOfFloat3.setDuration(800L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        final AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(objectAnimatorOfFloat, animatorSet, valueAnimatorOfFloat);
        animatorSet2.addListener(new sg.bigo.ads.common.utils.b.d() { // from class: sg.bigo.ads.ad.splash.a.5
            @Override // sg.bigo.ads.common.utils.b.d, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (a.f13002a) {
                    animatorSet2.start();
                } else {
                    animatorSet2.cancel();
                }
            }
        });
        animatorSet2.start();
    }

    static /* synthetic */ void a(View view, Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", view.getHeight() * 0.6f, 0.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(400L);
        objectAnimatorOfPropertyValuesHolder.addListener(animatorListener);
        objectAnimatorOfPropertyValuesHolder.start();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0058  */
    /* JADX WARN: Code duplicated, block: B:22:0x005c  */
    public static void a(final View view, View view2, int i, boolean z, int i2, boolean z2, int i3, int i4, h hVar) {
        ViewGroup.LayoutParams layoutParams;
        if (!(view2 instanceof FrameLayout) && !(view2 instanceof RelativeLayout)) {
            sg.bigo.ads.common.t.a.a(0, "SplashAd", "Failed to update up or below area click due to unsupported view.");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view2;
        Context context = view.getContext();
        if (context == null) {
            return;
        }
        if (i > 0) {
            View view3 = new View(context);
            view3.setId(R.id.bigo_ad_interstitial_below_area_click);
            view3.setTag(25);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, e.a(context, i), 80);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, e.a(context, i));
                layoutParams2.addRule(12);
                layoutParams = layoutParams2;
            } else if (z) {
                sg.bigo.ads.ad.b.a.a(view, view3, i3, hVar, i4);
            } else {
                sg.bigo.ads.ad.b.a.a(view, view3, i3, new h() { // from class: sg.bigo.ads.ad.splash.a.14
                    @Override // sg.bigo.ads.core.adview.h
                    public final void a(int i5, int i6, int i7, int i8, int i9, int i10) {
                        sg.bigo.ads.common.t.a.a(0, 3, "SplashAd", "Forbidden click for below area: " + view);
                    }
                }, i4);
            }
            viewGroup.addView(view3, layoutParams);
            if (z) {
                sg.bigo.ads.ad.b.a.a(view, view3, i3, hVar, i4);
            } else {
                sg.bigo.ads.ad.b.a.a(view, view3, i3, new h() { // from class: sg.bigo.ads.ad.splash.a.14
                    @Override // sg.bigo.ads.core.adview.h
                    public final void a(int i5, int i6, int i7, int i8, int i9, int i10) {
                        sg.bigo.ads.common.t.a.a(0, 3, "SplashAd", "Forbidden click for below area: " + view);
                    }
                }, i4);
            }
        }
        if (i2 > 0) {
            View view4 = new View(context);
            view4.setTag(24);
            if (viewGroup instanceof FrameLayout) {
                viewGroup.addView(view4, new FrameLayout.LayoutParams(-1, e.a(context, i2)));
            } else if (viewGroup instanceof RelativeLayout) {
                viewGroup.addView(view4, new RelativeLayout.LayoutParams(-1, e.a(context, i)));
            }
            if (z2) {
                sg.bigo.ads.ad.b.a.a(view, view4, i3, hVar, i4);
            } else {
                sg.bigo.ads.ad.b.a.a(view, view4, i3, new h() { // from class: sg.bigo.ads.ad.splash.a.15
                    @Override // sg.bigo.ads.core.adview.h
                    public final void a(int i5, int i6, int i7, int i8, int i9, int i10) {
                        sg.bigo.ads.common.t.a.a(0, 3, "SplashAd", "Forbidden click for up area: " + view);
                    }
                }, i4);
            }
        }
    }

    public static void a(final ViewGroup viewGroup, final int i) {
        final View viewFindViewById = viewGroup.findViewById(R.id.bigo_ad_splash_btn_cta);
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setAlpha(0.0f);
        viewGroup.post(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.a(viewFindViewById, new sg.bigo.ads.common.utils.b.d() { // from class: sg.bigo.ads.ad.splash.a.1.1
                    @Override // sg.bigo.ads.common.utils.b.d, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        a.c(viewGroup, i);
                    }
                });
            }
        });
    }

    private static void a(final ViewGroup viewGroup, boolean z) {
        final View viewA = sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.layout.bigo_ad_splash_item_flash, viewGroup, false);
        if (viewA != null) {
            ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
            if (z) {
                layoutParams.width = e.a(viewA.getContext(), 34);
                layoutParams.height = e.a(viewA.getContext(), 40);
            }
            viewGroup.addView(viewA);
            viewGroup.post(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.9
                @Override // java.lang.Runnable
                public final void run() {
                    ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewA, PropertyValuesHolder.ofKeyframe("translationX", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.72f, viewGroup.getMeasuredWidth())));
                    a.b(objectAnimatorOfPropertyValuesHolder);
                    objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
                    objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
                    objectAnimatorOfPropertyValuesHolder.start();
                }
            });
        }
    }

    public static void a(TextView textView, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            textView.setText(str2);
        }
    }

    public static void a(final sg.bigo.ads.ad.b.c cVar, final ValueCallback<Bitmap> valueCallback) {
        o oVar = (o) cVar.f();
        if (!oVar.aQ()) {
            String strAS = oVar.aS();
            if (q.a((CharSequence) strAS)) {
                valueCallback.onReceiveValue(null);
                return;
            } else {
                sg.bigo.ads.common.p.e.a(cVar.b.e, strAS, oVar.al(), new g() { // from class: sg.bigo.ads.ad.splash.a.7
                    @Override // sg.bigo.ads.common.p.g
                    public final void a(int i, String str, String str2) {
                        valueCallback.onReceiveValue(null);
                    }

                    @Override // sg.bigo.ads.common.p.g
                    public final void a(Bitmap bitmap, f fVar) {
                        valueCallback.onReceiveValue(bitmap);
                    }
                });
                return;
            }
        }
        String strB = sg.bigo.ads.common.o.b(cVar.b.e, oVar.aM());
        if (q.a((CharSequence) strB)) {
            valueCallback.onReceiveValue(null);
        } else {
            final String path = Uri.parse(strB).getPath();
            d.a(3, new Runnable() { // from class: sg.bigo.ads.ad.splash.a.6
                @Override // java.lang.Runnable
                public final void run() {
                    valueCallback.onReceiveValue(sg.bigo.ads.common.utils.d.a(Uri.parse(path).getPath(), cVar.b.e));
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0032  */
    /* JADX WARN: Code duplicated, block: B:21:0x003c  */
    /* JADX WARN: Code duplicated, block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    public static void a(AdCountDownButton adCountDownButton, int i) {
        int i2;
        if (i != 2) {
            if (i == 3) {
                i2 = R.drawable.bigo_ad_ic_close;
            } else if (i != 4) {
                if (i != 5) {
                    i2 = i != 6 ? -1 : R.drawable.bigo_ad_ic_close5;
                } else {
                    i2 = R.drawable.bigo_ad_ic_close4;
                }
            }
            if (-1 != i2) {
                adCountDownButton.a(R.layout.bigo_ad_item_inter_countdown_bg);
                adCountDownButton.setCloseImageResource(i2);
                if (i != 2) {
                    adCountDownButton.setShowCloseButtonInCountdown(true);
                }
            }
        }
        adCountDownButton.e = true;
        adCountDownButton.g.setVisibility(8);
        adCountDownButton.f.setVisibility(8);
        adCountDownButton.setShowCloseButtonInCountdown(false);
        i2 = R.drawable.bigo_ad_ic_close3;
        if (-1 != i2) {
            adCountDownButton.a(R.layout.bigo_ad_item_inter_countdown_bg);
            adCountDownButton.setCloseImageResource(i2);
            if (i != 2) {
                adCountDownButton.setShowCloseButtonInCountdown(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ObjectAnimator objectAnimator) {
        if (c == null) {
            c = new ArrayList();
        }
        c.add(objectAnimator);
    }

    public static void b(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, 10.0f);
        objectAnimatorOfFloat.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, Key.ROTATION, 10.0f, -10.0f);
        objectAnimatorOfFloat2.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, Key.ROTATION, -10.0f, 0.0f);
        objectAnimatorOfFloat3.setDuration(300L);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, valueAnimatorOfFloat);
        animatorSet.addListener(new sg.bigo.ads.common.utils.b.d() { // from class: sg.bigo.ads.ad.splash.a.4
            @Override // sg.bigo.ads.common.utils.b.d, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (a.f13002a) {
                    animatorSet.start();
                } else {
                    animatorSet.cancel();
                }
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ViewGroup viewGroup) {
        View viewA = sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.layout.bigo_ad_splash_item_ripple, viewGroup, false);
        if (viewA != null) {
            viewGroup.addView(viewA);
            Interpolator interpolatorA = sg.bigo.ads.common.utils.b.a(2);
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewA, PropertyValuesHolder.ofFloat("alpha", 0.0f, 0.2f, 0.2f, 0.0f), PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 2.5f, 4.5f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 2.5f, 4.5f));
            b(objectAnimatorOfPropertyValuesHolder);
            objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
            objectAnimatorOfPropertyValuesHolder.setInterpolator(interpolatorA);
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
            objectAnimatorOfPropertyValuesHolder.start();
        }
    }

    public static void b(ViewGroup viewGroup, int i) {
        if (i == 2) {
            viewGroup = (ViewGroup) viewGroup.findViewById(R.id.bigo_ad_splash_cta_inner);
            viewGroup.setVisibility(0);
        }
        if (i == 1) {
            sg.bigo.ads.ad.interstitial.c.e(viewGroup);
            return;
        }
        if (i == 2) {
            a(viewGroup, true);
            return;
        }
        if (i == 3) {
            b(viewGroup, true);
            return;
        }
        if (i != 4) {
            return;
        }
        sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.layout.bigo_ad_splash_endpage_item_slide, viewGroup, true);
        View viewFindViewById = viewGroup.findViewById(R.id.splash_slide);
        View viewFindViewById2 = viewGroup.findViewById(R.id.splash_slide_hand);
        if (viewFindViewById == null || viewFindViewById2 == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewFindViewById2, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewFindViewById2, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat2.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(viewFindViewById2, "translationY", 100.0f, -160.0f);
        objectAnimatorOfFloat3.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(objectAnimatorOfFloat, animatorSet, valueAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewFindViewById, "translationY", 20.0f, 0.0f);
        objectAnimatorOfFloat4.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(viewFindViewById, "translationY", 0.0f, 20.0f);
        objectAnimatorOfFloat5.setDuration(300L);
        objectAnimatorOfFloat5.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(objectAnimatorOfFloat5, objectAnimatorOfFloat4);
        final AnimatorSet animatorSet4 = (AnimatorSet) new WeakReference(new AnimatorSet()).get();
        if (animatorSet4 != null) {
            animatorSet4.playTogether(animatorSet2, animatorSet3);
            animatorSet4.addListener(new sg.bigo.ads.common.utils.b.d() { // from class: sg.bigo.ads.ad.splash.a.13
                @Override // sg.bigo.ads.common.utils.b.d, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (a.b) {
                        animatorSet4.start();
                    } else {
                        animatorSet4.cancel();
                    }
                }
            });
            animatorSet4.start();
        }
    }

    private static void b(ViewGroup viewGroup, boolean z) {
        int i = R.layout.bigo_ad_splash_item_click_guide;
        if (z) {
            i = R.layout.bigo_ad_splash_endpage_item_click_guide;
        }
        View viewA = sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), i, viewGroup, false);
        if (viewA != null) {
            viewGroup.addView(viewA);
            final View viewFindViewById = viewA.findViewById(R.id.click_gesture);
            final View viewFindViewById2 = viewA.findViewById(R.id.click_ripple);
            final RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 10.0f, 1, 0.5f, 1, 0.6f);
            rotateAnimation.setDuration(200L);
            rotateAnimation.setStartOffset(560L);
            rotateAnimation.setFillAfter(true);
            final RotateAnimation rotateAnimation2 = new RotateAnimation(10.0f, 0.0f, 1, 0.5f, 1, 0.6f);
            rotateAnimation2.setDuration(240L);
            rotateAnimation2.setFillAfter(true);
            final AnimationSet animationSet = new AnimationSet(false);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 5.0f, 1.0f, 5.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(400L);
            scaleAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(2));
            scaleAnimation.setFillAfter(true);
            animationSet.addAnimation(scaleAnimation);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(400L);
            scaleAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(2));
            alphaAnimation.setFillAfter(true);
            animationSet.addAnimation(alphaAnimation);
            alphaAnimation.setAnimationListener(new sg.bigo.ads.common.utils.b.c() { // from class: sg.bigo.ads.ad.splash.a.10
                @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    viewFindViewById2.setVisibility(4);
                }
            });
            rotateAnimation.setAnimationListener(new sg.bigo.ads.common.utils.b.c() { // from class: sg.bigo.ads.ad.splash.a.11
                @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    viewFindViewById.startAnimation(rotateAnimation2);
                }
            });
            rotateAnimation2.setAnimationListener(new sg.bigo.ads.common.utils.b.c() { // from class: sg.bigo.ads.ad.splash.a.12
                @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    viewFindViewById.startAnimation(rotateAnimation);
                    viewFindViewById2.setVisibility(0);
                    viewFindViewById2.startAnimation(animationSet);
                }
            });
            viewFindViewById.startAnimation(rotateAnimation);
        }
    }

    public static boolean b() {
        return i.f13093a != null && i.f13093a.u() == 1;
    }

    public static boolean b(m mVar) {
        return (i.f13093a == null ? 0 : i.f13093a.u()) == 0 && mVar.a("splash_style") == 1;
    }

    static SplashAd.Style c(m mVar) {
        int iU = i.f13093a == null ? 0 : i.f13093a.u();
        int iA = mVar.a("splash_style");
        if (iU == 1) {
            return SplashAd.Style.HORIZONTAL;
        }
        return iA == 1 ? SplashAd.Style.VERTICAL_HALFSCREEN : SplashAd.Style.VERTICAL_FULLSCREEN;
    }

    static /* synthetic */ void c(final ViewGroup viewGroup, int i) {
        if (i == 1 || i == 2 || i == 3) {
            viewGroup = (ViewGroup) viewGroup.findViewById(R.id.bigo_ad_splash_cta_inner);
            viewGroup.setVisibility(0);
        }
        if (i == 0) {
            View viewA = sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.layout.bigo_ad_splash_item_cta_bg, viewGroup, false);
            if (viewA != null) {
                viewGroup.addView(viewA);
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewA, PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 0.3f), Keyframe.ofFloat(0.8f, 0.0f)), PropertyValuesHolder.ofKeyframe("scaleX", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.8f, 1.07f)), PropertyValuesHolder.ofKeyframe("scaleY", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.8f, 1.54f)));
                b(objectAnimatorOfPropertyValuesHolder);
                objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
                objectAnimatorOfPropertyValuesHolder.setInterpolator(sg.bigo.ads.common.utils.b.a(2));
                objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
                objectAnimatorOfPropertyValuesHolder.start();
                return;
            }
            return;
        }
        if (i == 1) {
            View viewA2 = sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.layout.bigo_ad_splash_item_arrow, viewGroup, false);
            if (viewA2 != null) {
                viewGroup.addView(viewA2);
                float fA = e.a(viewGroup.getContext(), 6);
                ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(viewA2, PropertyValuesHolder.ofKeyframe("translationX", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.24f, -fA), Keyframe.ofFloat(0.44f, fA), Keyframe.ofFloat(0.64f, 0.0f)));
                b(objectAnimatorOfPropertyValuesHolder2);
                objectAnimatorOfPropertyValuesHolder2.setDuration(1000L);
                objectAnimatorOfPropertyValuesHolder2.setRepeatCount(-1);
                objectAnimatorOfPropertyValuesHolder2.start();
                return;
            }
            return;
        }
        if (i == 2) {
            b(viewGroup);
            viewGroup.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.8
                @Override // java.lang.Runnable
                public final void run() {
                    a.b(viewGroup);
                }
            }, 150L);
            return;
        }
        if (i == 3) {
            a(viewGroup, false);
            return;
        }
        if (i == 4) {
            b(viewGroup, false);
            return;
        }
        if (i != 5) {
            return;
        }
        sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.layout.bigo_ad_splash_item_slide, viewGroup, viewGroup != null);
        View viewFindViewById = viewGroup.findViewById(R.id.splash_slide);
        if (viewFindViewById != null) {
            float fA2 = e.a(viewGroup.getContext(), 10);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewFindViewById, "translationY", 0.0f, fA2, (-2.0f) * fA2, 0.0f, 0.0f);
            b(objectAnimatorOfFloat);
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.setRepeatCount(-1);
            objectAnimatorOfFloat.start();
        }
    }
}
