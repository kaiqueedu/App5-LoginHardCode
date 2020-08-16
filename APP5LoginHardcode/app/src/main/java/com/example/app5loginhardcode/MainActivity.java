package com.example.app5loginhardcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText prontuarioEditText;
    private EditText senhaEditText;
    private Button loginButton;
    private int prontuario = 123;
    private int senha = 321;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.button_login);
        loginButton.setOnClickListener(onClickLogin());
    }

    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                prontuarioEditText = findViewById(R.id.edittext_prontuario);
                senhaEditText = findViewById(R.id.edittext_senha);

                if (prontuarioEditText.getText() != null && senhaEditText.getText() != null) {
                    Intent intent = new Intent(getContext(), Main2Activity.class);
                    Bundle params = new Bundle();
                    if (validarLogin()) {
                        params.putString("msg", "Bem vindo");
                    }else{
                        params.putString("msg","Erro no login");
                    }
                    intent.putExtras(params);
                    startActivity(intent);
                } else {
                    mensagemValid("Os Campos usuário e senha devem ser preenchidos");
                }

            }
        };
    }

    private Context getContext() {
        return this;
    }

    private boolean validarLogin(){
        int p = Integer.parseInt( prontuarioEditText.getText().toString() );
        int s = Integer.parseInt( senhaEditText.getText().toString() );
        if( p != prontuario || s != senha ) {
            return false;
        }
        return true;
    }

    private void mensagemValid(String mensagem){
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

    }
}
