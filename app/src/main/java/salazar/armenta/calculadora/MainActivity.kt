package salazar.armenta.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var cantidad:Double=0.0
    var total:Double=0.0
    var numero:String=""
    var digit=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn7.setOnClickListener{
            numero("7")
        }
        btn8.setOnClickListener{
            numero("8")
        }
        btn9.setOnClickListener{
            numero("9")
        }
        btn4.setOnClickListener{
            numero("4")
        }
        btn5.setOnClickListener{
            numero("5")
        }
        btn6.setOnClickListener{
            numero("6")
        }
        btn1.setOnClickListener{
            numero("1")
        }
        btn2.setOnClickListener{
            numero("2")
        }
        btn3.setOnClickListener{
            numero("3")
        }
        btn0.setOnClickListener{
            numero("0")
        }
        btnMas.setOnClickListener{
            calcular("mas",0)
        }

        btnMenos.setOnClickListener{
            calcular("menos",0)
        }
        btnMulti.setOnClickListener{
            calcular("mult",0)
        }
        btnDiv.setOnClickListener{
            calcular("div",0)
        }


        btnBorrar.setOnClickListener{
            total=0.0
            cantidad=0.0
            numero=""
            campo1.setText(numero)
            campo2.setText(numero)
            digit=0
        }
        btnResult.setOnClickListener{
            if(digit==1){
                calcular("mas",1)
            }
            if(digit==2){
                calcular("resta",1)
            }
            if(digit==3){
                calcular("mult",1)
            }
            if(digit==4){
                calcular("div",1)
            }
        }
    }
    fun numero(num:String){
        numero=numero+num
        campo1.setText(numero)
    }

    fun calcular(oper: String, tipo:Int){
        if(numero.equals("")){
            pantalla(oper,tipo)
        }else {
            cantidad=numero.toDouble()
            if(total==0.0){
                total=cantidad
                pantalla(oper,tipo)
            }else{
                if (oper.equals("mas")) {
                    total=total+cantidad
                }
                if (oper.equals("menos")) {
                    total=total-cantidad
                }
                if (oper.equals("mult")) {
                    total=total*cantidad
                }
                if (oper.equals("div")) {
                    total=total/cantidad
                }
                pantalla(oper,tipo)
            }
            cantidad=0.0
            numero=""
            numero("")
        }
    }

    fun pantalla(oper:String,tipo:Int){
        if(tipo==0) {

            if (oper.equals("mas")) {
                campo2.setText("$total +")
                digit = 1
            }
            if (oper.equals("menos")) {
                campo2.setText("$total -")
                digit = 2
            }
            if (oper.equals("mult")) {
                campo2.setText("$total *")
                digit = 3
            }
            if (oper.equals("div")) {
                campo2.setText("$total /")
                digit = 4
            }
        }else{
                campo2.setText("$total")
                digit = 0
        }
    }
}
