import java.util.ArrayList;
import java.util.List;

public class ListaArbol {
    Arbol arbol;
    ArrayList<Arbol> lista;

    public ListaArbol(int cantidad) {
        lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            lista.add(new Arbol());
        }
    }

    public void insertardato(int pos, int x){
        lista.get(pos).insertar(x);
    }
    public void recinorden(int pos){
        lista.get(pos).recinorden();
    }

    public static void main(String[] args) {
        ListaArbol listaArbol = new ListaArbol(3);
        listaArbol.insertardato(0,100);
        listaArbol.insertardato(0,80);
        listaArbol.insertardato(0,90);
        listaArbol.recinorden(0);
    }
}
