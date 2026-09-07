package com.smaato.sdk.core;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import android.view.View;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.core.util.diinjection.InjectOrNull;
import com.smaato.sdk.core.util.diinjection.Named;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public final class AndroidsInjector {

    public interface InjectionAllowed {
    }

    public static void inject(View view) {
        Objects.requireNonNull(view, "Parameter view cannot be null for AndroidsInjector::inject");
        injectFieldValues(view);
    }

    public static void inject(Activity activity) {
        Objects.requireNonNull(activity, "Parameter activity cannot be null for AndroidsInjector::inject");
        injectFieldValues(activity);
    }

    public static void inject(Fragment fragment) {
        Objects.requireNonNull(fragment, "Parameter fragment cannot be null for AndroidsInjector::inject");
        injectFieldValues(fragment);
    }

    public static void inject(InjectionAllowed injectionAllowed) {
        Objects.requireNonNull(injectionAllowed, "Parameter injectionAllowed cannot be null for AndroidsInjector::inject");
        injectFieldValues(injectionAllowed);
    }

    public static void injectStatic(Class cls) {
        Objects.requireNonNull(cls, "Parameter clazz cannot be null for AndroidsInjector::inject");
        injectStaticFieldValues(cls);
    }

    private static void injectStaticFieldValues(Class cls) {
        injectFieldValues(cls, findFields(cls, Inject.class), false);
        injectFieldValues(cls, findFields(cls, InjectOrNull.class), true);
    }

    private static void injectFieldValues(Object obj) {
        injectFieldValues(obj, findFields(obj.getClass(), Inject.class), false);
        injectFieldValues(obj, findFields(obj.getClass(), InjectOrNull.class), true);
    }

    private static void injectFieldValues(Object obj, Set set, boolean z) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Field field = (Field) it.next();
            String strValue = field.isAnnotationPresent(Named.class) ? ((Named) field.getAnnotation(Named.class)).value() : null;
            field.setAccessible(true);
            try {
                for (Field field2 : SmaatoSdk.class.getDeclaredFields()) {
                    if (field2.getType() == SmaatoInstance.class) {
                        field2.setAccessible(true);
                        SmaatoInstance smaatoInstance = (SmaatoInstance) field2.get(null);
                        if (z) {
                            field.set(obj, smaatoInstance.getDiConstructor().getOrNull(strValue, field.getType()));
                            break;
                        } else {
                            field.set(obj, smaatoInstance.getDiConstructor().get(strValue, field.getType()));
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                Log.e("Injector", "Unknown injector error", e);
            }
        }
    }

    private static Set findFields(Class cls, Class cls2) {
        HashSet hashSet = new HashSet();
        String canonicalName = cls.getCanonicalName();
        while (canonicalName != null && canonicalName.startsWith(h.v)) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(cls2)) {
                    hashSet.add(field);
                }
            }
            cls = cls.getSuperclass();
            canonicalName = cls.getCanonicalName();
        }
        return hashSet;
    }
}
