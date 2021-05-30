package com.birdbean.seoul.application;

import ro.pippo.core.Application;
import ro.pippo.core.Pippo;
import ro.pippo.core.PippoFilter;
import ro.pippo.core.WebServer;

public class Seoul extends Pippo {

    public class SeoulFilter extends PippoFilter{
    }

    public SeoulFilter createFilter(Application application){
        return (SeoulFilter) super.createPippoFilter(application);
    }

    public Seoul(Application application) {
        super(application);
    }

    public Seoul() {
        super();
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public Application getApplication() {
        return super.getApplication();
    }

    @Override
    @SuppressWarnings("rawtypes")
    public WebServer getServer() {
        return super.getServer();
    }
}
