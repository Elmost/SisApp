package com.sisapp.sisapp.pojos;

import java.util.Map;

/**
 * Setup de SisApp
 * Su función es preparar la configuración de la aplicación en tiempo real.
 * <p/>
 * Created by Elmost on 8/08/2016.
 */
public class Setup {

    /**
     * Estado en qué se encuentra la aplicación SisApp: Disponible = true, en caso contrario false.
     */
    private boolean available;

    /**
     * Código de estado en que se encuentra la aplicación
     */
    private int Status;

    /**
     * Mensaje de estado de la aplicación.
     */
    private String messageStatus;

    /**
     * Clics minimos permitidos por día.
     */
    private int minimumClicks;

    /**
     * Estandar de clics permitidos por día.
     */
    private int standardClicks;

    /**
     * Maximos clics permitidos por día.
     */
    private int maximumClicks;

    /**
     * Cantidad de miembros actuales registrados en la aplicación.
     */
    private int currentMembers;

    /**
     * Cantidad minima de miembros permitidos.
     */
    private int minimumMembers;

    /**
     * Cantidad estandar de miembros permitidos.
     */
    private int standardMembers;

    /**
     * Cantidad maxima de miembros permitidos.
     */
    private int maximumMembers;

    /**
     * Fecha y hora de ultima actualización
     */
    private int timestamp;

    /**
     * Porcentaje de comisión por clic.
     */
    private double clickPercentage;

    /**
     * Pagos por pais, tipo de divisa y valor.
     * COP : 1000
     */
    private Map<String, Double> payments;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }

    public int getMinimumClicks() {
        return minimumClicks;
    }

    public void setMinimumClicks(int minimumClicks) {
        this.minimumClicks = minimumClicks;
    }

    public int getStandardClicks() {
        return standardClicks;
    }

    public void setStandardClicks(int standardClicks) {
        this.standardClicks = standardClicks;
    }

    public int getMaximumClicks() {
        return maximumClicks;
    }

    public void setMaximumClicks(int maximumClicks) {
        this.maximumClicks = maximumClicks;
    }

    public int getCurrentMembers() {
        return currentMembers;
    }

    public void setCurrentMembers(int currentMembers) {
        this.currentMembers = currentMembers;
    }

    public int getMinimumMembers() {
        return minimumMembers;
    }

    public void setMinimumMembers(int minimumMembers) {
        this.minimumMembers = minimumMembers;
    }

    public int getStandardMembers() {
        return standardMembers;
    }

    public void setStandardMembers(int standardMembers) {
        this.standardMembers = standardMembers;
    }

    public int getMaximumMembers() {
        return maximumMembers;
    }

    public void setMaximumMembers(int maximumMembers) {
        this.maximumMembers = maximumMembers;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public double getClickPercentage() {
        return clickPercentage;
    }

    public void setClickPercentage(double clickPercentage) {
        this.clickPercentage = clickPercentage;
    }

    public Map<String, Double> getPayments() {
        return payments;
    }

    public void setPayments(Map<String, Double> payments) {
        this.payments = payments;
    }
}
