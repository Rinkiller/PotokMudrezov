import java.util.ArrayList;
import java.util.List;
//  За круглым столом сидят 5 философов
//  У каждого есть вилка и тарелка с едой
//  Филосов может сука кушать и думать (но не одновременно, очень тупы...умственно одаренные пацаны)
// чтобы есть надо держать в руках 2 вилки(свою и еще одну) 
// Филосов не может есть 2 раза подряд но чтобы наж....сытиться надо поесть 3 раза потом Шотдавн философа
// Main шотдавн когда все наелись
public class Main {
    private static String[] names = {"Алексий","Петр","Моисей","Иосиф","И тот пятый"};
    private  static List VilkiNaStole = new ArrayList<Vilka>();
    public static void main(String[] args) {
        List<Pfhilosof> philosLst = new ArrayList<Pfhilosof>();
        for (int i = 0; i < names.length; i++) {
            VilkiNaStole.add(new Vilka(i));
        }
        for (int i = 0; i < names.length; i++) {
            philosLst.add(new Pfhilosof(names[i], i,VilkiNaStole));
        }
        for (int i = 0; i < names.length; i++) {
            philosLst.get(i).start();
        }
    }
}
