public class MainListaDoble {
    public static void main(String[] args) {
        ListaDoblementeLigada<Integer> lista = new ListaDoblementeLigada<>();

        // Insertar elementos
        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        System.out.println("Lista después de insertar 10, 20, 30:");
        System.out.println(lista); // [10,20,30]

        // Insertar en una posición específica
        lista.insertar(15);
        System.out.println("\nDespués de insertar 15 al inicio de la lista:");
        System.out.println(lista); // [10,15,20,30]

        //Devolver el índice del elemento 20
        System.out.println("\nEl índice del elemento 20 es: " + lista.devolverIndiceElemento(20));

        // Acceder a un elemento
        System.out.println("\nElemento en la posición 2:");
        System.out.println(lista.acceder(2)); // 20

        // Buscar un elemento
        System.out.println("\n¿La lista contiene 15?");
        System.out.println(lista.buscar(15)); // true

        System.out.println("¿La lista contiene 100?");
        System.out.println(lista.buscar(100)); // false

        // Eliminar un elemento
        lista.eliminar(2); // elimina 20
        System.out.println("\nDespués de eliminar el elemento en la posición 2:");
        System.out.println(lista); // [10,15,30]

        // Reversa
        ListaDoblementeLigada<Integer> reversa = lista.reversa();
        System.out.println("\nLista reversa:");
        System.out.println(reversa); // [30,15,10]

        //Eliminar T elemento
        Integer x = 30;
        reversa.eliminar(x);
        System.out.println("\nDespués de eliminar el elemento 30: ");
        System.out.println(reversa);
    }
}
