package Francisco.Gimenez.ISTEA.trabajopractico1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CelsiusActivity : AppCompatActivity() {
    lateinit var celsius : TextView
    lateinit var farenheit : TextView
    lateinit var convertir : Button
    var gradosCelsius:Float = 1f
    var gradosFarenheit: Float = 1f

    var lastC : Float =0f


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_celsius)
        Init()



        convertir.setOnClickListener(View.OnClickListener {




            VerificarNumeros(celsius.text.toString(),farenheit.text.toString())



        })


    }

    fun Init(){
        celsius = findViewById(R.id.e_c_celsius)
        farenheit = findViewById(R.id.e_c_farenheit)
        convertir = findViewById(R.id.b_c_convertir)
    }

    fun Convertir(gradosC:Float,gradosF:Float){



        if(gradosC != lastC){
            lastC = gradosC
            gradosFarenheit = (gradosC * 1.8f) + 32
            farenheit.text = gradosFarenheit.toString()
        }
        else{
            gradosCelsius = (gradosF - 32)/1.8f
            celsius.text = gradosCelsius.toString()
        }
    }

    fun VerificarNumeros(celsiusString:String, fahrenheitString:String){
        //TODO: Hace aca el refactor del OnClickListener
        try {


            gradosCelsius = celsiusString.toFloat()
            gradosFarenheit = fahrenheitString.toFloat()

            Convertir(gradosCelsius, gradosFarenheit)
        }
        //Si No es u numero, no anda.
        catch (nfe: NumberFormatException){
            Toast.makeText(this, "Por Favor ingrese un numero!", Toast.LENGTH_LONG).show()
            celsius.text = "0"
            farenheit.text = "0"
        }
    }




}