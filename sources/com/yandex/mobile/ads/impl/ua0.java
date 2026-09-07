package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.PopupMenu;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ua0 {
    public static PopupMenu a(Context context, ImageView view, List items) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(items, "items");
        PopupMenu popupMenu = new PopupMenu(context, view, 5);
        Menu menu = popupMenu.getMenu();
        Iterator it = items.iterator();
        int i = 0;
        while (it.hasNext()) {
            menu.add(0, i, 0, ((la0.a) it.next()).a());
            i++;
        }
        return popupMenu;
    }
}
