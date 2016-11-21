package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

// Largely inspired by a class given by my teachers last year at INSA Lyon (Yann GRIPAY and Anne TCHOUNIKINE)
public class JpaUtil {

    public static final String PERSISTENCE_UNIT_NAME = "VeRecipesPersist";

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    /**
     * Manages the current instances of the Entity Manager. It assures us that there only is one instance per thread
     */
    private static final ThreadLocal<EntityManager> threadLocalEntityManager = new ThreadLocal<EntityManager>() {

        @Override
        protected EntityManager initialValue() {
            return null;
        }
    };

    private static void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
        }
    }

    // Console logs
    // The flushes and pauses are there to try to synchronize the console outputs
    private static void log(String message) {
        System.out.flush();
        pause(5);
        System.err.println("[JpaUtil:Log] " + message);
        System.err.flush();
        pause(5);
    }

    /**
     * Initializes the Entity Manager Factory
     */
    public static synchronized void init() {
        log("Initialization of the Factory in a persistence context");
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    /**
     * Frees the Entity Manager Factory
     */
    public static synchronized void destroy() {
        log("Liberation of the facroty in a persistence context");
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
            entityManagerFactory = null;
        }
    }

    /**
     * Creates an instance of the Entity Manager (bound to a thread)
     */
    public static void createEntityManager() {
        log("Creation of the persistence context");
        threadLocalEntityManager.set(entityManagerFactory.createEntityManager());
    }

    /**
     * Closes the current instance of the Entity Manager (bound to the current thread)
     */
    public static void closeEntityManager() {
        log("Closure of the persistence context");
        EntityManager em = threadLocalEntityManager.get();
        em.close();
        threadLocalEntityManager.set(null);
    }

    /**
     * Begins a transation in the current Entity Manager
     */
    public static void openTransaction() {
        log("Beginning of the transaction");
        EntityManager em = threadLocalEntityManager.get();
        if (em.getTransaction().isActive()) {
            log("WARNING: the transaction is already open");
        }
        em.getTransaction().begin();
    }

    /**
     * Commits a transactions in the current Entity Manager
     *
     * @exception RollbackException when the commit is unsuccessful
     */
    public static void commitTransaction() throws RollbackException {
        log("Commit of the transaction");
        EntityManager em = threadLocalEntityManager.get();
        if (!em.getTransaction().isActive()) {
            log("Warning: the transaction hasn't been opened");
        }
        em.getTransaction().commit();
    }

    /**
     * Cancels the transaction in the current Entity Manager.
     */
    public static void cancelTransaction() {
        log("Rollback of the transaction");
        EntityManager em = threadLocalEntityManager.get();
        if (!em.getTransaction().isActive()) {
            log("WARNING: The transaction is not open");
        } else {
            em.getTransaction().rollback();
        }
    }

    /**
     * Returns the current Entity Manager
     *
     * @return instance of the current Entity Manager
     */
    public static EntityManager getEntityManager() {
        log("Acquisition of the persistence context");
        return threadLocalEntityManager.get();
    }

}
