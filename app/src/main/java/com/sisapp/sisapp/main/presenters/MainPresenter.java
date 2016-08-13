package com.sisapp.sisapp.main.presenters;

import com.sisapp.sisapp.main.events.UserEvent;
import com.sisapp.sisapp.pojos.User;

/**
 * Created by Elmost on 11/08/2016.
 */
public interface MainPresenter {

    /**
     * Entrar en crear.
     */
    void onCreate();

    /**
     * Entrar en pausa.
     */
    void onPause();

    /**
     * Entrar en resumen.
     */
    void onResume();

    /**
     * Entrar en destruir.
     */
    void onDestroy();

    /**
     * Cerrar la sesión.
     */
    void signOff();

    /**
     * Receptor de eventos de usuario.
     *
     * @param userEvent evento de usuario.
     */
    void toReceiveEvents(UserEvent userEvent);

    void toSubscribeUserUpdates();

    void onUpdateUser(User user);
}
