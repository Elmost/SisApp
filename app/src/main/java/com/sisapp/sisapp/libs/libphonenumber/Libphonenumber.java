package com.sisapp.sisapp.libs.libphonenumber;

import android.util.Log;

/**
 * Created by Elmost on 8/08/2016.
 */
public class LibPhoneNumber {

    private LibPhoneNumber() {
    }

    /**
     * Clase qué asegura una unica instancia.
     */
    private static class SingletonLibPhoneNumber {
        private static final LibPhoneNumber INSTANCE = new LibPhoneNumber();
    }

    /**
     * Constructor publico.
     *
     * @return Instancia de LibPhoneNumber.
     */
    public static LibPhoneNumber getINSTANCE() {
        return SingletonLibPhoneNumber.INSTANCE;
    }

/**
 @Override public Boolean isValidNumber(String countryCode, String phNumber) {
 PhoneNumberUtil mPhoneNumberUtil = PhoneNumberUtil.getInstance();
 String isoCode = mPhoneNumberUtil.getRegionCodeForCountryCode(Integer.parseInt(countryCode));
 Phonenumber.PhoneNumber mPhonenumber = null;

 try {
 mPhonenumber = mPhoneNumberUtil.parse(phNumber, isoCode);
 } catch (NumberParseException e) {
 Log.e(this.getClass().getName(), e.getMessage());
 }
 return mPhoneNumberUtil.isValidNumber(mPhonenumber);
 }
 **/
}
