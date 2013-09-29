import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


class CatLizardSem 
{
        private static int WORLDEND = 30;

       private static int NUM_LIZARDS =20;

       private static int MAX_LIZARD_CROSSING = 4;

      private static int MAX_LIZARD_SLEEP_TIME = 3;

      private static int MAX_LIZARD_EAT_TIME = 5;

      private static int CROSS_TIME = 2;

      private static int MAX_CAT_SLEEP;

       int numCrossingSago2MonkeyGrass = 0;

       int numCrossingMonkeyGrass2Sago = 0;

      Semaphore semaphoreCrossway = new Semaphore(MAX_LIZARD_CROSSING,true);

      Semaphore mutex = new Semaphore(4);

      private static boolean running = true;

      private static boolean debug = true;


    public void go()
    {
        ArrayList<Thread> allThreads = new ArrayList<Thread>();

        // create all the lizzard threads
        for (int i=0; i < NUM_LIZARDS; i++) 
        {       allThreads.add(new LizardThread(i) );
            allThreads.get(i).start();
}
        // create the cat thread
        Thread CatThread = new CatThread();
         CatThread.start();

        // let the world run for a while
        sleep (WORLDEND);

        // terminate all threads
        running = false;
        // wait until all threads terminate by joining all of them
        for (int i=0; i < NUM_LIZARDS; i++) {
            try {
               allThreads.get(i).join();
            } catch (InterruptedException ex) {
                System.err.println ("unable to join thread, " + ex.getMessage());
            }
        }
    }
       /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // starts the program
        new CatLizardSem().go();
    }

     /**
     * Models a cat thread.
     */
    public class CatThread extends Thread {


        /**
         * @see java.lang.Runnable.
         */
        @Override
        public void run() 
        {   
            // you must finish this method

            while (running) {
               // sleep for a while
               catSleep();

               // check on lizzards
               checkCrossway();
            }
        }

        /**
         * Puts cat thread to sleep for a random time.
         */
        public void catSleep()
        {
            int sleepSeconds  = 1 + (int)(Math.random()*MAX_CAT_SLEEP);

            if (debug) {
                System.out.println ("  Cat is sleeping for " + sleepSeconds + " seconds.");
                System.out.flush();
            }
            try {
                sleep(sleepSeconds*10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CatLizardSem.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (debug) {
                System.out.println ("Cat awakes.");
                System.out.flush();
            }
        }

        /**
         * Simulates cat checking the crossway.
         */
        public void checkCrossway()
        {
            if (numCrossingMonkeyGrass2Sago + numCrossingSago2MonkeyGrass > MAX_LIZARD_CROSSING) {
                System.out.println ("The cat says yum!");
                System.out.flush();
                     System.exit(-1);
            }
       }
    }

    /**
     * Models a lizard thread.
     */
    public class LizardThread extends Thread {

        private int _id;

        /**
         * Creates a new lizard thread.
         * 
         * @param id the id assigned to the lizard thread
         */
        public LizardThread(int id)
        {
            _id = id;
        }

        /**
         * @see java.lang.Runnable.
         */
        @Override
        public void run() 
        {    
            while (running) {
               // sleep for a while in sago
               lizardSleep();
               // wait until safe to cross from sago to monkey grass
               sagoToMonkeyIsSafe();
               // cross path to monkey grass
               crossedOverToMonkey();
               // eat in the monkey grass
               lizardEat();
               // wait untill its safe to cross back to sago
               monkeyToSagoIsSafe();
               // cross from cross monkey grass to sage
               crossMonkeyToSago();
            }
        }

        /**
         * This tests if it is safe to travel from sago to monkey.
         * Finish this.
         */
        public void sagoToMonkeyIsSafe()
        {
            if (debug) {
                System.out.println ("Lizard [" + _id + "] checks sago -> monkey grass.");
                System.out.flush();
            }

            // you must add code here
            // use a semaphore 


            if (debug) {
                System.out.println ("Lizard [" + _id + "] thinks sago -> monkey grass is safe.");
                System.out.flush();
            }
        }

        /**
         * Indicates that lizard crossed over to monkey grass.
         * Finish this.
         */
        public void crossedOverToMonkey()
        {
            if (debug) {
                System.out.println ("Lizard [" + _id + "] made it to monkey grass.");
                System.out.flush();
            }

            // add code here
        }


        /**
         * This tests if it is safe to travel from monkey to sago.
         * Finish this.
         */
        public void monkeyToSagoIsSafe()
        {
            if (debug) {
                System.out.println ("Lizard [" + _id + "] checks monkey grass -> sago.");
                System.out.flush();
            }

            // you must add code here
            // use a semaphore 

            if (debug) {
                System.out.println ("Lizard [" + _id + "] thinks monkey grass -> sago is safe.");
                System.out.flush();
            }
        }

        /**
         * Indicates that lizard crossed over to sago.
         * Finish this.
         */
        public void crossedOverToSago()
        {
            if (debug) {
                System.out.println ("Lizard [" + _id + "] made it to sago.");
                System.out.flush();
            }

            // add code here
        }

        /**
         * Indicates that lizard is crossing over from monkey to sago.
         * Finish this
         */
        void crossMonkeyToSago()
        {
            if (debug) {
                System.out.println ("Lizard [" + _id + "] is crossing monkey grass to sago.");
                System.out.flush();
            }

            numCrossingMonkeyGrass2Sago++;

            // simulate walk
            try {
                sleep(CROSS_TIME*10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CatLizardSem.class.getName()).log(Level.SEVERE, null, ex);
            }

            numCrossingMonkeyGrass2Sago--;
        }

        /**
         * Indicates that lizard is crossing over from sago to monkey. 
         */
        void crossSagoToMonkey()
        {

            if (debug) {
                System.out.println ("Lizard [" + _id + "] is crossing sago to monkey grass.");
                System.out.flush();
            }

            numCrossingSago2MonkeyGrass++;

            // simulate walk
            try {
                sleep(CROSS_TIME*10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CatLizardSem.class.getName()).log(Level.SEVERE, null, ex);
            }

            numCrossingSago2MonkeyGrass--;
        }


        /**
         * Puts lizard thread to sleep for a random amount of time.
         */
        public void lizardSleep()
        {
            int sleepSeconds  = 1 + (int)(Math.random()*MAX_LIZARD_SLEEP_TIME);

            if (debug) {
                System.out.println ("Lizard [" + _id + "] is sleeping for " + sleepSeconds + " seconds.");
                System.out.flush();
            }
            try {
                sleep(sleepSeconds*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CatLizardSem.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (debug) {
                System.out.println ("Lizard [" + _id + "] awakes.");
                System.out.flush();
            }
        }

        /**
         * Simulates lizard eating for a random amount of time.
         */
        public void lizardEat()
        {
            int eatSeconds  = 1 + (int)(Math.random()*MAX_LIZARD_EAT_TIME);

            if (debug) {
                System.out.println ("Lizard [" + _id + "] is eating for " + eatSeconds + " seconds.");
                System.out.flush();
            }
            try {
                sleep(eatSeconds*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CatLizardSem.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (debug) {
                System.out.println ("Lizard [" + _id + "] finished eating.");
                System.out.flush();
            }
        }
    }


    /**
     * Puts current thread to sleep for a specified amount of time.
     * 
     * @param seconds the number of seconds to put the thread to sleep
     */
    private static void sleep(int seconds)
    {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CatLizardSem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
