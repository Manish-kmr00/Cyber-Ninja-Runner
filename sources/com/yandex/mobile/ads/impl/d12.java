package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
public final class d12 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gj0 f8656a;
    private final hj1 b;

    private static final class a implements gj0.b {
        static final /* synthetic */ KProperty<Object>[] c = {ta.a(a.class, "weakContext", "getWeakContext()Landroid/content/Context;", 0), ta.a(a.class, "menuItem", "getMenuItem()Landroid/view/MenuItem;", 0)};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final zn1 f8657a;
        private final zn1 b;

        public a(Context context, MenuItem menuItem) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(menuItem, "menuItem");
            this.f8657a = ao1.a(context);
            this.b = ao1.a(menuItem);
        }

        @Override // com.yandex.mobile.ads.impl.gj0.b
        public final void a(Bitmap bitmap) {
            MenuItem menuItem;
            if (bitmap != null) {
                zn1 zn1Var = this.f8657a;
                KProperty<?>[] kPropertyArr = c;
                Context context = (Context) zn1Var.getValue(this, kPropertyArr[0]);
                if (context == null || (menuItem = (MenuItem) this.b.getValue(this, kPropertyArr[1])) == null) {
                    return;
                }
                menuItem.setIcon(new BitmapDrawable(context.getResources(), bitmap));
            }
        }
    }

    public d12(gj0 imageForPresentProvider, hj1 iconsManager) {
        Intrinsics.checkNotNullParameter(imageForPresentProvider, "imageForPresentProvider");
        Intrinsics.checkNotNullParameter(iconsManager, "iconsManager");
        this.f8656a = imageForPresentProvider;
        this.b = iconsManager;
    }

    public final PopupMenu a(View view, List<s02> items) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(items, "items");
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view, 5);
        this.b.getClass();
        hj1.a(popupMenu);
        Menu menu = popupMenu.getMenu();
        Context context = view.getContext();
        int size = items.size();
        for (int i = 0; i < size; i++) {
            s02 s02Var = items.get(i);
            Intrinsics.checkNotNull(context);
            Intrinsics.checkNotNull(menu);
            u02 u02VarC = s02Var.c();
            MenuItem menuItemAdd = menu.add(0, i, i, u02VarC.b());
            Intrinsics.checkNotNull(menuItemAdd);
            this.f8656a.a(u02VarC.a(), new a(context, menuItemAdd));
        }
        return popupMenu;
    }
}
