package ru.rrenat358;



public class MainApp {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDao userDao = new ProductDaoImpl(sessionFactoryUtils);
            userDao.testCaching();

        } catch (Exception e) {
            System.out.println("=== Exception ==========================");
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }

    }
}
