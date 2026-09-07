package com.five_corp.ad.internal.layouter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.five_corp.ad.internal.ad.custom_layout.m;
import com.five_corp.ad.internal.ad.custom_layout.n;
import com.five_corp.ad.internal.ad.s;
import com.five_corp.ad.internal.view.C3051i;
import com.five_corp.ad.internal.view.G;
import com.five_corp.ad.internal.view.InterfaceC3048f;
import com.five_corp.ad.internal.view.J;
import com.five_corp.ad.internal.view.ViewOnTouchListenerC3049g;
import com.five_corp.ad.internal.view.r;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1416a;
    public final Context b;
    public final Handler c;
    public final com.five_corp.ad.internal.logger.a d;
    public final HashMap e = new HashMap();
    public final G f;
    public com.five_corp.ad.internal.ad.custom_layout.d g;
    public final d h;
    public int i;
    public int j;
    public final com.five_corp.ad.internal.context.l k;
    public final com.five_corp.ad.internal.viewability.a l;
    public h m;

    public e(com.five_corp.ad.internal.view.l lVar, Context context, com.five_corp.ad.internal.logger.a aVar, G g, d dVar, com.five_corp.ad.internal.context.l lVar2, String str, com.five_corp.ad.internal.viewability.a aVar2, com.five_corp.ad.internal.ad.custom_layout.d dVar2, j jVar) {
        a aVar3 = new a(this, context);
        this.f1416a = aVar3;
        this.b = context;
        this.c = new Handler(Looper.getMainLooper());
        this.d = aVar;
        this.f = g;
        this.h = dVar;
        this.k = lVar2;
        this.l = aVar2;
        this.g = dVar2;
        jVar.f1420a.f1561a.add(new WeakReference(this));
        this.m = jVar.b;
        lVar.addView(aVar3);
        BitmapDrawable bitmapDrawableA = l.a(str, context.getResources(), aVar);
        if (bitmapDrawableA != null) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setClickable(false);
            frameLayout.setFocusable(false);
            frameLayout.setBackground(bitmapDrawableA);
            lVar.addView(frameLayout);
        }
    }

    public final void a(com.five_corp.ad.internal.ad.custom_layout.d dVar) {
        this.f1416a.isInLayout();
        this.g = dVar;
        Iterator it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            J.a((View) ((Map.Entry) it.next()).getValue());
        }
        this.e.clear();
    }

    public final /* synthetic */ void b(float f, float f2) {
        com.five_corp.ad.internal.ad.custom_layout.a aVarA = a(f, f2);
        if (aVarA != null) {
            switch (com.five_corp.ad.e.a(aVarA.f1275a)) {
                case 1:
                    this.h.c();
                    break;
                case 2:
                    this.h.a();
                    break;
                case 3:
                    this.h.g();
                    break;
                case 4:
                    this.h.d();
                    break;
                case 5:
                    this.h.f();
                    break;
                case 6:
                    this.h.b();
                    break;
                case 7:
                    String str = aVarA.h;
                    if (str != null) {
                        this.h.a(str);
                    }
                    break;
                case 8:
                    this.h.e();
                    break;
            }
        }
    }

    public final com.five_corp.ad.internal.ad.custom_layout.a a(float f, float f2) {
        double width = ((double) this.f1416a.getWidth()) / ((double) this.g.f1277a);
        double height = this.f1416a.getHeight();
        com.five_corp.ad.internal.ad.custom_layout.d dVar = this.g;
        double d = height / ((double) dVar.b);
        com.five_corp.ad.internal.ad.custom_layout.a aVar = null;
        for (com.five_corp.ad.internal.ad.custom_layout.a aVar2 : dVar.d) {
            if (a(this.m, aVar2.g)) {
                int i = aVar2.b;
                double d2 = f;
                if (((double) i) * width <= d2 && d2 <= ((double) (i + aVar2.e)) * width) {
                    int i2 = aVar2.c;
                    double d3 = f2;
                    if (((double) i2) * d <= d3 && d3 <= ((double) (i2 + aVar2.f)) * d && (aVar == null || aVar.d < aVar2.d)) {
                        aVar = aVar2;
                    }
                }
            }
        }
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0061  */
    public static boolean a(h hVar, com.five_corp.ad.internal.ad.custom_layout.c cVar) {
        boolean z;
        boolean z2;
        boolean z3;
        Integer num;
        if (cVar == null) {
            return true;
        }
        n nVar = cVar.f1276a;
        int iA = com.five_corp.ad.e.a(nVar.f1285a);
        if (iA == 0) {
            z = true;
        } else if (iA == 1) {
            z = hVar.e;
        } else if (iA == 2) {
            z = !hVar.e;
        } else if (iA == 3) {
            Integer num2 = nVar.b;
            if (num2 != null) {
                if (nVar.c != null) {
                    int iIntValue = num2.intValue();
                    int i = hVar.f1419a;
                    if (iIntValue <= i && i < nVar.c.intValue() && !hVar.e) {
                        z = true;
                    }
                } else if (num2.intValue() <= hVar.f1419a || hVar.e) {
                    z = true;
                }
            }
            z = false;
        } else if (iA == 4 && (num = nVar.b) != null && num.intValue() <= hVar.f1419a && !hVar.e) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int iA2 = com.five_corp.ad.e.a(cVar.b);
            if (iA2 == 0) {
                z2 = true;
            } else if (iA2 != 1) {
                z2 = iA2 != 2 ? false : !hVar.f;
            } else {
                z2 = hVar.f;
            }
            if (z2) {
                int iA3 = com.five_corp.ad.e.a(cVar.c);
                if (iA3 == 0) {
                    z3 = true;
                } else if (iA3 != 1) {
                    z3 = iA3 != 2 ? false : !hVar.g;
                } else {
                    z3 = hVar.g;
                }
                if (z3) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.five_corp.ad.internal.layouter.i
    public final void a(h hVar) {
        this.m = hVar;
        for (Map.Entry entry : this.e.entrySet()) {
            if (entry.getValue() instanceof k) {
                ((k) entry.getValue()).a(this.m);
            }
        }
        a(this.f1416a.getWidth(), this.f1416a.getHeight());
    }

    public final void a() {
        this.f1416a.getParent();
        this.f1416a.setClickable(true);
        this.f1416a.setOnTouchListener(new ViewOnTouchListenerC3049g(this.b, new InterfaceC3048f() { // from class: com.five_corp.ad.internal.layouter.e$$ExternalSyntheticLambda0
            @Override // com.five_corp.ad.internal.view.InterfaceC3048f
            public final void a(float f, float f2) {
                this.f$0.b(f, f2);
            }
        }, this.d));
        this.f1416a.setBackgroundColor(0);
        if (this.f.getParent() != this.f1416a) {
            J.a(this.f);
            this.f1416a.addView(this.f);
            a(this.f1416a.getWidth(), this.f1416a.getHeight());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:111:0x0271  */
    /* JADX WARN: Code duplicated, block: B:128:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:136:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:142:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:144:0x0307  */
    /* JADX WARN: Code duplicated, block: B:88:0x0205 A[DONT_INVERT, PHI: r8
  0x0205: PHI (r8v4 ??) = 
  (r8v2 ??)
  (r8v2 ??)
  (r8v9 ??)
  (r8v2 ??)
  (r8v2 ??)
  (r8v2 ??)
  (r8v14 ??)
  (r8v2 ??)
  (r8v17 ??)
  (r8v18 ??)
  (r8v2 ??)
  (r8v20 ??)
  (r8v2 ??)
  (r8v2 ??)
  (r8v22 ??)
  (r8v2 ??)
  (r8v24 ??)
 binds: [B:15:0x0051, B:63:0x0183, B:87:0x01fe, B:58:0x0169, B:55:0x0160, B:51:0x0135, B:53:0x0139, B:44:0x0110, B:49:0x0120, B:48:0x011c, B:40:0x00f7, B:61:0x017c, B:36:0x00d6, B:22:0x006e, B:152:0x0205, B:18:0x005c, B:20:0x0060] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:89:0x0207  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r4v17, types: [android.view.ViewGroup, com.five_corp.ad.internal.layouter.a] */
    /* JADX WARN: Type inference failed for: r4v18, types: [android.view.ViewGroup, com.five_corp.ad.internal.layouter.a] */
    /* JADX WARN: Type inference failed for: r4v39, types: [com.five_corp.ad.internal.viewability.a] */
    /* JADX WARN: Type inference failed for: r7v8, types: [android.view.ViewGroup, com.five_corp.ad.internal.layouter.a] */
    /* JADX WARN: Type inference failed for: r8v14, types: [android.view.View, android.webkit.WebView] */
    /* JADX WARN: Type inference failed for: r8v17, types: [android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v22, types: [android.widget.HorizontalScrollView] */
    /* JADX WARN: Type inference failed for: r8v24, types: [com.five_corp.ad.internal.cache.b] */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(int i, int i2) {
        int i3;
        FrameLayout.LayoutParams layoutParams;
        int i4;
        int i5;
        int i6;
        Object kVar;
        if (i == 0 || i2 == 0) {
            return;
        }
        com.five_corp.ad.internal.ad.custom_layout.d dVar = this.g;
        Collections.sort(dVar.c, new b());
        int i7 = 0;
        boolean z = false;
        int i8 = 0;
        for (com.five_corp.ad.internal.ad.custom_layout.h hVar : dVar.c) {
            ?? webView = (View) this.e.get(hVar);
            if (a(this.m, hVar.g)) {
                if (webView == 0) {
                    switch (com.five_corp.ad.e.a(hVar.f1281a.f1278a)) {
                        case 0:
                            com.five_corp.ad.internal.ad.custom_layout.k kVar2 = hVar.f1281a.b;
                            if (kVar2 != null) {
                                String strReplace = kVar2.f1284a.replace("<br>", "\n");
                                int iA = com.five_corp.ad.e.a(kVar2.d);
                                if (iA == 0) {
                                    i6 = 17;
                                } else if (iA == 1) {
                                    i6 = GravityCompat.START;
                                } else {
                                    if (iA != 2) {
                                        throw new RuntimeException("Unsupported gravity ".concat(m.a(kVar2.d)));
                                    }
                                    i6 = GravityCompat.END;
                                }
                                Context context = this.b;
                                String str = kVar2.b;
                                String str2 = kVar2.c;
                                boolean z2 = kVar2.e;
                                boolean z3 = kVar2.f;
                                boolean z4 = kVar2.h == null;
                                TextView textView = new TextView(context);
                                textView.setText(strReplace);
                                textView.setTextColor(J.a(str));
                                if (z3) {
                                    textView.setTypeface(Typeface.DEFAULT_BOLD);
                                }
                                GradientDrawable gradientDrawable = new GradientDrawable();
                                gradientDrawable.setColor(J.a(str2));
                                if (z4) {
                                    gradientDrawable.setCornerRadius(5.0f);
                                }
                                if (z2) {
                                    gradientDrawable.setStroke(1, J.a(str));
                                }
                                J.a(textView, gradientDrawable);
                                textView.setGravity(i6);
                                webView = textView;
                            }
                            if (webView != 0 && hVar.f1281a.f1278a != 3) {
                                this.e.put(hVar, webView);
                                this.l.a(webView, hVar.h);
                            }
                            break;
                        case 1:
                            s sVar = hVar.f1281a.c;
                            if (sVar != null) {
                                com.five_corp.ad.internal.cache.b bVarA = this.k.h.a(this.b, sVar);
                                bVarA.setScaleType(ImageView.ScaleType.FIT_XY);
                                kVar = bVarA;
                                webView = kVar;
                                if (webView != 0) {
                                    this.e.put(hVar, webView);
                                    this.l.a(webView, hVar.h);
                                }
                            } else if (webView != 0) {
                                this.e.put(hVar, webView);
                                this.l.a(webView, hVar.h);
                            }
                            break;
                        case 2:
                            if (this.f.getParent() == this.f1416a) {
                                kVar = this.f;
                                webView = kVar;
                                if (webView != 0) {
                                    this.e.put(hVar, webView);
                                    this.l.a(webView, hVar.h);
                                }
                            } else if (webView != 0) {
                                this.e.put(hVar, webView);
                                this.l.a(webView, hVar.h);
                            }
                            break;
                        case 3:
                            com.five_corp.ad.internal.ad.format_config.b bVar = hVar.f1281a.d;
                            if (bVar != null) {
                                webView = new WebView(this.b);
                                r.a(webView, this.k.g, bVar, this, this.d);
                                webView.setVerticalScrollBarEnabled(false);
                                webView.setHorizontalScrollBarEnabled(false);
                                webView.setBackgroundColor(0);
                                webView.setVisibility(0);
                            }
                            if (webView != 0) {
                                this.e.put(hVar, webView);
                                this.l.a(webView, hVar.h);
                            }
                            break;
                        case 4:
                            com.five_corp.ad.internal.ad.custom_layout.f fVar = hVar.f1281a.e;
                            if (fVar != null) {
                                if (fVar.b.size() == 0) {
                                    webView = 0;
                                } else {
                                    webView = new FrameLayout(this.b);
                                    new c(this, fVar, webView).run();
                                }
                            }
                            if (webView != 0) {
                                this.e.put(hVar, webView);
                                this.l.a(webView, hVar.h);
                            }
                            break;
                        case 5:
                            if (hVar.f1281a.f != null) {
                                kVar = new com.five_corp.ad.internal.view.k(this.b, this.k.h, hVar.f1281a.f);
                                webView = kVar;
                                if (webView != 0) {
                                    this.e.put(hVar, webView);
                                    this.l.a(webView, hVar.h);
                                }
                            } else if (webView != 0) {
                                this.e.put(hVar, webView);
                                this.l.a(webView, hVar.h);
                            }
                            break;
                        case 6:
                            if (hVar.f1281a.g != null) {
                                kVar = new C3051i(this.b, hVar.f1281a.g, this.k.b.f.intValue(), this.d);
                                webView = kVar;
                                if (webView != 0) {
                                    this.e.put(hVar, webView);
                                    this.l.a(webView, hVar.h);
                                }
                            } else if (webView != 0) {
                                this.e.put(hVar, webView);
                                this.l.a(webView, hVar.h);
                            }
                            break;
                        case 7:
                            com.five_corp.ad.internal.ad.custom_layout.g gVar = hVar.f1281a.h;
                            if (gVar != null) {
                                webView = new HorizontalScrollView(this.b);
                                String str3 = gVar.b;
                                if (str3 != null) {
                                    webView.setBackgroundColor(J.a(str3));
                                }
                                LinearLayout linearLayout = new LinearLayout(this.b);
                                linearLayout.setOrientation(i7);
                                webView.addView(linearLayout, new ViewGroup.LayoutParams(-2, -1));
                                Iterator it = gVar.f1280a.iterator();
                                boolean z5 = true;
                                while (it.hasNext()) {
                                    com.five_corp.ad.internal.cache.b bVarA2 = this.k.h.a(this.b, (s) it.next());
                                    bVarA2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                    bVarA2.setAdjustViewBounds(true);
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
                                    if (z5) {
                                        z5 = false;
                                    } else {
                                        layoutParams2.leftMargin = 16;
                                    }
                                    linearLayout.addView(bVarA2, layoutParams2);
                                }
                            }
                            if (webView != 0) {
                                this.e.put(hVar, webView);
                                this.l.a(webView, hVar.h);
                            }
                            break;
                        case 8:
                            com.five_corp.ad.internal.context.l lVar = this.k;
                            s sVar2 = lVar.b.o;
                            if (sVar2 != null) {
                                webView = lVar.h.a(this.b, sVar2);
                            }
                            if (webView != 0) {
                                this.e.put(hVar, webView);
                                this.l.a(webView, hVar.h);
                            }
                            break;
                        default:
                            if (webView != 0) {
                                this.e.put(hVar, webView);
                                this.l.a(webView, hVar.h);
                            }
                            break;
                    }
                }
                if (webView != 0) {
                    int i9 = (hVar.e * i) / dVar.f1277a;
                    com.five_corp.ad.internal.ad.custom_layout.e eVar = hVar.f1281a;
                    boolean z6 = true;
                    if (eVar.f1278a == 1) {
                        TextView textView2 = (TextView) webView;
                        com.five_corp.ad.internal.ad.custom_layout.k kVar3 = eVar.b;
                        if (kVar3 == null) {
                            i3 = 0;
                        } else {
                            Integer num = kVar3.h;
                            Float fValueOf = num != null ? Float.valueOf((num.intValue() * i) / dVar.f1277a) : null;
                            if (fValueOf != null) {
                                textView2.setPadding(fValueOf.intValue(), 0, fValueOf.intValue(), 0);
                                int iA2 = com.five_corp.ad.e.a(kVar3.d);
                                z6 = true;
                                if (iA2 == 0) {
                                    i5 = 17;
                                } else if (iA2 == 1) {
                                    i5 = GravityCompat.START;
                                } else if (iA2 != 2) {
                                    i5 = 17;
                                } else {
                                    i5 = GravityCompat.END;
                                }
                                textView2.setGravity(i5 | 16);
                                i4 = -2;
                            } else {
                                z6 = true;
                                i4 = i9;
                            }
                            Integer num2 = kVar3.g;
                            Float fValueOf2 = num2 != null ? Float.valueOf((num2.intValue() * i) / dVar.f1277a) : null;
                            if (fValueOf2 != null) {
                                i3 = 0;
                                textView2.setTextSize(0, fValueOf2.floatValue());
                            } else {
                                i3 = 0;
                            }
                            i9 = i4;
                        }
                    } else {
                        i3 = 0;
                    }
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i9, (hVar.f * i2) / dVar.b);
                    layoutParams3.leftMargin = (hVar.b * i) / dVar.f1277a;
                    layoutParams3.topMargin = (hVar.c * i2) / dVar.b;
                    if (hVar.f1281a.f1278a != 3) {
                        ViewParent parent = webView.getParent();
                        ?? r7 = this.f1416a;
                        if (parent == r7) {
                            layoutParams = (FrameLayout.LayoutParams) webView.getLayoutParams();
                            if (layoutParams3.width == layoutParams.width || layoutParams3.height != layoutParams.height || layoutParams3.leftMargin != layoutParams.leftMargin || layoutParams3.topMargin != layoutParams.topMargin) {
                                webView.setLayoutParams(layoutParams3);
                            }
                            if (!z && this.f1416a.indexOfChild(webView) != i8) {
                                z = z6;
                            }
                            if (z) {
                                this.f1416a.bringChildToFront(webView);
                            }
                        } else {
                            r7.addView(webView, layoutParams3);
                        }
                    } else {
                        layoutParams = (FrameLayout.LayoutParams) webView.getLayoutParams();
                        if (layoutParams3.width == layoutParams.width) {
                            webView.setLayoutParams(layoutParams3);
                        } else {
                            webView.setLayoutParams(layoutParams3);
                        }
                        if (!z) {
                            z = z6;
                        }
                        if (z) {
                            this.f1416a.bringChildToFront(webView);
                        }
                    }
                    i8++;
                } else {
                    i3 = 0;
                }
            } else {
                J.a((View) webView);
                i3 = i7;
            }
            i7 = i3;
        }
    }
}
