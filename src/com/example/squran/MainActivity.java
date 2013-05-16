package com.example.squran;

import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	EditText a,b,c;
	Button btn;
	TextView outText;
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0, bDot, minusBtn, delBtn, leftBtn, rightBtn;
	String input ="";
    Context context;
    String result="";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        
        b1= (Button)findViewById(R.id.btn1);
        b2= (Button)findViewById(R.id.btn2);
        b3= (Button)findViewById(R.id.btn3);
        b4= (Button)findViewById(R.id.btn4);
        b5= (Button)findViewById(R.id.btn5);
        b6= (Button)findViewById(R.id.btn6);
        b7= (Button)findViewById(R.id.btn7);
        b8= (Button)findViewById(R.id.btn8);
        b9= (Button)findViewById(R.id.btn9);
        b0= (Button)findViewById(R.id.btn0);
        leftBtn = (Button)findViewById(R.id.left);
        rightBtn = (Button)findViewById(R.id.right);
        bDot = (Button)findViewById(R.id.dotBtn);
        minusBtn = (Button)findViewById(R.id.minusBtn);
        delBtn = (Button)findViewById(R.id.del);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        bDot.setOnClickListener(this);
        minusBtn.setOnClickListener(this);
        delBtn.setOnClickListener(this);
        leftBtn.setOnClickListener(this);
        rightBtn.setOnClickListener(this);
        
        a = (EditText) findViewById(R.id.a);
        b = (EditText) findViewById(R.id.b);
        c = (EditText) findViewById(R.id.c);
        a.setSingleLine();
        b.setSingleLine();
        c.setSingleLine();
        
        a.setInputType(InputType.TYPE_NULL);
        b.setInputType(InputType.TYPE_NULL);
        c.setInputType(InputType.TYPE_NULL);
        
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("ShowToast")
			public void onClick(View v) {
				input ="";
				if ((a.getText().toString().equals("")) || (b.getText().toString().equals(""))|| (c.getText().toString().equals("")))
				{}
				
				else{
				
				double aa = Double.parseDouble((a.getText().toString()));
				double bb = Double.parseDouble((b.getText().toString()));
				double cc = Double.parseDouble((c.getText().toString()));

				double D  = (bb*bb-4*aa*cc);
				
				if (D<0) {
					result="Внимание! D<0";
					//Toast.makeText(getApplicationContext(),"Внимание! D<0" , Toast.LENGTH_LONG).show();
				}
				else if (D == 0){
					if (aa!=0){
					result="X = "+ (float)-bb/(2*aa);
                    }
					else if (cc==0) result = "Внимание! a=0, c - не ноль: нет решений";
                    else   result =  "Внимание! a=0,   х - любое число";
				}
				else if (D>0){
					if (aa!=0){
                        result =  "X1 = "+ (float)(-bb+Math.sqrt(D))/(2*aa)+"\n"+"X2 = "+ (float)(-bb-Math.sqrt(D))/(2*aa);
					}
                    else if (cc==0) result = "Внимание! a=0, c - не ноль: нет решений";
                    else   result = "Внимание! a=0,   х - любое число";
				}
				}

                AlertDialog.Builder ad = new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.myBackgroundStyle));
                ad.setTitle("Результат");
                ad.setMessage(result);
                ad.setNeutralButton("Ясно", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                ad.show();
			
			}
			
			
		});

    }

	public void onClick(View v) {
		
		switch (v.getId()){
		case R.id.btn0:
			input="0";
			break;
		
		case R.id.btn1:
			input="1";
			break;
			
		case R.id.btn2:
			input="2";
			break;
		case R.id.btn3:
			input="3";
			break;
		case R.id.btn4:
			input="4";
			break;
		case R.id.btn5:
			input="5";
			break;
		case R.id.btn6:
			input="6";
			break;	
		case R.id.btn7:
			input="7";
			break;
		case R.id.btn8:
			input="8";
			break;
		case R.id.btn9:
			input="9";
			break;
		case R.id.dotBtn:
			input=".";
			break;
		case R.id.minusBtn:
			input="-";
			break;
        case R.id.del:
                if (a.isFocused()) a.setText(a.getText().toString().substring(0, a.getText().length()-1));
                if (b.isFocused()) b.setText(b.getText().toString().substring(0, b.getText().length()-1));
                if (c.isFocused()) c.setText(b.getText().toString().substring(0, b.getText().length()-1));
                input="";
                break;

        case R.id.left:
                if (a.isFocused()) c.requestFocus();
                if (b.isFocused()) a.requestFocus();
                if (c.isFocused()) b.requestFocus();
                input="";
            break;

        case R.id.right:
                if (a.isFocused()) b.requestFocus();
                if (b.isFocused()) c.requestFocus();
                if (c.isFocused()) a.requestFocus();
                input="";
            break;
			
		default:
			break;
			
		
		}	
		if (a.isFocused()) a.setText(a.getText()+input);	
		if (b.isFocused()) b.setText(b.getText()+input);
		if (c.isFocused()) c.setText(c.getText()+input);
		
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        MenuItem cleanItem = menu.add("Clean");
        cleanItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                a = (EditText) findViewById(R.id.a);
                b = (EditText) findViewById(R.id.b);
                c = (EditText) findViewById(R.id.c);
                a.setText("");
                b.setText("");
                c.setText("");
                return  false;
            }
        }) ;
        return true;
    }

}



