package DAO.daoProductos;


public class daoProductos {
    private static daoProductos mInstance;

    public static daoProductos getInstance() {
        if (mInstance == null) {
            mInstance = new daoProductos();
        }
        return mInstance;
    }

}
