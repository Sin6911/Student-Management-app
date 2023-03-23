package com.example.test9;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnGuiTT;
    EditText EditTextHoTen,EditTextCMND,EdittextTTBoSung;
    RadioButton RadTrungCap,RadCaoDang,RadDaiHoc;
    CheckBox ChkDocBao,ChkDocSach,ChkCoding;
    RadioGroup RadGroupBC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AllControl();
        btnGui();



    }
    public void AllControl()
    {
        EditTextHoTen = (EditText) findViewById(R.id.EditTextHoTen);
        EditTextCMND = (EditText) findViewById(R.id.EditTextCMND);
        EdittextTTBoSung = (EditText) findViewById(R.id.EditTextTTBoSung);
        RadTrungCap = (RadioButton) findViewById(R.id.RadioTrungCap);
        RadCaoDang = (RadioButton) findViewById(R.id.RadioCaoDang);
        RadDaiHoc = (RadioButton) findViewById(R.id.RadioDaiHoc);
        ChkDocBao = (CheckBox) findViewById(R.id.ChkDocBao);
        ChkDocSach = (CheckBox) findViewById(R.id.ChkDocSach);
        ChkCoding = (CheckBox) findViewById(R.id.ChkDocCoding);
        btnGuiTT = (Button) findViewById(R.id.btnGuiTT);
        RadGroupBC = (RadioGroup) findViewById(R.id.radioGroup_BC);

    }

    public void btnGui()
    {
        final String[] checkst = {""};
        EditTextCMND.setInputType(InputType.TYPE_CLASS_NUMBER);
        RadDaiHoc.setChecked(true);



        btnGuiTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(EditTextHoTen.getText().toString().trim().length()==0 || EditTextHoTen.getText().toString().trim().length()<3)
                {
                    EditTextHoTen.setError("Không được để trống và có ít nhất 3 kí tự!");
                }
                else if(EditTextCMND.getText().toString().trim().length()==0 || EditTextCMND.getText().toString().trim().length()<9)
                {
                    EditTextCMND.setError("CMND Không được để trống và phải đúng 9 kí tự!");
                }
                else if(!ChkDocBao.isChecked()&&!ChkDocSach.isChecked()&&!ChkCoding.isChecked())
                {
                    Toast.makeText(MainActivity.this, "Phải chọn ít nhất một sở thích!", Toast.LENGTH_SHORT).show();
                }

               else{
                    thongbao();
                }

            }
        });
    }
    private  void  thongbao(){
        String hoten1 = EditTextHoTen.getText().toString();
        String CMND1 = EditTextCMND.getText().toString();
        String TTBoSung1 = EdittextTTBoSung.getText().toString();
        String TrungCap1 = "";
        String CaoDang1 = "";
        String DaiHoc1 = "";

        String Docbao1 ="";
        String DocSach1 ="";
        String DocCoding1 = "";
        if(RadTrungCap.isChecked())
        {
            TrungCap1 ="Trung cấp";
        }
        else if(RadCaoDang.isChecked())
        {
            CaoDang1 = "Cao đẳng";
        }
        else if(RadDaiHoc.isChecked())
        {
            DaiHoc1 = "Đại học";
        }

        if(ChkDocBao.isChecked()){
            Docbao1 = "Đọc báo";
        }
        if(ChkDocSach.isChecked()){
            DocSach1 = "Đọc sách";
        }
        if(ChkCoding.isChecked()){
            DocSach1 = "Đọc coding";
        }


        AlertDialog.Builder alerDialog = new AlertDialog.Builder(this);
        alerDialog.setTitle("Thông tin cá nhân");
        alerDialog.setIcon(R.mipmap.ic_launcher);
        alerDialog.setMessage(hoten1+"\n"+CMND1+"\n"+TrungCap1+CaoDang1+DaiHoc1+"\n"+ Docbao1+" "+DocSach1+" "+DocCoding1 + "\n"  +  "----------------------------------------"+"\n"+"Thông tin bổ sung:"+"\n"+TTBoSung1);
   /*     alerDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                System.exit(0);

            }
        });*/
        alerDialog.setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerDialog.show();

    }
}