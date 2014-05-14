/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

/**
*
* @author Mateusz
*/
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Main {
    public static void main(String[]args) throws FileNotFoundException{
        int pomocniczaIloscZczytan;
        int pomocniczaWielkDysk;
        Scanner sc = new Scanner(new FileReader("Test.txt"));
        
        while(sc.hasNextInt()){
            try{
                pomocniczaWielkDysk = sc.nextInt();
                Sheluder shlud = new Sheluder(pomocniczaWielkDysk);
                ProcesListGenerator plg = new ProcesListGenerator();
                LinkedList<Proces> procesy = new LinkedList<>();
                switch(sc.nextInt()){
                    case 0:
                        pomocniczaIloscZczytan = sc.nextInt();
                        procesy = plg.randGenerate(pomocniczaIloscZczytan, pomocniczaWielkDysk);
                        while(shlud.sendToProcesor() || procesy.size() > 0);

                        shlud.printTimes(pomocniczaIloscZczytan);
                        break;
                    case 1:
                        pomocniczaIloscZczytan = sc.nextInt();
                        procesy = plg.immediateGenerate(pomocniczaIloscZczytan, pomocniczaWielkDysk);
                        while(shlud.sendToProcesor() || procesy.size() > 0);

                        shlud.printTimes(pomocniczaIloscZczytan);
                        break;
                    case 2:
                        pomocniczaIloscZczytan = sc.nextInt();
                        System.out.print("jest tu");
                        procesy = plg.inOrderGenerate(pomocniczaIloscZczytan, pomocniczaWielkDysk);
                        System.out.print("przeszedł tędy");
                        while(shlud.sendToProcesor() || procesy.size() > 0)
                             System.out.print("czyżby się zaciął");

                        shlud.printTimes(pomocniczaIloscZczytan);
                        break;
                    case 3:
                        pomocniczaIloscZczytan = sc.nextInt();
                        procesy = plg.revOrderGenerate(pomocniczaIloscZczytan, pomocniczaWielkDysk);
                        while(shlud.sendToProcesor() || procesy.size() > 0);

                        shlud.printTimes(pomocniczaIloscZczytan);
                        break;
                } 
            }catch (NoSuchElementException e){
                System.out.println(" \nNieprawidłowa skłądnia piliku : Plik powinien byc postaci :\n"
                       + "Długość_cyklu_procesora  Sposób_generowania_procesów  Ilość_procesów");
            }
        }
    }
}