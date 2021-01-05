package EstructurasNoLineales;

public class Arbol {
    NodoArbol incial;
    public Arbol(){
        this.incial=null;
    }
    public void insertar(int valor){
        if(this.incial==null){
            this.incial=new NodoArbol(valor);
        }else{
            this.incial.insertar(valor);
        }
    }
    public void dispararPreorden(){
        this.preorden(this.incial);
    }
    public void preorden(NodoArbol nodo){
        if(nodo==null){
            return;//detener recursividad caso base
        }else{
            System.out.print(nodo.getValor()+", ");
            preorden(nodo.getNodoIzq());
            preorden(nodo.getNodoDerecho());
        }
    }
    public void dispararInorden(){
        this.inorden(this.incial);
    }
    public void inorden(NodoArbol nodo){
        if(nodo==null){
            return;//detener recursividad de caso base
        }else{
            inorden(nodo.getNodoIzq());
            System.out.print(nodo.getValor()+", ");
            inorden(nodo.getNodoDerecho());
        }
    }
    public void dispararPostorden(){
        this.postorden(this.incial);
    }
    public void postorden(NodoArbol nodo){
        if(nodo==null){
            return;//detener recursividad de caso base
        }else{
            postorden(nodo.getNodoIzq());
            postorden(nodo.getNodoDerecho());
            System.out.print(nodo.getValor()+", ");
        }
    }
}
