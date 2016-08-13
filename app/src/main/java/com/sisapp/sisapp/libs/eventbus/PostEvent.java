package com.sisapp.sisapp.libs.eventbus;

/**
 * Created by Elmost on 11/08/2016.
 */
public interface PostEvent {

    void postEvent(int type);

    void postEvent(int type, String message);

}
