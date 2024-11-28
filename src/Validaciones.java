import java.util.ArrayList;

public class Validaciones {


    public boolean validar( ArrayList<Integer> baseDatos,String dato){
        int valido = Integer.valueOf(dato);
        if(baseDatos.contains(valido)){
            return true;
        }else{
            return false;
        }
    }
}
