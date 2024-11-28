import java.util.ArrayList;

public class Empresa {

    private String cuit;
    private String razonSocial;
    private ArrayList<Empleado> empleados;


    public void mejorSalario(){
        double mejor = 0;
        for(Empleado empleado : empleados){
            if(empleado.salarioTotalCalculado() > mejor){
                mejor = empleado.salarioTotalCalculado()

                ;
            }
        }
        for(Empleado empleado : empleados){
            if(empleado.salarioTotalCalculado() == mejor){
                System.out.println("Nombre Completo: " + empleado.getNombreCompleto());
                System.out.println("Salario Completo: " + empleado.salarioTotalCalculado());
                System.out.println("Nivel Educativo: "+ empleado.getNivelAcademico().getNivel()+(" (Porcentaje de aumento "+empleado.getNivelAcademico().getPorcentajeAumento()+"%)"));
            }
        }
    }

    public double promedioTotal(){
        int contador = 0;
        double total=0;
        for(Empleado e : empleados){
            total+=e.salarioTotalCalculado();
            contador++;
        }
        double promedio = total/contador;
        return promedio;
    }

    public void cargaEmpleado(Empleado empleado) {
        if(empleados==null){
            empleados=new ArrayList<>();
        }
        empleados.add(empleado);
    }


    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
}
