    import java.io.*;  
    class Semaphore extends Thread {  
      static int semaphore;  
      static int work = 0;  
      static int ideal = 1;   
      static {  
        semaphore = ideal;  
      }  
       
      public static void main(String [] args) {  
        int i=1;  
        new Semaphore (i + 1).start();  
      }  
       
      private int no;  
      public  Semaphore(int no) {  
        this.no= no;  
      }  
       
      public void run() {  
        // Now Main Section  
        try {  
          while(true) {  
            int a;  
            BufferedReader br=new BufferedReader(new InputStreamReader (System.in));  
            System.out.println("If You Want Drink Then Press 1");  
            a=Integer.parseInt(br.readLine());  
       
            for(int i=0; i<=10;i++) {  
              if(a==1) {  
                Thread.sleep(800);  
                System.out.println("Cup is Full Please Take it\n");  
              }  
       
              System.out.println("no of Cups left\n"+(10-i));  
            }  
            if(true) {  
              System.out.println(" *** The Keg is Empty *** Replace it to get drink \n\n");  
              System.out.println("Wake Up Pledge the Keg is Empty *** Replace it \n");  
              wait(this.no);  
            }  
          }  
        } catch (Exception E) {  
          E.printStackTrace();  
        }  
        // End of Main Section  
        unlock();  
      }  
       
      static void Wait(int no) {  
        System.out.println("Wait Gentle man I will Replace the Keg");  
       
        try {  
          Thread.sleep(8000);  
        } catch(InterruptedException E) {  
          E.printStackTrace();  
        }  
        System.out.println("the keg is replaced and the drink is ready");  
        while(semaphore != ideal);  
       
        // semaphore = work;  
      }  
       
      static void unlock() {  
        semaphore = ideal;  
      }  
       
    }  
