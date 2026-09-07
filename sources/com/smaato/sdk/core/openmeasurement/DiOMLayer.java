package com.smaato.sdk.core.openmeasurement;

import android.content.Context;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.util.collections.Iterables;
import com.smaato.sdk.core.util.fi.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes14.dex */
public final class DiOMLayer {
    public static DiRegistry createRegistry(Context context) {
        final List listLoadAndInitPlugins = loadAndInitPlugins(context);
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.core.openmeasurement.DiOMLayer$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                Iterables.forEach(listLoadAndInitPlugins, new Consumer() { // from class: com.smaato.sdk.core.openmeasurement.DiOMLayer$$ExternalSyntheticLambda0
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj2) {
                        diRegistry.addFrom(((ViewabilityPlugin) obj2).diRegistry());
                    }
                });
            }
        });
    }

    private static List loadAndInitPlugins(Context context) {
        ServiceLoader<ViewabilityPlugin> serviceLoaderLoad = ServiceLoader.load(ViewabilityPlugin.class, context.getClassLoader());
        ArrayList arrayList = new ArrayList();
        for (ViewabilityPlugin viewabilityPlugin : serviceLoaderLoad) {
            if (!viewabilityPlugin.getName().isEmpty()) {
                viewabilityPlugin.init(context);
                arrayList.add(viewabilityPlugin);
            }
        }
        return arrayList;
    }
}
