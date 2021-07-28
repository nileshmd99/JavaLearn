package com.db.application;

public class ApplicationLauncher {
    public static void main(String[] args) {
        /**
         * Disengage with the implementation .....
         * Disengage with the Classes for business implementation only work with interfaces
         * Decoupling will help in enchancement of the future proof coding
         */
       IApplication application1 = ApplicationFactory.getApplication();
       application1.getVersion();
       application1.deposit("xx", 1);
    }
}
