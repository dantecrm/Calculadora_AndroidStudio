package calculadora.pe.edu.upeu.calculadoraexamen;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Dante Cunurana M on 27/04/2015.
 */
public class EstandarActivity extends ActionBarActivity {

    EditText txtResultado;

    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnPunto;


    Button btnSumar;
    Button btnRestar;
    Button btnDividir;
    Button btnMultiplicar;
    Button btnPotenciacion;
    Button btnRadicacion;


    Button btnIgual;
    Button btnBorrar;
    Button btnLimpiar;
    String ValorA="";
    String ValorB="";
    char operador=' ';
    String cont="";
    boolean decimal = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estandar);

        txtResultado=(EditText)findViewById(R.id.txtResultado);
        btn0=(Button)findViewById(R.id.btn0);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);

        btnSumar=(Button)findViewById(R.id.btnSuma);
        btnRestar=(Button)findViewById(R.id.btnResta);
        btnDividir=(Button)findViewById(R.id.btnDividir);
        btnMultiplicar=(Button)findViewById(R.id.btnMultiplicar);
        btnPotenciacion=(Button)findViewById(R.id.btnPotencia);
        btnRadicacion=(Button)findViewById(R.id.btnRaiz);

        btnIgual=(Button)findViewById(R.id.btnIgual);
        btnBorrar=(Button)findViewById(R.id.btnBorrar);
        btnPunto=(Button)findViewById(R.id.btnPunto);
        btnLimpiar=(Button)findViewById(R.id.btnLimpiar);

        View.OnClickListener onclick= new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Button dato = (Button)v;
                ValorA+=dato.getText();
                txtResultado.setText(ValorA);

            }
        };
        btn0.setOnClickListener(onclick);
        btn1.setOnClickListener(onclick);
        btn2.setOnClickListener(onclick);
        btn3.setOnClickListener(onclick);
        btn4.setOnClickListener(onclick);
        btn5.setOnClickListener(onclick);
        btn6.setOnClickListener(onclick);
        btn7.setOnClickListener(onclick);
        btn8.setOnClickListener(onclick);
        btn9.setOnClickListener(onclick);

        View.OnClickListener onclickPunto=new View.OnClickListener() {
            boolean hayPunto=false;
            @Override
            public void onClick(View v) {
                Button dato = (Button)v;
                try
                {
                    double a = Float.parseFloat(ValorA);
                    if (a%1==0){
                        ValorA+=dato.getText();
                        txtResultado.setText(ValorA);
                    }
                    else if (a%1!=0){
                        hayPunto=true;
                        return;
                    }
                }
                catch(NumberFormatException nfe)
                {
                    return;
                }
            }
        };
        btnPunto.setOnClickListener(onclickPunto);

        View.OnClickListener onclickOper=new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Button dato= (Button)v;
                operador=dato.getText().charAt(0);
                ValorB=ValorA;
                ValorA="";
                txtResultado.setText("");
            }
        };

        btnSumar.setOnClickListener(onclickOper);
        btnRestar.setOnClickListener(onclickOper);
        btnDividir.setOnClickListener(onclickOper);
        btnMultiplicar.setOnClickListener(onclickOper);
        btnPotenciacion.setOnClickListener(onclickOper);

        View.OnClickListener onclickOper1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button dato= (Button)v;
                cont = dato.getText().toString();
                ValorB=ValorA;
                ValorA="";
                txtResultado.setText("");
                double a;

                a = Float.parseFloat(ValorB);
                double resultado = Math.sqrt(a);
                txtResultado.setText(String.valueOf(resultado));
            }
        };
        btnRadicacion.setOnClickListener(onclickOper1);

        View.OnClickListener onclickResulOper = new View.OnClickListener() {
            double resultado=0.0;

            double a;
            double b;
            //Scanner num = new Scanner(System.in);
            @Override
            public void onClick(View v) {

                try {
                    switch (operador) {
                        case '+': {
                            //resultado = Integer.parseInt(ValorB) + Integer.parseInt(ValorA);
                            resultado = Float.parseFloat(ValorB) + Float.parseFloat(ValorA);
                        }
                        break;
                        case '-': {
                            //resultado = Integer.parseInt(ValorB) - Integer.parseInt(ValorA);
                            resultado = Float.parseFloat(ValorB) - Float.parseFloat(ValorA);
                        }
                        break;
                        case '/': {
                            //resultado = Integer.parseInt(ValorB) / Integer.parseInt(ValorA);
                            resultado = Float.parseFloat(ValorB) / Float.parseFloat(ValorA);
                        }
                        break;
                        case '*': {
                            //resultado = Integer.parseInt(ValorB) * Integer.parseInt(ValorA);
                            resultado = Float.parseFloat(ValorB) * Float.parseFloat(ValorA);
                        }
                        break;
                        case '^': {
                            a = Float.parseFloat(ValorB);
                            b = Float.parseFloat(ValorA);
                            resultado = Math.pow(a,b);
                        }
                        break;
                        default:
                            break;
                    }
                    txtResultado.setText(String.valueOf(resultado));
                } catch (Exception e){
                    txtResultado.setText("Error");
                };
            }

        };

        btnIgual.setOnClickListener(onclickResulOper);

        View.OnClickListener onclickborrar = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String temporal=ValorB.substring(0,ValorB.length()-1);

                ValorB=temporal;
                txtResultado.setText(String.valueOf(ValorB));

            }
        };
        btnBorrar.setOnClickListener(onclickborrar);

        View.OnClickListener onclicklimpiar = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ValorA = "";
                ValorB = "";
                txtResultado.setText("");
            }
        };
        btnLimpiar.setOnClickListener(onclicklimpiar);
    }

}
