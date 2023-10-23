package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //obtenemos la referencia del Id definido en el XML
        webView = findViewById(R.id.webView);
        //obtiene las configuraciones del WebView para modificar sus propiedades
        WebSettings webSettings = webView.getSettings();
        //habilita el JavaScrip
        webSettings.setJavaScriptEnabled(true);
        //agrega una interfaz de JavaScript, permite comunicar el codigo de la aplicacion
        webView.addJavascriptInterface(new JavaScriptInterface(), "appInterface");
    }

//el metodo loadURL se llama cuando el usuario hace clic en el boton
    public void loadURL(View view) {
        //obtiene las referencias del editText definido en el XML
        EditText urlEditText = findViewById(R.id.urlEditText);
        //Obtiene el texto ingresado como una cadena
        String url = urlEditText.getText().toString();
        //Comprueba si la cadena esta vacia
        if (url.isEmpty()) {
            //Muestra el toast indicando que se debe ingresar una URL valida
            Toast.makeText(this, "Ingresa una URL válida", Toast.LENGTH_SHORT).show();
        } else {//Si la cadena no esta vacia carga la URL ingresada
            webView.loadUrl(url);
        }
    }

//define a clase interna que se utiliza para cominicar entre el JAvaScript y Java
    private class JavaScriptInterface {
        //clase interna que contiene un metodo llamado showtoast
        @android.webkit.JavascriptInterface//permite a JavaScript llamarlo desde una pagina erb cargada
        public void showToast(String message) {
        }
    }
}






