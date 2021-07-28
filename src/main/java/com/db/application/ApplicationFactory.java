package com.db.application;

import java.util.ArrayList;
import java.util.List;

public class ApplicationFactory {
    private List<String> cache = new ArrayList<String>();
    private static final IApplication application = new GoldApplicationImpl();
    private static ApplicationFactory factory = null;
    private static IApplication proxy = null;

    protected ApplicationFactory() {
    }

    public static IApplication getApplication() {
        if (proxy == null) {
            proxy = new SecurityLoggerProxy(new AuditLoggerProxy(application));
        }
        return proxy;
    }

    public void addCache(String data) {
        cache.add(data);
    }

    public List<String> getCache() {
        return cache;
    }

    public static ApplicationFactory getInstance() {
        if (factory == null) {
            synchronized (ApplicationFactory.class) {
                if (factory == null) {
                    factory = new ApplicationFactory();
                }
            }
        }
        return factory;
    }
}
