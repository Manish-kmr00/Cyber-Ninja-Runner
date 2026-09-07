package com.bykv.vk.openvk.preload.b;

/* JADX INFO: compiled from: InterceptorFactory.java */
/* JADX INFO: loaded from: classes5.dex */
public interface e {
    <T> T a(Class<T> cls);

    /* JADX INFO: compiled from: InterceptorFactory.java */
    public static class a implements e {
        @Override // com.bykv.vk.openvk.preload.b.e
        public final <T> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
