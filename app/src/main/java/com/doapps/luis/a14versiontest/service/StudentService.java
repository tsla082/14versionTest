package com.doapps.luis.a14versiontest.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.doapps.luis.a14versiontest.uri.UrlService;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import cz.msebera.android.httpclient.Header;

/**
 * Created by frank on 30/06/16.
 */
public class StudentService {
    private static final String TAG = "StudentService";
    private Context context;
    private ProgressDialog progressDialog;
    private studentGetAllInterface studentGetAllInterface;

    public StudentService(Context context) {
        this.context = context;
        progressDialog = new ProgressDialog(context);
    }

    public void getAllStudents() {
        progressDialog.setMessage("Obteniendo Estudiantes");
        progressDialog.show();

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(context, UrlService.ListarDataURL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                try {
                    Log.d(TAG, "onSuccess");
                    Log.d(TAG, "onSuccess statuscode :" + i);
                    Log.e(TAG, "onSuccess data type :" + new String(bytes));

                    String jobject = new String(bytes);
                    JSONArray jsonObject = new JSONArray(jobject);
                    studentGetAllInterface.IgetAllStudents(jsonObject);
                    progressDialog.dismiss();
                } catch (JSONException ex) {
                    ex.getMessage();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Log.d(TAG, "onFailure");
                Log.d(TAG, "onFailure statuscode :" + i);
                progressDialog.dismiss();
                Toast.makeText(context, "No hay respuesta del servidor ,verificar su conexion a internet", Toast.LENGTH_SHORT).show();
            }
        });

    }


    public interface studentGetAllInterface {
        void IgetAllStudents(JSONArray jsonArray);
    }

    public void initGetAllStudentInterface(studentGetAllInterface studentGetAllInterface) {
        this.studentGetAllInterface = studentGetAllInterface;
    }

}
