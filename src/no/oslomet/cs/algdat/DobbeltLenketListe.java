package no.oslomet.cs.algdat;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;



public class DobbeltLenketListe<T> implements Liste<T>
{
    private static final class Node<T>   // en indre nodeklasse
    {
        // instansvariabler
        private T verdi;
        private Node<T> forrige, neste;

        private Node(T verdi, Node<T> forrige, Node<T> neste)  // konstruktør
        {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        protected Node(T verdi)  // konstruktør
        {
            this(verdi, null, null);
        }

    } // Node

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;   // antall endringer i listen

    // hjelpemetode
    private Node<T> finnNode(int indeks)

    {
int i = 0;
Node<T> returnNode = null;


        if (indeks<antall/2){ // hvis indeksen er mindre enn antall/2, skal denne koden kjøres
returnNode = hode;

        for (i=0;i<indeks;i++){ // benytter en for loop, starter fra hode, og går videre derfra
            returnNode = returnNode.neste;
        }
    }

        if (indeks>=antall/2){
returnNode=hale;
            for(i=0;i>indeks;i--){ // starter på hale og går bakover
                returnNode = returnNode.forrige;
            }
        }
        return returnNode;
    }

    // konstruktør
    public DobbeltLenketListe()
    {
        hode = hale = null;
        antall = 0;
        endringer = 0;
    }

    // konstruktør
    public DobbeltLenketListe(T[] a)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    // subliste
    public Liste<T> subliste(int fra, int til) {

        //startet fra node x(finnnode)
        Node<T> x = finnNode(fra);

        fratilKontroll(antall, fra, til);

        DobbeltLenketListe<T> subliste = new DobbeltLenketListe<>();


        //bruker  en løkke til å legge til alle nodene mellom fra og til
        for (int i=fra;i<til;i++){


subliste = (DobbeltLenketListe<T>) x.verdi; // legger alt fra-til intervallet i sublisten
x = x.neste; // starter fra og slutter ved Til som er spesifisert i for loop

        }

        //retunerer sublisten
        return subliste;


    }
        private void fratilKontroll ( int antall, int fra, int til){
            if (fra < 0)                                  // fra er negativ
                throw new IndexOutOfBoundsException
                        ("fra(" + fra + ") er negativ!");

            if (til > antall)                          // til er utenfor tabellen
                throw new IndexOutOfBoundsException
                        ("til(" + til + ") > tablengde(" + antall + ")");

            if (fra > til)                                // fra er større enn til
                throw new IndexOutOfBoundsException
                        ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }

    @Override
    public int antall()
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public boolean tom()
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public boolean leggInn(T verdi)
    {
        //throw new UnsupportedOperationException("Ikke laget ennå!");
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public boolean inneholder(T verdi)
    {
        Node <T> x = hode;
boolean sjekk = false;





        if (hode != null || verdi !=null){
if (x.verdi.equals(verdi)){
    sjekk = true;
}
if (hode == null || verdi == null)
{
    return false;
}


        }
return sjekk;
    }

    @Override
    public T hent(int indeks)
    {
        indeksKontroll(indeks,false);
        Node<T> nodeRetur = finnNode(indeks);
        return nodeRetur.verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        int i = 0; // hjelpevariabel som sjekker indeks.
        Node<T> r = hode;
        boolean ikfinnes = true;


        if (verdi != null) {


            while (r != null) {

                if (r.verdi.equals(verdi)) {
                    ikfinnes = false;
                    break; // siden verdien ble funnet, så hopper man ut av loopen man er i
                }
                else {
                    // som følge av at man hoppet ut av loopen når man fant verdien gjør man et par justeringer
                    r = r.neste; // pek mot  neste
                    i++; // øk til index
                }
            }

        }



else {
    i=-1;
        }
        if (ikfinnes){
            i=-1;
        }
        return i; //enten blir indeksen retunert eller -1
    }

    @Override
    public T oppdater(int indeks, T nyverdi)
    {
        Node<T> x = null;

        indeksKontroll(indeks,false);

x = finnNode(indeks); // lagrer indeksen

  T tidligereVerdi =  x.verdi;

  if (nyverdi != null){
      x.verdi = nyverdi;
endringer++;
  }

return tidligereVerdi;
    }

    @Override
    public boolean fjern(T verdi)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public T fjern(int indeks)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public void nullstill()
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public String toString()
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    public String omvendtString()
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public Iterator<T> iterator()
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    public Iterator<T> iterator(int indeks)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator()
        {
            denne = hode;     // denne starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks)
        {
            throw new UnsupportedOperationException("Ikke laget ennå!");
        }

        @Override
        public boolean hasNext()
        {
            return denne != null;  // denne koden skal ikke endres!
        }

        @Override
        public T next()
        {
            throw new UnsupportedOperationException("Ikke laget ennå!");
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException("Ikke laget ennå!");
        }

    } // DobbeltLenketListeIterator

} // DobbeltLenketListe

