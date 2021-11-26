package domain;

import usuario_interface.VentanaEjercicioUno;

public class MetodoOrdenamiento {

    /*Se crean crean los arreglos que se utilizaran para ambos ejercicios*/
    private int[] arregloNumeros;
    private Persona[] personas;
    private int tamanio;

    public MetodoOrdenamiento() {

        //..
    }

    public Persona getPersonas(int pos) {
        return this.personas[pos];
    }

    public void setPersonas(int pos, Persona dato) {
        this.personas[pos] = dato;
    }

    public int getArregloNumeros(int pos) {
        return this.arregloNumeros[pos];
    }

    public void setArregloNumeros(int pos, int dato) {
        this.arregloNumeros[pos] = dato;
    }

    public int getTamanio() {
        return this.tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    /*
     * Metodo utilizado para asignar el tamaño de los arreglos en tiempo de ejecucion
     */
    public void crearVector() {
        this.personas = new Persona[this.tamanio];
        this.arregloNumeros = new int[this.tamanio];
    }

    /*
     * Metodo para llenar el arreglo de numeros
     */
    public void llenar(int contador, int dato) {
        setArregloNumeros(contador, dato);
    }

    /* 
    * Metodo para llenar el arreglo de personas 
     */
    public void llenar(int contador, Persona persona) {
        setPersonas(contador, persona);
    }

    /*
    * Metodo para mostrar el arreglo de numeros 
     */
    public String mostrarArregloNumeros() {
        String dato = "\n ** MOSTRANDO ARREGLO **  \n";
        int largo = arregloNumeros.length;
        for (int i = 0; i < largo; i++) {
            dato += "Numero en posicion " + "[" + i + "] : " + getArregloNumeros(i) + "\n";
        }
        return dato;
    }

    /*
    * Metodo para mostrar el arreglo de Personas
     */
    public String mostrarArregloPersonas() {
        String dato = "\n ** MOSTRANDO ARREGLO **  \n";
        int largo = arregloNumeros.length;
        for (int i = 0; i < largo; i++) {
            dato += getPersonas(i);
        }
        return dato;

    }

    /* 
     * Metodo utilizado para cambiar los valores de la posciones 
     * para el ejercicio utilizando el metodo de ordenamiento seleccion
     */
    public void cambiar(int p1, int p2) {
        int temp;
        temp = getArregloNumeros(p1);
        setArregloNumeros(p1, getArregloNumeros(p2));
        setArregloNumeros(p2, temp);
    }

    /*
     * Metodo que ordena y concatena la informacion de las comparaciones e intercambios de posciones 
     * que se hacen durante el ordenamiento usando el metodo de seleccion
     * se establecio el metodo como String para poder mostrar la informacion
     * desde los jTextArea
     */
    public String ordenarSeleccion() {
        String dato = "\n ** ORDENANDO ARREGLO ** \n";
        int largo = arregloNumeros.length;
        int j;
        int posMenor;
        int menorElemento;
        for (int i = 0; i < largo; i++) {
            posMenor = i;
            menorElemento = getArregloNumeros(i);
            for (j = i + 1; j < largo; j++) {
                /**
                 * Se concatenan las comparaciones entre el elemento menor con
                 * el elemento siguiente *
                 */
                dato += "Comparando el numero [" + menorElemento + "] con [" + getArregloNumeros(j) + "] \n";
                /*
                * El algoritmo actual ordena de menor a mayor si quisiera que ordenara de forma contaria cambien < por >
                 */
                if (getArregloNumeros(j) < menorElemento) {
                    /* 
                     * Si la condicion es verdadera entonces se establece como nuevo elemento menor el de una poscion superior
                     * por tal motivo se contatenan dentro del if la informacion referente a 
                     * la poscion actual con su respectivo dato con el nuevo valor menor y su posicion 
                     */
                    dato += "Se cambia la posicion [" + posMenor + "] con el valor de : " + getArregloNumeros(posMenor)
                            + " con la posicion [" + j + "] con el valor de : " + getArregloNumeros(j) + "\n";
                    menorElemento = getArregloNumeros(j);
                    posMenor = j;
                } else {
                    /*
                     * Si no entra al if es por que no se realizo cambios en las posiciones
                     * por tal motivo se concatena el mesaje avisando que no se realizo cambio en las posiciones
                     */
                    dato += " No se cambia posciones \n";
                }
            }
            cambiar(i, posMenor);
        }
        return dato;
    }

    /*
     * Metodo burbuja para ordenamiento del arreglo de personas para el ejercicio 2 del quiz
     */
    public String sortBurbuja() {
        String dato = "\n ** ORDENANDO ARREGLO ** \n";
        int total = this.personas.length;
        /*
         * El metodo funciona como una matriz bidimensional, el primer for se posiciona sobre el primer elemento de la primerla fila y columnda
         * el segundo for compara el elemnto actual con el elemento superior osea el elemnto + 1
         * y va poscionando ese elemnto en la parte final del arreglo
         * el segundo for al iterar se le va restando la iteracion del primer for dado que los elementos de mitad del arreglo hacia atras se va ordenando
         * es por ello que el metodo solo itera hasta la mitada del arreglo 
         */
        for (int i = 0; i < total - 1; i++) {
            for (int j = 0; j < total - 1 - i; j++) {
                /*
                 * Ordena de manera decendente si quieras comparlo de manera acendente solo cambia el < por > 
                 * el metodo compareTo() devuelve siempre un numero de tipo int
                 * si es < que 0 es por que el objeto a comprar es menor
                 * si es > que 0 es por que el onjeto a comprar es mayor
                 * si es = que 0 es por que los objetos son iguales
                 */
                dato += "Comparando a la persona [" + getPersonas(j + 1).getNombre() + "] con [" + getPersonas(j).getNombre() + "] \n";
                /*
                 * El algoritmo actual ordena de mayor a menor si quiren que sea al contrario cambien > por <
                 * Si quisieran orden con otro parametro ya sea la direccion, id o la edad
                 * tiene que cambiar donde dice .getNombre() por .getEdad(), .getDireccion() o .getId()
                 */
                if (((Comparable) getPersonas(j + 1).getNombre()).compareTo(getPersonas(j).getNombre()) > 0) {
                    /* 
                     * Si la condicion es verdadera entonces se establece como nuevo elemento menor el de una poscion superior
                     * por tal motivo se concatenan dentro del if la informacion referente a 
                     * la poscion actual con su respectivo dato con el nuevo valor menor y su posicion 
                     */
                    dato += "Se cambia la posicion [" + j + "] con el valor de : " + getPersonas(j).getNombre()
                            + " con la posicion [" + (j + 1) + "] con el valor de : " + getPersonas(j + 1).getNombre() + "\n";
                    Persona aux = getPersonas(j);
                    setPersonas(j, getPersonas(j + 1));
                    setPersonas(j + 1, aux);
                } else {
                    /*
                     * Si no entra al if es por que no se realizo cambios en las posiciones
                     * por tal motivo se concatena el mesaje avisando que no se realizo cambio en las posiciones
                     */
                    dato += " No se cambia posciones \n";
                }
            }
        }
        return dato;
    }

}
