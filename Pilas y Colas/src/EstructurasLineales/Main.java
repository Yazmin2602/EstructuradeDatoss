package EstructurasLineales;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ListaEnlazada listaEnlazada=new ListaEnlazada();
        listaEnlazada.insertar(new Cancion ("navidad","./navidad.mp3",65));
        listaEnlazada.insertar(new Cancion ("navidad1","./navidad.mp3",65));
        listaEnlazada.insertar(new Cancion ("navidad2","./navidad.mp3",65));
        listaEnlazada.mostrarElementos();
        LinkedList<Cancion>listaJava=new LinkedList<>();
        listaJava.add(new Cancion("jasbxhjbcx","nesdffjnkf",65));
        listaJava.add(new Cancion("jasbxhjbcy","nesdffjnkf",65));
        listaJava.add(new Cancion("jasbxhjbcxyy","nesdffjnkf",65));
        for (int x=0;x<listaJava.size();x++){
            Cancion c=listaJava.get(2);
            System.out.println(c.getNombre());
        }
        /*Stack<Usuario> pila = new Stack<>();
        Stack<Integer> pila2 = new Stack<>();
        Queue<Usuario> cola = new LinkedList<>();
        pila.add(new Usuario("Yo", "calle tal", "123456"));
        pila.add(new Usuario("tu", "calle tal", "123456"));
        pila.add(new Usuario("el", "calle tal", "123456"));
        Usuario cachar = pila.pop();
        System.out.println(cachar.getNombre());
        cachar = pila.pop();
        System.out.println(cachar.getNombre());
        if (pila.isEmpty()) System.out.println("Esta vacia");
        pila2.add(1);
        pila2.add(2);
        pila2.add(3);
        cola.add(new Usuario("Yo", "asdfas", "123456"));
        cola.add(new Usuario("tu", "asdfas", "123456"));
        cola.add(new Usuario("el", "asdfas", "123456"));
        Usuario usr = cola.poll();
        System.out.println(usr.getNombre());
        cola.clear();//limpiando la cola pila
        pila.clear();
        Usuario cachar2 = cola.peek();
        System.out.println(cachar2.getNombre());

         */
    }
}
