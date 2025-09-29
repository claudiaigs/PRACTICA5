import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDoblementeLigada<T> implements Lista<T> {

     private class Nodo{
          public T elemento;

          public Nodo siguiente;

          public Nodo anterior;

          public Nodo(T e) {
               this.elemento = e;
          }
     }

     private class IteradorDoubleLinkedList implements Iterator<T> {

          public Nodo anterior;

          public Nodo siguiente;

          public IteradorDoubleLinkedList() {
               siguiente = cabeza;
          }

          @Override

          public boolean hasNext() {
               return siguiente != null;
          }

          @Override
          public T next() {
               if (siguiente == null) {
                    throw new NoSuchElementException("El elemento es null");
               }
               anterior = siguiente;
               siguiente = siguiente.siguiente;
               return anterior.elemento;
          }
     }

     private Nodo cabeza;

     private Nodo rabo;

     private int longitud;

     public Iterator<T> iterator() {
          return new IteradorDoubleLinkedList();
     }

     public ListaDoblementeLigada(){
          this.cabeza = null;
          this.rabo = null;
          this.longitud = 0;
     }

     @Override
     public void insertar(T elemento) throws IllegalArgumentException {
          if (elemento == null) throw new IllegalArgumentException("Elemento nulo");
          Nodo nuevo = new Nodo(elemento);

          if (cabeza == null) { // lista vacía
               cabeza = nuevo;
               rabo = nuevo;
          } else {
               cabeza.anterior = nuevo;
               nuevo.siguiente = cabeza;
               cabeza = nuevo;
          }
          longitud++;

     }

     public void eliminar(T elemento){
          if (elemento == null) return;
          Nodo actual = cabeza;

          for (T e : this) {
               if (e.equals(elemento)) {
                    if (actual == cabeza && actual == rabo) {
                         cabeza = rabo = null;
                    } else if (actual == cabeza) {
                         cabeza = cabeza.siguiente;
                         cabeza.anterior = null;
                    } else if (actual == rabo) {
                         rabo = rabo.anterior;
                         rabo.siguiente = null;
                    } else {
                         actual.anterior.siguiente = actual.siguiente;
                         actual.siguiente.anterior = actual.anterior;
                    }
                    longitud--;
                    return;
               }
               actual = actual.siguiente;
          }

     }

     @Override
     public boolean buscar(T elemento) {
          for (T e : this) {
          if (e.equals(elemento)) return true;
          }
          return false;

     }

     @Override
     public void eliminar(int i) {
          if (i < 0 || i >= longitud) throw new IndexOutOfBoundsException();
          Nodo actual = accederNodo(i);
          if (actual == cabeza && actual == rabo) {
               cabeza = rabo = null;
          } else if (actual == cabeza) {
               cabeza = cabeza.siguiente;
               cabeza.anterior = null;
          } else if (actual == rabo) {
               rabo = rabo.anterior;
               rabo.siguiente = null;
          } else {
               actual.anterior.siguiente = actual.siguiente;
               actual.siguiente.anterior = actual.anterior;
          }
          longitud--;

     }

     @Override
     public T acceder(int i) throws IllegalArgumentException {
          if (i < 0 || i >= longitud) {
               throw new IllegalArgumentException("Índice fuera de rango");
          }
          Nodo actual = cabeza;
          int contador = 0;
          while (contador < i) {
               actual = actual.siguiente;
               contador++;
          }
          return actual.elemento;
     }

     public int devolverIndiceElemento(T elemento) throws IllegalArgumentException{
          if (!buscar(elemento)) throw new IllegalArgumentException("Elemento no encontrado");
          int indice = 0;
          for (T e : this) {
               if (e.equals(elemento)) return indice;
               indice++;
          }
          return -1;

     }

     public int darLongitud(){
          return longitud;
     }

     public void insertarFinal(T elemento) throws IllegalArgumentException {
          if (elemento == null) throw new IllegalArgumentException("Elemento nulo");
          Nodo nuevo = new Nodo(elemento);
          if (rabo == null) { // lista vacía
               cabeza = nuevo;
               rabo = nuevo;
          } else {
               rabo.siguiente = nuevo;
               nuevo.anterior = rabo;
               rabo = nuevo;
          }
          longitud++;
     }

     public ListaDoblementeLigada<T> reversa(){
          ListaDoblementeLigada<T> reversa = new ListaDoblementeLigada<>();
          Nodo actual = rabo;
          while (actual != null) {
               reversa.insertarFinal(actual.elemento);
               actual = actual.anterior;
          }
          return reversa;
     }

     
     private Nodo accederNodo(int i) {
          if (i < 0 || i >= longitud) throw new IndexOutOfBoundsException();
          Nodo actual;
          int contador;
          if (i < longitud / 2) {
               actual = cabeza;
               contador = 0;
               while (contador < i) {
                    actual = actual.siguiente;
                    contador++;
               }
          } else {
               actual = rabo;
               contador = longitud - 1;
               while (contador > i) {
                    actual = actual.anterior;
                    contador--;
               }
          }
          return actual;
     }

     public String toString(){
          String s = "[";
          int cont = 0;
          for(T elem : this){
               if(cont == 0){
                    s = s + elem.toString();
                    cont++;
               }else{
                    s = s + "," +elem.toString();
               }
          }
          s = s + "]";
          return s;
     }
}