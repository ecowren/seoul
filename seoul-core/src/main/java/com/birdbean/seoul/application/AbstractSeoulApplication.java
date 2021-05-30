/*
 * Copyright (C) 2021 the original author or authors.
 *
 * Licensed under the ecowren.
 * you may not use this file except in compliance with the License.
 */
package com.birdbean.seoul.application;

import com.google.common.base.Joiner;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.pippo.controller.ControllerApplication;
import ro.pippo.core.Request;
import ro.pippo.core.route.RoutePreDispatchListener;
import ro.pippo.guice.GuiceControllerFactory;

import  static  com.birdbean.seoul.config.SeoulConfig.SPACE_PADDED_PIPE;
import  static  com.birdbean.seoul.config.SeoulConfig.EMPTY;
/**
 * @author Dahuin Choi
 */
@Slf4j
public abstract class AbstractSeoulApplication extends ControllerApplication {

    private static final Logger log = LoggerFactory.getLogger(AbstractSeoulApplication.class);

    protected final Injector injector;

    protected AbstractSeoulApplication(){

        injector = Guice.createInjector(installModules());
        injector.injectMembers(this);
        registerPreDispatchListensers(((request, response) -> log.debug(getLogMessage(request))));
        setControllerFactory(new GuiceControllerFactory(injector));
        preInit();
    }

    protected abstract Module[] installModules();

    protected abstract void preInit();

    private void registerPreDispatchListensers(@NonNull RoutePreDispatchListener ... preDispatchListeners){
        for (RoutePreDispatchListener preDispatchListener : preDispatchListeners){
            getRoutePreDispatchListeners().add(preDispatchListener);
        }
    }

    private String getLogMessage(Request request) {
        return Joiner.on(SPACE_PADDED_PIPE).useForNull(EMPTY).join(
                request.getMethod(),
                request.getApplicationUriWithQuery(),
                request.getParameters().toString());
    }
}
