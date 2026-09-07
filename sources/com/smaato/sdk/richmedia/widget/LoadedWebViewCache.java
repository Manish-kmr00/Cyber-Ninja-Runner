package com.smaato.sdk.richmedia.widget;

import com.smaato.sdk.core.util.Objects;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class LoadedWebViewCache {
    private final Map cache = new ConcurrentHashMap();

    public void save(String str, Item item) {
        trim();
        this.cache.put(str, item);
    }

    public RichMediaWebView pop(String str) {
        Item item = (Item) this.cache.remove(str);
        if (item == null) {
            return null;
        }
        return item.webView;
    }

    private void trim() {
        Iterator it = this.cache.entrySet().iterator();
        while (it.hasNext()) {
            if (((Item) ((Map.Entry) it.next()).getValue()).weakAdObject.get() == null) {
                it.remove();
            }
        }
    }

    public static final class Item {
        private final WeakReference weakAdObject;
        private final RichMediaWebView webView;

        private Item(RichMediaWebView richMediaWebView, WeakReference weakReference) {
            this.webView = (RichMediaWebView) Objects.requireNonNull(richMediaWebView);
            this.weakAdObject = (WeakReference) Objects.requireNonNull(weakReference);
        }

        public static Item create(RichMediaWebView richMediaWebView, Object obj) {
            return new Item(richMediaWebView, new WeakReference(obj));
        }
    }
}
