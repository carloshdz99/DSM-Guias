package sv.udb.edu.complementario;

import androidx.lifecycle.ViewModel;

public class SumaViewModel extends ViewModel {
    private Integer contador;

    //metodo para obtener el valor de la suma
    public Integer getSuma(){
        if(contador==null){
            contador=0;
        }
        return contador;
    }
    //sumando al contador
    public void addSuma(){
        if (contador==null || contador==9){
            contador=0;
        }else {
            contador++;
        }
    }
}
