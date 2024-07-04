import java.util.List;

public class Arbol {
    public Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(int x) {
        this.raiz = insertarrec(raiz, x);
    }

    private Nodo insertarrec(Nodo nodo, int x) {
        if (nodo == null) {
            return new Nodo(x);
        }
        if (x < nodo.elem) {
            nodo.izq = insertarrec(nodo.izq, x);
        } else {
            nodo.der = insertarrec(nodo.der, x);
        }
        return nodo;
    }

    public void recinorden() {
        recinordenrec(raiz);
    }

    private void recinordenrec(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        recinordenrec(nodo.izq);
        System.out.print(nodo.elem + " ");
        recinordenrec(nodo.der);
    }

    //ejer1
    public boolean seencuentra(int x) {
        return seencuentrarec(raiz, x);
    }

    private boolean seencuentrarec(Nodo nodo, int x) {
        if (nodo == null) {
            return false;
        }
        if (x == nodo.elem) {
            return true;
        }
        if (x < nodo.elem) {
            return seencuentrarec(nodo.izq, x);
        } else {
            return seencuentrarec(nodo.der, x);
        }
    }

    //ejer2
    public int cantidad() {
        return cantidadrec(raiz);
    }

    private int cantidadrec(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return cantidadrec(nodo.izq) + cantidadrec(nodo.der) + 1;
    }

    //ejer3 cantidad de nodos temrinales
    public int cantterm() {
        return cantidadterm(raiz);
    }

    private int cantidadterm(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.izq == null && nodo.der == null) {
            return 1;
        }
        return cantidadterm(nodo.izq) + cantidadterm(nodo.der);
    }

    //ejer4 mostrar nodos temrinales
    public void mostrarterm() {
        mostrartermrec(raiz);
    }

    private void mostrartermrec(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        if (nodo.izq == null && nodo.der == null)
            System.out.print(nodo.elem + " ");
        mostrartermrec(nodo.der);
        mostrartermrec(nodo.izq);
    }

    //ejer5 sumar nodos terminakles
    public int sumaterm() {
        return sumatermrec(raiz);
    }

    private int sumatermrec(Nodo nodo) {
        int sum = 0;
        if (nodo == null) {
            return 0;
        }
        if (nodo.izq == null && nodo.der == null) {
            sum = sum + nodo.elem;
        }
        return sum = sum + sumatermrec(nodo.izq) + sumatermrec(nodo.der);
    }

    //eliminar
    public void eliminar(int x) {
        this.raiz = eliminarrec(raiz, x);
    }

    private Nodo eliminarrec(Nodo nodo, int x) {
        if (nodo == null) {
            return null;
        }
        if (x == nodo.elem) {
            return eliminarnodo(nodo);
        }
        if (x < nodo.elem) {
            nodo.izq = eliminarrec(nodo.izq, x);
        } else {
            nodo.der = eliminarrec(nodo.der, x);
        }
        return nodo;
    }

    private Nodo eliminarnodo(Nodo nodo){
        if (nodo.izq == null && nodo.der == null){
            return null;
        }
        if (nodo.izq != null && nodo.der == null){
            return nodo.izq;
        }
        if (nodo.izq == null && nodo.der != null){
            return nodo.der;
        }
        Nodo q = nodo.izq;
        while (q.der != null){
            q = q.der;
        }
        int y = q.elem;
        eliminar(y);
        nodo.elem = y;
        return nodo;
    }
    //eje1 eliminarhojas
    public void eliminarhojas(){
        this.raiz = eliminarhojasrec(raiz);
    }
    private Nodo eliminarhojasrec(Nodo nodo){
        if (nodo == null){
            return null;
        }
        if (nodo.izq == null && nodo.der == null){
            return null;
        }
        nodo.izq = eliminarhojasrec(nodo.izq);
        nodo.der = eliminarhojasrec(nodo.der);
        return nodo;
    }
    //ejer2 eliminarpare
    public void eliminarpares(){
        this.raiz = eliminarparesrec(raiz);
    }
    private Nodo eliminarparesrec(Nodo nodo){
        if (nodo == null){
            return null;
        }
        nodo.izq = eliminarparesrec(nodo.izq);
        nodo.der = eliminarparesrec(nodo.der);
        if (nodo.elem % 2 == 0){
            nodo = eliminarnodo(nodo);
        }
        return nodo;
    }
    //ejer3 eliminar lista
    public void eliminarlista(List<Integer> lista){
        for (int x: lista){
            eliminar(x);
        }
    }
    //ejer4 eliminar menor
    public void eliminarmenor(){
        this.raiz = eliminarmenorec(raiz);
    }
    private Nodo eliminarmenorec(Nodo nodo){
        if (nodo.izq == null){
            return nodo.der;
        }
        nodo.izq = eliminarmenorec(nodo.izq);
        return nodo;
    }
}
