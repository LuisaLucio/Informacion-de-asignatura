package informaciónasignaturas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author LuisaLucio
 */
public class InformaciónAsignaturas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Integer, Asignatura> mapaAsignaturas = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {

            System.out.println("MENU");
            System.out.println("1. Registrar Asignaturas ");
            System.out.println("2. Buscar Asignaturas ");
            System.out.println("3. Mostrar Códigos Asignaturas ");
            System.out.println("4. Mostrar Asignaturas");
            System.out.println("5. Actualizar Asignatura ");
            System.out.println("6. Eliminar Asignatura ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion) {
                case 1: 
                    registrarAsignaturas(mapaAsignaturas, sc);
                break;
                case 2: 
                    buscarCodigo(mapaAsignaturas, sc);
                break;
                case 3:
                    mostrarCodigos(mapaAsignaturas);
                break;
                case 4:
                    mostrarAsignaturas(mapaAsignaturas);
                break;
                case 5:
                    actualizarAsignatura(mapaAsignaturas, sc);
                break;
                case 6:
                    eliminarAsignatura(mapaAsignaturas, sc);
                break;
                default:
                    break;
            }
        } while(opcion!=10);
        sc.close();
    }
    public static void registrarAsignaturas(Map<Integer,Asignatura> mapaAsignaturas, Scanner sc){       
        Asignatura asignatura = new Asignatura();        
        System.out.println("Ingrese el nombre de la asignatura:");
        String nombre = sc.nextLine();
        asignatura.setNombre(nombre);
        System.out.println("Ingrese el número de créditos de la asignatura:");
        Integer creditos = sc.nextInt();
        asignatura.setCreditos(creditos);
        System.out.println("Ingrese el semestre de la asignatura:");
        Integer semestre = sc.nextInt();
        asignatura.setSemestre(semestre);
        sc.nextLine();
        System.out.println("Ingrese el programa académico de la asignatura:");
        asignatura.setPrograma(sc.nextLine());
        int nuevoCodigo = mapaAsignaturas.size() + 1;
        mapaAsignaturas.put(nuevoCodigo, asignatura);        
    }
    public static void buscarCodigo(Map<Integer,Asignatura> mapaAsignaturas, Scanner sc){
        
        System.out.println("Ingrese el código de la asignatura a buscar:");
        int codigo = sc.nextInt();
        if (mapaAsignaturas.containsKey(codigo)) {
            Asignatura asignatura = (Asignatura) mapaAsignaturas.get(codigo);
            System.out.println(asignatura.toString());
        } else {
            System.out.println("No se encontró una asignatura con el código " + codigo + ".");
        }        
    }
    public static void mostrarCodigos(Map<Integer,Asignatura> mapaAsignaturas){
        Set<Integer> claves = mapaAsignaturas.keySet();

        // Iterar sobre el conjunto de claves y mostrar cada clave
        System.out.println("Índices de la colección asignaturas:");
        for (Integer clave : claves) {
            System.out.println(clave);
        }
    }
    public static void mostrarAsignaturas(Map<Integer,Asignatura> mapaAsignaturas) {
        Set<Integer> claves = mapaAsignaturas.keySet();
        
        // Iterar sobre el conjunto de claves y mostrar cada asignatura
        System.out.println("Detalles de las asignaturas:");
        for (Integer clave : claves) {
            Asignatura asignatura = mapaAsignaturas.get(clave);
            System.out.println(asignatura.toString());
        }
    }
    public static void eliminarAsignatura(Map<Integer,Asignatura> mapaAsignaturas, Scanner sc) {        
        System.out.print("Ingrese el código de la asignatura que desea eliminar: ");
        int codigo = sc.nextInt();    
        if (mapaAsignaturas.containsKey(codigo)) {
            mapaAsignaturas.remove(codigo);
            System.out.println("Asignatura con código " + codigo + " eliminada.");
        } else {
            System.out.println("No se encontró una asignatura con el código " + codigo + ".");
        }        
    }
    public static void actualizarAsignatura(Map<Integer,Asignatura> mapaAsignaturas, Scanner sc) {        
        
        System.out.print("Ingrese el código de la asignatura que desea actualizar: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        if (mapaAsignaturas.containsKey(codigo)) {
            Asignatura materia = mapaAsignaturas.get(codigo);            

            System.out.print("Nombre Asignatura (" + materia.getNombre() + "): ");
            String nuevoNombre = sc.nextLine();
            if (!nuevoNombre.isEmpty()) {
                materia.setNombre(nuevoNombre);
            }
            
            System.out.print("Número de Créditos (" + materia.getCreditos() + "): ");
            Creditos nuevoCreditos = sc.nextInt();
            sc.nextLine();
            if (!nuevoCreditos.isEmpty()) {
                materia.setCreditos(Integer.parseInt(nuevoCreditos));
            }
            

            System.out.print("Número de Semestre (" + materia.getSemestre() + "): ");
            String nuevoSemestre = sc.nextLine();
            if (!nuevoSemestre.isEmpty()) {
                materia.setSemestre(Integer.parseInt(nuevoSemestre));
            }

            System.out.print("Programa (" + materia.getPrograma() + "): ");
            String nuevoPrograma = sc.nextLine();
            if (!nuevoPrograma.isEmpty()) {
                materia.setPrograma(nuevoPrograma);
            }            
             
            System.out.println("Datos de la asignatura con código " + codigo + " actualizados.");
        } else {
            System.out.println("No se encontró una asignatura con el código " + codigo + ".");
        }      
    }

    
}
