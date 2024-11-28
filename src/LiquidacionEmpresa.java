import java.util.ArrayList;
import java.util.Scanner;

public class LiquidacionEmpresa {
    static ArrayList<NivelAcademico> nivelesAcademicos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        ArrayList<NivelAcademico> nivelesAcademicos = new ArrayList<NivelAcademico>();
        NivelAcademico na = new NivelAcademico(10, "Secundario Completo", 10);
        nivelesAcademicos.add(na);
        na = new NivelAcademico(20, "Universitario Completo", 30);
        nivelesAcademicos.add(na);
        na = new NivelAcademico(30, "Maestría Completo", 40);
        nivelesAcademicos.add(na);
        na = new NivelAcademico(40, "Doctorando Completo", 50);
        nivelesAcademicos.add(na);
        ArrayList<Integer> baseDatos = new ArrayList<>();
        Empresa emp = new Empresa();
        do{
            System.out.println("Ingrese el cuit de la empresa:");
            emp.setCuit(sc.nextLine());
        }while (emp.getCuit().length() != 11);
        do{
            System.out.println("Ingrese la razon social:");
            emp.setRazonSocial(sc.nextLine());
        }while(emp.getRazonSocial().isBlank());

        while (true){
            Empleado empleado = new Empleado();
            do{
                System.out.println("Ingrese el nombre completo del empleado:");
                empleado.setNombreCompleto(sc.nextLine());
            }while (empleado.getNombreCompleto().isBlank());

            String legajo;
            Validaciones v = new Validaciones();
            boolean check = true;
            do {
                System.out.println("Ingrese el legajo del empleado:");
                legajo = sc.nextLine();
                if(legajo.isBlank()){
                    System.out.println("El legajo no puede estar vacio");
                }else{
                    check = (v.validar(baseDatos,legajo));
                    if(check){
                        System.out.println("El legajo ingresado ya fue cargado anteriormente");
                    }else {
                        baseDatos.add(Integer.parseInt(legajo));
                    }
                }
            }while (legajo.isBlank()|| check);
            empleado.setLegajo(Integer.valueOf(legajo));
            do {
                System.out.println("Ingrese el salario mayor a 0:");
                empleado.setSalario(sc.nextDouble());
                sc.nextLine();
            }while (empleado.getSalario()<0);
            while (true){
                NivelAcademico nivel = new NivelAcademico();
                System.out.println("Ingrese el codigo del nivel academico:");
                int nivelCod = sc.nextInt();
                sc.nextLine();
                int contador = 0;
                for(NivelAcademico n : nivelesAcademicos){
                    if(n.getCodigo()==nivelCod){
                        nivel.setCodigo(n.getCodigo());
                        nivel.setNivel(n.getNivel());
                        nivel.setPorcentajeAumento(n.getPorcentajeAumento());
                        contador++;
                    }
                }
                if (contador == 0){
                    System.out.println("El código ingresado no existe, intente nuevamente");
                }else {
                    empleado.setNivelAcademico(nivel);
                    break;
                }
            }
            emp.cargaEmpleado(empleado);
            System.out.println("Desea cargar otro empleado?");
            String opcion = sc.nextLine();
            if (opcion.equalsIgnoreCase("NO")){
                break;
            }
        }
        System.out.println("Empresa: "+emp.getRazonSocial());
        System.out.println("CUIT: " +emp.getCuit());
        System.out.println("----------EMPLEADOS----------");
        for(Empleado empleado:emp.getEmpleados()){
            System.out.println("Nombre Completo: "+empleado.getNombreCompleto());
            System.out.println("Salario: "+empleado.salarioTotalCalculado());
            System.out.println("Nivel educativo: "+empleado.getNivelAcademico().getNivel());
        }
        System.out.println("Resumen:");
        System.out.println("El promedio de los salarios de la empresa es: $ "+emp.promedioTotal());
        System.out.println("El empleado con el mejor salario es: ");
        emp.mejorSalario();


























    }


}

