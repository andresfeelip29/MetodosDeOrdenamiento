package test;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import usuario_interface.VentanaEjercicioDos;
import usuario_interface.VentanaEjercicioUno;

public class TestOrdenamientos {

    public static int menu() {
        /*
         * Variable para almacenar la opcion del indice del mapa
         */
        int opcionIndice = 0;

        /* 
         * Para guardar las dos opciones que almacenas la soluciones a los dos puntos del quiz
         * se utiliza un mapa  que es como un arreglo asociativo entre dos tipos de datos
         * los cual asocia un indice a un valor
         */
        Map<String, Integer> opciones = new HashMap();
        opciones.put("Solucion Ejercicio 1 (Metodo de ordenamiento por seleccion)", 1);
        opciones.put("Solucion Ejercicio 2 (Ordenar de mayor a menor)", 2);
        opciones.put("Exit", 3);

        /**
         * El metodos key.Set() nos devuelve las llaves del mapa declarado
         * anteriormente Es decir el dato referente a la cadena String El metodo
         * toArray() covierte esas cadenas en una arreglo El cual se guarda en un
         * arreglo de tipo object que es la clase padre de todas las clases en
         * java
         */
        Object[] opArreglo = opciones.keySet().toArray();

        /*
         * En una variable de tipo Object se almacenara el mensaje en pantalla de la opciones
         * establecidad en el mapa de opciones
         */
        Object opcion = JOptionPane.showInputDialog(null,
                "Seleccione un Opción",
                "Metodos de ordenamiento",
                JOptionPane.INFORMATION_MESSAGE, null, opArreglo, opArreglo[0]);

        /*
         * Se realiza una validaciones para que el usuario escoga una opcion valida
         * o este obligado a escoger la opcion "Exit"
         * En caso que quiera terminar la ejecucion del programa
        */
        if (opcion == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una operación");
        } else {
            opcionIndice = opciones.get(opcion.toString());
        }
        return opcionIndice;
    }

    public static void main(String[] args) {
        /**
         * Se instancian ambas ventanas 
         */
        VentanaEjercicioUno ven1 = new VentanaEjercicioUno();
        VentanaEjercicioDos ven2 = new VentanaEjercicioDos();
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    ven1.setVisible(true);
                    break;
                case 2:
                    ven2.setVisible(true);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Haz salido con exito!");
                    System.exit(0);
                    break;
                default:
                    break;
            }

        } while (opcion < 1 || opcion > 3);

    }

}
