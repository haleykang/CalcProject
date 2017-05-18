package app3.android.test.calcproject;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {

    private TextView textView;
    private String opertator;
    private Boolean startOfNumber;
    private long result;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        startOfNumber = true;
        opertator = "=";



    }

    public void longToast(String ob) {
        Toast.makeText(getApplicationContext(),ob,Toast.LENGTH_LONG).show();
    }

    public void checkStart(String no) {

        if(startOfNumber)
            textView.setText(no);
        else textView.append(no);
        startOfNumber = false;

    }

    public void calculate(long n) {
        switch (opertator) {
            case "+" : result += n;
                break;
            case "-" : result -= n;
                break;
            case "*" : result *= n;
                break;
            case "/" : result /= n;
                break;
            case "=" : result = n;
                break;
        }
        textView.setText(result+"");
    }

    public void checkOp(String op) {

        if (startOfNumber)
            opertator = op;
        else {
            long x = Long.parseLong(textView.getText().toString());
            calculate(x);
            opertator = op;
            startOfNumber = true;
        }
    }





    public void onClick(View v) {

        textView = (TextView)findViewById(R.id.textView);

        switch (v.getId()) {

            case R.id.clear:
                startOfNumber = true;
                opertator = "=";
                result = 0L;
                textView.setText("");
                break;

            case R.id.del:
                String s = textView.getText().toString();
                if(s.length()>0)
                    textView.setText(s.substring(0,s.length()-1));
                break;

            // 숫자 버튼 클릭
            case R.id.no0:
                checkStart("0");
                break;
            case R.id.no1:
                checkStart("1");
                break;
            case R.id.no2:
                checkStart("2");
                break;
            case R.id.no3:
                checkStart("3");
                break;
            case R.id.no4:
                checkStart("4");
                break;
            case R.id.no5:
                checkStart("5");
                break;
            case R.id.no6:
                checkStart("6");
                break;
            case R.id.no7:
                checkStart("7");
                break;
            case R.id.no8:
                checkStart("8");
                break;
            case R.id.no9:
                checkStart("9");
                break;
            /*case R.id.point:
                checkStart(".");
                break;*/

            // 연산자 버튼 클릭
            case R.id.add:
                checkOp("+");
                longToast("덧셈");
                break;
            case R.id.sub :
                checkOp("-");
                longToast("뺄셈");
                break;
            case R.id.mul:
                checkOp("*");
                longToast("곱셈");
                break;
            case R.id.div:
                checkOp("/");
                longToast("나눗셈(몫)");
                break;
            case R.id.result:
                checkOp("=");
                longToast("결과");
                break;

        }
    }





}
