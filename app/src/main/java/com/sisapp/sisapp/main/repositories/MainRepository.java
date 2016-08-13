package com.sisapp.sisapp.main.repositories;

import com.sisapp.sisapp.pojos.User;

/**
 * Created by Elmost on 11/08/2016.
 */
public interface MainRepository {

    /**
     * Para suscribirse actualizaciones de usuario
     */
    void toSubscribeUserUpdates();

    void onUpdateUser(User user);
}
