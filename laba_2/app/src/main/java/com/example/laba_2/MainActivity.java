package com.example.laba_2;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private GestureDetectorCompat mDetector;
    private TextView textView;

    private void setMargins(View view) {
        ViewCompat.setOnApplyWindowInsetsListener(view, (v, windowInsets) -> {
            Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            mlp.leftMargin = insets.left;
            mlp.bottomMargin = insets.bottom;
            mlp.rightMargin = insets.right;
            mlp.topMargin = insets.top;
            v.setLayoutParams(mlp);
            return WindowInsetsCompat.CONSUMED;
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        mDetector = new GestureDetectorCompat(this,this);
        mDetector.setOnDoubleTapListener(this);
        textView = findViewById(R.id.textView);
        setMargins(findViewById(R.id.textViewFIO));
    }

    public boolean onTouchEvent(MotionEvent event) {
        mDetector.onTouchEvent(event);
        // Обязательно вызвать реализацию суперкласса
        return super.onTouchEvent(event);
    }

    // Отслеживает появление жеста одиночного нажатия (клик)
    @Override
    public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
        String text = "onSingleTapConfirmed: " + e.toString();
        textView.setText(text);
        return true;
    }

    // Отслеживает появление жеста двойного нажатия ("двойной клик")
    @Override
    public boolean onDoubleTap(@NonNull MotionEvent e) {
        String text = "onDoubleTap: " + e.toString();
        textView.setText(text);
        return true;
    }

    // Отслеживает появление событий во время выполнения жеста двойного нажатия, включая касание, перемещение, подъем пальца.
    @Override
    public boolean onDoubleTapEvent(@NonNull MotionEvent e) {
        String text = "onDoubleTapEvent: " + e.toString();
        textView.setText(text);
        return true;
    }

    // Отслеживает появление касания, т. е. палец прижат к экрану
    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        String text = "onDown: " + e.toString();
        textView.setText(text);
        return true;
    }

    // Отслеживая, что произошло, событие касания и больше никаких событий не происходит короткое время
    @Override
    public void onShowPress(@NonNull MotionEvent e) {
        String text = "onShowPress: " + e.toString();
        textView.setText(text);
    }

    // Отслеживать появление жеста одиночного нажатия (клик)
    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent e) {
        String text = "onSingleTapUp: " + e.toString();
        textView.setText(text);
        return true;
    }

    // Отслеживает появление жеста прокрутки (пролистования)
    @Override
    public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
        String text = "onScroll: " + (e1 == null ? "" : e1.toString()) + e2.toString();
        textView.setText(text);
        return true;
    }

    // Отслеживает удержание пальца прижатым к экрану длительное время
    @Override
    public void onLongPress(@NonNull MotionEvent e) {
        String text = "onLongPress: " + e.toString();
        textView.setText(text);
    }

    // Отслеживает появление жеста смахивания
    @Override
    public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
        String text = "onFling: " + (e1 == null ? "" : e1.toString()) + e2.toString();
        textView.setText(text);
        return true;
    }
}