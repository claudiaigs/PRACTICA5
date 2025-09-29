/**
 * Interfaz Lista
 *
 * Interfaz que define los métodos que debe implementar una colección
 * genérica.
 */
public interface Lista<T> extends Coleccion<T>{

    /**
     * Método que elimina un elemento de la lista.
     * @param indice
     */
    public void eliminar(int indice);

    /**
     * Método que accede a un elemento de la lista.
     * @param indice
     * @return T elemento de la lista.
     */
    public T acceder(int indice);

    /**
     * Método que devuelve el índice de la primera aparición del elemento.
     * @param elemento
     * @return indice.
     */
    public int devolverIndiceElemento(T elemento);

    /**
     * Método que devuelve el número de elementos de la lista.
     * @return longitud.
     */
    public int darLongitud();

}