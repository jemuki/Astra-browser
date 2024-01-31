package com.astra.astra

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import java.net.URLClassLoader


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //to go to homepage
        home.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }


        // to be able of using webview in android we should add Internet permission first
        // go to manifest and add permission
        //we will add google as a defaut web page when our activity load
        webview.loadUrl("https://www.google.com/")
        webview.settings.javaScriptEnabled = true // we need to enable javascript
        webview.canGoBack()
        webview.webViewClient = WebClient(this)

        // Now we need to load an url everytime we search something
        search_btn.setOnClickListener {
            val URL = url.text.toString()
            val isAddress = Patterns.WEB_URL.matcher(URL).matches()
            if (isAddress){
                webview.loadUrl(URL)
            }else{
                webview.loadUrl("https://www.google.com/search?q=$URL")
            }//ends if else
        }

        //now we will add the script to return back
        return_btn.setOnClickListener {
            webview.goBack()
        }


        //before we test our app we need to create a webclient class


    }



    class WebClient internal constructor(private val activity: Activity): WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            view?.loadUrl(request?.url.toString())
            return true
        }

    }//ends oncreate


}//ends class

//http://coding.co.ke/jereson/