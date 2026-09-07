package com.smaato.sdk.core.util.reflection;

import com.smaato.sdk.core.util.Joiner;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Pair;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class MethodAccessor {
    private final Class clazz;
    private final Object instance;
    private final String methodName;
    private final Object[] parameterInstances;
    private final Class[] parameterTypes;

    private MethodAccessor(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) {
        this.clazz = (Class) Objects.requireNonNull(cls, "Parameter clazz cannot be null for MethodAccessor::MethodAccessor");
        this.instance = obj;
        this.methodName = (String) Objects.requireNonNull(str, "Parameter methodName cannot be null for MethodAccessor::MethodAccessor");
        this.parameterTypes = clsArr;
        this.parameterInstances = objArr;
    }

    public Object execute() throws MethodAccessingException {
        try {
            return getDeclaredMethod().invoke(this.instance, this.parameterInstances);
        } catch (Exception e) {
            throw new MethodAccessingException(e);
        }
    }

    private Method getDeclaredMethod() throws NoSuchMethodException {
        for (Class superclass = this.clazz; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                return superclass.getDeclaredMethod(this.methodName, this.parameterTypes);
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new NoSuchMethodException();
    }

    public static final class MethodAccessingException extends Exception {
        public MethodAccessingException(Throwable th) {
            super(th);
        }
    }

    public static final class Builder {
        private Class clazz;
        private Object instance;
        private String methodName;
        private Object[] parameterInstances;
        private Class[] parameterTypes;

        public Builder fromObjectInstance(Object obj) {
            this.instance = Objects.requireNonNull(obj, "Parameter instance cannot be null for Builder::fromObjectInstance");
            this.clazz = obj.getClass();
            return this;
        }

        public Builder fromClassInstance(String str) throws ClassNotFoundException {
            Objects.requireNonNull(str, "Parameter className cannot be null for Builder::fromClassInstance");
            this.clazz = Class.forName(str);
            return this;
        }

        public Builder fromResolvedClassInstance(Class<?> cls) {
            this.clazz = (Class) Objects.requireNonNull(cls, "Parameter clazz cannot be null for Builder::fromResolvedClassInstance");
            return this;
        }

        public Builder setMethodName(String str) {
            this.methodName = (String) Objects.requireNonNull(str, "Parameter methodName cannot be null for Builder::setMethodName");
            return this;
        }

        @SafeVarargs
        public final Builder withParameters(Pair<String, Object>... pairArr) throws ClassNotFoundException {
            this.parameterTypes = new Class[pairArr.length];
            this.parameterInstances = new Object[pairArr.length];
            for (int i = 0; i < pairArr.length; i++) {
                Pair pair = (Pair) Objects.requireNonNull(pairArr[i], String.format("Parameter classNameToObjectInstanceArray[%d] cannot be null for Builder::withParameters", Integer.valueOf(i)));
                this.parameterTypes[i] = Class.forName((String) pair.first());
                this.parameterInstances[i] = pair.second();
            }
            return this;
        }

        @SafeVarargs
        public final <T> Builder withParametersOfResolvedTypes(Pair<Class<T>, T>... pairArr) {
            this.parameterTypes = new Class[pairArr.length];
            this.parameterInstances = new Object[pairArr.length];
            for (int i = 0; i < pairArr.length; i++) {
                Pair pair = (Pair) Objects.requireNonNull(pairArr[i], String.format("Parameter classToObjectInstanceArray[%d] cannot be null for Builder::withParametersOfResolvedTypes", Integer.valueOf(i)));
                this.parameterTypes[i] = (Class) pair.first();
                this.parameterInstances[i] = pair.second();
            }
            return this;
        }

        public MethodAccessor build() {
            ArrayList arrayList = new ArrayList();
            if (this.clazz == null) {
                arrayList.add("clazz");
            }
            if (this.methodName == null) {
                arrayList.add("methodName");
            }
            if (!arrayList.isEmpty()) {
                throw new IllegalStateException("Missing required parameter(s): " + Joiner.join(", ", arrayList));
            }
            return new MethodAccessor(this.clazz, this.instance, this.methodName, this.parameterTypes, this.parameterInstances);
        }
    }
}
