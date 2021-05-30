/*
 * Copyright (C) 2021 the original author or authors.
 *
 * Licensed under the ecowren.
 * you may not use this file except in compliance with the License.
 */
package com.birdbean.seoul.application;

import com.google.inject.Module;

/**
 * @author Dahuin Choi
 */
public class BirdbeanApplication extends AbstractSeoulApplication{

    @Override
    protected Module[] installModules() {
        return new Module[0];
    }

    @Override
    protected void preInit() {

    }

    @Override
    protected void onInit() {
        super.onInit();
    }
}
