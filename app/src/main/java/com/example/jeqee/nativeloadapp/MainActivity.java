package com.example.jeqee.nativeloadapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;

import com.bytedance.frameworks.core.encrypt.TTEncryptUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et = (EditText) this.findViewById(R.id.editText);
        String t = "dGMBDFo4MhyGdjDRcT8m7AadaINQf9TFFHUbDLy3UsAy2kLA7a9QZroqhT+hb4+JaVEH7ZoDMh9SWbc0oOuZzn5XVUuxsh7JGhjvv5Faz3iTfFj7YcIAFcKeKPW+R1ruI4eD8cBklGLt2x/9DtprftSsm8eudIaw2xhA3CHuqnoaX9FTTKeZ6Iu9u3DpjepOnodVUfDJITGfUS9/t9Lg7noNDK4PaPdt8bx1I5Ssy/NdpsIjV/6gqNmvuX7JVgmaJC5FNByCYZJsfdkelDdLSVbEo7XbUcfJQoFrz4rb1ASPTwgpxKHbN6hFXviBMziSkzSzMjyop4eNp4IGXiCT5/6vcggn4PIpKPLv3gf8s7RKhyo85y+GAlkDt2D+9AYFwthkN71O3q0pJXLKhTEzt2ryHvWq6mNqEfccQ+L5PyXygB2XD2zNjaR3sBoCl0Jx2kTx2BJqh3aH5Px+4XBORxj3+hyUXk6QM4gpRk4YpvCwO6I+lk/0tpl+FPr7fVK4dBxiMaD8VTF3X9ID0I1zaW1THAUtTTgIgjrZ1N9GVn9zGM7ga8lstN6Uc7x1j/t1CQ2EveHssNjWiHeb/wFyAUprO+AkAcshRF7vhrFpXkszvoT8vCwBa1YkqegmwlDMGHBv1c5fYwHJmXTeqePx2m3kxu+LY2uWd/eN7Wqwv9zks1Om+veQO4c4WLgVSWLM2tJl34Y/UjIfQe1hjPpGZDdEFNcZfmEc9mdh5l9cMuzZr39n";
        String t2 = "{\"magic_tag\":\"ss_app_log\",\"header\":{\"appkey\":\"4fd805175270154a3c000005\",\"openudid\":\"8202b72baf1161fb\",\"sdk_version\":1,\"package\":\"com.ss.android.article.news\",\"channel\":\"sem_baidu_pz\",\"display_name\":\"今日头条\",\"app_version\":\"6.0.7\",\"version_code\":607,\"timezone\":8,\"access\":\"wifi\",\"os\":\"Android\",\"os_version\":\"5.1.1\",\"os_api\":22,\"device_model\":\"MI 4\",\"device_brand\":\"Xiaomi\",\"device_manufacturer\":\"Xiaomi\",\"language\":\"zh\",\"resolution\":\"1920x1080\",\"display_density\":\"mdpi\",\"density_dpi\":480,\"mc\":\"00:0a:f5:3b:57:fc\",\"clientudid\":\"1e0262a7-e1e3-48bc-a914-1889967996d3\",\"sig_hash\":\"aea615ab910015038f73c47e45d21466\",\"aid\":13,\"push_sdk\":[1,2,6,7,8],\"rom\":\"9cab2ed14e\",\"release_build\":\"b1b5fb8_20170328\",\"update_version_code\":6075,\"manifest_version_code\":607,\"cpu_abi\":\"armeabi-v7a\",\"build_serial\":\"db0ed5ff\"},\"_gen_time\":1492477149978}";
        String t3 = "dGMBDlo4MhyGdjDRgY4m7AdgaINgUShsZFFxW4RzFygOfVrBbaB83dsUYzEPDzvGspacIl79wpd3xMHEUtWUb3VhEzgZE/VQ732FYOCyVEe84k9rI8ikubua2U2b3W++s+IRDFXKTc6Yb/CmFhnpeeeOXb3REG362V9jL+8RJyOsMWufMY/YEnhAhbHIGHI4eq4MkaCJBEZtVOon+ZEzbF+JRF6cas6WqQCTjUPUDcGZlM4ifMwkwCeBkk3QpRZ693ncemx8iuReqC9M2TEt+dvaIoM9zbdb1hWVA+S2ZegXOekCLR/qrF0YeOf9VwhZRxfXBYsojobhG15gBtNXLb5toAr7/qG5dyJ9raFFy8f5101e5rS25w8iJARnlNkRnD5sT/6hQazYUnT2RBJsVsNM0fGTgiIKcmCW9QTx0e2G1p4QZhsjPEtzuU2T+m3HhyRy2bHHbg0iNU1S26jCMn/IHHt0dMaS+NjcXihSKd9pi6eIt7ZjSv/3bRnbatvpxrrQiGB0Vhy0muXvAAI/x1DtE40XUsrREnHm6lQ9dRBoukx38eW/GsMvXJq9FMfJ/2w2GnWeNZypHMDUBxG+5Owq5Tv+D6BWUIi0xroVigjZoEqpQnkFk/ZBY4aU4vkqbKm0JxgULjxQO66Z+SPM6+wozeT6CeoSBLZ/WTrIPlvpmHzB2gCGQgwZGkDh54D6NkWG0uyWL36+tmSPaoHvjrrPBvl+1sPz2hSsjLTuvc+LhreV0VfnrOSDcM9BK3SsegkrbLpOx+S/7ecRHm3+T2d1HdPjexQiLuIWe0/s54JpYyMFXvpSqw2l2ZpzXV3JaPqxG45QvTBF3ZPX48fVnAcFxCrWxvSvdx9Jt+AKWxHvRj+W2U1seuXZrlovddUEa2OZZZ+TSEZFiv8dk5dhOp5HjX6AeMBIIZwyXOnCb39cHUQWqs+I3m8vZWZbJH6U2/eqO3gKWVR4QiSFFw6NX2H7a0uPlEtsdsP2tPp7OMV154QMzyfXVlcuqH8fENW8vFnwQMHaqehdoTyBPLPoASrDEjAH7ikulv9WwAJUaJvzR22bLRzTpJYJXKDametX5MK0+hOj69eArqtBosBLgUAKIGGfzzlT1vJcEAd6y7+eev1HbpcCc+qaPbkw+M6fv93nGPv8m1tTpvo4Gn5BI6ROEK7j4FNmV6dDXKXrv5+5eYHYrtoaR1NUOoIpoORTcdYGSZ4AFbeS/X2ouElUSgEMAKKOpkbr3Y8rK3ouMSyNvCo/9f4q1BMWV/XIS3PvDzGKV94gAQGCQCgBebIQDMJFSC22lOj0RNoHNtqWB5Bkd+GkhezyCmgR/8+v1GBrt036BrRXu7d2Rw3ibmn8HE1ni48JZS0BRHSkf1IMq8iYbYlG4fIWGzHS9pkXGi+fp+09Li8CEQ2EzaBJnrFPwV7kiUDn8pB0tO5Aym7E8biVURrDDRuDn3PP6UygRZpM+Bh30hBCPOysPlJ5hFhgkYLjU7coYqkdNP7h3X/QRWQvhWtWPxpjjfuHJRGSI2zSeyCQahh9W5qlUVD02QY2V/wFkbZPzg1ay/9EVN7aJjFOIeY8by/uI/0WslN1NtrxDAav/hZ8G+ZWqWXOLxRxVgA+ibKLgqtA4za5pjm5aPL8aDRm+WZvPYZ2MMVfXCbsYRyUZg==";
        et.setText(t3);
    }

    public void E_Click(View btn){
        try {
            EditText et = (EditText) this.findViewById(R.id.editText);
            String os = et.getText().toString();
            byte[] gc = compress(os);
            byte[] dbs = TTEncryptUtils.e(gc,gc.length);

            EditText et2 = (EditText)this.findViewById(R.id.editText2);
            et2.setText(Base64.encodeToString(dbs,0));
            System.out.println(et2.getText().toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void DE_Click(View btn){
        try {
            EditText et = (EditText) this.findViewById(R.id.editText);
            String os = et.getText().toString();
            byte[] bs = Base64.decode(os,0);

            byte[] dbs = TTEncryptUtils.d(bs,bs.length);

            EditText et2 = (EditText)this.findViewById(R.id.editText2);
            et2.setText(uncompress(dbs));
            System.out.println(et2.getText().toString());
        }catch (Exception ex){
ex.printStackTrace();
        }
    }

    public static byte[] compress(String str) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(str.getBytes());
        gzip.close();
        return out.toByteArray();
    }

    public static String uncompress(byte[] bs) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bs);
        GZIPInputStream gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer))>= 0) {
            out.write(buffer, 0, n);
        }
        // toString()使用平台默认编码，也可以显式的指定如toString(&quot;GBK&quot;)
        return out.toString();
    }

    public void a(){
        byte[] b = new byte[]{-0x3c,-0x3b,-0x34,-0x30,-0x2c,-0x28};
    }
}
