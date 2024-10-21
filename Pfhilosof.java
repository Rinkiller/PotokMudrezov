

import java.util.List;
import java.util.Random;

public class Pfhilosof extends Thread{
    private String name;
    private int number;
    private int count = 3;
    private List vilki;
    private boolean status; // True - думает , False - кушает
    public Pfhilosof(String name, int number, List vilki) {
        this.name = name;
        this.number = number;
        this.vilki = vilki;
    }
    public void pfilosofi(){
        System.out.println("Филосов № "+number+" "+name+" Думать изволит.........");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
    public void zjret(){
        System.out.println("Филосов № "+number+" "+name+" Кушает... Ест... Принимает писчу...Жретс");
        synchronized (vilki.get(number)) {
            int next = number - 1;
            if(number==0){next = vilki.size()-1;}
            synchronized (vilki.get(next)) {
                try {
                    Thread.sleep(2000);
                    count--;
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
       
    }
    @Override
    public void run() {
        status = new Random().nextBoolean();
        while (count > 0) { 
            if(status){
                pfilosofi();
                status = !status;
            }else{
                zjret();
                status = !status;
            }
        }
        System.out.println("Филосов №"+number+" "+ name +" Наелся и думать больше не изволит!!!!");
        super.run();
    }
    
}
