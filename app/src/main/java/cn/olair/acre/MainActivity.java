package cn.olair.acre;

import android.annotation.SuppressLint;
import android.database.DataSetObserver;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import cn.olair.view.AcreLayout;
import cn.olair.view.AcreLayoutT;

public class MainActivity extends AppCompatActivity {


    Button left, top, right, bottom, other;

    AcreLayoutT acreLayout;

    Matrix matrix;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acreLayout = findViewById(R.id.lay_acre);

        acreLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v instanceof AcreLayoutT) {
                    AcreLayoutT a = (AcreLayoutT) v;
                    a.moveTo(event.getX(), event.getY());
                }
                return true;
            }
        });

        left = findViewById(R.id.left);
        top = findViewById(R.id.top);
        right = findViewById(R.id.right);
        bottom = findViewById(R.id.bottom);
        other = findViewById(R.id.other);

        left.setOnClickListener(listener);
        top.setOnClickListener(listener);
        right.setOnClickListener(listener);
        bottom.setOnClickListener(listener);

        matrix = new Matrix();

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 和奇怪，为什么获取到的对象之间好像没有关系一样.
//                Log.i("------------ per", "onClick: " + acreLayout.getMatrix());
//                Matrix matrix = acreLayout.getMatrix();
//                matrix.postTranslate(50, 50);
//                Log.i("------------ the", "onClick: " + matrix);
//                Log.i("------------ end", "onClick: " + acreLayout.getMatrix());
//                acreLayout.rotate(90);
//                acreLayout.scale(1.1f);

                Matrix matrix = new Matrix();
                matrix.postScale(10, 10);
                Log.i("--------------- ", "onClick: " + matrix);
                matrix.preTranslate(20, 20);
                Log.i("--------------- ", "onClick: " + matrix);


            }
        });

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.left:
                    acreLayout.move(-40, 0);
                    break;
                case R.id.top:
                    acreLayout.move(0, -40);
                    break;
                case R.id.right:
                    acreLayout.move(40, 0);
                    break;
                case R.id.bottom:
                    acreLayout.move(0, 40);
                    break;
            }
        }
    };

}
