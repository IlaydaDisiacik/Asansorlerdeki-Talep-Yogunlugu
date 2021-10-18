
package yazlab12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author balpe
 */
public class Yazlab12 {

    Vector<Elevator> elevatorVector = new Vector<Elevator>(); // Asansorleri tutacak vektor yapisi.
    HashMap<Integer,Integer> userHashMap = new HashMap<Integer,Integer>(); // Gelen musterileri tutacak HashMap.
    HashMap<Integer,Integer> FloorZeroCostumerHashMap = new HashMap<Integer,Integer>(); // 0.katin musterilerini tutacak HashMap.
    HashMap<Integer,Integer> FloorOneCostumerHashMap = new HashMap<Integer,Integer>(); // 1.katin musterilerini tutacak HashMap.
    HashMap<Integer,Integer> FloorTwoCostumerHashMap = new HashMap<Integer,Integer>(); // 2.katin musterilerini  tutacak HashMap.
    HashMap<Integer,Integer> FloorThreeCostumerHashMap = new HashMap<Integer,Integer>(); // 3.katin musterilerini tutacak HashMap.
    HashMap<Integer,Integer> FloorFourCostumerHashMap = new HashMap<Integer,Integer>(); // 4.katin musterilerini tutacak HashMap.
    
    Elevator mainElevator = new Elevator(); // Ana asansoru olusturduk.
    Elevator secondElevator = new Elevator(); // 2.asansoru olusturduk.
    Elevator thirdElevator = new Elevator(); // 3.asansoru olusturduk.
    Elevator fourthElevator = new Elevator(); // 4.asansoru olusturduk.
    Elevator fifthElevator = new Elevator(); // 5.asansoru olusturduk.
    
    // Asansor icindeki musterileri tutacak HashMap.
    Vector<HashMap> elevatorCountVector = new Vector<HashMap>();
    HashMap<Integer,Integer> FirstElevatorInsideHashMap = new HashMap<Integer,Integer>(); 
    HashMap<Integer,Integer> SecondElevatorInsideHashMap = new HashMap<Integer,Integer>(); 
    HashMap<Integer,Integer> ThirdElevatorInsideHashMap = new HashMap<Integer,Integer>(); 
    HashMap<Integer,Integer> FourthElevatorInsideHashMap = new HashMap<Integer,Integer>(); 
    HashMap<Integer,Integer> FifthElevatorInsideHashMap = new HashMap<Integer,Integer>(); 
    
    int exitCount = 0;
    private int yogunluk = 0;
    int tempCount = 0;
    int elevatorCount = 0;
    int tempListCount;
    int giden = 0;

    public  int getYogunluk(){
        return yogunluk;
    }
    
    public  void setYogunluk(int yogunluk){
        this.yogunluk = yogunluk;
    }
    
    // Musteri olusturuyoruz.
    public  void musteriOlustur(){
        
        tempCount = tempCount - giden;
        // Gelen musteri sayisi
        Random r = new Random();
        int gelenMusteriSayisi = r.nextInt(11);
        
        if(gelenMusteriSayisi == 0 ){ // Kimsenin gelmeme durumu icin onlem.
            gelenMusteriSayisi += 1;
        }
        
        int tempFloor=0;
        setYogunluk(getYogunluk() + gelenMusteriSayisi);
        
        for(int i = 0; i<gelenMusteriSayisi; i++){ // Musterilerin gidecegi kat bilgisini atiyor.
                
            tempFloor = r.nextInt(5);

            if(tempFloor == 0){ // Eger gelen kat sayisi 0 ise 1.kat olarak atiyor.
                tempFloor +=1;
            }
            userHashMap.put(tempCount,tempFloor);               // i.musteri uretilen rastgele kata gidecek.
            FloorZeroCostumerHashMap.put(tempCount,tempFloor); // Gelen musteri 0.katta ataniyor.
            tempCount = tempCount + 1;
        }
        
        if(getYogunluk() < 20){ // Toplam musteri sayisi 20nin altinda ise ilk asansor aktif.
            
            elevatorCount = 1; // Yogunluk 20den az ise 1 asansor olacak dusuncesi ile.
            for(int i = 1;i<elevatorVector.size();i++){ // Ana asansor haric diger asansorlerin aktifligini kapatiyoruz.
                elevatorVector.get(i).setActive(false);
            }
        }else if((getYogunluk() >= 20) && (getYogunluk() < 40)) {
            secondElevator.setActive(true);
            
            thirdElevator.setActive(false);
            fourthElevator.setActive(false);
            fifthElevator.setActive(false);
            
        }
        else if((getYogunluk() >= 20) && (getYogunluk() < 40)) {
            secondElevator.setActive(true);
            thirdElevator.setActive(true);
            
            fourthElevator.setActive(false);
        }
        else if((getYogunluk() >= 40) && (getYogunluk() < 60)) {
            secondElevator.setActive(true);
            thirdElevator.setActive(true);
            fourthElevator.setActive(true);
            
            fifthElevator.setActive(false);
        }
        else if(getYogunluk() >= 60) {
            secondElevator.setActive(true);
            thirdElevator.setActive(true);
            fourthElevator.setActive(true);
            fifthElevator.setActive(true);
        }
    } // musteriOlustur()
    
    public void musteriCikisi(){
        Random r = new Random();
        int rastgeleInsan = 1+r.nextInt(5);
        int rastgeleKat = 1+r.nextInt(4);
        Elevator elevator = new Elevator();
        
        if(rastgeleKat==1){
           if(FloorOneCostumerHashMap.size() != 0 ){
              if(FloorOneCostumerHashMap.size() <= rastgeleInsan){
                FloorOneCostumerHashMap.clear();
                exitCount+=FloorOneCostumerHashMap.size();
              }        
              else{    
                FloorOneCostumerHashMap.remove(rastgeleInsan);
                exitCount+=rastgeleInsan;   
              }
           }  
        } 
        
        if(rastgeleKat==2){
          if(FloorTwoCostumerHashMap.size() != 0 ){
              if(FloorTwoCostumerHashMap.size() <= rastgeleInsan){
                FloorTwoCostumerHashMap.clear();
                exitCount+=FloorTwoCostumerHashMap.size();
              }        
              else{    
                FloorTwoCostumerHashMap.remove(rastgeleInsan);
                exitCount+=rastgeleInsan;   
              }
           }
        }
        
        if(rastgeleKat==3){
          if(FloorThreeCostumerHashMap.size() != 0 ){
              if(FloorThreeCostumerHashMap.size() <= rastgeleInsan){
                FloorThreeCostumerHashMap.clear();
                exitCount+=FloorThreeCostumerHashMap.size();
              }        
              else{    
                FloorThreeCostumerHashMap.remove(rastgeleInsan);
                exitCount+=rastgeleInsan;   
              }
           }
        }
         
        if(rastgeleKat==4){
         if(FloorFourCostumerHashMap.size() != 0 ){
              if(FloorFourCostumerHashMap.size() <= rastgeleInsan){
            FloorFourCostumerHashMap.clear();
            exitCount+=FloorFourCostumerHashMap.size();
              }        
              else{    
            FloorFourCostumerHashMap.remove(rastgeleInsan);
            exitCount+=rastgeleInsan;   
              }
           }
        }
    }
    
    public static void main(String[] args) {
        
        Yazlab12 mainController = new Yazlab12();
        
        mainController.createElevator(); // Asansorleri olusturdu.
        mainController.threadController();
        
    } // main()
    
    public void threadController(){
        
        // 500ms de bir calisacak olan giris islemlerini yapan thread.
        Thread loginThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {                    
                    try {
                        Thread.sleep(500);
                        musteriOlustur();
                        outputScreen(); // Cikti ekrani
                    } catch (InterruptedException ex) {
                        System.out.println("Musteri olusturulamadi..");
                    }
                }
            }
        });
        
        // 1000ms de bir calisacak olan cikis islemlerini yapan thread.
        Thread exitThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        musteriCikisi();
                    } catch (InterruptedException ex) {
                        System.out.println("Cikis yapilamadi..");
                    }
                }
            }
        });
        // Surekli calisacak olan ana asansore ait thread.
        Thread mainElevatorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    elevatorMove(mainElevator, 0);
                    
                    giden = 0;
                    int productNo1 = 0, productNo2 = 0, productNo3 = 0, productNo4 = 0;
                    tempListCount = elevatorCountVector.get(0).size();

                    while(mainElevator.getCurrentFloor() < 4 && (!(elevatorCountVector.get(0).isEmpty()))){
                        try {
                            Thread.sleep(200);
                            mainElevator.setCurrentFloor(mainElevator.getCurrentFloor() + 1); // Asansor bir ust kata cikti.
                            if(mainElevator.getCurrentFloor() == 1){
                                for(int i = 0 ;i<tempListCount;i++){
                                    if((elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(0).get(i) == 1)){ // Bos eleman degilse ve musterinin hedefi bu kat ise indir.
                                        mainElevator.setDestination(1);
                                        FloorOneCostumerHashMap.put(productNo1, (int)elevatorCountVector.get(0).get(i));
                                        elevatorCountVector.get(0).remove(i);
                                        giden = giden + 1; 
                                        mainElevator.setCount_inside(mainElevator.getCount_inside() - 1);
                                        productNo1 = productNo1 + 1;
                                    }
                                }
                            }
                            if(mainElevator.getCurrentFloor() == 2){
                                for(int i = 0 ;i<tempListCount;i++){
                                    if((elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(0).get(i) == 2)){
                                        mainElevator.setDestination(2);
                                        FloorTwoCostumerHashMap.put(productNo2, (int)elevatorCountVector.get(0).get(i));
                                        elevatorCountVector.get(0).remove(i);
                                        giden = giden + 1;
                                        mainElevator.setCount_inside(mainElevator.getCount_inside() - 1);
                                        productNo2 = productNo2 + 1;
                                    }
                                }
                            }
                            if(mainElevator.getCurrentFloor() == 3){
                                for(int i = 0 ;i<tempListCount;i++){
                                    if((elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(0).get(i) == 3)){
                                        mainElevator.setDestination(3);
                                        FloorThreeCostumerHashMap.put(productNo3, (int)elevatorCountVector.get(0).get(i));
                                        elevatorCountVector.get(0).remove(i);
                                        giden = giden + 1;
                                        mainElevator.setCount_inside(mainElevator.getCount_inside() - 1);
                                        productNo3 = productNo3 + 1;
                                    }
                                }
                            }
                            if(mainElevator.getCurrentFloor() == 4){
                                for(int i = 0 ;i<tempListCount;i++){
                                    if((elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(0).get(i) == 4)){
                                        mainElevator.setDestination(4);
                                        FloorFourCostumerHashMap.put(productNo4, (int)elevatorCountVector.get(0).get(i));
                                        elevatorCountVector.get(0).remove(i);
                                        giden = giden + 1;
                                        mainElevator.setCount_inside(mainElevator.getCount_inside() - 1);
                                        productNo4 = productNo4 + 1;
                                    }
                                }
                            }
                        } catch (InterruptedException ex) {
                            System.out.println("Asansor Tasima hatasi");
                        }
                    }
                    if(elevatorCountVector.get(0).isEmpty()){
                        while(mainElevator.getCurrentFloor() != 0){
                            mainElevator.setDestination(0);
                            try {
                                Thread.sleep(200);
                                mainElevator.setCurrentFloor(mainElevator.getCurrentFloor() - 1);
                            } catch (InterruptedException ex) {
                                System.out.println("ZEMINE ULASILAMADI!!!");
                            }
                        }
                        mainElevator.setCurrentFloor(0);
                        mainElevator.setCount_inside(0);
                    }

                    mainElevator.setMode(false);
                    editHashMap();
                }
            }
        });
        if(secondElevator.isActive()){
            Thread secondElevatorThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if(secondElevator.isActive()){
                            elevatorMove(secondElevator, 1);
                            
                            giden = 0;
                            int productNo1 = 0, productNo2 = 0, productNo3 = 0, productNo4 = 0;
                            tempListCount = elevatorCountVector.get(1).size();

                            while(secondElevator.getCurrentFloor() < 4 && (!(elevatorCountVector.get(1).isEmpty()))){
                                try {
                                    Thread.sleep(200);
                                    secondElevator.setCurrentFloor(secondElevator.getCurrentFloor() + 1); // Asansor bir ust kata cikti.
                                    if(secondElevator.getCurrentFloor() == 1){
                                        for(int i = 0 ;i<tempListCount;i++){
                                            if((elevatorCountVector.get(0).get(i) != null) && ((int)elevatorCountVector.get(1).get(i) == 1)){ // Bos eleman degilse ve musterinin hedefi bu kat ise indir.
                                                secondElevator.setDestination(1);
                                                FloorOneCostumerHashMap.put(productNo1, (int)elevatorCountVector.get(1).get(i));
                                                elevatorCountVector.get(1).remove(i);
                                                giden = giden + 1; 
                                                secondElevator.setCount_inside(secondElevator.getCount_inside() - 1);
                                                productNo1 = productNo1 + 1;
                                            }
                                        }
                                    }
                                    if(secondElevator.getCurrentFloor() == 2){
                                        for(int i = 0 ;i<tempListCount;i++){
                                            if((elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(1).get(i) == 2)){
                                                secondElevator.setDestination(2);
                                                FloorTwoCostumerHashMap.put(productNo2, (int)elevatorCountVector.get(1).get(i));
                                                elevatorCountVector.get(1).remove(i);
                                                giden = giden + 1;
                                                secondElevator.setCount_inside(secondElevator.getCount_inside() - 1);
                                                productNo2 = productNo2 + 1;
                                            }
                                        }
                                    }
                                    if(secondElevator.getCurrentFloor() == 3){
                                        for(int i = 0 ;i<tempListCount;i++){
                                            if(((elevatorCountVector.get(0).get(i) != null) &&(int)elevatorCountVector.get(1).get(i) == 3)){
                                                secondElevator.setDestination(3);
                                                FloorThreeCostumerHashMap.put(productNo3, (int)elevatorCountVector.get(1).get(i));
                                                elevatorCountVector.get(1).remove(i);
                                                giden = giden + 1;
                                                secondElevator.setCount_inside(secondElevator.getCount_inside() - 1);
                                                productNo3 = productNo3 + 1;
                                            }
                                        }
                                    }
                                    if(secondElevator.getCurrentFloor() == 4){
                                        for(int i = 0 ;i<tempListCount;i++){
                                            if((elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(1).get(i) == 4)){
                                                secondElevator.setDestination(4);
                                                FloorFourCostumerHashMap.put(productNo4, (int)elevatorCountVector.get(1).get(i));
                                                elevatorCountVector.get(1).remove(i);
                                                giden = giden + 1;
                                                secondElevator.setCount_inside(secondElevator.getCount_inside() - 1);
                                                productNo4 = productNo4 + 1;
                                            }
                                        }
                                    }
                                } catch (InterruptedException ex) {
                                    System.out.println("Asansor Tasima hatasi");
                                }
                            }
                            if(elevatorCountVector.get(1).isEmpty()){
                                while(secondElevator.getCurrentFloor() != 0){
                                    secondElevator.setDestination(0);
                                    try {
                                        Thread.sleep(200);
                                        secondElevator.setCurrentFloor(secondElevator.getCurrentFloor() - 1);
                                    } catch (InterruptedException ex) {
                                        System.out.println("ZEMINE ULASILAMADI!!!");
                                    }
                                }
                                secondElevator.setCurrentFloor(0);
                                secondElevator.setCount_inside(0);
                            }

                            secondElevator.setMode(false);
                            editHashMap();
                        }
                    }
                }
            });
            secondElevatorThread.start();
        }
        if(thirdElevator.isActive()){
            Thread thirdElevatorThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    if(thirdElevator.isActive()){
                        while (true) {
                            elevatorMove(thirdElevator, 2);
                            
                            giden = 0;
                            int productNo1 = 0, productNo2 = 0, productNo3 = 0, productNo4 = 0;
                            tempListCount = elevatorCountVector.get(2).size();

                            while(thirdElevator.getCurrentFloor() < 4 && (!(elevatorCountVector.get(2).isEmpty()))){
                                try {
                                    Thread.sleep(200);
                                    thirdElevator.setCurrentFloor(thirdElevator.getCurrentFloor() + 1); // Asansor bir ust kata cikti.
                                    if(thirdElevator.getCurrentFloor() == 1){
                                        for(int i = 0 ;i<tempListCount;i++){
                                            if( (elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(2).get(i) == 1)){ // Bos eleman degilse ve musterinin hedefi bu kat ise indir.
                                                thirdElevator.setDestination(1);
                                                FloorOneCostumerHashMap.put(productNo1, (int)elevatorCountVector.get(2).get(i));
                                                elevatorCountVector.get(2).remove(i);
                                                giden = giden + 1; 
                                                thirdElevator.setCount_inside(thirdElevator.getCount_inside() - 1);
                                                productNo1 = productNo1 + 1;
                                            }
                                        }
                                    }
                                    if(thirdElevator.getCurrentFloor() == 2){
                                        for(int i = 0 ;i<tempListCount;i++){
                                            if((elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(2).get(i) == 2)){
                                                thirdElevator.setDestination(2);
                                                FloorTwoCostumerHashMap.put(productNo2, (int)elevatorCountVector.get(2).get(i));
                                                elevatorCountVector.get(2).remove(i);
                                                giden = giden + 1;
                                                thirdElevator.setCount_inside(thirdElevator.getCount_inside() - 1);
                                                productNo2 = productNo2 + 1;
                                            }
                                        }
                                    }
                                    if(thirdElevator.getCurrentFloor() == 3){
                                        for(int i = 0 ;i<tempListCount;i++){
                                            if((elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(2).get(i) == 3)){
                                                thirdElevator.setDestination(3);
                                                FloorThreeCostumerHashMap.put(productNo3, (int)elevatorCountVector.get(2).get(i));
                                                elevatorCountVector.get(2).remove(i);
                                                giden = giden + 1;
                                                thirdElevator.setCount_inside(thirdElevator.getCount_inside() - 1);
                                                productNo3 = productNo3 + 1;
                                            }
                                        }
                                    }
                                    if(thirdElevator.getCurrentFloor() == 4){
                                        for(int i = 0 ;i<tempListCount;i++){
                                            if((elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(2).get(i) == 4)){
                                                thirdElevator.setDestination(4);
                                                FloorFourCostumerHashMap.put(productNo4, (int)elevatorCountVector.get(2).get(i));
                                                elevatorCountVector.get(2).remove(i);
                                                giden = giden + 1;
                                                thirdElevator.setCount_inside(thirdElevator.getCount_inside() - 1);
                                                productNo4 = productNo4 + 1;
                                            }
                                        }
                                    }
                                } catch (InterruptedException ex) {
                                    System.out.println("Asansor Tasima hatasi");
                                }
                            }
                            if(elevatorCountVector.get(2).isEmpty()){
                                while(thirdElevator.getCurrentFloor() != 0){
                                    thirdElevator.setDestination(0);
                                    try {
                                        Thread.sleep(200);
                                        thirdElevator.setCurrentFloor(thirdElevator.getCurrentFloor() - 1);
                                    } catch (InterruptedException ex) {
                                        System.out.println("ZEMINE ULASILAMADI!!!");
                                    }
                                }
                                thirdElevator.setCurrentFloor(0);
                                thirdElevator.setCount_inside(0);
                            }
                            thirdElevator.setMode(false);
                            editHashMap();
                        }
                    }
                }
            });
            thirdElevatorThread.start();
        }
        if(fourthElevator.isActive()){
            Thread fourthElevatorThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        elevatorMove(fourthElevator, 3);
                        
                        giden = 0;
                        int productNo1 = 0, productNo2 = 0, productNo3 = 0, productNo4 = 0;
                        tempListCount = elevatorCountVector.get(3).size();

                        while(fourthElevator.getCurrentFloor() < 4 && (!(elevatorCountVector.get(3).isEmpty()))){
                            try {
                                Thread.sleep(200);
                                fourthElevator.setCurrentFloor(fourthElevator.getCurrentFloor() + 1); // Asansor bir ust kata cikti.
                                if(fourthElevator.getCurrentFloor() == 1){
                                    for(int i = 0 ;i<tempListCount;i++){
                                        if((elevatorCountVector.get(0).get(i) != null) && ((int)elevatorCountVector.get(3).get(i) == 1)){ // Bos eleman degilse ve musterinin hedefi bu kat ise indir.
                                            fourthElevator.setDestination(1);
                                            FloorOneCostumerHashMap.put(productNo1, (int)elevatorCountVector.get(3).get(i));
                                            elevatorCountVector.get(3).remove(i);
                                            giden = giden + 1; 
                                            fourthElevator.setCount_inside(fourthElevator.getCount_inside() - 1);
                                            productNo1 = productNo1 + 1;
                                        }
                                    }
                                }
                                if(fourthElevator.getCurrentFloor() == 2){
                                    for(int i = 0 ;i<tempListCount;i++){
                                        if((elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(3).get(i) == 2)){
                                            fourthElevator.setDestination(2);
                                            FloorTwoCostumerHashMap.put(productNo2, (int)elevatorCountVector.get(3).get(i));
                                            elevatorCountVector.get(3).remove(i);
                                            giden = giden + 1;
                                            fourthElevator.setCount_inside(fourthElevator.getCount_inside() - 1);
                                            productNo2 = productNo2 + 1;
                                        }
                                    }
                                }
                                if(fourthElevator.getCurrentFloor() == 3){
                                    for(int i = 0 ;i<tempListCount;i++){
                                        if((elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(3).get(i) == 3)){
                                            fourthElevator.setDestination(3);
                                            FloorThreeCostumerHashMap.put(productNo3, (int)elevatorCountVector.get(3).get(i));
                                            elevatorCountVector.get(3).remove(i);
                                            giden = giden + 1;
                                            fourthElevator.setCount_inside(fourthElevator.getCount_inside() - 1);
                                            productNo3 = productNo3 + 1;
                                        }
                                    }
                                }
                                if(fourthElevator.getCurrentFloor() == 4){
                                    for(int i = 0 ;i<tempListCount;i++){
                                        if((elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(3).get(i) == 4)){
                                            fourthElevator.setDestination(4);
                                            FloorFourCostumerHashMap.put(productNo4, (int)elevatorCountVector.get(3).get(i));
                                            elevatorCountVector.get(3).remove(i);
                                            giden = giden + 1;
                                            fourthElevator.setCount_inside(fourthElevator.getCount_inside() - 1);
                                            productNo4 = productNo4 + 1;
                                        }
                                    }
                                }
                            } catch (InterruptedException ex) {
                                System.out.println("Asansor Tasima hatasi");
                            }
                        }
                        if(elevatorCountVector.get(3).isEmpty()){
                            while(fourthElevator.getCurrentFloor() != 0){
                                fourthElevator.setDestination(0);
                                try {
                                    Thread.sleep(200);
                                    fourthElevator.setCurrentFloor(fourthElevator.getCurrentFloor() - 1);
                                } catch (InterruptedException ex) {
                                    System.out.println("ZEMINE ULASILAMADI!!!");
                                }
                            }
                            fourthElevator.setCurrentFloor(0);
                            fourthElevator.setCount_inside(0);
                        }

                        fourthElevator.setMode(false);
                        editHashMap();
                    }
                }
            });
            fourthElevatorThread.start();
        }
        if(fifthElevator.isActive()){
            Thread fifthElevatorThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        elevatorMove(fifthElevator, 4);
                        
                        giden = 0;
                        int productNo1 = 0, productNo2 = 0, productNo3 = 0, productNo4 = 0;
                        tempListCount = elevatorCountVector.get(4).size();

                        while(fifthElevator.getCurrentFloor() < 4 && (!(elevatorCountVector.get(4).isEmpty()))){
                            try {
                                Thread.sleep(200);
                                fifthElevator.setCurrentFloor(fifthElevator.getCurrentFloor() + 1); // Asansor bir ust kata cikti.
                                if(fifthElevator.getCurrentFloor() == 1){
                                    for(int i = 0 ;i<tempListCount;i++){
                                        if((elevatorCountVector.get(0).get(i) != null) && ((int)elevatorCountVector.get(4).get(i) == 1)){ // Bos eleman degilse ve musterinin hedefi bu kat ise indir.
                                            fifthElevator.setDestination(1);
                                            FloorOneCostumerHashMap.put(productNo1, (int)elevatorCountVector.get(4).get(i));
                                            elevatorCountVector.get(4).remove(i);
                                            giden = giden + 1; 
                                            fifthElevator.setCount_inside(fifthElevator.getCount_inside() - 1);
                                            productNo1 = productNo1 + 1;
                                        }
                                    }
                                }
                                if(fifthElevator.getCurrentFloor() == 2){
                                    for(int i = 0 ;i<tempListCount;i++){
                                        if((elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(4).get(i) == 2)){
                                            fifthElevator.setDestination(2);
                                            FloorTwoCostumerHashMap.put(productNo2, (int)elevatorCountVector.get(4).get(i));
                                            elevatorCountVector.get(4).remove(i);
                                            giden = giden + 1;
                                            fifthElevator.setCount_inside(fifthElevator.getCount_inside() - 1);
                                            productNo2 = productNo2 + 1;
                                        }
                                    }
                                }
                                if(fifthElevator.getCurrentFloor() == 3){
                                    for(int i = 0 ;i<tempListCount;i++){
                                        if((elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(4).get(i) == 3)){
                                            fifthElevator.setDestination(3);
                                            FloorThreeCostumerHashMap.put(productNo3, (int)elevatorCountVector.get(4).get(i));
                                            elevatorCountVector.get(4).remove(i);
                                            giden = giden + 1;
                                            fifthElevator.setCount_inside(fifthElevator.getCount_inside() - 1);
                                            productNo3 = productNo3 + 1;
                                        }
                                    }
                                }
                                if(fifthElevator.getCurrentFloor() == 4){
                                    for(int i = 0 ;i<tempListCount;i++){
                                        if((elevatorCountVector.get(0).get(i) != null) &&((int)elevatorCountVector.get(4).get(i) == 4)){
                                            fifthElevator.setDestination(4);
                                            FloorFourCostumerHashMap.put(productNo4, (int)elevatorCountVector.get(4).get(i));
                                            elevatorCountVector.get(4).remove(i);
                                            giden = giden + 1;
                                            fifthElevator.setCount_inside(fifthElevator.getCount_inside() - 1);
                                            productNo4 = productNo4 + 1;
                                        }
                                    }
                                }
                            } catch (InterruptedException ex) {
                                System.out.println("Asansor Tasima hatasi");
                            }
                        }
                        if(elevatorCountVector.get(4).isEmpty()){
                            while(fifthElevator.getCurrentFloor() != 0){
                                fifthElevator.setDestination(0);
                                try {
                                    Thread.sleep(200);
                                    fifthElevator.setCurrentFloor(fifthElevator.getCurrentFloor() - 1);
                                } catch (InterruptedException ex) {
                                    System.out.println("ZEMINE ULASILAMADI!!!");
                                }
                            }
                            fifthElevator.setCurrentFloor(0);
                            fifthElevator.setCount_inside(0);
                        }

                        fifthElevator.setMode(false);
                        editHashMap();
                    }
                }
            });
            fifthElevatorThread.start();
        }
        
        loginThread.start();
        //exitThread.start();
        mainElevatorThread.start();
        
    } // threadController()
    
    public synchronized void elevatorMove(Elevator elvtr, int index){
        
        int temp = FloorZeroCostumerHashMap.size();
        if(!FloorZeroCostumerHashMap.isEmpty()){ // Musteri tutan kuyrugumuz bos degilse.
            if(elvtr.isActive()){ // Asansor aktif ise
                elvtr.setMode(true);
                if(!(FloorZeroCostumerHashMap.size() < 10)){ // 10'dan az musteri yoksa, 10dan fazla ise.
                    for(int i = 0;i < 10;i++){
                        if(FloorZeroCostumerHashMap.get(i) != null){
                            elevatorCountVector.get(index).put(i, FloorZeroCostumerHashMap.get(i)); // i.indisine userHashMap in i.ci musterisinin gidecegi kati attik.
                            elvtr.setCount_inside(elvtr.getCount_inside() + 1);
                            FloorZeroCostumerHashMap.remove(i);
                        }
                    }
                }else{ // 10dan az ise tum musterileri bindiriyoruz.
                    for(int i = 0;i<temp;i++){
                        if(FloorZeroCostumerHashMap.get(i) != null){
                            elevatorCountVector.get(index).put(i, FloorZeroCostumerHashMap.get(i));
                            elvtr.setCount_inside(elvtr.getCount_inside() + 1);
                            FloorZeroCostumerHashMap.remove(i);
                        }
                    }
                }
            }
        }
    } // elevatorMove()
    
    public void editHashMap(){
        
        for(int i = 0 ; i< tempListCount;i++){
            if(FloorZeroCostumerHashMap.get(i) == null){ // Eger null ise bir sonraki elemani bu degere atiyoruz.
                for(int j = i;j<tempListCount -1;j++){
                    FloorZeroCostumerHashMap.put(j,FloorZeroCostumerHashMap.get(j+1));
                    FloorZeroCostumerHashMap.remove(j+1);
                }
            }
        }
    }
    // Asansor olusturma fonksiyonu
    public void createElevator(){
        
        mainElevator.setActive(true); // Asansor aktif bigisii gonderdik.
        mainElevator.setElevatorID(1);// Id degerini gonderdik.

        secondElevator.setActive(false); // Asansor aktif bigisii gonderdik.
        secondElevator.setElevatorID(2); // Id degerini gonderdik.
        
        thirdElevator.setActive(false); // Asansor aktif bigisii gonderdik.
        thirdElevator.setElevatorID(3); // Id degerini gonderdik.

        fourthElevator.setActive(false); // Asansor aktif bigisii gonderdik.
        fourthElevator.setElevatorID(4); // Id degerini gonderdik.

        fifthElevator.setActive(false); // Asansor aktif bigisii gonderdik.
        fifthElevator.setElevatorID(5); // Id degerini gonderdik.
        
        // Asansorleri asansor tipinde olusturdugumuz vektorde tuttuk, toplu ulasmamiz gerekirse kolaylik saglamasi icin.
        elevatorVector.add(mainElevator);
        elevatorVector.add(secondElevator);
        elevatorVector.add(thirdElevator);
        elevatorVector.add(fourthElevator);
        elevatorVector.add(fifthElevator);
        
        elevatorCountVector.add(FirstElevatorInsideHashMap);
        elevatorCountVector.add(SecondElevatorInsideHashMap);
        elevatorCountVector.add(ThirdElevatorInsideHashMap);
        elevatorCountVector.add(FourthElevatorInsideHashMap);
        elevatorCountVector.add(FifthElevatorInsideHashMap);
    } // createElevator()
    // Cikti ekrani
    public  void outputScreen(){
        
        System.out.println("0.floor: queue: " + FloorZeroCostumerHashMap.size());
        System.out.println("1.floor: queue: " + FloorOneCostumerHashMap.size());
        System.out.println("2.floor: queue: " + FloorTwoCostumerHashMap.size());
        System.out.println("3.floor: queue: " + FloorThreeCostumerHashMap.size());
        System.out.println("4.floor: queue: " + FloorFourCostumerHashMap.size());
        System.out.println("exit count: " + exitCount);
        for(int i = 0;i<elevatorVector.size();i++){
            System.out.println("active : " + elevatorVector.get(i).isActive());
            if(elevatorVector.get(i).getMode()){
                System.out.println("        mode: working");
            }else{
                System.out.println("        mode: idle");
            }
            System.out.println("        floor: " + elevatorVector.get(i).getCurrentFloor());
            System.out.println("        destination: " + elevatorVector.get(i).getDestination());
            System.out.println("        capacity: " + elevatorVector.get(i).getCapacity());
            System.out.println("        count_inside: " + elevatorVector.get(i).getCount_inside());
            switch(i){
                case 0:
                    if(!(FirstElevatorInsideHashMap.isEmpty())){
                        System.out.println("        inside: [" + FirstElevatorInsideHashMap + "]");
                    }else{
                        System.out.println("        inside: []");
                    }
                    break;
                case 1:
                    if(!(SecondElevatorInsideHashMap.isEmpty())){
                        System.out.println("        inside: [" + SecondElevatorInsideHashMap + "]");
                    }
                    else{
                        System.out.println("        inside: []");
                    }
                    break;
                case 2:
                    if(!(ThirdElevatorInsideHashMap.isEmpty())){
                        System.out.println("        inside: [" + ThirdElevatorInsideHashMap + "]");
                    }else{
                        System.out.println("        inside: []");
                    }
                    break;
                case 3:
                    if(!(FourthElevatorInsideHashMap.isEmpty())){
                        System.out.println("        inside: [" + FourthElevatorInsideHashMap + "]");
                    }else{
                        System.out.println("        inside: []");
                    }
                    break;
                case 4:
                    if(!(FifthElevatorInsideHashMap.isEmpty())){
                        System.out.println("        inside: [" + FifthElevatorInsideHashMap + "]");
                    }else{
                        System.out.println("        inside: []");
                    }
                    break;
            }
        }
    } // outputScreen()
}
