public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(40);
        arbol.insertar(15);
        arbol.insertar(35);
        arbol.insertar(60);
        arbol.recinorden();
    }
}