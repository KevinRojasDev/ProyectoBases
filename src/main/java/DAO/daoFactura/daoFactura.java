package DAO.daoFactura;


public class daoFactura {
    private static daoFactura mInstance;

    public static daoFactura getInstance() {
        if (mInstance == null) {
            mInstance = new daoFactura();
        }
        return mInstance;
    }
}
