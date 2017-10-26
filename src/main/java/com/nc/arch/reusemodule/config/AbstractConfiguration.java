package com.nc.arch.reusemodule.config;

public abstract class AbstractConfiguration implements Configuration {

    protected int xxx;
    protected boolean yyy;
    protected String zzz;

    protected AbstractConfiguration() {}

    @Override
    public int getXXX() {
        return xxx;
    }

    @Override
    public boolean isYYY() {
        return yyy;
    }

    @Override
    public String getZZZ() {
        return zzz;
    }
}