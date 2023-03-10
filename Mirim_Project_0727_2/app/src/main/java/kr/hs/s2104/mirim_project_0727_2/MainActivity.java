package kr.hs.s2104.mirim_project_0727_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editName, editEmail;
    EditText dlgEditName, dlgEditEmail;
    TextView toastText;
    View dlgView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);

        Button btnInput = findViewById(R.id.btn_input);
        btnInput.setOnClickListener(btnInputListener);
    }

    View.OnClickListener btnInputListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setIcon(R.drawable.star_icon);
            dlg.setTitle("사용자정보입력");
            dlgView = View.inflate(MainActivity.this, R.layout.dialog1, null);
            dlg.setView(dlgView);

            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dlgEditName = dlgView.findViewById(R.id.edit_name);
                    dlgEditEmail = dlgView.findViewById(R.id.edit_email);
                    editName.setText(dlgEditName.getText().toString());
                    editEmail.setText(dlgEditEmail.getText().toString());
                }
            });
            dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    toastView = View.inflate(MainActivity.this, R.layout.toast, null);
                    Toast t = new Toast(MainActivity.this);
                    t.setDuration(Toast.LENGTH_LONG);
                    toastText = toastView.findViewById(R.id.text_toast);
                    toastText.setText("Have a nice day");
                    t.setView(toastView);
                    t.show();
                }
            });
            dlg.show();
        }
    };
}