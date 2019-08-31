package com.longkhoa.myapplication.Presenter;

import android.util.Log;

import com.longkhoa.myapplication.Model.ModelXuLyDangNhap;
import com.longkhoa.myapplication.View.ViewXuLyDangNhap;

public class PresenterXuLyDangNhap implements PresenterImDangNhap{
    ViewXuLyDangNhap viewXuLyDangNhap;
    ModelXuLyDangNhap ac;



    public PresenterXuLyDangNhap(ViewXuLyDangNhap viewXuLyDangNhap) {
        this.viewXuLyDangNhap = viewXuLyDangNhap;
        this.ac = new ModelXuLyDangNhap();

    }


    @Override
    public void ktDangNhap(String tk, String mk) {
        ac.halderDangnhap(tk,mk,this);

        }

    @Override
    public void result(boolean a) {
        Log.d("vv" , a + "");
        if(a){
            viewXuLyDangNhap.dangNhapThanhCong();
        }else {
            viewXuLyDangNhap.dangNhapThatBai();
        }
    }
}

