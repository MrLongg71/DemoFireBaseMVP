package com.longkhoa.myapplication.Model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.longkhoa.myapplication.Presenter.PresenterImDangNhap;
import com.longkhoa.myapplication.Presenter.PresenterXuLyDangNhap;

public class ModelXuLyDangNhap  {
    private  FirebaseAuth firebaseAuth;


    public String halderDangnhap(final String email, final String psss, final PresenterImDangNhap presenterImDangNhap) {
        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithEmailAndPassword(email, psss)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Log.d("vvv" , email+psss);
                            presenterImDangNhap.result(true);
                        } else {
                            presenterImDangNhap.result(false);

                        }
                    }
                });
        return "1";

    }
}
