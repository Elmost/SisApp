package com.sisapp.sisapp.libs.eventbus;

/**
 * EventBus es publicar un centro / suscripción sistema de eventos para Android.
 * <p/>
 * Los eventos se publican (post (Objeto)) al bus, que lo entrega a los suscriptores que tienen
 * un método de control de juego para el tipo de evento.
 * <p/>
 * Para recibir eventos, los suscriptor deben registrarse al bus mediante registro (Objeto).
 * Una vez registrados, los suscriptores reciben eventos hasta anular el registro (objeto).
 * <p/>
 * Los métodos de manipulación de eventos debe ser anotado por suscribirse, debe ser pública,
 * nada (void) volver, y tienen exactamente un parámetro (el evento).
 * <p/>
 * Created by Elmost on 9/08/2016.
 */
public class GreenRobotEventBus implements EventBus {

    // Manejador de eventos.
    org.greenrobot.eventbus.EventBus mEventBus;

    private static class SingletonHolder {
        private static final GreenRobotEventBus INSTANCE = new GreenRobotEventBus();
    }

    public static GreenRobotEventBus getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public GreenRobotEventBus() {
        mEventBus = org.greenrobot.eventbus.EventBus.getDefault();
    }

    /**
     * Registra el suscriptor dado para recibir eventos. Los suscriptores deben llamar a
     * anular el registro, una vez que ya no están interesados en recibir eventos.
     *
     * @param subscriber suscriptor.
     */
    @Override
    public void register(Object subscriber) {
        mEventBus.register(subscriber);
    }

    /**
     * Anular el registro del suscriptor dado de todas las clases de eventos.
     *
     * @param subscriber suscriptor.
     */
    @Override
    public void unregister(Object subscriber) {
        mEventBus.unregister(subscriber);
    }

    /**
     * Publica el evento dado.
     *
     * @param event evento.
     */
    @Override
    public void post(Object event) {
        mEventBus.post(event);
    }
}
